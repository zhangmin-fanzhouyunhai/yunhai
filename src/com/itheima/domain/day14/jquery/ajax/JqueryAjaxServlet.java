package com.itheima.domain.day14.jquery.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jquery��ajax
 */
@WebServlet("/jqueryAjaxServlet")
public class JqueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("����ʽ:"+request.getMethod());
		//�����ַ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		//���ܲ���
		String username=request.getParameter("username");
		System.out.println("�û����ƣ�"+username);
		//��Ӧ����
		response.getWriter().print("success");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("����ʽ:"+request.getMethod());
				//�����ַ���
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8"); 
				//���ܲ���
				String username=request.getParameter("username");
				//username=new String(username.getBytes("iso-8859-1"),"utf-8");
				//{"result":"success","msg":"��Ӧ�ɹ�"}
				String s="{\"result\":\"success\",\"msg\":\"��Ӧ�ɹ�\"}";
				System.out.println("�û����ƣ�"+username);
				
				//��Ӧ����
				response.getWriter().print(s);
	}

}
