package productdisplay.svc;

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
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import product.dto.Product;
import productdisplay.dao.ProductdisplayDao;
import productdisplay.dto.Productdisplay;

public class ProductdisplayListInBoAjax implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_prdprseqarr = Cvt.toStr( req.getParameter( "r_prdprseqarr" ) );
			String r_prdtype = Cvt.toStr( req.getParameter( "r_prdtype" ) );
			//--- param

			//---* Dao
			ProductdisplayDao productdisplayDao = new ProductdisplayDao( conn );
			for( String prd_prseq : r_prdprseqarr.split(",") ){
				Productdisplay productdisplay = new Productdisplay();
				
//				productdisplay.setPRD_SEQ( r_prdseq );
				productdisplay.setPRD_PRSEQ( Cvt.toInt(prd_prseq) );
				productdisplay.setPRD_TYPE( r_prdtype );
				productdisplay.setPRD_USE( "Y" );
				productdisplay.setPRD_INID( ss_mbid );
//				productdisplay.setPRD_INDATE( r_prdindate );
				
				productdisplayDao.in(productdisplay);
			}
			
			
			conn.commit();
			//--- Dao
			
			JSONObject obj = new JSONObject();
			
			obj.put( "result", true );
			
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj.toString());
			


		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}