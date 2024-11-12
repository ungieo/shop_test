package productbasket.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.dto.Member;
import memberlog.dao.MemberlogDao;
import memberlog.dto.Memberlog;

import org.json.simple.JSONObject;

import productbasket.dao.ProductbasketDao;
import productbasket.dto.Productbasket;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;

public class ProductbasketUpAjax implements Svc{

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
			Map<String, Object> sqlMap = new HashMap<String, Object>();
			List<String> colNameList = new ArrayList<String>();
			List<Object> colValList = new ArrayList<Object>();
			List<String> colTypeList = new ArrayList<String>();
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "colNameList", colNameList );
			sqlMap.put( "colValList", colValList );
			sqlMap.put( "colTypeList", colTypeList );
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable
			

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			if( "".equals( ss_mbid ) ){
				ss_mbid = session.getId();
			}
			
			//---* param
//			int r_prseq = Cvt.toInt( req.getParameter("r_prseq" ) );
			
			int r_prbseq = Cvt.toInt( req.getParameter( "r_prbseq") );
//			String r_prbprseq = Cvt.toStr( req.getParameter( "r_prbprseq") );
//			String r_prbmbid = Cvt.toStr( req.getParameter( "r_prbmbid") );
			int r_prbproseq = Cvt.toInt( req.getParameter( "r_prbproseq") );
			int r_prbea = Cvt.toInt( req.getParameter( "r_prbea") );
			String r_prbtype = Cvt.nullToStr( req.getParameter( "r_prbtype"), "N" );
//			Timestamp r_prbindate =  req.getParameter( "r_prbindate") );
			//---* param

			ProductbasketDao productbasketDao = new ProductbasketDao( conn );
			
			//---* dto setting
//			Productbasket productbasket = new Productbasket();
//			wColNameList.add( " and PRB_SEQ = ? " );
//			wColValList.add( r_prbseq+"" );
//			wColTypeList.add( "int" );
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "" );
			
//			productbasket.setPRB_SEQ( r_prbseq );
//			productbasket.setPRB_PRSEQ( r_prbprseq );
//			productbasket.setPRB_MBID( ss_mbid );
//			productbasket.setPRB_PROSEQ( r_prbproseq );
//			productbasket.setPRB_EA( r_prbea );
//			productbasket.setPRB_TYPE( r_prbtype );
//			productbasket.setPRB_MOID( ss_mbid );
//			productbasket.setPRB_INID( ss_mbid );
//			productbasket.setPRB_INDATE( r_prbindate );
			//--- dto setting

			//---* Dao
			
			
			//--- Dao
			if( r_prbproseq > 0 ){
				colNameList.add( " PRB_PROSEQ=? " );colValList.add(r_prbproseq);colTypeList.add("int");
			}
			
			if( r_prbea > 0 ){
				colNameList.add( " PRB_EA=? " );colValList.add(r_prbea);colTypeList.add("int");
			}
			
			wColNameList.add( " and PRB_SEQ = ? " );
			wColValList.add( r_prbseq+"" );
			wColTypeList.add( "int" );
			
			productbasketDao.upChoice(sqlMap);
			
			colNameList.clear();colValList.clear();colTypeList.clear();
			wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "" );
			
			conn.commit();
			
			JSONObject obj2 = new JSONObject();
			obj2.put( "result", true );
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj2.toString());
			
		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}