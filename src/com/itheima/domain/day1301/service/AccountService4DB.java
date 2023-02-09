package com.itheima.domain.day1301.service;

import com.itheima.domain.day1301.dao.AccountDao4DB;
import com.yunhai.util.DataSourceUtils;

public class AccountService4DB {

	public void account(String fromUser, String toUser, Integer money) throws Exception {
		AccountDao4DB dao = new AccountDao4DB();
		
		//Connection conn=null;
		try {
			// 0.��������
			  DataSourceUtils.startTransaction();
			//��conn�͵�ǰ�̰߳�
			//conn.setAutoCommit(false);
			// 1.ת��
			dao.accountOut(fromUser, money);

			//int i = 1 / 0;
			// 2.ת��
			dao.accountIn(toUser, money);
			//3.�����ύ 
			DataSourceUtils.commitAndCloseTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			DataSourceUtils.rollbackAndCloseTransaction();
			throw e;
		}
	}
}
