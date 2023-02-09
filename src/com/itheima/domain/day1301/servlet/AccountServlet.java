package com.itheima.domain.day1301.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day1301.service.AccountService4DB;

/**
 * Servlet implementation class AccountServlet
 * ת��
 */
@WebServlet("/accountServlet1301")
public class AccountServlet extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5203561877926715714L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//0.���ñ��� 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w=response.getWriter();
		//1.������������
		String fromUser=request.getParameter("fromuser");
		String toUser=request.getParameter("touser");
		Integer money= new Integer(request.getParameter("money"));
		
		//2.����accountService.account(fromuser,touser,money) ����ֵ
		try {
			//new AccountService().account(fromUser,toUser,money);
			//ʹ�õ�threadLocal��������
			//new AccountService4tl().account(fromUser,toUser,money);
			//ʹ�õ�threadLocal�������ӣ�QueryRunner
			new AccountService4DB().account(fromUser,toUser,money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			w.print("ת��ʧ�ܣ�failur");
			return;
		}
		
		//3.��ӡ��Ϣ
		w.print("ת�˳ɹ�-success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
