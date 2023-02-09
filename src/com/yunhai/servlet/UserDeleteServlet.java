package com.yunhai.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.itheima.dao.UserDao;
import java.sql.Connection;
import com.yunhai.orm.User;
import com.yunhai.util.DbUtil;
import com.yunhai.util.ResponseUtil;
import com.yunhai.util.StringUtil;

public class UserDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userId");
		String userName=request.getParameter("userName");
		Date userBirthday=new Date(request.getParameter("userBirthday"));
		String userPhone=request.getParameter("userPhone");
		String userMobile=request.getParameter("userMobile");
		String userInfo=request.getParameter("userInfo"); 
		
		
		
		User user=new User(id, userName,userBirthday, userPhone, userMobile,userInfo);
		if(StringUtil.isNotEmpty(id)){
			user.settUserId(Long.parseLong(id));
		}
		
		Connection con=null;
		try {
			int saveNums=0;
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(id)){
				saveNums=userDao.userModify(con, user);
			}else{
				saveNums=userDao.userAdd(con, user);
			}
			if(saveNums==1){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "±£´æ³É¹¦");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
