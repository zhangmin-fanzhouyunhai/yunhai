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
 * Servlet implementation class DeleteProductByIdServlet
 */
@WebServlet("/deleteProductByIdServlet")
public class DeleteProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取商品productId
		String productId=request.getParameter("productId");
		//调用service完成删除操作
		try {
			new ProductService().deleteProductById(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "商品删除失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		//3.重定向findAllProduct
		response.sendRedirect(request.getContextPath()+"/findAllProduct"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
