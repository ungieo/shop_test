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

public class ProductcategoryListBoJson implements Svc{

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

			String r_prclevel = Cvt.toStr( req.getParameter( "r_prclevel" ) );
			String r_prcgnum1 = Cvt.toStr( req.getParameter( "r_prcgnum1" ) );
			String r_prcgnum2 = Cvt.toStr( req.getParameter( "r_prcgnum2" ) );
			String r_prcgnum3 = Cvt.toStr( req.getParameter( "r_prcgnum3" ) );
			String r_prcuse = Cvt.toStr( req.getParameter( "r_prcuse" ) );
			
			String r_order = Cvt.toStr( req.getParameter( "r_order" ) );

			//---* Dao

			if( !"".equals( r_prclevel ) ){
				whereStr += " and PRC_LEVEL = "+r_prclevel;
			}
			if( !"".equals( r_prcgnum1 ) ){
				whereStr += " and PRC_GNUM1 = "+r_prcgnum1;
			}
			if( !"".equals( r_prcgnum2 ) ){
				whereStr += " and PRC_GNUM2 = "+r_prcgnum2;
			}
			if( !"".equals( r_prcgnum3 ) ){
				whereStr += " and PRC_GNUM3 = "+r_prcgnum3;
			}
			if( !"".equals( r_prcuse ) ){
				whereStr += " and PRC_USE = "+r_prcuse;
			}
			
			if( !"".equals( r_order ) ){
				orderStr += r_order;
			}
//			orderStr = " PRC_SEQ asc, PRC_LEVEL asc, PRC_STEP asc ";
//			int totCnt = productcategoryDao.cnt( sqlMap );
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			List<Productcategory> productcategoryList = productcategoryDao.list(whereStr, orderStr);
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			for( Productcategory productcategory : productcategoryList ){
				obj2 = new JSONObject();
				
				obj2.put( "prc_seq", productcategory.getPRC_SEQ() );
				obj2.put( "prc_code", productcategory.getPRC_CODE() );
				obj2.put( "prc_name", productcategory.getPRC_NAME() );
				obj2.put( "prc_step", productcategory.getPRC_STEP() );
				obj2.put( "prc_titleimage", productcategory.getPRC_TITLEIMAGE() );
				obj2.put( "prc_gnum1", productcategory.getPRC_GNUM1() );
				obj2.put( "prc_gnum2", productcategory.getPRC_GNUM2() );
				obj2.put( "prc_gnum3", productcategory.getPRC_GNUM3() );
				obj2.put( "prc_level", productcategory.getPRC_LEVEL() );
				obj2.put( "prc_type", productcategory.getPRC_TYPE() );
				obj2.put( "prc_use", productcategory.getPRC_USE() );
				obj2.put( "prc_moid", productcategory.getPRC_MOID() );
				obj2.put( "prc_inid", productcategory.getPRC_INID() );
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