package com.yunhai.file.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 
 * @author Zhang Min 2022/9/19 20:17 将多个（1个及以上）文件打包以zip压缩包的形式下载
 *
 */
@WebServlet("/downLoadFileAndZip")
@MultipartConfig
public class DownLoadFileAndZip extends HttpServlet {
	private static final long serialVersionUID = 2045095885972804611L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=(String)request.getSession().getAttribute("userName");
		String fileName = (String) request.getParameter("fileName");
		String path = (String) request.getParameter("path");
		//服务器上文件存储路径
		String savePath = request.getServletContext().getRealPath("/userFile/"+path);
		
		
		String fileNameWithPath = savePath + File.separator + fileName;
		File file = new File(fileNameWithPath);
		
		String outputFileName=fileName.substring(0,fileName.lastIndexOf("."))+".zip";
		response.setContentType("application/x-msdownload");
		//文件下载用，设置文件名称
		response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(outputFileName, "UTF-8"));
		ZipOutputStream zipOutputStream= new ZipOutputStream(response.getOutputStream());
		if (file.exists()) {
			/**
			 * 此处为了保证加入的中文名文件，不出现乱码，将编码设置为utf-8
			 */
			zipOutputStream.setEncoding("UTF-8");
			zipOutputStream.putNextEntry(new ZipEntry(fileName));
			FileInputStream fileInputStream =new FileInputStream(file);
			byte [] buffer = new byte[1024];
			int len=0;
			while((len = fileInputStream.read(buffer)) != -1) {
				zipOutputStream.write(buffer,0,len);
			}
			zipOutputStream.flush();
			fileInputStream.close();
			//设置解压文件后的注释内容，不出现乱码，将编码设置为gbk
			zipOutputStream.setEncoding("gbk");
			zipOutputStream.setComment("Download success:"+fileName);
			zipOutputStream.flush();
			zipOutputStream.close();
		}else {
			response.getWriter().print("false"); 
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
