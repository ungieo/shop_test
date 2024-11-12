package system.svc;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PgSvc{

	public boolean deliveryIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean escrowIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean escrowUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	
	public boolean pgCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean pgDel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean pgIn(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean pgPartCancel(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	public boolean pgUp(HttpServletRequest req, HttpServletResponse res, Map<String, Object> svcMap) throws SQLException;
	
	

}
