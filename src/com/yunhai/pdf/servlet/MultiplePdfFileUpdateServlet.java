package com.yunhai.pdf.servlet;

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

import com.yunhai.orm.UploadFile;

@WebServlet("/multiplePdfFileUpdateServlet")
@MultipartConfig
public class MultiplePdfFileUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7749235244449016079L;

	public MultiplePdfFileUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub// �Ȼ�ȡ����Ĳ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		// 1���ж������ǲ���multipart����
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("��ǰ����֧���ļ��ϴ�");
		}
		// System.out.println("��ʼ�ϴ��ļ�");
		String userFolder="/userFile/pdf";
		// �洢·��
		String savePath = request.getServletContext().getRealPath(userFolder);
		// ��ȡ�ϴ����ļ�����
		Collection<Part> parts = request.getParts(); 
		//System.out.println("parts.size=" + parts.size());
		/*
		 * Servlet3.0��multipart/form-data��POST�����װ��Part�� ͨ��Part���ϴ����ļ����в�����
		 * ͨ��request.getPart("pathStr"); ���ϴ����ļ������л�ȡPart����
		 */
		List fileList= new ArrayList<File>();
		for (Part p : parts) {
			// ��ͨ�ֶη�װΪpart��������Ϊnull
			if (p.getSubmittedFileName() != null) {
				InputStream inputStream = p.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				String header = p.getHeader("content-disposition");
				// ��ȡ�ļ���
				String fileName = getFileName(header); 
				
				File file = new File(savePath + File.separator + fileName);
				fileList.add(new UploadFile(fileName,savePath + File.separator + fileName,userFolder,null));//��һ����Ҫ���죬���ܰѷ�������·������¶�ˡ�
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
		
		request.setAttribute("fileList", fileList);
		
		 request.getRequestDispatcher("/jsp/pdf/uploadPdfFilesList.jsp").
		 forward(request, response);

	}
}
