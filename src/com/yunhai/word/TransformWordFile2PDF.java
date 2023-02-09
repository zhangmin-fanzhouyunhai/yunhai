package com.yunhai.word;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/transformWordFile2PDF", loadOnStartup = 1)
@MultipartConfig
public class TransformWordFile2PDF  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8939989812584477151L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �Ȼ�ȡ����Ĳ���
		// 0.���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		// 1.����������֤��
		HttpSession httpSession = request.getSession();
		// ��HttpSession�л�ȡcheckCode
		String sCode = (String) request.getSession().getAttribute("checkCode");
		// ��request�л�ȡ�������֤��verificationCode��
		String rCode = request.getParameter("verificationCode");
		// ��request�л�ȡ�������ı�š�
		String serveCode = request.getParameter("serveCode");
		// System.out.println("serveCode="+serveCode);
		// ��HttpSession�����÷������ı��
		httpSession.setAttribute("serveCode", serveCode);
		
	}
	

}
