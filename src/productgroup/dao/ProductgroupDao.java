package productgroup.dao;

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
import productgroup.dto.Productgroup;
import system.db.util.DbUtil;
import system.util.Cvt;

public class ProductgroupDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductgroupDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Productgroup productgroup)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into productgroup(PRG_SEQ, PRG_PRGSEQ, PRG_PRSEQ, PRG_TYPE, PRG_USE, PRG_INID, PRG_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, productgroup.getPRG_SEQ() );
			pstmt.setInt( i++, productgroup.getPRG_PRGSEQ() );
			pstmt.setInt( i++, productgroup.getPRG_PRSEQ() );
			pstmt.setString( i++, productgroup.getPRG_TYPE() );
			pstmt.setString( i++, productgroup.getPRG_USE() );
			pstmt.setString( i++, productgroup.getPRG_INID() );
//			pstmt.setTimestamp( i++, productgroup.getPRG_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Productgroup insert Error : "+se+" \nsql : "+sql+" \ndto : "+productgroup.toStr() );
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
			sql = "select count(*) from productgroup";

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
			System.out.println("Productgroup cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from productgroup";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Productgroup cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productgroup one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Productgroup productgroup = new Productgroup();
		String sql = "";
		try{
			sql = "select * from productgroup";

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
				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
			}
			return productgroup;

		}catch(SQLException se){
			System.out.println("Productgroup one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productgroup one(String whereStr, String orderStr)throws SQLException{

		Productgroup productgroup = new Productgroup();
		String sql = "";
		try{
			sql = "select * from productgroup";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
			}
			return productgroup;

		}catch(SQLException se){
			System.out.println("Productgroup one Error : "+se+" \n sql : "+sql );
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
			sql += " from productgroup";

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

			Map<String, Object> productgroup = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					productgroup.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productgroup;

		}catch(SQLException se){
			System.out.println("Productgroup oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productgroup> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productgroup> productgroupList = new ArrayList<Productgroup>();
		String sql = "";
		try{
			sql += "select * from productgroup";

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
				Productgroup productgroup = new Productgroup();

				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
				productgroupList.add(productgroup);
			}
			return productgroupList;

		}catch(SQLException se){
			System.out.println("Productgroup list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productgroup> list( String whereStr, String orderStr )throws SQLException{

		List<Productgroup> productgroupList = new ArrayList<Productgroup>();
		String sql = "";
		try{
			sql += "select * from productgroup";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productgroup productgroup = new Productgroup();

				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
				productgroupList.add(productgroup);
			}
			return productgroupList;

		}catch(SQLException se){
			System.out.println("Productgroup list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productgroup> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productgroup> productgroupList = new ArrayList<Productgroup>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productgroup";

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
				Productgroup productgroup = new Productgroup();

				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
				productgroupList.add(productgroup);
			}
			return productgroupList;

		}catch(SQLException se){
			System.out.println("Productgroup list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productgroup> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Productgroup> productgroupList = new ArrayList<Productgroup>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productgroup";

			sql += "select * from productgroup";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productgroup productgroup = new Productgroup();

				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
				productgroup.setPRG_PRGSEQ( rs.getInt("PRG_PRGSEQ") );
				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
				productgroup.setPRG_USE( rs.getString("PRG_USE") );
				productgroup.setPRG_INID( rs.getString("PRG_INID") );
				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
				productgroupList.add(productgroup);
			}
			return productgroupList;

		}catch(SQLException se){
			System.out.println("Productgroup list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> productgroupList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from productgroup";

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
				Map<String, Object> productgroup = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					productgroup.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				productgroupList.add(productgroup);
			}
			return productgroupList;

		}catch(SQLException se){
			System.out.println("Productgroup listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Productgroup productgroup = ( Productgroup )sqlMap.get( "productgroup" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update productgroup set PRG_SEQ=?, PRG_PRGSEQ=?, PRG_PRSEQ=?, PRG_TYPE=?, PRG_USE=?, PRG_INID=?, PRG_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , productgroup.getPRG_SEQ() );
			pstmt.setInt( i++ , productgroup.getPRG_PRGSEQ() );
			pstmt.setInt( i++ , productgroup.getPRG_PRSEQ() );
			pstmt.setString( i++ , productgroup.getPRG_TYPE() );
			pstmt.setString( i++ , productgroup.getPRG_USE() );
			pstmt.setString( i++ , productgroup.getPRG_INID() );
//			pstmt.setTimestamp( i++, productgroup.getPRG_INDATE() );


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
			System.out.println("Productgroup up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Productgroup productgroup, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update productgroup set PRG_SEQ=?, PRG_PRGSEQ=?, PRG_PRSEQ=?, PRG_TYPE=?, PRG_USE=?, PRG_INID=?, PRG_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 1;

			pstmt.setInt( i++ , productgroup.getPRG_SEQ() );
			pstmt.setInt( i++ , productgroup.getPRG_PRGSEQ() );
			pstmt.setInt( i++ , productgroup.getPRG_PRSEQ() );
			pstmt.setString( i++ , productgroup.getPRG_TYPE() );
			pstmt.setString( i++ , productgroup.getPRG_USE() );
			pstmt.setString( i++ , productgroup.getPRG_INID() );
//			pstmt.setTimestamp( i++, productgroup.getPRG_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productgroup up Error : "+se+" \n sql : "+sql );
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
			sql = "update productgroup set ";

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
			System.out.println("Productgroup upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update productgroup set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productgroup upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from productgroup";

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
			System.out.println("Productgroup delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from productgroup";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productgroup delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productgroup max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Productgroup max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productgroup lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!
	
	
	//list
	public Map<String, Object> listJoin( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Map<String, Object> productgroupMap = new HashMap<String, Object>();
//		List<Productgroup> productgroupList = new ArrayList<Productgroup>();
		List<Product> productList = new ArrayList<Product>();
		
		String sql = "";
		try{
			sql += "select pr.* from productgroup prg ";
			sql += " LEFT OUTER JOIN product pr ON prg.PRG_PRSEQ = pr.PR_SEQ ";

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
//				Productgroup productgroup = new Productgroup();
				Product product = new Product();
				
//				productgroup.setPRG_SEQ( rs.getInt("PRG_SEQ") );
//				productgroup.setPRG_PRSEQ( rs.getInt("PRG_PRSEQ") );
//				productgroup.setPRG_TYPE( rs.getString("PRG_TYPE") );
//				productgroup.setPRG_USE( rs.getString("PRG_USE") );
//				productgroup.setPRG_INID( rs.getString("PRG_INID") );
//				productgroup.setPRG_INDATE( rs.getTimestamp("PRG_INDATE") );
//				productgroupList.add(productgroup);
				
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
				
				productList.add( product );
			}
			productgroupMap.put( "productList", productList );
//			productgroupMap.put( "productgroupList", productgroupList );
			return productgroupMap;

		}catch(SQLException se){
			System.out.println("Productgroup listJoin Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

}