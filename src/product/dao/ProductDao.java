package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.HashMap;
import java.util.Map;

import product.dto.Product;
import productcategory.dto.Productcategory;
import system.db.util.DbUtil;
import system.util.Cvt;

public class ProductDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ProductDao(Connection conn){ this.conn = conn; }

	//insert
	public int in(Product product)throws SQLException{

		int result = 0;
		String sql = "";
		try{

			sql = "insert into product( PR_PRCSEQ, PR_CODE, PR_CODEB, PR_CODES, PR_NAME, PR_PRICE, PR_FILENUM, PR_IMAGE1, PR_IMAGE2, PR_IMAGE3, PR_IMAGE4, PR_CPIDS, PR_CPIDB, PR_BARCODE, PR_VATUSE, PR_SAVEMONEY, PR_STANDARD, PR_BRSEQ, PR_MODEL, PR_UNIT, PR_MANUFACTURE, PR_COUNTRY, PR_MINBUYEA, PR_STOCK, PR_WEIGHT, PR_CONTENT, PR_DELITERM, PR_DELIPOLICY, PR_STATUS, PR_LEVEL, PR_TYPE, PR_USE, PR_MOID, PR_INID, PR_MODATE, PR_INDATE)";
			sql += "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(), sysdate())";

			pstmt = conn.prepareStatement(sql);
			int i = 1;

//			pstmt.setInt( i++, product.getPR_SEQ() );
			pstmt.setInt( i++, product.getPR_PRCSEQ() );
			pstmt.setString( i++, product.getPR_CODE() );
			pstmt.setString( i++, product.getPR_CODEB() );
			pstmt.setString( i++, product.getPR_CODES() );
			pstmt.setString( i++, product.getPR_NAME() );
			pstmt.setInt( i++, product.getPR_PRICE() );
			pstmt.setInt( i++, product.getPR_FILENUM() );
			pstmt.setString( i++, product.getPR_IMAGE1() );
			pstmt.setString( i++, product.getPR_IMAGE2() );
			pstmt.setString( i++, product.getPR_IMAGE3() );
			pstmt.setString( i++, product.getPR_IMAGE4() );
			pstmt.setString( i++, product.getPR_CPIDS() );
			pstmt.setString( i++, product.getPR_CPIDB() );
			pstmt.setString( i++, product.getPR_BARCODE() );
			pstmt.setString( i++, product.getPR_VATUSE() );
			pstmt.setInt( i++, product.getPR_SAVEMONEY() );
			pstmt.setString( i++, product.getPR_STANDARD() );
			pstmt.setInt( i++, product.getPR_BRSEQ() );
			pstmt.setString( i++, product.getPR_MODEL() );
			pstmt.setString( i++, product.getPR_UNIT() );
			pstmt.setString( i++, product.getPR_MANUFACTURE() );
			pstmt.setString( i++, product.getPR_COUNTRY() );
			pstmt.setInt( i++, product.getPR_MINBUYEA() );
			pstmt.setInt( i++, product.getPR_STOCK() );
			pstmt.setString( i++, product.getPR_WEIGHT() );
			pstmt.setString( i++, product.getPR_CONTENT() );
			pstmt.setString( i++, product.getPR_DELITERM() );
			pstmt.setString( i++, product.getPR_DELIPOLICY() );
			pstmt.setString( i++, product.getPR_STATUS() );
			pstmt.setString( i++, product.getPR_LEVEL() );
			pstmt.setString( i++, product.getPR_TYPE() );
			pstmt.setString( i++, product.getPR_USE() );
			pstmt.setString( i++, product.getPR_MOID() );
			pstmt.setString( i++, product.getPR_INID() );
//			pstmt.setTimestamp( i++, product.getPR_MODATE() );
//			pstmt.setTimestamp( i++, product.getPR_INDATE() );

			result = pstmt.executeUpdate();
			return result;

		}catch(SQLException se){
			System.out.println("Product insert Error : "+se+" \nsql : "+sql+" \ndto : "+product.toStr() );
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
			sql = "select count(*) from product";

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
			System.out.println("Product cnt Error : "+se+" \nsql : "+sql );
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
			sql = "select count(*) from product";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				result = rs.getInt(1);
			}
			return result;

		}catch(SQLException se){
			System.out.println("Product cnt Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Product one( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Product product = new Product();
		String sql = "";
		try{
			sql = "select * from product";

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
				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );				
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
			}
			return product;

		}catch(SQLException se){
			System.out.println("Product one Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//one
	public Product one(String whereStr, String orderStr)throws SQLException{

		Product product = new Product();
		String sql = "";
		try{
			sql = "select * from product";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if( rs.next() ){
				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );				
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
			}
			return product;

		}catch(SQLException se){
			System.out.println("Product one Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Product> list( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Product> productList = new ArrayList<Product>();
		String sql = "";
		try{
			sql += "select * from product";

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
				Product product = new Product();

				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);
			}
			return productList;

		}catch(SQLException se){
			System.out.println("Product list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//list
	public List<Product> list( String whereStr, String orderStr )throws SQLException{

		List<Product> productList = new ArrayList<Product>();
		String sql = "";
		try{
			sql += "select * from product";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Product product = new Product();

				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);
			}
			return productList;

		}catch(SQLException se){
			System.out.println("Product list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Product> list( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		List<Product> productList = new ArrayList<Product>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from product";

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
				Product product = new Product();

				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);
			}
			return productList;

		}catch(SQLException se){
			System.out.println("Product list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//listPage
	public List<Product> list( int r_curpage, int r_rowlimit, String whereStr, String orderStr )throws SQLException{

		List<Product> productList = new ArrayList<Product>();
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from product";

			sql += "select * from product";
			if( whereStr.length() > 0 ) sql += " where 1=1 " + whereStr;
			if( orderStr.length() > 0 ) sql += " order by " + orderStr;
			if( r_curpage > 0 )
			sql += " limit "+ startrow +", "+ r_rowlimit;

  			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while( rs.next() ){
				Product product = new Product();

				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);
			}
			return productList;

		}catch(SQLException se){
			System.out.println("Product list Error : "+se+" \n sql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up( Map<String, Object> sqlMap )throws SQLException{

		Product product = ( Product )sqlMap.get( "product" );
		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql = "update product set PR_PRCSEQ=?, PR_CODE=?, PR_CODEB=?, PR_CODES=?, PR_NAME=?, PR_PRICE=?, PR_FILENUM=?, PR_IMAGE1=?, PR_IMAGE2=?, PR_IMAGE3=?, PR_IMAGE4=?, PR_CPIDS=?, PR_CPIDB=?, PR_BARCODE=?, PR_VATUSE=?, PR_SAVEMONEY=?, PR_STANDARD=?, PR_BRSEQ=?, PR_MODEL=?, PR_UNIT=?, PR_MANUFACTURE=?, PR_COUNTRY=?, PR_MINBUYEA=?, PR_STOCK=?, PR_WEIGHT=?, PR_CONTENT=?, PR_DELITERM=?, PR_DELIPOLICY=?, PR_STATUS=?, PR_LEVEL=?, PR_TYPE=?, PR_USE=?, PR_MOID=? ";
			if( !wColNameList.isEmpty() ){
				sql += " where 1=1 ";
				for( String wColName : wColNameList ){
					sql += wColName;
				}
			}

			if( !orderStr.isEmpty() ) sql += " order by " + orderStr;
			pstmt = conn.prepareStatement( sql );

			int i = 1;

//			pstmt.setInt( i++ , product.getPR_SEQ() );
			pstmt.setInt( i++ , product.getPR_PRCSEQ() );
			pstmt.setString( i++ , product.getPR_CODE() );
			pstmt.setString( i++ , product.getPR_CODEB() );
			pstmt.setString( i++ , product.getPR_CODES() );
			pstmt.setString( i++ , product.getPR_NAME() );
			pstmt.setInt( i++ , product.getPR_PRICE() );
			pstmt.setInt( i++ , product.getPR_FILENUM() );
			pstmt.setString( i++ , product.getPR_IMAGE1() );
			pstmt.setString( i++ , product.getPR_IMAGE2() );
			pstmt.setString( i++ , product.getPR_IMAGE3() );
			pstmt.setString( i++ , product.getPR_IMAGE4() );
			pstmt.setString( i++ , product.getPR_CPIDS() );
			pstmt.setString( i++ , product.getPR_CPIDB() );
			pstmt.setString( i++ , product.getPR_BARCODE() );
			pstmt.setString( i++ , product.getPR_VATUSE() );
			pstmt.setInt( i++ , product.getPR_SAVEMONEY() );
			pstmt.setString( i++ , product.getPR_STANDARD() );
			pstmt.setInt( i++ , product.getPR_BRSEQ() );
			pstmt.setString( i++ , product.getPR_MODEL() );
			pstmt.setString( i++ , product.getPR_UNIT() );
			pstmt.setString( i++ , product.getPR_MANUFACTURE() );
			pstmt.setString( i++ , product.getPR_COUNTRY() );
			pstmt.setInt( i++ , product.getPR_MINBUYEA() );
			pstmt.setInt( i++ , product.getPR_STOCK() );
			pstmt.setString( i++ , product.getPR_WEIGHT() );
			pstmt.setString( i++ , product.getPR_CONTENT() );
			pstmt.setString( i++ , product.getPR_DELITERM() );
			pstmt.setString( i++ , product.getPR_DELIPOLICY() );
			pstmt.setString( i++ , product.getPR_STATUS() );
			pstmt.setString( i++ , product.getPR_LEVEL() );
			pstmt.setString( i++ , product.getPR_TYPE() );
			pstmt.setString( i++ , product.getPR_USE() );
			pstmt.setString( i++ , product.getPR_MOID() );
//			pstmt.setString( i++ , product.getPR_INID() );
//			pstmt.setTimestamp( i++, product.getPR_MODATE() );
//			pstmt.setTimestamp( i++, product.getPR_INDATE() );


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
			System.out.println("Product up Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}

	//update
	public int up(Product product, String whereStr)throws SQLException{

		int result = 0;
		String sql = "";
		try{
			sql = "update product set PR_PRCSEQ=?, PR_CODE=?, PR_CODEB=?, PR_CODES=?, PR_NAME=?, PR_PRICE=?, PR_FILENUM=?, PR_IMAGE1=?, PR_IMAGE2=?, PR_IMAGE3=?, PR_IMAGE4=?, PR_CPIDS=?, PR_CPIDB=?, PR_BARCODE=?, PR_VATUSE=?, PR_SAVEMONEY=?, PR_STANDARD=?, PR_BRSEQ=?, PR_MODEL=?, PR_UNIT=?, PR_MANUFACTURE=?, PR_COUNTRY=?, PR_MINBUYEA=?, PR_STOCK=?, PR_WEIGHT=?, PR_CONTENT=?, PR_DELITERM=?, PR_DELIPOLICY=?, PR_STATUS=?, PR_LEVEL=?, PR_TYPE=?, PR_USE=?, PR_MOID=? ";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			int i = 0;

//			pstmt.setInt( i++ , product.getPR_SEQ() );
			pstmt.setInt( i++ , product.getPR_PRCSEQ() );
			pstmt.setString( i++ , product.getPR_CODE() );
			pstmt.setString( i++ , product.getPR_CODEB() );
			pstmt.setString( i++ , product.getPR_CODES() );
			pstmt.setString( i++ , product.getPR_NAME() );
			pstmt.setInt( i++ , product.getPR_PRICE() );
			pstmt.setInt( i++ , product.getPR_FILENUM() );
			pstmt.setString( i++ , product.getPR_IMAGE1() );
			pstmt.setString( i++ , product.getPR_IMAGE2() );
			pstmt.setString( i++ , product.getPR_IMAGE3() );
			pstmt.setString( i++ , product.getPR_IMAGE4() );			
			pstmt.setString( i++ , product.getPR_CPIDS() );
			pstmt.setString( i++ , product.getPR_CPIDB() );
			pstmt.setString( i++ , product.getPR_BARCODE() );
			pstmt.setString( i++ , product.getPR_VATUSE() );
			pstmt.setInt( i++ , product.getPR_SAVEMONEY() );
			pstmt.setString( i++ , product.getPR_STANDARD() );
			pstmt.setInt( i++ , product.getPR_BRSEQ() );
			pstmt.setString( i++ , product.getPR_MODEL() );
			pstmt.setString( i++ , product.getPR_UNIT() );
			pstmt.setString( i++ , product.getPR_MANUFACTURE() );
			pstmt.setString( i++ , product.getPR_COUNTRY() );
			pstmt.setInt( i++ , product.getPR_MINBUYEA() );
			pstmt.setInt( i++ , product.getPR_STOCK() );
			pstmt.setString( i++ , product.getPR_WEIGHT() );
			pstmt.setString( i++ , product.getPR_CONTENT() );
			pstmt.setString( i++ , product.getPR_DELITERM() );
			pstmt.setString( i++ , product.getPR_DELIPOLICY() );
			pstmt.setString( i++ , product.getPR_STATUS() );
			pstmt.setString( i++ , product.getPR_LEVEL() );
			pstmt.setString( i++ , product.getPR_TYPE() );
			pstmt.setString( i++ , product.getPR_USE() );
			pstmt.setString( i++ , product.getPR_MOID() );
//			pstmt.setString( i++ , product.getPR_INID() );
//			pstmt.setTimestamp( i++, product.getPR_MODATE() );
//			pstmt.setTimestamp( i++, product.getPR_INDATE() );
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Product up Error : "+se+" \n sql : "+sql );
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
			sql = "update product set ";

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
			System.out.println("Product upChoice Error : "+se+" \nsql : "+sql );
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
			sql = "update product set ";
			for( int i = 0, n=colnamearr.length; i<n; i++ ){
				sql += colnamearr[i]+"="+colvalarr[i]+", ";
			}
			sql = sql.substring(0,sql.lastIndexOf(","));
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Product upChoice Error : "+se+" \n sql : "+sql );
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
			sql = "delete from product";

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
			System.out.println("Product delete Error : "+se+" \nsql : "+sql );
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
			sql = "delete from product";
			if( whereStr.length() > 0 ) sql += " where 1=1 "+ whereStr;

			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			return result;

		}catch(SQLException se){
			System.out.println("Product delete Error : "+se+" \n sql : "+sql );
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
			System.out.println("Product max Error : "+se+" \nsql : "+sql );
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
			System.out.println("Product max Error : "+se+" \n sql : "+sql );
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
			System.out.println("Product lastId Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}


	//----추가 쿼리는 아래 작성!

	//count
	public int cntJoin( Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		int result = 0;
		String sql = "";
		try{
			sql += "select count(*) from product pr ";
			sql += " LEFT OUTER JOIN productcategory prc ON pr.pr_prcseq = prc.prc_seq ";

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
			System.out.println("Product cnt Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	
	
	//listPage
	public Map<String, Object> listJoin( int r_curpage, int r_rowlimit, Map<String, Object> sqlMap )throws SQLException{

		List<String> wColNameList = (List<String>)sqlMap.get( "wColNameList" );
		List<Object> wColValList = (List<Object>)sqlMap.get( "wColValList" );
		List<String> wColTypeList = (List<String>)sqlMap.get( "wColTypeList" );
		String orderStr = Cvt.toStr( sqlMap.get( "orderStr" ) );

		Map<String, Object> productMap = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		List<Productcategory> productcategoryList = new ArrayList<Productcategory>();
		
		int startrow = (r_curpage-1) * r_rowlimit;
		String sql = "";
		try{
			sql += "select * from product pr ";
			sql += " LEFT OUTER JOIN productcategory prc ON pr.pr_prcseq = prc.prc_seq ";

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
				Product product = new Product();
				Productcategory productcategory = new Productcategory();

				product.setPR_SEQ( rs.getInt("PR_SEQ") );
				product.setPR_PRCSEQ( rs.getInt("PR_PRCSEQ") );
				product.setPR_CODE( rs.getString("PR_CODE") );
				product.setPR_CODEB( rs.getString("PR_CODEB") );
				product.setPR_CODES( rs.getString("PR_CODES") );
				product.setPR_NAME( rs.getString("PR_NAME") );
				product.setPR_PRICE( rs.getInt("PR_PRICE") );
				product.setPR_FILENUM( rs.getInt("PR_FILENUM") );
				product.setPR_IMAGE1( rs.getString("PR_IMAGE1") );
				product.setPR_IMAGE2( rs.getString("PR_IMAGE2") );
				product.setPR_IMAGE3( rs.getString("PR_IMAGE3") );
				product.setPR_IMAGE4( rs.getString("PR_IMAGE4") );
				product.setPR_CPIDS( rs.getString("PR_CPIDS") );
				product.setPR_CPIDB( rs.getString("PR_CPIDB") );
				product.setPR_BARCODE( rs.getString("PR_BARCODE") );
				product.setPR_VATUSE( rs.getString("PR_VATUSE") );
				product.setPR_SAVEMONEY( rs.getInt("PR_SAVEMONEY") );
				product.setPR_STANDARD( rs.getString("PR_STANDARD") );
				product.setPR_BRSEQ( rs.getInt("PR_BRSEQ") );
				product.setPR_MODEL( rs.getString("PR_MODEL") );
				product.setPR_UNIT( rs.getString("PR_UNIT") );
				product.setPR_MANUFACTURE( rs.getString("PR_MANUFACTURE") );
				product.setPR_COUNTRY( rs.getString("PR_COUNTRY") );
				product.setPR_MINBUYEA( rs.getInt("PR_MINBUYEA") );
				product.setPR_STOCK( rs.getInt("PR_STOCK") );
				product.setPR_WEIGHT( rs.getString("PR_WEIGHT") );
				product.setPR_CONTENT( rs.getString("PR_CONTENT") );
				product.setPR_DELITERM( rs.getString("PR_DELITERM") );
				product.setPR_DELIPOLICY( rs.getString("PR_DELIPOLICY") );
				product.setPR_STATUS( rs.getString("PR_STATUS") );
				product.setPR_LEVEL( rs.getString("PR_LEVEL") );
				product.setPR_TYPE( rs.getString("PR_TYPE") );
				product.setPR_USE( rs.getString("PR_USE") );
				product.setPR_MOID( rs.getString("PR_MOID") );
				product.setPR_INID( rs.getString("PR_INID") );
				product.setPR_MODATE( rs.getTimestamp("PR_MODATE") );
				product.setPR_INDATE( rs.getTimestamp("PR_INDATE") );
				productList.add(product);
				
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
			productMap.put( "productList", productList);
			productMap.put( "productcategoryList", productcategoryList);
			return productMap;

		}catch(SQLException se){
			System.out.println("Product list Error : "+se+" \nsql : "+sql );
			throw new SQLException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	
	
}