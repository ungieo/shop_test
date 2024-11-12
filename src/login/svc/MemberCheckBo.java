package login.svc;

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
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;

public class MemberCheckBo implements Svc{

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
			String orderStr = "";
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			//---* sql variable

			HttpSession session = req.getSession();

			
			String r_mbid = Cvt.toStr( req.getParameter( "r_mbid" ) );
			String r_mbpswd = Cvt.toStr( req.getParameter( "r_mbpswd" ) );
			
			
			if( r_mbid.isEmpty() || r_mbpswd.isEmpty() ){
				model.put( "sv_msg", "login fail..." );
				model.put( "returnType", "F" );
				model.put( "returnPage", "/login/bo/login" );
			}else{
				
				MemberDao memberDao = new MemberDao( conn );
				
				wColNameList.add( " and MB_ID = ? " );
				wColValList.add( r_mbid );
				wColTypeList.add( "String" );
				wColNameList.add( " and MB_TYPE = ? " );
				wColValList.add( "M" );
				wColTypeList.add( "String" );
				wColNameList.add( " and MB_USE = ? " );
				wColValList.add( "Y" );
				wColTypeList.add( "String" );
				
				Member member = memberDao.one( sqlMap );
				
				if( "".equals( Cvt.toStr( member.getMB_ID() ) ) ){
					
					model.put( "sv_msg", "일치하는 정보가 없습니다." );
					model.put( "returnType", "F" );
					model.put( "returnPage", "/login/bo/login" );
					
				}else{
					
					String colNames = "";
					String colVals = "";
					
					String shaPswd = Encrypt.getSha256( r_mbpswd );
					
					if( member.getMB_PSWD().equals( shaPswd ) ){
						/*		관리자 계정이 닫힐 수 있기 때문에... 처리 안함.
						whereStr = "and MB_ID='"+r_mbid+"'";
						colNames = " MB_PSWDFAILCNT ";
						colVals = " 0 ";
						memberDao.upChoice(colNames, colVals, whereStr);
						*/
						
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
						
						model.put( "returnType", "R" );
						model.put( "returnPage", "/bo/index.jsp" );			//로그인 첫 페이지.
						
					}else{
						/*		관리자 계정이 닫힐 수 있기 때문에... 처리 안함.
						if( member.getMB_PSWDFAILCNT() < 5 ){
							whereStr = "and MB_ID='"+r_mbid+"'";
							colNames = " MB_PSWDFAILCNT ";
							colVals = " MB_PSWDFAILCNT + 1 ";
							memberDao.upChoice(colNames, colVals, whereStr);
						}
						*/
						model.put( "sv_msg", "일치하는 정보가 없습니다." );
						model.put( "returnType", "F" );
						model.put( "returnPage", "/login/bo/login" );
					}
				}
				conn.commit();
				
			}
			return;

		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}