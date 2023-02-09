package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOriFullAssetCapitalization entity provides the base persistence
 * definition of the OriFullAssetCapitalization entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFullAssetCapitalization implements java.io.Serializable {

	// Fields

	private String oriFullAssetCapitalizId;
	private String dataVersion;
	private Date calYaer;
	private String orgNameCode;
	private String orgName;
	private String assetNumber;
	private String secondaryNumber;
	private Long calyear;
	private String arDot;
	private String largeClassCode;
	private Double originalValue;
	private Double accumulatedPurchaseValue;
	private Double assetValueBusiness;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriFullAssetCapitalization() {
	}

	/** minimal constructor */
	public AbstractOriFullAssetCapitalization(String oriFullAssetCapitalizId) {
		this.oriFullAssetCapitalizId = oriFullAssetCapitalizId;
	}

	/** full constructor */
	public AbstractOriFullAssetCapitalization(String oriFullAssetCapitalizId, String dataVersion, Date calYaer,
			String orgNameCode, String orgName, String assetNumber, String secondaryNumber, Long calyear, String arDot,
			String largeClassCode, Double originalValue, Double accumulatedPurchaseValue, Double assetValueBusiness,String dataSourceFile) {
		this.oriFullAssetCapitalizId = oriFullAssetCapitalizId;
		this.dataVersion = dataVersion;
		this.calYaer = calYaer;
		this.orgNameCode = orgNameCode;
		this.orgName = orgName;
		this.assetNumber = assetNumber;
		this.secondaryNumber = secondaryNumber;
		this.calyear = calyear;
		this.arDot = arDot;
		this.largeClassCode = largeClassCode;
		this.originalValue = originalValue;
		this.accumulatedPurchaseValue = accumulatedPurchaseValue;
		this.assetValueBusiness = assetValueBusiness;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriFullAssetCapitalizId() {
		return this.oriFullAssetCapitalizId;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOriFullAssetCapitalizId(String oriFullAssetCapitalizId) {
		this.oriFullAssetCapitalizId = oriFullAssetCapitalizId;
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

	public String getArDot() {
		return this.arDot;
	}

	public void setArDot(String arDot) {
		this.arDot = arDot;
	}

	public String getLargeClassCode() {
		return this.largeClassCode;
	}

	public void setLargeClassCode(String largeClassCode) {
		this.largeClassCode = largeClassCode;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getAccumulatedPurchaseValue() {
		return this.accumulatedPurchaseValue;
	}

	public void setAccumulatedPurchaseValue(Double accumulatedPurchaseValue) {
		this.accumulatedPurchaseValue = accumulatedPurchaseValue;
	}

	public Double getAssetValueBusiness() {
		return this.assetValueBusiness;
	}

	public void setAssetValueBusiness(Double assetValueBusiness) {
		this.assetValueBusiness = assetValueBusiness;
	}

}