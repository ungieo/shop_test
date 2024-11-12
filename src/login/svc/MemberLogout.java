package login.svc;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;

public class MemberLogout implements Svc{

	Connection conn;

	@Override
	public void handling( HttpServletRequest req, HttpServletResponse res, Map<String, Object> model ){

		try{

			DbConn dbConn = new MysqlDbConnImpl();
			conn = dbConn.getConnection();

			HttpSession session = req.getSession();

//			String ss_mbtype = Cvt.toStr( session.getAttribute("ss_mbtype" ) );
			session.invalidate();

			String cPath = req.getContextPath();
			model.put( "returnType", "R" );
			model.put( "returnPage", cPath+"/index" );
			
//			model.put( "returnType", "F" );
//			model.put( "returnPage", "/login/logout" );
			return;

		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}