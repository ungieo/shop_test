package ordermain.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ordermain.dao.OrdermainDao;
import ordermain.dto.Ordermain;

import org.json.simple.JSONObject;

import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.svc.OrderHandlingSvc;
import system.util.CommonUtil;
import system.util.Cvt;

public class OrdermainListUpBoAjax implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<Object> colValList = new ArrayList<Object>();
			List<String> colTypeList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "colValList", colValList );
			sqlMap.put( "colTypeList", colTypeList );
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
			String r_omseqarr = Cvt.toStr( req.getParameter( "r_omseqarr" ) );
			String r_omstatus = Cvt.toStr( req.getParameter( "r_omstatus" ) );
			//---* param

			
			//---* Dao
			Map<String, Object> svcMap = new HashMap<String ,Object>();
			KcpOrderHandlingSvc odHandling = new KcpOrderHandlingSvc(conn);
			
			OrdermainDao ordermainDao = new OrdermainDao(conn);
			for( String r_omseq : r_omseqarr.split(",") ){
				
				wColNameList.add( " and OM_SEQ = ? " );
				wColValList.add( r_omseq );
				wColTypeList.add( "int" );
				Ordermain ordermain = ordermainDao.one(sqlMap);
				wColNameList.clear();wColValList.clear();wColTypeList.clear();
				svcMap.put( "ordermain", ordermain );
				
				if( "E1".equals( r_omstatus ) ){
					odHandling.deliveryIn(req, res, svcMap);
					odHandling.escrowIn(req, res, svcMap);
				}
				else if( "F1".equals( r_omstatus ) ){
					odHandling.escrowUp(req, res, svcMap);
				}
				else if( "G1".equals( r_omstatus ) ){
					odHandling.salesIn(req, res, svcMap);
					odHandling.virtualMoneyIn(req, res, svcMap);
				}
				
				odHandling.omStatusUp(req, res, svcMap);
				odHandling.omHistoryIn(req, res, svcMap);
			}
			
			
			
			conn.commit();
			
			JSONObject obj2 = new JSONObject();
			obj2.put( "result", true );
			
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