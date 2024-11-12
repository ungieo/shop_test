package productcategory.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system. db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;

public class ProductcategoryInBo implements Svc{

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
			int r_prcseq = Cvt.toInt( req.getParameter( "r_prcseq") );		//부모prcseq
//			String r_prccode = Cvt.toStr( req.getParameter( "r_prccode") );
//			int r_prcpid = Cvt.toInt( req.getParameter( "r_prcpid") );
//			String r_prcname = Cvt.toStr( req.getParameter( "r_prcname") );
//			int r_prcstep = Cvt.toInt( req.getParameter( "r_prcstep") );
//			String r_prctitleimage = Cvt.toStr( req.getParameter( "r_prctitleimage") );
//			int r_prcgnum1 = Cvt.toInt( req.getParameter( "r_prcgnum1") );
//			int r_prcgnum2 = Cvt.toInt( req.getParameter( "r_prcgnum2") );
//			int r_prcgnum3 = Cvt.toInt( req.getParameter( "r_prcgnum3") );
//			int r_prclevel = Cvt.toInt( req.getParameter( "r_prclevel") );
			String r_prctype = Cvt.nullToStr( req.getParameter( "r_prctype"), "N" );
			String r_prcuse = Cvt.nullToStr( req.getParameter( "r_prcuse"), "Y" );
//			String r_prcmoid = Cvt.toStr( req.getParameter( "r_prcmoid") );
//			String r_prcinid = Cvt.toStr( req.getParameter( "r_prcinid") );
//			Timestamp r_prcmodate =  req.getParameter( "r_prcmodate") );
//			Timestamp r_prcindate =  req.getParameter( "r_prcindate") );
			//---* param

			//---*부모카테고리가져오기
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			wColNameList.add( " and prc_seq = ? " );
			wColValList.add( r_prcseq+"" );
			wColTypeList.add( "int" );
			Productcategory productcategory = productcategoryDao.one(sqlMap);
			//---부모카테고리가져오기
			
			//---같은 레벨 스탭 max값 가져오기
			wColNameList.clear(); wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and PRC_PID = ? " );
			wColValList.add( r_prcseq+"" );
			wColTypeList.add( "int" );
			wColNameList.add( " and PRC_LEVEL = ? " );
			wColValList.add( (productcategory.getPRC_LEVEL()+1)+"" );
			wColTypeList.add( "int" );
			sqlMap.put( "maxColName", "prc_step" );
			sqlMap.put( "tableName", "productcategory" );			
			int max_prcstep = productcategoryDao.max(sqlMap);
			
//			whereStr = " and PRC_PID = "+r_prcpid+" and PRC_LEVEL = "+(productcategory.getPRC_LEVEL()+1);
//			productcategoryDao.max("productcategory", "prc_step", whereStr);
			//---* dto setting

//			productcategory.setPRC_SEQ( r_prcseq );
			productcategory.setPRC_CODE( "" );		//---일단 빈값
			productcategory.setPRC_PID( r_prcseq );
			productcategory.setPRC_NAME( "New node" );
			productcategory.setPRC_STEP( max_prcstep+1 );
			productcategory.setPRC_TITLEIMAGE( "" );
//			productcategory.setPRC_GNUM1( r_prcgnum1 );
//			productcategory.setPRC_GNUM2( r_prcgnum2 );
//			productcategory.setPRC_GNUM3( r_prcgnum3 );
			productcategory.setPRC_LEVEL( productcategory.getPRC_LEVEL()+1 );
			productcategory.setPRC_TYPE( r_prctype );
			productcategory.setPRC_USE( r_prcuse );
			productcategory.setPRC_MOID( ss_mbid );
			productcategory.setPRC_INID( ss_mbid );
//			productcategory.setPRC_MODATE( r_prcmodate );
//			productcategory.setPRC_INDATE( r_prcindate );
			//--- dto setting

			//---* Dao
			productcategoryDao.in( productcategory );
			
			//--- Dao
			
			//---*그룹번호업데이트
			int lastId = productcategoryDao.lastId();
			
			
			if( 1 == productcategory.getPRC_LEVEL() ){
				productcategory.setPRC_GNUM1( lastId );
//				productcategory.setPRC_GNUM2( lastId );
//				productcategory.setPRC_GNUM3( lastId );
			}else if( 2 == productcategory.getPRC_LEVEL() ){
				productcategory.setPRC_GNUM1( productcategory.getPRC_GNUM1() );
				productcategory.setPRC_GNUM2( lastId );
//				productcategory.setPRC_GNUM3( lastId );
			}else if( 3 == productcategory.getPRC_LEVEL() ){
				productcategory.setPRC_GNUM1( productcategory.getPRC_GNUM1() );
				productcategory.setPRC_GNUM2( productcategory.getPRC_GNUM2() );
				productcategory.setPRC_GNUM3( lastId );
			}else if( 4 == productcategory.getPRC_LEVEL() ){
				productcategory.setPRC_GNUM1( productcategory.getPRC_GNUM1() );
				productcategory.setPRC_GNUM2( productcategory.getPRC_GNUM2() );
				productcategory.setPRC_GNUM3( productcategory.getPRC_GNUM3() );
				productcategory.setPRC_GNUM4( lastId );
			}
			String colNames = " PRC_GNUM1, PRC_GNUM2, PRC_GNUM3, PRC_GNUM4 ";
			String colVals = productcategory.getPRC_GNUM1()+","+productcategory.getPRC_GNUM2()+","+productcategory.getPRC_GNUM3()+","+productcategory.getPRC_GNUM4();
			whereStr = " and PRC_SEQ = "+lastId;
			productcategoryDao.upChoice(colNames, colVals, whereStr);
			//---그룹번호업데이트
			conn.commit();
			
			JSONObject jsonObj = null;
			jsonObj = new JSONObject();
			jsonObj.put( "prc_seq", lastId );
			jsonObj.put( "prc_pid", r_prcseq );
			jsonObj.put( "prc_name", productcategory.getPRC_NAME() );
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(jsonObj.toString());
			
			return;
			//---* model
//			model.put( "returnType", "R" );
//			model.put( "returnPage", "/productcategory/bo/productcategoryview?r_prcseq="+r_prcseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}