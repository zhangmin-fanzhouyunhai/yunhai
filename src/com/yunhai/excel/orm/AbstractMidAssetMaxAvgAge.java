package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractMidAssetMaxAvgAge entity provides the base persistence definition of
 * the MidAssetMaxAvgAge entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidAssetMaxAvgAge implements java.io.Serializable {

	// Fields

	private String midAssetMaxAvgAgeId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double year1AvgAge;
	private Double year1MaxAge;
	private Double year2AvgAge;
	private Double year2MaxAge;
	private Double year3AvgAge;
	private Double year3MaxAge;
	private Double year4AvgAge;
	private Double year4MaxAge;
	private Double year5AvgAge;
	private Double year5MaxAge;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidAssetMaxAvgAge() {
	}

	/** minimal constructor */
	public AbstractMidAssetMaxAvgAge(String midAssetMaxAvgAgeId) {
		this.midAssetMaxAvgAgeId = midAssetMaxAvgAgeId;
	}

	/** full constructor */
	public AbstractMidAssetMaxAvgAge(String midAssetMaxAvgAgeId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double year1AvgAge,
			Double year1MaxAge, Double year2AvgAge, Double year2MaxAge, Double year3AvgAge, Double year3MaxAge,
			Double year4AvgAge, Double year4MaxAge, Double year5AvgAge, Double year5MaxAge, Date dvDateValue,
			String category) {
		this.midAssetMaxAvgAgeId = midAssetMaxAvgAgeId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.year1AvgAge = year1AvgAge;
		this.year1MaxAge = year1MaxAge;
		this.year2AvgAge = year2AvgAge;
		this.year2MaxAge = year2MaxAge;
		this.year3AvgAge = year3AvgAge;
		this.year3MaxAge = year3MaxAge;
		this.year4AvgAge = year4AvgAge;
		this.year4MaxAge = year4MaxAge;
		this.year5AvgAge = year5AvgAge;
		this.year5MaxAge = year5MaxAge;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidAssetMaxAvgAgeId() {
		return this.midAssetMaxAvgAgeId;
	}

	public void setMidAssetMaxAvgAgeId(String midAssetMaxAvgAgeId) {
		this.midAssetMaxAvgAgeId = midAssetMaxAvgAgeId;
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

	public Double getYear1AvgAge() {
		return this.year1AvgAge;
	}

	public void setYear1AvgAge(Double year1AvgAge) {
		this.year1AvgAge = year1AvgAge;
	}

	public Double getYear1MaxAge() {
		return this.year1MaxAge;
	}

	public void setYear1MaxAge(Double year1MaxAge) {
		this.year1MaxAge = year1MaxAge;
	}

	public Double getYear2AvgAge() {
		return this.year2AvgAge;
	}

	public void setYear2AvgAge(Double year2AvgAge) {
		this.year2AvgAge = year2AvgAge;
	}

	public Double getYear2MaxAge() {
		return this.year2MaxAge;
	}

	public void setYear2MaxAge(Double year2MaxAge) {
		this.year2MaxAge = year2MaxAge;
	}

	public Double getYear3AvgAge() {
		return this.year3AvgAge;
	}

	public void setYear3AvgAge(Double year3AvgAge) {
		this.year3AvgAge = year3AvgAge;
	}

	public Double getYear3MaxAge() {
		return this.year3MaxAge;
	}

	public void setYear3MaxAge(Double year3MaxAge) {
		this.year3MaxAge = year3MaxAge;
	}

	public Double getYear4AvgAge() {
		return this.year4AvgAge;
	}

	public void setYear4AvgAge(Double year4AvgAge) {
		this.year4AvgAge = year4AvgAge;
	}

	public Double getYear4MaxAge() {
		return this.year4MaxAge;
	}

	public void setYear4MaxAge(Double year4MaxAge) {
		this.year4MaxAge = year4MaxAge;
	}

	public Double getYear5AvgAge() {
		return this.year5AvgAge;
	}

	public void setYear5AvgAge(Double year5AvgAge) {
		this.year5AvgAge = year5AvgAge;
	}

	public Double getYear5MaxAge() {
		return this.year5MaxAge;
	}

	public void setYear5MaxAge(Double year5MaxAge) {
		this.year5MaxAge = year5MaxAge;
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