package boardarticle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.HashMap;
import java.util.Map;

import system.db.util.DbUtil;
import system.util.Cvt;
import boardarticle.dto.Boardarticle;

public class BoardarticleDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardarticleDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Boardarticle boardarticle)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into boardarticle( BDA_BDID, BDA_BDCSEQ, BDA_CONTENT, BDA_FILENUM, BDA_GROUPNUM, BDA_LEVELNUM, BDA_STEPNUM, BDA_MBID, BDA_NAME, BDA_OWNERNAME, BDA_PSWD, BDA_READCNT, BDA_RECOMMENDCNT, BDA_IP, BDA_STATUS, BDA_SECRETUSE, BDA_LEVEL, BDA_TYPE, BDA_USE, BDA_MOID, BDA_INID, BDA_MODATE, BDA_INDATE)";
			sql += "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";


			pstmt = conn.prepareStatement(sql);
			int i = 1;

//			pstmt.setInt( i++, boardarticle.getBDA_SEQ() );
			pstmt.setString( i++, boardarticle.getBDA_BDID() );
			pstmt.setInt( i++, boardarticle.getBDA_BDCSEQ() );
			pstmt.setString( i++, boardarticle.getBDA_CONTENT() );
			pstmt.setInt( i++, boardarticle.getBDA_FILENUM() );
			pstmt.setInt( i++, boardarticle.getBDA_GROUPNUM() );
			pstmt.setInt( i++, boardarticle.getBDA_LEVELNUM() );
			pstmt.setInt( i++, boardarticle.getBDA_STEPNUM() );
			pstmt.setString( i++, boardarticle.getBDA_MBID() );
			pstmt.setString( i++, boardarticle.getBDA_NAME() );
			pstmt.setString( i++, boardarticle.getBDA_OWNERNAME() );
			pstmt.setString( i++, boardarticle.getBDA_PSWD() );
			pstmt.setInt( i++, boardarticle.getBDA_READCNT() );
			pstmt.setInt( i++, boardarticle.getBDA_RECOMMENDCNT() );
			pstmt.setString( i++, boardarticle.getBDA_IP() );
			pstmt.setInt( i++, boardarticle.getBDA_STATUS() );
			pstmt.setString( i++, boardarticle.getBDA_SECRETUSE() );
			pstmt.setString( i++, boardarticle.getBDA_LEVEL() );
			pstmt.setString( i++, boardarticle.getBDA_TYPE() );
			pstmt.setString( i++, boardarticle.getBDA_USE() );
			pstmt.setString( i++, boardarticle.getBDA_MOID() );
			pstmt.setString( i++, boardarticle.getBDA_INID() );
