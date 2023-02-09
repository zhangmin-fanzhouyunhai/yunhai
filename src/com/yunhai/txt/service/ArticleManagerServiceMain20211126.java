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
	// 打开一个Session
	private static Session session;
	// 开始一个事务
	private static Transaction tx;

	public ArticleManagerServiceMain20211126() {
		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// 打开一个Session
		session = sf.openSession();
		// 开始一个事务
		tx = session.beginTransaction();
	}
	
	
	public static void main(String[] args) throws SQLException {

		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// 打开一个Session
		session = sf.openSession();
		// 开始一个事务
		tx = session.beginTransaction();
		String startTime = new Date().toString();
		String filePath = "E:\\希灵帝国.txt";
		//readFileContent(filePath);
		String chapter = "    其家住在一个名不见经传的北方小城，如果北京打算修个二十环三十环的话也能勉强算" + "是天子脚下，其人则是地地道道的普通小人物，要是全天下的好人卡都按谐音算在他头上的话勉强也算是"
				+ "名扬天下，走在路上没人认识，顶着一张除了有点男人味之外怎么看都普普通通的四方大脸过了二十来年" + "，人生目标是做一个好人，除此之外毫无特色――这就是他了。";
		//
		// sentenceSplit(chapter) ;
		String sentence = "如果北京打算修个二十环三十环的话也能勉强算是天子脚下";
		// vocabularySplit(sentence);
		String vocabulary = "如果";
		// vocabularyFrequence(vocabulary);
		String articleName = "异常生物见闻录";
		articleName = "Whit Whale";
		articleName = "异常生物见闻录"; 
		articleName = "希灵帝国";
		// articleName = "围猎";
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
		// 打开一个Session
		// Session session = sf.openSession();
		// 开始一个事务
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
			msg = "所查询著作本数据库未收藏！";
			// System.out.println(msg);

		} else {
			// System.out.println(" articleID=" + article.getArticleID() + ", articleName="
			// + article.getArticleName());

			queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
			String sqlString = "SELECT * FROM articleChapter WHERE 1=1 AND ARTICLEID=? ORDER BY SORTINDEX";
			// String chapterContent = " 其家住在一个名不见经传的北方小城，如果北京打算修个二十环三十环的话也能勉强算"
			// + "是天子脚下，其人则是地地道道的普通小人物，要是全天下的好人卡都按谐音算在他头上的话勉强也算是"
			// + "名扬天下，走在路上没人认识，顶着一张除了有点男人味之外怎么看都普普通通的四方大脸过了二十来年" +
			// "，人生目标是做一个好人，除此之外毫无特色――这就是他了。";
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
	 * @param vocabulary 对vocabulary中存放的值在VOCABULARY_FREQUENCE表中进行检测，如果存在，则将QUANTITY的记录加1，
	 *                   并将vocabulary所在的段落编号存入至另外一个表中；
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
			// 如果存在则更新
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
			// 如果没有出现过，则在主词汇表中添加一条记录，在从反向跟踪表中添加一条记录。
			// frequencyQuantity=vocabularyFrequence(vocabularyList.get(i));
			if (null == list || list.size() == 0 || null == list.get(0) || ((BigDecimal) list.get(0)).intValue() == 0) {
				frequencyQuantity = 1.0;
				vocabularyFrequencyID = addVocabularyFrequence(vocabularyList.get(i));
			} else {
				frequencyQuantity = ((BigDecimal) list.get(0)).doubleValue() + 1.0;
				// 如果存在，则更新主词汇表出现的频数，在从反向跟踪表中添加一条记录。
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
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
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
	 * @param chapter 对章节chapter中的语句进行分割。
	 */
	private static void sentenceSplit(String chapter) {
		String[] str = chapter.trim().split("[，-（《》‘’）,――。、()？“”！：……]");
		chapter.split(",", 2);
		for (int i = 0; i < str.length; i++) {
			// System.out.println("str["+i+"]="+str[i]);
			int vocabularyLengthLimit = 15;
			vocabularySplit(str[i], vocabularyLengthLimit);
		}

	}

	/**
	 * 
	 * @param chapter 对章节chapter中的语句进行分割。
	 * @param article 来源文章信息
	 */

	private static void sentenceSplit(ArticleChapter articleChapter) {
		String splitCharacter = "[，（《》‘’）,;-；――。、？“”！：……]";
		// 将chapter中的字符串通过split进行分割
		String[] chapterSplitSentence = articleChapter.getArticleChapterContent().trim().replace("(", "")
				.replace(".", "").replace(")", "").replace("-", "").split(splitCharacter);
		// chapter.split(",", 2);
		System.out.println("当前线程：" + Thread.currentThread().getName());
		for (int i = 0; i < chapterSplitSentence.length; i++) {
			// System.out.println("chapterSplitSentence["+i+"]="+chapterSplitSentence[i]);
			List<String> vocabularyList = null;
			int vocabularyLengthLimit = 15;
			// 将chapterSplitSentence[i]的字符串进行1至vocabularyLengthLimit长度的词汇的分割出来存入vocabularyList
			vocabularyList = vocabularySplit(chapterSplitSentence[i], vocabularyLengthLimit);

			if (null == vocabularyList) {// 如果进行单词分解失败，返回的vocabularySplit为空时，进行下一句的分词
				continue;
			} else { // 对分词完结的列表进行词频统计，事实上应该是再开一个线程进行并行处理。
				vocabularyFrequence(vocabularyList, articleChapter);
			}
		}

	}

	private static List<String> vocabularySplit(String sentence, int vocabularyLengthLimit) {
		/**
		 * 1.将句子分解成2个字符、3个字符、4个字符、5个字符、6个字符、7个字符的词组， 分解成l个字符长度的词组时，字符串的长度length>l。
		 * 2.对生成的词组进行频率统计； 3.对频率出现较多的进行筛选； 4.每个词出现的段落进行记录； 5.
		 */

		int limitNumber = 0;
		/**
		 * 当分割字符串sentence的长度小于最长词组字符串长度时，则备选词组的最大长度为该字符串的长度，
		 * 否则为vocabularyLengthLimit设定的长度。
		 */
		if (sentence.length() < vocabularyLengthLimit) {
			limitNumber = sentence.length();
		} else {
			limitNumber = vocabularyLengthLimit;
		}
		// int vocabularyNumber = 1;
		List<String> vocabularyList = new ArrayList<String>();
		/**
		 * 对字符串sentence做按vocabularyLength长度进行字符串分割，形成备选词组，vocabularyLength长度从2增长至vocabularyLengthLimit的设定值，
		 * 形成长度为2至vocabularyLengthLimit的备选词组列表，均存入vocabularyList表中。
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
			 * 备选词的长度增长1
			 */
			// vocabularyNumber = 1;
		}
		// 完成一个sentence的分词后，将分词字符串List列表，交给另一个线程去进行字符串信息匹配，匹配成本的将从数据库中查询到的记录的数量加1

		return vocabularyList;
	}

	public static String resolveCode(String path) throws Exception {// 根据文档的头部内容区分文档的编码类型

		InputStream inputStream = new FileInputStream(path);

		byte[] head = new byte[3];
		// System.out.println("head[1]="+head[0]+",head[2]="+head[1]+",head[3]="+head[2]);

		inputStream.read(head);

		String code = "UTF-8"; // 或GBK

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
