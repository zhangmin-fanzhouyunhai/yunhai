package com.yunhai.txt.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yunhai.txt.orm.Article;
import com.yunhai.txt.orm.ArticleChapter;
import com.yunhai.util.DataSourceUtils;

public class ArticleManagerServiceMain20211126 {

	private static SessionFactory sf;
	// ��һ��Session
	private static Session session;
	// ��ʼһ������
	private static Transaction tx;

	public ArticleManagerServiceMain20211126() {
		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// ��һ��Session
		session = sf.openSession();
		// ��ʼһ������
		tx = session.beginTransaction();
	}
	
	
	public static void main(String[] args) throws SQLException {

		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// ��һ��Session
		session = sf.openSession();
		// ��ʼһ������
		tx = session.beginTransaction();
		String startTime = new Date().toString();
		String filePath = "E:\\ϣ��۹�.txt";
		//readFileContent(filePath);
		String chapter = "    ���ס��һ�������������ı���С�ǣ�������������޸���ʮ����ʮ���Ļ�Ҳ����ǿ��" + "�����ӽ��£��������ǵصص�������ͨС���Ҫ��ȫ���µĺ��˿�����г��������ͷ�ϵĻ���ǿҲ����"
				+ "�������£�����·��û����ʶ������һ�ų����е�����ζ֮����ô��������ͨͨ���ķ��������˶�ʮ����" + "������Ŀ������һ�����ˣ�����֮�������ɫ�D�D��������ˡ�";
		//
		// sentenceSplit(chapter) ;
		String sentence = "������������޸���ʮ����ʮ���Ļ�Ҳ����ǿ�������ӽ���";
		// vocabularySplit(sentence);
		String vocabulary = "���";
		// vocabularyFrequence(vocabulary);
		String articleName = "�쳣�������¼";
		articleName = "Whit Whale";
		articleName = "�쳣�������¼"; 
		articleName = "ϣ��۹�";
		// articleName = "Χ��";
		String result = "";
		result = chapterWordStaticstic(articleName);
		System.out.println(result);
		String endTime = new Date().toString();
		System.out.println("startTime:" + startTime);
		System.out.println("endTime:" + endTime);
		tx.commit();
		session.close();
		sf.close();
	}

	private static String getArticleID(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String articleSqlString = "SELECT ARTICLE_ID FROM ARTICLE WHERE 1=1 AND ARTICLE_NAME=?";

		return queryRunner.query(articleSqlString, new ScalarHandler(), articleName).toString();

	}

	private static Article getArticleByArticleName(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String articleSqlString = "SELECT ARTICLE_ID FROM ARTICLE WHERE 1=1 AND ARTICLE_NAME=?";

		return queryRunner.query(articleSqlString, new BeanHandler<>(Article.class), articleName);

	}

