package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidErpItem entity. @author MyEclipse Persistence Tools
 */
public class MidErpItem extends AbstractMidErpItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidErpItem() {
	}

	/** minimal constructor */
	public MidErpItem(String midErpItemId, String version, Date calYear) {
		super(midErpItemId, version, calYear);
	}

	/** full constructor */
	
	
	public MidErpItem(String midErpItemId, String version, Date calYear, Short calyear, String orgName, String compCode,
			String assetMainNumber, String assetSubnumber, String equipementNumber, String currency, String largeClass,
			String mediumClass, String smallClass, String voltageLevel, Double quantity, String unit,
			Double originalValue, Double netValue, String assetStatus, String profitEnterSecLevelUnit,
			String costControlArea, String assetDescription, String projectType, Date capitalizationDate,
			Date deliveryDate, Date manufactureDate, Double lineLength, String lengthUnit, Double transformerCapacity,
			String capacityUnit, String warehouseAddress, String sparePartMark, String reusingDeviceMark,
			Date reusingEntryDate, Date reusingOutDate, String discardProjectResourceCode, String discardReasonCode,
			Date discardAccountingDate, String equipmentStatus, String equipmentVoltageLevel, String isCustody,
			String manufacturerCard, String manufacturerEquipement, String manufactureState,
			String manufacturePartNumber, String inactivityDate, String assetCategory, String cardSerialNumber,
			String cardInventoryNumber, String cardAssetUnit, String cardStorageUnit, String cardCostCenter,
			String cardAssetManageDepart, String cardUsingCustodian, String cardCarLicense,
			String costCenterAuxilAccounting, String donationType, String superviseSign, String assetUsingInformation,
			String assetIncreaseMethod, String assetChangeMode, String assetOrigin, String engineeringProperty,
			String fixedAssetClass, String cardWbsElement, String cardWbsElementDesc, String assetStorageAddress,
			String lineStationName, String housePropCertifiNum, String equipementName, String technicalObjectType,
			String authorizationGroup, String equipSpecificationModel, String equipNameplateNumber,
			String maintenanceFactory, String equipAssetChangeMode, String factoryArea, String abcIdentification,
			String classifiedField, String equipmentCostCenter, String equipmentWbsElement, String equipWbsElementDesc,
			String planFactory, String planGroup, String mainWorkCenter, String functionalPosition,
			String advancedEquipment, String techIdentificationNumber, String equipUseCustodian,
			String equipStorageDepartment, String equipObjectManageDeparment, String epqipmentIncreaseMethod,
			String equipmentSotrageAddress, String equipCarLicense, String equipHousePropCertifiNum,
			String lineStationLogo, String discardOriginProjectDesc, String discardReasonContent, Date dataExtractDate,
			Date dataExtractTime, String dataExtractPerson, String assetProperty, String propertyCode) {
		super(midErpItemId, version, calYear, calyear, orgName, compCode, assetMainNumber, assetSubnumber,
				equipementNumber, currency, largeClass, mediumClass, smallClass, voltageLevel, quantity, unit,
				originalValue, netValue, assetStatus, profitEnterSecLevelUnit, costControlArea, assetDescription,
				projectType, capitalizationDate, deliveryDate, manufactureDate, lineLength, lengthUnit,
				transformerCapacity, capacityUnit, warehouseAddress, sparePartMark, reusingDeviceMark, reusingEntryDate,
				reusingOutDate, discardProjectResourceCode, discardReasonCode, discardAccountingDate, equipmentStatus,
				equipmentVoltageLevel, isCustody, manufacturerCard, manufacturerEquipement, manufactureState,
				manufacturePartNumber, inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber,
				cardAssetUnit, cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian,
				cardCarLicense, costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
				assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass, cardWbsElement,
				cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum, equipementName,
				technicalObjectType, authorizationGroup, equipSpecificationModel, equipNameplateNumber,
				maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification, classifiedField,
				equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory, planGroup, mainWorkCenter,
				functionalPosition, advancedEquipment, techIdentificationNumber, equipUseCustodian,
				equipStorageDepartment, equipObjectManageDeparment, epqipmentIncreaseMethod, equipmentSotrageAddress,
				equipCarLicense, equipHousePropCertifiNum, lineStationLogo, discardOriginProjectDesc,
				discardReasonContent, dataExtractDate, dataExtractTime, dataExtractPerson, assetProperty, propertyCode);
	}

	public MidErpItem(String midErpItemId, String version, Date calYear, Short calyear2, String orgName,
			String compCode, String assetMainNumber, String assetSubnumber, String equipementNumber, String currency,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double quantity, String unit,
			Double originalValue, Double netValue, String assetStatus, String profitEnterSecLevelUnit,
			String costControlArea, String assetDescription, String projectType, Date capitalizationDate,
			Date deliveryDate, Date manufactureDate, Double lineLength, String lengthUnit, Double transformerCapacity,
			String capacityUnit, String warehouseAddress, String sparePartMark, String reusingDeviceMark,
			Date reusingEntryDate, Date reusingOutDate, String discardProjectResourceCode, String discardReasonCode,
			Date discardAccountingDate, String equipmentStatus, String equipmentVoltageLevel, String isCustody,
			String manufacturerCard, String manufacturerEquipement, String manufactureState,
			String manufacturePartNumber, String inactivityDate, String assetCategory, String cardSerialNumber,
			String cardInventoryNumber, String cardAssetUnit, String cardStorageUnit, String cardCostCenter,
			String cardAssetManageDepart, String cardUsingCustodian, String cardCarLicense,
			String costCenterAuxilAccounting, String donationType, String superviseSign, String assetUsingInformation,
			String assetIncreaseMethod, String assetChangeMode, String assetOrigin, String engineeringProperty,
			String fixedAssetClass, String cardWbsElement, String cardWbsElementDesc, String assetStorageAddress,
			String lineStationName, String housePropCertifiNum, String equipementName, String technicalObjectType,
			String authorizationGroup, String equipSpecificationModel, String equipNameplateNumber,
			String maintenanceFactory, String equipAssetChangeMode, String factoryArea, String abcIdentification,
			String classifiedField, String equipmentCostCenter, String equipmentWbsElement, String equipWbsElementDesc,
			String planFactory, String planGroup, String mainWorkCenter, String functionalPosition,
			String advancedEquipment, String techIdentificationNumber, String equipUseCustodian,
			String equipStorageDepartment, String equipObjectManageDeparment, String epqipmentIncreaseMethod,
			String equipmentSotrageAddress, String equipCarLicense, String equipHousePropCertifiNum,
			String lineStationLogo, String discardOriginProjectDesc, String discardReasonContent, Date dataExtractDate,
			Date dataExtractTime, String dataExtractPerson, String assetProperty, String propertyCode, String pmunr,
			String assetId, String assetVoltagelevel, String oldVoltageLevel, String oldAssetProperty,
			String oldPropertyCode, Date oldCapitalizationDate) {
		super(midErpItemId, version, calYear, calyear2, orgName, compCode, assetMainNumber, assetSubnumber, equipementNumber,
				currency, largeClass, mediumClass, smallClass, voltageLevel, quantity, unit, originalValue, netValue,
				assetStatus, profitEnterSecLevelUnit, costControlArea, assetDescription, projectType, capitalizationDate,
				deliveryDate, manufactureDate, lineLength, lengthUnit, transformerCapacity, capacityUnit, warehouseAddress,
				sparePartMark, reusingDeviceMark, reusingEntryDate, reusingOutDate, discardProjectResourceCode,
				discardReasonCode, discardAccountingDate, equipmentStatus, equipmentVoltageLevel, isCustody, manufacturerCard,
				manufacturerEquipement, manufactureState, manufacturePartNumber, inactivityDate, assetCategory,
				cardSerialNumber, cardInventoryNumber, cardAssetUnit, cardStorageUnit, cardCostCenter, cardAssetManageDepart,
				cardUsingCustodian, cardCarLicense, costCenterAuxilAccounting, donationType, superviseSign,
				assetUsingInformation, assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass,
				cardWbsElement, cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum, equipementName,
				technicalObjectType, authorizationGroup, equipSpecificationModel, equipNameplateNumber, maintenanceFactory,
				equipAssetChangeMode, factoryArea, abcIdentification, classifiedField, equipmentCostCenter, equipmentWbsElement,
				equipWbsElementDesc, planFactory, planGroup, mainWorkCenter, functionalPosition, advancedEquipment,
				techIdentificationNumber, equipUseCustodian, equipStorageDepartment, equipObjectManageDeparment,
				epqipmentIncreaseMethod, equipmentSotrageAddress, equipCarLicense, equipHousePropCertifiNum, lineStationLogo,
				discardOriginProjectDesc, discardReasonContent, dataExtractDate, dataExtractTime, dataExtractPerson,
				assetProperty, propertyCode, pmunr, assetId, assetVoltagelevel, oldVoltageLevel, oldAssetProperty,
				oldPropertyCode, oldCapitalizationDate);
		// TODO Auto-generated constructor stub
	}

	/** full constructor 20200527*/
	public MidErpItem(String midErpItemId, String version, Date calYear, Short calyear, String orgName, String compCode,
			String assetMainNumber, String assetSubnumber, String equipementNumber, String currency, String largeClass,
			String mediumClass, String smallClass, String voltageLevel, Double quantity, String unit,
			Double originalValue, Double netValue, String assetStatus, String profitEnterSecLevelUnit,
			String costControlArea, String assetDescription, String projectType, Date capitalizationDate,
			Date deliveryDate, Date manufactureDate, Double lineLength, String lengthUnit, Double transformerCapacity,
			String capacityUnit, String warehouseAddress, String sparePartMark, String reusingDeviceMark,
			Date reusingEntryDate, Date reusingOutDate, String discardProjectResourceCode, String discardReasonCode,
			Date discardAccountingDate, String equipmentStatus, String equipmentVoltageLevel, String isCustody,
			String manufacturerCard, String manufacturerEquipement, String manufactureState,
			String manufacturePartNumber, String inactivityDate, String assetCategory, String cardSerialNumber,
			String cardInventoryNumber, String cardAssetUnit, String cardStorageUnit, String cardCostCenter,
			String cardAssetManageDepart, String cardUsingCustodian, String cardCarLicense,
			String costCenterAuxilAccounting, String donationType, String superviseSign, String assetUsingInformation,
			String assetIncreaseMethod, String assetChangeMode, String assetOrigin, String engineeringProperty,
			String fixedAssetClass, String cardWbsElement, String cardWbsElementDesc, String assetStorageAddress,
			String lineStationName, String housePropCertifiNum, String equipementName, String technicalObjectType,
			String authorizationGroup, String equipSpecificationModel, String equipNameplateNumber,
			String maintenanceFactory, String equipAssetChangeMode, String factoryArea, String abcIdentification,
			String classifiedField, String equipmentCostCenter, String equipmentWbsElement, String equipWbsElementDesc,
			String planFactory, String planGroup, String mainWorkCenter, String functionalPosition,
			String advancedEquipment, String techIdentificationNumber, String equipUseCustodian,
			String equipStorageDepartment, String equipObjectManageDeparment, String epqipmentIncreaseMethod,
			String equipmentSotrageAddress, String equipCarLicense, String equipHousePropCertifiNum,
			String lineStationLogo, String discardOriginProjectDesc, String discardReasonContent, Date dataExtractDate,
			Date dataExtractTime, String dataExtractPerson, String assetProperty, String propertyCode, String pmunr,
			String assetId, String assetVoltagelevel) {
		super(midErpItemId, version, calYear, calyear, orgName, compCode, assetMainNumber, assetSubnumber,
				equipementNumber, currency, largeClass, mediumClass, smallClass, voltageLevel, quantity, unit,
				originalValue, netValue, assetStatus, profitEnterSecLevelUnit, costControlArea, assetDescription,
				projectType, capitalizationDate, deliveryDate, manufactureDate, lineLength, lengthUnit,
				transformerCapacity, capacityUnit, warehouseAddress, sparePartMark, reusingDeviceMark, reusingEntryDate,
				reusingOutDate, discardProjectResourceCode, discardReasonCode, discardAccountingDate, equipmentStatus,
				equipmentVoltageLevel, isCustody, manufacturerCard, manufacturerEquipement, manufactureState,
				manufacturePartNumber, inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber,
				cardAssetUnit, cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian,
				cardCarLicense, costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
				assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass, cardWbsElement,
				cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum, equipementName,
				technicalObjectType, authorizationGroup, equipSpecificationModel, equipNameplateNumber,
				maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification, classifiedField,
				equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory, planGroup, mainWorkCenter,
				functionalPosition, advancedEquipment, techIdentificationNumber, equipUseCustodian,
				equipStorageDepartment, equipObjectManageDeparment, epqipmentIncreaseMethod, equipmentSotrageAddress,
				equipCarLicense, equipHousePropCertifiNum, lineStationLogo, discardOriginProjectDesc,
				discardReasonContent, dataExtractDate, dataExtractTime, dataExtractPerson, assetProperty, propertyCode,
				pmunr, assetId, assetVoltagelevel);
	}
}
