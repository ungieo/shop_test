package company.dao;

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
import company.dto.Company;

public class CompanyDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public CompanyDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Company company)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into company(CP_SEQ, CP_ID, CP_NAME, CP_BIZNUM, CP_UPTAI, CP_UPJONG, CP_CEONAME, CP_ZIPCODE, CP_ADDR1, CP_ADDR2, CP_FILE, CP_DELIVERYMONEY, CP_PAYTYPE, CP_BIZTYPE, CP_TONGSINBIZNUM, CP_EMAIL, CP_TEL, CP_PHONE, CP_FAX, CP_LEVEL, CP_TYPE, CP_USE, CP_MOID, CP_INID, CP_MODATE, CP_INDATE)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setInt( i++, company.getCP_SEQ() );
			pstmt.setString( i++, company.getCP_ID() );
			pstmt.setString( i++, company.getCP_NAME() );
			pstmt.setString( i++, company.getCP_BIZNUM() );
			pstmt.setString( i++, company.getCP_UPTAI() );
			pstmt.setString( i++, company.getCP_UPJONG() );
			pstmt.setString( i++, company.getCP_CEONAME() );
			pstmt.setString( i++, company.getCP_ZIPCODE() );
			pstmt.setString( i++, company.getCP_ADDR1() );
			pstmt.setString( i++, company.getCP_ADDR2() );
			pstmt.setString( i++, company.getCP_FILE() );
			pstmt.setInt( i++, company.getCP_DELIVERYMONEY() );
			pstmt.setString( i++, company.getCP_PAYTYPE() );
			pstmt.setString( i++, company.getCP_BIZTYPE() );
			pstmt.setString( i++, company.getCP_TONGSINBIZNUM() );
			pstmt.setString( i++, company.getCP_EMAIL() );
			pstmt.setString( i++, company.getCP_TEL() );
			pstmt.setString( i++, company.getCP_PHONE() );
			pstmt.setString( i++, company.getCP_FAX() );
			pstmt.setString( i++, company.getCP_LEVEL() );
			pstmt.setString( i++, company.getCP_TYPE() );
			pstmt.setString( i++, company.getCP_USE() );
			pstmt.setString( i++, company.getCP_MOID() );
			pstmt.setString( i++, company.getCP_INID() );
