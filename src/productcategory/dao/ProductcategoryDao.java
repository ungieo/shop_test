package productcategory.dao;

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
import productcategory.dto.Productcategory;

public class ProductcategoryDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductcategoryDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Productcategory productcategory)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into productcategory( PRC_CODE, PRC_PID, PRC_NAME, PRC_STEP, PRC_TITLEIMAGE, PRC_GNUM1, PRC_GNUM2, PRC_GNUM3, PRC_GNUM4, PRC_LEVEL, PRC_TYPE, PRC_USE, PRC_MOID, PRC_INID, PRC_MODATE, PRC_INDATE)";
			sql += "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

//			pstmt.setInt( i++, productcategory.getPRC_SEQ() );
			pstmt.setString( i++, productcategory.getPRC_CODE() );
			pstmt.setInt( i++, productcategory.getPRC_PID() );
			pstmt.setString( i++, productcategory.getPRC_NAME() );
			pstmt.setInt( i++, productcategory.getPRC_STEP() );
			pstmt.setString( i++, productcategory.getPRC_TITLEIMAGE() );
			pstmt.setInt( i++, productcategory.getPRC_GNUM1() );
			pstmt.setInt( i++, productcategory.getPRC_GNUM2() );
			pstmt.setInt( i++, productcategory.getPRC_GNUM3() );
			pstmt.setInt( i++, productcategory.getPRC_GNUM4() );
			pstmt.setInt( i++, productcategory.getPRC_LEVEL() );
			pstmt.setString( i++, productcategory.getPRC_TYPE() );
			pstmt.setString( i++, productcategory.getPRC_USE() );
			pstmt.setString( i++, productcategory.getPRC_MOID() );
			pstmt.setString( i++, productcategory.getPRC_INID() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_MODATE() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Productcategory insert Error : "+se+" \nsql : "+sql+" \ndto : "+productcategory.toStr() );
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
			sql = "select count(*) from productcategory";

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
			System.out.println("Productcategory cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from productcategory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Productcategory cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productcategory one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Productcategory productcategory = new Productcategory();
		String sql = "";
		try{
			sql = "select * from productcategory";

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
				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
			}
			return productcategory;

		}catch(SQLException se){
			System.out.println("Productcategory one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Productcategory one(String whereStr, String orderStr)throws SQLException{

		Productcategory productcategory = new Productcategory();
		String sql = "";
		try{
			sql = "select * from productcategory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
			}
			return productcategory;

		}catch(SQLException se){
			System.out.println("Productcategory one Error : "+se+" \n sql : "+sql );
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
			sql += " from productcategory";

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

			Map<String, Object> productcategory = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					productcategory.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productcategory;

		}catch(SQLException se){
			System.out.println("Productcategory oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	
	//list
	public List<Productcategory> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productcategory> productcategoryList = new ArrayList<Productcategory>();
		String sql = "";
		try{
			sql += "select * from productcategory";

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
				Productcategory productcategory = new Productcategory();

				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
				productcategoryList.add(productcategory);
			}
			return productcategoryList;

		}catch(SQLException se){
			System.out.println("Productcategory list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Productcategory> list( String whereStr, String orderStr )throws SQLException{

		List<Productcategory> productcategoryList = new ArrayList<Productcategory>();
		String sql = "";
		try{
			sql += "select * from productcategory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productcategory productcategory = new Productcategory();

				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
				productcategoryList.add(productcategory);
			}
			return productcategoryList;

		}catch(SQLException se){
			System.out.println("Productcategory list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productcategory> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Productcategory> productcategoryList = new ArrayList<Productcategory>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productcategory";

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
				Productcategory productcategory = new Productcategory();

				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
				productcategoryList.add(productcategory);
			}
			return productcategoryList;

		}catch(SQLException se){
			System.out.println("Productcategory list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Productcategory> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Productcategory> productcategoryList = new ArrayList<Productcategory>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from productcategory";

			sql += "select * from productcategory";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Productcategory productcategory = new Productcategory();

				productcategory.setPRC_SEQ( rs.getInt("PRC_SEQ") );
				productcategory.setPRC_CODE( rs.getString("PRC_CODE") );
				productcategory.setPRC_PID( rs.getInt("PRC_PID") );
				productcategory.setPRC_NAME( rs.getString("PRC_NAME") );
				productcategory.setPRC_STEP( rs.getInt("PRC_STEP") );
				productcategory.setPRC_TITLEIMAGE( rs.getString("PRC_TITLEIMAGE") );
				productcategory.setPRC_GNUM1( rs.getInt("PRC_GNUM1") );
				productcategory.setPRC_GNUM2( rs.getInt("PRC_GNUM2") );
				productcategory.setPRC_GNUM3( rs.getInt("PRC_GNUM3") );
				productcategory.setPRC_GNUM4( rs.getInt("PRC_GNUM4") );
				productcategory.setPRC_LEVEL( rs.getInt("PRC_LEVEL") );
				productcategory.setPRC_TYPE( rs.getString("PRC_TYPE") );
				productcategory.setPRC_USE( rs.getString("PRC_USE") );
				productcategory.setPRC_MOID( rs.getString("PRC_MOID") );
				productcategory.setPRC_INID( rs.getString("PRC_INID") );
				productcategory.setPRC_MODATE( rs.getTimestamp("PRC_MODATE") );
				productcategory.setPRC_INDATE( rs.getTimestamp("PRC_INDATE") );
				productcategoryList.add(productcategory);
			}
			return productcategoryList;

		}catch(SQLException se){
			System.out.println("Productcategory list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> productcategoryList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from productcategory";

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
				Map<String, Object> productcategory = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					productcategory.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				productcategoryList.add(productcategory);
			}
			return productcategoryList;

		}catch(SQLException se){
			System.out.println("Productcategory listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Productcategory productcategory = ( Productcategory )sqlMap.get( "productcategory" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update productcategory set PRC_SEQ=?, PRC_CODE=?, PRC_PID=?, PRC_NAME=?, PRC_STEP=?, PRC_TITLEIMAGE=?, PRC_GNUM1=?, PRC_GNUM2=?, PRC_GNUM3=?, PRC_GNUM4=?, PRC_LEVEL=?, PRC_TYPE=?, PRC_USE=?, PRC_MOID=?, PRC_INID=?, PRC_MODATE=sysdate(), PRC_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , productcategory.getPRC_SEQ() );
			pstmt.setString( i++ , productcategory.getPRC_CODE() );
			pstmt.setInt( i++ , productcategory.getPRC_PID() );
			pstmt.setString( i++ , productcategory.getPRC_NAME() );
			pstmt.setInt( i++ , productcategory.getPRC_STEP() );
			pstmt.setString( i++ , productcategory.getPRC_TITLEIMAGE() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM1() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM2() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM3() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM4() );
			pstmt.setInt( i++ , productcategory.getPRC_LEVEL() );
			pstmt.setString( i++ , productcategory.getPRC_TYPE() );
			pstmt.setString( i++ , productcategory.getPRC_USE() );
			pstmt.setString( i++ , productcategory.getPRC_MOID() );
			pstmt.setString( i++ , productcategory.getPRC_INID() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_MODATE() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_INDATE() );


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
			System.out.println("Productcategory up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Productcategory productcategory, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update productcategory set PRC_SEQ=?, PRC_CODE=?, PRC_PID=?, PRC_NAME=?, PRC_STEP=?, PRC_TITLEIMAGE=?, PRC_GNUM1=?, PRC_GNUM2=?, PRC_GNUM3=?, PRC_GNUM4=?, PRC_LEVEL=?, PRC_TYPE=?, PRC_USE=?, PRC_MOID=?, PRC_INID=?, PRC_MODATE=sysdate(), PRC_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , productcategory.getPRC_SEQ() );
			pstmt.setString( i++ , productcategory.getPRC_CODE() );
			pstmt.setInt( i++ , productcategory.getPRC_PID() );
			pstmt.setString( i++ , productcategory.getPRC_NAME() );
			pstmt.setInt( i++ , productcategory.getPRC_STEP() );
			pstmt.setString( i++ , productcategory.getPRC_TITLEIMAGE() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM1() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM2() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM3() );
			pstmt.setInt( i++ , productcategory.getPRC_GNUM4() );
			pstmt.setInt( i++ , productcategory.getPRC_LEVEL() );
			pstmt.setString( i++ , productcategory.getPRC_TYPE() );
			pstmt.setString( i++ , productcategory.getPRC_USE() );
			pstmt.setString( i++ , productcategory.getPRC_MOID() );
			pstmt.setString( i++ , productcategory.getPRC_INID() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_MODATE() );
//			pstmt.setTimestamp( i++, productcategory.getPRC_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productcategory up Error : "+se+" \n sql : "+sql );
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
			sql = "update productcategory set ";

			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}

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
			System.out.println("Productcategory upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update productcategory set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productcategory upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from productcategory";

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
			System.out.println("Productcategory delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from productcategory";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Productcategory delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productcategory max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Productcategory max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Productcategory lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!
	
	
	//oneChoiceJoin
	public Map<String, Object> oneChoiceJoin( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		String sql = "";
		try{
			sql += "select ";
			sql += " prc4.prc_name PRC_NAME1, ";
			sql += " prc3.prc_name PRC_NAME2, ";
			sql += " prc2.prc_name PRC_NAME3, ";
			sql += " prc1.prc_name , prc1.PRC_GNUM1, prc1.PRC_GNUM2, prc1.PRC_GNUM3, prc1.PRC_GNUM4, prc1.PRC_LEVEL ";
			sql += " from productcategory prc1 ";
			sql += " LEFT OUTER JOIN productcategory prc2 ON prc1.prc_gnum3=prc2.prc_seq ";
			sql += " LEFT OUTER JOIN productcategory prc3 ON prc1.prc_gnum2=prc3.prc_seq ";
			sql += " LEFT OUTER JOIN productcategory prc4 ON prc1.prc_gnum1=prc4.prc_seq ";

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

			Map<String, Object> productcategory = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
//					productcategory.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
					productcategory.put( rsmd.getColumnLabel(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return productcategory;

		}catch(SQLException se){
			System.out.println("Productcategory oneChoiceJoin Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

}