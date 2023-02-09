package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidIncreaseAssetValueScale entity provides the base persistence
 * definition of the MidIncreaseAssetValueScale entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidIncreaseAssetValueScale implements java.io.Serializable {

	// Fields

	private String midIncreAssetValueScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double inverstThisYearOriginValue;
	private Double userHandoverOriginValue;
	private Double smallPurchaseOriginValue;
	private Double allocationOriginValue;
	private Double otherOriginValue;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidIncreaseAssetValueScale() {
	}

	/** minimal constructor */
	public AbstractMidIncreaseAssetValueScale(String midIncreAssetValueScaleId) {
		this.midIncreAssetValueScaleId = midIncreAssetValueScaleId;
	}

	/** full constructor */
	public AbstractMidIncreaseAssetValueScale(String midIncreAssetValueScaleId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double inverstThisYearOriginValue, Double userHandoverOriginValue, Double smallPurchaseOriginValue,
			Double allocationOriginValue, Double otherOriginValue, Date dvDateValue, String category,
			String areaName) {
		this.midIncreAssetValueScaleId = midIncreAssetValueScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.inverstThisYearOriginValue = inverstThisYearOriginValue;
		this.userHandoverOriginValue = userHandoverOriginValue;
		this.smallPurchaseOriginValue = smallPurchaseOriginValue;
		this.allocationOriginValue = allocationOriginValue;
		this.otherOriginValue = otherOriginValue;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidIncreAssetValueScaleId() {
		return this.midIncreAssetValueScaleId;
	}

	public void setMidIncreAssetValueScaleId(String midIncreAssetValueScaleId) {
		this.midIncreAssetValueScaleId = midIncreAssetValueScaleId;
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

	public Double getInverstThisYearOriginValue() {
		return this.inverstThisYearOriginValue;
	}

	public void setInverstThisYearOriginValue(Double inverstThisYearOriginValue) {
		this.inverstThisYearOriginValue = inverstThisYearOriginValue;
	}

	public Double getUserHandoverOriginValue() {
		return this.userHandoverOriginValue;
	}

	public void setUserHandoverOriginValue(Double userHandoverOriginValue) {
		this.userHandoverOriginValue = userHandoverOriginValue;
	}

	public Double getSmallPurchaseOriginValue() {
		return this.smallPurchaseOriginValue;
	}

	public void setSmallPurchaseOriginValue(Double smallPurchaseOriginValue) {
		this.smallPurchaseOriginValue = smallPurchaseOriginValue;
	}

	public Double getAllocationOriginValue() {
		return this.allocationOriginValue;
	}

	public void setAllocationOriginValue(Double allocationOriginValue) {
		this.allocationOriginValue = allocationOriginValue;
	}

	public Double getOtherOriginValue() {
		return this.otherOriginValue;
	}

	public void setOtherOriginValue(Double otherOriginValue) {
		this.otherOriginValue = otherOriginValue;
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