package com.yunhai.excel.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhai.excel.service.FileManageService;
import com.yunhai.file.orm.StoragePath;

@WebServlet("/excelFileListServlet")
@MultipartConfig
public class ExcelFileListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		List fileList =new FileManageService().queryAllExcelFileFromDatabase(serverCode);
		request.setAttribute("fileList", fileList); 
		request.getRequestDispatcher("/jsp/excel/excelFileList.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
