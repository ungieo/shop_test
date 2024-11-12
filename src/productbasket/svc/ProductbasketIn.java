package productbasket.svc;

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
import system. db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import productbasket.dao.ProductbasketDao;
import productbasket.dto.Productbasket;

public class ProductbasketIn implements Svc{

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
			int r_prbseq = Cvt.toInt( req.getParameter( "r_prbseq") );
			int r_prbprseq = Cvt.toInt( req.getParameter( "r_prbprseq") );
			String r_prbmbid = Cvt.toStr( req.getParameter( "r_prbmbid") );
			int r_prbproseq = Cvt.toInt( req.getParameter( "r_prbproseq") );
			int r_prbea = Cvt.toInt( req.getParameter( "r_prbea") );
			String r_prbtype = Cvt.toStr( req.getParameter( "r_prbtype") );
			String r_prbmoid = Cvt.toStr( req.getParameter( "r_prbmoid") );
			String r_prbinid = Cvt.toStr( req.getParameter( "r_prbinid") );
//			Timestamp r_prbindate =  req.getParameter( "r_prbindate") );
			//---* param

			//---* dto setting
			Productbasket productbasket = new Productbasket();

			productbasket.setPRB_SEQ( r_prbseq );
			productbasket.setPRB_PRSEQ( r_prbprseq );
			productbasket.setPRB_MBID( r_prbmbid );
			productbasket.setPRB_PROSEQ( r_prbproseq );
			productbasket.setPRB_EA( r_prbea );
			productbasket.setPRB_TYPE( r_prbtype );
			productbasket.setPRB_MOID( r_prbmoid );
			productbasket.setPRB_INID( r_prbinid );
//			productbasket.setPRB_INDATE( r_prbindate );
			//--- dto setting

			//---* Dao
			ProductbasketDao productbasketDao = new ProductbasketDao( conn );
			productbasketDao.in( productbasket );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/productbasket/productbasketview?r_prbseq="+r_prbseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}