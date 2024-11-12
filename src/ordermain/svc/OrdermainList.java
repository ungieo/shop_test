package ordermain.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ordermain.dao.OrdermainDao;
import ordermain.dto.Ordermain;
import productbasket.dao.ProductbasketDao;
import productcategory.dao.ProductcategoryDao;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.util.CommonUtil;
import system.util.Cvt;
import system.util.Pageing;
import board.dao.BoardDao;
import board.dto.Board;

public class OrdermainList implements Svc{

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

			//--- param
			
			

			//---* param
			String r_omseq = Cvt.toStr( req.getParameter( "r_omseq" ) );
			
			int r_page = Cvt.toInt( req.getParameter( "r_page" ) );
			int r_pagelimit = Cvt.toInt( req.getParameter( "r_pagelimit" ) );
			int r_rowlimit = Cvt.toInt( req.getParameter( "r_rowlimit" ) );

			//--- param

			if( r_page == 0 ) r_page = 1;
			if( r_pagelimit == 0 ) r_pagelimit = 10;
			if( r_rowlimit == 0 ) r_rowlimit = 10;

			//---* Dao
			OrdermainDao ordermainDao = new OrdermainDao( conn );
//			wColNameList.add();
//			wColValList.add();
//			wColTypeList.add();
			sqlMap.put( "orderStr", orderStr );

			int totCnt = ordermainDao.cnt( sqlMap );
			List<Ordermain> ordermainList = ordermainDao.list( r_page, r_rowlimit, sqlMap );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();
			//--- Dao

			Pageing.getTotalPage( totCnt, r_page, r_pagelimit, r_rowlimit, model );
			

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
			ProductbasketDao productbasketDao = new ProductbasketDao(conn);
			wColNameList.add( " and PRB_MBID = ? " );
			if( "".equals( ss_mbid ) ){
				ss_mbid = session.getId();
			}
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			int prbCnt = productbasketDao.cnt(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "");
			//---장바구니cnt
			
			
			BoardDao boardDao =new BoardDao(conn);
			wColNameList.add( " and BD_TYPE = ? ");
			wColValList.add( "N" );
			wColTypeList.add( "String" );
			wColNameList.add( " and BD_USE = ? ");
			wColValList.add( "Y" );
			wColTypeList.add( "String" );
			orderStr = " BD_ID ";
			List<Board> boardList = boardDao.list(sqlMap);
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "");
			//--- Dao
			
			conn.commit();

			//---* model

			model.put( "totCnt", totCnt );
			model.put( "r_page", r_page );
			model.put( "r_pagelimit", r_pagelimit );
			model.put( "r_rowlimit", r_rowlimit );
			model.put( "ordermainList", ordermainList );
			
			model.put( "prcList1", prcList1 );
			model.put( "prbCnt", prbCnt );
			
			model.put( "boardList", boardList );
			
			model.put( "returnType", "F" );
			model.put( "returnPage", "/ordermain/ordermainlist" );
			//---* model

		}catch(Exception e){
			CommonUtil.errorHandling( model, e, conn );
		}finally{
			DbUtil.close( conn );
		}
	}
}