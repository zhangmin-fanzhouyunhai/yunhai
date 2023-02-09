package com.itheima.day11.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.day11.utils.CookUtils;

/**
 * Servlet implementation class ClearHistroyServlet
 */
@WebServlet("/clearHistroyServlet")
public class ClearHistroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.��ȡָ����cookie ids
		Cookie cookie  = new Cookie("ids", "");
		// ���÷���·��
		cookie.setPath(request.getContextPath() + "/");
		// ���ô��ʱ��
		cookie.setMaxAge(0);
		// д�������
		response.addCookie(cookie);
		// 3.��ת��ָ������Ʒҳ����
		response.sendRedirect(request.getContextPath() + "/projectLearn/day11/product_list.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
