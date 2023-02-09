package com.itheima.day13.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.day13.dao.AccountDao;
import com.yunhai.util.JdbcUtils;

public class AccountService {

	/**
	 * ת��
	 * 
	 * @param fromUser ת����
	 * @param toUser   ת�뷽
	 * @param money    ���
	 * @throws SQLException
	 */
	public void account(String fromUser, String toUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			// 0.��������
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			// 1.ת��
			dao.accountOut(conn,fromUser, money);

			//
			int i = 1 / 0;

			// 2.ת��
			dao.accountIn(conn,toUser, money);
			// 3.�����ύ
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
			// ����ع�
			conn.rollback();
			System.out.println("rollback!");
			JdbcUtils.closeConn(conn);
			throw e;
		}
		/*
		 * // 1.ת�� dao.accountOut(fromUser, money);
		 * 
		 * int i = 1 / 0;
		 * 
		 * // 2.ת�� dao.accountIn(toUser, money);
		 */

	}

}
