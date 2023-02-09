package com.itheima.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

public class Demo3 {
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 重新设置新的名称
		user.setUserName("隔壁老王"); 
		tr.commit();
		session.close();
	}
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 获取到持久态的对象
		User user = session.get(User.class, new Long(1));
		// 重新设置新的生日
		try {
			user.setUserBirthday((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2005-12-11 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		session.save(user);
		tr.commit();
		session.close();
	}
}
