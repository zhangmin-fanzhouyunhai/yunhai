package com.yunhai.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yunhai.orm.Actor;
import com.yunhai.service.ActorService;

@WebServlet(value = "/actorAddServlet", loadOnStartup = 1)
@MultipartConfig
public class ActorAddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 923955714447690761L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取请求的参数
		// 0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		// 1.接受两个验证码
		HttpSession httpSession = request.getSession();
		// 从HttpSession中获取serveCode

		String serverCode = (String) request.getSession().getAttribute("serverCode");
		if ((null == serverCode || serverCode.isEmpty()) && null == request.getParameter("serverCode")) {
			serverCode = "100000000";
		} else if (!(null == request.getParameter("serverCode"))) {
			serverCode = request.getParameter("serverCode");
		}
		// System.out.println("serveCode="+serveCode);
		String actorName = request.getParameter("actorName");
		String foreignName = request.getParameter("foreignName");
		String motherLand = request.getParameter("motherLand");
		String description = request.getParameter("description");

		Actor actor = new Actor();
		actor.setActorName(actorName);
		actor.setForeignName(foreignName);
		actor.setMotherLand(motherLand);
		actor.setDescription(description);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
		String dateFormat = sdf.format(new Date());
		// System.out.println("dateFormat="+dateFormat);
		try {
			actor.setCreatedTime(sdf.parse(dateFormat));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new ActorService().saveActor(actor, serverCode);
		List<Actor> actorList = new ActorService().queryActorListWithLimitNum(10, serverCode);
		request.setAttribute("actorList", actorList);
		request.getRequestDispatcher("/jsp/art/artorAdd.jsp").forward(request, response);
	}

}
