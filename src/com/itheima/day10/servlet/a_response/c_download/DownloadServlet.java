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
 * Servlet implementation class DownloadServlet �ļ�����
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
		// ��ȡ�����ļ�������
		String fileName = request.getParameter("name");
		//
		System.out.println("���������Ĳ���������֮ǰ��fileName=" + fileName);
		// ���������Ĳ���������
		// fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		// �������ͷ�е�User-Agent
		String agent = request.getHeader("User-Agent");
		// ���ݲ�ͬ��������в�ͬ�ı���
		String fileNameEncoder = "";
		/*
		 * if (agent.contains("MSIE")) { // IE����� 
		 * fileNameEncoder =
		 * URLEncoder.encode(fileName, "utf-8"); 
		 * fileNameEncoder =
		 * fileNameEncoder.replace("+", " "); 
		 * } else if (agent.contains("Firefox")) 
		 * { //�������� 
		 * BASE64Encoder base64Encoder = new BASE64Encoder(); 
		 * fileNameEncoder =
		 * "=?utf-8?B?" + 
		 * base64Encoder.encode(fileName.getBytes("utf-8")) + "?="; 
		 * }else { // ��������� 
		 * fileNameEncoder = URLEncoder.encode(fileName, "utf-8"); 
		 * }
		 */
		//�ù�����DwonLoadUtils�滻
		fileNameEncoder = DownloadUtils.getName(agent, fileName);
		//
		System.out.println("���������Ĳ���������֮��fileNameEncoder=" + fileNameEncoder);
		// �ļ�����
		ServletContext context = this.getServletContext();

		// 1.�����ļ���mimeType
		// context.getMimeType(fileNameEncoder);������ļ��Ĵ�����
		String mimeType = context.getMimeType(fileNameEncoder);

		//System.out.println("mimeType=" + mimeType); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType(mimeType);
		// 2.�������ص�ͷ��Ϣ����ͷ���־��������ļ������֣�
		//Ϊ���������ļ������������룬��Ҫʹ�ô����������ļ���������
		response.setHeader("content-disposition", "attachment;fileName=" + fileNameEncoder);
		// 3.�Կ���
		// ��ȡ����Դ
		// context.getRealPath("/projectLearn/day10/download/day10.txt");
		//������ļ��Ĵ�����
		// context.getResourceAsStream("/projectLearn/day10/download/" +
		// fileName);//�������䲻�����ļ��Ĵ����ԣ���ʹ��ʱ����ļ������ڻᱨ��
		// getResourceAsStream��ȡ����webRootĿ¼�µ��ļ������Ƕ�Ӧ��Ŀ���Ŀ¼�µ�·����
		//��������Ŀ����·�������ļ��ϴ����̲Ż�ʹ�þ���·����
		// ����ʱ�����������ļ�����Ҫʹ�ô����������ļ���������
		//������Ϊ�������ļ����Ʊ���ˡ�2020%E5%B9%....xls�������ַ�����
		// ϵͳ���޷��ڱ����ҵ���ȷ���ļ���
		InputStream is = context.getResourceAsStream("/projectLearn/day10/download/" + fileName);
		// ��ȡ�����
		ServletOutputStream os = response.getOutputStream();
		// System.out.println("is.toString()"+is.toString());
		// ����1.
		/*
		 * int len = -1; byte[] 
		 * buffer = new byte[1024]; 
		 * while ((len =
		 * is.read(buffer))!= -1) { 
		 * os.write(buffer, 0, len); 
		 * }
		 */
		// ����2.��Ҫcommons.io-2.2.jar��
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
