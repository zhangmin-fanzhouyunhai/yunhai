package com.yunhai.c_life;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet("/life")
@MultipartConfig
public class LifeServlet implements Servlet {

	/**
	 * 初始化方法
	 * 执行者：服务器
	 * 执行次数：一次
	 * 执行时机：默认第一次访问的时候
	 * 
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("5555555555555555555");
	}

	/**
	 * 服务
	 * 执行者：服务器
	 * 执行次数：请求一次执行一次
	 * 执行时机：请求来的时候
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("6666666666666666666");
	}

	/**
	 * 销毁
	 * 执行者：服务器
	 * 执行次数：只执行一次
	 * 执行时机：当servlet该移除时候或者服务器正常关闭的时候
	 */ 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("4444444444444444");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}



}
