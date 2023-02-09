package com.yunhai.otherWebSite.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhai.excel.service.FileManageService;
import com.yunhai.otherWebSite.Service.EncylopediaThinkTankWebSiteService;
import com.yunhai.otherWebSite.orm.WebContent;

@WebServlet("/encylopediaThinkTankWebSiteList")
@MultipartConfig
public class EncylopediaThinkTankWebSiteListServlet  extends HttpServlet {
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
				if ((null == serverCode || serverCode.isEmpty()) && null==request.getParameter("serverCode")) {
					serverCode = "100000000";
				} else if(!(null==request.getParameter("serverCode"))){
					serverCode = request.getParameter("serverCode");
				}
				//String savePath = request.getServletContext().getRealPath("/" );
				//System.out.println("savePath="+savePath);
				List<WebContent> webContentList =new EncylopediaThinkTankWebSiteService().queryWebSiteAndLocalWebFile(serverCode);
				//request.setAttribute("savePath", savePath); 
				request.setAttribute("webContentList", webContentList); 
				request.getRequestDispatcher("/jsp/otherWebSite/encyclopediaThinkTankHtmlFile.jsp").forward(request,
						response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
