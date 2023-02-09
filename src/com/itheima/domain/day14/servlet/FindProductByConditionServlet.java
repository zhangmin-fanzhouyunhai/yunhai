package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.service.ProductService;

/**
 * ��������ѯ
 */
@WebServlet("/findProductByConditionServlet")
public class FindProductByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.������������
		String name = request.getParameter("name");
		String keyword = request.getParameter("keyword");
		// 2.����service ��ɲ��� ����ֵ�� list
		List<Product> productList=null;
		int methodType=1;
		try {
			productList = new ProductService().findProductByCondition(name, keyword,methodType);
			request.setAttribute("list", productList);
			request.getRequestDispatcher("/studyEachDay/day14/productList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "���汨��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		// 3.��list����request���У�����ת��
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
