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
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;

public class ProductListBo implements Svc{

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
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );

				//---* search
			String sc_type= Cvt.toStr( req.getParameter( "sc_type" ) );
			String sc_word= Cvt.toStr( req.getParameter( "sc_word" ) );
			String ctgr1= Cvt.toStr( req.getParameter( "ctgr1" ) );
			String ctgr2= Cvt.toStr( req.getParameter( "ctgr2" ) );
			String ctgr3= Cvt.toStr( req.getParameter( "ctgr3" ) );
			String ctgr4= Cvt.toStr( req.getParameter( "ctgr4" ) );
			
			String sc_prindates= Cvt.toStr( req.getParameter( "sc_prindates" ) );
			String sc_prindatee= Cvt.toStr( req.getParameter( "sc_prindatee" ) );
			
			String sc_pruse = Cvt.toStr( req.getParameter( "sc_pruse" ) );
				//---search
			//--- param

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			//---* Dao
			ProductDao productDao = new ProductDao( conn );
			if( !"".equals( sc_type ) ){
				wColNameList.add( " and "+sc_type+" like ? " );
				wColValList.add( "%"+sc_word+"%" );
				wColTypeList.add( "String" );
			}
			if( !"".equals(ctgr4) ){
				wColNameList.add( " and PRC_GNUM4 = ? " );
				wColValList.add( ctgr4 );
				wColTypeList.add( "int" );
			}else if( !"".equals(ctgr3) ){
				wColNameList.add( " and PRC_GNUM3 = ? " );
				wColValList.add( ctgr3 );
				wColTypeList.add( "int" );
			}else if( !"".equals(ctgr2) ){
				wColNameList.add( " and PRC_GNUM2 = ? " );
				wColValList.add( ctgr2 );
				wColTypeList.add( "int" );
			}else if( !"".equals(ctgr1) ){
				wColNameList.add( " and PRC_GNUM1 = ? " );
				wColValList.add( ctgr1 );
				wColTypeList.add( "int" );
			}
			
			if( !"".equals( sc_prindates ) ){
				wColNameList.add( " and date_format( PR_INDATE,'%Y%m%d' ) >= ? " );
				wColValList.add( sc_prindates.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_prindatee ) ){
				wColNameList.add( " and date_format( PR_INDATE,'%Y%m%d' ) <= ? " );
				wColValList.add( sc_prindatee.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			
			if( !"".equals( sc_pruse ) ){
				wColNameList.add( " and PR_USE = ? " );
				wColValList.add( sc_pruse );
				wColTypeList.add( "String" );
			}
			
			orderStr += " PR_SEQ desc ";
			sqlMap.put( "orderStr", orderStr );

			int totCnt = productDao.cntJoin( sqlMap );
			Map<String, Object> productMap = productDao.listJoin( r_page, r_rowlimit, sqlMap );
			//--- Dao

			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );

			
			//---*search
			ProductcategoryDao productcategoryDao = new ProductcategoryDao(conn);
			whereStr = " and PRC_LEVEL = 1 ";
			orderStr = " PRC_SEQ asc ";
			List<Productcategory> productcategoryList1 = productcategoryDao.list(whereStr, orderStr);
			List<Productcategory> productcategoryList2 = new ArrayList<Productcategory>();
			List<Productcategory> productcategoryList3 = new ArrayList<Productcategory>();
			List<Productcategory> productcategoryList4 = new ArrayList<Productcategory>();
			
			if( !"".equals( ctgr1 ) ){
				whereStr = " and PRC_LEVEL = 2 and PRC_GNUM1 = "+ctgr1;
				orderStr = " PRC_SEQ asc ";
				productcategoryList2 = productcategoryDao.list(whereStr, orderStr);
			}
			if( !"".equals( ctgr2 ) ){
				whereStr = " and PRC_LEVEL = 3 and PRC_GNUM2 = "+ctgr2;
				orderStr = " PRC_SEQ asc ";
				productcategoryList3 = productcategoryDao.list(whereStr, orderStr);
			}
			if( !"".equals( ctgr3 ) ){
				whereStr = " and PRC_LEVEL = 4 and PRC_GNUM3 = "+ctgr3;
				orderStr = " PRC_SEQ asc ";
				productcategoryList4 = productcategoryDao.list(whereStr, orderStr);
			}
			//---search
			
			conn.commit();
			//---* model
			model.put( "totCnt", totCnt );
			model.put( "r_page", r_page );
			model.put( "r_pagelimit", r_pagelimit );
			model.put( "r_rowlimit", r_rowlimit );
			model.put( "productMap", productMap );
			model.put( "productcategoryList1", productcategoryList1 );
			model.put( "productcategoryList2", productcategoryList2 );
			model.put( "productcategoryList3", productcategoryList3 );
			model.put( "productcategoryList4", productcategoryList4 );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/product/bo/productlist" );

			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}