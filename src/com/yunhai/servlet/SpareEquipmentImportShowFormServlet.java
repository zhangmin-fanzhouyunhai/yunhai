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
	 * ��������ͷ�������ļ��� ����ͷ�ĸ�ʽ�������google������£�form-data; name="file";
	 * filename="snmp4j--api.zip" IE������£�form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header ����ͷ
	 * @return �ļ���
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1���������������������
		 * �������google������£�tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		//System.out.println("tempArr1.size="+tempArr1.length);
		/**
		 * �������google������£�tempArr2={filename,"snmp4j--api.zip"}
		 * IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[tempArr1.length-1].split("=");
		// ��ȡ�ļ��������ݸ����������д��
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		//System.out.println("fileName="+fileName);
		return fileName;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1���ж������ǲ���multipart����
		
		  if (!ServletFileUpload.isMultipartContent(request)) { throw new
		  RuntimeException("��ǰ����֧���ļ��ϴ�"); }
		 
		System.out.println("��ʼ�ϴ��ļ�");   
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
		// �洢·��
		String savePath = request.getServletContext().getRealPath("/userFile/excel");
		//
		System.out.println("pathStr=" + pathStr +",versionValue=" + versionValue + ",calYear=" + calYear);
		// ��ȡ�ϴ����ļ�����
		Collection<Part> parts = request.getParts();
		// Servlet3.0��multipart/form-data��POST�����װ��Part��ͨ��Part���ϴ����ļ����в�����
		// ͨ��request.getPart("pathStr");//���ϴ����ļ������л�ȡPart����
		//Part part = request.getPart(pathStr);
		//ͨ����file�ؼ�(<input type="file" name="file">)������ֱ�ӻ�ȡPart����
		// Servlet3û���ṩֱ�ӻ�ȡ�ļ����ķ���,��Ҫ������ͷ�н�������
		// ��ȡ����ͷ������ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
		//part.getClass();
		
		//
		System.out.println("parts.size="+parts.size());
		
		//String header = part.getHeader("content-disposition");
		// ��ȡ�ļ���
		//String fileName2 = getFileName(header);
		//versionValue="O_2020_1";

		//calYear="2021-04-02 10:40";
		//String fileName2="��14-2020�걸Ʒ����-V1.1-20210402-С��-�滻��ͷ .csv";
		// ���ļ�д��ָ��·��
		//part.write(savePath + File.separator + fileName2);
		// �ϴ������ļ�
		System.out.println("savePath="+savePath);
		//new CsvImportService().spareEquipmentImportSave(savePath+"/"+fileName2, versionValue, calYear);
		// ת��/jsp/excelImport/add.jsp
		request.getRequestDispatcher("/jsp/excelImport/excelImport.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("�ϴ��ɹ�");
		out.flush();
		out.close();
	}

}
