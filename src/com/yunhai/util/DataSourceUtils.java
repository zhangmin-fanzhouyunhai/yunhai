package com.yunhai.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	/**
	 * ��ȡ����Դ
	 *  
	 * @return ���ӳ�
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * �ӵ�ǰ�߳��ϻ�ȡ����
	 * 
	 * @return ����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		 
		if (conn == null) {
			// ��һ�λ�ȡ����һ�����Ӻ͵�ǰ���̰߳�
			conn = ds.getConnection();

			// ��
			tl.set(conn);
		}
		return conn;
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn ����
	 * @param st   ���ִ����
	 * @param rs   �����
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st,rs);
		closeConn(conn);
		/*
		 * if (!(rs == null)) { closeRs(rs); } 
		 * if (!(st == null)) { closeSt(st); } 
		 * if(!(conn == null)) { closeConn(conn); }
		 */
		//�ɴ���
		//closeResultSet(rs);
		//closeStatement(st);
		//closeConn(conn);
		//�´���
		closeResource(st, rs);
		closeConn(conn);
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param st   ���ִ����
	 * @param rs   �����
	 */
	public static void closeResource(Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st); 
	}
	/**
	 * �ͷ�����
	 * 
	 * @param conn ����
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				// �͵�ǰ���߳̽��
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * �ͷ����ִ����
	 * 
	 * @param st ���ִ����
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
	 * @param rs �����
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
 
	/**
	 * ��������
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		// ��ȡ����//��������
		//Connection connection = getConnection().setAutoCommit(false);
		getConnection().setAutoCommit(false);
	}
	/**
	 * �����ύ
	 */
	public static void commitAndClose(){
		try {
			//��ȡ����
			Connection conn = getConnection();
			//�ύ����
			conn.commit();
			//�ͷ���Դ
			conn.close();
			//�����
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ύ
	 */
	public static void commitAndCloseTransaction() {
		
		try {
			// ��ȡ���� 
			Connection conn = getConnection(); 
			//�ύ����
			conn.commit();
			//�ͷ���Դ 
			conn.close();
			//�����
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * ����ع�
	 */
	public static void rollbackAndCloseTransaction() {
		
		try {
			// ��ȡ���� 
			Connection conn = getConnection(); 
			//�ύ�ع�
			conn.rollback();
			//�ͷ���Դ 
			conn.close();
			//�����
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ����ع�
	 */
	public static void rollbackAndClose(){
		try {
			//��ȡ����
			Connection conn = getConnection();
			//����ع�
			conn.rollback();
			//�ͷ���Դ
			conn.close();
			//�����
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
