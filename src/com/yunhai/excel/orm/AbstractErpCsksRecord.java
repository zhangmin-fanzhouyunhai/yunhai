package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpCsksRecord entity provides the base persistence definition of the
 * ErpCsksRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpCsksRecord implements java.io.Serializable {

	// Fields

	private String erpCsksRecordId;
	private String version;
	private Date calYear;
	private String profitConentCode;
	private String companyCode;
	private String secondProfitCode;
	private Date validEndDate;
	private Date validStartDate;

	// Constructors

	/** default constructor */
	public AbstractErpCsksRecord() {
	}

	/** minimal constructor */
	public AbstractErpCsksRecord(Date calYear) {
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractErpCsksRecord(String version,Date calYear, String profitConentCode, String companyCode, String secondProfitCode,
			Date validEndDate, Date validStartDate) {
		this.version = version;
		this.calYear = calYear;
		this.profitConentCode = profitConentCode;
		this.companyCode = companyCode;
		this.secondProfitCode = secondProfitCode;
		this.validEndDate = validEndDate;
		this.validStartDate = validStartDate;
	}

	// Property accessors

	public String getErpCsksRecordId() {
		return this.erpCsksRecordId;
	}

	public void setErpCsksRecordId(String erpCsksRecordId) {
		this.erpCsksRecordId = erpCsksRecordId;
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

	public String getProfitConentCode() {
		return this.profitConentCode;
	}

	public void setProfitConentCode(String profitConentCode) {
		this.profitConentCode = profitConentCode;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getSecondProfitCode() {
		return this.secondProfitCode;
	}

	public void setSecondProfitCode(String secondProfitCode) {
		this.secondProfitCode = secondProfitCode;
	}

	public Date getValidEndDate() {
		return this.validEndDate;
	}

	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public Date getValidStartDate() {
		return this.validStartDate;
	}

	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}

}