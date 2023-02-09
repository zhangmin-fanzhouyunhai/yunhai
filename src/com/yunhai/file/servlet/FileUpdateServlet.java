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
	 * ��������ͷ�������ļ��� ����ͷ�ĸ�ʽ��
	 * �����google������£�form-data; name="file";
	 * filename="snmp4j--api.zip" 
	 * IE������£�form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header ����ͷ
	 * @return �ļ���
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");
		 * ����ִ����֮���ڲ�ͬ��������£�
		 * tempArr1���������������������
		 * �������google������£�
		 * tempArr1={form-data,name="file",
		 * filename="snmp4j--api.zip"}
		 * IE������£�tempArr1={form-data,name="file",
		 * filename="E:\snmp4j--api.zip"}
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
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1���ж������ǲ���multipart����
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("��ǰ����֧���ļ��ϴ�");
		}
		// System.out.println("��ʼ�ϴ��ļ�"); 
		// �洢·��
		String savePath = request.getServletContext().
				getRealPath("/userFile/excel"); 
		// ��ȡ�ϴ����ļ�����
		//Collection<Part> parts = request.getParts();
		/*
		 * Servlet3.0��multipart/form-data��POST�����װ��Part��
		 * ͨ��Part���ϴ����ļ����в�����
		 * ͨ��request.getPart("pathStr");
		 * ���ϴ����ļ������л�ȡPart����
		 */
		Part part = request.getPart("pathStr");
		/*
		 * ͨ����file�ؼ�(<input type="file" name="file">)
		 * ������ֱ�ӻ�ȡPart����
		 * Servlet3û���ṩֱ�ӻ�ȡ�ļ����ķ���,
		 * ��Ҫ������ͷ�н������� ��ȡ����ͷ��
		 * ����ͷ�ĸ�ʽ��form-data; name="file";
		 * filename="snmp4j--api.zip"
		 */
		part.getClass();

		// System.out.println("parts.size="+parts.size()+
		//",part.getHeader()="+
		//part.getHeader("content-disposition"));

		String header = part.getHeader("content-disposition");
		// ��ȡ�ļ���
		String fileName2 = getFileName(header);
		// ���ļ�д��ָ��·��
		part.write(savePath + File.separator + fileName2);
		// �ϴ������ļ�  
		// ת��/jsp/excelImport/add.jsp
		request.getRequestDispatcher("/jsp/excelImport/uploadFile.jsp").
		forward(request, response); 

	}
}
