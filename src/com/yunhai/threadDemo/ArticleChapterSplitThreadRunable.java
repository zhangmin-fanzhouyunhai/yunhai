package com.yunhai.threadDemo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yunhai.txt.orm.Article;
import com.yunhai.txt.orm.ArticleChapter;
import com.yunhai.util.DataSourceUtils;

public class ArticleChapterSplitThreadRunable {

	public static void main(String[] args) {
		String articleName = "�쳣�������¼";
		articleName = "��������ݴ��Ի��ж�Զ���ⳡ�й��񾭵��ں��Ի��ӿڵĻ���ɻ�����";
		ArticleChapterSplitRunableThread articleChapterSplitRunableThread = new ArticleChapterSplitRunableThread();
		articleChapterSplitRunableThread.setArticleChapterList(articleName);
		// ��Ȼ�������̣߳�����ֻ��һ��������ʵ�ֵ�Runnable���������������̹߳���һ��window���������Զ�����100��Ʊ

		Thread t1 = new Thread(articleChapterSplitRunableThread);
		//Thread t2 = new Thread(articleChapterSplitRunableThread);
		//Thread t3 = new Thread(articleChapterSplitRunableThread);

		t1.setName("Thread1");
		//t2.setName("Thread2");
		//t3.setName("Thread3");

		t1.start();
		//t2.start();
		//t3.start();
	}
}

class ArticleChapterSplitRunableThread implements Runnable {
 
	private static int size = 100; // �����������ľ�̬���������̹߳���þ�̬����
	private static List<ArticleChapter> articleChapterList = null; // �����������ľ�̬���������̹߳���þ�̬����
	private static SessionFactory sf;

