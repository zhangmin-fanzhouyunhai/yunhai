package com.itheima.day10.servlet.b_request.e_header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/headerServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ������ں�
		String agent=request.getHeader("user-agent");
		System.out.println("agent="+agent);
		//��ȡreferer
		String referer=request.getHeader("referer");
		if(referer==null) {
			System.out.println("ֱ���ڵ�ַ���������");
		}else if(referer.contains("localhost")) {
			System.out.println("���Լ���");
		}else if(referer.contains("192.168.")) {
			System.out.println("���Ƕ����Ƕ����");
		}else {
			System.out.println("�����߿ɳ�");
		}
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
