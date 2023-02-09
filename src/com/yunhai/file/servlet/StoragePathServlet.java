package com.yunhai.file.servlet;

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

@WebServlet("/storagePathServlet")
@MultipartConfig
public class StoragePathServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String pathOwner = "";

		pathOwner = (String) request.getSession().getAttribute("userName");
		if (null == pathOwner || pathOwner.isEmpty()) {
			pathOwner = request.getParameter("owner");
		}

		List pathList =new FileManageService().queryAllStoragePathWithOwner(pathOwner);
		request.setAttribute("pathList", pathList);
		request.getRequestDispatcher("/jsp/excelImport/uploadWithPathOptionMultipleFile.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
