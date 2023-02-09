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
	 * 持久态的对象有自动更新数据库的能力 session的一級緩存
	 */
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// user是持久态，有自动更新数据库的能力
		System.out.println(user.getUserName());
		// 重新设置新的名称
		user.setUserName("隔壁老王");

		// 正常編寫代碼
		// session.saveOrUpdate(user);

		tr.commit();
		session.close();
	}

	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 创建对象
		User user = new User();
		user.setUserName("隔壁老王");
		try {
			user.setUserBirthday((new SimpleDateFormat("yyyy-mm-dd HH:mm:ss")).parse("2004-12-03 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUserId("34720041203");
		user.setUserMobile("134344323347");
		// 保存用户，user一級存入到session的緩存中
		Serializable id = session.save(user);
		System.out.println("id=" + id);

		// 获取对象，不会看到SQL语句
		User user2 = session.get(User.class, id);
		System.out.println(user2.getUserName());

		tr.commit();
		session.close();
	}

	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 最简单的证明，查询两次
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());

		tr.commit();
		session.close();
	}

	/**
	 * 快照机制
	 */
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 重新设置新的名称
		user.setUserName("隔壁老王");

		tr.commit();
		session.close();
	}

	/**
	 * Session.clear()--清空缓存。
	 */
	public void run5() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 最简单的证明，查询两次
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		// 清空缓存
		session.clear();

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());
		tr.commit();
		session.close();
	}

	/**
	 * Session.evict()--清除指定的对象。
	 */
	public void run6() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 最简单的证明，查询两次
		User user1 = session.get(User.class, new Long(1));
		System.out.println(user1.getUserName());

		// 清空user1对象
		session.evict(user1);

		User user2 = session.get(User.class, new Long(1));
		System.out.println(user2.getUserName());
		tr.commit();
		session.close();
	}

	/**
	 * 快照机制
	 */
	@Test
	public void run7() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 重新设置新的名称
		user.setUserName("隔壁老王");
		// 自动刷新缓存
		session.flush();

		tr.commit();
		session.close();
	}
}
