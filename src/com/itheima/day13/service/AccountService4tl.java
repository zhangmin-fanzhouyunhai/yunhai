package com.itheima.day13.service;

import java.sql.SQLException;

import com.itheima.day13.dao.AccountDao4tl;
import com.yunhai.util.DataSourceUtils;

public class AccountService4tl {

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
		AccountDao4tl dao = new AccountDao4tl();
		//AccountDao dao = new AccountDao();
		try {
			// 0.开启事务
			 DataSourceUtils.startTransaction();
			// 1.转出
			dao.accountOut(fromUser, money);

			//
			int i = 1 / 0;

			// 2.转入
			dao.accountIn(toUser, money);
			// 3.事务提交
			
		} catch (Exception e) {
			e.printStackTrace(); 
			DataSourceUtils.rollbackAndClose();
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
