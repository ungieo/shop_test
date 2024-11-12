package productwish.svc;

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
import productwish.dao.ProductwishDao;
import productwish.dto.Productwish;
import system.db.svc.DbConn;
import system.db.svc.impl.MysqlDbConnImpl;
import system.db.util.DbUtil;
import system.itf.Svc;
import system.security.Encrypt;
import system.util.CommonUtil;
import system.util.Cvt;

public class ProductwishInAjax implements Svc{

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
			List<String> wColNameList = new ArrayList<String>();
			List<String> wColValList = new ArrayList<String>();
			List<String> wColTypeList = new ArrayList<String>();
			sqlMap.put( "wColNameList", wColNameList );
			sqlMap.put( "wColValList", wColValList );
			sqlMap.put( "wColTypeList", wColTypeList );
			String orderStr = "";
			//---* sql variable
			

			//---* session
			HttpSession session = req.getSession();
			String ss_mbid = Cvt.toStr( session.getAttribute( "ss_mbid" ) );
			//--- session

			
			//---* param
			int r_prseq = Cvt.toInt( req.getParameter( "r_prseq" ) );
//			int r_prwseq = Cvt.toInt( req.getParameter( "r_prwseq") );
//			int r_prwprseq = Cvt.toInt( req.getParameter( "r_prwprseq") );
			int r_prwproseq = Cvt.toInt( req.getParameter( "r_prwproseq") );
			String r_prwlevel = Cvt.nullToStr( req.getParameter( "r_prwlevel"), "N" );
			String r_prwtype = Cvt.nullToStr( req.getParameter( "r_prwtype"), "N" );
			String r_prwuse = Cvt.nullToStr( req.getParameter( "r_prwuse"), "N" );
//			String r_prwmoid = Cvt.toStr( req.getParameter( "r_prwmoid") );
//			String r_prwinid = Cvt.toStr( req.getParameter( "r_prwinid") );
//			Timestamp r_prwmodate =  req.getParameter( "r_prwmodate") );
//			Timestamp r_prwindate =  req.getParameter( "r_prwindate") );
			//---* param

			ProductwishDao productwishDao = new ProductwishDao( conn );
			wColNameList.add( " and PRW_PRSEQ = ? " );
			wColValList.add( r_prseq+"" );
			wColTypeList.add( "int" );
			wColNameList.add( " and PRW_MBID = ? " );
			wColValList.add( ss_mbid );
			wColTypeList.add( "String" );
			int cnt = productwishDao.cnt(sqlMap);
			JSONObject obj = new JSONObject();
			
			if( "".equals( ss_mbid ) ){
				obj.put( "result", false );
				obj.put( "msg", "로그인 후 이용해주십시오." );
			}else if( cnt > 0 ){
				obj.put( "result", false );
				obj.put( "msg", "이미 등록 된 상품입니다." );
			}else{
			
				Productwish productwish = new Productwish();
	
	//			productwish.setPRW_SEQ( r_prwseq );
				productwish.setPRW_PRSEQ( r_prseq );
				productwish.setPRW_PROSEQ( r_prwproseq );
				productwish.setPRW_MBID( ss_mbid );
				productwish.setPRW_LEVEL( r_prwlevel );
				productwish.setPRW_TYPE( r_prwtype );
				productwish.setPRW_USE( r_prwuse );
				productwish.setPRW_MOID( ss_mbid );
				productwish.setPRW_INID( ss_mbid );
	//			productwish.setPRW_MODATE( r_prwmodate );
	//			productwish.setPRW_INDATE( r_prwindate );
	
				
				productwishDao.in( productwish );
				wColNameList.clear();wColValList.clear();wColTypeList.clear();sqlMap.put( "orderStr", "" );
				obj.put( "result", true );
				obj.put( "msg", "관심상품으로 등록되었습니다.");
			}
			conn.commit();
			
			
//			obj.put( "basketCnt", basketCnt );
			
			res.setContentType("text/json");
			res.setCharacterEncoding("utf-8");
			res.setHeader("Cache-Control", "no-cache");    
			res.getWriter().write(obj.toString());
			
		}catch(Exception e){
			CommonUtil.errorHandling(model, e, conn);
		}finally{
			DbUtil.close( conn );
		}
	}
}