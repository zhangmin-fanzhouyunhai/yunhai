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
 * 转账
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

		//0.设置编码 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w=response.getWriter();
		//1.接受三个参数
		String fromUser=request.getParameter("fromuser");
		String toUser=request.getParameter("touser");
		Integer money= new Integer(request.getParameter("money"));
		
		//2.调用accountService.account(fromuser,touser,money) 返回值
		try {
			//new AccountService().account(fromUser,toUser,money);
			//使用的threadLocal进行连接
			//new AccountService4tl().account(fromUser,toUser,money);
			//使用的threadLocal进行连接，QueryRunner
			new AccountService4DB().account(fromUser,toUser,money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			w.print("转账失败－failur");
			return;
		}
		
		//3.打印信息
		w.print("转账成功-success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
