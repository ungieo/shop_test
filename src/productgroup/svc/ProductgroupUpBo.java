package productgroup.svc;

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
import productgroup.dao.ProductgroupDao;
import productgroup.dto.Productgroup;

public class ProductgroupUpBo implements Svc{

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
			int r_prgseq = Cvt.toInt( req.getParameter( "r_prgseq") );
			int r_prgprgseq = Cvt.toInt( req.getParameter( "r_prgprgseq") );
			int r_prgprseq = Cvt.toInt( req.getParameter( "r_prgprseq") );
			String r_prgtype = Cvt.toStr( req.getParameter( "r_prgtype") );
			String r_prguse = Cvt.toStr( req.getParameter( "r_prguse") );
			String r_prginid = Cvt.toStr( req.getParameter( "r_prginid") );
//			Timestamp r_prgindate =  req.getParameter( "r_prgindate") );
			//--- param

			//---* dto setting
			Productgroup productgroup = new Productgroup();

			productgroup.setPRG_SEQ( r_prgseq );
			productgroup.setPRG_PRGSEQ( r_prgprgseq );
			productgroup.setPRG_PRSEQ( r_prgprseq );
			productgroup.setPRG_TYPE( r_prgtype );
			productgroup.setPRG_USE( r_prguse );
			productgroup.setPRG_INID( r_prginid );
//			productgroup.setPRG_INDATE(r_prgindate );
			//--- dto setting

			//---* Dao
			ProductgroupDao productgroupDao = new ProductgroupDao( conn );
			wColNameList.add( " and PRG_SEQ = ? " );
			wColValList.add( r_prgseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );

			productgroupDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/productgroup/bo/productgroupview?r_prgseq="+r_prgseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}