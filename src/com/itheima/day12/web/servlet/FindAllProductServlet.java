package com.itheima.day12.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.user.orm.Product;
import com.itheima.day12.service.ProductService;

/**
 * չʾ������Ʒ Servlet implementation class FindAllProductServlet
 */
@WebServlet("/findAllProduct")
public class FindAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.����service����list
			List<Product> productList = null;
			try {
				productList = new ProductService().findAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//2.��list����request����
			request.setAttribute("productList", productList);
		//����ת�� 
		//request.getRequestDispatcher("./projectLearn/day12/productList.jsp").forward(request, response);
		request.getRequestDispatcher("./showProductsByPage?currentPage=1").forward(request, response);
		
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
