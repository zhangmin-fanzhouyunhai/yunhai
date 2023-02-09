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
		//�������ӳ�
		BasicDataSource ds=new BasicDataSource();
		
		//������Ϣ
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF8");
		ds.setUsername("day06");
		ds.setPassword("day06");
		
		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?);";
		PreparedStatement st=conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c009");
		st.setString(2, "����");
		
		//ִ��
		int i=st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
	}
	@Test
	public void f2() throws Exception {
		//��������ļ�
		Properties prop =new Properties();
		//����
		//prop.setProperty("DriverClassName", "com.mysql.jdbc.Driver");
		prop.load(new FileInputStream("src/dbcp.properties"));
		//�������ӳ�
		DataSource ds=new BasicDataSourceFactory().createDataSource(prop);
		
				Connection conn=ds.getConnection();
		String sql="insert into category values(?,?);";
		PreparedStatement st=conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c011");
		st.setString(2, "����");
		
		//ִ��
		int i=st.executeUpdate();
		System.out.println(i);
		DbUtil2.closeResource(conn, st, null);
	}
	
	
}
