package com.itheima.service;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itheima.dao.UserDao;
import com.itheima.user.orm.YunhaiUser;
import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

public class UserService {
	public int regist(YunhaiUser u1) {
		UserDao dao = new UserDao();
		// �@ȡsession
		//Session session = HibernateUtils.getCurrentSession();
		// �_����
		//Transaction tr = session.beginTransaction();
		/*
		 * SessionFactory sf = new Configuration().configure().buildSessionFactory(); //
		 * ��һ��Session Session session = sf.openSession(); // ��ʼһ������ Transaction tr =
		 * session.beginTransaction();
		 */
		
		/*
		 * int result=0; try {
		 * 
		 * dao.save3(u1);
		 * 
		 * // �ύ�� tr.commit(); result=1; } catch (Exception e) { // TODO: handle
		 * exception e.printStackTrace(); //�������⣺�ع����� tr.rollback(); }finally{
		 * //�Լ��ͷ���Դ�����ڣ�session���ùرգ��߳̽����ˣ��Զ��رյģ����� }
		 */

		int result=dao.save3(u1);  
		
		return result;

	}

	public void save(User u1, User u2) {
		UserDao dao = new UserDao();
		// �@ȡsession
		Session session = HibernateUtils.getCurrentSession();
		// �_����
		Transaction tr = session.beginTransaction();

		try {

			dao.save1(u1); 
			dao.save2(u2);

			// �ύ��
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//�������⣺�ع�����
			tr.rollback();
		}finally{
			//�Լ��ͷ���Դ�����ڣ�session���ùرգ��߳̽����ˣ��Զ��رյģ�����
		}

	}

	public YunhaiUser getUserByUserNameAndPassword(String userName,String password,String serveCode) throws SQLException {
		// TODO Auto-generated method stub
		
		return new UserDao().getUserByUserNameAndPassword(userName,password,serveCode) ;
	}

}
