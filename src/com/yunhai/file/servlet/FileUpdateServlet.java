package com.yunhai.file.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yunhai.excel.service.CsvImportService;

@WebServlet("/fileUpdateServlet")
@MultipartConfig
public class FileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 2045095885972804611L;

	public FileUpdateServlet() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 根据请求头解析出文件名 请求头的格式：
	 * 火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" 
	 * IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header 请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");
		 * 代码执行完之后，在不同的浏览器下，
		 * tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：
		 * tempArr1={form-data,name="file",
		 * filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",
		 * filename="E:\snmp4j--api.zip"}
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
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1、判断请求是不是multipart请求
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("当前请求不支持文件上传");
		}
		// System.out.println("开始上传文件"); 
		// 存储路径
		String savePath = request.getServletContext().
				getRealPath("/userFile/excel"); 
		// 获取上传的文件集合
		//Collection<Part> parts = request.getParts();
		/*
		 * Servlet3.0将multipart/form-data的POST请求封装成Part，
		 * 通过Part对上传的文件进行操作。
		 * 通过request.getPart("pathStr");
		 * 从上传的文件集合中获取Part对象
		 */
		Part part = request.getPart("pathStr");
		/*
		 * 通过表单file控件(<input type="file" name="file">)
		 * 的名字直接获取Part对象
		 * Servlet3没有提供直接获取文件名的方法,
		 * 需要从请求头中解析出来 获取请求头，
		 * 请求头的格式：form-data; name="file";
		 * filename="snmp4j--api.zip"
		 */
		part.getClass();

		// System.out.println("parts.size="+parts.size()+
		//",part.getHeader()="+
		//part.getHeader("content-disposition"));

		String header = part.getHeader("content-disposition");
		// 获取文件名
		String fileName2 = getFileName(header);
		// 把文件写到指定路径
		part.write(savePath + File.separator + fileName2);
		// 上传单个文件  
		// 转发/jsp/excelImport/add.jsp
		request.getRequestDispatcher("/jsp/excelImport/uploadFile.jsp").
		forward(request, response); 

	}
}
