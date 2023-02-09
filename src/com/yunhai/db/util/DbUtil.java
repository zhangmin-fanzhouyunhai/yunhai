package com.yunhai.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
	/*
	 * 功能：编写一个静态方法用于与数据库建立连�? 输入参数：无 返回值：数据库连接对�?
	 */
	public static Connection getConnection() {
		// 定义�?个连接对�?
		Connection conn = null;
		// 定义连接数据库的URL资源
		//String url = "jdbc:Oracle:thin:@vdserver.gicp.net:13551:orcl";
		// 
		//String url = "jdbc:Oracle:thin:@192.168.1.202:1521:orcl"; 
		//String url = "jdbc:Oracle:thin:@192.168.81.128:1521:orcl"; 
		//String url = "jdbc:Oracle:thin:@192.168.199.140:1521:hubeiorcl";
		//String url = "jdbc:Oracle:thin:@192.168.199.133:1521:orcl";
		String url = "jdbc:Oracle:thin:@192.168.15.134:1521:YUNHAI";
		// 定义连接数据库的用户名称与密�?
		//String username = "ZCFX_HEBEI";
		//String password = "ZCFX_HEBEI";
		//String username = "ZCFX_HEBEI_OLD";
		//String password = "ZCFX_HEBEI_OLD";
		//
		String username = "ZCFX_HEBEI2";
		//
		String password = "ZCFX_HEBEI2";
		//String username = "C##ZCFX";
		//String password = "ZCFX";
		//		String username = "ZCFX_NEW";
		//		String password = "ZCFX_NEW";
		//String username = "ZCFX_HEBEI_OLD";
		//String password = "ZCFX_HEBEI_OLD";
		// 加载数据库连接驱�?
		String className = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取数据库的连接对象
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接建立成�?...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回连接对象
		return conn;
	}

	public static void close(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement c) {
		if (c != null) {
			try {
				c.close();
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}
	}
}
