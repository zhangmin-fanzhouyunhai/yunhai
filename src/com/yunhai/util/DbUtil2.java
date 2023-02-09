package com.yunhai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtil2 {

	// 获取ResourceBundle ctrl+2 1
	// ResourceBundle bundle;
	// 获取指定的内容
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	static {
		// 以下快捷键对eclipse开发工具有用
		// 获取ResourceBundle ctrl+2 1
		// 块编辑 alt+shift+a
		// 变大写 ctrl+shift+x
		// 变小写 ctrl+shift+y
		// 向下复制一行 alt+ctrl+(向下键)
		// 向下添加一个空行 shift+enter
		// 向上添加一个空行 ctrl+shift+enter
		// 删除一行选中行 ctrl+d
		// 注释或者去掉注释 ctrl+/
		// 向下移动一行 alt+(向下键)
		// 注意jdbc.properties文件必须放在src目录下，不能放在src.com.ithe*类型目录下。
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		// 获取指定的内容
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
	}
	static {
		// 注册驱动 ctrl+shift+f格式化代码
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {

		// 下面的方法每执行一次连接数据库，就会读取一次配置文件。因此，可以用一个static块。固注释正面的内容，在外面放置static块

		// System.out.println("DRIVERCLASS"
		// +DRIVERCLASS+"URL"+URL+"USER"+USER+"PASSWORD"+PASSWORD);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// 释放资源
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
