package ordermainitemhistory.dao;

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
import ordermainitemhistory.dto.Ordermainitemhistory;

public class OrdermainitemhistoryDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OrdermainitemhistoryDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Ordermainitemhistory ordermainitemhistory)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into ordermainitemhistory(OMIH_SEQ, OMIH_OMISEQ, OMIH_OMISTATUS, OMIH_OMISTEP, OMIH_MEMO, OMIH_LEVEL, OMIH_TYPE, OMIH_MOID, OMIH_INID, OMIH_MODATE, OMIH_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, ordermainitemhistory.getOMIH_SEQ() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_OMISEQ() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_OMISTATUS() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_OMISTEP() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_MEMO() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_LEVEL() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_TYPE() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_MOID() );
			pstmt.setString( i++, ordermainitemhistory.getOMIH_INID() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory insert Error : "+se+" \nsql : "+sql+" \ndto : "+ordermainitemhistory.toStr() );
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
			sql = "select count(*) from ordermainitemhistory";

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
			System.out.println("Ordermainitemhistory cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from ordermainitemhistory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitemhistory one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();
		String sql = "";
		try{
			sql = "select * from ordermainitemhistory";

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
				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
			}
			return ordermainitemhistory;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitemhistory one(String whereStr, String orderStr)throws SQLException{

		Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();
		String sql = "";
		try{
			sql = "select * from ordermainitemhistory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
			}
			return ordermainitemhistory;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitemhistory> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitemhistory> ordermainitemhistoryList = new ArrayList<Ordermainitemhistory>();
		String sql = "";
		try{
			sql += "select * from ordermainitemhistory";

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
				Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();

				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
				ordermainitemhistoryList.add(ordermainitemhistory);
			}
			return ordermainitemhistoryList;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitemhistory> list( String whereStr, String orderStr )throws SQLException{

		List<Ordermainitemhistory> ordermainitemhistoryList = new ArrayList<Ordermainitemhistory>();
		String sql = "";
		try{
			sql += "select * from ordermainitemhistory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();

				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
				ordermainitemhistoryList.add(ordermainitemhistory);
			}
			return ordermainitemhistoryList;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitemhistory> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitemhistory> ordermainitemhistoryList = new ArrayList<Ordermainitemhistory>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitemhistory";

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
				Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();

				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
				ordermainitemhistoryList.add(ordermainitemhistory);
			}
			return ordermainitemhistoryList;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitemhistory> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Ordermainitemhistory> ordermainitemhistoryList = new ArrayList<Ordermainitemhistory>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitemhistory";

			sql += "select * from ordermainitemhistory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitemhistory ordermainitemhistory = new Ordermainitemhistory();

				ordermainitemhistory.setOMIH_SEQ( rs.getInt("OMIH_SEQ") );
				ordermainitemhistory.setOMIH_OMISEQ( rs.getString("OMIH_OMISEQ") );
				ordermainitemhistory.setOMIH_OMISTATUS( rs.getString("OMIH_OMISTATUS") );
				ordermainitemhistory.setOMIH_OMISTEP( rs.getString("OMIH_OMISTEP") );
				ordermainitemhistory.setOMIH_MEMO( rs.getString("OMIH_MEMO") );
				ordermainitemhistory.setOMIH_LEVEL( rs.getString("OMIH_LEVEL") );
				ordermainitemhistory.setOMIH_TYPE( rs.getString("OMIH_TYPE") );
				ordermainitemhistory.setOMIH_MOID( rs.getString("OMIH_MOID") );
				ordermainitemhistory.setOMIH_INID( rs.getString("OMIH_INID") );
				ordermainitemhistory.setOMIH_MODATE( rs.getTimestamp("OMIH_MODATE") );
				ordermainitemhistory.setOMIH_INDATE( rs.getTimestamp("OMIH_INDATE") );
				ordermainitemhistoryList.add(ordermainitemhistory);
			}
			return ordermainitemhistoryList;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> ordermainitemhistoryList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from ordermainitemhistory";

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
				Map<String, Object> ordermainitemhistory = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					ordermainitemhistory.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				ordermainitemhistoryList.add(ordermainitemhistory);
			}
			return ordermainitemhistoryList;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Ordermainitemhistory ordermainitemhistory = ( Ordermainitemhistory )sqlMap.get( "ordermainitemhistory" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitemhistory set OMIH_SEQ=?, OMIH_OMISEQ=?, OMIH_OMISTATUS=?, OMIH_OMISTEP=?, OMIH_MEMO=?, OMIH_LEVEL=?, OMIH_TYPE=?, OMIH_MOID=?, OMIH_INID=?, OMIH_MODATE=sysdate(), OMIH_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , ordermainitemhistory.getOMIH_SEQ() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISEQ() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISTATUS() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISTEP() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_MEMO() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_LEVEL() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_TYPE() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_MOID() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_INID() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_INDATE() );


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
			System.out.println("Ordermainitemhistory up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Ordermainitemhistory ordermainitemhistory, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitemhistory set OMIH_SEQ=?, OMIH_OMISEQ=?, OMIH_OMISTATUS=?, OMIH_OMISTEP=?, OMIH_MEMO=?, OMIH_LEVEL=?, OMIH_TYPE=?, OMIH_MOID=?, OMIH_INID=?, OMIH_MODATE=sysdate(), OMIH_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , ordermainitemhistory.getOMIH_SEQ() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISEQ() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISTATUS() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_OMISTEP() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_MEMO() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_LEVEL() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_TYPE() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_MOID() );
			pstmt.setString( i++ , ordermainitemhistory.getOMIH_INID() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitemhistory.getOMIH_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory up Error : "+se+" \n sql : "+sql );
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
			sql = "update ordermainitemhistory set ";

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
			System.out.println("Ordermainitemhistory upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update ordermainitemhistory set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from ordermainitemhistory";

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
			System.out.println("Ordermainitemhistory delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from ordermainitemhistory";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitemhistory delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitemhistory max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Ordermainitemhistory max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitemhistory lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}