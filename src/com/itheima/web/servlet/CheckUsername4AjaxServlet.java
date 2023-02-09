package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.YUNHAIUserDao;
import com.itheima.service.UserService;
import com.itheima.service.YUNHAIUserService;
import com.itheima.user.orm.YunhaiUser;

public class CheckUsername4AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0.���ñ���

		// 1.�����û���
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"));
		//System.out.println(username);

		// 2.����service��ɲ�ѯ ����ֵuser
		YunhaiUser user = null;
		try {
			user = new YUNHAIUserService().checkUsername4Ajax(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.�ж�user д����Ϣ
		if (user == null) {
			response.getWriter().println("1");
		} else {
			response.getWriter().println("0");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
