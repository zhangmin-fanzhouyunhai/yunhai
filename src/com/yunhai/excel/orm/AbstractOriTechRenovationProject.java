package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractOriTechRenovationProject entity provides the base persistence definition of the OriTechRenovationProject entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriTechRenovationProject  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -2474767237494424530L;
	private String oriTechRenovationProjectId;
     private String dataVersion;
     private Date calYear;
     private String objId;
     private String localCity;
     private String projectName;
     private String plannedYear;
     private String projectType;
     private Double projectScore;
     private String professionalCategory;
     private String professionalSubspecialty;
     private String projectContent;
     private String renovationPurpose;
     private String voltageLevel;
     private String projectDocumentNo;
     private Double currentYearFunds;
     private Double totalInvestment;
     private String assetNature;
     private Date projectStartTime;
     private Date projectEndTime;
     private String ruralPowerNetwork;
     private String preparedPerson;
     private String projectBasis;
     private String renovationReasons;
     private String feasibStudyReviewDocNo;
     private String feasibStudyApproReplyNo;
     private String feasibStudyReviewComments;
     private String feasibStudyApprovalDocument;
     private String projectNature;
 	 private String dataSourceFile;


    // Constructors

    /** default constructor */
    public AbstractOriTechRenovationProject() {
    }

	/** minimal constructor */
    public AbstractOriTechRenovationProject(String oriTechRenovationProjectId) {
        this.oriTechRenovationProjectId = oriTechRenovationProjectId;
    }
    
    /** full constructor */
    public AbstractOriTechRenovationProject(String oriTechRenovationProjectId, String dataVersion, Date calYear, String objId, String localCity, String projectName, String plannedYear, String projectType, Double projectScore, String professionalCategory, String professionalSubspecialty, String projectContent, String renovationPurpose, String voltageLevel, String projectDocumentNo, Double currentYearFunds, Double totalInvestment, String assetNature, Date projectStartTime, Date projectEndTime, String ruralPowerNetwork, String preparedPerson, String projectBasis, String renovationReasons, String feasibStudyReviewDocNo, String feasibStudyApproReplyNo, String feasibStudyReviewComments, String feasibStudyApprovalDocument, String projectNature) {
        this.oriTechRenovationProjectId = oriTechRenovationProjectId;
        this.dataVersion = dataVersion;
        this.calYear = calYear;
        this.objId = objId;
        this.localCity = localCity;
        this.projectName = projectName;
        this.plannedYear = plannedYear;
        this.projectType = projectType;
        this.projectScore = projectScore;
        this.professionalCategory = professionalCategory;
        this.professionalSubspecialty = professionalSubspecialty;
        this.projectContent = projectContent;
        this.renovationPurpose = renovationPurpose;
        this.voltageLevel = voltageLevel;
        this.projectDocumentNo = projectDocumentNo;
        this.currentYearFunds = currentYearFunds;
        this.totalInvestment = totalInvestment;
        this.assetNature = assetNature;
        this.projectStartTime = projectStartTime;
        this.projectEndTime = projectEndTime;
        this.ruralPowerNetwork = ruralPowerNetwork;
        this.preparedPerson = preparedPerson;
        this.projectBasis = projectBasis;
        this.renovationReasons = renovationReasons;
        this.feasibStudyReviewDocNo = feasibStudyReviewDocNo;
        this.feasibStudyApproReplyNo = feasibStudyApproReplyNo;
        this.feasibStudyReviewComments = feasibStudyReviewComments;
        this.feasibStudyApprovalDocument = feasibStudyApprovalDocument;
        this.projectNature = projectNature;
    }

   
    // Property accessors

    public AbstractOriTechRenovationProject(String oriTechRenovationProjectId, String dataVersion, Date calYear,
			String objId, String localCity, String projectName, String plannedYear, String projectType,
			Double projectScore, String professionalCategory, String professionalSubspecialty, String projectContent,
			String renovationPurpose, String voltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetNature, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String preparedPerson, String projectBasis, String renovationReasons,
			String feasibStudyReviewDocNo, String feasibStudyApproReplyNo, String feasibStudyReviewComments,
			String feasibStudyApprovalDocument, String projectNature, String dataSourceFile) {
		super();
		this.oriTechRenovationProjectId = oriTechRenovationProjectId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.objId = objId;
		this.localCity = localCity;
		this.projectName = projectName;
		this.plannedYear = plannedYear;
		this.projectType = projectType;
		this.projectScore = projectScore;
		this.professionalCategory = professionalCategory;
		this.professionalSubspecialty = professionalSubspecialty;
		this.projectContent = projectContent;
		this.renovationPurpose = renovationPurpose;
		this.voltageLevel = voltageLevel;
		this.projectDocumentNo = projectDocumentNo;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.assetNature = assetNature;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.ruralPowerNetwork = ruralPowerNetwork;
		this.preparedPerson = preparedPerson;
		this.projectBasis = projectBasis;
		this.renovationReasons = renovationReasons;
		this.feasibStudyReviewDocNo = feasibStudyReviewDocNo;
		this.feasibStudyApproReplyNo = feasibStudyApproReplyNo;
		this.feasibStudyReviewComments = feasibStudyReviewComments;
		this.feasibStudyApprovalDocument = feasibStudyApprovalDocument;
		this.projectNature = projectNature;
		this.dataSourceFile = dataSourceFile;
	}

	public String getOriTechRenovationProjectId() {
        return this.oriTechRenovationProjectId;
    }
    
    public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOriTechRenovationProjectId(String oriTechRenovationProjectId) {
        this.oriTechRenovationProjectId = oriTechRenovationProjectId;
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

    public String getObjId() {
        return this.objId;
    }
    
    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getLocalCity() {
        return this.localCity;
    }
    
    public void setLocalCity(String localCity) {
        this.localCity = localCity;
    }

    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPlannedYear() {
        return this.plannedYear;
    }
    
    public void setPlannedYear(String plannedYear) {
        this.plannedYear = plannedYear;
    }

    public String getProjectType() {
        return this.projectType;
    }
    
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Double getProjectScore() {
        return this.projectScore;
    }
    
    public void setProjectScore(Double projectScore) {
        this.projectScore = projectScore;
    }

    public String getProfessionalCategory() {
        return this.professionalCategory;
    }
    
    public void setProfessionalCategory(String professionalCategory) {
        this.professionalCategory = professionalCategory;
    }

    public String getProfessionalSubspecialty() {
        return this.professionalSubspecialty;
    }
    
    public void setProfessionalSubspecialty(String professionalSubspecialty) {
        this.professionalSubspecialty = professionalSubspecialty;
    }

    public String getProjectContent() {
        return this.projectContent;
    }
    
    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getRenovationPurpose() {
        return this.renovationPurpose;
    }
    
    public void setRenovationPurpose(String renovationPurpose) {
        this.renovationPurpose = renovationPurpose;
    }

    public String getVoltageLevel() {
        return this.voltageLevel;
    }
    
    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getProjectDocumentNo() {
        return this.projectDocumentNo;
    }
    
    public void setProjectDocumentNo(String projectDocumentNo) {
        this.projectDocumentNo = projectDocumentNo;
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

    public String getAssetNature() {
        return this.assetNature;
    }
    
    public void setAssetNature(String assetNature) {
        this.assetNature = assetNature;
    }

    public Date getProjectStartTime() {
        return this.projectStartTime;
    }
    
    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return this.projectEndTime;
    }
    
    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public String getRuralPowerNetwork() {
        return this.ruralPowerNetwork;
    }
    
    public void setRuralPowerNetwork(String ruralPowerNetwork) {
        this.ruralPowerNetwork = ruralPowerNetwork;
    }

    public String getPreparedPerson() {
        return this.preparedPerson;
    }
    
    public void setPreparedPerson(String preparedPerson) {
        this.preparedPerson = preparedPerson;
    }

    public String getProjectBasis() {
        return this.projectBasis;
    }
    
    public void setProjectBasis(String projectBasis) {
        this.projectBasis = projectBasis;
    }

    public String getRenovationReasons() {
        return this.renovationReasons;
    }
    
    public void setRenovationReasons(String renovationReasons) {
        this.renovationReasons = renovationReasons;
    }

    public String getFeasibStudyReviewDocNo() {
        return this.feasibStudyReviewDocNo;
    }
    
    public void setFeasibStudyReviewDocNo(String feasibStudyReviewDocNo) {
        this.feasibStudyReviewDocNo = feasibStudyReviewDocNo;
    }

    public String getFeasibStudyApproReplyNo() {
        return this.feasibStudyApproReplyNo;
    }
    
    public void setFeasibStudyApproReplyNo(String feasibStudyApproReplyNo) {
        this.feasibStudyApproReplyNo = feasibStudyApproReplyNo;
    }

    public String getFeasibStudyReviewComments() {
        return this.feasibStudyReviewComments;
    }
    
    public void setFeasibStudyReviewComments(String feasibStudyReviewComments) {
        this.feasibStudyReviewComments = feasibStudyReviewComments;
    }

    public String getFeasibStudyApprovalDocument() {
        return this.feasibStudyApprovalDocument;
    }
    
    public void setFeasibStudyApprovalDocument(String feasibStudyApprovalDocument) {
        this.feasibStudyApprovalDocument = feasibStudyApprovalDocument;
    }

    public String getProjectNature() {
        return this.projectNature;
    }
    
    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
    }
   








}