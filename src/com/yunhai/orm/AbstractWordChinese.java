package com.yunhai.orm;

import java.util.Date;

/**
 * AbstractWordChinese entity provides the base persistence definition of the
 * WordChinese entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWordChinese implements java.io.Serializable {

	// Fields

	private String wordChineseId;
	private String wordChineseValue;
	private String wordChineseWubeiCode;
	private String wordChinesePinyinCode;
	private Date createDate;
	private Double frequence;
	private Double sortIndex;
	private String documentName;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractWordChinese() {
	}

	/** minimal constructor */
	public AbstractWordChinese(String wordChineseId) {
		this.wordChineseId = wordChineseId;
	}

	/** full constructor */
	public AbstractWordChinese(String wordChineseId, String wordChineseValue, String wordChineseWubeiCode,
			String wordChinesePinyinCode, Date createDate, Double frequence, Double sortIndex, String documentName,
			String description) {
		this.wordChineseId = wordChineseId;
		this.wordChineseValue = wordChineseValue;
		this.wordChineseWubeiCode = wordChineseWubeiCode;
		this.wordChinesePinyinCode = wordChinesePinyinCode;
		this.createDate = createDate;
		this.frequence = frequence;
		this.sortIndex = sortIndex;
		this.documentName = documentName;
		this.description = description;
	}

	// Property accessors

	public String getWordChineseId() {
		return this.wordChineseId;
	}

	public void setWordChineseId(String wordChineseId) {
		this.wordChineseId = wordChineseId;
	}

	public String getWordChineseValue() {
		return this.wordChineseValue;
	}

	public void setWordChineseValue(String wordChineseValue) {
		this.wordChineseValue = wordChineseValue;
	}

	public String getWordChineseWubeiCode() {
		return this.wordChineseWubeiCode;
	}

	public void setWordChineseWubeiCode(String wordChineseWubeiCode) {
		this.wordChineseWubeiCode = wordChineseWubeiCode;
	}

	public String getWordChinesePinyinCode() {
		return this.wordChinesePinyinCode;
	}

	public void setWordChinesePinyinCode(String wordChinesePinyinCode) {
		this.wordChinesePinyinCode = wordChinesePinyinCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getFrequence() {
		return this.frequence;
	}

	public void setFrequence(Double frequence) {
		this.frequence = frequence;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}