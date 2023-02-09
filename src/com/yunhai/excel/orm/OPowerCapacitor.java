package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OPowerCapacitor entity. @author MyEclipse Persistence Tools
 */
public class OPowerCapacitor extends AbstractOPowerCapacitor implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OPowerCapacitor() {
	}

	/** minimal constructor */
	public OPowerCapacitor(String OPowerCapacitorId, String dataVersion, Date calYear) {
		super(OPowerCapacitorId, dataVersion, calYear);
	}

	/** full constructor */
	public OPowerCapacitor(String OPowerCapacitorId, String dataVersion, Date calYear, String equipmentName,
			String operationNumber, String powerStation, String spacerUnit, String localCity,
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
		super(OPowerCapacitorId, dataVersion, calYear, equipmentName, operationNumber, powerStation, spacerUnit,
				localCity, operationMaintenanDepartment, maintenanceTeam, equipmentOwner, voltageLevel,
				belongLargeFeederLine, equipmentStatus, operationDate, whetherAgentMaintenance, largeFeederBrnachLine,
				latestOperationDate, combinedEquipmentType, whetherRuralPowerNetwork, useEnvironment, importanceDegree,
				installationMode, accessMode, wiringMode, assetNature, assetDepartment, wbsId, assetId, projectNo,
				projectName, equipmentAdditionMethod, equipmentModel, manufacturer, factoryNumber, productCode,
				manufacturingCountry, productionDate, insulatingMedium, capacitorBankInteProteMode,
				singleProtectionMode, ratedVoltageKv, ratedCurrentA, ratedFrequencyHz, singleCapacityKvar,
				wholeGroupCapacityKvar, capacitanceUf, dispatchingJurisdiction, equipmentNumber,
				dispatchingOperationRight, dispatchingPermission, dispatchingMonitoringRight, registrationTime,
				equipmentId, remark, equipmentClassCode, combinedElectricalAppliance, combinedEquipmentName,
				combinedApparSwitchgearName, professionalClassification, pmId, functionalLocation, physicalId,
				accountCreationMethod);
	}

	public OPowerCapacitor(String oPowerCapacitorId, String dataVersion, Date calYear, String equipmentName,
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
		super(oPowerCapacitorId, dataVersion, calYear, equipmentName, operationNumber, powerStation, spacerUnit, localCity,
				operationMaintenanDepartment, maintenanceTeam, equipmentOwner, voltageLevel, belongLargeFeederLine,
				equipmentStatus, operationDate, whetherAgentMaintenance, largeFeederBrnachLine, latestOperationDate,
				combinedEquipmentType, whetherRuralPowerNetwork, useEnvironment, importanceDegree, installationMode, accessMode,
				wiringMode, assetNature, assetDepartment, wbsId, assetId, projectNo, projectName, equipmentAdditionMethod,
				equipmentModel, manufacturer, factoryNumber, productCode, manufacturingCountry, productionDate,
				insulatingMedium, capacitorBankInteProteMode, singleProtectionMode, ratedVoltageKv, ratedCurrentA,
				ratedFrequencyHz, singleCapacityKvar, wholeGroupCapacityKvar, capacitanceUf, dispatchingJurisdiction,
				equipmentNumber, dispatchingOperationRight, dispatchingPermission, dispatchingMonitoringRight, registrationTime,
				equipmentId, remark, equipmentClassCode, combinedElectricalAppliance, combinedEquipmentName,
				combinedApparSwitchgearName, professionalClassification, pmId, functionalLocation, physicalId,
				accountCreationMethod, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
