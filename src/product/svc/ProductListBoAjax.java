package product.svc;

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

import product.dao.ProductDao;
import product.dto.Product;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;

public class ProductListBoAjax implements Svc{

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

			conn.commit();
			
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			List<Product> productList = (List<Product>) productMap.get("productList");
			for( Product product : productList ){
				obj2 = new JSONObject();
				
				obj2.put( "pr_seq", product.getPR_SEQ() );
				obj2.put( "pr_prcseq", product.getPR_PRCSEQ() );
				obj2.put( "pr_code", product.getPR_CODE() );
				obj2.put( "pr_codeb", product.getPR_CODEB() );
				obj2.put( "pr_codes", product.getPR_CODES() );
				obj2.put( "pr_name", product.getPR_NAME() );
				obj2.put( "pr_price", product.getPR_PRICE() );
				obj2.put( "pr_filenum", product.getPR_FILENUM() );
				obj2.put( "pr_image1", product.getPR_IMAGE1() );
				obj2.put( "pr_image2", product.getPR_IMAGE2() );
				obj2.put( "pr_image3", product.getPR_IMAGE3() );
				obj2.put( "pr_image4", product.getPR_IMAGE4() );
				obj2.put( "pr_cpids", product.getPR_CPIDS() );
				obj2.put( "pr_cpidb", product.getPR_CPIDB() );
				obj2.put( "pr_barcode", product.getPR_BARCODE() );
				obj2.put( "pr_vatuse", product.getPR_VATUSE() );
				obj2.put( "pr_savemoney", product.getPR_SAVEMONEY() );
				obj2.put( "pr_standard", product.getPR_STANDARD() );
				obj2.put( "pr_brseq", product.getPR_BRSEQ() );
				obj2.put( "pr_model", product.getPR_MODEL() );
				obj2.put( "pr_unit", product.getPR_UNIT() );
				obj2.put( "pr_manufacture", product.getPR_MANUFACTURE() );
				obj2.put( "pr_country", product.getPR_COUNTRY() );
				obj2.put( "pr_minbuyea", product.getPR_MINBUYEA() );
				obj2.put( "pr_stock", product.getPR_STOCK() );
				obj2.put( "pr_weight", product.getPR_WEIGHT() );
				obj2.put( "pr_content", product.getPR_CONTENT() );
				obj2.put( "pr_deliterm", product.getPR_DELITERM() );
				obj2.put( "pr_delipolicy", product.getPR_DELIPOLICY() );
				obj2.put( "pr_status", product.getPR_STATUS() );
				obj2.put( "pr_level", product.getPR_LEVEL() );
				obj2.put( "pr_type", product.getPR_TYPE() );
				obj2.put( "pr_use", product.getPR_USE() );
				obj2.put( "pr_moid", product.getPR_MOID() );
				obj2.put( "pr_inid", product.getPR_INID() );
				obj2.put( "pr_modate", Cvt.subString( product.getPR_MODATE().toString(), 0, 10 ) );
				obj2.put( "pr_indate", Cvt.subString( product.getPR_INDATE().toString(), 0, 10 ) );
				
				obj.add(obj2);
			}
			JSONObject root = new JSONObject();
			root.put( "productList", obj );
			root.put( "totCnt", totCnt );			//iTotalRecords
			root.put( "r_page", r_page );		//iTotalDisplayRecords
			root.put( "r_pagelimit", r_pagelimit );
			root.put( "r_rowlimit", r_rowlimit );
			root.put( "totPage", model.get("totPage"));
			root.put( "startPage", model.get("startPage"));
			root.put( "endPage", model.get("endPage"));
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(root.toString());
			
			
			
			
			
			

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}