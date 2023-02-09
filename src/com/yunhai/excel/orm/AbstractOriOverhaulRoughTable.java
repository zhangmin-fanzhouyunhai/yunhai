package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriOverhaulRoughTable entity provides the base persistence definition
 * of the OriOverhaulRoughTable entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriOverhaulRoughTable implements java.io.Serializable {

	// Fields

	private String oriOverhaulRoughTableId;
	private String dataVersion;
	private Date calYear;
	private String projectId;
	private Double plannedYear;
	private String professionalCategory;
	private String professionalSegmentation;
	private Double totalInvestment;
	private String projectBasis;
	private String dataSourceFile;
	private String professionalInvestDirection;
	// Constructors

	/** default constructor */
	public AbstractOriOverhaulRoughTable() {
	}

	/** minimal constructor */
	public AbstractOriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear) {
		this.oriOverhaulRoughTableId = oriOverhaulRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			Double totalInvestment, String projectBasis) {
		this.oriOverhaulRoughTableId = oriOverhaulRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.totalInvestment = totalInvestment;
		this.projectBasis = projectBasis;
	}


	public AbstractOriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			Double totalInvestment, String projectBasis, String dataSourceFile) {
		super();
		this.oriOverhaulRoughTableId = oriOverhaulRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.totalInvestment = totalInvestment;
		this.projectBasis = projectBasis;
		this.dataSourceFile = dataSourceFile;
	}
	
	
	
	

	public AbstractOriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			Double totalInvestment, String projectBasis, String dataSourceFile, String professionalInvestDirection) {
		super();
		this.oriOverhaulRoughTableId = oriOverhaulRoughTableId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectId = projectId;
		this.plannedYear = plannedYear;
		this.professionalCategory = professionalCategory;
		this.professionalSegmentation = professionalSegmentation;
		this.totalInvestment = totalInvestment;
		this.projectBasis = projectBasis;
		this.dataSourceFile = dataSourceFile;
		this.professionalInvestDirection = professionalInvestDirection;
	}

	
	// Property accessors
	public String getOriOverhaulRoughTableId() {
		return this.oriOverhaulRoughTableId;
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

	public void setOriOverhaulRoughTableId(String oriOverhaulRoughTableId) {
		this.oriOverhaulRoughTableId = oriOverhaulRoughTableId;
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

	public Double getTotalInvestment() {
		return this.totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public String getProjectBasis() {
		return this.projectBasis;
	}

	public void setProjectBasis(String projectBasis) {
		this.projectBasis = projectBasis;
	}

}