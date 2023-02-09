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

import com.yunhai.service.ChinesWordService;

@WebServlet(value = "/saveWords")
@MultipartConfig
public class SaveWordsServlet extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045095885972804611L;

	public SaveWordsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
		// 0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		

		// 1.接受两个验证码
		HttpSession httpSession = request.getSession();
		//从HttpSession中获取serveCode
		String serveCode = (String) httpSession.getAttribute("serveCode");

		//System.out.println("serveCode="+serveCode); 
		String[] words = request.getParameterValues("words");
		
		List<String> wordList=new ArrayList<String>(Arrays.asList(words));
		/*System.out.println("words="+words); 
		System.out.println("words length="+words.length); 
		String word1 = request.getParameter("word1");
		String word2 = request.getParameter("word2");
		String word3 = request.getParameter("word3");
		String word4 = request.getParameter("word4"); 
		String word5 = request.getParameter("word5");
		String word6 = request.getParameter("word6");
		String word7 = request.getParameter("word7");
		String word8 = request.getParameter("word8"); */
/*
		System.out.println("word1="+word1);
		System.out.println("word2="+word2);
		System.out.println("word3="+word3);
		System.out.println("word4="+word4);  
		System.out.println("word5="+word5);  
		System.out.println("word6="+word6);  
		System.out.println("word7="+word7);  
		System.out.println("word8="+word8);  */
		
		new ChinesWordService().saveWords(wordList,serveCode);
		 
	}

}
