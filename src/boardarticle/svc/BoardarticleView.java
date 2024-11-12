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
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class BoardarticleView implements Svc{

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

			String r_bdabdid = Cvt.toStr( req.getParameter( "r_bdabdid" ) );
			String r_bdaseq = Cvt.toStr( req.getParameter( "r_bdaseq" ) );

			//---*게시판 가져오기
			BoardDao boardDao = new BoardDao(conn);
			wColNameList.add( " and BD_ID = ? " );
			wColValList.add( r_bdabdid );
			wColTypeList.add( "String" );
			Board board = boardDao.one(sqlMap);
			//---게시판 가져오기

			//---*선택 글 가져오기
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and BDA_SEQ = ? " );
			wColValList.add( r_bdaseq );
			wColTypeList.add( "int" );
			
			boardarticleDao.upChoice( "BDA_READCNT", "BDA_READCNT+1", " and BDA_SEQ="+r_bdaseq );
			
			Boardarticle boardarticle = boardarticleDao.one( sqlMap );
			//---선택 글 가져오기
			
			//---* 파일리스트
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "boardarticle" );
			wColTypeList.add( "String" );
			wColNameList.add( " and FLS_REFERID = ? " );
			wColValList.add( r_bdaseq+"" );
			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", "FLS_SEQ ASC" );
			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			//---파일리스트
			
			conn.commit();


			model.put( "board", board );
			model.put( "boardarticle", boardarticle );
			model.put( "filestorageList", filestorageList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/boardarticleview" );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}