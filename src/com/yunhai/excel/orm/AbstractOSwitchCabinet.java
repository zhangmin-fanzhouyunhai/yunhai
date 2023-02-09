package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOSwitchCabinet entity provides the base persistence definition of the
 * OSwitchCabinet entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOSwitchCabinet implements java.io.Serializable {

	// Fields

	private String OSwitchCabinetId;
	private String dataVersion;
	private Date calYear;
	private String dataSourceFile;
	private String equipmentName;
	private String operationNumber;
	private String powerStation;
	private String spacerUnit;
	private String localCity;
	private String operationMaintenanceOrg;
	private String maintenanceTeam;
	private String equipmentOwner;
	private String voltageLevel;
	private String equipmentStatus;
	private Date operationDate;
	private Date latestOperationDate;
	private String generationMaintenance;
	private String regionalCharacteristics;
	private String equipmentClass;
	private String ruralPowerNetwork;
	private String useEnvironment;
	private String assetNature;
	private String assetUnit;
	private String assetId;
	private String itemCode;
	private String equipmentAdditionMethod;
	private String singleItemCoding;
	private String entryName;
	private String itemName;
	private String equipmentModel;
	private String manufacturer;
	private String wbsCode;
	private String factoryNumber;
	private String productCode;
	private String manufacturingCountry;
	private Date productionDate;
	private Double ratedVoltageKv;
	private Double heightMm;
	private Double widthMm;
	private Double ratedCurrentA;
	private Double depthMm;
	private Double ratedFrequencyHz;
	private String insulatingMedium;
	private String whetherIacLevel;
	private String whetherLsc2Class;
	private String backCoverOrNot;
	private String structureType;
	private Double cabinetWidthMm;
	private String equipmentId;
	private Date registrationTime;
	private String remarks;
	private String accountCreationMethod;
	private String physicalId;
	private String powerStationVoltageLevel;
	private String functionalLocation;
	private String pmId;
	private String professionalClassification;
	private String equipmentTypeCode;
	private String whetherStandardized;
	private String voltageClassCode;
	private String voltageClassName;

	// Constructors

	/** default constructor */
	public AbstractOSwitchCabinet() {
	}

	/** minimal constructor */
	public AbstractOSwitchCabinet(String OSwitchCabinetId, String dataVersion, Date calYear,
			String dataSourceFile) {
		this.OSwitchCabinetId = OSwitchCabinetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataSourceFile = dataSourceFile;
	}

	/** full constructor */
	public AbstractOSwitchCabinet(String OSwitchCabinetId, String dataVersion, Date calYear,
			String dataSourceFile, String equipmentName, String operationNumber, String powerStation,
			String spacerUnit, String localCity, String operationMaintenanceOrg, String maintenanceTeam,
			String equipmentOwner, String voltageLevel, String equipmentStatus, Date operationDate,
			Date latestOperationDate, String generationMaintenance, String regionalCharacteristics,
			String equipmentClass, String ruralPowerNetwork, String useEnvironment, String assetNature,
			String assetUnit, String assetId, String itemCode, String equipmentAdditionMethod,
			String singleItemCoding, String entryName, String itemName, String equipmentModel, String manufacturer,
			String wbsCode, String factoryNumber, String productCode, String manufacturingCountry,
			Date productionDate, Double ratedVoltageKv, Double heightMm, Double widthMm, Double ratedCurrentA,
			Double depthMm, Double ratedFrequencyHz, String insulatingMedium, String whetherIacLevel,
			String whetherLsc2Class, String backCoverOrNot, String structureType, Double cabinetWidthMm,
			String equipmentId, Date registrationTime, String remarks, String accountCreationMethod,
			String physicalId, String powerStationVoltageLevel, String functionalLocation, String pmId,
			String professionalClassification, String equipmentTypeCode, String whetherStandardized,
			String voltageClassCode, String voltageClassName) {
		this.OSwitchCabinetId = OSwitchCabinetId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataSourceFile = dataSourceFile;
		this.equipmentName = equipmentName;
		this.operationNumber = operationNumber;
		this.powerStation = powerStation;
		this.spacerUnit = spacerUnit;
		this.localCity = localCity;
		this.operationMaintenanceOrg = operationMaintenanceOrg;
		this.maintenanceTeam = maintenanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.equipmentStatus = equipmentStatus;
		this.operationDate = operationDate;
		this.latestOperationDate = latestOperationDate;
		this.generationMaintenance = generationMaintenance;
		this.regionalCharacteristics = regionalCharacteristics;
		this.equipmentClass = equipmentClass;
		this.ruralPowerNetwork = ruralPowerNetwork;
		this.useEnvironment = useEnvironment;
		this.assetNature = assetNature;
		this.assetUnit = assetUnit;
		this.assetId = assetId;
		this.itemCode = itemCode;
		this.equipmentAdditionMethod = equipmentAdditionMethod;
		this.singleItemCoding = singleItemCoding;
		this.entryName = entryName;
		this.itemName = itemName;
		this.equipmentModel = equipmentModel;
		this.manufacturer = manufacturer;
		this.wbsCode = wbsCode;
		this.factoryNumber = factoryNumber;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.productionDate = productionDate;
		this.ratedVoltageKv = ratedVoltageKv;
		this.heightMm = heightMm;
		this.widthMm = widthMm;
		this.ratedCurrentA = ratedCurrentA;
		this.depthMm = depthMm;
		this.ratedFrequencyHz = ratedFrequencyHz;
		this.insulatingMedium = insulatingMedium;
		this.whetherIacLevel = whetherIacLevel;
		this.whetherLsc2Class = whetherLsc2Class;
		this.backCoverOrNot = backCoverOrNot;
		this.structureType = structureType;
		this.cabinetWidthMm = cabinetWidthMm;
		this.equipmentId = equipmentId;
		this.registrationTime = registrationTime;
		this.remarks = remarks;
		this.accountCreationMethod = accountCreationMethod;
		this.physicalId = physicalId;
		this.powerStationVoltageLevel = powerStationVoltageLevel;
		this.functionalLocation = functionalLocation;
		this.pmId = pmId;
		this.professionalClassification = professionalClassification;
		this.equipmentTypeCode = equipmentTypeCode;
		this.whetherStandardized = whetherStandardized;
		this.voltageClassCode = voltageClassCode;
		this.voltageClassName = voltageClassName;
	}

	// Property accessors

	public String getOSwitchCabinetId() {
		return this.OSwitchCabinetId;
	}

	public void setOSwitchCabinetId(String OSwitchCabinetId) {
		this.OSwitchCabinetId = OSwitchCabinetId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getOperationNumber() {
		return this.operationNumber;
	}

	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getPowerStation() {
		return this.powerStation;
	}

	public void setPowerStation(String powerStation) {
		this.powerStation = powerStation;
	}

	public String getSpacerUnit() {
		return this.spacerUnit;
	}

	public void setSpacerUnit(String spacerUnit) {
		this.spacerUnit = spacerUnit;
	}

	public String getLocalCity() {
		return this.localCity;
	}

	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}

	public String getOperationMaintenanceOrg() {
		return this.operationMaintenanceOrg;
	}

	public void setOperationMaintenanceOrg(String operationMaintenanceOrg) {
		this.operationMaintenanceOrg = operationMaintenanceOrg;
	}

	public String getMaintenanceTeam() {
		return this.maintenanceTeam;
	}

	public void setMaintenanceTeam(String maintenanceTeam) {
		this.maintenanceTeam = maintenanceTeam;
	}

	public String getEquipmentOwner() {
		return this.equipmentOwner;
	}

	public void setEquipmentOwner(String equipmentOwner) {
		this.equipmentOwner = equipmentOwner;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Date getLatestOperationDate() {
		return this.latestOperationDate;
	}

	public void setLatestOperationDate(Date latestOperationDate) {
		this.latestOperationDate = latestOperationDate;
	}

	public String getGenerationMaintenance() {
		return this.generationMaintenance;
	}

	public void setGenerationMaintenance(String generationMaintenance) {
		this.generationMaintenance = generationMaintenance;
	}

	public String getRegionalCharacteristics() {
		return this.regionalCharacteristics;
	}

	public void setRegionalCharacteristics(String regionalCharacteristics) {
		this.regionalCharacteristics = regionalCharacteristics;
	}

	public String getEquipmentClass() {
		return this.equipmentClass;
	}

	public void setEquipmentClass(String equipmentClass) {
		this.equipmentClass = equipmentClass;
	}

	public String getRuralPowerNetwork() {
		return this.ruralPowerNetwork;
	}

	public void setRuralPowerNetwork(String ruralPowerNetwork) {
		this.ruralPowerNetwork = ruralPowerNetwork;
	}

	public String getUseEnvironment() {
		return this.useEnvironment;
	}

	public void setUseEnvironment(String useEnvironment) {
		this.useEnvironment = useEnvironment;
	}

	public String getAssetNature() {
		return this.assetNature;
	}

	public void setAssetNature(String assetNature) {
		this.assetNature = assetNature;
	}

	public String getAssetUnit() {
		return this.assetUnit;
	}

	public void setAssetUnit(String assetUnit) {
		this.assetUnit = assetUnit;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getEquipmentAdditionMethod() {
		return this.equipmentAdditionMethod;
	}

	public void setEquipmentAdditionMethod(String equipmentAdditionMethod) {
		this.equipmentAdditionMethod = equipmentAdditionMethod;
	}

	public String getSingleItemCoding() {
		return this.singleItemCoding;
	}

	public void setSingleItemCoding(String singleItemCoding) {
		this.singleItemCoding = singleItemCoding;
	}

	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getEquipmentModel() {
		return this.equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getWbsCode() {
		return this.wbsCode;
	}

	public void setWbsCode(String wbsCode) {
		this.wbsCode = wbsCode;
	}

	public String getFactoryNumber() {
		return this.factoryNumber;
	}

	public void setFactoryNumber(String factoryNumber) {
		this.factoryNumber = factoryNumber;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getManufacturingCountry() {
		return this.manufacturingCountry;
	}

	public void setManufacturingCountry(String manufacturingCountry) {
		this.manufacturingCountry = manufacturingCountry;
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Double getRatedVoltageKv() {
		return this.ratedVoltageKv;
	}

	public void setRatedVoltageKv(Double ratedVoltageKv) {
		this.ratedVoltageKv = ratedVoltageKv;
	}

	public Double getHeightMm() {
		return this.heightMm;
	}

	public void setHeightMm(Double heightMm) {
		this.heightMm = heightMm;
	}

	public Double getWidthMm() {
		return this.widthMm;
	}

	public void setWidthMm(Double widthMm) {
		this.widthMm = widthMm;
	}

	public Double getRatedCurrentA() {
		return this.ratedCurrentA;
	}

	public void setRatedCurrentA(Double ratedCurrentA) {
		this.ratedCurrentA = ratedCurrentA;
	}

	public Double getDepthMm() {
		return this.depthMm;
	}

	public void setDepthMm(Double depthMm) {
		this.depthMm = depthMm;
	}

	public Double getRatedFrequencyHz() {
		return this.ratedFrequencyHz;
	}

	public void setRatedFrequencyHz(Double ratedFrequencyHz) {
		this.ratedFrequencyHz = ratedFrequencyHz;
	}

	public String getInsulatingMedium() {
		return this.insulatingMedium;
	}

	public void setInsulatingMedium(String insulatingMedium) {
		this.insulatingMedium = insulatingMedium;
	}

	public String getWhetherIacLevel() {
		return this.whetherIacLevel;
	}

	public void setWhetherIacLevel(String whetherIacLevel) {
		this.whetherIacLevel = whetherIacLevel;
	}

	public String getWhetherLsc2Class() {
		return this.whetherLsc2Class;
	}

	public void setWhetherLsc2Class(String whetherLsc2Class) {
		this.whetherLsc2Class = whetherLsc2Class;
	}

	public String getBackCoverOrNot() {
		return this.backCoverOrNot;
	}

	public void setBackCoverOrNot(String backCoverOrNot) {
		this.backCoverOrNot = backCoverOrNot;
	}

	public String getStructureType() {
		return this.structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public Double getCabinetWidthMm() {
		return this.cabinetWidthMm;
	}

	public void setCabinetWidthMm(Double cabinetWidthMm) {
		this.cabinetWidthMm = cabinetWidthMm;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Date getRegistrationTime() {
		return this.registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAccountCreationMethod() {
		return this.accountCreationMethod;
	}

	public void setAccountCreationMethod(String accountCreationMethod) {
		this.accountCreationMethod = accountCreationMethod;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setPhysicalId(String physicalId) {
		this.physicalId = physicalId;
	}

	public String getPowerStationVoltageLevel() {
		return this.powerStationVoltageLevel;
	}

	public void setPowerStationVoltageLevel(String powerStationVoltageLevel) {
		this.powerStationVoltageLevel = powerStationVoltageLevel;
	}

	public String getFunctionalLocation() {
		return this.functionalLocation;
	}

	public void setFunctionalLocation(String functionalLocation) {
		this.functionalLocation = functionalLocation;
	}

	public String getPmId() {
		return this.pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public String getProfessionalClassification() {
		return this.professionalClassification;
	}

	public void setProfessionalClassification(String professionalClassification) {
		this.professionalClassification = professionalClassification;
	}

	public String getEquipmentTypeCode() {
		return this.equipmentTypeCode;
	}

	public void setEquipmentTypeCode(String equipmentTypeCode) {
		this.equipmentTypeCode = equipmentTypeCode;
	}

	public String getWhetherStandardized() {
		return this.whetherStandardized;
	}

	public void setWhetherStandardized(String whetherStandardized) {
		this.whetherStandardized = whetherStandardized;
	}

	public String getVoltageClassCode() {
		return this.voltageClassCode;
	}

	public void setVoltageClassCode(String voltageClassCode) {
		this.voltageClassCode = voltageClassCode;
	}

	public String getVoltageClassName() {
		return this.voltageClassName;
	}

	public void setVoltageClassName(String voltageClassName) {
		this.voltageClassName = voltageClassName;
	}

}