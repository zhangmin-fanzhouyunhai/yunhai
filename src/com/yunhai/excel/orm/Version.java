package com.yunhai.excel.orm;

import java.sql.Date;

public class Version {
	private String versionID;
	private String dataType;
	private String versionValue;
	private Integer yearValue;
	private Integer subVersion;
	private String versionStatus;
	private String targetTable;
	private Date generateDate;
	private String discription;
	private String parentVersionTemp;
	private String fileName;
	private Integer recordQuantity;

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getVersionValue() {
		return versionValue;
	}

	public void setVersionValue(String versionValue) {
		this.versionValue = versionValue;
	}

	public Integer getYearValue() {
		return yearValue;
	}

	public void setYearValue(Integer yearValue) {
		this.yearValue = yearValue;
	}

	public Integer getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(Integer subVersion) {
		this.subVersion = subVersion;
	}

	public String getVersionStatus() {
		return versionStatus;
	}

	public void setVersionStatus(String versionStatus) {
		this.versionStatus = versionStatus;
	}

	public String getTargetTable() {
		return targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public Date getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getParentVersionTemp() {
		return parentVersionTemp;
	}

	public void setParentVersionTemp(String parentVersionTemp) {
		this.parentVersionTemp = parentVersionTemp;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getRecordQuantity() {
		return recordQuantity;
	}

	public void setRecordQuantity(Integer recordQuantity) {
		this.recordQuantity = recordQuantity;
	}

	@Override
	public String toString() {
		return "Employee [versionID=" + versionID + ",dataType" + dataType + ",versionValue=" + versionValue
				+ ",yearValue=" + yearValue + ",subVersion=" + subVersion + ",versionStatus=" + versionStatus
				+ ",targetTable=" + targetTable + ",generateDate=" + generateDate + ",discription=" + discription
				+ ",parentVersionTemp=" + parentVersionTemp + ",fileName=" + fileName + ",recordQuantity="
				+ recordQuantity

		;
	}

}
