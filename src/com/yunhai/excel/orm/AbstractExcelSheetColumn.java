package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractExcelSheetColumn entity provides the base persistence definition of
 * the ExcelSheetColumn entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractExcelSheetColumn implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5414368061264923686L;
	private String excelSheetColumnId;
	private ExcelSheet excelSheet;
	private String excelSheetId;
	private String excelSheetColumnName;
	private String dataType;
	private String dataTypeCode;
	private Date createDate;
	private Double sortIndex;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractExcelSheetColumn() {
	}

	/** minimal constructor */
	public AbstractExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet) {
		this.excelSheetColumnId = excelSheetColumnId;
		this.excelSheet = excelSheet;
	}

	/** full constructor */
	public AbstractExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet, String excelSheetColumnName,
			String dataType, String dataTypeCode, Double sortIndex, String description) {
		this.excelSheetColumnId = excelSheetColumnId;
		this.excelSheet = excelSheet;
		this.excelSheetColumnName = excelSheetColumnName;
		this.dataType = dataType;
		this.dataTypeCode = dataTypeCode;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	// Property accessors

	public AbstractExcelSheetColumn(String excelSheetColumnId, String excelSheetId, String excelSheetColumnName,
			String dataType, String dataTypeCode, Double sortIndex, String description) {
		super();
		this.excelSheetColumnId = excelSheetColumnId;
		this.excelSheetId = excelSheetId;
		this.excelSheetColumnName = excelSheetColumnName;
		this.dataType = dataType;
		this.dataTypeCode = dataTypeCode;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	public AbstractExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet, String excelSheetId,
			String excelSheetColumnName, String dataType, String dataTypeCode, Date createDate, Double sortIndex,
			String description) {
		super();
		this.excelSheetColumnId = excelSheetColumnId;
		this.excelSheet = excelSheet;
		this.excelSheetId = excelSheetId;
		this.excelSheetColumnName = excelSheetColumnName;
		this.dataType = dataType;
		this.dataTypeCode = dataTypeCode;
		this.createDate = createDate;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getExcelSheetId() {
		return excelSheetId;
	}

	public void setExcelSheetId(String excelSheetId) {
		this.excelSheetId = excelSheetId;
	}

	public String getExcelSheetColumnId() {
		return this.excelSheetColumnId;
	}

	public void setExcelSheetColumnId(String excelSheetColumnId) {
		this.excelSheetColumnId = excelSheetColumnId;
	}

	public ExcelSheet getExcelSheet() {
		return this.excelSheet;
	}

	public void setExcelSheet(ExcelSheet excelSheet) {
		this.excelSheet = excelSheet;
	}

	public String getExcelSheetColumnName() {
		return this.excelSheetColumnName;
	}

	public void setExcelSheetColumnName(String excelSheetColumnName) {
		this.excelSheetColumnName = excelSheetColumnName;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataTypeCode() {
		return this.dataTypeCode;
	}

	public void setDataTypeCode(String dataTypeCode) {
		this.dataTypeCode = dataTypeCode;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}