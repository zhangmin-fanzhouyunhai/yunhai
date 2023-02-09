package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidErpItemOld20199 entity provides the base persistence definition of
 * the MidErpItemOld20199 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidErpItemOld20199 implements java.io.Serializable {

	// Fields

	private String midErpItemId;
	private String version;
	private Date calYear;
	private Long dwdm;
	private String orgName;
	private String zcDl;
	private String zcZl;
	private String zcXl;
	private Short calyear;
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
	private Date capitalizationDate;
	private Date deliveryDate;
	private Date manufactureDate;
	private Double lineLength;
	private String lengthUnit;
	private Double transformerCapacity;
	private String capacityUnit;
	private String warehouseAddress;
	private String sparePartMark;
	private String reusingDeviceMark;
	private Date reusingEntryDate;
	private Date reusingOutDate;
	private String discardProjectResourceCode;
	private String discardReasonCode;
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
	private String equipmentIncreaseMethod;
	private String equipmentSotrageAddress;
	private String equipCarLicense;
	private String equipHousePropCertifiNum;
	private String lineStationLogo;
	private String discardOriginProjectDesc;
	private String discardReasonContent;
	private Date dataExtractDate;
	private Date dataExtractTime;
	private String dataExtractPerson;
	private String assetProperty;
	private String propertyCode;
	private String pmunr;
	private String assetId;
	private String assetVoltageLevel;
	private String oldVoltageLevel;
	private String oldAssetProperty;
	private String oldPropertyCode;
	private Long calYear1;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidErpItemOld20199() {
	}

	/** minimal constructor */
	public AbstractMidErpItemOld20199(String midErpItemId, String version, Date calYear) {
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractMidErpItemOld20199(String midErpItemId, String version, Date calYear, Long dwdm, String orgName,
			String zcDl, String zcZl, String zcXl, Short calyear, String compCode, String assetMainNumber,
			String assetSubnumber, String equipementNumber, String currency, String largeClass, String mediumClass,
			String smallClass, String voltageLevel, Double quantity, String unit, Double originalValue, Double netValue,
			String assetStatus, String profitEnterSecLevelUnit, String costControlArea, String assetDescription,
			String projectType, Date capitalizationDate, Date deliveryDate, Date manufactureDate,
			Double lineLength, String lengthUnit, Double transformerCapacity, String capacityUnit,
			String warehouseAddress, String sparePartMark, String reusingDeviceMark, Date reusingEntryDate,
			Date reusingOutDate, String discardProjectResourceCode, String discardReasonCode,
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
			String equipStorageDepartment, String equipObjectManageDeparment, String equipmentIncreaseMethod,
			String equipmentSotrageAddress, String equipCarLicense, String equipHousePropCertifiNum,
			String lineStationLogo, String discardOriginProjectDesc, String discardReasonContent,
			Date dataExtractDate, Date dataExtractTime, String dataExtractPerson, String assetProperty,
			String propertyCode, String pmunr, String assetId, String assetVoltageLevel, String oldVoltageLevel,
			String oldAssetProperty, String oldPropertyCode, Long calYear1, Date dvDateValue, String category) {
		this.midErpItemId = midErpItemId;
		this.version = version;
		this.calYear = calYear;
		this.dwdm = dwdm;
		this.orgName = orgName;
		this.zcDl = zcDl;
		this.zcZl = zcZl;
		this.zcXl = zcXl;
		this.calyear = calyear;
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
		this.equipmentIncreaseMethod = equipmentIncreaseMethod;
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
		this.assetVoltageLevel = assetVoltageLevel;
		this.oldVoltageLevel = oldVoltageLevel;
		this.oldAssetProperty = oldAssetProperty;
		this.oldPropertyCode = oldPropertyCode;
		this.calYear1 = calYear1;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidErpItemId() {
		return this.midErpItemId;
	}

	public void setMidErpItemId(String midErpItemId) {
		this.midErpItemId = midErpItemId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public Long getDwdm() {
		return this.dwdm;
	}

	public void setDwdm(Long dwdm) {
		this.dwdm = dwdm;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getZcDl() {
		return this.zcDl;
	}

	public void setZcDl(String zcDl) {
		this.zcDl = zcDl;
	}

	public String getZcZl() {
		return this.zcZl;
	}

	public void setZcZl(String zcZl) {
		this.zcZl = zcZl;
	}

	public String getZcXl() {
		return this.zcXl;
	}

	public void setZcXl(String zcXl) {
		this.zcXl = zcXl;
	}

	public Short getCalyear() {
		return this.calyear;
	}

	public void setCalyear(Short calyear) {
		this.calyear = calyear;
	}

	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getAssetMainNumber() {
		return this.assetMainNumber;
	}

	public void setAssetMainNumber(String assetMainNumber) {
		this.assetMainNumber = assetMainNumber;
	}

	public String getAssetSubnumber() {
		return this.assetSubnumber;
	}

	public void setAssetSubnumber(String assetSubnumber) {
		this.assetSubnumber = assetSubnumber;
	}

	public String getEquipementNumber() {
		return this.equipementNumber;
	}

	public void setEquipementNumber(String equipementNumber) {
		this.equipementNumber = equipementNumber;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLargeClass() {
		return this.largeClass;
	}

	public void setLargeClass(String largeClass) {
		this.largeClass = largeClass;
	}

	public String getMediumClass() {
		return this.mediumClass;
	}

	public void setMediumClass(String mediumClass) {
		this.mediumClass = mediumClass;
	}

	public String getSmallClass() {
		return this.smallClass;
	}

	public void setSmallClass(String smallClass) {
		this.smallClass = smallClass;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getProfitEnterSecLevelUnit() {
		return this.profitEnterSecLevelUnit;
	}

	public void setProfitEnterSecLevelUnit(String profitEnterSecLevelUnit) {
		this.profitEnterSecLevelUnit = profitEnterSecLevelUnit;
	}

	public String getCostControlArea() {
		return this.costControlArea;
	}

	public void setCostControlArea(String costControlArea) {
		this.costControlArea = costControlArea;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Double getLineLength() {
		return this.lineLength;
	}

	public void setLineLength(Double lineLength) {
		this.lineLength = lineLength;
	}

	public String getLengthUnit() {
		return this.lengthUnit;
	}

	public void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public Double getTransformerCapacity() {
		return this.transformerCapacity;
	}

	public void setTransformerCapacity(Double transformerCapacity) {
		this.transformerCapacity = transformerCapacity;
	}

	public String getCapacityUnit() {
		return this.capacityUnit;
	}

	public void setCapacityUnit(String capacityUnit) {
		this.capacityUnit = capacityUnit;
	}

	public String getWarehouseAddress() {
		return this.warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getSparePartMark() {
		return this.sparePartMark;
	}

	public void setSparePartMark(String sparePartMark) {
		this.sparePartMark = sparePartMark;
	}

	public String getReusingDeviceMark() {
		return this.reusingDeviceMark;
	}

	public void setReusingDeviceMark(String reusingDeviceMark) {
		this.reusingDeviceMark = reusingDeviceMark;
	}

	public Date getReusingEntryDate() {
		return this.reusingEntryDate;
	}

	public void setReusingEntryDate(Date reusingEntryDate) {
		this.reusingEntryDate = reusingEntryDate;
	}

	public Date getReusingOutDate() {
		return this.reusingOutDate;
	}

	public void setReusingOutDate(Date reusingOutDate) {
		this.reusingOutDate = reusingOutDate;
	}

	public String getDiscardProjectResourceCode() {
		return this.discardProjectResourceCode;
	}

	public void setDiscardProjectResourceCode(String discardProjectResourceCode) {
		this.discardProjectResourceCode = discardProjectResourceCode;
	}

	public String getDiscardReasonCode() {
		return this.discardReasonCode;
	}

	public void setDiscardReasonCode(String discardReasonCode) {
		this.discardReasonCode = discardReasonCode;
	}

	public Date getDiscardAccountingDate() {
		return this.discardAccountingDate;
	}

	public void setDiscardAccountingDate(Date discardAccountingDate) {
		this.discardAccountingDate = discardAccountingDate;
	}

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getEquipmentVoltageLevel() {
		return this.equipmentVoltageLevel;
	}

	public void setEquipmentVoltageLevel(String equipmentVoltageLevel) {
		this.equipmentVoltageLevel = equipmentVoltageLevel;
	}

	public String getIsCustody() {
		return this.isCustody;
	}

	public void setIsCustody(String isCustody) {
		this.isCustody = isCustody;
	}

	public String getManufacturerCard() {
		return this.manufacturerCard;
	}

	public void setManufacturerCard(String manufacturerCard) {
		this.manufacturerCard = manufacturerCard;
	}

	public String getManufacturerEquipement() {
		return this.manufacturerEquipement;
	}

	public void setManufacturerEquipement(String manufacturerEquipement) {
		this.manufacturerEquipement = manufacturerEquipement;
	}

	public String getManufactureState() {
		return this.manufactureState;
	}

	public void setManufactureState(String manufactureState) {
		this.manufactureState = manufactureState;
	}

	public String getManufacturePartNumber() {
		return this.manufacturePartNumber;
	}

	public void setManufacturePartNumber(String manufacturePartNumber) {
		this.manufacturePartNumber = manufacturePartNumber;
	}

	public String getInactivityDate() {
		return this.inactivityDate;
	}

	public void setInactivityDate(String inactivityDate) {
		this.inactivityDate = inactivityDate;
	}

	public String getAssetCategory() {
		return this.assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getCardSerialNumber() {
		return this.cardSerialNumber;
	}

	public void setCardSerialNumber(String cardSerialNumber) {
		this.cardSerialNumber = cardSerialNumber;
	}

	public String getCardInventoryNumber() {
		return this.cardInventoryNumber;
	}

	public void setCardInventoryNumber(String cardInventoryNumber) {
		this.cardInventoryNumber = cardInventoryNumber;
	}

	public String getCardAssetUnit() {
		return this.cardAssetUnit;
	}

	public void setCardAssetUnit(String cardAssetUnit) {
		this.cardAssetUnit = cardAssetUnit;
	}

	public String getCardStorageUnit() {
		return this.cardStorageUnit;
	}

	public void setCardStorageUnit(String cardStorageUnit) {
		this.cardStorageUnit = cardStorageUnit;
	}

	public String getCardCostCenter() {
		return this.cardCostCenter;
	}

	public void setCardCostCenter(String cardCostCenter) {
		this.cardCostCenter = cardCostCenter;
	}

	public String getCardAssetManageDepart() {
		return this.cardAssetManageDepart;
	}

	public void setCardAssetManageDepart(String cardAssetManageDepart) {
		this.cardAssetManageDepart = cardAssetManageDepart;
	}

	public String getCardUsingCustodian() {
		return this.cardUsingCustodian;
	}

	public void setCardUsingCustodian(String cardUsingCustodian) {
		this.cardUsingCustodian = cardUsingCustodian;
	}

	public String getCardCarLicense() {
		return this.cardCarLicense;
	}

	public void setCardCarLicense(String cardCarLicense) {
		this.cardCarLicense = cardCarLicense;
	}

	public String getCostCenterAuxilAccounting() {
		return this.costCenterAuxilAccounting;
	}

	public void setCostCenterAuxilAccounting(String costCenterAuxilAccounting) {
		this.costCenterAuxilAccounting = costCenterAuxilAccounting;
	}

	public String getDonationType() {
		return this.donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getSuperviseSign() {
		return this.superviseSign;
	}

	public void setSuperviseSign(String superviseSign) {
		this.superviseSign = superviseSign;
	}

	public String getAssetUsingInformation() {
		return this.assetUsingInformation;
	}

	public void setAssetUsingInformation(String assetUsingInformation) {
		this.assetUsingInformation = assetUsingInformation;
	}

	public String getAssetIncreaseMethod() {
		return this.assetIncreaseMethod;
	}

	public void setAssetIncreaseMethod(String assetIncreaseMethod) {
		this.assetIncreaseMethod = assetIncreaseMethod;
	}

	public String getAssetChangeMode() {
		return this.assetChangeMode;
	}

	public void setAssetChangeMode(String assetChangeMode) {
		this.assetChangeMode = assetChangeMode;
	}

	public String getAssetOrigin() {
		return this.assetOrigin;
	}

	public void setAssetOrigin(String assetOrigin) {
		this.assetOrigin = assetOrigin;
	}

	public String getEngineeringProperty() {
		return this.engineeringProperty;
	}

	public void setEngineeringProperty(String engineeringProperty) {
		this.engineeringProperty = engineeringProperty;
	}

	public String getFixedAssetClass() {
		return this.fixedAssetClass;
	}

	public void setFixedAssetClass(String fixedAssetClass) {
		this.fixedAssetClass = fixedAssetClass;
	}

	public String getCardWbsElement() {
		return this.cardWbsElement;
	}

	public void setCardWbsElement(String cardWbsElement) {
		this.cardWbsElement = cardWbsElement;
	}

	public String getCardWbsElementDesc() {
		return this.cardWbsElementDesc;
	}

	public void setCardWbsElementDesc(String cardWbsElementDesc) {
		this.cardWbsElementDesc = cardWbsElementDesc;
	}

	public String getAssetStorageAddress() {
		return this.assetStorageAddress;
	}

	public void setAssetStorageAddress(String assetStorageAddress) {
		this.assetStorageAddress = assetStorageAddress;
	}

	public String getLineStationName() {
		return this.lineStationName;
	}

	public void setLineStationName(String lineStationName) {
		this.lineStationName = lineStationName;
	}

	public String getHousePropCertifiNum() {
		return this.housePropCertifiNum;
	}

	public void setHousePropCertifiNum(String housePropCertifiNum) {
		this.housePropCertifiNum = housePropCertifiNum;
	}

	public String getEquipementName() {
		return this.equipementName;
	}

	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}

	public String getTechnicalObjectType() {
		return this.technicalObjectType;
	}

	public void setTechnicalObjectType(String technicalObjectType) {
		this.technicalObjectType = technicalObjectType;
	}

	public String getAuthorizationGroup() {
		return this.authorizationGroup;
	}

	public void setAuthorizationGroup(String authorizationGroup) {
		this.authorizationGroup = authorizationGroup;
	}

	public String getEquipSpecificationModel() {
		return this.equipSpecificationModel;
	}

	public void setEquipSpecificationModel(String equipSpecificationModel) {
		this.equipSpecificationModel = equipSpecificationModel;
	}

	public String getEquipNameplateNumber() {
		return this.equipNameplateNumber;
	}

	public void setEquipNameplateNumber(String equipNameplateNumber) {
		this.equipNameplateNumber = equipNameplateNumber;
	}

	public String getMaintenanceFactory() {
		return this.maintenanceFactory;
	}

	public void setMaintenanceFactory(String maintenanceFactory) {
		this.maintenanceFactory = maintenanceFactory;
	}

	public String getEquipAssetChangeMode() {
		return this.equipAssetChangeMode;
	}

	public void setEquipAssetChangeMode(String equipAssetChangeMode) {
		this.equipAssetChangeMode = equipAssetChangeMode;
	}

	public String getFactoryArea() {
		return this.factoryArea;
	}

	public void setFactoryArea(String factoryArea) {
		this.factoryArea = factoryArea;
	}

	public String getAbcIdentification() {
		return this.abcIdentification;
	}

	public void setAbcIdentification(String abcIdentification) {
		this.abcIdentification = abcIdentification;
	}

	public String getClassifiedField() {
		return this.classifiedField;
	}

	public void setClassifiedField(String classifiedField) {
		this.classifiedField = classifiedField;
	}

	public String getEquipmentCostCenter() {
		return this.equipmentCostCenter;
	}

	public void setEquipmentCostCenter(String equipmentCostCenter) {
		this.equipmentCostCenter = equipmentCostCenter;
	}

	public String getEquipmentWbsElement() {
		return this.equipmentWbsElement;
	}

	public void setEquipmentWbsElement(String equipmentWbsElement) {
		this.equipmentWbsElement = equipmentWbsElement;
	}

	public String getEquipWbsElementDesc() {
		return this.equipWbsElementDesc;
	}

	public void setEquipWbsElementDesc(String equipWbsElementDesc) {
		this.equipWbsElementDesc = equipWbsElementDesc;
	}

	public String getPlanFactory() {
		return this.planFactory;
	}

	public void setPlanFactory(String planFactory) {
		this.planFactory = planFactory;
	}

	public String getPlanGroup() {
		return this.planGroup;
	}

	public void setPlanGroup(String planGroup) {
		this.planGroup = planGroup;
	}

	public String getMainWorkCenter() {
		return this.mainWorkCenter;
	}

	public void setMainWorkCenter(String mainWorkCenter) {
		this.mainWorkCenter = mainWorkCenter;
	}

	public String getFunctionalPosition() {
		return this.functionalPosition;
	}

	public void setFunctionalPosition(String functionalPosition) {
		this.functionalPosition = functionalPosition;
	}

	public String getAdvancedEquipment() {
		return this.advancedEquipment;
	}

	public void setAdvancedEquipment(String advancedEquipment) {
		this.advancedEquipment = advancedEquipment;
	}

	public String getTechIdentificationNumber() {
		return this.techIdentificationNumber;
	}

	public void setTechIdentificationNumber(String techIdentificationNumber) {
		this.techIdentificationNumber = techIdentificationNumber;
	}

	public String getEquipUseCustodian() {
		return this.equipUseCustodian;
	}

	public void setEquipUseCustodian(String equipUseCustodian) {
		this.equipUseCustodian = equipUseCustodian;
	}

	public String getEquipStorageDepartment() {
		return this.equipStorageDepartment;
	}

	public void setEquipStorageDepartment(String equipStorageDepartment) {
		this.equipStorageDepartment = equipStorageDepartment;
	}

	public String getEquipObjectManageDeparment() {
		return this.equipObjectManageDeparment;
	}

	public void setEquipObjectManageDeparment(String equipObjectManageDeparment) {
		this.equipObjectManageDeparment = equipObjectManageDeparment;
	}

	public String getEquipmentIncreaseMethod() {
		return this.equipmentIncreaseMethod;
	}

	public void setEquipmentIncreaseMethod(String equipmentIncreaseMethod) {
		this.equipmentIncreaseMethod = equipmentIncreaseMethod;
	}

	public String getEquipmentSotrageAddress() {
		return this.equipmentSotrageAddress;
	}

	public void setEquipmentSotrageAddress(String equipmentSotrageAddress) {
		this.equipmentSotrageAddress = equipmentSotrageAddress;
	}

	public String getEquipCarLicense() {
		return this.equipCarLicense;
	}

	public void setEquipCarLicense(String equipCarLicense) {
		this.equipCarLicense = equipCarLicense;
	}

	public String getEquipHousePropCertifiNum() {
		return this.equipHousePropCertifiNum;
	}

	public void setEquipHousePropCertifiNum(String equipHousePropCertifiNum) {
		this.equipHousePropCertifiNum = equipHousePropCertifiNum;
	}

	public String getLineStationLogo() {
		return this.lineStationLogo;
	}

	public void setLineStationLogo(String lineStationLogo) {
		this.lineStationLogo = lineStationLogo;
	}

	public String getDiscardOriginProjectDesc() {
		return this.discardOriginProjectDesc;
	}

	public void setDiscardOriginProjectDesc(String discardOriginProjectDesc) {
		this.discardOriginProjectDesc = discardOriginProjectDesc;
	}

	public String getDiscardReasonContent() {
		return this.discardReasonContent;
	}

	public void setDiscardReasonContent(String discardReasonContent) {
		this.discardReasonContent = discardReasonContent;
	}

	public Date getDataExtractDate() {
		return this.dataExtractDate;
	}

	public void setDataExtractDate(Date dataExtractDate) {
		this.dataExtractDate = dataExtractDate;
	}

	public Date getDataExtractTime() {
		return this.dataExtractTime;
	}

	public void setDataExtractTime(Date dataExtractTime) {
		this.dataExtractTime = dataExtractTime;
	}

	public String getDataExtractPerson() {
		return this.dataExtractPerson;
	}

	public void setDataExtractPerson(String dataExtractPerson) {
		this.dataExtractPerson = dataExtractPerson;
	}

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPmunr() {
		return this.pmunr;
	}

	public void setPmunr(String pmunr) {
		this.pmunr = pmunr;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetVoltageLevel() {
		return this.assetVoltageLevel;
	}

	public void setAssetVoltageLevel(String assetVoltageLevel) {
		this.assetVoltageLevel = assetVoltageLevel;
	}

	public String getOldVoltageLevel() {
		return this.oldVoltageLevel;
	}

	public void setOldVoltageLevel(String oldVoltageLevel) {
		this.oldVoltageLevel = oldVoltageLevel;
	}

	public String getOldAssetProperty() {
		return this.oldAssetProperty;
	}

	public void setOldAssetProperty(String oldAssetProperty) {
		this.oldAssetProperty = oldAssetProperty;
	}

	public String getOldPropertyCode() {
		return this.oldPropertyCode;
	}

	public void setOldPropertyCode(String oldPropertyCode) {
		this.oldPropertyCode = oldPropertyCode;
	}

	public Long getCalYear1() {
		return this.calYear1;
	}

	public void setCalYear1(Long calYear1) {
		this.calYear1 = calYear1;
	}

	public Date getDvDateValue() {
		return this.dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}