//			pstmt.setTimestamp( i++, boardarticle.getBDA_MODATE() );
//			pstmt.setTimestamp( i++, boardarticle.getBDA_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Boardarticle insert Error : "+se+" \nsql : "+sql+" \ndto : "+boardarticle.toStr() );
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
			sql = "select count(*) from boardarticle";

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
			System.out.println("Boardarticle cnt Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Boardarticle one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Boardarticle boardarticle = new Boardarticle();
		String sql = "";
		try{
			sql = "select * from boardarticle";

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

			if( rs.next() ){
				boardarticle.setBDA_SEQ( rs.getInt("BDA_SEQ") );
				boardarticle.setBDA_BDID( rs.getString("BDA_BDID") );
				boardarticle.setBDA_BDCSEQ( rs.getInt("BDA_BDCSEQ") );
				boardarticle.setBDA_CONTENT( rs.getString("BDA_CONTENT") );
				boardarticle.setBDA_FILENUM( rs.getInt("BDA_FILENUM") );
				boardarticle.setBDA_GROUPNUM( rs.getInt("BDA_GROUPNUM") );
				boardarticle.setBDA_LEVELNUM( rs.getInt("BDA_LEVELNUM") );
				boardarticle.setBDA_STEPNUM( rs.getInt("BDA_STEPNUM") );
				boardarticle.setBDA_MBID( rs.getString("BDA_MBID") );
				boardarticle.setBDA_NAME( rs.getString("BDA_NAME") );
				boardarticle.setBDA_OWNERNAME( rs.getString("BDA_OWNERNAME") );
				boardarticle.setBDA_PSWD( rs.getString("BDA_PSWD") );
				boardarticle.setBDA_READCNT( rs.getInt("BDA_READCNT") );
				boardarticle.setBDA_RECOMMENDCNT( rs.getInt("BDA_RECOMMENDCNT") );
				boardarticle.setBDA_IP( rs.getString("BDA_IP") );
				boardarticle.setBDA_STATUS( rs.getInt("BDA_STATUS") );
				boardarticle.setBDA_SECRETUSE( rs.getString("BDA_SECRETUSE") );
				boardarticle.setBDA_LEVEL( rs.getString("BDA_LEVEL") );
				boardarticle.setBDA_TYPE( rs.getString("BDA_TYPE") );
				boardarticle.setBDA_USE( rs.getString("BDA_USE") );
				boardarticle.setBDA_MOID( rs.getString("BDA_MOID") );
				boardarticle.setBDA_INID( rs.getString("BDA_INID") );
				boardarticle.setBDA_MODATE( rs.getTimestamp("BDA_MODATE") );
				boardarticle.setBDA_INDATE( rs.getTimestamp("BDA_INDATE") );
			}
			return boardarticle;

		}catch(SQLException se){
			System.out.println("Boardarticle one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Boardarticle> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Boardarticle> boardarticleList = new ArrayList<Boardarticle>();
		String sql = "";
		try{
			sql += "select * from boardarticle";

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

			while( rs.next() ){
				Boardarticle boardarticle = new Boardarticle();

				boardarticle.setBDA_SEQ( rs.getInt("BDA_SEQ") );
				boardarticle.setBDA_BDID( rs.getString("BDA_BDID") );
				boardarticle.setBDA_BDCSEQ( rs.getInt("BDA_BDCSEQ") );
				boardarticle.setBDA_CONTENT( rs.getString("BDA_CONTENT") );
				boardarticle.setBDA_FILENUM( rs.getInt("BDA_FILENUM") );
				boardarticle.setBDA_GROUPNUM( rs.getInt("BDA_GROUPNUM") );
				boardarticle.setBDA_LEVELNUM( rs.getInt("BDA_LEVELNUM") );
				boardarticle.setBDA_STEPNUM( rs.getInt("BDA_STEPNUM") );
				boardarticle.setBDA_MBID( rs.getString("BDA_MBID") );
				boardarticle.setBDA_NAME( rs.getString("BDA_NAME") );
				boardarticle.setBDA_OWNERNAME( rs.getString("BDA_OWNERNAME") );
				boardarticle.setBDA_PSWD( rs.getString("BDA_PSWD") );
				boardarticle.setBDA_READCNT( rs.getInt("BDA_READCNT") );
				boardarticle.setBDA_RECOMMENDCNT( rs.getInt("BDA_RECOMMENDCNT") );
				boardarticle.setBDA_IP( rs.getString("BDA_IP") );
				boardarticle.setBDA_STATUS( rs.getInt("BDA_STATUS") );
				boardarticle.setBDA_SECRETUSE( rs.getString("BDA_SECRETUSE") );
				boardarticle.setBDA_LEVEL( rs.getString("BDA_LEVEL") );
				boardarticle.setBDA_TYPE( rs.getString("BDA_TYPE") );
				boardarticle.setBDA_USE( rs.getString("BDA_USE") );
				boardarticle.setBDA_MOID( rs.getString("BDA_MOID") );
				boardarticle.setBDA_INID( rs.getString("BDA_INID") );
				boardarticle.setBDA_MODATE( rs.getTimestamp("BDA_MODATE") );
				boardarticle.setBDA_INDATE( rs.getTimestamp("BDA_INDATE") );
				boardarticleList.add(boardarticle);
			}
			return boardarticleList;

		}catch(SQLException se){
			System.out.println("Boardarticle list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Boardarticle> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Boardarticle> boardarticleList = new ArrayList<Boardarticle>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from boardarticle";

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

			while( rs.next() ){
				Boardarticle boardarticle = new Boardarticle();

				boardarticle.setBDA_SEQ( rs.getInt("BDA_SEQ") );
				boardarticle.setBDA_BDID( rs.getString("BDA_BDID") );
				boardarticle.setBDA_BDCSEQ( rs.getInt("BDA_BDCSEQ") );
				boardarticle.setBDA_CONTENT( rs.getString("BDA_CONTENT") );
				boardarticle.setBDA_FILENUM( rs.getInt("BDA_FILENUM") );
				boardarticle.setBDA_GROUPNUM( rs.getInt("BDA_GROUPNUM") );
				boardarticle.setBDA_LEVELNUM( rs.getInt("BDA_LEVELNUM") );
				boardarticle.setBDA_STEPNUM( rs.getInt("BDA_STEPNUM") );
				boardarticle.setBDA_MBID( rs.getString("BDA_MBID") );
				boardarticle.setBDA_NAME( rs.getString("BDA_NAME") );
				boardarticle.setBDA_OWNERNAME( rs.getString("BDA_OWNERNAME") );
				boardarticle.setBDA_PSWD( rs.getString("BDA_PSWD") );
				boardarticle.setBDA_READCNT( rs.getInt("BDA_READCNT") );
				boardarticle.setBDA_RECOMMENDCNT( rs.getInt("BDA_RECOMMENDCNT") );
				boardarticle.setBDA_IP( rs.getString("BDA_IP") );
				boardarticle.setBDA_STATUS( rs.getInt("BDA_STATUS") );
				boardarticle.setBDA_SECRETUSE( rs.getString("BDA_SECRETUSE") );
				boardarticle.setBDA_LEVEL( rs.getString("BDA_LEVEL") );
				boardarticle.setBDA_TYPE( rs.getString("BDA_TYPE") );
				boardarticle.setBDA_USE( rs.getString("BDA_USE") );
				boardarticle.setBDA_MOID( rs.getString("BDA_MOID") );
				boardarticle.setBDA_INID( rs.getString("BDA_INID") );
				boardarticle.setBDA_MODATE( rs.getTimestamp("BDA_MODATE") );
				boardarticle.setBDA_INDATE( rs.getTimestamp("BDA_INDATE") );
				boardarticleList.add(boardarticle);
			}
			return boardarticleList;

		}catch(SQLException se){
			System.out.println("Boardarticle list Error : "+se+" \nsql : "+sql );
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

		List<Map<String, Object>> boardarticleList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from boardarticle";

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
				Map<String, Object> boardarticle = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					boardarticle.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				boardarticleList.add(boardarticle);
			}
			return boardarticleList;

		}catch(SQLException se){
			System.out.println("Boardarticle listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Boardarticle boardarticle = ( Boardarticle )sqlMap.get( "boardarticle" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update boardarticle set BDA_BDID=?, BDA_BDCSEQ=?, BDA_CONTENT=?, BDA_FILENUM=?, BDA_GROUPNUM=?, BDA_LEVELNUM=?, BDA_STEPNUM=?, BDA_MBID=?, BDA_NAME=?, BDA_OWNERNAME=?, BDA_PSWD=?, BDA_READCNT=?, BDA_RECOMMENDCNT=?, BDA_IP=?, BDA_STATUS=?, BDA_SECRETUSE=?, BDA_LEVEL=?, BDA_TYPE=?, BDA_USE=?, BDA_MOID=?, BDA_MODATE=sysdate() ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setInt( i++ , boardarticle.getBDA_SEQ() );
			pstmt.setString( i++ , boardarticle.getBDA_BDID() );
			pstmt.setInt( i++ , boardarticle.getBDA_BDCSEQ() );
			pstmt.setString( i++ , boardarticle.getBDA_CONTENT() );
			pstmt.setInt( i++ , boardarticle.getBDA_FILENUM() );
			pstmt.setInt( i++ , boardarticle.getBDA_GROUPNUM() );
			pstmt.setInt( i++ , boardarticle.getBDA_LEVELNUM() );
			pstmt.setInt( i++ , boardarticle.getBDA_STEPNUM() );
			pstmt.setString( i++ , boardarticle.getBDA_MBID() );
			pstmt.setString( i++ , boardarticle.getBDA_NAME() );
			pstmt.setString( i++ , boardarticle.getBDA_OWNERNAME() );
			pstmt.setString( i++ , boardarticle.getBDA_PSWD() );
			pstmt.setInt( i++ , boardarticle.getBDA_READCNT() );
			pstmt.setInt( i++ , boardarticle.getBDA_RECOMMENDCNT() );
			pstmt.setString( i++ , boardarticle.getBDA_IP() );
			pstmt.setInt( i++ , boardarticle.getBDA_STATUS() );
			pstmt.setString( i++ , boardarticle.getBDA_SECRETUSE() );
			pstmt.setString( i++ , boardarticle.getBDA_LEVEL() );
			pstmt.setString( i++ , boardarticle.getBDA_TYPE() );
			pstmt.setString( i++ , boardarticle.getBDA_USE() );
			pstmt.setString( i++ , boardarticle.getBDA_MOID() );
//			pstmt.setString( i++ , boardarticle.getBDA_INID() );
//			pstmt.setTimestamp( i++, boardarticle.getBDA_MODATE() );
//			pstmt.setTimestamp( i++, boardarticle.getBDA_INDATE() );


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
			System.out.println("Boardarticle up Error : "+se+" \nsql : "+sql );
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
			sql = "update boardarticle set ";

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
			System.out.println("Boardarticle upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update boardarticle set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Boardarticle upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from boardarticle";

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
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Boardarticle delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from boardarticle";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Boardarticle delete Error : "+se+" \n sql : "+sql );
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

			if( rs.next() ) result = rs.getInt( 1 );

			return result;

		}catch(SQLException se){
			System.out.println("Boardarticle max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Boardarticle lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

	//---step up할 때 사용. 그러나 upchoice를 사용하면 됨. 그냥 만들어 놨음.
	public int upStep( Boardarticle boardarticle, String whereStr, String orderStr )throws SQLException{
		int result = 0;
		String sql = "";
		
		//--- 부모 step보다 높은 step+1을 시킴.
		sql = " update BOARDARTICLE set BDA_STEPNUM = BDA_STEPNUM+1 ";
		sql += " where BDA_GROUPNUM = ? and BDA_STEPNUM > ? ";
		try{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt( 1, boardarticle.getBDA_GROUPNUM() );
			pstmt.setInt( 2, boardarticle.getBDA_STEPNUM() );
			result = pstmt.executeUpdate();
			return result;
		}catch( SQLException se ){
			System.out.println( "Boardarticle upStep Error : "+se+" /n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
		
}