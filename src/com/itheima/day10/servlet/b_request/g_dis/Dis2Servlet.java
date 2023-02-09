package com.itheima.day10.servlet.b_request.g_dis;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dis2Servlet
 */
@WebServlet("/dis2Servlet")
public class Dis2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("侯教师曰：需要多少？我答："+
		request.getParameter("money"));
		Double money=0.0;
		try {
			money=new DecimalFormat().parse(request.getParameter("money")).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("侯教师曰：需要多少？我答："+
				(money+8.0));
		System.out.println("侯教师又曰：干嘛用啊？我答：借给"+
				request.getAttribute("username"));
		request.getRequestDispatcher("/projectLearn/day10/index.html").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
