package board.svc;

import java.io.IOException;
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
import system.file.svc.FileSvc;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import board.dao.BoardDao;
import board.dto.Board;

import com.oreilly.servlet.MultipartRequest;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class BoardUpBo implements Svc{

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
			
			
			//---* 파일저장
			FileSvc fileSvc = new FileSvcImpl();
			Map<String,Object> fileMap = new HashMap<String, Object>();
			fileMap.put( "filePath", "/up/temp" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();
			
			MultipartRequest mtptReq = (MultipartRequest)fileMap.get("mtptReq");
			List<String> fileNameList = (List<String>)fileMap.get("fileNameList");
			//--- 파일저장 
			

			//---* param
			String r_bdid = Cvt.toStr( mtptReq.getParameter( "r_bdid") );
			String r_bdname = Cvt.toStr( mtptReq.getParameter( "r_bdname") );
			String r_bdcommentuse = Cvt.toStr( mtptReq.getParameter( "r_bdcommentuse") );
			String r_bdsecretuse = Cvt.toStr( mtptReq.getParameter( "r_bdsecretuse") );
			String r_bddescription = Cvt.toStr( mtptReq.getParameter( "r_bddescription") );
			int r_bdfilemaxsize = Cvt.toInt( mtptReq.getParameter( "r_bdfilemaxsize") );
			String r_bdfileuse = Cvt.toStr( mtptReq.getParameter( "r_bdfileuse") );
			String r_bdadduse = Cvt.toStr( mtptReq.getParameter( "r_bdadduse") );
			String r_bddeluse = Cvt.toStr( mtptReq.getParameter( "r_bddeluse") );
			String r_bdedituse = Cvt.toStr( mtptReq.getParameter( "r_bdedituse") );
			String r_bdimage = Cvt.toStr( mtptReq.getParameter( "r_bdimage") );
			String r_bdip = Cvt.toStr( mtptReq.getParameter( "r_bdip") );
			String r_bdipuse = Cvt.toStr( mtptReq.getParameter( "r_bdipuse") );
			String r_bdselfviewuse = Cvt.toStr( mtptReq.getParameter( "r_bdselfviewuse" ) );
			String r_bdpswduse = Cvt.toStr( mtptReq.getParameter( "r_bdpswduse") );
			String r_bdreplyuse = Cvt.toStr( mtptReq.getParameter( "r_bdreplyuse") );
			String r_bdsorttype = Cvt.toStr( mtptReq.getParameter( "r_bdsorttype") );
			String r_bdviewtype = Cvt.toStr( mtptReq.getParameter( "r_bdviewtype") );
//			String r_bdlevel = Cvt.toStr( mtptReq.getParameter( "r_bdlevel") );
			String r_bdtype = Cvt.toStr( mtptReq.getParameter( "r_bdtype") );
			String r_bduse = Cvt.toStr( mtptReq.getParameter( "r_bduse") );
//			String r_bdmoid = Cvt.toStr( mtptReq.getParameter( "r_bdmoid") );
//			String r_bdinid = Cvt.toStr( mtptReq.getParameter( "r_bdinid") );
//			Timestamp r_bdmodate =  mtptReq.getParameter( "r_bdmodate") );
//			Timestamp r_bdindate =  mtptReq.getParameter( "r_bdindate") );
			//--- param

			//---* dto setting
			BoardDao boardDao = new BoardDao( conn );
			wColNameList.add( " and BD_ID = ? " );
			wColValList.add( r_bdid );
			wColTypeList.add( "String" );
			
			Board board = boardDao.one(sqlMap);

//			board.setBD_ID(r_bdid );
			board.setBD_NAME(r_bdname );
			board.setBD_COMMENTUSE(r_bdcommentuse );
			board.setBD_SECRETUSE( r_bdsecretuse );
			board.setBD_DESCRIPTION(r_bddescription );
			board.setBD_FILEMAXSIZE(r_bdfilemaxsize );
			board.setBD_FILEUSE(r_bdfileuse );
			board.setBD_DELUSE( r_bddeluse );
			board.setBD_EDITUSE( r_bdedituse );
			board.setBD_ADDUSE( r_bdadduse );
			if( !fileNameList.isEmpty() ){
				board.setBD_IMAGE( fileNameList.get(0) );
			}
			board.setBD_IP(r_bdip );
			board.setBD_IPUSE(r_bdipuse );
			board.setBD_SELFVIEWUSE( r_bdselfviewuse );
			board.setBD_PSWDUSE(r_bdpswduse );
			board.setBD_REPLYUSE(r_bdreplyuse );
			board.setBD_SORTTYPE(r_bdsorttype );
			board.setBD_VIEWTYPE(r_bdviewtype );
//			board.setBD_LEVEL(r_bdlevel );
			board.setBD_TYPE(r_bdtype );
			board.setBD_USE(r_bduse );
			board.setBD_MOID( ss_mbid );
//			board.setBD_INID(r_bdinid );
//			board.setBD_MODATE(r_bdmodate );
//			board.setBD_INDATE(r_bdindate );
			//--- dto setting

			//---* Dao
			sqlMap.put( "board", board );
			wColNameList.add( " and BD_ID = ? " );
			wColValList.add( r_bdid );
			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", orderStr );

			boardDao.up( sqlMap );
			
			
			//---*파일저장완료
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			
			if( !fileNameList.isEmpty() ){
				//---*기존파일 삭제처리
				wColNameList.clear();wColValList.clear();wColTypeList.clear();
				wColNameList.add( " and FLS_REFERTABLE = ? " );wColValList.add( "board" );wColTypeList.add( "String" );
				wColNameList.add( " and FLS_REFERID = ? " );wColValList.add( r_bdid );wColTypeList.add( "String" );
				List<Filestorage> filestorageList = filestorageDao.list(sqlMap);
				for( Filestorage filestorage : filestorageList ){
					fileSvc.fileDel( req, "/up/board/"+filestorage.getFLS_INNAME() );
				}
				//---기존파일 삭제처리
				
//				wColNameList.add( " and FLS_REFERTABLE = ? " );wColValList.add( "board" );wColTypeList.add( "String" );
//				wColNameList.add( " and FLS_REFERID = ? " );wColValList.add( r_bdid );wColTypeList.add( "String" );
				filestorageDao.del(sqlMap);
				
//				fileNameList.get(0);
			}
			
			fileMap.clear();
			int index = 0;
			for( String fileName : fileNameList ){
				index++;
				
				Filestorage filestorage = new Filestorage();
				filestorage.setFLS_REFERTABLE( "board" );
				filestorage.setFLS_REFERID( r_bdid+"" );
				filestorage.setFLS_NAME( fileName );
				filestorage.setFLS_INNAME( r_bdid+"_"+index );
				filestorage.setFLS_EXTENSION( "" );
				filestorage.setFLS_INID( ss_mbid );
				
				filestorageDao.in(filestorage);
				
				fileMap.put( "filePath", "/up/temp/"+fileName );
				fileMap.put( "changePath", "/up/board/"+r_bdid+"_"+index );
				fileSvc.fileRename( req, fileMap );
				fileSvc.fileDel( req, "/up/temp/"+fileName );
			}
			//---파일저장완료
			
			
			conn.commit();
			//--- Dao

			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/board/bo/boardview?r_bdid="+r_bdid );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}