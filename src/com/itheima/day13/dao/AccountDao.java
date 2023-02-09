package com.itheima.day13.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import com.yunhai.util.JdbcUtils;

public class AccountDao {
	/**
	 * ת��Ǯ
	 * 
	 * @param fromUser ת����
	 * @param money    ת�����
	 * @throws SQLException 
	 */
	public void accountOut(String fromUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//��дsql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY - ? WHERE ACCOUNT_NAME=?";
			//������� ִ����
			st=conn.prepareStatement(sqlStr);
			//���ò��� 
			st.setString(1,money);
			st.setString(2, fromUser);
			//ִ��sql
			int resultNumber=st.executeUpdate();
			//����
			System.out.println("����"+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

	/**
	 * ת��Ǯ
	 * 
	 * @param toUser ת�뷽
	 * @param money  ת����
	 * @throws SQLException 
	 */
	public void accountIn(String toUser, String money) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			//��дsql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY + ? WHERE ACCOUNT_NAME=?";
			//������� ִ����
			st=conn.prepareStatement(sqlStr);
			//���ò��� 
			st.setString(1,money);
			st.setString(2, toUser);
			//ִ��sql
			int resultNumber=st.executeUpdate();
			//����
			System.out.println("�룺"+resultNumber);
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
			//��дsql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY - ? WHERE ACCOUNT_NAME=?";
			//������� ִ����
			st=conn.prepareStatement(sqlStr);
			//���ò��� 
			st.setString(1,money);
			st.setString(2, fromUser);
			//ִ��sql
			int resultNumber=st.executeUpdate();
			//����
			System.out.println("����"+resultNumber);
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
			//��дsql
			String sqlStr="UPDATE BANK_ACCOUNT SET MONEY=MONEY + ? WHERE ACCOUNT_NAME=?";
			//������� ִ����
			st=conn.prepareStatement(sqlStr);
			//���ò��� 
			st.setString(1,money);
			st.setString(2, toUser);
			//ִ��sql
			int resultNumber=st.executeUpdate();
			//����
			System.out.println("�룺"+resultNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeStatement(st);
		}
	}

}
