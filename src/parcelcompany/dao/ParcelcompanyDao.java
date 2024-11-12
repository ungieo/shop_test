package parcelcompany.dao;

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
import parcelcompany.dto.Parcelcompany;

public class ParcelcompanyDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ParcelcompanyDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Parcelcompany parcelcompany)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into parcelcompany(PC_SEQ, PC_NAME, PC_CPID, PC_URL, PC_LEVEL, PC_TYPE, PC_USE, PC_INID, PC_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, parcelcompany.getPC_SEQ() );
			pstmt.setString( i++, parcelcompany.getPC_NAME() );
			pstmt.setString( i++, parcelcompany.getPC_CPID() );
			pstmt.setString( i++, parcelcompany.getPC_URL() );
			pstmt.setString( i++, parcelcompany.getPC_LEVEL() );
			pstmt.setString( i++, parcelcompany.getPC_TYPE() );
			pstmt.setString( i++, parcelcompany.getPC_USE() );
			pstmt.setString( i++, parcelcompany.getPC_INID() );
//			pstmt.setTimestamp( i++, parcelcompany.getPC_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Parcelcompany insert Error : "+se+" \nsql : "+sql+" \ndto : "+parcelcompany.toStr() );
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
			sql = "select count(*) from parcelcompany";

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
			System.out.println("Parcelcompany cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from parcelcompany";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Parcelcompany cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Parcelcompany one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Parcelcompany parcelcompany = new Parcelcompany();
		String sql = "";
		try{
			sql = "select * from parcelcompany";

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
				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
			}
			return parcelcompany;

		}catch(SQLException se){
			System.out.println("Parcelcompany one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Parcelcompany one(String whereStr, String orderStr)throws SQLException{

		Parcelcompany parcelcompany = new Parcelcompany();
		String sql = "";
		try{
			sql = "select * from parcelcompany";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
			}
			return parcelcompany;

		}catch(SQLException se){
			System.out.println("Parcelcompany one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//oneChoice
	public Map<String, Object> oneChoice( Map<String, Object> sqlMap )throws SQLException{

		List<String> colNameList = (List<String>)sqlMap.get( "colNameList" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from parcelcompany";

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

			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData();
			int colCnt = rsmd.getColumnCount();

			Map<String, Object> parcelcompany = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					parcelcompany.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return parcelcompany;

		}catch(SQLException se){
			System.out.println("Parcelcompany oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Parcelcompany> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Parcelcompany> parcelcompanyList = new ArrayList<Parcelcompany>();
		String sql = "";
		try{
			sql += "select * from parcelcompany";

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
				Parcelcompany parcelcompany = new Parcelcompany();

				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
				parcelcompanyList.add(parcelcompany);
			}
			return parcelcompanyList;

		}catch(SQLException se){
			System.out.println("Parcelcompany list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Parcelcompany> list( String whereStr, String orderStr )throws SQLException{

		List<Parcelcompany> parcelcompanyList = new ArrayList<Parcelcompany>();
		String sql = "";
		try{
			sql += "select * from parcelcompany";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Parcelcompany parcelcompany = new Parcelcompany();

				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
				parcelcompanyList.add(parcelcompany);
			}
			return parcelcompanyList;

		}catch(SQLException se){
			System.out.println("Parcelcompany list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Parcelcompany> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Parcelcompany> parcelcompanyList = new ArrayList<Parcelcompany>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from parcelcompany";

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
				Parcelcompany parcelcompany = new Parcelcompany();

				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
				parcelcompanyList.add(parcelcompany);
			}
			return parcelcompanyList;

		}catch(SQLException se){
			System.out.println("Parcelcompany list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Parcelcompany> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Parcelcompany> parcelcompanyList = new ArrayList<Parcelcompany>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from parcelcompany";

			sql += "select * from parcelcompany";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Parcelcompany parcelcompany = new Parcelcompany();

				parcelcompany.setPC_SEQ( rs.getInt("PC_SEQ") );
				parcelcompany.setPC_NAME( rs.getString("PC_NAME") );
				parcelcompany.setPC_CPID( rs.getString("PC_CPID") );
				parcelcompany.setPC_URL( rs.getString("PC_URL") );
				parcelcompany.setPC_LEVEL( rs.getString("PC_LEVEL") );
				parcelcompany.setPC_TYPE( rs.getString("PC_TYPE") );
				parcelcompany.setPC_USE( rs.getString("PC_USE") );
				parcelcompany.setPC_INID( rs.getString("PC_INID") );
				parcelcompany.setPC_INDATE( rs.getTimestamp("PC_INDATE") );
				parcelcompanyList.add(parcelcompany);
			}
			return parcelcompanyList;

		}catch(SQLException se){
			System.out.println("Parcelcompany list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> parcelcompanyList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from parcelcompany";

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
				Map<String, Object> parcelcompany = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					parcelcompany.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				parcelcompanyList.add(parcelcompany);
			}
			return parcelcompanyList;

		}catch(SQLException se){
			System.out.println("Parcelcompany listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Parcelcompany parcelcompany = ( Parcelcompany )sqlMap.get( "parcelcompany" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update parcelcompany set PC_NAME=?, PC_CPID=?, PC_URL=?, PC_LEVEL=?, PC_TYPE=?, PC_USE=? ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setInt( i++ , parcelcompany.getPC_SEQ() );
			pstmt.setString( i++ , parcelcompany.getPC_NAME() );
			pstmt.setString( i++ , parcelcompany.getPC_CPID() );
			pstmt.setString( i++ , parcelcompany.getPC_URL() );
			pstmt.setString( i++ , parcelcompany.getPC_LEVEL() );
			pstmt.setString( i++ , parcelcompany.getPC_TYPE() );
			pstmt.setString( i++ , parcelcompany.getPC_USE() );
//			pstmt.setString( i++ , parcelcompany.getPC_INID() );
//			pstmt.setTimestamp( i++, parcelcompany.getPC_INDATE() );


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
			System.out.println("Parcelcompany up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Parcelcompany parcelcompany, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update parcelcompany set PC_SEQ=?, PC_NAME=?, PC_CPID=?, PC_URL=?, PC_LEVEL=?, PC_TYPE=?, PC_USE=?, PC_INID=?, PC_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement( sql );
			
			int i = 1;

			pstmt.setInt( i++ , parcelcompany.getPC_SEQ() );
			pstmt.setString( i++ , parcelcompany.getPC_NAME() );
			pstmt.setString( i++ , parcelcompany.getPC_CPID() );
			pstmt.setString( i++ , parcelcompany.getPC_URL() );
			pstmt.setString( i++ , parcelcompany.getPC_LEVEL() );
			pstmt.setString( i++ , parcelcompany.getPC_TYPE() );
			pstmt.setString( i++ , parcelcompany.getPC_USE() );
			pstmt.setString( i++ , parcelcompany.getPC_INID() );
//			pstmt.setTimestamp( i++, parcelcompany.getPC_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Parcelcompany up Error : "+se+" \n sql : "+sql );
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
			sql = "update parcelcompany set ";

			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName+",";
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
			System.out.println("Parcelcompany upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update parcelcompany set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Parcelcompany upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from parcelcompany";

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
			System.out.println("Parcelcompany delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from parcelcompany";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Parcelcompany delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Parcelcompany max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Parcelcompany max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Parcelcompany lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}