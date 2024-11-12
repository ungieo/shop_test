package company.svc;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system. db.svc.impl.MysqlDbConnImpl;
import system.file.svc.FileSvc;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import company.dao.CompanyDao;
import company.dto.Company;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class CompanyInBo implements Svc{

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
			
			FileSvc fileSvc = new FileSvcImpl();
			Map<String,Object> fileMap = new HashMap<String, Object>();
			fileMap.put( "filePath", "/up/temp" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();
			
			MultipartRequest mtptReq = (MultipartRequest)fileMap.get("mtptReq");
			List<String> fileNameList = (List<String>)fileMap.get("fileNameList");
			

			//---* param
//			int r_cpseq = Cvt.toInt( mtptReq.getParameter( "r_cpseq") );
			String r_cpid = Cvt.toStr( mtptReq.getParameter( "r_cpid") );
			String r_cpname = Cvt.toStr( mtptReq.getParameter( "r_cpname") );
			String r_cpbiznum = Cvt.toStr( mtptReq.getParameter( "r_cpbiznum") );
			String r_cpuptai = Cvt.toStr( mtptReq.getParameter( "r_cpuptai") );
			String r_cpupjong = Cvt.toStr( mtptReq.getParameter( "r_cpupjong") );
			String r_cpceoname = Cvt.toStr( mtptReq.getParameter( "r_cpceoname") );
			String r_cpzipcode = Cvt.toStr( mtptReq.getParameter( "r_cpzipcode") );
			String r_cpaddr1 = Cvt.toStr( mtptReq.getParameter( "r_cpaddr1") );
			String r_cpaddr2 = Cvt.toStr( mtptReq.getParameter( "r_cpaddr2") );
			String r_cpfile = Cvt.toStr( mtptReq.getParameter( "r_cpfile") );
			int r_cpdeliverymoney = Cvt.toInt( mtptReq.getParameter( "r_cpdeliverymoney") );
			String r_cppaytype = Cvt.toStr( mtptReq.getParameter( "r_cppaytype") );
			String r_cpbiztype = Cvt.toStr( mtptReq.getParameter( "r_cpbiztype") );
			String r_cptongsinbiznum = Cvt.toStr( mtptReq.getParameter( "r_cptongsinbiznum") );
			String r_cpemail = Cvt.toStr( mtptReq.getParameter( "r_cpemail") );
			String r_cptel = Cvt.toStr( mtptReq.getParameter( "r_cptel") );
			String r_cpphone = Cvt.toStr( mtptReq.getParameter( "r_cpphone") );
			String r_cpfax = Cvt.toStr( mtptReq.getParameter( "r_cpfax") );
			String r_cplevel = Cvt.toStr( mtptReq.getParameter( "r_cplevel") );
			String r_cptype = Cvt.toStr( mtptReq.getParameter( "r_cptype") );
			String r_cpuse = Cvt.toStr( mtptReq.getParameter( "r_cpuse") );
			String r_cpmoid = Cvt.toStr( mtptReq.getParameter( "r_cpmoid") );
			String r_cpinid = Cvt.toStr( mtptReq.getParameter( "r_cpinid") );
//			Timestamp r_cpmodate =  mtptReq.getParameter( "r_cpmodate") );
//			Timestamp r_cpindate =  mtptReq.getParameter( "r_cpindate") );
			//---* param

			//---* dto setting
			Company company = new Company();

//			company.setCP_SEQ( r_cpseq );
			company.setCP_ID( r_cpid );
			company.setCP_NAME( r_cpname );
			company.setCP_BIZNUM( r_cpbiznum );
			company.setCP_UPTAI( r_cpuptai );
			company.setCP_UPJONG( r_cpupjong );
			company.setCP_CEONAME( r_cpceoname );
			company.setCP_ZIPCODE( r_cpzipcode );
			company.setCP_ADDR1( r_cpaddr1 );
			company.setCP_ADDR2( r_cpaddr2 );
			company.setCP_FILE( fileNameList.size()+"" );
			company.setCP_DELIVERYMONEY( r_cpdeliverymoney );
			company.setCP_PAYTYPE( r_cppaytype );
			company.setCP_BIZTYPE( r_cpbiztype );
			company.setCP_TONGSINBIZNUM( r_cptongsinbiznum );
			company.setCP_EMAIL( r_cpemail );
			company.setCP_TEL( r_cptel );
			company.setCP_PHONE( r_cpphone );
			company.setCP_FAX( r_cpfax );
			company.setCP_LEVEL( r_cplevel );
			company.setCP_TYPE( r_cptype );
			company.setCP_USE( r_cpuse );
			company.setCP_MOID( ss_mbid );
			company.setCP_INID( ss_mbid );
//			company.setCP_MODATE( r_cpmodate );
//			company.setCP_INDATE( r_cpindate );
			//--- dto setting

			//---* Dao
			CompanyDao companyDao = new CompanyDao( conn );
			companyDao.in( company );
			
			int r_cpseq = companyDao.lastId();
			//--- Dao
			
			
			
			//---* 파일 처리
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			fileMap.clear();
			int index = 0;
			for( String fileName : fileNameList ){
				index++;
				
				Filestorage filestorage = new Filestorage();
				filestorage.setFLS_REFERTABLE( "company" );
				filestorage.setFLS_REFERID( r_cpseq+"" );
				filestorage.setFLS_NAME( fileName );
				filestorage.setFLS_INNAME( r_cpseq+"_"+index );
				filestorage.setFLS_EXTENSION( "" );
				filestorage.setFLS_INID( ss_mbid );
				
				filestorageDao.in(filestorage);
				
				fileMap.put( "filePath", "/up/temp/"+fileName );
				fileMap.put( "changePath", "/up/company/"+r_cpseq+"_"+index );
				fileSvc.fileRename( req, fileMap );
				fileSvc.fileDel( req, "/up/temp/"+fileName );
			}
			//---파일처리
			

			conn.commit();
			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/company/bo/companyview?r_cpseq="+r_cpseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}