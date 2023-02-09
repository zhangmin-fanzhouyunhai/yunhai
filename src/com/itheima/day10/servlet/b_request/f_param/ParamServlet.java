package com.itheima.day10.servlet.b_request.f_param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 * 获取请求参数
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/paramServlet" })
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取username
		String username=request.getParameter("username");
		System.out.println("username:"+username);
		//获取爱好 多个值
		String[] hobby=request.getParameterValues("hobby");
		System.out.println("hobby"+Arrays.toString(hobby));
		
		//获取所有
		System.out.println("=========================");
		Map<String,String[]> map=request.getParameterMap();
		
		for (String key : map.keySet()) {
			System.out.println(key+":"+Arrays.toString(map.get(key)));
		}

		request.getRequestDispatcher("/projectLearn/day10/code.html").
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
