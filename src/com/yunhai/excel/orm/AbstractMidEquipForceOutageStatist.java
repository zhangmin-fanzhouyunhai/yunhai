package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidEquipForceOutageStatist entity provides the base persistence
 * definition of the MidEquipForceOutageStatist entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidEquipForceOutageStatist implements java.io.Serializable {

	// Fields

	private String midEquipForceOutageStaId;
	private String version;
	private Date calYear;
	private String orgName;
	private String assetClass;
	private String dutyReason;
	private String smallDutyReason;
	private Double equipForceOutageTimesYear1;
	private Double equipForceOutageTimesYear2;
	private Double equipForceOutageTimesYear3;
	private Double equipForceOutageTimesYear4;
	private Double equipForceOutageTimesYear5;
	private Date dvDateValue;
	private String dutyReasonCategory;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidEquipForceOutageStatist() {
	}

	/** minimal constructor */
	public AbstractMidEquipForceOutageStatist(String midEquipForceOutageStaId) {
		this.midEquipForceOutageStaId = midEquipForceOutageStaId;
	}

	/** full constructor */
	public AbstractMidEquipForceOutageStatist(String midEquipForceOutageStaId, String version, Date calYear,
			String orgName, String assetClass, String dutyReason, String smallDutyReason,
			Double equipForceOutageTimesYear1, Double equipForceOutageTimesYear2, Double equipForceOutageTimesYear3,
			Double equipForceOutageTimesYear4, Double equipForceOutageTimesYear5, Date dvDateValue,
			String dutyReasonCategory, String areaName) {
		this.midEquipForceOutageStaId = midEquipForceOutageStaId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.assetClass = assetClass;
		this.dutyReason = dutyReason;
		this.smallDutyReason = smallDutyReason;
		this.equipForceOutageTimesYear1 = equipForceOutageTimesYear1;
		this.equipForceOutageTimesYear2 = equipForceOutageTimesYear2;
		this.equipForceOutageTimesYear3 = equipForceOutageTimesYear3;
		this.equipForceOutageTimesYear4 = equipForceOutageTimesYear4;
		this.equipForceOutageTimesYear5 = equipForceOutageTimesYear5;
		this.dvDateValue = dvDateValue;
		this.dutyReasonCategory = dutyReasonCategory;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidEquipForceOutageStaId() {
		return this.midEquipForceOutageStaId;
	}

	public void setMidEquipForceOutageStaId(String midEquipForceOutageStaId) {
		this.midEquipForceOutageStaId = midEquipForceOutageStaId;
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

	public String getAssetClass() {
		return this.assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getDutyReason() {
		return this.dutyReason;
	}

	public void setDutyReason(String dutyReason) {
		this.dutyReason = dutyReason;
	}

	public String getSmallDutyReason() {
		return this.smallDutyReason;
	}

	public void setSmallDutyReason(String smallDutyReason) {
		this.smallDutyReason = smallDutyReason;
	}

	public Double getEquipForceOutageTimesYear1() {
		return this.equipForceOutageTimesYear1;
	}

	public void setEquipForceOutageTimesYear1(Double equipForceOutageTimesYear1) {
		this.equipForceOutageTimesYear1 = equipForceOutageTimesYear1;
	}

	public Double getEquipForceOutageTimesYear2() {
		return this.equipForceOutageTimesYear2;
	}

	public void setEquipForceOutageTimesYear2(Double equipForceOutageTimesYear2) {
		this.equipForceOutageTimesYear2 = equipForceOutageTimesYear2;
	}

	public Double getEquipForceOutageTimesYear3() {
		return this.equipForceOutageTimesYear3;
	}

	public void setEquipForceOutageTimesYear3(Double equipForceOutageTimesYear3) {
		this.equipForceOutageTimesYear3 = equipForceOutageTimesYear3;
	}

	public Double getEquipForceOutageTimesYear4() {
		return this.equipForceOutageTimesYear4;
	}

	public void setEquipForceOutageTimesYear4(Double equipForceOutageTimesYear4) {
		this.equipForceOutageTimesYear4 = equipForceOutageTimesYear4;
	}

	public Double getEquipForceOutageTimesYear5() {
		return this.equipForceOutageTimesYear5;
	}

	public void setEquipForceOutageTimesYear5(Double equipForceOutageTimesYear5) {
		this.equipForceOutageTimesYear5 = equipForceOutageTimesYear5;
	}

	public Date getDvDateValue() {
		return this.dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
	}

	public String getDutyReasonCategory() {
		return this.dutyReasonCategory;
	}

	public void setDutyReasonCategory(String dutyReasonCategory) {
		this.dutyReasonCategory = dutyReasonCategory;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}