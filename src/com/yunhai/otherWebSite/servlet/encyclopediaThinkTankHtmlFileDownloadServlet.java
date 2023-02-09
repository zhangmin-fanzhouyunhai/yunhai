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

@WebServlet("/encyclopediaThinkTankHtmlFileDownloadServlet")
@MultipartConfig
public class encyclopediaThinkTankHtmlFileDownloadServlet  extends HttpServlet {
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
		String webSiteName=request.getParameter("webSiteName");
		String webSite=request.getParameter("webSite");
		String relativePath="/html/encyclopediaThinkTank/";
		String pythonFileRelativePath="/jsp/pythonFile/";
		String storagePath= request.getServletContext().getRealPath(relativePath );
		String pythonFilePath= request.getServletContext().getRealPath(pythonFileRelativePath );
		String pythonFile="mbaEncyclopediaThinkTankWebSave.py";
		EncylopediaThinkTankWebSiteService encylopediaThinkTankWebSiteService=new EncylopediaThinkTankWebSiteService();
		encylopediaThinkTankWebSiteService.webDownload( webSiteName, webSite,pythonFilePath+"/"+pythonFile, relativePath, storagePath);
		//List<WebContent> webContentList =encylopediaThinkTankWebSiteService.queryWebSiteAndLocalWebFile(serverCode);
		//request.setAttribute("savePath", savePath); 
		//request.setAttribute("webContentList", webContentList); 
		//request.getRequestDispatcher("/jsp/otherWebSite/encyclopediaThinkTankHtmlFile.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
