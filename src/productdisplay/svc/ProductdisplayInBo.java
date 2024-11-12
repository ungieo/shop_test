package productdisplay.svc;

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
import productdisplay.dao.ProductdisplayDao;
import productdisplay.dto.Productdisplay;

public class ProductdisplayInBo implements Svc{

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
			int r_prdseq = Cvt.toInt( req.getParameter( "r_prdseq") );
			int r_prdprseq = Cvt.toInt( req.getParameter( "r_prdprseq") );
			String r_prdtype = Cvt.toStr( req.getParameter( "r_prdtype") );
			String r_prduse = Cvt.toStr( req.getParameter( "r_prduse") );
			String r_prdinid = Cvt.toStr( req.getParameter( "r_prdinid") );
//			Timestamp r_prdindate =  req.getParameter( "r_prdindate") );
			//---* param

			//---* dto setting
			Productdisplay productdisplay = new Productdisplay();

			productdisplay.setPRD_SEQ( r_prdseq );
			productdisplay.setPRD_PRSEQ( r_prdprseq );
			productdisplay.setPRD_TYPE( r_prdtype );
			productdisplay.setPRD_USE( r_prduse );
			productdisplay.setPRD_INID( r_prdinid );
//			productdisplay.setPRD_INDATE( r_prdindate );
			//--- dto setting

			//---* Dao
			ProductdisplayDao productdisplayDao = new ProductdisplayDao( conn );
			productdisplayDao.in( productdisplay );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/productdisplay/bo/productdisplayview?r_prdseq="+r_prdseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}