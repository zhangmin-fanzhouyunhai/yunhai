package com.yunhai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

/**
 * 添加客户的控制器 Servlet implementation class SaveCustomer
 */
//@WebServlet("/customerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * 
	 */
	public CustomerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 
		// 封闭数据，使用BeanUtils工具，导入jar包
		Customer c = new Customer();
		try { 
			// 調用業務層
			new CustomerService().queryAllCustomer();
			System.out.println("添加客户成功！");  
			request.getRequestDispatcher("./jsp/customer/add.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
