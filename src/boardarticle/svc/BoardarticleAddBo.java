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
import board.dao.BoardDao;
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;

public class BoardarticleAddBo implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );

			//---* param
			//--- param

			//---* Dao
//			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
//			wColNameList.add();
//			wColValList.add();
//			wColTypeList.add();
//			sqlMap.put( "orderStr", orderStr );

//			boardarticleDao.one( sqlMap );
			
			BoardDao boardDao = new BoardDao(conn);
			colNameList.add( "BD_ID" );
			colNameList.add( ", BD_NAME" );
			List<Map<String, Object>> boardList = boardDao.listChoice(sqlMap);			//그냥 string으로 colname을 전달하는게 더 간단....
			//--- Dao

			//---* model
			model.put( "boardList", boardList );
			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/bo/boardarticleadd" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}