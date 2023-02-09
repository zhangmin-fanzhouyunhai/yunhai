package com.yunhai.excel.orm;

/**
 * AbstractReportTableFieldColumn entity provides the base persistence
 * definition of the ReportTableFieldColumn entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractReportTableFieldColumn implements java.io.Serializable {

	// Fields

	private String reportTableFieldColumnId;
	private String reportId;
	private String reportName;
	private String tableName;
	private String fieldName;
	private Double indexof;
	private String fieldTitle;
	private String dimensionOrIndicate;
	private String dimensionOrIndicateType;
	private String discription;

	// Constructors

	/** default constructor */
	public AbstractReportTableFieldColumn() {
	}

	/** minimal constructor */
	public AbstractReportTableFieldColumn(String reportTableFieldColumnId, Double indexof) {
		this.reportTableFieldColumnId = reportTableFieldColumnId;
		this.indexof = indexof;
	}

	/** full constructor */
	public AbstractReportTableFieldColumn(String reportTableFieldColumnId, String reportId, String reportName,
			String tableName, String fieldName, Double indexof, String fieldTitle, String dimensionOrIndicate,
			String dimensionOrIndicateType, String discription) {
		this.reportTableFieldColumnId = reportTableFieldColumnId;
		this.reportId = reportId;
		this.reportName = reportName;
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.indexof = indexof;
		this.fieldTitle = fieldTitle;
		this.dimensionOrIndicate = dimensionOrIndicate;
		this.dimensionOrIndicateType = dimensionOrIndicateType;
		this.discription = discription;
	}

	// Property accessors

	public String getReportTableFieldColumnId() {
		return this.reportTableFieldColumnId;
	}

	public void setReportTableFieldColumnId(String reportTableFieldColumnId) {
		this.reportTableFieldColumnId = reportTableFieldColumnId;
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Double getIndexof() {
		return this.indexof;
	}

	public void setIndexof(Double indexof) {
		this.indexof = indexof;
	}

	public String getFieldTitle() {
		return this.fieldTitle;
	}

	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}

	public String getDimensionOrIndicate() {
		return this.dimensionOrIndicate;
	}

	public void setDimensionOrIndicate(String dimensionOrIndicate) {
		this.dimensionOrIndicate = dimensionOrIndicate;
	}

	public String getDimensionOrIndicateType() {
		return this.dimensionOrIndicateType;
	}

	public void setDimensionOrIndicateType(String dimensionOrIndicateType) {
		this.dimensionOrIndicateType = dimensionOrIndicateType;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}