package com.yunhai.excel.orm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * AbstractOriPmsTransformerSubstation entity provides the base persistence
 * definition of the OriPmsTransformerSubstation entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriPmsTransformerSubstation implements java.io.Serializable {

	// Fields

	private String oriPmsTransformerSubstatId;
	private String equipmentName;
	private String substationName;
	private String orgName;
	private String maintainanceOrgName;
	private String maintainanceTeam;
	private String assetProperty;
	private String assetOrgName;
	private String voltageLevel;
	private String assetStatus;
	private Date commissioningDate;
	private String substationType;
	private String powerSupplyArea;
	private String whetherSmartSubstation;
	private String isHubSubstation;
	private String substationImportantLevel;
	private String whetherAgentMaintainance;
	private String whetherRuralPowerNetwork;
	private String dutyMode;
	private String arrangementMode;
	private String contaminationLevel;
	private String substationAddress;
	private Double coverageArea;
	private String coverageAreaUnit;
	private Double buildingArea;
	private String buildingAreaUnit;
	private BigDecimal altitude;
	private String altitudeUnit;
	private String regionalCharacteristics;
	private Date cancellationDate;
	private String contactPhoneNumber;
	private String substationShortName;
	private String supremeDispatchJurisdiction;
	private String whetherSatisfiedNMinus1;
	private String whetherConnectedAvc;
	private String ifLinkDefInfoTeletransSys;
	private String engineeringName;
	private String whetherCentralizeMonitoring;
	private String equipmentId;
	private Date registrationDate;
	private String deviceOwner;
	private String remark;
	private String whetherExistRingNetwork;
	private String engineeringId;
	private String isIndependentBuilding;
	private String antiMisoperationMode;
	private String subordinateDcSystem;
	private String converterStationType;
	private String assetId;
	private String professionalClassification;
	private String funcionalLocationCode;
	private Double groundingResistance;
	private String groundingResistanceUnit;
	private String pmId;
	private Double dcTransmissionCapacity;
	private String dcTransmissionCapacityUnit;
	private String voltageLevelCode;
	private String voltageLevelName;
	private String stationId;
	private String boxTransformerType;
	private Double reactivePowerCompenCapacity;
	private String reactPowerCompenCapaciUnit;
	private String isUndergroundStation;
	private String workingNumber;
	private String importanceDegree;
	private Double distribTransformerCapacity;
	private String distribTransformerCapacUnit;
	private Double distribTransformerQuantity;

	// Constructors

	/** default constructor */
	public AbstractOriPmsTransformerSubstation() {
	}

	/** full constructor */
	public AbstractOriPmsTransformerSubstation(String equipmentName, String substationName, String orgName,
			String maintainanceOrgName, String maintainanceTeam, String assetProperty, String assetOrgName,
			String voltageLevel, String assetStatus, Date commissioningDate, String substationType,
			String powerSupplyArea, String whetherSmartSubstation, String isHubSubstation,
			String substationImportantLevel, String whetherAgentMaintainance, String whetherRuralPowerNetwork,
			String dutyMode, String arrangementMode, String contaminationLevel, String substationAddress,
			Double coverageArea, String coverageAreaUnit, Double buildingArea, String buildingAreaUnit,
			BigDecimal altitude, String altitudeUnit, String regionalCharacteristics, Date cancellationDate,
			String contactPhoneNumber, String substationShortName, String supremeDispatchJurisdiction,
			String whetherSatisfiedNMinus1, String whetherConnectedAvc, String ifLinkDefInfoTeletransSys,
			String engineeringName, String whetherCentralizeMonitoring, String equipmentId, Date registrationDate,
			String deviceOwner, String remark, String whetherExistRingNetwork, String engineeringId,
			String isIndependentBuilding, String antiMisoperationMode, String subordinateDcSystem,
			String converterStationType, String assetId, String professionalClassification,
			String funcionalLocationCode, Double groundingResistance, String groundingResistanceUnit, String pmId,
			Double dcTransmissionCapacity, String dcTransmissionCapacityUnit, String voltageLevelCode,
			String voltageLevelName, String stationId, String boxTransformerType, Double reactivePowerCompenCapacity,
			String reactPowerCompenCapaciUnit, String isUndergroundStation, String workingNumber,
			String importanceDegree, Double distribTransformerCapacity, String distribTransformerCapacUnit,
			Double distribTransformerQuantity) {
		this.equipmentName = equipmentName;
		this.substationName = substationName;
		this.orgName = orgName;
		this.maintainanceOrgName = maintainanceOrgName;
		this.maintainanceTeam = maintainanceTeam;
		this.assetProperty = assetProperty;
		this.assetOrgName = assetOrgName;
		this.voltageLevel = voltageLevel;
		this.assetStatus = assetStatus;
		this.commissioningDate = commissioningDate;
		this.substationType = substationType;
		this.powerSupplyArea = powerSupplyArea;
		this.whetherSmartSubstation = whetherSmartSubstation;
		this.isHubSubstation = isHubSubstation;
		this.substationImportantLevel = substationImportantLevel;
		this.whetherAgentMaintainance = whetherAgentMaintainance;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.dutyMode = dutyMode;
		this.arrangementMode = arrangementMode;
		this.contaminationLevel = contaminationLevel;
		this.substationAddress = substationAddress;
		this.coverageArea = coverageArea;
		this.coverageAreaUnit = coverageAreaUnit;
		this.buildingArea = buildingArea;
		this.buildingAreaUnit = buildingAreaUnit;
		this.altitude = altitude;
		this.altitudeUnit = altitudeUnit;
		this.regionalCharacteristics = regionalCharacteristics;
		this.cancellationDate = cancellationDate;
		this.contactPhoneNumber = contactPhoneNumber;
		this.substationShortName = substationShortName;
		this.supremeDispatchJurisdiction = supremeDispatchJurisdiction;
		this.whetherSatisfiedNMinus1 = whetherSatisfiedNMinus1;
		this.whetherConnectedAvc = whetherConnectedAvc;
		this.ifLinkDefInfoTeletransSys = ifLinkDefInfoTeletransSys;
		this.engineeringName = engineeringName;
		this.whetherCentralizeMonitoring = whetherCentralizeMonitoring;
		this.equipmentId = equipmentId;
		this.registrationDate = registrationDate;
		this.deviceOwner = deviceOwner;
		this.remark = remark;
		this.whetherExistRingNetwork = whetherExistRingNetwork;
		this.engineeringId = engineeringId;
		this.isIndependentBuilding = isIndependentBuilding;
		this.antiMisoperationMode = antiMisoperationMode;
		this.subordinateDcSystem = subordinateDcSystem;
		this.converterStationType = converterStationType;
		this.assetId = assetId;
		this.professionalClassification = professionalClassification;
		this.funcionalLocationCode = funcionalLocationCode;
		this.groundingResistance = groundingResistance;
		this.groundingResistanceUnit = groundingResistanceUnit;
		this.pmId = pmId;
		this.dcTransmissionCapacity = dcTransmissionCapacity;
		this.dcTransmissionCapacityUnit = dcTransmissionCapacityUnit;
		this.voltageLevelCode = voltageLevelCode;
		this.voltageLevelName = voltageLevelName;
		this.stationId = stationId;
		this.boxTransformerType = boxTransformerType;
		this.reactivePowerCompenCapacity = reactivePowerCompenCapacity;
		this.reactPowerCompenCapaciUnit = reactPowerCompenCapaciUnit;
		this.isUndergroundStation = isUndergroundStation;
		this.workingNumber = workingNumber;
		this.importanceDegree = importanceDegree;
		this.distribTransformerCapacity = distribTransformerCapacity;
		this.distribTransformerCapacUnit = distribTransformerCapacUnit;
		this.distribTransformerQuantity = distribTransformerQuantity;
	}

	// Property accessors

	public String getOriPmsTransformerSubstatId() {
		return this.oriPmsTransformerSubstatId;
	}

	public void setOriPmsTransformerSubstatId(String oriPmsTransformerSubstatId) {
		this.oriPmsTransformerSubstatId = oriPmsTransformerSubstatId;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getSubstationName() {
		return this.substationName;
	}

	public void setSubstationName(String substationName) {
		this.substationName = substationName;
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

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getAssetOrgName() {
		return this.assetOrgName;
	}

	public void setAssetOrgName(String assetOrgName) {
		this.assetOrgName = assetOrgName;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getSubstationType() {
		return this.substationType;
	}

	public void setSubstationType(String substationType) {
		this.substationType = substationType;
	}

	public String getPowerSupplyArea() {
		return this.powerSupplyArea;
	}

	public void setPowerSupplyArea(String powerSupplyArea) {
		this.powerSupplyArea = powerSupplyArea;
	}

	public String getWhetherSmartSubstation() {
		return this.whetherSmartSubstation;
	}

	public void setWhetherSmartSubstation(String whetherSmartSubstation) {
		this.whetherSmartSubstation = whetherSmartSubstation;
	}

	public String getIsHubSubstation() {
		return this.isHubSubstation;
	}

	public void setIsHubSubstation(String isHubSubstation) {
		this.isHubSubstation = isHubSubstation;
	}

	public String getSubstationImportantLevel() {
		return this.substationImportantLevel;
	}

	public void setSubstationImportantLevel(String substationImportantLevel) {
		this.substationImportantLevel = substationImportantLevel;
	}

	public String getWhetherAgentMaintainance() {
		return this.whetherAgentMaintainance;
	}

	public void setWhetherAgentMaintainance(String whetherAgentMaintainance) {
		this.whetherAgentMaintainance = whetherAgentMaintainance;
	}

	public String getWhetherRuralPowerNetwork() {
		return this.whetherRuralPowerNetwork;
	}

	public void setWhetherRuralPowerNetwork(String whetherRuralPowerNetwork) {
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
	}

	public String getDutyMode() {
		return this.dutyMode;
	}

	public void setDutyMode(String dutyMode) {
		this.dutyMode = dutyMode;
	}

	public String getArrangementMode() {
		return this.arrangementMode;
	}

	public void setArrangementMode(String arrangementMode) {
		this.arrangementMode = arrangementMode;
	}

	public String getContaminationLevel() {
		return this.contaminationLevel;
	}

	public void setContaminationLevel(String contaminationLevel) {
		this.contaminationLevel = contaminationLevel;
	}

	public String getSubstationAddress() {
		return this.substationAddress;
	}

	public void setSubstationAddress(String substationAddress) {
		this.substationAddress = substationAddress;
	}

	public Double getCoverageArea() {
		return this.coverageArea;
	}

	public void setCoverageArea(Double coverageArea) {
		this.coverageArea = coverageArea;
	}

	public String getCoverageAreaUnit() {
		return this.coverageAreaUnit;
	}

	public void setCoverageAreaUnit(String coverageAreaUnit) {
		this.coverageAreaUnit = coverageAreaUnit;
	}

	public Double getBuildingArea() {
		return this.buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getBuildingAreaUnit() {
		return this.buildingAreaUnit;
	}

	public void setBuildingAreaUnit(String buildingAreaUnit) {
		this.buildingAreaUnit = buildingAreaUnit;
	}

	public BigDecimal getAltitude() {
		return this.altitude;
	}

	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}

	public String getAltitudeUnit() {
		return this.altitudeUnit;
	}

	public void setAltitudeUnit(String altitudeUnit) {
		this.altitudeUnit = altitudeUnit;
	}

	public String getRegionalCharacteristics() {
		return this.regionalCharacteristics;
	}

	public void setRegionalCharacteristics(String regionalCharacteristics) {
		this.regionalCharacteristics = regionalCharacteristics;
	}

	public Date getCancellationDate() {
		return this.cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getContactPhoneNumber() {
		return this.contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getSubstationShortName() {
		return this.substationShortName;
	}

	public void setSubstationShortName(String substationShortName) {
		this.substationShortName = substationShortName;
	}

	public String getSupremeDispatchJurisdiction() {
		return this.supremeDispatchJurisdiction;
	}

	public void setSupremeDispatchJurisdiction(String supremeDispatchJurisdiction) {
		this.supremeDispatchJurisdiction = supremeDispatchJurisdiction;
	}

	public String getWhetherSatisfiedNMinus1() {
		return this.whetherSatisfiedNMinus1;
	}

	public void setWhetherSatisfiedNMinus1(String whetherSatisfiedNMinus1) {
		this.whetherSatisfiedNMinus1 = whetherSatisfiedNMinus1;
	}

	public String getWhetherConnectedAvc() {
		return this.whetherConnectedAvc;
	}

	public void setWhetherConnectedAvc(String whetherConnectedAvc) {
		this.whetherConnectedAvc = whetherConnectedAvc;
	}

	public String getIfLinkDefInfoTeletransSys() {
		return this.ifLinkDefInfoTeletransSys;
	}

	public void setIfLinkDefInfoTeletransSys(String ifLinkDefInfoTeletransSys) {
		this.ifLinkDefInfoTeletransSys = ifLinkDefInfoTeletransSys;
	}

	public String getEngineeringName() {
		return this.engineeringName;
	}

	public void setEngineeringName(String engineeringName) {
		this.engineeringName = engineeringName;
	}

	public String getWhetherCentralizeMonitoring() {
		return this.whetherCentralizeMonitoring;
	}

	public void setWhetherCentralizeMonitoring(String whetherCentralizeMonitoring) {
		this.whetherCentralizeMonitoring = whetherCentralizeMonitoring;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDeviceOwner() {
		return this.deviceOwner;
	}

	public void setDeviceOwner(String deviceOwner) {
		this.deviceOwner = deviceOwner;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWhetherExistRingNetwork() {
		return this.whetherExistRingNetwork;
	}

	public void setWhetherExistRingNetwork(String whetherExistRingNetwork) {
		this.whetherExistRingNetwork = whetherExistRingNetwork;
	}

	public String getEngineeringId() {
		return this.engineeringId;
	}

	public void setEngineeringId(String engineeringId) {
		this.engineeringId = engineeringId;
	}

	public String getIsIndependentBuilding() {
		return this.isIndependentBuilding;
	}

	public void setIsIndependentBuilding(String isIndependentBuilding) {
		this.isIndependentBuilding = isIndependentBuilding;
	}

	public String getAntiMisoperationMode() {
		return this.antiMisoperationMode;
	}

	public void setAntiMisoperationMode(String antiMisoperationMode) {
		this.antiMisoperationMode = antiMisoperationMode;
	}

	public String getSubordinateDcSystem() {
		return this.subordinateDcSystem;
	}

	public void setSubordinateDcSystem(String subordinateDcSystem) {
		this.subordinateDcSystem = subordinateDcSystem;
	}

	public String getConverterStationType() {
		return this.converterStationType;
	}

	public void setConverterStationType(String converterStationType) {
		this.converterStationType = converterStationType;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getProfessionalClassification() {
		return this.professionalClassification;
	}

	public void setProfessionalClassification(String professionalClassification) {
		this.professionalClassification = professionalClassification;
	}

	public String getFuncionalLocationCode() {
		return this.funcionalLocationCode;
	}

	public void setFuncionalLocationCode(String funcionalLocationCode) {
		this.funcionalLocationCode = funcionalLocationCode;
	}

	public Double getGroundingResistance() {
		return this.groundingResistance;
	}

	public void setGroundingResistance(Double groundingResistance) {
		this.groundingResistance = groundingResistance;
	}

	public String getGroundingResistanceUnit() {
		return this.groundingResistanceUnit;
	}

	public void setGroundingResistanceUnit(String groundingResistanceUnit) {
		this.groundingResistanceUnit = groundingResistanceUnit;
	}

	public String getPmId() {
		return this.pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public Double getDcTransmissionCapacity() {
		return this.dcTransmissionCapacity;
	}

	public void setDcTransmissionCapacity(Double dcTransmissionCapacity) {
		this.dcTransmissionCapacity = dcTransmissionCapacity;
	}

	public String getDcTransmissionCapacityUnit() {
		return this.dcTransmissionCapacityUnit;
	}

	public void setDcTransmissionCapacityUnit(String dcTransmissionCapacityUnit) {
		this.dcTransmissionCapacityUnit = dcTransmissionCapacityUnit;
	}

	public String getVoltageLevelCode() {
		return this.voltageLevelCode;
	}

	public void setVoltageLevelCode(String voltageLevelCode) {
		this.voltageLevelCode = voltageLevelCode;
	}

	public String getVoltageLevelName() {
		return this.voltageLevelName;
	}

	public void setVoltageLevelName(String voltageLevelName) {
		this.voltageLevelName = voltageLevelName;
	}

	public String getStationId() {
		return this.stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getBoxTransformerType() {
		return this.boxTransformerType;
	}

	public void setBoxTransformerType(String boxTransformerType) {
		this.boxTransformerType = boxTransformerType;
	}

	public Double getReactivePowerCompenCapacity() {
		return this.reactivePowerCompenCapacity;
	}

	public void setReactivePowerCompenCapacity(Double reactivePowerCompenCapacity) {
		this.reactivePowerCompenCapacity = reactivePowerCompenCapacity;
	}

	public String getReactPowerCompenCapaciUnit() {
		return this.reactPowerCompenCapaciUnit;
	}

	public void setReactPowerCompenCapaciUnit(String reactPowerCompenCapaciUnit) {
		this.reactPowerCompenCapaciUnit = reactPowerCompenCapaciUnit;
	}

	public String getIsUndergroundStation() {
		return this.isUndergroundStation;
	}

	public void setIsUndergroundStation(String isUndergroundStation) {
		this.isUndergroundStation = isUndergroundStation;
	}

	public String getWorkingNumber() {
		return this.workingNumber;
	}

	public void setWorkingNumber(String workingNumber) {
		this.workingNumber = workingNumber;
	}

	public String getImportanceDegree() {
		return this.importanceDegree;
	}

	public void setImportanceDegree(String importanceDegree) {
		this.importanceDegree = importanceDegree;
	}

	public Double getDistribTransformerCapacity() {
		return this.distribTransformerCapacity;
	}

	public void setDistribTransformerCapacity(Double distribTransformerCapacity) {
		this.distribTransformerCapacity = distribTransformerCapacity;
	}

	public String getDistribTransformerCapacUnit() {
		return this.distribTransformerCapacUnit;
	}

	public void setDistribTransformerCapacUnit(String distribTransformerCapacUnit) {
		this.distribTransformerCapacUnit = distribTransformerCapacUnit;
	}

	public Double getDistribTransformerQuantity() {
		return this.distribTransformerQuantity;
	}

	public void setDistribTransformerQuantity(Double distribTransformerQuantity) {
		this.distribTransformerQuantity = distribTransformerQuantity;
	}

}