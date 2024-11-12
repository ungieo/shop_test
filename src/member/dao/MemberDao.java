package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
import java.util.Map;

import system.db.util.DbUtil;
import system.util.Cvt;
import member.dto.Member;

public class MemberDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MemberDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Member member)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into member(MB_ID, MB_NAME, MB_PSWD, MB_PSWDCHDATE, MB_PSWDFAILCNT, MB_CPID, MB_DPID, MB_ZIPCODE, MB_ADDR1, MB_ADDR2, MB_EMAIL, MB_PHONE, MB_TEL, MB_BIRTH, MB_SEX, MB_EMAILUSE, MB_SMSUSE, MB_LEVEL, MB_TYPE, MB_USE, MB_MOID, MB_INID, MB_MODATE, MB_INDATE)";
			sql += "values(?, ?, ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString( i++, member.getMB_ID() );
			pstmt.setString( i++, member.getMB_NAME() );
			pstmt.setString( i++, member.getMB_PSWD() );
//			pstmt.setTimestamp( i++, member.getMB_PSWDCHDATE() );
			pstmt.setInt( i++, member.getMB_PSWDFAILCNT() );
			pstmt.setString( i++, member.getMB_CPID() );
			pstmt.setString( i++, member.getMB_DPID() );
			pstmt.setString( i++, member.getMB_ZIPCODE() );
			pstmt.setString( i++, member.getMB_ADDR1() );
			pstmt.setString( i++, member.getMB_ADDR2() );
			pstmt.setString( i++, member.getMB_EMAIL() );
			pstmt.setString( i++, member.getMB_PHONE() );
			pstmt.setString( i++, member.getMB_TEL() );
			pstmt.setString( i++, member.getMB_BIRTH() );
			pstmt.setString( i++, member.getMB_SEX() );
			pstmt.setString( i++, member.getMB_EMAILUSE() );
			pstmt.setString( i++, member.getMB_SMSUSE() );
			pstmt.setString( i++, member.getMB_LEVEL() );
			pstmt.setString( i++, member.getMB_TYPE() );
			pstmt.setString( i++, member.getMB_USE() );
			pstmt.setString( i++, member.getMB_MOID() );
			pstmt.setString( i++, member.getMB_INID() );
