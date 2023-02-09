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
	// 初始化登录次数
	public void init() throws ServletException {
		// 获取全局管理者
		ServletContext context = getServletContext();
		// @PostConstruct
		// void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		// }
		// 初始化次数
		context.setAttribute("count", 0);
		System.out.println("Day29,初始化登录总次数成功");
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
		// 先获取请求的参数
		// 0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		// 1.接受两个验证码
		HttpSession httpSession = request.getSession();
		// 从HttpSession中获取checkCode
		String sCode = (String) request.getSession().getAttribute("checkCode");
		// 从request中获取输入的验证码verificationCode。
		String rCode = request.getParameter("verificationCode");
		// 从request中获取服务器的编号。
		String serveCode = request.getParameter("serveCode");
		// System.out.println("serveCode="+serveCode);
		// 向HttpSession中设置服务器的编号
		httpSession.setAttribute("serveCode", serveCode);
		// System.out.println("AccountLoginServlet,getParameter(\"checkCode\")="+request.getParameter("verificationCode"));
		// System.out.println("AccountLoginServlet,checkCode="+request.getSession().getAttribute("checkCode"));
		// System.out.println("rCode="+rCode);
		// System.out.println("sCode="+sCode);

		// 判断两个验证码是否一致
		if (rCode == null || rCode.trim().length() == 0 || sCode == null) {
			// 验证码有问题，提示信息页面跳转到login.jsp
			request.setAttribute("msg", "请重新输入验证码");
			// System.out.println("空");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// if (!rCode.equals(sCode))
		if (!rCode.equalsIgnoreCase(sCode)) {
			// 验证码输入不，提示信息页面跳转到login.jsp
			System.out.println("相等");
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 2.接受用户名和密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String verificationCode = request.getParameter("verificationCode");
		String automaticLogin = request.getParameter("automaticLoginCheckBox");
		// String rememberAccount=request.getParameter("rememberAccountCheckBox");

		// 3.调用userservice getUserByUserNameAndPassword() 返回值user
		YunhaiUser user = null;
		try {
			user = new UserService().getUserByUserNameAndPassword(userName, password, serveCode);
			// System.out.println("userName="+user.getUserName()+",password="+user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.判断user
		if (user == null) {
			// 4.1 若user为空，提示信息，请求转发到login.jsp
			// System.out.println("user is null");
			request.setAttribute("msg", "用户和密码不匹配");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			// 4.获取全局管理者
			ServletContext context = this.getServletContext();
			// 5.获取总次数
			Integer count = (Integer) context.getAttribute("count");
			// 6.将次数+1
			count++;
			// 7.将次数再次设置回全局
			context.setAttribute("count", count);
			// System.out.println("username=" + userName + ",password=" + password +
			// ",count=" + count);

			ServletConfig config = getServletConfig();
			// System.out.println("servletName:" + config.getServletName());
			// 4.2若user不为空，判断是否勾选了记住用户名，将user放入Session
			if ("ok".equals(request.getParameter("rememberAccountCheckBox"))) {
				// 创建cookie userName不能是中文
				Cookie cookie = new Cookie("saveName", userName);
				cookie.setPath(request.getContextPath() + "/");
				cookie.setMaxAge(3600);
				// System.out.println("cookie!");
				// 写回浏览器
				response.addCookie(cookie);
			}
			
			request.getSession().setAttribute("user", user);
			// 一次性验证用完之后从session中移除
			request.getSession().removeAttribute("checkCode");
			// response.setStatus(0, "200");
			// 向前台输出数据用response.getWriter().print（）这种写法
			// JSONArray.fromObject(userInfo);转为json数组格式
			// 也可以返回一个字符串，页面是判断data跟返回的字符串是否相等做逻辑处理
			// 注意下面的命令需要放在正确的执行分枝的最后一行。
			response.getWriter().print(JSONArray.fromObject(user));
			
		}

		// 5.页面重定向 index.jsp
		// response.sendRedirect(request.getContextPath() + "/index.jsp");

		/*
		 * Customer customer = new Customer(); customer.setCustName(userName);
		 * customer.setCustInfo(password); if (null != customer) {
		 */
		// 向前台输出数据用response.getWriter().print（）这种写法

		// JSONArray.fromObject(userInfo);转为json数组格式

		// 也可以返回一个字符串，页面是判断data跟返回的字符串是否相等做逻辑处理

		/* response.getWriter().print(JSONArray.fromObject(customer)); */
		// 4.获取全局管理者
		/* ServletContext context=this.getServletContext(); */
		// 5.获取总次数
		/*
		 * Integer count=(Integer) context.getAttribute("count");
		 */ // 6.将次数+1 count++;
		// 7.将次数再次设置回全局 context.setAttribute("count", count);
		/*
		 * System.out.println("username="+userName+",password="+password+",count="+count
		 * );
		 * 
		 * ServletConfig config=getServletConfig();
		 * System.out.println("servletName:"+config.getServletName()); } else {
		 * response.setCharacterEncoding("UTF-8"); response.setHeader("content-type",
		 * "text/html;charset=UTF-8");
		 * response.getWriter().println("<font color='red'>账户名/密码错误</font>"); return; }
		 */

	}

}
