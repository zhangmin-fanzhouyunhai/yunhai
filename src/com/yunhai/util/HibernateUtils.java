package com.yunhai.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// ctrl+shift+X
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY; 

	// 编写表态代码块
	static { 
		// 加载XML的配置文件
		CONFIG = new Configuration().configure();
		// System.out.println("Inside Here");

		// 构造工厂
		
		FACTORY = CONFIG.buildSessionFactory();  
	}

	/**
	 * 从工厂中获取Session对象
	 * 
	 * @return
	 */
	public static Session getSession() { 
		return FACTORY.openSession();
	}

	/**
	 * //从ThreadLocal类中获取到session的对象
	 * 
	 * @return
	 */
	public static Session getCurrentSession() {
		// 从ThreadLocal类中获取到session的對象
		return FACTORY.getCurrentSession();
	}

	/*
	 * public static void main(String[] arg) { // 调用获取 session getSession(); }
	 */
}
