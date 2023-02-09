package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpAnlzRecord entity provides the base persistence definition of the
 * ErpAnlzRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpAnlzRecord implements java.io.Serializable {

	// Fields

	private String erpAnlzRecordId;
	private String version;
	private Date calYear;
	private String companyCode;
	private String mainAssetId;
	private String secondaryCode;
	private Date validEndDate;
	private String profitCenterCode;
	private String pssElement;

	// Constructors

	/** default constructor */
	public AbstractErpAnlzRecord() {
	}

	/** minimal constructor */
	public AbstractErpAnlzRecord(Date calYear) {
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractErpAnlzRecord(String version, Date calYear, String companyCode, String mainAssetId, String secondaryCode,
			Date validEndDate, String profitCenterCode, String pssElement) {
		this.version = version;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.mainAssetId = mainAssetId;
		this.secondaryCode = secondaryCode;
		this.validEndDate = validEndDate;
		this.profitCenterCode = profitCenterCode;
		this.pssElement = pssElement;
	}

	// Property accessors

	public String getErpAnlzRecordId() {
		return this.erpAnlzRecordId;
	}

	public void setErpAnlzRecordId(String erpAnlzRecordId) {
		this.erpAnlzRecordId = erpAnlzRecordId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public String getMainAssetId() {
		return this.mainAssetId;
	}

	public void setMainAssetId(String mainAssetId) {
		this.mainAssetId = mainAssetId;
	}

	public String getSecondaryCode() {
		return this.secondaryCode;
	}

	public void setSecondaryCode(String secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

	public Date getValidEndDate() {
		return this.validEndDate;
	}

	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public String getProfitCenterCode() {
		return this.profitCenterCode;
	}

	public void setProfitCenterCode(String profitCenterCode) {
		this.profitCenterCode = profitCenterCode;
	}

	public String getPssElement() {
		return this.pssElement;
	}

	public void setPssElement(String pssElement) {
		this.pssElement = pssElement;
	}

}