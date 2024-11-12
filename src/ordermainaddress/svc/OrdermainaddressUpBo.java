package ordermainaddress.svc;

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
import system.util.CommonUtil;
import system.util.Cvt;
import ordermainaddress.dao.OrdermainaddressDao;
import ordermainaddress.dto.Ordermainaddress;

public class OrdermainaddressUpBo implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_omaseq = Cvt.toInt( req.getParameter( "r_omaseq") );
			int r_omaomseq = Cvt.toInt( req.getParameter( "r_omaomseq") );
			String r_omaname = Cvt.toStr( req.getParameter( "r_omaname") );
			String r_omatel = Cvt.toStr( req.getParameter( "r_omatel") );
			String r_omaphone = Cvt.toStr( req.getParameter( "r_omaphone") );
			String r_omaemail = Cvt.toStr( req.getParameter( "r_omaemail") );
			String r_omazipcode = Cvt.toStr( req.getParameter( "r_omazipcode") );
			String r_omaaddr1 = Cvt.toStr( req.getParameter( "r_omaaddr1") );
			String r_omaaddr2 = Cvt.toStr( req.getParameter( "r_omaaddr2") );
			String r_omatype = Cvt.toStr( req.getParameter( "r_omatype") );
			String r_omamoid = Cvt.toStr( req.getParameter( "r_omamoid") );
			String r_omainid = Cvt.toStr( req.getParameter( "r_omainid") );
//			Timestamp r_omamodate =  req.getParameter( "r_omamodate") );
//			Timestamp r_omaindate =  req.getParameter( "r_omaindate") );
			//--- param

			//---* dto setting
			Ordermainaddress ordermainaddress = new Ordermainaddress();

			ordermainaddress.setOMA_SEQ( r_omaseq );
			ordermainaddress.setOMA_OMSEQ( r_omaomseq );
			ordermainaddress.setOMA_NAME( r_omaname );
			ordermainaddress.setOMA_TEL( r_omatel );
			ordermainaddress.setOMA_PHONE( r_omaphone );
			ordermainaddress.setOMA_EMAIL( r_omaemail );
			ordermainaddress.setOMA_ZIPCODE( r_omazipcode );
			ordermainaddress.setOMA_ADDR1( r_omaaddr1 );
			ordermainaddress.setOMA_ADDR2( r_omaaddr2 );
			ordermainaddress.setOMA_TYPE( r_omatype );
			ordermainaddress.setOMA_MOID( r_omamoid );
			ordermainaddress.setOMA_INID( r_omainid );
//			ordermainaddress.setOMA_MODATE(r_omamodate );
//			ordermainaddress.setOMA_INDATE(r_omaindate );
			//--- dto setting

			//---* Dao
			OrdermainaddressDao ordermainaddressDao = new OrdermainaddressDao( conn );
			wColNameList.add( " and OMA_SEQ = ? " );
			wColValList.add( r_omaseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			ordermainaddressDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermainaddress/bo/ordermainaddressview?r_omaseq="+r_omaseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}