package home.svc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commontext.dao.CommontextDao;
import shopinfo.dao.ShopinfoDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

public class NonmbprivacyUpBo implements Svc{

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
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_cmtseq = Cvt.toStr( req.getParameter( "r_cmtseq" ) );
			String r_cmtvalue = Cvt.toStr( req.getParameter( "r_cmtvalue" ) );
			//--- param

			//---* Dao
			CommontextDao commontextDao = new CommontextDao( conn );
			colNameList.add( " CMT_VALUE = ? " );
			colValList.add( r_cmtvalue );
			colTypeList.add( "String" );
			
			wColNameList.add( " and CMT_SEQ = ? " );
			wColValList.add( r_cmtseq );
			wColTypeList.add( "int" );
			commontextDao.upChoice(sqlMap);
			
//			ShopinfoDao shopinfoDao = new ShopinfoDao( conn );
//			colNameList.add( " SHOP_PRIVACY = ? ");colValList.add( r_shopprivacy );colTypeList.add( "String");
//			colNameList.add( " SHOP_MOID = ? ");colValList.add( ss_mbid );colTypeList.add( "String");
//			
//			shopinfoDao.upChoice(sqlMap);
			//--- Dao
			   
			conn.commit();

			//---* model
			
			model.put( "returnType", "R" );
			model.put( "returnPage", "/home/bo/nonmbprivacyedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}