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
	 * 保存客戶
	 * 
	 * @param c
	 */
	public void save(Customer c) {
		// 先獲取session
		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 保存用户
		session.save(c);
		// 提交事务
		tr.commit();
		// 关闭资源
		session.close();
	}

	/**
	 * 查询数据
	 */
	public List<Customer> query() {
		// 先獲取session
		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 查询
		// Criteria criteria=session.createCriteria(Customer.class);
		// List<Customer> list=criteria.list();
		// 查询
		List<Customer> list = session.createQuery("from Customer").list();
		tr.commit();
		session.close();
		return list;
	}

	/**
	 * 按名称查询数据
	 */
	public List<Customer> query(String custName) {
		// 先獲取session
		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 查询
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
