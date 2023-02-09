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
 * ԭ��ajax����û����Ƿ�ռ��
 */
@WebServlet("/checkUsername4Ajax15")
public class CheckUserName4ajaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1.�����û���

		String username = request.getParameter("username");
		// username=new String(username.getBytes("iso-8859-1"),"utf-8");

		System.out.println("username=" + username);
		// 2.����service ��ɲ�ѯ ����ֵ user
		User user=null;
		try {
			user = new UserService().checkUsername4Ajax(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.�ж� user д����Ϣ
		if(user==null) {
			//������ʱ������1
			response.getWriter().println("1");
		}else {
			//����ʱ������0
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
