package ordermainitemaddress.svc;

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
import ordermainitemaddress.dao.OrdermainitemaddressDao;
import ordermainitemaddress.dto.Ordermainitemaddress;

public class OrdermainitemaddressEditBo implements Svc{

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
			String r_omiaseq = Cvt.toStr( req.getParameter( "r_omiaseq" ) );
			//--- param

			//---* Dao
			OrdermainitemaddressDao ordermainitemaddressDao = new OrdermainitemaddressDao( conn );
			wColNameList.add( " and OMIA_SEQ = ? " );
			wColValList.add( r_omiaseq );
			wColTypeList.add( "int" );
			Ordermainitemaddress ordermainitemaddress = ordermainitemaddressDao.one( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "ordermainitemaddress", ordermainitemaddress );
			model.put( "returnType", "F" );
			model.put( "returnPage", "/ordermainitemaddress/bo/ordermainitemaddressedit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}