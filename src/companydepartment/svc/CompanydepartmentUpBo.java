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
import companydepartment.dao.CompanydepartmentDao;
import companydepartment.dto.Companydepartment;

public class CompanydepartmentUpBo implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_cpdseq = Cvt.toInt( req.getParameter( "r_cpdseq") );
			String r_cpdcpid = Cvt.toStr( req.getParameter( "r_cpdcpid") );
			String r_cpdid = Cvt.toStr( req.getParameter( "r_cpdid") );
			String r_cpdname = Cvt.toStr( req.getParameter( "r_cpdname") );
			String r_cpdpaytype = Cvt.toStr( req.getParameter( "r_cpdpaytype") );
			String r_cpdemail = Cvt.toStr( req.getParameter( "r_cpdemail") );
			String r_cpdtel = Cvt.toStr( req.getParameter( "r_cpdtel") );
			String r_cpdphone = Cvt.toStr( req.getParameter( "r_cpdphone") );
			String r_cpdfax = Cvt.toStr( req.getParameter( "r_cpdfax") );
			String r_cpdlevel = Cvt.toStr( req.getParameter( "r_cpdlevel") );
			String r_cpdtype = Cvt.toStr( req.getParameter( "r_cpdtype") );
			String r_cpduse = Cvt.toStr( req.getParameter( "r_cpduse") );
			String r_cpdmoid = Cvt.toStr( req.getParameter( "r_cpdmoid") );
			String r_cpdinid = Cvt.toStr( req.getParameter( "r_cpdinid") );
//			Timestamp r_cpdmodate =  req.getParameter( "r_cpdmodate") );
//			Timestamp r_cpdindate =  req.getParameter( "r_cpdindate") );
			//--- param

			//---* dto setting
			Companydepartment companydepartment = new Companydepartment();

			companydepartment.setCPD_SEQ( r_cpdseq );
			companydepartment.setCPD_CPID( r_cpdcpid );
			companydepartment.setCPD_ID( r_cpdid );
			companydepartment.setCPD_NAME( r_cpdname );
			companydepartment.setCPD_PAYTYPE( r_cpdpaytype );
			companydepartment.setCPD_EMAIL( r_cpdemail );
			companydepartment.setCPD_TEL( r_cpdtel );
			companydepartment.setCPD_PHONE( r_cpdphone );
			companydepartment.setCPD_FAX( r_cpdfax );
			companydepartment.setCPD_LEVEL( r_cpdlevel );
			companydepartment.setCPD_TYPE( r_cpdtype );
			companydepartment.setCPD_USE( r_cpduse );
			companydepartment.setCPD_MOID( r_cpdmoid );
			companydepartment.setCPD_INID( r_cpdinid );
//			companydepartment.setCPD_MODATE(r_cpdmodate );
//			companydepartment.setCPD_INDATE(r_cpdindate );
			//--- dto setting

			//---* Dao
			CompanydepartmentDao companydepartmentDao = new CompanydepartmentDao( conn );
			wColNameList.add( " and CPD_SEQ = ? " );
			wColValList.add( r_cpdseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			companydepartmentDao.up( sqlMap );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/companydepartment/bo/companydepartmentview?r_cpdseq="+r_cpdseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}