package sales.dao;

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
import sales.dto.Sales;

public class SalesDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public SalesDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Sales sales)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into sales(SL_SEQ, SL_OMSEQ, SL_OMISEQ, SL_CPIDP, SL_CPIDS, SL_MBID, SL_ACCOUNTMONEY, SL_CARDMONEY, SL_COUPONMONEY, SL_LATERMONEY, SL_BUDGETMONEY, SL_VIRTUALMONEY, SL_VIRTUALACCOUNTMONEY, SL_ORIGNALMONEY, SL_SALEMONEY, SL_CCIDB, SL_CCIDS, SL_CCBHANDLINGYN, SL_CCSHANDLINGYN, SL_TYPE, SL_INID, SL_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, sales.getSL_SEQ() );
			pstmt.setInt( i++, sales.getSL_OMSEQ() );
			pstmt.setInt( i++, sales.getSL_OMISEQ() );
			pstmt.setString( i++, sales.getSL_CPIDP() );
			pstmt.setString( i++, sales.getSL_CPIDS() );
			pstmt.setString( i++, sales.getSL_MBID() );
			pstmt.setInt( i++, sales.getSL_ACCOUNTMONEY() );
			pstmt.setInt( i++, sales.getSL_CARDMONEY() );
			pstmt.setInt( i++, sales.getSL_COUPONMONEY() );
			pstmt.setInt( i++, sales.getSL_LATERMONEY() );
			pstmt.setInt( i++, sales.getSL_BUDGETMONEY() );
			pstmt.setInt( i++, sales.getSL_VIRTUALMONEY() );
			pstmt.setInt( i++, sales.getSL_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++, sales.getSL_ORIGNALMONEY() );
			pstmt.setInt( i++, sales.getSL_SALEMONEY() );
			pstmt.setString( i++, sales.getSL_CCIDB() );
			pstmt.setString( i++, sales.getSL_CCIDS() );
			pstmt.setString( i++, sales.getSL_CCBHANDLINGYN() );
			pstmt.setString( i++, sales.getSL_CCSHANDLINGYN() );
			pstmt.setString( i++, sales.getSL_TYPE() );
			pstmt.setString( i++, sales.getSL_INID() );
