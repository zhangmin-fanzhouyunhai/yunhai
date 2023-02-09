package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidDepreciationCost entity provides the base persistence definition
 * of the MidDepreciationCost entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidDepreciationCost implements java.io.Serializable {

	// Fields

	private String midDepreciationCostId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Date dvDateValue;
	private String category;
	private Double year1DeprecCost;
	private Double year2DeprecCost;
	private Double year3DeprecCost;
	private Double year4DeprecCost;
	private Double year5DeprecCost;

	// Constructors

	/** default constructor */
	public AbstractMidDepreciationCost() {
	}

	/** minimal constructor */
	public AbstractMidDepreciationCost(String midDepreciationCostId, String version, String orgName,
			String largeClass) {
		this.midDepreciationCostId = midDepreciationCostId;
		this.version = version;
		this.orgName = orgName;
		this.largeClass = largeClass;
	}

	/** full constructor */
	public AbstractMidDepreciationCost(String midDepreciationCostId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Date dvDateValue,
			String category, Double year1DeprecCost, Double year2DeprecCost, Double year3DeprecCost,
			Double year4DeprecCost, Double year5DeprecCost) {
		this.midDepreciationCostId = midDepreciationCostId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.year1DeprecCost = year1DeprecCost;
		this.year2DeprecCost = year2DeprecCost;
		this.year3DeprecCost = year3DeprecCost;
		this.year4DeprecCost = year4DeprecCost;
		this.year5DeprecCost = year5DeprecCost;
	}

	// Property accessors

	public String getMidDepreciationCostId() {
		return this.midDepreciationCostId;
	}

	public void setMidDepreciationCostId(String midDepreciationCostId) {
		this.midDepreciationCostId = midDepreciationCostId;
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

	public Double getYear1DeprecCost() {
		return this.year1DeprecCost;
	}

	public void setYear1DeprecCost(Double year1DeprecCost) {
		this.year1DeprecCost = year1DeprecCost;
	}

	public Double getYear2DeprecCost() {
		return this.year2DeprecCost;
	}

	public void setYear2DeprecCost(Double year2DeprecCost) {
		this.year2DeprecCost = year2DeprecCost;
	}

	public Double getYear3DeprecCost() {
		return this.year3DeprecCost;
	}

	public void setYear3DeprecCost(Double year3DeprecCost) {
		this.year3DeprecCost = year3DeprecCost;
	}

	public Double getYear4DeprecCost() {
		return this.year4DeprecCost;
	}

	public void setYear4DeprecCost(Double year4DeprecCost) {
		this.year4DeprecCost = year4DeprecCost;
	}

	public Double getYear5DeprecCost() {
		return this.year5DeprecCost;
	}

	public void setYear5DeprecCost(Double year5DeprecCost) {
		this.year5DeprecCost = year5DeprecCost;
	}

}