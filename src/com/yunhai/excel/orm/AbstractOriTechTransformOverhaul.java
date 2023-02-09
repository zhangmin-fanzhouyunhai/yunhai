package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriTechTransformOverhaul entity provides the base persistence
 * definition of the OriTechTransformOverhaul entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriTechTransformOverhaul implements java.io.Serializable {

	// Fields

	private String oriTechTransformOverhaulId;
	private Integer recordNum;
	private String objId;
	private String projectId;
	private String orgName;
	private String projectName;
	private Integer planningYear;
	private String projectType;
	private String majorCategory;
	private String majorDetailCategory;
	private String projectContent;
	private String purposeOfTransformation;
	private String voltageLevel;
	private String imageProgress;
	private Double currentYearAccountingMoney;
	private Double currentYearFunds;
	private Double totalInvestment;
	private Date xmkssj;
	private Date xmwcsj;
	private String isItRuralNetwork;
	private String projectApprovalBasis;
	private String transformationReason;
	private String feasibilityStudyRevieDocNo;
	private String feasibilityStudyApproDocNo;
	private String natureOfTheProject;
	private String equipmentCategory;
	private String unit;
	private Double assetQuantity;
	private String governanceDirection;
	private String governanceSubCategory;
	private String reviewer;
	private String fireFightingOrNot;
	private String adjustBatch;
	private String adjustCategory;
	private Date calYear;
	private String dataVersion;
	private String fileName;

	// Constructors

	/** default constructor */
	public AbstractOriTechTransformOverhaul() {
	}

	/** minimal constructor */
	public AbstractOriTechTransformOverhaul(String oriTechTransformOverhaulId) {
		this.oriTechTransformOverhaulId = oriTechTransformOverhaulId;
	}

	/** full constructor */
	public AbstractOriTechTransformOverhaul(String oriTechTransformOverhaulId, Integer recordNum, String objId,
			String projectId, String orgName, String projectName, Integer planningYear, String projectType,
			String majorCategory, String majorDetailCategory, String projectContent, String purposeOfTransformation,
			String voltageLevel, String imageProgress, Double currentYearAccountingMoney, Double currentYearFunds,
			Double totalInvestment, Date xmkssj, Date xmwcsj, String isItRuralNetwork,
			String projectApprovalBasis, String transformationReason, String feasibilityStudyRevieDocNo,
			String feasibilityStudyApproDocNo, String natureOfTheProject, String equipmentCategory, String unit,
			Double assetQuantity, String governanceDirection, String governanceSubCategory, String reviewer,
			String fireFightingOrNot, String adjustBatch, String adjustCategory, Date calYear, String dataVersion,
			String fileName) {
		this.oriTechTransformOverhaulId = oriTechTransformOverhaulId;
		this.recordNum = recordNum;
		this.objId = objId;
		this.projectId = projectId;
		this.orgName = orgName;
		this.projectName = projectName;
		this.planningYear = planningYear;
		this.projectType = projectType;
		this.majorCategory = majorCategory;
		this.majorDetailCategory = majorDetailCategory;
		this.projectContent = projectContent;
		this.purposeOfTransformation = purposeOfTransformation;
		this.voltageLevel = voltageLevel;
		this.imageProgress = imageProgress;
		this.currentYearAccountingMoney = currentYearAccountingMoney;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.xmkssj = xmkssj;
		this.xmwcsj = xmwcsj;
		this.isItRuralNetwork = isItRuralNetwork;
		this.projectApprovalBasis = projectApprovalBasis;
		this.transformationReason = transformationReason;
		this.feasibilityStudyRevieDocNo = feasibilityStudyRevieDocNo;
		this.feasibilityStudyApproDocNo = feasibilityStudyApproDocNo;
		this.natureOfTheProject = natureOfTheProject;
		this.equipmentCategory = equipmentCategory;
		this.unit = unit;
		this.assetQuantity = assetQuantity;
		this.governanceDirection = governanceDirection;
		this.governanceSubCategory = governanceSubCategory;
		this.reviewer = reviewer;
		this.fireFightingOrNot = fireFightingOrNot;
		this.adjustBatch = adjustBatch;
		this.adjustCategory = adjustCategory;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.fileName = fileName;
	}

	// Property accessors

	public String getOriTechTransformOverhaulId() {
		return this.oriTechTransformOverhaulId;
	}

	public void setOriTechTransformOverhaulId(String oriTechTransformOverhaulId) {
		this.oriTechTransformOverhaulId = oriTechTransformOverhaulId;
	}

	public Integer getRecordNum() {
		return this.recordNum;
	}

	public void setRecordNum(Integer recordNum) {
		this.recordNum = recordNum;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getPlanningYear() {
		return this.planningYear;
	}

	public void setPlanningYear(Integer planningYear) {
		this.planningYear = planningYear;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getMajorCategory() {
		return this.majorCategory;
	}

	public void setMajorCategory(String majorCategory) {
		this.majorCategory = majorCategory;
	}

	public String getMajorDetailCategory() {
		return this.majorDetailCategory;
	}

	public void setMajorDetailCategory(String majorDetailCategory) {
		this.majorDetailCategory = majorDetailCategory;
	}

	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getPurposeOfTransformation() {
		return this.purposeOfTransformation;
	}

	public void setPurposeOfTransformation(String purposeOfTransformation) {
		this.purposeOfTransformation = purposeOfTransformation;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getImageProgress() {
		return this.imageProgress;
	}

	public void setImageProgress(String imageProgress) {
		this.imageProgress = imageProgress;
	}

	public Double getCurrentYearAccountingMoney() {
		return this.currentYearAccountingMoney;
	}

	public void setCurrentYearAccountingMoney(Double currentYearAccountingMoney) {
		this.currentYearAccountingMoney = currentYearAccountingMoney;
	}

	public Double getCurrentYearFunds() {
		return this.currentYearFunds;
	}

	public void setCurrentYearFunds(Double currentYearFunds) {
		this.currentYearFunds = currentYearFunds;
	}

	public Double getTotalInvestment() {
		return this.totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public Date getXmkssj() {
		return this.xmkssj;
	}

	public void setXmkssj(Date xmkssj) {
		this.xmkssj = xmkssj;
	}

	public Date getXmwcsj() {
		return this.xmwcsj;
	}

	public void setXmwcsj(Date xmwcsj) {
		this.xmwcsj = xmwcsj;
	}

	public String getIsItRuralNetwork() {
		return this.isItRuralNetwork;
	}

	public void setIsItRuralNetwork(String isItRuralNetwork) {
		this.isItRuralNetwork = isItRuralNetwork;
	}

	public String getProjectApprovalBasis() {
		return this.projectApprovalBasis;
	}

	public void setProjectApprovalBasis(String projectApprovalBasis) {
		this.projectApprovalBasis = projectApprovalBasis;
	}

	public String getTransformationReason() {
		return this.transformationReason;
	}

	public void setTransformationReason(String transformationReason) {
		this.transformationReason = transformationReason;
	}

	public String getFeasibilityStudyRevieDocNo() {
		return this.feasibilityStudyRevieDocNo;
	}

	public void setFeasibilityStudyRevieDocNo(String feasibilityStudyRevieDocNo) {
		this.feasibilityStudyRevieDocNo = feasibilityStudyRevieDocNo;
	}

	public String getFeasibilityStudyApproDocNo() {
		return this.feasibilityStudyApproDocNo;
	}

	public void setFeasibilityStudyApproDocNo(String feasibilityStudyApproDocNo) {
		this.feasibilityStudyApproDocNo = feasibilityStudyApproDocNo;
	}

	public String getNatureOfTheProject() {
		return this.natureOfTheProject;
	}

	public void setNatureOfTheProject(String natureOfTheProject) {
		this.natureOfTheProject = natureOfTheProject;
	}

	public String getEquipmentCategory() {
		return this.equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getAssetQuantity() {
		return this.assetQuantity;
	}

	public void setAssetQuantity(Double assetQuantity) {
		this.assetQuantity = assetQuantity;
	}

	public String getGovernanceDirection() {
		return this.governanceDirection;
	}

	public void setGovernanceDirection(String governanceDirection) {
		this.governanceDirection = governanceDirection;
	}

	public String getGovernanceSubCategory() {
		return this.governanceSubCategory;
	}

	public void setGovernanceSubCategory(String governanceSubCategory) {
		this.governanceSubCategory = governanceSubCategory;
	}

	public String getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getFireFightingOrNot() {
		return this.fireFightingOrNot;
	}

	public void setFireFightingOrNot(String fireFightingOrNot) {
		this.fireFightingOrNot = fireFightingOrNot;
	}

	public String getAdjustBatch() {
		return this.adjustBatch;
	}

	public void setAdjustBatch(String adjustBatch) {
		this.adjustBatch = adjustBatch;
	}

	public String getAdjustCategory() {
		return this.adjustCategory;
	}

	public void setAdjustCategory(String adjustCategory) {
		this.adjustCategory = adjustCategory;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}