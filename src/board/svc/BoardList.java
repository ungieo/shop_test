package board.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import board.dao.BoardDao;
import board.dto.Board;

public class BoardList implements Svc{

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
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );

			//--- param

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			//---* Dao
			BoardDao boardDao = new BoardDao( conn );
//			wColNameList.add();
//			wColValList.add();
//			wColTypeList.add();
			sqlMap.put( "orderStr", orderStr );

			int totCnt = boardDao.cnt( sqlMap );
			List<Board> boardList = boardDao.list( r_page, r_rowlimit, sqlMap );
			conn.commit();
			//--- Dao

			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );

			//---* model
			model.put( "totCnt", totCnt );
			model.put( "r_page", r_page );
			model.put( "r_pagelimit", r_pagelimit );
			model.put( "r_rowlimit", r_rowlimit );
			model.put( "boardList", boardList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/board/boardlist" );

			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}