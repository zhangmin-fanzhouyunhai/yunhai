package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpAnlcRecord entity provides the base persistence definition of the
 * ErpAnlcRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpAnlcRecord implements java.io.Serializable {

	// Fields

	private String erpAnlcRecordId;
	private String version;
	private Date calYear;
	private String companyCode;
	private String mainAssetId;
	private String secondaryCode;
	private Long calyear;
	private String arCode;
	private Double originalValue;
	private Double accumulatGeneralDepreciation;
	private Double unplannedDepreciation;
	private Double netValue;

	// Constructors

	/** default constructor */
	public AbstractErpAnlcRecord() {
	}

	/** minimal constructor */
	public AbstractErpAnlcRecord(Date calYear) {
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractErpAnlcRecord(String version,Date calYear, String companyCode, String mainAssetId, String secondaryCode,
			Long calyear, String arCode, Double originalValue, Double accumulatGeneralDepreciation,
			Double unplannedDepreciation, Double netValue) {
		this.version = version;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.mainAssetId = mainAssetId;
		this.secondaryCode = secondaryCode;
		this.calyear = calyear;
		this.arCode = arCode;
		this.originalValue = originalValue;
		this.accumulatGeneralDepreciation = accumulatGeneralDepreciation;
		this.unplannedDepreciation = unplannedDepreciation;
		this.netValue = netValue;
	}

	// Property accessors

	public String getErpAnlcRecordId() {
		return this.erpAnlcRecordId;
	}

	public void setErpAnlcRecordId(String erpAnlcRecordId) {
		this.erpAnlcRecordId = erpAnlcRecordId;
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

	public Long getCalyear() {
		return this.calyear;
	}

	public void setCalyear(Long calyear) {
		this.calyear = calyear;
	}

	public String getArCode() {
		return this.arCode;
	}

	public void setArCode(String arCode) {
		this.arCode = arCode;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getAccumulatGeneralDepreciation() {
		return this.accumulatGeneralDepreciation;
	}

	public void setAccumulatGeneralDepreciation(Double accumulatGeneralDepreciation) {
		this.accumulatGeneralDepreciation = accumulatGeneralDepreciation;
	}

	public Double getUnplannedDepreciation() {
		return this.unplannedDepreciation;
	}

	public void setUnplannedDepreciation(Double unplannedDepreciation) {
		this.unplannedDepreciation = unplannedDepreciation;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

}