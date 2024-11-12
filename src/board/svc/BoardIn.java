package board.svc;

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
import board.dao.BoardDao;
import board.dto.Board;

public class BoardIn implements Svc{

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
			String r_bdid = Cvt.toStr( req.getParameter( "r_bdid") );
			String r_bdname = Cvt.toStr( req.getParameter( "r_bdname") );
			String r_bdcommentuse = Cvt.toStr( req.getParameter( "r_bdcommentuse") );
			String r_bddescription = Cvt.toStr( req.getParameter( "r_bddescription") );
			int r_bdfilemaxsize = Cvt.toInt( req.getParameter( "r_bdfilemaxsize") );
			String r_bdfileuse = Cvt.toStr( req.getParameter( "r_bdfileuse") );
			String r_bdadduse = Cvt.toStr( req.getParameter( "r_bdadduse") );
			String r_bddeluse = Cvt.toStr( req.getParameter( "r_bddeluse") );
			String r_bdedituse = Cvt.toStr( req.getParameter( "r_bdedituse") );
			String r_bdimage = Cvt.toStr( req.getParameter( "r_bdimage") );
			String r_bdip = Cvt.toStr( req.getParameter( "r_bdip") );
			String r_bdipuse = Cvt.toStr( req.getParameter( "r_bdipuse") );
			String r_bdpswduse = Cvt.toStr( req.getParameter( "r_bdpswduse") );
			String r_bdreplyuse = Cvt.toStr( req.getParameter( "r_bdreplyuse") );
			String r_bdsorttype = Cvt.toStr( req.getParameter( "r_bdsorttype") );
			String r_bdviewtype = Cvt.toStr( req.getParameter( "r_bdviewtype") );
			String r_bdlevel = Cvt.toStr( req.getParameter( "r_bdlevel") );
			String r_bdtype = Cvt.toStr( req.getParameter( "r_bdtype") );
			String r_bduse = Cvt.toStr( req.getParameter( "r_bduse") );
			String r_bdmoid = Cvt.toStr( req.getParameter( "r_bdmoid") );
			String r_bdinid = Cvt.toStr( req.getParameter( "r_bdinid") );
//			Timestamp r_bdmodate =  req.getParameter( "r_bdmodate") );
//			Timestamp r_bdindate =  req.getParameter( "r_bdindate") );
			//---* param

			//---* dto setting
			Board board = new Board();

			board.setBD_ID( r_bdid );
			board.setBD_NAME( r_bdname );
			board.setBD_COMMENTUSE( r_bdcommentuse );
			board.setBD_DESCRIPTION( r_bddescription );
			board.setBD_FILEMAXSIZE( r_bdfilemaxsize );
			board.setBD_FILEUSE( r_bdfileuse );
			board.setBD_ADDUSE( r_bdadduse );
			board.setBD_DELUSE( r_bddeluse );
			board.setBD_EDITUSE( r_bdedituse );
			board.setBD_IMAGE( r_bdimage );
			board.setBD_IP( r_bdip );
			board.setBD_IPUSE( r_bdipuse );
			board.setBD_PSWDUSE( r_bdpswduse );
			board.setBD_REPLYUSE( r_bdreplyuse );
			board.setBD_SORTTYPE( r_bdsorttype );
			board.setBD_VIEWTYPE( r_bdviewtype );
			board.setBD_LEVEL( r_bdlevel );
			board.setBD_TYPE( r_bdtype );
			board.setBD_USE( r_bduse );
			board.setBD_MOID( r_bdmoid );
			board.setBD_INID( r_bdinid );
//			board.setBD_MODATE( r_bdmodate );
//			board.setBD_INDATE( r_bdindate );
			//--- dto setting

			//---* Dao
			BoardDao boardDao = new BoardDao( conn );
			boardDao.in( board );
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/board/boardview?r_bdid="+r_bdid );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}