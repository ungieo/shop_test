package system.svc;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrderHandlingSvc{

	public boolean deliveryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean escrowIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean escrowUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	
	public boolean omCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omStatusUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omHistoryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	
	public boolean omiCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiStatusUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiHistoryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean omiPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	
	public boolean salesIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean salesDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean stockUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean virtualMoneyIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	

}
