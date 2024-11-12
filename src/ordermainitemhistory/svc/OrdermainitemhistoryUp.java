package ordermainitemhistory.svc;

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
import ordermainitemhistory.dao.OrdermainitemhistoryDao;
import ordermainitemhistory.dto.Ordermainitemhistory;

public class OrdermainitemhistoryUp implements Svc{

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
			int r_omihseq = Cvt.toInt( req.getParameter( "r_omihseq") );
			String r_omihomiseq = Cvt.toStr( req.getParameter( "r_omihomiseq") );
			String r_omihomistatus = Cvt.toStr( req.getParameter( "r_omihomistatus") );
			String r_omihomistep = Cvt.toStr( req.getParameter( "r_omihomistep") );
			String r_omihmemo = Cvt.toStr( req.getParameter( "r_omihmemo") );
			String r_omihlevel = Cvt.toStr( req.getParameter( "r_omihlevel") );
			String r_omihtype = Cvt.toStr( req.getParameter( "r_omihtype") );
			String r_omihmoid = Cvt.toStr( req.getParameter( "r_omihmoid") );
			String r_omihinid = Cvt.toStr( req.getParameter( "r_omihinid") );
//			Timestamp r_omihmodate =  req.getParameter( "r_omihmodate") );
//			Timestamp r_omihindate =  req.getParameter( "r_omihindate") );
			//--- param

			//---* dto setting
			Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();

			ordermainitemhistory.setOMIH_SEQ( r_omihseq );
			ordermainitemhistory.setOMIH_OMISEQ( r_omihomiseq );
			ordermainitemhistory.setOMIH_OMISTATUS( r_omihomistatus );
			ordermainitemhistory.setOMIH_OMISTEP( r_omihomistep );
			ordermainitemhistory.setOMIH_MEMO( r_omihmemo );
			ordermainitemhistory.setOMIH_LEVEL( r_omihlevel );
			ordermainitemhistory.setOMIH_TYPE( r_omihtype );
			ordermainitemhistory.setOMIH_MOID( r_omihmoid );
			ordermainitemhistory.setOMIH_INID( r_omihinid );
//			ordermainitemhistory.setOMIH_MODATE(r_omihmodate );
//			ordermainitemhistory.setOMIH_INDATE(r_omihindate );
			//--- dto setting

			//---* Dao
			OrdermainitemhistoryDao ordermainitemhistoryDao = new OrdermainitemhistoryDao( conn );
			wColNameList.add( " and OMIH_SEQ = ? " );
			wColValList.add( r_omihseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			ordermainitemhistoryDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermainitemhistory/ordermainitemhistoryview?r_omihseq="+r_omihseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}