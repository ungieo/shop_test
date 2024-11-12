package ordermainitem.dao;

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
import ordermainitem.dto.Ordermainitem;

public class OrdermainitemDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public OrdermainitemDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Ordermainitem ordermainitem)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into ordermainitem(OMI_SEQ, OMI_OMSEQ, OMI_PRSEQ, OMI_PROSEQ, OMI_PSWD, OMI_MBID, OMI_MBNAME, OMI_PAYTYPE, OMI_ACCOUNTMONEY, OMI_CARDMONEY, OMI_COUPONMONEY, OMI_LATERMONEY, OMI_POINTMONEY, OMI_SAVEMONEY, OMI_VIRTUALACCOUNTMONEY, OMI_RACCOUNTMONEY, OMI_RCARDMONEY, OMI_RCOUPONMONEY, OMI_RLATERMONEY, OMI_RPOINTMONEY, OMI_RSAVEMONEY, OMI_RVIRTUALACCOUNTMONEY, OMI_NEWSAVEMONEY, OMI_ORIGNALMONEY, OMI_TOTORIGNALMONEY, OMI_SALEMONEY, OMI_TOTSALEMONEY, OMI_DELITYPE, OMI_DELIMEMO, OMI_DELIMONEY, OMI_DELINUM, OMI_MEMO, OMI_PCCSEQ, OMI_ESCROWYN, OMI_PARTCANCELYN, OMI_EA, OMI_OUTEA, OMI_INEA, OMI_STATUS, OMI_STEP, OMI_TYPE, OMI_MOID, OMI_INID, OMI_MODATE, OMI_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, ordermainitem.getOMI_SEQ() );
			pstmt.setInt( i++, ordermainitem.getOMI_OMSEQ() );
			pstmt.setInt( i++, ordermainitem.getOMI_PRSEQ() );
			pstmt.setInt( i++, ordermainitem.getOMI_PROSEQ() );
			pstmt.setString( i++, ordermainitem.getOMI_PSWD() );
			pstmt.setString( i++, ordermainitem.getOMI_MBID() );
			pstmt.setString( i++, ordermainitem.getOMI_MBNAME() );
			pstmt.setString( i++, ordermainitem.getOMI_PAYTYPE() );
			pstmt.setInt( i++, ordermainitem.getOMI_ACCOUNTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_CARDMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_COUPONMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_LATERMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_POINTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_SAVEMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RACCOUNTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RCARDMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RCOUPONMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RLATERMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RPOINTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RSAVEMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_NEWSAVEMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_ORIGNALMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_TOTORIGNALMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_SALEMONEY() );
			pstmt.setInt( i++, ordermainitem.getOMI_TOTSALEMONEY() );
			pstmt.setString( i++, ordermainitem.getOMI_DELITYPE() );
			pstmt.setString( i++, ordermainitem.getOMI_DELIMEMO() );
			pstmt.setInt( i++, ordermainitem.getOMI_DELIMONEY() );
			pstmt.setString( i++, ordermainitem.getOMI_DELINUM() );
			pstmt.setString( i++, ordermainitem.getOMI_MEMO() );
			pstmt.setInt( i++, ordermainitem.getOMI_PCCSEQ() );
			pstmt.setString( i++, ordermainitem.getOMI_ESCROWYN() );
			pstmt.setString( i++, ordermainitem.getOMI_PARTCANCELYN() );
			pstmt.setInt( i++, ordermainitem.getOMI_EA() );
			pstmt.setInt( i++, ordermainitem.getOMI_OUTEA() );
			pstmt.setInt( i++, ordermainitem.getOMI_INEA() );
			pstmt.setString( i++, ordermainitem.getOMI_STATUS() );
			pstmt.setString( i++, ordermainitem.getOMI_STEP() );
			pstmt.setString( i++, ordermainitem.getOMI_TYPE() );
			pstmt.setString( i++, ordermainitem.getOMI_MOID() );
			pstmt.setString( i++, ordermainitem.getOMI_INID() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitem insert Error : "+se+" \nsql : "+sql+" \ndto : "+ordermainitem.toStr() );
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
			sql = "select count(*) from ordermainitem";

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
			System.out.println("Ordermainitem cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from ordermainitem";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitem cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitem one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Ordermainitem ordermainitem = new Ordermainitem();
		String sql = "";
		try{
			sql = "select * from ordermainitem";

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
				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
			}
			return ordermainitem;

		}catch(SQLException se){
			System.out.println("Ordermainitem one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Ordermainitem one(String whereStr, String orderStr)throws SQLException{

		Ordermainitem ordermainitem = new Ordermainitem();
		String sql = "";
		try{
			sql = "select * from ordermainitem";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
			}
			return ordermainitem;

		}catch(SQLException se){
			System.out.println("Ordermainitem one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitem> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitem> ordermainitemList = new ArrayList<Ordermainitem>();
		String sql = "";
		try{
			sql += "select * from ordermainitem";

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
				Ordermainitem ordermainitem = new Ordermainitem();

				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
				ordermainitemList.add(ordermainitem);
			}
			return ordermainitemList;

		}catch(SQLException se){
			System.out.println("Ordermainitem list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Ordermainitem> list( String whereStr, String orderStr )throws SQLException{

		List<Ordermainitem> ordermainitemList = new ArrayList<Ordermainitem>();
		String sql = "";
		try{
			sql += "select * from ordermainitem";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitem ordermainitem = new Ordermainitem();

				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
				ordermainitemList.add(ordermainitem);
			}
			return ordermainitemList;

		}catch(SQLException se){
			System.out.println("Ordermainitem list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitem> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Ordermainitem> ordermainitemList = new ArrayList<Ordermainitem>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitem";

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
				Ordermainitem ordermainitem = new Ordermainitem();

				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
				ordermainitemList.add(ordermainitem);
			}
			return ordermainitemList;

		}catch(SQLException se){
			System.out.println("Ordermainitem list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Ordermainitem> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Ordermainitem> ordermainitemList = new ArrayList<Ordermainitem>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from ordermainitem";

			sql += "select * from ordermainitem";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Ordermainitem ordermainitem = new Ordermainitem();

				ordermainitem.setOMI_SEQ( rs.getInt("OMI_SEQ") );
				ordermainitem.setOMI_OMSEQ( rs.getInt("OMI_OMSEQ") );
				ordermainitem.setOMI_PRSEQ( rs.getInt("OMI_PRSEQ") );
				ordermainitem.setOMI_PROSEQ( rs.getInt("OMI_PROSEQ") );
				ordermainitem.setOMI_PSWD( rs.getString("OMI_PSWD") );
				ordermainitem.setOMI_MBID( rs.getString("OMI_MBID") );
				ordermainitem.setOMI_MBNAME( rs.getString("OMI_MBNAME") );
				ordermainitem.setOMI_PAYTYPE( rs.getString("OMI_PAYTYPE") );
				ordermainitem.setOMI_ACCOUNTMONEY( rs.getInt("OMI_ACCOUNTMONEY") );
				ordermainitem.setOMI_CARDMONEY( rs.getInt("OMI_CARDMONEY") );
				ordermainitem.setOMI_COUPONMONEY( rs.getInt("OMI_COUPONMONEY") );
				ordermainitem.setOMI_LATERMONEY( rs.getInt("OMI_LATERMONEY") );
				ordermainitem.setOMI_POINTMONEY( rs.getInt("OMI_POINTMONEY") );
				ordermainitem.setOMI_SAVEMONEY( rs.getInt("OMI_SAVEMONEY") );
				ordermainitem.setOMI_VIRTUALACCOUNTMONEY( rs.getInt("OMI_VIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_RACCOUNTMONEY( rs.getInt("OMI_RACCOUNTMONEY") );
				ordermainitem.setOMI_RCARDMONEY( rs.getInt("OMI_RCARDMONEY") );
				ordermainitem.setOMI_RCOUPONMONEY( rs.getInt("OMI_RCOUPONMONEY") );
				ordermainitem.setOMI_RLATERMONEY( rs.getInt("OMI_RLATERMONEY") );
				ordermainitem.setOMI_RPOINTMONEY( rs.getInt("OMI_RPOINTMONEY") );
				ordermainitem.setOMI_RSAVEMONEY( rs.getInt("OMI_RSAVEMONEY") );
				ordermainitem.setOMI_RVIRTUALACCOUNTMONEY( rs.getInt("OMI_RVIRTUALACCOUNTMONEY") );
				ordermainitem.setOMI_NEWSAVEMONEY( rs.getInt("OMI_NEWSAVEMONEY") );
				ordermainitem.setOMI_ORIGNALMONEY( rs.getInt("OMI_ORIGNALMONEY") );
				ordermainitem.setOMI_TOTORIGNALMONEY( rs.getInt("OMI_TOTORIGNALMONEY") );
				ordermainitem.setOMI_SALEMONEY( rs.getInt("OMI_SALEMONEY") );
				ordermainitem.setOMI_TOTSALEMONEY( rs.getInt("OMI_TOTSALEMONEY") );
				ordermainitem.setOMI_DELITYPE( rs.getString("OMI_DELITYPE") );
				ordermainitem.setOMI_DELIMEMO( rs.getString("OMI_DELIMEMO") );
				ordermainitem.setOMI_DELIMONEY( rs.getInt("OMI_DELIMONEY") );
				ordermainitem.setOMI_DELINUM( rs.getString("OMI_DELINUM") );
				ordermainitem.setOMI_MEMO( rs.getString("OMI_MEMO") );
				ordermainitem.setOMI_PCCSEQ( rs.getInt("OMI_PCCSEQ") );
				ordermainitem.setOMI_ESCROWYN( rs.getString("OMI_ESCROWYN") );
				ordermainitem.setOMI_PARTCANCELYN( rs.getString("OMI_PARTCANCELYN") );
				ordermainitem.setOMI_EA( rs.getInt("OMI_EA") );
				ordermainitem.setOMI_OUTEA( rs.getInt("OMI_OUTEA") );
				ordermainitem.setOMI_INEA( rs.getInt("OMI_INEA") );
				ordermainitem.setOMI_STATUS( rs.getString("OMI_STATUS") );
				ordermainitem.setOMI_STEP( rs.getString("OMI_STEP") );
				ordermainitem.setOMI_TYPE( rs.getString("OMI_TYPE") );
				ordermainitem.setOMI_MOID( rs.getString("OMI_MOID") );
				ordermainitem.setOMI_INID( rs.getString("OMI_INID") );
				ordermainitem.setOMI_MODATE( rs.getTimestamp("OMI_MODATE") );
				ordermainitem.setOMI_INDATE( rs.getTimestamp("OMI_INDATE") );
				ordermainitemList.add(ordermainitem);
			}
			return ordermainitemList;

		}catch(SQLException se){
			System.out.println("Ordermainitem list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> ordermainitemList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from ordermainitem";

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
				Map<String, Object> ordermainitem = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					ordermainitem.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				ordermainitemList.add(ordermainitem);
			}
			return ordermainitemList;

		}catch(SQLException se){
			System.out.println("Ordermainitem listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Ordermainitem ordermainitem = ( Ordermainitem )sqlMap.get( "ordermainitem" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitem set OMI_SEQ=?, OMI_OMSEQ=?, OMI_PRSEQ=?, OMI_PROSEQ=?, OMI_PSWD=?, OMI_MBID=?, OMI_MBNAME=?, OMI_PAYTYPE=?, OMI_ACCOUNTMONEY=?, OMI_CARDMONEY=?, OMI_COUPONMONEY=?, OMI_LATERMONEY=?, OMI_POINTMONEY=?, OMI_SAVEMONEY=?, OMI_VIRTUALACCOUNTMONEY=?, OMI_RACCOUNTMONEY=?, OMI_RCARDMONEY=?, OMI_RCOUPONMONEY=?, OMI_RLATERMONEY=?, OMI_RPOINTMONEY=?, OMI_RSAVEMONEY=?, OMI_RVIRTUALACCOUNTMONEY=?, OMI_NEWSAVEMONEY=?, OMI_ORIGNALMONEY=?, OMI_TOTORIGNALMONEY=?, OMI_SALEMONEY=?, OMI_TOTSALEMONEY=?, OMI_DELITYPE=?, OMI_DELIMEMO=?, OMI_DELIMONEY=?, OMI_DELINUM=?, OMI_MEMO=?, OMI_PCCSEQ=?, OMI_ESCROWYN=?, OMI_PARTCANCELYN=?, OMI_EA=?, OMI_OUTEA=?, OMI_INEA=?, OMI_STATUS=?, OMI_STEP=?, OMI_TYPE=?, OMI_MOID=?, OMI_INID=?, OMI_MODATE=sysdate(), OMI_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , ordermainitem.getOMI_SEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_OMSEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PRSEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PROSEQ() );
			pstmt.setString( i++ , ordermainitem.getOMI_PSWD() );
			pstmt.setString( i++ , ordermainitem.getOMI_MBID() );
			pstmt.setString( i++ , ordermainitem.getOMI_MBNAME() );
			pstmt.setString( i++ , ordermainitem.getOMI_PAYTYPE() );
			pstmt.setInt( i++ , ordermainitem.getOMI_ACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_CARDMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_COUPONMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_LATERMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_POINTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_SAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RCARDMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RCOUPONMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RLATERMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RPOINTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RSAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_NEWSAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_ORIGNALMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_TOTORIGNALMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_SALEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_TOTSALEMONEY() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELITYPE() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELIMEMO() );
			pstmt.setInt( i++ , ordermainitem.getOMI_DELIMONEY() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELINUM() );
			pstmt.setString( i++ , ordermainitem.getOMI_MEMO() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PCCSEQ() );
			pstmt.setString( i++ , ordermainitem.getOMI_ESCROWYN() );
			pstmt.setString( i++ , ordermainitem.getOMI_PARTCANCELYN() );
			pstmt.setInt( i++ , ordermainitem.getOMI_EA() );
			pstmt.setInt( i++ , ordermainitem.getOMI_OUTEA() );
			pstmt.setInt( i++ , ordermainitem.getOMI_INEA() );
			pstmt.setString( i++ , ordermainitem.getOMI_STATUS() );
			pstmt.setString( i++ , ordermainitem.getOMI_STEP() );
			pstmt.setString( i++ , ordermainitem.getOMI_TYPE() );
			pstmt.setString( i++ , ordermainitem.getOMI_MOID() );
			pstmt.setString( i++ , ordermainitem.getOMI_INID() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_INDATE() );


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
			System.out.println("Ordermainitem up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Ordermainitem ordermainitem, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update ordermainitem set OMI_SEQ=?, OMI_OMSEQ=?, OMI_PRSEQ=?, OMI_PROSEQ=?, OMI_PSWD=?, OMI_MBID=?, OMI_MBNAME=?, OMI_PAYTYPE=?, OMI_ACCOUNTMONEY=?, OMI_CARDMONEY=?, OMI_COUPONMONEY=?, OMI_LATERMONEY=?, OMI_POINTMONEY=?, OMI_SAVEMONEY=?, OMI_VIRTUALACCOUNTMONEY=?, OMI_RACCOUNTMONEY=?, OMI_RCARDMONEY=?, OMI_RCOUPONMONEY=?, OMI_RLATERMONEY=?, OMI_RPOINTMONEY=?, OMI_RSAVEMONEY=?, OMI_RVIRTUALACCOUNTMONEY=?, OMI_NEWSAVEMONEY=?, OMI_ORIGNALMONEY=?, OMI_TOTORIGNALMONEY=?, OMI_SALEMONEY=?, OMI_TOTSALEMONEY=?, OMI_DELITYPE=?, OMI_DELIMEMO=?, OMI_DELIMONEY=?, OMI_DELINUM=?, OMI_MEMO=?, OMI_PCCSEQ=?, OMI_ESCROWYN=?, OMI_PARTCANCELYN=?, OMI_EA=?, OMI_OUTEA=?, OMI_INEA=?, OMI_STATUS=?, OMI_STEP=?, OMI_TYPE=?, OMI_MOID=?, OMI_INID=?, OMI_MODATE=sysdate(), OMI_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setInt( i++ , ordermainitem.getOMI_SEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_OMSEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PRSEQ() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PROSEQ() );
			pstmt.setString( i++ , ordermainitem.getOMI_PSWD() );
			pstmt.setString( i++ , ordermainitem.getOMI_MBID() );
			pstmt.setString( i++ , ordermainitem.getOMI_MBNAME() );
			pstmt.setString( i++ , ordermainitem.getOMI_PAYTYPE() );
			pstmt.setInt( i++ , ordermainitem.getOMI_ACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_CARDMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_COUPONMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_LATERMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_POINTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_SAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_VIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RCARDMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RCOUPONMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RLATERMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RPOINTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RSAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_RVIRTUALACCOUNTMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_NEWSAVEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_ORIGNALMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_TOTORIGNALMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_SALEMONEY() );
			pstmt.setInt( i++ , ordermainitem.getOMI_TOTSALEMONEY() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELITYPE() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELIMEMO() );
			pstmt.setInt( i++ , ordermainitem.getOMI_DELIMONEY() );
			pstmt.setString( i++ , ordermainitem.getOMI_DELINUM() );
			pstmt.setString( i++ , ordermainitem.getOMI_MEMO() );
			pstmt.setInt( i++ , ordermainitem.getOMI_PCCSEQ() );
			pstmt.setString( i++ , ordermainitem.getOMI_ESCROWYN() );
			pstmt.setString( i++ , ordermainitem.getOMI_PARTCANCELYN() );
			pstmt.setInt( i++ , ordermainitem.getOMI_EA() );
			pstmt.setInt( i++ , ordermainitem.getOMI_OUTEA() );
			pstmt.setInt( i++ , ordermainitem.getOMI_INEA() );
			pstmt.setString( i++ , ordermainitem.getOMI_STATUS() );
			pstmt.setString( i++ , ordermainitem.getOMI_STEP() );
			pstmt.setString( i++ , ordermainitem.getOMI_TYPE() );
			pstmt.setString( i++ , ordermainitem.getOMI_MOID() );
			pstmt.setString( i++ , ordermainitem.getOMI_INID() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_MODATE() );
//			pstmt.setTimestamp( i++, ordermainitem.getOMI_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitem up Error : "+se+" \n sql : "+sql );
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
			sql = "update ordermainitem set ";

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
			System.out.println("Ordermainitem upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update ordermainitem set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitem upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from ordermainitem";

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
			System.out.println("Ordermainitem delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from ordermainitem";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Ordermainitem delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitem max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Ordermainitem max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Ordermainitem lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}