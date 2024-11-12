package productoption.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
import system.util.Pageing;
import productoption.dao.ProductoptionDao;
import productoption.dto.Productoption;

public class ProductoptionListAjax implements Svc{

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
			String r_proprseq = Cvt.toStr( req.getParameter( "r_proprseq" ) );
			//--- param

			//---* Dao
			ProductoptionDao productoptionDao = new ProductoptionDao( conn );
			wColNameList.add( "AND PRO_PRSEQ = ? ");
			wColValList.add( r_proprseq );
			wColTypeList.add( "int" );
//			sqlMap.put( "orderStr", orderStr );
			
			List<Productoption> productoptionList = productoptionDao.list(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- Dao
			conn.commit();
			
			JSONObject root = new JSONObject();
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			for( Productoption productoption : productoptionList ){
				obj2 = new JSONObject();
				
				obj2.put( "pro_seq", productoption.getPRO_SEQ() );
				obj2.put( "pro_gname", productoption.getPRO_GNAME() );
				obj2.put( "pro_name", productoption.getPRO_NAME() );
				
				obj.add(obj2);
			}
			root.put( "productoptionList", obj );
			root.put( "result", true );
//			root.put( "msg", "");
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