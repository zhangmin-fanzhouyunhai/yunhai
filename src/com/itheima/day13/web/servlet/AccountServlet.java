package com.itheima.day13.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.day13.service.AccountService4tl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/accountServlet13")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ת��
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset-utf-8");
		//PrintWriter w=response.getWriter();
		//1.������������
		String fromUser=request.getParameter("fromUser");
		String toUser=request.getParameter("toUser");
		String money=request.getParameter("money");
		System.out.println("fromUser="+fromUser+",toUser="+toUser+",money="+money);
		//2.����accountService.account(fromUser,toUser,money)
		try {
			//new AccountService().account(fromUser,toUser, money);
			new AccountService4tl().account(fromUser,toUser, money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//w.print("ת��ʧ��");
			request.getRequestDispatcher("/projectLearn/day13/account.jsp").forward(request, response);
			return;
		}
		
		//3.��ӡ��Ϣ
		//w.print("ת�˳ɹ�");
		//ת��
		request.getRequestDispatcher("/projectLearn/day13/account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
