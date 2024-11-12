package home.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import commontext.dao.CommontextDao;
import commontext.dto.Commontext;

public class PrivacyEditBo implements Svc{

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
			String ss_mbcpid = Cvt.toStr( session.getAttribute( "ss_mbcpid" ) );
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			//--- param

			//---* Dao
			CommontextDao commontextDao = new CommontextDao( conn );
			wColNameList.add( " and CMT_CPID = ? " );
			wColValList.add( ss_mbcpid );
			wColTypeList.add( "String" );
			wColNameList.add( " and CMT_GROUPCODE = ? " );
			wColValList.add( "shopinfo" );
			wColTypeList.add( "String" );
			wColNameList.add( " and CMT_CODE = ? " );
			wColValList.add( "privacy" );
			wColTypeList.add( "String" );
			Commontext commontext = commontextDao.one(sqlMap);
			
			//--- Dao
			   
			conn.commit();

			//---* model
			model.put( "commontext", commontext );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/home/bo/privacyedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}