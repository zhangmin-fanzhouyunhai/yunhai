package com.yunhai.english.orm;

import java.util.Date;

/**
 * AbstractEnglishWord entity provides the base persistence definition of the
 * EnglishWord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractEnglishWord implements java.io.Serializable {

	// Fields

	private String englishWordId;
	private String englishWord;
	private String phoneticSymbol;
	private String wordMeaning;
	private Date createDate;
	private Double sortIndex;
	private String englishDetail;

	// Constructors

	/** default constructor */
	public AbstractEnglishWord() {
	}

	/** minimal constructor */
	public AbstractEnglishWord(String englishWordId, String englishWord) {
		this.englishWordId = englishWordId;
		this.englishWord = englishWord;
	}

	/** full constructor */
	public AbstractEnglishWord(String englishWordId, String englishWord, String phoneticSymbol, String wordMeaning,
			Date createDate, Double sortIndex, String englishDetail) {
		this.englishWordId = englishWordId;
		this.englishWord = englishWord;
		this.phoneticSymbol = phoneticSymbol;
		this.wordMeaning = wordMeaning;
		this.createDate = createDate;
		this.sortIndex = sortIndex;
		this.englishDetail = englishDetail;
	}

	// Property accessors

	public String getEnglishWordId() {
		return this.englishWordId;
	}

	public void setEnglishWordId(String englishWordId) {
		this.englishWordId = englishWordId;
	}

	public String getEnglishWord() {
		return this.englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getPhoneticSymbol() {
		return this.phoneticSymbol;
	}

	public void setPhoneticSymbol(String phoneticSymbol) {
		this.phoneticSymbol = phoneticSymbol;
	}

	public String getWordMeaning() {
		return this.wordMeaning;
	}

	public void setWordMeaning(String wordMeaning) {
		this.wordMeaning = wordMeaning;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getEnglishDetail() {
		return this.englishDetail;
	}

	public void setEnglishDetail(String englishDetail) {
		this.englishDetail = englishDetail;
	}

}