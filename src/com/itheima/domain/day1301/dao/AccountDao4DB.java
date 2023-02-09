  package com.itheima.domain.day1301.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.yunhai.util.DataSourceUtils;

public class AccountDao4DB {

	public void accountOut(String fromUser, Integer money) throws SQLException {
		// TODO Auto-generated method stub
		//创建queryRunner
		QueryRunner qr=new QueryRunner();
		
		//编写SQL
		String sql="update account set money = money - ? where name = ? ";
		//执行SQL 
		qr.update(DataSourceUtils.getConnection(),sql,money,fromUser);
	}

	public void accountIn(String toUser, Integer money) throws SQLException {
		// TODO Auto-generated method stub
		//创建queryRunner
				QueryRunner qr=new QueryRunner();
				
				//编写SQL
				String sql="update account set money = money + ? where name = ? ";
				//执行SQL 
				qr.update(DataSourceUtils.getConnection(),sql,money,toUser);
	}

}
