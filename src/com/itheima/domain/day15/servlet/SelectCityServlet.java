package com.itheima.domain.day15.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.day15.domain.City;
import com.itheima.domain.day15.service.CityService;

import net.sf.json.JSONArray;

/**
 * 根据省份id查询所有的市
 */
@WebServlet("/selectCityServlet")
public class SelectCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取省份id
		String provinceID=request.getParameter("provinceID");
		//2.调用service 查询所有的市 返回list
		List<City> list=null;
		try {
			list = new CityService().findCitiesByProvinceID(provinceID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.将list转换成json 返回页面
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
