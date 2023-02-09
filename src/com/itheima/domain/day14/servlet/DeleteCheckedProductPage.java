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
 * 删除数据后，以页面的形式展现数据
 */
@WebServlet("/deleteCheckedProductPage")
public class DeleteCheckedProductPage extends HttpServlet {
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
		String[] productIds = request.getParameterValues("productId");
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
		// System.out.println("currentPage"+currentPage);
		if (productIds.length != 0 || productIds != null) {
			// 调用Service完成多个product的删除
			try {
				new ProductService().deleteCheckedProduct(productIds);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "商品删除失败");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		} else {
			System.out.println("未选中记录！");
		}
		// 3.页面重定向 findAllProduct
		response.sendRedirect(
				request.getContextPath() + "/showProductsByPage?currentPage=" + currentPage + "&pageSize=" + pageSize);
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
