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

public class BoardarticleReplyIn implements Svc{

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
			
			//---* 파일저장
			FileSvc fileSvc = new FileSvcImpl();
			Map<String,Object> svcMap = new HashMap<String, Object>();
			svcMap.put( "filePath", "/up/temp" );
			svcMap.put( "fileSize", 1024*1024*10 );
			svcMap.put( "encoding", "utf-8" );
			
			boolean fileReturn =  fileSvc.fileUpload( req, svcMap );
			if( !fileReturn ) throw new IOException();
			
			MultipartRequest mtptReq = (MultipartRequest)svcMap.get("mtptReq");
			List<String> fileNameList = (List<String>)svcMap.get("fileNameList");
			//---파일저장
			
			//---*부모글 가져오기
			int r_bdaseq = Cvt.toInt( mtptReq.getParameter( "r_bdaseq" ) );
			
			BoardarticleDao boardarticleDao = new BoardarticleDao( conn );
			wColNameList.add( " and BDA_SEQ = ? ");
			wColValList.add( ""+r_bdaseq );
			wColTypeList.add( "int" );
			Boardarticle boardarticle = boardarticleDao.one( sqlMap );
			//---부모글 가져오기
			
			//---*파라미터받기
			String r_bdabdid = Cvt.toStr( mtptReq.getParameter( "r_bdabdid") );
//			int r_bdabdcseq = Cvt.toInt( mtptReq.getParameter( "r_bdabdcseq") );
			String r_bdacontent = Cvt.toStr( mtptReq.getParameter( "r_bdacontent") );
			int r_bdafilenum = Cvt.toInt( fileNameList.size() );
			String r_bdaname = Cvt.toStr( mtptReq.getParameter( "r_bdaname") );
//			String r_bdaownername = Cvt.toStr( mtptReq.getParameter( "r_bdaownername") );
			String r_bdapswd = Cvt.toStr( mtptReq.getParameter( "r_bdapswd") );
//			int r_bdarecommendcnt = Cvt.toInt( mtptReq.getParameter( "r_bdarecommendcnt") );
//			int r_bdastatus = Cvt.toInt( mtptReq.getParameter( "r_bdastatus") );
//			String r_bdalevel = Cvt.toStr( mtptReq.getParameter( "r_bdalevel") );
//			String r_bdatype = Cvt.toStr( mtptReq.getParameter( "r_bdatype") );
//			String r_bdause = Cvt.toStr( mtptReq.getParameter( "r_bdause") );
//			String r_bdamoid = Cvt.toStr( mtptReq.getParameter( "r_bdamoid") );
//			String r_bdainid = Cvt.toStr( mtptReq.getParameter( "r_bdainid") );
			
			//---*dto값대입
			boardarticle.setBDA_SEQ( 0 );
			boardarticle.setBDA_BDID( r_bdabdid );
			boardarticle.setBDA_BDCSEQ( 0 );
			boardarticle.setBDA_CONTENT( r_bdacontent );
			boardarticle.setBDA_FILENUM( r_bdafilenum );
//			boardarticle.setBDA_GROUPNUM( r_bdaseq );
//			boardarticle.setBDA_LEVELNUM( r_bdalevelnum );
//			boardarticle.setBDA_STEPNUM( r_bdastepnum );
			boardarticle.setBDA_MBID( ss_mbid );
			boardarticle.setBDA_NAME( r_bdaname );
			boardarticle.setBDA_OWNERNAME( ss_mbname );
			boardarticle.setBDA_PSWD( r_bdapswd );
			boardarticle.setBDA_READCNT( 0 );
//			boardarticle.setBDA_RECOMMENDCNT( r_bdarecommendcnt );
//			boardarticle.setBDA_STATUS( r_bdastatus );
//			boardarticle.setBDA_LEVEL( r_bdalevel );
//			boardarticle.setBDA_TYPE( r_bdatype );
//			boardarticle.setBDA_USE( r_bdause );
			boardarticle.setBDA_MOID( "" );
			boardarticle.setBDA_INID( ss_mbid );
//			boardarticle.setBDA_MODATE( r_bdamodate );
//			boardarticle.setBDA_INDATE( r_bdaindate );
			
//			boardarticle.toStr();
			
			//---*부모글step보다 큰것들 step+1
			whereStr = " and BDA_GROUPNUM = "+boardarticle.getBDA_GROUPNUM()+" and BDA_STEPNUM > "+boardarticle.getBDA_STEPNUM();
			boardarticleDao.upChoice( "BDA_STEPNUM", "BDA_STEPNUM+1", whereStr);
			
			boardarticle.setBDA_LEVELNUM( boardarticle.getBDA_LEVELNUM()+1 );
			boardarticle.setBDA_STEPNUM( boardarticle.getBDA_STEPNUM()+1 );
			
			//---*답글저장
			boardarticleDao.in( boardarticle );

			//---*답글autoincrement값 구하기. 그룹번호는 기존거 그대로 가져감.
			r_bdaseq = boardarticleDao.lastId();
			
			//---*파일 db등록
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			
			svcMap.clear();
			int index = 0;
			for( String fileName : fileNameList ){
				index++;
				
				Filestorage filestorage = new Filestorage();
				filestorage.setFLS_REFERTABLE( "boardarticle" );
				filestorage.setFLS_REFERID( Cvt.toStr( r_bdaseq ) );
				filestorage.setFLS_NAME( fileName );
				filestorage.setFLS_INNAME( r_bdaseq+"_"+index );
				filestorage.setFLS_EXTENSION( "" );
				filestorage.setFLS_INID( ss_mbid );
				
				filestorageDao.in(filestorage);
				
				svcMap.put( "filePath", "/up/temp/"+fileName );
				svcMap.put( "changePath", "/up/boardarticle/"+r_bdaseq+"_"+index );
				fileSvc.fileRename( req, svcMap );
				fileSvc.fileDel( req, "/up/temp"+fileName );
			}
			

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