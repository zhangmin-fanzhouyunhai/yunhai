package com.itheima.domain.day1301.service;

import java.sql.Connection;

import com.itheima.domain.day1301.dao.AccountDao;
import com.yunhai.util.JdbcUtils;

public class AccountService {

	public void account(String fromUser, String toUser, Integer money) throws Exception {
		AccountDao dao = new AccountDao();

		Connection conn=null;
		try {
			// 0.��������
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			// 1.ת��
			dao.accountOut(conn,fromUser, money);

			int i = 1 / 0;
			// 2.ת��
			dao.accountIn(conn,toUser, money);
			//3.�����ύ
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//����ع�
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
	}
}
