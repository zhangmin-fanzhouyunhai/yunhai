package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriPmsTransformer entity. @author MyEclipse Persistence Tools
 */
public class OriPmsTransformer extends AbstractOriPmsTransformer implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriPmsTransformer() {
	}

	/** full constructor */
	public OriPmsTransformer(String equipmentName, String workingCode, String subordinateSubstationName,
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
		super(equipmentName, workingCode, subordinateSubstationName, commissioningDate, assetOrgName, wbsId,
				modelNumber, manufacturer, factoryNumber, productionDate, equipmentId, equipmentTypeCode, spaceingUnit,
				orgName, maintainanceOrgName, maintainanceTeam, equipmentOwner, voltageLevel, equipmentStatus,
				phaseNumber, phaseType, recentCommissioningDate, whetherRuralPowerNetwork, purpose, workingEnvironment,
				installationLocation, assetProperty, assetId, engineeringId, engineeringName, equipmentIncreaseMode,
				productCode, manufacturingCountry, ratedVoltage, ratedVoltageUnit, ratedCurrent, ratedCurrentUnit,
				ratedFrequency, ratedFrequencyUnit, insulateHeatResistanceGrade, antifoulingGrade, insulatingMedium,
				windingType, structuralStyle, coolingMode, voltageRegulationMode, connectionGroupLabel, ratedCapacity,
				ratedCapacityUnit, selfCoolingCapacityPercent, voltageRatio, ratedMediumVoltage, ratedMediumVoltageUnit,
				ratedLowVoltage, ratedLowVoltageUnit, mvRatedCurrent, mvRatedCurrentUnit, lvRatedCurrent,
				lvRatedCurrentUnit, highLowVoltageLoadLoss, highLowVoltLoadLossUnit, highMediumVoltageLoadLoss,
				highMedVoltLoadLossUnit, mediumLowVoltLoadLoss, medLowVoltLoadLossUnit, hvMvShortCircuitImpedanc,
				hvLvShortCircuitImpedance, mvLvShortCircuitImpedance, noLoadCurrentRatio, noLoadLoss, noLoadLossUnit,
				fullLoadLoss, fullLoadLossUnit, totalWeight, totalWeightUnit, oilNumber, oilWeight, oilWeightUnit,
				oilProductionArea, ratedSf6GasPressure, ratedSf6GasPressureUnit, sf6GasAlarmPressure,
				sf6GasAlarmPressureUnit, bodyWeight, bodyWeightUnit, transportationWeight, transportationWeightUnit,
				isulationLevel, isulationLevelNeutralPoint, forcedAirCoolingNoiseHp, forcedAirCoolNoiseHpUnit,
				oilPillowCapacity, oilPillowCapacityUnit, oilPillowSealingMethod, whetherExistThermalSiphon,
				upperFuelTankWeight, upperFuelTankWeightUnit, oilGasTankStructure, sf6Manufacturer, sf6GasWeight,
				sf6GasWeightUnit, sf6AirOntologyWeight, sf6AirOntologyWeightUnit, sf6AirCableStorageWeight,
				sf6AirCableStorWeightUnit, sf6AirOnLoadSwitchWeight, sf6OnLoadSwitchWeightUnit, sf6AirOntologyPressure,
				sf6AirOntologyPressureUnit, sf6AirCableStoragePressure, sf6CableStorPressureUnit,
				sf6OnLoadSwitchPressure, sf6OnLoadSwitchPressuUnit, coolingWaterWeight, coolingWaterWeightUnit,
				cumulativeFilingNumber, upLayerOilTemperatureLimit, upLayerOilTemperLimitUnit, windingTemperatureLimit,
				windingTemperatureLimitUnit, neutralPoingGroundingMode, highVoltageSideTapGear,
				mediumVoltageSideTapGear, lowVoltageSideTapGear, mvSideCapacity, mvSideCapacityUnit, lvSideCapacity,
				lvSideCapacityUnit, hvSideZeroSequenceResister, hvSideZeroSeqResisterUnit, hvSideZeroSeqReactance,
				hvSideZerSeqReactanceUnit, mvSideZeroSequenceResister, mvSideZeroSeqResisterUnit,
				mvSideZeroSeqReactance, mvSideZerSeqReactanceUnit, lvSideZeroSequenceResister,
				lvSideZeroSeqResisterUnit, lvSideZeroSeqReactance, lvSideZerSeqReactanceUnit, dispatchingJurisdiction,
				dispatchingOperationRight, dispatchingPermission, dispatchingMonitRight, registrationDate, remark,
				powerSysNameplateRunlibId, objectId, voltageLevelCode, capacityRatio, substationVoltageLevel,
				voltageLevelName, professionalClassification, stationId, functionLocation, pmId);
	}

}
