package com.itheima.test;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

/**
 * 测试的查询
 * 
 * @author Administrator
 *
 */
public class Demo4 {
	/**
	 * 添加查询的条件
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 查询的方式HQL from User where 属性条件
		// SQL: SELECT * FROM T_USER WHERE 條件
		Query query = session.createQuery("from User where user_name like ?");

		//设置值
		query.setString(0, "%小%");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	/**
	 * 测试Query的查询接口
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 查询的方式
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
}
