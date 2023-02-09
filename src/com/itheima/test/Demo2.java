package com.itheima.test;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

public class Demo2 {

	/**
	 * �־�̬�Ķ������Զ��������ݿ������ session��һ������
	 */
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ȡ���־�̬�Ķ���
		User user = session.get(User.class, new Long(1));
		// user�ǳ־�̬�����Զ��������ݿ������
		System.out.println(user.getUserName());
		// ���������µ�����
		user.setUserName("��������");

		// �����������a
		// session.saveOrUpdate(user);

		tr.commit();
		session.close();
	}

	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��������
		User user = new User();
		user.setUserName("��������");
		try {
			user.setUserBirthday((new SimpleDateFormat("yyyy-mm-dd HH:mm:ss")).parse("2004-12-03 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUserId("34720041203");
		user.setUserMobile("134344323347");
		// �����û���userһ�����뵽session�ľ�����
		Serializable id = session.save(user);
		System.out.println("id=" + id);

		// ��ȡ���󣬲��ῴ��SQL���
		User user2 = session.get(User.class, id);
		System.out.println(user2.getUserName());

		tr.commit();
		session.close();
	}

	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��򵥵�֤������ѯ����
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());

		tr.commit();
		session.close();
	}

	/**
	 * ���ջ���
	 */
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ȡ���־�̬�Ķ���
		User user = session.get(User.class, new Long(1));
		// ���������µ�����
		user.setUserName("��������");

		tr.commit();
		session.close();
	}

	/**
	 * Session.clear()--��ջ��档
	 */
	public void run5() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ȡ���־�̬�Ķ���
		User user = session.get(User.class, new Long(1));
		// ��򵥵�֤������ѯ����
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		// ��ջ���
		session.clear();

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());
		tr.commit();
		session.close();
	}

	/**
	 * Session.evict()--���ָ���Ķ���
	 */
	public void run6() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ȡ���־�̬�Ķ���
		User user = session.get(User.class, new Long(1));
		// ��򵥵�֤������ѯ����
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		// ���user1����
		session.evict(user1);

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());
		tr.commit();
		session.close();
	}

	/**
	 * ���ջ���
	 */
	@Test
	public void run7() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// ��ȡ���־�̬�Ķ���
		User user = session.get(User.class, new Long(1));
		// ���������µ�����
		user.setUserName("��������");
		// �Զ�ˢ�»���
		session.flush();

		tr.commit();
		session.close();
	}
}
