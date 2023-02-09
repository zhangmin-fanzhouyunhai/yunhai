package com.itheima.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.yunhai.util.HibernateUtils;

public class CustomerDao {
	/**
	 * ����͑�
	 * 
	 * @param c
	 */
	public void save(Customer c) {
		// �ȫ@ȡsession
		Session session = HibernateUtils.getSession();
		// ��������
		Transaction tr = session.beginTransaction();
		// �����û�
		session.save(c);
		// �ύ����
		tr.commit();
		// �ر���Դ
		session.close();
	}

	/**
	 * ��ѯ����
	 */
	public List<Customer> query() {
		// �ȫ@ȡsession
		Session session = HibernateUtils.getSession();
		// ��������
		Transaction tr = session.beginTransaction();
		// ��ѯ
		// Criteria criteria=session.createCriteria(Customer.class);
		// List<Customer> list=criteria.list();
		// ��ѯ
		List<Customer> list = session.createQuery("from Customer").list();
		tr.commit();
		session.close();
		return list;
	}

	/**
	 * �����Ʋ�ѯ����
	 */
	public List<Customer> query(String custName) {
		// �ȫ@ȡsession
		Session session = HibernateUtils.getSession();
		// ��������
		Transaction tr = session.beginTransaction();
		// ��ѯ
		Criteria criteria = session.createCriteria(Customer.class);
		if (custName != null && !custName.trim().isEmpty()) {
			criteria.add(Restrictions.ilike("custName", "%" + custName + "%"));
		}
		List<Customer> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}
}
