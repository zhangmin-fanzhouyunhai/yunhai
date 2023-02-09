package com.yunhai.db.my;

import java.util.Date;

/**
 * AbstractDVersion entity provides the base persistence definition of the
 * DVersion entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDVersion implements java.io.Serializable {

	// Fields

	private String versionId;
	private String dataType;
	private String versionValue;
	private Short yearValue;
	private Short subVersion;
	private String versionStatus;
	private String targetTable;
	private String parentVersion;
	private Date generateDate;
	private String discription;
	private String parentVersionTemp;
	private String fileName;
	private Long recordQuantity;
	private String procedureName;
	private String procedureVersion;

	// Constructors

	/** default constructor */
	public AbstractDVersion() {
	}

	/** minimal constructor */
	public AbstractDVersion(String versionId, String dataType, String versionValue, Short yearValue, Short subVersion,
			String versionStatus, String targetTable, Date generateDate) {
		this.versionId = versionId;
		this.dataType = dataType;
		this.versionValue = versionValue;
		this.yearValue = yearValue;
		this.subVersion = subVersion;
		this.versionStatus = versionStatus;
		this.targetTable = targetTable;
		this.generateDate = generateDate;
	}

	/** full constructor */
	public AbstractDVersion(String versionId, String dataType, String versionValue, Short yearValue, Short subVersion,
			String versionStatus, String targetTable, String parentVersion, Date generateDate, String discription,
			String parentVersionTemp, String fileName, Long recordQuantity, String procedureName,
			String procedureVersion) {
		this.versionId = versionId;
		this.dataType = dataType;
		this.versionValue = versionValue;
		this.yearValue = yearValue;
		this.subVersion = subVersion;
		this.versionStatus = versionStatus;
		this.targetTable = targetTable;
		this.parentVersion = parentVersion;
		this.generateDate = generateDate;
		this.discription = discription;
		this.parentVersionTemp = parentVersionTemp;
		this.fileName = fileName;
		this.recordQuantity = recordQuantity;
		this.procedureName = procedureName;
		this.procedureVersion = procedureVersion;
	}

	// Property accessors

	public String getVersionId() {
		return this.versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getVersionValue() {
		return this.versionValue;
	}

	public void setVersionValue(String versionValue) {
		this.versionValue = versionValue;
	}

	public Short getYearValue() {
		return this.yearValue;
	}

	public void setYearValue(Short yearValue) {
		this.yearValue = yearValue;
	}

	public Short getSubVersion() {
		return this.subVersion;
	}

	public void setSubVersion(Short subVersion) {
		this.subVersion = subVersion;
	}

	public String getVersionStatus() {
		return this.versionStatus;
	}

	public void setVersionStatus(String versionStatus) {
		this.versionStatus = versionStatus;
	}

	public String getTargetTable() {
		return this.targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public String getParentVersion() {
		return this.parentVersion;
	}

	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}

	public Date getGenerateDate() {
		return this.generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getParentVersionTemp() {
		return this.parentVersionTemp;
	}

	public void setParentVersionTemp(String parentVersionTemp) {
		this.parentVersionTemp = parentVersionTemp;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getRecordQuantity() {
		return this.recordQuantity;
	}

	public void setRecordQuantity(Long recordQuantity) {
		this.recordQuantity = recordQuantity;
	}

	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getProcedureVersion() {
		return this.procedureVersion;
	}

	public void setProcedureVersion(String procedureVersion) {
		this.procedureVersion = procedureVersion;
	}

}