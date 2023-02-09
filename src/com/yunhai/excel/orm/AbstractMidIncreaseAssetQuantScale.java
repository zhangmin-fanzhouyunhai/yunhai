package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidIncreaseAssetQuantScale entity provides the base persistence
 * definition of the MidIncreaseAssetQuantScale entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidIncreaseAssetQuantScale implements java.io.Serializable {

	// Fields

	private String midIncreAssetQuantScaleId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double inverstThisYearQuantity;
	private Double inverstThisYearTechScale;
	private Double userHandoverQuantity;
	private Double userHandoverTechScale;
	private Double smallPurchaseQuantity;
	private Double smallPurchaseTechScale;
	private Double allocationQuantity;
	private Double allocationTechScale;
	private Double otherQuantity;
	private Double otherTechScale;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidIncreaseAssetQuantScale() {
	}

	/** minimal constructor */
	public AbstractMidIncreaseAssetQuantScale(String midIncreAssetQuantScaleId) {
		this.midIncreAssetQuantScaleId = midIncreAssetQuantScaleId;
	}

	/** full constructor */
	public AbstractMidIncreaseAssetQuantScale(String midIncreAssetQuantScaleId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double inverstThisYearQuantity, Double inverstThisYearTechScale, Double userHandoverQuantity,
			Double userHandoverTechScale, Double smallPurchaseQuantity, Double smallPurchaseTechScale,
			Double allocationQuantity, Double allocationTechScale, Double otherQuantity, Double otherTechScale,
			Date dvDateValue, String category, String areaName) {
		this.midIncreAssetQuantScaleId = midIncreAssetQuantScaleId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.inverstThisYearQuantity = inverstThisYearQuantity;
		this.inverstThisYearTechScale = inverstThisYearTechScale;
		this.userHandoverQuantity = userHandoverQuantity;
		this.userHandoverTechScale = userHandoverTechScale;
		this.smallPurchaseQuantity = smallPurchaseQuantity;
		this.smallPurchaseTechScale = smallPurchaseTechScale;
		this.allocationQuantity = allocationQuantity;
		this.allocationTechScale = allocationTechScale;
		this.otherQuantity = otherQuantity;
		this.otherTechScale = otherTechScale;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidIncreAssetQuantScaleId() {
		return this.midIncreAssetQuantScaleId;
	}

	public void setMidIncreAssetQuantScaleId(String midIncreAssetQuantScaleId) {
		this.midIncreAssetQuantScaleId = midIncreAssetQuantScaleId;
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

	public Double getInverstThisYearQuantity() {
		return this.inverstThisYearQuantity;
	}

	public void setInverstThisYearQuantity(Double inverstThisYearQuantity) {
		this.inverstThisYearQuantity = inverstThisYearQuantity;
	}

	public Double getInverstThisYearTechScale() {
		return this.inverstThisYearTechScale;
	}

	public void setInverstThisYearTechScale(Double inverstThisYearTechScale) {
		this.inverstThisYearTechScale = inverstThisYearTechScale;
	}

	public Double getUserHandoverQuantity() {
		return this.userHandoverQuantity;
	}

	public void setUserHandoverQuantity(Double userHandoverQuantity) {
		this.userHandoverQuantity = userHandoverQuantity;
	}

	public Double getUserHandoverTechScale() {
		return this.userHandoverTechScale;
	}

	public void setUserHandoverTechScale(Double userHandoverTechScale) {
		this.userHandoverTechScale = userHandoverTechScale;
	}

	public Double getSmallPurchaseQuantity() {
		return this.smallPurchaseQuantity;
	}

	public void setSmallPurchaseQuantity(Double smallPurchaseQuantity) {
		this.smallPurchaseQuantity = smallPurchaseQuantity;
	}

	public Double getSmallPurchaseTechScale() {
		return this.smallPurchaseTechScale;
	}

	public void setSmallPurchaseTechScale(Double smallPurchaseTechScale) {
		this.smallPurchaseTechScale = smallPurchaseTechScale;
	}

	public Double getAllocationQuantity() {
		return this.allocationQuantity;
	}

	public void setAllocationQuantity(Double allocationQuantity) {
		this.allocationQuantity = allocationQuantity;
	}

	public Double getAllocationTechScale() {
		return this.allocationTechScale;
	}

	public void setAllocationTechScale(Double allocationTechScale) {
		this.allocationTechScale = allocationTechScale;
	}

	public Double getOtherQuantity() {
		return this.otherQuantity;
	}

	public void setOtherQuantity(Double otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public Double getOtherTechScale() {
		return this.otherTechScale;
	}

	public void setOtherTechScale(Double otherTechScale) {
		this.otherTechScale = otherTechScale;
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