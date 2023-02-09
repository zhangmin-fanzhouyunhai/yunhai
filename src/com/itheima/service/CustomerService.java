package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerService {
	/**
	 * 保存客户
	 * 
	 * @param c
	 */
	public void saveCustomer(Customer c) {
		new CustomerDao().save(c);
	}
	
	/**
	 * 查询所有的用户
	 */

	public List<Customer>  queryAllCustomer() {
		//List<Customer> customerList=new CustomerDao().query();
		//return customerList;
		return new CustomerDao().query();
	}

	/**
	 * 按条件查询数据
	 */

	public List<Customer>  queryAllCustomer(String custName) {
		//List<Customer> customerList=new CustomerDao().query();
		//return customerList;
		return new CustomerDao().query(custName);
	}
	
	
}
