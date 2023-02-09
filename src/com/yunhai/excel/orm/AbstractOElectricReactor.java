package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOElectricReactor entity provides the base persistence definition of
 * the OElectricReactor entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOElectricReactor implements java.io.Serializable {

	// Fields

	private String OElectricReactorId;
	private String dataVersion;
	private Date calYear;
	private String equipmentName;
	private String associatFixedFireExtingSys;
	private String operationNumber;
	private String powerStation;
	private String spacerUnit;
	private String localCity;
	private String operationMaintenanDepartment;
	private String maintenanceTeam;
	private String equipmentOwner;
	private String voltageLevel;
	private String equipmentStatus;
	private String largeFeederLine;
	private String phaseNumber;
	private String phaseName;
	private String largeFeederBrnachLine;
	private Date operationDate;
	private Date latestOperationDate;
	private String whetherRuralPowerNetwork;
	private String combinedEquipmentClass;
	private String accessMode;
	private String useEnvironment;
	private String whetherAgentMaintenance;
	private String installationMode;
	private String regionalCharacteristic;
	private String assetNature;
	private String assetOrganization;
	private String wbsId;
	private String assetId;
	private String equipmentClassCode;
	private String projectNo;
	private String projectName;
	private String equipmentAdditionMethod;
	private String model;
	private String manufacturer;
	private String factoryNumber;
	private String productCode;
	private String manufacturingCountry;
	private Date dateOfProduction;
	private String insulationClass;
	private String antifoulingGrade;
	private String ratedVoltageKv;
	private Double ratedCurrentA;
	private Double ratedFrequencyHz;
	private String coolingMode;
	private String voltageRegulationMode;
	private String insulatingMedium;
	private String magneticConductionStructure;
	private Double ratedCapacityKvar;
	private Double ratedReactanceOmega;
	private Double ratedReactanceRate;
	private Double ratedInductanceMh;
	private Double totalWeightT;
	private String oilNumber;
	private String oilProducingArea;
	private Double ratedLossKw;
	private Double percentImpedancePercent;
	private Double ratedSTimeWithstandCurrKa;
	private Double ratedPeakWithstandCurrKa;
	private Double ratedShortCircuitDuratMs;
	private String insulationLevel;
	private Double bodyWeightT;
	private String insulationLevelNeutralPoint;
	private Double zeroSequenceReactanceOmega;
	private Double continuWorkOvervoltageMulti;
	private Double oilWeightT;
	private String oilTankStructure;
	private String conservatorSealingMode;
	private String equipmentId;
	private Double continuWorkOvercurrentMulti;
	private Date registrationTime;
	private String remark;
	private String stationLineName;
	private String accountCreationMethod;
	private String voltageClassName;
	private String combinedApparSwitchgearName;
	private String belongCombinApparSwitchgear;
	private String equipmentManufacturer;
	private String professionalClassification;
	private String pmId;
	private String functionalLocation;
	private String belongStationVoltageLevel;
	private String physicalId;
	private String voltageClassCode;
	private String dataSourceFile;
 
	// Constructors

	/** default constructor */
	public AbstractOElectricReactor() {
	}

	/** minimal constructor */
	public AbstractOElectricReactor(String OElectricReactorId, String dataVersion, Date calYear) {
		this.OElectricReactorId = OElectricReactorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOElectricReactor(String OElectricReactorId, String dataVersion, Date calYear,
			String equipmentName, String associatFixedFireExtingSys, String operationNumber, String powerStation,
			String spacerUnit, String localCity, String operationMaintenanDepartment, String maintenanceTeam,
			String equipmentOwner, String voltageLevel, String equipmentStatus, String largeFeederLine,
			String phaseNumber, String phaseName, String largeFeederBrnachLine, Date operationDate,
			Date latestOperationDate, String whetherRuralPowerNetwork, String combinedEquipmentClass,
			String accessMode, String useEnvironment, String whetherAgentMaintenance, String installationMode,
			String regionalCharacteristic, String assetNature, String assetOrganization, String wbsId, String assetId,
			String equipmentClassCode, String projectNo, String projectName, String equipmentAdditionMethod,
			String model, String manufacturer, String factoryNumber, String productCode, String manufacturingCountry,
			Date dateOfProduction, String insulationClass, String antifoulingGrade, String ratedVoltageKv,
			Double ratedCurrentA, Double ratedFrequencyHz, String coolingMode, String voltageRegulationMode,
			String insulatingMedium, String magneticConductionStructure, Double ratedCapacityKvar,
			Double ratedReactanceOmega, Double ratedReactanceRate, Double ratedInductanceMh, Double totalWeightT,
			String oilNumber, String oilProducingArea, Double ratedLossKw, Double percentImpedancePercent,
			Double ratedSTimeWithstandCurrKa, Double ratedPeakWithstandCurrKa, Double ratedShortCircuitDuratMs,
			String insulationLevel, Double bodyWeightT, String insulationLevelNeutralPoint,
			Double zeroSequenceReactanceOmega, Double continuWorkOvervoltageMulti, Double oilWeightT,
			String oilTankStructure, String conservatorSealingMode, String equipmentId,
			Double continuWorkOvercurrentMulti, Date registrationTime, String remark, String stationLineName,
			String accountCreationMethod, String voltageClassName, String combinedApparSwitchgearName,
			String belongCombinApparSwitchgear, String equipmentManufacturer, String professionalClassification,
			String pmId, String functionalLocation, String belongStationVoltageLevel, String physicalId,
			String voltageClassCode) {
		this.OElectricReactorId = OElectricReactorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentName = equipmentName;
		this.associatFixedFireExtingSys = associatFixedFireExtingSys;
		this.operationNumber = operationNumber;
		this.powerStation = powerStation;
		this.spacerUnit = spacerUnit;
		this.localCity = localCity;
		this.operationMaintenanDepartment = operationMaintenanDepartment;
		this.maintenanceTeam = maintenanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.equipmentStatus = equipmentStatus;
		this.largeFeederLine = largeFeederLine;
		this.phaseNumber = phaseNumber;
		this.phaseName = phaseName;
		this.largeFeederBrnachLine = largeFeederBrnachLine;
		this.operationDate = operationDate;
		this.latestOperationDate = latestOperationDate;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.combinedEquipmentClass = combinedEquipmentClass;
		this.accessMode = accessMode;
		this.useEnvironment = useEnvironment;
		this.whetherAgentMaintenance = whetherAgentMaintenance;
		this.installationMode = installationMode;
		this.regionalCharacteristic = regionalCharacteristic;
		this.assetNature = assetNature;
		this.assetOrganization = assetOrganization;
		this.wbsId = wbsId;
		this.assetId = assetId;
		this.equipmentClassCode = equipmentClassCode;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.equipmentAdditionMethod = equipmentAdditionMethod;
		this.model = model;
		this.manufacturer = manufacturer;
		this.factoryNumber = factoryNumber;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.dateOfProduction = dateOfProduction;
		this.insulationClass = insulationClass;
		this.antifoulingGrade = antifoulingGrade;
		this.ratedVoltageKv = ratedVoltageKv;
		this.ratedCurrentA = ratedCurrentA;
		this.ratedFrequencyHz = ratedFrequencyHz;
		this.coolingMode = coolingMode;
		this.voltageRegulationMode = voltageRegulationMode;
		this.insulatingMedium = insulatingMedium;
		this.magneticConductionStructure = magneticConductionStructure;
		this.ratedCapacityKvar = ratedCapacityKvar;
		this.ratedReactanceOmega = ratedReactanceOmega;
		this.ratedReactanceRate = ratedReactanceRate;
		this.ratedInductanceMh = ratedInductanceMh;
		this.totalWeightT = totalWeightT;
		this.oilNumber = oilNumber;
		this.oilProducingArea = oilProducingArea;
		this.ratedLossKw = ratedLossKw;
		this.percentImpedancePercent = percentImpedancePercent;
		this.ratedSTimeWithstandCurrKa = ratedSTimeWithstandCurrKa;
		this.ratedPeakWithstandCurrKa = ratedPeakWithstandCurrKa;
		this.ratedShortCircuitDuratMs = ratedShortCircuitDuratMs;
		this.insulationLevel = insulationLevel;
		this.bodyWeightT = bodyWeightT;
		this.insulationLevelNeutralPoint = insulationLevelNeutralPoint;
		this.zeroSequenceReactanceOmega = zeroSequenceReactanceOmega;
		this.continuWorkOvervoltageMulti = continuWorkOvervoltageMulti;
		this.oilWeightT = oilWeightT;
		this.oilTankStructure = oilTankStructure;
		this.conservatorSealingMode = conservatorSealingMode;
		this.equipmentId = equipmentId;
		this.continuWorkOvercurrentMulti = continuWorkOvercurrentMulti;
		this.registrationTime = registrationTime;
		this.remark = remark;
		this.stationLineName = stationLineName;
		this.accountCreationMethod = accountCreationMethod;
		this.voltageClassName = voltageClassName;
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
		this.belongCombinApparSwitchgear = belongCombinApparSwitchgear;
		this.equipmentManufacturer = equipmentManufacturer;
		this.professionalClassification = professionalClassification;
		this.pmId = pmId;
		this.functionalLocation = functionalLocation;
		this.belongStationVoltageLevel = belongStationVoltageLevel;
		this.physicalId = physicalId;
		this.voltageClassCode = voltageClassCode;
	}

	// Property accessors

	public AbstractOElectricReactor(String oElectricReactorId, String dataVersion, Date calYear, String equipmentName,
			String associatFixedFireExtingSys, String operationNumber, String powerStation, String spacerUnit,
			String localCity, String operationMaintenanDepartment, String maintenanceTeam, String equipmentOwner,
			String voltageLevel, String equipmentStatus, String largeFeederLine, String phaseNumber, String phaseName,
			String largeFeederBrnachLine, Date operationDate, Date latestOperationDate, String whetherRuralPowerNetwork,
			String combinedEquipmentClass, String accessMode, String useEnvironment, String whetherAgentMaintenance,
			String installationMode, String regionalCharacteristic, String assetNature, String assetOrganization,
			String wbsId, String assetId, String equipmentClassCode, String projectNo, String projectName,
			String equipmentAdditionMethod, String model, String manufacturer, String factoryNumber, String productCode,
			String manufacturingCountry, Date dateOfProduction, String insulationClass, String antifoulingGrade,
			String ratedVoltageKv, Double ratedCurrentA, Double ratedFrequencyHz, String coolingMode,
			String voltageRegulationMode, String insulatingMedium, String magneticConductionStructure,
			Double ratedCapacityKvar, Double ratedReactanceOmega, Double ratedReactanceRate, Double ratedInductanceMh,
			Double totalWeightT, String oilNumber, String oilProducingArea, Double ratedLossKw,
			Double percentImpedancePercent, Double ratedSTimeWithstandCurrKa, Double ratedPeakWithstandCurrKa,
			Double ratedShortCircuitDuratMs, String insulationLevel, Double bodyWeightT,
			String insulationLevelNeutralPoint, Double zeroSequenceReactanceOmega, Double continuWorkOvervoltageMulti,
			Double oilWeightT, String oilTankStructure, String conservatorSealingMode, String equipmentId,
			Double continuWorkOvercurrentMulti, Date registrationTime, String remark, String stationLineName,
			String accountCreationMethod, String voltageClassName, String combinedApparSwitchgearName,
			String belongCombinApparSwitchgear, String equipmentManufacturer, String professionalClassification,
			String pmId, String functionalLocation, String belongStationVoltageLevel, String physicalId,
			String voltageClassCode, String dataSourceFile) {
		super();
		OElectricReactorId = oElectricReactorId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentName = equipmentName;
		this.associatFixedFireExtingSys = associatFixedFireExtingSys;
		this.operationNumber = operationNumber;
		this.powerStation = powerStation;
		this.spacerUnit = spacerUnit;
		this.localCity = localCity;
		this.operationMaintenanDepartment = operationMaintenanDepartment;
		this.maintenanceTeam = maintenanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.equipmentStatus = equipmentStatus;
		this.largeFeederLine = largeFeederLine;
		this.phaseNumber = phaseNumber;
		this.phaseName = phaseName;
		this.largeFeederBrnachLine = largeFeederBrnachLine;
		this.operationDate = operationDate;
		this.latestOperationDate = latestOperationDate;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.combinedEquipmentClass = combinedEquipmentClass;
		this.accessMode = accessMode;
		this.useEnvironment = useEnvironment;
		this.whetherAgentMaintenance = whetherAgentMaintenance;
		this.installationMode = installationMode;
		this.regionalCharacteristic = regionalCharacteristic;
		this.assetNature = assetNature;
		this.assetOrganization = assetOrganization;
		this.wbsId = wbsId;
		this.assetId = assetId;
		this.equipmentClassCode = equipmentClassCode;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.equipmentAdditionMethod = equipmentAdditionMethod;
		this.model = model;
		this.manufacturer = manufacturer;
		this.factoryNumber = factoryNumber;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.dateOfProduction = dateOfProduction;
		this.insulationClass = insulationClass;
		this.antifoulingGrade = antifoulingGrade;
		this.ratedVoltageKv = ratedVoltageKv;
		this.ratedCurrentA = ratedCurrentA;
		this.ratedFrequencyHz = ratedFrequencyHz;
		this.coolingMode = coolingMode;
		this.voltageRegulationMode = voltageRegulationMode;
		this.insulatingMedium = insulatingMedium;
		this.magneticConductionStructure = magneticConductionStructure;
		this.ratedCapacityKvar = ratedCapacityKvar;
		this.ratedReactanceOmega = ratedReactanceOmega;
		this.ratedReactanceRate = ratedReactanceRate;
		this.ratedInductanceMh = ratedInductanceMh;
		this.totalWeightT = totalWeightT;
		this.oilNumber = oilNumber;
		this.oilProducingArea = oilProducingArea;
		this.ratedLossKw = ratedLossKw;
		this.percentImpedancePercent = percentImpedancePercent;
		this.ratedSTimeWithstandCurrKa = ratedSTimeWithstandCurrKa;
		this.ratedPeakWithstandCurrKa = ratedPeakWithstandCurrKa;
		this.ratedShortCircuitDuratMs = ratedShortCircuitDuratMs;
		this.insulationLevel = insulationLevel;
		this.bodyWeightT = bodyWeightT;
		this.insulationLevelNeutralPoint = insulationLevelNeutralPoint;
		this.zeroSequenceReactanceOmega = zeroSequenceReactanceOmega;
		this.continuWorkOvervoltageMulti = continuWorkOvervoltageMulti;
		this.oilWeightT = oilWeightT;
		this.oilTankStructure = oilTankStructure;
		this.conservatorSealingMode = conservatorSealingMode;
		this.equipmentId = equipmentId;
		this.continuWorkOvercurrentMulti = continuWorkOvercurrentMulti;
		this.registrationTime = registrationTime;
		this.remark = remark;
		this.stationLineName = stationLineName;
		this.accountCreationMethod = accountCreationMethod;
		this.voltageClassName = voltageClassName;
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
		this.belongCombinApparSwitchgear = belongCombinApparSwitchgear;
		this.equipmentManufacturer = equipmentManufacturer;
		this.professionalClassification = professionalClassification;
		this.pmId = pmId;
		this.functionalLocation = functionalLocation;
		this.belongStationVoltageLevel = belongStationVoltageLevel;
		this.physicalId = physicalId;
		this.voltageClassCode = voltageClassCode;
		this.dataSourceFile = dataSourceFile;
	}

	public String getOElectricReactorId() {
		return this.OElectricReactorId;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOElectricReactorId(String OElectricReactorId) {
		this.OElectricReactorId = OElectricReactorId;
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

	public String getAssociatFixedFireExtingSys() {
		return this.associatFixedFireExtingSys;
	}

	public void setAssociatFixedFireExtingSys(String associatFixedFireExtingSys) {
		this.associatFixedFireExtingSys = associatFixedFireExtingSys;
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

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getLargeFeederLine() {
		return this.largeFeederLine;
	}

	public void setLargeFeederLine(String largeFeederLine) {
		this.largeFeederLine = largeFeederLine;
	}

	public String getPhaseNumber() {
		return this.phaseNumber;
	}

	public void setPhaseNumber(String phaseNumber) {
		this.phaseNumber = phaseNumber;
	}

	public String getPhaseName() {
		return this.phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public String getLargeFeederBrnachLine() {
		return this.largeFeederBrnachLine;
	}

	public void setLargeFeederBrnachLine(String largeFeederBrnachLine) {
		this.largeFeederBrnachLine = largeFeederBrnachLine;
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

	public String getWhetherRuralPowerNetwork() {
		return this.whetherRuralPowerNetwork;
	}

	public void setWhetherRuralPowerNetwork(String whetherRuralPowerNetwork) {
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
	}

	public String getCombinedEquipmentClass() {
		return this.combinedEquipmentClass;
	}

	public void setCombinedEquipmentClass(String combinedEquipmentClass) {
		this.combinedEquipmentClass = combinedEquipmentClass;
	}

	public String getAccessMode() {
		return this.accessMode;
	}

	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	public String getUseEnvironment() {
		return this.useEnvironment;
	}

	public void setUseEnvironment(String useEnvironment) {
		this.useEnvironment = useEnvironment;
	}

	public String getWhetherAgentMaintenance() {
		return this.whetherAgentMaintenance;
	}

	public void setWhetherAgentMaintenance(String whetherAgentMaintenance) {
		this.whetherAgentMaintenance = whetherAgentMaintenance;
	}

	public String getInstallationMode() {
		return this.installationMode;
	}

	public void setInstallationMode(String installationMode) {
		this.installationMode = installationMode;
	}

	public String getRegionalCharacteristic() {
		return this.regionalCharacteristic;
	}

	public void setRegionalCharacteristic(String regionalCharacteristic) {
		this.regionalCharacteristic = regionalCharacteristic;
	}

	public String getAssetNature() {
		return this.assetNature;
	}

	public void setAssetNature(String assetNature) {
		this.assetNature = assetNature;
	}

	public String getAssetOrganization() {
		return this.assetOrganization;
	}

	public void setAssetOrganization(String assetOrganization) {
		this.assetOrganization = assetOrganization;
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

	public String getEquipmentClassCode() {
		return this.equipmentClassCode;
	}

	public void setEquipmentClassCode(String equipmentClassCode) {
		this.equipmentClassCode = equipmentClassCode;
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public Date getDateOfProduction() {
		return this.dateOfProduction;
	}

	public void setDateOfProduction(Date dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}

	public String getInsulationClass() {
		return this.insulationClass;
	}

	public void setInsulationClass(String insulationClass) {
		this.insulationClass = insulationClass;
	}

	public String getAntifoulingGrade() {
		return this.antifoulingGrade;
	}

	public void setAntifoulingGrade(String antifoulingGrade) {
		this.antifoulingGrade = antifoulingGrade;
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

	public String getCoolingMode() {
		return this.coolingMode;
	}

	public void setCoolingMode(String coolingMode) {
		this.coolingMode = coolingMode;
	}

	public String getVoltageRegulationMode() {
		return this.voltageRegulationMode;
	}

	public void setVoltageRegulationMode(String voltageRegulationMode) {
		this.voltageRegulationMode = voltageRegulationMode;
	}

	public String getInsulatingMedium() {
		return this.insulatingMedium;
	}

	public void setInsulatingMedium(String insulatingMedium) {
		this.insulatingMedium = insulatingMedium;
	}

	public String getMagneticConductionStructure() {
		return this.magneticConductionStructure;
	}

	public void setMagneticConductionStructure(String magneticConductionStructure) {
		this.magneticConductionStructure = magneticConductionStructure;
	}

	public Double getRatedCapacityKvar() {
		return this.ratedCapacityKvar;
	}

	public void setRatedCapacityKvar(Double ratedCapacityKvar) {
		this.ratedCapacityKvar = ratedCapacityKvar;
	}

	public Double getRatedReactanceOmega() {
		return this.ratedReactanceOmega;
	}

	public void setRatedReactanceOmega(Double ratedReactanceOmega) {
		this.ratedReactanceOmega = ratedReactanceOmega;
	}

	public Double getRatedReactanceRate() {
		return this.ratedReactanceRate;
	}

	public void setRatedReactanceRate(Double ratedReactanceRate) {
		this.ratedReactanceRate = ratedReactanceRate;
	}

	public Double getRatedInductanceMh() {
		return this.ratedInductanceMh;
	}

	public void setRatedInductanceMh(Double ratedInductanceMh) {
		this.ratedInductanceMh = ratedInductanceMh;
	}

	public Double getTotalWeightT() {
		return this.totalWeightT;
	}

	public void setTotalWeightT(Double totalWeightT) {
		this.totalWeightT = totalWeightT;
	}

	public String getOilNumber() {
		return this.oilNumber;
	}

	public void setOilNumber(String oilNumber) {
		this.oilNumber = oilNumber;
	}

	public String getOilProducingArea() {
		return this.oilProducingArea;
	}

	public void setOilProducingArea(String oilProducingArea) {
		this.oilProducingArea = oilProducingArea;
	}

	public Double getRatedLossKw() {
		return this.ratedLossKw;
	}

	public void setRatedLossKw(Double ratedLossKw) {
		this.ratedLossKw = ratedLossKw;
	}

	public Double getPercentImpedancePercent() {
		return this.percentImpedancePercent;
	}

	public void setPercentImpedancePercent(Double percentImpedancePercent) {
		this.percentImpedancePercent = percentImpedancePercent;
	}

	public Double getRatedSTimeWithstandCurrKa() {
		return this.ratedSTimeWithstandCurrKa;
	}

	public void setRatedSTimeWithstandCurrKa(Double ratedSTimeWithstandCurrKa) {
		this.ratedSTimeWithstandCurrKa = ratedSTimeWithstandCurrKa;
	}

	public Double getRatedPeakWithstandCurrKa() {
		return this.ratedPeakWithstandCurrKa;
	}

	public void setRatedPeakWithstandCurrKa(Double ratedPeakWithstandCurrKa) {
		this.ratedPeakWithstandCurrKa = ratedPeakWithstandCurrKa;
	}

	public Double getRatedShortCircuitDuratMs() {
		return this.ratedShortCircuitDuratMs;
	}

	public void setRatedShortCircuitDuratMs(Double ratedShortCircuitDuratMs) {
		this.ratedShortCircuitDuratMs = ratedShortCircuitDuratMs;
	}

	public String getInsulationLevel() {
		return this.insulationLevel;
	}

	public void setInsulationLevel(String insulationLevel) {
		this.insulationLevel = insulationLevel;
	}

	public Double getBodyWeightT() {
		return this.bodyWeightT;
	}

	public void setBodyWeightT(Double bodyWeightT) {
		this.bodyWeightT = bodyWeightT;
	}

	public String getInsulationLevelNeutralPoint() {
		return this.insulationLevelNeutralPoint;
	}

	public void setInsulationLevelNeutralPoint(String insulationLevelNeutralPoint) {
		this.insulationLevelNeutralPoint = insulationLevelNeutralPoint;
	}

	public Double getZeroSequenceReactanceOmega() {
		return this.zeroSequenceReactanceOmega;
	}

	public void setZeroSequenceReactanceOmega(Double zeroSequenceReactanceOmega) {
		this.zeroSequenceReactanceOmega = zeroSequenceReactanceOmega;
	}

	public Double getContinuWorkOvervoltageMulti() {
		return this.continuWorkOvervoltageMulti;
	}

	public void setContinuWorkOvervoltageMulti(Double continuWorkOvervoltageMulti) {
		this.continuWorkOvervoltageMulti = continuWorkOvervoltageMulti;
	}

	public Double getOilWeightT() {
		return this.oilWeightT;
	}

	public void setOilWeightT(Double oilWeightT) {
		this.oilWeightT = oilWeightT;
	}

	public String getOilTankStructure() {
		return this.oilTankStructure;
	}

	public void setOilTankStructure(String oilTankStructure) {
		this.oilTankStructure = oilTankStructure;
	}

	public String getConservatorSealingMode() {
		return this.conservatorSealingMode;
	}

	public void setConservatorSealingMode(String conservatorSealingMode) {
		this.conservatorSealingMode = conservatorSealingMode;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Double getContinuWorkOvercurrentMulti() {
		return this.continuWorkOvercurrentMulti;
	}

	public void setContinuWorkOvercurrentMulti(Double continuWorkOvercurrentMulti) {
		this.continuWorkOvercurrentMulti = continuWorkOvercurrentMulti;
	}

	public Date getRegistrationTime() {
		return this.registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStationLineName() {
		return this.stationLineName;
	}

	public void setStationLineName(String stationLineName) {
		this.stationLineName = stationLineName;
	}

	public String getAccountCreationMethod() {
		return this.accountCreationMethod;
	}

	public void setAccountCreationMethod(String accountCreationMethod) {
		this.accountCreationMethod = accountCreationMethod;
	}

	public String getVoltageClassName() {
		return this.voltageClassName;
	}

	public void setVoltageClassName(String voltageClassName) {
		this.voltageClassName = voltageClassName;
	}

	public String getCombinedApparSwitchgearName() {
		return this.combinedApparSwitchgearName;
	}

	public void setCombinedApparSwitchgearName(String combinedApparSwitchgearName) {
		this.combinedApparSwitchgearName = combinedApparSwitchgearName;
	}

	public String getBelongCombinApparSwitchgear() {
		return this.belongCombinApparSwitchgear;
	}

	public void setBelongCombinApparSwitchgear(String belongCombinApparSwitchgear) {
		this.belongCombinApparSwitchgear = belongCombinApparSwitchgear;
	}

	public String getEquipmentManufacturer() {
		return this.equipmentManufacturer;
	}

	public void setEquipmentManufacturer(String equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
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

	public String getBelongStationVoltageLevel() {
		return this.belongStationVoltageLevel;
	}

	public void setBelongStationVoltageLevel(String belongStationVoltageLevel) {
		this.belongStationVoltageLevel = belongStationVoltageLevel;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setPhysicalId(String physicalId) {
		this.physicalId = physicalId;
	}

	public String getVoltageClassCode() {
		return this.voltageClassCode;
	}

	public void setVoltageClassCode(String voltageClassCode) {
		this.voltageClassCode = voltageClassCode;
	}

}