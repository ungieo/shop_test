package product.svc;

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

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;
import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.file.svc.FileSvc;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import product.dao.ProductDao;
import product.dto.Product;

public class ProductUp implements Svc{

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
			int r_prseq = Cvt.toInt( req.getParameter( "r_prseq") );
			int r_prprcseq = Cvt.toInt( req.getParameter( "r_prprcseq") );
			String r_prcode = Cvt.toStr( req.getParameter( "r_prcode") );
			String r_prcodeb = Cvt.toStr( req.getParameter( "r_prcodeb") );
			String r_prcodes = Cvt.toStr( req.getParameter( "r_prcodes") );
			String r_prname = Cvt.toStr( req.getParameter( "r_prname") );
			int r_prmoney = Cvt.toInt( req.getParameter( "r_prmoney") );
			int r_prfilenum = Cvt.toInt( req.getParameter( "r_prfilenum") );
			String r_prcpids = Cvt.toStr( req.getParameter( "r_prcpids") );
			String r_prcpidb = Cvt.toStr( req.getParameter( "r_prcpidb") );
			String r_prbarcode = Cvt.toStr( req.getParameter( "r_prbarcode") );
			String r_prvatuse = Cvt.toStr( req.getParameter( "r_prvatuse") );
			int r_prsavemoney = Cvt.toInt( req.getParameter( "r_prsavemoney") );
			String r_prstandard = Cvt.toStr( req.getParameter( "r_prstandard") );
			int r_prbrseq = Cvt.toInt( req.getParameter( "r_prbrseq") );
			String r_prmodel = Cvt.toStr( req.getParameter( "r_prmodel") );
			String r_prunit = Cvt.toStr( req.getParameter( "r_prunit") );
			String r_prmanufacture = Cvt.toStr( req.getParameter( "r_prmanufacture") );
			String r_prcountry = Cvt.toStr( req.getParameter( "r_prcountry") );
			int r_prminbuyea = Cvt.toInt( req.getParameter( "r_prminbuyea") );
			int r_prstock = Cvt.toInt( req.getParameter( "r_prstock") );
			String r_prweight = Cvt.toStr( req.getParameter( "r_prweight") );
			String r_prcontent = Cvt.toStr( req.getParameter( "r_prcontent") );
			String r_prdeliterm = Cvt.toStr( req.getParameter( "r_prdeliterm") );
			String r_prdelipolicy = Cvt.toStr( req.getParameter( "r_prdelipolicy") );
			String r_prstatus = Cvt.toStr( req.getParameter( "r_prstatus") );
			String r_prlevel = Cvt.toStr( req.getParameter( "r_prlevel") );
			String r_prtype = Cvt.toStr( req.getParameter( "r_prtype") );
			String r_pruse = Cvt.toStr( req.getParameter( "r_pruse") );
			String r_prmoid = Cvt.toStr( req.getParameter( "r_prmoid") );
			String r_prinid = Cvt.toStr( req.getParameter( "r_prinid") );
//			Timestamp r_prmodate =  req.getParameter( "r_prmodate") );
//			Timestamp r_prindate =  req.getParameter( "r_prindate") );
			//--- param

			//---* 원본 가져오기
			ProductDao productDao = new ProductDao( conn );
			wColNameList.add( "and PR_SEQ = ? " );
			wColValList.add( r_prseq+"" );
			wColTypeList.add( "int" );
			Product product = productDao.one(sqlMap);
			//--- 원본 가져오기
			
			//---* dto setting
			product.setPR_SEQ( r_prseq );
			product.setPR_PRCSEQ( r_prprcseq );
			product.setPR_CODE( r_prcode );
			product.setPR_CODEB( r_prcodeb );
			product.setPR_CODES( r_prcodes );
			product.setPR_NAME( r_prname );
			product.setPR_PRICE( r_prmoney );
			product.setPR_FILENUM( r_prfilenum );
			product.setPR_CPIDS( r_prcpids );
			product.setPR_CPIDB( r_prcpidb );
			product.setPR_BARCODE( r_prbarcode );
			product.setPR_VATUSE( r_prvatuse );
			product.setPR_SAVEMONEY( r_prsavemoney );
			product.setPR_STANDARD( r_prstandard );
			product.setPR_BRSEQ( r_prbrseq );
			product.setPR_MODEL( r_prmodel );
			product.setPR_UNIT( r_prunit );
			product.setPR_MANUFACTURE( r_prmanufacture );
			product.setPR_COUNTRY( r_prcountry );
			product.setPR_MINBUYEA( r_prminbuyea );
			product.setPR_STOCK( r_prstock );
			product.setPR_WEIGHT( r_prweight );
			product.setPR_CONTENT( r_prcontent );
			product.setPR_DELITERM( r_prdeliterm );
			product.setPR_DELIPOLICY( r_prdelipolicy );
			product.setPR_STATUS( r_prstatus );
			product.setPR_LEVEL( r_prlevel );
			product.setPR_TYPE( r_prtype );
			product.setPR_USE( r_pruse );
			product.setPR_MOID( r_prmoid );
			product.setPR_INID( r_prinid );
//			product.setPR_MODATE(r_prmodate );
//			product.setPR_INDATE(r_prindate );
			//--- dto setting

			//---* Dao
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and PR_SEQ = ? " );
			wColValList.add( r_prseq+"" );
			wColTypeList.add( "int" );
			sqlMap.put( "product", product );
			productDao.up( sqlMap );
			//--- Dao

			//---* 기존 파일, DB 삭제
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			if( !fileNameList.isEmpty() ){
				wColNameList.clear();wColValList.clear();wColTypeList.clear();
				wColNameList.add( " and FLS_REFERTABLE = ? " );wColValList.add( "product" );wColTypeList.add( "String" );
				wColNameList.add( " and FLS_REFERID = ? " );wColValList.add( r_prseq+"" );wColTypeList.add( "String" );
				List<Filestorage> filestorageList = filestorageDao.list(sqlMap);
				for( Filestorage filestorage : filestorageList ){
					fileSvc.fileDel( req, "/up/product/"+filestorage.getFLS_INNAME() );
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
			

			conn.commit();
			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/product/productview?r_prseq="+r_prseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}