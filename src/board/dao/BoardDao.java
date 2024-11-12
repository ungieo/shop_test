package board.dao;

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
import board.dto.Board;

public class BoardDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Board board)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into board(BD_ID, BD_NAME, BD_DESCRIPTION, BD_FILEMAXSIZE, BD_IMAGE, BD_IP, BD_FILEUSE, BD_DELUSE, BD_EDITUSE, BD_ADDUSE, BD_COMMENTUSE, BD_SECRETUSE, BD_IPUSE, BD_SELFVIEWUSE, BD_PSWDUSE, BD_REPLYUSE, BD_SORTTYPE, BD_VIEWTYPE, BD_LEVEL, BD_TYPE, BD_USE, BD_MOID, BD_INID, BD_MODATE, BD_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";


			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString( i++, board.getBD_ID() );
			pstmt.setString( i++, board.getBD_NAME() );
			pstmt.setString( i++, board.getBD_DESCRIPTION() );
			pstmt.setInt( i++, board.getBD_FILEMAXSIZE() );
			pstmt.setString( i++, board.getBD_IMAGE() );
			pstmt.setString( i++, board.getBD_IP() );
			pstmt.setString( i++, board.getBD_FILEUSE() );
			pstmt.setString( i++, board.getBD_DELUSE() );
			pstmt.setString( i++, board.getBD_EDITUSE() );
			pstmt.setString( i++, board.getBD_ADDUSE() );
			pstmt.setString( i++, board.getBD_COMMENTUSE() );
			pstmt.setString( i++, board.getBD_SECRETUSE() );
			pstmt.setString( i++, board.getBD_IPUSE() );
			pstmt.setString( i++, board.getBD_SELFVIEWUSE() );			
			pstmt.setString( i++, board.getBD_PSWDUSE() );
			pstmt.setString( i++, board.getBD_REPLYUSE() );
			pstmt.setString( i++, board.getBD_SORTTYPE() );
			pstmt.setString( i++, board.getBD_VIEWTYPE() );
			pstmt.setString( i++, board.getBD_LEVEL() );
			pstmt.setString( i++, board.getBD_TYPE() );
			pstmt.setString( i++, board.getBD_USE() );
			pstmt.setString( i++, board.getBD_MOID() );
			pstmt.setString( i++, board.getBD_INID() );
//			pstmt.setTimestamp( i++, board.getBD_MODATE() );
//			pstmt.setTimestamp( i++, board.getBD_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Board insert Error : "+se+" \nsql : "+sql+" \ndto : "+board.toStr() );
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
			sql = "select count(*) from board";

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
			System.out.println("Board cnt Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Board one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Board board = new Board();
		String sql = "";
		try{
			sql = "select * from board";

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
				board.setBD_ID( rs.getString("BD_ID") );
				board.setBD_NAME( rs.getString("BD_NAME") );
				board.setBD_DESCRIPTION( rs.getString("BD_DESCRIPTION") );
				board.setBD_FILEMAXSIZE( rs.getInt("BD_FILEMAXSIZE") );
				board.setBD_IMAGE( rs.getString("BD_IMAGE") );
				board.setBD_IP( rs.getString("BD_IP") );
				board.setBD_FILEUSE( rs.getString("BD_FILEUSE") );
				board.setBD_DELUSE( rs.getString("BD_DELUSE") );
				board.setBD_EDITUSE( rs.getString("BD_EDITUSE") );
				board.setBD_ADDUSE( rs.getString("BD_ADDUSE") );
				board.setBD_COMMENTUSE( rs.getString("BD_COMMENTUSE") );
				board.setBD_SECRETUSE( rs.getString("BD_SECRETUSE") );
				board.setBD_IPUSE( rs.getString("BD_IPUSE") );
				board.setBD_SELFVIEWUSE( rs.getString("BD_SELFVIEWUSE") );				
				board.setBD_PSWDUSE( rs.getString("BD_PSWDUSE") );
				board.setBD_REPLYUSE( rs.getString("BD_REPLYUSE") );
				board.setBD_SORTTYPE( rs.getString("BD_SORTTYPE") );
				board.setBD_VIEWTYPE( rs.getString("BD_VIEWTYPE") );
				board.setBD_LEVEL( rs.getString("BD_LEVEL") );
				board.setBD_TYPE( rs.getString("BD_TYPE") );
				board.setBD_USE( rs.getString("BD_USE") );
				board.setBD_MOID( rs.getString("BD_MOID") );
				board.setBD_INID( rs.getString("BD_INID") );
				board.setBD_MODATE( rs.getTimestamp("BD_MODATE") );
				board.setBD_INDATE( rs.getTimestamp("BD_INDATE") );
			}
			return board;

		}catch(SQLException se){
			System.out.println("Board one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Board> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Board> boardList = new ArrayList<Board>();
		String sql = "";
		try{
			sql += "select * from board";

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
				Board board = new Board();

				board.setBD_ID( rs.getString("BD_ID") );
				board.setBD_NAME( rs.getString("BD_NAME") );
				board.setBD_DESCRIPTION( rs.getString("BD_DESCRIPTION") );
				board.setBD_FILEMAXSIZE( rs.getInt("BD_FILEMAXSIZE") );
				board.setBD_IMAGE( rs.getString("BD_IMAGE") );
				board.setBD_IP( rs.getString("BD_IP") );
				board.setBD_FILEUSE( rs.getString("BD_FILEUSE") );
				board.setBD_DELUSE( rs.getString("BD_DELUSE") );
				board.setBD_EDITUSE( rs.getString("BD_EDITUSE") );
				board.setBD_ADDUSE( rs.getString("BD_ADDUSE") );
				board.setBD_COMMENTUSE( rs.getString("BD_COMMENTUSE") );
				board.setBD_SECRETUSE( rs.getString("BD_SECRETUSE") );
				board.setBD_IPUSE( rs.getString("BD_IPUSE") );
				board.setBD_SELFVIEWUSE( rs.getString("BD_SELFVIEWUSE") );				
				board.setBD_PSWDUSE( rs.getString("BD_PSWDUSE") );
				board.setBD_REPLYUSE( rs.getString("BD_REPLYUSE") );
				board.setBD_SORTTYPE( rs.getString("BD_SORTTYPE") );
				board.setBD_VIEWTYPE( rs.getString("BD_VIEWTYPE") );
				board.setBD_LEVEL( rs.getString("BD_LEVEL") );
				board.setBD_TYPE( rs.getString("BD_TYPE") );
				board.setBD_USE( rs.getString("BD_USE") );
				board.setBD_MOID( rs.getString("BD_MOID") );
				board.setBD_INID( rs.getString("BD_INID") );
				board.setBD_MODATE( rs.getTimestamp("BD_MODATE") );
				board.setBD_INDATE( rs.getTimestamp("BD_INDATE") );
				boardList.add(board);
			}
			return boardList;

		}catch(SQLException se){
			System.out.println("Board list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Board> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Board> boardList = new ArrayList<Board>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from board";

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
				Board board = new Board();

				board.setBD_ID( rs.getString("BD_ID") );
				board.setBD_NAME( rs.getString("BD_NAME") );
				board.setBD_DESCRIPTION( rs.getString("BD_DESCRIPTION") );
				board.setBD_FILEMAXSIZE( rs.getInt("BD_FILEMAXSIZE") );
				board.setBD_IMAGE( rs.getString("BD_IMAGE") );
				board.setBD_IP( rs.getString("BD_IP") );
				board.setBD_FILEUSE( rs.getString("BD_FILEUSE") );
				board.setBD_DELUSE( rs.getString("BD_DELUSE") );
				board.setBD_EDITUSE( rs.getString("BD_EDITUSE") );
				board.setBD_ADDUSE( rs.getString("BD_ADDUSE") );
				board.setBD_COMMENTUSE( rs.getString("BD_COMMENTUSE") );
				board.setBD_SECRETUSE( rs.getString("BD_SECRETUSE") );
				board.setBD_IPUSE( rs.getString("BD_IPUSE") );
				board.setBD_SELFVIEWUSE( rs.getString("BD_SELFVIEWUSE") );				
				board.setBD_PSWDUSE( rs.getString("BD_PSWDUSE") );
				board.setBD_REPLYUSE( rs.getString("BD_REPLYUSE") );
				board.setBD_SORTTYPE( rs.getString("BD_SORTTYPE") );
				board.setBD_VIEWTYPE( rs.getString("BD_VIEWTYPE") );
				board.setBD_LEVEL( rs.getString("BD_LEVEL") );
				board.setBD_TYPE( rs.getString("BD_TYPE") );
				board.setBD_USE( rs.getString("BD_USE") );
				board.setBD_MOID( rs.getString("BD_MOID") );
				board.setBD_INID( rs.getString("BD_INID") );
				board.setBD_MODATE( rs.getTimestamp("BD_MODATE") );
				board.setBD_INDATE( rs.getTimestamp("BD_INDATE") );
				boardList.add(board);
			}
			return boardList;

		}catch(SQLException se){
			System.out.println("Board list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Board board = ( Board )sqlMap.get( "board" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update board set BD_NAME=?, BD_DESCRIPTION=?, BD_FILEMAXSIZE=?, BD_IMAGE=?, BD_IP=?, BD_FILEUSE=?, BD_ADDUSE=?, BD_DELUSE=?, BD_EDITUSE=?, BD_COMMENTUSE=?, BD_SECRETUSE=?, BD_IPUSE=?, BD_SELFVIEWUSE=?, BD_PSWDUSE=?, BD_REPLYUSE=?, BD_SORTTYPE=?, BD_VIEWTYPE=?, BD_LEVEL=?, BD_TYPE=?, BD_USE=?, BD_MOID=?, BD_MODATE=sysdate() ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setString( i++ , board.getBD_ID() );
			pstmt.setString( i++ , board.getBD_NAME() );
			pstmt.setString( i++ , board.getBD_DESCRIPTION() );
			pstmt.setInt( i++ , board.getBD_FILEMAXSIZE() );
			pstmt.setString( i++ , board.getBD_IMAGE() );
			pstmt.setString( i++ , board.getBD_IP() );
			pstmt.setString( i++ , board.getBD_FILEUSE() );
			pstmt.setString( i++ , board.getBD_DELUSE() );
			pstmt.setString( i++ , board.getBD_EDITUSE() );
			pstmt.setString( i++ , board.getBD_ADDUSE() );
			pstmt.setString( i++ , board.getBD_COMMENTUSE() );
			pstmt.setString( i++ , board.getBD_SECRETUSE() );
			pstmt.setString( i++ , board.getBD_IPUSE() );
			pstmt.setString( i++ , board.getBD_SELFVIEWUSE() );
			pstmt.setString( i++ , board.getBD_PSWDUSE() );
			pstmt.setString( i++ , board.getBD_REPLYUSE() );
			pstmt.setString( i++ , board.getBD_SORTTYPE() );
			pstmt.setString( i++ , board.getBD_VIEWTYPE() );
			pstmt.setString( i++ , board.getBD_LEVEL() );
			pstmt.setString( i++ , board.getBD_TYPE() );
			pstmt.setString( i++ , board.getBD_USE() );
			pstmt.setString( i++ , board.getBD_MOID() );
//			pstmt.setString( i++ , board.getBD_INID() );
//			pstmt.setTimestamp( i++, board.getBD_MODATE() );
//			pstmt.setTimestamp( i++, board.getBD_INDATE() );


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
			System.out.println("Board up Error : "+se+" \nsql : "+sql );
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
			sql = "update board set ";

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

			if( !colValList.isEmpty() ){
				int index = 1;
				for( int i = 0, n = colValList.size(); i < n; i++ ){
					Object obj = colValList.get(i);
					String colType = colTypeList.get(i);
					if( "int".equals( colType ) ) pstmt.setInt( index++, Cvt.toInt( obj ) );
					if( "String".equals( colType ) ) pstmt.setString( index++, Cvt.toStr( obj ) );
					if( "long".equals( colType ) ) pstmt.setLong( index++, Cvt.toLong( obj ) );
				}
			}
			if( !wColValList.isEmpty() ){
				int index = 1;
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
			System.out.println("Board upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update board set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Board upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from board";

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
			System.out.println("Board delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from board";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Board delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Board max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Board lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

	
	//listChoice
	public List<Map<String, Object>> listChoice( Map<String, Object> sqlMap )throws SQLException{
		
		List<String> colNameList = (List<String>)sqlMap.get( "colNameList" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName; 
				}
			}
			sql += " from board";
			

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
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			
			while( rs.next() ){
				Map<String, Object> board = new HashMap<String, Object>();
				
				for( int i = 1; i <= colCnt; i++ ){
					board.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}

				boardList.add(board);
			}
			return boardList;

		}catch(SQLException se){
			System.out.println("Board list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	
	
}