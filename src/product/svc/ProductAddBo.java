package product.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import company.dao.CompanyDao;

public class ProductAddBo implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			//--- param

			//---* Dao
			ProductcategoryDao productcategoryDao = new ProductcategoryDao(conn);
			whereStr = " and PRC_LEVEL = 1 ";
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList = productcategoryDao.list(whereStr, orderStr);
			
			CompanyDao companyDao = new CompanyDao( conn );
			colNameList.add( " CP_ID, " );
			colNameList.add( " CP_NAME " );
			
			wColNameList.add( " and CP_TYPE = ? ");
			wColValList.add( "S" );
			wColTypeList.add( "String" );
			orderStr = " CP_ID ASC ";
			sqlMap.put( "orderStr", orderStr );
			List<Map<String, Object>> scompanyList = companyDao.listChoice(sqlMap);
			
//			ProductDao productDao = new ProductDao( conn );
//			wColNameList.add();
//			wColValList.add();
//			wColTypeList.add();
//			sqlMap.put( "orderStr", orderStr );

//			productDao.one( sqlMap );
			//--- Dao

			//---* model
			model.put( "productcategoryList", productcategoryList );
			model.put( "scompanyList", scompanyList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/product/bo/productadd" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}