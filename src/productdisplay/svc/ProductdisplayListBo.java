package productdisplay.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import product.dao.ProductDao;
import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;
import productdisplay.dao.ProductdisplayDao;
import productdisplay.dto.Productdisplay;

public class ProductdisplayListBo implements Svc{

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

			//--- param

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;
			
			
			//---* search
			String sc_type= Cvt.toStr( req.getParameter( "sc_type" ) );
			String sc_word= Cvt.toStr( req.getParameter( "sc_word" ) );
			String ctgr1= Cvt.toStr( req.getParameter( "ctgr1" ) );
			String ctgr2= Cvt.toStr( req.getParameter( "ctgr2" ) );
			String ctgr3= Cvt.toStr( req.getParameter( "ctgr3" ) );
			String ctgr4= Cvt.toStr( req.getParameter( "ctgr4" ) );
			
			String sc_prdindates= Cvt.toStr( req.getParameter( "sc_prdindates" ) );
			String sc_prdindatee= Cvt.toStr( req.getParameter( "sc_prindatee" ) );
			
			String sc_prduse = Cvt.toStr( req.getParameter( "sc_prduse" ) );
			
			String sc_prdtype = Cvt.toStr( req.getParameter( "sc_prdtype" ) );
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
			
			if( !"".equals( sc_prdindates ) ){
				wColNameList.add( " and date_format( PRD_INDATE,'%Y%m%d' ) >= ? " );
				wColValList.add( sc_prdindates.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_prdindatee ) ){
				wColNameList.add( " and date_format( PRD_INDATE,'%Y%m%d' ) <= ? " );
				wColValList.add( sc_prdindatee.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			
			if( !"".equals( sc_prduse ) ){
				wColNameList.add( " and PRD_USE = ? " );
				wColValList.add( sc_prduse );
				wColTypeList.add( "String" );
			}
			
			if( !"".equals( sc_prdtype ) ){
				wColNameList.add( " and PRD_TYPE = ? " );
				wColValList.add( sc_prdtype );
				wColTypeList.add( "String" );
			}
		

			//---* Dao
			ProductdisplayDao productdisplayDao = new ProductdisplayDao( conn );
//			wColNameList.add();
//			wColValList.add();
//			wColTypeList.add();
			orderStr = " PRD_SEQ DESC ";
			sqlMap.put( "orderStr", orderStr );

			int totCnt = productdisplayDao.cntJoin( sqlMap );
			Map<String, Object> productdisplayMap = productdisplayDao.listJoin( r_page, r_rowlimit, sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
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
			model.put( "productdisplayMap", productdisplayMap );
			
			model.put( "productcategoryList1", productcategoryList1 );
			model.put( "productcategoryList2", productcategoryList2 );
			model.put( "productcategoryList3", productcategoryList3 );
			model.put( "productcategoryList4", productcategoryList4 );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/productdisplay/bo/productdisplaylist" );

			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}