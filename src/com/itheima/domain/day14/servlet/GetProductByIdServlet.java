package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.service.ProductService;

/**
 * 通过商品id获取商品 Servlet implementation class GetProductByIdServlet
 */
@WebServlet("/getProductByIdServlet")
public class GetProductByIdServlet extends HttpServlet {
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
		response.setContentType("text/heml;charset=utf-8");
		// 1.获取商品pid
		String productId = request.getParameter("productId");
		// 2.调用service 通过id获取商品 返回值 product
		Product product = null;
		try {
			product = new ProductService().getProductById(productId);
			//System.out.println("product.productId:"+product.getProductId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.将product放入request域中，请求转发到edit.jsp
		request.setAttribute("bean", product);
		request.getRequestDispatcher("/studyEachDay/day14/editProduct.jsp").forward(request, response);

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
