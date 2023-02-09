package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractMidAssetQuantAgeStructure entity provides the base persistence
 * definition of the MidAssetQuantAgeStructure entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractMidAssetQuantAgeStructure implements java.io.Serializable {

	// Fields

	private String midAssetQuantAgeStructId;
	private String version;
	private Date calYear;
	private String orgName;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Double totalQuantity;
	private Double quantityAge1;
	private Double quantityAge2;
	private Double quantityAge3;
	private Double quantityAge4;
	private Double quantityAge5;
	private Double quantityAge6;
	private Double quantityAge7;
	private Double quantityAge8;
	private Double quantityAge9;
	private Double quantityAge10;
	private Double quantityAge11;
	private Double quantityAge12;
	private Double quantityAge13;
	private Double quantityAge14;
	private Double quantityAge15;
	private Double quantityAge16;
	private Double quantityAge17;
	private Double quantityAge18;
	private Double quantityAge19;
	private Double quantityAge20;
	private Double quantityAge21;
	private Double quantityAge22;
	private Double quantityAge23;
	private Double quantityAge24;
	private Double quantityAge25;
	private Double quantityAge26;
	private Double quantityAge27;
	private Double quantityAge28;
	private Double quantityAge29;
	private Double quantityAge30;
	private Double quantityAgeMoreThan30;
	private Date dvDateValue;
	private String category;
	private String areaName;
	private Double quantAgeBetween05Year;
	private Double quantAgeBetween510Year;
	private Double quantAgeBetween1015Year;
	private Double quantAgeBetween1520Year;
	private Double quantAgeBetween2030Year;
	private Double quantAgeMoreThen30Year;

	// Constructors

	/** default constructor */
	public AbstractMidAssetQuantAgeStructure() {
	}

	/** minimal constructor */
	public AbstractMidAssetQuantAgeStructure(String midAssetQuantAgeStructId, Date calYear) {
		this.midAssetQuantAgeStructId = midAssetQuantAgeStructId;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractMidAssetQuantAgeStructure(String midAssetQuantAgeStructId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double totalQuantity, Double quantityAge1, Double quantityAge2, Double quantityAge3, Double quantityAge4,
			Double quantityAge5, Double quantityAge6, Double quantityAge7, Double quantityAge8, Double quantityAge9,
			Double quantityAge10, Double quantityAge11, Double quantityAge12, Double quantityAge13,
			Double quantityAge14, Double quantityAge15, Double quantityAge16, Double quantityAge17,
			Double quantityAge18, Double quantityAge19, Double quantityAge20, Double quantityAge21,
			Double quantityAge22, Double quantityAge23, Double quantityAge24, Double quantityAge25,
			Double quantityAge26, Double quantityAge27, Double quantityAge28, Double quantityAge29,
			Double quantityAge30, Double quantityAgeMoreThan30, Date dvDateValue, String category, String areaName,
			Double quantAgeBetween05Year, Double quantAgeBetween510Year, Double quantAgeBetween1015Year,
			Double quantAgeBetween1520Year, Double quantAgeBetween2030Year, Double quantAgeMoreThen30Year) {
		this.midAssetQuantAgeStructId = midAssetQuantAgeStructId;
		this.version = version;
		this.calYear = calYear;
		this.orgName = orgName;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.totalQuantity = totalQuantity;
		this.quantityAge1 = quantityAge1;
		this.quantityAge2 = quantityAge2;
		this.quantityAge3 = quantityAge3;
		this.quantityAge4 = quantityAge4;
		this.quantityAge5 = quantityAge5;
		this.quantityAge6 = quantityAge6;
		this.quantityAge7 = quantityAge7;
		this.quantityAge8 = quantityAge8;
		this.quantityAge9 = quantityAge9;
		this.quantityAge10 = quantityAge10;
		this.quantityAge11 = quantityAge11;
		this.quantityAge12 = quantityAge12;
		this.quantityAge13 = quantityAge13;
		this.quantityAge14 = quantityAge14;
		this.quantityAge15 = quantityAge15;
		this.quantityAge16 = quantityAge16;
		this.quantityAge17 = quantityAge17;
		this.quantityAge18 = quantityAge18;
		this.quantityAge19 = quantityAge19;
		this.quantityAge20 = quantityAge20;
		this.quantityAge21 = quantityAge21;
		this.quantityAge22 = quantityAge22;
		this.quantityAge23 = quantityAge23;
		this.quantityAge24 = quantityAge24;
		this.quantityAge25 = quantityAge25;
		this.quantityAge26 = quantityAge26;
		this.quantityAge27 = quantityAge27;
		this.quantityAge28 = quantityAge28;
		this.quantityAge29 = quantityAge29;
		this.quantityAge30 = quantityAge30;
		this.quantityAgeMoreThan30 = quantityAgeMoreThan30;
		this.dvDateValue = dvDateValue;
		this.category = category;
		this.areaName = areaName;
		this.quantAgeBetween05Year = quantAgeBetween05Year;
		this.quantAgeBetween510Year = quantAgeBetween510Year;
		this.quantAgeBetween1015Year = quantAgeBetween1015Year;
		this.quantAgeBetween1520Year = quantAgeBetween1520Year;
		this.quantAgeBetween2030Year = quantAgeBetween2030Year;
		this.quantAgeMoreThen30Year = quantAgeMoreThen30Year;
	}

	// Property accessors

	public String getMidAssetQuantAgeStructId() {
		return this.midAssetQuantAgeStructId;
	}

	public void setMidAssetQuantAgeStructId(String midAssetQuantAgeStructId) {
		this.midAssetQuantAgeStructId = midAssetQuantAgeStructId;
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

	public Double getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getQuantityAge1() {
		return this.quantityAge1;
	}

	public void setQuantityAge1(Double quantityAge1) {
		this.quantityAge1 = quantityAge1;
	}

	public Double getQuantityAge2() {
		return this.quantityAge2;
	}

	public void setQuantityAge2(Double quantityAge2) {
		this.quantityAge2 = quantityAge2;
	}

	public Double getQuantityAge3() {
		return this.quantityAge3;
	}

	public void setQuantityAge3(Double quantityAge3) {
		this.quantityAge3 = quantityAge3;
	}

	public Double getQuantityAge4() {
		return this.quantityAge4;
	}

	public void setQuantityAge4(Double quantityAge4) {
		this.quantityAge4 = quantityAge4;
	}

	public Double getQuantityAge5() {
		return this.quantityAge5;
	}

	public void setQuantityAge5(Double quantityAge5) {
		this.quantityAge5 = quantityAge5;
	}

	public Double getQuantityAge6() {
		return this.quantityAge6;
	}

	public void setQuantityAge6(Double quantityAge6) {
		this.quantityAge6 = quantityAge6;
	}

	public Double getQuantityAge7() {
		return this.quantityAge7;
	}

	public void setQuantityAge7(Double quantityAge7) {
		this.quantityAge7 = quantityAge7;
	}

	public Double getQuantityAge8() {
		return this.quantityAge8;
	}

	public void setQuantityAge8(Double quantityAge8) {
		this.quantityAge8 = quantityAge8;
	}

	public Double getQuantityAge9() {
		return this.quantityAge9;
	}

	public void setQuantityAge9(Double quantityAge9) {
		this.quantityAge9 = quantityAge9;
	}

	public Double getQuantityAge10() {
		return this.quantityAge10;
	}

	public void setQuantityAge10(Double quantityAge10) {
		this.quantityAge10 = quantityAge10;
	}

	public Double getQuantityAge11() {
		return this.quantityAge11;
	}

	public void setQuantityAge11(Double quantityAge11) {
		this.quantityAge11 = quantityAge11;
	}

	public Double getQuantityAge12() {
		return this.quantityAge12;
	}

	public void setQuantityAge12(Double quantityAge12) {
		this.quantityAge12 = quantityAge12;
	}

	public Double getQuantityAge13() {
		return this.quantityAge13;
	}

	public void setQuantityAge13(Double quantityAge13) {
		this.quantityAge13 = quantityAge13;
	}

	public Double getQuantityAge14() {
		return this.quantityAge14;
	}

	public void setQuantityAge14(Double quantityAge14) {
		this.quantityAge14 = quantityAge14;
	}

	public Double getQuantityAge15() {
		return this.quantityAge15;
	}

	public void setQuantityAge15(Double quantityAge15) {
		this.quantityAge15 = quantityAge15;
	}

	public Double getQuantityAge16() {
		return this.quantityAge16;
	}

	public void setQuantityAge16(Double quantityAge16) {
		this.quantityAge16 = quantityAge16;
	}

	public Double getQuantityAge17() {
		return this.quantityAge17;
	}

	public void setQuantityAge17(Double quantityAge17) {
		this.quantityAge17 = quantityAge17;
	}

	public Double getQuantityAge18() {
		return this.quantityAge18;
	}

	public void setQuantityAge18(Double quantityAge18) {
		this.quantityAge18 = quantityAge18;
	}

	public Double getQuantityAge19() {
		return this.quantityAge19;
	}

	public void setQuantityAge19(Double quantityAge19) {
		this.quantityAge19 = quantityAge19;
	}

	public Double getQuantityAge20() {
		return this.quantityAge20;
	}

	public void setQuantityAge20(Double quantityAge20) {
		this.quantityAge20 = quantityAge20;
	}

	public Double getQuantityAge21() {
		return this.quantityAge21;
	}

	public void setQuantityAge21(Double quantityAge21) {
		this.quantityAge21 = quantityAge21;
	}

	public Double getQuantityAge22() {
		return this.quantityAge22;
	}

	public void setQuantityAge22(Double quantityAge22) {
		this.quantityAge22 = quantityAge22;
	}

	public Double getQuantityAge23() {
		return this.quantityAge23;
	}

	public void setQuantityAge23(Double quantityAge23) {
		this.quantityAge23 = quantityAge23;
	}

	public Double getQuantityAge24() {
		return this.quantityAge24;
	}

	public void setQuantityAge24(Double quantityAge24) {
		this.quantityAge24 = quantityAge24;
	}

	public Double getQuantityAge25() {
		return this.quantityAge25;
	}

	public void setQuantityAge25(Double quantityAge25) {
		this.quantityAge25 = quantityAge25;
	}

	public Double getQuantityAge26() {
		return this.quantityAge26;
	}

	public void setQuantityAge26(Double quantityAge26) {
		this.quantityAge26 = quantityAge26;
	}

	public Double getQuantityAge27() {
		return this.quantityAge27;
	}

	public void setQuantityAge27(Double quantityAge27) {
		this.quantityAge27 = quantityAge27;
	}

	public Double getQuantityAge28() {
		return this.quantityAge28;
	}

	public void setQuantityAge28(Double quantityAge28) {
		this.quantityAge28 = quantityAge28;
	}

	public Double getQuantityAge29() {
		return this.quantityAge29;
	}

	public void setQuantityAge29(Double quantityAge29) {
		this.quantityAge29 = quantityAge29;
	}

	public Double getQuantityAge30() {
		return this.quantityAge30;
	}

	public void setQuantityAge30(Double quantityAge30) {
		this.quantityAge30 = quantityAge30;
	}

	public Double getQuantityAgeMoreThan30() {
		return this.quantityAgeMoreThan30;
	}

	public void setQuantityAgeMoreThan30(Double quantityAgeMoreThan30) {
		this.quantityAgeMoreThan30 = quantityAgeMoreThan30;
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

	public Double getQuantAgeBetween05Year() {
		return this.quantAgeBetween05Year;
	}

	public void setQuantAgeBetween05Year(Double quantAgeBetween05Year) {
		this.quantAgeBetween05Year = quantAgeBetween05Year;
	}

	public Double getQuantAgeBetween510Year() {
		return this.quantAgeBetween510Year;
	}

	public void setQuantAgeBetween510Year(Double quantAgeBetween510Year) {
		this.quantAgeBetween510Year = quantAgeBetween510Year;
	}

	public Double getQuantAgeBetween1015Year() {
		return this.quantAgeBetween1015Year;
	}

	public void setQuantAgeBetween1015Year(Double quantAgeBetween1015Year) {
		this.quantAgeBetween1015Year = quantAgeBetween1015Year;
	}

	public Double getQuantAgeBetween1520Year() {
		return this.quantAgeBetween1520Year;
	}

	public void setQuantAgeBetween1520Year(Double quantAgeBetween1520Year) {
		this.quantAgeBetween1520Year = quantAgeBetween1520Year;
	}

	public Double getQuantAgeBetween2030Year() {
		return this.quantAgeBetween2030Year;
	}

	public void setQuantAgeBetween2030Year(Double quantAgeBetween2030Year) {
		this.quantAgeBetween2030Year = quantAgeBetween2030Year;
	}

	public Double getQuantAgeMoreThen30Year() {
		return this.quantAgeMoreThen30Year;
	}

	public void setQuantAgeMoreThen30Year(Double quantAgeMoreThen30Year) {
		this.quantAgeMoreThen30Year = quantAgeMoreThen30Year;
	}

}