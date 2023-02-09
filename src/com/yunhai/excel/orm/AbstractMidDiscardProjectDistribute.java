package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidDiscardProjectDistribute entity provides the base persistence
 * definition of the MidDiscardProjectDistribute entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidDiscardProjectDistribute implements java.io.Serializable {

	// Fields

	private String midDiscardProjDistribId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double origValueProject1;
	private Double origValueProject2;
	private Double origValueProject3;
	private Double origValueProject4;
	private Double netValueProject1;
	private Double netValueProject2;
	private Double netValueProject3;
	private Double netValueProject4;
	private Double quantityProject1;
	private Double quantityProject2;
	private Double quantityProject3;
	private Double quantityProject4;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidDiscardProjectDistribute() {
	}

	/** minimal constructor */
	public AbstractMidDiscardProjectDistribute(String midDiscardProjDistribId) {
		this.midDiscardProjDistribId = midDiscardProjDistribId;
	}

	/** full constructor */
	public AbstractMidDiscardProjectDistribute(String midDiscardProjDistribId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double origValueProject1, Double origValueProject2, Double origValueProject3, Double origValueProject4,
			Double netValueProject1, Double netValueProject2, Double netValueProject3, Double netValueProject4,
			Double quantityProject1, Double quantityProject2, Double quantityProject3, Double quantityProject4,
			Date dvDateValue, String category, String areaName) {
		this.midDiscardProjDistribId = midDiscardProjDistribId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.origValueProject1 = origValueProject1;
		this.origValueProject2 = origValueProject2;
		this.origValueProject3 = origValueProject3;
		this.origValueProject4 = origValueProject4;
		this.netValueProject1 = netValueProject1;
		this.netValueProject2 = netValueProject2;
		this.netValueProject3 = netValueProject3;
		this.netValueProject4 = netValueProject4;
		this.quantityProject1 = quantityProject1;
		this.quantityProject2 = quantityProject2;
		this.quantityProject3 = quantityProject3;
		this.quantityProject4 = quantityProject4;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidDiscardProjDistribId() {
		return this.midDiscardProjDistribId;
	}

	public void setMidDiscardProjDistribId(String midDiscardProjDistribId) {
		this.midDiscardProjDistribId = midDiscardProjDistribId;
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

	public Double getOrigValueProject1() {
		return this.origValueProject1;
	}

	public void setOrigValueProject1(Double origValueProject1) {
		this.origValueProject1 = origValueProject1;
	}

	public Double getOrigValueProject2() {
		return this.origValueProject2;
	}

	public void setOrigValueProject2(Double origValueProject2) {
		this.origValueProject2 = origValueProject2;
	}

	public Double getOrigValueProject3() {
		return this.origValueProject3;
	}

	public void setOrigValueProject3(Double origValueProject3) {
		this.origValueProject3 = origValueProject3;
	}

	public Double getOrigValueProject4() {
		return this.origValueProject4;
	}

	public void setOrigValueProject4(Double origValueProject4) {
		this.origValueProject4 = origValueProject4;
	}

	public Double getNetValueProject1() {
		return this.netValueProject1;
	}

	public void setNetValueProject1(Double netValueProject1) {
		this.netValueProject1 = netValueProject1;
	}

	public Double getNetValueProject2() {
		return this.netValueProject2;
	}

	public void setNetValueProject2(Double netValueProject2) {
		this.netValueProject2 = netValueProject2;
	}

	public Double getNetValueProject3() {
		return this.netValueProject3;
	}

	public void setNetValueProject3(Double netValueProject3) {
		this.netValueProject3 = netValueProject3;
	}

	public Double getNetValueProject4() {
		return this.netValueProject4;
	}

	public void setNetValueProject4(Double netValueProject4) {
		this.netValueProject4 = netValueProject4;
	}

	public Double getQuantityProject1() {
		return this.quantityProject1;
	}

	public void setQuantityProject1(Double quantityProject1) {
		this.quantityProject1 = quantityProject1;
	}

	public Double getQuantityProject2() {
		return this.quantityProject2;
	}

	public void setQuantityProject2(Double quantityProject2) {
		this.quantityProject2 = quantityProject2;
	}

	public Double getQuantityProject3() {
		return this.quantityProject3;
	}

	public void setQuantityProject3(Double quantityProject3) {
		this.quantityProject3 = quantityProject3;
	}

	public Double getQuantityProject4() {
		return this.quantityProject4;
	}

	public void setQuantityProject4(Double quantityProject4) {
		this.quantityProject4 = quantityProject4;
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