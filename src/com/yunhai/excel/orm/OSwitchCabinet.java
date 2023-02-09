package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OSwitchCabinet entity. @author MyEclipse Persistence Tools
 */
public class OSwitchCabinet extends AbstractOSwitchCabinet implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OSwitchCabinet() {
	}

	/** minimal constructor */
	public OSwitchCabinet(String OSwitchCabinetId, String dataVersion, Date calYear,
			String dataSourceFile) {
		super(OSwitchCabinetId, dataVersion, calYear, dataSourceFile);
	}

	/** full constructor */
	public OSwitchCabinet(String OSwitchCabinetId, String dataVersion, Date importCalYear,
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
		super(OSwitchCabinetId, dataVersion, importCalYear, dataSourceFile, equipmentName, operationNumber,
				powerStation, spacerUnit, localCity, operationMaintenanceOrg, maintenanceTeam, equipmentOwner,
				voltageLevel, equipmentStatus, operationDate, latestOperationDate, generationMaintenance,
				regionalCharacteristics, equipmentClass, ruralPowerNetwork, useEnvironment, assetNature, assetUnit,
				assetId, itemCode, equipmentAdditionMethod, singleItemCoding, entryName, itemName, equipmentModel,
				manufacturer, wbsCode, factoryNumber, productCode, manufacturingCountry, productionDate, ratedVoltageKv,
				heightMm, widthMm, ratedCurrentA, depthMm, ratedFrequencyHz, insulatingMedium, whetherIacLevel,
				whetherLsc2Class, backCoverOrNot, structureType, cabinetWidthMm, equipmentId, registrationTime,
				remarks, accountCreationMethod, physicalId, powerStationVoltageLevel, functionalLocation, pmId,
				professionalClassification, equipmentTypeCode, whetherStandardized, voltageClassCode, voltageClassName);
	}

}
