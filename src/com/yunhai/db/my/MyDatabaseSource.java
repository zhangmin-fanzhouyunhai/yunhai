package com.yunhai.db.my;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

//import com.mysql.jdbc.jdbc2.optional.ConnectionWrapper;
import com.yunhai.util.DbUtil2;

public class MyDatabaseSource {

	static LinkedList<Connection> pool=new LinkedList<>();
	static {
		//初始化的时候需要存入3个连接
		for(int i=0;i<3;i++) {
			try {
				Connection conn=
						DbUtil2.getConnection();
				pool.add(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 从连接池中获取连接
	 */
	public static Connection getConnection() {
		//获取连接的时候需要判断list是否为空
		if(pool.isEmpty()) {
			//在添加2个连接进去
			for(int i=0;i<3;i++) {
				try {
					Connection conn=
							DbUtil2.getConnection();
					pool.add(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("从池中获取一个连接");
		//return pool.removeFirst();
		Connection conn=pool.removeFirst();
		//将conn进行包装
		//ConnectionWarp myConn=new ConnectionWarp(conn);
		ConnectionWarp myConn=new ConnectionWarp(conn,pool);
		return myConn;
	}

	/**
	 * 归还连接的方法
	 */
	public static void addBack(Connection conn) {

		//将conn放入到list的最后面即可
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}





