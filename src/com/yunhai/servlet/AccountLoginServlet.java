package com.yunhai.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.service.UserService;
import com.itheima.user.orm.YunhaiUser;

import net.sf.json.JSONArray;

@WebServlet(value = "/accountLogin", loadOnStartup = 1)
@MultipartConfig
public class AccountLoginServlet extends HttpServlet {
	@Override
	// ��ʼ����¼����
	public void init() throws ServletException {
		// ��ȡȫ�ֹ�����
		ServletContext context = getServletContext();
		// @PostConstruct
		// void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		// }
		// ��ʼ������
		context.setAttribute("count", 0);
		System.out.println("Day29,��ʼ����¼�ܴ����ɹ�");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045095885972804611L;

	public AccountLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		// �Ȼ�ȡ����Ĳ���
		// 0.���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		// 1.����������֤��
		HttpSession httpSession = request.getSession();
		// ��HttpSession�л�ȡcheckCode
		String sCode = (String) request.getSession().getAttribute("checkCode");
		// ��request�л�ȡ�������֤��verificationCode��
		String rCode = request.getParameter("verificationCode");
		// ��request�л�ȡ�������ı�š�
		String serveCode = request.getParameter("serveCode");
		// System.out.println("serveCode="+serveCode);
		// ��HttpSession�����÷������ı��
		httpSession.setAttribute("serveCode", serveCode);
		// System.out.println("AccountLoginServlet,getParameter(\"checkCode\")="+request.getParameter("verificationCode"));
		// System.out.println("AccountLoginServlet,checkCode="+request.getSession().getAttribute("checkCode"));
		// System.out.println("rCode="+rCode);
		// System.out.println("sCode="+sCode);

		// �ж�������֤���Ƿ�һ��
		if (rCode == null || rCode.trim().length() == 0 || sCode == null) {
			// ��֤�������⣬��ʾ��Ϣҳ����ת��login.jsp
			request.setAttribute("msg", "������������֤��");
			// System.out.println("��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// if (!rCode.equals(sCode))
		if (!rCode.equalsIgnoreCase(sCode)) {
			// ��֤�����벻����ʾ��Ϣҳ����ת��login.jsp
			System.out.println("���");
			request.setAttribute("msg", "��֤���������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 2.�����û���������
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String verificationCode = request.getParameter("verificationCode");
		String automaticLogin = request.getParameter("automaticLoginCheckBox");
		// String rememberAccount=request.getParameter("rememberAccountCheckBox");

		// 3.����userservice getUserByUserNameAndPassword() ����ֵuser
		YunhaiUser user = null;
		try {
			user = new UserService().getUserByUserNameAndPassword(userName, password, serveCode);
			// System.out.println("userName="+user.getUserName()+",password="+user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.�ж�user
		if (user == null) {
			// 4.1 ��userΪ�գ���ʾ��Ϣ������ת����login.jsp
			// System.out.println("user is null");
			request.setAttribute("msg", "�û������벻ƥ��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			// 4.��ȡȫ�ֹ�����
			ServletContext context = this.getServletContext();
			// 5.��ȡ�ܴ���
			Integer count = (Integer) context.getAttribute("count");
			// 6.������+1
			count++;
			// 7.�������ٴ����û�ȫ��
			context.setAttribute("count", count);
			// System.out.println("username=" + userName + ",password=" + password +
			// ",count=" + count);

			ServletConfig config = getServletConfig();
			// System.out.println("servletName:" + config.getServletName());
			// 4.2��user��Ϊ�գ��ж��Ƿ�ѡ�˼�ס�û�������user����Session
			if ("ok".equals(request.getParameter("rememberAccountCheckBox"))) {
				// ����cookie userName����������
				Cookie cookie = new Cookie("saveName", userName);
				cookie.setPath(request.getContextPath() + "/");
				cookie.setMaxAge(3600);
				// System.out.println("cookie!");
				// д�������
				response.addCookie(cookie);
			}
			
			request.getSession().setAttribute("user", user);
			// һ������֤����֮���session���Ƴ�
			request.getSession().removeAttribute("checkCode");
			// response.setStatus(0, "200");
			// ��ǰ̨���������response.getWriter().print��������д��
			// JSONArray.fromObject(userInfo);תΪjson�����ʽ
			// Ҳ���Է���һ���ַ�����ҳ�����ж�data�����ص��ַ����Ƿ�������߼�����
			// ע�������������Ҫ������ȷ��ִ�з�֦�����һ�С�
			response.getWriter().print(JSONArray.fromObject(user));
			
		}

		// 5.ҳ���ض��� index.jsp
		// response.sendRedirect(request.getContextPath() + "/index.jsp");

		/*
		 * Customer customer = new Customer(); customer.setCustName(userName);
		 * customer.setCustInfo(password); if (null != customer) {
		 */
		// ��ǰ̨���������response.getWriter().print��������д��

		// JSONArray.fromObject(userInfo);תΪjson�����ʽ

		// Ҳ���Է���һ���ַ�����ҳ�����ж�data�����ص��ַ����Ƿ�������߼�����

		/* response.getWriter().print(JSONArray.fromObject(customer)); */
		// 4.��ȡȫ�ֹ�����
		/* ServletContext context=this.getServletContext(); */
		// 5.��ȡ�ܴ���
		/*
		 * Integer count=(Integer) context.getAttribute("count");
		 */ // 6.������+1 count++;
		// 7.�������ٴ����û�ȫ�� context.setAttribute("count", count);
		/*
		 * System.out.println("username="+userName+",password="+password+",count="+count
		 * );
		 * 
		 * ServletConfig config=getServletConfig();
		 * System.out.println("servletName:"+config.getServletName()); } else {
		 * response.setCharacterEncoding("UTF-8"); response.setHeader("content-type",
		 * "text/html;charset=UTF-8");
		 * response.getWriter().println("<font color='red'>�˻���/�������</font>"); return; }
		 */

	}

}
