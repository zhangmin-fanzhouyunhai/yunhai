package com.itheima.day10.servlet.b_request.f_param;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Param_Servlet
 */
@WebServlet("/param_Servlet")
public class Param_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ñ���,���������˷�����Ҫ���post����
		request.setCharacterEncoding("utf-8");
		
		// ��ȡ�û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����Ϊ����һ��
		/*
		 *username=new String(username.getBytes("iso-8859-1"),"utf-8");
		 *password=new String(password.getBytes("iso-8859-1"),"utf-8");
		 */
		System.out.println("username:"+username);
		System.out.println("password:"+password); 
		request.getRequestDispatcher("/projectLearn/day10/form.html").
		forward(request, response);
	}

}
