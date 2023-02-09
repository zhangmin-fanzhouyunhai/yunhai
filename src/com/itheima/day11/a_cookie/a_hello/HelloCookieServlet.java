package com.itheima.day11.a_cookie.a_hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloCookieServlet
 */
@WebServlet("/helloCookieServlet")
public class HelloCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ñ���
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		//����һ��cookie
		Cookie cookie=new Cookie("akey","avalue");
		//д�������
		response.addCookie(cookie);

		//�������cookie 
		Cookie cookie2=new Cookie("key2","value2");
		Cookie cookie3=new Cookie("key3","value3");
		//д�������
		response.addCookie(cookie);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		//��ʾ��Ϣ
		String html="<A class=style2 href='/Day29/projectLearn/day11/index.jsp' target=main>����</A><br>";
		pw.println(html);
		pw.print("cookie �Ѿ�д��");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
