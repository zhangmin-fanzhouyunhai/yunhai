package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetOriginalNetScale entity provides the base persistence
 * definition of the MidAssetOriginalNetScale entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetOriginalNetScale implements java.io.Serializable {

	// Fields

	private String midAssetOrigNetScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double originalValue;
	private Double netValue;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidAssetOriginalNetScale() {
	}

	/** minimal constructor */
	public AbstractMidAssetOriginalNetScale(String midAssetOrigNetScaleId) {
		this.midAssetOrigNetScaleId = midAssetOrigNetScaleId;
	}

	/** full constructor */
	public AbstractMidAssetOriginalNetScale(String midAssetOrigNetScaleId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double originalValue, Double netValue, Date dvDateValue, String category, String areaName) {
		this.midAssetOrigNetScaleId = midAssetOrigNetScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidAssetOrigNetScaleId() {
		return this.midAssetOrigNetScaleId;
	}

	public void setMidAssetOrigNetScaleId(String midAssetOrigNetScaleId) {
		this.midAssetOrigNetScaleId = midAssetOrigNetScaleId;
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

	public Double getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
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