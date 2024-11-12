package boardarticle.svc;

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
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class FileDown implements Svc{

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
			
			String r_flsseq = Cvt.toStr( req.getParameter( "r_flsseq" ) );
			
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.add( " and FLS_SEQ = ? " );
			wColValList.add( ""+r_flsseq );
			wColTypeList.add( "int" );
			Filestorage filestorage = filestorageDao.one(sqlMap);
			
			FileSvc fileSvc = new FileSvcImpl();
			Map<String, Object> svcMap = new HashMap<String, Object>();
			svcMap.put( "filePath", "/up/boardarticle/"+filestorage.getFLS_INNAME() );
			svcMap.put( "fileName", filestorage.getFLS_NAME() );
			fileSvc.fileDown( req, res, svcMap);

			return;
//			model.put( "returnType", "F" );
//			model.put( "returnPage", "/boardarticle/boardarticleadd" );

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}