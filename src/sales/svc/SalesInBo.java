package sales.svc;

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
import sales.dao.SalesDao;
import sales.dto.Sales;

public class SalesInBo implements Svc{

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
			int r_slseq = Cvt.toInt( req.getParameter( "r_slseq") );
			int r_slomseq = Cvt.toInt( req.getParameter( "r_slomseq") );
			int r_slomiseq = Cvt.toInt( req.getParameter( "r_slomiseq") );
			String r_slcpidp = Cvt.toStr( req.getParameter( "r_slcpidp") );
			String r_slcpids = Cvt.toStr( req.getParameter( "r_slcpids") );
			String r_slmbid = Cvt.toStr( req.getParameter( "r_slmbid") );
			int r_slaccountmoney = Cvt.toInt( req.getParameter( "r_slaccountmoney") );
			int r_slcardmoney = Cvt.toInt( req.getParameter( "r_slcardmoney") );
			int r_slcouponmoney = Cvt.toInt( req.getParameter( "r_slcouponmoney") );
			int r_sllatermoney = Cvt.toInt( req.getParameter( "r_sllatermoney") );
			int r_slbudgetmoney = Cvt.toInt( req.getParameter( "r_slbudgetmoney") );
			int r_slvirtualmoney = Cvt.toInt( req.getParameter( "r_slvirtualmoney") );
			int r_slvirtualaccountmoney = Cvt.toInt( req.getParameter( "r_slvirtualaccountmoney") );
			int r_slorignalmoney = Cvt.toInt( req.getParameter( "r_slorignalmoney") );
			int r_slsalemoney = Cvt.toInt( req.getParameter( "r_slsalemoney") );
			String r_slccidb = Cvt.toStr( req.getParameter( "r_slccidb") );
			String r_slccids = Cvt.toStr( req.getParameter( "r_slccids") );
			String r_slccbhandlingyn = Cvt.toStr( req.getParameter( "r_slccbhandlingyn") );
			String r_slccshandlingyn = Cvt.toStr( req.getParameter( "r_slccshandlingyn") );
			String r_sltype = Cvt.toStr( req.getParameter( "r_sltype") );
			String r_slinid = Cvt.toStr( req.getParameter( "r_slinid") );
//			Timestamp r_slindate =  req.getParameter( "r_slindate") );
			//---* param

			//---* dto setting
			Sales sales = new Sales();

			sales.setSL_SEQ( r_slseq );
			sales.setSL_OMSEQ( r_slomseq );
			sales.setSL_OMISEQ( r_slomiseq );
			sales.setSL_CPIDP( r_slcpidp );
			sales.setSL_CPIDS( r_slcpids );
			sales.setSL_MBID( r_slmbid );
			sales.setSL_ACCOUNTMONEY( r_slaccountmoney );
			sales.setSL_CARDMONEY( r_slcardmoney );
			sales.setSL_COUPONMONEY( r_slcouponmoney );
			sales.setSL_LATERMONEY( r_sllatermoney );
			sales.setSL_BUDGETMONEY( r_slbudgetmoney );
			sales.setSL_VIRTUALMONEY( r_slvirtualmoney );
			sales.setSL_VIRTUALACCOUNTMONEY( r_slvirtualaccountmoney );
			sales.setSL_ORIGNALMONEY( r_slorignalmoney );
			sales.setSL_SALEMONEY( r_slsalemoney );
			sales.setSL_CCIDB( r_slccidb );
			sales.setSL_CCIDS( r_slccids );
			sales.setSL_CCBHANDLINGYN( r_slccbhandlingyn );
			sales.setSL_CCSHANDLINGYN( r_slccshandlingyn );
			sales.setSL_TYPE( r_sltype );
			sales.setSL_INID( r_slinid );
//			sales.setSL_INDATE( r_slindate );
			//--- dto setting

			//---* Dao
			SalesDao salesDao = new SalesDao( conn );
			salesDao.in( sales );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/sales/bo/salesview?r_slseq="+r_slseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}