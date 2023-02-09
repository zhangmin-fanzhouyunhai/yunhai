package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidOtherProvinceLeaseAsset entity provides the base persistence
 * definition of the MidOtherProvinceLeaseAsset entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidOtherProvinceLeaseAsset implements java.io.Serializable {

	// Fields

	private String midOtherProviLeaseAssetId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double otherProviOriginalValue;
	private Double otherProviNetValue;
	private Double otherProviQuantity;
	private Double otherProviTechnologyScale;
	private Double leaseOriginalValue;
	private Double leaseNetValue;
	private Double leaseQuantity;
	private Double leaseTechnologyScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidOtherProvinceLeaseAsset() {
	}

	/** minimal constructor */
	public AbstractMidOtherProvinceLeaseAsset(String midOtherProviLeaseAssetId) {
		this.midOtherProviLeaseAssetId = midOtherProviLeaseAssetId;
	}

	/** full constructor */
	public AbstractMidOtherProvinceLeaseAsset(String midOtherProviLeaseAssetId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double otherProviOriginalValue, Double otherProviNetValue, Double otherProviQuantity,
			Double otherProviTechnologyScale, Double leaseOriginalValue, Double leaseNetValue, Double leaseQuantity,
			Double leaseTechnologyScale, Date dvDateValue, String category, String areaName) {
		this.midOtherProviLeaseAssetId = midOtherProviLeaseAssetId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.otherProviOriginalValue = otherProviOriginalValue;
		this.otherProviNetValue = otherProviNetValue;
		this.otherProviQuantity = otherProviQuantity;
		this.otherProviTechnologyScale = otherProviTechnologyScale;
		this.leaseOriginalValue = leaseOriginalValue;
		this.leaseNetValue = leaseNetValue;
		this.leaseQuantity = leaseQuantity;
		this.leaseTechnologyScale = leaseTechnologyScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidOtherProviLeaseAssetId() {
		return this.midOtherProviLeaseAssetId;
	}

	public void setMidOtherProviLeaseAssetId(String midOtherProviLeaseAssetId) {
		this.midOtherProviLeaseAssetId = midOtherProviLeaseAssetId;
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

	public Double getOtherProviOriginalValue() {
		return this.otherProviOriginalValue;
	}

	public void setOtherProviOriginalValue(Double otherProviOriginalValue) {
		this.otherProviOriginalValue = otherProviOriginalValue;
	}

	public Double getOtherProviNetValue() {
		return this.otherProviNetValue;
	}

	public void setOtherProviNetValue(Double otherProviNetValue) {
		this.otherProviNetValue = otherProviNetValue;
	}

	public Double getOtherProviQuantity() {
		return this.otherProviQuantity;
	}

	public void setOtherProviQuantity(Double otherProviQuantity) {
		this.otherProviQuantity = otherProviQuantity;
	}

	public Double getOtherProviTechnologyScale() {
		return this.otherProviTechnologyScale;
	}

	public void setOtherProviTechnologyScale(Double otherProviTechnologyScale) {
		this.otherProviTechnologyScale = otherProviTechnologyScale;
	}

	public Double getLeaseOriginalValue() {
		return this.leaseOriginalValue;
	}

	public void setLeaseOriginalValue(Double leaseOriginalValue) {
		this.leaseOriginalValue = leaseOriginalValue;
	}

	public Double getLeaseNetValue() {
		return this.leaseNetValue;
	}

	public void setLeaseNetValue(Double leaseNetValue) {
		this.leaseNetValue = leaseNetValue;
	}

	public Double getLeaseQuantity() {
		return this.leaseQuantity;
	}

	public void setLeaseQuantity(Double leaseQuantity) {
		this.leaseQuantity = leaseQuantity;
	}

	public Double getLeaseTechnologyScale() {
		return this.leaseTechnologyScale;
	}

	public void setLeaseTechnologyScale(Double leaseTechnologyScale) {
		this.leaseTechnologyScale = leaseTechnologyScale;
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