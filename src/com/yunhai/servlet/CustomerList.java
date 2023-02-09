package com.yunhai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

/**
 * ��ӿͻ��Ŀ����� Servlet implementation class SaveCustomer
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
		// ������ݣ�ʹ��BeanUtils���ߣ�����jar��
		Customer c = new Customer();
		try { 
			// �{�ØI�Ռ�
			new CustomerService().queryAllCustomer();
			System.out.println("��ӿͻ��ɹ���");  
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
