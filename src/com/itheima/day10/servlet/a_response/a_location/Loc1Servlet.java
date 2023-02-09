package com.itheima.day10.servlet.a_response.a_location;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 * Servlet implementation class Loc1Servlet
 */
@WebServlet("/loc1Servlet")
public class Loc1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		System.out.println("我说：没零钱......");
		System.out.println("又曰：找候老师");
		
		//方式1：理解,需要两步
		//步骤1，设置状态码 302
		//response.setStatus(302);
		//步骤2，设置响应头
		//response.setHeader("location", "/Day29/loc2Servlet");
		
		//方式2：掌握
		response.sendRedirect("/Day29/loc2Servlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
