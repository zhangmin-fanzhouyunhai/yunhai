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
		// 先获取请求的参数
		// 0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		// 1.接受两个验证码
		HttpSession httpSession = request.getSession();
		// 从HttpSession中获取checkCode
		String sCode = (String) request.getSession().getAttribute("checkCode");
		// 从request中获取输入的验证码verificationCode。
		String rCode = request.getParameter("verificationCode");
		// 从request中获取服务器的编号。
		String serveCode = request.getParameter("serveCode");
		// System.out.println("serveCode="+serveCode);
		// 向HttpSession中设置服务器的编号
		httpSession.setAttribute("serveCode", serveCode);
		
	}
	

}
