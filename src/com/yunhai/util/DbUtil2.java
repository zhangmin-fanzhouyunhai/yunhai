package com.yunhai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtil2 {

	// ��ȡResourceBundle ctrl+2 1
	// ResourceBundle bundle;
	// ��ȡָ��������
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static {
		// ���¿�ݼ���eclipse������������
		// ��ȡResourceBundle ctrl+2 1
		// ��༭ alt+shift+a
		// ���д ctrl+shift+x
		// ��Сд ctrl+shift+y
		// ���¸���һ�� alt+ctrl+(���¼�)
		// �������һ������ shift+enter
		// �������һ������ ctrl+shift+enter
		// ɾ��һ��ѡ���� ctrl+d
		// ע�ͻ���ȥ��ע�� ctrl+/
		// �����ƶ�һ�� alt+(���¼�)
		// ע��jdbc.properties�ļ��������srcĿ¼�£����ܷ���src.com.ithe*����Ŀ¼�¡�
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ȡ����
	public static Connection getConnection() throws SQLException {

		// ����ķ���ÿִ��һ���������ݿ⣬�ͻ��ȡһ�������ļ�����ˣ�������һ��static�顣��ע����������ݣ����������static��

		// System.out.println("DRIVERCLASS"
		// +DRIVERCLASS+"URL"+URL+"USER"+USER+"PASSWORD"+PASSWORD);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// �ͷ���Դ
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
