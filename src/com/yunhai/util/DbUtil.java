package com.yunhai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
 

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/hibernate_day01?useUnicode=true&characterEncoding=UTF8";
	private String dbUserName = "hibernate_day01";
	private String dbPassword = "hibernate_day01";
	private String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = (Connection) DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	// ��ȡ����
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// ע������ ctrl+shift+f��ʽ������
		//Class.forName("com.mysql.jdbc.Driver");

		// ��ȡ���� ctrl+o �����
		//Connection conn = (Connection) DriverManager.getConnection(
		//		"jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF8", "day06", "day06");

		ResourceBundle bundle= ResourceBundle.getBundle("jdbc");

		String driverClass=bundle.getString("driverClass");
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");

		Class.forName(driverClass);
		Connection conn = (Connection) DriverManager.getConnection(url,user,password);
				
		return conn;
	}

	// �ͷ���Դ
	public static void closeResource(java.sql.Connection conn, Statement st, ResultSet rs) throws Exception {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}

	/**
	 * �ͷ����ӳ�
	 * @param con
	 * @throws Exception
	 */
	public static void closeConn(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
		con = null;
	}

	/**
	 * �ͷŽ����
	 * @param rs
	 * @throws Exception
	 */
	public static void closeRs(ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}
		rs = null;
	}

	/**
	 * �ͷ����ִ����
	 * @param st
	 * @throws Exception
	 */
	public static void closeSt(Statement st) throws Exception {
		if (st != null) {
			st.close();
		}
		st = null;
	}

}
