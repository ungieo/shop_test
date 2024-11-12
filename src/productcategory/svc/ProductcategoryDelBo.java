package productcategory.svc;

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

public class ProductcategoryDelBo implements Svc{

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
			String r_prcseq = Cvt.toStr( req.getParameter( "r_prcseq" ) );
			//--- param

			//---* Dao
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			wColNameList.add( " and PRC_SEQ = ? " );
			wColValList.add( r_prcseq );
			wColTypeList.add( "int" );
//			sqlMap.put( "orderStr", orderStr );
			
			Productcategory productcategory = productcategoryDao.one(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			if( 4 == productcategory.getPRC_LEVEL() ){
				wColNameList.add( " and PRC_SEQ = ? " );
				wColValList.add( r_prcseq );
				wColTypeList.add( "int" );
				productcategoryDao.del(sqlMap);				
			}else{
				wColNameList.add( " and PRC_GNUM"+productcategory.getPRC_LEVEL()+" = ? " );
				wColValList.add( r_prcseq );
				wColTypeList.add( "int" );
				productcategoryDao.del(sqlMap);
			}
			
			/*
			if( 1 == productcategory.getPRC_LEVEL() ){
				productcategoryDao.del( " and PRC_GNUM1 = "+productcategory.getPRC_SEQ() );
			}else if( 2 == productcategory.getPRC_LEVEL() ){
				productcategoryDao.del( " and PRC_GNUM2 = "+productcategory.getPRC_SEQ() );
			}else if( 3 == productcategory.getPRC_LEVEL() ){
				productcategoryDao.del( " and PRC_GNUM3 = "+productcategory.getPRC_SEQ() );
			}else if( 4 == productcategory.getPRC_LEVEL() ){
				productcategoryDao.del( " and PRC_GNUM4 = "+productcategory.getPRC_SEQ() );
			}
			*/
			conn.commit();
			//--- Dao

			return;
			
		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}