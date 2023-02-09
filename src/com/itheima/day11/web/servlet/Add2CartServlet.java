package com.itheima.day11.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加商品到购物车
 * Servlet implementation class Add2CartServlet
 */
@WebServlet("/add2CartServlet")
public class Add2CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//1.获取商品的名称
		String name=request.getParameter("name");
		System.out.println("quantity="+request.getParameter("quantity"));
		int productQuantity=new Integer( request.getParameter("quantity"));
		//name=new String(name.getBytes("iso-8859-1"),"utf-8");
		
		//2.将商品添加到购物车
		//2.1从session中获取购物车
		Map<String,Integer>map=(Map<String, Integer>) request.getSession().getAttribute("cart");
		
		Integer count=null;
		//2.2判断购物车是否为空
		if(map==null) {
			//第一次购物，创建购物车
			map=new HashMap<String, Integer>();
			//将购物车放入session中去
			count=productQuantity; 
			request.getSession().setAttribute("cart", map);;
		}else {
			//购物车不为空，继续判断购物车中是否有该商品
			count=map.get(name);
			if(count==null) {
				//购物车中没有该商品
				count=productQuantity;
			}else {
				//购物车中有该商品
				count=count+productQuantity;
			}
		}
		
		//将商品放入购物车中
		map.put(name, count);
		
		//3.提示信息
		PrintWriter pw=response.getWriter();
		pw.print("已经 将<b>"+name+"</b>添加到购物车中<hr>");
		pw.print("<a href='"+request.getContextPath()+"/projectLearn/day11/product_list.jsp'>继续购物</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.print("<a href='"+request.getContextPath()+"/projectLearn/day11/cart.jsp'>查看购物</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
