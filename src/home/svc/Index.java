package home.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.dto.Product;
import productbasket.dao.ProductbasketDao;
import productcategory.dao.ProductcategoryDao;
import productdisplay.dao.ProductdisplayDao;
import productdisplay.dto.Productdisplay;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import filestorage.dao.FilestorageDao;
import filestorage.dto.Filestorage;

public class Index implements Svc{

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
			//--- sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			String r_omseq = Cvt.toStr( req.getParameter( "r_omseq" ) );

			//--- param

			//---* 전체 카테고리 가져오기
			ProductcategoryDao productcategoryDao = new ProductcategoryDao( conn );
			colNameList.add( " PRC_SEQ " );
			colNameList.add( ", PRC_NAME " );
			colNameList.add( ", PRC_GNUM1 " );
			colNameList.add( ", PRC_GNUM2 " );
			colNameList.add( ", PRC_GNUM3 " );
			colNameList.add( ", PRC_LEVEL " );
			
			wColNameList.add( " and PRC_LEVEL != ? " );
			wColValList.add( "0" );
			wColTypeList.add( "int" );
			
			orderStr = " PRC_GNUM1, PRC_GNUM2, PRC_GNUM3, PRC_STEP ";
			sqlMap.put( "orderStr", orderStr );
			List<Map<String, Object>> prcTotalList = productcategoryDao.listChoice(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "" );
			
			
			List<Map<String, Object>> prcList1 = new ArrayList<Map<String, Object>>();
			
			for( Map<String, Object> prcMap1 : prcTotalList ){
				
				if( 1 == (int)prcMap1.get( "PRC_LEVEL" ) ){
					Map<String, Object> nPrcMap1 = new HashMap<String, Object>();
					nPrcMap1.put( "PRC_SEQ", prcMap1.get( "PRC_SEQ" ) );
					nPrcMap1.put( "PRC_NAME", prcMap1.get( "PRC_NAME" ) );
					nPrcMap1.put( "PRC_LEVEL", prcMap1.get( "PRC_LEVEL" ) );
					prcList1.add( nPrcMap1 );
					
					List<Map<String, Object>> prcList2 = new ArrayList<Map<String, Object>>();
					
					for( Map<String, Object> prcMap2 : prcTotalList ){
						
						
						if( 2 == (int)prcMap2.get( "PRC_LEVEL" ) && (int)prcMap2.get( "PRC_GNUM1" ) == (int)prcMap1.get( "PRC_GNUM1" )  ){
							Map<String, Object> nPrcMap2 = new HashMap<String, Object>();
							nPrcMap2.put( "PRC_SEQ", prcMap2.get( "PRC_SEQ" ) );
							nPrcMap2.put( "PRC_NAME", prcMap2.get( "PRC_NAME" ) );
							nPrcMap2.put( "PRC_LEVEL", prcMap2.get( "PRC_LEVEL" ) );
							prcList2.add( nPrcMap2 );
							nPrcMap1.put( "prcList2", prcList2 );
							
							List<Map<String, Object>> prcList3 = new ArrayList<Map<String, Object>>();
							
							for( Map<String, Object> prcMap3 : prcTotalList ){
								
								if( 3 == (int)prcMap3.get( "PRC_LEVEL" ) && (int)prcMap3.get( "PRC_GNUM2" ) == (int)prcMap2.get( "PRC_GNUM2" )  ){
									Map<String, Object> nPrcMap3 = new HashMap<String, Object>();
									nPrcMap3.put( "PRC_SEQ", prcMap3.get( "PRC_SEQ" ) );
									nPrcMap3.put( "PRC_NAME", prcMap3.get( "PRC_NAME" ) );
									nPrcMap3.put( "PRC_LEVEL", prcMap3.get( "PRC_LEVEL" ) );
									prcList3.add( nPrcMap3 );
									nPrcMap2.put( "prcList3", prcList3 );
									
									List<Map<String, Object>> prcList4 = new ArrayList<Map<String, Object>>();
									
									for( Map<String, Object> prcMap4 : prcTotalList ){
										
										if( 4 == (int)prcMap4.get( "PRC_LEVEL" ) && (int)prcMap4.get( "PRC_GNUM3" ) == (int)prcMap3.get( "PRC_GNUM3" )  ){
											Map<String, Object> nPrcMap4 = new HashMap<String, Object>();
											nPrcMap4.put( "PRC_SEQ", prcMap4.get( "PRC_SEQ" ) );
											nPrcMap4.put( "PRC_NAME", prcMap4.get( "PRC_NAME" ) );
											nPrcMap4.put( "PRC_LEVEL", prcMap4.get( "PRC_LEVEL" ) );
											prcList4.add( nPrcMap4 );
											nPrcMap3.put( "prcList4", prcList4 );
											
										}
									}
									
								}
							}
							
						}
					}
					
				}
			}
			//--- 전체 카테고리 가져오기
			
