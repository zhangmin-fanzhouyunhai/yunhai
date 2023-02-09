package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidEquipBreakdownSatistics entity provides the base persistence
 * definition of the MidEquipBreakdownSatistics entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidEquipBreakdownSatistics implements java.io.Serializable {

	// Fields

	private String midEquipBreakdownSatisId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeDutyReason;
	private String mediumDutyReason;
	private String smallDutyReason;
	private Double transmissionBreakdownTimes1;
	private Double transformerBreakdownTimes1;
	private Double distributionBreakdownTimes1;
	private Double transmissionBreakdownTimes2;
	private Double transformerBreakdownTimes2;
	private Double distributionBreakdownTimes2;
	private Double transmissionBreakdownTimes3;
	private Double transformerBreakdownTimes3;
	private Double distributionBreakdownTimes3;
	private Double transmissionBreakdownTimes4;
	private Double transformerBreakdownTimes4;
	private Double distributionBreakdownTimes4;
	private Double transmissionBreakdownTimes5;
	private Double transformerBreakdownTimes5;
	private Double distributionBreakdownTimes5;
	private Date dvDateValue;
	private String dutyReasonCategory;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidEquipBreakdownSatistics() {
	}

	/** minimal constructor */
	public AbstractMidEquipBreakdownSatistics(String midEquipBreakdownSatisId) {
		this.midEquipBreakdownSatisId = midEquipBreakdownSatisId;
	}

	/** full constructor */
	public AbstractMidEquipBreakdownSatistics(String midEquipBreakdownSatisId, String version, Date calYear,
			String orgName, String largeDutyReason, String mediumDutyReason, String smallDutyReason,
			Double transmissionBreakdownTimes1, Double transformerBreakdownTimes1, Double distributionBreakdownTimes1,
			Double transmissionBreakdownTimes2, Double transformerBreakdownTimes2, Double distributionBreakdownTimes2,
			Double transmissionBreakdownTimes3, Double transformerBreakdownTimes3, Double distributionBreakdownTimes3,
			Double transmissionBreakdownTimes4, Double transformerBreakdownTimes4, Double distributionBreakdownTimes4,
			Double transmissionBreakdownTimes5, Double transformerBreakdownTimes5, Double distributionBreakdownTimes5,
			Date dvDateValue, String dutyReasonCategory, String areaName) {
		this.midEquipBreakdownSatisId = midEquipBreakdownSatisId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeDutyReason = largeDutyReason;
		this.mediumDutyReason = mediumDutyReason;
		this.smallDutyReason = smallDutyReason;
		this.transmissionBreakdownTimes1 = transmissionBreakdownTimes1;
		this.transformerBreakdownTimes1 = transformerBreakdownTimes1;
		this.distributionBreakdownTimes1 = distributionBreakdownTimes1;
		this.transmissionBreakdownTimes2 = transmissionBreakdownTimes2;
		this.transformerBreakdownTimes2 = transformerBreakdownTimes2;
		this.distributionBreakdownTimes2 = distributionBreakdownTimes2;
		this.transmissionBreakdownTimes3 = transmissionBreakdownTimes3;
		this.transformerBreakdownTimes3 = transformerBreakdownTimes3;
		this.distributionBreakdownTimes3 = distributionBreakdownTimes3;
		this.transmissionBreakdownTimes4 = transmissionBreakdownTimes4;
		this.transformerBreakdownTimes4 = transformerBreakdownTimes4;
		this.distributionBreakdownTimes4 = distributionBreakdownTimes4;
		this.transmissionBreakdownTimes5 = transmissionBreakdownTimes5;
		this.transformerBreakdownTimes5 = transformerBreakdownTimes5;
		this.distributionBreakdownTimes5 = distributionBreakdownTimes5;
		this.dvDateValue = dvDateValue;
		this.dutyReasonCategory = dutyReasonCategory;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidEquipBreakdownSatisId() {
		return this.midEquipBreakdownSatisId;
	}

	public void setMidEquipBreakdownSatisId(String midEquipBreakdownSatisId) {
		this.midEquipBreakdownSatisId = midEquipBreakdownSatisId;
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

	public String getLargeDutyReason() {
		return this.largeDutyReason;
	}

	public void setLargeDutyReason(String largeDutyReason) {
		this.largeDutyReason = largeDutyReason;
	}

	public String getMediumDutyReason() {
		return this.mediumDutyReason;
	}

	public void setMediumDutyReason(String mediumDutyReason) {
		this.mediumDutyReason = mediumDutyReason;
	}

	public String getSmallDutyReason() {
		return this.smallDutyReason;
	}

	public void setSmallDutyReason(String smallDutyReason) {
		this.smallDutyReason = smallDutyReason;
	}

	public Double getTransmissionBreakdownTimes1() {
		return this.transmissionBreakdownTimes1;
	}

	public void setTransmissionBreakdownTimes1(Double transmissionBreakdownTimes1) {
		this.transmissionBreakdownTimes1 = transmissionBreakdownTimes1;
	}

	public Double getTransformerBreakdownTimes1() {
		return this.transformerBreakdownTimes1;
	}

	public void setTransformerBreakdownTimes1(Double transformerBreakdownTimes1) {
		this.transformerBreakdownTimes1 = transformerBreakdownTimes1;
	}

	public Double getDistributionBreakdownTimes1() {
		return this.distributionBreakdownTimes1;
	}

	public void setDistributionBreakdownTimes1(Double distributionBreakdownTimes1) {
		this.distributionBreakdownTimes1 = distributionBreakdownTimes1;
	}

	public Double getTransmissionBreakdownTimes2() {
		return this.transmissionBreakdownTimes2;
	}

	public void setTransmissionBreakdownTimes2(Double transmissionBreakdownTimes2) {
		this.transmissionBreakdownTimes2 = transmissionBreakdownTimes2;
	}

	public Double getTransformerBreakdownTimes2() {
		return this.transformerBreakdownTimes2;
	}

	public void setTransformerBreakdownTimes2(Double transformerBreakdownTimes2) {
		this.transformerBreakdownTimes2 = transformerBreakdownTimes2;
	}

	public Double getDistributionBreakdownTimes2() {
		return this.distributionBreakdownTimes2;
	}

	public void setDistributionBreakdownTimes2(Double distributionBreakdownTimes2) {
		this.distributionBreakdownTimes2 = distributionBreakdownTimes2;
	}

	public Double getTransmissionBreakdownTimes3() {
		return this.transmissionBreakdownTimes3;
	}

	public void setTransmissionBreakdownTimes3(Double transmissionBreakdownTimes3) {
		this.transmissionBreakdownTimes3 = transmissionBreakdownTimes3;
	}

	public Double getTransformerBreakdownTimes3() {
		return this.transformerBreakdownTimes3;
	}

	public void setTransformerBreakdownTimes3(Double transformerBreakdownTimes3) {
		this.transformerBreakdownTimes3 = transformerBreakdownTimes3;
	}

	public Double getDistributionBreakdownTimes3() {
		return this.distributionBreakdownTimes3;
	}

	public void setDistributionBreakdownTimes3(Double distributionBreakdownTimes3) {
		this.distributionBreakdownTimes3 = distributionBreakdownTimes3;
	}

	public Double getTransmissionBreakdownTimes4() {
		return this.transmissionBreakdownTimes4;
	}

	public void setTransmissionBreakdownTimes4(Double transmissionBreakdownTimes4) {
		this.transmissionBreakdownTimes4 = transmissionBreakdownTimes4;
	}

	public Double getTransformerBreakdownTimes4() {
		return this.transformerBreakdownTimes4;
	}

	public void setTransformerBreakdownTimes4(Double transformerBreakdownTimes4) {
		this.transformerBreakdownTimes4 = transformerBreakdownTimes4;
	}

	public Double getDistributionBreakdownTimes4() {
		return this.distributionBreakdownTimes4;
	}

	public void setDistributionBreakdownTimes4(Double distributionBreakdownTimes4) {
		this.distributionBreakdownTimes4 = distributionBreakdownTimes4;
	}

	public Double getTransmissionBreakdownTimes5() {
		return this.transmissionBreakdownTimes5;
	}

	public void setTransmissionBreakdownTimes5(Double transmissionBreakdownTimes5) {
		this.transmissionBreakdownTimes5 = transmissionBreakdownTimes5;
	}

	public Double getTransformerBreakdownTimes5() {
		return this.transformerBreakdownTimes5;
	}

	public void setTransformerBreakdownTimes5(Double transformerBreakdownTimes5) {
		this.transformerBreakdownTimes5 = transformerBreakdownTimes5;
	}

	public Double getDistributionBreakdownTimes5() {
		return this.distributionBreakdownTimes5;
	}

	public void setDistributionBreakdownTimes5(Double distributionBreakdownTimes5) {
		this.distributionBreakdownTimes5 = distributionBreakdownTimes5;
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