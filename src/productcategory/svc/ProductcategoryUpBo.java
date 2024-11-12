package productcategory.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;

public class ProductcategoryUpBo implements Svc{

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
			List<Object> colValList = new ArrayList<Object>();
			List<String> colTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "colValList", colValList );
			sqlMap.put( "colTypeList", colTypeList );
			
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_prcseq = Cvt.toInt( req.getParameter( "r_prcseq") );
//			String r_prccode = Cvt.toStr( req.getParameter( "r_prccode") );
//			int r_prcpid = Cvt.toInt( req.getParameter( "r_prcpid") );
			String r_prcname = Cvt.toStr( req.getParameter( "r_prcname") );
//			int r_prcstep = Cvt.toInt( req.getParameter( "r_prcstep") );
//			String r_prctitleimage = Cvt.toStr( req.getParameter( "r_prctitleimage") );
//			int r_prcgnum1 = Cvt.toInt( req.getParameter( "r_prcgnum1") );
//			int r_prcgnum2 = Cvt.toInt( req.getParameter( "r_prcgnum2") );
//			int r_prcgnum3 = Cvt.toInt( req.getParameter( "r_prcgnum3") );
//			String r_prclevel = Cvt.toStr( req.getParameter( "r_prclevel") );
//			String r_prctype = Cvt.toStr( req.getParameter( "r_prctype") );
//			String r_prcuse = Cvt.toStr( req.getParameter( "r_prcuse") );
//			String r_prcmoid = Cvt.toStr( req.getParameter( "r_prcmoid") );
//			String r_prcinid = Cvt.toStr( req.getParameter( "r_prcinid") );
//			Timestamp r_prcmodate =  req.getParameter( "r_prcmodate") );
//			Timestamp r_prcindate =  req.getParameter( "r_prcindate") );
			//--- param

			//---* dto setting
			Productcategory productcategory = new Productcategory();

			productcategory.setPRC_SEQ( r_prcseq );
//			productcategory.setPRC_CODE( r_prccode );
//			productcategory.setPRC_PID( r_prcpid );
			productcategory.setPRC_NAME( r_prcname );
//			productcategory.setPRC_STEP( r_prcstep );
//			productcategory.setPRC_TITLEIMAGE( r_prctitleimage );
//			productcategory.setPRC_LEVEL( r_prclevel );
//			productcategory.setPRC_GNUM1( r_prcgnum1 );
//			productcategory.setPRC_GNUM2( r_prcgnum2 );
//			productcategory.setPRC_GNUM3( r_prcgnum3 );
//			productcategory.setPRC_TYPE( r_prctype );
//			productcategory.setPRC_USE( r_prcuse );
			productcategory.setPRC_MOID( ss_mbid );
//			productcategory.setPRC_INID( r_prcinid );
//			productcategory.setPRC_MODATE(r_prcmodate );
//			productcategory.setPRC_INDATE(r_prcindate );
			//--- dto setting

			//---* Dao
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			colNameList.add( " PRC_NAME =  ? " );
			colValList.add( r_prcname );
			colTypeList.add( "String" );
			colNameList.add( ", PRC_MOID =  ? " );
			colValList.add( ss_mbid );
			colTypeList.add( "String" );
			
			wColNameList.add( " and PRC_SEQ = ? ");
			wColValList.add( r_prcseq+"" );
			wColTypeList.add( "int" );
			productcategoryDao.upChoice(sqlMap);
			conn.commit();
			//--- Dao
			return;

			//---* model
//			model.put( "returnType", "R" );
//			model.put( "returnPage", "/productcategory/bo/productcategoryview?r_prcseq="+r_prcseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}