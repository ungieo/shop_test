package member.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import productbasket.dao.ProductbasketDao;
import productcategory.dao.ProductcategoryDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;

import commontext.dao.CommontextDao;
import commontext.dto.Commontext;

public class MemberAdd1 implements Svc{

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
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> colNameList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable

			//---* session
			HttpSession session = req.getSession();
			String ss_mbcpid = Cvt.toStr( session.getAttribute( "ss_mbcpid" ) );
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			//---* param
			//--- param

			//---* Dao
			CommontextDao commontextDao = new CommontextDao( conn );
//			wColNameList.add( " AND CMT_CPID = ? ");
//			wColValList.add( ss_mbcpid );
//			wColTypeList.add( "String" );
			wColNameList.add( " AND CMT_GROUPCODE = ? ");
			wColValList.add( "shopinfo" );
			wColTypeList.add( "String" );
			wColNameList.add( " AND CMT_CODE = ? ");
			wColValList.add( "agreement" );
			wColTypeList.add( "String" );
			Commontext agreementtext = commontextDao.one(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
//			wColNameList.add( " AND CMT_CPID = ? ");
//			wColValList.add( ss_mbcpid );
//			wColTypeList.add( "String" );
			wColNameList.add( " AND CMT_GROUPCODE = ? ");
			wColValList.add( "shopinfo" );
			wColTypeList.add( "String" );
			wColNameList.add( " AND CMT_CODE = ? ");
			wColValList.add( "privacy" );
			wColTypeList.add( "String" );
			Commontext privacytext = commontextDao.one(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			
//			ShopinfoDao shopinfoDao = new ShopinfoDao( conn );
//			Shopinfo shopinfo = shopinfoDao.one(sqlMap);
			//--- Dao
			
			
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
					prcList1.add( nPrcMap1 );
					
					List<Map<String, Object>> prcList2 = new ArrayList<Map<String, Object>>();
					
					for( Map<String, Object> prcMap2 : prcTotalList ){
						
						
						if( 2 == (int)prcMap2.get( "PRC_LEVEL" ) && (int)prcMap2.get( "PRC_GNUM1" ) == (int)prcMap1.get( "PRC_GNUM1" )  ){
							Map<String, Object> nPrcMap2 = new HashMap<String, Object>();
							nPrcMap2.put( "PRC_SEQ", prcMap2.get( "PRC_SEQ" ) );
							nPrcMap2.put( "PRC_NAME", prcMap2.get( "PRC_NAME" ) );
							prcList2.add( nPrcMap2 );
							nPrcMap1.put( "prcList2", prcList2 );
							
							List<Map<String, Object>> prcList3 = new ArrayList<Map<String, Object>>();
							
							for( Map<String, Object> prcMap3 : prcTotalList ){
								
								if( 3 == (int)prcMap3.get( "PRC_LEVEL" ) && (int)prcMap3.get( "PRC_GNUM2" ) == (int)prcMap2.get( "PRC_GNUM2" )  ){
									Map<String, Object> nPrcMap3 = new HashMap<String, Object>();
									nPrcMap3.put( "PRC_SEQ", prcMap3.get( "PRC_SEQ" ) );
									nPrcMap3.put( "PRC_NAME", prcMap3.get( "PRC_NAME" ) );
									prcList3.add( nPrcMap3 );
									nPrcMap2.put( "prcList3", prcList3 );
									
									List<Map<String, Object>> prcList4 = new ArrayList<Map<String, Object>>();
									
									for( Map<String, Object> prcMap4 : prcTotalList ){
										
										if( 4 == (int)prcMap4.get( "PRC_LEVEL" ) && (int)prcMap4.get( "PRC_GNUM3" ) == (int)prcMap3.get( "PRC_GNUM3" )  ){
											Map<String, Object> nPrcMap4 = new HashMap<String, Object>();
											nPrcMap4.put( "PRC_SEQ", prcMap4.get( "PRC_SEQ" ) );
											nPrcMap4.put( "PRC_NAME", prcMap4.get( "PRC_NAME" ) );
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
			ProductbasketDao productbasketDao = new ProductbasketDao(conn);
			wColNameList.add( " and PRB_MBID = ? " );
			if( "".equals( ss_mbid ) ){
				ss_mbid = session.getId();
			}
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			int prbCnt = productbasketDao.cnt(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//---장바구니cnt
			
			
			
			conn.commit();


			//---* model
//			model.put( "shopinfo", shopinfo );
			model.put( "agreementtext", agreementtext );
			model.put( "privacytext", privacytext );
			
			model.put( "prcList1", prcList1 );
			model.put( "prbCnt", prbCnt );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/member/memberadd1" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}