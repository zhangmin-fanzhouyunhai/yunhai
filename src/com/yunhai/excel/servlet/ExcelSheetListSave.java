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

@WebServlet("/excelSheetListSave")
@MultipartConfig
public class ExcelSheetListSave extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4534112457950474028L;

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
		String userFolder = request.getParameter("userFolder"); 
		String savePath = request.getServletContext().getRealPath("userFile"+File.separator+userFolder);
		//String fileName1=request.getParameter("fileName");
		//System.out.println("fileName1="+fileName1+"savePath="+savePath);
		String fileName = savePath+File.separator+request.getParameter("fileName");
		//System.out.println("fileName="+fileName);
		List excelSheetList =new FileManageService().getAllExcelSheetAndSave(fileName, serverCode);
		request.setAttribute("sheetList", excelSheetList);
		request.setAttribute("fileName", request.getParameter("fileName"));
		request.getRequestDispatcher("/jsp/excel/excelSheetListSave.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
