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
import system.util.Pageing;
import board.dao.BoardDao;
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;

public class BoardarticleListBo implements Svc{

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

			//---*param
//			String r_bdabdid = Cvt.toStr( req.getParameter( "r_bdabdid" ) );
			
			String sc_column = Cvt.toStr( req.getParameter( "sc_column" ) );
			String sc_word = Cvt.toStr( req.getParameter( "sc_word" ) );
			String sc_bdabdid = Cvt.toStr( req.getParameter( "sc_bdabdid" ) );
			String sc_bdaindates = Cvt.toStr( req.getParameter( "sc_bdaindates" ) );
			String sc_bdaindatee = Cvt.toStr( req.getParameter( "sc_bdaindatee" ) );
			String sc_bdause = Cvt.toStr( req.getParameter( "sc_bdause" ) );
			
			//---param

			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
//			if( !r_bdabdid.isEmpty() ){
//				wColNameList.add( " and BDA_BDID = ? " );
//				wColValList.add( r_bdabdid );
//				wColTypeList.add( "String" );
//			}
			
			if( !"".equals( sc_column ) ){
				wColNameList.add( " and " +sc_column + " like ? " );
				wColValList.add( "%"+sc_word+"%" );
				wColTypeList.add( "String" );
			}
			
			if( !"".equals( sc_bdabdid ) ){
				wColNameList.add( " and BDA_BDID = ? " );
				wColValList.add( sc_bdabdid );
				wColTypeList.add( "String" );
			}
			if( !"".equals( sc_bdaindates ) ){
				wColNameList.add( " and date_format( BDA_INDATE,'%Y%m%d' ) >= ? " );
				wColValList.add( sc_bdaindates.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_bdaindatee ) ){
				wColNameList.add( " and date_format( BDA_INDATE,'%Y%m%d' ) <= ? " );
				wColValList.add( sc_bdaindatee.replaceAll( "-", "" ) );
				wColTypeList.add( "int" );
			}
			if( !"".equals( sc_bdause ) ){
				wColNameList.add( " and BDA_USE = ? " );
				wColValList.add( sc_bdause );
				wColTypeList.add( "String" );
			}
			
			orderStr = " bda_groupnum desc, bda_stepnum asc ";
			sqlMap.put( "orderStr", orderStr );

			int totCnt = boardarticleDao.cnt( sqlMap );
			List<Boardarticle> boardarticleList = boardarticleDao.list( r_page, r_rowlimit, sqlMap );
			wColNameList.clear(); wColValList.clear(); wColTypeList.clear();
			
			//---*search boardList
			BoardDao boardDao = new BoardDao( conn );
			colNameList.add( " BD_ID, " );
			colNameList.add( " BD_NAME " );
			sqlMap.put( "orderStr", "" );
			List<Map<String, Object>> scBoardList = boardDao.listChoice(sqlMap);
			//---search boardList
			
			conn.commit();


			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );

			model.put( "totCnt", totCnt );
			model.put( "r_page", r_page );
			model.put( "r_pagelimit", r_pagelimit );
			model.put( "r_rowlimit", r_rowlimit );
			model.put( "boardarticleList", boardarticleList );
			
			model.put( "scBoardList", scBoardList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/boardarticle/bo/boardarticlelist" );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}