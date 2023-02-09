package com.yunhai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	
	static {
		// ��༭ alt+shift +a
		// ���д ctrl+shift+x
		// ��Сд ctrl+shift+y
		// ���¸���һ��   alt+ctrl+��
		// �������һ������ shift + enter
		// �������һ������ ctrl+shift + enter
		// ɾ��һ�� ѡ����  ctrl+d
		// ע�ͻ���ȥ��ע�� ctrl+/
		// �����ƶ�һ�� alt + ��
		
		
		// ��ȡResourceBundle ctrl+2 l
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		// ��ȡָ��������
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
	}
	
	static {
		// ע������ ctrl+shift+f��ʽ������
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	// ��ȡ����
	public static Connection getConnection() throws SQLException {
		// ��ȡ���� ctrl+o �����
		return  DriverManager.getConnection(URL, USER, PASSWORD);
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ����
	 * @param st
	 *            ���ִ����
	 * @param rs
	 *            �����
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * �ͷ�����
	 * 
	 * @param conn
	 *            ����
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * �ͷ����ִ����
	 * 
	 * @param st
	 *            ���ִ����
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * �ͷŽ����
	 * 
	 * @param rs
	 *            �����
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}
}
