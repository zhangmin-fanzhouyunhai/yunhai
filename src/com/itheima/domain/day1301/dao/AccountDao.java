package com.itheima.domain.day1301.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yunhai.util.JdbcUtils;

public class AccountDao {
	/**
	 * ���Ǯ
	 * 
	 * @param fromUser
	 * @param money
	 */
	public void accountOut(Connection conn,String fromUser, int money) throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//conn = JdbcUtils.getConnection();
			//��дsql
			String sql="update account set money = money - ? where name = ?";
			//�������ִ����
			st=conn.prepareStatement(sql);
			//���ò���
			st.setInt(1, money);
			st.setString(2, fromUser);
			
			//ִ��sql
			int i=st.executeUpdate();
			//����
			System.out.println("����i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn,st,rs);
			JdbcUtils.closeStatement(st);
		}
	}

	/**
	 * ת��Ǯ
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
			//��дsql
			String sql="update account set money = money + ? where name = ?";
			//�������ִ����
			st=conn.prepareStatement(sql);
			//���ò���
			st.setInt(1, money);
			st.setString(2, toUser);
			
			//ִ��sql
			int i=st.executeUpdate();
			//����
			System.out.println("����i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn,st,rs);
			JdbcUtils.closeStatement(st);
		}
		
	}
	
	/**
	 * ���Ǯ
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
			//��дsql
			String sql="update account set money = money - ? where name = ?";
			//�������ִ����
			st=conn.prepareStatement(sql);
			//���ò���
			st.setInt(1, money);
			st.setString(2, fromUser);
			
			//ִ��sql
			int i=st.executeUpdate();
			//����
			System.out.println("����i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
	}

	/**
	 * ת��Ǯ
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
			//��дsql
			String sql="update account set money = money + ? where name = ?";
			//�������ִ����
			st=conn.prepareStatement(sql);
			//���ò���
			st.setInt(1, money);
			st.setString(2, toUser);
			
			//ִ��sql
			int i=st.executeUpdate();
			//����
			System.out.println("����i="+i);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeResource(conn,st,rs);
		}
		
	}
}
