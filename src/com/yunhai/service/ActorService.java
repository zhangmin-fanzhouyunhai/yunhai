package com.yunhai.service;

import java.util.List;

import com.yunhai.dao.ActorDao;
import com.yunhai.orm.Actor;


public class ActorService {
	public void saveActor(Actor actor,String serveCode){
		new ActorDao().saveActor(actor,serveCode);
	}

	public List<Actor> queryActorListWithLimitNum(int actorNum,String serveCode) {
		// TODO Auto-generated method stub
		List<Actor> actorList=new ActorDao().queryActorListWithLimitNum(actorNum,serveCode);
		return actorList;
	}
}
