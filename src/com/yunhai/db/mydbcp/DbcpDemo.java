package com.yunhai.db.mydbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.yunhai.util.DbUtil2;

public class DbcpDemo {
	@Test
	public void f1() throws SQLException {
		//创建连接池
		BasicDataSource ds=new BasicDataSource();
		
		//配置信息
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF8");
		ds.setUsername("day06");
		ds.setPassword("day06");
		
		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?);";
		PreparedStatement st=conn.prepareStatement(sql);
		
		//设置参数
		st.setString(1, "c009");
		st.setString(2, "饲料");
		
		//执行
		int i=st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
	}
	@Test
	public void f2() throws Exception {
		//存放配置文件
		Properties prop =new Properties();
		//设置
		//prop.setProperty("DriverClassName", "com.mysql.jdbc.Driver");
		prop.load(new FileInputStream("src/dbcp.properties"));
		//创建连接池
		DataSource ds=new BasicDataSourceFactory().createDataSource(prop);
		
				Connection conn=ds.getConnection();
		String sql="insert into category values(?,?);";
		PreparedStatement st=conn.prepareStatement(sql);
		
		//设置参数
		st.setString(1, "c011");
		st.setString(2, "饲料");
		
		//执行
		int i=st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
	}
	
	
}
