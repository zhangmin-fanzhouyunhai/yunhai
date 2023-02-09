package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpItemReuse entity provides the base persistence definition of the
 * ErpItemReuse entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpItemReuse implements java.io.Serializable {

	// Fields

	private String erpItemReuseId;
	private String categoryCode;
	private String assetQuitPlanId;
	private String rowProjectId;
	private String reutilitizationStatus;
	private String assetManageStorageStatus;
	private String quitPlanIdDescription;
	private String companCode;
	private String assetManageOrgId;
	private String assetManageOrgName;
	private Date planCreateDate;
	private String planCreator;
	private String planStatus;
	private String doPlanAdjustment;
	private Date auditFinishedDate;
	private String reutilitizationAssetId;
	private String reutilitizationAssetName;
	private String manufacturerCode;
	private String mvt;
	private String storagePlace;
	private String repositoryAddressDescription;
	private Double quantity;
	private String bunUnit;
	private String costCenterId;
	private String materiaWarehouseWarrantId;
	private String writeoffStorageWarrantId;
	private String materiaOutgoingWarrantId;
	private String writeoffOutgoingWarrantId;
	private String projectCategory;
	private String projectDescription;
	private String projectDefinitionId;
	private String importantComponentEquipId;
	private String importComponentEquipProfile;
	private String mainEquipmentId;
	private String mainEquipmentName;
	private String mainEquipmentVoltageLevel;
	private String belongedToLineSubstation;
	private String equipmentType;
	private String manufacturerName;
	private String specificationModel;
	private Double equipmentCapacity;
	private Double lineLength;
	private Date exFactoryDate;
	private Date workingOnlineDate;
	private String assetCategoryId;
	private String assetCategoryName;
	private String assetId;
	private String assetName;
	private Double assetOriginalValue;
	private Double assetNetValue;
	private Date warrantDate;
	private Date postingDate;
	private String reference;
	private Double plannedDismantlingQuantity;
	private String assetQuantityUnit;
	private Date plannedQuitDate;
	private Date actualDismantlingDate;
	private Double reusedRate;
	private Double reusedAmount;
	private String demandOrgId;
	private String demandOrgName;
	private String demanderId;
	private String demanderName;
	private String demanderTeleNumber;
	private String reservedOrg;
	private String reservedPerson;
	private String reservedPersonTeleNumber;
	private String reutiRepositoryFuncPosition;
	private Integer workingOnlineAge;
	private String remark;
	private String statusIndicateSymbol;
	private String creator;
	private Date createDate;
	private Date createTime;
	private String workflowDocumentReserveId;
	private String workflowRowProjReserveId;
	private String workflowDoc2discardId;
	private String workflowRowProj2discardId;
	private String workflowDocAppraisalId;
	private String workflowRowProjAppraisalId;
	private String bfsqdh;
	private String zzksj;
	private Date jdsj;
	private String czsj;
	private String assetCostCenter;
	private String reusedStatus;
	private String batchId;
	private String zqxxm;
	private String zqxxmms;

	// Constructors

	/** default constructor */
	public AbstractErpItemReuse() {
	}

	/** full constructor */
	public AbstractErpItemReuse(String categoryCode, String assetQuitPlanId, String rowProjectId,
			String reutilitizationStatus, String assetManageStorageStatus, String quitPlanIdDescription,
			String companCode, String assetManageOrgId, String assetManageOrgName, Date planCreateDate,
			String planCreator, String planStatus, String doPlanAdjustment, Date auditFinishedDate,
			String reutilitizationAssetId, String reutilitizationAssetName, String manufacturerCode, String mvt,
			String storagePlace, String repositoryAddressDescription, Double quantity, String bunUnit,
			String costCenterId, String materiaWarehouseWarrantId, String writeoffStorageWarrantId,
			String materiaOutgoingWarrantId, String writeoffOutgoingWarrantId, String projectCategory,
			String projectDescription, String projectDefinitionId, String importantComponentEquipId,
			String importComponentEquipProfile, String mainEquipmentId, String mainEquipmentName,
			String mainEquipmentVoltageLevel, String belongedToLineSubstation, String equipmentType,
			String manufacturerName, String specificationModel, Double equipmentCapacity, Double lineLength,
			Date exFactoryDate, Date workingOnlineDate, String assetCategoryId, String assetCategoryName,
			String assetId, String assetName, Double assetOriginalValue, Double assetNetValue, Date warrantDate,
			Date postingDate, String reference, Double plannedDismantlingQuantity, String assetQuantityUnit,
			Date plannedQuitDate, Date actualDismantlingDate, Double reusedRate, Double reusedAmount,
			String demandOrgId, String demandOrgName, String demanderId, String demanderName, String demanderTeleNumber,
			String reservedOrg, String reservedPerson, String reservedPersonTeleNumber,
			String reutiRepositoryFuncPosition, Integer workingOnlineAge, String remark, String statusIndicateSymbol,
			String creator, Date createDate, Date createTime, String workflowDocumentReserveId,
			String workflowRowProjReserveId, String workflowDoc2discardId, String workflowRowProj2discardId,
			String workflowDocAppraisalId, String workflowRowProjAppraisalId, String bfsqdh, String zzksj, Date jdsj,
			String czsj, String assetCostCenter, String reusedStatus, String batchId, String zqxxm, String zqxxmms) {
		this.categoryCode = categoryCode;
		this.assetQuitPlanId = assetQuitPlanId;
		this.rowProjectId = rowProjectId;
		this.reutilitizationStatus = reutilitizationStatus;
		this.assetManageStorageStatus = assetManageStorageStatus;
		this.quitPlanIdDescription = quitPlanIdDescription;
		this.companCode = companCode;
		this.assetManageOrgId = assetManageOrgId;
		this.assetManageOrgName = assetManageOrgName;
		this.planCreateDate = planCreateDate;
		this.planCreator = planCreator;
		this.planStatus = planStatus;
		this.doPlanAdjustment = doPlanAdjustment;
		this.auditFinishedDate = auditFinishedDate;
		this.reutilitizationAssetId = reutilitizationAssetId;
		this.reutilitizationAssetName = reutilitizationAssetName;
		this.manufacturerCode = manufacturerCode;
		this.mvt = mvt;
		this.storagePlace = storagePlace;
		this.repositoryAddressDescription = repositoryAddressDescription;
		this.quantity = quantity;
		this.bunUnit = bunUnit;
		this.costCenterId = costCenterId;
		this.materiaWarehouseWarrantId = materiaWarehouseWarrantId;
		this.writeoffStorageWarrantId = writeoffStorageWarrantId;
		this.materiaOutgoingWarrantId = materiaOutgoingWarrantId;
		this.writeoffOutgoingWarrantId = writeoffOutgoingWarrantId;
		this.projectCategory = projectCategory;
		this.projectDescription = projectDescription;
		this.projectDefinitionId = projectDefinitionId;
		this.importantComponentEquipId = importantComponentEquipId;
		this.importComponentEquipProfile = importComponentEquipProfile;
		this.mainEquipmentId = mainEquipmentId;
		this.mainEquipmentName = mainEquipmentName;
		this.mainEquipmentVoltageLevel = mainEquipmentVoltageLevel;
		this.belongedToLineSubstation = belongedToLineSubstation;
		this.equipmentType = equipmentType;
		this.manufacturerName = manufacturerName;
		this.specificationModel = specificationModel;
		this.equipmentCapacity = equipmentCapacity;
		this.lineLength = lineLength;
		this.exFactoryDate = exFactoryDate;
		this.workingOnlineDate = workingOnlineDate;
		this.assetCategoryId = assetCategoryId;
		this.assetCategoryName = assetCategoryName;
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetOriginalValue = assetOriginalValue;
		this.assetNetValue = assetNetValue;
		this.warrantDate = warrantDate;
		this.postingDate = postingDate;
		this.reference = reference;
		this.plannedDismantlingQuantity = plannedDismantlingQuantity;
		this.assetQuantityUnit = assetQuantityUnit;
		this.plannedQuitDate = plannedQuitDate;
		this.actualDismantlingDate = actualDismantlingDate;
		this.reusedRate = reusedRate;
		this.reusedAmount = reusedAmount;
		this.demandOrgId = demandOrgId;
		this.demandOrgName = demandOrgName;
		this.demanderId = demanderId;
		this.demanderName = demanderName;
		this.demanderTeleNumber = demanderTeleNumber;
		this.reservedOrg = reservedOrg;
		this.reservedPerson = reservedPerson;
		this.reservedPersonTeleNumber = reservedPersonTeleNumber;
		this.reutiRepositoryFuncPosition = reutiRepositoryFuncPosition;
		this.workingOnlineAge = workingOnlineAge;
		this.remark = remark;
		this.statusIndicateSymbol = statusIndicateSymbol;
		this.creator = creator;
		this.createDate = createDate;
		this.createTime = createTime;
		this.workflowDocumentReserveId = workflowDocumentReserveId;
		this.workflowRowProjReserveId = workflowRowProjReserveId;
		this.workflowDoc2discardId = workflowDoc2discardId;
		this.workflowRowProj2discardId = workflowRowProj2discardId;
		this.workflowDocAppraisalId = workflowDocAppraisalId;
		this.workflowRowProjAppraisalId = workflowRowProjAppraisalId;
		this.bfsqdh = bfsqdh;
		this.zzksj = zzksj;
		this.jdsj = jdsj;
		this.czsj = czsj;
		this.assetCostCenter = assetCostCenter;
		this.reusedStatus = reusedStatus;
		this.batchId = batchId;
		this.zqxxm = zqxxm;
		this.zqxxmms = zqxxmms;
	}

	// Property accessors

	public String getErpItemReuseId() {
		return this.erpItemReuseId;
	}

	public void setErpItemReuseId(String erpItemReuseId) {
		this.erpItemReuseId = erpItemReuseId;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getAssetQuitPlanId() {
		return this.assetQuitPlanId;
	}

	public void setAssetQuitPlanId(String assetQuitPlanId) {
		this.assetQuitPlanId = assetQuitPlanId;
	}

	public String getRowProjectId() {
		return this.rowProjectId;
	}

	public void setRowProjectId(String rowProjectId) {
		this.rowProjectId = rowProjectId;
	}

	public String getReutilitizationStatus() {
		return this.reutilitizationStatus;
	}

	public void setReutilitizationStatus(String reutilitizationStatus) {
		this.reutilitizationStatus = reutilitizationStatus;
	}

	public String getAssetManageStorageStatus() {
		return this.assetManageStorageStatus;
	}

	public void setAssetManageStorageStatus(String assetManageStorageStatus) {
		this.assetManageStorageStatus = assetManageStorageStatus;
	}

	public String getQuitPlanIdDescription() {
		return this.quitPlanIdDescription;
	}

	public void setQuitPlanIdDescription(String quitPlanIdDescription) {
		this.quitPlanIdDescription = quitPlanIdDescription;
	}

	public String getCompanCode() {
		return this.companCode;
	}

	public void setCompanCode(String companCode) {
		this.companCode = companCode;
	}

	public String getAssetManageOrgId() {
		return this.assetManageOrgId;
	}

	public void setAssetManageOrgId(String assetManageOrgId) {
		this.assetManageOrgId = assetManageOrgId;
	}

	public String getAssetManageOrgName() {
		return this.assetManageOrgName;
	}

	public void setAssetManageOrgName(String assetManageOrgName) {
		this.assetManageOrgName = assetManageOrgName;
	}

	public Date getPlanCreateDate() {
		return this.planCreateDate;
	}

	public void setPlanCreateDate(Date planCreateDate) {
		this.planCreateDate = planCreateDate;
	}

	public String getPlanCreator() {
		return this.planCreator;
	}

	public void setPlanCreator(String planCreator) {
		this.planCreator = planCreator;
	}

	public String getPlanStatus() {
		return this.planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getDoPlanAdjustment() {
		return this.doPlanAdjustment;
	}

	public void setDoPlanAdjustment(String doPlanAdjustment) {
		this.doPlanAdjustment = doPlanAdjustment;
	}

	public Date getAuditFinishedDate() {
		return this.auditFinishedDate;
	}

	public void setAuditFinishedDate(Date auditFinishedDate) {
		this.auditFinishedDate = auditFinishedDate;
	}

	public String getReutilitizationAssetId() {
		return this.reutilitizationAssetId;
	}

	public void setReutilitizationAssetId(String reutilitizationAssetId) {
		this.reutilitizationAssetId = reutilitizationAssetId;
	}

	public String getReutilitizationAssetName() {
		return this.reutilitizationAssetName;
	}

	public void setReutilitizationAssetName(String reutilitizationAssetName) {
		this.reutilitizationAssetName = reutilitizationAssetName;
	}

	public String getManufacturerCode() {
		return this.manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getMvt() {
		return this.mvt;
	}

	public void setMvt(String mvt) {
		this.mvt = mvt;
	}

	public String getStoragePlace() {
		return this.storagePlace;
	}

	public void setStoragePlace(String storagePlace) {
		this.storagePlace = storagePlace;
	}

	public String getRepositoryAddressDescription() {
		return this.repositoryAddressDescription;
	}

	public void setRepositoryAddressDescription(String repositoryAddressDescription) {
		this.repositoryAddressDescription = repositoryAddressDescription;
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

	public String getCostCenterId() {
		return this.costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getMateriaWarehouseWarrantId() {
		return this.materiaWarehouseWarrantId;
	}

	public void setMateriaWarehouseWarrantId(String materiaWarehouseWarrantId) {
		this.materiaWarehouseWarrantId = materiaWarehouseWarrantId;
	}

	public String getWriteoffStorageWarrantId() {
		return this.writeoffStorageWarrantId;
	}

	public void setWriteoffStorageWarrantId(String writeoffStorageWarrantId) {
		this.writeoffStorageWarrantId = writeoffStorageWarrantId;
	}

	public String getMateriaOutgoingWarrantId() {
		return this.materiaOutgoingWarrantId;
	}

	public void setMateriaOutgoingWarrantId(String materiaOutgoingWarrantId) {
		this.materiaOutgoingWarrantId = materiaOutgoingWarrantId;
	}

	public String getWriteoffOutgoingWarrantId() {
		return this.writeoffOutgoingWarrantId;
	}

	public void setWriteoffOutgoingWarrantId(String writeoffOutgoingWarrantId) {
		this.writeoffOutgoingWarrantId = writeoffOutgoingWarrantId;
	}

	public String getProjectCategory() {
		return this.projectCategory;
	}

	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectDefinitionId() {
		return this.projectDefinitionId;
	}

	public void setProjectDefinitionId(String projectDefinitionId) {
		this.projectDefinitionId = projectDefinitionId;
	}

	public String getImportantComponentEquipId() {
		return this.importantComponentEquipId;
	}

	public void setImportantComponentEquipId(String importantComponentEquipId) {
		this.importantComponentEquipId = importantComponentEquipId;
	}

	public String getImportComponentEquipProfile() {
		return this.importComponentEquipProfile;
	}

	public void setImportComponentEquipProfile(String importComponentEquipProfile) {
		this.importComponentEquipProfile = importComponentEquipProfile;
	}

	public String getMainEquipmentId() {
		return this.mainEquipmentId;
	}

	public void setMainEquipmentId(String mainEquipmentId) {
		this.mainEquipmentId = mainEquipmentId;
	}

	public String getMainEquipmentName() {
		return this.mainEquipmentName;
	}

	public void setMainEquipmentName(String mainEquipmentName) {
		this.mainEquipmentName = mainEquipmentName;
	}

	public String getMainEquipmentVoltageLevel() {
		return this.mainEquipmentVoltageLevel;
	}

	public void setMainEquipmentVoltageLevel(String mainEquipmentVoltageLevel) {
		this.mainEquipmentVoltageLevel = mainEquipmentVoltageLevel;
	}

	public String getBelongedToLineSubstation() {
		return this.belongedToLineSubstation;
	}

	public void setBelongedToLineSubstation(String belongedToLineSubstation) {
		this.belongedToLineSubstation = belongedToLineSubstation;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getSpecificationModel() {
		return this.specificationModel;
	}

	public void setSpecificationModel(String specificationModel) {
		this.specificationModel = specificationModel;
	}

	public Double getEquipmentCapacity() {
		return this.equipmentCapacity;
	}

	public void setEquipmentCapacity(Double equipmentCapacity) {
		this.equipmentCapacity = equipmentCapacity;
	}

	public Double getLineLength() {
		return this.lineLength;
	}

	public void setLineLength(Double lineLength) {
		this.lineLength = lineLength;
	}

	public Date getExFactoryDate() {
		return this.exFactoryDate;
	}

	public void setExFactoryDate(Date exFactoryDate) {
		this.exFactoryDate = exFactoryDate;
	}

	public Date getWorkingOnlineDate() {
		return this.workingOnlineDate;
	}

	public void setWorkingOnlineDate(Date workingOnlineDate) {
		this.workingOnlineDate = workingOnlineDate;
	}

	public String getAssetCategoryId() {
		return this.assetCategoryId;
	}

	public void setAssetCategoryId(String assetCategoryId) {
		this.assetCategoryId = assetCategoryId;
	}

	public String getAssetCategoryName() {
		return this.assetCategoryName;
	}

	public void setAssetCategoryName(String assetCategoryName) {
		this.assetCategoryName = assetCategoryName;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Double getAssetOriginalValue() {
		return this.assetOriginalValue;
	}

	public void setAssetOriginalValue(Double assetOriginalValue) {
		this.assetOriginalValue = assetOriginalValue;
	}

	public Double getAssetNetValue() {
		return this.assetNetValue;
	}

	public void setAssetNetValue(Double assetNetValue) {
		this.assetNetValue = assetNetValue;
	}

	public Date getWarrantDate() {
		return this.warrantDate;
	}

	public void setWarrantDate(Date warrantDate) {
		this.warrantDate = warrantDate;
	}

	public Date getPostingDate() {
		return this.postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getPlannedDismantlingQuantity() {
		return this.plannedDismantlingQuantity;
	}

	public void setPlannedDismantlingQuantity(Double plannedDismantlingQuantity) {
		this.plannedDismantlingQuantity = plannedDismantlingQuantity;
	}

	public String getAssetQuantityUnit() {
		return this.assetQuantityUnit;
	}

	public void setAssetQuantityUnit(String assetQuantityUnit) {
		this.assetQuantityUnit = assetQuantityUnit;
	}

	public Date getPlannedQuitDate() {
		return this.plannedQuitDate;
	}

	public void setPlannedQuitDate(Date plannedQuitDate) {
		this.plannedQuitDate = plannedQuitDate;
	}

	public Date getActualDismantlingDate() {
		return this.actualDismantlingDate;
	}

	public void setActualDismantlingDate(Date actualDismantlingDate) {
		this.actualDismantlingDate = actualDismantlingDate;
	}

	public Double getReusedRate() {
		return this.reusedRate;
	}

	public void setReusedRate(Double reusedRate) {
		this.reusedRate = reusedRate;
	}

	public Double getReusedAmount() {
		return this.reusedAmount;
	}

	public void setReusedAmount(Double reusedAmount) {
		this.reusedAmount = reusedAmount;
	}

	public String getDemandOrgId() {
		return this.demandOrgId;
	}

	public void setDemandOrgId(String demandOrgId) {
		this.demandOrgId = demandOrgId;
	}

	public String getDemandOrgName() {
		return this.demandOrgName;
	}

	public void setDemandOrgName(String demandOrgName) {
		this.demandOrgName = demandOrgName;
	}

	public String getDemanderId() {
		return this.demanderId;
	}

	public void setDemanderId(String demanderId) {
		this.demanderId = demanderId;
	}

	public String getDemanderName() {
		return this.demanderName;
	}

	public void setDemanderName(String demanderName) {
		this.demanderName = demanderName;
	}

	public String getDemanderTeleNumber() {
		return this.demanderTeleNumber;
	}

	public void setDemanderTeleNumber(String demanderTeleNumber) {
		this.demanderTeleNumber = demanderTeleNumber;
	}

	public String getReservedOrg() {
		return this.reservedOrg;
	}

	public void setReservedOrg(String reservedOrg) {
		this.reservedOrg = reservedOrg;
	}

	public String getReservedPerson() {
		return this.reservedPerson;
	}

	public void setReservedPerson(String reservedPerson) {
		this.reservedPerson = reservedPerson;
	}

	public String getReservedPersonTeleNumber() {
		return this.reservedPersonTeleNumber;
	}

	public void setReservedPersonTeleNumber(String reservedPersonTeleNumber) {
		this.reservedPersonTeleNumber = reservedPersonTeleNumber;
	}

	public String getReutiRepositoryFuncPosition() {
		return this.reutiRepositoryFuncPosition;
	}

	public void setReutiRepositoryFuncPosition(String reutiRepositoryFuncPosition) {
		this.reutiRepositoryFuncPosition = reutiRepositoryFuncPosition;
	}

	public Integer getWorkingOnlineAge() {
		return this.workingOnlineAge;
	}

	public void setWorkingOnlineAge(Integer workingOnlineAge) {
		this.workingOnlineAge = workingOnlineAge;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatusIndicateSymbol() {
		return this.statusIndicateSymbol;
	}

	public void setStatusIndicateSymbol(String statusIndicateSymbol) {
		this.statusIndicateSymbol = statusIndicateSymbol;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWorkflowDocumentReserveId() {
		return this.workflowDocumentReserveId;
	}

	public void setWorkflowDocumentReserveId(String workflowDocumentReserveId) {
		this.workflowDocumentReserveId = workflowDocumentReserveId;
	}

	public String getWorkflowRowProjReserveId() {
		return this.workflowRowProjReserveId;
	}

	public void setWorkflowRowProjReserveId(String workflowRowProjReserveId) {
		this.workflowRowProjReserveId = workflowRowProjReserveId;
	}

	public String getWorkflowDoc2discardId() {
		return this.workflowDoc2discardId;
	}

	public void setWorkflowDoc2discardId(String workflowDoc2discardId) {
		this.workflowDoc2discardId = workflowDoc2discardId;
	}

	public String getWorkflowRowProj2discardId() {
		return this.workflowRowProj2discardId;
	}

	public void setWorkflowRowProj2discardId(String workflowRowProj2discardId) {
		this.workflowRowProj2discardId = workflowRowProj2discardId;
	}

	public String getWorkflowDocAppraisalId() {
		return this.workflowDocAppraisalId;
	}

	public void setWorkflowDocAppraisalId(String workflowDocAppraisalId) {
		this.workflowDocAppraisalId = workflowDocAppraisalId;
	}

	public String getWorkflowRowProjAppraisalId() {
		return this.workflowRowProjAppraisalId;
	}

	public void setWorkflowRowProjAppraisalId(String workflowRowProjAppraisalId) {
		this.workflowRowProjAppraisalId = workflowRowProjAppraisalId;
	}

	public String getBfsqdh() {
		return this.bfsqdh;
	}

	public void setBfsqdh(String bfsqdh) {
		this.bfsqdh = bfsqdh;
	}

	public String getZzksj() {
		return this.zzksj;
	}

	public void setZzksj(String zzksj) {
		this.zzksj = zzksj;
	}

	public Date getJdsj() {
		return this.jdsj;
	}

	public void setJdsj(Date jdsj) {
		this.jdsj = jdsj;
	}

	public String getCzsj() {
		return this.czsj;
	}

	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}

	public String getAssetCostCenter() {
		return this.assetCostCenter;
	}

	public void setAssetCostCenter(String assetCostCenter) {
		this.assetCostCenter = assetCostCenter;
	}

	public String getReusedStatus() {
		return this.reusedStatus;
	}

	public void setReusedStatus(String reusedStatus) {
		this.reusedStatus = reusedStatus;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getZqxxm() {
		return this.zqxxm;
	}

	public void setZqxxm(String zqxxm) {
		this.zqxxm = zqxxm;
	}

	public String getZqxxmms() {
		return this.zqxxmms;
	}

	public void setZqxxmms(String zqxxmms) {
		this.zqxxmms = zqxxmms;
	}

}