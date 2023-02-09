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
 * �����Ʒ�����ﳵ
 * Servlet implementation class Add2CartServlet
 */
@WebServlet("/add2CartServlet")
public class Add2CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//0.���ñ���
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//1.��ȡ��Ʒ������
		String name=request.getParameter("name");
		System.out.println("quantity="+request.getParameter("quantity"));
		int productQuantity=new Integer( request.getParameter("quantity"));
		//name=new String(name.getBytes("iso-8859-1"),"utf-8");
		
		//2.����Ʒ��ӵ����ﳵ
		//2.1��session�л�ȡ���ﳵ
		Map<String,Integer>map=(Map<String, Integer>) request.getSession().getAttribute("cart");
		
		Integer count=null;
		//2.2�жϹ��ﳵ�Ƿ�Ϊ��
		if(map==null) {
			//��һ�ι���������ﳵ
			map=new HashMap<String, Integer>();
			//�����ﳵ����session��ȥ
			count=productQuantity; 
			request.getSession().setAttribute("cart", map);;
		}else {
			//���ﳵ��Ϊ�գ������жϹ��ﳵ���Ƿ��и���Ʒ
			count=map.get(name);
			if(count==null) {
				//���ﳵ��û�и���Ʒ
				count=productQuantity;
			}else {
				//���ﳵ���и���Ʒ
				count=count+productQuantity;
			}
		}
		
		//����Ʒ���빺�ﳵ��
		map.put(name, count);
		
		//3.��ʾ��Ϣ
		PrintWriter pw=response.getWriter();
		pw.print("�Ѿ� ��<b>"+name+"</b>��ӵ����ﳵ��<hr>");
		pw.print("<a href='"+request.getContextPath()+"/projectLearn/day11/product_list.jsp'>��������</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.print("<a href='"+request.getContextPath()+"/projectLearn/day11/cart.jsp'>�鿴����</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
