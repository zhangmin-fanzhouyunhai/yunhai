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
	 * ��ʼ������
	 * ִ���ߣ�������
	 * ִ�д�����һ��
	 * ִ��ʱ����Ĭ�ϵ�һ�η��ʵ�ʱ��
	 * 
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("5555555555555555555");
	}

	/**
	 * ����
	 * ִ���ߣ�������
	 * ִ�д���������һ��ִ��һ��
	 * ִ��ʱ������������ʱ��
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("6666666666666666666");
	}

	/**
	 * ����
	 * ִ���ߣ�������
	 * ִ�д�����ִֻ��һ��
	 * ִ��ʱ������servlet���Ƴ�ʱ����߷����������رյ�ʱ��
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
