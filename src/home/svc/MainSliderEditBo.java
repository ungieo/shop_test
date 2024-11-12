package home.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.dao.CompanyDao;

import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;
import system.db.svc.DbConn;
import system.db.util.DbUtil;
import system.db.svc.impl.MysqlDbConnImpl;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import product.dao.ProductDao;
import product.dto.Product;
import productcategory.dao.ProductcategoryDao;
import productcategory.dto.Productcategory;

public class MainSliderEditBo implements Svc{

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
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_prseq = Cvt.toStr( req.getParameter( "r_prseq" ) );
			//--- param

			//---* 파일리스트
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "mainslider" );
			wColTypeList.add( "String" );
//			wColNameList.add( " and FLS_REFERID = ? " );
//			wColValList.add( "mainslider" );
//			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", "FLS_REFERID " );
			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			//---파일리스트
			
			conn.commit();
			
			//---* model
			
			model.put( "filestorageList", filestorageList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/home/bo/mainslideredit" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close(conn);
		}
	}
}