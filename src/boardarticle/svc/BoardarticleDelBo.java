package boardarticle.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import boardarticle.dao.BoardarticleDao;

public class BoardarticleDelBo implements Svc{

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

			String r_bdaseq = Cvt.toStr( req.getParameter( "r_bdaseq" ) );
			String r_bdabdid = Cvt.toStr( req.getParameter( "r_bdabdid" ) );
			String r_bdapswd = Cvt.toStr( req.getParameter( "r_bdapswd" ) );

			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			
			wColNameList.add( "and BDA_SEQ = ? " );
			wColValList.add( r_bdaseq+"" );
			wColTypeList.add( "int" );
			
			wColNameList.add( "and BDA_PSWD = ? " );
			wColValList.add( r_bdapswd+"" );
			wColTypeList.add( "String" );
			
//			orderStr = "";

			boardarticleDao.del(sqlMap);
			conn.commit();


			model.put( "returnType", "R" );
			model.put( "returnPage", "/boardarticle/bo/boardarticlelist?r_bdabdid="+r_bdabdid );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}