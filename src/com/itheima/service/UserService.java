package com.itheima.service;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itheima.dao.UserDao;
import com.itheima.user.orm.YunhaiUser;
import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

public class UserService {
	public int regist(YunhaiUser u1) {
		UserDao dao = new UserDao();
		// 獲取session
		//Session session = HibernateUtils.getCurrentSession();
		// 開啟事務
		//Transaction tr = session.beginTransaction();
		/*
		 * SessionFactory sf = new Configuration().configure().buildSessionFactory(); //
		 * 打开一个Session Session session = sf.openSession(); // 开始一个事务 Transaction tr =
		 * session.beginTransaction();
		 */
		
		/*
		 * int result=0; try {
		 * 
		 * dao.save3(u1);
		 * 
		 * // 提交事務 tr.commit(); result=1; } catch (Exception e) { // TODO: handle
		 * exception e.printStackTrace(); //出现问题：回滚事务 tr.rollback(); }finally{
		 * //自己释放资源，现在，session不用关闭，线程结束了，自动关闭的！！！ }
		 */

		int result=dao.save3(u1);  
		
		return result;

	}

	public void save(User u1, User u2) {
		UserDao dao = new UserDao();
		// 獲取session
		Session session = HibernateUtils.getCurrentSession();
		// 開啟事務
		Transaction tr = session.beginTransaction();

		try {

			dao.save1(u1); 
			dao.save2(u2);

			// 提交事務
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//出现问题：回滚事务
			tr.rollback();
		}finally{
			//自己释放资源，现在，session不用关闭，线程结束了，自动关闭的！！！
		}

	}

	public YunhaiUser getUserByUserNameAndPassword(String userName,String password,String serveCode) throws SQLException {
		// TODO Auto-generated method stub
		
		return new UserDao().getUserByUserNameAndPassword(userName,password,serveCode) ;
	}

}
