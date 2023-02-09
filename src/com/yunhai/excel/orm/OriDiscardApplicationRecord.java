package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriDiscardApplicationRecord entity. @author MyEclipse Persistence Tools
 */
public class OriDiscardApplicationRecord extends AbstractOriDiscardApplicationRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriDiscardApplicationRecord() {
	}

	/** minimal constructor */
	public OriDiscardApplicationRecord(String oriDiscardApplicatRecordId, String dataVersion, Date calYear,
			String dataSourceFile) {
		super(oriDiscardApplicatRecordId, dataVersion, calYear, dataSourceFile);
	}

	/** full constructor */
	public OriDiscardApplicationRecord(String oriDiscardApplicatRecordId, String dataVersion, Date calYear,
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
		super(oriDiscardApplicatRecordId, dataVersion, calYear, dataSourceFile, applicationNumber, creator,
				serialNumber, approvedPerson, approvalLevel, approvalStatus, creationDate, dateOfSubmission, endDate,
				documentNumber, equipmentNumber1, technicalObjectDescription1, equipment, technicalObjectDescription2,
				importComponentEquipStatus, importantEquipReferenceVal, equipmentNumber, technicalObjectDescription,
				masterDeviceStatus, mainEquipmentReferenceValue, assetClassification, assetClassAlias, assetNumber,
				assetDescription, scrappingReason, residuValAssetRenewaScheme, assetRetirementScale, changeStatus,
				assetValueDate, bookkeepingDate, involvingPurchaseYear, originalBookValue, accumulatedDepreciation,
				provisionForImpairment, netBookValue, scrapRatio, scrapOriginalValueAmount, scrapDepreciation,
				preparationForRetention, estimatedResidualValue, saleRevenue, insuranceLiabilityIndemnity, text,
				assignment1, assignment, costCenter, costCenterShortText, quantity, measurementBasicUnit,
				measureUnitText, assetManufacturer, capitalizationDate, expectedServiceLife, scheduledMonth, checkmark,
				companyCode, corporateName, profitCenter, longText, abstract_, userChineseName, technicalDataNameNumber,
				resiValTreOpiAsseReneSch, provinCompApprovRequired, successMark, approvNodeSelected91Step,
				isItVehicleProcess, businessTypeVehicle, vehicleType, vehicleApplicationLevel, physicalId, businessType,
				provincCompanyApprovalType, demolitionListNo, demolitionListLineNumber);
	}

}
