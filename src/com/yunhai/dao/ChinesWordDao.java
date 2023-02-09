package com.yunhai.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.yunhai.orm.WordChinese;
import com.yunhai.util.CommenHibernateUtil;

public class ChinesWordDao {

	public void saveWords(List<String> wordList, String serveCode) {
		String sql = "insert into word_chinese(WORD_CHINESE_VALUE,FREQUENCE,CREATE_DATE) value(?,?,CAST(? AS DATETIME))";
		String updateSql = "update word_chinese set FREQUENCE =? where WORD_CHINESE_VALUE= ?";

		Session session = CommenHibernateUtil.getSession(serveCode);
		Query query = session.createSQLQuery(sql);
		Query updateQuery = session.createSQLQuery(updateSql);
		for (int i = 0; i < wordList.size(); i++) {
			Double frequence = wordFrequenceQuery(wordList.get(i), serveCode);
			/*
			 * ������ص�Ƶ��Ϊ0����ʾ��¼�����ڣ���˲������ݡ�
			 */
			if (frequence == 0) {
				query.setString(0, wordList.get(i));
				query.setDouble(1, 1.0);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
				String dateFormat = sdf.format(new Date());
				query.setString(2, dateFormat);
				// System.out.println("new Date()="+dateFormat);
				query.executeUpdate();
				session.beginTransaction().commit();
			} else {
				/*
				 * ������ص�Ƶ�ʲ�Ϊ0����ʾ��¼���ڣ������ַ�����Ӧ������Ƶ����
				 */
				updateQuery.setDouble(0, frequence + 1.0);
				updateQuery.setString(1, wordList.get(i));
				updateQuery.executeUpdate();
				session.beginTransaction().commit();
			}
		}
	}

	public Double wordFrequenceQuery(String wordValue, String serveCode) {
		String sql = "select FREQUENCE from word_chinese WHERE WORD_CHINESE_VALUE=? ";

		Session session = CommenHibernateUtil.getSession(serveCode);
		Query query = session.createSQLQuery(sql);
		query.setString(0, wordValue);
		List<BigDecimal> list = query.list();
		/**
		 * ������صļ�¼����Ϊ1,�򷵻�Ƶ���������ʾ��¼�����ڣ�����0.
		 */
		if (list.size() == 1) {
			return (Double) list.get(0).doubleValue();
		} else {
			return 0.0;
		}
	}

	public List<WordChinese> queryWordListWithLimitNum(int wordNum,String serveCode) {
		// TODO Auto-generated method stub
		String sql = "select * from word_chinese order by create_date desc limit ?";

		Session session = CommenHibernateUtil.getSession(serveCode);
		SQLQuery query = session.createSQLQuery(sql).addEntity(WordChinese.class);
		query.setInteger(0, wordNum);
		List<WordChinese> wordList = query.list();  
		session.close();
		return wordList;
	}

}
