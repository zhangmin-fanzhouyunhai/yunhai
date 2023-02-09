package com.yunhai.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunhai.orm.Actor;
import com.yunhai.util.CommenHibernateUtil;

public class ActorDao {
 
 

	public void saveActor(Actor actor, String serveCode) {
		// TODO Auto-generated method stub 

		Session session = CommenHibernateUtil.getSession(serveCode); 
		Transaction ts=session.beginTransaction();
		session.save(actor);
		ts.commit();
		session.close();
		
	}

	public List<Actor> queryActorListWithLimitNum(int actorNum, String serveCode) {
		// TODO Auto-generated method stub
		String sql = "select * from actor order by created_time desc limit ?";

		Session session = CommenHibernateUtil.getSession(serveCode);
		SQLQuery query = session.createSQLQuery(sql).addEntity(Actor.class);
		query.setInteger(0, actorNum);
		List<Actor> actorList = query.list();  
		session.close();
		return actorList;
	}

}
