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
		// 1.获取指定的cookie ids
		Cookie cookie  = new Cookie("ids", "");
		// 设置访问路径
		cookie.setPath(request.getContextPath() + "/");
		// 设置存活时间
		cookie.setMaxAge(0);
		// 写回浏览器
		response.addCookie(cookie);
		// 3.跳转到指定的商品页面上
		response.sendRedirect(request.getContextPath() + "/projectLearn/day11/product_list.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
