package com.itheima.domain.day15.service;

import java.sql.SQLException;

import com.itheima.domain.day15.dao.UserDao;
import com.itheima.domain.day15.domain.User;

public class UserService {
	/**
	 * 检测用户是否被占用
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public User checkUsername4Ajax(String username) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDao().getUserByUsername4Ajax(username);
	}

}
