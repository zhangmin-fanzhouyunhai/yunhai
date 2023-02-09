package com.yunhai.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.yunhai.orm.WordChinese;
import com.yunhai.service.ChinesWordService;

@WebServlet(value = "/saveWords2")
@MultipartConfig
public class SaveWordsServlet2 extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045095885972804611L;

	public SaveWordsServlet2() {
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
		
		serveCode="100000000";
		
		new ChinesWordService().saveWords(wordList,serveCode);
		Map oldWordMap=new HashMap<String,String>();
		for(int i=0;i<wordList.size();i++) {
			oldWordMap.put("oldWord"+(i+1), wordList.get(i));
			//request.setAttribute("oldWord"+(i+1), wordList.get(i));
		}
		JSONObject oldWordMapJsonObject=new JSONObject(oldWordMap);
		//System.out.println("oldWordMapJsonObject="+oldWordMapJsonObject);
		serveCode="100000000";
		int wordNum=10;
		List<WordChinese> recentWordList=new ChinesWordService().queryWordListWithLimitNum(wordNum,serveCode);
		
		Map resultMap=new HashMap<String,Object>();
		resultMap.put("oldWordMap", oldWordMap);
		resultMap.put("wordList", recentWordList);

		JSONObject resultMapJsonObject=new JSONObject(resultMap);
		//System.out.println("resultMapJsonObject="+resultMapJsonObject);
		
		Map recentInputWordMap = new HashMap<String,WordChinese>();
		for(int i=0;i<recentWordList.size();i++) {
			recentInputWordMap.put(""+i,recentWordList.get(i));
		}
		JSONObject recentInputWordMapJsonObject=new JSONObject(recentInputWordMap);
		//System.out.println("recentInputWordMapJsonObject="+recentInputWordMapJsonObject);
		request.setAttribute("data", oldWordMapJsonObject);
		response.setContentType("application/json");
		//response.getWriter().write(oldWordMapJsonObject.toString());
		response.getWriter().write(resultMapJsonObject.toString());
		
		//request.getRequestDispatcher("./jsp/wuBiInputMethodWordInput2.jsp").forward(request, response);
	}

}