//			pstmt.setTimestamp( i++, company.getCP_MODATE() );
//			pstmt.setTimestamp( i++, company.getCP_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Company insert Error : "+se+" \nsql : "+sql+" \ndto : "+company.toStr() );
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
			sql = "select count(*) from company";

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
			System.out.println("Company cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from company";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Company cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Company one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Company company = new Company();
		String sql = "";
		try{
			sql = "select * from company";

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
				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
			}
			return company;

		}catch(SQLException se){
			System.out.println("Company one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Company one(String whereStr, String orderStr)throws SQLException{

		Company company = new Company();
		String sql = "";
		try{
			sql = "select * from company";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
			}
			return company;

		}catch(SQLException se){
			System.out.println("Company one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Company> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Company> companyList = new ArrayList<Company>();
		String sql = "";
		try{
			sql += "select * from company";

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
				Company company = new Company();

				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
				companyList.add(company);
			}
			return companyList;

		}catch(SQLException se){
			System.out.println("Company list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Company> list( String whereStr, String orderStr )throws SQLException{

		List<Company> companyList = new ArrayList<Company>();
		String sql = "";
		try{
			sql += "select * from company";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Company company = new Company();

				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
				companyList.add(company);
			}
			return companyList;

		}catch(SQLException se){
			System.out.println("Company list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Company> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Company> companyList = new ArrayList<Company>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from company";

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
				Company company = new Company();

				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
				companyList.add(company);
			}
			return companyList;

		}catch(SQLException se){
			System.out.println("Company list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Company> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Company> companyList = new ArrayList<Company>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from company";

			sql += "select * from company";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Company company = new Company();

				company.setCP_SEQ( rs.getInt("CP_SEQ") );
				company.setCP_ID( rs.getString("CP_ID") );
				company.setCP_NAME( rs.getString("CP_NAME") );
				company.setCP_BIZNUM( rs.getString("CP_BIZNUM") );
				company.setCP_UPTAI( rs.getString("CP_UPTAI") );
				company.setCP_UPJONG( rs.getString("CP_UPJONG") );
				company.setCP_CEONAME( rs.getString("CP_CEONAME") );
				company.setCP_ZIPCODE( rs.getString("CP_ZIPCODE") );
				company.setCP_ADDR1( rs.getString("CP_ADDR1") );
				company.setCP_ADDR2( rs.getString("CP_ADDR2") );
				company.setCP_FILE( rs.getString("CP_FILE") );
				company.setCP_DELIVERYMONEY( rs.getInt("CP_DELIVERYMONEY") );
				company.setCP_PAYTYPE( rs.getString("CP_PAYTYPE") );
				company.setCP_BIZTYPE( rs.getString("CP_BIZTYPE") );
				company.setCP_TONGSINBIZNUM( rs.getString("CP_TONGSINBIZNUM") );
				company.setCP_EMAIL( rs.getString("CP_EMAIL") );
				company.setCP_TEL( rs.getString("CP_TEL") );
				company.setCP_PHONE( rs.getString("CP_PHONE") );
				company.setCP_FAX( rs.getString("CP_FAX") );
				company.setCP_LEVEL( rs.getString("CP_LEVEL") );
				company.setCP_TYPE( rs.getString("CP_TYPE") );
				company.setCP_USE( rs.getString("CP_USE") );
				company.setCP_MOID( rs.getString("CP_MOID") );
				company.setCP_INID( rs.getString("CP_INID") );
				company.setCP_MODATE( rs.getTimestamp("CP_MODATE") );
				company.setCP_INDATE( rs.getTimestamp("CP_INDATE") );
				companyList.add(company);
			}
			return companyList;

		}catch(SQLException se){
			System.out.println("Company list Error : "+se+" \n sql : "+sql );
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

		List<Map<String, Object>> companyList = new ArrayList<Map<String, Object>>();
		String sql = "";
		try{
			sql += "select ";
			if( !colNameList.isEmpty() ){
				for( String colName : colNameList ){
					sql += colName;
				}
			}
			sql += " from company";

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
				Map<String, Object> company = new HashMap<String, Object>();
				for( int i = 1; i <= colCnt; i++ ){
					company.put( rsmd.getColumnName(i).toUpperCase(), rs.getObject(i) );
				}
				companyList.add(company);
			}
			return companyList;

		}catch(SQLException se){
			System.out.println("Company listChoice Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	
	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Company company = ( Company )sqlMap.get( "company" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update company set CP_NAME=?, CP_BIZNUM=?, CP_UPTAI=?, CP_UPJONG=?, CP_CEONAME=?, CP_ZIPCODE=?, CP_ADDR1=?, CP_ADDR2=?, CP_FILE=?, CP_DELIVERYMONEY=?, CP_PAYTYPE=?, CP_BIZTYPE=?, CP_TONGSINBIZNUM=?, CP_EMAIL=?, CP_TEL=?, CP_PHONE=?, CP_FAX=?, CP_LEVEL=?, CP_TYPE=?, CP_USE=?, CP_MOID=?, CP_MODATE=sysdate() ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setInt( i++ , company.getCP_SEQ() );
//			pstmt.setString( i++ , company.getCP_ID() );
			pstmt.setString( i++ , company.getCP_NAME() );
			pstmt.setString( i++ , company.getCP_BIZNUM() );
			pstmt.setString( i++ , company.getCP_UPTAI() );
			pstmt.setString( i++ , company.getCP_UPJONG() );
			pstmt.setString( i++ , company.getCP_CEONAME() );
			pstmt.setString( i++ , company.getCP_ZIPCODE() );
			pstmt.setString( i++ , company.getCP_ADDR1() );
			pstmt.setString( i++ , company.getCP_ADDR2() );
			pstmt.setString( i++ , company.getCP_FILE() );
			pstmt.setInt( i++ , company.getCP_DELIVERYMONEY() );
			pstmt.setString( i++ , company.getCP_PAYTYPE() );
			pstmt.setString( i++ , company.getCP_BIZTYPE() );
			pstmt.setString( i++ , company.getCP_TONGSINBIZNUM() );
			pstmt.setString( i++ , company.getCP_EMAIL() );
			pstmt.setString( i++ , company.getCP_TEL() );
			pstmt.setString( i++ , company.getCP_PHONE() );
			pstmt.setString( i++ , company.getCP_FAX() );
			pstmt.setString( i++ , company.getCP_LEVEL() );
			pstmt.setString( i++ , company.getCP_TYPE() );
			pstmt.setString( i++ , company.getCP_USE() );
			pstmt.setString( i++ , company.getCP_MOID() );
//			pstmt.setString( i++ , company.getCP_INID() );
//			pstmt.setTimestamp( i++, company.getCP_MODATE() );
//			pstmt.setTimestamp( i++, company.getCP_INDATE() );


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
			System.out.println("Company up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Company company, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update company set CP_NAME=?, CP_BIZNUM=?, CP_UPTAI=?, CP_UPJONG=?, CP_CEONAME=?, CP_ZIPCODE=?, CP_ADDR1=?, CP_ADDR2=?, CP_FILE=?, CP_DELIVERYMONEY=?, CP_PAYTYPE=?, CP_BIZTYPE=?, CP_TONGSINBIZNUM=?, CP_EMAIL=?, CP_TEL=?, CP_PHONE=?, CP_FAX=?, CP_LEVEL=?, CP_TYPE=?, CP_USE=?, CP_MOID=?, CP_MODATE=sysdate() ";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

//			pstmt.setInt( i++ , company.getCP_SEQ() );
//			pstmt.setString( i++ , company.getCP_ID() );
			pstmt.setString( i++ , company.getCP_NAME() );
			pstmt.setString( i++ , company.getCP_BIZNUM() );
			pstmt.setString( i++ , company.getCP_UPTAI() );
			pstmt.setString( i++ , company.getCP_UPJONG() );
			pstmt.setString( i++ , company.getCP_CEONAME() );
			pstmt.setString( i++ , company.getCP_ZIPCODE() );
			pstmt.setString( i++ , company.getCP_ADDR1() );
			pstmt.setString( i++ , company.getCP_ADDR2() );
			pstmt.setString( i++ , company.getCP_FILE() );
			pstmt.setInt( i++ , company.getCP_DELIVERYMONEY() );
			pstmt.setString( i++ , company.getCP_PAYTYPE() );
			pstmt.setString( i++ , company.getCP_BIZTYPE() );
			pstmt.setString( i++ , company.getCP_TONGSINBIZNUM() );
			pstmt.setString( i++ , company.getCP_EMAIL() );
			pstmt.setString( i++ , company.getCP_TEL() );
			pstmt.setString( i++ , company.getCP_PHONE() );
			pstmt.setString( i++ , company.getCP_FAX() );
			pstmt.setString( i++ , company.getCP_LEVEL() );
			pstmt.setString( i++ , company.getCP_TYPE() );
			pstmt.setString( i++ , company.getCP_USE() );
			pstmt.setString( i++ , company.getCP_MOID() );
//			pstmt.setString( i++ , company.getCP_INID() );
//			pstmt.setTimestamp( i++, company.getCP_MODATE() );
//			pstmt.setTimestamp( i++, company.getCP_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Company up Error : "+se+" \n sql : "+sql );
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
			sql = "update company set ";

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
			System.out.println("Company upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update company set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Company upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from company";

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
			System.out.println("Company delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from company";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Company delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Company max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Company max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Company lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

}