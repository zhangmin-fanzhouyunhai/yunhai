package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidDiscardReasonDistribute entity provides the base persistence
 * definition of the MidDiscardReasonDistribute entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidDiscardReasonDistribute implements java.io.Serializable {

	// Fields

	private String midDiscardReasonDistrId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double origValueDiscardReason1;
	private Double origValueDiscardReason2;
	private Double origValueDiscardReason3;
	private Double origValueDiscardReason4;
	private Double origValueDiscardReason5;
	private Double origValueDiscardReason6;
	private Double origValueDiscardReason7;
	private Double origValueDiscardReason8;
	private Double netValueDiscardReason1;
	private Double netValueDiscardReason2;
	private Double netValueDiscardReason3;
	private Double netValueDiscardReason4;
	private Double netValueDiscardReason5;
	private Double netValueDiscardReason6;
	private Double netValueDiscardReason7;
	private Double netValueDiscardReason8;
	private Double quantityDiscardReason1;
	private Double quantityDiscardReason2;
	private Double quantityDiscardReason3;
	private Double quantityDiscardReason4;
	private Double quantityDiscardReason5;
	private Double quantityDiscardReason6;
	private Double quantityDiscardReason7;
	private Double quantityDiscardReason8;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidDiscardReasonDistribute() {
	}

	/** minimal constructor */
	public AbstractMidDiscardReasonDistribute(String midDiscardReasonDistrId) {
		this.midDiscardReasonDistrId = midDiscardReasonDistrId;
	}

	/** full constructor */
	public AbstractMidDiscardReasonDistribute(String midDiscardReasonDistrId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double origValueDiscardReason1, Double origValueDiscardReason2, Double origValueDiscardReason3,
			Double origValueDiscardReason4, Double origValueDiscardReason5, Double origValueDiscardReason6,
			Double origValueDiscardReason7, Double origValueDiscardReason8, Double netValueDiscardReason1,
			Double netValueDiscardReason2, Double netValueDiscardReason3, Double netValueDiscardReason4,
			Double netValueDiscardReason5, Double netValueDiscardReason6, Double netValueDiscardReason7,
			Double netValueDiscardReason8, Double quantityDiscardReason1, Double quantityDiscardReason2,
			Double quantityDiscardReason3, Double quantityDiscardReason4, Double quantityDiscardReason5,
			Double quantityDiscardReason6, Double quantityDiscardReason7, Double quantityDiscardReason8,
			Date dvDateValue, String category, String areaName) {
		this.midDiscardReasonDistrId = midDiscardReasonDistrId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.origValueDiscardReason1 = origValueDiscardReason1;
		this.origValueDiscardReason2 = origValueDiscardReason2;
		this.origValueDiscardReason3 = origValueDiscardReason3;
		this.origValueDiscardReason4 = origValueDiscardReason4;
		this.origValueDiscardReason5 = origValueDiscardReason5;
		this.origValueDiscardReason6 = origValueDiscardReason6;
		this.origValueDiscardReason7 = origValueDiscardReason7;
		this.origValueDiscardReason8 = origValueDiscardReason8;
		this.netValueDiscardReason1 = netValueDiscardReason1;
		this.netValueDiscardReason2 = netValueDiscardReason2;
		this.netValueDiscardReason3 = netValueDiscardReason3;
		this.netValueDiscardReason4 = netValueDiscardReason4;
		this.netValueDiscardReason5 = netValueDiscardReason5;
		this.netValueDiscardReason6 = netValueDiscardReason6;
		this.netValueDiscardReason7 = netValueDiscardReason7;
		this.netValueDiscardReason8 = netValueDiscardReason8;
		this.quantityDiscardReason1 = quantityDiscardReason1;
		this.quantityDiscardReason2 = quantityDiscardReason2;
		this.quantityDiscardReason3 = quantityDiscardReason3;
		this.quantityDiscardReason4 = quantityDiscardReason4;
		this.quantityDiscardReason5 = quantityDiscardReason5;
		this.quantityDiscardReason6 = quantityDiscardReason6;
		this.quantityDiscardReason7 = quantityDiscardReason7;
		this.quantityDiscardReason8 = quantityDiscardReason8;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidDiscardReasonDistrId() {
		return this.midDiscardReasonDistrId;
	}

	public void setMidDiscardReasonDistrId(String midDiscardReasonDistrId) {
		this.midDiscardReasonDistrId = midDiscardReasonDistrId;
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

	public Double getOrigValueDiscardReason1() {
		return this.origValueDiscardReason1;
	}

	public void setOrigValueDiscardReason1(Double origValueDiscardReason1) {
		this.origValueDiscardReason1 = origValueDiscardReason1;
	}

	public Double getOrigValueDiscardReason2() {
		return this.origValueDiscardReason2;
	}

	public void setOrigValueDiscardReason2(Double origValueDiscardReason2) {
		this.origValueDiscardReason2 = origValueDiscardReason2;
	}

	public Double getOrigValueDiscardReason3() {
		return this.origValueDiscardReason3;
	}

	public void setOrigValueDiscardReason3(Double origValueDiscardReason3) {
		this.origValueDiscardReason3 = origValueDiscardReason3;
	}

	public Double getOrigValueDiscardReason4() {
		return this.origValueDiscardReason4;
	}

	public void setOrigValueDiscardReason4(Double origValueDiscardReason4) {
		this.origValueDiscardReason4 = origValueDiscardReason4;
	}

	public Double getOrigValueDiscardReason5() {
		return this.origValueDiscardReason5;
	}

	public void setOrigValueDiscardReason5(Double origValueDiscardReason5) {
		this.origValueDiscardReason5 = origValueDiscardReason5;
	}

	public Double getOrigValueDiscardReason6() {
		return this.origValueDiscardReason6;
	}

	public void setOrigValueDiscardReason6(Double origValueDiscardReason6) {
		this.origValueDiscardReason6 = origValueDiscardReason6;
	}

	public Double getOrigValueDiscardReason7() {
		return this.origValueDiscardReason7;
	}

	public void setOrigValueDiscardReason7(Double origValueDiscardReason7) {
		this.origValueDiscardReason7 = origValueDiscardReason7;
	}

	public Double getOrigValueDiscardReason8() {
		return this.origValueDiscardReason8;
	}

	public void setOrigValueDiscardReason8(Double origValueDiscardReason8) {
		this.origValueDiscardReason8 = origValueDiscardReason8;
	}

	public Double getNetValueDiscardReason1() {
		return this.netValueDiscardReason1;
	}

	public void setNetValueDiscardReason1(Double netValueDiscardReason1) {
		this.netValueDiscardReason1 = netValueDiscardReason1;
	}

	public Double getNetValueDiscardReason2() {
		return this.netValueDiscardReason2;
	}

	public void setNetValueDiscardReason2(Double netValueDiscardReason2) {
		this.netValueDiscardReason2 = netValueDiscardReason2;
	}

	public Double getNetValueDiscardReason3() {
		return this.netValueDiscardReason3;
	}

	public void setNetValueDiscardReason3(Double netValueDiscardReason3) {
		this.netValueDiscardReason3 = netValueDiscardReason3;
	}

	public Double getNetValueDiscardReason4() {
		return this.netValueDiscardReason4;
	}

	public void setNetValueDiscardReason4(Double netValueDiscardReason4) {
		this.netValueDiscardReason4 = netValueDiscardReason4;
	}

	public Double getNetValueDiscardReason5() {
		return this.netValueDiscardReason5;
	}

	public void setNetValueDiscardReason5(Double netValueDiscardReason5) {
		this.netValueDiscardReason5 = netValueDiscardReason5;
	}

	public Double getNetValueDiscardReason6() {
		return this.netValueDiscardReason6;
	}

	public void setNetValueDiscardReason6(Double netValueDiscardReason6) {
		this.netValueDiscardReason6 = netValueDiscardReason6;
	}

	public Double getNetValueDiscardReason7() {
		return this.netValueDiscardReason7;
	}

	public void setNetValueDiscardReason7(Double netValueDiscardReason7) {
		this.netValueDiscardReason7 = netValueDiscardReason7;
	}

	public Double getNetValueDiscardReason8() {
		return this.netValueDiscardReason8;
	}

	public void setNetValueDiscardReason8(Double netValueDiscardReason8) {
		this.netValueDiscardReason8 = netValueDiscardReason8;
	}

	public Double getQuantityDiscardReason1() {
		return this.quantityDiscardReason1;
	}

	public void setQuantityDiscardReason1(Double quantityDiscardReason1) {
		this.quantityDiscardReason1 = quantityDiscardReason1;
	}

	public Double getQuantityDiscardReason2() {
		return this.quantityDiscardReason2;
	}

	public void setQuantityDiscardReason2(Double quantityDiscardReason2) {
		this.quantityDiscardReason2 = quantityDiscardReason2;
	}

	public Double getQuantityDiscardReason3() {
		return this.quantityDiscardReason3;
	}

	public void setQuantityDiscardReason3(Double quantityDiscardReason3) {
		this.quantityDiscardReason3 = quantityDiscardReason3;
	}

	public Double getQuantityDiscardReason4() {
		return this.quantityDiscardReason4;
	}

	public void setQuantityDiscardReason4(Double quantityDiscardReason4) {
		this.quantityDiscardReason4 = quantityDiscardReason4;
	}

	public Double getQuantityDiscardReason5() {
		return this.quantityDiscardReason5;
	}

	public void setQuantityDiscardReason5(Double quantityDiscardReason5) {
		this.quantityDiscardReason5 = quantityDiscardReason5;
	}

	public Double getQuantityDiscardReason6() {
		return this.quantityDiscardReason6;
	}

	public void setQuantityDiscardReason6(Double quantityDiscardReason6) {
		this.quantityDiscardReason6 = quantityDiscardReason6;
	}

	public Double getQuantityDiscardReason7() {
		return this.quantityDiscardReason7;
	}

	public void setQuantityDiscardReason7(Double quantityDiscardReason7) {
		this.quantityDiscardReason7 = quantityDiscardReason7;
	}

	public Double getQuantityDiscardReason8() {
		return this.quantityDiscardReason8;
	}

	public void setQuantityDiscardReason8(Double quantityDiscardReason8) {
		this.quantityDiscardReason8 = quantityDiscardReason8;
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

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}