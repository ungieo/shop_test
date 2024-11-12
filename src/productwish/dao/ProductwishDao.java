package productwish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product.dto.Product;
import productwish.dto.Productwish;
import system.db.util.DbUtil;
import system.util.Cvt;

public class ProductwishDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductwishDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Productwish productwish)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into productwish(PRW_SEQ, PRW_PRSEQ, PRW_PROSEQ, PRW_MBID, PRW_LEVEL, PRW_TYPE, PRW_USE, PRW_MOID, PRW_INID, PRW_MODATE, PRW_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, productwish.getPRW_SEQ() );
			pstmt.setInt( i++, productwish.getPRW_PRSEQ() );
			pstmt.setInt( i++, productwish.getPRW_PROSEQ() );
			pstmt.setString( i++, productwish.getPRW_MBID() );
			pstmt.setString( i++, productwish.getPRW_LEVEL() );
			pstmt.setString( i++, productwish.getPRW_TYPE() );
			pstmt.setString( i++, productwish.getPRW_USE() );
			pstmt.setString( i++, productwish.getPRW_MOID() );
			pstmt.setString( i++, productwish.getPRW_INID() );
//			pstmt.setTimestamp( i++, productwish.getPRW_MODATE() );
//			pstmt.setTimestamp( i++, productwish.getPRW_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Productwish insert Error : "+se+" \nsql : "+sql+" \ndto : "+productwish.toStr() );
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
			sql = "select count(*) from productwish";

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
			System.out.println("Productwish cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from productwish";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Productwish cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productwish one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Productwish productwish = new Productwish();
		String sql = "";
		try{
			sql = "select * from productwish";

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
				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
			}
			return productwish;

		}catch(SQLException se){
			System.out.println("Productwish one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productwish one(String whereStr, String orderStr)throws SQLException{

		Productwish productwish = new Productwish();
		String sql = "";
		try{
			sql = "select * from productwish";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
			}
			return productwish;

		}catch(SQLException se){
			System.out.println("Productwish one Error : "+se+" \n sql : "+sql );
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
			sql += " from productwish";

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

			Map<String, Object> productwish = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					productwish.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productwish;

		}catch(SQLException se){
			System.out.println("Productwish oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productwish> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productwish> productwishList = new ArrayList<Productwish>();
		String sql = "";
		try{
			sql += "select * from productwish";

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
				Productwish productwish = new Productwish();

				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
				productwishList.add(productwish);
			}
			return productwishList;

		}catch(SQLException se){
			System.out.println("Productwish list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productwish> list( String whereStr, String orderStr )throws SQLException{

		List<Productwish> productwishList = new ArrayList<Productwish>();
		String sql = "";
		try{
			sql += "select * from productwish";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productwish productwish = new Productwish();

				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
				productwishList.add(productwish);
			}
			return productwishList;

		}catch(SQLException se){
			System.out.println("Productwish list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productwish> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productwish> productwishList = new ArrayList<Productwish>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productwish";

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
				Productwish productwish = new Productwish();

				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
				productwishList.add(productwish);
			}
			return productwishList;

		}catch(SQLException se){
			System.out.println("Productwish list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productwish> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Productwish> productwishList = new ArrayList<Productwish>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productwish";

			sql += "select * from productwish";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productwish productwish = new Productwish();

				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_MBID( rs.getString("PRW_MBID") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
				productwishList.add(productwish);
			}
			return productwishList;

		}catch(SQLException se){
			System.out.println("Productwish list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> productwishList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from productwish";

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
				Map<String, Object> productwish = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					productwish.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				productwishList.add(productwish);
			}
			return productwishList;

		}catch(SQLException se){
			System.out.println("Productwish listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Productwish productwish = ( Productwish )sqlMap.get( "productwish" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update productwish set PRW_SEQ=?, PRW_PRSEQ=?, PRW_PROSEQ=?, PRW_MBID=?, PRW_LEVEL=?, PRW_TYPE=?, PRW_USE=?, PRW_MOID=?, PRW_INID=?, PRW_MODATE=sysdate(), PRW_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , productwish.getPRW_SEQ() );
			pstmt.setInt( i++ , productwish.getPRW_PRSEQ() );
			pstmt.setInt( i++ , productwish.getPRW_PROSEQ() );
			pstmt.setString( i++ , productwish.getPRW_MBID() );
			pstmt.setString( i++ , productwish.getPRW_LEVEL() );
			pstmt.setString( i++ , productwish.getPRW_TYPE() );
			pstmt.setString( i++ , productwish.getPRW_USE() );
			pstmt.setString( i++ , productwish.getPRW_MOID() );
			pstmt.setString( i++ , productwish.getPRW_INID() );
//			pstmt.setTimestamp( i++, productwish.getPRW_MODATE() );
//			pstmt.setTimestamp( i++, productwish.getPRW_INDATE() );


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
			System.out.println("Productwish up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Productwish productwish, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update productwish set PRW_SEQ=?, PRW_PRSEQ=?, PRW_PROSEQ=?, PRW_MBID=?, PRW_LEVEL=?, PRW_TYPE=?, PRW_USE=?, PRW_MOID=?, PRW_INID=?, PRW_MODATE=sysdate(), PRW_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , productwish.getPRW_SEQ() );
			pstmt.setInt( i++ , productwish.getPRW_PRSEQ() );
			pstmt.setInt( i++ , productwish.getPRW_PROSEQ() );
			pstmt.setString( i++ , productwish.getPRW_MBID() );
			pstmt.setString( i++ , productwish.getPRW_LEVEL() );
			pstmt.setString( i++ , productwish.getPRW_TYPE() );
			pstmt.setString( i++ , productwish.getPRW_USE() );
			pstmt.setString( i++ , productwish.getPRW_MOID() );
			pstmt.setString( i++ , productwish.getPRW_INID() );
//			pstmt.setTimestamp( i++, productwish.getPRW_MODATE() );
//			pstmt.setTimestamp( i++, productwish.getPRW_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productwish up Error : "+se+" \n sql : "+sql );
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
			sql = "update productwish set ";

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
			System.out.println("Productwish upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update productwish set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productwish upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from productwish";

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
			System.out.println("Productwish delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from productwish";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productwish delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productwish max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Productwish max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productwish lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

	//count
	public int cntJoin( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql += "select count(*) from productwish prw";
			sql += " LEFT OUTER JOIN product pr ON prw.PRW_PRSEQ = pr.PR_SEQ ";

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
			System.out.println("Productwish cnt Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	
	
	//list
	public Map<String, Object> listJoin( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Map<String, Object> productwishMap = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		List<Productwish> productwishList = new ArrayList<Productwish>();
		
		String sql = "";
		try{
			sql += "select * from productwish prw";
			sql += " LEFT OUTER JOIN product pr ON prw.PRW_PRSEQ = pr.PR_SEQ ";

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
				Product product = new Product();
				Productwish productwish = new Productwish();
				
				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);

				productwish.setPRW_SEQ( rs.getInt("PRW_SEQ") );
				productwish.setPRW_PRSEQ( rs.getInt("PRW_PRSEQ") );
				productwish.setPRW_PROSEQ( rs.getInt("PRW_PROSEQ") );
				productwish.setPRW_LEVEL( rs.getString("PRW_LEVEL") );
				productwish.setPRW_TYPE( rs.getString("PRW_TYPE") );
				productwish.setPRW_USE( rs.getString("PRW_USE") );
				productwish.setPRW_MOID( rs.getString("PRW_MOID") );
				productwish.setPRW_INID( rs.getString("PRW_INID") );
				productwish.setPRW_MODATE( rs.getTimestamp("PRW_MODATE") );
				productwish.setPRW_INDATE( rs.getTimestamp("PRW_INDATE") );
				productwishList.add(productwish);
			}
			productwishMap.put( "productList", productList );
			productwishMap.put( "productwishList", productwishList );
			return productwishMap;

		}catch(SQLException se){
			System.out.println("Productwish list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

}