package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.dto.Member;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import company.dao.CompanyDao;
import companydepartment.dao.CompanydepartmentDao;

public class AdminMemberEditBo implements Svc{

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
			String r_mbid = Cvt.toStr( req.getParameter( "r_mbid" ) );
			//--- param

			//---* Dao
			MemberDao memberDao = new MemberDao( conn );
			wColNameList.add( " and MB_ID = ? " );
			wColValList.add( r_mbid );
			wColTypeList.add( "String" );
			Member member = memberDao.one( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			CompanyDao companyDao = new CompanyDao( conn );
			colNameList.add( "CP_ID" );
			colNameList.add( ", CP_NAME" );
			List<Map<String, Object>> companyList = companyDao.listChoice(sqlMap);
			
			colNameList.clear();
			CompanydepartmentDao companydepartmentDao = new CompanydepartmentDao( conn );
			colNameList.add( "CPD_ID" );
			colNameList.add( ", CPD_NAME" );
			wColNameList.add( " and CPD_CPID = ? " );
			wColValList.add( member.getMB_CPID() );
			wColTypeList.add( "String" );
			List<Map<String, Object>> companydepartmentList = companydepartmentDao.listChoice(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			//--- Dao
			conn.commit();

			//---* model
			model.put( "member", member );
			model.put( "companyList", companyList );
			model.put( "companydepartmentList", companydepartmentList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/member/bo/adminmemberedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}