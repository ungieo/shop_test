package companydepartment.svc;

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
import companydepartment.dao.CompanydepartmentDao;
import companydepartment.dto.Companydepartment;

public class CompanydepartmentEditBo implements Svc{

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
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_cpdseq = Cvt.toStr( req.getParameter( "r_cpdseq" ) );
			//--- param

			//---* Dao
			CompanydepartmentDao companydepartmentDao = new CompanydepartmentDao( conn );
			wColNameList.add( " and CPD_SEQ = ? " );
			wColValList.add( r_cpdseq );
			wColTypeList.add( "int" );
			Companydepartment companydepartment = companydepartmentDao.one( sqlMap );
			//--- Dao

			CompanyDao companyDao = new CompanyDao( conn );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			colNameList.add( " CP_ID " );
			colNameList.add( ", CP_NAME " );
			List<Map<String, Object>> companyList = companyDao.listChoice(sqlMap);
			
			conn.commit();
			//---* model
			model.put( "companydepartment", companydepartment );
			model.put( "companyList", companyList );
			model.put( "returnType", "F" );
			model.put( "returnPage", "/companydepartment/bo/companydepartmentedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}