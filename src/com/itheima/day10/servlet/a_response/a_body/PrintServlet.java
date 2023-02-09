package com.itheima.day10.servlet.a_response.a_body;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintServlet
 *   ������Ӧ��
 */
@WebServlet("/printServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//������Ӧ����������
		//����1��
		//response.setContentType("text/html;charset=utf-8");
		//����2��
		response.setHeader("content-type", "text/html;charset=utf-8");
		//��ӡ���
		//��ȡ�ַ���
		PrintWriter writer=response.getWriter();
		writer.print("<table border='1'><tr>");
		writer.print("<td>�û���:</td>");
		writer.print("<td>tom</td>");
		writer.print("</tr><tr>");
		writer.print("<td>����:</td>");
		writer.print("<td>123</td>");
		writer.print("</tr></table>");
		
		//ServletOutputStream os=response.getOutputStream();
		
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
