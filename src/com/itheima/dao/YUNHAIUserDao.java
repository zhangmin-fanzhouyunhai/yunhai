package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.itheima.user.orm.YunhaiUser;
import com.yunhai.util.DataSourceUtils;
import com.yunhai.util.HibernateUtils;

public class YUNHAIUserDao {

	/**
	 *  ����1 2020-04-25
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public YunhaiUser getUserByUsername4Ajax(String username) throws SQLException {
		// TODO Auto-generated method stub

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from YUNHAI_USER where USER_NAME=? and rownum<1";

		return qr.query(sql, new BeanHandler<>(YunhaiUser.class), username);
		
	}

	/**
	 * ����1 2020-04-25
	 * @param username
	 * @return
	 */
	public YunhaiUser getUserByUsername4AjaxViaCriteria(String username) {
		// �ȫ@ȡsession
		Session session = HibernateUtils.getSession();
		// ��������
		Transaction tr = session.beginTransaction();

		// Query query=session.createQuery("select ");
		// ��ѯ
		Criteria criteria = session.createCriteria(YunhaiUser.class);

		System.out.println("Dao username=" + username);

		if (username != null && !username.trim().isEmpty()) {
			criteria.add(Restrictions.eq("userName", username));
		}

		List<YunhaiUser> list = criteria.list();
		// criteria.setMaxResults(1);
		System.out.println(list.size());
		//
		YunhaiUser yunhaiUser = (YunhaiUser) criteria.uniqueResult();
		 
		  //YunhaiUser yunhaiUser = null; if(0!=list.size()) { yunhaiUser=(YunhaiUser)
		  // list.get(0); }
		  
		tr.commit();
		session.close();
		return yunhaiUser;
		
	}
}
