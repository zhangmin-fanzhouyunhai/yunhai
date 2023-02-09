package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpItemDiscard entity provides the base persistence definition of the
 * ErpItemDiscard entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpItemDiscard implements java.io.Serializable {

	// Fields

	private String erpItemDiscardId;
	private String categoryCode;
	private String applicationFormId;
	private String applicaFormCreatorAccount;
	private String xh;
	private String warrantId;
	private String approverAcclunt;
	private String currentApprovalLevel;
	private String fixAssetDiscAppFormState;
	private Date appFormCreateDate;
	private Date appFormSubmitDate;
	private String equipmentId;
	private String technObjectSpecification;
	private String equipmentStatus;
	private String equipmentClassCode;
	private String assetCategoryName;
	private String assetNumber;
	private String assetSpecification;
	private String discardDetailDescription;
	private String residuValueDealAssetRenew;
	private String assetDiscardCompleteness;
	private String stateChange;
	private Date assetValueDate;
	private Date accountDate;
	private String comeFrom;
	private Double originalValue;
	private Double accumulatedDepreciation;
	private Double beenImpairmentProvision;
	private Double netValue;
	private Double discardRate;
	private Double discardOriginalAmount;
	private Double discardDepreciation;
	private Double tlzb;
	private Double expectedSalvageValue;
	private Double insuranceLiabilityCompensat;
	private String documentDescription;
	private String reference;
	private String allocation;
	private String costCenter;
	private String abstractSpecification;
	private Double quantity;
	private String bunUnit;
	private String unitName;
	private String manufacturerName;
	private Date capitalizationDate;
	private Integer reserverUsingYears;
	private String reserverUsingMonth;
	private String mark;
	private String orgCode;
	private String orgName;
	private String profitCenterCode;
	private String detailSpecification;
	private String abstract_;
	private String userName;
	private String sublevel;
	private String zflagProcess;
	private String currentSymbol;
	private String currentId;
	private String currentCode;
	private String procedureCompleIndicate;
	private String procedureCreatorAccount;
	private String financialStaffAccount;
	private Date udate;
	private Date utime;
	private String whethNeedLocalOrgApproval;
	private String whethNeedProviOrgApproval;
	private String fjid;
	private String discardReasonCode;
	private String discardReasonDiscription;
	private String residuValueDealAssetRenew2;
	private Date discardWcDate;
	private String assetOutgoingFormId;
	private String zccqhh;
	private String writeOffMark;
	private Double wasteMaterialOutputTaxRate;

	// Constructors

	/** default constructor */
	public AbstractErpItemDiscard() {
	}

	/** full constructor */
	public AbstractErpItemDiscard(String categoryCode, String applicationFormId, String applicaFormCreatorAccount,
			String xh, String warrantId, String approverAcclunt, String currentApprovalLevel,
			String fixAssetDiscAppFormState, Date appFormCreateDate, Date appFormSubmitDate, String equipmentId,
			String technObjectSpecification, String equipmentStatus, String equipmentClassCode,
			String assetCategoryName, String assetNumber, String assetSpecification, String discardDetailDescription,
			String residuValueDealAssetRenew, String assetDiscardCompleteness, String stateChange, Date assetValueDate,
			Date accountDate, String comeFrom, Double originalValue, Double accumulatedDepreciation,
			Double beenImpairmentProvision, Double netValue, Double discardRate, Double discardOriginalAmount,
			Double discardDepreciation, Double tlzb, Double expectedSalvageValue, Double insuranceLiabilityCompensat,
			String documentDescription, String reference, String allocation, String costCenter,
			String abstractSpecification, Double quantity, String bunUnit, String unitName, String manufacturerName,
			Date capitalizationDate, Integer reserverUsingYears, String reserverUsingMonth, String mark, String orgCode,
			String orgName, String profitCenterCode, String detailSpecification, String abstract_, String userName,
			String sublevel, String zflagProcess, String currentSymbol, String currentId, String currentCode,
			String procedureCompleIndicate, String procedureCreatorAccount, String financialStaffAccount, Date udate,
			Date utime, String whethNeedLocalOrgApproval, String whethNeedProviOrgApproval, String fjid,
			String discardReasonCode, String discardReasonDiscription, String residuValueDealAssetRenew2,
			Date discardWcDate, String assetOutgoingFormId, String zccqhh, String writeOffMark,
			Double wasteMaterialOutputTaxRate) {
		this.categoryCode = categoryCode;
		this.applicationFormId = applicationFormId;
		this.applicaFormCreatorAccount = applicaFormCreatorAccount;
		this.xh = xh;
		this.warrantId = warrantId;
		this.approverAcclunt = approverAcclunt;
		this.currentApprovalLevel = currentApprovalLevel;
		this.fixAssetDiscAppFormState = fixAssetDiscAppFormState;
		this.appFormCreateDate = appFormCreateDate;
		this.appFormSubmitDate = appFormSubmitDate;
		this.equipmentId = equipmentId;
		this.technObjectSpecification = technObjectSpecification;
		this.equipmentStatus = equipmentStatus;
		this.equipmentClassCode = equipmentClassCode;
		this.assetCategoryName = assetCategoryName;
		this.assetNumber = assetNumber;
		this.assetSpecification = assetSpecification;
		this.discardDetailDescription = discardDetailDescription;
		this.residuValueDealAssetRenew = residuValueDealAssetRenew;
		this.assetDiscardCompleteness = assetDiscardCompleteness;
		this.stateChange = stateChange;
		this.assetValueDate = assetValueDate;
		this.accountDate = accountDate;
		this.comeFrom = comeFrom;
		this.originalValue = originalValue;
		this.accumulatedDepreciation = accumulatedDepreciation;
		this.beenImpairmentProvision = beenImpairmentProvision;
		this.netValue = netValue;
		this.discardRate = discardRate;
		this.discardOriginalAmount = discardOriginalAmount;
		this.discardDepreciation = discardDepreciation;
		this.tlzb = tlzb;
		this.expectedSalvageValue = expectedSalvageValue;
		this.insuranceLiabilityCompensat = insuranceLiabilityCompensat;
		this.documentDescription = documentDescription;
		this.reference = reference;
		this.allocation = allocation;
		this.costCenter = costCenter;
		this.abstractSpecification = abstractSpecification;
		this.quantity = quantity;
		this.bunUnit = bunUnit;
		this.unitName = unitName;
		this.manufacturerName = manufacturerName;
		this.capitalizationDate = capitalizationDate;
		this.reserverUsingYears = reserverUsingYears;
		this.reserverUsingMonth = reserverUsingMonth;
		this.mark = mark;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.profitCenterCode = profitCenterCode;
		this.detailSpecification = detailSpecification;
		this.abstract_ = abstract_;
		this.userName = userName;
		this.sublevel = sublevel;
		this.zflagProcess = zflagProcess;
		this.currentSymbol = currentSymbol;
		this.currentId = currentId;
		this.currentCode = currentCode;
		this.procedureCompleIndicate = procedureCompleIndicate;
		this.procedureCreatorAccount = procedureCreatorAccount;
		this.financialStaffAccount = financialStaffAccount;
		this.udate = udate;
		this.utime = utime;
		this.whethNeedLocalOrgApproval = whethNeedLocalOrgApproval;
		this.whethNeedProviOrgApproval = whethNeedProviOrgApproval;
		this.fjid = fjid;
		this.discardReasonCode = discardReasonCode;
		this.discardReasonDiscription = discardReasonDiscription;
		this.residuValueDealAssetRenew2 = residuValueDealAssetRenew2;
		this.discardWcDate = discardWcDate;
		this.assetOutgoingFormId = assetOutgoingFormId;
		this.zccqhh = zccqhh;
		this.writeOffMark = writeOffMark;
		this.wasteMaterialOutputTaxRate = wasteMaterialOutputTaxRate;
	}

	// Property accessors

	public String getErpItemDiscardId() {
		return this.erpItemDiscardId;
	}

	public void setErpItemDiscardId(String erpItemDiscardId) {
		this.erpItemDiscardId = erpItemDiscardId;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getApplicationFormId() {
		return this.applicationFormId;
	}

	public void setApplicationFormId(String applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public String getApplicaFormCreatorAccount() {
		return this.applicaFormCreatorAccount;
	}

	public void setApplicaFormCreatorAccount(String applicaFormCreatorAccount) {
		this.applicaFormCreatorAccount = applicaFormCreatorAccount;
	}

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getWarrantId() {
		return this.warrantId;
	}

	public void setWarrantId(String warrantId) {
		this.warrantId = warrantId;
	}

	public String getApproverAcclunt() {
		return this.approverAcclunt;
	}

	public void setApproverAcclunt(String approverAcclunt) {
		this.approverAcclunt = approverAcclunt;
	}

	public String getCurrentApprovalLevel() {
		return this.currentApprovalLevel;
	}

	public void setCurrentApprovalLevel(String currentApprovalLevel) {
		this.currentApprovalLevel = currentApprovalLevel;
	}

	public String getFixAssetDiscAppFormState() {
		return this.fixAssetDiscAppFormState;
	}

	public void setFixAssetDiscAppFormState(String fixAssetDiscAppFormState) {
		this.fixAssetDiscAppFormState = fixAssetDiscAppFormState;
	}

	public Date getAppFormCreateDate() {
		return this.appFormCreateDate;
	}

	public void setAppFormCreateDate(Date appFormCreateDate) {
		this.appFormCreateDate = appFormCreateDate;
	}

	public Date getAppFormSubmitDate() {
		return this.appFormSubmitDate;
	}

	public void setAppFormSubmitDate(Date appFormSubmitDate) {
		this.appFormSubmitDate = appFormSubmitDate;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getTechnObjectSpecification() {
		return this.technObjectSpecification;
	}

	public void setTechnObjectSpecification(String technObjectSpecification) {
		this.technObjectSpecification = technObjectSpecification;
	}

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getEquipmentClassCode() {
		return this.equipmentClassCode;
	}

	public void setEquipmentClassCode(String equipmentClassCode) {
		this.equipmentClassCode = equipmentClassCode;
	}

	public String getAssetCategoryName() {
		return this.assetCategoryName;
	}

	public void setAssetCategoryName(String assetCategoryName) {
		this.assetCategoryName = assetCategoryName;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetSpecification() {
		return this.assetSpecification;
	}

	public void setAssetSpecification(String assetSpecification) {
		this.assetSpecification = assetSpecification;
	}

	public String getDiscardDetailDescription() {
		return this.discardDetailDescription;
	}

	public void setDiscardDetailDescription(String discardDetailDescription) {
		this.discardDetailDescription = discardDetailDescription;
	}

	public String getResiduValueDealAssetRenew() {
		return this.residuValueDealAssetRenew;
	}

	public void setResiduValueDealAssetRenew(String residuValueDealAssetRenew) {
		this.residuValueDealAssetRenew = residuValueDealAssetRenew;
	}

	public String getAssetDiscardCompleteness() {
		return this.assetDiscardCompleteness;
	}

	public void setAssetDiscardCompleteness(String assetDiscardCompleteness) {
		this.assetDiscardCompleteness = assetDiscardCompleteness;
	}

	public String getStateChange() {
		return this.stateChange;
	}

	public void setStateChange(String stateChange) {
		this.stateChange = stateChange;
	}

	public Date getAssetValueDate() {
		return this.assetValueDate;
	}

	public void setAssetValueDate(Date assetValueDate) {
		this.assetValueDate = assetValueDate;
	}

	public Date getAccountDate() {
		return this.accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public String getComeFrom() {
		return this.comeFrom;
	}

	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getAccumulatedDepreciation() {
		return this.accumulatedDepreciation;
	}

	public void setAccumulatedDepreciation(Double accumulatedDepreciation) {
		this.accumulatedDepreciation = accumulatedDepreciation;
	}

	public Double getBeenImpairmentProvision() {
		return this.beenImpairmentProvision;
	}

	public void setBeenImpairmentProvision(Double beenImpairmentProvision) {
		this.beenImpairmentProvision = beenImpairmentProvision;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public Double getDiscardRate() {
		return this.discardRate;
	}

	public void setDiscardRate(Double discardRate) {
		this.discardRate = discardRate;
	}

	public Double getDiscardOriginalAmount() {
		return this.discardOriginalAmount;
	}

	public void setDiscardOriginalAmount(Double discardOriginalAmount) {
		this.discardOriginalAmount = discardOriginalAmount;
	}

	public Double getDiscardDepreciation() {
		return this.discardDepreciation;
	}

	public void setDiscardDepreciation(Double discardDepreciation) {
		this.discardDepreciation = discardDepreciation;
	}

	public Double getTlzb() {
		return this.tlzb;
	}

	public void setTlzb(Double tlzb) {
		this.tlzb = tlzb;
	}

	public Double getExpectedSalvageValue() {
		return this.expectedSalvageValue;
	}

	public void setExpectedSalvageValue(Double expectedSalvageValue) {
		this.expectedSalvageValue = expectedSalvageValue;
	}

	public Double getInsuranceLiabilityCompensat() {
		return this.insuranceLiabilityCompensat;
	}

	public void setInsuranceLiabilityCompensat(Double insuranceLiabilityCompensat) {
		this.insuranceLiabilityCompensat = insuranceLiabilityCompensat;
	}

	public String getDocumentDescription() {
		return this.documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAllocation() {
		return this.allocation;
	}

	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getAbstractSpecification() {
		return this.abstractSpecification;
	}

	public void setAbstractSpecification(String abstractSpecification) {
		this.abstractSpecification = abstractSpecification;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getBunUnit() {
		return this.bunUnit;
	}

	public void setBunUnit(String bunUnit) {
		this.bunUnit = bunUnit;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public Integer getReserverUsingYears() {
		return this.reserverUsingYears;
	}

	public void setReserverUsingYears(Integer reserverUsingYears) {
		this.reserverUsingYears = reserverUsingYears;
	}

	public String getReserverUsingMonth() {
		return this.reserverUsingMonth;
	}

	public void setReserverUsingMonth(String reserverUsingMonth) {
		this.reserverUsingMonth = reserverUsingMonth;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getProfitCenterCode() {
		return this.profitCenterCode;
	}

	public void setProfitCenterCode(String profitCenterCode) {
		this.profitCenterCode = profitCenterCode;
	}

	public String getDetailSpecification() {
		return this.detailSpecification;
	}

	public void setDetailSpecification(String detailSpecification) {
		this.detailSpecification = detailSpecification;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSublevel() {
		return this.sublevel;
	}

	public void setSublevel(String sublevel) {
		this.sublevel = sublevel;
	}

	public String getZflagProcess() {
		return this.zflagProcess;
	}

	public void setZflagProcess(String zflagProcess) {
		this.zflagProcess = zflagProcess;
	}

	public String getCurrentSymbol() {
		return this.currentSymbol;
	}

	public void setCurrentSymbol(String currentSymbol) {
		this.currentSymbol = currentSymbol;
	}

	public String getCurrentId() {
		return this.currentId;
	}

	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}

	public String getCurrentCode() {
		return this.currentCode;
	}

	public void setCurrentCode(String currentCode) {
		this.currentCode = currentCode;
	}

	public String getProcedureCompleIndicate() {
		return this.procedureCompleIndicate;
	}

	public void setProcedureCompleIndicate(String procedureCompleIndicate) {
		this.procedureCompleIndicate = procedureCompleIndicate;
	}

	public String getProcedureCreatorAccount() {
		return this.procedureCreatorAccount;
	}

	public void setProcedureCreatorAccount(String procedureCreatorAccount) {
		this.procedureCreatorAccount = procedureCreatorAccount;
	}

	public String getFinancialStaffAccount() {
		return this.financialStaffAccount;
	}

	public void setFinancialStaffAccount(String financialStaffAccount) {
		this.financialStaffAccount = financialStaffAccount;
	}

	public Date getUdate() {
		return this.udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public Date getUtime() {
		return this.utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public String getWhethNeedLocalOrgApproval() {
		return this.whethNeedLocalOrgApproval;
	}

	public void setWhethNeedLocalOrgApproval(String whethNeedLocalOrgApproval) {
		this.whethNeedLocalOrgApproval = whethNeedLocalOrgApproval;
	}

	public String getWhethNeedProviOrgApproval() {
		return this.whethNeedProviOrgApproval;
	}

	public void setWhethNeedProviOrgApproval(String whethNeedProviOrgApproval) {
		this.whethNeedProviOrgApproval = whethNeedProviOrgApproval;
	}

	public String getFjid() {
		return this.fjid;
	}

	public void setFjid(String fjid) {
		this.fjid = fjid;
	}

	public String getDiscardReasonCode() {
		return this.discardReasonCode;
	}

	public void setDiscardReasonCode(String discardReasonCode) {
		this.discardReasonCode = discardReasonCode;
	}

	public String getDiscardReasonDiscription() {
		return this.discardReasonDiscription;
	}

	public void setDiscardReasonDiscription(String discardReasonDiscription) {
		this.discardReasonDiscription = discardReasonDiscription;
	}

	public String getResiduValueDealAssetRenew2() {
		return this.residuValueDealAssetRenew2;
	}

	public void setResiduValueDealAssetRenew2(String residuValueDealAssetRenew2) {
		this.residuValueDealAssetRenew2 = residuValueDealAssetRenew2;
	}

	public Date getDiscardWcDate() {
		return this.discardWcDate;
	}

	public void setDiscardWcDate(Date discardWcDate) {
		this.discardWcDate = discardWcDate;
	}

	public String getAssetOutgoingFormId() {
		return this.assetOutgoingFormId;
	}

	public void setAssetOutgoingFormId(String assetOutgoingFormId) {
		this.assetOutgoingFormId = assetOutgoingFormId;
	}

	public String getZccqhh() {
		return this.zccqhh;
	}

	public void setZccqhh(String zccqhh) {
		this.zccqhh = zccqhh;
	}

	public String getWriteOffMark() {
		return this.writeOffMark;
	}

	public void setWriteOffMark(String writeOffMark) {
		this.writeOffMark = writeOffMark;
	}

	public Double getWasteMaterialOutputTaxRate() {
		return this.wasteMaterialOutputTaxRate;
	}

	public void setWasteMaterialOutputTaxRate(Double wasteMaterialOutputTaxRate) {
		this.wasteMaterialOutputTaxRate = wasteMaterialOutputTaxRate;
	}

}