	private static Article queryArticleByArticleName(String articleName) throws SQLException {
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

	private static String chapterWordStaticstic(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		// String articleID=getArticleID(articleName);
		Article article = queryArticleByArticleName(articleName);
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

	/**
	 * 
	 * @param vocabulary ��vocabulary�д�ŵ�ֵ��VOCABULARY_FREQUENCE���н��м�⣬������ڣ���QUANTITY�ļ�¼��1��
	 *                   ����vocabulary���ڵĶ����Ŵ���������һ�����У�
	 * 
	 */
	private static Double vocabularyFrequence(String vocabulary) {
		String sqlString = "SELECT COUNT(*) QUANTITY FROM vocabularyfrequency WHERE 1=1 and vocabularyContent = ?";

		SQLQuery query = session.createSQLQuery(sqlString);
		query.setString(0, vocabulary);
		List list = query.list();
		Double frequencyQuantity = 0.0;
		// System.out.println("list.get(0)="+(BigInteger)list.get(0));

		if (null == list.get(0) || ((BigInteger) list.get(0)).intValue() == 0) {
			frequencyQuantity = 1.0;
		} else {
			// ������������
			frequencyQuantity = ((BigInteger) list.get(0)).doubleValue() + 1.0;
		}
		if (frequencyQuantity > 1) {
			System.out.println("vocabulary=" + vocabulary + ",frequencyQuantity=" + frequencyQuantity);
		}
		return frequencyQuantity;
	}

	private static String addVocabularyFrequence(String vocabulary) {
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
		System.out.println("maxSortIndex=" + maxSortIndex);
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

	private static String updateVocabularyFrequenceQuantity(String vocabulary, Double frequencyQuantity) {
		System.out.println("vocabulary:" + vocabulary + ",frequencyQuantity" + frequencyQuantity);
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

	private static void addVocabularySentenceLocation(String articleChapterID, String vocabularyFrequencyID,
			int location) {
		SQLQuery query = null;
		String sqlString = "INSERT INTO VocabularyResource (VocabularyResourceID,articleChapterID,"
				+ "VocabularyFrequencyID,calYear)" + "VALUES(?,?,?,?)";
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

	/**
	 * 
	 * @param vocabularyList
	 */
	private static void vocabularyFrequence(List<String> vocabularyList, ArticleChapter articleChapter) {
		Double frequencyQuantity = 0.0;

		String sqlString = "SELECT frequency FROM vocabularyfrequency WHERE 1=1 and vocabularyContent = ?";

		SQLQuery query = session.createSQLQuery(sqlString);
		String vocabularyFrequencyID = null;
		for (int i = 0; i < vocabularyList.size(); i++) {
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
			/*
			 * if (frequencyQuantity > 1) { System.out.println("vocabulary=" +
			 * vocabularyList.get(i) + ",frequencyQuantity=" + frequencyQuantity); }
			 */
		}
	}

	private static void readFileContent(String fileName) {

		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer sbf = new StringBuffer();
		String str = "";
		SessionFactory sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// ��һ��Session
		Session session = sf.openSession();
		// ��ʼһ������
		Transaction tx = session.beginTransaction();

		int i = 1;
		try {
			String code = resolveCode(fileName);
			// reader = new BufferedReader(new FileReader(file));
			InputStream is = new FileInputStream(fileName);
			InputStreamReader isReader = new InputStreamReader(is, code);
			reader = new BufferedReader(isReader);
			String tempStr;
			while ((tempStr = reader.readLine()) != null) {
				// sbf.append(tempStr);
				if (!tempStr.trim().isEmpty()) {
					System.out.println("The i=" + i + "s content is:" + tempStr.trim());
					String uuid = UUID.randomUUID().toString();
					ArticleChapter articleChapter = new ArticleChapter();
					articleChapter.setArticleChapterID(uuid);
					articleChapter.setArticleID("ARTICLE_0002");
					articleChapter.setSortIndex(new Double((i - 1) * 1.0));
					articleChapter.setArticleChapterContent(tempStr.trim());
					session.save(articleChapter);
					if (++i % 5000 == 0) {
						session.flush();
						session.clear();
						tx.commit();
						tx = session.beginTransaction();
					}
				}
			}
			tx.commit();
			session.clear();
			sf.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @param chapter ���½�chapter�е������зָ
	 */
	private static void sentenceSplit(String chapter) {
		String[] str = chapter.trim().split("[��-������������,�D�D����()��������������]");
		chapter.split(",", 2);
		for (int i = 0; i < str.length; i++) {
			// System.out.println("str["+i+"]="+str[i]);
			int vocabularyLengthLimit = 15;
			vocabularySplit(str[i], vocabularyLengthLimit);
		}

	}

	/**
	 * 
	 * @param chapter ���½�chapter�е������зָ
	 * @param article ��Դ������Ϣ
	 */

	private static void sentenceSplit(ArticleChapter articleChapter) {
		String splitCharacter = "[��������������,;-���D�D������������������]";
		// ��chapter�е��ַ���ͨ��split���зָ�
		String[] chapterSplitSentence = articleChapter.getArticleChapterContent().trim().replace("(", "")
				.replace(".", "").replace(")", "").replace("-", "").split(splitCharacter);
		// chapter.split(",", 2);
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName());
		for (int i = 0; i < chapterSplitSentence.length; i++) {
			// System.out.println("chapterSplitSentence["+i+"]="+chapterSplitSentence[i]);
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

	private static List<String> vocabularySplit(String sentence, int vocabularyLengthLimit) {
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
		 * �γɳ���Ϊ2��vocabularyLengthLimit�ı�ѡ�����б�������vocabularyList���С�
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
		// ���һ��sentence�ķִʺ󣬽��ִ��ַ���List�б�������һ���߳�ȥ�����ַ�����Ϣƥ�䣬ƥ��ɱ��Ľ������ݿ��в�ѯ���ļ�¼��������1

		return vocabularyList;
	}

	public static String resolveCode(String path) throws Exception {// �����ĵ���ͷ�����������ĵ��ı�������

		InputStream inputStream = new FileInputStream(path);

		byte[] head = new byte[3];
		// System.out.println("head[1]="+head[0]+",head[2]="+head[1]+",head[3]="+head[2]);

		inputStream.read(head);

		String code = "UTF-8"; // ��GBK

		if (head[0] == -1 && head[1] == -2)

			code = "UTF-16";

		else if (head[0] == -2 && head[1] == -1)

			code = "Unicode";

		else if (head[0] == -17 && head[1] == -69 && head[2] == -65)

			code = "UTF-8";

		inputStream.close();

		System.out.println(code);

		return code;

	}
}
