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
import productbasket.dao.ProductbasketDao;
import productcategory.dao.ProductcategoryDao;
import productgroup.dao.ProductgroupDao;
import productoption.dao.ProductoptionDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

public class ProductViewAjax implements Svc{

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
			//--- sql variable

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
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- Dao
			
			//---*선택카테고리
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			wColNameList.add( " and prc1.PRC_SEQ = ? " );
			wColValList.add( product.getPR_PRCSEQ()+"" );
			wColTypeList.add( "int" );
			Map<String, Object> productcategory = productcategoryDao.oneChoiceJoin(sqlMap);
			colNameList.clear();wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---선택카테고리
			
			//---*optionList
			ProductoptionDao productoptionDao = new ProductoptionDao(conn);
			colNameList.add( " PRO_SEQ " );
			colNameList.add( " ,PRO_GNAME " );
			colNameList.add( " ,PRO_NAME " );
			wColNameList.add( " and PRO_PRSEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			List<Map<String, Object>> productoptionList = productoptionDao.listChoice(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();colNameList.clear();
			//---optionList
			
			conn.commit();
			
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
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
			
			
			
			JSONObject root = new JSONObject();
			root.put( "product", obj );
			
			
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