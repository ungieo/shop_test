package ordermainitemaddress.svc;

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
import ordermainitemaddress.dao.OrdermainitemaddressDao;
import ordermainitemaddress.dto.Ordermainitemaddress;

public class OrdermainitemaddressInBo implements Svc{

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
			int r_omiaseq = Cvt.toInt( req.getParameter( "r_omiaseq") );
			String r_omiaomiseq = Cvt.toStr( req.getParameter( "r_omiaomiseq") );
			String r_omianame = Cvt.toStr( req.getParameter( "r_omianame") );
			String r_omiatel = Cvt.toStr( req.getParameter( "r_omiatel") );
			String r_omiaphone = Cvt.toStr( req.getParameter( "r_omiaphone") );
			String r_omiaemail = Cvt.toStr( req.getParameter( "r_omiaemail") );
			String r_omiazipcode = Cvt.toStr( req.getParameter( "r_omiazipcode") );
			String r_omiaaddr1 = Cvt.toStr( req.getParameter( "r_omiaaddr1") );
			String r_omiaaddr2 = Cvt.toStr( req.getParameter( "r_omiaaddr2") );
			String r_omiatype = Cvt.toStr( req.getParameter( "r_omiatype") );
			String r_omiamoid = Cvt.toStr( req.getParameter( "r_omiamoid") );
			String r_omiainid = Cvt.toStr( req.getParameter( "r_omiainid") );
//			Timestamp r_omiamodate =  req.getParameter( "r_omiamodate") );
//			Timestamp r_omiaindate =  req.getParameter( "r_omiaindate") );
			//---* param

			//---* dto setting
			Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();

			ordermainitemaddress.setOMIA_SEQ( r_omiaseq );
			ordermainitemaddress.setOMIA_OMISEQ( r_omiaomiseq );
			ordermainitemaddress.setOMIA_NAME( r_omianame );
			ordermainitemaddress.setOMIA_TEL( r_omiatel );
			ordermainitemaddress.setOMIA_PHONE( r_omiaphone );
			ordermainitemaddress.setOMIA_EMAIL( r_omiaemail );
			ordermainitemaddress.setOMIA_ZIPCODE( r_omiazipcode );
			ordermainitemaddress.setOMIA_ADDR1( r_omiaaddr1 );
			ordermainitemaddress.setOMIA_ADDR2( r_omiaaddr2 );
			ordermainitemaddress.setOMIA_TYPE( r_omiatype );
			ordermainitemaddress.setOMIA_MOID( r_omiamoid );
			ordermainitemaddress.setOMIA_INID( r_omiainid );
//			ordermainitemaddress.setOMIA_MODATE( r_omiamodate );
//			ordermainitemaddress.setOMIA_INDATE( r_omiaindate );
			//--- dto setting

			//---* Dao
			OrdermainitemaddressDao ordermainitemaddressDao = new OrdermainitemaddressDao( conn );
			ordermainitemaddressDao.in( ordermainitemaddress );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermainitemaddress/bo/ordermainitemaddressview?r_omiaseq="+r_omiaseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}