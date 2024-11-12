package ordermainhistory.svc;

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
import ordermainhistory.dao.OrdermainhistoryDao;
import ordermainhistory.dto.Ordermainhistory;

public class OrdermainhistoryInBo implements Svc{

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
			int r_omhseq = Cvt.toInt( req.getParameter( "r_omhseq") );
			int r_omhomseq = Cvt.toInt( req.getParameter( "r_omhomseq") );
			String r_omhomstatus = Cvt.toStr( req.getParameter( "r_omhomstatus") );
			String r_omhmemo = Cvt.toStr( req.getParameter( "r_omhmemo") );
			String r_omhtype = Cvt.toStr( req.getParameter( "r_omhtype") );
			String r_omhinid = Cvt.toStr( req.getParameter( "r_omhinid") );
//			Timestamp r_omhindate =  req.getParameter( "r_omhindate") );
			//---* param

			//---* dto setting
			Ordermainhistory ordermainhistory = new Ordermainhistory();

			ordermainhistory.setOMH_SEQ( r_omhseq );
			ordermainhistory.setOMH_OMSEQ( r_omhomseq );
			ordermainhistory.setOMH_OMSTATUS( r_omhomstatus );
			ordermainhistory.setOMH_MEMO( r_omhmemo );
			ordermainhistory.setOMH_TYPE( r_omhtype );
			ordermainhistory.setOMH_INID( r_omhinid );
//			ordermainhistory.setOMH_INDATE( r_omhindate );
			//--- dto setting

			//---* Dao
			OrdermainhistoryDao ordermainhistoryDao = new OrdermainhistoryDao( conn );
			ordermainhistoryDao.in( ordermainhistory );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermainhistory/bo/ordermainhistoryview?r_omhseq="+r_omhseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}