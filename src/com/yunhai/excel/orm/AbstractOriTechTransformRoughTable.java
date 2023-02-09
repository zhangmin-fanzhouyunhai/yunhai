package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriTechTransformRoughTable entity provides the base persistence
 * definition of the OriTechTransformRoughTable entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriTechTransformRoughTable implements java.io.Serializable {

	// Fields

	private String oriTechTransfRoughTableId;
	private String dataVersion;
	private Date calYear;
	private String projectId;
	private Double plannedYear;
	private String professionalCategory;
	private String professionalSegmentation;
	private String transformationPurpose;
	private Double totalInvestment;
	private String recommendationBasis;
	private String dataSourceFile;
	private String professionalInvestDirection;
	// Constructors

	/** default constructor */
	public AbstractOriTechTransformRoughTable() {
	}

	/** minimal constructor */
	public AbstractOriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear) {
		this.oriTechTransfRoughTableId = oriTechTransfRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis) {
		this.oriTechTransfRoughTableId = oriTechTransfRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.transformationPurpose = transformationPurpose;
		this.totalInvestment = totalInvestment;
		this.recommendationBasis = recommendationBasis;
	}

	public AbstractOriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis, String dataSourceFile) {
		super();
		this.oriTechTransfRoughTableId = oriTechTransfRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.transformationPurpose = transformationPurpose;
		this.totalInvestment = totalInvestment;
		this.recommendationBasis = recommendationBasis;
		this.dataSourceFile = dataSourceFile;
	}


	public AbstractOriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis, String dataSourceFile,
			String professionalInvestDirection) {
		super();
		this.oriTechTransfRoughTableId = oriTechTransfRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.transformationPurpose = transformationPurpose;
		this.totalInvestment = totalInvestment;
		this.recommendationBasis = recommendationBasis;
		this.dataSourceFile = dataSourceFile;
		this.professionalInvestDirection = professionalInvestDirection;
	}

	// Property accessors
	public String getOriTechTransfRoughTableId() {
		return this.oriTechTransfRoughTableId;
	}

	public String getProfessionalInvestDirection() {
		return professionalInvestDirection;
	}

	public void setProfessionalInvestDirection(String professionalInvestDirection) {
		this.professionalInvestDirection = professionalInvestDirection;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOriTechTransfRoughTableId(String oriTechTransfRoughTableId) {
		this.oriTechTransfRoughTableId = oriTechTransfRoughTableId;
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

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Double getPlannedYear() {
		return this.plannedYear;
	}

	public void setPlannedYear(Double plannedYear) {
		this.plannedYear = plannedYear;
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

	public String getTransformationPurpose() {
		return this.transformationPurpose;
	}

	public void setTransformationPurpose(String transformationPurpose) {
		this.transformationPurpose = transformationPurpose;
	}

	public Double getTotalInvestment() {
		return this.totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public String getRecommendationBasis() {
		return this.recommendationBasis;
	}

	public void setRecommendationBasis(String recommendationBasis) {
		this.recommendationBasis = recommendationBasis;
	}

}