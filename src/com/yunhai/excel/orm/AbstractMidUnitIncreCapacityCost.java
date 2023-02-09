package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidUnitIncreCapacityCost entity provides the base persistence
 * definition of the MidUnitIncreCapacityCost entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidUnitIncreCapacityCost implements java.io.Serializable {

	// Fields

	private String midUnitIncreCapaciCostId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Date dvDateValue;
	private String category;
	private Double year1Cost;
	private Double year2Cost;
	private Double year3Cost;
	private Double year4Cost;
	private Double year5Cost;

	// Constructors

	/** default constructor */
	public AbstractMidUnitIncreCapacityCost() {
	}

	/** minimal constructor */
	public AbstractMidUnitIncreCapacityCost(String midUnitIncreCapaciCostId, String version, String orgName,
			String largeClass) {
		this.midUnitIncreCapaciCostId = midUnitIncreCapaciCostId;
		this.version = version;
		this.orgName = orgName;
		this.largeClass = largeClass;
	}

	/** full constructor */
	public AbstractMidUnitIncreCapacityCost(String midUnitIncreCapaciCostId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Date dvDateValue, String category, Double year1Cost, Double year2Cost, Double year3Cost,
			Double year4Cost, Double year5Cost) {
		this.midUnitIncreCapaciCostId = midUnitIncreCapaciCostId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.year1Cost = year1Cost;
		this.year2Cost = year2Cost;
		this.year3Cost = year3Cost;
		this.year4Cost = year4Cost;
		this.year5Cost = year5Cost;
	}

	// Property accessors

	public String getMidUnitIncreCapaciCostId() {
		return this.midUnitIncreCapaciCostId;
	}

	public void setMidUnitIncreCapaciCostId(String midUnitIncreCapaciCostId) {
		this.midUnitIncreCapaciCostId = midUnitIncreCapaciCostId;
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

	public Double getYear1Cost() {
		return this.year1Cost;
	}

	public void setYear1Cost(Double year1Cost) {
		this.year1Cost = year1Cost;
	}

	public Double getYear2Cost() {
		return this.year2Cost;
	}

	public void setYear2Cost(Double year2Cost) {
		this.year2Cost = year2Cost;
	}

	public Double getYear3Cost() {
		return this.year3Cost;
	}

	public void setYear3Cost(Double year3Cost) {
		this.year3Cost = year3Cost;
	}

	public Double getYear4Cost() {
		return this.year4Cost;
	}

	public void setYear4Cost(Double year4Cost) {
		this.year4Cost = year4Cost;
	}

	public Double getYear5Cost() {
		return this.year5Cost;
	}

	public void setYear5Cost(Double year5Cost) {
		this.year5Cost = year5Cost;
	}

}