package com.itheima.day10.servlet.b_request.d_row;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RowServlet
 */
@WebServlet("/rowServlet")
public class RowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//��ȡ����ʽ
		String m=request.getMethod();
		System.out.println("��ʽ��"+m);
		
		//��ȡ������Դ
		String uri=request.getRequestURI();
		String url=request.getRequestURL().toString();
		System.out.println("uri:"+uri);
		System.out.println("url:"+url);
		//��ȡ����������ַ���
		String s=request.getQueryString();
		System.out.println("s:"+s);
		
		//��ȡЭ��汾
		String protocol=request.getProtocol();
		System.out.println("protocol:"+protocol);
		System.out.println("-------��Ҫ��--------");
		
		//��ȡ�����IP
		String ipAddr=request.getRemoteAddr();
		System.out.println("ipAddr:"+ipAddr);
		//��ȡ��Ŀ��
		String path=request.getContextPath();
		System.out.println("��Ŀ·����"+path);
		request.getRequestDispatcher("/projectLearn/day10/index.html").
		forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
