package virtualmoney.dao;

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
import virtualmoney.dto.Virtualmoney;

public class VirtualmoneyDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public VirtualmoneyDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Virtualmoney virtualmoney)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into virtualmoney(VTM_SEQ, VTM_MBID, VTM_DESCRIPTION, VTM_OMSEQ, VTM_OMISEQ, VTM_MONEY, VTN_USETYPE, VTM_TYPE, VTM_USE, VTM_INID, VTM_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, virtualmoney.getVTM_SEQ() );
			pstmt.setString( i++, virtualmoney.getVTM_MBID() );
			pstmt.setString( i++, virtualmoney.getVTM_DESCRIPTION() );
			pstmt.setInt( i++, virtualmoney.getVTM_OMSEQ() );
			pstmt.setInt( i++, virtualmoney.getVTM_OMISEQ() );
			pstmt.setInt( i++, virtualmoney.getVTM_MONEY() );
			pstmt.setString( i++, virtualmoney.getVTN_USETYPE() );
			pstmt.setString( i++, virtualmoney.getVTM_TYPE() );
			pstmt.setString( i++, virtualmoney.getVTM_USE() );
			pstmt.setString( i++, virtualmoney.getVTM_INID() );
//			pstmt.setTimestamp( i++, virtualmoney.getVTM_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Virtualmoney insert Error : "+se+" \nsql : "+sql+" \ndto : "+virtualmoney.toStr() );
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
			sql = "select count(*) from virtualmoney";

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
			System.out.println("Virtualmoney cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from virtualmoney";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Virtualmoney cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Virtualmoney one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Virtualmoney virtualmoney = new Virtualmoney();
		String sql = "";
		try{
			sql = "select * from virtualmoney";

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
				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
			}
			return virtualmoney;

		}catch(SQLException se){
			System.out.println("Virtualmoney one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Virtualmoney one(String whereStr, String orderStr)throws SQLException{

		Virtualmoney virtualmoney = new Virtualmoney();
		String sql = "";
		try{
			sql = "select * from virtualmoney";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
			}
			return virtualmoney;

		}catch(SQLException se){
			System.out.println("Virtualmoney one Error : "+se+" \n sql : "+sql );
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
			sql += " from virtualmoney";

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

			Map<String, Object> virtualmoney = new HashMap<String, Object>();
			while( rs.next() ){
				for( int i = 1; i <= colCnt; i++ ){
					virtualmoney.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
			}
			return virtualmoney;

		}catch(SQLException se){
			System.out.println("Virtualmoney oneChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Virtualmoney> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Virtualmoney> virtualmoneyList = new ArrayList<Virtualmoney>();
		String sql = "";
		try{
			sql += "select * from virtualmoney";

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
				Virtualmoney virtualmoney = new Virtualmoney();

				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
				virtualmoneyList.add(virtualmoney);
			}
			return virtualmoneyList;

		}catch(SQLException se){
			System.out.println("Virtualmoney list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Virtualmoney> list( String whereStr, String orderStr )throws SQLException{

		List<Virtualmoney> virtualmoneyList = new ArrayList<Virtualmoney>();
		String sql = "";
		try{
			sql += "select * from virtualmoney";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Virtualmoney virtualmoney = new Virtualmoney();

				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
				virtualmoneyList.add(virtualmoney);
			}
			return virtualmoneyList;

		}catch(SQLException se){
			System.out.println("Virtualmoney list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Virtualmoney> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Virtualmoney> virtualmoneyList = new ArrayList<Virtualmoney>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from virtualmoney";

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
				Virtualmoney virtualmoney = new Virtualmoney();

				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
				virtualmoneyList.add(virtualmoney);
			}
			return virtualmoneyList;

		}catch(SQLException se){
			System.out.println("Virtualmoney list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Virtualmoney> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Virtualmoney> virtualmoneyList = new ArrayList<Virtualmoney>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from virtualmoney";

			sql += "select * from virtualmoney";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Virtualmoney virtualmoney = new Virtualmoney();

				virtualmoney.setVTM_SEQ( rs.getInt("VTM_SEQ") );
				virtualmoney.setVTM_MBID( rs.getString("VTM_MBID") );
				virtualmoney.setVTM_DESCRIPTION( rs.getString("VTM_DESCRIPTION") );
				virtualmoney.setVTM_OMSEQ( rs.getInt("VTM_OMSEQ") );
				virtualmoney.setVTM_OMISEQ( rs.getInt("VTM_OMISEQ") );
				virtualmoney.setVTM_MONEY( rs.getInt("VTM_MONEY") );
				virtualmoney.setVTN_USETYPE( rs.getString("VTN_USETYPE") );
				virtualmoney.setVTM_TYPE( rs.getString("VTM_TYPE") );
				virtualmoney.setVTM_USE( rs.getString("VTM_USE") );
				virtualmoney.setVTM_INID( rs.getString("VTM_INID") );
				virtualmoney.setVTM_INDATE( rs.getTimestamp("VTM_INDATE") );
				virtualmoneyList.add(virtualmoney);
			}
			return virtualmoneyList;

		}catch(SQLException se){
			System.out.println("Virtualmoney list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> virtualmoneyList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from virtualmoney";

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
				Map<String, Object> virtualmoney = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					virtualmoney.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				virtualmoneyList.add(virtualmoney);
			}
			return virtualmoneyList;

		}catch(SQLException se){
			System.out.println("Virtualmoney listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Virtualmoney virtualmoney = ( Virtualmoney )sqlMap.get( "virtualmoney" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update virtualmoney set VTM_SEQ=?, VTM_MBID=?, VTM_DESCRIPTION=?, VTM_OMSEQ=?, VTM_OMISEQ=?, VTM_MONEY=?, VTN_USETYPE=?, VTM_TYPE=?, VTM_USE=?, VTM_INID=?, VTM_INDATE=sysdate()";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

			pstmt.setInt( i++ , virtualmoney.getVTM_SEQ() );
			pstmt.setString( i++ , virtualmoney.getVTM_MBID() );
			pstmt.setString( i++ , virtualmoney.getVTM_DESCRIPTION() );
			pstmt.setInt( i++ , virtualmoney.getVTM_OMSEQ() );
			pstmt.setInt( i++ , virtualmoney.getVTM_OMISEQ() );
			pstmt.setInt( i++ , virtualmoney.getVTM_MONEY() );
			pstmt.setString( i++ , virtualmoney.getVTN_USETYPE() );
			pstmt.setString( i++ , virtualmoney.getVTM_TYPE() );
			pstmt.setString( i++ , virtualmoney.getVTM_USE() );
			pstmt.setString( i++ , virtualmoney.getVTM_INID() );
//			pstmt.setTimestamp( i++, virtualmoney.getVTM_INDATE() );


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
			System.out.println("Virtualmoney up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Virtualmoney virtualmoney, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update virtualmoney set VTM_SEQ=?, VTM_MBID=?, VTM_DESCRIPTION=?, VTM_OMSEQ=?, VTM_OMISEQ=?, VTM_MONEY=?, VTN_USETYPE=?, VTM_TYPE=?, VTM_USE=?, VTM_INID=?, VTM_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);

			int i = 1;

			pstmt.setInt( i++ , virtualmoney.getVTM_SEQ() );
			pstmt.setString( i++ , virtualmoney.getVTM_MBID() );
			pstmt.setString( i++ , virtualmoney.getVTM_DESCRIPTION() );
			pstmt.setInt( i++ , virtualmoney.getVTM_OMSEQ() );
			pstmt.setInt( i++ , virtualmoney.getVTM_OMISEQ() );
			pstmt.setInt( i++ , virtualmoney.getVTM_MONEY() );
			pstmt.setString( i++ , virtualmoney.getVTN_USETYPE() );
			pstmt.setString( i++ , virtualmoney.getVTM_TYPE() );
			pstmt.setString( i++ , virtualmoney.getVTM_USE() );
			pstmt.setString( i++ , virtualmoney.getVTM_INID() );
//			pstmt.setTimestamp( i++, virtualmoney.getVTM_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Virtualmoney up Error : "+se+" \n sql : "+sql );
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
			sql = "update virtualmoney set ";

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
			System.out.println("Virtualmoney upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update virtualmoney set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Virtualmoney upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from virtualmoney";

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
			System.out.println("Virtualmoney delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from virtualmoney";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Virtualmoney delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Virtualmoney max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Virtualmoney max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Virtualmoney lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}