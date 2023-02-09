package com.yunhai.file.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downLoadFile")
@MultipartConfig
public class DownLoadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 2045095885972804611L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = (String) request.getSession().getAttribute("userName");
		String fileName = (String) request.getParameter("fileName");
		String path = (String) request.getParameter("path");
		// 服务器上文件存储路径
		String savePath = request.getServletContext().getRealPath("/userFile/" + path);

		String fileNameWithPath = savePath + File.separator + fileName;
		File file = new File(fileNameWithPath);

		if (file.exists()) {
			response.setContentType("application/x-msdownload");
			// 文件下载用，设置文件名称
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
			FileInputStream inputStream = new FileInputStream(file);
			ServletOutputStream ouputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				ouputStream.write(buffer, 0, len);
			}
			ouputStream.close();
			inputStream.close();
		} else {
			response.getWriter().print("false");
		}
	}

	/**
	 * 根据请求头解析出文件名 请求头的格式： 火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header 请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";"); 代码执行完之后，在不同的浏览器下， tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下： tempArr1={form-data,name="file", filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file", filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		// System.out.println("tempArr1.size="+tempArr1.length);
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[tempArr1.length - 1].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		// System.out.println("fileName="+fileName);
		return fileName;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
