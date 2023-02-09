package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriFinanceScrapPostAsset entity provides the base persistence
 * definition of the OriFinanceScrapPostAsset entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFinanceScrapPostAsset implements java.io.Serializable {

	// Fields

	private String oriFinancScrapPostAssetId;
	private String dataVersion;
	private java.util.Date calYear;
	private String companyCode;
	private String assetsNo;
	private String sno;
	private String classification;
	private String typeName;
	private String voltageLevel;
	private Double quantity;
	private String meterUnit;
	private String assetStatus;
	private String costCenter;
	private String assetDescription;
	private java.util.Date capitalizationDate;
	private java.util.Date inactiveDate;
	private String locationAddress;
	private String assetPhysicalId;
	private String dataSourceFileName;

	// Constructors

	/** default constructor */
	public AbstractOriFinanceScrapPostAsset() {
	}

	/** minimal constructor */
	public AbstractOriFinanceScrapPostAsset(String oriFinancScrapPostAssetId, String dataVersion, java.util.Date calYear) {
		this.oriFinancScrapPostAssetId = oriFinancScrapPostAssetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriFinanceScrapPostAsset(String oriFinancScrapPostAssetId, String dataVersion, java.util.Date calYear,
			String companyCode, String assetsNo, String sno, String classification, String typeName,
			String voltageLevel, Double quantity, String meterUnit, String assetStatus, String costCenter,
			String assetDescription, java.util.Date capitalizationDate, java.util.Date inactiveDate, String locationAddress,
			String assetPhysicalId, String dataSourceFileName) {
		this.oriFinancScrapPostAssetId = oriFinancScrapPostAssetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.assetsNo = assetsNo;
		this.sno = sno;
		this.classification = classification;
		this.typeName = typeName;
		this.voltageLevel = voltageLevel;
		this.quantity = quantity;
		this.meterUnit = meterUnit;
		this.assetStatus = assetStatus;
		this.costCenter = costCenter;
		this.assetDescription = assetDescription;
		this.capitalizationDate = capitalizationDate;
		this.inactiveDate = inactiveDate;
		this.locationAddress = locationAddress;
		this.assetPhysicalId = assetPhysicalId;
		this.dataSourceFileName = dataSourceFileName;
	}

	// Property accessors

	public String getOriFinancScrapPostAssetId() {
		return this.oriFinancScrapPostAssetId;
	}

	public void setOriFinancScrapPostAssetId(String oriFinancScrapPostAssetId) {
		this.oriFinancScrapPostAssetId = oriFinancScrapPostAssetId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public java.util.Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(java.util.Date calYear) {
		this.calYear = calYear;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAssetsNo() {
		return this.assetsNo;
	}

	public void setAssetsNo(String assetsNo) {
		this.assetsNo = assetsNo;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getMeterUnit() {
		return this.meterUnit;
	}

	public void setMeterUnit(String meterUnit) {
		this.meterUnit = meterUnit;
	}

	public String getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public java.util.Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(java.util.Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public java.util.Date getInactiveDate() {
		return this.inactiveDate;
	}

	public void setInactiveDate(java.util.Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getLocationAddress() {
		return this.locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getAssetPhysicalId() {
		return this.assetPhysicalId;
	}

	public void setAssetPhysicalId(String assetPhysicalId) {
		this.assetPhysicalId = assetPhysicalId;
	}

	public String getDataSourceFileName() {
		return this.dataSourceFileName;
	}

	public void setDataSourceFileName(String dataSourceFileName) {
		this.dataSourceFileName = dataSourceFileName;
	}

}