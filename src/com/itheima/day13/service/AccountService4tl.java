package com.itheima.day13.service;

import java.sql.SQLException;

import com.itheima.day13.dao.AccountDao4tl;
import com.yunhai.util.DataSourceUtils;

public class AccountService4tl {

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
		AccountDao4tl dao = new AccountDao4tl();
		//AccountDao dao = new AccountDao();
		try {
			// 0.��������
			 DataSourceUtils.startTransaction();
			// 1.ת��
			dao.accountOut(fromUser, money);

			//
			int i = 1 / 0;

			// 2.ת��
			dao.accountIn(toUser, money);
			// 3.�����ύ
			
		} catch (Exception e) {
			e.printStackTrace(); 
			DataSourceUtils.rollbackAndClose();
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
