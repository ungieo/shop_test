package ordermainitemaddress.dao;

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
import ordermainitemaddress.dto.Ordermainitemaddress;

public class OrdermainitemaddressDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OrdermainitemaddressDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Ordermainitemaddress ordermainitemaddress)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into ordermainitemaddress(OMIA_SEQ, OMIA_OMISEQ, OMIA_NAME, OMIA_TEL, OMIA_PHONE, OMIA_EMAIL, OMIA_ZIPCODE, OMIA_ADDR1, OMIA_ADDR2, OMIA_TYPE, OMIA_MOID, OMIA_INID, OMIA_MODATE, OMIA_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, ordermainitemaddress.getOMIA_SEQ() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_OMISEQ() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_NAME() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_TEL() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_PHONE() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_EMAIL() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_ZIPCODE() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_ADDR1() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_ADDR2() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_TYPE() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_MOID() );
			pstmt.setString( i++, ordermainitemaddress.getOMIA_INID() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress insert Error : "+se+" \nsql : "+sql+" \ndto : "+ordermainitemaddress.toStr() );
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
			sql = "select count(*) from ordermainitemaddress";

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
			System.out.println("Ordermainitemaddress cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from ordermainitemaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitemaddress one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();
		String sql = "";
		try{
			sql = "select * from ordermainitemaddress";

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
				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
			}
			return ordermainitemaddress;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitemaddress one(String whereStr, String orderStr)throws SQLException{

		Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();
		String sql = "";
		try{
			sql = "select * from ordermainitemaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
			}
			return ordermainitemaddress;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitemaddress> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitemaddress> ordermainitemaddressList = new ArrayList<Ordermainitemaddress>();
		String sql = "";
		try{
			sql += "select * from ordermainitemaddress";

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
				Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();

				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
				ordermainitemaddressList.add(ordermainitemaddress);
			}
			return ordermainitemaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitemaddress> list( String whereStr, String orderStr )throws SQLException{

		List<Ordermainitemaddress> ordermainitemaddressList = new ArrayList<Ordermainitemaddress>();
		String sql = "";
		try{
			sql += "select * from ordermainitemaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();

				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
				ordermainitemaddressList.add(ordermainitemaddress);
			}
			return ordermainitemaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitemaddress> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitemaddress> ordermainitemaddressList = new ArrayList<Ordermainitemaddress>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitemaddress";

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
				Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();

				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
				ordermainitemaddressList.add(ordermainitemaddress);
			}
			return ordermainitemaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitemaddress> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Ordermainitemaddress> ordermainitemaddressList = new ArrayList<Ordermainitemaddress>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitemaddress";

			sql += "select * from ordermainitemaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitemaddress ordermainitemaddress = new Ordermainitemaddress();

				ordermainitemaddress.setOMIA_SEQ( rs.getInt("OMIA_SEQ") );
				ordermainitemaddress.setOMIA_OMISEQ( rs.getString("OMIA_OMISEQ") );
				ordermainitemaddress.setOMIA_NAME( rs.getString("OMIA_NAME") );
				ordermainitemaddress.setOMIA_TEL( rs.getString("OMIA_TEL") );
				ordermainitemaddress.setOMIA_PHONE( rs.getString("OMIA_PHONE") );
				ordermainitemaddress.setOMIA_EMAIL( rs.getString("OMIA_EMAIL") );
				ordermainitemaddress.setOMIA_ZIPCODE( rs.getString("OMIA_ZIPCODE") );
				ordermainitemaddress.setOMIA_ADDR1( rs.getString("OMIA_ADDR1") );
				ordermainitemaddress.setOMIA_ADDR2( rs.getString("OMIA_ADDR2") );
				ordermainitemaddress.setOMIA_TYPE( rs.getString("OMIA_TYPE") );
				ordermainitemaddress.setOMIA_MOID( rs.getString("OMIA_MOID") );
				ordermainitemaddress.setOMIA_INID( rs.getString("OMIA_INID") );
				ordermainitemaddress.setOMIA_MODATE( rs.getTimestamp("OMIA_MODATE") );
				ordermainitemaddress.setOMIA_INDATE( rs.getTimestamp("OMIA_INDATE") );
				ordermainitemaddressList.add(ordermainitemaddress);
			}
			return ordermainitemaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> ordermainitemaddressList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from ordermainitemaddress";

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
				Map<String, Object> ordermainitemaddress = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					ordermainitemaddress.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				ordermainitemaddressList.add(ordermainitemaddress);
			}
			return ordermainitemaddressList;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Ordermainitemaddress ordermainitemaddress = ( Ordermainitemaddress )sqlMap.get( "ordermainitemaddress" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitemaddress set OMIA_SEQ=?, OMIA_OMISEQ=?, OMIA_NAME=?, OMIA_TEL=?, OMIA_PHONE=?, OMIA_EMAIL=?, OMIA_ZIPCODE=?, OMIA_ADDR1=?, OMIA_ADDR2=?, OMIA_TYPE=?, OMIA_MOID=?, OMIA_INID=?, OMIA_MODATE=sysdate(), OMIA_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , ordermainitemaddress.getOMIA_SEQ() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_OMISEQ() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_NAME() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_TEL() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_PHONE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_EMAIL() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ZIPCODE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ADDR1() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ADDR2() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_TYPE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_MOID() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_INID() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_INDATE() );


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
			System.out.println("Ordermainitemaddress up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Ordermainitemaddress ordermainitemaddress, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitemaddress set OMIA_SEQ=?, OMIA_OMISEQ=?, OMIA_NAME=?, OMIA_TEL=?, OMIA_PHONE=?, OMIA_EMAIL=?, OMIA_ZIPCODE=?, OMIA_ADDR1=?, OMIA_ADDR2=?, OMIA_TYPE=?, OMIA_MOID=?, OMIA_INID=?, OMIA_MODATE=sysdate(), OMIA_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , ordermainitemaddress.getOMIA_SEQ() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_OMISEQ() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_NAME() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_TEL() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_PHONE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_EMAIL() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ZIPCODE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ADDR1() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_ADDR2() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_TYPE() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_MOID() );
			pstmt.setString( i++ , ordermainitemaddress.getOMIA_INID() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemaddress.getOMIA_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress up Error : "+se+" \n sql : "+sql );
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
			sql = "update ordermainitemaddress set ";

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
			System.out.println("Ordermainitemaddress upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update ordermainitemaddress set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from ordermainitemaddress";

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
			System.out.println("Ordermainitemaddress delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from ordermainitemaddress";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemaddress delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitemaddress max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Ordermainitemaddress max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitemaddress lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}