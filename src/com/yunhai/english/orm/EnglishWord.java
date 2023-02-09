package com.yunhai.english.orm;

import java.util.Date;

/**
 * EnglishWord entity. @author MyEclipse Persistence Tools
 */
public class EnglishWord extends AbstractEnglishWord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public EnglishWord() {
	}

	/** minimal constructor */
	public EnglishWord(String englishWordId, String englishWord) {
		super(englishWordId, englishWord);
	}

	/** full constructor */
	public EnglishWord(String englishWordId, String englishWord, String phoneticSymbol, String wordMeaning,
			java.util.Date createDate, Double sortIndex, String englishDetail) {
		super(englishWordId, englishWord, phoneticSymbol, wordMeaning, createDate, sortIndex, englishDetail);
	}

}
