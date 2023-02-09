package com.yunhai.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils2 {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	//获取连接
	/**
	 * 獲取數據源
	 * @return 連接池
	 */
	public static DataSource getDataSource() {
		System.out.println("1,ds="+ds.getDataSourceName());
		return ds;
	}
	
	//获取数据源
	public static Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}
	
	
	//释放资源

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
	 * 释放连接池
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
	 * 释放结果集
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
	 * 释放语句执行者
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
