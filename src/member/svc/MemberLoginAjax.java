package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.dto.Member;
import memberlog.dao.MemberlogDao;
import memberlog.dto.Memberlog;

import org.json.simple.JSONObject;

import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;

public class MemberLoginAjax implements Svc{

	Connection conn;

	@Override
	public void handling( HttpServletRequest req, HttpServletResponse res, Map<String, Object> model ){

		try{

			//---* DB
			DbConn dbConn = new MysqlDbConnImpl();
			conn = dbConn.getConnection();
			conn.setAutoCommit(false);
			//--- DB

			//---* sql variable
			String whereStr = "";
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			HttpSession session = req.getSession();

			
			String i_mbid = Cvt.toStr( req.getParameter( "i_mbid" ) );
			String i_mbpswd = Cvt.toStr( req.getParameter( "i_mbpswd" ) );
			
//			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
//			String answer = req.getParameter("answer");
//			if (!captcha.isCorrect(answer)) answer = "";
			
			
//			if( r_mbid.isEmpty() || r_mbpswd.isEmpty() || answer.isEmpty() ){
			
			JSONObject obj2 = new JSONObject();
			
			if( i_mbid.isEmpty() || i_mbpswd.isEmpty() ){
				obj2.put( "result", false );
				obj2.put( "msg", "일치하는 정보가 없습니다." );
			}else{
				
				MemberDao memberDao = new MemberDao( conn );
				wColNameList.add( " and MB_ID = ? " );
				wColValList.add( i_mbid );
				wColTypeList.add( "String" );
				wColNameList.add( " and MB_TYPE != ? " );
				wColValList.add( "M" );
				wColTypeList.add( "String" );
				wColNameList.add( " and MB_USE = ? " );
				wColValList.add( "Y" );
				wColTypeList.add( "String" );
				Member member = memberDao.one( sqlMap );
				
				if( "".equals( Cvt.toStr( member.getMB_ID() ) ) ){
					
					obj2.put( "result", false );
					obj2.put( "msg", "일치하는 정보가 없습니다." );
					
				}else{
					String colNames = "";
					String colVals = "";
					
					String shaPswd = Encrypt.getSha256( i_mbpswd );
					
					if( member.getMB_PSWD().equals( shaPswd ) ){
						whereStr = "and MB_ID='"+i_mbid+"'";
						colNames = " MB_PSWDFAILCNT ";
						colVals = " 0 ";
						memberDao.upChoice(colNames, colVals, whereStr);
						
						
						Memberlog memberlog = new Memberlog();
						memberlog.setMBL_IP( Cvt.toStr( req.getRemoteAddr() ) );
						memberlog.setMBL_MBID( member.getMB_ID() );
						
						MemberlogDao memberlogDao = new MemberlogDao(conn);
						memberlogDao.in(memberlog);
						
						session.setAttribute( "ss_sdkey", req.getServletContext().getInitParameter("sdkey") );
						session.setAttribute( "ss_mbcpid", member.getMB_CPID() );
						session.setAttribute( "ss_mbdpid", member.getMB_DPID() );
						session.setAttribute( "ss_mbid", member.getMB_ID() );
						session.setAttribute( "ss_mbname", member.getMB_NAME() );
						session.setAttribute( "ss_mblevel", member.getMB_LEVEL() );
						session.setAttribute( "ss_mbtype", member.getMB_TYPE() );
						
//						obj2.put( "ss_mbid", member.getMB_ID() );
						obj2.put( "result", true );
						obj2.put( "msg", "success" );
					}else{
						if( member.getMB_PSWDFAILCNT() < 5 ){
							whereStr = "and MB_ID='"+i_mbid+"'";
							colNames = " MB_PSWDFAILCNT ";
							colVals = " MB_PSWDFAILCNT + 1 ";
							memberDao.upChoice(colNames, colVals, whereStr);
						}
						obj2.put( "result", false );
						obj2.put( "msg", "일치하는 정보가 없습니다." );
					}
				}
				
				
			}
			
			conn.commit();
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj2.toString());
			
		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}