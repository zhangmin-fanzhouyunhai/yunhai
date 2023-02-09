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
 * ͨ����Ʒid��ȡ��Ʒ Servlet implementation class GetProductByIdServlet
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
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/heml;charset=utf-8");
		// 1.��ȡ��Ʒpid
		String productId = request.getParameter("productId");
		// 2.����service ͨ��id��ȡ��Ʒ ����ֵ product
		Product product = null;
		try {
			product = new ProductService().getProductById(productId);
			//System.out.println("product.productId:"+product.getProductId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.��product����request���У�����ת����edit.jsp
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
