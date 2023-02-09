package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriPmsTransformer entity provides the base persistence definition of
 * the OriPmsTransformer entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriPmsTransformer implements java.io.Serializable {

	// Fields

	private String oriPmsTransformerId;
	private String equipmentName;
	private String workingCode;
	private String subordinateSubstationName;
	private Date commissioningDate;
	private String assetOrgName;
	private String wbsId;
	private String modelNumber;
	private String manufacturer;
	private String factoryNumber;
	private Date productionDate;
	private String equipmentId;
	private String equipmentTypeCode;
	private String spaceingUnit;
	private String orgName;
	private String maintainanceOrgName;
	private String maintainanceTeam;
	private String equipmentOwner;
	private String voltageLevel;
	private String equipmentStatus;
	private String phaseNumber;
	private String phaseType;
	private Date recentCommissioningDate;
	private String whetherRuralPowerNetwork;
	private String purpose;
	private String workingEnvironment;
	private String installationLocation;
	private String assetProperty;
	private String assetId;
	private String engineeringId;
	private String engineeringName;
	private String equipmentIncreaseMode;
	private String productCode;
	private String manufacturingCountry;
	private String ratedVoltage;
	private String ratedVoltageUnit;
	private Double ratedCurrent;
	private String ratedCurrentUnit;
	private Double ratedFrequency;
	private String ratedFrequencyUnit;
	private String insulateHeatResistanceGrade;
	private String antifoulingGrade;
	private String insulatingMedium;
	private String windingType;
	private String structuralStyle;
	private String coolingMode;
	private String voltageRegulationMode;
	private String connectionGroupLabel;
	private Double ratedCapacity;
	private String ratedCapacityUnit;
	private Double selfCoolingCapacityPercent;
	private String voltageRatio;
	private String ratedMediumVoltage;
	private String ratedMediumVoltageUnit;
	private String ratedLowVoltage;
	private String ratedLowVoltageUnit;
	private Double mvRatedCurrent;
	private String mvRatedCurrentUnit;
	private Double lvRatedCurrent;
	private String lvRatedCurrentUnit;
	private Double highLowVoltageLoadLoss;
	private String highLowVoltLoadLossUnit;
	private Double highMediumVoltageLoadLoss;
	private String highMedVoltLoadLossUnit;
	private Double mediumLowVoltLoadLoss;
	private String medLowVoltLoadLossUnit;
	private Double hvMvShortCircuitImpedanc;
	private Double hvLvShortCircuitImpedance;
	private Double mvLvShortCircuitImpedance;
	private Double noLoadCurrentRatio;
	private Double noLoadLoss;
	private String noLoadLossUnit;
	private Double fullLoadLoss;
	private String fullLoadLossUnit;
	private Double totalWeight;
	private String totalWeightUnit;
	private String oilNumber;
	private Double oilWeight;
	private String oilWeightUnit;
	private String oilProductionArea;
	private Double ratedSf6GasPressure;
	private String ratedSf6GasPressureUnit;
	private Double sf6GasAlarmPressure;
	private String sf6GasAlarmPressureUnit;
	private Double bodyWeight;
	private String bodyWeightUnit;
	private Double transportationWeight;
	private String transportationWeightUnit;
	private String isulationLevel;
	private String isulationLevelNeutralPoint;
	private Double forcedAirCoolingNoiseHp;
	private String forcedAirCoolNoiseHpUnit;
	private Double oilPillowCapacity;
	private String oilPillowCapacityUnit;
	private String oilPillowSealingMethod;
	private String whetherExistThermalSiphon;
	private Double upperFuelTankWeight;
	private String upperFuelTankWeightUnit;
	private String oilGasTankStructure;
	private String sf6Manufacturer;
	private Double sf6GasWeight;
	private String sf6GasWeightUnit;
	private Double sf6AirOntologyWeight;
	private String sf6AirOntologyWeightUnit;
	private Double sf6AirCableStorageWeight;
	private String sf6AirCableStorWeightUnit;
	private Double sf6AirOnLoadSwitchWeight;
	private String sf6OnLoadSwitchWeightUnit;
	private Double sf6AirOntologyPressure;
	private String sf6AirOntologyPressureUnit;
	private Double sf6AirCableStoragePressure;
	private String sf6CableStorPressureUnit;
	private Double sf6OnLoadSwitchPressure;
	private String sf6OnLoadSwitchPressuUnit;
	private Double coolingWaterWeight;
	private String coolingWaterWeightUnit;
	private Double cumulativeFilingNumber;
	private Double upLayerOilTemperatureLimit;
	private String upLayerOilTemperLimitUnit;
	private Double windingTemperatureLimit;
	private String windingTemperatureLimitUnit;
	private String neutralPoingGroundingMode;
	private Double highVoltageSideTapGear;
	private Double mediumVoltageSideTapGear;
	private Double lowVoltageSideTapGear;
	private Double mvSideCapacity;
	private String mvSideCapacityUnit;
	private Double lvSideCapacity;
	private String lvSideCapacityUnit;
	private Double hvSideZeroSequenceResister;
	private String hvSideZeroSeqResisterUnit;
	private Double hvSideZeroSeqReactance;
	private String hvSideZerSeqReactanceUnit;
	private Double mvSideZeroSequenceResister;
	private String mvSideZeroSeqResisterUnit;
	private Double mvSideZeroSeqReactance;
	private String mvSideZerSeqReactanceUnit;
	private Double lvSideZeroSequenceResister;
	private String lvSideZeroSeqResisterUnit;
	private Double lvSideZeroSeqReactance;
	private String lvSideZerSeqReactanceUnit;
	private String dispatchingJurisdiction;
	private String dispatchingOperationRight;
	private String dispatchingPermission;
	private String dispatchingMonitRight;
	private Date registrationDate;
	private String remark;
	private String powerSysNameplateRunlibId;
	private String objectId;
	private String voltageLevelCode;
	private String capacityRatio;
	private String substationVoltageLevel;
	private String voltageLevelName;
	private String professionalClassification;
	private String stationId;
	private String functionLocation;
	private String pmId;

	// Constructors

	/** default constructor */
	public AbstractOriPmsTransformer() {
	}

	/** full constructor */
	public AbstractOriPmsTransformer(String equipmentName, String workingCode, String subordinateSubstationName,
			Date commissioningDate, String assetOrgName, String wbsId, String modelNumber, String manufacturer,
			String factoryNumber, Date productionDate, String equipmentId, String equipmentTypeCode,
			String spaceingUnit, String orgName, String maintainanceOrgName, String maintainanceTeam,
			String equipmentOwner, String voltageLevel, String equipmentStatus, String phaseNumber, String phaseType,
			Date recentCommissioningDate, String whetherRuralPowerNetwork, String purpose, String workingEnvironment,
			String installationLocation, String assetProperty, String assetId, String engineeringId,
			String engineeringName, String equipmentIncreaseMode, String productCode, String manufacturingCountry,
			String ratedVoltage, String ratedVoltageUnit, Double ratedCurrent, String ratedCurrentUnit,
			Double ratedFrequency, String ratedFrequencyUnit, String insulateHeatResistanceGrade,
			String antifoulingGrade, String insulatingMedium, String windingType, String structuralStyle,
			String coolingMode, String voltageRegulationMode, String connectionGroupLabel, Double ratedCapacity,
			String ratedCapacityUnit, Double selfCoolingCapacityPercent, String voltageRatio, String ratedMediumVoltage,
			String ratedMediumVoltageUnit, String ratedLowVoltage, String ratedLowVoltageUnit, Double mvRatedCurrent,
			String mvRatedCurrentUnit, Double lvRatedCurrent, String lvRatedCurrentUnit, Double highLowVoltageLoadLoss,
			String highLowVoltLoadLossUnit, Double highMediumVoltageLoadLoss, String highMedVoltLoadLossUnit,
			Double mediumLowVoltLoadLoss, String medLowVoltLoadLossUnit, Double hvMvShortCircuitImpedanc,
			Double hvLvShortCircuitImpedance, Double mvLvShortCircuitImpedance, Double noLoadCurrentRatio,
			Double noLoadLoss, String noLoadLossUnit, Double fullLoadLoss, String fullLoadLossUnit, Double totalWeight,
			String totalWeightUnit, String oilNumber, Double oilWeight, String oilWeightUnit, String oilProductionArea,
			Double ratedSf6GasPressure, String ratedSf6GasPressureUnit, Double sf6GasAlarmPressure,
			String sf6GasAlarmPressureUnit, Double bodyWeight, String bodyWeightUnit, Double transportationWeight,
			String transportationWeightUnit, String isulationLevel, String isulationLevelNeutralPoint,
			Double forcedAirCoolingNoiseHp, String forcedAirCoolNoiseHpUnit, Double oilPillowCapacity,
			String oilPillowCapacityUnit, String oilPillowSealingMethod, String whetherExistThermalSiphon,
			Double upperFuelTankWeight, String upperFuelTankWeightUnit, String oilGasTankStructure,
			String sf6Manufacturer, Double sf6GasWeight, String sf6GasWeightUnit, Double sf6AirOntologyWeight,
			String sf6AirOntologyWeightUnit, Double sf6AirCableStorageWeight, String sf6AirCableStorWeightUnit,
			Double sf6AirOnLoadSwitchWeight, String sf6OnLoadSwitchWeightUnit, Double sf6AirOntologyPressure,
			String sf6AirOntologyPressureUnit, Double sf6AirCableStoragePressure, String sf6CableStorPressureUnit,
			Double sf6OnLoadSwitchPressure, String sf6OnLoadSwitchPressuUnit, Double coolingWaterWeight,
			String coolingWaterWeightUnit, Double cumulativeFilingNumber, Double upLayerOilTemperatureLimit,
			String upLayerOilTemperLimitUnit, Double windingTemperatureLimit, String windingTemperatureLimitUnit,
			String neutralPoingGroundingMode, Double highVoltageSideTapGear, Double mediumVoltageSideTapGear,
			Double lowVoltageSideTapGear, Double mvSideCapacity, String mvSideCapacityUnit, Double lvSideCapacity,
			String lvSideCapacityUnit, Double hvSideZeroSequenceResister, String hvSideZeroSeqResisterUnit,
			Double hvSideZeroSeqReactance, String hvSideZerSeqReactanceUnit, Double mvSideZeroSequenceResister,
			String mvSideZeroSeqResisterUnit, Double mvSideZeroSeqReactance, String mvSideZerSeqReactanceUnit,
			Double lvSideZeroSequenceResister, String lvSideZeroSeqResisterUnit, Double lvSideZeroSeqReactance,
			String lvSideZerSeqReactanceUnit, String dispatchingJurisdiction, String dispatchingOperationRight,
			String dispatchingPermission, String dispatchingMonitRight, Date registrationDate, String remark,
			String powerSysNameplateRunlibId, String objectId, String voltageLevelCode, String capacityRatio,
			String substationVoltageLevel, String voltageLevelName, String professionalClassification, String stationId,
			String functionLocation, String pmId) {
		this.equipmentName = equipmentName;
		this.workingCode = workingCode;
		this.subordinateSubstationName = subordinateSubstationName;
		this.commissioningDate = commissioningDate;
		this.assetOrgName = assetOrgName;
		this.wbsId = wbsId;
		this.modelNumber = modelNumber;
		this.manufacturer = manufacturer;
		this.factoryNumber = factoryNumber;
		this.productionDate = productionDate;
		this.equipmentId = equipmentId;
		this.equipmentTypeCode = equipmentTypeCode;
		this.spaceingUnit = spaceingUnit;
		this.orgName = orgName;
		this.maintainanceOrgName = maintainanceOrgName;
		this.maintainanceTeam = maintainanceTeam;
		this.equipmentOwner = equipmentOwner;
		this.voltageLevel = voltageLevel;
		this.equipmentStatus = equipmentStatus;
		this.phaseNumber = phaseNumber;
		this.phaseType = phaseType;
		this.recentCommissioningDate = recentCommissioningDate;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.purpose = purpose;
		this.workingEnvironment = workingEnvironment;
		this.installationLocation = installationLocation;
		this.assetProperty = assetProperty;
		this.assetId = assetId;
		this.engineeringId = engineeringId;
		this.engineeringName = engineeringName;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.productCode = productCode;
		this.manufacturingCountry = manufacturingCountry;
		this.ratedVoltage = ratedVoltage;
		this.ratedVoltageUnit = ratedVoltageUnit;
		this.ratedCurrent = ratedCurrent;
		this.ratedCurrentUnit = ratedCurrentUnit;
		this.ratedFrequency = ratedFrequency;
		this.ratedFrequencyUnit = ratedFrequencyUnit;
		this.insulateHeatResistanceGrade = insulateHeatResistanceGrade;
		this.antifoulingGrade = antifoulingGrade;
		this.insulatingMedium = insulatingMedium;
		this.windingType = windingType;
		this.structuralStyle = structuralStyle;
		this.coolingMode = coolingMode;
		this.voltageRegulationMode = voltageRegulationMode;
		this.connectionGroupLabel = connectionGroupLabel;
		this.ratedCapacity = ratedCapacity;
		this.ratedCapacityUnit = ratedCapacityUnit;
		this.selfCoolingCapacityPercent = selfCoolingCapacityPercent;
		this.voltageRatio = voltageRatio;
		this.ratedMediumVoltage = ratedMediumVoltage;
		this.ratedMediumVoltageUnit = ratedMediumVoltageUnit;
		this.ratedLowVoltage = ratedLowVoltage;
		this.ratedLowVoltageUnit = ratedLowVoltageUnit;
		this.mvRatedCurrent = mvRatedCurrent;
		this.mvRatedCurrentUnit = mvRatedCurrentUnit;
		this.lvRatedCurrent = lvRatedCurrent;
		this.lvRatedCurrentUnit = lvRatedCurrentUnit;
		this.highLowVoltageLoadLoss = highLowVoltageLoadLoss;
		this.highLowVoltLoadLossUnit = highLowVoltLoadLossUnit;
		this.highMediumVoltageLoadLoss = highMediumVoltageLoadLoss;
		this.highMedVoltLoadLossUnit = highMedVoltLoadLossUnit;
		this.mediumLowVoltLoadLoss = mediumLowVoltLoadLoss;
		this.medLowVoltLoadLossUnit = medLowVoltLoadLossUnit;
		this.hvMvShortCircuitImpedanc = hvMvShortCircuitImpedanc;
		this.hvLvShortCircuitImpedance = hvLvShortCircuitImpedance;
		this.mvLvShortCircuitImpedance = mvLvShortCircuitImpedance;
		this.noLoadCurrentRatio = noLoadCurrentRatio;
		this.noLoadLoss = noLoadLoss;
		this.noLoadLossUnit = noLoadLossUnit;
		this.fullLoadLoss = fullLoadLoss;
		this.fullLoadLossUnit = fullLoadLossUnit;
		this.totalWeight = totalWeight;
		this.totalWeightUnit = totalWeightUnit;
		this.oilNumber = oilNumber;
		this.oilWeight = oilWeight;
		this.oilWeightUnit = oilWeightUnit;
		this.oilProductionArea = oilProductionArea;
		this.ratedSf6GasPressure = ratedSf6GasPressure;
		this.ratedSf6GasPressureUnit = ratedSf6GasPressureUnit;
		this.sf6GasAlarmPressure = sf6GasAlarmPressure;
		this.sf6GasAlarmPressureUnit = sf6GasAlarmPressureUnit;
		this.bodyWeight = bodyWeight;
		this.bodyWeightUnit = bodyWeightUnit;
		this.transportationWeight = transportationWeight;
		this.transportationWeightUnit = transportationWeightUnit;
		this.isulationLevel = isulationLevel;
		this.isulationLevelNeutralPoint = isulationLevelNeutralPoint;
		this.forcedAirCoolingNoiseHp = forcedAirCoolingNoiseHp;
		this.forcedAirCoolNoiseHpUnit = forcedAirCoolNoiseHpUnit;
		this.oilPillowCapacity = oilPillowCapacity;
		this.oilPillowCapacityUnit = oilPillowCapacityUnit;
		this.oilPillowSealingMethod = oilPillowSealingMethod;
		this.whetherExistThermalSiphon = whetherExistThermalSiphon;
		this.upperFuelTankWeight = upperFuelTankWeight;
		this.upperFuelTankWeightUnit = upperFuelTankWeightUnit;
		this.oilGasTankStructure = oilGasTankStructure;
		this.sf6Manufacturer = sf6Manufacturer;
		this.sf6GasWeight = sf6GasWeight;
		this.sf6GasWeightUnit = sf6GasWeightUnit;
		this.sf6AirOntologyWeight = sf6AirOntologyWeight;
		this.sf6AirOntologyWeightUnit = sf6AirOntologyWeightUnit;
		this.sf6AirCableStorageWeight = sf6AirCableStorageWeight;
		this.sf6AirCableStorWeightUnit = sf6AirCableStorWeightUnit;
		this.sf6AirOnLoadSwitchWeight = sf6AirOnLoadSwitchWeight;
		this.sf6OnLoadSwitchWeightUnit = sf6OnLoadSwitchWeightUnit;
		this.sf6AirOntologyPressure = sf6AirOntologyPressure;
		this.sf6AirOntologyPressureUnit = sf6AirOntologyPressureUnit;
		this.sf6AirCableStoragePressure = sf6AirCableStoragePressure;
		this.sf6CableStorPressureUnit = sf6CableStorPressureUnit;
		this.sf6OnLoadSwitchPressure = sf6OnLoadSwitchPressure;
		this.sf6OnLoadSwitchPressuUnit = sf6OnLoadSwitchPressuUnit;
		this.coolingWaterWeight = coolingWaterWeight;
		this.coolingWaterWeightUnit = coolingWaterWeightUnit;
		this.cumulativeFilingNumber = cumulativeFilingNumber;
		this.upLayerOilTemperatureLimit = upLayerOilTemperatureLimit;
		this.upLayerOilTemperLimitUnit = upLayerOilTemperLimitUnit;
		this.windingTemperatureLimit = windingTemperatureLimit;
		this.windingTemperatureLimitUnit = windingTemperatureLimitUnit;
		this.neutralPoingGroundingMode = neutralPoingGroundingMode;
		this.highVoltageSideTapGear = highVoltageSideTapGear;
		this.mediumVoltageSideTapGear = mediumVoltageSideTapGear;
		this.lowVoltageSideTapGear = lowVoltageSideTapGear;
		this.mvSideCapacity = mvSideCapacity;
		this.mvSideCapacityUnit = mvSideCapacityUnit;
		this.lvSideCapacity = lvSideCapacity;
		this.lvSideCapacityUnit = lvSideCapacityUnit;
		this.hvSideZeroSequenceResister = hvSideZeroSequenceResister;
		this.hvSideZeroSeqResisterUnit = hvSideZeroSeqResisterUnit;
		this.hvSideZeroSeqReactance = hvSideZeroSeqReactance;
		this.hvSideZerSeqReactanceUnit = hvSideZerSeqReactanceUnit;
		this.mvSideZeroSequenceResister = mvSideZeroSequenceResister;
		this.mvSideZeroSeqResisterUnit = mvSideZeroSeqResisterUnit;
		this.mvSideZeroSeqReactance = mvSideZeroSeqReactance;
		this.mvSideZerSeqReactanceUnit = mvSideZerSeqReactanceUnit;
		this.lvSideZeroSequenceResister = lvSideZeroSequenceResister;
		this.lvSideZeroSeqResisterUnit = lvSideZeroSeqResisterUnit;
		this.lvSideZeroSeqReactance = lvSideZeroSeqReactance;
		this.lvSideZerSeqReactanceUnit = lvSideZerSeqReactanceUnit;
		this.dispatchingJurisdiction = dispatchingJurisdiction;
		this.dispatchingOperationRight = dispatchingOperationRight;
		this.dispatchingPermission = dispatchingPermission;
		this.dispatchingMonitRight = dispatchingMonitRight;
		this.registrationDate = registrationDate;
		this.remark = remark;
		this.powerSysNameplateRunlibId = powerSysNameplateRunlibId;
		this.objectId = objectId;
		this.voltageLevelCode = voltageLevelCode;
		this.capacityRatio = capacityRatio;
		this.substationVoltageLevel = substationVoltageLevel;
		this.voltageLevelName = voltageLevelName;
		this.professionalClassification = professionalClassification;
		this.stationId = stationId;
		this.functionLocation = functionLocation;
		this.pmId = pmId;
	}

	// Property accessors

	public String getOriPmsTransformerId() {
		return this.oriPmsTransformerId;
	}

	public void setOriPmsTransformerId(String oriPmsTransformerId) {
		this.oriPmsTransformerId = oriPmsTransformerId;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getWorkingCode() {
		return this.workingCode;
	}

	public void setWorkingCode(String workingCode) {
		this.workingCode = workingCode;
	}

	public String getSubordinateSubstationName() {
		return this.subordinateSubstationName;
	}

	public void setSubordinateSubstationName(String subordinateSubstationName) {
		this.subordinateSubstationName = subordinateSubstationName;
	}

	public Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getAssetOrgName() {
		return this.assetOrgName;
	}

	public void setAssetOrgName(String assetOrgName) {
		this.assetOrgName = assetOrgName;
	}

	public String getWbsId() {
		return this.wbsId;
	}

	public void setWbsId(String wbsId) {
		this.wbsId = wbsId;
	}

	public String getModelNumber() {
		return this.modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
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

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentTypeCode() {
		return this.equipmentTypeCode;
	}

	public void setEquipmentTypeCode(String equipmentTypeCode) {
		this.equipmentTypeCode = equipmentTypeCode;
	}

	public String getSpaceingUnit() {
		return this.spaceingUnit;
	}

	public void setSpaceingUnit(String spaceingUnit) {
		this.spaceingUnit = spaceingUnit;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMaintainanceOrgName() {
		return this.maintainanceOrgName;
	}

	public void setMaintainanceOrgName(String maintainanceOrgName) {
		this.maintainanceOrgName = maintainanceOrgName;
	}

	public String getMaintainanceTeam() {
		return this.maintainanceTeam;
	}

	public void setMaintainanceTeam(String maintainanceTeam) {
		this.maintainanceTeam = maintainanceTeam;
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

	public String getPhaseNumber() {
		return this.phaseNumber;
	}

	public void setPhaseNumber(String phaseNumber) {
		this.phaseNumber = phaseNumber;
	}

	public String getPhaseType() {
		return this.phaseType;
	}

	public void setPhaseType(String phaseType) {
		this.phaseType = phaseType;
	}

	public Date getRecentCommissioningDate() {
		return this.recentCommissioningDate;
	}

	public void setRecentCommissioningDate(Date recentCommissioningDate) {
		this.recentCommissioningDate = recentCommissioningDate;
	}

	public String getWhetherRuralPowerNetwork() {
		return this.whetherRuralPowerNetwork;
	}

	public void setWhetherRuralPowerNetwork(String whetherRuralPowerNetwork) {
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getWorkingEnvironment() {
		return this.workingEnvironment;
	}

	public void setWorkingEnvironment(String workingEnvironment) {
		this.workingEnvironment = workingEnvironment;
	}

	public String getInstallationLocation() {
		return this.installationLocation;
	}

	public void setInstallationLocation(String installationLocation) {
		this.installationLocation = installationLocation;
	}

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getEngineeringId() {
		return this.engineeringId;
	}

	public void setEngineeringId(String engineeringId) {
		this.engineeringId = engineeringId;
	}

	public String getEngineeringName() {
		return this.engineeringName;
	}

	public void setEngineeringName(String engineeringName) {
		this.engineeringName = engineeringName;
	}

	public String getEquipmentIncreaseMode() {
		return this.equipmentIncreaseMode;
	}

	public void setEquipmentIncreaseMode(String equipmentIncreaseMode) {
		this.equipmentIncreaseMode = equipmentIncreaseMode;
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

	public String getRatedVoltage() {
		return this.ratedVoltage;
	}

	public void setRatedVoltage(String ratedVoltage) {
		this.ratedVoltage = ratedVoltage;
	}

	public String getRatedVoltageUnit() {
		return this.ratedVoltageUnit;
	}

	public void setRatedVoltageUnit(String ratedVoltageUnit) {
		this.ratedVoltageUnit = ratedVoltageUnit;
	}

	public Double getRatedCurrent() {
		return this.ratedCurrent;
	}

	public void setRatedCurrent(Double ratedCurrent) {
		this.ratedCurrent = ratedCurrent;
	}

	public String getRatedCurrentUnit() {
		return this.ratedCurrentUnit;
	}

	public void setRatedCurrentUnit(String ratedCurrentUnit) {
		this.ratedCurrentUnit = ratedCurrentUnit;
	}

	public Double getRatedFrequency() {
		return this.ratedFrequency;
	}

	public void setRatedFrequency(Double ratedFrequency) {
		this.ratedFrequency = ratedFrequency;
	}

	public String getRatedFrequencyUnit() {
		return this.ratedFrequencyUnit;
	}

	public void setRatedFrequencyUnit(String ratedFrequencyUnit) {
		this.ratedFrequencyUnit = ratedFrequencyUnit;
	}

	public String getInsulateHeatResistanceGrade() {
		return this.insulateHeatResistanceGrade;
	}

	public void setInsulateHeatResistanceGrade(String insulateHeatResistanceGrade) {
		this.insulateHeatResistanceGrade = insulateHeatResistanceGrade;
	}

	public String getAntifoulingGrade() {
		return this.antifoulingGrade;
	}

	public void setAntifoulingGrade(String antifoulingGrade) {
		this.antifoulingGrade = antifoulingGrade;
	}

	public String getInsulatingMedium() {
		return this.insulatingMedium;
	}

	public void setInsulatingMedium(String insulatingMedium) {
		this.insulatingMedium = insulatingMedium;
	}

	public String getWindingType() {
		return this.windingType;
	}

	public void setWindingType(String windingType) {
		this.windingType = windingType;
	}

	public String getStructuralStyle() {
		return this.structuralStyle;
	}

	public void setStructuralStyle(String structuralStyle) {
		this.structuralStyle = structuralStyle;
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

	public String getConnectionGroupLabel() {
		return this.connectionGroupLabel;
	}

	public void setConnectionGroupLabel(String connectionGroupLabel) {
		this.connectionGroupLabel = connectionGroupLabel;
	}

	public Double getRatedCapacity() {
		return this.ratedCapacity;
	}

	public void setRatedCapacity(Double ratedCapacity) {
		this.ratedCapacity = ratedCapacity;
	}

	public String getRatedCapacityUnit() {
		return this.ratedCapacityUnit;
	}

	public void setRatedCapacityUnit(String ratedCapacityUnit) {
		this.ratedCapacityUnit = ratedCapacityUnit;
	}

	public Double getSelfCoolingCapacityPercent() {
		return this.selfCoolingCapacityPercent;
	}

	public void setSelfCoolingCapacityPercent(Double selfCoolingCapacityPercent) {
		this.selfCoolingCapacityPercent = selfCoolingCapacityPercent;
	}

	public String getVoltageRatio() {
		return this.voltageRatio;
	}

	public void setVoltageRatio(String voltageRatio) {
		this.voltageRatio = voltageRatio;
	}

	public String getRatedMediumVoltage() {
		return this.ratedMediumVoltage;
	}

	public void setRatedMediumVoltage(String ratedMediumVoltage) {
		this.ratedMediumVoltage = ratedMediumVoltage;
	}

	public String getRatedMediumVoltageUnit() {
		return this.ratedMediumVoltageUnit;
	}

	public void setRatedMediumVoltageUnit(String ratedMediumVoltageUnit) {
		this.ratedMediumVoltageUnit = ratedMediumVoltageUnit;
	}

	public String getRatedLowVoltage() {
		return this.ratedLowVoltage;
	}

	public void setRatedLowVoltage(String ratedLowVoltage) {
		this.ratedLowVoltage = ratedLowVoltage;
	}

	public String getRatedLowVoltageUnit() {
		return this.ratedLowVoltageUnit;
	}

	public void setRatedLowVoltageUnit(String ratedLowVoltageUnit) {
		this.ratedLowVoltageUnit = ratedLowVoltageUnit;
	}

	public Double getMvRatedCurrent() {
		return this.mvRatedCurrent;
	}

	public void setMvRatedCurrent(Double mvRatedCurrent) {
		this.mvRatedCurrent = mvRatedCurrent;
	}

	public String getMvRatedCurrentUnit() {
		return this.mvRatedCurrentUnit;
	}

	public void setMvRatedCurrentUnit(String mvRatedCurrentUnit) {
		this.mvRatedCurrentUnit = mvRatedCurrentUnit;
	}

	public Double getLvRatedCurrent() {
		return this.lvRatedCurrent;
	}

	public void setLvRatedCurrent(Double lvRatedCurrent) {
		this.lvRatedCurrent = lvRatedCurrent;
	}

	public String getLvRatedCurrentUnit() {
		return this.lvRatedCurrentUnit;
	}

	public void setLvRatedCurrentUnit(String lvRatedCurrentUnit) {
		this.lvRatedCurrentUnit = lvRatedCurrentUnit;
	}

	public Double getHighLowVoltageLoadLoss() {
		return this.highLowVoltageLoadLoss;
	}

	public void setHighLowVoltageLoadLoss(Double highLowVoltageLoadLoss) {
		this.highLowVoltageLoadLoss = highLowVoltageLoadLoss;
	}

	public String getHighLowVoltLoadLossUnit() {
		return this.highLowVoltLoadLossUnit;
	}

	public void setHighLowVoltLoadLossUnit(String highLowVoltLoadLossUnit) {
		this.highLowVoltLoadLossUnit = highLowVoltLoadLossUnit;
	}

	public Double getHighMediumVoltageLoadLoss() {
		return this.highMediumVoltageLoadLoss;
	}

	public void setHighMediumVoltageLoadLoss(Double highMediumVoltageLoadLoss) {
		this.highMediumVoltageLoadLoss = highMediumVoltageLoadLoss;
	}

	public String getHighMedVoltLoadLossUnit() {
		return this.highMedVoltLoadLossUnit;
	}

	public void setHighMedVoltLoadLossUnit(String highMedVoltLoadLossUnit) {
		this.highMedVoltLoadLossUnit = highMedVoltLoadLossUnit;
	}

	public Double getMediumLowVoltLoadLoss() {
		return this.mediumLowVoltLoadLoss;
	}

	public void setMediumLowVoltLoadLoss(Double mediumLowVoltLoadLoss) {
		this.mediumLowVoltLoadLoss = mediumLowVoltLoadLoss;
	}

	public String getMedLowVoltLoadLossUnit() {
		return this.medLowVoltLoadLossUnit;
	}

	public void setMedLowVoltLoadLossUnit(String medLowVoltLoadLossUnit) {
		this.medLowVoltLoadLossUnit = medLowVoltLoadLossUnit;
	}

	public Double getHvMvShortCircuitImpedanc() {
		return this.hvMvShortCircuitImpedanc;
	}

	public void setHvMvShortCircuitImpedanc(Double hvMvShortCircuitImpedanc) {
		this.hvMvShortCircuitImpedanc = hvMvShortCircuitImpedanc;
	}

	public Double getHvLvShortCircuitImpedance() {
		return this.hvLvShortCircuitImpedance;
	}

	public void setHvLvShortCircuitImpedance(Double hvLvShortCircuitImpedance) {
		this.hvLvShortCircuitImpedance = hvLvShortCircuitImpedance;
	}

	public Double getMvLvShortCircuitImpedance() {
		return this.mvLvShortCircuitImpedance;
	}

	public void setMvLvShortCircuitImpedance(Double mvLvShortCircuitImpedance) {
		this.mvLvShortCircuitImpedance = mvLvShortCircuitImpedance;
	}

	public Double getNoLoadCurrentRatio() {
		return this.noLoadCurrentRatio;
	}

	public void setNoLoadCurrentRatio(Double noLoadCurrentRatio) {
		this.noLoadCurrentRatio = noLoadCurrentRatio;
	}

	public Double getNoLoadLoss() {
		return this.noLoadLoss;
	}

	public void setNoLoadLoss(Double noLoadLoss) {
		this.noLoadLoss = noLoadLoss;
	}

	public String getNoLoadLossUnit() {
		return this.noLoadLossUnit;
	}

	public void setNoLoadLossUnit(String noLoadLossUnit) {
		this.noLoadLossUnit = noLoadLossUnit;
	}

	public Double getFullLoadLoss() {
		return this.fullLoadLoss;
	}

	public void setFullLoadLoss(Double fullLoadLoss) {
		this.fullLoadLoss = fullLoadLoss;
	}

	public String getFullLoadLossUnit() {
		return this.fullLoadLossUnit;
	}

	public void setFullLoadLossUnit(String fullLoadLossUnit) {
		this.fullLoadLossUnit = fullLoadLossUnit;
	}

	public Double getTotalWeight() {
		return this.totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getTotalWeightUnit() {
		return this.totalWeightUnit;
	}

	public void setTotalWeightUnit(String totalWeightUnit) {
		this.totalWeightUnit = totalWeightUnit;
	}

	public String getOilNumber() {
		return this.oilNumber;
	}

	public void setOilNumber(String oilNumber) {
		this.oilNumber = oilNumber;
	}

	public Double getOilWeight() {
		return this.oilWeight;
	}

	public void setOilWeight(Double oilWeight) {
		this.oilWeight = oilWeight;
	}

	public String getOilWeightUnit() {
		return this.oilWeightUnit;
	}

	public void setOilWeightUnit(String oilWeightUnit) {
		this.oilWeightUnit = oilWeightUnit;
	}

	public String getOilProductionArea() {
		return this.oilProductionArea;
	}

	public void setOilProductionArea(String oilProductionArea) {
		this.oilProductionArea = oilProductionArea;
	}

	public Double getRatedSf6GasPressure() {
		return this.ratedSf6GasPressure;
	}

	public void setRatedSf6GasPressure(Double ratedSf6GasPressure) {
		this.ratedSf6GasPressure = ratedSf6GasPressure;
	}

	public String getRatedSf6GasPressureUnit() {
		return this.ratedSf6GasPressureUnit;
	}

	public void setRatedSf6GasPressureUnit(String ratedSf6GasPressureUnit) {
		this.ratedSf6GasPressureUnit = ratedSf6GasPressureUnit;
	}

	public Double getSf6GasAlarmPressure() {
		return this.sf6GasAlarmPressure;
	}

	public void setSf6GasAlarmPressure(Double sf6GasAlarmPressure) {
		this.sf6GasAlarmPressure = sf6GasAlarmPressure;
	}

	public String getSf6GasAlarmPressureUnit() {
		return this.sf6GasAlarmPressureUnit;
	}

	public void setSf6GasAlarmPressureUnit(String sf6GasAlarmPressureUnit) {
		this.sf6GasAlarmPressureUnit = sf6GasAlarmPressureUnit;
	}

	public Double getBodyWeight() {
		return this.bodyWeight;
	}

	public void setBodyWeight(Double bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public String getBodyWeightUnit() {
		return this.bodyWeightUnit;
	}

	public void setBodyWeightUnit(String bodyWeightUnit) {
		this.bodyWeightUnit = bodyWeightUnit;
	}

	public Double getTransportationWeight() {
		return this.transportationWeight;
	}

	public void setTransportationWeight(Double transportationWeight) {
		this.transportationWeight = transportationWeight;
	}

	public String getTransportationWeightUnit() {
		return this.transportationWeightUnit;
	}

	public void setTransportationWeightUnit(String transportationWeightUnit) {
		this.transportationWeightUnit = transportationWeightUnit;
	}

	public String getIsulationLevel() {
		return this.isulationLevel;
	}

	public void setIsulationLevel(String isulationLevel) {
		this.isulationLevel = isulationLevel;
	}

	public String getIsulationLevelNeutralPoint() {
		return this.isulationLevelNeutralPoint;
	}

	public void setIsulationLevelNeutralPoint(String isulationLevelNeutralPoint) {
		this.isulationLevelNeutralPoint = isulationLevelNeutralPoint;
	}

	public Double getForcedAirCoolingNoiseHp() {
		return this.forcedAirCoolingNoiseHp;
	}

	public void setForcedAirCoolingNoiseHp(Double forcedAirCoolingNoiseHp) {
		this.forcedAirCoolingNoiseHp = forcedAirCoolingNoiseHp;
	}

	public String getForcedAirCoolNoiseHpUnit() {
		return this.forcedAirCoolNoiseHpUnit;
	}

	public void setForcedAirCoolNoiseHpUnit(String forcedAirCoolNoiseHpUnit) {
		this.forcedAirCoolNoiseHpUnit = forcedAirCoolNoiseHpUnit;
	}

	public Double getOilPillowCapacity() {
		return this.oilPillowCapacity;
	}

	public void setOilPillowCapacity(Double oilPillowCapacity) {
		this.oilPillowCapacity = oilPillowCapacity;
	}

	public String getOilPillowCapacityUnit() {
		return this.oilPillowCapacityUnit;
	}

	public void setOilPillowCapacityUnit(String oilPillowCapacityUnit) {
		this.oilPillowCapacityUnit = oilPillowCapacityUnit;
	}

	public String getOilPillowSealingMethod() {
		return this.oilPillowSealingMethod;
	}

	public void setOilPillowSealingMethod(String oilPillowSealingMethod) {
		this.oilPillowSealingMethod = oilPillowSealingMethod;
	}

	public String getWhetherExistThermalSiphon() {
		return this.whetherExistThermalSiphon;
	}

	public void setWhetherExistThermalSiphon(String whetherExistThermalSiphon) {
		this.whetherExistThermalSiphon = whetherExistThermalSiphon;
	}

	public Double getUpperFuelTankWeight() {
		return this.upperFuelTankWeight;
	}

	public void setUpperFuelTankWeight(Double upperFuelTankWeight) {
		this.upperFuelTankWeight = upperFuelTankWeight;
	}

	public String getUpperFuelTankWeightUnit() {
		return this.upperFuelTankWeightUnit;
	}

	public void setUpperFuelTankWeightUnit(String upperFuelTankWeightUnit) {
		this.upperFuelTankWeightUnit = upperFuelTankWeightUnit;
	}

	public String getOilGasTankStructure() {
		return this.oilGasTankStructure;
	}

	public void setOilGasTankStructure(String oilGasTankStructure) {
		this.oilGasTankStructure = oilGasTankStructure;
	}

	public String getSf6Manufacturer() {
		return this.sf6Manufacturer;
	}

	public void setSf6Manufacturer(String sf6Manufacturer) {
		this.sf6Manufacturer = sf6Manufacturer;
	}

	public Double getSf6GasWeight() {
		return this.sf6GasWeight;
	}

	public void setSf6GasWeight(Double sf6GasWeight) {
		this.sf6GasWeight = sf6GasWeight;
	}

	public String getSf6GasWeightUnit() {
		return this.sf6GasWeightUnit;
	}

	public void setSf6GasWeightUnit(String sf6GasWeightUnit) {
		this.sf6GasWeightUnit = sf6GasWeightUnit;
	}

	public Double getSf6AirOntologyWeight() {
		return this.sf6AirOntologyWeight;
	}

	public void setSf6AirOntologyWeight(Double sf6AirOntologyWeight) {
		this.sf6AirOntologyWeight = sf6AirOntologyWeight;
	}

	public String getSf6AirOntologyWeightUnit() {
		return this.sf6AirOntologyWeightUnit;
	}

	public void setSf6AirOntologyWeightUnit(String sf6AirOntologyWeightUnit) {
		this.sf6AirOntologyWeightUnit = sf6AirOntologyWeightUnit;
	}

	public Double getSf6AirCableStorageWeight() {
		return this.sf6AirCableStorageWeight;
	}

	public void setSf6AirCableStorageWeight(Double sf6AirCableStorageWeight) {
		this.sf6AirCableStorageWeight = sf6AirCableStorageWeight;
	}

	public String getSf6AirCableStorWeightUnit() {
		return this.sf6AirCableStorWeightUnit;
	}

	public void setSf6AirCableStorWeightUnit(String sf6AirCableStorWeightUnit) {
		this.sf6AirCableStorWeightUnit = sf6AirCableStorWeightUnit;
	}

	public Double getSf6AirOnLoadSwitchWeight() {
		return this.sf6AirOnLoadSwitchWeight;
	}

	public void setSf6AirOnLoadSwitchWeight(Double sf6AirOnLoadSwitchWeight) {
		this.sf6AirOnLoadSwitchWeight = sf6AirOnLoadSwitchWeight;
	}

	public String getSf6OnLoadSwitchWeightUnit() {
		return this.sf6OnLoadSwitchWeightUnit;
	}

	public void setSf6OnLoadSwitchWeightUnit(String sf6OnLoadSwitchWeightUnit) {
		this.sf6OnLoadSwitchWeightUnit = sf6OnLoadSwitchWeightUnit;
	}

	public Double getSf6AirOntologyPressure() {
		return this.sf6AirOntologyPressure;
	}

	public void setSf6AirOntologyPressure(Double sf6AirOntologyPressure) {
		this.sf6AirOntologyPressure = sf6AirOntologyPressure;
	}

	public String getSf6AirOntologyPressureUnit() {
		return this.sf6AirOntologyPressureUnit;
	}

	public void setSf6AirOntologyPressureUnit(String sf6AirOntologyPressureUnit) {
		this.sf6AirOntologyPressureUnit = sf6AirOntologyPressureUnit;
	}

	public Double getSf6AirCableStoragePressure() {
		return this.sf6AirCableStoragePressure;
	}

	public void setSf6AirCableStoragePressure(Double sf6AirCableStoragePressure) {
		this.sf6AirCableStoragePressure = sf6AirCableStoragePressure;
	}

	public String getSf6CableStorPressureUnit() {
		return this.sf6CableStorPressureUnit;
	}

	public void setSf6CableStorPressureUnit(String sf6CableStorPressureUnit) {
		this.sf6CableStorPressureUnit = sf6CableStorPressureUnit;
	}

	public Double getSf6OnLoadSwitchPressure() {
		return this.sf6OnLoadSwitchPressure;
	}

	public void setSf6OnLoadSwitchPressure(Double sf6OnLoadSwitchPressure) {
		this.sf6OnLoadSwitchPressure = sf6OnLoadSwitchPressure;
	}

	public String getSf6OnLoadSwitchPressuUnit() {
		return this.sf6OnLoadSwitchPressuUnit;
	}

	public void setSf6OnLoadSwitchPressuUnit(String sf6OnLoadSwitchPressuUnit) {
		this.sf6OnLoadSwitchPressuUnit = sf6OnLoadSwitchPressuUnit;
	}

	public Double getCoolingWaterWeight() {
		return this.coolingWaterWeight;
	}

	public void setCoolingWaterWeight(Double coolingWaterWeight) {
		this.coolingWaterWeight = coolingWaterWeight;
	}

	public String getCoolingWaterWeightUnit() {
		return this.coolingWaterWeightUnit;
	}

	public void setCoolingWaterWeightUnit(String coolingWaterWeightUnit) {
		this.coolingWaterWeightUnit = coolingWaterWeightUnit;
	}

	public Double getCumulativeFilingNumber() {
		return this.cumulativeFilingNumber;
	}

	public void setCumulativeFilingNumber(Double cumulativeFilingNumber) {
		this.cumulativeFilingNumber = cumulativeFilingNumber;
	}

	public Double getUpLayerOilTemperatureLimit() {
		return this.upLayerOilTemperatureLimit;
	}

	public void setUpLayerOilTemperatureLimit(Double upLayerOilTemperatureLimit) {
		this.upLayerOilTemperatureLimit = upLayerOilTemperatureLimit;
	}

	public String getUpLayerOilTemperLimitUnit() {
		return this.upLayerOilTemperLimitUnit;
	}

	public void setUpLayerOilTemperLimitUnit(String upLayerOilTemperLimitUnit) {
		this.upLayerOilTemperLimitUnit = upLayerOilTemperLimitUnit;
	}

	public Double getWindingTemperatureLimit() {
		return this.windingTemperatureLimit;
	}

	public void setWindingTemperatureLimit(Double windingTemperatureLimit) {
		this.windingTemperatureLimit = windingTemperatureLimit;
	}

	public String getWindingTemperatureLimitUnit() {
		return this.windingTemperatureLimitUnit;
	}

	public void setWindingTemperatureLimitUnit(String windingTemperatureLimitUnit) {
		this.windingTemperatureLimitUnit = windingTemperatureLimitUnit;
	}

	public String getNeutralPoingGroundingMode() {
		return this.neutralPoingGroundingMode;
	}

	public void setNeutralPoingGroundingMode(String neutralPoingGroundingMode) {
		this.neutralPoingGroundingMode = neutralPoingGroundingMode;
	}

	public Double getHighVoltageSideTapGear() {
		return this.highVoltageSideTapGear;
	}

	public void setHighVoltageSideTapGear(Double highVoltageSideTapGear) {
		this.highVoltageSideTapGear = highVoltageSideTapGear;
	}

	public Double getMediumVoltageSideTapGear() {
		return this.mediumVoltageSideTapGear;
	}

	public void setMediumVoltageSideTapGear(Double mediumVoltageSideTapGear) {
		this.mediumVoltageSideTapGear = mediumVoltageSideTapGear;
	}

	public Double getLowVoltageSideTapGear() {
		return this.lowVoltageSideTapGear;
	}

	public void setLowVoltageSideTapGear(Double lowVoltageSideTapGear) {
		this.lowVoltageSideTapGear = lowVoltageSideTapGear;
	}

	public Double getMvSideCapacity() {
		return this.mvSideCapacity;
	}

	public void setMvSideCapacity(Double mvSideCapacity) {
		this.mvSideCapacity = mvSideCapacity;
	}

	public String getMvSideCapacityUnit() {
		return this.mvSideCapacityUnit;
	}

	public void setMvSideCapacityUnit(String mvSideCapacityUnit) {
		this.mvSideCapacityUnit = mvSideCapacityUnit;
	}

	public Double getLvSideCapacity() {
		return this.lvSideCapacity;
	}

	public void setLvSideCapacity(Double lvSideCapacity) {
		this.lvSideCapacity = lvSideCapacity;
	}

	public String getLvSideCapacityUnit() {
		return this.lvSideCapacityUnit;
	}

	public void setLvSideCapacityUnit(String lvSideCapacityUnit) {
		this.lvSideCapacityUnit = lvSideCapacityUnit;
	}

	public Double getHvSideZeroSequenceResister() {
		return this.hvSideZeroSequenceResister;
	}

	public void setHvSideZeroSequenceResister(Double hvSideZeroSequenceResister) {
		this.hvSideZeroSequenceResister = hvSideZeroSequenceResister;
	}

	public String getHvSideZeroSeqResisterUnit() {
		return this.hvSideZeroSeqResisterUnit;
	}

	public void setHvSideZeroSeqResisterUnit(String hvSideZeroSeqResisterUnit) {
		this.hvSideZeroSeqResisterUnit = hvSideZeroSeqResisterUnit;
	}

	public Double getHvSideZeroSeqReactance() {
		return this.hvSideZeroSeqReactance;
	}

	public void setHvSideZeroSeqReactance(Double hvSideZeroSeqReactance) {
		this.hvSideZeroSeqReactance = hvSideZeroSeqReactance;
	}

	public String getHvSideZerSeqReactanceUnit() {
		return this.hvSideZerSeqReactanceUnit;
	}

	public void setHvSideZerSeqReactanceUnit(String hvSideZerSeqReactanceUnit) {
		this.hvSideZerSeqReactanceUnit = hvSideZerSeqReactanceUnit;
	}

	public Double getMvSideZeroSequenceResister() {
		return this.mvSideZeroSequenceResister;
	}

	public void setMvSideZeroSequenceResister(Double mvSideZeroSequenceResister) {
		this.mvSideZeroSequenceResister = mvSideZeroSequenceResister;
	}

	public String getMvSideZeroSeqResisterUnit() {
		return this.mvSideZeroSeqResisterUnit;
	}

	public void setMvSideZeroSeqResisterUnit(String mvSideZeroSeqResisterUnit) {
		this.mvSideZeroSeqResisterUnit = mvSideZeroSeqResisterUnit;
	}

	public Double getMvSideZeroSeqReactance() {
		return this.mvSideZeroSeqReactance;
	}

	public void setMvSideZeroSeqReactance(Double mvSideZeroSeqReactance) {
		this.mvSideZeroSeqReactance = mvSideZeroSeqReactance;
	}

	public String getMvSideZerSeqReactanceUnit() {
		return this.mvSideZerSeqReactanceUnit;
	}

	public void setMvSideZerSeqReactanceUnit(String mvSideZerSeqReactanceUnit) {
		this.mvSideZerSeqReactanceUnit = mvSideZerSeqReactanceUnit;
	}

	public Double getLvSideZeroSequenceResister() {
		return this.lvSideZeroSequenceResister;
	}

	public void setLvSideZeroSequenceResister(Double lvSideZeroSequenceResister) {
		this.lvSideZeroSequenceResister = lvSideZeroSequenceResister;
	}

	public String getLvSideZeroSeqResisterUnit() {
		return this.lvSideZeroSeqResisterUnit;
	}

	public void setLvSideZeroSeqResisterUnit(String lvSideZeroSeqResisterUnit) {
		this.lvSideZeroSeqResisterUnit = lvSideZeroSeqResisterUnit;
	}

	public Double getLvSideZeroSeqReactance() {
		return this.lvSideZeroSeqReactance;
	}

	public void setLvSideZeroSeqReactance(Double lvSideZeroSeqReactance) {
		this.lvSideZeroSeqReactance = lvSideZeroSeqReactance;
	}

	public String getLvSideZerSeqReactanceUnit() {
		return this.lvSideZerSeqReactanceUnit;
	}

	public void setLvSideZerSeqReactanceUnit(String lvSideZerSeqReactanceUnit) {
		this.lvSideZerSeqReactanceUnit = lvSideZerSeqReactanceUnit;
	}

	public String getDispatchingJurisdiction() {
		return this.dispatchingJurisdiction;
	}

	public void setDispatchingJurisdiction(String dispatchingJurisdiction) {
		this.dispatchingJurisdiction = dispatchingJurisdiction;
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

	public String getDispatchingMonitRight() {
		return this.dispatchingMonitRight;
	}

	public void setDispatchingMonitRight(String dispatchingMonitRight) {
		this.dispatchingMonitRight = dispatchingMonitRight;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPowerSysNameplateRunlibId() {
		return this.powerSysNameplateRunlibId;
	}

	public void setPowerSysNameplateRunlibId(String powerSysNameplateRunlibId) {
		this.powerSysNameplateRunlibId = powerSysNameplateRunlibId;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getVoltageLevelCode() {
		return this.voltageLevelCode;
	}

	public void setVoltageLevelCode(String voltageLevelCode) {
		this.voltageLevelCode = voltageLevelCode;
	}

	public String getCapacityRatio() {
		return this.capacityRatio;
	}

	public void setCapacityRatio(String capacityRatio) {
		this.capacityRatio = capacityRatio;
	}

	public String getSubstationVoltageLevel() {
		return this.substationVoltageLevel;
	}

	public void setSubstationVoltageLevel(String substationVoltageLevel) {
		this.substationVoltageLevel = substationVoltageLevel;
	}

	public String getVoltageLevelName() {
		return this.voltageLevelName;
	}

	public void setVoltageLevelName(String voltageLevelName) {
		this.voltageLevelName = voltageLevelName;
	}

	public String getProfessionalClassification() {
		return this.professionalClassification;
	}

	public void setProfessionalClassification(String professionalClassification) {
		this.professionalClassification = professionalClassification;
	}

	public String getStationId() {
		return this.stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getFunctionLocation() {
		return this.functionLocation;
	}

	public void setFunctionLocation(String functionLocation) {
		this.functionLocation = functionLocation;
	}

	public String getPmId() {
		return this.pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

}