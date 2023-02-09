package com.yunhai.excel.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractExcelFile entity provides the base persistence definition of the
 * ExcelFile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractExcelFile implements java.io.Serializable {

	// Fields

	private String excelFileId;
	private String excelFileName;
	private String uploadPersonName;
	private Date uploadDate;
	private Double sortIndex;
	private String storyPath;
	private String description;
	private Set excelSheets = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractExcelFile() {
	}

	/** minimal constructor */
	public AbstractExcelFile(String excelFileId) {
		this.excelFileId = excelFileId;
	}

	/** full constructor */
	public AbstractExcelFile(String excelFileId, String excelFileName, String uploadPersonName, Date uploadDate,
			Double sortIndex, String storyPath, String description, Set excelSheets) {
		this.excelFileId = excelFileId;
		this.excelFileName = excelFileName;
		this.uploadPersonName = uploadPersonName;
		this.uploadDate = uploadDate;
		this.sortIndex = sortIndex;
		this.storyPath = storyPath;
		this.description = description;
		this.excelSheets = excelSheets;
	}

	// Property accessors

	public String getExcelFileId() {
		return this.excelFileId;
	}

	public void setExcelFileId(String excelFileId) {
		this.excelFileId = excelFileId;
	}

	public String getExcelFileName() {
		return this.excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getUploadPersonName() {
		return this.uploadPersonName;
	}

	public void setUploadPersonName(String uploadPersonName) {
		this.uploadPersonName = uploadPersonName;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getStoryPath() {
		return this.storyPath;
	}

	public void setStoryPath(String storyPath) {
		this.storyPath = storyPath;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getExcelSheets() {
		return this.excelSheets;
	}

	public void setExcelSheets(Set excelSheets) {
		this.excelSheets = excelSheets;
	}

}