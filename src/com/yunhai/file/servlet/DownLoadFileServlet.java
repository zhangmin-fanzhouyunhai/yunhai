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
		// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = (String) request.getSession().getAttribute("userName");
		String fileName = (String) request.getParameter("fileName");
		String path = (String) request.getParameter("path");
		// ���������ļ��洢·��
		String savePath = request.getServletContext().getRealPath("/userFile/" + path);

		String fileNameWithPath = savePath + File.separator + fileName;
		File file = new File(fileNameWithPath);

		if (file.exists()) {
			response.setContentType("application/x-msdownload");
			// �ļ������ã������ļ�����
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
	 * ��������ͷ�������ļ��� ����ͷ�ĸ�ʽ�� �����google������£�form-data; name="file";
	 * filename="snmp4j--api.zip" IE������£�form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header ����ͷ
	 * @return �ļ���
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";"); ����ִ����֮���ڲ�ͬ��������£� tempArr1���������������������
		 * �������google������£� tempArr1={form-data,name="file", filename="snmp4j--api.zip"}
		 * IE������£�tempArr1={form-data,name="file", filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		// System.out.println("tempArr1.size="+tempArr1.length);
		/**
		 * �������google������£�tempArr2={filename,"snmp4j--api.zip"}
		 * IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[tempArr1.length - 1].split("=");
		// ��ȡ�ļ��������ݸ����������д��
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
