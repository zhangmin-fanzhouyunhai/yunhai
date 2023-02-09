package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidResuingAssetScale entity provides the base persistence definition
 * of the MidResuingAssetScale entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidResuingAssetScale implements java.io.Serializable {

	// Fields

	private String midResuingAssetScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double inYearProvQuantity;
	private Double inYearProvTechnScale;
	private Double accumInProvQuantity;
	private Double accumInProvTechnScale;
	private Double inYearBetProvQuantity;
	private Double inYearBetProvTechnScale;
	private Double accumBetProvQuantity;
	private Double accumBetProvTechnScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidResuingAssetScale() {
	}

	/** minimal constructor */
	public AbstractMidResuingAssetScale(String midResuingAssetScaleId) {
		this.midResuingAssetScaleId = midResuingAssetScaleId;
	}

	/** full constructor */
	public AbstractMidResuingAssetScale(String midResuingAssetScaleId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double inYearProvQuantity, Double inYearProvTechnScale, Double accumInProvQuantity,
			Double accumInProvTechnScale, Double inYearBetProvQuantity, Double inYearBetProvTechnScale,
			Double accumBetProvQuantity, Double accumBetProvTechnScale, Date dvDateValue, String category,
			String areaName) {
		this.midResuingAssetScaleId = midResuingAssetScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.inYearProvQuantity = inYearProvQuantity;
		this.inYearProvTechnScale = inYearProvTechnScale;
		this.accumInProvQuantity = accumInProvQuantity;
		this.accumInProvTechnScale = accumInProvTechnScale;
		this.inYearBetProvQuantity = inYearBetProvQuantity;
		this.inYearBetProvTechnScale = inYearBetProvTechnScale;
		this.accumBetProvQuantity = accumBetProvQuantity;
		this.accumBetProvTechnScale = accumBetProvTechnScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidResuingAssetScaleId() {
		return this.midResuingAssetScaleId;
	}

	public void setMidResuingAssetScaleId(String midResuingAssetScaleId) {
		this.midResuingAssetScaleId = midResuingAssetScaleId;
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

	public Double getInYearProvQuantity() {
		return this.inYearProvQuantity;
	}

	public void setInYearProvQuantity(Double inYearProvQuantity) {
		this.inYearProvQuantity = inYearProvQuantity;
	}

	public Double getInYearProvTechnScale() {
		return this.inYearProvTechnScale;
	}

	public void setInYearProvTechnScale(Double inYearProvTechnScale) {
		this.inYearProvTechnScale = inYearProvTechnScale;
	}

	public Double getAccumInProvQuantity() {
		return this.accumInProvQuantity;
	}

	public void setAccumInProvQuantity(Double accumInProvQuantity) {
		this.accumInProvQuantity = accumInProvQuantity;
	}

	public Double getAccumInProvTechnScale() {
		return this.accumInProvTechnScale;
	}

	public void setAccumInProvTechnScale(Double accumInProvTechnScale) {
		this.accumInProvTechnScale = accumInProvTechnScale;
	}

	public Double getInYearBetProvQuantity() {
		return this.inYearBetProvQuantity;
	}

	public void setInYearBetProvQuantity(Double inYearBetProvQuantity) {
		this.inYearBetProvQuantity = inYearBetProvQuantity;
	}

	public Double getInYearBetProvTechnScale() {
		return this.inYearBetProvTechnScale;
	}

	public void setInYearBetProvTechnScale(Double inYearBetProvTechnScale) {
		this.inYearBetProvTechnScale = inYearBetProvTechnScale;
	}

	public Double getAccumBetProvQuantity() {
		return this.accumBetProvQuantity;
	}

	public void setAccumBetProvQuantity(Double accumBetProvQuantity) {
		this.accumBetProvQuantity = accumBetProvQuantity;
	}

	public Double getAccumBetProvTechnScale() {
		return this.accumBetProvTechnScale;
	}

	public void setAccumBetProvTechnScale(Double accumBetProvTechnScale) {
		this.accumBetProvTechnScale = accumBetProvTechnScale;
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