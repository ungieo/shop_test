package companydepartment.svc;

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

import companydepartment.dao.CompanydepartmentDao;

import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

public class CompanydepartmentListBoJson implements Svc{

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
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---*param
			String r_cpdcpid = Cvt.toStr( req.getParameter( "r_cpdcpid" ) );
			//---param

			//---* Dao

			CompanydepartmentDao companydepartmentDao = new CompanydepartmentDao( conn );
			colNameList.add( " CPD_ID " );
			colNameList.add( " ,CPD_NAME " );
			wColNameList.add( " and CPD_CPID = ? " );
			wColValList.add( r_cpdcpid );
			wColTypeList.add( "String" );
			List<Map<String, Object>> companydepartmentList = companydepartmentDao.listChoice(sqlMap);
			
			
			JSONArray obj = new JSONArray();
			JSONObject obj2 = null;
			
			for( Map<String, Object> companydepartment : companydepartmentList ){
				obj2 = new JSONObject();
				obj2.put( "cpd_id", companydepartment.get("CPD_ID") );
				obj2.put( "cpd_name", companydepartment.get("CPD_NAME") );
				obj.add(obj2);
			}
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj.toString());
//			System.out.println(obj.toString());
			  
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}