package product.svc;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;

import product.dao.ProductDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.file.svc.FileSvc;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class FilestorageUpBoJson implements Svc{

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
			
			
			//---* param
			int r_prseq = Cvt.toInt( mtptReq.getParameter( "r_prseq" ) );
			String r_flsseq = Cvt.toStr( mtptReq.getParameter( "r_flsseq" ) );
			//--- param

			//---* Dao
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			
			if( !"".equals(r_flsseq) ){
				
				wColNameList.add( " and FLS_SEQ = ? " );
				wColValList.add( r_flsseq );
				wColTypeList.add( "int" );
				Filestorage filestorage = filestorageDao.one( sqlMap );
				
				//---* 기존 파일, DB 삭제
				fileSvc.fileDel( req, "/up/product/"+filestorage.getFLS_INNAME() );
				
				filestorageDao.del(sqlMap);
				//--- 기존파일, DB삭제
				
				filestorageDao.upChoice( " FLS_INNAME ", fileNameList.get(0)+"_"+filestorage.getFLS_INNAME().split("_")[1], " and FLS_SEQ="+r_flsseq );
				
			}else{
				
				//---*새파일등록
				fileMap.clear();
				int index = 0;
				for( String fileName : fileNameList ){
					index++;
					
					Filestorage filestorage = new Filestorage();
					filestorage.setFLS_REFERTABLE( "product" );
					filestorage.setFLS_REFERID( r_prseq+"" );
					filestorage.setFLS_NAME( fileName );
					filestorage.setFLS_INNAME( r_prseq+"_"+index );
					filestorage.setFLS_EXTENSION( "" );
					filestorage.setFLS_INID( ss_mbid );
					
					filestorageDao.in(filestorage);
					
					fileMap.put( "filePath", "/up/temp/"+fileName );
					fileMap.put( "changePath", "/up/product/"+r_prseq+"_"+index );
					fileSvc.fileRename( req, fileMap );
					fileSvc.fileDel( req, "/up/temp/"+fileName );
				}
				//---새파일등록
				
				ProductDao productDao = new ProductDao( conn );
				productDao.upChoice( "PR_FILENUM", "PR_FILENUM+1", " and PR_SEQ = "+r_prseq );
			}
			
			
			
			
			
			//--- Dao
			
			conn.commit();
			
			res.setContentType("text");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().print(fileNameList.get(0));
			
			

			//---* model
//			model.put( "returnType", "R" );
//			model.put( "returnPage", "/filestorage/bo/filestoragelist" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}