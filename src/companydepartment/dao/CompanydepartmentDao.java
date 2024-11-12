package companydepartment.dao;

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
import companydepartment.dto.Companydepartment;

public class CompanydepartmentDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public CompanydepartmentDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Companydepartment companydepartment)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into companydepartment(CPD_SEQ, CPD_CPID, CPD_ID, CPD_NAME, CPD_PAYTYPE, CPD_EMAIL, CPD_TEL, CPD_PHONE, CPD_FAX, CPD_LEVEL, CPD_TYPE, CPD_USE, CPD_MOID, CPD_INID, CPD_MODATE, CPD_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, companydepartment.getCPD_SEQ() );
			pstmt.setString( i++, companydepartment.getCPD_CPID() );
			pstmt.setString( i++, companydepartment.getCPD_ID() );
			pstmt.setString( i++, companydepartment.getCPD_NAME() );
			pstmt.setString( i++, companydepartment.getCPD_PAYTYPE() );
			pstmt.setString( i++, companydepartment.getCPD_EMAIL() );
			pstmt.setString( i++, companydepartment.getCPD_TEL() );
			pstmt.setString( i++, companydepartment.getCPD_PHONE() );
			pstmt.setString( i++, companydepartment.getCPD_FAX() );
			pstmt.setString( i++, companydepartment.getCPD_LEVEL() );
			pstmt.setString( i++, companydepartment.getCPD_TYPE() );
			pstmt.setString( i++, companydepartment.getCPD_USE() );
			pstmt.setString( i++, companydepartment.getCPD_MOID() );
			pstmt.setString( i++, companydepartment.getCPD_INID() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_MODATE() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Companydepartment insert Error : "+se+" \nsql : "+sql+" \ndto : "+companydepartment.toStr() );
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
			sql = "select count(*) from companydepartment";

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
			System.out.println("Companydepartment cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from companydepartment";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Companydepartment cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Companydepartment one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Companydepartment companydepartment = new Companydepartment();
		String sql = "";
		try{
			sql = "select * from companydepartment";

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
				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
			}
			return companydepartment;

		}catch(SQLException se){
			System.out.println("Companydepartment one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Companydepartment one(String whereStr, String orderStr)throws SQLException{

		Companydepartment companydepartment = new Companydepartment();
		String sql = "";
		try{
			sql = "select * from companydepartment";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
			}
			return companydepartment;

		}catch(SQLException se){
			System.out.println("Companydepartment one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Companydepartment> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Companydepartment> companydepartmentList = new ArrayList<Companydepartment>();
		String sql = "";
		try{
			sql += "select * from companydepartment";

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
				Companydepartment companydepartment = new Companydepartment();

				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
				companydepartmentList.add(companydepartment);
			}
			return companydepartmentList;

		}catch(SQLException se){
			System.out.println("Companydepartment list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Companydepartment> list( String whereStr, String orderStr )throws SQLException{

		List<Companydepartment> companydepartmentList = new ArrayList<Companydepartment>();
		String sql = "";
		try{
			sql += "select * from companydepartment";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Companydepartment companydepartment = new Companydepartment();

				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
				companydepartmentList.add(companydepartment);
			}
			return companydepartmentList;

		}catch(SQLException se){
			System.out.println("Companydepartment list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Companydepartment> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Companydepartment> companydepartmentList = new ArrayList<Companydepartment>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from companydepartment";

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
				Companydepartment companydepartment = new Companydepartment();

				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
				companydepartmentList.add(companydepartment);
			}
			return companydepartmentList;

		}catch(SQLException se){
			System.out.println("Companydepartment list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Companydepartment> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Companydepartment> companydepartmentList = new ArrayList<Companydepartment>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from companydepartment";

			sql += "select * from companydepartment";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Companydepartment companydepartment = new Companydepartment();

				companydepartment.setCPD_SEQ( rs.getInt("CPD_SEQ") );
				companydepartment.setCPD_CPID( rs.getString("CPD_CPID") );
				companydepartment.setCPD_ID( rs.getString("CPD_ID") );
				companydepartment.setCPD_NAME( rs.getString("CPD_NAME") );
				companydepartment.setCPD_PAYTYPE( rs.getString("CPD_PAYTYPE") );
				companydepartment.setCPD_EMAIL( rs.getString("CPD_EMAIL") );
				companydepartment.setCPD_TEL( rs.getString("CPD_TEL") );
				companydepartment.setCPD_PHONE( rs.getString("CPD_PHONE") );
				companydepartment.setCPD_FAX( rs.getString("CPD_FAX") );
				companydepartment.setCPD_LEVEL( rs.getString("CPD_LEVEL") );
				companydepartment.setCPD_TYPE( rs.getString("CPD_TYPE") );
				companydepartment.setCPD_USE( rs.getString("CPD_USE") );
				companydepartment.setCPD_MOID( rs.getString("CPD_MOID") );
				companydepartment.setCPD_INID( rs.getString("CPD_INID") );
				companydepartment.setCPD_MODATE( rs.getTimestamp("CPD_MODATE") );
				companydepartment.setCPD_INDATE( rs.getTimestamp("CPD_INDATE") );
				companydepartmentList.add(companydepartment);
			}
			return companydepartmentList;

		}catch(SQLException se){
			System.out.println("Companydepartment list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> companydepartmentList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from companydepartment";

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
				Map<String, Object> companydepartment = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					companydepartment.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				companydepartmentList.add(companydepartment);
			}
			return companydepartmentList;

		}catch(SQLException se){
			System.out.println("Companydepartment listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Companydepartment companydepartment = ( Companydepartment )sqlMap.get( "companydepartment" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update companydepartment set CPD_SEQ=?, CPD_CPID=?, CPD_ID=?, CPD_NAME=?, CPD_PAYTYPE=?, CPD_EMAIL=?, CPD_TEL=?, CPD_PHONE=?, CPD_FAX=?, CPD_LEVEL=?, CPD_TYPE=?, CPD_USE=?, CPD_MOID=?, CPD_INID=?, CPD_MODATE=sysdate(), CPD_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , companydepartment.getCPD_SEQ() );
			pstmt.setString( i++ , companydepartment.getCPD_CPID() );
			pstmt.setString( i++ , companydepartment.getCPD_ID() );
			pstmt.setString( i++ , companydepartment.getCPD_NAME() );
			pstmt.setString( i++ , companydepartment.getCPD_PAYTYPE() );
			pstmt.setString( i++ , companydepartment.getCPD_EMAIL() );
			pstmt.setString( i++ , companydepartment.getCPD_TEL() );
			pstmt.setString( i++ , companydepartment.getCPD_PHONE() );
			pstmt.setString( i++ , companydepartment.getCPD_FAX() );
			pstmt.setString( i++ , companydepartment.getCPD_LEVEL() );
			pstmt.setString( i++ , companydepartment.getCPD_TYPE() );
			pstmt.setString( i++ , companydepartment.getCPD_USE() );
			pstmt.setString( i++ , companydepartment.getCPD_MOID() );
			pstmt.setString( i++ , companydepartment.getCPD_INID() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_MODATE() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_INDATE() );


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
			System.out.println("Companydepartment up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Companydepartment companydepartment, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update companydepartment set CPD_SEQ=?, CPD_CPID=?, CPD_ID=?, CPD_NAME=?, CPD_PAYTYPE=?, CPD_EMAIL=?, CPD_TEL=?, CPD_PHONE=?, CPD_FAX=?, CPD_LEVEL=?, CPD_TYPE=?, CPD_USE=?, CPD_MOID=?, CPD_INID=?, CPD_MODATE=sysdate(), CPD_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , companydepartment.getCPD_SEQ() );
			pstmt.setString( i++ , companydepartment.getCPD_CPID() );
			pstmt.setString( i++ , companydepartment.getCPD_ID() );
			pstmt.setString( i++ , companydepartment.getCPD_NAME() );
			pstmt.setString( i++ , companydepartment.getCPD_PAYTYPE() );
			pstmt.setString( i++ , companydepartment.getCPD_EMAIL() );
			pstmt.setString( i++ , companydepartment.getCPD_TEL() );
			pstmt.setString( i++ , companydepartment.getCPD_PHONE() );
			pstmt.setString( i++ , companydepartment.getCPD_FAX() );
			pstmt.setString( i++ , companydepartment.getCPD_LEVEL() );
			pstmt.setString( i++ , companydepartment.getCPD_TYPE() );
			pstmt.setString( i++ , companydepartment.getCPD_USE() );
			pstmt.setString( i++ , companydepartment.getCPD_MOID() );
			pstmt.setString( i++ , companydepartment.getCPD_INID() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_MODATE() );
//			pstmt.setTimestamp( i++, companydepartment.getCPD_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Companydepartment up Error : "+se+" \n sql : "+sql );
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
			sql = "update companydepartment set ";

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
			System.out.println("Companydepartment upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update companydepartment set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Companydepartment upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from companydepartment";

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
			System.out.println("Companydepartment delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from companydepartment";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Companydepartment delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Companydepartment max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Companydepartment max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Companydepartment lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}