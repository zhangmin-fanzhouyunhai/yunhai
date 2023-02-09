package com.yunhai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

/**
 * Servlet implementation class ListCustomer
 */
@WebServlet("/listCustomer")
public class ListCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		//获取到客户的名称
		String custName=request.getParameter("custName");
		
		List<Customer> list=new CustomerService().queryAllCustomer(custName);
		
		//存入request
		request.setAttribute("list", list);
		//转发
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
