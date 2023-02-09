package com.yunhai.orm;

import java.util.Date;

/**
 * WordChinese entity. @author MyEclipse Persistence Tools
 */
public class WordChinese extends AbstractWordChinese implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740853444932690712L;

	/** default constructor */
	public WordChinese() {
	}

	/** minimal constructor */
	public WordChinese(String wordChineseId) {
		super(wordChineseId);
	}

	/** full constructor */
	public WordChinese(String wordChineseId, String wordChineseValue, String wordChineseWubeiCode,
			String wordChinesePinyinCode, Date createDate, Double frequence, Double sortIndex, String documentName,
			String description) {
		super(wordChineseId, wordChineseValue, wordChineseWubeiCode, wordChinesePinyinCode, createDate, frequence,
				sortIndex, documentName, description);
	}

}
