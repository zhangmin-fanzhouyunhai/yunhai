package com.yunhai.excel.orm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AbstractMidErpItem entity provides the base persistence definition of the
 * MidErpItem entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidErpItem implements java.io.Serializable {

	// Fields
	private String midErpItemId;
	private String version;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date calYear;
	private Short calyear;
	private String orgName;
	private String compCode;
	private String assetMainNumber;
	private String assetSubnumber;
	private String equipementNumber;
	private String currency;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double quantity;
	private String unit;
	private Double originalValue;
	private Double netValue;
	private String assetStatus;
	private String profitEnterSecLevelUnit;
	private String costControlArea;
	private String assetDescription;
	private String projectType;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date capitalizationDate;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date deliveryDate;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date manufactureDate;
	private Double lineLength;
	private String lengthUnit;
	private Double transformerCapacity;
	private String capacityUnit;
	private String warehouseAddress;
	private String sparePartMark;
	private String reusingDeviceMark;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date reusingEntryDate;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date reusingOutDate;
	private String discardProjectResourceCode;
	private String discardReasonCode;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date discardAccountingDate;
	private String equipmentStatus;
	private String equipmentVoltageLevel;
	private String isCustody;
	private String manufacturerCard;
	private String manufacturerEquipement;
	private String manufactureState;
	private String manufacturePartNumber;
	private String inactivityDate;
	private String assetCategory;
	private String cardSerialNumber;
	private String cardInventoryNumber;
	private String cardAssetUnit;
	private String cardStorageUnit;
	private String cardCostCenter;
	private String cardAssetManageDepart;
	private String cardUsingCustodian;
	private String cardCarLicense;
	private String costCenterAuxilAccounting;
	private String donationType;
	private String superviseSign;
	private String assetUsingInformation;
	private String assetIncreaseMethod;
	private String assetChangeMode;
	private String assetOrigin;
	private String engineeringProperty;
	private String fixedAssetClass;
	private String cardWbsElement;
	private String cardWbsElementDesc;
	private String assetStorageAddress;
	private String lineStationName;
	private String housePropCertifiNum;
	private String equipementName;
	private String technicalObjectType;
	private String authorizationGroup;
	private String equipSpecificationModel;
	private String equipNameplateNumber;
	private String maintenanceFactory;
	private String equipAssetChangeMode;
	private String factoryArea;
	private String abcIdentification;
	private String classifiedField;
	private String equipmentCostCenter;
	private String equipmentWbsElement;
	private String equipWbsElementDesc;
	private String planFactory;
	private String planGroup;
	private String mainWorkCenter;
	private String functionalPosition;
	private String advancedEquipment;
	private String techIdentificationNumber;
	private String equipUseCustodian;
	private String equipStorageDepartment;
	private String equipObjectManageDeparment;
	private String epqipmentIncreaseMethod;
	private String equipmentSotrageAddress;
	private String equipCarLicense;
	private String equipHousePropCertifiNum;
	private String lineStationLogo;
	private String discardOriginProjectDesc;
	private String discardReasonContent;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date dataExtractDate;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date dataExtractTime;
	private String dataExtractPerson;
	private String assetProperty;
	private String propertyCode;
	
	

	private String pmunr;
	private String assetId;
	private String assetVoltagelevel;  
	
	/*2020-07-21 添加如下字段变量*/
	private String oldVoltageLevel;
	private String oldAssetProperty;
	private String oldPropertyCode;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.s")
	private Date oldCapitalizationDate;
	
	// Constructors

	public AbstractMidErpItem(String midErpItemId, String version, Date calYear, Short calyear2, String orgName,
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
		super();
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
		calyear = calyear2;
		this.orgName = orgName;
		this.compCode = compCode;
		this.assetMainNumber = assetMainNumber;
		this.assetSubnumber = assetSubnumber;
		this.equipementNumber = equipementNumber;
		this.currency = currency;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.quantity = quantity;
		this.unit = unit;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.assetStatus = assetStatus;
		this.profitEnterSecLevelUnit = profitEnterSecLevelUnit;
		this.costControlArea = costControlArea;
		this.assetDescription = assetDescription;
		this.projectType = projectType;
		this.capitalizationDate = capitalizationDate;
		this.deliveryDate = deliveryDate;
		this.manufactureDate = manufactureDate;
		this.lineLength = lineLength;
		this.lengthUnit = lengthUnit;
		this.transformerCapacity = transformerCapacity;
		this.capacityUnit = capacityUnit;
		this.warehouseAddress = warehouseAddress;
		this.sparePartMark = sparePartMark;
		this.reusingDeviceMark = reusingDeviceMark;
		this.reusingEntryDate = reusingEntryDate;
		this.reusingOutDate = reusingOutDate;
		this.discardProjectResourceCode = discardProjectResourceCode;
		this.discardReasonCode = discardReasonCode;
		this.discardAccountingDate = discardAccountingDate;
		this.equipmentStatus = equipmentStatus;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.isCustody = isCustody;
		this.manufacturerCard = manufacturerCard;
		this.manufacturerEquipement = manufacturerEquipement;
		this.manufactureState = manufactureState;
		this.manufacturePartNumber = manufacturePartNumber;
		this.inactivityDate = inactivityDate;
		this.assetCategory = assetCategory;
		this.cardSerialNumber = cardSerialNumber;
		this.cardInventoryNumber = cardInventoryNumber;
		this.cardAssetUnit = cardAssetUnit;
		this.cardStorageUnit = cardStorageUnit;
		this.cardCostCenter = cardCostCenter;
		this.cardAssetManageDepart = cardAssetManageDepart;
		this.cardUsingCustodian = cardUsingCustodian;
		this.cardCarLicense = cardCarLicense;
		this.costCenterAuxilAccounting = costCenterAuxilAccounting;
		this.donationType = donationType;
		this.superviseSign = superviseSign;
		this.assetUsingInformation = assetUsingInformation;
		this.assetIncreaseMethod = assetIncreaseMethod;
		this.assetChangeMode = assetChangeMode;
		this.assetOrigin = assetOrigin;
		this.engineeringProperty = engineeringProperty;
		this.fixedAssetClass = fixedAssetClass;
		this.cardWbsElement = cardWbsElement;
		this.cardWbsElementDesc = cardWbsElementDesc;
		this.assetStorageAddress = assetStorageAddress;
		this.lineStationName = lineStationName;
		this.housePropCertifiNum = housePropCertifiNum;
		this.equipementName = equipementName;
		this.technicalObjectType = technicalObjectType;
		this.authorizationGroup = authorizationGroup;
		this.equipSpecificationModel = equipSpecificationModel;
		this.equipNameplateNumber = equipNameplateNumber;
		this.maintenanceFactory = maintenanceFactory;
		this.equipAssetChangeMode = equipAssetChangeMode;
		this.factoryArea = factoryArea;
		this.abcIdentification = abcIdentification;
		this.classifiedField = classifiedField;
		this.equipmentCostCenter = equipmentCostCenter;
		this.equipmentWbsElement = equipmentWbsElement;
		this.equipWbsElementDesc = equipWbsElementDesc;
		this.planFactory = planFactory;
		this.planGroup = planGroup;
		this.mainWorkCenter = mainWorkCenter;
		this.functionalPosition = functionalPosition;
		this.advancedEquipment = advancedEquipment;
		this.techIdentificationNumber = techIdentificationNumber;
		this.equipUseCustodian = equipUseCustodian;
		this.equipStorageDepartment = equipStorageDepartment;
		this.equipObjectManageDeparment = equipObjectManageDeparment;
		this.epqipmentIncreaseMethod = epqipmentIncreaseMethod;
		this.equipmentSotrageAddress = equipmentSotrageAddress;
		this.equipCarLicense = equipCarLicense;
		this.equipHousePropCertifiNum = equipHousePropCertifiNum;
		this.lineStationLogo = lineStationLogo;
		this.discardOriginProjectDesc = discardOriginProjectDesc;
		this.discardReasonContent = discardReasonContent;
		this.dataExtractDate = dataExtractDate;
		this.dataExtractTime = dataExtractTime;
		this.dataExtractPerson = dataExtractPerson;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.pmunr = pmunr;
		this.assetId = assetId;
		this.assetVoltagelevel = assetVoltagelevel;
		this.oldVoltageLevel = oldVoltageLevel;
		this.oldAssetProperty = oldAssetProperty;
		this.oldPropertyCode = oldPropertyCode;
		this.oldCapitalizationDate = oldCapitalizationDate;
	}

	/** default constructor */
	public AbstractMidErpItem() {
	}

	/** minimal constructor */
	public AbstractMidErpItem(String midErpItemId, String version, Date calYear) {
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractMidErpItem(String midErpItemId, String version, Date calYear, Short calyear, String orgName,
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
			Date dataExtractTime, String dataExtractPerson, String assetProperty, String propertyCode) {
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
		this.calyear = calyear;
		this.orgName = orgName;
		this.compCode = compCode;
		this.assetMainNumber = assetMainNumber;
		this.assetSubnumber = assetSubnumber;
		this.equipementNumber = equipementNumber;
		this.currency = currency;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.quantity = quantity;
		this.unit = unit;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.assetStatus = assetStatus;
		this.profitEnterSecLevelUnit = profitEnterSecLevelUnit;
		this.costControlArea = costControlArea;
		this.assetDescription = assetDescription;
		this.projectType = projectType;
		this.capitalizationDate = capitalizationDate;
		this.deliveryDate = deliveryDate;
		this.manufactureDate = manufactureDate;
		this.lineLength = lineLength;
		this.lengthUnit = lengthUnit;
		this.transformerCapacity = transformerCapacity;
		this.capacityUnit = capacityUnit;
		this.warehouseAddress = warehouseAddress;
		this.sparePartMark = sparePartMark;
		this.reusingDeviceMark = reusingDeviceMark;
		this.reusingEntryDate = reusingEntryDate;
		this.reusingOutDate = reusingOutDate;
		this.discardProjectResourceCode = discardProjectResourceCode;
		this.discardReasonCode = discardReasonCode;
		this.discardAccountingDate = discardAccountingDate;
		this.equipmentStatus = equipmentStatus;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.isCustody = isCustody;
		this.manufacturerCard = manufacturerCard;
		this.manufacturerEquipement = manufacturerEquipement;
		this.manufactureState = manufactureState;
		this.manufacturePartNumber = manufacturePartNumber;
		this.inactivityDate = inactivityDate;
		this.assetCategory = assetCategory;
		this.cardSerialNumber = cardSerialNumber;
		this.cardInventoryNumber = cardInventoryNumber;
		this.cardAssetUnit = cardAssetUnit;
		this.cardStorageUnit = cardStorageUnit;
		this.cardCostCenter = cardCostCenter;
		this.cardAssetManageDepart = cardAssetManageDepart;
		this.cardUsingCustodian = cardUsingCustodian;
		this.cardCarLicense = cardCarLicense;
		this.costCenterAuxilAccounting = costCenterAuxilAccounting;
		this.donationType = donationType;
		this.superviseSign = superviseSign;
		this.assetUsingInformation = assetUsingInformation;
		this.assetIncreaseMethod = assetIncreaseMethod;
		this.assetChangeMode = assetChangeMode;
		this.assetOrigin = assetOrigin;
		this.engineeringProperty = engineeringProperty;
		this.fixedAssetClass = fixedAssetClass;
		this.cardWbsElement = cardWbsElement;
		this.cardWbsElementDesc = cardWbsElementDesc;
		this.assetStorageAddress = assetStorageAddress;
		this.lineStationName = lineStationName;
		this.housePropCertifiNum = housePropCertifiNum;
		this.equipementName = equipementName;
		this.technicalObjectType = technicalObjectType;
		this.authorizationGroup = authorizationGroup;
		this.equipSpecificationModel = equipSpecificationModel;
		this.equipNameplateNumber = equipNameplateNumber;
		this.maintenanceFactory = maintenanceFactory;
		this.equipAssetChangeMode = equipAssetChangeMode;
		this.factoryArea = factoryArea;
		this.abcIdentification = abcIdentification;
		this.classifiedField = classifiedField;
		this.equipmentCostCenter = equipmentCostCenter;
		this.equipmentWbsElement = equipmentWbsElement;
		this.equipWbsElementDesc = equipWbsElementDesc;
		this.planFactory = planFactory;
		this.planGroup = planGroup;
		this.mainWorkCenter = mainWorkCenter;
		this.functionalPosition = functionalPosition;
		this.advancedEquipment = advancedEquipment;
		this.techIdentificationNumber = techIdentificationNumber;
		this.equipUseCustodian = equipUseCustodian;
		this.equipStorageDepartment = equipStorageDepartment;
		this.equipObjectManageDeparment = equipObjectManageDeparment;
		this.epqipmentIncreaseMethod = epqipmentIncreaseMethod;
		this.equipmentSotrageAddress = equipmentSotrageAddress;
		this.equipCarLicense = equipCarLicense;
		this.equipHousePropCertifiNum = equipHousePropCertifiNum;
		this.lineStationLogo = lineStationLogo;
		this.discardOriginProjectDesc = discardOriginProjectDesc;
		this.discardReasonContent = discardReasonContent;
		this.dataExtractDate = dataExtractDate;
		this.dataExtractTime = dataExtractTime;
		this.dataExtractPerson = dataExtractPerson;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
	}

	/** full constructor  20200527*/
	public AbstractMidErpItem(String midErpItemId, String version, Date calYear, Short calyear, String orgName,
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
			String assetId, String assetVoltagelevel) {
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
		this.calyear = calyear;
		this.orgName = orgName;
		this.compCode = compCode;
		this.assetMainNumber = assetMainNumber;
		this.assetSubnumber = assetSubnumber;
		this.equipementNumber = equipementNumber;
		this.currency = currency;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.quantity = quantity;
		this.unit = unit;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.assetStatus = assetStatus;
		this.profitEnterSecLevelUnit = profitEnterSecLevelUnit;
		this.costControlArea = costControlArea;
		this.assetDescription = assetDescription;
		this.projectType = projectType;
		this.capitalizationDate = capitalizationDate;
		this.deliveryDate = deliveryDate;
		this.manufactureDate = manufactureDate;
		this.lineLength = lineLength;
		this.lengthUnit = lengthUnit;
		this.transformerCapacity = transformerCapacity;
		this.capacityUnit = capacityUnit;
		this.warehouseAddress = warehouseAddress;
		this.sparePartMark = sparePartMark;
		this.reusingDeviceMark = reusingDeviceMark;
		this.reusingEntryDate = reusingEntryDate;
		this.reusingOutDate = reusingOutDate;
		this.discardProjectResourceCode = discardProjectResourceCode;
		this.discardReasonCode = discardReasonCode;
		this.discardAccountingDate = discardAccountingDate;
		this.equipmentStatus = equipmentStatus;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.isCustody = isCustody;
		this.manufacturerCard = manufacturerCard;
		this.manufacturerEquipement = manufacturerEquipement;
		this.manufactureState = manufactureState;
		this.manufacturePartNumber = manufacturePartNumber;
		this.inactivityDate = inactivityDate;
		this.assetCategory = assetCategory;
		this.cardSerialNumber = cardSerialNumber;
		this.cardInventoryNumber = cardInventoryNumber;
		this.cardAssetUnit = cardAssetUnit;
		this.cardStorageUnit = cardStorageUnit;
		this.cardCostCenter = cardCostCenter;
		this.cardAssetManageDepart = cardAssetManageDepart;
		this.cardUsingCustodian = cardUsingCustodian;
		this.cardCarLicense = cardCarLicense;
		this.costCenterAuxilAccounting = costCenterAuxilAccounting;
		this.donationType = donationType;
		this.superviseSign = superviseSign;
		this.assetUsingInformation = assetUsingInformation;
		this.assetIncreaseMethod = assetIncreaseMethod;
		this.assetChangeMode = assetChangeMode;
		this.assetOrigin = assetOrigin;
		this.engineeringProperty = engineeringProperty;
		this.fixedAssetClass = fixedAssetClass;
		this.cardWbsElement = cardWbsElement;
		this.cardWbsElementDesc = cardWbsElementDesc;
		this.assetStorageAddress = assetStorageAddress;
		this.lineStationName = lineStationName;
		this.housePropCertifiNum = housePropCertifiNum;
		this.equipementName = equipementName;
		this.technicalObjectType = technicalObjectType;
		this.authorizationGroup = authorizationGroup;
		this.equipSpecificationModel = equipSpecificationModel;
		this.equipNameplateNumber = equipNameplateNumber;
		this.maintenanceFactory = maintenanceFactory;
		this.equipAssetChangeMode = equipAssetChangeMode;
		this.factoryArea = factoryArea;
		this.abcIdentification = abcIdentification;
		this.classifiedField = classifiedField;
		this.equipmentCostCenter = equipmentCostCenter;
		this.equipmentWbsElement = equipmentWbsElement;
		this.equipWbsElementDesc = equipWbsElementDesc;
		this.planFactory = planFactory;
		this.planGroup = planGroup;
		this.mainWorkCenter = mainWorkCenter;
		this.functionalPosition = functionalPosition;
		this.advancedEquipment = advancedEquipment;
		this.techIdentificationNumber = techIdentificationNumber;
		this.equipUseCustodian = equipUseCustodian;
		this.equipStorageDepartment = equipStorageDepartment;
		this.equipObjectManageDeparment = equipObjectManageDeparment;
		this.epqipmentIncreaseMethod = epqipmentIncreaseMethod;
		this.equipmentSotrageAddress = equipmentSotrageAddress;
		this.equipCarLicense = equipCarLicense;
		this.equipHousePropCertifiNum = equipHousePropCertifiNum;
		this.lineStationLogo = lineStationLogo;
		this.discardOriginProjectDesc = discardOriginProjectDesc;
		this.discardReasonContent = discardReasonContent;
		this.dataExtractDate = dataExtractDate;
		this.dataExtractTime = dataExtractTime;
		this.dataExtractPerson = dataExtractPerson;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.pmunr = pmunr;
		this.assetId = assetId;
		this.assetVoltagelevel = assetVoltagelevel;
	}

	// Property accessors

	public String getMidErpItemId() {
		return this.midErpItemId;
	}

	public String getOldVoltageLevel() {
		return oldVoltageLevel;
	}

	@JSONField(name="OLD_VOLTAGE_LEVEL")
	public void setOldVoltageLevel(String oldVoltageLevel) {
		this.oldVoltageLevel = oldVoltageLevel;
	}

	public String getOldAssetProperty() {
		return oldAssetProperty;
	}

	@JSONField(name="OLD_ASSET_PROPERTY")
	public void setOldAssetProperty(String oldAssetProperty) {
		this.oldAssetProperty = oldAssetProperty;
	}

	public String getOldPropertyCode() {
		return oldPropertyCode;
	}

	@JSONField(name="OLD_PROPERTY_CODE")
	public void setOldPropertyCode(String oldPropertyCode) {
		this.oldPropertyCode = oldPropertyCode;
	}

	public Date getOldCapitalizationDate() {
		return oldCapitalizationDate;
	}

	@JSONField(name="OLD_CAPITALIZATION_DATE")
	public void setOldCapitalizationDate(Date oldCapitalizationDate) {
		this.oldCapitalizationDate = oldCapitalizationDate;
	}

	public String getPmunr() {
		return pmunr;
	}

	@JSONField(name="PMUNR")
	public void setPmunr(String pmunr) {
		this.pmunr = pmunr;
	}

	public String getAssetId() {
		return assetId;
	}

	@JSONField(name="ASSET_ID")
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetVoltagelevel() {
		return assetVoltagelevel;
	}

	@JSONField(name="ASSET_VOLTAGE_LEVEL")
	public void setAssetVoltagelevel(String assetVoltagelevel) {
		this.assetVoltagelevel = assetVoltagelevel;
	}

	@JSONField(name="MID_ERP_ITEM_ID")
	public void setMidErpItemId(String midErpItemId) {
		this.midErpItemId = midErpItemId;
	}

	public String getVersion() {
		return this.version;
	}

	@JSONField(name="DATA_VERSION")
	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	@JSONField(name="CAL_YEAR")
	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public Short getCalyear() {
		return this.calyear;
	}

	@JSONField(name="CALYEAR")
	public void setCalyear(Short calyear) {
		this.calyear = calyear;
	}

	public String getOrgName() {
		return this.orgName;
	}

	@JSONField(name="ORG_NAME")
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCompCode() {
		return this.compCode;
	}

	@JSONField(name="COMP_CODE")
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getAssetMainNumber() {
		return this.assetMainNumber;
	}

	@JSONField(name="ASSET_MAIN_NUMBER")
	public void setAssetMainNumber(String assetMainNumber) {
		this.assetMainNumber = assetMainNumber;
	}

	public String getAssetSubnumber() {
		return this.assetSubnumber;
	}

	@JSONField(name="ASSET_SUBNUMBER")
	public void setAssetSubnumber(String assetSubnumber) {
		this.assetSubnumber = assetSubnumber;
	}

	public String getEquipementNumber() {
		return this.equipementNumber;
	}

	@JSONField(name="EQUIPEMENT_NUMBER")
	public void setEquipementNumber(String equipementNumber) {
		this.equipementNumber = equipementNumber;
	}

	public String getCurrency() {
		return this.currency;
	}

	@JSONField(name="CURRENCY")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLargeClass() {
		return this.largeClass;
	}

	@JSONField(name="LARGE_CLASS")
	public void setLargeClass(String largeClass) {
		this.largeClass = largeClass;
	}

	public String getMediumClass() {
		return this.mediumClass;
	}

	@JSONField(name="MEDIUM_CLASS")
	public void setMediumClass(String mediumClass) {
		this.mediumClass = mediumClass;
	}

	public String getSmallClass() {
		return this.smallClass;
	}

	@JSONField(name="SMALL_CLASS")
	public void setSmallClass(String smallClass) {
		this.smallClass = smallClass;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	@JSONField(name="VOLTAGE_LEVEL")
	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	@JSONField(name="QUANTITY")
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	@JSONField(name="UNIT")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}
	
	@JSONField(name="ORIGINAL_VALUE")
	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	@JSONField(name="NET_VALUE")
	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getAssetStatus() {
		return this.assetStatus;
	}

	@JSONField(name="ASSET_STATUS")
	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getProfitEnterSecLevelUnit() {
		return this.profitEnterSecLevelUnit;
	}

	@JSONField(name="PROFIT_ENTER_SEC_LEVEL_UNIT")
	public void setProfitEnterSecLevelUnit(String profitEnterSecLevelUnit) {
		this.profitEnterSecLevelUnit = profitEnterSecLevelUnit;
	}

	public String getCostControlArea() {
		return this.costControlArea;
	}

	@JSONField(name="COST_CONTROL_AREA")
	public void setCostControlArea(String costControlArea) {
		this.costControlArea = costControlArea;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	@JSONField(name="ASSET_DESCRIPTION")
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getProjectType() {
		return this.projectType;
	}

	@JSONField(name="PROJECT_TYPE")
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	@JSONField(name="CAPITALIZATION_DATE")
	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	@JSONField(name="DELIVERY_DATE")
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	@JSONField(name="MANUFACTURE_DATE")
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Double getLineLength() {
		return this.lineLength;
	}

	@JSONField(name="LINE_LENGTH")
	public void setLineLength(Double lineLength) {
		this.lineLength = lineLength;
	}

	public String getLengthUnit() {
		return this.lengthUnit;
	}

	@JSONField(name="LENGTH_UNIT")
	public void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public Double getTransformerCapacity() {
		return this.transformerCapacity;
	}

	@JSONField(name="TRANSFORMER_CAPACITY")
	public void setTransformerCapacity(Double transformerCapacity) {
		this.transformerCapacity = transformerCapacity;
	}

	public String getCapacityUnit() {
		return this.capacityUnit;
	}

	@JSONField(name="CAPACITY_UNIT")
	public void setCapacityUnit(String capacityUnit) {
		this.capacityUnit = capacityUnit;
	}

	public String getWarehouseAddress() {
		return this.warehouseAddress;
	}

	@JSONField(name="WAREHOUSE_ADDRESS")
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getSparePartMark() {
		return this.sparePartMark;
	}

	@JSONField(name="SPARE_PART_MARK")
	public void setSparePartMark(String sparePartMark) {
		this.sparePartMark = sparePartMark;
	}

	public String getReusingDeviceMark() {
		return this.reusingDeviceMark;
	}

	@JSONField(name="REUSING_DEVICE_MARK")
	public void setReusingDeviceMark(String reusingDeviceMark) {
		this.reusingDeviceMark = reusingDeviceMark;
	}

	public Date getReusingEntryDate() {
		return this.reusingEntryDate;
	}
	@JSONField(name="REUSING_ENTRY_DATE")
	public void setReusingEntryDate(Date reusingEntryDate) {
		this.reusingEntryDate = reusingEntryDate;
	}

	public Date getReusingOutDate() {
		return this.reusingOutDate;
	}

	@JSONField(name="REUSING_OUT_DATE")
	public void setReusingOutDate(Date reusingOutDate) {
		this.reusingOutDate = reusingOutDate;
	}

	public String getDiscardProjectResourceCode() {
		return this.discardProjectResourceCode;
	}

	@JSONField(name="DISCARD_PROJECT_RESOURCE_CODE")
	public void setDiscardProjectResourceCode(String discardProjectResourceCode) {
		this.discardProjectResourceCode = discardProjectResourceCode;
	}

	public String getDiscardReasonCode() {
		return this.discardReasonCode;
	}

	@JSONField(name="DISCARD_REASON_CODE")
	public void setDiscardReasonCode(String discardReasonCode) {
		this.discardReasonCode = discardReasonCode;
	}

	public Date getDiscardAccountingDate() {
		return this.discardAccountingDate;
	}

	@JSONField(name="DISCARD_ACCOUNTING_DATE")
	public void setDiscardAccountingDate(Date discardAccountingDate) {
		this.discardAccountingDate = discardAccountingDate;
	}

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	@JSONField(name="EQUIPMENT_STATUS")
	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getEquipmentVoltageLevel() {
		return this.equipmentVoltageLevel;
	}

	@JSONField(name="EQUIPMENT_VOLTAGE_LEVEL")
	public void setEquipmentVoltageLevel(String equipmentVoltageLevel) {
		this.equipmentVoltageLevel = equipmentVoltageLevel;
	}

	public String getIsCustody() {
		return this.isCustody;
	}

	@JSONField(name="IS_CUSTODY")
	public void setIsCustody(String isCustody) {
		this.isCustody = isCustody;
	}

	public String getManufacturerCard() {
		return this.manufacturerCard;
	}

	@JSONField(name="MANUFACTURER_CARD")
	public void setManufacturerCard(String manufacturerCard) {
		this.manufacturerCard = manufacturerCard;
	}

	public String getManufacturerEquipement() {
		return this.manufacturerEquipement;
	}

	@JSONField(name="MANUFACTURER_EQUIPEMENT")
	public void setManufacturerEquipement(String manufacturerEquipement) {
		this.manufacturerEquipement = manufacturerEquipement;
	}

	public String getManufactureState() {
		return this.manufactureState;
	}

	@JSONField(name="MANUFACTURE_STATE")
	public void setManufactureState(String manufactureState) {
		this.manufactureState = manufactureState;
	}

	public String getManufacturePartNumber() {
		return this.manufacturePartNumber;
	}

	@JSONField(name="MANUFACTURE_PART_NUMBER")
	public void setManufacturePartNumber(String manufacturePartNumber) {
		this.manufacturePartNumber = manufacturePartNumber;
	}

	public String getInactivityDate() {
		return this.inactivityDate;
	}

	@JSONField(name="INACTIVITY_DATE")
	public void setInactivityDate(String inactivityDate) {
		this.inactivityDate = inactivityDate;
	}

	public String getAssetCategory() {
		return this.assetCategory;
	}

	@JSONField(name="ASSET_CATEGORY")
	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getCardSerialNumber() {
		return this.cardSerialNumber;
	}

	@JSONField(name="CARD_SERIAL_NUMBER")
	public void setCardSerialNumber(String cardSerialNumber) {
		this.cardSerialNumber = cardSerialNumber;
	}

	public String getCardInventoryNumber() {
		return this.cardInventoryNumber;
	}

	@JSONField(name="CARD_INVENTORY_NUMBER")
	public void setCardInventoryNumber(String cardInventoryNumber) {
		this.cardInventoryNumber = cardInventoryNumber;
	}

	public String getCardAssetUnit() {
		return this.cardAssetUnit;
	}

	@JSONField(name="CARD_ASSET_UNIT")
	public void setCardAssetUnit(String cardAssetUnit) {
		this.cardAssetUnit = cardAssetUnit;
	}

	public String getCardStorageUnit() {
		return this.cardStorageUnit;
	}

	@JSONField(name="CARD_STORAGE_UNIT")
	public void setCardStorageUnit(String cardStorageUnit) {
		this.cardStorageUnit = cardStorageUnit;
	}

	public String getCardCostCenter() {
		return this.cardCostCenter;
	}

	@JSONField(name="CARD_COST_CENTER")
	public void setCardCostCenter(String cardCostCenter) {
		this.cardCostCenter = cardCostCenter;
	}

	public String getCardAssetManageDepart() {
		return this.cardAssetManageDepart;
	}

	@JSONField(name="CARD_ASSET_MANAGE_DEPART")
	public void setCardAssetManageDepart(String cardAssetManageDepart) {
		this.cardAssetManageDepart = cardAssetManageDepart;
	}

	public String getCardUsingCustodian() {
		return this.cardUsingCustodian;
	}

	@JSONField(name="CARD_USING_CUSTODIAN")
	public void setCardUsingCustodian(String cardUsingCustodian) {
		this.cardUsingCustodian = cardUsingCustodian;
	}

	public String getCardCarLicense() {
		return this.cardCarLicense;
	}

	@JSONField(name="CARD_CAR_LICENSE")
	public void setCardCarLicense(String cardCarLicense) {
		this.cardCarLicense = cardCarLicense;
	}

	public String getCostCenterAuxilAccounting() {
		return this.costCenterAuxilAccounting;
	}

	@JSONField(name="COST_CENTER_AUXIL_ACCOUNTING")
	public void setCostCenterAuxilAccounting(String costCenterAuxilAccounting) {
		this.costCenterAuxilAccounting = costCenterAuxilAccounting;
	}

	public String getDonationType() {
		return this.donationType;
	}

	@JSONField(name="DONATION_TYPE")
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getSuperviseSign() {
		return this.superviseSign;
	}

	@JSONField(name="SUPERVISE_SIGN")
	public void setSuperviseSign(String superviseSign) {
		this.superviseSign = superviseSign;
	}

	public String getAssetUsingInformation() {
		return this.assetUsingInformation;
	}

	@JSONField(name="ASSET_USING_INFORMATION")
	public void setAssetUsingInformation(String assetUsingInformation) {
		this.assetUsingInformation = assetUsingInformation;
	}

	public String getAssetIncreaseMethod() {
		return this.assetIncreaseMethod;
	}

	@JSONField(name="ASSET_INCREASE_METHOD")
	public void setAssetIncreaseMethod(String assetIncreaseMethod) {
		this.assetIncreaseMethod = assetIncreaseMethod;
	}

	public String getAssetChangeMode() {
		return this.assetChangeMode;
	}

	@JSONField(name="ASSET_CHANGE_MODE")
	public void setAssetChangeMode(String assetChangeMode) {
		this.assetChangeMode = assetChangeMode;
	}

	public String getAssetOrigin() {
		return this.assetOrigin;
	}

	@JSONField(name="ASSET_ORIGIN")
	public void setAssetOrigin(String assetOrigin) {
		this.assetOrigin = assetOrigin;
	}

	public String getEngineeringProperty() {
		return this.engineeringProperty;
	}

	@JSONField(name="ENGINEERING_PROPERTY")
	public void setEngineeringProperty(String engineeringProperty) {
		this.engineeringProperty = engineeringProperty;
	}

	public String getFixedAssetClass() {
		return this.fixedAssetClass;
	}

	@JSONField(name="FIXED_ASSET_CLASS")
	public void setFixedAssetClass(String fixedAssetClass) {
		this.fixedAssetClass = fixedAssetClass;
	}

	public String getCardWbsElement() {
		return this.cardWbsElement;
	}

	@JSONField(name="CARD_WBS_ELEMENT")
	public void setCardWbsElement(String cardWbsElement) {
		this.cardWbsElement = cardWbsElement;
	}

	public String getCardWbsElementDesc() {
		return this.cardWbsElementDesc;
	}

	@JSONField(name="CARD_WBS_ELEMENT_DESC")
	public void setCardWbsElementDesc(String cardWbsElementDesc) {
		this.cardWbsElementDesc = cardWbsElementDesc;
	}

	public String getAssetStorageAddress() {
		return this.assetStorageAddress;
	}

	@JSONField(name="ASSET_STORAGE_ADDRESS")
	public void setAssetStorageAddress(String assetStorageAddress) {
		this.assetStorageAddress = assetStorageAddress;
	}

	public String getLineStationName() {
		return this.lineStationName;
	}

	@JSONField(name="LINE_STATION_NAME")
	public void setLineStationName(String lineStationName) {
		this.lineStationName = lineStationName;
	}

	public String getHousePropCertifiNum() {
		return this.housePropCertifiNum;
	}

	@JSONField(name="HOUSE_PROP_CERTIFI_NUM")
	public void setHousePropCertifiNum(String housePropCertifiNum) {
		this.housePropCertifiNum = housePropCertifiNum;
	}

	public String getEquipementName() {
		return this.equipementName;
	}

	@JSONField(name="EQUIPEMENT_NAME")
	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}

	public String getTechnicalObjectType() {
		return this.technicalObjectType;
	}

	@JSONField(name="TECHNICAL_OBJECT_TYPE")
	public void setTechnicalObjectType(String technicalObjectType) {
		this.technicalObjectType = technicalObjectType;
	}

	public String getAuthorizationGroup() {
		return this.authorizationGroup;
	}

	@JSONField(name="AUTHORIZATION_GROUP")
	public void setAuthorizationGroup(String authorizationGroup) {
		this.authorizationGroup = authorizationGroup;
	}

	public String getEquipSpecificationModel() {
		return this.equipSpecificationModel;
	}

	@JSONField(name="EQUIP_SPECIFICATION_MODEL")
	public void setEquipSpecificationModel(String equipSpecificationModel) {
		this.equipSpecificationModel = equipSpecificationModel;
	}

	public String getEquipNameplateNumber() {
		return this.equipNameplateNumber;
	}

	@JSONField(name="EQUIP_NAMEPLATE_NUMBER")
	public void setEquipNameplateNumber(String equipNameplateNumber) {
		this.equipNameplateNumber = equipNameplateNumber;
	}

	public String getMaintenanceFactory() {
		return this.maintenanceFactory;
	}

	@JSONField(name="MAINTENANCE_FACTORY")
	public void setMaintenanceFactory(String maintenanceFactory) {
		this.maintenanceFactory = maintenanceFactory;
	}

	public String getEquipAssetChangeMode() {
		return this.equipAssetChangeMode;
	}

	@JSONField(name="EQUIP_ASSET_CHANGE_MODE")
	public void setEquipAssetChangeMode(String equipAssetChangeMode) {
		this.equipAssetChangeMode = equipAssetChangeMode;
	}

	public String getFactoryArea() {
		return this.factoryArea;
	}

	@JSONField(name="FACTORY_AREA")
	public void setFactoryArea(String factoryArea) {
		this.factoryArea = factoryArea;
	}

	public String getAbcIdentification() {
		return this.abcIdentification;
	}

	@JSONField(name="ABC_IDENTIFICATION")
	public void setAbcIdentification(String abcIdentification) {
		this.abcIdentification = abcIdentification;
	}

	public String getClassifiedField() {
		return this.classifiedField;
	}

	@JSONField(name="CLASSIFIED_FIELD")
	public void setClassifiedField(String classifiedField) {
		this.classifiedField = classifiedField;
	}

	public String getEquipmentCostCenter() {
		return this.equipmentCostCenter;
	}

	@JSONField(name="EQUIPMENT_COST_CENTER")
	public void setEquipmentCostCenter(String equipmentCostCenter) {
		this.equipmentCostCenter = equipmentCostCenter;
	}

	public String getEquipmentWbsElement() {
		return this.equipmentWbsElement;
	}

	@JSONField(name="EQUIPMENT_WBS_ELEMENT")
	public void setEquipmentWbsElement(String equipmentWbsElement) {
		this.equipmentWbsElement = equipmentWbsElement;
	}

	public String getEquipWbsElementDesc() {
		return this.equipWbsElementDesc;
	}

	@JSONField(name="EQUIP_WBS_ELEMENT_DESC")
	public void setEquipWbsElementDesc(String equipWbsElementDesc) {
		this.equipWbsElementDesc = equipWbsElementDesc;
	}

	public String getPlanFactory() {
		return this.planFactory;
	}

	@JSONField(name="PLAN_FACTORY")
	public void setPlanFactory(String planFactory) {
		this.planFactory = planFactory;
	}

	public String getPlanGroup() {
		return this.planGroup;
	}

	@JSONField(name="PLAN_GROUP")
	public void setPlanGroup(String planGroup) {
		this.planGroup = planGroup;
	}

	public String getMainWorkCenter() {
		return this.mainWorkCenter;
	}

	@JSONField(name="MAIN_WORK_CENTER")
	public void setMainWorkCenter(String mainWorkCenter) {
		this.mainWorkCenter = mainWorkCenter;
	}

	public String getFunctionalPosition() {
		return this.functionalPosition;
	}

	@JSONField(name="FUNCTIONAL_POSITION")
	public void setFunctionalPosition(String functionalPosition) {
		this.functionalPosition = functionalPosition;
	}

	public String getAdvancedEquipment() {
		return this.advancedEquipment;
	}

	@JSONField(name="ADVANCED_EQUIPMENT")
	public void setAdvancedEquipment(String advancedEquipment) {
		this.advancedEquipment = advancedEquipment;
	}

	public String getTechIdentificationNumber() {
		return this.techIdentificationNumber;
	}

	@JSONField(name="TECH_IDENTIFICATION_NUMBER")
	public void setTechIdentificationNumber(String techIdentificationNumber) {
		this.techIdentificationNumber = techIdentificationNumber;
	}

	public String getEquipUseCustodian() {
		return this.equipUseCustodian;
	}

	@JSONField(name="EQUIP_USE_CUSTODIAN")
	public void setEquipUseCustodian(String equipUseCustodian) {
		this.equipUseCustodian = equipUseCustodian;
	}

	public String getEquipStorageDepartment() {
		return this.equipStorageDepartment;
	}

	@JSONField(name="EQUIP_STORAGE_DEPARTMENT")
	public void setEquipStorageDepartment(String equipStorageDepartment) {
		this.equipStorageDepartment = equipStorageDepartment;
	}

	public String getEquipObjectManageDeparment() {
		return this.equipObjectManageDeparment;
	}

	@JSONField(name="EQUIP_OBJECT_MANAGE_DEPARMENT")
	public void setEquipObjectManageDeparment(String equipObjectManageDeparment) {
		this.equipObjectManageDeparment = equipObjectManageDeparment;
	}

	public String getEpqipmentIncreaseMethod() {
		return this.epqipmentIncreaseMethod;
	}

	@JSONField(name="EPQIPMENT_INCREASE_METHOD")
	public void setEpqipmentIncreaseMethod(String epqipmentIncreaseMethod) {
		this.epqipmentIncreaseMethod = epqipmentIncreaseMethod;
	}

	public String getEquipmentSotrageAddress() {
		return this.equipmentSotrageAddress;
	}

	@JSONField(name="EQUIPMENT_SOTRAGE_ADDRESS")
	public void setEquipmentSotrageAddress(String equipmentSotrageAddress) {
		this.equipmentSotrageAddress = equipmentSotrageAddress;
	}

	public String getEquipCarLicense() {
		return this.equipCarLicense;
	}

	@JSONField(name="EQUIP_CAR_LICENSE")
	public void setEquipCarLicense(String equipCarLicense) {
		this.equipCarLicense = equipCarLicense;
	}

	public String getEquipHousePropCertifiNum() {
		return this.equipHousePropCertifiNum;
	}

	@JSONField(name="EQUIP_HOUSE_PROP_CERTIFI_NUM")
	public void setEquipHousePropCertifiNum(String equipHousePropCertifiNum) {
		this.equipHousePropCertifiNum = equipHousePropCertifiNum;
	}

	public String getLineStationLogo() {
		return this.lineStationLogo;
	}

	@JSONField(name="LINE_STATION_LOGO")
	public void setLineStationLogo(String lineStationLogo) {
		this.lineStationLogo = lineStationLogo;
	}

	public String getDiscardOriginProjectDesc() {
		return this.discardOriginProjectDesc;
	}

	@JSONField(name="DISCARD_ORIGIN_PROJECT_DESC")
	public void setDiscardOriginProjectDesc(String discardOriginProjectDesc) {
		this.discardOriginProjectDesc = discardOriginProjectDesc;
	}

	public String getDiscardReasonContent() {
		return this.discardReasonContent;
	}

	@JSONField(name="DISCARD_REASON_CONTENT")
	public void setDiscardReasonContent(String discardReasonContent) {
		this.discardReasonContent = discardReasonContent;
	}

	public Date getDataExtractDate() {
		return this.dataExtractDate;
	}

	@JSONField(name="DATA_EXTRACT_DATE")
	public void setDataExtractDate(Date dataExtractDate) {
		this.dataExtractDate = dataExtractDate;
	}

	public Date getDataExtractTime() {
		return this.dataExtractTime;
	}

	@JSONField(name="DATA_EXTRACT_TIME")
	public void setDataExtractTime(Date dataExtractTime) {
		this.dataExtractTime = dataExtractTime;
	}

	public String getDataExtractPerson() {
		return this.dataExtractPerson;
	}

	@JSONField(name="DATA_EXTRACT_PERSON")
	public void setDataExtractPerson(String dataExtractPerson) {
		this.dataExtractPerson = dataExtractPerson;
	}

	public String getAssetProperty() {
		return this.assetProperty;
	}

	@JSONField(name="ASSET_PROPERTY")
	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	@JSONField(name="PROPERTY_CODE")
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

}