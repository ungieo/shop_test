package home.svc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopinfo.dao.ShopinfoDao;
import shopinfo.dto.Shopinfo;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import commoncode.dao.CommoncodeDao;
import commoncode.dto.Commoncode;

public class ShopinfoUpBo implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<Object> colValList = new ArrayList<Object>();
			List<String> colTypeList = new ArrayList<String>();
			
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "colValList", colValList );
			sqlMap.put( "colTypeList", colTypeList );
			
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbcpid = Cvt.toStr( session.getAttribute( "ss_mbcpid" ) );
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String biznum = Cvt.toStr( req.getParameter( "biznum" ) );
			String name = Cvt.toStr( req.getParameter( "name" ) );
			String ceoname = Cvt.toStr( req.getParameter( "ceoname" ) );
			String uptai = Cvt.toStr( req.getParameter( "uptai" ) );
			String jongmok = Cvt.toStr( req.getParameter( "jongmok" ) );
			String zipcode = Cvt.toStr( req.getParameter( "zipcode" ) );
			String addr1 = Cvt.toStr( req.getParameter( "addr1" ) );
			String addr2 = Cvt.toStr( req.getParameter( "addr2" ) );
			String tel = Cvt.toStr( req.getParameter( "tel" ) );
			String fax = Cvt.toStr( req.getParameter( "fax" ) );
			String email = Cvt.toStr( req.getParameter( "email" ) );
			String domain = Cvt.toStr( req.getParameter( "domain" ) );
			String tongsinnum = Cvt.toStr( req.getParameter( "tongsinnum" ) );
			String cstel = Cvt.toStr( req.getParameter( "cstel" ) );
			String csemail = Cvt.toStr( req.getParameter( "csemail" ) );
			String csfax = Cvt.toStr( req.getParameter( "csfax" ) );
			String cstime = Cvt.toStr( req.getParameter( "cstime" ) );
			String securityname = Cvt.toStr( req.getParameter( "securityname" ) );
			String securitydepart = Cvt.toStr( req.getParameter( "securitydepart" ) );
			String securityposition = Cvt.toStr( req.getParameter( "securityposition" ) );
			String securityphone = Cvt.toStr( req.getParameter( "securityphone" ) );
			String securityemail = Cvt.toStr( req.getParameter( "securityemail" ) );
			
			//--- param

			//---* Dao
			
			CommoncodeDao commoncodeDao = new CommoncodeDao( conn );
			Commoncode commoncode = new Commoncode();
			commoncode.setCMC_VALUE( biznum );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "biznum" );wColTypeList.add( "String" );
			sqlMap.put( "commoncode", commoncode );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( name );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "name" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( ceoname );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "ceoname" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( uptai );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "uptai" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( jongmok );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "jongmok" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( zipcode );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "zipcode" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( addr1 );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "addr1" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( addr2 );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "addr2" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( tel );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "tel" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( fax );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "fax" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( email );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "email" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( domain );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "domain" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( tongsinnum );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "tongsinnum" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( cstel );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "cstel" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( csemail );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "csemail" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( csfax );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "csfax" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( cstime );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "cstime" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( securityname );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "securityname" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( securitydepart );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "securitydepart" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( securityposition );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "securityposition" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( securityphone );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "securityphone" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			commoncode.setCMC_VALUE( securityemail );
			wColNameList.add( " and CMC_CPID = ? " );wColValList.add( ss_mbcpid );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_GROUPCODE = ? " );wColValList.add( "shopinfo" );wColTypeList.add( "String" );
			wColNameList.add( " and CMC_CODE = ? " );wColValList.add( "securityemail" );wColTypeList.add( "String" );
			commoncodeDao.up(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- Dao
			
			Properties prop = new Properties();
			
			prop.setProperty( "biznum", biznum );
			prop.setProperty( "name", name );
			prop.setProperty( "ceoname", ceoname );
			prop.setProperty( "uptai", uptai );
			prop.setProperty( "jongmok",jongmok );
			prop.setProperty( "zipcode", zipcode);
			prop.setProperty( "addr1", addr1);
			prop.setProperty( "addr2", addr2);
			prop.setProperty( "tel", tel);
			prop.setProperty( "fax",fax );
			prop.setProperty( "email",email );
			prop.setProperty( "domain",domain );
			prop.setProperty( "tongsinnum",tongsinnum );
			prop.setProperty( "cstel", cstel);
			prop.setProperty( "csemail", csemail);
			prop.setProperty( "csfax", csfax);
			prop.setProperty( "cstime", cstime);
			prop.setProperty( "securityname",securityname );
			prop.setProperty( "securitydepart", securitydepart);
			prop.setProperty( "securityposition", securityposition);
			prop.setProperty( "securityphone", securityphone);
			prop.setProperty( "securityemail", securityemail);
			
			OutputStream os = new FileOutputStream( new File( req.getServletContext().getRealPath( "/WEB-INF/system/prop/shopinfo.properties" ) ) );
			
			prop.store( os, "shop info" );
			os.close();		   
			   
			conn.commit();

			//---* model
			
			model.put( "returnType", "R" );
			model.put( "returnPage", "/home/bo/shopinfoedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}