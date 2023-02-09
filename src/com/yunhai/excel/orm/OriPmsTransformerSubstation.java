package com.yunhai.excel.orm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OriPmsTransformerSubstation entity. @author MyEclipse Persistence Tools
 */
public class OriPmsTransformerSubstation extends AbstractOriPmsTransformerSubstation implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriPmsTransformerSubstation() {
	}

	/** full constructor */
	public OriPmsTransformerSubstation(String equipmentName, String substationName, String orgName,
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
		super(equipmentName, substationName, orgName, maintainanceOrgName, maintainanceTeam, assetProperty,
				assetOrgName, voltageLevel, assetStatus, commissioningDate, substationType, powerSupplyArea,
				whetherSmartSubstation, isHubSubstation, substationImportantLevel, whetherAgentMaintainance,
				whetherRuralPowerNetwork, dutyMode, arrangementMode, contaminationLevel, substationAddress,
				coverageArea, coverageAreaUnit, buildingArea, buildingAreaUnit, altitude, altitudeUnit,
				regionalCharacteristics, cancellationDate, contactPhoneNumber, substationShortName,
				supremeDispatchJurisdiction, whetherSatisfiedNMinus1, whetherConnectedAvc, ifLinkDefInfoTeletransSys,
				engineeringName, whetherCentralizeMonitoring, equipmentId, registrationDate, deviceOwner, remark,
				whetherExistRingNetwork, engineeringId, isIndependentBuilding, antiMisoperationMode,
				subordinateDcSystem, converterStationType, assetId, professionalClassification, funcionalLocationCode,
				groundingResistance, groundingResistanceUnit, pmId, dcTransmissionCapacity, dcTransmissionCapacityUnit,
				voltageLevelCode, voltageLevelName, stationId, boxTransformerType, reactivePowerCompenCapacity,
				reactPowerCompenCapaciUnit, isUndergroundStation, workingNumber, importanceDegree,
				distribTransformerCapacity, distribTransformerCapacUnit, distribTransformerQuantity);
	}

}
