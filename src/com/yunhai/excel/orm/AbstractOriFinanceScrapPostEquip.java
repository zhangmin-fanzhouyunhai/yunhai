package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriFinanceScrapPostEquip entity provides the base persistence
 * definition of the OriFinanceScrapPostEquip entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriFinanceScrapPostEquip implements java.io.Serializable {

	// Fields

	private String oriFinancScrapPostEquipId;
	private String dataVersion;
	private java.util.Date calYear;
	private String equipmentNo;
	private String technicalObjectType;
	private String voltageLevel;
	private String equipmentIncreaseMode;
	private String assetManufacturer;
	private String model;
	private String userStatus;
	private String assetPropertyCode;
	private String assetPropertyTxt;
	private String equipmentDescription;
	private java.util.Date commissioningDate;
	private String lengthUnit;
	private String capacitanceUnit;
	private Double lineLength;
	private Double substationCapacity;
	private String equipmentPhysicalId;
	private String dataSourceFileName;

	// Constructors

	/** default constructor */
	public AbstractOriFinanceScrapPostEquip() {
	}

	/** minimal constructor */
	public AbstractOriFinanceScrapPostEquip(String oriFinancScrapPostEquipId, String dataVersion, java.util.Date calYear) {
		this.oriFinancScrapPostEquipId = oriFinancScrapPostEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriFinanceScrapPostEquip(String oriFinancScrapPostEquipId, String dataVersion, java.util.Date calYear,
			String equipmentNo, String technicalObjectType, String voltageLevel, String equipmentIncreaseMode,
			String assetManufacturer, String model, String userStatus, String assetPropertyCode,
			String assetPropertyTxt, String equipmentDescription, java.util.Date commissioningDate, String lengthUnit,
			String capacitanceUnit, Double lineLength, Double substationCapacity, String equipmentPhysicalId,
			String dataSourceFileName) {
		this.oriFinancScrapPostEquipId = oriFinancScrapPostEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentNo = equipmentNo;
		this.technicalObjectType = technicalObjectType;
		this.voltageLevel = voltageLevel;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.assetManufacturer = assetManufacturer;
		this.model = model;
		this.userStatus = userStatus;
		this.assetPropertyCode = assetPropertyCode;
		this.assetPropertyTxt = assetPropertyTxt;
		this.equipmentDescription = equipmentDescription;
		this.commissioningDate = commissioningDate;
		this.lengthUnit = lengthUnit;
		this.capacitanceUnit = capacitanceUnit;
		this.lineLength = lineLength;
		this.substationCapacity = substationCapacity;
		this.equipmentPhysicalId = equipmentPhysicalId;
		this.dataSourceFileName = dataSourceFileName;
	}

	// Property accessors

	public String getOriFinancScrapPostEquipId() {
		return this.oriFinancScrapPostEquipId;
	}

	public void setOriFinancScrapPostEquipId(String oriFinancScrapPostEquipId) {
		this.oriFinancScrapPostEquipId = oriFinancScrapPostEquipId;
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

	public String getEquipmentNo() {
		return this.equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getTechnicalObjectType() {
		return this.technicalObjectType;
	}

	public void setTechnicalObjectType(String technicalObjectType) {
		this.technicalObjectType = technicalObjectType;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getEquipmentIncreaseMode() {
		return this.equipmentIncreaseMode;
	}

	public void setEquipmentIncreaseMode(String equipmentIncreaseMode) {
		this.equipmentIncreaseMode = equipmentIncreaseMode;
	}

	public String getAssetManufacturer() {
		return this.assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getAssetPropertyCode() {
		return this.assetPropertyCode;
	}

	public void setAssetPropertyCode(String assetPropertyCode) {
		this.assetPropertyCode = assetPropertyCode;
	}

	public String getAssetPropertyTxt() {
		return this.assetPropertyTxt;
	}

	public void setAssetPropertyTxt(String assetPropertyTxt) {
		this.assetPropertyTxt = assetPropertyTxt;
	}

	public String getEquipmentDescription() {
		return this.equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	public java.util.Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(java.util.Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getLengthUnit() {
		return this.lengthUnit;
	}

	public void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public String getCapacitanceUnit() {
		return this.capacitanceUnit;
	}

	public void setCapacitanceUnit(String capacitanceUnit) {
		this.capacitanceUnit = capacitanceUnit;
	}

	public Double getLineLength() {
		return this.lineLength;
	}

	public void setLineLength(Double lineLength) {
		this.lineLength = lineLength;
	}

	public Double getSubstationCapacity() {
		return this.substationCapacity;
	}

	public void setSubstationCapacity(Double substationCapacity) {
		this.substationCapacity = substationCapacity;
	}

	public String getEquipmentPhysicalId() {
		return this.equipmentPhysicalId;
	}

	public void setEquipmentPhysicalId(String equipmentPhysicalId) {
		this.equipmentPhysicalId = equipmentPhysicalId;
	}

	public String getDataSourceFileName() {
		return this.dataSourceFileName;
	}

	public void setDataSourceFileName(String dataSourceFileName) {
		this.dataSourceFileName = dataSourceFileName;
	}

}