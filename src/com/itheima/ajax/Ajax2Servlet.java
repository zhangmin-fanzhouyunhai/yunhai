package com.itheima.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * get����
 */
@WebServlet("/getListProvince")
public class Ajax2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ajax2Servlet() {
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
		// ���ܲ���
		String username = request.getParameter("username"); 
		//username = new String(username.getBytes("iso8859-1"), "utf-8");
		System.out.println(username);
		// ��Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("������" + username);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println(request.getMethod());
		//request.setCharacterEncoding("utf-8");
		
		// ���ܲ���
		String username = request.getParameter("username");  
		//
		username = new String(username.getBytes("iso8859-1"), "utf-8");
		System.out.println(username);
		
		// ��Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("post������" + username);
		
	}

}
