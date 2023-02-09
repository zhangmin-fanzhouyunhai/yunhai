package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidDiscardAssetUseingYear entity provides the base persistence
 * definition of the MidDiscardAssetUseingYear entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidDiscardAssetUseingYear implements java.io.Serializable {

	// Fields

	private String midDiscardAssetUseYearId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double realUsingYear5;
	private Double discardAssetQuantityYear5;
	private Double totalUsingYear5;
	private Double realUsingYear4;
	private Double discardAssetQuantityYear4;
	private Double totalUsingYear4;
	private Double realUsingYear3;
	private Double discardAssetQuantityYear3;
	private Double totalUsingYear3;
	private Double realUsingYear2;
	private Double discardAssetQuantityYear2;
	private Double totalUsingYear2;
	private Double realUsingYear1;
	private Double discardAssetQuantityYear1;
	private Double totalUsingYear1;
	private Date dvDateValue;
	private String category;
	private String areaName;
	private Double realUsingYear6;
	private Double discardAssetQuantityYear6;
	private Double totalUsingYear6;

	// Constructors

	/** default constructor */
	public AbstractMidDiscardAssetUseingYear() {
	}

	/** minimal constructor */
	public AbstractMidDiscardAssetUseingYear(String midDiscardAssetUseYearId) {
		this.midDiscardAssetUseYearId = midDiscardAssetUseYearId;
	}

	/** full constructor */
	public AbstractMidDiscardAssetUseingYear(String midDiscardAssetUseYearId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double realUsingYear5, Double discardAssetQuantityYear5, Double totalUsingYear5, Double realUsingYear4,
			Double discardAssetQuantityYear4, Double totalUsingYear4, Double realUsingYear3,
			Double discardAssetQuantityYear3, Double totalUsingYear3, Double realUsingYear2,
			Double discardAssetQuantityYear2, Double totalUsingYear2, Double realUsingYear1,
			Double discardAssetQuantityYear1, Double totalUsingYear1, Date dvDateValue, String category,
			String areaName, Double realUsingYear6, Double discardAssetQuantityYear6, Double totalUsingYear6) {
		this.midDiscardAssetUseYearId = midDiscardAssetUseYearId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.realUsingYear5 = realUsingYear5;
		this.discardAssetQuantityYear5 = discardAssetQuantityYear5;
		this.totalUsingYear5 = totalUsingYear5;
		this.realUsingYear4 = realUsingYear4;
		this.discardAssetQuantityYear4 = discardAssetQuantityYear4;
		this.totalUsingYear4 = totalUsingYear4;
		this.realUsingYear3 = realUsingYear3;
		this.discardAssetQuantityYear3 = discardAssetQuantityYear3;
		this.totalUsingYear3 = totalUsingYear3;
		this.realUsingYear2 = realUsingYear2;
		this.discardAssetQuantityYear2 = discardAssetQuantityYear2;
		this.totalUsingYear2 = totalUsingYear2;
		this.realUsingYear1 = realUsingYear1;
		this.discardAssetQuantityYear1 = discardAssetQuantityYear1;
		this.totalUsingYear1 = totalUsingYear1;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
		this.realUsingYear6 = realUsingYear6;
		this.discardAssetQuantityYear6 = discardAssetQuantityYear6;
		this.totalUsingYear6 = totalUsingYear6;
	}

	// Property accessors

	public String getMidDiscardAssetUseYearId() {
		return this.midDiscardAssetUseYearId;
	}

	public void setMidDiscardAssetUseYearId(String midDiscardAssetUseYearId) {
		this.midDiscardAssetUseYearId = midDiscardAssetUseYearId;
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

	public Double getRealUsingYear5() {
		return this.realUsingYear5;
	}

	public void setRealUsingYear5(Double realUsingYear5) {
		this.realUsingYear5 = realUsingYear5;
	}

	public Double getDiscardAssetQuantityYear5() {
		return this.discardAssetQuantityYear5;
	}

	public void setDiscardAssetQuantityYear5(Double discardAssetQuantityYear5) {
		this.discardAssetQuantityYear5 = discardAssetQuantityYear5;
	}

	public Double getTotalUsingYear5() {
		return this.totalUsingYear5;
	}

	public void setTotalUsingYear5(Double totalUsingYear5) {
		this.totalUsingYear5 = totalUsingYear5;
	}

	public Double getRealUsingYear4() {
		return this.realUsingYear4;
	}

	public void setRealUsingYear4(Double realUsingYear4) {
		this.realUsingYear4 = realUsingYear4;
	}

	public Double getDiscardAssetQuantityYear4() {
		return this.discardAssetQuantityYear4;
	}

	public void setDiscardAssetQuantityYear4(Double discardAssetQuantityYear4) {
		this.discardAssetQuantityYear4 = discardAssetQuantityYear4;
	}

	public Double getTotalUsingYear4() {
		return this.totalUsingYear4;
	}

	public void setTotalUsingYear4(Double totalUsingYear4) {
		this.totalUsingYear4 = totalUsingYear4;
	}

	public Double getRealUsingYear3() {
		return this.realUsingYear3;
	}

	public void setRealUsingYear3(Double realUsingYear3) {
		this.realUsingYear3 = realUsingYear3;
	}

	public Double getDiscardAssetQuantityYear3() {
		return this.discardAssetQuantityYear3;
	}

	public void setDiscardAssetQuantityYear3(Double discardAssetQuantityYear3) {
		this.discardAssetQuantityYear3 = discardAssetQuantityYear3;
	}

	public Double getTotalUsingYear3() {
		return this.totalUsingYear3;
	}

	public void setTotalUsingYear3(Double totalUsingYear3) {
		this.totalUsingYear3 = totalUsingYear3;
	}

	public Double getRealUsingYear2() {
		return this.realUsingYear2;
	}

	public void setRealUsingYear2(Double realUsingYear2) {
		this.realUsingYear2 = realUsingYear2;
	}

	public Double getDiscardAssetQuantityYear2() {
		return this.discardAssetQuantityYear2;
	}

	public void setDiscardAssetQuantityYear2(Double discardAssetQuantityYear2) {
		this.discardAssetQuantityYear2 = discardAssetQuantityYear2;
	}

	public Double getTotalUsingYear2() {
		return this.totalUsingYear2;
	}

	public void setTotalUsingYear2(Double totalUsingYear2) {
		this.totalUsingYear2 = totalUsingYear2;
	}

	public Double getRealUsingYear1() {
		return this.realUsingYear1;
	}

	public void setRealUsingYear1(Double realUsingYear1) {
		this.realUsingYear1 = realUsingYear1;
	}

	public Double getDiscardAssetQuantityYear1() {
		return this.discardAssetQuantityYear1;
	}

	public void setDiscardAssetQuantityYear1(Double discardAssetQuantityYear1) {
		this.discardAssetQuantityYear1 = discardAssetQuantityYear1;
	}

	public Double getTotalUsingYear1() {
		return this.totalUsingYear1;
	}

	public void setTotalUsingYear1(Double totalUsingYear1) {
		this.totalUsingYear1 = totalUsingYear1;
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

	public Double getRealUsingYear6() {
		return this.realUsingYear6;
	}

	public void setRealUsingYear6(Double realUsingYear6) {
		this.realUsingYear6 = realUsingYear6;
	}

	public Double getDiscardAssetQuantityYear6() {
		return this.discardAssetQuantityYear6;
	}

	public void setDiscardAssetQuantityYear6(Double discardAssetQuantityYear6) {
		this.discardAssetQuantityYear6 = discardAssetQuantityYear6;
	}

	public Double getTotalUsingYear6() {
		return this.totalUsingYear6;
	}

	public void setTotalUsingYear6(Double totalUsingYear6) {
		this.totalUsingYear6 = totalUsingYear6;
	}

}