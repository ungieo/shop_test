package productwish.svc;

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
import productwish.dao.ProductwishDao;
import productwish.dto.Productwish;

public class ProductwishUpBo implements Svc{

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
			int r_prwseq = Cvt.toInt( req.getParameter( "r_prwseq") );
			int r_prwprseq = Cvt.toInt( req.getParameter( "r_prwprseq") );
			int r_prwproseq = Cvt.toInt( req.getParameter( "r_prwproseq") );
			String r_prwmbid = Cvt.toStr( req.getParameter( "r_prwmbid") );
			String r_prwlevel = Cvt.toStr( req.getParameter( "r_prwlevel") );
			String r_prwtype = Cvt.toStr( req.getParameter( "r_prwtype") );
			String r_prwuse = Cvt.toStr( req.getParameter( "r_prwuse") );
			String r_prwmoid = Cvt.toStr( req.getParameter( "r_prwmoid") );
			String r_prwinid = Cvt.toStr( req.getParameter( "r_prwinid") );
//			Timestamp r_prwmodate =  req.getParameter( "r_prwmodate") );
//			Timestamp r_prwindate =  req.getParameter( "r_prwindate") );
			//--- param

			//---* dto setting
			Productwish productwish = new Productwish();

			productwish.setPRW_SEQ( r_prwseq );
			productwish.setPRW_PRSEQ( r_prwprseq );
			productwish.setPRW_PROSEQ( r_prwproseq );
			productwish.setPRW_MBID( r_prwmbid );
			productwish.setPRW_LEVEL( r_prwlevel );
			productwish.setPRW_TYPE( r_prwtype );
			productwish.setPRW_USE( r_prwuse );
			productwish.setPRW_MOID( r_prwmoid );
			productwish.setPRW_INID( r_prwinid );
//			productwish.setPRW_MODATE(r_prwmodate );
//			productwish.setPRW_INDATE(r_prwindate );
			//--- dto setting

			//---* Dao
			ProductwishDao productwishDao = new ProductwishDao( conn );
			wColNameList.add( " and PRW_SEQ = ? " );
			wColValList.add( r_prwseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			productwishDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/productwish/bo/productwishview?r_prwseq="+r_prwseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}