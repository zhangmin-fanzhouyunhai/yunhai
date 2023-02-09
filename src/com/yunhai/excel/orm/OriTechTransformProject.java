package com.yunhai.excel.orm;

import java.util.Date;


/**
 * OriTechTransformProject entity. @author MyEclipse Persistence Tools
 */
public class OriTechTransformProject extends AbstractOriTechTransformProject implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public OriTechTransformProject() {
    }

	/** minimal constructor */
    public OriTechTransformProject(String oriTechTransformProjectId) {
        super(oriTechTransformProjectId);        
    }
    
    /** full constructor */
    public OriTechTransformProject(String oriTechTransformProjectId, Integer recordNum, String objId, String projectId, String orgName, String projectName, Integer planningYear, String projectType, String majorCategory, String majorDetailCategory, String projectContent, String purposeOfTransformation, String voltageLevel, String imageProgress, Double currentYearAccountingMoney, Double currentYearFunds, Double totalInvestment, Date xmkssj, Date xmwcsj, String isItRuralNetwork, String projectApprovalBasis, String transformationReason, String feasibilityStudyRevieDocNo, String feasibilityStudyApproDocNo, String natureOfTheProject, String equipmentCategory, String unit, Double assetQuantity, String governanceDirection, String governanceSubCategory, String reviewer, String fireFightingOrNot, String adjustBatch, String adjustCategory, Date calYear, String dataVersion, String fileName) {
        super(oriTechTransformProjectId, recordNum, objId, projectId, orgName, projectName, planningYear, projectType, majorCategory, majorDetailCategory, projectContent, purposeOfTransformation, voltageLevel, imageProgress, currentYearAccountingMoney, currentYearFunds, totalInvestment, xmkssj, xmwcsj, isItRuralNetwork, projectApprovalBasis, transformationReason, feasibilityStudyRevieDocNo, feasibilityStudyApproDocNo, natureOfTheProject, equipmentCategory, unit, assetQuantity, governanceDirection, governanceSubCategory, reviewer, fireFightingOrNot, adjustBatch, adjustCategory, calYear, dataVersion, fileName);        
    }
   
}
