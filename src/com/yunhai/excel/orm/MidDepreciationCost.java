package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidDepreciationCost entity. @author MyEclipse Persistence Tools
 */
public class MidDepreciationCost extends AbstractMidDepreciationCost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidDepreciationCost() {
	}

	/** minimal constructor */
	public MidDepreciationCost(String midDepreciationCostId, String version, String orgName, String largeClass) {
		super(midDepreciationCostId, version, orgName, largeClass);
	}

	/** full constructor */
	public MidDepreciationCost(String midDepreciationCostId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Date dvDateValue,
			String category, Double year1DeprecCost, Double year2DeprecCost, Double year3DeprecCost,
			Double year4DeprecCost, Double year5DeprecCost) {
		super(midDepreciationCostId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				dvDateValue, category, year1DeprecCost, year2DeprecCost, year3DeprecCost, year4DeprecCost,
				year5DeprecCost);
	}

}
