package com.yunhai.english.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhai.english.orm.EnglishWord;
import com.yunhai.english.service.EnglishWordService;

@WebServlet("/englishWord")
@MultipartConfig
public class EnglishWordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("utf-8");
				String pathOwner = (String) request.getSession().getAttribute("userName");
				if (null == pathOwner || pathOwner.isEmpty()) {
					pathOwner = request.getParameter("owner");
				} 
				String serverCode = (String) request.getSession().getAttribute("serverCode");
				if ((null == serverCode || serverCode.isEmpty()) && null==request.getParameter("serverCode")) {
					serverCode = "100000000";
				} else if(!(null==request.getParameter("serverCode"))){
					serverCode = request.getParameter("serverCode");
				}
				String englishWordVal = request.getParameter("englishWordVal");
				String phoneticSymbol = request.getParameter("phoneticSymbol");
				String wordMeaning = request.getParameter("wordMeaning");
				String englishDetail = request.getParameter("englishDetail");
				EnglishWord englisWord=new EnglishWord();
				englisWord.setEnglishWord(englishWordVal);
				englisWord.setPhoneticSymbol(phoneticSymbol);
				englisWord.setWordMeaning(wordMeaning);
				englisWord.setEnglishDetail(englishDetail);
				new EnglishWordService().addEnglishWord(serverCode,englisWord); 
				request.getRequestDispatcher("/jsp/englishWord.jsp").forward(request,
						response);
	}
}
