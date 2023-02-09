package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractPmsItemReuse entity provides the base persistence definition of the
 * PmsItemReuse entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPmsItemReuse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4386753193738175717L;
	private String pmsItemReuseId;
	private String version;
	private Date calYear;
	private String oldEquipmentName;
	private String equipmentType;
	private String voltageLevel;
	private String oldTransformSubstationLine;
	private String repositoryAddress;
	private String equipmentCustodian;
	private String equipmentEvaluationResult;
	private String assetProperty;
	private String oldMaintenanceOrgName;
	private String assetNumber;
	private String equipmentNumber;
	private String pmEquipmentNumber;
	private Double originalValue;
	private Double netValue;
	private Date deliveryDate;
	private Date storageDate;
	private String isOccupied;
	private String occupiedOrgName;
	private String occupiedProjectName;
	private String unit;
	private String disposialStatus;
	private String maintenanceOrgId;
	private String subordinateMunicipality;
	private String subordinateMaintenanceOrg;
	private String modifierName; 
	private Double whetherBeenUsed;
	private String dataSourceFile;

	public AbstractPmsItemReuse(String pmsItemReuseId, String version, Date calYear, String oldEquipmentName,
			String equipmentType, String voltageLevel, String oldTransformSubstationLine, String repositoryAddress,
			String equipmentCustodian, String equipmentEvaluationResult, String assetProperty,
			String oldMaintenanceOrgName, String assetNumber, String equipmentNumber, String pmEquipmentNumber,
			Double originalValue, Double netValue, Date deliveryDate, Date storageDate, String isOccupied,
			String occupiedOrgName, String occupiedProjectName, String unit, String disposialStatus,
			String maintenanceOrgId, String subordinateMunicipality, String subordinateMaintenanceOrg,
			String modifierName, Double whetherBeenUsed, String dataSourceFile) {
		super();
		this.pmsItemReuseId = pmsItemReuseId;
		this.version = version;
		this.calYear = calYear;
		this.oldEquipmentName = oldEquipmentName;
		this.equipmentType = equipmentType;
		this.voltageLevel = voltageLevel;
		this.oldTransformSubstationLine = oldTransformSubstationLine;
		this.repositoryAddress = repositoryAddress;
		this.equipmentCustodian = equipmentCustodian;
		this.equipmentEvaluationResult = equipmentEvaluationResult;
		this.assetProperty = assetProperty;
		this.oldMaintenanceOrgName = oldMaintenanceOrgName;
		this.assetNumber = assetNumber;
		this.equipmentNumber = equipmentNumber;
		this.pmEquipmentNumber = pmEquipmentNumber;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.deliveryDate = deliveryDate;
		this.storageDate = storageDate;
		this.isOccupied = isOccupied;
		this.occupiedOrgName = occupiedOrgName;
		this.occupiedProjectName = occupiedProjectName;
		this.unit = unit;
		this.disposialStatus = disposialStatus;
		this.maintenanceOrgId = maintenanceOrgId;
		this.subordinateMunicipality = subordinateMunicipality;
		this.subordinateMaintenanceOrg = subordinateMaintenanceOrg;
		this.modifierName = modifierName; 
		this.whetherBeenUsed = whetherBeenUsed;
		this.dataSourceFile = dataSourceFile;
	}

	// Constructors

	/** default constructor */
	public AbstractPmsItemReuse() {
	}

	// Property accessors

	public AbstractPmsItemReuse(String pmsItemReuseId, String version, Date calYear, String oldEquipmentName,
			String equipmentType, String voltageLevel, String oldTransformSubstationLine, String repositoryAddress,
			String equipmentCustodian, String equipmentEvaluationResult, String assetProperty,
			String oldMaintenanceOrgName, String assetNumber, String equipmentNumber, String pmEquipmentNumber,
			Double originalValue, Double netValue, Date deliveryDate, Date storageDate, String isOccupied,
			String occupiedOrgName, String occupiedProjectName, String unit, String disposialStatus) {
		super();
		this.pmsItemReuseId = pmsItemReuseId;
		this.version = version;
		this.calYear = calYear;
		this.oldEquipmentName = oldEquipmentName;
		this.equipmentType = equipmentType;
		this.voltageLevel = voltageLevel;
		this.oldTransformSubstationLine = oldTransformSubstationLine;
		this.repositoryAddress = repositoryAddress;
		this.equipmentCustodian = equipmentCustodian;
		this.equipmentEvaluationResult = equipmentEvaluationResult;
		this.assetProperty = assetProperty;
		this.oldMaintenanceOrgName = oldMaintenanceOrgName;
		this.assetNumber = assetNumber;
		this.equipmentNumber = equipmentNumber;
		this.pmEquipmentNumber = pmEquipmentNumber;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.deliveryDate = deliveryDate;
		this.storageDate = storageDate;
		this.isOccupied = isOccupied;
		this.occupiedOrgName = occupiedOrgName;
		this.occupiedProjectName = occupiedProjectName;
		this.unit = unit;
		this.disposialStatus = disposialStatus;
	}

	public String getMaintenanceOrgId() {
		return maintenanceOrgId;
	}

	public void setMaintenanceOrgId(String maintenanceOrgId) {
		this.maintenanceOrgId = maintenanceOrgId;
	}

	public String getSubordinateMunicipality() {
		return subordinateMunicipality;
	}

	public void setSubordinateMunicipality(String subordinateMunicipality) {
		this.subordinateMunicipality = subordinateMunicipality;
	}

	public String getSubordinateMaintenanceOrg() {
		return subordinateMaintenanceOrg;
	}

	public void setSubordinateMaintenanceOrg(String subordinateMaintenanceOrg) {
		this.subordinateMaintenanceOrg = subordinateMaintenanceOrg;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	} 

	public Double getWhetherBeenUsed() {
		return whetherBeenUsed;
	}

	public void setWhetherBeenUsed(Double whetherBeenUsed) {
		this.whetherBeenUsed = whetherBeenUsed;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getDisposialStatus() {
		return disposialStatus;
	}

	public void setDisposialStatus(String disposialStatus) {
		this.disposialStatus = disposialStatus;
	}

	public String getPmsItemReuseId() {
		return this.pmsItemReuseId;
	}

	public void setPmsItemReuseId(String pmsItemReuseId) {
		this.pmsItemReuseId = pmsItemReuseId;
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

	public String getOldEquipmentName() {
		return this.oldEquipmentName;
	}

	public void setOldEquipmentName(String oldEquipmentName) {
		this.oldEquipmentName = oldEquipmentName;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getOldTransformSubstationLine() {
		return this.oldTransformSubstationLine;
	}

	public void setOldTransformSubstationLine(String oldTransformSubstationLine) {
		this.oldTransformSubstationLine = oldTransformSubstationLine;
	}

	public String getRepositoryAddress() {
		return this.repositoryAddress;
	}

	public void setRepositoryAddress(String repositoryAddress) {
		this.repositoryAddress = repositoryAddress;
	}

	public String getEquipmentCustodian() {
		return this.equipmentCustodian;
	}

	public void setEquipmentCustodian(String equipmentCustodian) {
		this.equipmentCustodian = equipmentCustodian;
	}

	public String getEquipmentEvaluationResult() {
		return this.equipmentEvaluationResult;
	}

	public void setEquipmentEvaluationResult(String equipmentEvaluationResult) {
		this.equipmentEvaluationResult = equipmentEvaluationResult;
	}

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getOldMaintenanceOrgName() {
		return this.oldMaintenanceOrgName;
	}

	public void setOldMaintenanceOrgName(String oldMaintenanceOrgName) {
		this.oldMaintenanceOrgName = oldMaintenanceOrgName;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getPmEquipmentNumber() {
		return this.pmEquipmentNumber;
	}

	public void setPmEquipmentNumber(String pmEquipmentNumber) {
		this.pmEquipmentNumber = pmEquipmentNumber;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getStorageDate() {
		return this.storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public String getIsOccupied() {
		return this.isOccupied;
	}

	public void setIsOccupied(String isOccupied) {
		this.isOccupied = isOccupied;
	}

	public String getOccupiedOrgName() {
		return this.occupiedOrgName;
	}

	public void setOccupiedOrgName(String occupiedOrgName) {
		this.occupiedOrgName = occupiedOrgName;
	}

	public String getOccupiedProjectName() {
		return this.occupiedProjectName;
	}

	public void setOccupiedProjectName(String occupiedProjectName) {
		this.occupiedProjectName = occupiedProjectName;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}