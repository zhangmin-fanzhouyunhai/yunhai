package com.itheima.domain.day15.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.poi.ss.formula.functions.T;

import com.yunhai.util.DataSourceUtils;
import com.itheima.domain.day15.domain.User;

public class UserDao {
	/**
	 * 通过用户名获取一个用户
	 * 
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUsername4Ajax(String username) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String querySql="select * from user where username=? limit 1";
		
		return queryRunner.query(querySql, new BeanHandler<>(User.class),username);
	}

}
