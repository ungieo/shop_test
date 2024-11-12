package product.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dao.ProductDao;
import product.dto.Product;
import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;
import productgroup.dao.ProductgroupDao;
import productoption.dao.ProductoptionDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import company.dao.CompanyDao;

public class ProductEditBo implements Svc{

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
			String r_prseq = Cvt.toStr( req.getParameter( "r_prseq" ) );
			//--- param

			//---* Dao
			ProductDao productDao = new ProductDao( conn );
			wColNameList.add( " and PR_SEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			Product product = productDao.one( sqlMap );
			wColNameList.clear(); wColValList.clear(); wColTypeList.clear();
			//--- Dao
			
			CompanyDao companyDao = new CompanyDao( conn );
			colNameList.add( " CP_ID, " );
			colNameList.add( " CP_NAME " );
			
			wColNameList.add( " and CP_TYPE = ? ");
			wColValList.add( "S" );
			wColTypeList.add( "String" );
			orderStr = " CP_ID ASC ";
			sqlMap.put( "orderStr", orderStr );
			List<Map<String, Object>> scompanyList = companyDao.listChoice(sqlMap);
			wColNameList.clear(); wColValList.clear(); wColTypeList.clear();
			

			//---* category
			ProductcategoryDao productcategoryDao = new ProductcategoryDao(conn);
			wColNameList.add( " and PRC_SEQ = ? " );
			wColValList.add( product.getPR_PRCSEQ()+"" );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", "" );
			Productcategory productcategory = productcategoryDao.one(sqlMap);
			
			whereStr = " and PRC_LEVEL = 1 ";
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList1 = productcategoryDao.list(whereStr, orderStr);
			
			whereStr = " and PRC_LEVEL = 2 and PRC_GNUM1 = "+productcategory.getPRC_GNUM1();
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList2 = productcategoryDao.list(whereStr, orderStr);
			
			whereStr = " and PRC_LEVEL = 3 and PRC_GNUM2 = "+productcategory.getPRC_GNUM2();
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList3 = productcategoryDao.list(whereStr, orderStr);
			
			whereStr = " and PRC_LEVEL = 4 and PRC_GNUM3 = "+productcategory.getPRC_GNUM3();
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList4 = productcategoryDao.list(whereStr, orderStr);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();colNameList.clear();
			//--- category
			
			//---*optionList
			ProductoptionDao productoptionDao = new ProductoptionDao(conn);
			colNameList.add( " PRO_GNAME " );
			colNameList.add( " ,PRO_NAME " );
			wColNameList.add( " and PRO_PRSEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			List<Map<String, Object>> productoptionList = productoptionDao.listChoice(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();colNameList.clear();
			//---optionList
			
			//---* 파일리스트
//			FilestorageDao filestorageDao = new FilestorageDao( conn );
//			wColNameList.add( " and FLS_REFERTABLE = ? " );
//			wColValList.add( "product" );
//			wColTypeList.add( "String" );
//			wColNameList.add( " and FLS_REFERID = ? " );
//			wColValList.add( product.getPR_SEQ()+"" );
//			wColTypeList.add( "String" );
//			sqlMap.put( "orderStr", "FLS_SEQ ASC" );
//			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			//---파일리스트
			
			//---*productgroupList
			ProductgroupDao productgroupDao = new ProductgroupDao(conn);
			wColNameList.add( " and PRG_PRGSEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			wColNameList.add( " and PRG_TYPE = ? " );
			wColValList.add( "1" );
			wColTypeList.add( "String" );
			Map<String, Object> productgorupMap1 = productgroupDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();colNameList.clear();
			wColNameList.add( " and PRG_PRGSEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			wColNameList.add( " and PRG_TYPE = ? " );
			wColValList.add( "2" );
			wColTypeList.add( "String" );
			Map<String, Object> productgorupMap2 = productgroupDao.listJoin(sqlMap);
			
			
			//---productgroupList
			
			conn.commit();
			
			//---* model
			model.put( "product", product );
			model.put( "scompanyList", scompanyList );
			model.put( "productcategory", productcategory );
			model.put( "productcategoryList1", productcategoryList1 );
			model.put( "productcategoryList2", productcategoryList2 );
			model.put( "productcategoryList3", productcategoryList3 );
			model.put( "productcategoryList4", productcategoryList4 );
			
			model.put( "productgorupMap1", productgorupMap1 );
			model.put( "productgorupMap2", productgorupMap2 );
			
//			model.put( "filestorageList", filestorageList );
			model.put( "productoptionList", productoptionList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/product/bo/productedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}