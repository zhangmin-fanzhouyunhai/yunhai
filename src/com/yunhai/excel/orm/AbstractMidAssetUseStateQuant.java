package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetUseStateQuant entity provides the base persistence definition
 * of the MidAssetUseStateQuant entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidAssetUseStateQuant implements java.io.Serializable {

	// Fields

	private String midAssetUseStateQuantId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double year1WorkingState;
	private Double year1BackupState;
	private Double year1DiscardState;
	private Double year2WorkingState;
	private Double year2BackupState;
	private Double year2DiscardState;
	private Double year3WorkingState;
	private Double year3BackupState;
	private Double year3DiscardState;
	private Double year4WorkingState;
	private Double year4BackupState;
	private Double year4DiscardState;
	private Double year5WorkingState;
	private Double year5BackupState;
	private Double year5DiscardState;
	private Double year6WorkingState;
	private Double year6BackupState;
	private Double year6DiscardState;
	private Date dvDateValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidAssetUseStateQuant() {
	}

	/** minimal constructor */
	public AbstractMidAssetUseStateQuant(String midAssetUseStateQuantId) {
		this.midAssetUseStateQuantId = midAssetUseStateQuantId;
	}

	/** full constructor */
	public AbstractMidAssetUseStateQuant(String midAssetUseStateQuantId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double year1WorkingState,
			Double year1BackupState, Double year1DiscardState, Double year2WorkingState, Double year2BackupState,
			Double year2DiscardState, Double year3WorkingState, Double year3BackupState, Double year3DiscardState,
			Double year4WorkingState, Double year4BackupState, Double year4DiscardState, Double year5WorkingState,
			Double year5BackupState, Double year5DiscardState, Double year6WorkingState, Double year6BackupState,
			Double year6DiscardState, Date dvDateValue, String category) {
		this.midAssetUseStateQuantId = midAssetUseStateQuantId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.year1WorkingState = year1WorkingState;
		this.year1BackupState = year1BackupState;
		this.year1DiscardState = year1DiscardState;
		this.year2WorkingState = year2WorkingState;
		this.year2BackupState = year2BackupState;
		this.year2DiscardState = year2DiscardState;
		this.year3WorkingState = year3WorkingState;
		this.year3BackupState = year3BackupState;
		this.year3DiscardState = year3DiscardState;
		this.year4WorkingState = year4WorkingState;
		this.year4BackupState = year4BackupState;
		this.year4DiscardState = year4DiscardState;
		this.year5WorkingState = year5WorkingState;
		this.year5BackupState = year5BackupState;
		this.year5DiscardState = year5DiscardState;
		this.year6WorkingState = year6WorkingState;
		this.year6BackupState = year6BackupState;
		this.year6DiscardState = year6DiscardState;
		this.dvDateValue = dvDateValue;
		this.category = category;
	}

	// Property accessors

	public String getMidAssetUseStateQuantId() {
		return this.midAssetUseStateQuantId;
	}

	public void setMidAssetUseStateQuantId(String midAssetUseStateQuantId) {
		this.midAssetUseStateQuantId = midAssetUseStateQuantId;
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

	public Double getYear1WorkingState() {
		return this.year1WorkingState;
	}

	public void setYear1WorkingState(Double year1WorkingState) {
		this.year1WorkingState = year1WorkingState;
	}

	public Double getYear1BackupState() {
		return this.year1BackupState;
	}

	public void setYear1BackupState(Double year1BackupState) {
		this.year1BackupState = year1BackupState;
	}

	public Double getYear1DiscardState() {
		return this.year1DiscardState;
	}

	public void setYear1DiscardState(Double year1DiscardState) {
		this.year1DiscardState = year1DiscardState;
	}

	public Double getYear2WorkingState() {
		return this.year2WorkingState;
	}

	public void setYear2WorkingState(Double year2WorkingState) {
		this.year2WorkingState = year2WorkingState;
	}

	public Double getYear2BackupState() {
		return this.year2BackupState;
	}

	public void setYear2BackupState(Double year2BackupState) {
		this.year2BackupState = year2BackupState;
	}

	public Double getYear2DiscardState() {
		return this.year2DiscardState;
	}

	public void setYear2DiscardState(Double year2DiscardState) {
		this.year2DiscardState = year2DiscardState;
	}

	public Double getYear3WorkingState() {
		return this.year3WorkingState;
	}

	public void setYear3WorkingState(Double year3WorkingState) {
		this.year3WorkingState = year3WorkingState;
	}

	public Double getYear3BackupState() {
		return this.year3BackupState;
	}

	public void setYear3BackupState(Double year3BackupState) {
		this.year3BackupState = year3BackupState;
	}

	public Double getYear3DiscardState() {
		return this.year3DiscardState;
	}

	public void setYear3DiscardState(Double year3DiscardState) {
		this.year3DiscardState = year3DiscardState;
	}

	public Double getYear4WorkingState() {
		return this.year4WorkingState;
	}

	public void setYear4WorkingState(Double year4WorkingState) {
		this.year4WorkingState = year4WorkingState;
	}

	public Double getYear4BackupState() {
		return this.year4BackupState;
	}

	public void setYear4BackupState(Double year4BackupState) {
		this.year4BackupState = year4BackupState;
	}

	public Double getYear4DiscardState() {
		return this.year4DiscardState;
	}

	public void setYear4DiscardState(Double year4DiscardState) {
		this.year4DiscardState = year4DiscardState;
	}

	public Double getYear5WorkingState() {
		return this.year5WorkingState;
	}

	public void setYear5WorkingState(Double year5WorkingState) {
		this.year5WorkingState = year5WorkingState;
	}

	public Double getYear5BackupState() {
		return this.year5BackupState;
	}

	public void setYear5BackupState(Double year5BackupState) {
		this.year5BackupState = year5BackupState;
	}

	public Double getYear5DiscardState() {
		return this.year5DiscardState;
	}

	public void setYear5DiscardState(Double year5DiscardState) {
		this.year5DiscardState = year5DiscardState;
	}

	public Double getYear6WorkingState() {
		return this.year6WorkingState;
	}

	public void setYear6WorkingState(Double year6WorkingState) {
		this.year6WorkingState = year6WorkingState;
	}

	public Double getYear6BackupState() {
		return this.year6BackupState;
	}

	public void setYear6BackupState(Double year6BackupState) {
		this.year6BackupState = year6BackupState;
	}

	public Double getYear6DiscardState() {
		return this.year6DiscardState;
	}

	public void setYear6DiscardState(Double year6DiscardState) {
		this.year6DiscardState = year6DiscardState;
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