package com.yunhai.db.mydbutils.curd;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.yunhai.util.DataSourceUtils;

public class CURDDemo {
	@Test
	public void insert() throws SQLException {
		//1����queryrunner�
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.����Sql
		String sql="insert into category values(?,?)";
		
		//3.����sql
		qr.update(sql,"c201","�N�����"); 	
	}
	
	@Test
	public void update() throws SQLException {
		//1����queryrunner�
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.����Sql
		String sql="update category cname=? where cid=?";
		
		//3.����sql
		qr.update(sql,"�����","c001"); 	
	}
	
	
	
	
	
	
	
	
}
