package company.svc;

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
import system. db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import company.dao.CompanyDao;
import company.dto.Company;

public class CompanyIn implements Svc{

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

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_cpseq = Cvt.toInt( req.getParameter( "r_cpseq") );
			String r_cpid = Cvt.toStr( req.getParameter( "r_cpid") );
			String r_cpname = Cvt.toStr( req.getParameter( "r_cpname") );
			String r_cpbiznum = Cvt.toStr( req.getParameter( "r_cpbiznum") );
			String r_cpuptai = Cvt.toStr( req.getParameter( "r_cpuptai") );
			String r_cpupjong = Cvt.toStr( req.getParameter( "r_cpupjong") );
			String r_cpceoname = Cvt.toStr( req.getParameter( "r_cpceoname") );
			String r_cpzipcode = Cvt.toStr( req.getParameter( "r_cpzipcode") );
			String r_cpaddr1 = Cvt.toStr( req.getParameter( "r_cpaddr1") );
			String r_cpaddr2 = Cvt.toStr( req.getParameter( "r_cpaddr2") );
			String r_cpfile = Cvt.toStr( req.getParameter( "r_cpfile") );
			int r_cpdeliverymoney = Cvt.toInt( req.getParameter( "r_cpdeliverymoney") );
			String r_cppaytype = Cvt.toStr( req.getParameter( "r_cppaytype") );
			String r_cpbiztype = Cvt.toStr( req.getParameter( "r_cpbiztype") );
			String r_cptongsinbiznum = Cvt.toStr( req.getParameter( "r_cptongsinbiznum") );
			String r_cpemail = Cvt.toStr( req.getParameter( "r_cpemail") );
			String r_cptel = Cvt.toStr( req.getParameter( "r_cptel") );
			String r_cpphone = Cvt.toStr( req.getParameter( "r_cpphone") );
			String r_cpfax = Cvt.toStr( req.getParameter( "r_cpfax") );
			String r_cplevel = Cvt.toStr( req.getParameter( "r_cplevel") );
			String r_cptype = Cvt.toStr( req.getParameter( "r_cptype") );
			String r_cpuse = Cvt.toStr( req.getParameter( "r_cpuse") );
			String r_cpmoid = Cvt.toStr( req.getParameter( "r_cpmoid") );
			String r_cpinid = Cvt.toStr( req.getParameter( "r_cpinid") );
//			Timestamp r_cpmodate =  req.getParameter( "r_cpmodate") );
//			Timestamp r_cpindate =  req.getParameter( "r_cpindate") );
			//---* param

			//---* dto setting
			Company company = new Company();

			company.setCP_SEQ( r_cpseq );
			company.setCP_ID( r_cpid );
			company.setCP_NAME( r_cpname );
			company.setCP_BIZNUM( r_cpbiznum );
			company.setCP_UPTAI( r_cpuptai );
			company.setCP_UPJONG( r_cpupjong );
			company.setCP_CEONAME( r_cpceoname );
			company.setCP_ZIPCODE( r_cpzipcode );
			company.setCP_ADDR1( r_cpaddr1 );
			company.setCP_ADDR2( r_cpaddr2 );
			company.setCP_FILE( r_cpfile );
			company.setCP_DELIVERYMONEY( r_cpdeliverymoney );
			company.setCP_PAYTYPE( r_cppaytype );
			company.setCP_BIZTYPE( r_cpbiztype );
			company.setCP_TONGSINBIZNUM( r_cptongsinbiznum );
			company.setCP_EMAIL( r_cpemail );
			company.setCP_TEL( r_cptel );
			company.setCP_PHONE( r_cpphone );
			company.setCP_FAX( r_cpfax );
			company.setCP_LEVEL( r_cplevel );
			company.setCP_TYPE( r_cptype );
			company.setCP_USE( r_cpuse );
			company.setCP_MOID( ss_mbid );
			company.setCP_INID( ss_mbid );
//			company.setCP_MODATE( r_cpmodate );
//			company.setCP_INDATE( r_cpindate );
			//--- dto setting

			//---* Dao
			CompanyDao companyDao = new CompanyDao( conn );
			companyDao.in( company );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/company/companyview?r_cpseq="+r_cpseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}