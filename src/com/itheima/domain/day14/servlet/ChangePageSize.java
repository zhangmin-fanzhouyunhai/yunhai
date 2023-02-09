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
import com.yunhai.bean.PageBean;

/**
 * Servlet implementation class ChangePageSize
 */
@WebServlet("/changePageSize")
public class ChangePageSize extends HttpServlet {
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
		// 1.获取第几页
		// System.out.println("request.getParameter(\"currentPage\"):"+request.getParameter("currentPage"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int sessionPageSize = Integer.parseInt(request.getSession().getAttribute("pageSize").toString());
		if(Math.ceil((currentPage * sessionPageSize) / pageSize)<=0) {
			currentPage = 1;
		}else {
			currentPage = (int) Math.ceil((currentPage * sessionPageSize) / pageSize);
		} 
		// 2.调用service完成分页查询 返回值：pagebean
		PageBean<Product> pageBean;
		try {
			pageBean = new ProductService().ChangePageSize(currentPage, pageSize,sessionPageSize); 
			request.getSession().setAttribute("pageSize", pageSize);
			//System.out.println("pageSize="+pageSize+",currentPage:"+currentPage);
			response.sendRedirect(request.getContextPath() + "/showProductsByPage?currentPage=" + pageBean.getCurrentPage()
					+ "&pageSize=" + pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
