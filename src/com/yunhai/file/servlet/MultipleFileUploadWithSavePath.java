package com.yunhai.file.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yunhai.excel.dao.FileManageDao;
import com.yunhai.excel.service.FileManageService;
import com.yunhai.orm.UploadFile;

@WebServlet("/multiFileUploadWithSavePathServlet")
@MultipartConfig
public class MultipleFileUploadWithSavePath extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7749235244449016079L;

	public MultipleFileUploadWithSavePath() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub// 先获取请求的参数
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1、判断请求是不是multipart请求
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("当前请求不支持文件上传");
		}
		String serverCode="";
		if(null ==request.getSession().getAttribute("serverCode")) {
			serverCode="100000000";
		}else {
			serverCode=(String)request.getSession().getAttribute("serverCode");
		}
		String userName="";
		if(null ==request.getSession().getAttribute("userName")) {
			userName="admin";
		}else {
			userName=(String)request.getSession().getAttribute("userName");
		}
		String fileFolder=request.getParameter("savePath");
		// System.out.println("开始上传文件");
		String userFolder="/userFile/"+fileFolder;
		// 存储路径
		String savePath = request.getServletContext().getRealPath(userFolder);

		//System.out.println("savePath="+savePath);
		// 获取上传的文件集合
		Collection<Part> parts = request.getParts(); 
		//System.out.println("parts.size=" + parts.size());
		/*
		 * Servlet3.0将multipart/form-data的POST请求封装成Part， 通过Part对上传的文件进行操作。
		 * 通过request.getPart("pathStr"); 从上传的文件集合中获取Part对象
		 */
		List fileList= new ArrayList<File>();
		List existFileList=new ArrayList();
		FileManageService fileManageService=new FileManageService();
		for (Part p : parts) {
			// 普通字段封装为part对象数据为null
			if (p.getSubmittedFileName() != null) {
				InputStream inputStream = p.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				String header = p.getHeader("content-disposition");
				// 获取文件名
				String fileName = getFileName(header); 
				File file = new File(savePath + File.separator + fileName);
				/**
				 * 检查文件在数据库与存放文件夹中的存在性，只有两者同时存在时，即存在。
				 * 否则，需要将文件上传到文件夹中。
				 */
				Boolean checkValue=fileManageService.fileExistCheck(fileName,savePath,serverCode);
				if(checkValue.equals(Boolean.TRUE)) {
					//System.out.println("existFileList，fileFolder="+fileFolder);
					existFileList.add(new UploadFile(fileName,userFolder,fileFolder,null));
					//existFileList.add(new UploadFile(fileName,fileFolder,userFolder,null));
				}else {//                                "/userFile/excel","excel",null  
					//System.out.println("fileFolder="+fileFolder);
					fileList.add(new UploadFile(fileName,userFolder,fileFolder,null));
					FileOutputStream fos = new FileOutputStream(file);
					byte[] b = new byte[2048];
					int len = 0;
					while ((len = bis.read(b)) != -1) {
						fos.write(b, 0, len);
					}
					bis.close();
					fos.flush();
					fos.close();
				}
			}
		}
		fileManageService.fileInforSave(fileList,serverCode,userName);
		if(existFileList.size()>0) {
			//System.out.println("existsFileList!!!");
			request.setAttribute("fileList", existFileList);
			request.getRequestDispatcher("/jsp/excelImport/existFileList.jsp").
			forward(request, response);
		}else {
			request.setAttribute("fileList", fileList);
			request.getRequestDispatcher("/jsp/excelImport/uploadFileListManage.jsp").
			forward(request, response);
		}
	}
}
