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
		// ���û�������
		/**
		 * �������ò��ɹ�����Ҫԭ�������mysql-connector-java-5.1.39-bin.jar�汾��ƥ��
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

		// ���ò���
		st.setString(1, "c009");
		st.setString(2, "��ҩ");

		// ִ��
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

		// ���ò���
		st.setString(1, "c010");
		st.setString(2, "�˲�");

		// ִ��
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

		// ���ò���
		st.setString(1, "c011");
		st.setString(2, "�˲�");

		// ִ��
		int i = st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
		
	}
	
	
	
}
