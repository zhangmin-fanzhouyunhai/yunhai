package com.itheima.day10.servlet.b_request.f_path;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
@WebServlet("/pathServlet")
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pt=PathServlet.class.getClassLoader().getResource("2.txt").getPath();
		System.out.println("pt="+pt);
		String pt1=PathServlet.class.getClassLoader().getResource("/2.txt").getPath();
		System.out.println("pt1="+pt1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void main(String[] args) {
		//String path=PathServlet.class.getClassLoader().getResource("1.txt").getPath();
		InputStream inputStream=PathServlet.class.getClassLoader().getResourceAsStream("/1.txt");
		System.out.println(inputStream);
	}
}











