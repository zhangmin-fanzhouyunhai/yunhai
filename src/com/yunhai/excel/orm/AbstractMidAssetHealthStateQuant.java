package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetHealthStateQuant entity provides the base persistence
 * definition of the MidAssetHealthStateQuant entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetHealthStateQuant implements java.io.Serializable {

	// Fields

	private String midAssetHealStateQuantId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double year1TotalAssetQuantity;
	private Double year1NormalStateQuant;
	private Double year1AttentionStateQuant;
	private Double year1UnnormalStateQuant;
	private Double year1SeriousStateQuant;
	private Double year2TotalAssetQuantity;
	private Double year2NormalStateQuant;
	private Double year2AttentionStateQuant;
	private Double year2UnnormalStateQuant;
	private Double year2SeriousStateQuant;
	private Double year3TotalAssetQuantity;
	private Double year3NormalStateQuant;
	private Double year3AttentionStateQuant;
	private Double year3UnnormalStateQuant;
	private Double year3SeriousStateQuant;
	private Double year4TotalAssetQuantity;
	private Double year4NormalStateQuant;
	private Double year4AttentionStateQuant;
	private Double year4UnnormalStateQuant;
	private Double year4SeriousStateQuant;
	private Double year5TotalAssetQuantity;
	private Double year5NormalStateQuant;
	private Double year5AttentionStateQuant;
	private Double year5UnnormalStateQuant;
	private Double year5SeriousStateQuant;
	private Double year6TotalAssetQuantity;
	private Double year6NormalStateQuant;
	private Double year6AttentionStateQuant;
	private Double year6UnnormalStateQuant;
	private Double year6SeriousStateQuant;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidAssetHealthStateQuant() {
	}

	/** minimal constructor */
	public AbstractMidAssetHealthStateQuant(String midAssetHealStateQuantId) {
		this.midAssetHealStateQuantId = midAssetHealStateQuantId;
	}

	/** full constructor */
	public AbstractMidAssetHealthStateQuant(String midAssetHealStateQuantId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double year1TotalAssetQuantity, Double year1NormalStateQuant, Double year1AttentionStateQuant,
			Double year1UnnormalStateQuant, Double year1SeriousStateQuant, Double year2TotalAssetQuantity,
			Double year2NormalStateQuant, Double year2AttentionStateQuant, Double year2UnnormalStateQuant,
			Double year2SeriousStateQuant, Double year3TotalAssetQuantity, Double year3NormalStateQuant,
			Double year3AttentionStateQuant, Double year3UnnormalStateQuant, Double year3SeriousStateQuant,
			Double year4TotalAssetQuantity, Double year4NormalStateQuant, Double year4AttentionStateQuant,
			Double year4UnnormalStateQuant, Double year4SeriousStateQuant, Double year5TotalAssetQuantity,
			Double year5NormalStateQuant, Double year5AttentionStateQuant, Double year5UnnormalStateQuant,
			Double year5SeriousStateQuant, Double year6TotalAssetQuantity, Double year6NormalStateQuant,
			Double year6AttentionStateQuant, Double year6UnnormalStateQuant, Double year6SeriousStateQuant,
			Date dvDateValue, String category) {
		this.midAssetHealStateQuantId = midAssetHealStateQuantId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.year1TotalAssetQuantity = year1TotalAssetQuantity;
		this.year1NormalStateQuant = year1NormalStateQuant;
		this.year1AttentionStateQuant = year1AttentionStateQuant;
		this.year1UnnormalStateQuant = year1UnnormalStateQuant;
		this.year1SeriousStateQuant = year1SeriousStateQuant;
		this.year2TotalAssetQuantity = year2TotalAssetQuantity;
		this.year2NormalStateQuant = year2NormalStateQuant;
		this.year2AttentionStateQuant = year2AttentionStateQuant;
		this.year2UnnormalStateQuant = year2UnnormalStateQuant;
		this.year2SeriousStateQuant = year2SeriousStateQuant;
		this.year3TotalAssetQuantity = year3TotalAssetQuantity;
		this.year3NormalStateQuant = year3NormalStateQuant;
		this.year3AttentionStateQuant = year3AttentionStateQuant;
		this.year3UnnormalStateQuant = year3UnnormalStateQuant;
		this.year3SeriousStateQuant = year3SeriousStateQuant;
		this.year4TotalAssetQuantity = year4TotalAssetQuantity;
		this.year4NormalStateQuant = year4NormalStateQuant;
		this.year4AttentionStateQuant = year4AttentionStateQuant;
		this.year4UnnormalStateQuant = year4UnnormalStateQuant;
		this.year4SeriousStateQuant = year4SeriousStateQuant;
		this.year5TotalAssetQuantity = year5TotalAssetQuantity;
		this.year5NormalStateQuant = year5NormalStateQuant;
		this.year5AttentionStateQuant = year5AttentionStateQuant;
		this.year5UnnormalStateQuant = year5UnnormalStateQuant;
		this.year5SeriousStateQuant = year5SeriousStateQuant;
		this.year6TotalAssetQuantity = year6TotalAssetQuantity;
		this.year6NormalStateQuant = year6NormalStateQuant;
		this.year6AttentionStateQuant = year6AttentionStateQuant;
		this.year6UnnormalStateQuant = year6UnnormalStateQuant;
		this.year6SeriousStateQuant = year6SeriousStateQuant;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidAssetHealStateQuantId() {
		return this.midAssetHealStateQuantId;
	}

	public void setMidAssetHealStateQuantId(String midAssetHealStateQuantId) {
		this.midAssetHealStateQuantId = midAssetHealStateQuantId;
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

	public Double getYear1TotalAssetQuantity() {
		return this.year1TotalAssetQuantity;
	}

	public void setYear1TotalAssetQuantity(Double year1TotalAssetQuantity) {
		this.year1TotalAssetQuantity = year1TotalAssetQuantity;
	}

	public Double getYear1NormalStateQuant() {
		return this.year1NormalStateQuant;
	}

	public void setYear1NormalStateQuant(Double year1NormalStateQuant) {
		this.year1NormalStateQuant = year1NormalStateQuant;
	}

	public Double getYear1AttentionStateQuant() {
		return this.year1AttentionStateQuant;
	}

	public void setYear1AttentionStateQuant(Double year1AttentionStateQuant) {
		this.year1AttentionStateQuant = year1AttentionStateQuant;
	}

	public Double getYear1UnnormalStateQuant() {
		return this.year1UnnormalStateQuant;
	}

	public void setYear1UnnormalStateQuant(Double year1UnnormalStateQuant) {
		this.year1UnnormalStateQuant = year1UnnormalStateQuant;
	}

	public Double getYear1SeriousStateQuant() {
		return this.year1SeriousStateQuant;
	}

	public void setYear1SeriousStateQuant(Double year1SeriousStateQuant) {
		this.year1SeriousStateQuant = year1SeriousStateQuant;
	}

	public Double getYear2TotalAssetQuantity() {
		return this.year2TotalAssetQuantity;
	}

	public void setYear2TotalAssetQuantity(Double year2TotalAssetQuantity) {
		this.year2TotalAssetQuantity = year2TotalAssetQuantity;
	}

	public Double getYear2NormalStateQuant() {
		return this.year2NormalStateQuant;
	}

	public void setYear2NormalStateQuant(Double year2NormalStateQuant) {
		this.year2NormalStateQuant = year2NormalStateQuant;
	}

	public Double getYear2AttentionStateQuant() {
		return this.year2AttentionStateQuant;
	}

	public void setYear2AttentionStateQuant(Double year2AttentionStateQuant) {
		this.year2AttentionStateQuant = year2AttentionStateQuant;
	}

	public Double getYear2UnnormalStateQuant() {
		return this.year2UnnormalStateQuant;
	}

	public void setYear2UnnormalStateQuant(Double year2UnnormalStateQuant) {
		this.year2UnnormalStateQuant = year2UnnormalStateQuant;
	}

	public Double getYear2SeriousStateQuant() {
		return this.year2SeriousStateQuant;
	}

	public void setYear2SeriousStateQuant(Double year2SeriousStateQuant) {
		this.year2SeriousStateQuant = year2SeriousStateQuant;
	}

	public Double getYear3TotalAssetQuantity() {
		return this.year3TotalAssetQuantity;
	}

	public void setYear3TotalAssetQuantity(Double year3TotalAssetQuantity) {
		this.year3TotalAssetQuantity = year3TotalAssetQuantity;
	}

	public Double getYear3NormalStateQuant() {
		return this.year3NormalStateQuant;
	}

	public void setYear3NormalStateQuant(Double year3NormalStateQuant) {
		this.year3NormalStateQuant = year3NormalStateQuant;
	}

	public Double getYear3AttentionStateQuant() {
		return this.year3AttentionStateQuant;
	}

	public void setYear3AttentionStateQuant(Double year3AttentionStateQuant) {
		this.year3AttentionStateQuant = year3AttentionStateQuant;
	}

	public Double getYear3UnnormalStateQuant() {
		return this.year3UnnormalStateQuant;
	}

	public void setYear3UnnormalStateQuant(Double year3UnnormalStateQuant) {
		this.year3UnnormalStateQuant = year3UnnormalStateQuant;
	}

	public Double getYear3SeriousStateQuant() {
		return this.year3SeriousStateQuant;
	}

	public void setYear3SeriousStateQuant(Double year3SeriousStateQuant) {
		this.year3SeriousStateQuant = year3SeriousStateQuant;
	}

	public Double getYear4TotalAssetQuantity() {
		return this.year4TotalAssetQuantity;
	}

	public void setYear4TotalAssetQuantity(Double year4TotalAssetQuantity) {
		this.year4TotalAssetQuantity = year4TotalAssetQuantity;
	}

	public Double getYear4NormalStateQuant() {
		return this.year4NormalStateQuant;
	}

	public void setYear4NormalStateQuant(Double year4NormalStateQuant) {
		this.year4NormalStateQuant = year4NormalStateQuant;
	}

	public Double getYear4AttentionStateQuant() {
		return this.year4AttentionStateQuant;
	}

	public void setYear4AttentionStateQuant(Double year4AttentionStateQuant) {
		this.year4AttentionStateQuant = year4AttentionStateQuant;
	}

	public Double getYear4UnnormalStateQuant() {
		return this.year4UnnormalStateQuant;
	}

	public void setYear4UnnormalStateQuant(Double year4UnnormalStateQuant) {
		this.year4UnnormalStateQuant = year4UnnormalStateQuant;
	}

	public Double getYear4SeriousStateQuant() {
		return this.year4SeriousStateQuant;
	}

	public void setYear4SeriousStateQuant(Double year4SeriousStateQuant) {
		this.year4SeriousStateQuant = year4SeriousStateQuant;
	}

	public Double getYear5TotalAssetQuantity() {
		return this.year5TotalAssetQuantity;
	}

	public void setYear5TotalAssetQuantity(Double year5TotalAssetQuantity) {
		this.year5TotalAssetQuantity = year5TotalAssetQuantity;
	}

	public Double getYear5NormalStateQuant() {
		return this.year5NormalStateQuant;
	}

	public void setYear5NormalStateQuant(Double year5NormalStateQuant) {
		this.year5NormalStateQuant = year5NormalStateQuant;
	}

	public Double getYear5AttentionStateQuant() {
		return this.year5AttentionStateQuant;
	}

	public void setYear5AttentionStateQuant(Double year5AttentionStateQuant) {
		this.year5AttentionStateQuant = year5AttentionStateQuant;
	}

	public Double getYear5UnnormalStateQuant() {
		return this.year5UnnormalStateQuant;
	}

	public void setYear5UnnormalStateQuant(Double year5UnnormalStateQuant) {
		this.year5UnnormalStateQuant = year5UnnormalStateQuant;
	}

	public Double getYear5SeriousStateQuant() {
		return this.year5SeriousStateQuant;
	}

	public void setYear5SeriousStateQuant(Double year5SeriousStateQuant) {
		this.year5SeriousStateQuant = year5SeriousStateQuant;
	}

	public Double getYear6TotalAssetQuantity() {
		return this.year6TotalAssetQuantity;
	}

	public void setYear6TotalAssetQuantity(Double year6TotalAssetQuantity) {
		this.year6TotalAssetQuantity = year6TotalAssetQuantity;
	}

	public Double getYear6NormalStateQuant() {
		return this.year6NormalStateQuant;
	}

	public void setYear6NormalStateQuant(Double year6NormalStateQuant) {
		this.year6NormalStateQuant = year6NormalStateQuant;
	}

	public Double getYear6AttentionStateQuant() {
		return this.year6AttentionStateQuant;
	}

	public void setYear6AttentionStateQuant(Double year6AttentionStateQuant) {
		this.year6AttentionStateQuant = year6AttentionStateQuant;
	}

	public Double getYear6UnnormalStateQuant() {
		return this.year6UnnormalStateQuant;
	}

	public void setYear6UnnormalStateQuant(Double year6UnnormalStateQuant) {
		this.year6UnnormalStateQuant = year6UnnormalStateQuant;
	}

	public Double getYear6SeriousStateQuant() {
		return this.year6SeriousStateQuant;
	}

	public void setYear6SeriousStateQuant(Double year6SeriousStateQuant) {
		this.year6SeriousStateQuant = year6SeriousStateQuant;
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