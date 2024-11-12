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

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;
import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import board.dao.BoardDao;
import board.dto.Board;

public class BoardViewBo implements Svc{

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
			//--- sql variable

			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

			//---* param
			String r_bdid = Cvt.toStr( req.getParameter( "r_bdid" ) );

			//--- param

			//---* Dao
			BoardDao boardDao = new BoardDao( conn );
			wColNameList.add( " and BD_ID = ? " );
			wColValList.add( r_bdid );
			wColTypeList.add( "String" );
			Board board = boardDao.one( sqlMap );
			//--- Dao
			
			
			//---* 파일리스트
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "board" );
			wColTypeList.add( "String" );
			wColNameList.add( " and FLS_REFERID = ? " );
			wColValList.add( r_bdid+"" );
			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", "FLS_SEQ ASC" );
			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			//---파일리스트
			
			
			conn.commit();

			//---* model
			model.put( "board", board );
			model.put( "filestorageList", filestorageList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/board/bo/boardview" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}