package ordermain.svc;

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
import ordermain.dao.OrdermainDao;
import ordermain.dto.Ordermain;

public class OrdermainUpBo implements Svc{

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
			int r_omseq = Cvt.toInt( req.getParameter( "r_omseq") );
			String r_omid = Cvt.toStr( req.getParameter( "r_omid") );
			String r_ompgid = Cvt.toStr( req.getParameter( "r_ompgid") );
			String r_ompswd = Cvt.toStr( req.getParameter( "r_ompswd") );
			String r_ommbid = Cvt.toStr( req.getParameter( "r_ommbid") );
			String r_ommbname = Cvt.toStr( req.getParameter( "r_ommbname") );
			String r_omprname = Cvt.toStr( req.getParameter( "r_omprname") );
			String r_ompaytype = Cvt.toStr( req.getParameter( "r_ompaytype") );
			int r_omaccountmoney = Cvt.toInt( req.getParameter( "r_omaccountmoney") );
			int r_omcardmoney = Cvt.toInt( req.getParameter( "r_omcardmoney") );
			int r_omcouponmoney = Cvt.toInt( req.getParameter( "r_omcouponmoney") );
			int r_omlatermoney = Cvt.toInt( req.getParameter( "r_omlatermoney") );
			int r_ompointmoney = Cvt.toInt( req.getParameter( "r_ompointmoney") );
			int r_omsavemoney = Cvt.toInt( req.getParameter( "r_omsavemoney") );
			int r_omvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omvirtualaccountmoney") );
			int r_omraccountmoney = Cvt.toInt( req.getParameter( "r_omraccountmoney") );
			int r_omrcardmoney = Cvt.toInt( req.getParameter( "r_omrcardmoney") );
			int r_omrcouponmoney = Cvt.toInt( req.getParameter( "r_omrcouponmoney") );
			int r_omrlatermoney = Cvt.toInt( req.getParameter( "r_omrlatermoney") );
			int r_omrpointmoney = Cvt.toInt( req.getParameter( "r_omrpointmoney") );
			int r_omrsavemoney = Cvt.toInt( req.getParameter( "r_omrsavemoney") );
			int r_omrvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omrvirtualaccountmoney") );
			int r_omnewsavemoney = Cvt.toInt( req.getParameter( "r_omnewsavemoney") );
			int r_omorignalmoney = Cvt.toInt( req.getParameter( "r_omorignalmoney") );
			int r_omsalemoney = Cvt.toInt( req.getParameter( "r_omsalemoney") );
			String r_omdelitype = Cvt.toStr( req.getParameter( "r_omdelitype") );
			String r_omdelimemo = Cvt.toStr( req.getParameter( "r_omdelimemo") );
			int r_omdelimoney = Cvt.toInt( req.getParameter( "r_omdelimoney") );
			String r_omdelinum = Cvt.toStr( req.getParameter( "r_omdelinum") );
			String r_ommemo = Cvt.toStr( req.getParameter( "r_ommemo") );
			int r_ompccseq = Cvt.toInt( req.getParameter( "r_ompccseq") );
			String r_omescrowyn = Cvt.toStr( req.getParameter( "r_omescrowyn") );
			String r_ompartcancelyn = Cvt.toStr( req.getParameter( "r_ompartcancelyn") );
			String r_omstatus = Cvt.toStr( req.getParameter( "r_omstatus") );
			String r_omstep = Cvt.toStr( req.getParameter( "r_omstep") );
			String r_omtype = Cvt.toStr( req.getParameter( "r_omtype") );
			String r_ommoid = Cvt.toStr( req.getParameter( "r_ommoid") );
			String r_ominid = Cvt.toStr( req.getParameter( "r_ominid") );
//			Timestamp r_ommodate =  req.getParameter( "r_ommodate") );
//			Timestamp r_omindate =  req.getParameter( "r_omindate") );
			//--- param

			//---* dto setting
			Ordermain ordermain = new Ordermain();

			ordermain.setOM_SEQ( r_omseq );
			ordermain.setOM_ID( r_omid );
			ordermain.setOM_PGID( r_ompgid );
			ordermain.setOM_PSWD( r_ompswd );
			ordermain.setOM_MBID( r_ommbid );
			ordermain.setOM_MBNAME( r_ommbname );
			ordermain.setOM_PRNAME( r_omprname );
			ordermain.setOM_PAYTYPE( r_ompaytype );
			ordermain.setOM_ACCOUNTMONEY( r_omaccountmoney );
			ordermain.setOM_CARDMONEY( r_omcardmoney );
			ordermain.setOM_COUPONMONEY( r_omcouponmoney );
			ordermain.setOM_LATERMONEY( r_omlatermoney );
			ordermain.setOM_POINTMONEY( r_ompointmoney );
			ordermain.setOM_SAVEMONEY( r_omsavemoney );
			ordermain.setOM_VIRTUALACCOUNTMONEY( r_omvirtualaccountmoney );
			ordermain.setOM_RACCOUNTMONEY( r_omraccountmoney );
			ordermain.setOM_RCARDMONEY( r_omrcardmoney );
			ordermain.setOM_RCOUPONMONEY( r_omrcouponmoney );
			ordermain.setOM_RLATERMONEY( r_omrlatermoney );
			ordermain.setOM_RPOINTMONEY( r_omrpointmoney );
			ordermain.setOM_RSAVEMONEY( r_omrsavemoney );
			ordermain.setOM_RVIRTUALACCOUNTMONEY( r_omrvirtualaccountmoney );
			ordermain.setOM_NEWSAVEMONEY( r_omnewsavemoney );
			ordermain.setOM_ORIGNALMONEY( r_omorignalmoney );
			ordermain.setOM_SALEMONEY( r_omsalemoney );
			ordermain.setOM_DELITYPE( r_omdelitype );
			ordermain.setOM_DELIMEMO( r_omdelimemo );
			ordermain.setOM_DELIMONEY( r_omdelimoney );
			ordermain.setOM_DELINUM( r_omdelinum );
			ordermain.setOM_MEMO( r_ommemo );
			ordermain.setOM_PCCSEQ( r_ompccseq );
			ordermain.setOM_ESCROWYN( r_omescrowyn );
			ordermain.setOM_PARTCANCELYN( r_ompartcancelyn );
			ordermain.setOM_STATUS( r_omstatus );
			ordermain.setOM_STEP( r_omstep );
			ordermain.setOM_TYPE( r_omtype );
			ordermain.setOM_MOID( r_ommoid );
			ordermain.setOM_INID( r_ominid );
//			ordermain.setOM_MODATE(r_ommodate );
//			ordermain.setOM_INDATE(r_omindate );
			//--- dto setting

			//---* Dao
			OrdermainDao ordermainDao = new OrdermainDao( conn );
			wColNameList.add( " and OM_SEQ = ? " );
			wColValList.add( r_omseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			ordermainDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermain/bo/ordermainview?r_omseq="+r_omseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}