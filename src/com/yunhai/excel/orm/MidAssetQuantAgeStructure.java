package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MidAssetQuantAgeStructure entity. @author MyEclipse Persistence Tools
 */
public class MidAssetQuantAgeStructure extends AbstractMidAssetQuantAgeStructure implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetQuantAgeStructure() {
	}

	/** minimal constructor */
	public MidAssetQuantAgeStructure(String midAssetQuantAgeStructId, Date calYear) {
		super(midAssetQuantAgeStructId, calYear);
	}

	/** full constructor */
	public MidAssetQuantAgeStructure(String midAssetQuantAgeStructId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double totalQuantity,
			Double quantityAge1, Double quantityAge2, Double quantityAge3, Double quantityAge4, Double quantityAge5,
			Double quantityAge6, Double quantityAge7, Double quantityAge8, Double quantityAge9, Double quantityAge10,
			Double quantityAge11, Double quantityAge12, Double quantityAge13, Double quantityAge14,
			Double quantityAge15, Double quantityAge16, Double quantityAge17, Double quantityAge18,
			Double quantityAge19, Double quantityAge20, Double quantityAge21, Double quantityAge22,
			Double quantityAge23, Double quantityAge24, Double quantityAge25, Double quantityAge26,
			Double quantityAge27, Double quantityAge28, Double quantityAge29, Double quantityAge30,
			Double quantityAgeMoreThan30, Date dvDateValue, String category, String areaName,
			Double quantAgeBetween05Year, Double quantAgeBetween510Year, Double quantAgeBetween1015Year,
			Double quantAgeBetween1520Year, Double quantAgeBetween2030Year, Double quantAgeMoreThen30Year) {
		super(midAssetQuantAgeStructId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				totalQuantity, quantityAge1, quantityAge2, quantityAge3, quantityAge4, quantityAge5, quantityAge6,
				quantityAge7, quantityAge8, quantityAge9, quantityAge10, quantityAge11, quantityAge12, quantityAge13,
				quantityAge14, quantityAge15, quantityAge16, quantityAge17, quantityAge18, quantityAge19, quantityAge20,
				quantityAge21, quantityAge22, quantityAge23, quantityAge24, quantityAge25, quantityAge26, quantityAge27,
				quantityAge28, quantityAge29, quantityAge30, quantityAgeMoreThan30, dvDateValue, category, areaName,
				quantAgeBetween05Year, quantAgeBetween510Year, quantAgeBetween1015Year, quantAgeBetween1520Year,
				quantAgeBetween2030Year, quantAgeMoreThen30Year);
	}

}
