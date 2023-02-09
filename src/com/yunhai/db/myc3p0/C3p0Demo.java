package com.yunhai.db.myc3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yunhai.util.DbUtil2;

public class C3p0Demo {
	@Test
	public void f1() throws Exception {

		ComboPooledDataSource ds = new ComboPooledDataSource();
		// 设置基本参数
		/**
		 * 以下配置不成功，主要原因可能是mysql-connector-java-5.1.39-bin.jar版本不匹配
		 * 
		 * 
		 */
		ds.setDriverClass("com.mysql.jdbc.Driver");//com.mysql.cj.jdbc.Driver
		//ds.setJdbcUrl("jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF8");//&serverTimezone=GMT%2B8
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/day06");
		ds.setUser("day 06");
		ds.setPassword("day06");

		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?);";
		PreparedStatement st = conn.prepareStatement(sql);

		// 设置参数
		st.setString(1, "c009");
		st.setString(2, "中药");

		// 执行
		int i = st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);

	}
	@Test
	public void f2() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?);";
		PreparedStatement st = conn.prepareStatement(sql);

		// 设置参数
		st.setString(1, "c010");
		st.setString(2, "人参");

		// 执行
		int i = st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
		
	}

	@Test
	public void f3() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource("itcast");
		Connection conn = ds.getConnection();
		String sql = "insert into category values(?,?);";
		PreparedStatement st = conn.prepareStatement(sql);

		// 设置参数
		st.setString(1, "c011");
		st.setString(2, "人参");

		// 执行
		int i = st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
		
	}
	
	
	
}
