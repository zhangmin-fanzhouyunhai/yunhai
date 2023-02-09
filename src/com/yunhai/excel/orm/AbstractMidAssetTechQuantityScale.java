package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractMidAssetTechQuantityScale entity provides the base persistence
 * definition of the MidAssetTechQuantityScale entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetTechQuantityScale implements java.io.Serializable {

	// Fields

	private String midAssetTechQuantScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double quantity;
	private Double technologyScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidAssetTechQuantityScale() {
	}

	/** minimal constructor */
	public AbstractMidAssetTechQuantityScale(String midAssetTechQuantScaleId) {
		this.midAssetTechQuantScaleId = midAssetTechQuantScaleId;
	}

	/** full constructor */
	public AbstractMidAssetTechQuantityScale(String midAssetTechQuantScaleId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double quantity, Double technologyScale, Date dvDateValue, String category, String areaName) {
		this.midAssetTechQuantScaleId = midAssetTechQuantScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.quantity = quantity;
		this.technologyScale = technologyScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidAssetTechQuantScaleId() {
		return this.midAssetTechQuantScaleId;
	}

	public void setMidAssetTechQuantScaleId(String midAssetTechQuantScaleId) {
		this.midAssetTechQuantScaleId = midAssetTechQuantScaleId;
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

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}