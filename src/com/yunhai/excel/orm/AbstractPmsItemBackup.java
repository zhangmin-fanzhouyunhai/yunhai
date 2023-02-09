package com.yunhai.excel.orm;

import java.io.Serializable;
import java.util.Date;

public class AbstractPmsItemBackup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6448620167512441497L;
	private String pmsItemBackupId;
	private Date calYear;
	private String version;
	private String backupItemSource;
	private String equipmentType;
	private String voltageLevel;
	private String manufacturer;
	private String equipmentModel;
	private String reporsitoryAddress;
	private String equipmentCustodian;
	private String equipmentEvaluationResult;
	private String assetProperty;
	private String orgName;
	private String assetNumber;
	private String equipmentNumber;
	private Date storageDate;
	private String backupEquipmentStatus;
	private String projectName;
	private Double originalValue;
	private Double netValue;
	private String unit;
	private String maintenanceOrgId;
	private String subordinateMunicipality;
	private String subordinateMaintenanceOrg;
	private String modifierName;
	private String projectId;
	private String dataSourceFile;

	public AbstractPmsItemBackup(String pmsItemBackupId, Date calYear, String version, String backupItemSource,
			String equipmentType, String voltageLevel, String manufacturer, String equipmentModel,
			String reporsitoryAddress, String equipmentCustodian, String equipmentEvaluationResult,
			String assetProperty, String orgName, String assetNumber, String equipmentNumber, Date storageDate,
			String backupEquipmentStatus, String projectName, Double originalValue, Double netValue, String unit,
			String maintenanceOrgId, String subordinateMunicipality, String subordinateMaintenanceOrg,
			String modifierName, String projectId, String dataSourceFile) {
		super();
		this.pmsItemBackupId = pmsItemBackupId;
		this.calYear = calYear;
		this.version = version;
		this.backupItemSource = backupItemSource;
		this.equipmentType = equipmentType;
		this.voltageLevel = voltageLevel;
		this.manufacturer = manufacturer;
		this.equipmentModel = equipmentModel;
		this.reporsitoryAddress = reporsitoryAddress;
		this.equipmentCustodian = equipmentCustodian;
		this.equipmentEvaluationResult = equipmentEvaluationResult;
		this.assetProperty = assetProperty;
		this.orgName = orgName;
		this.assetNumber = assetNumber;
		this.equipmentNumber = equipmentNumber;
		this.storageDate = storageDate;
		this.backupEquipmentStatus = backupEquipmentStatus;
		this.projectName = projectName;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.unit = unit;
		this.maintenanceOrgId = maintenanceOrgId;
		this.subordinateMunicipality = subordinateMunicipality;
		this.subordinateMaintenanceOrg = subordinateMaintenanceOrg;
		this.modifierName = modifierName;
		this.projectId = projectId;
		this.dataSourceFile = dataSourceFile;
	}

	public AbstractPmsItemBackup() {
	}

	public AbstractPmsItemBackup(String pmsItemBackupId, Date calYear, String version, String backupItemSource,
			String equipmentType, String voltageLevel, String manufacturer, String equipmentModel,
			String reporsitoryAddress, String equipmentCustodian, String equipmentEvaluationResult,
			String assetProperty, String orgName, String assetNumber, String equipmentNumber, Date storageDate,
			String backupEquipmentStatus, String projectName, Double originalValue, Double netValue, String unit) {
		super();
		this.pmsItemBackupId = pmsItemBackupId;
		this.calYear = calYear;
		this.version = version;
		this.backupItemSource = backupItemSource;
		this.equipmentType = equipmentType;
		this.voltageLevel = voltageLevel;
		this.manufacturer = manufacturer;
		this.equipmentModel = equipmentModel;
		this.reporsitoryAddress = reporsitoryAddress;
		this.equipmentCustodian = equipmentCustodian;
		this.equipmentEvaluationResult = equipmentEvaluationResult;
		this.assetProperty = assetProperty;
		this.orgName = orgName;
		this.assetNumber = assetNumber;
		this.equipmentNumber = equipmentNumber;
		this.storageDate = storageDate;
		this.backupEquipmentStatus = backupEquipmentStatus;
		this.projectName = projectName;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.unit = unit;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getPmsItemBackupId() {
		return pmsItemBackupId;
	}

	public void setPmsItemBackupId(String pmsItemBackupId) {
		this.pmsItemBackupId = pmsItemBackupId;
	}

	public Date getCalYear() {
		return calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBackupItemSource() {
		return backupItemSource;
	}

	public void setBackupItemSource(String backupItemSource) {
		this.backupItemSource = backupItemSource;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getVoltageLevel() {
		return voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getReporsitoryAddress() {
		return reporsitoryAddress;
	}

	public void setReporsitoryAddress(String reporsitoryAddress) {
		this.reporsitoryAddress = reporsitoryAddress;
	}

	public String getEquipmentCustodian() {
		return equipmentCustodian;
	}

	public void setEquipmentCustodian(String equipmentCustodian) {
		this.equipmentCustodian = equipmentCustodian;
	}

	public String getEquipmentEvaluationResult() {
		return equipmentEvaluationResult;
	}

	public void setEquipmentEvaluationResult(String equipmentEvaluationResult) {
		this.equipmentEvaluationResult = equipmentEvaluationResult;
	}

	public String getAssetProperty() {
		return assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public String getBackupEquipmentStatus() {
		return backupEquipmentStatus;
	}

	public void setBackupEquipmentStatus(String backupEquipmentStatus) {
		this.backupEquipmentStatus = backupEquipmentStatus;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getNetValue() {
		return netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
