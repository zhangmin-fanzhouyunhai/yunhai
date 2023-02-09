package com.yunhai.excel.servlet;

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

import com.yunhai.excel.service.ExcelFileManageService;

@WebServlet("/batchUpdateColDataType")
@MultipartConfig
public class BatchUpdateColDataTypeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		String excelSheetColumnId[] = request.getParameterValues("excelSheetColumnIdArray"); 
		/*
		 * System.out.println(excelSheetColumnId); for(int
		 * i=0;i<excelSheetColumnId.length;i++) {
		 * System.out.println("excelSheetColumnId["+i+"]="+excelSheetColumnId[i]); }
		 */
		List<String> excelSheetColumnIdList=new ArrayList<String>(Arrays.asList(excelSheetColumnId));
		String dataType = request.getParameter("dataType"); 
		//System.out.println("excelSheetColumnId="+excelSheetColumnId+",dataType="+dataType);
		//if(!(excelSheetColumnIdList.isEmpty()|| null==excelSheetColumnIdList)) {
			new ExcelFileManageService().batchUpdateColumnDataTypeByColumnId(excelSheetColumnIdList,dataType, serverCode);
		//}
		response.setContentType("application/json"); 
		response.getWriter().write("true");
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
