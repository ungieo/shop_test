package statistics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import system.db.util.DbUtil;
import system.util.Cvt;
import shopinfo.dto.Shopinfo;

public class StatisticsDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public StatisticsDao(Connection conn){ this.conn = conn; }

	public Map<String, Object> weekJoinMember( Map<String, Object> sqlMap )throws SQLException{
		
		Map<String, Object> daoMap = new HashMap<String, Object>();
		String sql = "";
		
		try{
			sql += " select ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+0) ) day0, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+1) ) day1, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+2) ) day2, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+3) ) day3, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+4) ) day4, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+5) ) day5, ";
			sql += " ( select count(*) from member where date_format( mb_indate,'%Y%m%d' ) = ( curdate()+6) ) day6 ";
			sql += " from dual ";

			pstmt = conn.prepareStatement( sql );

			rs = pstmt.executeQuery();
			rs.next();
			
			daoMap.put( "day0", rs.getInt( "day0" ) );
			daoMap.put( "day1", rs.getInt( "day1" ) );
			daoMap.put( "day2", rs.getInt( "day2" ) );
			daoMap.put( "day3", rs.getInt( "day3" ) );
			daoMap.put( "day4", rs.getInt( "day4" ) );
			daoMap.put( "day5", rs.getInt( "day5" ) );
			daoMap.put( "day6", rs.getInt( "day6" ) );
			
			return daoMap;

		}catch(SQLException se){
			System.out.println("weekJoinMember list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
		
		
	public Map<String, Object> monthJoinMember( Map<String, Object> sqlMap )throws SQLException{
		
		Map<String, Object> daoMap = new HashMap<String, Object>();
		String sql = "";
		
		try{
			sql += " select ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m') ) ) month0, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-1 ) ) month1, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-2 ) ) month2, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-3 ) ) month3, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-4 ) ) month4, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-5 ) ) month5, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-6 ) ) month6, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-7 ) ) month7, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-8 ) ) month8, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-9 ) ) month9, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-10 ) ) month10, ";
			sql += " (select count(*) from member where date_format(mb_indate,'%Y%m') = ( date_format(now(),'%Y%m')-11 ) ) month11 ";
			sql += " from dual ";

			pstmt = conn.prepareStatement( sql );

			rs = pstmt.executeQuery();
			rs.next();
			
			daoMap.put( "month0", rs.getInt( "month0" ) );
			daoMap.put( "month1", rs.getInt( "month1" ) );
			daoMap.put( "month2", rs.getInt( "month2" ) );
			daoMap.put( "month3", rs.getInt( "month3" ) );
			daoMap.put( "month4", rs.getInt( "month4" ) );
			daoMap.put( "month5", rs.getInt( "month5" ) );
			daoMap.put( "month6", rs.getInt( "month6" ) );
			daoMap.put( "month7", rs.getInt( "month7" ) );
			daoMap.put( "month8", rs.getInt( "month8" ) );
			daoMap.put( "month9", rs.getInt( "month9" ) );
			daoMap.put( "month10", rs.getInt( "month10" ) );
			daoMap.put( "month11", rs.getInt( "month11" ) );
			
			return daoMap;

		}catch(SQLException se){
			System.out.println("monthJoinMember list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		
	}
	
	
	//list
	public List<Shopinfo> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Shopinfo> shopinfoList = new ArrayList<Shopinfo>();
		String sql = "";
		try{
			sql += "select * from shopinfo";

			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement( sql );

			int index = 1;
			if( !wColValList.isEmpty() ){
				for( int i = 0, n = wColValList.size(); i < n; i++ ){
					Object wColVal = wColValList.get(i);
					String wColType = wColTypeList.get(i);
					if( "int".equals( wColType ) ) pstmt.setInt( index++, Cvt.toInt( wColVal ) );
					if( "String".equals( wColType ) ) pstmt.setString( index++, Cvt.toStr( wColVal ) );
					if( "long".equals( wColType ) ) pstmt.setLong( index++, Cvt.toLong( wColVal ) );
				}
			}
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Shopinfo shopinfo = new Shopinfo();

				shopinfo.setSHOP_ID( rs.getString("SHOP_ID") );
				shopinfo.setSHOP_NAME( rs.getString("SHOP_NAME") );
				shopinfo.setSHOP_IP( rs.getString("SHOP_IP") );
				shopinfo.setSHOP_BIZNUM( rs.getString("SHOP_BIZNUM") );
				shopinfo.setSHOP_CEONAME( rs.getString("SHOP_CEONAME") );
				shopinfo.setSHOP_UPTAI( rs.getString("SHOP_UPTAI") );
				shopinfo.setSHOP_JONGMOK( rs.getString("SHOP_JONGMOK") );
				shopinfo.setSHOP_ZIPCODE( rs.getString("SHOP_ZIPCODE") );
				shopinfo.setSHOP_ADDR1( rs.getString("SHOP_ADDR1") );
				shopinfo.setSHOP_ADDR2( rs.getString("SHOP_ADDR2") );
				shopinfo.setSHOP_TEL( rs.getString("SHOP_TEL") );
				shopinfo.setSHOP_FAX( rs.getString("SHOP_FAX") );
				shopinfo.setSHOP_EMAIL( rs.getString("SHOP_EMAIL") );
				shopinfo.setSHOP_DOMAIN( rs.getString("SHOP_DOMAIN") );
				shopinfo.setSHOP_TONGSINNUM( rs.getString("SHOP_TONGSINNUM") );
				shopinfo.setSHOP_CSTEL( rs.getString("SHOP_CSTEL") );
				shopinfo.setSHOP_CSEMAIL( rs.getString("SHOP_CSEMAIL") );
				shopinfo.setSHOP_CSFAX( rs.getString("SHOP_CSFAX") );
				shopinfo.setSHOP_CSTIME( rs.getString("SHOP_CSTIME") );
				shopinfo.setSHOP_SCRNAME( rs.getString("SHOP_SCRNAME") );
				shopinfo.setSHOP_SCRDEPART( rs.getString("SHOP_SCRDEPART") );
				shopinfo.setSHOP_SCRPHONE( rs.getString("SHOP_SCRPHONE") );
				shopinfo.setSHOP_SCREMAIL( rs.getString("SHOP_SCREMAIL") );
				shopinfo.setSHOP_AGREEMENT( rs.getString("SHOP_AGREEMENT") );
				shopinfo.setSHOP_PRIVACY( rs.getString("SHOP_PRIVACY") );
				shopinfo.setSHOP_LEVEL( rs.getString("SHOP_LEVEL") );
				shopinfo.setSHOP_TYPE( rs.getString("SHOP_TYPE") );
				shopinfo.setSHOP_USE( rs.getString("SHOP_USE") );
				shopinfo.setSHOP_MOID( rs.getString("SHOP_MOID") );
				shopinfo.setSHOP_INID( rs.getString("SHOP_INID") );
				shopinfo.setSHOP_MODATE( rs.getTimestamp("SHOP_MODATE") );
				shopinfo.setSHOP_INDATE( rs.getTimestamp("SHOP_INDATE") );
				shopinfoList.add(shopinfo);
			}
			return shopinfoList;

		}catch(SQLException se){
			System.out.println("Shopinfo list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Shopinfo> list( String whereStr, String orderStr )throws SQLException{

		List<Shopinfo> shopinfoList = new ArrayList<Shopinfo>();
		String sql = "";
		try{
			sql += "select * from shopinfo";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Shopinfo shopinfo = new Shopinfo();

				shopinfo.setSHOP_ID( rs.getString("SHOP_ID") );
				shopinfo.setSHOP_NAME( rs.getString("SHOP_NAME") );
				shopinfo.setSHOP_IP( rs.getString("SHOP_IP") );
				shopinfo.setSHOP_BIZNUM( rs.getString("SHOP_BIZNUM") );
				shopinfo.setSHOP_CEONAME( rs.getString("SHOP_CEONAME") );
				shopinfo.setSHOP_UPTAI( rs.getString("SHOP_UPTAI") );
				shopinfo.setSHOP_JONGMOK( rs.getString("SHOP_JONGMOK") );
				shopinfo.setSHOP_ZIPCODE( rs.getString("SHOP_ZIPCODE") );
				shopinfo.setSHOP_ADDR1( rs.getString("SHOP_ADDR1") );
				shopinfo.setSHOP_ADDR2( rs.getString("SHOP_ADDR2") );
				shopinfo.setSHOP_TEL( rs.getString("SHOP_TEL") );
				shopinfo.setSHOP_FAX( rs.getString("SHOP_FAX") );
				shopinfo.setSHOP_EMAIL( rs.getString("SHOP_EMAIL") );
				shopinfo.setSHOP_DOMAIN( rs.getString("SHOP_DOMAIN") );
				shopinfo.setSHOP_TONGSINNUM( rs.getString("SHOP_TONGSINNUM") );
				shopinfo.setSHOP_CSTEL( rs.getString("SHOP_CSTEL") );
				shopinfo.setSHOP_CSEMAIL( rs.getString("SHOP_CSEMAIL") );
				shopinfo.setSHOP_CSFAX( rs.getString("SHOP_CSFAX") );
				shopinfo.setSHOP_CSTIME( rs.getString("SHOP_CSTIME") );
				shopinfo.setSHOP_SCRNAME( rs.getString("SHOP_SCRNAME") );
				shopinfo.setSHOP_SCRDEPART( rs.getString("SHOP_SCRDEPART") );
				shopinfo.setSHOP_SCRPHONE( rs.getString("SHOP_SCRPHONE") );
				shopinfo.setSHOP_SCREMAIL( rs.getString("SHOP_SCREMAIL") );
				shopinfo.setSHOP_AGREEMENT( rs.getString("SHOP_AGREEMENT") );
				shopinfo.setSHOP_PRIVACY( rs.getString("SHOP_PRIVACY") );
				shopinfo.setSHOP_LEVEL( rs.getString("SHOP_LEVEL") );
				shopinfo.setSHOP_TYPE( rs.getString("SHOP_TYPE") );
				shopinfo.setSHOP_USE( rs.getString("SHOP_USE") );
				shopinfo.setSHOP_MOID( rs.getString("SHOP_MOID") );
				shopinfo.setSHOP_INID( rs.getString("SHOP_INID") );
				shopinfo.setSHOP_MODATE( rs.getTimestamp("SHOP_MODATE") );
				shopinfo.setSHOP_INDATE( rs.getTimestamp("SHOP_INDATE") );
				shopinfoList.add(shopinfo);
			}
			return shopinfoList;

		}catch(SQLException se){
			System.out.println("Shopinfo list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Shopinfo> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Shopinfo> shopinfoList = new ArrayList<Shopinfo>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from shopinfo";

			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement( sql );

			int index = 1;
			if( !wColValList.isEmpty() ){
				for( int i = 0, n = wColValList.size(); i < n; i++ ){
					Object wColVal = wColValList.get(i);
					String wColType = wColTypeList.get(i);
					if( "int".equals( wColType ) ) pstmt.setInt( index++, Cvt.toInt( wColVal ) );
					if( "String".equals( wColType ) ) pstmt.setString( index++, Cvt.toStr( wColVal ) );
					if( "long".equals( wColType ) ) pstmt.setLong( index++, Cvt.toLong( wColVal ) );
				}
			}
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Shopinfo shopinfo = new Shopinfo();

				shopinfo.setSHOP_ID( rs.getString("SHOP_ID") );
				shopinfo.setSHOP_NAME( rs.getString("SHOP_NAME") );
				shopinfo.setSHOP_IP( rs.getString("SHOP_IP") );
				shopinfo.setSHOP_BIZNUM( rs.getString("SHOP_BIZNUM") );
				shopinfo.setSHOP_CEONAME( rs.getString("SHOP_CEONAME") );
				shopinfo.setSHOP_UPTAI( rs.getString("SHOP_UPTAI") );
				shopinfo.setSHOP_JONGMOK( rs.getString("SHOP_JONGMOK") );
				shopinfo.setSHOP_ZIPCODE( rs.getString("SHOP_ZIPCODE") );
				shopinfo.setSHOP_ADDR1( rs.getString("SHOP_ADDR1") );
				shopinfo.setSHOP_ADDR2( rs.getString("SHOP_ADDR2") );
				shopinfo.setSHOP_TEL( rs.getString("SHOP_TEL") );
				shopinfo.setSHOP_FAX( rs.getString("SHOP_FAX") );
				shopinfo.setSHOP_EMAIL( rs.getString("SHOP_EMAIL") );
				shopinfo.setSHOP_DOMAIN( rs.getString("SHOP_DOMAIN") );
				shopinfo.setSHOP_TONGSINNUM( rs.getString("SHOP_TONGSINNUM") );
				shopinfo.setSHOP_CSTEL( rs.getString("SHOP_CSTEL") );
				shopinfo.setSHOP_CSEMAIL( rs.getString("SHOP_CSEMAIL") );
				shopinfo.setSHOP_CSFAX( rs.getString("SHOP_CSFAX") );
				shopinfo.setSHOP_CSTIME( rs.getString("SHOP_CSTIME") );
				shopinfo.setSHOP_SCRNAME( rs.getString("SHOP_SCRNAME") );
				shopinfo.setSHOP_SCRDEPART( rs.getString("SHOP_SCRDEPART") );
				shopinfo.setSHOP_SCRPHONE( rs.getString("SHOP_SCRPHONE") );
				shopinfo.setSHOP_SCREMAIL( rs.getString("SHOP_SCREMAIL") );
				shopinfo.setSHOP_AGREEMENT( rs.getString("SHOP_AGREEMENT") );
				shopinfo.setSHOP_PRIVACY( rs.getString("SHOP_PRIVACY") );
				shopinfo.setSHOP_LEVEL( rs.getString("SHOP_LEVEL") );
				shopinfo.setSHOP_TYPE( rs.getString("SHOP_TYPE") );
				shopinfo.setSHOP_USE( rs.getString("SHOP_USE") );
				shopinfo.setSHOP_MOID( rs.getString("SHOP_MOID") );
				shopinfo.setSHOP_INID( rs.getString("SHOP_INID") );
				shopinfo.setSHOP_MODATE( rs.getTimestamp("SHOP_MODATE") );
				shopinfo.setSHOP_INDATE( rs.getTimestamp("SHOP_INDATE") );
				shopinfoList.add(shopinfo);
			}
			return shopinfoList;

		}catch(SQLException se){
			System.out.println("Shopinfo list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Shopinfo> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Shopinfo> shopinfoList = new ArrayList<Shopinfo>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from shopinfo";

			sql += "select * from shopinfo";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Shopinfo shopinfo = new Shopinfo();

				shopinfo.setSHOP_ID( rs.getString("SHOP_ID") );
				shopinfo.setSHOP_NAME( rs.getString("SHOP_NAME") );
				shopinfo.setSHOP_IP( rs.getString("SHOP_IP") );
				shopinfo.setSHOP_BIZNUM( rs.getString("SHOP_BIZNUM") );
				shopinfo.setSHOP_CEONAME( rs.getString("SHOP_CEONAME") );
				shopinfo.setSHOP_UPTAI( rs.getString("SHOP_UPTAI") );
				shopinfo.setSHOP_JONGMOK( rs.getString("SHOP_JONGMOK") );
				shopinfo.setSHOP_ZIPCODE( rs.getString("SHOP_ZIPCODE") );
				shopinfo.setSHOP_ADDR1( rs.getString("SHOP_ADDR1") );
				shopinfo.setSHOP_ADDR2( rs.getString("SHOP_ADDR2") );
				shopinfo.setSHOP_TEL( rs.getString("SHOP_TEL") );
				shopinfo.setSHOP_FAX( rs.getString("SHOP_FAX") );
				shopinfo.setSHOP_EMAIL( rs.getString("SHOP_EMAIL") );
				shopinfo.setSHOP_DOMAIN( rs.getString("SHOP_DOMAIN") );
				shopinfo.setSHOP_TONGSINNUM( rs.getString("SHOP_TONGSINNUM") );
				shopinfo.setSHOP_CSTEL( rs.getString("SHOP_CSTEL") );
				shopinfo.setSHOP_CSEMAIL( rs.getString("SHOP_CSEMAIL") );
				shopinfo.setSHOP_CSFAX( rs.getString("SHOP_CSFAX") );
				shopinfo.setSHOP_CSTIME( rs.getString("SHOP_CSTIME") );
				shopinfo.setSHOP_SCRNAME( rs.getString("SHOP_SCRNAME") );
				shopinfo.setSHOP_SCRDEPART( rs.getString("SHOP_SCRDEPART") );
				shopinfo.setSHOP_SCRPHONE( rs.getString("SHOP_SCRPHONE") );
				shopinfo.setSHOP_SCREMAIL( rs.getString("SHOP_SCREMAIL") );
				shopinfo.setSHOP_AGREEMENT( rs.getString("SHOP_AGREEMENT") );
				shopinfo.setSHOP_PRIVACY( rs.getString("SHOP_PRIVACY") );
				shopinfo.setSHOP_LEVEL( rs.getString("SHOP_LEVEL") );
				shopinfo.setSHOP_TYPE( rs.getString("SHOP_TYPE") );
				shopinfo.setSHOP_USE( rs.getString("SHOP_USE") );
				shopinfo.setSHOP_MOID( rs.getString("SHOP_MOID") );
				shopinfo.setSHOP_INID( rs.getString("SHOP_INID") );
				shopinfo.setSHOP_MODATE( rs.getTimestamp("SHOP_MODATE") );
				shopinfo.setSHOP_INDATE( rs.getTimestamp("SHOP_INDATE") );
				shopinfoList.add(shopinfo);
			}
			return shopinfoList;

		}catch(SQLException se){
			System.out.println("Shopinfo list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listChoice
	public List<Map<String, Object>> listChoice( Map<String, Object> sqlMap )throws SQLException{

		List<String> colNameList = (List<String>)sqlMap.get( "colNameList" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Map<String, Object>> shopinfoList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from shopinfo";

			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement( sql );

			if( !wColValList.isEmpty() ){
				int index = 1;
				for( int i = 0, n = wColValList.size(); i < n; i++ ){
					Object wColVal = wColValList.get(i);
					String wColType = wColTypeList.get(i);
					if( "int".equals( wColType ) ) pstmt.setInt( index++, Cvt.toInt( wColVal ) );
					if( "String".equals( wColType ) ) pstmt.setString( index++, Cvt.toStr( wColVal ) );
					if( "long".equals( wColType ) ) pstmt.setLong( index++, Cvt.toLong( wColVal ) );
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData();
			int colCnt = rsmd.getColumnCount();

			while( rs.next() ){
				Map<String, Object> shopinfo = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					shopinfo.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				shopinfoList.add(shopinfo);
			}
			return shopinfoList;

		}catch(SQLException se){
			System.out.println("Shopinfo listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}




	//----추가 쿼리는 아래 작성!

}