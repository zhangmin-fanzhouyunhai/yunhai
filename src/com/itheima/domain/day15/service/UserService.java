package com.itheima.domain.day15.service;

import java.sql.SQLException;

import com.itheima.domain.day15.dao.UserDao;
import com.itheima.domain.day15.domain.User;

public class UserService {
	/**
	 * ����û��Ƿ�ռ��
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public User checkUsername4Ajax(String username) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDao().getUserByUsername4Ajax(username);
	}

}
