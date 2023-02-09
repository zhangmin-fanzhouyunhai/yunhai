package com.yunhai.excel.orm;
 
import java.util.Date;

/**
 * AbstractOriValidatTechRenovaProj entity provides the base persistence
 * definition of the OriValidatTechRenovaProj entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriValidatTechRenovaProj implements java.io.Serializable {

	// Fields

	private String validatTechRenovaProjId;
	private String dataVersion;
	private Date calYear;
	private String projectNo;
	private String company;
	private String projectName;
	private String projectContent;
	private String projectType;
	private String professionalCategory;
	private String professionalSegmentation;
	private String voltageLevel;
	private Date projectStartTime;
	private Date projectEndTime;
	private String responsibleDepartment;
	private Double currentYearFunds;
	private Double totalInvestment;
	private String assetProperty;
	private String transformationPurpose;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriValidatTechRenovaProj() {
	}

	/** minimal constructor */
	public AbstractOriValidatTechRenovaProj(String validatTechRenovaProjId) {
		this.validatTechRenovaProjId = validatTechRenovaProjId;
	}

	/** full constructor */
	public AbstractOriValidatTechRenovaProj(String validatTechRenovaProjId, String dataVersion, Date calYear,
			String projectNo, String company, String projectName, String projectContent, String projectType,
			String professionalCategory, String professionalSegmentation, String voltageLevel,
			Date projectStartTime, Date projectEndTime, String responsibleDepartment, Double currentYearFunds,
			Double totalInvestment, String assetProperty, String transformationPurpose, String dataSourceFile) {
		this.validatTechRenovaProjId = validatTechRenovaProjId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectNo = projectNo;
		this.company = company;
		this.projectName = projectName;
		this.projectContent = projectContent;
		this.projectType = projectType;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.voltageLevel = voltageLevel;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.responsibleDepartment = responsibleDepartment;
		this.currentYearFunds = currentYearFunds;
		this.totalInvestment = totalInvestment;
		this.assetProperty = assetProperty;
		this.transformationPurpose = transformationPurpose;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getValidatTechRenovaProjId() {
		return this.validatTechRenovaProjId;
	}

	public void setValidatTechRenovaProjId(String validatTechRenovaProjId) {
		this.validatTechRenovaProjId = validatTechRenovaProjId;
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

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
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

	public String getResponsibleDepartment() {
		return this.responsibleDepartment;
	}

	public void setResponsibleDepartment(String responsibleDepartment) {
		this.responsibleDepartment = responsibleDepartment;
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

	public String getTransformationPurpose() {
		return this.transformationPurpose;
	}

	public void setTransformationPurpose(String transformationPurpose) {
		this.transformationPurpose = transformationPurpose;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}