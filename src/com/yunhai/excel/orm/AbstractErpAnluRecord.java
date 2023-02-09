package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpAnluRecord entity provides the base persistence definition of the
 * ErpAnluRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpAnluRecord implements java.io.Serializable {

	// Fields

	private String erpAnluRecordId;
	private String version;
	private Date calYear;
	private String companyCode;
	private String mainAssetId;
	private String secondaryCode;
	private String assetOwnOrgId;
	private String usingCustodianOrgId;

	// Constructors

	/** default constructor */
	public AbstractErpAnluRecord() {
	}

	/** minimal constructor */
	public AbstractErpAnluRecord(Date calYear) {
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractErpAnluRecord(String version, Date calYear, String companyCode, String mainAssetId, String secondaryCode,
			String assetOwnOrgId, String usingCustodianOrgId) {
		this.version = version;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.mainAssetId = mainAssetId;
		this.secondaryCode = secondaryCode;
		this.assetOwnOrgId = assetOwnOrgId;
		this.usingCustodianOrgId = usingCustodianOrgId;
	}

	// Property accessors

	public String getErpAnluRecordId() {
		return this.erpAnluRecordId;
	}

	public void setErpAnluRecordId(String erpAnluRecordId) {
		this.erpAnluRecordId = erpAnluRecordId;
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

	public String getAssetOwnOrgId() {
		return this.assetOwnOrgId;
	}

	public void setAssetOwnOrgId(String assetOwnOrgId) {
		this.assetOwnOrgId = assetOwnOrgId;
	}

	public String getUsingCustodianOrgId() {
		return this.usingCustodianOrgId;
	}

	public void setUsingCustodianOrgId(String usingCustodianOrgId) {
		this.usingCustodianOrgId = usingCustodianOrgId;
	}

}