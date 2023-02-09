package com.yunhai.util;

import org.hibernate.Session;

public class CommenHibernateUtil {

	public static Session getSession(String dataSourceType) {
		Session session = null;
		//System.out.println("dataSourceType="+dataSourceType);
		switch (dataSourceType) {
		case "100000000":
			session = HibernateMySQLUtils.getSession();
			break;
		case "100000001":
			session = HibernateUtils.getSession();
			break;
		default:
			session = null;
		}
		/*
		 * if(dataSourceType.contentEquals("100000000")) session =
		 * HibernateMySQLUtils.getSession(); else session=HibernateUtils.getSession();
		 */
		return session;
	}

	/**
	 * //��ThreadLocal���л�ȡ��session�Ķ���
	 * 
	 * @return
	 */
	public static Session getCurrentSession(String dataSourceType) {

		// ��ThreadLocal���л�ȡ��session�Č���
		Session session = null;
		switch (dataSourceType) {
		case "100000000":
			session = HibernateMySQLUtils.getCurrentSession();
			break;
		case "100000001":
			session = HibernateUtils.getCurrentSession();
			break;
		default:
			session = null;
		}
		/*
		 * if(dataSourceType.contentEquals("100000000")) session =
		 * HibernateMySQLUtils.getCurrentSession(); else
		 * session=HibernateUtils.getCurrentSession();
		 */
		return session;
	}
}