//			pstmt.setTimestamp( i++, member.getMB_MODATE() );
//			pstmt.setTimestamp( i++, member.getMB_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Member insert Error : "+se+" \nsql : "+sql+" \ndto : "+member.toStr() );
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
			sql = "select count(*) from member";

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
			System.out.println("Member cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from member";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Member cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Member one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Member member = new Member();
		String sql = "";
		try{
			sql = "select * from member";

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
				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
			}
			return member;

		}catch(SQLException se){
			System.out.println("Member one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Member one(String whereStr, String orderStr)throws SQLException{

		Member member = new Member();
		String sql = "";
		try{
			sql = "select * from member";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
			}
			return member;

		}catch(SQLException se){
			System.out.println("Member one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Member> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Member> memberList = new ArrayList<Member>();
		String sql = "";
		try{
			sql += "select * from member";

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
				Member member = new Member();

				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
				memberList.add(member);
			}
			return memberList;

		}catch(SQLException se){
			System.out.println("Member list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Member> list( String whereStr, String orderStr )throws SQLException{

		List<Member> memberList = new ArrayList<Member>();
		String sql = "";
		try{
			sql += "select * from member";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Member member = new Member();

				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
				memberList.add(member);
			}
			return memberList;

		}catch(SQLException se){
			System.out.println("Member list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Member> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Member> memberList = new ArrayList<Member>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from member";

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
				Member member = new Member();

				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
				memberList.add(member);
			}
			return memberList;

		}catch(SQLException se){
			System.out.println("Member list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Member> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Member> memberList = new ArrayList<Member>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from member";

			sql += "select * from member";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Member member = new Member();

				member.setMB_ID( rs.getString("MB_ID") );
				member.setMB_NAME( rs.getString("MB_NAME") );
				member.setMB_PSWD( rs.getString("MB_PSWD") );
				member.setMB_PSWDCHDATE( rs.getTimestamp("MB_PSWDCHDATE") );
				member.setMB_PSWDFAILCNT( rs.getInt("MB_PSWDFAILCNT") );
				member.setMB_CPID( rs.getString("MB_CPID") );
				member.setMB_DPID( rs.getString("MB_DPID") );
				member.setMB_ZIPCODE( rs.getString("MB_ZIPCODE") );
				member.setMB_ADDR1( rs.getString("MB_ADDR1") );
				member.setMB_ADDR2( rs.getString("MB_ADDR2") );
				member.setMB_EMAIL( rs.getString("MB_EMAIL") );
				member.setMB_PHONE( rs.getString("MB_PHONE") );
				member.setMB_TEL( rs.getString("MB_TEL") );
				member.setMB_BIRTH( rs.getString("MB_BIRTH") );
				member.setMB_SEX( rs.getString("MB_SEX") );
				member.setMB_EMAILUSE( rs.getString("MB_EMAILUSE") );
				member.setMB_SMSUSE( rs.getString("MB_SMSUSE") );
				member.setMB_LEVEL( rs.getString("MB_LEVEL") );
				member.setMB_TYPE( rs.getString("MB_TYPE") );
				member.setMB_USE( rs.getString("MB_USE") );
				member.setMB_MOID( rs.getString("MB_MOID") );
				member.setMB_INID( rs.getString("MB_INID") );
				member.setMB_MODATE( rs.getTimestamp("MB_MODATE") );
				member.setMB_INDATE( rs.getTimestamp("MB_INDATE") );
				memberList.add(member);
			}
			return memberList;

		}catch(SQLException se){
			System.out.println("Member list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Member member = ( Member )sqlMap.get( "member" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update member set MB_NAME=?, MB_PSWD=?, MB_PSWDFAILCNT=?, MB_CPID=?, MB_DPID=?, MB_ZIPCODE=?, MB_ADDR1=?, MB_ADDR2=?, MB_EMAIL=?, MB_PHONE=?, MB_TEL=?, MB_BIRTH=?, MB_SEX=?, MB_EMAILUSE=?, MB_SMSUSE=?, MB_LEVEL=?, MB_TYPE=?, MB_USE=?, MB_MOID=?, MB_INID=?, MB_MODATE=sysdate() ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setString( i++ , member.getMB_ID() );
			pstmt.setString( i++ , member.getMB_NAME() );
			pstmt.setString( i++ , member.getMB_PSWD() );
//			pstmt.setTimestamp( i++, member.getMB_PSWDCHDATE() );
			pstmt.setInt( i++ , member.getMB_PSWDFAILCNT() );
			pstmt.setString( i++ , member.getMB_CPID() );
			pstmt.setString( i++ , member.getMB_DPID() );
			pstmt.setString( i++ , member.getMB_ZIPCODE() );
			pstmt.setString( i++ , member.getMB_ADDR1() );
			pstmt.setString( i++ , member.getMB_ADDR2() );
			pstmt.setString( i++ , member.getMB_EMAIL() );
			pstmt.setString( i++ , member.getMB_PHONE() );
			pstmt.setString( i++ , member.getMB_TEL() );
			pstmt.setString( i++ , member.getMB_BIRTH() );
			pstmt.setString( i++ , member.getMB_SEX() );
			pstmt.setString( i++ , member.getMB_EMAILUSE() );
			pstmt.setString( i++ , member.getMB_SMSUSE() );
			pstmt.setString( i++ , member.getMB_LEVEL() );
			pstmt.setString( i++ , member.getMB_TYPE() );
			pstmt.setString( i++ , member.getMB_USE() );
			pstmt.setString( i++ , member.getMB_MOID() );
			pstmt.setString( i++ , member.getMB_INID() );
//			pstmt.setTimestamp( i++, member.getMB_MODATE() );
//			pstmt.setTimestamp( i++, member.getMB_INDATE() );


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
			System.out.println("Member up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Member member, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update member set MB_ID=?, MB_NAME=?, MB_PSWD=?, MB_PSWDCHDATE=sysdate(), MB_PSWDFAILCNT=?, MB_CPID=?, MB_DPID=?, MB_ZIPCODE=?, MB_ADDR1=?, MB_ADDR2=?, MB_EMAIL=?, MB_PHONE=?, MB_TEL=?, MB_BIRTH=?, MB_SEX=?, MB_EMAILUSE=?, MB_SMSUSE=?, MB_LEVEL=?, MB_TYPE=?, MB_USE=?, MB_MOID=?, MB_INID=?, MB_MODATE=sysdate(), MB_INDATE=sysdate()";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

			pstmt.setString( i++ , member.getMB_ID() );
			pstmt.setString( i++ , member.getMB_NAME() );
			pstmt.setString( i++ , member.getMB_PSWD() );
//			pstmt.setTimestamp( i++, member.getMB_PSWDCHDATE() );
			pstmt.setInt( i++ , member.getMB_PSWDFAILCNT() );
			pstmt.setString( i++ , member.getMB_CPID() );
			pstmt.setString( i++ , member.getMB_DPID() );
			pstmt.setString( i++ , member.getMB_ZIPCODE() );
			pstmt.setString( i++ , member.getMB_ADDR1() );
			pstmt.setString( i++ , member.getMB_ADDR2() );
			pstmt.setString( i++ , member.getMB_EMAIL() );
			pstmt.setString( i++ , member.getMB_PHONE() );
			pstmt.setString( i++ , member.getMB_TEL() );
			pstmt.setString( i++ , member.getMB_BIRTH() );
			pstmt.setString( i++ , member.getMB_SEX() );
			pstmt.setString( i++ , member.getMB_EMAILUSE() );
			pstmt.setString( i++ , member.getMB_SMSUSE() );
			pstmt.setString( i++ , member.getMB_LEVEL() );
			pstmt.setString( i++ , member.getMB_TYPE() );
			pstmt.setString( i++ , member.getMB_USE() );
			pstmt.setString( i++ , member.getMB_MOID() );
			pstmt.setString( i++ , member.getMB_INID() );
//			pstmt.setTimestamp( i++, member.getMB_MODATE() );
//			pstmt.setTimestamp( i++, member.getMB_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Member up Error : "+se+" \n sql : "+sql );
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
			sql = "update member set ";

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
			System.out.println("Member upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update member set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Member upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from member";

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
			System.out.println("Member delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from member";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Member delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Member max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Member max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Member lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}