			//---*장바구니cnt
//			ProductbasketDao productbasketDao = new ProductbasketDao(conn);
//			wColNameList.add( " and PRB_MBID = ? " );
//			if( "".equals( ss_mbid ) ){
//				ss_mbid = session.getId();
//			}
//			wColValList.add( ss_mbid );
//			wColTypeList.add( "String" );
//			int prbCnt = productbasketDao.cnt(sqlMap);
//			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			ProductbasketDao productbasketDao = new ProductbasketDao(conn);
			wColNameList.add( " and PRB_MBID = ? " );
			if( "".equals( ss_mbid ) ){
				ss_mbid = session.getId();
			}
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			Map<String, Object> topPrbList = productbasketDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			model.put( "topPrbList", topPrbList );
			//---장바구니cnt
			
			//---*mainslider
			FilestorageDao filestorageDao = new FilestorageDao( conn );
			wColNameList.add( " and FLS_REFERTABLE = ? " );
			wColValList.add( "mainslider" );
			wColTypeList.add( "String" );
			sqlMap.put( "orderStr", "FLS_REFERID " );
			List<Filestorage> filestorageList = filestorageDao.list( sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---mainslider
			
			//---*best product
			ProductdisplayDao productdisplayDao = new ProductdisplayDao(conn);
			wColNameList.add(" and PRD_TYPE = ? ");
			wColValList.add( "B" );
			wColTypeList.add( "String" );
			wColNameList.add(" and PRD_USE = ? ");
			wColValList.add( "Y" );
			wColTypeList.add( "String" );			
			sqlMap.put( "orderStr", " PRD_SEQ desc " );
			Map<String, Object> bestProductdisplayMap = productdisplayDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---best product
			
			//---*hot product
			wColNameList.add(" and PRD_TYPE = ? ");
			wColValList.add( "H" );
			wColTypeList.add( "String" );
			wColNameList.add(" and PRD_USE = ? ");
			wColValList.add( "Y" );
			wColTypeList.add( "String" );		
			Map<String, Object> hotProductdisplayMap = productdisplayDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---hot product
			
			//---*new product
			wColNameList.add(" and PRD_TYPE = ? ");
			wColValList.add( "N" );
			wColTypeList.add( "String" );
			wColNameList.add(" and PRD_USE = ? ");
			wColValList.add( "Y" );
			wColTypeList.add( "String" );		
			Map<String, Object> newProductdisplayMap = productdisplayDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---new product
			
			//---*popular product
			wColNameList.add(" and PRD_TYPE = ? ");
			wColValList.add( "P" );
			wColTypeList.add( "String" );
			wColNameList.add(" and PRD_USE = ? ");
			wColValList.add( "Y" );
			wColTypeList.add( "String" );		
			Map<String, Object> popularProductdisplayMap = productdisplayDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---popular product
			
			//---*recommend product
			wColNameList.add(" and PRD_TYPE = ? ");
			wColValList.add( "P" );
			wColTypeList.add( "String" );
			Map<String, Object> recommendProductdisplayMap = productdisplayDao.listJoin(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---recommend product
			
			
			conn.commit();
			//--- Dao

			//---* model

			model.put( "prcList1", prcList1 );
//			model.put( "prbCnt", prbCnt );
			model.put( "filestorageList", filestorageList );
			model.put( "bestProductdisplayMap", bestProductdisplayMap );
			model.put( "hotProductdisplayMap", hotProductdisplayMap );
			model.put( "newProductdisplayMap", newProductdisplayMap );
			model.put( "popularProductdisplayMap", popularProductdisplayMap );
			model.put( "recommendProductdisplayMap", recommendProductdisplayMap );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/home/index" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}