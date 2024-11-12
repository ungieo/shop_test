package home.svc;

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
import system.file.svc.impl.CommonFileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class MainSliderUpBo implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session
			
			//---* 파일저장
			FileSvc fileSvc = new CommonFileSvcImpl();
			Map<String,Object> fileMap = new HashMap<String, Object>();
			fileMap.put( "filePath", "/up/shopinfo" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			//--- 파일저장
			
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();

			//---* param
			String r_mainslider1 = Cvt.toStr( fileMap.get( "r_mainslider1") );
			String r_mainslider2 = Cvt.toStr( fileMap.get( "r_mainslider2") );
			String r_mainslider3 = Cvt.toStr( fileMap.get( "r_mainslider3") );
			String r_mainslider4 = Cvt.toStr( fileMap.get( "r_mainslider4") );
			String r_mainsliderfile1 = Cvt.toStr( fileMap.get( "r_mainsliderfile1") );
			String r_mainsliderfile2 = Cvt.toStr( fileMap.get( "r_mainsliderfile2") );
			String r_mainsliderfile3 = Cvt.toStr( fileMap.get( "r_mainsliderfile3") );
			String r_mainsliderfile4 = Cvt.toStr( fileMap.get( "r_mainsliderfile4") );
			String r_mainsliderlink1 = Cvt.toStr( fileMap.get( "r_mainsliderlink1") );
			String r_mainsliderlink2 = Cvt.toStr( fileMap.get( "r_mainsliderlink2") );
			String r_mainsliderlink3 = Cvt.toStr( fileMap.get( "r_mainsliderlink3") );
			String r_mainsliderlink4 = Cvt.toStr( fileMap.get( "r_mainsliderlink4") );
			
			//--- param

			//---* 원본 가져오기
			//--- 원본 가져오기
			
			FilestorageDao filestorageDao = new FilestorageDao( conn );

			
			Filestorage filestorage = null; 
			
			
			if( !"".equals( r_mainslider1 ) || !"".equals( r_mainsliderlink1 ) ){
//				fileSvc.fileDel( req, "/up/shopinfo/"+r_mainsliderfile1 );
//				filestorageDao.del( " and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='1' " );
				
				filestorage = filestorageDao.one(" and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='1' ", "" );
				
//				filestorage.setFLS_REFERTABLE( "mainslider" );
//				filestorage.setFLS_REFERID( "1" );
				if( !"".equals( r_mainslider1 ) ){
					fileSvc.fileDel( req, "/up/shopinfo/"+r_mainsliderfile1 );
					filestorage.setFLS_NAME( r_mainslider1 );
					filestorage.setFLS_INNAME( r_mainslider1 );
				}
				filestorage.setFLS_EXTENSION( "" );
				if( !"".equals( r_mainsliderlink1 ) ){
					filestorage.setFLS_LINK( r_mainsliderlink1 );
				}
				filestorage.setFLS_MOID( ss_mbid );
				
//				filestorageDao.in(filestorage);
				filestorageDao.up(filestorage, " and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='1' " );
			}
			if( !"".equals( r_mainslider2 ) || !"".equals( r_mainsliderlink2 ) ){
				filestorage = filestorageDao.one(" and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='2' ", "" );
				if( !"".equals( r_mainslider2 ) ){
					fileSvc.fileDel( req, "/up/shopinfo/"+r_mainsliderfile2 );
					filestorage.setFLS_NAME( r_mainslider2 );
					filestorage.setFLS_INNAME( r_mainslider2 );
				}
				filestorage.setFLS_EXTENSION( "" );
				if( !"".equals( r_mainsliderlink2 ) ){
					filestorage.setFLS_LINK( r_mainsliderlink2 );
				}
				filestorage.setFLS_MOID( ss_mbid );
				
				filestorageDao.up(filestorage, " and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='2' " );
			}
			if( !"".equals( r_mainslider3 ) || !"".equals( r_mainsliderlink3 )  ){
				filestorage = filestorageDao.one(" and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='3' ", "" );
				if( !"".equals( r_mainslider3 ) ){
					fileSvc.fileDel( req, "/up/shopinfo/"+r_mainsliderfile3 );
					filestorage.setFLS_NAME( r_mainslider3 );
					filestorage.setFLS_INNAME( r_mainslider3 );
				}
				filestorage.setFLS_EXTENSION( "" );
				if( !"".equals( r_mainsliderlink3 ) ){
					filestorage.setFLS_LINK( r_mainsliderlink3 );
				}
				filestorage.setFLS_MOID( ss_mbid );
				
				filestorageDao.up(filestorage, " and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='3' " );
			}
			if( !"".equals( r_mainslider4 ) || !"".equals( r_mainsliderlink4 )  ){
				filestorage = filestorageDao.one(" and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='4' ", "" );
				if( !"".equals( r_mainslider4 ) ){
					fileSvc.fileDel( req, "/up/shopinfo/"+r_mainsliderfile4 );
					filestorage.setFLS_NAME( r_mainslider4 );
					filestorage.setFLS_INNAME( r_mainslider4 );
				}
				filestorage.setFLS_EXTENSION( "" );
				if( !"".equals( r_mainsliderlink4 ) ){
					filestorage.setFLS_LINK( r_mainsliderlink4 );
				}
				filestorage.setFLS_MOID( ss_mbid );
				
				filestorageDao.up(filestorage, " and FLS_REFERTABLE = 'mainslider' and FLS_REFERID='4' " );
			}
			
			
			//---* Dao
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
			//--- Dao

			conn.commit();
			
			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/home/bo/mainslideredit" );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}