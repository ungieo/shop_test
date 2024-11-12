package productbasket.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.dto.Member;
import memberlog.dao.MemberlogDao;
import memberlog.dto.Memberlog;

import org.json.simple.JSONObject;

import productbasket.dao.ProductbasketDao;
import productbasket.dto.Productbasket;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;

public class ProductbasketListDelAjax implements Svc{

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
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable
			

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			if( "".equals( ss_mbid ) ){
				ss_mbid = session.getId();
			}
			
			//---* param
			String r_prbseq = Cvt.toStr( req.getParameter( "r_prbseq" ) );
			//--- param

			//---* Dao
			ProductbasketDao productbasketDao = new ProductbasketDao( conn );
			productbasketDao.del( " and PRB_SEQ in("+r_prbseq+") and PRB_MBID = '"+ss_mbid+"'" );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "" );
			//--- Dao
			
			wColNameList.add( " and PRB_MBID = ? " );
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			int basketCnt = productbasketDao.cnt(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			conn.commit();
			
			JSONObject obj2 = new JSONObject();
			obj2.put( "result", true );
			obj2.put( "basketCnt", basketCnt );
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj2.toString());
			
		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}