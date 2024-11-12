package ordermainitem.svc;

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
import ordermainitem.dao.OrdermainitemDao;
import ordermainitem.dto.Ordermainitem;

public class OrdermainitemInBo implements Svc{

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
			int r_omiseq = Cvt.toInt( req.getParameter( "r_omiseq") );
			int r_omiomseq = Cvt.toInt( req.getParameter( "r_omiomseq") );
			int r_omiprseq = Cvt.toInt( req.getParameter( "r_omiprseq") );
			int r_omiproseq = Cvt.toInt( req.getParameter( "r_omiproseq") );
			String r_omipswd = Cvt.toStr( req.getParameter( "r_omipswd") );
			String r_omimbid = Cvt.toStr( req.getParameter( "r_omimbid") );
			String r_omimbname = Cvt.toStr( req.getParameter( "r_omimbname") );
			String r_omipaytype = Cvt.toStr( req.getParameter( "r_omipaytype") );
			int r_omiaccountmoney = Cvt.toInt( req.getParameter( "r_omiaccountmoney") );
			int r_omicardmoney = Cvt.toInt( req.getParameter( "r_omicardmoney") );
			int r_omicouponmoney = Cvt.toInt( req.getParameter( "r_omicouponmoney") );
			int r_omilatermoney = Cvt.toInt( req.getParameter( "r_omilatermoney") );
			int r_omipointmoney = Cvt.toInt( req.getParameter( "r_omipointmoney") );
			int r_omisavemoney = Cvt.toInt( req.getParameter( "r_omisavemoney") );
			int r_omivirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omivirtualaccountmoney") );
			int r_omiraccountmoney = Cvt.toInt( req.getParameter( "r_omiraccountmoney") );
			int r_omircardmoney = Cvt.toInt( req.getParameter( "r_omircardmoney") );
			int r_omircouponmoney = Cvt.toInt( req.getParameter( "r_omircouponmoney") );
			int r_omirlatermoney = Cvt.toInt( req.getParameter( "r_omirlatermoney") );
			int r_omirpointmoney = Cvt.toInt( req.getParameter( "r_omirpointmoney") );
			int r_omirsavemoney = Cvt.toInt( req.getParameter( "r_omirsavemoney") );
			int r_omirvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_omirvirtualaccountmoney") );
			int r_ominewsavemoney = Cvt.toInt( req.getParameter( "r_ominewsavemoney") );
			int r_omiorignalmoney = Cvt.toInt( req.getParameter( "r_omiorignalmoney") );
			int r_omitotorignalmoney = Cvt.toInt( req.getParameter( "r_omitotorignalmoney") );
			int r_omisalemoney = Cvt.toInt( req.getParameter( "r_omisalemoney") );
			int r_omitotsalemoney = Cvt.toInt( req.getParameter( "r_omitotsalemoney") );
			String r_omidelitype = Cvt.toStr( req.getParameter( "r_omidelitype") );
			String r_omidelimemo = Cvt.toStr( req.getParameter( "r_omidelimemo") );
			int r_omidelimoney = Cvt.toInt( req.getParameter( "r_omidelimoney") );
			String r_omidelinum = Cvt.toStr( req.getParameter( "r_omidelinum") );
			String r_omimemo = Cvt.toStr( req.getParameter( "r_omimemo") );
			int r_omipccseq = Cvt.toInt( req.getParameter( "r_omipccseq") );
			String r_omiescrowyn = Cvt.toStr( req.getParameter( "r_omiescrowyn") );
			String r_omipartcancelyn = Cvt.toStr( req.getParameter( "r_omipartcancelyn") );
			int r_omiea = Cvt.toInt( req.getParameter( "r_omiea") );
			int r_omioutea = Cvt.toInt( req.getParameter( "r_omioutea") );
			int r_omiinea = Cvt.toInt( req.getParameter( "r_omiinea") );
			String r_omistatus = Cvt.toStr( req.getParameter( "r_omistatus") );
			String r_omistep = Cvt.toStr( req.getParameter( "r_omistep") );
			String r_omitype = Cvt.toStr( req.getParameter( "r_omitype") );
			String r_omimoid = Cvt.toStr( req.getParameter( "r_omimoid") );
			String r_omiinid = Cvt.toStr( req.getParameter( "r_omiinid") );
//			Timestamp r_omimodate =  req.getParameter( "r_omimodate") );
//			Timestamp r_omiindate =  req.getParameter( "r_omiindate") );
			//---* param

