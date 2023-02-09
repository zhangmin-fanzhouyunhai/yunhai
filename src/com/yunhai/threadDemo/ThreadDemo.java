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
import com.yunhai.txt.service.ArticleManagerServiceMain20211126;
import com.yunhai.util.DataSourceUtils;

//import android.view.Window;

/**
 *
 * ��������������Ʊ����Ʊ��Ϊ100�ţ�ʹ�ü̳���Thread��ʽ �þ�̬������֤�����̵߳����ݶ�һ��
 * 
 * �����̵߳İ�ȫ���⣬�д����
 *
 */

public class ThreadDemo extends Thread {

	public static void main(String[] args) {

		String articleName = "�쳣�������¼";

		window2 t1 = new window2();
		t1.setArticleChapterList(articleName);
		window2 t2 = new window2();
		//t2.setArticleChapterList(articleName);
		window2 t3 = new window2();
		//t3.setArticleChapterList(articleName);

		t1.setName("��Ʊ��1");
		System.out.println("Size of t1:"+t1.getSize());
		t2.setName("��Ʊ��2");
		System.out.println("Size of t2:"+t2.getSize());
		t3.setName("��Ʊ��3");
		System.out.println("Size of t3:"+t3.getSize());

		t1.start();
		t2.start();
		t3.start();
	}

}

