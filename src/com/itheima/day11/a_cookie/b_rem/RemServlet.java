package com.itheima.day11.a_cookie.b_rem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemServlet
 */
@WebServlet("/remServlet")
public class RemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.���ñ���
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// 1.��ȡָ�����Ƶ�cookie
		Cookie cookie = getCookieByName("lastTime", request.getCookies());

		// 2.�ж�cookie�Ƿ�Ϊ��
		if (cookie == null) {
			// cookieΪ�գ���ʾ��һ�η���
			pw.print("���ǵ�һ�η��ʣ�");
		} else {
			// cookieΪ�� ��ȡvalue չʾ��һ�η��ʵ�ʱ��
			String value = cookie.getValue();// lastTime=12312324234��������
			long time = Long.parseLong(value);
			Date date = new Date(time);
			pw.print("���ϴη���ʱ�䣺" + date.toLocaleString());
		}
		// 3.����ǰ���ʵ�ʱ���¼

		// 3.1����cookie
		cookie = new Cookie("lastTime", new Date().getTime() + "");
		
		//�־û�cookie
		cookie.setMaxAge(3600);
		//����·��
		cookie.setPath(request.getContextPath()+"/");
		
		// 3.2д�������
		response.addCookie(cookie);
		//request.getRequestDispatcher("/projectLearn/day11/index.jsp").
		//forward(request, response);

	}

	/**
	 * ͨ��������cookie�����ȡָ����cookie
	 * 
	 * @param name cookie����
	 * @param cookies cookie����
	 * @return
	 */
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		// TODO Auto-generated method stub
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(name.equals(cookie.getName())) {
					//����
					return cookie;
				}
			}
		}
		
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
