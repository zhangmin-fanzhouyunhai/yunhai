package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOPowerCapacitor entity provides the base persistence definition of
 * the OPowerCapacitor entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOPowerCapacitor implements java.io.Serializable {

	// Fields

	private String OPowerCapacitorId;
	private String dataVersion;
	private Date calYear;
	private String equipmentName;
	private String operationNumber;
	private String powerStation;
	private String spacerUnit;
	private String localCity;
	private String operationMaintenanDepartment;
	private String maintenanceTeam;
	private String equipmentOwner;
	private String voltageLevel;
	private String belongLargeFeederLine;
	private String equipmentStatus;
	private Date operationDate;
	private String whetherAgentMaintenance;
	private String largeFeederBrnachLine;
	private Date latestOperationDate;
	private String combinedEquipmentType;
	private String whetherRuralPowerNetwork;
	private String useEnvironment;
	private String importanceDegree;
	private String installationMode;
	private String accessMode;
	private String wiringMode;
	private String assetNature;
	private String assetDepartment;
	private String wbsId;
	private String assetId;
	private String projectNo;
	private String projectName;
	private String equipmentAdditionMethod;
	private String equipmentModel;
	private String manufacturer;
	private String factoryNumber;
	private String productCode;
	private String manufacturingCountry;
	private Date productionDate;
	private String insulatingMedium;
	private String capacitorBankInteProteMode;
	private String singleProtectionMode;
	private String ratedVoltageKv;
	private Double ratedCurrentA;
	private Double ratedFrequencyHz;
	private Double singleCapacityKvar;
	private Double wholeGroupCapacityKvar;
	private Double capacitanceUf;
	private String dispatchingJurisdiction;
	private Double equipmentNumber;
	private String dispatchingOperationRight;
	private String dispatchingPermission;
	private String dispatchingMonitoringRight;
	private Date registrationTime;
	private String equipmentId;
	private String remark;
	private String equipmentClassCode;
	private String combinedElectricalAppliance;
	private String combinedEquipmentName;
	private String combinedApparSwitchgearName;
	private String professionalClassification;
	private String pmId;
	private String functionalLocation;
	private String physicalId;
	private String accountCreationMethod;
	private String dataSourceFile;
 
	// Constructors

	/** default constructor */
	public AbstractOPowerCapacitor() {
	}

	/** minimal constructor */
	public AbstractOPowerCapacitor(String OPowerCapacitorId, String dataVersion, Date calYear) {
		this.OPowerCapacitorId = OPowerCapacitorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOPowerCapacitor(String OPowerCapacitorId, String dataVersion, Date calYear,
			String equipmentName, String operationNumber, String powerStation, String spacerUnit, String localCity,
			String operationMaintenanDepartment, String maintenanceTeam, String equipmentOwner, String voltageLevel,
			String belongLargeFeederLine, String equipmentStatus, Date operationDate,
			String whetherAgentMaintenance, String largeFeederBrnachLine, Date latestOperationDate,
			String combinedEquipmentType, String whetherRuralPowerNetwork, String useEnvironment,
			String importanceDegree, String installationMode, String accessMode, String wiringMode, String assetNature,
			String assetDepartment, String wbsId, String assetId, String projectNo, String projectName,
			String equipmentAdditionMethod, String equipmentModel, String manufacturer, String factoryNumber,
			String productCode, String manufacturingCountry, Date productionDate, String insulatingMedium,
			String capacitorBankInteProteMode, String singleProtectionMode, String ratedVoltageKv, Double ratedCurrentA,
			Double ratedFrequencyHz, Double singleCapacityKvar, Double wholeGroupCapacityKvar, Double capacitanceUf,
			String dispatchingJurisdiction, Double equipmentNumber, String dispatchingOperationRight,
			String dispatchingPermission, String dispatchingMonitoringRight, Date registrationTime,
			String equipmentId, String remark, String equipmentClassCode, String combinedElectricalAppliance,
			String combinedEquipmentName, String combinedApparSwitchgearName, String professionalClassification,
			String pmId, String functionalLocation, String physicalId, String accountCreationMethod) {
		this.OPowerCapacitorId = OPowerCapacitorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentName = equipmentName;
		this.operationNumber = operationNumber;
		this.powerStation = powerStation;
		this.spacerUnit = spacerUnit;
		this.localCity = localCity;
		this.operationMaintenanDepartment = operationMaintenanDepartment;
		this.maintenanceTeam = maintenanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.belongLargeFeederLine = belongLargeFeederLine;
		this.equipmentStatus = equipmentStatus;
		this.operationDate = operationDate;
		this.whetherAgentMaintenance = whetherAgentMaintenance;
		this.largeFeederBrnachLine = largeFeederBrnachLine;
		this.latestOperationDate = latestOperationDate;
		this.combinedEquipmentType = combinedEquipmentType;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.useEnvironment = useEnvironment;
		this.importanceDegree = importanceDegree;
		this.installationMode = installationMode;
		this.accessMode = accessMode;
		this.wiringMode = wiringMode;
		this.assetNature = assetNature;
		this.assetDepartment = assetDepartment;
		this.wbsId = wbsId;
		this.assetId = assetId;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.equipmentAdditionMethod = equipmentAdditionMethod;
		this.equipmentModel = equipmentModel;
		this.manufacturer = manufacturer;
		this.factoryNumber = factoryNumber;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.productionDate = productionDate;
		this.insulatingMedium = insulatingMedium;
		this.capacitorBankInteProteMode = capacitorBankInteProteMode;
		this.singleProtectionMode = singleProtectionMode;
		this.ratedVoltageKv = ratedVoltageKv;
		this.ratedCurrentA = ratedCurrentA;
		this.ratedFrequencyHz = ratedFrequencyHz;
		this.singleCapacityKvar = singleCapacityKvar;
		this.wholeGroupCapacityKvar = wholeGroupCapacityKvar;
		this.capacitanceUf = capacitanceUf;
		this.dispatchingJurisdiction = dispatchingJurisdiction;
		this.equipmentNumber = equipmentNumber;
		this.dispatchingOperationRight = dispatchingOperationRight;
		this.dispatchingPermission = dispatchingPermission;
		this.dispatchingMonitoringRight = dispatchingMonitoringRight;
		this.registrationTime = registrationTime;
		this.equipmentId = equipmentId;
		this.remark = remark;
		this.equipmentClassCode = equipmentClassCode;
		this.combinedElectricalAppliance = combinedElectricalAppliance;
		this.combinedEquipmentName = combinedEquipmentName;
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
		this.professionalClassification = professionalClassification;
		this.pmId = pmId;
		this.functionalLocation = functionalLocation;
		this.physicalId = physicalId;
		this.accountCreationMethod = accountCreationMethod;
	}

	public AbstractOPowerCapacitor(String oPowerCapacitorId, String dataVersion, Date calYear, String equipmentName,
			String operationNumber, String powerStation, String spacerUnit, String localCity,
			String operationMaintenanDepartment, String maintenanceTeam, String equipmentOwner, String voltageLevel,
			String belongLargeFeederLine, String equipmentStatus, Date operationDate, String whetherAgentMaintenance,
			String largeFeederBrnachLine, Date latestOperationDate, String combinedEquipmentType,
			String whetherRuralPowerNetwork, String useEnvironment, String importanceDegree, String installationMode,
			String accessMode, String wiringMode, String assetNature, String assetDepartment, String wbsId,
			String assetId, String projectNo, String projectName, String equipmentAdditionMethod, String equipmentModel,
			String manufacturer, String factoryNumber, String productCode, String manufacturingCountry,
			Date productionDate, String insulatingMedium, String capacitorBankInteProteMode,
			String singleProtectionMode, String ratedVoltageKv, Double ratedCurrentA, Double ratedFrequencyHz,
			Double singleCapacityKvar, Double wholeGroupCapacityKvar, Double capacitanceUf,
			String dispatchingJurisdiction, Double equipmentNumber, String dispatchingOperationRight,
			String dispatchingPermission, String dispatchingMonitoringRight, Date registrationTime, String equipmentId,
			String remark, String equipmentClassCode, String combinedElectricalAppliance, String combinedEquipmentName,
			String combinedApparSwitchgearName, String professionalClassification, String pmId,
			String functionalLocation, String physicalId, String accountCreationMethod, String dataSourceFile) {
		super();
		OPowerCapacitorId = oPowerCapacitorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentName = equipmentName;
		this.operationNumber = operationNumber;
		this.powerStation = powerStation;
		this.spacerUnit = spacerUnit;
		this.localCity = localCity;
		this.operationMaintenanDepartment = operationMaintenanDepartment;
		this.maintenanceTeam = maintenanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.belongLargeFeederLine = belongLargeFeederLine;
		this.equipmentStatus = equipmentStatus;
		this.operationDate = operationDate;
		this.whetherAgentMaintenance = whetherAgentMaintenance;
		this.largeFeederBrnachLine = largeFeederBrnachLine;
		this.latestOperationDate = latestOperationDate;
		this.combinedEquipmentType = combinedEquipmentType;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.useEnvironment = useEnvironment;
		this.importanceDegree = importanceDegree;
		this.installationMode = installationMode;
		this.accessMode = accessMode;
		this.wiringMode = wiringMode;
		this.assetNature = assetNature;
		this.assetDepartment = assetDepartment;
		this.wbsId = wbsId;
		this.assetId = assetId;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.equipmentAdditionMethod = equipmentAdditionMethod;
		this.equipmentModel = equipmentModel;
		this.manufacturer = manufacturer;
		this.factoryNumber = factoryNumber;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.productionDate = productionDate;
		this.insulatingMedium = insulatingMedium;
		this.capacitorBankInteProteMode = capacitorBankInteProteMode;
		this.singleProtectionMode = singleProtectionMode;
		this.ratedVoltageKv = ratedVoltageKv;
		this.ratedCurrentA = ratedCurrentA;
		this.ratedFrequencyHz = ratedFrequencyHz;
		this.singleCapacityKvar = singleCapacityKvar;
		this.wholeGroupCapacityKvar = wholeGroupCapacityKvar;
		this.capacitanceUf = capacitanceUf;
		this.dispatchingJurisdiction = dispatchingJurisdiction;
		this.equipmentNumber = equipmentNumber;
		this.dispatchingOperationRight = dispatchingOperationRight;
		this.dispatchingPermission = dispatchingPermission;
		this.dispatchingMonitoringRight = dispatchingMonitoringRight;
		this.registrationTime = registrationTime;
		this.equipmentId = equipmentId;
		this.remark = remark;
		this.equipmentClassCode = equipmentClassCode;
		this.combinedElectricalAppliance = combinedElectricalAppliance;
		this.combinedEquipmentName = combinedEquipmentName;
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
		this.professionalClassification = professionalClassification;
		this.pmId = pmId;
		this.functionalLocation = functionalLocation;
		this.physicalId = physicalId;
		this.accountCreationMethod = accountCreationMethod;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOPowerCapacitorId() {
		return this.OPowerCapacitorId;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOPowerCapacitorId(String OPowerCapacitorId) {
		this.OPowerCapacitorId = OPowerCapacitorId;
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

	public String getOperationMaintenanDepartment() {
		return this.operationMaintenanDepartment;
	}

	public void setOperationMaintenanDepartment(String operationMaintenanDepartment) {
		this.operationMaintenanDepartment = operationMaintenanDepartment;
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

	public String getBelongLargeFeederLine() {
		return this.belongLargeFeederLine;
	}

	public void setBelongLargeFeederLine(String belongLargeFeederLine) {
		this.belongLargeFeederLine = belongLargeFeederLine;
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

	public String getWhetherAgentMaintenance() {
		return this.whetherAgentMaintenance;
	}

	public void setWhetherAgentMaintenance(String whetherAgentMaintenance) {
		this.whetherAgentMaintenance = whetherAgentMaintenance;
	}

	public String getLargeFeederBrnachLine() {
		return this.largeFeederBrnachLine;
	}

	public void setLargeFeederBrnachLine(String largeFeederBrnachLine) {
		this.largeFeederBrnachLine = largeFeederBrnachLine;
	}

	public Date getLatestOperationDate() {
		return this.latestOperationDate;
	}

	public void setLatestOperationDate(Date latestOperationDate) {
		this.latestOperationDate = latestOperationDate;
	}

	public String getCombinedEquipmentType() {
		return this.combinedEquipmentType;
	}

	public void setCombinedEquipmentType(String combinedEquipmentType) {
		this.combinedEquipmentType = combinedEquipmentType;
	}

	public String getWhetherRuralPowerNetwork() {
		return this.whetherRuralPowerNetwork;
	}

	public void setWhetherRuralPowerNetwork(String whetherRuralPowerNetwork) {
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
	}

	public String getUseEnvironment() {
		return this.useEnvironment;
	}

	public void setUseEnvironment(String useEnvironment) {
		this.useEnvironment = useEnvironment;
	}

	public String getImportanceDegree() {
		return this.importanceDegree;
	}

	public void setImportanceDegree(String importanceDegree) {
		this.importanceDegree = importanceDegree;
	}

	public String getInstallationMode() {
		return this.installationMode;
	}

	public void setInstallationMode(String installationMode) {
		this.installationMode = installationMode;
	}

	public String getAccessMode() {
		return this.accessMode;
	}

	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	public String getWiringMode() {
		return this.wiringMode;
	}

	public void setWiringMode(String wiringMode) {
		this.wiringMode = wiringMode;
	}

	public String getAssetNature() {
		return this.assetNature;
	}

	public void setAssetNature(String assetNature) {
		this.assetNature = assetNature;
	}

	public String getAssetDepartment() {
		return this.assetDepartment;
	}

	public void setAssetDepartment(String assetDepartment) {
		this.assetDepartment = assetDepartment;
	}

	public String getWbsId() {
		return this.wbsId;
	}

	public void setWbsId(String wbsId) {
		this.wbsId = wbsId;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEquipmentAdditionMethod() {
		return this.equipmentAdditionMethod;
	}

	public void setEquipmentAdditionMethod(String equipmentAdditionMethod) {
		this.equipmentAdditionMethod = equipmentAdditionMethod;
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

	public String getInsulatingMedium() {
		return this.insulatingMedium;
	}

	public void setInsulatingMedium(String insulatingMedium) {
		this.insulatingMedium = insulatingMedium;
	}

	public String getCapacitorBankInteProteMode() {
		return this.capacitorBankInteProteMode;
	}

	public void setCapacitorBankInteProteMode(String capacitorBankInteProteMode) {
		this.capacitorBankInteProteMode = capacitorBankInteProteMode;
	}

	public String getSingleProtectionMode() {
		return this.singleProtectionMode;
	}

	public void setSingleProtectionMode(String singleProtectionMode) {
		this.singleProtectionMode = singleProtectionMode;
	}

	public String getRatedVoltageKv() {
		return this.ratedVoltageKv;
	}

	public void setRatedVoltageKv(String ratedVoltageKv) {
		this.ratedVoltageKv = ratedVoltageKv;
	}

	public Double getRatedCurrentA() {
		return this.ratedCurrentA;
	}

	public void setRatedCurrentA(Double ratedCurrentA) {
		this.ratedCurrentA = ratedCurrentA;
	}

	public Double getRatedFrequencyHz() {
		return this.ratedFrequencyHz;
	}

	public void setRatedFrequencyHz(Double ratedFrequencyHz) {
		this.ratedFrequencyHz = ratedFrequencyHz;
	}

	public Double getSingleCapacityKvar() {
		return this.singleCapacityKvar;
	}

	public void setSingleCapacityKvar(Double singleCapacityKvar) {
		this.singleCapacityKvar = singleCapacityKvar;
	}

	public Double getWholeGroupCapacityKvar() {
		return this.wholeGroupCapacityKvar;
	}

	public void setWholeGroupCapacityKvar(Double wholeGroupCapacityKvar) {
		this.wholeGroupCapacityKvar = wholeGroupCapacityKvar;
	}

	public Double getCapacitanceUf() {
		return this.capacitanceUf;
	}

	public void setCapacitanceUf(Double capacitanceUf) {
		this.capacitanceUf = capacitanceUf;
	}

	public String getDispatchingJurisdiction() {
		return this.dispatchingJurisdiction;
	}

	public void setDispatchingJurisdiction(String dispatchingJurisdiction) {
		this.dispatchingJurisdiction = dispatchingJurisdiction;
	}

	public Double getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(Double equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getDispatchingOperationRight() {
		return this.dispatchingOperationRight;
	}

	public void setDispatchingOperationRight(String dispatchingOperationRight) {
		this.dispatchingOperationRight = dispatchingOperationRight;
	}

	public String getDispatchingPermission() {
		return this.dispatchingPermission;
	}

	public void setDispatchingPermission(String dispatchingPermission) {
		this.dispatchingPermission = dispatchingPermission;
	}

	public String getDispatchingMonitoringRight() {
		return this.dispatchingMonitoringRight;
	}

	public void setDispatchingMonitoringRight(String dispatchingMonitoringRight) {
		this.dispatchingMonitoringRight = dispatchingMonitoringRight;
	}

	public Date getRegistrationTime() {
		return this.registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEquipmentClassCode() {
		return this.equipmentClassCode;
	}

	public void setEquipmentClassCode(String equipmentClassCode) {
		this.equipmentClassCode = equipmentClassCode;
	}

	public String getCombinedElectricalAppliance() {
		return this.combinedElectricalAppliance;
	}

	public void setCombinedElectricalAppliance(String combinedElectricalAppliance) {
		this.combinedElectricalAppliance = combinedElectricalAppliance;
	}

	public String getCombinedEquipmentName() {
		return this.combinedEquipmentName;
	}

	public void setCombinedEquipmentName(String combinedEquipmentName) {
		this.combinedEquipmentName = combinedEquipmentName;
	}

	public String getCombinedApparSwitchgearName() {
		return this.combinedApparSwitchgearName;
	}

	public void setCombinedApparSwitchgearName(String combinedApparSwitchgearName) {
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
	}

	public String getProfessionalClassification() {
		return this.professionalClassification;
	}

	public void setProfessionalClassification(String professionalClassification) {
		this.professionalClassification = professionalClassification;
	}

	public String getPmId() {
		return this.pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public String getFunctionalLocation() {
		return this.functionalLocation;
	}

	public void setFunctionalLocation(String functionalLocation) {
		this.functionalLocation = functionalLocation;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setPhysicalId(String physicalId) {
		this.physicalId = physicalId;
	}

	public String getAccountCreationMethod() {
		return this.accountCreationMethod;
	}

	public void setAccountCreationMethod(String accountCreationMethod) {
		this.accountCreationMethod = accountCreationMethod;
	}

}