package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerService {
	/**
	 * ����ͻ�
	 * 
	 * @param c
	 */
	public void saveCustomer(Customer c) {
		new CustomerDao().save(c);
	}
	
	/**
	 * ��ѯ���е��û�
	 */

	public List<Customer>  queryAllCustomer() {
		//List<Customer> customerList=new CustomerDao().query();
		//return customerList;
		return new CustomerDao().query();
	}

	/**
	 * ��������ѯ����
	 */

	public List<Customer>  queryAllCustomer(String custName) {
		//List<Customer> customerList=new CustomerDao().query();
		//return customerList;
		return new CustomerDao().query(custName);
	}
	
	
}