			//---* dto setting
			Ordermainitem ordermainitem = new Ordermainitem();

			ordermainitem.setOMI_SEQ( r_omiseq );
			ordermainitem.setOMI_OMSEQ( r_omiomseq );
			ordermainitem.setOMI_PRSEQ( r_omiprseq );
			ordermainitem.setOMI_PROSEQ( r_omiproseq );
			ordermainitem.setOMI_PSWD( r_omipswd );
			ordermainitem.setOMI_MBID( r_omimbid );
			ordermainitem.setOMI_MBNAME( r_omimbname );
			ordermainitem.setOMI_PAYTYPE( r_omipaytype );
			ordermainitem.setOMI_ACCOUNTMONEY( r_omiaccountmoney );
			ordermainitem.setOMI_CARDMONEY( r_omicardmoney );
			ordermainitem.setOMI_COUPONMONEY( r_omicouponmoney );
			ordermainitem.setOMI_LATERMONEY( r_omilatermoney );
			ordermainitem.setOMI_POINTMONEY( r_omipointmoney );
			ordermainitem.setOMI_SAVEMONEY( r_omisavemoney );
			ordermainitem.setOMI_VIRTUALACCOUNTMONEY( r_omivirtualaccountmoney );
			ordermainitem.setOMI_RACCOUNTMONEY( r_omiraccountmoney );
			ordermainitem.setOMI_RCARDMONEY( r_omircardmoney );
			ordermainitem.setOMI_RCOUPONMONEY( r_omircouponmoney );
			ordermainitem.setOMI_RLATERMONEY( r_omirlatermoney );
			ordermainitem.setOMI_RPOINTMONEY( r_omirpointmoney );
			ordermainitem.setOMI_RSAVEMONEY( r_omirsavemoney );
			ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( r_omirvirtualaccountmoney );
			ordermainitem.setOMI_NEWSAVEMONEY( r_ominewsavemoney );
			ordermainitem.setOMI_ORIGNALMONEY( r_omiorignalmoney );
			ordermainitem.setOMI_TOTORIGNALMONEY( r_omitotorignalmoney );
			ordermainitem.setOMI_SALEMONEY( r_omisalemoney );
			ordermainitem.setOMI_TOTSALEMONEY( r_omitotsalemoney );
			ordermainitem.setOMI_DELITYPE( r_omidelitype );
			ordermainitem.setOMI_DELIMEMO( r_omidelimemo );
			ordermainitem.setOMI_DELIMONEY( r_omidelimoney );
			ordermainitem.setOMI_DELINUM( r_omidelinum );
			ordermainitem.setOMI_MEMO( r_omimemo );
			ordermainitem.setOMI_PCCSEQ( r_omipccseq );
			ordermainitem.setOMI_ESCROWYN( r_omiescrowyn );
			ordermainitem.setOMI_PARTCANCELYN( r_omipartcancelyn );
			ordermainitem.setOMI_EA( r_omiea );
			ordermainitem.setOMI_OUTEA( r_omioutea );
			ordermainitem.setOMI_INEA( r_omiinea );
			ordermainitem.setOMI_STATUS( r_omistatus );
			ordermainitem.setOMI_STEP( r_omistep );
			ordermainitem.setOMI_TYPE( r_omitype );
			ordermainitem.setOMI_MOID( r_omimoid );
			ordermainitem.setOMI_INID( r_omiinid );
//			ordermainitem.setOMI_MODATE( r_omimodate );
//			ordermainitem.setOMI_INDATE( r_omiindate );
			//--- dto setting

			//---* Dao
			OrdermainitemDao ordermainitemDao = new OrdermainitemDao( conn );
			ordermainitemDao.in( ordermainitem );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/ordermainitem/bo/ordermainitemview?r_omiseq="+r_omiseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}