package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetUseStateOrigVal entity provides the base persistence
 * definition of the MidAssetUseStateOrigVal entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetUseStateOrigVal implements java.io.Serializable {

	// Fields

	private String midAssetUseStatOrigValId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double year1WorkingOrigVal;
	private Double year1BackupOrigVal;
	private Double year1DiscardOrigVal;
	private Double year2WorkingOrigVal;
	private Double year2BackupOrigVal;
	private Double year2DiscardOrigVal;
	private Double year3WorkingOrigVal;
	private Double year3BackupOrigVal;
	private Double year3DiscardOrigVal;
	private Double year4WorkingOrigVal;
	private Double year4BackupOrigVal;
	private Double year4DiscardOrigVal;
	private Double year5WorkingOrigVal;
	private Double year5BackupOrigVal;
	private Double year5DiscardOrigVal;
	private Double year6WorkingOrigVal;
	private Double year6BackupOrigVal;
	private Double year6DiscardOrigVal;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidAssetUseStateOrigVal() {
	}

	/** minimal constructor */
	public AbstractMidAssetUseStateOrigVal(String midAssetUseStatOrigValId) {
		this.midAssetUseStatOrigValId = midAssetUseStatOrigValId;
	}

	/** full constructor */
	public AbstractMidAssetUseStateOrigVal(String midAssetUseStatOrigValId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double year1WorkingOrigVal, Double year1BackupOrigVal, Double year1DiscardOrigVal,
			Double year2WorkingOrigVal, Double year2BackupOrigVal, Double year2DiscardOrigVal,
			Double year3WorkingOrigVal, Double year3BackupOrigVal, Double year3DiscardOrigVal,
			Double year4WorkingOrigVal, Double year4BackupOrigVal, Double year4DiscardOrigVal,
			Double year5WorkingOrigVal, Double year5BackupOrigVal, Double year5DiscardOrigVal,
			Double year6WorkingOrigVal, Double year6BackupOrigVal, Double year6DiscardOrigVal, Date dvDateValue,
			String category) {
		this.midAssetUseStatOrigValId = midAssetUseStatOrigValId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.year1WorkingOrigVal = year1WorkingOrigVal;
		this.year1BackupOrigVal = year1BackupOrigVal;
		this.year1DiscardOrigVal = year1DiscardOrigVal;
		this.year2WorkingOrigVal = year2WorkingOrigVal;
		this.year2BackupOrigVal = year2BackupOrigVal;
		this.year2DiscardOrigVal = year2DiscardOrigVal;
		this.year3WorkingOrigVal = year3WorkingOrigVal;
		this.year3BackupOrigVal = year3BackupOrigVal;
		this.year3DiscardOrigVal = year3DiscardOrigVal;
		this.year4WorkingOrigVal = year4WorkingOrigVal;
		this.year4BackupOrigVal = year4BackupOrigVal;
		this.year4DiscardOrigVal = year4DiscardOrigVal;
		this.year5WorkingOrigVal = year5WorkingOrigVal;
		this.year5BackupOrigVal = year5BackupOrigVal;
		this.year5DiscardOrigVal = year5DiscardOrigVal;
		this.year6WorkingOrigVal = year6WorkingOrigVal;
		this.year6BackupOrigVal = year6BackupOrigVal;
		this.year6DiscardOrigVal = year6DiscardOrigVal;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidAssetUseStatOrigValId() {
		return this.midAssetUseStatOrigValId;
	}

	public void setMidAssetUseStatOrigValId(String midAssetUseStatOrigValId) {
		this.midAssetUseStatOrigValId = midAssetUseStatOrigValId;
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

	public Double getYear1WorkingOrigVal() {
		return this.year1WorkingOrigVal;
	}

	public void setYear1WorkingOrigVal(Double year1WorkingOrigVal) {
		this.year1WorkingOrigVal = year1WorkingOrigVal;
	}

	public Double getYear1BackupOrigVal() {
		return this.year1BackupOrigVal;
	}

	public void setYear1BackupOrigVal(Double year1BackupOrigVal) {
		this.year1BackupOrigVal = year1BackupOrigVal;
	}

	public Double getYear1DiscardOrigVal() {
		return this.year1DiscardOrigVal;
	}

	public void setYear1DiscardOrigVal(Double year1DiscardOrigVal) {
		this.year1DiscardOrigVal = year1DiscardOrigVal;
	}

	public Double getYear2WorkingOrigVal() {
		return this.year2WorkingOrigVal;
	}

	public void setYear2WorkingOrigVal(Double year2WorkingOrigVal) {
		this.year2WorkingOrigVal = year2WorkingOrigVal;
	}

	public Double getYear2BackupOrigVal() {
		return this.year2BackupOrigVal;
	}

	public void setYear2BackupOrigVal(Double year2BackupOrigVal) {
		this.year2BackupOrigVal = year2BackupOrigVal;
	}

	public Double getYear2DiscardOrigVal() {
		return this.year2DiscardOrigVal;
	}

	public void setYear2DiscardOrigVal(Double year2DiscardOrigVal) {
		this.year2DiscardOrigVal = year2DiscardOrigVal;
	}

	public Double getYear3WorkingOrigVal() {
		return this.year3WorkingOrigVal;
	}

	public void setYear3WorkingOrigVal(Double year3WorkingOrigVal) {
		this.year3WorkingOrigVal = year3WorkingOrigVal;
	}

	public Double getYear3BackupOrigVal() {
		return this.year3BackupOrigVal;
	}

	public void setYear3BackupOrigVal(Double year3BackupOrigVal) {
		this.year3BackupOrigVal = year3BackupOrigVal;
	}

	public Double getYear3DiscardOrigVal() {
		return this.year3DiscardOrigVal;
	}

	public void setYear3DiscardOrigVal(Double year3DiscardOrigVal) {
		this.year3DiscardOrigVal = year3DiscardOrigVal;
	}

	public Double getYear4WorkingOrigVal() {
		return this.year4WorkingOrigVal;
	}

	public void setYear4WorkingOrigVal(Double year4WorkingOrigVal) {
		this.year4WorkingOrigVal = year4WorkingOrigVal;
	}

	public Double getYear4BackupOrigVal() {
		return this.year4BackupOrigVal;
	}

	public void setYear4BackupOrigVal(Double year4BackupOrigVal) {
		this.year4BackupOrigVal = year4BackupOrigVal;
	}

	public Double getYear4DiscardOrigVal() {
		return this.year4DiscardOrigVal;
	}

	public void setYear4DiscardOrigVal(Double year4DiscardOrigVal) {
		this.year4DiscardOrigVal = year4DiscardOrigVal;
	}

	public Double getYear5WorkingOrigVal() {
		return this.year5WorkingOrigVal;
	}

	public void setYear5WorkingOrigVal(Double year5WorkingOrigVal) {
		this.year5WorkingOrigVal = year5WorkingOrigVal;
	}

	public Double getYear5BackupOrigVal() {
		return this.year5BackupOrigVal;
	}

	public void setYear5BackupOrigVal(Double year5BackupOrigVal) {
		this.year5BackupOrigVal = year5BackupOrigVal;
	}

	public Double getYear5DiscardOrigVal() {
		return this.year5DiscardOrigVal;
	}

	public void setYear5DiscardOrigVal(Double year5DiscardOrigVal) {
		this.year5DiscardOrigVal = year5DiscardOrigVal;
	}

	public Double getYear6WorkingOrigVal() {
		return this.year6WorkingOrigVal;
	}

	public void setYear6WorkingOrigVal(Double year6WorkingOrigVal) {
		this.year6WorkingOrigVal = year6WorkingOrigVal;
	}

	public Double getYear6BackupOrigVal() {
		return this.year6BackupOrigVal;
	}

	public void setYear6BackupOrigVal(Double year6BackupOrigVal) {
		this.year6BackupOrigVal = year6BackupOrigVal;
	}

	public Double getYear6DiscardOrigVal() {
		return this.year6DiscardOrigVal;
	}

	public void setYear6DiscardOrigVal(Double year6DiscardOrigVal) {
		this.year6DiscardOrigVal = year6DiscardOrigVal;
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