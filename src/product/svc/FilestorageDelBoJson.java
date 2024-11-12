package product.svc;

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

public class FilestorageDelBoJson implements Svc{

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

			//---* param
			String r_flsseq = Cvt.toStr( req.getParameter( "r_flsseq" ) );
			//--- param

			//---* Dao
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.add( " and FLS_SEQ = ? " );
			wColValList.add( r_flsseq );
			wColTypeList.add( "int" );

			Filestorage filestorage = filestorageDao.one( sqlMap );
			//--- Dao
			
			//---* 기존 파일, DB 삭제
			FileSvc fileSvc = new FileSvcImpl();
			fileSvc.fileDel( req, "/up/product/"+filestorage.getFLS_INNAME() );
			
			filestorageDao.del(sqlMap);
			//--- 기존파일, DB삭제
			
			ProductDao productDao = new ProductDao( conn );
			productDao.upChoice( "PR_FILENUM", "PR_FILENUM-1", " and PR_SEQ = "+filestorage.getFLS_REFERID() );
			
			conn.commit();
			
			res.setContentType("text");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().print("정상처리되었습니다.");
			
			

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