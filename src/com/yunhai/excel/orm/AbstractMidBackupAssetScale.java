package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidBackupAssetScale entity provides the base persistence definition
 * of the MidBackupAssetScale entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidBackupAssetScale implements java.io.Serializable {

	// Fields

	private String midBackupAssetScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double within3YearQuantity;
	private Double within3YearTechnScale;
	private Double moreThan3YearQuantity;
	private Double moreThan3YearTechnScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidBackupAssetScale() {
	}

	/** minimal constructor */
	public AbstractMidBackupAssetScale(String midBackupAssetScaleId) {
		this.midBackupAssetScaleId = midBackupAssetScaleId;
	}

	/** full constructor */
	public AbstractMidBackupAssetScale(String midBackupAssetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double within3YearQuantity,
			Double within3YearTechnScale, Double moreThan3YearQuantity, Double moreThan3YearTechnScale,
			Date dvDateValue, String category, String areaName) {
		this.midBackupAssetScaleId = midBackupAssetScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.within3YearQuantity = within3YearQuantity;
		this.within3YearTechnScale = within3YearTechnScale;
		this.moreThan3YearQuantity = moreThan3YearQuantity;
		this.moreThan3YearTechnScale = moreThan3YearTechnScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidBackupAssetScaleId() {
		return this.midBackupAssetScaleId;
	}

	public void setMidBackupAssetScaleId(String midBackupAssetScaleId) {
		this.midBackupAssetScaleId = midBackupAssetScaleId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLargeClass() {
		return this.largeClass;
	}

	public void setLargeClass(String largeClass) {
		this.largeClass = largeClass;
	}

	public String getMediumClass() {
		return this.mediumClass;
	}

	public void setMediumClass(String mediumClass) {
		this.mediumClass = mediumClass;
	}

	public String getSmallClass() {
		return this.smallClass;
	}

	public void setSmallClass(String smallClass) {
		this.smallClass = smallClass;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Double getWithin3YearQuantity() {
		return this.within3YearQuantity;
	}

	public void setWithin3YearQuantity(Double within3YearQuantity) {
		this.within3YearQuantity = within3YearQuantity;
	}

	public Double getWithin3YearTechnScale() {
		return this.within3YearTechnScale;
	}

	public void setWithin3YearTechnScale(Double within3YearTechnScale) {
		this.within3YearTechnScale = within3YearTechnScale;
	}

	public Double getMoreThan3YearQuantity() {
		return this.moreThan3YearQuantity;
	}

	public void setMoreThan3YearQuantity(Double moreThan3YearQuantity) {
		this.moreThan3YearQuantity = moreThan3YearQuantity;
	}

	public Double getMoreThan3YearTechnScale() {
		return this.moreThan3YearTechnScale;
	}

	public void setMoreThan3YearTechnScale(Double moreThan3YearTechnScale) {
		this.moreThan3YearTechnScale = moreThan3YearTechnScale;
	}

	public Date getDvDateValue() {
		return this.dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}