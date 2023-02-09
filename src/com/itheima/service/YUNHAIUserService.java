package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.YUNHAIUserDao;
import com.itheima.user.orm.YunhaiUser;

public class YUNHAIUserService {
	/**
	 * ����û��Ƿ�ռ��
	 * 
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public YunhaiUser checkUsername4Ajax(String username) throws SQLException {
		//return new YUNHAIUserDao().getUserByUsername4Ajax(username);
		return new YUNHAIUserDao().getUserByUsername4AjaxViaCriteria(username);
		
	}
}
