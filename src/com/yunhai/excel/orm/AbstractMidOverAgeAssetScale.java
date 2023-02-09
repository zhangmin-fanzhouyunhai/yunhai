package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidOverAgeAssetScale entity provides the base persistence definition
 * of the MidOverAgeAssetScale entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidOverAgeAssetScale implements java.io.Serializable {

	// Fields

	private String midOverAgeAssetScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double totalOriginalValue;
	private Double totalNetValue;
	private Double totalQuantity;
	private Double totalTechnologyScale;
	private Double overAgeOriginalValue;
	private Double overAgeNetValue;
	private Double overAgeQuantity;
	private Double overAgeTechnologyScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidOverAgeAssetScale() {
	}

	/** minimal constructor */
	public AbstractMidOverAgeAssetScale(String midOverAgeAssetScaleId) {
		this.midOverAgeAssetScaleId = midOverAgeAssetScaleId;
	}

	/** full constructor */
	public AbstractMidOverAgeAssetScale(String midOverAgeAssetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double totalOriginalValue,
			Double totalNetValue, Double totalQuantity, Double totalTechnologyScale, Double overAgeOriginalValue,
			Double overAgeNetValue, Double overAgeQuantity, Double overAgeTechnologyScale, Date dvDateValue,
			String category, String areaName) {
		this.midOverAgeAssetScaleId = midOverAgeAssetScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.totalOriginalValue = totalOriginalValue;
		this.totalNetValue = totalNetValue;
		this.totalQuantity = totalQuantity;
		this.totalTechnologyScale = totalTechnologyScale;
		this.overAgeOriginalValue = overAgeOriginalValue;
		this.overAgeNetValue = overAgeNetValue;
		this.overAgeQuantity = overAgeQuantity;
		this.overAgeTechnologyScale = overAgeTechnologyScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidOverAgeAssetScaleId() {
		return this.midOverAgeAssetScaleId;
	}

	public void setMidOverAgeAssetScaleId(String midOverAgeAssetScaleId) {
		this.midOverAgeAssetScaleId = midOverAgeAssetScaleId;
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

	public Double getTotalOriginalValue() {
		return this.totalOriginalValue;
	}

	public void setTotalOriginalValue(Double totalOriginalValue) {
		this.totalOriginalValue = totalOriginalValue;
	}

	public Double getTotalNetValue() {
		return this.totalNetValue;
	}

	public void setTotalNetValue(Double totalNetValue) {
		this.totalNetValue = totalNetValue;
	}

	public Double getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalTechnologyScale() {
		return this.totalTechnologyScale;
	}

	public void setTotalTechnologyScale(Double totalTechnologyScale) {
		this.totalTechnologyScale = totalTechnologyScale;
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