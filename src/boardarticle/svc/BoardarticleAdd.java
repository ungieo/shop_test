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
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import board.dao.BoardDao;
import board.dto.Board;

public class BoardarticleAdd implements Svc{

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

			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

			//---* param
			String r_bdabdid = Cvt.toStr( req.getParameter( "r_bdabdid" ) );
			//--- param

			//---* Dao
			if( r_bdabdid.isEmpty() ){
				throw new Exception( "r_bdabdid is null" );
			}
			
			BoardDao boardDao = new BoardDao(conn);
			
			wColNameList.add( " and BD_ID = ? ");
			wColValList.add( r_bdabdid );
			wColTypeList.add( "String" );

			Board board = boardDao.one( sqlMap );
			//--- Dao

			//---* model
			model.put( "board", board);
			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/boardarticleadd" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}