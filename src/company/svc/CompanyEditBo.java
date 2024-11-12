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
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class CompanyEditBo implements Svc{

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
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
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
			String r_cpseq = Cvt.toStr( req.getParameter( "r_cpseq" ) );
			//--- param

			//---* Dao
			CompanyDao companyDao = new CompanyDao( conn );
			wColNameList.add( " and CP_SEQ = ? " );
			wColValList.add( r_cpseq );
			wColTypeList.add( "int" );
			Company company = companyDao.one( sqlMap );
			
			//--- Dao
			
			//---* 파일리스트
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "company" );
			wColTypeList.add( "String" );
			wColNameList.add( " and FLS_REFERID = ? " );
			wColValList.add( r_cpseq+"" );
			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", "FLS_SEQ ASC" );
			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			//---파일리스트
			

			conn.commit();
			//---* model
			model.put( "company", company );
			model.put( "filestorageList", filestorageList );
			model.put( "returnType", "F" );
			model.put( "returnPage", "/company/bo/companyedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}