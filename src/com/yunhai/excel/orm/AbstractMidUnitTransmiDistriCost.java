package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidUnitTransmiDistriCost entity provides the base persistence
 * definition of the MidUnitTransmiDistriCost entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidUnitTransmiDistriCost implements java.io.Serializable {

	// Fields

	private String midUnitTransmDistriCostId;
	private String version;
	private Date calYear;
	private String orgName;
	private Integer yearValue;
	private Date dvDateValue;
	private Double transmiDistriCost;
	private Double electricitySales;
	private Double unitElectrTransmDistriCost;

	// Constructors

	/** default constructor */
	public AbstractMidUnitTransmiDistriCost() {
	}

	/** minimal constructor */
	public AbstractMidUnitTransmiDistriCost(String midUnitTransmDistriCostId, String version, String orgName,
			Integer yearValue) {
		this.midUnitTransmDistriCostId = midUnitTransmDistriCostId;
		this.version = version;
		this.orgName = orgName;
		this.yearValue = yearValue;
	}

	/** full constructor */
	public AbstractMidUnitTransmiDistriCost(String midUnitTransmDistriCostId, String version, Date calYear,
			String orgName, Integer yearValue, Date dvDateValue, Double transmiDistriCost, Double electricitySales,
			Double unitElectrTransmDistriCost) {
		this.midUnitTransmDistriCostId = midUnitTransmDistriCostId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.yearValue = yearValue;
		this.dvDateValue = dvDateValue;
		this.transmiDistriCost = transmiDistriCost;
		this.electricitySales = electricitySales;
		this.unitElectrTransmDistriCost = unitElectrTransmDistriCost;
	}

	// Property accessors

	public String getMidUnitTransmDistriCostId() {
		return this.midUnitTransmDistriCostId;
	}

	public void setMidUnitTransmDistriCostId(String midUnitTransmDistriCostId) {
		this.midUnitTransmDistriCostId = midUnitTransmDistriCostId;
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

	public Integer getYearValue() {
		return this.yearValue;
	}

	public void setYearValue(Integer yearValue) {
		this.yearValue = yearValue;
	}

	public Date getDvDateValue() {
		return this.dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
	}

	public Double getTransmiDistriCost() {
		return this.transmiDistriCost;
	}

	public void setTransmiDistriCost(Double transmiDistriCost) {
		this.transmiDistriCost = transmiDistriCost;
	}

	public Double getElectricitySales() {
		return this.electricitySales;
	}

	public void setElectricitySales(Double electricitySales) {
		this.electricitySales = electricitySales;
	}

	public Double getUnitElectrTransmDistriCost() {
		return this.unitElectrTransmDistriCost;
	}

	public void setUnitElectrTransmDistriCost(Double unitElectrTransmDistriCost) {
		this.unitElectrTransmDistriCost = unitElectrTransmDistriCost;
	}

}