package company.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import company.dao.CompanyDao;
import company.dto.Company;

public class CompanyListBo implements Svc{

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
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );
			
			String sc_column = Cvt.toStr( req.getParameter( "sc_column" ) );
			String sc_word = Cvt.toStr( req.getParameter( "sc_word" ) );
			String sc_cptype = Cvt.toStr( req.getParameter( "sc_cptype" ) );
			String sc_cpindates = Cvt.toStr( req.getParameter( "sc_cpindates" ) );
			String sc_cpindatee = Cvt.toStr( req.getParameter( "sc_cpindatee" ) );
			String sc_cpuse = Cvt.toStr( req.getParameter( "sc_cpuse" ) );

			//--- param

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			//---* Dao
			CompanyDao companyDao = new CompanyDao( conn );
			
			if( !"".equals( sc_column ) ){
				wColNameList.add( "and "+sc_column+" like ? ");
				wColValList.add( "%"+sc_word+"%" );
				wColTypeList.add( "String" );				
			}
			if( !"".equals( sc_cptype ) ){
				wColNameList.add( "and CP_TYPE = ? ");
				wColValList.add( sc_cptype );
				wColTypeList.add( "String" );
			}
			if( !"".equals( sc_cpindates ) ){
				wColNameList.add( " and date_format( CP_INDATE,'%Y%m%d' ) >= ? " );
				wColValList.add( sc_cpindates.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_cpindatee ) ){
				wColNameList.add( " and date_format( CP_INDATE,'%Y%m%d' ) <= ? " );
				wColValList.add( sc_cpindatee.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_cpuse ) ){
				wColNameList.add( " and CP_USE = ? " );
				wColValList.add( sc_cpuse );
				wColTypeList.add( "String" );
			}
			
			
			sqlMap.put( "orderStr", orderStr );

			int totCnt = companyDao.cnt( sqlMap );
			List<Company> companyList = companyDao.list( r_page, r_rowlimit, sqlMap );
			conn.commit();
			//--- Dao

			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );

			//---* model
			model.put( "totCnt", totCnt );
			model.put( "r_page", r_page );
			model.put( "r_pagelimit", r_pagelimit );
			model.put( "r_rowlimit", r_rowlimit );
			model.put( "companyList", companyList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/company/bo/companylist" );

			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}