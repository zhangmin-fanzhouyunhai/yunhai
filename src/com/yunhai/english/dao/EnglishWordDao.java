package com.yunhai.english.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunhai.english.orm.EnglishWord;
import com.yunhai.orm.WordChinese;
import com.yunhai.util.CommenHibernateUtil;
import com.yunhai.util.DateFormatUtil;

import antlr.Utils;

public class EnglishWordDao {

	public void addEnglishWord(String serverCode,EnglishWord englisWord) {
		// TODO Auto-generated method stub
		Session session = CommenHibernateUtil.getSession("100000000");
		englisWord.setCreateDate(new Date());
		Transaction ts=session.beginTransaction();
		session.save(englisWord);
		ts.commit();
	}

	public List<EnglishWord> queryWordListWithLimitNum(int wordNum, String serveCode) {
		// TODO Auto-generated method stub
		String sql = "select * from english_word order by create_date desc limit ?";

		Session session = CommenHibernateUtil.getSession(serveCode);
		SQLQuery query = session.createSQLQuery(sql).addEntity(EnglishWord.class);
		query.setInteger(0, wordNum);
		List<EnglishWord> wordList = query.list();  
		session.close();
		return wordList;
	}

}
