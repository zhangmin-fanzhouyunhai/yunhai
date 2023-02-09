package com.itheima.domain.day15.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day15.service.KeyWordService;

/**
 * ģ�°ٶ� ģ��
 */
@WebServlet("/searchKwServlet")
public class SearchKwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.���ñ���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		// 1.��ȡkw
		String keyword = request.getParameter("keyword");

		// 2.����service���ģ������ ����ֵ:list
		List<Object> list = null;
		try {
			list = new KeyWordService().findKw4Ajax(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.������ [a,aa,aaa] ȥ������ д��ȥ a,aaa,aa
		if (list != null && list.size() > 0) {
			String s = list.toString();
			s = s.substring(1, s.length() - 1);
			System.out.println(s);
			response.getWriter().println(s);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
