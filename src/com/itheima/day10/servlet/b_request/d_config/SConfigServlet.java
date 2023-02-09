package com.itheima.day10.servlet.b_request.d_config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SConfigServlet
 */
@WebServlet(value = "/msconfigServlet", initParams = { @WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "password", value = "1234") },loadOnStartup=1)
public class SConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.获取servletConfig
		ServletConfig servletConfig = getServletConfig();
		// 获取当前servlet的名称
		String servletName = servletConfig.getServletName();
		System.out.println("servlet名称：" + servletName);

		// 获取初始化参数
		String user = servletConfig.getInitParameter("user");
		System.out.println("获取单一的值，user=" + user);
		System.out.println("------------------------------------");
		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

		while (initParameterNames.hasMoreElements()) {
			String parameterName = initParameterNames.nextElement();
			System.out.println("参数名称：" + parameterName + ",值为" + servletConfig.getInitParameter(parameterName));
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
