package system.svc.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ordermain.dao.OrdermainDao;
import ordermain.dto.Ordermain;
import ordermainhistory.dao.OrdermainhistoryDao;
import ordermainhistory.dto.Ordermainhistory;
import sales.dao.SalesDao;
import sales.dto.Sales;
import system.svc.OrderHandlingSvc;
import system.util.Cvt;
import virtualmoney.dao.VirtualmoneyDao;
import virtualmoney.dto.Virtualmoney;

public class OrderHandlingSvcImpl implements OrderHandlingSvc{

	Connection conn;
	HttpSession session;
	
	public OrderHandlingSvcImpl(Connection conn){ this.conn = conn; }
	
	@Override
	public boolean deliveryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		
		
		
		return result;
	}
	
	@Override
	public boolean escrowIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}

	@Override
	public boolean escrowUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}
	
	@Override
	public boolean omCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public boolean omIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		
		return false;
	}

	@Override
	public boolean omStatusUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException{
		
		boolean result = true;
		
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
		
		
		String r_omstatus = Cvt.toStr( req.getParameter( "r_omstatus" ) );
		
		Ordermain ordermain = (Ordermain)svcMap.get( "ordermain" );
		
		OrdermainDao ordermainDao = new OrdermainDao( conn );
		colNameList.add( " OM_STATUS = ? " );
		colValList.add( r_omstatus );
		colTypeList.add( "String" );

		wColNameList.add( " AND OM_SEQ =  ? " );
		wColValList.add( ordermain.getOM_SEQ()+"" );
		wColTypeList.add( "int" );
		ordermainDao.upChoice(sqlMap);
		
		return result;
	}

	@Override
	public boolean omHistoryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException{
		boolean result = true;
		
		session = (HttpSession)req.getSession();
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

		String r_omstatus = Cvt.toStr( req.getParameter( "r_omstatus" ) );
		
		Ordermain ordermain = (Ordermain)svcMap.get( "ordermain" );
		
		Ordermainhistory ordermainhistory = new Ordermainhistory();

		ordermainhistory.setOMH_OMSEQ( ordermain.getOM_SEQ() );
		ordermainhistory.setOMH_OMSTATUS( r_omstatus );
		ordermainhistory.setOMH_MEMO( "" );
		ordermainhistory.setOMH_TYPE( "" );
		ordermainhistory.setOMH_INID( ss_mbid );
		//--- dto setting

		//---* Dao
		OrdermainhistoryDao ordermainhistoryDao = new OrdermainhistoryDao( conn );
		ordermainhistoryDao.in( ordermainhistory );
		
		return result;
	}
	
	@Override
	public boolean omUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap)throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omiStatusUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}

	@Override
	public boolean omiHistoryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}
	
	@Override
	public boolean salesIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException{
		boolean result = true;
		
		session = (HttpSession)req.getSession();
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

		Ordermain ordermain = (Ordermain)svcMap.get( "ordermain" );
		//---* dto setting
		Sales sales = new Sales();

//		sales.setSL_SEQ( r_slseq );
		sales.setSL_OMSEQ( ordermain.getOM_SEQ() );
		sales.setSL_OMISEQ( 0 );
		sales.setSL_CPIDP( ordermain.getOM_CPIDP() );
		sales.setSL_CPIDS( ordermain.getOM_CPIDS() );
		sales.setSL_MBID( ordermain.getOM_MBID() );
		sales.setSL_ACCOUNTMONEY( ordermain.getOM_ACCOUNTMONEY() );
		sales.setSL_CARDMONEY( ordermain.getOM_CARDMONEY() );
		sales.setSL_COUPONMONEY( ordermain.getOM_COUPONMONEY() );
		sales.setSL_LATERMONEY( ordermain.getOM_LATERMONEY() );
		sales.setSL_BUDGETMONEY( ordermain.getOM_BUDGETMONEY() );
		sales.setSL_VIRTUALMONEY( ordermain.getOM_VIRTUALMONEY() );
		sales.setSL_VIRTUALACCOUNTMONEY( ordermain.getOM_VIRTUALACCOUNTMONEY() );
		sales.setSL_ORIGNALMONEY( ordermain.getOM_ORIGNALMONEY() );
		sales.setSL_SALEMONEY( ordermain.getOM_SALEMONEY() );
		sales.setSL_CCIDB( "" );
		sales.setSL_CCIDS( "" );
		sales.setSL_CCBHANDLINGYN( "N" );
		sales.setSL_CCSHANDLINGYN( "N" );
		sales.setSL_TYPE( "1" );
		sales.setSL_INID( ss_mbid );
//		sales.setSL_INDATE( r_slindate );
		//--- dto setting

		//---* Dao
		SalesDao salesDao = new SalesDao( conn );
		salesDao.in( sales );
		
		return result;
	}

	@Override
	public boolean salesDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}

	@Override
	public boolean stockUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) {
		boolean result = true;
		return result;
	}
	
	@Override
	public boolean virtualMoneyIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException{
		
		boolean result = true;
		
		
		session = (HttpSession)req.getSession();
		String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

		Ordermain ordermain = (Ordermain)svcMap.get( "ordermain" );
		
		if( 0 < ordermain.getOM_NEWVIRTUALMONEY() ){
			//---* dto setting
			Virtualmoney virtualmoney = new Virtualmoney();
	
	//		virtualmoney.setVTM_SEQ( r_vtmseq );
			virtualmoney.setVTM_MBID( ordermain.getOM_MBID() );
			virtualmoney.setVTM_DESCRIPTION( "구매확정 적립급" );
			virtualmoney.setVTM_OMSEQ( ordermain.getOM_SEQ() );
			virtualmoney.setVTM_OMISEQ(0);
			virtualmoney.setVTM_MONEY( ordermain.getOM_NEWVIRTUALMONEY() );
			virtualmoney.setVTN_USETYPE( "1" );
			virtualmoney.setVTM_TYPE( "1" );
			virtualmoney.setVTM_USE( "" );
			virtualmoney.setVTM_INID( ss_mbid );
			//--- dto setting
	
			//---* Dao
			VirtualmoneyDao virtualmoneyDao = new VirtualmoneyDao( conn );
			virtualmoneyDao.in( virtualmoney );
			//--- Dao
		}
		
		return result;
	}

	@Override
	public boolean omiCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omiDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omiIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omiUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean omiPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
