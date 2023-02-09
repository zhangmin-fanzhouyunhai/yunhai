package com.itheima.day13.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import com.yunhai.util.JdbcUtils;

public class AccountDao {
	/**
	 * 转出钱
	 * 
	 * @param fromUser 转出方
	 * @param money    转出金额
	 * @throws SQLException 
	 */
	public void accountOut(String fromUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//编写sql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY - ? WHERE ACCOUNT_NAME=?";
			//创建语句 执行者
			st=conn.prepareStatement(sqlStr);
			//设置参数 
			st.setString(1,money);
			st.setString(2, fromUser);
			//执行sql
			int resultNumber=st.executeUpdate();
			//处理
			System.out.println("出："+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

	/**
	 * 转入钱
	 * 
	 * @param toUser 转入方
	 * @param money  转入金额
	 * @throws SQLException 
	 */
	public void accountIn(String toUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//编写sql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY + ? WHERE ACCOUNT_NAME=?";
			//创建语句 执行者
			st=conn.prepareStatement(sqlStr);
			//设置参数 
			st.setString(1,money);
			st.setString(2, toUser);
			//执行sql
			int resultNumber=st.executeUpdate();
			//处理
			System.out.println("入："+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

	public void accountOut(Connection conn, String fromUser, String money) throws SQLException {
		// TODO Auto-generated method stub 
		PreparedStatement st = null; 

		try { 
			//编写sql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY - ? WHERE ACCOUNT_NAME=?";
			//创建语句 执行者
			st=conn.prepareStatement(sqlStr);
			//设置参数 
			st.setString(1,money);
			st.setString(2, fromUser);
			//执行sql
			int resultNumber=st.executeUpdate();
			//处理
			System.out.println("出："+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeStatement(st);
		}
	}

	public void accountIn(Connection conn, String toUser, String money) throws SQLException {
		// TODO Auto-generated method stub 
		PreparedStatement st = null; 

		try { 
			//编写sql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY + ? WHERE ACCOUNT_NAME=?";
			//创建语句 执行者
			st=conn.prepareStatement(sqlStr);
			//设置参数 
			st.setString(1,money);
			st.setString(2, toUser);
			//执行sql
			int resultNumber=st.executeUpdate();
			//处理
			System.out.println("入："+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeStatement(st);
		}
	}

}
