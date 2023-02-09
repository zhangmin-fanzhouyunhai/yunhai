package com.itheima.domain.day1301.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yunhai.util.JdbcUtils;

public class AccountDao {
	/**
	 * 输出钱
	 * 
	 * @param fromUser
	 * @param money
	 */
	public void accountOut(Connection conn,String fromUser, int money) throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//conn = JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money - ? where name = ?";
			//创建语句执行者
			st=conn.prepareStatement(sql);
			//设置参数
			st.setInt(1, money);
			st.setString(2, fromUser);
			
			//执行sql
			int i=st.executeUpdate();
			//处理
			System.out.println("出：i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn,st,rs);
			JdbcUtils.closeStatement(st);
		}
	}

	/**
	 * 转入钱
	 * 
	 * @param toUser
	 * @param money
	 * @throws SQLException 
	 */
	public void accountIn(Connection conn,String toUser, int money) throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//conn = JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money + ? where name = ?";
			//创建语句执行者
			st=conn.prepareStatement(sql);
			//设置参数
			st.setInt(1, money);
			st.setString(2, toUser);
			
			//执行sql
			int i=st.executeUpdate();
			//处理
			System.out.println("出：i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn,st,rs);
			JdbcUtils.closeStatement(st);
		}
		
	}
	
	/**
	 * 输出钱
	 * 
	 * @param fromUser
	 * @param money
	 */
	public void accountOut_(String fromUser, int money) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money - ? where name = ?";
			//创建语句执行者
			st=conn.prepareStatement(sql);
			//设置参数
			st.setInt(1, money);
			st.setString(2, fromUser);
			
			//执行sql
			int i=st.executeUpdate();
			//处理
			System.out.println("出：i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
	}

	/**
	 * 转入钱
	 * 
	 * @param toUser
	 * @param money
	 * @throws SQLException 
	 */
	public void accountIn_(String toUser, int money) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money + ? where name = ?";
			//创建语句执行者
			st=conn.prepareStatement(sql);
			//设置参数
			st.setInt(1, money);
			st.setString(2, toUser);
			
			//执行sql
			int i=st.executeUpdate();
			//处理
			System.out.println("出：i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
		
	}
}
