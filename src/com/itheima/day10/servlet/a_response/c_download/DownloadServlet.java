package com.itheima.day10.servlet.a_response.c_download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;

import com.yunhai.util.DownloadUtils;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet 文件下载
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取下载文件的名称
		String fileName = request.getParameter("name");
		//
		System.out.println("解决获得中文参数的乱码之前，fileName=" + fileName);
		// 解决获得中文参数的乱码
		// fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		// 获得请求头中的User-Agent
		String agent = request.getHeader("User-Agent");
		// 根据不同浏览器进行不同的编码
		String fileNameEncoder = "";
		/*
		 * if (agent.contains("MSIE")) { // IE浏览器 
		 * fileNameEncoder =
		 * URLEncoder.encode(fileName, "utf-8"); 
		 * fileNameEncoder =
		 * fileNameEncoder.replace("+", " "); 
		 * } else if (agent.contains("Firefox")) 
		 * { //火狐浏览器 
		 * BASE64Encoder base64Encoder = new BASE64Encoder(); 
		 * fileNameEncoder =
		 * "=?utf-8?B?" + 
		 * base64Encoder.encode(fileName.getBytes("utf-8")) + "?="; 
		 * }else { // 其它浏览器 
		 * fileNameEncoder = URLEncoder.encode(fileName, "utf-8"); 
		 * }
		 */
		//用工具类DwonLoadUtils替换
		fileNameEncoder = DownloadUtils.getName(agent, fileName);
		//
		System.out.println("解决获得中文参数的乱码之后，fileNameEncoder=" + fileNameEncoder);
		// 文件下载
		ServletContext context = this.getServletContext();

		// 1.设置文件的mimeType
		// context.getMimeType(fileNameEncoder);不检查文件的存在性
		String mimeType = context.getMimeType(fileNameEncoder);

		//System.out.println("mimeType=" + mimeType); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType(mimeType);
		// 2.设置下载的头信息，表头部分决定下载文件的名字，
		//为避免下载文件出现中文乱码，需要使用处理乱码后的文件名变量。
		response.setHeader("content-disposition", "attachment;fileName=" + fileNameEncoder);
		// 3.对拷流
		// 获取输入源
		// context.getRealPath("/projectLearn/day10/download/day10.txt");
		//不检测文件的存在性
		// context.getResourceAsStream("/projectLearn/day10/download/" +
		// fileName);//下面的语句不会检测文件的存在性，但使用时如果文件不存在会报错。
		// getResourceAsStream，取的是webRoot目录下的文件，且是对应项目相对目录下的路径，
		//不接受项目绝对路径。在文件上传过程才会使用绝对路径。
		// 下载时，输入流的文件名不要使用处理乱码后的文件名变量，
		//这是因为处理后的文件名称变成了“2020%E5%B9%....xls”类似字符串，
		// 系统将无法在本地找到正确的文件。
		InputStream is = context.getResourceAsStream("/projectLearn/day10/download/" + fileName);
		// 获取输出流
		ServletOutputStream os = response.getOutputStream();
		// System.out.println("is.toString()"+is.toString());
		// 方案1.
		/*
		 * int len = -1; byte[] 
		 * buffer = new byte[1024]; 
		 * while ((len =
		 * is.read(buffer))!= -1) { 
		 * os.write(buffer, 0, len); 
		 * }
		 */
		// 方案2.需要commons.io-2.2.jar包
		IOUtils.copy(is, os);
		os.close();
		is.close();
		//request.getRequestDispatcher("/projectLearn/day10/download2.html").
		//forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
