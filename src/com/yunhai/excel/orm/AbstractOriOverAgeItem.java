package com.yunhai.excel.orm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AbstractOriOverAgeItem entity provides the base persistence definition of the
 * OriOverAgeItem entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriOverAgeItem implements java.io.Serializable {

	// Fields

	private String oriOverAgeItemId;
	private String dataVersion;
	private Date calYear;
	private String assetNumber;
	private String sno;
	private String extractYear;
	private String largeClassCode;
	private Double originalValue;
	private Double accumulatedDepreciation;
	private Double netValue;
	private Double depreciationRatio;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriOverAgeItem() {
	}

	/** minimal constructor */
	public AbstractOriOverAgeItem(String oriOverAgeItemId) {
		this.oriOverAgeItemId = oriOverAgeItemId;
	}

	/** full constructor */
	public AbstractOriOverAgeItem(String oriOverAgeItemId, String dataVersion, Date calYear, String assetNumber,
			String sno, String extractYear, String largeClassCode, Double originalValue, Double accumulatedDepreciation,
			Double netValue, Double depreciationRatio, String dataSourceFile) {
		this.oriOverAgeItemId = oriOverAgeItemId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.assetNumber = assetNumber;
		this.sno = sno;
		this.extractYear = extractYear;
		this.largeClassCode = largeClassCode;
		this.originalValue = originalValue;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.netValue = netValue;
		this.depreciationRatio = depreciationRatio;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriOverAgeItemId() {
		return this.oriOverAgeItemId;
	}

	@JSONField(name="ORI_OVER_AGE_ITEM_ID")
	public void setOriOverAgeItemId(String oriOverAgeItemId) {
		this.oriOverAgeItemId = oriOverAgeItemId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	@JSONField(name="DATA_VERSION")
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	@JSONField(name="CAL_YEAR")
	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	@JSONField(name="ASSET_NUMBER")
	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSno() {
		return this.sno;
	}

	@JSONField(name="SNO")
	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getExtractYear() {
		return this.extractYear;
	}

	@JSONField(name="EXTRACT_YEAR")
	public void setExtractYear(String extractYear) {
		this.extractYear = extractYear;
	}

	public String getLargeClassCode() {
		return this.largeClassCode;
	}

	@JSONField(name="LARGE_CLASS_CODE")
	public void setLargeClassCode(String largeClassCode) {
		this.largeClassCode = largeClassCode;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	@JSONField(name="ORIGINAL_VALUE")
	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getAccumulatedDepreciation() {
		return this.accumulatedDepreciation;
	}

	@JSONField(name="ACCUMULATED_DEPRECIATION")
	public void setAccumulatedDepreciation(Double accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	@JSONField(name="NET_VALUE")
	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public Double getDepreciationRatio() {
		return this.depreciationRatio;
	}

	@JSONField(name="DEPRECIATION_RATIO")
	public void setDepreciationRatio(Double depreciationRatio) {
		this.depreciationRatio = depreciationRatio;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	@JSONField(name="DATA_SOURCE_FILE")
	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}