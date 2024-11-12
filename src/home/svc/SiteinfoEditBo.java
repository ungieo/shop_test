package home.svc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

public class SiteinfoEditBo implements Svc{

	Connection conn;

	@Override
	public void handling( HttpServletRequest req, HttpServletResponse res, Map<String, Object> model ){

		try{

			//---* DB
//			DbConn dbConn = new MysqlDbConnImpl();
//			conn = dbConn.getConnection();
//			conn.setAutoCommit(false);
			//--- DB

			//---* sql variable
//			Map<String, Object> sqlMap = new HashMap<String, Object>();
//			List<String> colNameList = new ArrayList<String>();
//			List<String> wColNameList = new ArrayList<String>();
//			List<String> wColValList = new ArrayList<String>();
//			List<String> wColTypeList = new ArrayList<String>();
//			sqlMap.put( "colNameList", colNameList );
//			sqlMap.put( "wColNameList", wColNameList );
//			sqlMap.put( "wColValList", wColValList );
//			sqlMap.put( "wColTypeList", wColTypeList );
//			String orderStr = "";
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
//			String r_mbid = Cvt.toStr( req.getParameter( "r_mbid" ) );
			//--- param

			//---* Dao
			
			//--- Dao

			
//			conn.commit();

			//---* model
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/home/bo/siteinfoedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}