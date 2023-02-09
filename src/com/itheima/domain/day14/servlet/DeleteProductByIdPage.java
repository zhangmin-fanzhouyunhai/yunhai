package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day14.service.ProductService;

/**
 * Servlet implementation class DeleteProductByIdPage
 */
@WebServlet("/deleteProductByIdPage")
public class DeleteProductByIdPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.获取商品productId
		String productId = request.getParameter("productId");
		// 获取第几页
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));

		// 固定每页显示的条数
		Integer oldPageSize = 5;
		Integer pageSize = 1;
		if (request.getParameter("pageSize") == null) {
			pageSize = 5;
			oldPageSize = pageSize;
			if (request.getSession().getAttribute("pageSize") == null) {
				request.getSession().setAttribute("pageSize", pageSize);
			}
		} else {
			pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			oldPageSize = Integer.parseInt(request.getSession().getAttribute("pageSize").toString());
			if (request.getSession().getAttribute("pageSize") != pageSize) {
				request.getSession().setAttribute("pageSize", pageSize);
			}
		}
		// 如果pageSize改变后，当前页码可能会小于原来的页码数据，因此跳转至转换后的页面处，为“记录总数/新单页记录数”页。
		if (currentPage != Math.ceil(currentPage * oldPageSize / pageSize)) {
			currentPage = (int) Math.ceil(currentPage * oldPageSize / pageSize);
		}
		// 调用service完成删除操作
		try {
			new ProductService().deleteProductById(productId);
			// 3.重定向findAllProduct
			response.sendRedirect(request.getContextPath() + "/showProductsByPage?currentPage=" + currentPage
					+ "&pageSize=" + pageSize);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "商品删除失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
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
