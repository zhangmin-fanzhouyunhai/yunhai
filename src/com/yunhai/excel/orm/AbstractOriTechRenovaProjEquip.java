package com.yunhai.excel.orm;
 
import java.util.Date;

/**
 * AbstractOriTechRenovaProjEquip entity provides the base persistence
 * definition of the OriTechRenovaProjEquip entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriTechRenovaProjEquip implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4588617164581657566L;
	private String oriTechRenovaProjEquipId;
	private String dataVersion;
	private Date calYear;
	private String objId;
	private String localCity;
	private String entryName;
	private String plannedYear;
	private String projectType;
	private Double itemScore;
	private String professionalCategory;
	private String professionalSegmentation;
	private String projectContent;
	private String transformationPurpose;
	private String projectVoltageLevel;
	private String projectDocumentNo;
	private Double currentYearFunds;
	private Double totalInvestment;
	private String assetProperty;
	private Date projectStartTime;
	private Date projectEndTime;
	private String ruralPowerNetwork;
	private String transformationReasons;
	private String equipmentType;
	private String equipmentCode;
	private String equipmentVoltageLevel;
	private String equipmentModel;
	private Date operationDate;
	private Double equipmentCapacity;
	private String dataSourceFile;
	private String substationLineName;

	// Constructors

	/** default constructor */
	public AbstractOriTechRenovaProjEquip() {
	}

	public AbstractOriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String dataVersion, Date calYear,
			String objId, String localCity, String entryName, String plannedYear, String projectType, Double itemScore,
			String professionalCategory, String professionalSegmentation, String projectContent,
			String transformationPurpose, String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetProperty, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String transformationReasons, String equipmentType, String equipmentCode,
			String equipmentVoltageLevel, String equipmentModel, Date operationDate, Double equipmentCapacity,
			String dataSourceFile) {
		super();
		this.oriTechRenovaProjEquipId = oriTechRenovaProjEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.objId = objId;
		this.localCity = localCity;
		this.entryName = entryName;
		this.plannedYear = plannedYear;
		this.projectType = projectType;
		this.itemScore = itemScore;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.projectContent = projectContent;
		this.transformationPurpose = transformationPurpose;
		this.projectVoltageLevel = projectVoltageLevel;
		this.projectDocumentNo = projectDocumentNo;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.assetProperty = assetProperty;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.ruralPowerNetwork = ruralPowerNetwork;
		this.transformationReasons = transformationReasons;
		this.equipmentType = equipmentType;
		this.equipmentCode = equipmentCode;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.equipmentModel = equipmentModel;
		this.operationDate = operationDate;
		this.equipmentCapacity = equipmentCapacity;
		this.dataSourceFile = dataSourceFile;
	}

	/** minimal constructor */
	public AbstractOriTechRenovaProjEquip(String oriTechRenovaProjEquipId) {
		this.oriTechRenovaProjEquipId = oriTechRenovaProjEquipId;
	}

	/** full constructor */
	public AbstractOriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String objId, String localCity,
			String entryName, String plannedYear, String projectType, Double itemScore, String professionalCategory,
			String professionalSegmentation, String projectContent, String transformationPurpose,
			String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds, Double totalInvestment,
			String assetProperty, Date projectStartTime, Date projectEndTime, String ruralPowerNetwork,
			String transformationReasons, String equipmentType, String equipmentCode, String equipmentVoltageLevel,
			String equipmentModel, Date operationDate, Double equipmentCapacity) {
		this.oriTechRenovaProjEquipId = oriTechRenovaProjEquipId;
		this.objId = objId;
		this.localCity = localCity;
		this.entryName = entryName;
		this.plannedYear = plannedYear;
		this.projectType = projectType;
		this.itemScore = itemScore;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.projectContent = projectContent;
		this.transformationPurpose = transformationPurpose;
		this.projectVoltageLevel = projectVoltageLevel;
		this.projectDocumentNo = projectDocumentNo;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.assetProperty = assetProperty;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.ruralPowerNetwork = ruralPowerNetwork;
		this.transformationReasons = transformationReasons;
		this.equipmentType = equipmentType;
		this.equipmentCode = equipmentCode;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.equipmentModel = equipmentModel;
		this.operationDate = operationDate;
		this.equipmentCapacity = equipmentCapacity;
	}

	
	public AbstractOriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String dataVersion, Date calYear,
			String objId, String localCity, String entryName, String plannedYear, String projectType, Double itemScore,
			String professionalCategory, String professionalSegmentation, String projectContent,
			String transformationPurpose, String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetProperty, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String transformationReasons, String equipmentType, String equipmentCode,
			String equipmentVoltageLevel, String equipmentModel, Date operationDate, Double equipmentCapacity,
			String dataSourceFile, String substationLineName) {
		super();
		this.oriTechRenovaProjEquipId = oriTechRenovaProjEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.objId = objId;
		this.localCity = localCity;
		this.entryName = entryName;
		this.plannedYear = plannedYear;
		this.projectType = projectType;
		this.itemScore = itemScore;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.projectContent = projectContent;
		this.transformationPurpose = transformationPurpose;
		this.projectVoltageLevel = projectVoltageLevel;
		this.projectDocumentNo = projectDocumentNo;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.assetProperty = assetProperty;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.ruralPowerNetwork = ruralPowerNetwork;
		this.transformationReasons = transformationReasons;
		this.equipmentType = equipmentType;
		this.equipmentCode = equipmentCode;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
		this.equipmentModel = equipmentModel;
		this.operationDate = operationDate;
		this.equipmentCapacity = equipmentCapacity;
		this.dataSourceFile = dataSourceFile;
		this.substationLineName = substationLineName;
	}

	// Property accessors

	
	public String getOriTechRenovaProjEquipId() {
		return this.oriTechRenovaProjEquipId;
	}

	public String getSubstationLineName() {
		return substationLineName;
	}

	public void setSubstationLineName(String substationLineName) {
		this.substationLineName = substationLineName;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setOriTechRenovaProjEquipId(String oriTechRenovaProjEquipId) {
		this.oriTechRenovaProjEquipId = oriTechRenovaProjEquipId;
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

	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
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

	public Double getItemScore() {
		return this.itemScore;
	}

	public void setItemScore(Double itemScore) {
		this.itemScore = itemScore;
	}

	public String getProfessionalCategory() {
		return this.professionalCategory;
	}

	public void setProfessionalCategory(String professionalCategory) {
		this.professionalCategory = professionalCategory;
	}

	public String getProfessionalSegmentation() {
		return this.professionalSegmentation;
	}

	public void setProfessionalSegmentation(String professionalSegmentation) {
		this.professionalSegmentation = professionalSegmentation;
	}

	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getTransformationPurpose() {
		return this.transformationPurpose;
	}

	public void setTransformationPurpose(String transformationPurpose) {
		this.transformationPurpose = transformationPurpose;
	}

	public String getProjectVoltageLevel() {
		return this.projectVoltageLevel;
	}

	public void setProjectVoltageLevel(String projectVoltageLevel) {
		this.projectVoltageLevel = projectVoltageLevel;
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

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
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

	public String getTransformationReasons() {
		return this.transformationReasons;
	}

	public void setTransformationReasons(String transformationReasons) {
		this.transformationReasons = transformationReasons;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentCode() {
		return this.equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getEquipmentVoltageLevel() {
		return this.equipmentVoltageLevel;
	}

	public void setEquipmentVoltageLevel(String equipmentVoltageLevel) {
		this.equipmentVoltageLevel = equipmentVoltageLevel;
	}

	public String getEquipmentModel() {
		return this.equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Double getEquipmentCapacity() {
		return this.equipmentCapacity;
	}

	public void setEquipmentCapacity(Double equipmentCapacity) {
		this.equipmentCapacity = equipmentCapacity;
	}

}