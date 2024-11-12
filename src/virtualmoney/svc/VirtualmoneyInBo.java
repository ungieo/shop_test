package virtualmoney.svc;

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
import system. db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import virtualmoney.dao.VirtualmoneyDao;
import virtualmoney.dto.Virtualmoney;

public class VirtualmoneyInBo implements Svc{

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
			int r_vtmseq = Cvt.toInt( req.getParameter( "r_vtmseq") );
			String r_vtmmbid = Cvt.toStr( req.getParameter( "r_vtmmbid") );
			String r_vtmdescription = Cvt.toStr( req.getParameter( "r_vtmdescription") );
			int r_vtmomseq = Cvt.toInt( req.getParameter( "r_vtmomseq") );
			int r_vtmomiseq = Cvt.toInt( req.getParameter( "r_vtmomiseq") );
			int r_vtmmoney = Cvt.toInt( req.getParameter( "r_vtmmoney") );
			String r_vtnusetype = Cvt.toStr( req.getParameter( "r_vtnusetype") );
			String r_vtmtype = Cvt.toStr( req.getParameter( "r_vtmtype") );
			String r_vtmuse = Cvt.toStr( req.getParameter( "r_vtmuse") );
			String r_vtminid = Cvt.toStr( req.getParameter( "r_vtminid") );
//			Timestamp r_vtmindate =  req.getParameter( "r_vtmindate") );
			//---* param

			//---* dto setting
			Virtualmoney virtualmoney = new Virtualmoney();

			virtualmoney.setVTM_SEQ( r_vtmseq );
			virtualmoney.setVTM_MBID( r_vtmmbid );
			virtualmoney.setVTM_DESCRIPTION( r_vtmdescription );
			virtualmoney.setVTM_OMSEQ( r_vtmomseq );
			virtualmoney.setVTM_OMISEQ( r_vtmomiseq );
			virtualmoney.setVTM_MONEY( r_vtmmoney );
			virtualmoney.setVTN_USETYPE( r_vtnusetype );
			virtualmoney.setVTM_TYPE( r_vtmtype );
			virtualmoney.setVTM_USE( r_vtmuse );
			virtualmoney.setVTM_INID( r_vtminid );
//			virtualmoney.setVTM_INDATE( r_vtmindate );
			//--- dto setting

			//---* Dao
			VirtualmoneyDao virtualmoneyDao = new VirtualmoneyDao( conn );
			virtualmoneyDao.in( virtualmoney );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/virtualmoney/bo/virtualmoneyview?r_vtmseq="+r_vtmseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}