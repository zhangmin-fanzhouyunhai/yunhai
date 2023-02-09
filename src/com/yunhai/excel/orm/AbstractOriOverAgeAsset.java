package com.yunhai.excel.orm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField; 

/**
 * AbstractOriOverAgeAsset entity provides the base persistence definition of
 * the OriOverAgeAsset entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriOverAgeAsset implements java.io.Serializable {

	// Fields

	private String oriOverAgeAssetId;
	private String dataVersion;
	private Date calYear;
	private String companyCode;
	private String assetNumber;
	private String profitCenter;
	private String assetClassificationCode;
	private String fixeAssetClassificationCode;
	private String profitCenterDescription;
	private String assetName;
	private String assetClassAlias;
	private String costCenter;
	private String costCenterName;
	private String largeAssetClassCode;
	private String mediumAssetClassCode;
	private String smallAssetClassCode;
	private Double accumulatedPurchaseValue;
	private Double accumulUnplannedDepreciation;
	private Double accumulOrdinaryDepreciation;
	private Double assetNetValue;
	private Double assetResidualValue;
	private Date capitalizationDate;
	private String expectedServiceLife;
	private Date overAgeDate;
	private String depreciationCode;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriOverAgeAsset() {
	}

	/** minimal constructor */
	public AbstractOriOverAgeAsset(String oriOverAgeAssetId, String dataVersion, Date calYear) {
		this.oriOverAgeAssetId = oriOverAgeAssetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriOverAgeAsset(String oriOverAgeAssetId, String dataVersion, Date calYear, String companyCode,
			String assetNumber, String profitCenter, String assetClassificationCode, String fixeAssetClassificationCode,
			String profitCenterDescription, String assetName, String assetClassAlias, String costCenter,
			String costCenterName, String largeAssetClassCode, String mediumAssetClassCode, String smallAssetClassCode,
			Double accumulatedPurchaseValue, Double accumulUnplannedDepreciation, Double accumulOrdinaryDepreciation,
			Double assetNetValue, Double assetResidualValue, Date capitalizationDate, String expectedServiceLife,
			Date overAgeDate, String depreciationCode, String dataSourceFile) {
		this.oriOverAgeAssetId = oriOverAgeAssetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.assetNumber = assetNumber;
		this.profitCenter = profitCenter;
		this.assetClassificationCode = assetClassificationCode;
		this.fixeAssetClassificationCode = fixeAssetClassificationCode;
		this.profitCenterDescription = profitCenterDescription;
		this.assetName = assetName;
		this.assetClassAlias = assetClassAlias;
		this.costCenter = costCenter;
		this.costCenterName = costCenterName;
		this.largeAssetClassCode = largeAssetClassCode;
		this.mediumAssetClassCode = mediumAssetClassCode;
		this.smallAssetClassCode = smallAssetClassCode;
		this.accumulatedPurchaseValue = accumulatedPurchaseValue;
		this.accumulUnplannedDepreciation = accumulUnplannedDepreciation;
		this.accumulOrdinaryDepreciation = accumulOrdinaryDepreciation;
		this.assetNetValue = assetNetValue;
		this.assetResidualValue = assetResidualValue;
		this.capitalizationDate = capitalizationDate;
		this.expectedServiceLife = expectedServiceLife;
		this.overAgeDate = overAgeDate;
		this.depreciationCode = depreciationCode;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriOverAgeAssetId() {
		return this.oriOverAgeAssetId;
	}

	@JSONField(name="ORI_OVER_AGE_ASSET_ID")
	public void setOriOverAgeAssetId(String oriOverAgeAssetId) {
		this.oriOverAgeAssetId = oriOverAgeAssetId;
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

	public String getCompanyCode() {
		return this.companyCode;
	}

	@JSONField(name="COMPANY_CODE")
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	@JSONField(name="ASSET_NUMBER")
	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getProfitCenter() {
		return this.profitCenter;
	}

	@JSONField(name="PROFIT_CENTER")
	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getAssetClassificationCode() {
		return this.assetClassificationCode;
	}

	@JSONField(name="ASSET_CLASSIFICATION_CODE")
	public void setAssetClassificationCode(String assetClassificationCode) {
		this.assetClassificationCode = assetClassificationCode;
	}

	public String getFixeAssetClassificationCode() {
		return this.fixeAssetClassificationCode;
	}

	@JSONField(name="FIXE_ASSET_CLASSIFICATION_CODE")
	public void setFixeAssetClassificationCode(String fixeAssetClassificationCode) {
		this.fixeAssetClassificationCode = fixeAssetClassificationCode;
	}

	public String getProfitCenterDescription() {
		return this.profitCenterDescription;
	}

	@JSONField(name="PROFIT_CENTER_DESCRIPTION")
	public void setProfitCenterDescription(String profitCenterDescription) {
		this.profitCenterDescription = profitCenterDescription;
	}

	public String getAssetName() {
		return this.assetName;
	}

	@JSONField(name="ASSET_NAME")
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetClassAlias() {
		return this.assetClassAlias;
	}

	@JSONField(name="ASSET_CLASS_ALIAS")
	public void setAssetClassAlias(String assetClassAlias) {
		this.assetClassAlias = assetClassAlias;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	@JSONField(name="COST_CENTER")
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCostCenterName() {
		return this.costCenterName;
	}

	@JSONField(name="COST_CENTER_NAME")
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getLargeAssetClassCode() {
		return this.largeAssetClassCode;
	}

	@JSONField(name="LARGE_ASSET_CLASS_CODE")
	public void setLargeAssetClassCode(String largeAssetClassCode) {
		this.largeAssetClassCode = largeAssetClassCode;
	}

	public String getMediumAssetClassCode() {
		return this.mediumAssetClassCode;
	}

	@JSONField(name="MEDIUM_ASSET_CLASS_CODE")
	public void setMediumAssetClassCode(String mediumAssetClassCode) {
		this.mediumAssetClassCode = mediumAssetClassCode;
	}

	public String getSmallAssetClassCode() {
		return this.smallAssetClassCode;
	}

	@JSONField(name="SMALL_ASSET_CLASS_CODE")
	public void setSmallAssetClassCode(String smallAssetClassCode) {
		this.smallAssetClassCode = smallAssetClassCode;
	}

	public Double getAccumulatedPurchaseValue() {
		return this.accumulatedPurchaseValue;
	}

	@JSONField(name="ACCUMULATED_PURCHASE_VALUE")
	public void setAccumulatedPurchaseValue(Double accumulatedPurchaseValue) {
		this.accumulatedPurchaseValue = accumulatedPurchaseValue;
	}

	public Double getAccumulUnplannedDepreciation() {
		return this.accumulUnplannedDepreciation;
	}

	@JSONField(name="ACCUMUL_UNPLANNED_DEPRECIATION")
	public void setAccumulUnplannedDepreciation(Double accumulUnplannedDepreciation) {
		this.accumulUnplannedDepreciation = accumulUnplannedDepreciation;
	}

	public Double getAccumulOrdinaryDepreciation() {
		return this.accumulOrdinaryDepreciation;
	}

	@JSONField(name="ACCUMUL_ORDINARY_DEPRECIATION")
	public void setAccumulOrdinaryDepreciation(Double accumulOrdinaryDepreciation) {
		this.accumulOrdinaryDepreciation = accumulOrdinaryDepreciation;
	}

	public Double getAssetNetValue() {
		return this.assetNetValue;
	}

	@JSONField(name="ASSET_NET_VALUE")
	public void setAssetNetValue(Double assetNetValue) {
		this.assetNetValue = assetNetValue;
	}

	public Double getAssetResidualValue() {
		return this.assetResidualValue;
	}

	@JSONField(name="ASSET_RESIDUAL_VALUE")
	public void setAssetResidualValue(Double assetResidualValue) {
		this.assetResidualValue = assetResidualValue;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	@JSONField(name="CAPITALIZATION_DATE")
	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public String getExpectedServiceLife() {
		return this.expectedServiceLife;
	}

	@JSONField(name="EXPECTED_SERVICE_LIFE")
	public void setExpectedServiceLife(String expectedServiceLife) {
		this.expectedServiceLife = expectedServiceLife;
	}

	public Date getOverAgeDate() {
		return this.overAgeDate;
	}

	@JSONField(name="OVER_AGE_DATE")
	public void setOverAgeDate(Date overAgeDate) {
		this.overAgeDate = overAgeDate;
	}

	public String getDepreciationCode() {
		return this.depreciationCode;
	}

	@JSONField(name="DEPRECIATION_CODE")
	public void setDepreciationCode(String depreciationCode) {
		this.depreciationCode = depreciationCode;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	@JSONField(name="DATA_SOURCE_FILE")
	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}