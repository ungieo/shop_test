package shopinfo.dao;

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

public class ShopinfoDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ShopinfoDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Shopinfo shopinfo)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into shopinfo(SHOP_ID, SHOP_NAME, SHOP_IP, SHOP_BIZNUM, SHOP_CEONAME, SHOP_UPTAI, SHOP_JONGMOK, SHOP_ZIPCODE, SHOP_ADDR1, SHOP_ADDR2, SHOP_TEL, SHOP_FAX, SHOP_EMAIL, SHOP_DOMAIN, SHOP_TONGSINNUM, SHOP_CSTEL, SHOP_CSEMAIL, SHOP_CSFAX, SHOP_CSTIME, SHOP_SCRNAME, SHOP_SCRDEPART, SHOP_SCRPHONE, SHOP_SCREMAIL, SHOP_AGREEMENT, SHOP_PRIVACY, SHOP_LEVEL, SHOP_TYPE, SHOP_USE, SHOP_MOID, SHOP_INID, SHOP_MODATE, SHOP_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString( i++, shopinfo.getSHOP_ID() );
			pstmt.setString( i++, shopinfo.getSHOP_NAME() );
			pstmt.setString( i++, shopinfo.getSHOP_IP() );
			pstmt.setString( i++, shopinfo.getSHOP_BIZNUM() );
			pstmt.setString( i++, shopinfo.getSHOP_CEONAME() );
			pstmt.setString( i++, shopinfo.getSHOP_UPTAI() );
			pstmt.setString( i++, shopinfo.getSHOP_JONGMOK() );
			pstmt.setString( i++, shopinfo.getSHOP_ZIPCODE() );
			pstmt.setString( i++, shopinfo.getSHOP_ADDR1() );
			pstmt.setString( i++, shopinfo.getSHOP_ADDR2() );
			pstmt.setString( i++, shopinfo.getSHOP_TEL() );
			pstmt.setString( i++, shopinfo.getSHOP_FAX() );
			pstmt.setString( i++, shopinfo.getSHOP_EMAIL() );
			pstmt.setString( i++, shopinfo.getSHOP_DOMAIN() );
			pstmt.setString( i++, shopinfo.getSHOP_TONGSINNUM() );
			pstmt.setString( i++, shopinfo.getSHOP_CSTEL() );
			pstmt.setString( i++, shopinfo.getSHOP_CSEMAIL() );
			pstmt.setString( i++, shopinfo.getSHOP_CSFAX() );
			pstmt.setString( i++, shopinfo.getSHOP_CSTIME() );
			pstmt.setString( i++, shopinfo.getSHOP_SCRNAME() );
			pstmt.setString( i++, shopinfo.getSHOP_SCRDEPART() );
			pstmt.setString( i++, shopinfo.getSHOP_SCRPHONE() );
			pstmt.setString( i++, shopinfo.getSHOP_SCREMAIL() );
			pstmt.setString( i++, shopinfo.getSHOP_AGREEMENT() );
			pstmt.setString( i++, shopinfo.getSHOP_PRIVACY() );
			pstmt.setString( i++, shopinfo.getSHOP_LEVEL() );
			pstmt.setString( i++, shopinfo.getSHOP_TYPE() );
			pstmt.setString( i++, shopinfo.getSHOP_USE() );
			pstmt.setString( i++, shopinfo.getSHOP_MOID() );
			pstmt.setString( i++, shopinfo.getSHOP_INID() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_MODATE() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo insert Error : "+se+" \nsql : "+sql+" \ndto : "+shopinfo.toStr() );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//count
	public int cnt( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "select count(*) from shopinfo";

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
					else if( "String".equals( wColType ) ) pstmt.setString( index++, Cvt.toStr( wColVal ) );
					else if( "long".equals( wColType ) ) pstmt.setLong( index++, Cvt.toLong( wColVal ) );
				}
			}
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo cnt Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//count
	public int cnt(String whereStr )throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "select count(*) from shopinfo";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Shopinfo one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Shopinfo shopinfo = new Shopinfo();
		String sql = "";
		try{
			sql = "select * from shopinfo";

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

			if( rs.next() ){
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
			}
			return shopinfo;

		}catch(SQLException se){
			System.out.println("Shopinfo one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Shopinfo one(String whereStr, String orderStr)throws SQLException{

		Shopinfo shopinfo = new Shopinfo();
		String sql = "";
		try{
			sql = "select * from shopinfo";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
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
			}
			return shopinfo;

		}catch(SQLException se){
			System.out.println("Shopinfo one Error : "+se+" \n sql : "+sql );
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

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Shopinfo shopinfo = ( Shopinfo )sqlMap.get( "shopinfo" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update shopinfo set SHOP_ID=?, SHOP_NAME=?, SHOP_IP=?, SHOP_BIZNUM=?, SHOP_CEONAME=?, SHOP_UPTAI=?, SHOP_JONGMOK=?, SHOP_ZIPCODE=?, SHOP_ADDR1=?, SHOP_ADDR2=?, SHOP_TEL=?, SHOP_FAX=?, SHOP_EMAIL=?, SHOP_DOMAIN=?, SHOP_TONGSINNUM=?, SHOP_CSTEL=?, SHOP_CSEMAIL=?, SHOP_CSFAX=?, SHOP_CSTIME=?, SHOP_SCRNAME=?, SHOP_SCRDEPART=?, SHOP_SCRPHONE=?, SHOP_SCREMAIL=?, SHOP_AGREEMENT=?, SHOP_PRIVACY=?, SHOP_LEVEL=?, SHOP_TYPE=?, SHOP_USE=?, SHOP_MOID=?, SHOP_INID=?, SHOP_MODATE=sysdate(), SHOP_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setString( i++ , shopinfo.getSHOP_ID() );
			pstmt.setString( i++ , shopinfo.getSHOP_NAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_IP() );
			pstmt.setString( i++ , shopinfo.getSHOP_BIZNUM() );
			pstmt.setString( i++ , shopinfo.getSHOP_CEONAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_UPTAI() );
			pstmt.setString( i++ , shopinfo.getSHOP_JONGMOK() );
			pstmt.setString( i++ , shopinfo.getSHOP_ZIPCODE() );
			pstmt.setString( i++ , shopinfo.getSHOP_ADDR1() );
			pstmt.setString( i++ , shopinfo.getSHOP_ADDR2() );
			pstmt.setString( i++ , shopinfo.getSHOP_TEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_FAX() );
			pstmt.setString( i++ , shopinfo.getSHOP_EMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_DOMAIN() );
			pstmt.setString( i++ , shopinfo.getSHOP_TONGSINNUM() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSTEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSEMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSFAX() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSTIME() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRNAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRDEPART() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRPHONE() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCREMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_AGREEMENT() );
			pstmt.setString( i++ , shopinfo.getSHOP_PRIVACY() );
			pstmt.setString( i++ , shopinfo.getSHOP_LEVEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_TYPE() );
			pstmt.setString( i++ , shopinfo.getSHOP_USE() );
			pstmt.setString( i++ , shopinfo.getSHOP_MOID() );
			pstmt.setString( i++ , shopinfo.getSHOP_INID() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_MODATE() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_INDATE() );


			if( !wColValList.isEmpty() ){
				for( int ii = 0, n = wColValList.size(); ii < n; ii++ ){
					Object wColVal = wColValList.get(ii);
					String wColType = wColTypeList.get(ii);
					if( "int".equals( wColType ) ) pstmt.setInt( i++, Cvt.toInt( wColVal ) );
					if( "String".equals( wColType ) ) pstmt.setString( i++, Cvt.toStr( wColVal ) );
					if( "long".equals( wColType ) ) pstmt.setLong( i++, Cvt.toLong( wColVal ) );
				}
			}
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Shopinfo shopinfo, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update shopinfo set SHOP_ID=?, SHOP_NAME=?, SHOP_IP=?, SHOP_BIZNUM=?, SHOP_CEONAME=?, SHOP_UPTAI=?, SHOP_JONGMOK=?, SHOP_ZIPCODE=?, SHOP_ADDR1=?, SHOP_ADDR2=?, SHOP_TEL=?, SHOP_FAX=?, SHOP_EMAIL=?, SHOP_DOMAIN=?, SHOP_TONGSINNUM=?, SHOP_CSTEL=?, SHOP_CSEMAIL=?, SHOP_CSFAX=?, SHOP_CSTIME=?, SHOP_SCRNAME=?, SHOP_SCRDEPART=?, SHOP_SCRPHONE=?, SHOP_SCREMAIL=?, SHOP_AGREEMENT=?, SHOP_PRIVACY=?, SHOP_LEVEL=?, SHOP_TYPE=?, SHOP_USE=?, SHOP_MOID=?, SHOP_INID=?, SHOP_MODATE=sysdate(), SHOP_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setString( i++ , shopinfo.getSHOP_ID() );
			pstmt.setString( i++ , shopinfo.getSHOP_NAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_IP() );
			pstmt.setString( i++ , shopinfo.getSHOP_BIZNUM() );
			pstmt.setString( i++ , shopinfo.getSHOP_CEONAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_UPTAI() );
			pstmt.setString( i++ , shopinfo.getSHOP_JONGMOK() );
			pstmt.setString( i++ , shopinfo.getSHOP_ZIPCODE() );
			pstmt.setString( i++ , shopinfo.getSHOP_ADDR1() );
			pstmt.setString( i++ , shopinfo.getSHOP_ADDR2() );
			pstmt.setString( i++ , shopinfo.getSHOP_TEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_FAX() );
			pstmt.setString( i++ , shopinfo.getSHOP_EMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_DOMAIN() );
			pstmt.setString( i++ , shopinfo.getSHOP_TONGSINNUM() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSTEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSEMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSFAX() );
			pstmt.setString( i++ , shopinfo.getSHOP_CSTIME() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRNAME() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRDEPART() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCRPHONE() );
			pstmt.setString( i++ , shopinfo.getSHOP_SCREMAIL() );
			pstmt.setString( i++ , shopinfo.getSHOP_AGREEMENT() );
			pstmt.setString( i++ , shopinfo.getSHOP_PRIVACY() );
			pstmt.setString( i++ , shopinfo.getSHOP_LEVEL() );
			pstmt.setString( i++ , shopinfo.getSHOP_TYPE() );
			pstmt.setString( i++ , shopinfo.getSHOP_USE() );
			pstmt.setString( i++ , shopinfo.getSHOP_MOID() );
			pstmt.setString( i++ , shopinfo.getSHOP_INID() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_MODATE() );
//			pstmt.setTimestamp( i++, shopinfo.getSHOP_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo up Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//updateChoice
	public int upChoice( Map<String, Object> sqlMap )throws SQLException{

		List<String> colNameList = (List<String>)sqlMap.get( "colNameList" );
		List<Object> colValList = (List<Object>)sqlMap.get( "colValList" );
		List<String> colTypeList = (List<String>)sqlMap.get( "colTypeList" );

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update shopinfo set ";

			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName +", ";
				}
			}
			
			sql = sql.substring(0, sql.lastIndexOf( "," ) );

			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement( sql );

			int index = 1;
			if( !colValList.isEmpty() ){
				for( int i = 0, n = colValList.size(); i < n; i++ ){
					Object obj = colValList.get(i);
					String colType = colTypeList.get(i);
					if( "int".equals( colType ) ) pstmt.setInt( index++, Cvt.toInt( obj ) );
					if( "String".equals( colType ) ) pstmt.setString( index++, Cvt.toStr( obj ) );
					if( "long".equals( colType ) ) pstmt.setLong( index++, Cvt.toLong( obj ) );
				}
			}
			if( !wColValList.isEmpty() ){
				for( int i = 0, n = wColValList.size(); i < n; i++ ){
					Object obj = wColValList.get(i);
					String wColType = wColTypeList.get(i);
					if( "int".equals( wColType ) ) pstmt.setInt( index++, Cvt.toInt( obj ) );
					if( "String".equals( wColType ) ) pstmt.setString( index++, Cvt.toStr( obj ) );
					if( "long".equals( wColType ) ) pstmt.setLong( index++, Cvt.toLong( obj ) );
				}
			}
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo upChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//updateChoice
	public int upChoice(String colNames, String colVals, String whereStr)throws SQLException{

		String[] colnamearr = colNames.split(",");
		String[] colvalarr = colVals.split(",");
		int result = 0;
		String sql = "";
		try{
			sql = "update shopinfo set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo upChoice Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//delete
	public int del( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "delete from shopinfo";

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
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo delete Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//delete
	public int del(String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "delete from shopinfo";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo delete Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//max
	public int max( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		String maxColName = Cvt.toStr( sqlMap.get( "maxColName" ) );
		String tableName = Cvt.toStr( sqlMap.get( "tableName" ) );
		int result = 0;
		String sql = "";
		try{
			sql = "select max( "+maxColName+" ) from "+tableName+"";

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

			if( rs.next() ) result = rs.getInt( 1 );

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo max Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//max
	public int max( String tableName, String colName, String whereStr )throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "select max( ? ) from ?";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, colName );
			pstmt.setString(2, tableName );
			rs = pstmt.executeQuery();

			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo max Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//last
	public int lastId()throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "select LAST_INSERT_ID()";
			pstmt = conn.prepareStatement( sql );
			rs = pstmt.executeQuery();

			rs.next();
			result = rs.getInt(1);
			return result;

		}catch(SQLException se){
			System.out.println("Shopinfo lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}