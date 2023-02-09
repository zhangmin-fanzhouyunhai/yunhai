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
		// 0.设置编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// 1.获取指定名称的cookie
		Cookie cookie = getCookieByName("lastTime", request.getCookies());

		// 2.判断cookie是否为空
		if (cookie == null) {
			// cookie为空，提示第一次访问
			pw.print("您是第一次访问！");
		} else {
			// cookie为空 获取value 展示上一次访问的时间
			String value = cookie.getValue();// lastTime=12312324234，长整形
			long time = Long.parseLong(value);
			Date date = new Date(time);
			pw.print("您上次访问时间：" + date.toLocaleString());
		}
		// 3.将当前访问的时间记录

		// 3.1创建cookie
		cookie = new Cookie("lastTime", new Date().getTime() + "");
		
		//持久化cookie
		cookie.setMaxAge(3600);
		//设置路径
		cookie.setPath(request.getContextPath()+"/");
		
		// 3.2写回浏览器
		response.addCookie(cookie);
		//request.getRequestDispatcher("/projectLearn/day11/index.jsp").
		//forward(request, response);

	}

	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * 
	 * @param name cookie名称
	 * @param cookies cookie数组
	 * @return
	 */
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		// TODO Auto-generated method stub
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(name.equals(cookie.getName())) {
					//返回
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
