package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/msg")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.���ñ���
		response.setContentType("text/html);charset=utf-8");
		
		//1.��request���л�ȡ����msg
		String s=(String) request.getAttribute("msg");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//2.����Ϣ��ӡ��ҳ����
		//response.getWriter().print(s);
		request.getRequestDispatcher("/projectLearn/day10/register.html").
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
