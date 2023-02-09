package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetOverAge entity. @author MyEclipse Persistence Tools
 */
public class MidAssetOverAge extends AbstractMidAssetOverAge implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetOverAge() {
	}

	/** minimal constructor */
	public MidAssetOverAge(String midAssetOverAgeId) {
		super(midAssetOverAgeId);
	}

	/** full constructor */
	public MidAssetOverAge(String midAssetOverAgeId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double overAgeOriginalValue,
			Double overAgeNetValue, Double overAgeQuantity, Double overAgeTechnologyScale, Double originalValue,
			Double netValue, Double quantity, Double technologyScale, Date dvDateValue, String category) {
		super(midAssetOverAgeId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				overAgeOriginalValue, overAgeNetValue, overAgeQuantity, overAgeTechnologyScale, originalValue, netValue,
				quantity, technologyScale, dvDateValue, category);
	}

}
