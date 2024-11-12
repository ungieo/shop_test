package boardarticle.svc;

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
import boardarticle.dao.BoardarticleDao;

public class BoardarticleListDelBo implements Svc{

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
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			String r_bdaseqarr = Cvt.toStr( req.getParameter( "r_bdaseqarr" ) );
			//--- param

			//---* Dao
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			whereStr = " and BDA_SEQ in ( "+r_bdaseqarr+" ) ";
			boardarticleDao.del( whereStr );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/boardarticle/bo/boardarticlelist?r_page="+r_page );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}