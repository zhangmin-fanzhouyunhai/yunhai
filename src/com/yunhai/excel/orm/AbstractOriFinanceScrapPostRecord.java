package com.yunhai.excel.orm;

/**
 * AbstractOriFinanceScrapPostRecord entity provides the base persistence
 * definition of the OriFinanceScrapPostRecord entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFinanceScrapPostRecord implements java.io.Serializable {

	// Fields

	private String oriFinanScrapPostRecordId;
	private String dataVersion;
	private java.util.Date calYear;
	private String applicationNo;
	private String mainEquipmentNumber;
	private String mainEquipmentStatus;
	private String classification;
	private String assetClassAlias;
	private String assetsNumber;
	private String assetDescription;
	private String assetRetirement;
	private String changingState;
	private java.util.Date assetValueDate;
	private java.util.Date bookkeepingDate;
	private Double originalBookValue;
	private Double accumulatedDepreciation;
	private Double provisionForImpairment;
	private Double netBookValue;
	private Double scrapRatio;
	private Double scrapOriginalValue;
	private Double scrapDepreciation;
	private String costCenter;
	private Double quantity;
	private String meterUnit;
	private String unitOfMeasureText;
	private String assetManufacturer;
	private java.util.Date capitalizationDate;
	private String profitCenter;
	private String scrapReasonCode;
	private String scrapReasonDescription;
	private String objectType;
	private String dataSourceFileName;

	// Constructors

	/** default constructor */
	public AbstractOriFinanceScrapPostRecord() {
	}

	/** minimal constructor */
	public AbstractOriFinanceScrapPostRecord(String oriFinanScrapPostRecordId, String dataVersion,
			java.util.Date calYear) {
		this.oriFinanScrapPostRecordId = oriFinanScrapPostRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriFinanceScrapPostRecord(String oriFinanScrapPostRecordId, String dataVersion,
			java.util.Date calYear, String applicationNo, String mainEquipmentNumber, String mainEquipmentStatus,
			String classification, String assetClassAlias, String assetsNumber, String assetDescription,
			String assetRetirement, String changingState, java.util.Date assetValueDate, java.util.Date bookkeepingDate,
			Double originalBookValue, Double accumulatedDepreciation, Double provisionForImpairment,
			Double netBookValue, Double scrapRatio, Double scrapOriginalValue, Double scrapDepreciation,
			String costCenter, Double quantity, String meterUnit, String unitOfMeasureText, String assetManufacturer,
			java.util.Date capitalizationDate, String profitCenter, String scrapReasonCode,
			String scrapReasonDescription, String objectType, String dataSourceFileName) {
		this.oriFinanScrapPostRecordId = oriFinanScrapPostRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.applicationNo = applicationNo;
		this.mainEquipmentNumber = mainEquipmentNumber;
		this.mainEquipmentStatus = mainEquipmentStatus;
		this.classification = classification;
		this.assetClassAlias = assetClassAlias;
		this.assetsNumber = assetsNumber;
		this.assetDescription = assetDescription;
		this.assetRetirement = assetRetirement;
		this.changingState = changingState;
		this.assetValueDate = assetValueDate;
		this.bookkeepingDate = bookkeepingDate;
		this.originalBookValue = originalBookValue;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.provisionForImpairment = provisionForImpairment;
		this.netBookValue = netBookValue;
		this.scrapRatio = scrapRatio;
		this.scrapOriginalValue = scrapOriginalValue;
		this.scrapDepreciation = scrapDepreciation;
		this.costCenter = costCenter;
		this.quantity = quantity;
		this.meterUnit = meterUnit;
		this.unitOfMeasureText = unitOfMeasureText;
		this.assetManufacturer = assetManufacturer;
		this.capitalizationDate = capitalizationDate;
		this.profitCenter = profitCenter;
		this.scrapReasonCode = scrapReasonCode;
		this.scrapReasonDescription = scrapReasonDescription;
		this.objectType = objectType;
		this.dataSourceFileName = dataSourceFileName;
	}

	// Property accessors

	public String getOriFinanScrapPostRecordId() {
		return this.oriFinanScrapPostRecordId;
	}

	public void setOriFinanScrapPostRecordId(String oriFinanScrapPostRecordId) {
		this.oriFinanScrapPostRecordId = oriFinanScrapPostRecordId;
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

	public String getApplicationNo() {
		return this.applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getMainEquipmentNumber() {
		return this.mainEquipmentNumber;
	}

	public void setMainEquipmentNumber(String mainEquipmentNumber) {
		this.mainEquipmentNumber = mainEquipmentNumber;
	}

	public String getMainEquipmentStatus() {
		return this.mainEquipmentStatus;
	}

	public void setMainEquipmentStatus(String mainEquipmentStatus) {
		this.mainEquipmentStatus = mainEquipmentStatus;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAssetClassAlias() {
		return this.assetClassAlias;
	}

	public void setAssetClassAlias(String assetClassAlias) {
		this.assetClassAlias = assetClassAlias;
	}

	public String getAssetsNumber() {
		return this.assetsNumber;
	}

	public void setAssetsNumber(String assetsNumber) {
		this.assetsNumber = assetsNumber;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getAssetRetirement() {
		return this.assetRetirement;
	}

	public void setAssetRetirement(String assetRetirement) {
		this.assetRetirement = assetRetirement;
	}

	public String getChangingState() {
		return this.changingState;
	}

	public void setChangingState(String changingState) {
		this.changingState = changingState;
	}

	public java.util.Date getAssetValueDate() {
		return this.assetValueDate;
	}

	public void setAssetValueDate(java.util.Date assetValueDate) {
		this.assetValueDate = assetValueDate;
	}

	public java.util.Date getBookkeepingDate() {
		return this.bookkeepingDate;
	}

	public void setBookkeepingDate(java.util.Date bookkeepingDate) {
		this.bookkeepingDate = bookkeepingDate;
	}

	public Double getOriginalBookValue() {
		return this.originalBookValue;
	}

	public void setOriginalBookValue(Double originalBookValue) {
		this.originalBookValue = originalBookValue;
	}

	public Double getAccumulatedDepreciation() {
		return this.accumulatedDepreciation;
	}

	public void setAccumulatedDepreciation(Double accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public Double getProvisionForImpairment() {
		return this.provisionForImpairment;
	}

	public void setProvisionForImpairment(Double provisionForImpairment) {
		this.provisionForImpairment = provisionForImpairment;
	}

	public Double getNetBookValue() {
		return this.netBookValue;
	}

	public void setNetBookValue(Double netBookValue) {
		this.netBookValue = netBookValue;
	}

	public Double getScrapRatio() {
		return this.scrapRatio;
	}

	public void setScrapRatio(Double scrapRatio) {
		this.scrapRatio = scrapRatio;
	}

	public Double getScrapOriginalValue() {
		return this.scrapOriginalValue;
	}

	public void setScrapOriginalValue(Double scrapOriginalValue) {
		this.scrapOriginalValue = scrapOriginalValue;
	}

	public Double getScrapDepreciation() {
		return this.scrapDepreciation;
	}

	public void setScrapDepreciation(Double scrapDepreciation) {
		this.scrapDepreciation = scrapDepreciation;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
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

	public String getUnitOfMeasureText() {
		return this.unitOfMeasureText;
	}

	public void setUnitOfMeasureText(String unitOfMeasureText) {
		this.unitOfMeasureText = unitOfMeasureText;
	}

	public String getAssetManufacturer() {
		return this.assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public java.util.Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(java.util.Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public String getProfitCenter() {
		return this.profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getScrapReasonCode() {
		return this.scrapReasonCode;
	}

	public void setScrapReasonCode(String scrapReasonCode) {
		this.scrapReasonCode = scrapReasonCode;
	}

	public String getScrapReasonDescription() {
		return this.scrapReasonDescription;
	}

	public void setScrapReasonDescription(String scrapReasonDescription) {
		this.scrapReasonDescription = scrapReasonDescription;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getDataSourceFileName() {
		return this.dataSourceFileName;
	}

	public void setDataSourceFileName(String dataSourceFileName) {
		this.dataSourceFileName = dataSourceFileName;
	}

}