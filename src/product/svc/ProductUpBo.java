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

import product.dao.ProductDao;
import product.dto.Product;
import productgroup.dao.ProductgroupDao;
import productgroup.dto.Productgroup;
import productoption.dao.ProductoptionDao;
import productoption.dto.Productoption;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.file.svc.FileSvc;
import system.file.svc.impl.CommonFileSvcImpl;
import system.file.svc.impl.FileSvcImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import com.oreilly.servlet.MultipartRequest;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class ProductUpBo implements Svc{

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
			fileMap.put( "filePath", "/up/product" );
			fileMap.put( "fileSize", 1024*1024*10 );
			fileMap.put( "encoding", "utf-8" );
			//--- 파일저장
			
			boolean fileReturn =  fileSvc.fileUpload( req, fileMap );
			if( !fileReturn ) throw new IOException();

			//---* param
			int r_prseq = Cvt.toInt( fileMap.get( "r_prseq") );
			int r_prprcseq = Cvt.toInt( fileMap.get( "r_prprcseq") );
			String r_prcode = Cvt.toStr( fileMap.get( "r_prcode") );
			String r_prcodeb = Cvt.toStr( fileMap.get( "r_prcodeb") );
			String r_prcodes = Cvt.toStr( fileMap.get( "r_prcodes") );
			String r_prname = Cvt.toStr( fileMap.get( "r_prname") );
			int r_prprice = Cvt.toInt( fileMap.get( "r_prprice") );
//			int r_prfilenum = Cvt.toInt( fileMap.get( "r_prfilenum") );
			String r_primage1 = Cvt.toStr( fileMap.get( "r_primage1") );
			String r_primage2 = Cvt.toStr( fileMap.get( "r_primage2") );
			String r_primage3 = Cvt.toStr( fileMap.get( "r_primage3") );
			String r_primage4 = Cvt.toStr( fileMap.get( "r_primage4") );
			String r_prcpids = Cvt.toStr( fileMap.get( "r_prcpids") );
			String r_prcpidb = Cvt.toStr( fileMap.get( "r_prcpidb") );
			String r_prbarcode = Cvt.toStr( fileMap.get( "r_prbarcode") );
			String r_prvatuse = Cvt.toStr( fileMap.get( "r_prvatuse") );
			int r_prsavemoney = Cvt.toInt( fileMap.get( "r_prsavemoney") );
			String r_prstandard = Cvt.toStr( fileMap.get( "r_prstandard") );
			int r_prbrseq = Cvt.toInt( fileMap.get( "r_prbrseq") );
			String r_prmodel = Cvt.toStr( fileMap.get( "r_prmodel") );
			String r_prunit = Cvt.toStr( fileMap.get( "r_prunit") );
			String r_prmanufacture = Cvt.toStr( fileMap.get( "r_prmanufacture") );
			String r_prcountry = Cvt.toStr( fileMap.get( "r_prcountry") );
			int r_prminbuyea = Cvt.toInt( fileMap.get( "r_prminbuyea") );
			int r_prstock = Cvt.toInt( fileMap.get( "r_prstock") );
			String r_prweight = Cvt.toStr( fileMap.get( "r_prweight") );
			String r_prcontent = Cvt.toStr( fileMap.get( "r_prcontent") );
			String r_prdeliterm = Cvt.toStr( fileMap.get( "r_prdeliterm") );
			String r_prdelipolicy = Cvt.toStr( fileMap.get( "r_prdelipolicy") );
			String r_prstatus = Cvt.toStr( fileMap.get( "r_prstatus") );
			String r_prlevel = Cvt.toStr( fileMap.get( "r_prlevel") );
			String r_prtype = Cvt.toStr( fileMap.get( "r_prtype") );
			String r_pruse = Cvt.toStr( fileMap.get( "r_pruse") );
//			String r_prmoid = Cvt.toStr( fileMap.get( "r_prmoid") );
//			String r_prinid = Cvt.toStr( fileMap.get( "r_prinid") );
//			Timestamp r_prmodate =  fileMap.get( "r_prmodate") );
//			Timestamp r_prindate =  fileMap.get( "r_prindate") );
			
			String r_progname = Cvt.toStr( fileMap.get( "r_progname" ) );
			String r_proname = Cvt.toStr( fileMap.get( "r_proname" ) );
			
			
			int r_prgprseq1 = Cvt.toInt( fileMap.get( "r_prgprseq1" ) );
			int r_prgprseq2 = Cvt.toInt( fileMap.get( "r_prgprseq2" ) );
			int r_prgprseq3 = Cvt.toInt( fileMap.get( "r_prgprseq3" ) );
			int r_prgprseq4 = Cvt.toInt( fileMap.get( "r_prgprseq4" ) );
			int r_prgprseq5 = Cvt.toInt( fileMap.get( "r_prgprseq5" ) );
			int r_prgprseq6 = Cvt.toInt( fileMap.get( "r_prgprseq6" ) );
			
			//--- param

			//---* 원본 가져오기
			ProductDao productDao = new ProductDao( conn );
			wColNameList.add( "and PR_SEQ = ? " );
			wColValList.add( r_prseq+"" );
			wColTypeList.add( "int" );
			Product product = productDao.one(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- 원본 가져오기
			
			//---* dto setting
//			product.setPR_SEQ( r_prseq );
			product.setPR_PRCSEQ( r_prprcseq );
			product.setPR_CODE( r_prcode );
			product.setPR_CODEB( r_prcodeb );
			product.setPR_CODES( r_prcodes );
			product.setPR_NAME( r_prname );
			product.setPR_PRICE( r_prprice );
//			product.setPR_FILENUM( fileNameList.size() );
			
			if( !"".equals( r_primage1 ) ){
				product.setPR_IMAGE1( r_primage1 );
			}
			if( !"".equals( r_primage2 ) ){
				product.setPR_IMAGE2( r_primage2 );
			}
			if( !"".equals( r_primage3 ) ){
				product.setPR_IMAGE3( r_primage3 );
			}
			if( !"".equals( r_primage4 ) ){
				product.setPR_IMAGE4( r_primage4 );
			}
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
			product.setPR_MOID( ss_mbid );
//			product.setPR_INID( r_prinid );
//			product.setPR_MODATE(r_prmodate );
//			product.setPR_INDATE(r_prindate );
			//--- dto setting

			//---* Dao
			wColNameList.add( " and PR_SEQ = ? " );
			wColValList.add( r_prseq+"" );
			wColTypeList.add( "int" );
			sqlMap.put( "product", product );
			productDao.up( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- Dao
			
			//---*productoption In
			if( !"".equals( r_progname ) ){
				ProductoptionDao productoptionDao = new ProductoptionDao( conn );
				wColNameList.add( " and PRO_PRSEQ = ? " );
				wColValList.add( r_prseq+"" );
				wColTypeList.add( "int" );
				productoptionDao.del(sqlMap);
				wColNameList.clear();wColValList.clear();wColTypeList.clear();
				String[] r_pronameArray = r_proname.split(",");
				
				for( String pro_name : r_pronameArray ){
					Productoption productoption = new Productoption();
					
//					productoption.setPRO_SEQ( r_proseq );
					productoption.setPRO_PRSEQ( r_prseq );
					productoption.setPRO_GNAME( r_progname );
					productoption.setPRO_NAME( pro_name );
					productoption.setPRO_VALUE( "" );
					productoption.setPRO_PRICE( 0 );
					productoption.setPRO_STOCK( 0 );
					productoption.setPRO_LEVEL( "1" );
					productoption.setPRO_TYPE( "1" );
					productoption.setPRO_USE( "Y" );
					productoption.setPRO_MOID( ss_mbid );
					productoption.setPRO_INID( ss_mbid );
					
					productoptionDao.in( productoption );
				}
				
			}
			//---productoption In

			
			//---*productGroupIn
			List<Integer> r_prgprseqList = new ArrayList<Integer>();
			List<Integer> r_prgprseqList2 = new ArrayList<Integer>();
			if( 0 != r_prgprseq1 ) r_prgprseqList.add(r_prgprseq1);
			if( 0 != r_prgprseq2 ) r_prgprseqList.add(r_prgprseq2);
			if( 0 != r_prgprseq3 ) r_prgprseqList.add(r_prgprseq3);
			if( 0 != r_prgprseq4 ) r_prgprseqList2.add(r_prgprseq4);
			if( 0 != r_prgprseq5 ) r_prgprseqList2.add(r_prgprseq5);
			if( 0 != r_prgprseq6 ) r_prgprseqList2.add(r_prgprseq6);
			
			ProductgroupDao productgroupDao = new ProductgroupDao( conn );
			productgroupDao.del( " and PRG_PRGSEQ = "+r_prseq );
			for( int prg_prseq : r_prgprseqList ){
				Productgroup productgroup = new Productgroup();
//				productgroup.setPRG_SEQ( r_prgseq );
				productgroup.setPRG_PRGSEQ( r_prseq );
				productgroup.setPRG_PRSEQ( prg_prseq );
				productgroup.setPRG_TYPE( "1" );
				productgroup.setPRG_USE( "Y" );
				productgroup.setPRG_INID( ss_mbid );
				productgroupDao.in( productgroup );
			}
			for( int prg_prseq : r_prgprseqList2 ){
				Productgroup productgroup = new Productgroup();
//				productgroup.setPRG_SEQ( r_prgseq );
				productgroup.setPRG_PRGSEQ( r_prseq );
				productgroup.setPRG_PRSEQ( prg_prseq );
				productgroup.setPRG_TYPE( "2" );
				productgroup.setPRG_USE( "Y" );
				productgroup.setPRG_INID( ss_mbid );
				productgroupDao.in( productgroup );
			}
			
			//---productGroupIn
			

			conn.commit();
			
			//---* model
			model.put( "returnType", "R" );
			model.put( "returnPage", "/product/bo/productview?r_prseq="+r_prseq );
			//--- model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}