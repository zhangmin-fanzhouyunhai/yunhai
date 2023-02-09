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
	 * 获取数据源
	 *  
	 * @return 连接池
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 从当前线程上获取连接
	 * 
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		 
		if (conn == null) {
			// 第一次获取创建一个连接和当前的线程绑定
			conn = ds.getConnection();

			// 绑定
			tl.set(conn);
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn 连接
	 * @param st   语句执行者
	 * @param rs   结果集
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st,rs);
		closeConn(conn);
		/*
		 * if (!(rs == null)) { closeRs(rs); } 
		 * if (!(st == null)) { closeSt(st); } 
		 * if(!(conn == null)) { closeConn(conn); }
		 */
		//旧代码
		//closeResultSet(rs);
		//closeStatement(st);
		//closeConn(conn);
		//新代码
		closeResource(st, rs);
		closeConn(conn);
	}

	/**
	 * 释放资源
	 * 
	 * @param st   语句执行者
	 * @param rs   结果集
	 */
	public static void closeResource(Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st); 
	}
	/**
	 * 释放连接
	 * 
	 * @param conn 连接
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				// 和当前的线程解绑
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * 释放语句执行者
	 * 
	 * @param st 语句执行者
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
	 * 释放结果集
	 * 
	 * @param rs 结果集
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
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		// 获取连接//开启事务
		//Connection connection = getConnection().setAutoCommit(false);
		getConnection().setAutoCommit(false);
	}
	/**
	 * 事务提交
	 */
	public static void commitAndClose(){
		try {
			//获取连接
			Connection conn = getConnection();
			//提交事务
			conn.commit();
			//释放资源
			conn.close();
			//解除绑定
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 事务提交
	 */
	public static void commitAndCloseTransaction() {
		
		try {
			// 获取连接 
			Connection conn = getConnection(); 
			//提交事务
			conn.commit();
			//释放资源 
			conn.close();
			//解除绑定
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * 事务回滚
	 */
	public static void rollbackAndCloseTransaction() {
		
		try {
			// 获取连接 
			Connection conn = getConnection(); 
			//提交回滚
			conn.rollback();
			//释放资源 
			conn.close();
			//解除绑定
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 事务回滚
	 */
	public static void rollbackAndClose(){
		try {
			//获取连接
			Connection conn = getConnection();
			//事务回滚
			conn.rollback();
			//释放资源
			conn.close();
			//解除绑定
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
