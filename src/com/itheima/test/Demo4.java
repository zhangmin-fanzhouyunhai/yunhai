package com.itheima.test;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

/**
 * ���ԵĲ�ѯ
 * 
 * @author Administrator
 *
 */
public class Demo4 {
	/**
	 * ��Ӳ�ѯ������
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ѯ�ķ�ʽHQL from User where ��������
		// SQL: SELECT * FROM T_USER WHERE �l��
		Query query = session.createQuery("from User where user_name like ?");

		//����ֵ
		query.setString(0, "%С%");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	/**
	 * ����Query�Ĳ�ѯ�ӿ�
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ѯ�ķ�ʽ
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
}
