package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.service.ProductService;
import com.yunhai.bean.PageBean;

import antlr.collections.List;

/**
 * 分页展示数据
 */
@WebServlet("/showProductsByPage")
public class ShowProductsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 分页展示数据
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
		// 固定每页显示的条数
		Integer oldPageSize = 5;
		Integer pageSize = 1;
		if (request.getParameter("pageSize") == null) {
			pageSize = 5;
			oldPageSize = pageSize;
			if (request.getSession().getAttribute("pageSize") == null) {
				//System.out.println("pageSize null, request.getSession().getAttribute(\"pageSize\")"
				//		+ request.getSession().getAttribute("pageSize"));
				// System.out.println("pageSize not exists! Set pageSize="+pageSize);
				request.getSession().setAttribute("pageSize", pageSize);
			}
		} else {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			oldPageSize = Integer.parseInt(request.getSession().getAttribute("pageSize").toString());
			// System.out.println("pageSize:"+pageSize);
			if (request.getSession().getAttribute("pageSize") != pageSize) {
				 //System.out.println("session pageSize:"+request.getSession().getAttribute("pageSize")+",pageSize:"+pageSize);
				request.getSession().setAttribute("pageSize", pageSize);
			}
		}
		//System.out.println("session pageSize:"+pageSize+",pageSize:"+pageSize);
		
		// 2.调用service完成分页查询 返回值：pagebean
		PageBean<Product> pageBean;
		try {
			// 如果pageSize改变后，当前页码可能会小于原来的页码数据，因此跳转至转换后的页面处，为“记录总数/新单页记录数”页。
			//且前面的记录页面与单页记录数乘积，除以新的单页显示数量得到的页面大于0，则修改当前的页面currentPage.
			if ((currentPage > Math.ceil(currentPage * oldPageSize / pageSize))&&
					(Math.ceil(currentPage * oldPageSize / pageSize)>0)) {
				currentPage = (int) Math.ceil((currentPage * oldPageSize) / pageSize);
				//System.out.println("if currentPage:"+currentPage);
				pageBean = new ProductService().showProductsByPage(currentPage, pageSize,oldPageSize);
				
			} else {
				pageBean = new ProductService().showProductsByPage(currentPage, pageSize,oldPageSize);
				//System.out.println("currentPage:"+currentPage);
			}
			ArrayList<Integer> pageNumberList = new ArrayList<Integer>();
			for (int i = 1; i <= pageBean.getTotalPageCount(); i++) {
				pageNumberList.add(i);
			}
			
			// 3.将pagebean放入request域中，请求转发productPage.jsp
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("pageNumberList", pageNumberList);
			request.getRequestDispatcher("/studyEachDay/day14/productPage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "数据查询失败");
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
