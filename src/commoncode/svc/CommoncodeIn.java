package commoncode.svc;

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
import commoncode.dao.CommoncodeDao;
import commoncode.dto.Commoncode;

public class CommoncodeIn implements Svc{

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
			int r_cmcseq = Cvt.toInt( req.getParameter( "r_cmcseq") );
			String r_cmcgroupcode = Cvt.toStr( req.getParameter( "r_cmcgroupcode") );
			String r_cmccode = Cvt.toStr( req.getParameter( "r_cmccode") );
			String r_cmcname = Cvt.toStr( req.getParameter( "r_cmcname") );
			String r_cmcvalue = Cvt.toStr( req.getParameter( "r_cmcvalue") );
			String r_cmcuse = Cvt.toStr( req.getParameter( "r_cmcuse") );
			String r_cmcinid = Cvt.toStr( req.getParameter( "r_cmcinid") );
//			Timestamp r_cmcindate =  req.getParameter( "r_cmcindate") );
			//---* param

			//---* dto setting
			Commoncode commoncode = new Commoncode();

			commoncode.setCMC_SEQ( r_cmcseq );
			commoncode.setCMC_GROUPCODE( r_cmcgroupcode );
			commoncode.setCMC_CODE( r_cmccode );
			commoncode.setCMC_NAME( r_cmcname );
			commoncode.setCMC_VALUE( r_cmcvalue );
			commoncode.setCMC_USE( r_cmcuse );
			commoncode.setCMC_INID( r_cmcinid );
//			commoncode.setCMC_INDATE( r_cmcindate );
			//--- dto setting

			//---* Dao
			CommoncodeDao commoncodeDao = new CommoncodeDao( conn );
			commoncodeDao.in( commoncode );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/commoncode/commoncodeview?r_cmcseq="+r_cmcseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}