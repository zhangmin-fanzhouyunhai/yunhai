package com.itheima.day10.servlet.b_request.e_scontext;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScontextServlet
 * servletContext �ĳ��÷���
 */
@WebServlet("/scontextServlet")
public class ScontextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.��ȡȫ�ֹ�����
		ServletContext context=getServletContext();
		
		//��ȡ��ʼ������
		String encoding=context.getInitParameter("encoding");
		System.out.println("��ʼ��������"+encoding);
		//��ȡ�ļ�����ʵ·��
		String path=context.getRealPath("/");//��ĿĿ¼��
		path=context.getRealPath("/projectLearn/day10/download/day10.txt");//��ĿĿ¼��
		System.out.println("path="+path);
		//��������ʽ����һ���ļ�
		InputStream is=context.getResourceAsStream("/2.txt");
		System.out.println("/2.txt="+is);
		is=context.getResourceAsStream(path);
		System.out.println("day10.txt="+is);
		is=context.getResourceAsStream("/webRoot1.txt");
		System.out.println("webRoot1.txt="+is);
		is=context.getResourceAsStream("/projectLearn/day10/download/day10.txt");
		System.out.println("day10.txt="+is);
		/**
		 * D:\ProgramFiles\Workspaces\workspace\
		 * Tomcat8.0.33\conf\web.xml
		 * ���ļ������P�"mime"�����P��Ϣ�����磺
		 * ...................
		 *<mime-mapping>
		 *		<extension>htke</extension>
		 *		<mime-type>application/vnd.kenameaapp</mime-type>
		 *</mime-mapping>
		 *<mime-mapping>
		 *		<extension>htm</extension>
		 *		<mime-type>text/html</mime-type>
		 *</mime-mapping>
		 *<mime-mapping>
		 *		<extension>html</extension>
		 *		<mime-type>text/html</mime-type>
		 *</mime-mapping>
		 *........ 
		 */
		//��ȡ�ļ���mime����
		System.out.println("======================");
		String mimeType=context.getMimeType("1.jpg");
		System.out.println("mimeType="+mimeType);
		mimeType=context.getMimeType("1.gif");
		System.out.println("mimeType="+mimeType); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
