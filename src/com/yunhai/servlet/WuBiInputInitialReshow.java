package com.yunhai.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yunhai.orm.WordChinese;
import com.yunhai.service.ChinesWordService;

@WebServlet(value = "/wuBiInputInitialReshow")
@MultipartConfig
public class WuBiInputInitialReshow  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 189405277870307989L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �Ȼ�ȡ����Ĳ���
		// 0.���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8"); 
		// 1.����������֤��
		HttpSession httpSession = request.getSession();
		//��HttpSession�л�ȡserveCode
		String serveCode = (String) httpSession.getAttribute("serveCode");

		serveCode="100000000";
		int wordNum=10;
		List<WordChinese> wordList=new ChinesWordService().queryWordListWithLimitNum(wordNum,serveCode);
		request.setAttribute("wordList", wordList);
		request.getRequestDispatcher("./jsp/wuBiInputMethodWordInputReshow.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
