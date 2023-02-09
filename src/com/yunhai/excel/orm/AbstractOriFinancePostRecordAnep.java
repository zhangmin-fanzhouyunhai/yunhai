package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriFinancePostRecordAnep entity provides the base persistence
 * definition of the OriFinancePostRecordAnep entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFinancePostRecordAnep implements java.io.Serializable {

	// Fields

	private String oriFinancePostRecordId;
	private String dataVersion;
	private Date calYear;
	private String companyCode;
	private String assetNumber;
	private String subnumber;
	private String fiscalYear;
	private String transactionType;
	private Double accountAmount;
	private Date assetValueDate;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriFinancePostRecordAnep() {
	}

	/** minimal constructor */
	public AbstractOriFinancePostRecordAnep(String oriFinancePostRecordId, String dataVersion, Date calYear) {
		this.oriFinancePostRecordId = oriFinancePostRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriFinancePostRecordAnep(String oriFinancePostRecordId, String dataVersion, Date calYear,
			String companyCode, String assetNumber, String subnumber, String fiscalYear, String transactionType,
			Double accountAmount, Date assetValueDate, String dataSourceFile) {
		this.oriFinancePostRecordId = oriFinancePostRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.assetNumber = assetNumber;
		this.subnumber = subnumber;
		this.fiscalYear = fiscalYear;
		this.transactionType = transactionType;
		this.accountAmount = accountAmount;
		this.assetValueDate = assetValueDate;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriFinancePostRecordId() {
		return this.oriFinancePostRecordId;
	}

	public void setOriFinancePostRecordId(String oriFinancePostRecordId) {
		this.oriFinancePostRecordId = oriFinancePostRecordId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSubnumber() {
		return this.subnumber;
	}

	public void setSubnumber(String subnumber) {
		this.subnumber = subnumber;
	}

	public String getFiscalYear() {
		return this.fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAccountAmount() {
		return this.accountAmount;
	}

	public void setAccountAmount(Double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Date getAssetValueDate() {
		return this.assetValueDate;
	}

	public void setAssetValueDate(Date assetValueDate) {
		this.assetValueDate = assetValueDate;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}