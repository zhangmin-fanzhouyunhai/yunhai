package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MidAssetMaxAvgAge entity. @author MyEclipse Persistence Tools
 */
public class MidAssetMaxAvgAge extends AbstractMidAssetMaxAvgAge implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetMaxAvgAge() {
	}

	/** minimal constructor */
	public MidAssetMaxAvgAge(String midAssetMaxAvgAgeId) {
		super(midAssetMaxAvgAgeId);
	}

	/** full constructor */
	public MidAssetMaxAvgAge(String midAssetMaxAvgAgeId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double year1AvgAge,
			Double year1MaxAge, Double year2AvgAge, Double year2MaxAge, Double year3AvgAge, Double year3MaxAge,
			Double year4AvgAge, Double year4MaxAge, Double year5AvgAge, Double year5MaxAge, Date dvDateValue,
			String category) {
		super(midAssetMaxAvgAgeId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				year1AvgAge, year1MaxAge, year2AvgAge, year2MaxAge, year3AvgAge, year3MaxAge, year4AvgAge, year4MaxAge,
				year5AvgAge, year5MaxAge, dvDateValue, category);
	}

}
