package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OElectricReactor entity. @author MyEclipse Persistence Tools
 */
public class OElectricReactor extends AbstractOElectricReactor implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OElectricReactor() {
	}

	/** minimal constructor */
	public OElectricReactor(String OElectricReactorId, String dataVersion, Date calYear) {
		super(OElectricReactorId, dataVersion, calYear);
	}

	/** full constructor */
	public OElectricReactor(String OElectricReactorId, String dataVersion, Date calYear, String equipmentName,
			String associatFixedFireExtingSys, String operationNumber, String powerStation, String spacerUnit,
			String localCity, String operationMaintenanDepartment, String maintenanceTeam, String equipmentOwner,
			String voltageLevel, String equipmentStatus, String largeFeederLine, String phaseNumber, String phaseName,
			String largeFeederBrnachLine, Date operationDate, Date latestOperationDate,
			String whetherRuralPowerNetwork, String combinedEquipmentClass, String accessMode, String useEnvironment,
			String whetherAgentMaintenance, String installationMode, String regionalCharacteristic, String assetNature,
			String assetOrganization, String wbsId, String assetId, String equipmentClassCode, String projectNo,
			String projectName, String equipmentAdditionMethod, String model, String manufacturer, String factoryNumber,
			String productCode, String manufacturingCountry, Date dateOfProduction, String insulationClass,
			String antifoulingGrade, String ratedVoltageKv, Double ratedCurrentA, Double ratedFrequencyHz,
			String coolingMode, String voltageRegulationMode, String insulatingMedium,
			String magneticConductionStructure, Double ratedCapacityKvar, Double ratedReactanceOmega,
			Double ratedReactanceRate, Double ratedInductanceMh, Double totalWeightT, String oilNumber,
			String oilProducingArea, Double ratedLossKw, Double percentImpedancePercent,
			Double ratedSTimeWithstandCurrKa, Double ratedPeakWithstandCurrKa, Double ratedShortCircuitDuratMs,
			String insulationLevel, Double bodyWeightT, String insulationLevelNeutralPoint,
			Double zeroSequenceReactanceOmega, Double continuWorkOvervoltageMulti, Double oilWeightT,
			String oilTankStructure, String conservatorSealingMode, String equipmentId,
			Double continuWorkOvercurrentMulti, Date registrationTime, String remark, String stationLineName,
			String accountCreationMethod, String voltageClassName, String combinedApparSwitchgearName,
			String belongCombinApparSwitchgear, String equipmentManufacturer, String professionalClassification,
			String pmId, String functionalLocation, String belongStationVoltageLevel, String physicalId,
			String voltageClassCode) {
		super(OElectricReactorId, dataVersion, calYear, equipmentName, associatFixedFireExtingSys, operationNumber,
				powerStation, spacerUnit, localCity, operationMaintenanDepartment, maintenanceTeam, equipmentOwner,
				voltageLevel, equipmentStatus, largeFeederLine, phaseNumber, phaseName, largeFeederBrnachLine,
				operationDate, latestOperationDate, whetherRuralPowerNetwork, combinedEquipmentClass, accessMode,
				useEnvironment, whetherAgentMaintenance, installationMode, regionalCharacteristic, assetNature,
				assetOrganization, wbsId, assetId, equipmentClassCode, projectNo, projectName, equipmentAdditionMethod,
				model, manufacturer, factoryNumber, productCode, manufacturingCountry, dateOfProduction,
				insulationClass, antifoulingGrade, ratedVoltageKv, ratedCurrentA, ratedFrequencyHz, coolingMode,
				voltageRegulationMode, insulatingMedium, magneticConductionStructure, ratedCapacityKvar,
				ratedReactanceOmega, ratedReactanceRate, ratedInductanceMh, totalWeightT, oilNumber, oilProducingArea,
				ratedLossKw, percentImpedancePercent, ratedSTimeWithstandCurrKa, ratedPeakWithstandCurrKa,
				ratedShortCircuitDuratMs, insulationLevel, bodyWeightT, insulationLevelNeutralPoint,
				zeroSequenceReactanceOmega, continuWorkOvervoltageMulti, oilWeightT, oilTankStructure,
				conservatorSealingMode, equipmentId, continuWorkOvercurrentMulti, registrationTime, remark,
				stationLineName, accountCreationMethod, voltageClassName, combinedApparSwitchgearName,
				belongCombinApparSwitchgear, equipmentManufacturer, professionalClassification, pmId,
				functionalLocation, belongStationVoltageLevel, physicalId, voltageClassCode);
	}

	public OElectricReactor(String oElectricReactorId, String dataVersion, Date calYear, String equipmentName,
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
		super(oElectricReactorId, dataVersion, calYear, equipmentName, associatFixedFireExtingSys, operationNumber,
				powerStation, spacerUnit, localCity, operationMaintenanDepartment, maintenanceTeam, equipmentOwner,
				voltageLevel, equipmentStatus, largeFeederLine, phaseNumber, phaseName, largeFeederBrnachLine, operationDate,
				latestOperationDate, whetherRuralPowerNetwork, combinedEquipmentClass, accessMode, useEnvironment,
				whetherAgentMaintenance, installationMode, regionalCharacteristic, assetNature, assetOrganization, wbsId,
				assetId, equipmentClassCode, projectNo, projectName, equipmentAdditionMethod, model, manufacturer,
				factoryNumber, productCode, manufacturingCountry, dateOfProduction, insulationClass, antifoulingGrade,
				ratedVoltageKv, ratedCurrentA, ratedFrequencyHz, coolingMode, voltageRegulationMode, insulatingMedium,
				magneticConductionStructure, ratedCapacityKvar, ratedReactanceOmega, ratedReactanceRate, ratedInductanceMh,
				totalWeightT, oilNumber, oilProducingArea, ratedLossKw, percentImpedancePercent, ratedSTimeWithstandCurrKa,
				ratedPeakWithstandCurrKa, ratedShortCircuitDuratMs, insulationLevel, bodyWeightT, insulationLevelNeutralPoint,
				zeroSequenceReactanceOmega, continuWorkOvervoltageMulti, oilWeightT, oilTankStructure, conservatorSealingMode,
				equipmentId, continuWorkOvercurrentMulti, registrationTime, remark, stationLineName, accountCreationMethod,
				voltageClassName, combinedApparSwitchgearName, belongCombinApparSwitchgear, equipmentManufacturer,
				professionalClassification, pmId, functionalLocation, belongStationVoltageLevel, physicalId, voltageClassCode,
				dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
