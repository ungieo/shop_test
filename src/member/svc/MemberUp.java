package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;
import member.dao.MemberDao;
import member.dto.Member;

public class MemberUp implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_mbid = Cvt.toStr( req.getParameter( "r_mbid") );
//			String r_mbname = Cvt.toStr( req.getParameter( "r_mbname") );
			String r_mbpswd = Cvt.toStr( req.getParameter( "r_mbpswd") );
//			Timestamp r_mbpswdchdate =  req.getParameter( "r_mbpswdchdate") );
//			int r_mbpswdfailcnt = Cvt.toInt( req.getParameter( "r_mbpswdfailcnt") );
//			String r_mbcpid = Cvt.toStr( req.getParameter( "r_mbcpid") );
//			String r_mbdpid = Cvt.toStr( req.getParameter( "r_mbdpid") );
			String r_mbaddr1 = Cvt.toStr( req.getParameter( "r_mbaddr1") );
			String r_mbaddr2 = Cvt.toStr( req.getParameter( "r_mbaddr2") );
			String r_mbemail = Cvt.toStr( req.getParameter( "r_mbemail") );
			String r_mbphone = Cvt.toStr( req.getParameter( "r_mbphone") );
			String r_mbtel = Cvt.toStr( req.getParameter( "r_mbtel") );
			String r_mbzipcode = Cvt.toStr( req.getParameter( "r_mbzipcode") );
			String r_mbbirth = Cvt.toStr( req.getParameter( "r_mbbirth") );
//			String r_mbsex = Cvt.toStr( req.getParameter( "r_mbsex" ) );
			String r_mbemailuse = Cvt.toStr( req.getParameter( "r_mbemailuse") );
			String r_mbsmsuse = Cvt.toStr( req.getParameter( "r_mbsmsuse") );
//			String r_mblevel = Cvt.toStr( req.getParameter( "r_mblevel") );
//			String r_mbtype = Cvt.toStr( req.getParameter( "r_mbtype") );
//			String r_mbuse = Cvt.toStr( req.getParameter( "r_mbuse") );
//			String r_mbmoid = Cvt.toStr( req.getParameter( "r_mbmoid") );
//			String r_mbinid = Cvt.toStr( req.getParameter( "r_mbinid") );
//			Timestamp r_mbmodate =  req.getParameter( "r_mbmodate") );
//			Timestamp r_mbindate =  req.getParameter( "r_mbindate") );
			//--- param

			//---* dto setting
			MemberDao memberDao = new MemberDao( conn );
			wColNameList.add( " and MB_ID = ? " );
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			Member member = memberDao.one(sqlMap);
//			member.setMB_ID( r_mbid );
//			member.setMB_NAME( r_mbname );
			if( !"".equals( r_mbpswd ) ){
				member.setMB_PSWD( Encrypt.getSha256( r_mbpswd ) );
			}
//			member.setMB_PSWDCHDATE(r_mbpswdchdate );
//			member.setMB_PSWDFAILCNT( r_mbpswdfailcnt );
//			member.setMB_CPID( r_mbcpid );
//			member.setMB_DPID( r_mbdpid );
			member.setMB_ADDR1( r_mbaddr1 );
			member.setMB_ADDR2( r_mbaddr2 );
			member.setMB_EMAIL( r_mbemail );
			member.setMB_PHONE( r_mbphone );
			member.setMB_TEL( r_mbtel );
			member.setMB_ZIPCODE( r_mbzipcode );
			member.setMB_BIRTH( r_mbbirth );
//			member.setMB_SEX( r_mbsex );
			member.setMB_EMAILUSE( r_mbemailuse );
			member.setMB_SMSUSE( r_mbsmsuse );
//			member.setMB_LEVEL( r_mblevel );
//			member.setMB_TYPE( r_mbtype );
//			member.setMB_USE( r_mbuse );
			member.setMB_MOID( ss_mbid );
//			member.setMB_INID( r_mbinid );
//			member.setMB_MODATE(r_mbmodate );
//			member.setMB_INDATE(r_mbindate );
			//--- dto setting

			//---* Dao
			sqlMap.put( "member", member );
			memberDao.up( sqlMap );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/member/memberedit?r_result=true" );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}