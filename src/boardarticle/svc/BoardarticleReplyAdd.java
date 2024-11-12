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
import board.dao.BoardDao;
import board.dto.Board;
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;

public class BoardarticleReplyAdd implements Svc{

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

			String r_bdabdid = Cvt.toStr( req.getParameter( "r_bdabdid" ) );
			String r_bdaseq = Cvt.toStr( req.getParameter( "r_bdaseq" ) );
			
			
			//---boardarticleDao
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			wColNameList.add( " and BDA_SEQ = ? " );
			wColValList.add( r_bdaseq );
			wColTypeList.add( "int" );
			sqlMap.put( "orderStr", orderStr );
			
			Boardarticle boardarticle = boardarticleDao.one( sqlMap );
			//---Dao
			
			//---* boardDao가져와서 설정 처리
			BoardDao boardDao = new BoardDao(conn);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			wColNameList.add( " and BD_ID = ? ");
			wColValList.add( boardarticle.getBDA_BDID() );
			wColTypeList.add( "String" );

			Board board = boardDao.one( sqlMap );
			//--- 
			
			
			model.put( "boardarticle", boardarticle );
			model.put( "board", board );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/boardarticlereplyadd" );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}