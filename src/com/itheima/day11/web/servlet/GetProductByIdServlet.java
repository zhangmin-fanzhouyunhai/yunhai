package com.itheima.day11.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.day11.utils.CookUtils;

/**
 * 记录商品浏览器历史
 * Servlet implementation class GetProductByIdServlet
 */
@WebServlet("/getProductById")
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//0.1获取当前访问的商品id
		String id=request.getParameter("id");
		//1.获取指定的cookie ids 
		Cookie cookie=CookUtils.getCookieByName("ids", request.getCookies());
		String ids="";
		//2.判断cookie是否为空
		if(cookie==null) {
			//若cookie为空，需要将当前商品id放入ids中
			ids=id; 
		}else {
			//若cookie不为空,继续判断ids中是否已经该id  //ids=2-11-21
			//获取值
			ids=cookie.getValue();
			String[] arr=ids.split("-");
			//将数组转换成集合,此list长度不可变
			List<String> asList=Arrays.asList(arr);
			//将aslist放入一个新list中
			LinkedList<String> list=new LinkedList<>(asList);
			
			if(list.contains(id)) {
				//若ids中包含id	将id移除	放到最前面
				list.remove(id);
				list.addFirst(id);
			}else {
				//若ids中不包含id	继续判断长度是否大于2
				if(list.size()>2) {
					//长度>=3，移除最后一个将当前的放入最前面
					list.removeLast();
					list.addFirst(id);
				}else {
					//长度<3,将当前往往最前面
					list.addFirst(id);
				}
			}
			ids="";
			//将list转成字符串
			for(String s:list) {
				ids+=(s+"-");
			}
			ids= ids.substring(0, ids.length()-1);
		}
		
		//将ids写回去
		//cookie=new Cookie("ids",ids);
		//cookie=new Cookie("ids",ids.substring(0,ids.length()-1));
		cookie=new Cookie("ids",ids);
		//设置访问路径
		cookie.setPath(request.getContextPath()+"/");
		//设置存活时间
		cookie.setMaxAge(3600);
		//写回浏览器
		response.addCookie(cookie);
		
		//若cookie为空
		//若cookie不为空
		
		//3.跳转到指定的商品页面上
		response.sendRedirect(request.getContextPath()+"/projectLearn/day11/product_info"+id+".html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
