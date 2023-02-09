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
 * 展示所有商品
 * Servlet implementation class ProductServlet
 */
@WebServlet("/findAllProduct14")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/heml;charset=utf-8");
		//1.调用service 查询所有商品 返回值list
		List<Product> plist=null;
		try {
			plist = new ProductService().findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.将 list 放入 request 域中，
		request.setAttribute("list", plist);
		/*
		 * System.out.println("plist.size():"+plist.size()); for(int i=0 ;i<plist.size()
		 * ;i++) { System.out.println("plist.get("+i+").getProductId()="+plist.get(i).
		 * getProductId());
		 * System.out.println("plist.get("+i+").getProductName()="+plist.get(i).
		 * getProductName()); }
		 */
		//3.请求转发
		request.getRequestDispatcher("/studyEachDay/day14/productPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
