package commontext.svc;

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
import commontext.dao.CommontextDao;
import commontext.dto.Commontext;

public class CommontextInBo implements Svc{

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
			int r_cmtseq = Cvt.toInt( req.getParameter( "r_cmtseq") );
			String r_cmtgroupcode = Cvt.toStr( req.getParameter( "r_cmtgroupcode") );
			String r_cmtcode = Cvt.toStr( req.getParameter( "r_cmtcode") );
			String r_cmtname = Cvt.toStr( req.getParameter( "r_cmtname") );
			String r_cmtvalue = Cvt.toStr( req.getParameter( "r_cmtvalue") );
			String r_cmtinid = Cvt.toStr( req.getParameter( "r_cmtinid") );
//			Timestamp r_cmtindate =  req.getParameter( "r_cmtindate") );
			//---* param

			//---* dto setting
			Commontext commontext = new Commontext();

			commontext.setCMT_SEQ( r_cmtseq );
			commontext.setCMT_GROUPCODE( r_cmtgroupcode );
			commontext.setCMT_CODE( r_cmtcode );
			commontext.setCMT_NAME( r_cmtname );
			commontext.setCMT_VALUE( r_cmtvalue );
			commontext.setCMT_INID( r_cmtinid );
//			commontext.setCMT_INDATE( r_cmtindate );
			//--- dto setting

			//---* Dao
			CommontextDao commontextDao = new CommontextDao( conn );
			commontextDao.in( commontext );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/commontext/bo/commontextview?r_cmtseq="+r_cmtseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}