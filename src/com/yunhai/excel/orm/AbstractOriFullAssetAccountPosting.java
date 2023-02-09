package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriFullAssetAccountPosting entity provides the base persistence
 * definition of the OriFullAssetAccountPosting entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFullAssetAccountPosting implements java.io.Serializable {

	// Fields

	private String oriFullAssetAccountPosId;
	private String dataVersion;
	private Date calYaer;
	private String systemIdentification;
	private String orgNameCode;
	private String orgName;
	private String assetNumber;
	private String secondaryNumber;
	private Long calyear;
	private String largeClassCode;
	private String transactionCategory;
	private String whethCapitalizationLastYear;
	private Double bookKeepingAmount;
	private Date assetValueDate;
	private String businessAttribute;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriFullAssetAccountPosting() {
	}

	/** minimal constructor */
	public AbstractOriFullAssetAccountPosting(String oriFullAssetAccountPosId) {
		this.oriFullAssetAccountPosId = oriFullAssetAccountPosId;
	}

	/** full constructor */
	public AbstractOriFullAssetAccountPosting(String oriFullAssetAccountPosId, String dataVersion, Date calYaer,
			String systemIdentification, String orgNameCode, String orgName, String assetNumber, String secondaryNumber,
			Long calyear, String largeClassCode, String transactionCategory, String whethCapitalizationLastYear,
			Double bookKeepingAmount, Date assetValueDate, String businessAttribute, String dataSourceFile) {
		this.oriFullAssetAccountPosId = oriFullAssetAccountPosId;
		this.dataVersion = dataVersion;
		this.calYaer = calYaer;
		this.systemIdentification = systemIdentification;
		this.orgNameCode = orgNameCode;
		this.orgName = orgName;
		this.assetNumber = assetNumber;
		this.secondaryNumber = secondaryNumber;
		this.calyear = calyear;
		this.largeClassCode = largeClassCode;
		this.transactionCategory = transactionCategory;
		this.whethCapitalizationLastYear = whethCapitalizationLastYear;
		this.bookKeepingAmount = bookKeepingAmount;
		this.assetValueDate = assetValueDate;
		this.businessAttribute = businessAttribute;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriFullAssetAccountPosId() {
		return this.oriFullAssetAccountPosId;
	}

	public void setOriFullAssetAccountPosId(String oriFullAssetAccountPosId) {
		this.oriFullAssetAccountPosId = oriFullAssetAccountPosId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYaer() {
		return this.calYaer;
	}

	public void setCalYaer(Date calYaer) {
		this.calYaer = calYaer;
	}

	public String getSystemIdentification() {
		return this.systemIdentification;
	}

	public void setSystemIdentification(String systemIdentification) {
		this.systemIdentification = systemIdentification;
	}

	public String getOrgNameCode() {
		return this.orgNameCode;
	}

	public void setOrgNameCode(String orgNameCode) {
		this.orgNameCode = orgNameCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSecondaryNumber() {
		return this.secondaryNumber;
	}

	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}

	public Long getCalyear() {
		return this.calyear;
	}

	public void setCalyear(Long calyear) {
		this.calyear = calyear;
	}

	public String getLargeClassCode() {
		return this.largeClassCode;
	}

	public void setLargeClassCode(String largeClassCode) {
		this.largeClassCode = largeClassCode;
	}

	public String getTransactionCategory() {
		return this.transactionCategory;
	}

	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

	public String getWhethCapitalizationLastYear() {
		return this.whethCapitalizationLastYear;
	}

	public void setWhethCapitalizationLastYear(String whethCapitalizationLastYear) {
		this.whethCapitalizationLastYear = whethCapitalizationLastYear;
	}

	public Double getBookKeepingAmount() {
		return this.bookKeepingAmount;
	}

	public void setBookKeepingAmount(Double bookKeepingAmount) {
		this.bookKeepingAmount = bookKeepingAmount;
	}

	public Date getAssetValueDate() {
		return this.assetValueDate;
	}

	public void setAssetValueDate(Date assetValueDate) {
		this.assetValueDate = assetValueDate;
	}

	public String getBusinessAttribute() {
		return this.businessAttribute;
	}

	public void setBusinessAttribute(String businessAttribute) {
		this.businessAttribute = businessAttribute;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}