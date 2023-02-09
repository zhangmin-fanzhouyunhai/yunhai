package com.yunhai.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SpareEquipmentImportServlet
 */ 
@WebServlet("/spareEquipmentImportShowFormServlet")
public class SpareEquipmentImportShowFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);	
		
	}

	/**
	 * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header 请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		//System.out.println("tempArr1.size="+tempArr1.length);
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[tempArr1.length-1].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		//System.out.println("fileName="+fileName);
		return fileName;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1、判断请求是不是multipart请求
		
		  if (!ServletFileUpload.isMultipartContent(request)) { throw new
		  RuntimeException("当前请求不支持文件上传"); }
		 
		System.out.println("开始上传文件");   
		String version= request.getParameter("versionValue");
		System.out.println("version="+version);
		String []versionValues = request.getParameterValues("versionValue");
		String [] calYears = request.getParameterValues("calYear"); 

		String [] acs=request.getParameterValues("ac");
		String [] pathStrs=request.getParameterValues("pathStr"); 
		String versionValue="";
		String calYear="";
		String pathStr="";
		String ac="";
		if(versionValues==null) {
			System.out.println("versionValues not exists!");
		}
		if(calYears==null) {
			System.out.println("calYears not exists!");
		}
		if(pathStrs==null) {
			System.out.println("pathStrs not exists!");
		}
		/*
		 * for(int i=0;i<versionValues.length;i++) {
		 * if(!versionValues[i].contentEquals("")) { versionValue=versionValues[i];
		 * calYear=calYears[i]; pathStr=pathStrs[i]; break; } }
		 */
		// 存储路径
		String savePath = request.getServletContext().getRealPath("/userFile/excel");
		//
		System.out.println("pathStr=" + pathStr +",versionValue=" + versionValue + ",calYear=" + calYear);
		// 获取上传的文件集合
		Collection<Part> parts = request.getParts();
		// Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
		// 通过request.getPart("pathStr");//从上传的文件集合中获取Part对象
		//Part part = request.getPart(pathStr);
		//通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
		// Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
		// 获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
		//part.getClass();
		
		//
		System.out.println("parts.size="+parts.size());
		
		//String header = part.getHeader("content-disposition");
		// 获取文件名
		//String fileName2 = getFileName(header);
		//versionValue="O_2020_1";

		//calYear="2021-04-02 10:40";
		//String fileName2="表14-2020年备品备件-V1.1-20210402-小邓-替换表头 .csv";
		// 把文件写到指定路径
		//part.write(savePath + File.separator + fileName2);
		// 上传单个文件
		System.out.println("savePath="+savePath);
		//new CsvImportService().spareEquipmentImportSave(savePath+"/"+fileName2, versionValue, calYear);
		// 转发/jsp/excelImport/add.jsp
		request.getRequestDispatcher("/jsp/excelImport/excelImport.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("上传成功");
		out.flush();
		out.close();
	}

}
