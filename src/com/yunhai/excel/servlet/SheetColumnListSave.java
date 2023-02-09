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

import com.yunhai.excel.orm.ColumnValueType;
import com.yunhai.excel.orm.ExcelFile;
import com.yunhai.excel.service.FileManageService;

@WebServlet("/sheetColumnListSave")
@MultipartConfig
public class SheetColumnListSave extends HttpServlet {
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
		String excelFileId = request.getParameter("excelFileId"); 
		String sheetName = request.getParameter("sheetName"); 
		ExcelFile excelFile=new FileManageService().getExcelFileByFileId(excelFileId, serverCode);
		if(null==excelFile) {
			request.getRequestDispatcher("/jsp/excel/err.jsp").forward(request,
					response);
		}else {
			//String fileName1=request.getParameter("fileName");
			//System.out.println("fileName1="+fileName1+"savePath="+savePath);
			String savePath = request.getServletContext().getRealPath("userFile"+File.separator+excelFile.getStoryPath());
			String fileName = savePath+File.separator+excelFile.getExcelFileName(); 
			List excelSheetColumnList =new FileManageService().getAllExcelSheetColumnAndSave(fileName, sheetName,serverCode);
			List  columnValueTypeList=new FileManageService().getColumnValueType(serverCode);
			/*
			 * List excelColumnValueTypeList=new ArrayList();
			 * excelColumnValueTypeList.add("字符型"); excelColumnValueTypeList.add("日期型");
			 * excelColumnValueTypeList.add("数值型");
			 */
			request.setAttribute("sheetColumnList", excelSheetColumnList);
			request.setAttribute("sheetName", sheetName);
			request.setAttribute("excelColumnValueTypeList", columnValueTypeList);
		
			request.setAttribute("fileName", excelFile.getExcelFileName());
			request.getRequestDispatcher("/jsp/excel/excelSheetColumnListSave.jsp").forward(request,
					response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
