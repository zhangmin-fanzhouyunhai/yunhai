package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidAssetOriginalValueWall entity provides the base persistence
 * definition of the MidAssetOriginalValueWall entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetOriginalValueWall implements java.io.Serializable {

	// Fields

	private String midAssetOrigValueWallId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double totalOriginalValue;
	private Double originalValueAge1;
	private Double originalValueAge2;
	private Double originalValueAge3;
	private Double originalValueAge4;
	private Double originalValueAge5;
	private Double originalValueAge6;
	private Double originalValueAge7;
	private Double originalValueAge8;
	private Double originalValueAge9;
	private Double originalValueAge10;
	private Double originalValueAge11;
	private Double originalValueAge12;
	private Double originalValueAge13;
	private Double originalValueAge14;
	private Double originalValueAge15;
	private Double originalValueAge16;
	private Double originalValueAge17;
	private Double originalValueAge18;
	private Double originalValueAge19;
	private Double originalValueAge20;
	private Double originalValueAge21;
	private Double originalValueAge22;
	private Double originalValueAge23;
	private Double originalValueAge24;
	private Double originalValueAge25;
	private Double originalValueAge26;
	private Double originalValueAge27;
	private Double originalValueAge28;
	private Double originalValueAge29;
	private Double originalValueAge30;
	private Double originalValueAge31;
	private Double originalValueAge32;
	private Double originalValueAge33;
	private Double originalValueAge34;
	private Double quantityAgeMoreThan35;
	private Date dvDateValue;
	private String category;
	private String areaName;

	// Constructors

	/** default constructor */
	public AbstractMidAssetOriginalValueWall() {
	}

	/** minimal constructor */
	public AbstractMidAssetOriginalValueWall(String midAssetOrigValueWallId) {
		this.midAssetOrigValueWallId = midAssetOrigValueWallId;
	}

	/** full constructor */
	public AbstractMidAssetOriginalValueWall(String midAssetOrigValueWallId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double totalOriginalValue, Double originalValueAge1, Double originalValueAge2, Double originalValueAge3,
			Double originalValueAge4, Double originalValueAge5, Double originalValueAge6, Double originalValueAge7,
			Double originalValueAge8, Double originalValueAge9, Double originalValueAge10, Double originalValueAge11,
			Double originalValueAge12, Double originalValueAge13, Double originalValueAge14, Double originalValueAge15,
			Double originalValueAge16, Double originalValueAge17, Double originalValueAge18, Double originalValueAge19,
			Double originalValueAge20, Double originalValueAge21, Double originalValueAge22, Double originalValueAge23,
			Double originalValueAge24, Double originalValueAge25, Double originalValueAge26, Double originalValueAge27,
			Double originalValueAge28, Double originalValueAge29, Double originalValueAge30, Double originalValueAge31,
			Double originalValueAge32, Double originalValueAge33, Double originalValueAge34,
			Double quantityAgeMoreThan35, Date dvDateValue, String category, String areaName) {
		this.midAssetOrigValueWallId = midAssetOrigValueWallId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.totalOriginalValue = totalOriginalValue;
		this.originalValueAge1 = originalValueAge1;
		this.originalValueAge2 = originalValueAge2;
		this.originalValueAge3 = originalValueAge3;
		this.originalValueAge4 = originalValueAge4;
		this.originalValueAge5 = originalValueAge5;
		this.originalValueAge6 = originalValueAge6;
		this.originalValueAge7 = originalValueAge7;
		this.originalValueAge8 = originalValueAge8;
		this.originalValueAge9 = originalValueAge9;
		this.originalValueAge10 = originalValueAge10;
		this.originalValueAge11 = originalValueAge11;
		this.originalValueAge12 = originalValueAge12;
		this.originalValueAge13 = originalValueAge13;
		this.originalValueAge14 = originalValueAge14;
		this.originalValueAge15 = originalValueAge15;
		this.originalValueAge16 = originalValueAge16;
		this.originalValueAge17 = originalValueAge17;
		this.originalValueAge18 = originalValueAge18;
		this.originalValueAge19 = originalValueAge19;
		this.originalValueAge20 = originalValueAge20;
		this.originalValueAge21 = originalValueAge21;
		this.originalValueAge22 = originalValueAge22;
		this.originalValueAge23 = originalValueAge23;
		this.originalValueAge24 = originalValueAge24;
		this.originalValueAge25 = originalValueAge25;
		this.originalValueAge26 = originalValueAge26;
		this.originalValueAge27 = originalValueAge27;
		this.originalValueAge28 = originalValueAge28;
		this.originalValueAge29 = originalValueAge29;
		this.originalValueAge30 = originalValueAge30;
		this.originalValueAge31 = originalValueAge31;
		this.originalValueAge32 = originalValueAge32;
		this.originalValueAge33 = originalValueAge33;
		this.originalValueAge34 = originalValueAge34;
		this.quantityAgeMoreThan35 = quantityAgeMoreThan35;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
	}

	// Property accessors

	public String getMidAssetOrigValueWallId() {
		return this.midAssetOrigValueWallId;
	}

	public void setMidAssetOrigValueWallId(String midAssetOrigValueWallId) {
		this.midAssetOrigValueWallId = midAssetOrigValueWallId;
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

	public Double getTotalOriginalValue() {
		return this.totalOriginalValue;
	}

	public void setTotalOriginalValue(Double totalOriginalValue) {
		this.totalOriginalValue = totalOriginalValue;
	}

	public Double getOriginalValueAge1() {
		return this.originalValueAge1;
	}

	public void setOriginalValueAge1(Double originalValueAge1) {
		this.originalValueAge1 = originalValueAge1;
	}

	public Double getOriginalValueAge2() {
		return this.originalValueAge2;
	}

	public void setOriginalValueAge2(Double originalValueAge2) {
		this.originalValueAge2 = originalValueAge2;
	}

	public Double getOriginalValueAge3() {
		return this.originalValueAge3;
	}

	public void setOriginalValueAge3(Double originalValueAge3) {
		this.originalValueAge3 = originalValueAge3;
	}

	public Double getOriginalValueAge4() {
		return this.originalValueAge4;
	}

	public void setOriginalValueAge4(Double originalValueAge4) {
		this.originalValueAge4 = originalValueAge4;
	}

	public Double getOriginalValueAge5() {
		return this.originalValueAge5;
	}

	public void setOriginalValueAge5(Double originalValueAge5) {
		this.originalValueAge5 = originalValueAge5;
	}

	public Double getOriginalValueAge6() {
		return this.originalValueAge6;
	}

	public void setOriginalValueAge6(Double originalValueAge6) {
		this.originalValueAge6 = originalValueAge6;
	}

	public Double getOriginalValueAge7() {
		return this.originalValueAge7;
	}

	public void setOriginalValueAge7(Double originalValueAge7) {
		this.originalValueAge7 = originalValueAge7;
	}

	public Double getOriginalValueAge8() {
		return this.originalValueAge8;
	}

	public void setOriginalValueAge8(Double originalValueAge8) {
		this.originalValueAge8 = originalValueAge8;
	}

	public Double getOriginalValueAge9() {
		return this.originalValueAge9;
	}

	public void setOriginalValueAge9(Double originalValueAge9) {
		this.originalValueAge9 = originalValueAge9;
	}

	public Double getOriginalValueAge10() {
		return this.originalValueAge10;
	}

	public void setOriginalValueAge10(Double originalValueAge10) {
		this.originalValueAge10 = originalValueAge10;
	}

	public Double getOriginalValueAge11() {
		return this.originalValueAge11;
	}

	public void setOriginalValueAge11(Double originalValueAge11) {
		this.originalValueAge11 = originalValueAge11;
	}

	public Double getOriginalValueAge12() {
		return this.originalValueAge12;
	}

	public void setOriginalValueAge12(Double originalValueAge12) {
		this.originalValueAge12 = originalValueAge12;
	}

	public Double getOriginalValueAge13() {
		return this.originalValueAge13;
	}

	public void setOriginalValueAge13(Double originalValueAge13) {
		this.originalValueAge13 = originalValueAge13;
	}

	public Double getOriginalValueAge14() {
		return this.originalValueAge14;
	}

	public void setOriginalValueAge14(Double originalValueAge14) {
		this.originalValueAge14 = originalValueAge14;
	}

	public Double getOriginalValueAge15() {
		return this.originalValueAge15;
	}

	public void setOriginalValueAge15(Double originalValueAge15) {
		this.originalValueAge15 = originalValueAge15;
	}

	public Double getOriginalValueAge16() {
		return this.originalValueAge16;
	}

	public void setOriginalValueAge16(Double originalValueAge16) {
		this.originalValueAge16 = originalValueAge16;
	}

	public Double getOriginalValueAge17() {
		return this.originalValueAge17;
	}

	public void setOriginalValueAge17(Double originalValueAge17) {
		this.originalValueAge17 = originalValueAge17;
	}

	public Double getOriginalValueAge18() {
		return this.originalValueAge18;
	}

	public void setOriginalValueAge18(Double originalValueAge18) {
		this.originalValueAge18 = originalValueAge18;
	}

	public Double getOriginalValueAge19() {
		return this.originalValueAge19;
	}

	public void setOriginalValueAge19(Double originalValueAge19) {
		this.originalValueAge19 = originalValueAge19;
	}

	public Double getOriginalValueAge20() {
		return this.originalValueAge20;
	}

	public void setOriginalValueAge20(Double originalValueAge20) {
		this.originalValueAge20 = originalValueAge20;
	}

	public Double getOriginalValueAge21() {
		return this.originalValueAge21;
	}

	public void setOriginalValueAge21(Double originalValueAge21) {
		this.originalValueAge21 = originalValueAge21;
	}

	public Double getOriginalValueAge22() {
		return this.originalValueAge22;
	}

	public void setOriginalValueAge22(Double originalValueAge22) {
		this.originalValueAge22 = originalValueAge22;
	}

	public Double getOriginalValueAge23() {
		return this.originalValueAge23;
	}

	public void setOriginalValueAge23(Double originalValueAge23) {
		this.originalValueAge23 = originalValueAge23;
	}

	public Double getOriginalValueAge24() {
		return this.originalValueAge24;
	}

	public void setOriginalValueAge24(Double originalValueAge24) {
		this.originalValueAge24 = originalValueAge24;
	}

	public Double getOriginalValueAge25() {
		return this.originalValueAge25;
	}

	public void setOriginalValueAge25(Double originalValueAge25) {
		this.originalValueAge25 = originalValueAge25;
	}

	public Double getOriginalValueAge26() {
		return this.originalValueAge26;
	}

	public void setOriginalValueAge26(Double originalValueAge26) {
		this.originalValueAge26 = originalValueAge26;
	}

	public Double getOriginalValueAge27() {
		return this.originalValueAge27;
	}

	public void setOriginalValueAge27(Double originalValueAge27) {
		this.originalValueAge27 = originalValueAge27;
	}

	public Double getOriginalValueAge28() {
		return this.originalValueAge28;
	}

	public void setOriginalValueAge28(Double originalValueAge28) {
		this.originalValueAge28 = originalValueAge28;
	}

	public Double getOriginalValueAge29() {
		return this.originalValueAge29;
	}

	public void setOriginalValueAge29(Double originalValueAge29) {
		this.originalValueAge29 = originalValueAge29;
	}

	public Double getOriginalValueAge30() {
		return this.originalValueAge30;
	}

	public void setOriginalValueAge30(Double originalValueAge30) {
		this.originalValueAge30 = originalValueAge30;
	}

	public Double getOriginalValueAge31() {
		return this.originalValueAge31;
	}

	public void setOriginalValueAge31(Double originalValueAge31) {
		this.originalValueAge31 = originalValueAge31;
	}

	public Double getOriginalValueAge32() {
		return this.originalValueAge32;
	}

	public void setOriginalValueAge32(Double originalValueAge32) {
		this.originalValueAge32 = originalValueAge32;
	}

	public Double getOriginalValueAge33() {
		return this.originalValueAge33;
	}

	public void setOriginalValueAge33(Double originalValueAge33) {
		this.originalValueAge33 = originalValueAge33;
	}

	public Double getOriginalValueAge34() {
		return this.originalValueAge34;
	}

	public void setOriginalValueAge34(Double originalValueAge34) {
		this.originalValueAge34 = originalValueAge34;
	}

	public Double getQuantityAgeMoreThan35() {
		return this.quantityAgeMoreThan35;
	}

	public void setQuantityAgeMoreThan35(Double quantityAgeMoreThan35) {
		this.quantityAgeMoreThan35 = quantityAgeMoreThan35;
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