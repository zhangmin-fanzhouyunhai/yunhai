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
 * ��¼��Ʒ�������ʷ
 * Servlet implementation class GetProductByIdServlet
 */
@WebServlet("/getProductById")
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//0.1��ȡ��ǰ���ʵ���Ʒid
		String id=request.getParameter("id");
		//1.��ȡָ����cookie ids 
		Cookie cookie=CookUtils.getCookieByName("ids", request.getCookies());
		String ids="";
		//2.�ж�cookie�Ƿ�Ϊ��
		if(cookie==null) {
			//��cookieΪ�գ���Ҫ����ǰ��Ʒid����ids��
			ids=id; 
		}else {
			//��cookie��Ϊ��,�����ж�ids���Ƿ��Ѿ���id  //ids=2-11-21
			//��ȡֵ
			ids=cookie.getValue();
			String[] arr=ids.split("-");
			//������ת���ɼ���,��list���Ȳ��ɱ�
			List<String> asList=Arrays.asList(arr);
			//��aslist����һ����list��
			LinkedList<String> list=new LinkedList<>(asList);
			
			if(list.contains(id)) {
				//��ids�а���id	��id�Ƴ�	�ŵ���ǰ��
				list.remove(id);
				list.addFirst(id);
			}else {
				//��ids�в�����id	�����жϳ����Ƿ����2
				if(list.size()>2) {
					//����>=3���Ƴ����һ������ǰ�ķ�����ǰ��
					list.removeLast();
					list.addFirst(id);
				}else {
					//����<3,����ǰ������ǰ��
					list.addFirst(id);
				}
			}
			ids="";
			//��listת���ַ���
			for(String s:list) {
				ids+=(s+"-");
			}
			ids= ids.substring(0, ids.length()-1);
		}
		
		//��idsд��ȥ
		//cookie=new Cookie("ids",ids);
		//cookie=new Cookie("ids",ids.substring(0,ids.length()-1));
		cookie=new Cookie("ids",ids);
		//���÷���·��
		cookie.setPath(request.getContextPath()+"/");
		//���ô��ʱ��
		cookie.setMaxAge(3600);
		//д�������
		response.addCookie(cookie);
		
		//��cookieΪ��
		//��cookie��Ϊ��
		
		//3.��ת��ָ������Ʒҳ����
		response.sendRedirect(request.getContextPath()+"/projectLearn/day11/product_info"+id+".html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
