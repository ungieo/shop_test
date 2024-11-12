package productoption.dao;

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
import productoption.dto.Productoption;

public class ProductoptionDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductoptionDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Productoption productoption)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into productoption(PRO_SEQ, PRO_PRSEQ, PRO_GNAME, PRO_NAME, PRO_VALUE, PRO_PRICE, PRO_STOCK, PRO_LEVEL, PRO_TYPE, PRO_USE, PRO_MOID, PRO_INID, PRO_MODATE, PRO_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, productoption.getPRO_SEQ() );
			pstmt.setInt( i++, productoption.getPRO_PRSEQ() );
			pstmt.setString( i++, productoption.getPRO_GNAME() );
			pstmt.setString( i++, productoption.getPRO_NAME() );
			pstmt.setString( i++, productoption.getPRO_VALUE() );
			pstmt.setInt( i++, productoption.getPRO_PRICE() );
			pstmt.setInt( i++, productoption.getPRO_STOCK() );
			pstmt.setString( i++, productoption.getPRO_LEVEL() );
			pstmt.setString( i++, productoption.getPRO_TYPE() );
			pstmt.setString( i++, productoption.getPRO_USE() );
			pstmt.setString( i++, productoption.getPRO_MOID() );
			pstmt.setString( i++, productoption.getPRO_INID() );
//			pstmt.setTimestamp( i++, productoption.getPRO_MODATE() );
//			pstmt.setTimestamp( i++, productoption.getPRO_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Productoption insert Error : "+se+" \nsql : "+sql+" \ndto : "+productoption.toStr() );
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
			sql = "select count(*) from productoption";

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
			System.out.println("Productoption cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from productoption";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Productoption cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productoption one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Productoption productoption = new Productoption();
		String sql = "";
		try{
			sql = "select * from productoption";

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
				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
			}
			return productoption;

		}catch(SQLException se){
			System.out.println("Productoption one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productoption one(String whereStr, String orderStr)throws SQLException{

		Productoption productoption = new Productoption();
		String sql = "";
		try{
			sql = "select * from productoption";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
			}
			return productoption;

		}catch(SQLException se){
			System.out.println("Productoption one Error : "+se+" \n sql : "+sql );
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
			sql += " from productoption";

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

			Map<String, Object> productoption = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					productoption.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productoption;

		}catch(SQLException se){
			System.out.println("Productoption oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productoption> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productoption> productoptionList = new ArrayList<Productoption>();
		String sql = "";
		try{
			sql += "select * from productoption";

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
				Productoption productoption = new Productoption();

				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
				productoptionList.add(productoption);
			}
			return productoptionList;

		}catch(SQLException se){
			System.out.println("Productoption list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productoption> list( String whereStr, String orderStr )throws SQLException{

		List<Productoption> productoptionList = new ArrayList<Productoption>();
		String sql = "";
		try{
			sql += "select * from productoption";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productoption productoption = new Productoption();

				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
				productoptionList.add(productoption);
			}
			return productoptionList;

		}catch(SQLException se){
			System.out.println("Productoption list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productoption> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productoption> productoptionList = new ArrayList<Productoption>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productoption";

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
				Productoption productoption = new Productoption();

				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
				productoptionList.add(productoption);
			}
			return productoptionList;

		}catch(SQLException se){
			System.out.println("Productoption list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productoption> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Productoption> productoptionList = new ArrayList<Productoption>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productoption";

			sql += "select * from productoption";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productoption productoption = new Productoption();

				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
				productoption.setPRO_USE( rs.getString("PRO_USE") );
				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
				productoption.setPRO_INID( rs.getString("PRO_INID") );
				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
				productoptionList.add(productoption);
			}
			return productoptionList;

		}catch(SQLException se){
			System.out.println("Productoption list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> productoptionList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from productoption";

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
				Map<String, Object> productoption = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					productoption.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				productoptionList.add(productoption);
			}
			return productoptionList;

		}catch(SQLException se){
			System.out.println("Productoption listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Productoption productoption = ( Productoption )sqlMap.get( "productoption" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update productoption set PRO_SEQ=?, PRO_PRSEQ=?, PRO_GNAME=?, PRO_NAME=?, PRO_VALUE=?, PRO_PRICE=?, PRO_STOCK=?, PRO_LEVEL=?, PRO_TYPE=?, PRO_USE=?, PRO_MOID=?, PRO_INID=?, PRO_MODATE=sysdate(), PRO_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , productoption.getPRO_SEQ() );
			pstmt.setInt( i++ , productoption.getPRO_PRSEQ() );
			pstmt.setString( i++ , productoption.getPRO_GNAME() );
			pstmt.setString( i++ , productoption.getPRO_NAME() );
			pstmt.setString( i++ , productoption.getPRO_VALUE() );
			pstmt.setInt( i++ , productoption.getPRO_PRICE() );
			pstmt.setInt( i++ , productoption.getPRO_STOCK() );
			pstmt.setString( i++ , productoption.getPRO_LEVEL() );
			pstmt.setString( i++ , productoption.getPRO_TYPE() );
			pstmt.setString( i++ , productoption.getPRO_USE() );
			pstmt.setString( i++ , productoption.getPRO_MOID() );
			pstmt.setString( i++ , productoption.getPRO_INID() );
//			pstmt.setTimestamp( i++, productoption.getPRO_MODATE() );
//			pstmt.setTimestamp( i++, productoption.getPRO_INDATE() );


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
			System.out.println("Productoption up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Productoption productoption, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update productoption set PRO_SEQ=?, PRO_PRSEQ=?, PRO_GNAME=?, PRO_NAME=?, PRO_VALUE=?, PRO_PRICE=?, PRO_STOCK=?, PRO_LEVEL=?, PRO_TYPE=?, PRO_USE=?, PRO_MOID=?, PRO_INID=?, PRO_MODATE=sysdate(), PRO_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 1;

			pstmt.setInt( i++ , productoption.getPRO_SEQ() );
			pstmt.setInt( i++ , productoption.getPRO_PRSEQ() );
			pstmt.setString( i++ , productoption.getPRO_GNAME() );
			pstmt.setString( i++ , productoption.getPRO_NAME() );
			pstmt.setString( i++ , productoption.getPRO_VALUE() );
			pstmt.setInt( i++ , productoption.getPRO_PRICE() );
			pstmt.setInt( i++ , productoption.getPRO_STOCK() );
			pstmt.setString( i++ , productoption.getPRO_LEVEL() );
			pstmt.setString( i++ , productoption.getPRO_TYPE() );
			pstmt.setString( i++ , productoption.getPRO_USE() );
			pstmt.setString( i++ , productoption.getPRO_MOID() );
			pstmt.setString( i++ , productoption.getPRO_INID() );
//			pstmt.setTimestamp( i++, productoption.getPRO_MODATE() );
//			pstmt.setTimestamp( i++, productoption.getPRO_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productoption up Error : "+se+" \n sql : "+sql );
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
			sql = "update productoption set ";

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
			System.out.println("Productoption upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update productoption set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productoption upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from productoption";

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
			System.out.println("Productoption delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from productoption";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productoption delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productoption max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Productoption max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productoption lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}