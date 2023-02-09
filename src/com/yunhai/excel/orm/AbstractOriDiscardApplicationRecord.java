package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriDiscardApplicationRecord entity provides the base persistence
 * definition of the OriDiscardApplicationRecord entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriDiscardApplicationRecord implements java.io.Serializable {

	// Fields

	private String oriDiscardApplicatRecordId;
	private String dataVersion;
	private Date calYear;
	private String dataSourceFile;
	private String applicationNumber;
	private String creator;
	private String serialNumber;
	private String approvedPerson;
	private String approvalLevel;
	private String approvalStatus;
	private String creationDate;
	private String dateOfSubmission;
	private String endDate;
	private String documentNumber;
	private String equipmentNumber1;
	private String technicalObjectDescription1;
	private String equipment;
	private String technicalObjectDescription2;
	private String importComponentEquipStatus;
	private String importantEquipReferenceVal;
	private String equipmentNumber;
	private String technicalObjectDescription;
	private String masterDeviceStatus;
	private String mainEquipmentReferenceValue;
	private String assetClassification;
	private String assetClassAlias;
	private String assetNumber;
	private String assetDescription;
	private String scrappingReason;
	private String residuValAssetRenewaScheme;
	private String assetRetirementScale;
	private String changeStatus;
	private String assetValueDate;
	private String bookkeepingDate;
	private String involvingPurchaseYear;
	private String originalBookValue;
	private String accumulatedDepreciation;
	private String provisionForImpairment;
	private String netBookValue;
	private String scrapRatio;
	private String scrapOriginalValueAmount;
	private String scrapDepreciation;
	private String preparationForRetention;
	private String estimatedResidualValue;
	private String saleRevenue;
	private String insuranceLiabilityIndemnity;
	private String text;
	private String assignment1;
	private String assignment;
	private String costCenter;
	private String costCenterShortText;
	private String quantity;
	private String measurementBasicUnit;
	private String measureUnitText;
	private String assetManufacturer;
	private String capitalizationDate;
	private String expectedServiceLife;
	private String scheduledMonth;
	private String checkmark;
	private String companyCode;
	private String corporateName;
	private String profitCenter;
	private String longText;
	private String abstract_;
	private String userChineseName;
	private String technicalDataNameNumber;
	private String resiValTreOpiAsseReneSch;
	private String provinCompApprovRequired;
	private String successMark;
	private String approvNodeSelected91Step;
	private String isItVehicleProcess;
	private String businessTypeVehicle;
	private String vehicleType;
	private String vehicleApplicationLevel;
	private String physicalId;
	private String businessType;
	private String provincCompanyApprovalType;
	private String demolitionListNo;
	private String demolitionListLineNumber;

	// Constructors

	/** default constructor */
	public AbstractOriDiscardApplicationRecord() {
	}

	/** minimal constructor */
	public AbstractOriDiscardApplicationRecord(String oriDiscardApplicatRecordId, String dataVersion, Date calYear,
			String dataSourceFile) {
		this.oriDiscardApplicatRecordId = oriDiscardApplicatRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataSourceFile = dataSourceFile;
	}

	/** full constructor */
	public AbstractOriDiscardApplicationRecord(String oriDiscardApplicatRecordId, String dataVersion, Date calYear,
			String dataSourceFile, String applicationNumber, String creator, String serialNumber, String approvedPerson,
			String approvalLevel, String approvalStatus, String creationDate, String dateOfSubmission, String endDate,
			String documentNumber, String equipmentNumber1, String technicalObjectDescription1, String equipment,
			String technicalObjectDescription2, String importComponentEquipStatus, String importantEquipReferenceVal,
			String equipmentNumber, String technicalObjectDescription, String masterDeviceStatus,
			String mainEquipmentReferenceValue, String assetClassification, String assetClassAlias, String assetNumber,
			String assetDescription, String scrappingReason, String residuValAssetRenewaScheme,
			String assetRetirementScale, String changeStatus, String assetValueDate, String bookkeepingDate,
			String involvingPurchaseYear, String originalBookValue, String accumulatedDepreciation,
			String provisionForImpairment, String netBookValue, String scrapRatio, String scrapOriginalValueAmount,
			String scrapDepreciation, String preparationForRetention, String estimatedResidualValue, String saleRevenue,
			String insuranceLiabilityIndemnity, String text, String assignment1, String assignment, String costCenter,
			String costCenterShortText, String quantity, String measurementBasicUnit, String measureUnitText,
			String assetManufacturer, String capitalizationDate, String expectedServiceLife, String scheduledMonth,
			String checkmark, String companyCode, String corporateName, String profitCenter, String longText,
			String abstract_, String userChineseName, String technicalDataNameNumber, String resiValTreOpiAsseReneSch,
			String provinCompApprovRequired, String successMark, String approvNodeSelected91Step,
			String isItVehicleProcess, String businessTypeVehicle, String vehicleType, String vehicleApplicationLevel,
			String physicalId, String businessType, String provincCompanyApprovalType, String demolitionListNo,
			String demolitionListLineNumber) {
		this.oriDiscardApplicatRecordId = oriDiscardApplicatRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataSourceFile = dataSourceFile;
		this.applicationNumber = applicationNumber;
		this.creator = creator;
		this.serialNumber = serialNumber;
		this.approvedPerson = approvedPerson;
		this.approvalLevel = approvalLevel;
		this.approvalStatus = approvalStatus;
		this.creationDate = creationDate;
		this.dateOfSubmission = dateOfSubmission;
		this.endDate = endDate;
		this.documentNumber = documentNumber;
		this.equipmentNumber1 = equipmentNumber1;
		this.technicalObjectDescription1 = technicalObjectDescription1;
		this.equipment = equipment;
		this.technicalObjectDescription2 = technicalObjectDescription2;
		this.importComponentEquipStatus = importComponentEquipStatus;
		this.importantEquipReferenceVal = importantEquipReferenceVal;
		this.equipmentNumber = equipmentNumber;
		this.technicalObjectDescription = technicalObjectDescription;
		this.masterDeviceStatus = masterDeviceStatus;
		this.mainEquipmentReferenceValue = mainEquipmentReferenceValue;
		this.assetClassification = assetClassification;
		this.assetClassAlias = assetClassAlias;
		this.assetNumber = assetNumber;
		this.assetDescription = assetDescription;
		this.scrappingReason = scrappingReason;
		this.residuValAssetRenewaScheme = residuValAssetRenewaScheme;
		this.assetRetirementScale = assetRetirementScale;
		this.changeStatus = changeStatus;
		this.assetValueDate = assetValueDate;
		this.bookkeepingDate = bookkeepingDate;
		this.involvingPurchaseYear = involvingPurchaseYear;
		this.originalBookValue = originalBookValue;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.provisionForImpairment = provisionForImpairment;
		this.netBookValue = netBookValue;
		this.scrapRatio = scrapRatio;
		this.scrapOriginalValueAmount = scrapOriginalValueAmount;
		this.scrapDepreciation = scrapDepreciation;
		this.preparationForRetention = preparationForRetention;
		this.estimatedResidualValue = estimatedResidualValue;
		this.saleRevenue = saleRevenue;
		this.insuranceLiabilityIndemnity = insuranceLiabilityIndemnity;
		this.text = text;
		this.assignment1 = assignment1;
		this.assignment = assignment;
		this.costCenter = costCenter;
		this.costCenterShortText = costCenterShortText;
		this.quantity = quantity;
		this.measurementBasicUnit = measurementBasicUnit;
		this.measureUnitText = measureUnitText;
		this.assetManufacturer = assetManufacturer;
		this.capitalizationDate = capitalizationDate;
		this.expectedServiceLife = expectedServiceLife;
		this.scheduledMonth = scheduledMonth;
		this.checkmark = checkmark;
		this.companyCode = companyCode;
		this.corporateName = corporateName;
		this.profitCenter = profitCenter;
		this.longText = longText;
		this.abstract_ = abstract_;
		this.userChineseName = userChineseName;
		this.technicalDataNameNumber = technicalDataNameNumber;
		this.resiValTreOpiAsseReneSch = resiValTreOpiAsseReneSch;
		this.provinCompApprovRequired = provinCompApprovRequired;
		this.successMark = successMark;
		this.approvNodeSelected91Step = approvNodeSelected91Step;
		this.isItVehicleProcess = isItVehicleProcess;
		this.businessTypeVehicle = businessTypeVehicle;
		this.vehicleType = vehicleType;
		this.vehicleApplicationLevel = vehicleApplicationLevel;
		this.physicalId = physicalId;
		this.businessType = businessType;
		this.provincCompanyApprovalType = provincCompanyApprovalType;
		this.demolitionListNo = demolitionListNo;
		this.demolitionListLineNumber = demolitionListLineNumber;
	}

	// Property accessors

	public String getOriDiscardApplicatRecordId() {
		return this.oriDiscardApplicatRecordId;
	}

	public void setOriDiscardApplicatRecordId(String oriDiscardApplicatRecordId) {
		this.oriDiscardApplicatRecordId = oriDiscardApplicatRecordId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getApplicationNumber() {
		return this.applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getApprovedPerson() {
		return this.approvedPerson;
	}

	public void setApprovedPerson(String approvedPerson) {
		this.approvedPerson = approvedPerson;
	}

	public String getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDateOfSubmission() {
		return this.dateOfSubmission;
	}

	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getEquipmentNumber1() {
		return this.equipmentNumber1;
	}

	public void setEquipmentNumber1(String equipmentNumber1) {
		this.equipmentNumber1 = equipmentNumber1;
	}

	public String getTechnicalObjectDescription1() {
		return this.technicalObjectDescription1;
	}

	public void setTechnicalObjectDescription1(String technicalObjectDescription1) {
		this.technicalObjectDescription1 = technicalObjectDescription1;
	}

	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getTechnicalObjectDescription2() {
		return this.technicalObjectDescription2;
	}

	public void setTechnicalObjectDescription2(String technicalObjectDescription2) {
		this.technicalObjectDescription2 = technicalObjectDescription2;
	}

	public String getImportComponentEquipStatus() {
		return this.importComponentEquipStatus;
	}

	public void setImportComponentEquipStatus(String importComponentEquipStatus) {
		this.importComponentEquipStatus = importComponentEquipStatus;
	}

	public String getImportantEquipReferenceVal() {
		return this.importantEquipReferenceVal;
	}

	public void setImportantEquipReferenceVal(String importantEquipReferenceVal) {
		this.importantEquipReferenceVal = importantEquipReferenceVal;
	}

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getTechnicalObjectDescription() {
		return this.technicalObjectDescription;
	}

	public void setTechnicalObjectDescription(String technicalObjectDescription) {
		this.technicalObjectDescription = technicalObjectDescription;
	}

	public String getMasterDeviceStatus() {
		return this.masterDeviceStatus;
	}

	public void setMasterDeviceStatus(String masterDeviceStatus) {
		this.masterDeviceStatus = masterDeviceStatus;
	}

	public String getMainEquipmentReferenceValue() {
		return this.mainEquipmentReferenceValue;
	}

	public void setMainEquipmentReferenceValue(String mainEquipmentReferenceValue) {
		this.mainEquipmentReferenceValue = mainEquipmentReferenceValue;
	}

	public String getAssetClassification() {
		return this.assetClassification;
	}

	public void setAssetClassification(String assetClassification) {
		this.assetClassification = assetClassification;
	}

	public String getAssetClassAlias() {
		return this.assetClassAlias;
	}

	public void setAssetClassAlias(String assetClassAlias) {
		this.assetClassAlias = assetClassAlias;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getScrappingReason() {
		return this.scrappingReason;
	}

	public void setScrappingReason(String scrappingReason) {
		this.scrappingReason = scrappingReason;
	}

	public String getResiduValAssetRenewaScheme() {
		return this.residuValAssetRenewaScheme;
	}

	public void setResiduValAssetRenewaScheme(String residuValAssetRenewaScheme) {
		this.residuValAssetRenewaScheme = residuValAssetRenewaScheme;
	}

	public String getAssetRetirementScale() {
		return this.assetRetirementScale;
	}

	public void setAssetRetirementScale(String assetRetirementScale) {
		this.assetRetirementScale = assetRetirementScale;
	}

	public String getChangeStatus() {
		return this.changeStatus;
	}

	public void setChangeStatus(String changeStatus) {
		this.changeStatus = changeStatus;
	}

	public String getAssetValueDate() {
		return this.assetValueDate;
	}

	public void setAssetValueDate(String assetValueDate) {
		this.assetValueDate = assetValueDate;
	}

	public String getBookkeepingDate() {
		return this.bookkeepingDate;
	}

	public void setBookkeepingDate(String bookkeepingDate) {
		this.bookkeepingDate = bookkeepingDate;
	}

	public String getInvolvingPurchaseYear() {
		return this.involvingPurchaseYear;
	}

	public void setInvolvingPurchaseYear(String involvingPurchaseYear) {
		this.involvingPurchaseYear = involvingPurchaseYear;
	}

	public String getOriginalBookValue() {
		return this.originalBookValue;
	}

	public void setOriginalBookValue(String originalBookValue) {
		this.originalBookValue = originalBookValue;
	}

	public String getAccumulatedDepreciation() {
		return this.accumulatedDepreciation;
	}

	public void setAccumulatedDepreciation(String accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public String getProvisionForImpairment() {
		return this.provisionForImpairment;
	}

	public void setProvisionForImpairment(String provisionForImpairment) {
		this.provisionForImpairment = provisionForImpairment;
	}

	public String getNetBookValue() {
		return this.netBookValue;
	}

	public void setNetBookValue(String netBookValue) {
		this.netBookValue = netBookValue;
	}

	public String getScrapRatio() {
		return this.scrapRatio;
	}

	public void setScrapRatio(String scrapRatio) {
		this.scrapRatio = scrapRatio;
	}

	public String getScrapOriginalValueAmount() {
		return this.scrapOriginalValueAmount;
	}

	public void setScrapOriginalValueAmount(String scrapOriginalValueAmount) {
		this.scrapOriginalValueAmount = scrapOriginalValueAmount;
	}

	public String getScrapDepreciation() {
		return this.scrapDepreciation;
	}

	public void setScrapDepreciation(String scrapDepreciation) {
		this.scrapDepreciation = scrapDepreciation;
	}

	public String getPreparationForRetention() {
		return this.preparationForRetention;
	}

	public void setPreparationForRetention(String preparationForRetention) {
		this.preparationForRetention = preparationForRetention;
	}

	public String getEstimatedResidualValue() {
		return this.estimatedResidualValue;
	}

	public void setEstimatedResidualValue(String estimatedResidualValue) {
		this.estimatedResidualValue = estimatedResidualValue;
	}

	public String getSaleRevenue() {
		return this.saleRevenue;
	}

	public void setSaleRevenue(String saleRevenue) {
		this.saleRevenue = saleRevenue;
	}

	public String getInsuranceLiabilityIndemnity() {
		return this.insuranceLiabilityIndemnity;
	}

	public void setInsuranceLiabilityIndemnity(String insuranceLiabilityIndemnity) {
		this.insuranceLiabilityIndemnity = insuranceLiabilityIndemnity;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAssignment1() {
		return this.assignment1;
	}

	public void setAssignment1(String assignment1) {
		this.assignment1 = assignment1;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCostCenterShortText() {
		return this.costCenterShortText;
	}

	public void setCostCenterShortText(String costCenterShortText) {
		this.costCenterShortText = costCenterShortText;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getMeasurementBasicUnit() {
		return this.measurementBasicUnit;
	}

	public void setMeasurementBasicUnit(String measurementBasicUnit) {
		this.measurementBasicUnit = measurementBasicUnit;
	}

	public String getMeasureUnitText() {
		return this.measureUnitText;
	}

	public void setMeasureUnitText(String measureUnitText) {
		this.measureUnitText = measureUnitText;
	}

	public String getAssetManufacturer() {
		return this.assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(String capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public String getExpectedServiceLife() {
		return this.expectedServiceLife;
	}

	public void setExpectedServiceLife(String expectedServiceLife) {
		this.expectedServiceLife = expectedServiceLife;
	}

	public String getScheduledMonth() {
		return this.scheduledMonth;
	}

	public void setScheduledMonth(String scheduledMonth) {
		this.scheduledMonth = scheduledMonth;
	}

	public String getCheckmark() {
		return this.checkmark;
	}

	public void setCheckmark(String checkmark) {
		this.checkmark = checkmark;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCorporateName() {
		return this.corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getProfitCenter() {
		return this.profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getLongText() {
		return this.longText;
	}

	public void setLongText(String longText) {
		this.longText = longText;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getUserChineseName() {
		return this.userChineseName;
	}

	public void setUserChineseName(String userChineseName) {
		this.userChineseName = userChineseName;
	}

	public String getTechnicalDataNameNumber() {
		return this.technicalDataNameNumber;
	}

	public void setTechnicalDataNameNumber(String technicalDataNameNumber) {
		this.technicalDataNameNumber = technicalDataNameNumber;
	}

	public String getResiValTreOpiAsseReneSch() {
		return this.resiValTreOpiAsseReneSch;
	}

	public void setResiValTreOpiAsseReneSch(String resiValTreOpiAsseReneSch) {
		this.resiValTreOpiAsseReneSch = resiValTreOpiAsseReneSch;
	}

	public String getProvinCompApprovRequired() {
		return this.provinCompApprovRequired;
	}

	public void setProvinCompApprovRequired(String provinCompApprovRequired) {
		this.provinCompApprovRequired = provinCompApprovRequired;
	}

	public String getSuccessMark() {
		return this.successMark;
	}

	public void setSuccessMark(String successMark) {
		this.successMark = successMark;
	}

	public String getApprovNodeSelected91Step() {
		return this.approvNodeSelected91Step;
	}

	public void setApprovNodeSelected91Step(String approvNodeSelected91Step) {
		this.approvNodeSelected91Step = approvNodeSelected91Step;
	}

	public String getIsItVehicleProcess() {
		return this.isItVehicleProcess;
	}

	public void setIsItVehicleProcess(String isItVehicleProcess) {
		this.isItVehicleProcess = isItVehicleProcess;
	}

	public String getBusinessTypeVehicle() {
		return this.businessTypeVehicle;
	}

	public void setBusinessTypeVehicle(String businessTypeVehicle) {
		this.businessTypeVehicle = businessTypeVehicle;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleApplicationLevel() {
		return this.vehicleApplicationLevel;
	}

	public void setVehicleApplicationLevel(String vehicleApplicationLevel) {
		this.vehicleApplicationLevel = vehicleApplicationLevel;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setPhysicalId(String physicalId) {
		this.physicalId = physicalId;
	}

	public String getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getProvincCompanyApprovalType() {
		return this.provincCompanyApprovalType;
	}

	public void setProvincCompanyApprovalType(String provincCompanyApprovalType) {
		this.provincCompanyApprovalType = provincCompanyApprovalType;
	}

	public String getDemolitionListNo() {
		return this.demolitionListNo;
	}

	public void setDemolitionListNo(String demolitionListNo) {
		this.demolitionListNo = demolitionListNo;
	}

	public String getDemolitionListLineNumber() {
		return this.demolitionListLineNumber;
	}

	public void setDemolitionListLineNumber(String demolitionListLineNumber) {
		this.demolitionListLineNumber = demolitionListLineNumber;
	}

}