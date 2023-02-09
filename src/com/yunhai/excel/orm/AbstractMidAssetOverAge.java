package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetOverAge entity provides the base persistence definition of
 * the MidAssetOverAge entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidAssetOverAge implements java.io.Serializable {

	// Fields

	private String midAssetOverAgeId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double overAgeOriginalValue;
	private Double overAgeNetValue;
	private Double overAgeQuantity;
	private Double overAgeTechnologyScale;
	private Double originalValue;
	private Double netValue;
	private Double quantity;
	private Double technologyScale;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidAssetOverAge() {
	}

	/** minimal constructor */
	public AbstractMidAssetOverAge(String midAssetOverAgeId) {
		this.midAssetOverAgeId = midAssetOverAgeId;
	}

	/** full constructor */
	public AbstractMidAssetOverAge(String midAssetOverAgeId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double overAgeOriginalValue,
			Double overAgeNetValue, Double overAgeQuantity, Double overAgeTechnologyScale, Double originalValue,
			Double netValue, Double quantity, Double technologyScale, Date dvDateValue, String category) {
		this.midAssetOverAgeId = midAssetOverAgeId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.overAgeOriginalValue = overAgeOriginalValue;
		this.overAgeNetValue = overAgeNetValue;
		this.overAgeQuantity = overAgeQuantity;
		this.overAgeTechnologyScale = overAgeTechnologyScale;
		this.originalValue = originalValue;
		this.netValue = netValue;
		this.quantity = quantity;
		this.technologyScale = technologyScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidAssetOverAgeId() {
		return this.midAssetOverAgeId;
	}

	public void setMidAssetOverAgeId(String midAssetOverAgeId) {
		this.midAssetOverAgeId = midAssetOverAgeId;
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

	public Double getOverAgeOriginalValue() {
		return this.overAgeOriginalValue;
	}

	public void setOverAgeOriginalValue(Double overAgeOriginalValue) {
		this.overAgeOriginalValue = overAgeOriginalValue;
	}

	public Double getOverAgeNetValue() {
		return this.overAgeNetValue;
	}

	public void setOverAgeNetValue(Double overAgeNetValue) {
		this.overAgeNetValue = overAgeNetValue;
	}

	public Double getOverAgeQuantity() {
		return this.overAgeQuantity;
	}

	public void setOverAgeQuantity(Double overAgeQuantity) {
		this.overAgeQuantity = overAgeQuantity;
	}

	public Double getOverAgeTechnologyScale() {
		return this.overAgeTechnologyScale;
	}

	public void setOverAgeTechnologyScale(Double overAgeTechnologyScale) {
		this.overAgeTechnologyScale = overAgeTechnologyScale;
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

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getTechnologyScale() {
		return this.technologyScale;
	}

	public void setTechnologyScale(Double technologyScale) {
		this.technologyScale = technologyScale;
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

}