package boardarticle.svc;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.file.svc.FileSvc;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;

public class BoardarticleUp implements Svc{

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
			
			//---*임시파일등록
			FileSvc fileSvc = new FileSvcImpl();
			Map<String,Object> fileMap = new HashMap<String, Object>();
			fileMap.put( "filePath", "/up/temp" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();
			
			MultipartRequest mtptReq = (MultipartRequest)fileMap.get("mtptReq");
			List<String> fileNameList = (List<String>)fileMap.get("fileNameList");
			//---임시파일등록

			int r_bdaseq = Cvt.toInt( mtptReq.getParameter( "r_bdaseq") );
			String r_bdabdid = Cvt.toStr( mtptReq.getParameter( "r_bdabdid") );
//			int r_bdabdcseq = Cvt.toInt( mtptReq.getParameter( "r_bdabdcseq") );
			String r_bdacontent = Cvt.toStr( mtptReq.getParameter( "r_bdacontent") );
			int r_bdafilenum = Cvt.toInt( mtptReq.getParameter( "r_bdafilenum") );
//			int r_bdagroupnum = Cvt.toInt( mtptReq.getParameter( "r_bdagroupnum") );
//			int r_bdalevelnum = Cvt.toInt( mtptReq.getParameter( "r_bdalevelnum") );
//			int r_bdastepnum = Cvt.toInt( mtptReq.getParameter( "r_bdastepnum") );
//			String r_bdambid = Cvt.toStr( mtptReq.getParameter( "r_bdambid") );
//			String r_bdaname = Cvt.toStr( mtptReq.getParameter( "r_bdaname") );
//			String r_bdaownername = Cvt.toStr( mtptReq.getParameter( "r_bdaownername") );
			String r_bdapswd = Cvt.toStr( mtptReq.getParameter( "r_bdapswd") );
//			int r_bdareadcnt = Cvt.toInt( mtptReq.getParameter( "r_bdareadcnt") );
//			int r_bdarecommendcnt = Cvt.toInt( mtptReq.getParameter( "r_bdarecommendcnt") );
			
//			int r_bdastatus = Cvt.toInt( mtptReq.getParameter( "r_bdastatus") );
//			String r_bdalevel = Cvt.toStr( mtptReq.getParameter( "r_bdalevel") );
//			String r_bdatype = Cvt.toStr( mtptReq.getParameter( "r_bdatype") );
//			String r_bdause = Cvt.toStr( mtptReq.getParameter( "r_bdause") );
//			String r_bdamoid = Cvt.toStr( mtptReq.getParameter( "r_bdamoid") );
//			String r_bdainid = Cvt.toStr( mtptReq.getParameter( "r_bdainid") );
//			Timestamp r_bdamodate =  mtptReq.getParameter( "r_bdamodate") );
//			Timestamp r_bdaindate =  mtptReq.getParameter( "r_bdaindate") );

			//---* 원글 불러오기
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			wColNameList.add( "and BDA_SEQ = ? " );
//			wColNameList.add( "and BDA_PSWD = ? " );
			wColValList.add( ""+r_bdaseq );
//			wColValList.add( r_bdapswd );
			wColTypeList.add( "int" );
//			wColTypeList.add( "String" );
			Boardarticle boardarticle = boardarticleDao.one(sqlMap);
			//--- 원글 불러오기
			
			if( !ss_mbid.equals(boardarticle.getBDA_MBID() ) ){
				throw new Exception("권한이 없습니다.");
			}
			
//			boardarticle.setBDA_SEQ(r_bdaseq );
//			boardarticle.setBDA_BDID(r_bdabdid );
//			boardarticle.setBDA_BDCSEQ(r_bdabdcseq );
			boardarticle.setBDA_CONTENT(r_bdacontent );
			if( !fileNameList.isEmpty() ){
				boardarticle.setBDA_FILENUM(r_bdafilenum );
			}
//			boardarticle.setBDA_GROUPNUM(r_bdagroupnum );
//			boardarticle.setBDA_LEVELNUM(r_bdalevelnum );
//			boardarticle.setBDA_STEPNUM(r_bdastepnum );
//			boardarticle.setBDA_MBID(r_bdambid );
//			boardarticle.setBDA_NAME(r_bdaname );
//			boardarticle.setBDA_OWNERNAME(r_bdaownername );
//			boardarticle.setBDA_PSWD(r_bdapswd );
//			boardarticle.setBDA_READCNT(r_bdareadcnt );
//			boardarticle.setBDA_RECOMMENDCNT(r_bdarecommendcnt );
			boardarticle.setBDA_IP( Cvt.toStr( req.getRemoteHost() ) );
//			boardarticle.setBDA_STATUS(r_bdastatus );
//			boardarticle.setBDA_LEVEL(r_bdalevel );
//			boardarticle.setBDA_TYPE(r_bdatype );
//			boardarticle.setBDA_USE(r_bdause );
			boardarticle.setBDA_MOID( ss_mbid );
//			boardarticle.setBDA_INID( ss_mbid );
//			boardarticle.setBDA_MODATE(r_bdamodate );
//			boardarticle.setBDA_INDATE(r_bdaindate );


			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			wColNameList.add( "and BDA_SEQ = ? " );
//			wColNameList.add( "and BDA_PSWD = ? " );
			wColValList.add( ""+r_bdaseq );
//			wColValList.add( r_bdapswd );
			wColTypeList.add( "int" );
//			wColTypeList.add( "String" );
			sqlMap.put( "boardarticle", boardarticle );
			boardarticleDao.up( sqlMap );
			
			
			//---* 기존 파일, DB 삭제
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			if( !fileNameList.isEmpty() ){
				wColNameList.clear();wColValList.clear();wColTypeList.clear();
				wColNameList.add( " and FLS_REFERTABLE = ? " );wColValList.add( "boardarticle" );wColTypeList.add( "String" );
				wColNameList.add( " and FLS_REFERID = ? " );wColValList.add( ""+r_bdaseq );wColTypeList.add( "String" );
				List<Filestorage> filestorageList = filestorageDao.list(sqlMap);
				for( Filestorage filestorage : filestorageList ){
					fileSvc.fileDel( req, "/up/boardarticle/"+filestorage.getFLS_INNAME() );
				}
				filestorageDao.del(sqlMap);
			}
			//--- 기존파일, DB삭제
			
			
			//---*새파일등록
			fileMap.clear();
			int index = 0;
			for( String fileName : fileNameList ){
				index++;
				
				Filestorage filestorage = new Filestorage();
				filestorage.setFLS_REFERTABLE( "boardarticle" );
				filestorage.setFLS_REFERID( r_bdaseq+"" );
				filestorage.setFLS_NAME( fileName );
				filestorage.setFLS_INNAME( r_bdaseq+"_"+index );
				filestorage.setFLS_EXTENSION( "" );
				filestorage.setFLS_INID( ss_mbid );
				
				filestorageDao.in(filestorage);
				
				fileMap.put( "filePath", "/up/temp/"+fileName );
				fileMap.put( "changePath", "/up/boardarticle/"+r_bdaseq+"_"+index );
				fileSvc.fileRename( req, fileMap );
				fileSvc.fileDel( req, "/up/temp/"+fileName );
			}
			//---새파일등록
			
			
			
			conn.commit();


			model.put( "returnType", "R" );
			model.put( "returnPage", "/boardarticle/boardarticleview?r_bdabdid="+r_bdabdid+"&r_bdaseq="+r_bdaseq );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}