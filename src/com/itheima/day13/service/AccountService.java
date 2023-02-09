package com.itheima.day13.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.day13.dao.AccountDao;
import com.yunhai.util.JdbcUtils;

public class AccountService {

	/**
	 * 转账
	 * 
	 * @param fromUser 转出方
	 * @param toUser   转入方
	 * @param money    金额
	 * @throws SQLException
	 */
	public void account(String fromUser, String toUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			// 0.开启事务
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			// 1.转出
			dao.accountOut(conn,fromUser, money);

			//
			int i = 1 / 0;

			// 2.转入
			dao.accountIn(conn,toUser, money);
			// 3.事务提交
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
			// 事务回滚
			conn.rollback();
			System.out.println("rollback!");
			JdbcUtils.closeConn(conn);
			throw e;
		}
		/*
		 * // 1.转出 dao.accountOut(fromUser, money);
		 * 
		 * int i = 1 / 0;
		 * 
		 * // 2.转入 dao.accountIn(toUser, money);
		 */

	}

}
