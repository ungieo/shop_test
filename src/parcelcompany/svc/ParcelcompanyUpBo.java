package parcelcompany.svc;

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
import parcelcompany.dao.ParcelcompanyDao;
import parcelcompany.dto.Parcelcompany;

public class ParcelcompanyUpBo implements Svc{

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
			int r_pcseq = Cvt.toInt( req.getParameter( "r_pcseq") );
			String r_pcname = Cvt.toStr( req.getParameter( "r_pcname") );
			String r_pccpid = Cvt.toStr( req.getParameter( "r_pccpid") );
			String r_pcurl = Cvt.toStr( req.getParameter( "r_pcurl") );
			String r_pclevel = Cvt.toStr( req.getParameter( "r_pclevel") );
			String r_pctype = Cvt.toStr( req.getParameter( "r_pctype") );
			String r_pcuse = Cvt.toStr( req.getParameter( "r_pcuse") );
			String r_pcinid = Cvt.toStr( req.getParameter( "r_pcinid") );
//			Timestamp r_pcindate =  req.getParameter( "r_pcindate") );
			//--- param

			
			ParcelcompanyDao parcelcompanyDao = new ParcelcompanyDao( conn );
			wColNameList.add( " and PC_SEQ = ? " );
			wColValList.add( r_pcseq+"" );
			wColTypeList.add( "int" );
			Parcelcompany parcelcompany = parcelcompanyDao.one(sqlMap);
			//---* dto setting

//			parcelcompany.setPC_SEQ( r_pcseq );
			parcelcompany.setPC_NAME( r_pcname );
			parcelcompany.setPC_CPID( r_pccpid );
			parcelcompany.setPC_URL( r_pcurl );
			parcelcompany.setPC_LEVEL( r_pclevel );
			parcelcompany.setPC_TYPE( r_pctype );
			parcelcompany.setPC_USE( r_pcuse );
//			parcelcompany.setPC_INID( r_pcinid );
//			parcelcompany.setPC_INDATE(r_pcindate );
			//--- dto setting

			//---* Dao
			sqlMap.put( "parcelcompany", parcelcompany );
			
			wColNameList.add( " and PC_SEQ = ? " );
			wColValList.add( r_pcseq+"" );
			wColTypeList.add( "int" );

			parcelcompanyDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/parcelcompany/bo/parcelcompanylist" );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}