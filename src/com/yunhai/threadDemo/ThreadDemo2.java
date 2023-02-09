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

public class ThreadDemo2 {

	public static void main(String[] args) {

		String articleName = "异常生物见闻录";

		window3 t1 = new window3();
		t1.setArticleChapterList(articleName);
		window3 t2 = new window3();
		//t2.setArticleChapterList(articleName);
		window3 t3 = new window3();
		//t3.setArticleChapterList(articleName);
		window3 t4 = new window3();
		window3 t5 = new window3();

		t1.setName("Thread1");
		System.out.println("Size of t1:"+t1.getSize());
		t2.setName("Thread2");
		System.out.println("Size of t2:"+t2.getSize());
		t3.setName("Thread3");
		System.out.println("Size of t3:"+t3.getSize());
		t4.setName("Thread4");
		System.out.println("Size of t4:"+t4.getSize());
		t5.setName("Thread5");
		System.out.println("Size of t5:"+t5.getSize());
		String startTime=new Date().toString();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		String endTime=new Date().toString();
		System.out.println("startTime:"+startTime+",endTime"+endTime);
		
	}

}

class window3 extends Thread {
	private static int size = 100; // 将其加载在类的静态区，所有线程共享该静态变量
	private static List<ArticleChapter> articleChapterList = null; // 将其加载在类的静态区，所有线程共享该静态变量
	private static SessionFactory sf; 
	
	@Override
	public void run() {
		
		while (true) {
			if (size > 0) { 
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("size1:"+getSize()+"articleChapterList.size()="+articleChapterList.size());
				System.out.println("getSize()="+size);
				System.out.println("getArticleChapterList().size()="+size);
				if(articleChapterList.size()==getSize()) {
					size--;
					System.out.println(getName()+",if:getSize()="+size);
					System.out.println("getSize()--="+size);
					sentenceSplit(this.articleChapterList.get(0));
				}else {
					size--;
					System.out.println(getName()+"，else :articleChapterContent:"+this.articleChapterList.get(articleChapterList.size()-size).getArticleChapterContent());
					sentenceSplit(this.articleChapterList.get(this.articleChapterList.size()-size));
					//articleChapterList.remove(1);
					System.out.println("articleChapterList.size=" + size);
				}
			} else {
				System.out.println(getName()+"break!");
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

	public window3() {
		sf = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		
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


	private String chapterWordStaticstic(String articleName) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		// String articleID=getArticleID(articleName);
		Article article = queryArticleByArticleName(articleName );
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

	private Article queryArticleByArticleName(String articleName) throws SQLException {
		// SessionFactory sf = new
		// Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory();
		// 打开一个Session
		// Session session = sf.openSession();
		// 开始一个事务
		// Transaction tx = session.beginTransaction();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		//Transaction	tx = session.beginTransaction(); 
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
	 * @param chapter 对章节chapter中的语句进行分割。
	 * @param article 来源文章信息
	 */

	private void sentenceSplit(ArticleChapter articleChapter) {
		String splitCharacter = "[，（《》‘’）,;；――。、？“”！：……]";
		System.out.println(getName()+",sentenceSplit.articleChapter.content:"+articleChapter.getArticleChapterContent());
		// 将chapter中的字符串通过split进行分割
		String[] chapterSplitSentence = articleChapter.getArticleChapterContent().trim().replace("(", "")
				.replace(".", "").replace(")", "").replace("-", "").split(splitCharacter);
		// chapter.split(",", 2);
		System.out.println("当前线程：" + getName());
		for (int i = 0; i < chapterSplitSentence.length; i++) {
			 System.out.println(getName()+",chapterSplitSentence["+i+"]="+chapterSplitSentence[i]);
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

	private List<String> vocabularySplit(String sentence, int vocabularyLengthLimit) {
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

	/**
	 * 
	 * @param vocabularyList
	 */
	private void vocabularyFrequence(List<String> vocabularyList, ArticleChapter articleChapter) {
		Double frequencyQuantity = 0.0;

		// 打开一个Session
		Session session = sf.openSession();
				// 开始一个事务
		Transaction	tx = session.beginTransaction(); 
		String sqlString = "SELECT frequency FROM vocabularyfrequency WHERE 1=1 and vocabularyContent = ?";

		SQLQuery query = null;
		String vocabularyFrequencyID = null;
		for (int i = 0; i < vocabularyList.size(); i++) {
			query = session.createSQLQuery(sqlString);
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
		session.close();
	}

	private String addVocabularyFrequence(String vocabulary) {
		// 打开一个Session
		Session session = sf.openSession();
				// 开始一个事务
		Transaction	tx = session.beginTransaction(); 
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
		System.out.println("当前线程：" + getName()+"， add vocabulary="+vocabulary+",maxSortIndex=" + maxSortIndex);
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
		// query = session.createSQLQuery(sqlString);
		// System.out.println("vocabulary:"+vocabulary);
		return uuid;
	}

	private String updateVocabularyFrequenceQuantity(String vocabulary, Double frequencyQuantity) {

		// 打开一个Session
		Session session = sf.openSession();
				// 开始一个事务
		Transaction	tx = session.beginTransaction(); 
		System.out.println("当前线程：" + getName()+",update vocabulary:" + vocabulary + ",frequencyQuantity" + frequencyQuantity);
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
		// 打开一个Session
		Session session = sf.openSession();
				// 开始一个事务
		Transaction	tx = session.beginTransaction(); 
		SQLQuery query = null;
		String sqlString = "INSERT INTO VocabularyResource (VocabularyResourceID,articleChapterID,"
				+ "VocabularyFrequencyID,calYear)" + "VALUES(?,?,?,?)";

		System.out.println("当前线程：" + getName()+"， add addVocabularySentenceLocation="+articleChapterID);
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
		// query = session.createSQLQuery(sqlString);
		// System.out.println("vocabulary:"+vocabulary);
	}
}
 

