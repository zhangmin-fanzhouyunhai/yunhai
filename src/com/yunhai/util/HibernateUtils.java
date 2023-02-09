package com.yunhai.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// ctrl+shift+X
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY; 

	// ��д��̬�����
	static { 
		// ����XML�������ļ�
		CONFIG = new Configuration().configure();
		// System.out.println("Inside Here");

		// ���칤��
		
		FACTORY = CONFIG.buildSessionFactory();  
	}

	/**
	 * �ӹ����л�ȡSession����
	 * 
	 * @return
	 */
	public static Session getSession() { 
		return FACTORY.openSession();
	}

	/**
	 * //��ThreadLocal���л�ȡ��session�Ķ���
	 * 
	 * @return
	 */
	public static Session getCurrentSession() {
		// ��ThreadLocal���л�ȡ��session�Č���
		return FACTORY.getCurrentSession();
	}

	/*
	 * public static void main(String[] arg) { // ���û�ȡ session getSession(); }
	 */
}
