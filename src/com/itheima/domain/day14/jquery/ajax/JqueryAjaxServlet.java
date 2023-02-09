package com.itheima.domain.day14.jquery.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jquery的ajax
 */
@WebServlet("/jqueryAjaxServlet")
public class JqueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("请求方式:"+request.getMethod());
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		//接受参数
		String username=request.getParameter("username");
		System.out.println("用户名称："+username);
		//响应数据
		response.getWriter().print("success");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("请求方式:"+request.getMethod());
				//设置字符集
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8"); 
				//接受参数
				String username=request.getParameter("username");
				//username=new String(username.getBytes("iso-8859-1"),"utf-8");
				//{"result":"success","msg":"响应成功"}
				String s="{\"result\":\"success\",\"msg\":\"响应成功\"}";
				System.out.println("用户名称："+username);
				
				//响应数据
				response.getWriter().print(s);
	}

}
