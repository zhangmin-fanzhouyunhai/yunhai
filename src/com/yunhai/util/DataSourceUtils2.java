package com.yunhai.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils2 {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	//��ȡ����
	/**
	 * �@ȡ����Դ
	 * @return �B�ӳ�
	 */
	public static DataSource getDataSource() {
		System.out.println("1,ds="+ds.getDataSourceName());
		return ds;
	}
	
	//��ȡ����Դ
	public static Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}
	
	
	//�ͷ���Դ

	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		if (!(rs == null)) {
			closeRs(rs);
		}
		if (!(st == null)) {
			closeSt(st);
		}
		if (!(conn == null)) {
			closeConn(conn);
		}
	}
	
	

	/**
	 * �ͷ����ӳ�
	 * 
	 * @param con
	 * @throws Exception
	 */
	public static void closeConn(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		con = null;
	}

	/**
	 * �ͷŽ����
	 * 
	 * @param rs
	 * @throws Exception
	 */
	public static void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = null;
	}

	/**
	 * �ͷ����ִ����
	 * 
	 * @param st
	 * @throws Exception
	 */
	public static void closeSt(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		st = null;
	}
	
}
