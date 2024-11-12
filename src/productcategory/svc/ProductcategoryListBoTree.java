package productcategory.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

public class ProductcategoryListBoTree implements Svc{

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


			//---* Dao
			
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			whereStr = "";
			orderStr = " PRC_SEQ asc, PRC_LEVEL asc, PRC_STEP asc ";

			int totCnt = productcategoryDao.cnt( sqlMap );
			List<Productcategory> productcategoryList = productcategoryDao.list(whereStr, orderStr);
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			for( Productcategory productcategory : productcategoryList ){
				obj2 = new JSONObject();
				obj2.put( "id", productcategory.getPRC_SEQ() );
				obj2.put( "parent", productcategory.getPRC_PID() );
				if( 0 == productcategory.getPRC_PID() ){
					obj2.put( "parent", "#" );
				}
				obj2.put( "text", productcategory.getPRC_NAME() );
//				obj2.put( "data", productcategory.getPRC_LEVEL() );
				obj.add(obj2);
			}
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj.toString());
//			System.out.println(obj.toString());
			  
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}