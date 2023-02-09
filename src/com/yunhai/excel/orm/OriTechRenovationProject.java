package com.yunhai.excel.orm;

import java.util.Date;


/**
 * OriTechRenovationProject entity. @author MyEclipse Persistence Tools
 */
public class OriTechRenovationProject extends AbstractOriTechRenovationProject implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = 3821315238358047948L;

	/** default constructor */
    public OriTechRenovationProject() {
    }

	/** minimal constructor */
    public OriTechRenovationProject(String oriTechRenovationProjectId) {
        super(oriTechRenovationProjectId);        
    }
    
    /** full constructor */
    public OriTechRenovationProject(String oriTechRenovationProjectId, String dataVersion, Date calYear, String objId, String localCity, String projectName, String plannedYear, String projectType, Double projectScore, String professionalCategory, String professionalSubspecialty, String projectContent, String renovationPurpose, String voltageLevel, String projectDocumentNo, Double currentYearFunds, Double totalInvestment, String assetNature, Date projectStartTime, Date projectEndTime, String ruralPowerNetwork, String preparedPerson, String projectBasis, String renovationReasons, String feasibStudyReviewDocNo, String feasibStudyApproReplyNo, String feasibStudyReviewComments, String feasibStudyApprovalDocument, String projectNature) {
        super(oriTechRenovationProjectId, dataVersion, calYear, objId, localCity, projectName, plannedYear, projectType, projectScore, professionalCategory, professionalSubspecialty, projectContent, renovationPurpose, voltageLevel, projectDocumentNo, currentYearFunds, totalInvestment, assetNature, projectStartTime, projectEndTime, ruralPowerNetwork, preparedPerson, projectBasis, renovationReasons, feasibStudyReviewDocNo, feasibStudyApproReplyNo, feasibStudyReviewComments, feasibStudyApprovalDocument, projectNature);        
    }

	public OriTechRenovationProject(String oriTechRenovationProjectId, String dataVersion, Date calYear, String objId,
			String localCity, String projectName, String plannedYear, String projectType, Double projectScore,
			String professionalCategory, String professionalSubspecialty, String projectContent,
			String renovationPurpose, String voltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetNature, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String preparedPerson, String projectBasis, String renovationReasons,
			String feasibStudyReviewDocNo, String feasibStudyApproReplyNo, String feasibStudyReviewComments,
			String feasibStudyApprovalDocument, String projectNature, String dataSourceFile) {
		super(oriTechRenovationProjectId, dataVersion, calYear, objId, localCity, projectName, plannedYear, projectType,
				projectScore, professionalCategory, professionalSubspecialty, projectContent, renovationPurpose, voltageLevel,
				projectDocumentNo, currentYearFunds, totalInvestment, assetNature, projectStartTime, projectEndTime,
				ruralPowerNetwork, preparedPerson, projectBasis, renovationReasons, feasibStudyReviewDocNo,
				feasibStudyApproReplyNo, feasibStudyReviewComments, feasibStudyApprovalDocument, projectNature, dataSourceFile);
		// TODO Auto-generated constructor stub
	}
   
}