class window2 extends Thread {
	private static int size = 100; // �����������ľ�̬���������̹߳����þ�̬����
	private static SessionFactory sf;
	// ��һ��Session
	private static Session session;
	// ��ʼһ������
	private static Transaction tx;
	private List<ArticleChapter> articleChapterList = null; // �����������ľ�̬���������̹߳����þ�̬����
 

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public window2() {
		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// ��һ��Session
		session = sf.openSession();
		// ��ʼһ������
		tx = session.beginTransaction(); 
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
			// System.out.println(msg);

		} else {
			// System.out.println(" articleID=" + article.getArticleID() + ", articleName="
			// + article.getArticleName());

			queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sqlString = "SELECT * FROM articleChapter WHERE 1=1 AND ARTICLEID=? ORDER BY SORTINDEX";
			// String chapterContent = " ���ס��һ�������������ı���С�ǣ�������������޸���ʮ����ʮ���Ļ�Ҳ����ǿ��"
			// + "�����ӽ��£��������ǵصص�������ͨС���Ҫ��ȫ���µĺ��˿�����г��������ͷ�ϵĻ���ǿҲ����"
			// + "�������£�����·��û����ʶ������һ�ų����е�����ζ֮����ô��������ͨͨ���ķ��������˶�ʮ����" +
			// "������Ŀ������һ�����ˣ�����֮�������ɫ�D�D��������ˡ�";
			List<ArticleChapter> list;
			try {
				this.articleChapterList = queryRunner.query(sqlString, new BeanListHandler<>(ArticleChapter.class),
						article.getArticleID());
				this.size=this.articleChapterList.size();
				System.out.println("this.size="+this.size);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() { 
		
		while (true) {
			if (this.size > 0) { 
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("size1:"+getSize()+"articleChapterList.size()="+articleChapterList.size());
				if(articleChapterList.size()==getSize()) {
					this.size--;
					sentenceSplit(this.articleChapterList.get(0));
				}else {
					this.size--;
					System.out.println("articleChapterContent:"+this.articleChapterList.get(articleChapterList.size()-size).getArticleChapterContent());
					sentenceSplit(this.articleChapterList.get(this.articleChapterList.size()-size));
					//articleChapterList.remove(1);
					System.out.println("articleChapterList.size=" + this.size);
				}
			} else {
				break;
			}
		}
		
		//System.out.println("articleChapterList.size=" + articleChapterList.size());
		//for (int chapterI = 0; chapterI < articleChapterList.size(); chapterI++) { //
		//System.out.println("chapter "+chapterI+"  is:"+list.get(chapterI).getArticleChapterContent());
		//sentenceSplit(articleChapterList.get(chapterI), session);
		//articleChapterList.remove(chapterI); }
		 
	}

	private String chapterWordStaticstic(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		// String articleID=getArticleID(articleName);
		Article article = queryArticleByArticleName(articleName );
		String msg = "";
		if (null == article) {
			msg = "����ѯ���������ݿ�δ�ղأ�";
			// System.out.println(msg);

		} else {
			// System.out.println(" articleID=" + article.getArticleID() + ", articleName="
			// + article.getArticleName());

			queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sqlString = "SELECT * FROM articleChapter WHERE 1=1 AND ARTICLEID=? ORDER BY SORTINDEX";
			// String chapterContent = " ���ס��һ�������������ı���С�ǣ�������������޸���ʮ����ʮ���Ļ�Ҳ����ǿ��"
			// + "�����ӽ��£��������ǵصص�������ͨС���Ҫ��ȫ���µĺ��˿�����г��������ͷ�ϵĻ���ǿҲ����"
			// + "�������£�����·��û����ʶ������һ�ų����е�����ζ֮����ô��������ͨͨ���ķ��������˶�ʮ����" +
			// "������Ŀ������һ�����ˣ�����֮�������ɫ�D�D��������ˡ�";
			List<ArticleChapter> list = queryRunner.query(sqlString, new BeanListHandler<>(ArticleChapter.class),
					article.getArticleID());
			System.out.println("list.size=" + list.size());
			for (int chapterI = 0; chapterI < list.size(); chapterI++) {
				// System.out.println("chapter "+chapterI+"
				// is:"+list.get(chapterI).getArticleChapterContent());
				sentenceSplit(list.get(chapterI));
			}
			msg = "Successful";
		}
		return msg;
	}

	private Article queryArticleByArticleName(String articleName) throws SQLException {
		// SessionFactory sf = new
		// Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// ��һ��Session
		// Session session = sf.openSession();
		// ��ʼһ������
		// Transaction tx = session.beginTransaction();

		String articleSqlString = "SELECT * FROM ARTICLE WHERE 1=1 AND ARTICLE_NAME=? ";
		SQLQuery query = session.createSQLQuery(articleSqlString).addEntity(Article.class);
		query.setString(0, articleName);
		List<Article> list = query.list();
		// System.out.println("list size="+list.size()+",articleName="+articleName);
		Article article = null;
		if (list.size() != 0) {
			article = list.get(0);
		}
		return article;
	}

	/**
	 * 
	 * @param chapter ���½�chapter�е������зָ
	 * @param article ��Դ������Ϣ
	 */

	private void sentenceSplit(ArticleChapter articleChapter) {
		String splitCharacter = "[��������������,;���D�D������������������]";
		System.out.println("sentenceSplit.articleChapter.content:"+articleChapter.getArticleChapterContent());
		// ��chapter�е��ַ���ͨ��split���зָ�
		String[] chapterSplitSentence = articleChapter.getArticleChapterContent().trim().replace("(", "")
				.replace(".", "").replace(")", "").replace("-", "").split(splitCharacter);
		// chapter.split(",", 2);
		System.out.println("��ǰ�̣߳�" + getName());
		for (int i = 0; i < chapterSplitSentence.length; i++) {
			 System.out.println("chapterSplitSentence["+i+"]="+chapterSplitSentence[i]);
			List<String> vocabularyList = null;
			
			int vocabularyLengthLimit = 15;
			// ��chapterSplitSentence[i]���ַ�������1��vocabularyLengthLimit���ȵĴʻ�ķָ��������vocabularyList
			vocabularyList = vocabularySplit(chapterSplitSentence[i], vocabularyLengthLimit);

			if (null == vocabularyList) {// ������е��ʷֽ�ʧ�ܣ����ص�vocabularySplitΪ��ʱ��������һ��ķִ�
				continue;
			} else { // �Էִ������б����д�Ƶͳ�ƣ���ʵ��Ӧ�����ٿ�һ���߳̽��в��д�����
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
		// int vocabularyNumber = 1;
		List<String> vocabularyList = new ArrayList<String>();
		/**
		 * ���ַ���sentence����vocabularyLength���Ƚ����ַ����ָ�γɱ�ѡ���飬vocabularyLength���ȴ�2������vocabularyLengthLimit���趨ֵ��
		 * �γɳ���Ϊ2��vocabularyLengthLimit�ı�ѡ�����б���������vocabularyList���С�
		 * 
		 */
		for (int vocabularyLength = 1; vocabularyLength <= limitNumber; vocabularyLength++) {
			for (int sentenceI = 0; sentenceI <= sentence.length() - vocabularyLength; sentenceI++) {
				// System.out.println(sentence);
				// System.out.println(sentence.substring(sentenceI,sentenceI+vocabularyLength));
				vocabularyList.add(sentence.substring(sentenceI, sentenceI + vocabularyLength));
				// vocabularyNumber++;
			}
			/**
			 * ��ѡ�ʵĳ�������1
			 */
			// vocabularyNumber = 1;
		}
		// ���һ��sentence�ķִʺ󣬽��ִ��ַ���List�б���������һ���߳�ȥ�����ַ�����Ϣƥ�䣬ƥ��ɱ��Ľ������ݿ��в�ѯ���ļ�¼��������1

		return vocabularyList;
	}

	/**
	 * 
	 * @param vocabularyList
	 */
	private void vocabularyFrequence(List<String> vocabularyList, ArticleChapter articleChapter) {
		Double frequencyQuantity = 0.0;

		String sqlString = "SELECT frequency FROM vocabularyfrequency WHERE 1=1 and vocabularyContent = ?";

		SQLQuery query = session.createSQLQuery(sqlString);
		String vocabularyFrequencyID = null;
		for (int i = 0; i < vocabularyList.size(); i++) {
			query.setString(0, vocabularyList.get(i));
			List list = query.list();
			// ���û�г��ֹ����������ʻ��������һ����¼���ڴӷ�����ٱ�������һ����¼��
			// frequencyQuantity=vocabularyFrequence(vocabularyList.get(i));
			if (null == list || list.size() == 0 || null == list.get(0) || ((BigDecimal) list.get(0)).intValue() == 0) {
				frequencyQuantity = 1.0;
				vocabularyFrequencyID = addVocabularyFrequence(vocabularyList.get(i));
			} else {
				frequencyQuantity = ((BigDecimal) list.get(0)).doubleValue() + 1.0;
				// ������ڣ���������ʻ�����ֵ�Ƶ�����ڴӷ�����ٱ�������һ����¼��
				vocabularyFrequencyID = updateVocabularyFrequenceQuantity(vocabularyList.get(i), frequencyQuantity);
			}
			 
			if (vocabularyList.get(i).length() > 1) {
				addVocabularySentenceLocation(articleChapter.getArticleChapterID(), vocabularyFrequencyID,
						articleChapter.getArticleChapterContent().indexOf(vocabularyList.get(i)));
			}
			/*
			 * if (frequencyQuantity > 1) { System.out.println("vocabulary=" +
			 * vocabularyList.get(i) + ",frequencyQuantity=" + frequencyQuantity); }
			 */
		}
	}

	private String addVocabularyFrequence(String vocabulary) {
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
		System.out.println("��ǰ�̣߳�" + getName()+"�� add vocabulary="+vocabulary+",maxSortIndex=" + maxSortIndex);
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
		session.beginTransaction().commit();
		// query = session.createSQLQuery(sqlString);
		// System.out.println("vocabulary:"+vocabulary);
		return uuid;
	}

	private String updateVocabularyFrequenceQuantity(String vocabulary, Double frequencyQuantity) {
		System.out.println("��ǰ�̣߳�" + getName()+",update vocabulary:" + vocabulary + ",frequencyQuantity" + frequencyQuantity);
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
		session.beginTransaction().commit();
		return vocabularyFrequencyID;
	}

	private void addVocabularySentenceLocation(String articleChapterID, String vocabularyFrequencyID, int location) {
		SQLQuery query = null;
		String sqlString = "INSERT INTO VocabularyResource (VocabularyResourceID,articleChapterID,"
				+ "VocabularyFrequencyID,calYear)" + "VALUES(?,?,?,?)";

		System.out.println("��ǰ�̣߳�" + getName()+"�� add addVocabularySentenceLocation="+articleChapterID);
		query = session.createSQLQuery(sqlString);
		String uuid = UUID.randomUUID().toString();
		query.setString(0, uuid);
		query.setString(1, articleChapterID);
		query.setString(2, vocabularyFrequencyID);
		query.setDate(3, new Date());
		query.executeUpdate();

		session.flush();
		session.beginTransaction().commit();
		// query = session.createSQLQuery(sqlString);
		// System.out.println("vocabulary:"+vocabulary);
	}
}

class window extends Thread {
	private static int ticket = 100; // �����������ľ�̬���������̹߳����þ�̬����

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
				System.out.println(getName() + "��ǰ�۳���" + ticket + "��Ʊ");
				ticket--;
			} else {
				break;
			}
		}
	}
}