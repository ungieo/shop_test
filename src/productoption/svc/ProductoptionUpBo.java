package productoption.svc;

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
import productoption.dao.ProductoptionDao;
import productoption.dto.Productoption;

public class ProductoptionUpBo implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_proseq = Cvt.toInt( req.getParameter( "r_proseq") );
			int r_proprseq = Cvt.toInt( req.getParameter( "r_proprseq") );
			String r_progname = Cvt.toStr( req.getParameter( "r_progname") );
			String r_proname = Cvt.toStr( req.getParameter( "r_proname") );
			String r_provalue = Cvt.toStr( req.getParameter( "r_provalue") );
			int r_proprice = Cvt.toInt( req.getParameter( "r_proprice") );
			int r_prostock = Cvt.toInt( req.getParameter( "r_prostock") );
			String r_prolevel = Cvt.toStr( req.getParameter( "r_prolevel") );
			String r_protype = Cvt.toStr( req.getParameter( "r_protype") );
			String r_prouse = Cvt.toStr( req.getParameter( "r_prouse") );
			String r_promoid = Cvt.toStr( req.getParameter( "r_promoid") );
			String r_proinid = Cvt.toStr( req.getParameter( "r_proinid") );
//			Timestamp r_promodate =  req.getParameter( "r_promodate") );
//			Timestamp r_proindate =  req.getParameter( "r_proindate") );
			//--- param

			//---* dto setting
			Productoption productoption = new Productoption();

			productoption.setPRO_SEQ( r_proseq );
			productoption.setPRO_PRSEQ( r_proprseq );
			productoption.setPRO_GNAME( r_progname );
			productoption.setPRO_NAME( r_proname );
			productoption.setPRO_VALUE( r_provalue );
			productoption.setPRO_PRICE( r_proprice );
			productoption.setPRO_STOCK( r_prostock );
			productoption.setPRO_LEVEL( r_prolevel );
			productoption.setPRO_TYPE( r_protype );
			productoption.setPRO_USE( r_prouse );
			productoption.setPRO_MOID( r_promoid );
			productoption.setPRO_INID( r_proinid );
//			productoption.setPRO_MODATE(r_promodate );
//			productoption.setPRO_INDATE(r_proindate );
			//--- dto setting

			//---* Dao
			ProductoptionDao productoptionDao = new ProductoptionDao( conn );
			wColNameList.add( " and PRO_SEQ = ? " );
			wColValList.add( r_proseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			productoptionDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/productoption/bo/productoptionview?r_proseq="+r_proseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}