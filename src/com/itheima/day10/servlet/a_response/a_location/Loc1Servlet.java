package com.itheima.day10.servlet.a_response.a_location;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ض���
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


		System.out.println("��˵��û��Ǯ......");
		System.out.println("��Ի���Һ���ʦ");
		
		//��ʽ1�����,��Ҫ����
		//����1������״̬�� 302
		//response.setStatus(302);
		//����2��������Ӧͷ
		//response.setHeader("location", "/Day29/loc2Servlet");
		
		//��ʽ2������
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
