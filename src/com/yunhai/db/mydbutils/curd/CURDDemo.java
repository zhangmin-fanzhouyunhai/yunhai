package com.yunhai.db.mydbutils.curd;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.yunhai.util.DataSourceUtils;

public class CURDDemo {
	@Test
	public void insert() throws SQLException {
		//1創建queryrunner類
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.編寫Sql
		String sql="insert into category values(?,?)";
		
		//3.執行sql
		qr.update(sql,"c201","廚房電器"); 	
	}
	
	@Test
	public void update() throws SQLException {
		//1創建queryrunner類
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.編寫Sql
		String sql="update category cname=? where cid=?";
		
		//3.執行sql
		qr.update(sql,"大電器","c001"); 	
	}
	
	
	
	
	
	
	
	
}
