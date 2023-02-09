package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidMaintenOverhaulCost entity provides the base persistence
 * definition of the MidMaintenOverhaulCost entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidMaintenOverhaulCost implements java.io.Serializable {

	// Fields

	private String midMaintenOverhaulCostId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double overhaul5YearCost;
	private Double overhaul4YearCost;
	private Double overhaul3YearCost;
	private Double overhaul2YearCost;
	private Double overhaul1YearCost;
	private Double maintenance5YearCost;
	private Double maintenance4YearCost;
	private Double maintenance3YearCost;
	private Double maintenance2YearCost;
	private Double maintenance1YearCost;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidMaintenOverhaulCost() {
	}

	/** minimal constructor */
	public AbstractMidMaintenOverhaulCost(String midMaintenOverhaulCostId) {
		this.midMaintenOverhaulCostId = midMaintenOverhaulCostId;
	}

	/** full constructor */
	public AbstractMidMaintenOverhaulCost(String midMaintenOverhaulCostId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double overhaul5YearCost, Double overhaul4YearCost, Double overhaul3YearCost, Double overhaul2YearCost,
			Double overhaul1YearCost, Double maintenance5YearCost, Double maintenance4YearCost,
			Double maintenance3YearCost, Double maintenance2YearCost, Double maintenance1YearCost,
			Date dvDateValue, String category) {
		this.midMaintenOverhaulCostId = midMaintenOverhaulCostId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.overhaul5YearCost = overhaul5YearCost;
		this.overhaul4YearCost = overhaul4YearCost;
		this.overhaul3YearCost = overhaul3YearCost;
		this.overhaul2YearCost = overhaul2YearCost;
		this.overhaul1YearCost = overhaul1YearCost;
		this.maintenance5YearCost = maintenance5YearCost;
		this.maintenance4YearCost = maintenance4YearCost;
		this.maintenance3YearCost = maintenance3YearCost;
		this.maintenance2YearCost = maintenance2YearCost;
		this.maintenance1YearCost = maintenance1YearCost;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidMaintenOverhaulCostId() {
		return this.midMaintenOverhaulCostId;
	}

	public void setMidMaintenOverhaulCostId(String midMaintenOverhaulCostId) {
		this.midMaintenOverhaulCostId = midMaintenOverhaulCostId;
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

	public Double getOverhaul5YearCost() {
		return this.overhaul5YearCost;
	}

	public void setOverhaul5YearCost(Double overhaul5YearCost) {
		this.overhaul5YearCost = overhaul5YearCost;
	}

	public Double getOverhaul4YearCost() {
		return this.overhaul4YearCost;
	}

	public void setOverhaul4YearCost(Double overhaul4YearCost) {
		this.overhaul4YearCost = overhaul4YearCost;
	}

	public Double getOverhaul3YearCost() {
		return this.overhaul3YearCost;
	}

	public void setOverhaul3YearCost(Double overhaul3YearCost) {
		this.overhaul3YearCost = overhaul3YearCost;
	}

	public Double getOverhaul2YearCost() {
		return this.overhaul2YearCost;
	}

	public void setOverhaul2YearCost(Double overhaul2YearCost) {
		this.overhaul2YearCost = overhaul2YearCost;
	}

	public Double getOverhaul1YearCost() {
		return this.overhaul1YearCost;
	}

	public void setOverhaul1YearCost(Double overhaul1YearCost) {
		this.overhaul1YearCost = overhaul1YearCost;
	}

	public Double getMaintenance5YearCost() {
		return this.maintenance5YearCost;
	}

	public void setMaintenance5YearCost(Double maintenance5YearCost) {
		this.maintenance5YearCost = maintenance5YearCost;
	}

	public Double getMaintenance4YearCost() {
		return this.maintenance4YearCost;
	}

	public void setMaintenance4YearCost(Double maintenance4YearCost) {
		this.maintenance4YearCost = maintenance4YearCost;
	}

	public Double getMaintenance3YearCost() {
		return this.maintenance3YearCost;
	}

	public void setMaintenance3YearCost(Double maintenance3YearCost) {
		this.maintenance3YearCost = maintenance3YearCost;
	}

	public Double getMaintenance2YearCost() {
		return this.maintenance2YearCost;
	}

	public void setMaintenance2YearCost(Double maintenance2YearCost) {
		this.maintenance2YearCost = maintenance2YearCost;
	}

	public Double getMaintenance1YearCost() {
		return this.maintenance1YearCost;
	}

	public void setMaintenance1YearCost(Double maintenance1YearCost) {
		this.maintenance1YearCost = maintenance1YearCost;
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