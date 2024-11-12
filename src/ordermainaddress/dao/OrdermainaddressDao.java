package ordermainaddress.dao;

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
import ordermainaddress.dto.Ordermainaddress;

public class OrdermainaddressDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OrdermainaddressDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Ordermainaddress ordermainaddress)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into ordermainaddress(OMA_SEQ, OMA_OMSEQ, OMA_NAME, OMA_TEL, OMA_PHONE, OMA_EMAIL, OMA_ZIPCODE, OMA_ADDR1, OMA_ADDR2, OMA_TYPE, OMA_MOID, OMA_INID, OMA_MODATE, OMA_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, ordermainaddress.getOMA_SEQ() );
			pstmt.setInt( i++, ordermainaddress.getOMA_OMSEQ() );
			pstmt.setString( i++, ordermainaddress.getOMA_NAME() );
			pstmt.setString( i++, ordermainaddress.getOMA_TEL() );
			pstmt.setString( i++, ordermainaddress.getOMA_PHONE() );
			pstmt.setString( i++, ordermainaddress.getOMA_EMAIL() );
			pstmt.setString( i++, ordermainaddress.getOMA_ZIPCODE() );
			pstmt.setString( i++, ordermainaddress.getOMA_ADDR1() );
			pstmt.setString( i++, ordermainaddress.getOMA_ADDR2() );
			pstmt.setString( i++, ordermainaddress.getOMA_TYPE() );
			pstmt.setString( i++, ordermainaddress.getOMA_MOID() );
			pstmt.setString( i++, ordermainaddress.getOMA_INID() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainaddress insert Error : "+se+" \nsql : "+sql+" \ndto : "+ordermainaddress.toStr() );
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
			sql = "select count(*) from ordermainaddress";

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
			System.out.println("Ordermainaddress cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from ordermainaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainaddress cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainaddress one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Ordermainaddress ordermainaddress = new Ordermainaddress();
		String sql = "";
		try{
			sql = "select * from ordermainaddress";

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
				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
			}
			return ordermainaddress;

		}catch(SQLException se){
			System.out.println("Ordermainaddress one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainaddress one(String whereStr, String orderStr)throws SQLException{

		Ordermainaddress ordermainaddress = new Ordermainaddress();
		String sql = "";
		try{
			sql = "select * from ordermainaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
			}
			return ordermainaddress;

		}catch(SQLException se){
			System.out.println("Ordermainaddress one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainaddress> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainaddress> ordermainaddressList = new ArrayList<Ordermainaddress>();
		String sql = "";
		try{
			sql += "select * from ordermainaddress";

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
				Ordermainaddress ordermainaddress = new Ordermainaddress();

				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
				ordermainaddressList.add(ordermainaddress);
			}
			return ordermainaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainaddress list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainaddress> list( String whereStr, String orderStr )throws SQLException{

		List<Ordermainaddress> ordermainaddressList = new ArrayList<Ordermainaddress>();
		String sql = "";
		try{
			sql += "select * from ordermainaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainaddress ordermainaddress = new Ordermainaddress();

				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
				ordermainaddressList.add(ordermainaddress);
			}
			return ordermainaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainaddress list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainaddress> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainaddress> ordermainaddressList = new ArrayList<Ordermainaddress>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainaddress";

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
				Ordermainaddress ordermainaddress = new Ordermainaddress();

				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
				ordermainaddressList.add(ordermainaddress);
			}
			return ordermainaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainaddress list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainaddress> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Ordermainaddress> ordermainaddressList = new ArrayList<Ordermainaddress>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainaddress";

			sql += "select * from ordermainaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainaddress ordermainaddress = new Ordermainaddress();

				ordermainaddress.setOMA_SEQ( rs.getInt("OMA_SEQ") );
				ordermainaddress.setOMA_OMSEQ( rs.getInt("OMA_OMSEQ") );
				ordermainaddress.setOMA_NAME( rs.getString("OMA_NAME") );
				ordermainaddress.setOMA_TEL( rs.getString("OMA_TEL") );
				ordermainaddress.setOMA_PHONE( rs.getString("OMA_PHONE") );
				ordermainaddress.setOMA_EMAIL( rs.getString("OMA_EMAIL") );
				ordermainaddress.setOMA_ZIPCODE( rs.getString("OMA_ZIPCODE") );
				ordermainaddress.setOMA_ADDR1( rs.getString("OMA_ADDR1") );
				ordermainaddress.setOMA_ADDR2( rs.getString("OMA_ADDR2") );
				ordermainaddress.setOMA_TYPE( rs.getString("OMA_TYPE") );
				ordermainaddress.setOMA_MOID( rs.getString("OMA_MOID") );
				ordermainaddress.setOMA_INID( rs.getString("OMA_INID") );
				ordermainaddress.setOMA_MODATE( rs.getTimestamp("OMA_MODATE") );
				ordermainaddress.setOMA_INDATE( rs.getTimestamp("OMA_INDATE") );
				ordermainaddressList.add(ordermainaddress);
			}
			return ordermainaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainaddress list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> ordermainaddressList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from ordermainaddress";

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
				Map<String, Object> ordermainaddress = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					ordermainaddress.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				ordermainaddressList.add(ordermainaddress);
			}
			return ordermainaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainaddress listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Ordermainaddress ordermainaddress = ( Ordermainaddress )sqlMap.get( "ordermainaddress" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainaddress set OMA_SEQ=?, OMA_OMSEQ=?, OMA_NAME=?, OMA_TEL=?, OMA_PHONE=?, OMA_EMAIL=?, OMA_ZIPCODE=?, OMA_ADDR1=?, OMA_ADDR2=?, OMA_TYPE=?, OMA_MOID=?, OMA_INID=?, OMA_MODATE=sysdate(), OMA_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , ordermainaddress.getOMA_SEQ() );
			pstmt.setInt( i++ , ordermainaddress.getOMA_OMSEQ() );
			pstmt.setString( i++ , ordermainaddress.getOMA_NAME() );
			pstmt.setString( i++ , ordermainaddress.getOMA_TEL() );
			pstmt.setString( i++ , ordermainaddress.getOMA_PHONE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_EMAIL() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ZIPCODE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ADDR1() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ADDR2() );
			pstmt.setString( i++ , ordermainaddress.getOMA_TYPE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_MOID() );
			pstmt.setString( i++ , ordermainaddress.getOMA_INID() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_INDATE() );


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
			System.out.println("Ordermainaddress up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Ordermainaddress ordermainaddress, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainaddress set OMA_SEQ=?, OMA_OMSEQ=?, OMA_NAME=?, OMA_TEL=?, OMA_PHONE=?, OMA_EMAIL=?, OMA_ZIPCODE=?, OMA_ADDR1=?, OMA_ADDR2=?, OMA_TYPE=?, OMA_MOID=?, OMA_INID=?, OMA_MODATE=sysdate(), OMA_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , ordermainaddress.getOMA_SEQ() );
			pstmt.setInt( i++ , ordermainaddress.getOMA_OMSEQ() );
			pstmt.setString( i++ , ordermainaddress.getOMA_NAME() );
			pstmt.setString( i++ , ordermainaddress.getOMA_TEL() );
			pstmt.setString( i++ , ordermainaddress.getOMA_PHONE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_EMAIL() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ZIPCODE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ADDR1() );
			pstmt.setString( i++ , ordermainaddress.getOMA_ADDR2() );
			pstmt.setString( i++ , ordermainaddress.getOMA_TYPE() );
			pstmt.setString( i++ , ordermainaddress.getOMA_MOID() );
			pstmt.setString( i++ , ordermainaddress.getOMA_INID() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainaddress.getOMA_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainaddress up Error : "+se+" \n sql : "+sql );
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
			sql = "update ordermainaddress set ";

			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql = sql.substring( 0, sql.lastIndexOf( "," ) );

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
			System.out.println("Ordermainaddress upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update ordermainaddress set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainaddress upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from ordermainaddress";

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
			System.out.println("Ordermainaddress delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from ordermainaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainaddress delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainaddress max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Ordermainaddress max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainaddress lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}