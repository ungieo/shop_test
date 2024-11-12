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
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class BoardarticleEditBo implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			String r_bdaseq = Cvt.toStr( req.getParameter( "r_bdaseq" ) );
			
			
			//---boardarticle one
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			wColNameList.add( " and BDA_SEQ = ? " );
			wColValList.add( r_bdaseq );
			wColTypeList.add( "int" );

			Boardarticle boardarticle = boardarticleDao.one( sqlMap );
			//---boardarticle one
			
			//---boardList
			BoardDao boardDao = new BoardDao( conn );
			wColNameList.clear(); wColValList.clear(); wColTypeList.clear();
			colNameList.add( "BD_ID" );
			colNameList.add( ", BD_NAME" );
			List<Map<String, Object>> boardList = boardDao.listChoice(sqlMap);			//그냥 string으로 colname을 전달하는게 더 간단....
			//---boardList
			
			//---*filestorageList
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
			//---filestorageList
			
			model.put( "boardarticle", boardarticle );
			model.put( "boardList", boardList );
			model.put( "filestorageList", filestorageList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/bo/boardarticleedit" );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}