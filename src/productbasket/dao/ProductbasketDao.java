package productbasket.dao;

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
import productbasket.dto.Productbasket;
import productoption.dto.Productoption;
import system.db.util.DbUtil;
import system.util.Cvt;

public class ProductbasketDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductbasketDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Productbasket productbasket)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into productbasket(PRB_SEQ, PRB_PRSEQ, PRB_MBID, PRB_PROSEQ, PRB_EA, PRB_TYPE, PRB_MOID, PRB_INID, PRB_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, productbasket.getPRB_SEQ() );
			pstmt.setInt( i++, productbasket.getPRB_PRSEQ() );
			pstmt.setString( i++, productbasket.getPRB_MBID() );
			pstmt.setInt( i++, productbasket.getPRB_PROSEQ() );
			pstmt.setInt( i++, productbasket.getPRB_EA() );
			pstmt.setString( i++, productbasket.getPRB_TYPE() );
			pstmt.setString( i++, productbasket.getPRB_MOID() );
			pstmt.setString( i++, productbasket.getPRB_INID() );
//			pstmt.setTimestamp( i++, productbasket.getPRB_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Productbasket insert Error : "+se+" \nsql : "+sql+" \ndto : "+productbasket.toStr() );
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
			sql = "select count(*) from productbasket";

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
			System.out.println("Productbasket cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from productbasket";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Productbasket cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productbasket one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Productbasket productbasket = new Productbasket();
		String sql = "";
		try{
			sql = "select * from productbasket";

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
				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
			}
			return productbasket;

		}catch(SQLException se){
			System.out.println("Productbasket one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productbasket one(String whereStr, String orderStr)throws SQLException{

		Productbasket productbasket = new Productbasket();
		String sql = "";
		try{
			sql = "select * from productbasket";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
			}
			return productbasket;

		}catch(SQLException se){
			System.out.println("Productbasket one Error : "+se+" \n sql : "+sql );
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
			sql += " from productbasket";

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

			Map<String, Object> productbasket = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					productbasket.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productbasket;

		}catch(SQLException se){
			System.out.println("Productbasket oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productbasket> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productbasket> productbasketList = new ArrayList<Productbasket>();
		String sql = "";
		try{
			sql += "select * from productbasket";

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
				Productbasket productbasket = new Productbasket();

				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
				productbasketList.add(productbasket);
			}
			return productbasketList;

		}catch(SQLException se){
			System.out.println("Productbasket list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productbasket> list( String whereStr, String orderStr )throws SQLException{

		List<Productbasket> productbasketList = new ArrayList<Productbasket>();
		String sql = "";
		try{
			sql += "select * from productbasket";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productbasket productbasket = new Productbasket();

				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
				productbasketList.add(productbasket);
			}
			return productbasketList;

		}catch(SQLException se){
			System.out.println("Productbasket list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productbasket> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productbasket> productbasketList = new ArrayList<Productbasket>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productbasket";

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
				Productbasket productbasket = new Productbasket();

				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
				productbasketList.add(productbasket);
			}
			return productbasketList;

		}catch(SQLException se){
			System.out.println("Productbasket list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productbasket> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Productbasket> productbasketList = new ArrayList<Productbasket>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productbasket";

			sql += "select * from productbasket";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productbasket productbasket = new Productbasket();

				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
				productbasketList.add(productbasket);
			}
			return productbasketList;

		}catch(SQLException se){
			System.out.println("Productbasket list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> productbasketList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from productbasket";

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
				Map<String, Object> productbasket = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					productbasket.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				productbasketList.add(productbasket);
			}
			return productbasketList;

		}catch(SQLException se){
			System.out.println("Productbasket listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Productbasket productbasket = ( Productbasket )sqlMap.get( "productbasket" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update productbasket set PRB_SEQ=?, PRB_PRSEQ=?, PRB_MBID=?, PRB_PROSEQ=?, PRB_EA=?, PRB_TYPE=?, PRB_MOID=?, PRB_INID=?, PRB_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , productbasket.getPRB_SEQ() );
			pstmt.setInt( i++ , productbasket.getPRB_PRSEQ() );
			pstmt.setString( i++ , productbasket.getPRB_MBID() );
			pstmt.setInt( i++ , productbasket.getPRB_PROSEQ() );
			pstmt.setInt( i++ , productbasket.getPRB_EA() );
			pstmt.setString( i++ , productbasket.getPRB_TYPE() );
			pstmt.setString( i++ , productbasket.getPRB_MOID() );
			pstmt.setString( i++ , productbasket.getPRB_INID() );
//			pstmt.setTimestamp( i++, productbasket.getPRB_INDATE() );


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
			System.out.println("Productbasket up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Productbasket productbasket, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update productbasket set PRB_SEQ=?, PRB_PRSEQ=?, PRB_MBID=?, PRB_PROSEQ=?, PRB_EA=?, PRB_TYPE=?, PRB_MOID=?, PRB_INID=?, PRB_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , productbasket.getPRB_SEQ() );
			pstmt.setInt( i++ , productbasket.getPRB_PRSEQ() );
			pstmt.setString( i++ , productbasket.getPRB_MBID() );
			pstmt.setInt( i++ , productbasket.getPRB_PROSEQ() );
			pstmt.setInt( i++ , productbasket.getPRB_EA() );
			pstmt.setString( i++ , productbasket.getPRB_TYPE() );
			pstmt.setString( i++ , productbasket.getPRB_MOID() );
			pstmt.setString( i++ , productbasket.getPRB_INID() );
//			pstmt.setTimestamp( i++, productbasket.getPRB_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productbasket up Error : "+se+" \n sql : "+sql );
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
			sql = "update productbasket set ";

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
			System.out.println("Productbasket upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update productbasket set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productbasket upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from productbasket";

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
			System.out.println("Productbasket delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from productbasket";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productbasket delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productbasket max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Productbasket max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productbasket lastId Error : "+se+" \nsql : "+sql );
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
			sql += "select count(*) from productbasket prb ";
			sql += " LEFT OUTER JOIN product pr ON prb.PRB_PRSEQ = pr.PR_SEQ ";
			sql += " LEFT OUTER JOIN productoption pro ON prb.PRB_PROSEQ = pro.PRO_SEQ ";

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
			System.out.println("Productbasket cnt Error : "+se+" \nsql : "+sql );
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

		Map<String, Object> productbasketMap = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		List<Productbasket> productbasketList = new ArrayList<Productbasket>();
		List<Productoption> productoptionList = new ArrayList<Productoption>();
		List<Integer> procntList = new ArrayList<Integer>();
		
		String sql = "";
		try{
			sql += "select *,(select count(*) from productoption where pro_prseq=pr.PR_SEQ) as PROCNT from productbasket prb ";
			sql += " LEFT OUTER JOIN product pr ON prb.PRB_PRSEQ = pr.PR_SEQ ";
			sql += " LEFT OUTER JOIN productoption pro ON prb.PRB_PROSEQ = pro.PRO_SEQ ";

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
				Productbasket productbasket = new Productbasket();
				Productoption productoption = new Productoption();
				
				procntList.add( rs.getInt( "PROCNT" ) );
				
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
				
				productbasket.setPRB_SEQ( rs.getInt("PRB_SEQ") );
				productbasket.setPRB_PRSEQ( rs.getInt("PRB_PRSEQ") );
				productbasket.setPRB_MBID( rs.getString("PRB_MBID") );
				productbasket.setPRB_PROSEQ( rs.getInt("PRB_PROSEQ") );
				productbasket.setPRB_EA( rs.getInt("PRB_EA") );
				productbasket.setPRB_TYPE( rs.getString("PRB_TYPE") );
				productbasket.setPRB_MOID( rs.getString("PRB_MOID") );
				productbasket.setPRB_INID( rs.getString("PRB_INID") );
				productbasket.setPRB_INDATE( rs.getTimestamp("PRB_INDATE") );
				productbasketList.add(productbasket);
				
//				productoption.setPRO_SEQ( rs.getInt("PRO_SEQ") );
//				productoption.setPRO_PRSEQ( rs.getInt("PRO_PRSEQ") );
				productoption.setPRO_GNAME( rs.getString("PRO_GNAME") );
				productoption.setPRO_NAME( rs.getString("PRO_NAME") );
				productoption.setPRO_VALUE( rs.getString("PRO_VALUE") );
				productoption.setPRO_PRICE( rs.getInt("PRO_PRICE") );
				productoption.setPRO_STOCK( rs.getInt("PRO_STOCK") );
//				productoption.setPRO_LEVEL( rs.getString("PRO_LEVEL") );
//				productoption.setPRO_TYPE( rs.getString("PRO_TYPE") );
//				productoption.setPRO_USE( rs.getString("PRO_USE") );
//				productoption.setPRO_MOID( rs.getString("PRO_MOID") );
//				productoption.setPRO_INID( rs.getString("PRO_INID") );
//				productoption.setPRO_MODATE( rs.getTimestamp("PRO_MODATE") );
//				productoption.setPRO_INDATE( rs.getTimestamp("PRO_INDATE") );
				
				productoptionList.add(productoption);
			}
			
			productbasketMap.put( "procntList", procntList );
			productbasketMap.put( "productList", productList );
			productbasketMap.put( "productbasketList", productbasketList );
			productbasketMap.put( "productoptionList", productoptionList );
			
			return productbasketMap;

		}catch(SQLException se){
			System.out.println("Productbasket listJoin Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}	
}