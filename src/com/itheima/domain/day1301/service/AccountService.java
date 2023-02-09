package com.itheima.domain.day1301.service;

import java.sql.Connection;

import com.itheima.domain.day1301.dao.AccountDao;
import com.yunhai.util.JdbcUtils;

public class AccountService {

	public void account(String fromUser, String toUser, Integer money) throws Exception {
		AccountDao dao = new AccountDao();

		Connection conn=null;
		try {
			// 0.开启事务
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			// 1.转出
			dao.accountOut(conn,fromUser, money);

			int i = 1 / 0;
			// 2.转入
			dao.accountIn(conn,toUser, money);
			//3.事务提交
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//事务回滚
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
	}
}
