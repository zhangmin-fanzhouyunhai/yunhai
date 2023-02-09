package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidMaintenOverhaulCost entity. @author MyEclipse Persistence Tools
 */
public class MidMaintenOverhaulCost extends AbstractMidMaintenOverhaulCost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidMaintenOverhaulCost() {
	}

	/** minimal constructor */
	public MidMaintenOverhaulCost(String midMaintenOverhaulCostId) {
		super(midMaintenOverhaulCostId);
	}

	/** full constructor */
	public MidMaintenOverhaulCost(String midMaintenOverhaulCostId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double overhaul5YearCost,
			Double overhaul4YearCost, Double overhaul3YearCost, Double overhaul2YearCost, Double overhaul1YearCost,
			Double maintenance5YearCost, Double maintenance4YearCost, Double maintenance3YearCost,
			Double maintenance2YearCost, Double maintenance1YearCost, Date dvDateValue, String category) {
		super(midMaintenOverhaulCostId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				overhaul5YearCost, overhaul4YearCost, overhaul3YearCost, overhaul2YearCost, overhaul1YearCost,
				maintenance5YearCost, maintenance4YearCost, maintenance3YearCost, maintenance2YearCost,
				maintenance1YearCost, dvDateValue, category);
	}

}