	@Override
	public void run() {
		while (true) {
			if (size > 0) { 
				System.out.println("getSize()="+size);
				System.out.println("getArticleChapterList().size()="+size);
				if(articleChapterList.size()==getSize()) {
					size--;
					System.out.println("if:getSize()="+size);
					System.out.println("getSize()--="+size);
					sentenceSplit(this.articleChapterList.get(0));
				}else {
					size--;
					System.out.println("else :articleChapterContent:"+this.articleChapterList.get(articleChapterList.size()-size).getArticleChapterContent());
					sentenceSplit(this.articleChapterList.get(this.articleChapterList.size()-size));
					//articleChapterList.remove(1);
					System.out.println("articleChapterList.size=" + size);
				}
			} else { 
				break;
			}
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArticleChapterSplitRunableThread() {
		sf = new Configuration().configure("hibernateMySQL2.cfg.xml").buildSessionFactory();

	}

	public List<ArticleChapter> getArticleChapterList() {
		return articleChapterList;
	}

	public void setArticleChapterList(List<ArticleChapter> articleChapterList) {
		this.articleChapterList = articleChapterList;
	}

	public void setArticleChapterList(String articleName) {

		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		// String articleID=getArticleID(articleName);
		Article article = null;
		try {
			article = queryArticleByArticleName(articleName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = "";
		if (null == article) {
			msg = "����ѯ���������ݿ�δ�ղأ�";
		} else {
			queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sqlString = "SELECT * FROM articleChapter WHERE 1=1 AND ARTICLEID=? ORDER BY SORTINDEX";
			List<ArticleChapter> list;
			try {
				this.articleChapterList = queryRunner.query(sqlString, new BeanListHandler<>(ArticleChapter.class),
						article.getArticleID());
				this.size = this.articleChapterList.size();
				System.out.println("this.size=" + this.size);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String chapterWordStaticstic(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource()); 
		Article article = queryArticleByArticleName(articleName);
		String msg = "";
		if (null == article) {
			msg = "����ѯ���������ݿ�δ�ղأ�";
		} else {
			queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sqlString = "SELECT * FROM articleChapter WHERE 1=1 AND ARTICLEID=? ORDER BY SORTINDEX";

			List<ArticleChapter> list = queryRunner.query(sqlString, new BeanListHandler<>(ArticleChapter.class),
					article.getArticleID());
			System.out.println("list.size=" + list.size());
			for (int chapterI = 0; chapterI < list.size(); chapterI++) {
				sentenceSplit(list.get(chapterI));
			}
			msg = "Successful";
		}
		return msg;
	}

	private Article queryArticleByArticleName(String articleName) throws SQLException { 
		//���� Session 
		Session session = sf.openSession(); 
		String articleSqlString = "SELECT * FROM ARTICLE WHERE 1=1 AND ARTICLE_NAME=? ";
		SQLQuery query = session.createSQLQuery(articleSqlString).addEntity(Article.class);
		query.setString(0, articleName);
		List<Article> list = query.list();
		// System.out.println("list size="+list.size()+",articleName="+articleName);
		Article article = null;
		if (list.size() != 0) {
			article = list.get(0);
		}
		session.close();
		return article;
	}

	/**
	 * 
	 * @param chapter ���½�chapter�е������зָ
	 * @param article ��Դ������Ϣ
	 */

	private void sentenceSplit(ArticleChapter articleChapter) {
		String splitCharacter = "[��������������,;���D�D������������������]";
		System.out.println("sentenceSplit.articleChapter.content:" + articleChapter.getArticleChapterContent());
		// ��chapter�е��ַ���ͨ��split���зָ�
		String[] chapterSplitSentence = articleChapter.getArticleChapterContent().trim().replace("(", "")
				.replace(".", "").replace(")", "").replace("-", "").split(splitCharacter);
		for (int i = 0; i < chapterSplitSentence.length; i++) {
			System.out.println(
					"��ǰ�̣߳�"+Thread.currentThread().getName()+
					",chapterSplitSentence[" + i + "]=" + chapterSplitSentence[i]);
			List<String> vocabularyList = null;

			int vocabularyLengthLimit = 15;
			// ��chapterSplitSentence[i]���ַ�������1��vocabularyLengthLimit���ȵĴʻ�ķָ��������vocabularyList
			vocabularyList = vocabularySplit(chapterSplitSentence[i], vocabularyLengthLimit);

			if (null == vocabularyList) {// ������е��ʷֽ�ʧ�ܣ����ص�vocabularySplitΪ��ʱ��������һ��ķִ�
				continue;
			} else { // �Էִ������б���д�Ƶͳ�ƣ���ʵ��Ӧ�����ٿ�һ���߳̽��в��д���
				vocabularyFrequence(vocabularyList, articleChapter);
			}
		}

	}

	private List<String> vocabularySplit(String sentence, int vocabularyLengthLimit) {
		/**
		 * 1.�����ӷֽ��2���ַ���3���ַ���4���ַ���5���ַ���6���ַ���7���ַ��Ĵ��飬 �ֽ��l���ַ����ȵĴ���ʱ���ַ����ĳ���length>l��
		 * 2.�����ɵĴ������Ƶ��ͳ�ƣ� 3.��Ƶ�ʳ��ֽ϶�Ľ���ɸѡ�� 4.ÿ���ʳ��ֵĶ�����м�¼�� 5.
		 */

		int limitNumber = 0;
		/**
		 * ���ָ��ַ���sentence�ĳ���С��������ַ�������ʱ����ѡ�������󳤶�Ϊ���ַ����ĳ��ȣ�
		 * ����ΪvocabularyLengthLimit�趨�ĳ��ȡ�
		 */
		if (sentence.length() < vocabularyLengthLimit) {
			limitNumber = sentence.length();
		} else {
			limitNumber = vocabularyLengthLimit;
		} 
		List<String> vocabularyList = new ArrayList<String>();
		/**
		 * ���ַ���sentence����vocabularyLength���Ƚ����ַ����ָ�γɱ�ѡ���飬vocabularyLength���ȴ�2������vocabularyLengthLimit���趨ֵ��
		 * �γɳ���Ϊ2��vocabularyLengthLimit�ı�ѡ�����б�������vocabularyList���С�
		 * 
		 */
		for (int vocabularyLength = 1; vocabularyLength <= limitNumber; vocabularyLength++) {
			for (int sentenceI = 0; sentenceI <= sentence.length() - vocabularyLength; sentenceI++) {
				vocabularyList.add(sentence.substring(sentenceI, sentenceI + vocabularyLength));
			}
		}
		// ���һ��sentence�ķִʺ󣬽��ִ��ַ���List�б�������һ���߳�ȥ�����ַ�����Ϣƥ�䣬ƥ��ɱ��Ľ������ݿ��в�ѯ���ļ�¼��������1

		return vocabularyList;
	}

	/**
	 * 
	 * @param vocabularyList
	 */
	private void vocabularyFrequence(List<String> vocabularyList, ArticleChapter articleChapter) {
		Double frequencyQuantity = 0.0;

		// ��һ��Session
		Session session = sf.openSession();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		String sqlString = "SELECT frequency FROM vocabularyfrequency WHERE 1=1 and vocabularyContent = ?";

		SQLQuery query = null;
		String vocabularyFrequencyID = null;
		for (int i = 0; i < vocabularyList.size(); i++) {
			query = session.createSQLQuery(sqlString);
			query.setString(0, vocabularyList.get(i));
			List list = query.list();
			// ���û�г��ֹ����������ʻ�������һ����¼���ڴӷ�����ٱ������һ����¼��
			// frequencyQuantity=vocabularyFrequence(vocabularyList.get(i));
			if (null == list || list.size() == 0 || null == list.get(0) || ((BigDecimal) list.get(0)).intValue() == 0) {
				frequencyQuantity = 1.0;
				vocabularyFrequencyID = addVocabularyFrequence(vocabularyList.get(i));
			} else {
				frequencyQuantity = ((BigDecimal) list.get(0)).doubleValue() + 1.0;
				// ������ڣ���������ʻ����ֵ�Ƶ�����ڴӷ�����ٱ������һ����¼��
				vocabularyFrequencyID = updateVocabularyFrequenceQuantity(vocabularyList.get(i), frequencyQuantity);
			}

			if (vocabularyList.get(i).length() > 1) {
				addVocabularySentenceLocation(articleChapter.getArticleChapterID(), vocabularyFrequencyID,
						articleChapter.getArticleChapterContent().indexOf(vocabularyList.get(i)));
			}
		}
		session.close();
	}

	private String addVocabularyFrequence(String vocabulary) {
		// ��һ��Session
		Session session = sf.openSession();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		SQLQuery query = null;
		String queryString = "SELECT max(sortIndex) sortIndex from vocabularyfrequency ";
		query = session.createSQLQuery(queryString);
		Double maxSortIndex = 0.0;
		if (null == query.uniqueResult()) {
			maxSortIndex = 0.0;
		} else {
			maxSortIndex = (((BigDecimal) query.uniqueResult()).doubleValue());
		}
		maxSortIndex++;
		System.out.println(
				"��ǰ�̣߳�"+Thread.currentThread().getName()+
				",add vocabulary=" + vocabulary + ",maxSortIndex=" + maxSortIndex);
		String sqlString = "INSERT INTO vocabularyfrequency (vocabularyFrequencyID,dataVersion,"
				+ "calYear,vocabularyContent,frequency,sortIndex)" + "VALUES(?,?,?,?,?,?)";
		query = session.createSQLQuery(sqlString);
		String uuid = UUID.randomUUID().toString();
		query.setString(0, uuid);
		query.setString(1, "O_2021_1");
		query.setDate(2, new Date());
		query.setString(3, vocabulary);
		query.setInteger(4, 1);
		query.setDouble(5, maxSortIndex);
		query.executeUpdate();

		session.flush();
		//
		session.beginTransaction().commit();
		session.close();
		return uuid;
	}

	private String updateVocabularyFrequenceQuantity(String vocabulary, Double frequencyQuantity) {

		// ��һ��Session
		Session session = sf.openSession();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		System.out.println(
				"��ǰ�̣߳�"+Thread.currentThread().getName()+
				",update vocabulary:" + vocabulary + ",frequencyQuantity" + frequencyQuantity);
		SQLQuery query = null;
		String queryString = "SELECT vocabularyFrequencyID FROM vocabularyFrequency WHERE vocabularyContent=?";
		query = session.createSQLQuery(queryString);
		query.setString(0, vocabulary);
		String vocabularyFrequencyID = query.list().get(0).toString();

		String updateString = "UPDATE vocabularyfrequency SET FREQUENCY=? WHERE vocabularyContent=?";
		query = session.createSQLQuery(updateString);
		query.setDouble(0, frequencyQuantity);
		query.setString(1, vocabulary);
		query.executeUpdate();
		session.flush();
		//
		session.beginTransaction().commit();
		session.close();
		return vocabularyFrequencyID;
	}

	private void addVocabularySentenceLocation(String articleChapterID, String vocabularyFrequencyID, int location) {
		// ��һ��Session
		Session session = sf.openSession();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();
		SQLQuery query = null;
		String sqlString = "INSERT INTO VocabularyResource (VocabularyResourceID,articleChapterID,"
				+ "VocabularyFrequencyID,calYear)" + "VALUES(?,?,?,?)";

		System.out.println(
				"��ǰ�̣߳�"+Thread.currentThread().getName()+
				",add addVocabularySentenceLocation=" + articleChapterID);
		query = session.createSQLQuery(sqlString);
		String uuid = UUID.randomUUID().toString();
		query.setString(0, uuid);
		query.setString(1, articleChapterID);
		query.setString(2, vocabularyFrequencyID);
		query.setDate(3, new Date());
		query.executeUpdate();

		session.flush();
		session.beginTransaction().commit();
		session.close();
	}
}
