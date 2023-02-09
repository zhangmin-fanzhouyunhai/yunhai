package com.yunhai.excel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.yunhai.excel.orm.ExcelSheetColumn;
import com.yunhai.excel.service.ExcelFileManageService;

@WebServlet("/columnValueAnalysis")
@MultipartConfig
public class ColumnValueAnalysisServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String pathOwner = (String) request.getSession().getAttribute("userName");
		if (null == pathOwner || pathOwner.isEmpty()) {
			pathOwner = request.getParameter("owner");
		}
		String serverCode = (String) request.getSession().getAttribute("serverCode");
		if ((null == serverCode || serverCode.isEmpty()) && null == request.getParameter("serverCode")) {
			serverCode = "100000000";
		} else if (!(null == request.getParameter("serverCode"))) {
			serverCode = request.getParameter("serverCode");
		}
		String parentValue=request.getParameter("parentValue");
		//System.out.println("parentValue:"+parentValue);
		String  str = "";
		str += "<table align='center'><thead><TH>���</TH><TH>������</TH><TH>��������</TH><TH>���ݾ���</TH>";
		str += "<TH>�ֶ�����</TH><TH>����˳��</TH></thead><tbody>";
		str += "<TR>" + parentValue;
		str += "</TR></tbody></table>";
		//System.out.println("str:"+str);
		request.setAttribute("data", str);
		Map resultMap= new HashMap();
		resultMap.put("data", str);
		JSONObject result=new JSONObject(resultMap);
		System.out.println("result="+result);
		ExcelSheetColumn excelSheetColumn=new ExcelSheetColumn();
		List<ExcelSheetColumn> columnList =new ArrayList<ExcelSheetColumn>();
		new ExcelFileManageService().columnValueAnalysis(excelSheetColumn);
		//response.getWriter().append(str);
		response.setContentType("application/json"); 
		response.getWriter().write(result.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
