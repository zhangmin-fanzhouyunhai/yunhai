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
 * @author Zhang Min 2022/9/19 20:17 �������1�������ϣ��ļ������zipѹ��������ʽ����
 *
 */
@WebServlet("/downLoadFileAndZip")
@MultipartConfig
public class DownLoadFileAndZip extends HttpServlet {
	private static final long serialVersionUID = 2045095885972804611L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=(String)request.getSession().getAttribute("userName");
		String fileName = (String) request.getParameter("fileName");
		String path = (String) request.getParameter("path");
		//���������ļ��洢·��
		String savePath = request.getServletContext().getRealPath("/userFile/"+path);
		
		
		String fileNameWithPath = savePath + File.separator + fileName;
		File file = new File(fileNameWithPath);
		
		String outputFileName=fileName.substring(0,fileName.lastIndexOf("."))+".zip";
		response.setContentType("application/x-msdownload");
		//�ļ������ã������ļ�����
		response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(outputFileName, "UTF-8"));
		ZipOutputStream zipOutputStream= new ZipOutputStream(response.getOutputStream());
		if (file.exists()) {
			/**
			 * �˴�Ϊ�˱�֤������������ļ������������룬����������Ϊutf-8
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
			//���ý�ѹ�ļ����ע�����ݣ����������룬����������Ϊgbk
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
