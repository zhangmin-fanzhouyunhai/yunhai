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
 * �����Ʒ
 */
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��չ���ƻ���
		//0.1��ȡsession�����ƺ��ύ����������
		String rToken=request.getParameter("rToken");
		String sToken=(String) request.getSession().getAttribute("sToken");
		//0.2 �Ƴ�session�е�����
		request.getSession().removeAttribute("sToken");
		System.out.println("sToken:"+sToken);
		System.out.println("rToken:"+rToken);
		
		//0.3�Ƚ���������
		if(sToken==null	|| !sToken.equals(rToken)) {
			//�Ѿ��ύ���ˣ����ɴ�����ʾ��Ϣ����request���У���ת��msg.jsp
			request.setAttribute("msg", "��Ʒ�Ѿ����棡");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//1.��װ����
		Product p=new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			//1.1����pid
			p.setProductId(UUIDUtils.getId());
			//1.2����ʱ��
			p.setProductDate(new Date());
			System.out.println("productName��"+p.getProductName());
			//2.����service�����Ӳ���
			new ProductService().addProduct(p);
			
			//3.ҳ����ת	findAll		
			//��������ת��
			request.getRequestDispatcher("/findAllProduct").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "�����Ʒʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
