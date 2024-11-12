package product.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;
import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import product.dao.ProductDao;
import product.dto.Product;

public class ProductViewBo implements Svc{

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

			//---* param
			String r_prseq = Cvt.toStr( req.getParameter( "r_prseq" ) );

			//--- param

			//---* Dao
			ProductDao productDao = new ProductDao( conn );
			wColNameList.add( " and PR_SEQ = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "int" );
			Product product = productDao.one( sqlMap );
			conn.commit();
			//--- Dao
			
			//---* 파일가져오기
			FilestorageDao filestorageDao = new FilestorageDao(conn);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "product" );
			wColTypeList.add( "String" );
			wColNameList.add( " and FLS_REFERID = ? " );
			wColValList.add( r_prseq );
			wColTypeList.add( "String" );
			List<Filestorage> filestorageList = filestorageDao.list(sqlMap);
			

			//---* model
			model.put( "product", product );
			model.put( "filestorageList", filestorageList );

			model.put( "returnType", "F" );
			model.put( "returnPage", "/product/bo/productview" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}