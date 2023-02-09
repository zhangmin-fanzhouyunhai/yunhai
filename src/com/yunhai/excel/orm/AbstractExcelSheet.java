package com.yunhai.excel.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractExcelSheet entity provides the base persistence definition of the
 * ExcelSheet entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractExcelSheet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6963563286550037371L;
	private String excelSheetId;
	private ExcelFile excelFile;
	private String excelFileId;
	private String excelSheetName;
	private Double sortIndex;
	private Date createDate;
	private String description;
	private Set excelSheetColumns = new HashSet(0);
	private Integer columnInserted;

	
	// Constructors

	public AbstractExcelSheet(String excelSheetId, ExcelFile excelFile, String excelFileId, String excelSheetName,
			Double sortIndex, Date createDate, String description, Integer columnInserted) {
		super();
		this.excelSheetId = excelSheetId;
		this.excelFile = excelFile;
		this.excelFileId = excelFileId;
		this.excelSheetName = excelSheetName;
		this.sortIndex = sortIndex;
		this.createDate = createDate;
		this.description = description;
		this.columnInserted = columnInserted;
	}

	public Integer getColumnInserted() {
		return columnInserted;
	}

	public void setColumnInserted(Integer columnInserted) {
		this.columnInserted = columnInserted;
	}

	/** default constructor */
	public AbstractExcelSheet() {
	}

	/** minimal constructor */
	public AbstractExcelSheet(String excelSheetId, ExcelFile excelFile) {
		this.excelSheetId = excelSheetId;
		this.excelFile = excelFile;
	}

	/** full constructor */
	public AbstractExcelSheet(String excelSheetId, ExcelFile excelFile, String excelSheetName, Double sortIndex,
			String description, Set excelSheetColumns) {
		this.excelSheetId = excelSheetId;
		this.excelFile = excelFile;
		this.excelSheetName = excelSheetName;
		this.sortIndex = sortIndex;
		this.description = description;
		this.excelSheetColumns = excelSheetColumns;
	}

	// Property accessors

	public AbstractExcelSheet(String excelSheetId, String excelFileId, String excelSheetName, Double sortIndex,
			String description, Set excelSheetColumns) {
		super();
		this.excelSheetId = excelSheetId;
		this.excelFileId = excelFileId;
		this.excelSheetName = excelSheetName;
		this.sortIndex = sortIndex;
		this.description = description;
		this.excelSheetColumns = excelSheetColumns;
	}

	public AbstractExcelSheet(String excelSheetId, ExcelFile excelFile, String excelFileId, String excelSheetName,
			Double sortIndex, Date createDate, String description, Set excelSheetColumns) {
		super();
		this.excelSheetId = excelSheetId;
		this.excelFile = excelFile;
		this.excelFileId = excelFileId;
		this.excelSheetName = excelSheetName;
		this.sortIndex = sortIndex;
		this.createDate = createDate;
		this.description = description;
		this.excelSheetColumns = excelSheetColumns;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getExcelFileId() {
		return excelFileId;
	}

	public void setExcelFileId(String excelFileId) {
		this.excelFileId = excelFileId;
	}

	public String getExcelSheetId() {
		return this.excelSheetId;
	}

	public void setExcelSheetId(String excelSheetId) {
		this.excelSheetId = excelSheetId;
	}

	public ExcelFile getExcelFile() {
		return this.excelFile;
	}

	public void setExcelFile(ExcelFile excelFile) {
		this.excelFile = excelFile;
	}

	public String getExcelSheetName() {
		return this.excelSheetName;
	}

	public void setExcelSheetName(String excelSheetName) {
		this.excelSheetName = excelSheetName;
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

	public Set getExcelSheetColumns() {
		return this.excelSheetColumns;
	}

	public void setExcelSheetColumns(Set excelSheetColumns) {
		this.excelSheetColumns = excelSheetColumns;
	}

}