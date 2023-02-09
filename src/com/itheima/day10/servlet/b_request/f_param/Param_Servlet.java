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
		//设置编码,方案二：此方案主要针对post可用
		request.setCharacterEncoding("utf-8");
		
		// 获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//以下为方案一：
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
