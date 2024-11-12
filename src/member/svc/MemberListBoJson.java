package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import member.dao.MemberDao;
import member.dto.Member;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;

public class MemberListBoJson implements Svc{

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
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			
//			Enumeration<String> enumer = req.getParameterNames();
//			List<String> panames = new ArrayList<String>();
//			while( enumer.hasMoreElements() ){
//				panames.add(enumer.nextElement());
//			}
//			for( String paname : panames ){
//				System.out.println(paname +" : " +req.getParameter(paname));
//			}
			
			String sc_word = Cvt.toStr( req.getParameter( "sc_word" ) );
			String sc_column = Cvt.toStr( req.getParameter( "sc_column" ) );
			String sc_mbcpid = Cvt.toStr( req.getParameter( "sc_mbcpid" ) );
			String sc_mbtype = Cvt.toStr( req.getParameter( "sc_mbtype" ) );
			String sc_mbindates = Cvt.toStr( req.getParameter( "sc_mbindates" ) );
			String sc_mbindatee = Cvt.toStr( req.getParameter( "sc_mbindatee" ) );
			String sc_mbuse = Cvt.toStr( req.getParameter( "sc_mbuse" ) );
			
			int start = Cvt.toInt(req.getParameter("start"));
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
//			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "length" ) );
			
			

			//--- param
			r_page = start/10+1;	
			if( r_rowlimit < 0 ) r_page=r_rowlimit;
			
			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			//---* Dao
			MemberDao memberDao = new MemberDao( conn );
			if( !"".equals(sc_word) ){
				wColNameList.add( "and " + sc_column + " like ? " );
				wColValList.add( "%"+sc_word+"%" );
				wColTypeList.add( "String" );
			}
			if( !"".equals( sc_mbcpid) ){
				wColNameList.add( "and MB_CPID = ? " );
				wColValList.add( sc_mbcpid );
				wColTypeList.add( "String" );
			}
			if( !"".equals( sc_mbtype) ){
				wColNameList.add( "and MB_TYPE = ? " );
				wColValList.add( sc_mbtype );
				wColTypeList.add( "String" );
			}
			if( !"".equals(sc_mbindates) ){
				wColNameList.add( "and date_format( mb_indate, '%Y%m%d' ) >= ? " );
				wColValList.add( sc_mbindates.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals(sc_mbindatee) ){
				wColNameList.add( "and date_format( mb_indate, '%Y%m%d' ) <= ? " );
				wColValList.add( sc_mbindatee.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_mbuse ) ){
				wColNameList.add( "and MB_USE = ? " );
				wColValList.add( sc_mbuse );
				wColTypeList.add( "String" );
			}
			
			orderStr += " MB_INDATE DESC ";
			sqlMap.put( "orderStr", orderStr );

			int totCnt = memberDao.cnt( sqlMap );
			List<Member> memberList = memberDao.list( r_page, r_rowlimit, sqlMap );
			//--- Dao
			
			conn.commit();

			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );

			//---* model
//			model.put( "totCnt", totCnt );
//			model.put( "r_page", r_page );
//			model.put( "r_pagelimit", r_pagelimit );
//			model.put( "r_rowlimit", r_rowlimit );
//			model.put( "memberList", memberList );

//			model.put( "returnType", "F" );
//			model.put( "returnPage", "/member/bo/memberlist" );
			
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			for( Member member : memberList ){
				obj2 = new JSONObject();
				
				
				obj2.put( "mb_id", member.getMB_ID() );
				obj2.put( "mb_name", member.getMB_NAME(  ) );
				obj2.put( "mb_pswd", member.getMB_PSWD(  ) );
				obj2.put( "mb_pswdchdate", member.getMB_PSWDCHDATE(  ).toString() );
				obj2.put( "mb_pswdfailcnt", member.getMB_PSWDFAILCNT(  ) );
				obj2.put( "mb_cpid", member.getMB_CPID(  ) );
				obj2.put( "mb_dpid", member.getMB_DPID(  ) );
				obj2.put( "mb_addr1", member.getMB_ADDR1(  ) );
				obj2.put( "mb_addr2", member.getMB_ADDR2(  ) );
				obj2.put( "mb_email", member.getMB_EMAIL(  ) );
				obj2.put( "MB_PHONE", member.getMB_PHONE(  ) );
				obj2.put( "mb_tel", member.getMB_TEL(  ) );
				obj2.put( "mb_zipcode", member.getMB_ZIPCODE(  ) );
				obj2.put( "mb_birth", member.getMB_BIRTH(  ) );
				obj2.put( "mb_emailuse", member.getMB_EMAILUSE(  ) );
				obj2.put( "mb_smsuse", member.getMB_SMSUSE(  ) );
				obj2.put( "mb_level", member.getMB_LEVEL(  ) );
				obj2.put( "mb_type", member.getMB_TYPE(  ) );
				obj2.put( "mb_use", member.getMB_USE(  ) );
				obj2.put( "mb_moid", member.getMB_MOID(  ) );
				obj2.put( "mb_inid", member.getMB_INID(  ) );
				obj2.put( "mb_modate", Cvt.subString( member.getMB_MODATE(  ).toString(), 0, 16 ) );
				obj2.put( "mb_indate", Cvt.subString( member.getMB_INDATE(  ).toString(), 0, 16 ) );
				
				obj.add(obj2);
			}
			JSONObject root = new JSONObject();
			root.put( "memberList", obj );
			root.put( "recordsTotal", totCnt );			//iTotalRecords
			root.put( "recordsFiltered", totCnt );		//iTotalDisplayRecords

			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(root.toString());
			

			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}