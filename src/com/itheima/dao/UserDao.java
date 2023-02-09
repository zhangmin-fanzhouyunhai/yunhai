package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itheima.user.orm.YunhaiUser;
import com.yunhai.orm.User;
import com.yunhai.util.CommenHibernateUtil;
import com.yunhai.util.DataSourceUtils;
import com.yunhai.util.HibernateUtils;

public class UserDao {
	public void save1(User u1) {
		// Session session= HibernateUtils.getSession();
		Session session = HibernateUtils.getCurrentSession();
		// Transaction tr=session.beginTransaction();
		session.save(u1);
		// tr.commit();
		// session.close();
	}

	public boolean checkAccountExists(YunhaiUser u1,Session session) { 
		String sqlStr = "SELECT * FROM YUNHAI_USER WHERE USER_NAME=? ";

		Query query = session.createSQLQuery(sqlStr);
		query.setString(0, u1.getUserName());
		//query.setString(1, u1.getName());
		@SuppressWarnings("unchecked")
		ArrayList<YunhaiUser> list = (ArrayList<YunhaiUser>) query.list();
		int userQuantity = list.size(); 
		System.out.println("queryResult=" + userQuantity);
		if(userQuantity!=0) {
			return true;
		}else{ 
			return false;
		} 
	}

	/**
	 * 添加用户
	 * 
	 * @param u1
	 */
	public int save3(YunhaiUser u1) {
		// Session session= HibernateUtils.getSession();
		// QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		// String sql="insert into YunhaiUser("
		// + "userName,password,email,name,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
		/*
		 * return qr.update(sql,u1.getUserName(), u1.getPassword(), u1.getEmail(),
		 * u1.getName(), u1.getSex(), u1.getBirthday(), u1.getHobby());
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tr = session.beginTransaction();
		u1.setYunhaiUserId("YUNHAI_USER_ID_" + Math.random());
		boolean existCheck=checkAccountExists(u1,session); 
		if(existCheck==true) {
			return 2;
		}else {
		session.save(u1);
		tr.commit();
		}
		existCheck=checkAccountExists(u1,session); 
		session.close();
		if(existCheck==true) {
			return 1;
		}else {
			return 3;
		} 
	}

	public void save2(User u2) {
		// Session session= HibernateUtils.getSession();
		Session session = HibernateUtils.getCurrentSession();
		// Transaction tr=session.beginTransaction();
		session.save(u2);
		// tr.commit();
		// session.close();

	}

	public int userModify(Connection con, User user) {
		return 0;
	}

	public int userAdd(Connection con, User user) {
		return 0;
	}

	public YunhaiUser getUserByUserNameAndPassword(String userName, String password,String serveCode) throws SQLException { 
		String sqlStr = "SELECT * FROM YUNHAI_USER WHERE USER_NAME=? AND PASSWORD=? ";
		//System.out.println("Dao,userName="+userName+",password="+password);
		//QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		//qr.query(sqlStr, new BeanHandler< >(YunhaiUser.class),userName,password);
		
		Session session = null;
		//try {
		//	session = HibernateUtils.getSession();
		//	System.out.println("连接Oracle数据库");
		//}catch (Exception e) {
			// TODO: handle exception
			//session = HibernateMySQLUtils.getSession();
			session = CommenHibernateUtil.getSession(serveCode);
			
			System.out.println("连接MySQL数据库");
		//}
		
		Query query = session.createSQLQuery(sqlStr).addEntity(YunhaiUser.class);
		query.setString(0,userName);
		query.setString(1,password);

		//System.out.println("queryResult=" + query);
		//@SuppressWarnings("unchecked")
		List<YunhaiUser> list =  query.list(); 
		//System.out.println("queryResult=" + list.size());
		if(list.size()==1) {
			return (YunhaiUser) list.get(0);
		}else{ 
			return null;
		} 
		  
	}
	public YunhaiUser getUserByUserNameAndPassword1(String userName, String password) throws SQLException { 
		String sqlStr = "SELECT * FROM YUNHAI_USER WHERE USER_NAME=? AND PASSWORD=? ";
		System.out.println("Dao,userName="+userName+",password="+password);
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		qr.query(sqlStr, new BeanHandler< >(YunhaiUser.class),userName,password);
		
		Session session = HibernateUtils.getSession();
		Query query = session.createSQLQuery(sqlStr).addEntity(YunhaiUser.class);
		query.setString(0,userName);
		query.setString(1,password);
		
		@SuppressWarnings("unchecked")
		List<YunhaiUser> list =  query.list(); 
		//System.out.println("queryResult=" + list.size());
		if(list.size()==1) {
			return (YunhaiUser) list.get(0);
		}else{ 
			return null;
		} 
		  
	}
}
