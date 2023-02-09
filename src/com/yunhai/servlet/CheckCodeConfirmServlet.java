package com.yunhai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CheckCodeConfirmServlet
 */
@WebServlet("/checkCodeConfirm")
public class CheckCodeConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkCode=(String) request.getParameter("checkCode"); 
		//ȡ��ǰ��ajax���ݹ���������ʱ��getParameter,���Ժ��request.setAttribute��ֵ����request.getAttribute
		//System.out.println("request.getSession().getAttribute(\"checkCode\")="
		//+request.getSession().getAttribute("checkCode"));
		JSONObject json=new JSONObject();
		if(request.getSession().getAttribute("checkCode").equals(checkCode)) {
			// �齨һ������Ϊdata��ֵΪsuccess��JSONObject���ݻ�ǰ��ajax���д���
			json.put("data", "success");
			response.getWriter().print(json.toString()); 
		}else {
			// �齨һ������Ϊdata��ֵΪfailure��JSONObject���ݻ�ǰ��ajax���д���
			json.put("data", "failure"); 
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
