package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractTechRefProSinEngDecompose entity provides the base persistence definition of the TechRefProSinEngDecompose entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTechRefProSinEngDecompose  implements java.io.Serializable {


    // Fields    

     private String techRefProSinEngDecompId;
     private String version;
     private Date calYear;
     private Integer indexof;
     private String projectManageOrgName;
     private String projectImplementOrgName;
     private String assetRpoperty;
     private String substationLineVoltageLevel;
     private String projectId;
     private String projectName;
     private String singleProjectType;
     private String reformEquipVoltageLevel;
     private String singleProjectContent;
     private Date technicalReformStartTime;
     private Date technicalReformEndTime;
     private String preRegulationVersion;
     private String transformerEquipmentModel;
     private Double transformerReformQuantity;
     private Double transformerSingleCapacity;
     private Double transformerAftTaxUnitPrice;
     private String circuitBreakerModel;
     private Double ratedCurrent;
     private Double circuitBreakReformQuantity;
     private Double circuBreakAftTaxUnitPrice;
     private String isolatingSwitStuctureModel;
     private Double isolatingSwitReformQuantity;
     private Double isolatSwitAftTaxUnitPrice;
     private Double constructionCost;
     private Double equipmentPurchaseCost;
     private Double totalInstallEngineeringCost;
     private Double aftTaxInstallDevMaterCost;
     private Double demolitionCost;
     private Double totalOtherCost;
     private Double staticInvestment;
     private String befTechniReformEquipErpId;
     private String befTechniReformEquipPmsId;
     private String befTechRefoEquipWorkStat;
     private String equipTechnicalReformReason;
     private String techRefoFeasibOrigDesiDoc;
     private Double residueRatio;
     private String equipmentDealStation;
     private Double assetActualUsedAge;
     private Double discardAssetAge;
     private String afterTechnicalReformErpId;
     private String afterTechnicalReformPmsId;
     private Double aftTechRefSerAbnStaTimes;
     private Double aftTechRefDefectTimes;
     private String aftTechRefAchieSolProBen;
     private String postEvaluationReport;
     private Double historicalDefectTimes;
     private Double discarcAge;
     private Double aftTechReformDefectTimes;
     private Double workingAge;


    // Constructors

    /** default constructor */
    public AbstractTechRefProSinEngDecompose() {
    }

    
    /** full constructor */
    public AbstractTechRefProSinEngDecompose(String version,Date calYear, Integer indexof, String projectManageOrgName, String projectImplementOrgName, String assetRpoperty, String substationLineVoltageLevel, String projectId, String projectName, String singleProjectType, String reformEquipVoltageLevel, String singleProjectContent, Date technicalReformStartTime, Date technicalReformEndTime, String preRegulationVersion, String transformerEquipmentModel, Double transformerReformQuantity, Double transformerSingleCapacity, Double transformerAftTaxUnitPrice, String circuitBreakerModel, Double ratedCurrent, Double circuitBreakReformQuantity, Double circuBreakAftTaxUnitPrice, String isolatingSwitStuctureModel, Double isolatingSwitReformQuantity, Double isolatSwitAftTaxUnitPrice, Double constructionCost, Double equipmentPurchaseCost, Double totalInstallEngineeringCost, Double aftTaxInstallDevMaterCost, Double demolitionCost, Double totalOtherCost, Double staticInvestment, String befTechniReformEquipErpId, String befTechniReformEquipPmsId, String befTechRefoEquipWorkStat, String equipTechnicalReformReason, String techRefoFeasibOrigDesiDoc, Double residueRatio, String equipmentDealStation, Double assetActualUsedAge, Double discardAssetAge, String afterTechnicalReformErpId, String afterTechnicalReformPmsId, Double aftTechRefSerAbnStaTimes, Double aftTechRefDefectTimes, String aftTechRefAchieSolProBen, String postEvaluationReport, Double historicalDefectTimes, Double discarcAge, Double aftTechReformDefectTimes, Double workingAge) {
    	this.version = version;
        this.calYear = calYear;
        this.indexof = indexof;
        this.projectManageOrgName = projectManageOrgName;
        this.projectImplementOrgName = projectImplementOrgName;
        this.assetRpoperty = assetRpoperty;
        this.substationLineVoltageLevel = substationLineVoltageLevel;
        this.projectId = projectId;
        this.projectName = projectName;
        this.singleProjectType = singleProjectType;
        this.reformEquipVoltageLevel = reformEquipVoltageLevel;
        this.singleProjectContent = singleProjectContent;
        this.technicalReformStartTime = technicalReformStartTime;
        this.technicalReformEndTime = technicalReformEndTime;
        this.preRegulationVersion = preRegulationVersion;
        this.transformerEquipmentModel = transformerEquipmentModel;
        this.transformerReformQuantity = transformerReformQuantity;
        this.transformerSingleCapacity = transformerSingleCapacity;
        this.transformerAftTaxUnitPrice = transformerAftTaxUnitPrice;
        this.circuitBreakerModel = circuitBreakerModel;
        this.ratedCurrent = ratedCurrent;
        this.circuitBreakReformQuantity = circuitBreakReformQuantity;
        this.circuBreakAftTaxUnitPrice = circuBreakAftTaxUnitPrice;
        this.isolatingSwitStuctureModel = isolatingSwitStuctureModel;
        this.isolatingSwitReformQuantity = isolatingSwitReformQuantity;
        this.isolatSwitAftTaxUnitPrice = isolatSwitAftTaxUnitPrice;
        this.constructionCost = constructionCost;
        this.equipmentPurchaseCost = equipmentPurchaseCost;
        this.totalInstallEngineeringCost = totalInstallEngineeringCost;
        this.aftTaxInstallDevMaterCost = aftTaxInstallDevMaterCost;
        this.demolitionCost = demolitionCost;
        this.totalOtherCost = totalOtherCost;
        this.staticInvestment = staticInvestment;
        this.befTechniReformEquipErpId = befTechniReformEquipErpId;
        this.befTechniReformEquipPmsId = befTechniReformEquipPmsId;
        this.befTechRefoEquipWorkStat = befTechRefoEquipWorkStat;
        this.equipTechnicalReformReason = equipTechnicalReformReason;
        this.techRefoFeasibOrigDesiDoc = techRefoFeasibOrigDesiDoc;
        this.residueRatio = residueRatio;
        this.equipmentDealStation = equipmentDealStation;
        this.assetActualUsedAge = assetActualUsedAge;
        this.discardAssetAge = discardAssetAge;
        this.afterTechnicalReformErpId = afterTechnicalReformErpId;
        this.afterTechnicalReformPmsId = afterTechnicalReformPmsId;
        this.aftTechRefSerAbnStaTimes = aftTechRefSerAbnStaTimes;
        this.aftTechRefDefectTimes = aftTechRefDefectTimes;
        this.aftTechRefAchieSolProBen = aftTechRefAchieSolProBen;
        this.postEvaluationReport = postEvaluationReport;
        this.historicalDefectTimes = historicalDefectTimes;
        this.discarcAge = discarcAge;
        this.aftTechReformDefectTimes = aftTechReformDefectTimes;
        this.workingAge = workingAge;
    }

   
    // Property accessors

    public String getTechRefProSinEngDecompId() {
        return this.techRefProSinEngDecompId;
    }
    
    public void setTechRefProSinEngDecompId(String techRefProSinEngDecompId) {
        this.techRefProSinEngDecompId = techRefProSinEngDecompId;
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

    public Integer getIndexof() {
        return this.indexof;
    }
    
    public void setIndexof(Integer indexof) {
        this.indexof = indexof;
    }

    public String getProjectManageOrgName() {
        return this.projectManageOrgName;
    }
    
    public void setProjectManageOrgName(String projectManageOrgName) {
        this.projectManageOrgName = projectManageOrgName;
    }

    public String getProjectImplementOrgName() {
        return this.projectImplementOrgName;
    }
    
    public void setProjectImplementOrgName(String projectImplementOrgName) {
        this.projectImplementOrgName = projectImplementOrgName;
    }

    public String getAssetRpoperty() {
        return this.assetRpoperty;
    }
    
    public void setAssetRpoperty(String assetRpoperty) {
        this.assetRpoperty = assetRpoperty;
    }

    public String getSubstationLineVoltageLevel() {
        return this.substationLineVoltageLevel;
    }
    
    public void setSubstationLineVoltageLevel(String substationLineVoltageLevel) {
        this.substationLineVoltageLevel = substationLineVoltageLevel;
    }

    public String getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSingleProjectType() {
        return this.singleProjectType;
    }
    
    public void setSingleProjectType(String singleProjectType) {
        this.singleProjectType = singleProjectType;
    }

    public String getReformEquipVoltageLevel() {
        return this.reformEquipVoltageLevel;
    }
    
    public void setReformEquipVoltageLevel(String reformEquipVoltageLevel) {
        this.reformEquipVoltageLevel = reformEquipVoltageLevel;
    }

    public String getSingleProjectContent() {
        return this.singleProjectContent;
    }
    
    public void setSingleProjectContent(String singleProjectContent) {
        this.singleProjectContent = singleProjectContent;
    }

    public Date getTechnicalReformStartTime() {
        return this.technicalReformStartTime;
    }
    
    public void setTechnicalReformStartTime(Date technicalReformStartTime) {
        this.technicalReformStartTime = technicalReformStartTime;
    }

    public Date getTechnicalReformEndTime() {
        return this.technicalReformEndTime;
    }
    
    public void setTechnicalReformEndTime(Date technicalReformEndTime) {
        this.technicalReformEndTime = technicalReformEndTime;
    }

    public String getPreRegulationVersion() {
        return this.preRegulationVersion;
    }
    
    public void setPreRegulationVersion(String preRegulationVersion) {
        this.preRegulationVersion = preRegulationVersion;
    }

    public String getTransformerEquipmentModel() {
        return this.transformerEquipmentModel;
    }
    
    public void setTransformerEquipmentModel(String transformerEquipmentModel) {
        this.transformerEquipmentModel = transformerEquipmentModel;
    }

    public Double getTransformerReformQuantity() {
        return this.transformerReformQuantity;
    }
    
    public void setTransformerReformQuantity(Double transformerReformQuantity) {
        this.transformerReformQuantity = transformerReformQuantity;
    }

    public Double getTransformerSingleCapacity() {
        return this.transformerSingleCapacity;
    }
    
    public void setTransformerSingleCapacity(Double transformerSingleCapacity) {
        this.transformerSingleCapacity = transformerSingleCapacity;
    }

    public Double getTransformerAftTaxUnitPrice() {
        return this.transformerAftTaxUnitPrice;
    }
    
    public void setTransformerAftTaxUnitPrice(Double transformerAftTaxUnitPrice) {
        this.transformerAftTaxUnitPrice = transformerAftTaxUnitPrice;
    }

    public String getCircuitBreakerModel() {
        return this.circuitBreakerModel;
    }
    
    public void setCircuitBreakerModel(String circuitBreakerModel) {
        this.circuitBreakerModel = circuitBreakerModel;
    }

    public Double getRatedCurrent() {
        return this.ratedCurrent;
    }
    
    public void setRatedCurrent(Double ratedCurrent) {
        this.ratedCurrent = ratedCurrent;
    }

    public Double getCircuitBreakReformQuantity() {
        return this.circuitBreakReformQuantity;
    }
    
    public void setCircuitBreakReformQuantity(Double circuitBreakReformQuantity) {
        this.circuitBreakReformQuantity = circuitBreakReformQuantity;
    }

    public Double getCircuBreakAftTaxUnitPrice() {
        return this.circuBreakAftTaxUnitPrice;
    }
    
    public void setCircuBreakAftTaxUnitPrice(Double circuBreakAftTaxUnitPrice) {
        this.circuBreakAftTaxUnitPrice = circuBreakAftTaxUnitPrice;
    }

    public String getIsolatingSwitStuctureModel() {
        return this.isolatingSwitStuctureModel;
    }
    
    public void setIsolatingSwitStuctureModel(String isolatingSwitStuctureModel) {
        this.isolatingSwitStuctureModel = isolatingSwitStuctureModel;
    }

    public Double getIsolatingSwitReformQuantity() {
        return this.isolatingSwitReformQuantity;
    }
    
    public void setIsolatingSwitReformQuantity(Double isolatingSwitReformQuantity) {
        this.isolatingSwitReformQuantity = isolatingSwitReformQuantity;
    }

    public Double getIsolatSwitAftTaxUnitPrice() {
        return this.isolatSwitAftTaxUnitPrice;
    }
    
    public void setIsolatSwitAftTaxUnitPrice(Double isolatSwitAftTaxUnitPrice) {
        this.isolatSwitAftTaxUnitPrice = isolatSwitAftTaxUnitPrice;
    }

    public Double getConstructionCost() {
        return this.constructionCost;
    }
    
    public void setConstructionCost(Double constructionCost) {
        this.constructionCost = constructionCost;
    }

    public Double getEquipmentPurchaseCost() {
        return this.equipmentPurchaseCost;
    }
    
    public void setEquipmentPurchaseCost(Double equipmentPurchaseCost) {
        this.equipmentPurchaseCost = equipmentPurchaseCost;
    }

    public Double getTotalInstallEngineeringCost() {
        return this.totalInstallEngineeringCost;
    }
    
    public void setTotalInstallEngineeringCost(Double totalInstallEngineeringCost) {
        this.totalInstallEngineeringCost = totalInstallEngineeringCost;
    }

    public Double getAftTaxInstallDevMaterCost() {
        return this.aftTaxInstallDevMaterCost;
    }
    
    public void setAftTaxInstallDevMaterCost(Double aftTaxInstallDevMaterCost) {
        this.aftTaxInstallDevMaterCost = aftTaxInstallDevMaterCost;
    }

    public Double getDemolitionCost() {
        return this.demolitionCost;
    }
    
    public void setDemolitionCost(Double demolitionCost) {
        this.demolitionCost = demolitionCost;
    }

    public Double getTotalOtherCost() {
        return this.totalOtherCost;
    }
    
    public void setTotalOtherCost(Double totalOtherCost) {
        this.totalOtherCost = totalOtherCost;
    }

    public Double getStaticInvestment() {
        return this.staticInvestment;
    }
    
    public void setStaticInvestment(Double staticInvestment) {
        this.staticInvestment = staticInvestment;
    }

    public String getBefTechniReformEquipErpId() {
        return this.befTechniReformEquipErpId;
    }
    
    public void setBefTechniReformEquipErpId(String befTechniReformEquipErpId) {
        this.befTechniReformEquipErpId = befTechniReformEquipErpId;
    }

    public String getBefTechniReformEquipPmsId() {
        return this.befTechniReformEquipPmsId;
    }
    
    public void setBefTechniReformEquipPmsId(String befTechniReformEquipPmsId) {
        this.befTechniReformEquipPmsId = befTechniReformEquipPmsId;
    }

    public String getBefTechRefoEquipWorkStat() {
        return this.befTechRefoEquipWorkStat;
    }
    
    public void setBefTechRefoEquipWorkStat(String befTechRefoEquipWorkStat) {
        this.befTechRefoEquipWorkStat = befTechRefoEquipWorkStat;
    }

    public String getEquipTechnicalReformReason() {
        return this.equipTechnicalReformReason;
    }
    
    public void setEquipTechnicalReformReason(String equipTechnicalReformReason) {
        this.equipTechnicalReformReason = equipTechnicalReformReason;
    }

    public String getTechRefoFeasibOrigDesiDoc() {
        return this.techRefoFeasibOrigDesiDoc;
    }
    
    public void setTechRefoFeasibOrigDesiDoc(String techRefoFeasibOrigDesiDoc) {
        this.techRefoFeasibOrigDesiDoc = techRefoFeasibOrigDesiDoc;
    }

    public Double getResidueRatio() {
        return this.residueRatio;
    }
    
    public void setResidueRatio(Double residueRatio) {
        this.residueRatio = residueRatio;
    }

    public String getEquipmentDealStation() {
        return this.equipmentDealStation;
    }
    
    public void setEquipmentDealStation(String equipmentDealStation) {
        this.equipmentDealStation = equipmentDealStation;
    }

    public Double getAssetActualUsedAge() {
        return this.assetActualUsedAge;
    }
    
    public void setAssetActualUsedAge(Double assetActualUsedAge) {
        this.assetActualUsedAge = assetActualUsedAge;
    }

    public Double getDiscardAssetAge() {
        return this.discardAssetAge;
    }
    
    public void setDiscardAssetAge(Double discardAssetAge) {
        this.discardAssetAge = discardAssetAge;
    }

    public String getAfterTechnicalReformErpId() {
        return this.afterTechnicalReformErpId;
    }
    
    public void setAfterTechnicalReformErpId(String afterTechnicalReformErpId) {
        this.afterTechnicalReformErpId = afterTechnicalReformErpId;
    }

    public String getAfterTechnicalReformPmsId() {
        return this.afterTechnicalReformPmsId;
    }
    
    public void setAfterTechnicalReformPmsId(String afterTechnicalReformPmsId) {
        this.afterTechnicalReformPmsId = afterTechnicalReformPmsId;
    }

    public Double getAftTechRefSerAbnStaTimes() {
        return this.aftTechRefSerAbnStaTimes;
    }
    
    public void setAftTechRefSerAbnStaTimes(Double aftTechRefSerAbnStaTimes) {
        this.aftTechRefSerAbnStaTimes = aftTechRefSerAbnStaTimes;
    }

    public Double getAftTechRefDefectTimes() {
        return this.aftTechRefDefectTimes;
    }
    
    public void setAftTechRefDefectTimes(Double aftTechRefDefectTimes) {
        this.aftTechRefDefectTimes = aftTechRefDefectTimes;
    }

    public String getAftTechRefAchieSolProBen() {
        return this.aftTechRefAchieSolProBen;
    }
    
    public void setAftTechRefAchieSolProBen(String aftTechRefAchieSolProBen) {
        this.aftTechRefAchieSolProBen = aftTechRefAchieSolProBen;
    }

    public String getPostEvaluationReport() {
        return this.postEvaluationReport;
    }
    
    public void setPostEvaluationReport(String postEvaluationReport) {
        this.postEvaluationReport = postEvaluationReport;
    }

    public Double getHistoricalDefectTimes() {
        return this.historicalDefectTimes;
    }
    
    public void setHistoricalDefectTimes(Double historicalDefectTimes) {
        this.historicalDefectTimes = historicalDefectTimes;
    }

    public Double getDiscarcAge() {
        return this.discarcAge;
    }
    
    public void setDiscarcAge(Double discarcAge) {
        this.discarcAge = discarcAge;
    }

    public Double getAftTechReformDefectTimes() {
        return this.aftTechReformDefectTimes;
    }
    
    public void setAftTechReformDefectTimes(Double aftTechReformDefectTimes) {
        this.aftTechReformDefectTimes = aftTechReformDefectTimes;
    }

    public Double getWorkingAge() {
        return this.workingAge;
    }
    
    public void setWorkingAge(Double workingAge) {
        this.workingAge = workingAge;
    }
   








}