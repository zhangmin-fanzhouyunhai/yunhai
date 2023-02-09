package com.itheima.domain.day15.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day15.domain.Province;
import com.itheima.domain.day15.service.ProvinceService;

import net.sf.json.JSONArray;

/**
 * ��ѯ���е�ʡ
 */
@WebServlet("/selectProvinceServlet")
public class SelectProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.����service ��ѯ���е�ʡ�� 
		List<Province> list=null;
		try {
			list = new ProvinceService().findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//2.�����е�ʡ��д��ȥ
		response.setContentType("text/html;charset=utf-8");
		if(list!=null && list.size()>0) {
			response.getWriter().println(JSONArray.fromObject(list));
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
