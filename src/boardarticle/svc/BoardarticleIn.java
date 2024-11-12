package boardarticle.svc;

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
import boardarticle.dao.BoardarticleDao;
import boardarticle.dto.Boardarticle;

import com.oreilly.servlet.MultipartRequest;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class BoardarticleIn implements Svc{

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
			String ss_mbname = Cvt.toStr( session.getAttribute( "ss_mbname" ) );
			//--- session
			
//			String r_bdainid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			
			FileSvc fileSvc = new FileSvcImpl();
			Map<String,Object> fileMap = new HashMap<String, Object>();
			fileMap.put( "filePath", "/up/temp" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();
			
			MultipartRequest mtptReq = (MultipartRequest)fileMap.get("mtptReq");
			List<String> fileNameList = (List<String>)fileMap.get("fileNameList");
			
//			int r_bdaseq = Cvt.toInt( mtptReq.getParameter( "r_bdaseq") );
			String r_bdabdid = Cvt.toStr( mtptReq.getParameter( "r_bdabdid") );
//			int r_bdabdcseq = Cvt.toInt( mtptReq.getParameter( "r_bdabdcseq") );
			String r_bdacontent = Cvt.toStr( mtptReq.getParameter( "r_bdacontent") );
//			int r_bdafilenum = Cvt.toInt( mtptReq.getParameter( "r_bdafilenum") );
//			int r_bdagroupnum = Cvt.toInt( mtptReq.getParameter( "r_bdagroupnum") );
//			int r_bdalevelnum = Cvt.toInt( mtptReq.getParameter( "r_bdalevelnum") );
//			int r_bdastepnum = Cvt.toInt( mtptReq.getParameter( "r_bdastepnum") );
//			String r_bdambid = Cvt.toStr( mtptReq.getParameter( "r_bdambid") );
			String r_bdaname = Cvt.toStr( mtptReq.getParameter( "r_bdaname") );
//			String r_bdaownername = Cvt.toStr( mtptReq.getParameter( "r_bdaownername") );
			String r_bdapswd = Cvt.toStr( mtptReq.getParameter( "r_bdapswd") );
//			int r_bdareadcnt = Cvt.toInt( mtptReq.getParameter( "r_bdareadcnt") );
//			int r_bdarecommendcnt = Cvt.toInt( mtptReq.getParameter( "r_bdarecommendcnt") );
			
//			int r_bdastatus = Cvt.toInt( mtptReq.getParameter( "r_bdastatus") );
			String r_bdasecretuse = Cvt.nullToStr( mtptReq.getParameter( "r_bdasecretuse"), "N" );
//			String r_bdalevel = Cvt.toStr( mtptReq.getParameter( "r_bdalevel") );
//			String r_bdatype = Cvt.toStr( mtptReq.getParameter( "r_bdatype") );
//			String r_bdause = Cvt.toStr( mtptReq.getParameter( "r_bdause") );
//			String r_bdamoid = Cvt.toStr( mtptReq.getParameter( "r_bdamoid") );
//			String r_bdainid = Cvt.toStr( mtptReq.getParameter( "r_bdainid") );
//			Timestamp r_bdamodate =  mtptReq.getParameter( "r_bdamodate") );
//			Timestamp r_bdaindate =  mtptReq.getParameter( "r_bdaindate") );
			
			
			Boardarticle boardarticle = new Boardarticle();

//			boardarticle.setBDA_SEQ( r_bdaseq );
			boardarticle.setBDA_BDID( r_bdabdid );
//			boardarticle.setBDA_BDCSEQ( r_bdabdcseq );
			boardarticle.setBDA_CONTENT( r_bdacontent );
			boardarticle.setBDA_FILENUM( fileNameList.size() );
//			boardarticle.setBDA_GROUPNUM( r_bdagroupnum );
			boardarticle.setBDA_LEVELNUM( 1 );
			boardarticle.setBDA_STEPNUM( 1 );
			boardarticle.setBDA_MBID( ss_mbid );
			boardarticle.setBDA_NAME( r_bdaname );
			boardarticle.setBDA_OWNERNAME( ss_mbname );
			boardarticle.setBDA_PSWD( r_bdapswd );
//			boardarticle.setBDA_READCNT( r_bdareadcnt );
//			boardarticle.setBDA_RECOMMENDCNT( r_bdarecommendcnt );
			boardarticle.setBDA_IP(Cvt.toStr( req.getRemoteHost() ));
//			boardarticle.setBDA_STATUS( r_bdastatus );
			boardarticle.setBDA_SECRETUSE( r_bdasecretuse );			
//			boardarticle.setBDA_LEVEL( r_bdalevel );
//			boardarticle.setBDA_TYPE( r_bdatype );
//			boardarticle.setBDA_USE( r_bdause );
//			boardarticle.setBDA_MOID( r_bdamoid );
			boardarticle.setBDA_INID( ss_mbid );
//			boardarticle.setBDA_MODATE( r_bdamodate );
//			boardarticle.setBDA_INDATE( r_bdaindate );
			
//			boardarticle.toStr();
			
			
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			boardarticleDao.in( boardarticle );

			int r_bdaseq = 0;
			r_bdaseq = boardarticleDao.lastId();
			boardarticleDao.upChoice("BDA_GROUPNUM", r_bdaseq+"", " and BDA_SEQ = "+r_bdaseq );
			
			//---* 파일 처리
			FilestorageDao filestorageDao = new FilestorageDao( conn );
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
			//---파일처리

			conn.commit();
			
			model.put( "returnType", "R" );
			model.put( "returnPage", "/boardarticle/boardarticleview?r_bdabdid="+r_bdabdid+"&r_bdaseq="+r_bdaseq );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}