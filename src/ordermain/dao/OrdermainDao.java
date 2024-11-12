package ordermain.dao;

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
import ordermain.dto.Ordermain;

public class OrdermainDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OrdermainDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Ordermain ordermain)throws SQLException{

		int result = 0;
		String sql = "";
		try{

//			sql = "insert into ordermain(OM_SEQ, OM_ID, OM_PGID, OM_PSWD, OM_MBID, OM_CPIDP, OM_CPIDS, OM_MBNAME, OM_PRNAME, OM_PAYTYPE, OM_ACCOUNTMONEY, OM_BUDGETMONEY, OM_CARDMONEY, OM_COUPONMONEY, OM_LATERMONEY, OM_VIRTUALMONEY, OM_VIRTUALACCOUNTMONEY, OM_RACCOUNTMONEY, OM_RCARDMONEY, OM_RCOUPONMONEY, OM_RLATERMONEY, OM_RVIRTUALMONEY, OM_RVIRTUALACCOUNTMONEY, OM_NEWVIRTUALMONEY, OM_ORIGNALMONEY, OM_SALEMONEY, OM_DELITYPE, OM_DELIMEMO, OM_DELIMONEY, OM_DELINUM, OM_MEMO, OM_PCCSEQ, OM_ESCROWYN, OM_PARTCANCELYN, OM_STATUS, OM_TYPE, OM_INID, OM_INDATE)";
//			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";
			
			sql = "insert into ordermain(OM_SEQ, OM_ID, OM_PGID, OM_PSWD, OM_MBID, OM_CPIDP, OM_CPIDS, OM_MBNAME, OM_PAYTYPE, OM_ACCOUNTMONEY, OM_BUDGETMONEY, OM_CARDMONEY, OM_COUPONMONEY, OM_LATERMONEY, OM_VIRTUALMONEY, OM_VIRTUALACCOUNTMONEY, OM_RACCOUNTMONEY, OM_RCARDMONEY, OM_RCOUPONMONEY, OM_RLATERMONEY, OM_RVIRTUALMONEY, OM_RVIRTUALACCOUNTMONEY, OM_NEWVIRTUALMONEY, OM_ORIGNALMONEY, OM_SALEMONEY, OM_DELITYPE, OM_DELIMEMO, OM_DELIMONEY, OM_DELINUM, OM_MEMO, OM_PCCSEQ, OM_ESCROWYN, OM_PARTCANCELYN, OM_STATUS, OM_TYPE, OM_INID, OM_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, ordermain.getOM_SEQ() );
			pstmt.setString( i++, ordermain.getOM_ID() );
			pstmt.setString( i++, ordermain.getOM_PGID() );
			pstmt.setString( i++, ordermain.getOM_PSWD() );
			pstmt.setString( i++, ordermain.getOM_MBID() );
			pstmt.setString( i++, ordermain.getOM_CPIDP() );
			pstmt.setString( i++, ordermain.getOM_CPIDS() );
//			pstmt.setString( i++, ordermain.getOM_MBNAME() );
			pstmt.setString( i++, ordermain.getOM_PRNAME() );
			pstmt.setString( i++, ordermain.getOM_PAYTYPE() );
			pstmt.setInt( i++, ordermain.getOM_ACCOUNTMONEY() );
			pstmt.setInt( i++, ordermain.getOM_BUDGETMONEY() );
			pstmt.setInt( i++, ordermain.getOM_CARDMONEY() );
			pstmt.setInt( i++, ordermain.getOM_COUPONMONEY() );
			pstmt.setInt( i++, ordermain.getOM_LATERMONEY() );
			pstmt.setInt( i++, ordermain.getOM_VIRTUALMONEY() );
			pstmt.setInt( i++, ordermain.getOM_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RACCOUNTMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RCARDMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RCOUPONMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RLATERMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RVIRTUALMONEY() );
			pstmt.setInt( i++, ordermain.getOM_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++, ordermain.getOM_NEWVIRTUALMONEY() );
			pstmt.setInt( i++, ordermain.getOM_ORIGNALMONEY() );
			pstmt.setInt( i++, ordermain.getOM_SALEMONEY() );
			pstmt.setString( i++, ordermain.getOM_DELITYPE() );
			pstmt.setString( i++, ordermain.getOM_DELIMEMO() );
			pstmt.setInt( i++, ordermain.getOM_DELIMONEY() );
			pstmt.setString( i++, ordermain.getOM_DELINUM() );
			pstmt.setString( i++, ordermain.getOM_MEMO() );
			pstmt.setInt( i++, ordermain.getOM_PCCSEQ() );
			pstmt.setString( i++, ordermain.getOM_ESCROWYN() );
			pstmt.setString( i++, ordermain.getOM_PARTCANCELYN() );
			pstmt.setString( i++, ordermain.getOM_STATUS() );
			pstmt.setString( i++, ordermain.getOM_TYPE() );
			pstmt.setString( i++, ordermain.getOM_INID() );
//			pstmt.setTimestamp( i++, ordermain.getOM_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Ordermain insert Error : "+se+" \nsql : "+sql+" \ndto : "+ordermain.toStr() );
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
			sql = "select count(*) from ordermain";

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
			System.out.println("Ordermain cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from ordermain";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Ordermain cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermain one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Ordermain ordermain = new Ordermain();
		String sql = "";
		try{
			sql = "select * from ordermain";

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
				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
			}
			return ordermain;

		}catch(SQLException se){
			System.out.println("Ordermain one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermain one(String whereStr, String orderStr)throws SQLException{

		Ordermain ordermain = new Ordermain();
		String sql = "";
		try{
			sql = "select * from ordermain";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
			}
			return ordermain;

		}catch(SQLException se){
			System.out.println("Ordermain one Error : "+se+" \n sql : "+sql );
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
			sql += " from ordermain";

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

			Map<String, Object> ordermain = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					ordermain.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return ordermain;

		}catch(SQLException se){
			System.out.println("Ordermain oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermain> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermain> ordermainList = new ArrayList<Ordermain>();
		String sql = "";
		try{
			sql += "select * from ordermain";

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
				Ordermain ordermain = new Ordermain();

				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
				ordermainList.add(ordermain);
			}
			return ordermainList;

		}catch(SQLException se){
			System.out.println("Ordermain list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermain> list( String whereStr, String orderStr )throws SQLException{

		List<Ordermain> ordermainList = new ArrayList<Ordermain>();
		String sql = "";
		try{
			sql += "select * from ordermain";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermain ordermain = new Ordermain();

				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
				ordermainList.add(ordermain);
			}
			return ordermainList;

		}catch(SQLException se){
			System.out.println("Ordermain list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermain> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermain> ordermainList = new ArrayList<Ordermain>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermain";

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
				Ordermain ordermain = new Ordermain();

				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
				ordermainList.add(ordermain);
			}
			return ordermainList;

		}catch(SQLException se){
			System.out.println("Ordermain list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermain> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Ordermain> ordermainList = new ArrayList<Ordermain>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermain";

			sql += "select * from ordermain";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermain ordermain = new Ordermain();

				ordermain.setOM_SEQ( rs.getInt("OM_SEQ") );
				ordermain.setOM_ID( rs.getString("OM_ID") );
				ordermain.setOM_PGID( rs.getString("OM_PGID") );
				ordermain.setOM_PSWD( rs.getString("OM_PSWD") );
				ordermain.setOM_MBID( rs.getString("OM_MBID") );
				ordermain.setOM_CPIDP( rs.getString("OM_CPIDP") );
				ordermain.setOM_CPIDS( rs.getString("OM_CPIDS") );
//				ordermain.setOM_MBNAME( rs.getString("OM_MBNAME") );
				ordermain.setOM_PRNAME( rs.getString("OM_PRNAME") );
				ordermain.setOM_PAYTYPE( rs.getString("OM_PAYTYPE") );
				ordermain.setOM_ACCOUNTMONEY( rs.getInt("OM_ACCOUNTMONEY") );
				ordermain.setOM_BUDGETMONEY( rs.getInt("OM_BUDGETMONEY") );
				ordermain.setOM_CARDMONEY( rs.getInt("OM_CARDMONEY") );
				ordermain.setOM_COUPONMONEY( rs.getInt("OM_COUPONMONEY") );
				ordermain.setOM_LATERMONEY( rs.getInt("OM_LATERMONEY") );
				ordermain.setOM_VIRTUALMONEY( rs.getInt("OM_VIRTUALMONEY") );
				ordermain.setOM_VIRTUALACCOUNTMONEY( rs.getInt("OM_VIRTUALACCOUNTMONEY") );
				ordermain.setOM_RACCOUNTMONEY( rs.getInt("OM_RACCOUNTMONEY") );
				ordermain.setOM_RCARDMONEY( rs.getInt("OM_RCARDMONEY") );
				ordermain.setOM_RCOUPONMONEY( rs.getInt("OM_RCOUPONMONEY") );
				ordermain.setOM_RLATERMONEY( rs.getInt("OM_RLATERMONEY") );
				ordermain.setOM_RVIRTUALMONEY( rs.getInt("OM_RVIRTUALMONEY") );
				ordermain.setOM_RVIRTUALACCOUNTMONEY( rs.getInt("OM_RVIRTUALACCOUNTMONEY") );
				ordermain.setOM_NEWVIRTUALMONEY( rs.getInt("OM_NEWVIRTUALMONEY") );
				ordermain.setOM_ORIGNALMONEY( rs.getInt("OM_ORIGNALMONEY") );
				ordermain.setOM_SALEMONEY( rs.getInt("OM_SALEMONEY") );
				ordermain.setOM_DELITYPE( rs.getString("OM_DELITYPE") );
				ordermain.setOM_DELIMEMO( rs.getString("OM_DELIMEMO") );
				ordermain.setOM_DELIMONEY( rs.getInt("OM_DELIMONEY") );
				ordermain.setOM_DELINUM( rs.getString("OM_DELINUM") );
				ordermain.setOM_MEMO( rs.getString("OM_MEMO") );
				ordermain.setOM_PCCSEQ( rs.getInt("OM_PCCSEQ") );
				ordermain.setOM_ESCROWYN( rs.getString("OM_ESCROWYN") );
				ordermain.setOM_PARTCANCELYN( rs.getString("OM_PARTCANCELYN") );
				ordermain.setOM_STATUS( rs.getString("OM_STATUS") );
				ordermain.setOM_TYPE( rs.getString("OM_TYPE") );
				ordermain.setOM_INID( rs.getString("OM_INID") );
				ordermain.setOM_INDATE( rs.getTimestamp("OM_INDATE") );
				ordermainList.add(ordermain);
			}
			return ordermainList;

		}catch(SQLException se){
			System.out.println("Ordermain list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> ordermainList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from ordermain";

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
				Map<String, Object> ordermain = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					ordermain.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				ordermainList.add(ordermain);
			}
			return ordermainList;

		}catch(SQLException se){
			System.out.println("Ordermain listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Ordermain ordermain = ( Ordermain )sqlMap.get( "ordermain" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
//			sql = "update ordermain set OM_SEQ=?, OM_ID=?, OM_PGID=?, OM_PSWD=?, OM_MBID=?, OM_CPIDP=?, OM_CPIDS=?, OM_MBNAME=?, OM_PRNAME=?, OM_PAYTYPE=?, OM_ACCOUNTMONEY=?, OM_BUDGETMONEY=?, OM_CARDMONEY=?, OM_COUPONMONEY=?, OM_LATERMONEY=?, OM_VIRTUALMONEY=?, OM_VIRTUALACCOUNTMONEY=?, OM_RACCOUNTMONEY=?, OM_RCARDMONEY=?, OM_RCOUPONMONEY=?, OM_RLATERMONEY=?, OM_RVIRTUALMONEY=?, OM_RVIRTUALACCOUNTMONEY=?, OM_NEWVIRTUALMONEY=?, OM_ORIGNALMONEY=?, OM_SALEMONEY=?, OM_DELITYPE=?, OM_DELIMEMO=?, OM_DELIMONEY=?, OM_DELINUM=?, OM_MEMO=?, OM_PCCSEQ=?, OM_ESCROWYN=?, OM_PARTCANCELYN=?, OM_STATUS=?, OM_TYPE=?, OM_INID=?, OM_INDATE=sysdate()";
			sql = "update ordermain set OM_SEQ=?, OM_ID=?, OM_PGID=?, OM_PSWD=?, OM_MBID=?, OM_CPIDP=?, OM_CPIDS=?, OM_PRNAME=?, OM_PAYTYPE=?, OM_ACCOUNTMONEY=?, OM_BUDGETMONEY=?, OM_CARDMONEY=?, OM_COUPONMONEY=?, OM_LATERMONEY=?, OM_VIRTUALMONEY=?, OM_VIRTUALACCOUNTMONEY=?, OM_RACCOUNTMONEY=?, OM_RCARDMONEY=?, OM_RCOUPONMONEY=?, OM_RLATERMONEY=?, OM_RVIRTUALMONEY=?, OM_RVIRTUALACCOUNTMONEY=?, OM_NEWVIRTUALMONEY=?, OM_ORIGNALMONEY=?, OM_SALEMONEY=?, OM_DELITYPE=?, OM_DELIMEMO=?, OM_DELIMONEY=?, OM_DELINUM=?, OM_MEMO=?, OM_PCCSEQ=?, OM_ESCROWYN=?, OM_PARTCANCELYN=?, OM_STATUS=?, OM_TYPE=?, OM_INID=?, OM_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , ordermain.getOM_SEQ() );
			pstmt.setString( i++ , ordermain.getOM_ID() );
			pstmt.setString( i++ , ordermain.getOM_PGID() );
			pstmt.setString( i++ , ordermain.getOM_PSWD() );
			pstmt.setString( i++ , ordermain.getOM_MBID() );
			pstmt.setString( i++ , ordermain.getOM_CPIDP() );
			pstmt.setString( i++ , ordermain.getOM_CPIDS() );
//			pstmt.setString( i++ , ordermain.getOM_MBNAME() );
			pstmt.setString( i++ , ordermain.getOM_PRNAME() );
			pstmt.setString( i++ , ordermain.getOM_PAYTYPE() );
			pstmt.setInt( i++ , ordermain.getOM_ACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_BUDGETMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_CARDMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_COUPONMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_LATERMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_VIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RCARDMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RCOUPONMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RLATERMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RVIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_NEWVIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_ORIGNALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_SALEMONEY() );
			pstmt.setString( i++ , ordermain.getOM_DELITYPE() );
			pstmt.setString( i++ , ordermain.getOM_DELIMEMO() );
			pstmt.setInt( i++ , ordermain.getOM_DELIMONEY() );
			pstmt.setString( i++ , ordermain.getOM_DELINUM() );
			pstmt.setString( i++ , ordermain.getOM_MEMO() );
			pstmt.setInt( i++ , ordermain.getOM_PCCSEQ() );
			pstmt.setString( i++ , ordermain.getOM_ESCROWYN() );
			pstmt.setString( i++ , ordermain.getOM_PARTCANCELYN() );
			pstmt.setString( i++ , ordermain.getOM_STATUS() );
			pstmt.setString( i++ , ordermain.getOM_TYPE() );
			pstmt.setString( i++ , ordermain.getOM_INID() );
//			pstmt.setTimestamp( i++, ordermain.getOM_INDATE() );


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
			System.out.println("Ordermain up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Ordermain ordermain, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermain set OM_SEQ=?, OM_ID=?, OM_PGID=?, OM_PSWD=?, OM_MBID=?, OM_CPIDP=?, OM_CPIDS=?, OM_MBNAME=?, OM_PRNAME=?, OM_PAYTYPE=?, OM_ACCOUNTMONEY=?, OM_BUDGETMONEY=?, OM_CARDMONEY=?, OM_COUPONMONEY=?, OM_LATERMONEY=?, OM_VIRTUALMONEY=?, OM_VIRTUALACCOUNTMONEY=?, OM_RACCOUNTMONEY=?, OM_RCARDMONEY=?, OM_RCOUPONMONEY=?, OM_RLATERMONEY=?, OM_RVIRTUALMONEY=?, OM_RVIRTUALACCOUNTMONEY=?, OM_NEWVIRTUALMONEY=?, OM_ORIGNALMONEY=?, OM_SALEMONEY=?, OM_DELITYPE=?, OM_DELIMEMO=?, OM_DELIMONEY=?, OM_DELINUM=?, OM_MEMO=?, OM_PCCSEQ=?, OM_ESCROWYN=?, OM_PARTCANCELYN=?, OM_STATUS=?, OM_TYPE=?, OM_INID=?, OM_INDATE=sysdate()";
			sql = "update ordermain set OM_SEQ=?, OM_ID=?, OM_PGID=?, OM_PSWD=?, OM_MBID=?, OM_CPIDP=?, OM_CPIDS=?, OM_PRNAME=?, OM_PAYTYPE=?, OM_ACCOUNTMONEY=?, OM_BUDGETMONEY=?, OM_CARDMONEY=?, OM_COUPONMONEY=?, OM_LATERMONEY=?, OM_VIRTUALMONEY=?, OM_VIRTUALACCOUNTMONEY=?, OM_RACCOUNTMONEY=?, OM_RCARDMONEY=?, OM_RCOUPONMONEY=?, OM_RLATERMONEY=?, OM_RVIRTUALMONEY=?, OM_RVIRTUALACCOUNTMONEY=?, OM_NEWVIRTUALMONEY=?, OM_ORIGNALMONEY=?, OM_SALEMONEY=?, OM_DELITYPE=?, OM_DELIMEMO=?, OM_DELIMONEY=?, OM_DELINUM=?, OM_MEMO=?, OM_PCCSEQ=?, OM_ESCROWYN=?, OM_PARTCANCELYN=?, OM_STATUS=?, OM_TYPE=?, OM_INID=?, OM_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);

			int i = 1;

			pstmt.setInt( i++ , ordermain.getOM_SEQ() );
			pstmt.setString( i++ , ordermain.getOM_ID() );
			pstmt.setString( i++ , ordermain.getOM_PGID() );
			pstmt.setString( i++ , ordermain.getOM_PSWD() );
			pstmt.setString( i++ , ordermain.getOM_MBID() );
			pstmt.setString( i++ , ordermain.getOM_CPIDP() );
			pstmt.setString( i++ , ordermain.getOM_CPIDS() );
//			pstmt.setString( i++ , ordermain.getOM_MBNAME() );
			pstmt.setString( i++ , ordermain.getOM_PRNAME() );
			pstmt.setString( i++ , ordermain.getOM_PAYTYPE() );
			pstmt.setInt( i++ , ordermain.getOM_ACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_BUDGETMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_CARDMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_COUPONMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_LATERMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_VIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RCARDMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RCOUPONMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RLATERMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RVIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_NEWVIRTUALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_ORIGNALMONEY() );
			pstmt.setInt( i++ , ordermain.getOM_SALEMONEY() );
			pstmt.setString( i++ , ordermain.getOM_DELITYPE() );
			pstmt.setString( i++ , ordermain.getOM_DELIMEMO() );
			pstmt.setInt( i++ , ordermain.getOM_DELIMONEY() );
			pstmt.setString( i++ , ordermain.getOM_DELINUM() );
			pstmt.setString( i++ , ordermain.getOM_MEMO() );
			pstmt.setInt( i++ , ordermain.getOM_PCCSEQ() );
			pstmt.setString( i++ , ordermain.getOM_ESCROWYN() );
			pstmt.setString( i++ , ordermain.getOM_PARTCANCELYN() );
			pstmt.setString( i++ , ordermain.getOM_STATUS() );
			pstmt.setString( i++ , ordermain.getOM_TYPE() );
			pstmt.setString( i++ , ordermain.getOM_INID() );
//			pstmt.setTimestamp( i++, ordermain.getOM_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermain up Error : "+se+" \n sql : "+sql );
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
			sql = "update ordermain set ";

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
			System.out.println("Ordermain upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update ordermain set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermain upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from ordermain";

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
			System.out.println("Ordermain delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from ordermain";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermain delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermain max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Ordermain max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermain lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}