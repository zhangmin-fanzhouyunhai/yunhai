package com.itheima.domain.day14.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.service.ProductService;
import com.yunhai.util.UUIDUtils;

/**
 * 添加商品
 */
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//扩展令牌机制
		//0.1获取session中令牌和提交过来的令牌
		String rToken=request.getParameter("rToken");
		String sToken=(String) request.getSession().getAttribute("sToken");
		//0.2 移除session中的令牌
		request.getSession().removeAttribute("sToken");
		System.out.println("sToken:"+sToken);
		System.out.println("rToken:"+rToken);
		
		//0.3比较两个令牌
		if(sToken==null	|| !sToken.equals(rToken)) {
			//已经提交过了，生成错误提示信息放入request域中，跳转到msg.jsp
			request.setAttribute("msg", "商品已经保存！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//1.封装数据
		Product p=new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			//1.1设置pid
			p.setProductId(UUIDUtils.getId());
			//1.2设置时间
			p.setProductDate(new Date());
			System.out.println("productName："+p.getProductName());
			//2.调用service完成添加操作
			new ProductService().addProduct(p);
			
			//3.页面跳转	findAll		
			//先用请求转发
			request.getRequestDispatcher("/findAllProduct").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "添加商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
