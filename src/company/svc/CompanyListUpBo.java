package company.svc;

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
import company.dao.CompanyDao;
import company.dto.Company;

public class CompanyListUpBo implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			String r_cpseqarr = Cvt.toStr( req.getParameter( "r_cpseqarr" ) );
			String r_column = Cvt.toStr( req.getParameter( "r_column" ) );
			String r_columnvalue = Cvt.toStr( req.getParameter( "r_columnvalue" ) );
			//String r_columntype = Cvt.toStr( req.getParameter( "r_columntype" ) );
			//--- param

			//---* Dao
			CompanyDao companyDao = new CompanyDao( conn );
			whereStr = " and CP_SEQ in ( "+r_cpseqarr+" ) ";
			companyDao.upChoice( r_column, "'"+r_columnvalue+"'", whereStr );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/company/bo/companylist?r_page="+r_page );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}