//			pstmt.setTimestamp( i++, sales.getSL_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Sales insert Error : "+se+" \nsql : "+sql+" \ndto : "+sales.toStr() );
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
			sql = "select count(*) from sales";

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
			System.out.println("Sales cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from sales";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Sales cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Sales one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Sales sales = new Sales();
		String sql = "";
		try{
			sql = "select * from sales";

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
				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
			}
			return sales;

		}catch(SQLException se){
			System.out.println("Sales one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Sales one(String whereStr, String orderStr)throws SQLException{

		Sales sales = new Sales();
		String sql = "";
		try{
			sql = "select * from sales";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
			}
			return sales;

		}catch(SQLException se){
			System.out.println("Sales one Error : "+se+" \n sql : "+sql );
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
			sql += " from sales";

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

			Map<String, Object> sales = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					sales.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return sales;

		}catch(SQLException se){
			System.out.println("Sales oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Sales> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Sales> salesList = new ArrayList<Sales>();
		String sql = "";
		try{
			sql += "select * from sales";

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
				Sales sales = new Sales();

				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
				salesList.add(sales);
			}
			return salesList;

		}catch(SQLException se){
			System.out.println("Sales list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Sales> list( String whereStr, String orderStr )throws SQLException{

		List<Sales> salesList = new ArrayList<Sales>();
		String sql = "";
		try{
			sql += "select * from sales";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Sales sales = new Sales();

				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
				salesList.add(sales);
			}
			return salesList;

		}catch(SQLException se){
			System.out.println("Sales list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Sales> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Sales> salesList = new ArrayList<Sales>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from sales";

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
				Sales sales = new Sales();

				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
				salesList.add(sales);
			}
			return salesList;

		}catch(SQLException se){
			System.out.println("Sales list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Sales> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Sales> salesList = new ArrayList<Sales>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from sales";

			sql += "select * from sales";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Sales sales = new Sales();

				sales.setSL_SEQ( rs.getInt("SL_SEQ") );
				sales.setSL_OMSEQ( rs.getInt("SL_OMSEQ") );
				sales.setSL_OMISEQ( rs.getInt("SL_OMISEQ") );
				sales.setSL_CPIDP( rs.getString("SL_CPIDP") );
				sales.setSL_CPIDS( rs.getString("SL_CPIDS") );
				sales.setSL_MBID( rs.getString("SL_MBID") );
				sales.setSL_ACCOUNTMONEY( rs.getInt("SL_ACCOUNTMONEY") );
				sales.setSL_CARDMONEY( rs.getInt("SL_CARDMONEY") );
				sales.setSL_COUPONMONEY( rs.getInt("SL_COUPONMONEY") );
				sales.setSL_LATERMONEY( rs.getInt("SL_LATERMONEY") );
				sales.setSL_BUDGETMONEY( rs.getInt("SL_BUDGETMONEY") );
				sales.setSL_VIRTUALMONEY( rs.getInt("SL_VIRTUALMONEY") );
				sales.setSL_VIRTUALACCOUNTMONEY( rs.getInt("SL_VIRTUALACCOUNTMONEY") );
				sales.setSL_ORIGNALMONEY( rs.getInt("SL_ORIGNALMONEY") );
				sales.setSL_SALEMONEY( rs.getInt("SL_SALEMONEY") );
				sales.setSL_CCIDB( rs.getString("SL_CCIDB") );
				sales.setSL_CCIDS( rs.getString("SL_CCIDS") );
				sales.setSL_CCBHANDLINGYN( rs.getString("SL_CCBHANDLINGYN") );
				sales.setSL_CCSHANDLINGYN( rs.getString("SL_CCSHANDLINGYN") );
				sales.setSL_TYPE( rs.getString("SL_TYPE") );
				sales.setSL_INID( rs.getString("SL_INID") );
				sales.setSL_INDATE( rs.getTimestamp("SL_INDATE") );
				salesList.add(sales);
			}
			return salesList;

		}catch(SQLException se){
			System.out.println("Sales list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> salesList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from sales";

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
				Map<String, Object> sales = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					sales.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				salesList.add(sales);
			}
			return salesList;

		}catch(SQLException se){
			System.out.println("Sales listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Sales sales = ( Sales )sqlMap.get( "sales" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update sales set SL_SEQ=?, SL_OMSEQ=?, SL_OMISEQ=?, SL_CPIDP=?, SL_CPIDS=?, SL_MBID=?, SL_ACCOUNTMONEY=?, SL_CARDMONEY=?, SL_COUPONMONEY=?, SL_LATERMONEY=?, SL_BUDGETMONEY=?, SL_VIRTUALMONEY=?, SL_VIRTUALACCOUNTMONEY=?, SL_ORIGNALMONEY=?, SL_SALEMONEY=?, SL_CCIDB=?, SL_CCIDS=?, SL_CCBHANDLINGYN=?, SL_CCSHANDLINGYN=?, SL_TYPE=?, SL_INID=?, SL_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , sales.getSL_SEQ() );
			pstmt.setInt( i++ , sales.getSL_OMSEQ() );
			pstmt.setInt( i++ , sales.getSL_OMISEQ() );
			pstmt.setString( i++ , sales.getSL_CPIDP() );
			pstmt.setString( i++ , sales.getSL_CPIDS() );
			pstmt.setString( i++ , sales.getSL_MBID() );
			pstmt.setInt( i++ , sales.getSL_ACCOUNTMONEY() );
			pstmt.setInt( i++ , sales.getSL_CARDMONEY() );
			pstmt.setInt( i++ , sales.getSL_COUPONMONEY() );
			pstmt.setInt( i++ , sales.getSL_LATERMONEY() );
			pstmt.setInt( i++ , sales.getSL_BUDGETMONEY() );
			pstmt.setInt( i++ , sales.getSL_VIRTUALMONEY() );
			pstmt.setInt( i++ , sales.getSL_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , sales.getSL_ORIGNALMONEY() );
			pstmt.setInt( i++ , sales.getSL_SALEMONEY() );
			pstmt.setString( i++ , sales.getSL_CCIDB() );
			pstmt.setString( i++ , sales.getSL_CCIDS() );
			pstmt.setString( i++ , sales.getSL_CCBHANDLINGYN() );
			pstmt.setString( i++ , sales.getSL_CCSHANDLINGYN() );
			pstmt.setString( i++ , sales.getSL_TYPE() );
			pstmt.setString( i++ , sales.getSL_INID() );
//			pstmt.setTimestamp( i++, sales.getSL_INDATE() );


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
			System.out.println("Sales up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Sales sales, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update sales set SL_SEQ=?, SL_OMSEQ=?, SL_OMISEQ=?, SL_CPIDP=?, SL_CPIDS=?, SL_MBID=?, SL_ACCOUNTMONEY=?, SL_CARDMONEY=?, SL_COUPONMONEY=?, SL_LATERMONEY=?, SL_BUDGETMONEY=?, SL_VIRTUALMONEY=?, SL_VIRTUALACCOUNTMONEY=?, SL_ORIGNALMONEY=?, SL_SALEMONEY=?, SL_CCIDB=?, SL_CCIDS=?, SL_CCBHANDLINGYN=?, SL_CCSHANDLINGYN=?, SL_TYPE=?, SL_INID=?, SL_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);

			int i = 1;

			pstmt.setInt( i++ , sales.getSL_SEQ() );
			pstmt.setInt( i++ , sales.getSL_OMSEQ() );
			pstmt.setInt( i++ , sales.getSL_OMISEQ() );
			pstmt.setString( i++ , sales.getSL_CPIDP() );
			pstmt.setString( i++ , sales.getSL_CPIDS() );
			pstmt.setString( i++ , sales.getSL_MBID() );
			pstmt.setInt( i++ , sales.getSL_ACCOUNTMONEY() );
			pstmt.setInt( i++ , sales.getSL_CARDMONEY() );
			pstmt.setInt( i++ , sales.getSL_COUPONMONEY() );
			pstmt.setInt( i++ , sales.getSL_LATERMONEY() );
			pstmt.setInt( i++ , sales.getSL_BUDGETMONEY() );
			pstmt.setInt( i++ , sales.getSL_VIRTUALMONEY() );
			pstmt.setInt( i++ , sales.getSL_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , sales.getSL_ORIGNALMONEY() );
			pstmt.setInt( i++ , sales.getSL_SALEMONEY() );
			pstmt.setString( i++ , sales.getSL_CCIDB() );
			pstmt.setString( i++ , sales.getSL_CCIDS() );
			pstmt.setString( i++ , sales.getSL_CCBHANDLINGYN() );
			pstmt.setString( i++ , sales.getSL_CCSHANDLINGYN() );
			pstmt.setString( i++ , sales.getSL_TYPE() );
			pstmt.setString( i++ , sales.getSL_INID() );
//			pstmt.setTimestamp( i++, sales.getSL_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Sales up Error : "+se+" \n sql : "+sql );
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
			sql = "update sales set ";

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
			System.out.println("Sales upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update sales set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Sales upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from sales";

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
			System.out.println("Sales delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from sales";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Sales delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Sales max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Sales max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Sales lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}