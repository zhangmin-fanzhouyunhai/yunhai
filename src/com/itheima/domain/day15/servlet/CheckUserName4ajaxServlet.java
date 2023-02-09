package com.itheima.domain.day15.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.day15.domain.User;
import com.itheima.domain.day15.service.UserService;

/**
 * 原生ajax检测用户名是否被占用
 */
@WebServlet("/checkUsername4Ajax15")
public class CheckUserName4ajaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1.接受用户名

		String username = request.getParameter("username");
		// username=new String(username.getBytes("iso-8859-1"),"utf-8");

		System.out.println("username=" + username);
		// 2.调用service 完成查询 返回值 user
		User user=null;
		try {
			user = new UserService().checkUsername4Ajax(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.判断 user 写回信息
		if(user==null) {
			//不存在时，报出1
			response.getWriter().println("1");
		}else {
			//存在时，报出0
			response.getWriter().println("0");
		}

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
