package com.yunhai.db.my;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

//import com.mysql.jdbc.jdbc2.optional.ConnectionWrapper;
import com.yunhai.util.DbUtil2;

public class MyDatabaseSource {

	static LinkedList<Connection> pool=new LinkedList<>();
	static {
		//��ʼ����ʱ����Ҫ����3������
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
	 * �����ӳ��л�ȡ����
	 */
	public static Connection getConnection() {
		//��ȡ���ӵ�ʱ����Ҫ�ж�list�Ƿ�Ϊ��
		if(pool.isEmpty()) {
			//�����2�����ӽ�ȥ
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
		System.out.println("�ӳ��л�ȡһ������");
		//return pool.removeFirst();
		Connection conn=pool.removeFirst();
		//��conn���а�װ
		//ConnectionWarp myConn=new ConnectionWarp(conn);
		ConnectionWarp myConn=new ConnectionWarp(conn,pool);
		return myConn;
	}

	/**
	 * �黹���ӵķ���
	 */
	public static void addBack(Connection conn) {

		//��conn���뵽list������漴��
		pool.addLast(conn);
		System.out.println("�����ѹ黹");
	}
}





