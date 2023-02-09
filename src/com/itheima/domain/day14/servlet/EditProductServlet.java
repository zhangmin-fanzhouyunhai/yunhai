package com.itheima.domain.day14.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils; 

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.service.ProductService; 

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		//1.封装数据
		Product product=new Product();
		//System.out.println("I'm get in here!");
		try {
			BeanUtils.populate(product, request.getParameterMap());
			//2.调用service 完成更新
			new ProductService().updateProduct(product);
			//3.重定向FindAllServlet
			response.sendRedirect(request.getContextPath()+"/findAllProduct");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "保存报错");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
