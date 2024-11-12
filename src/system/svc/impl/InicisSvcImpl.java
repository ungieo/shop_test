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
import system.svc.PgSvc;
import system.util.Cvt;
import virtualmoney.dao.VirtualmoneyDao;
import virtualmoney.dto.Virtualmoney;

public class InicisSvcImpl implements PgSvc{

	Connection conn;
	HttpSession session;
	
	public InicisSvcImpl(Connection conn){ this.conn = conn; }

	@Override
	public boolean deliveryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean escrowIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean escrowUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pgUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
