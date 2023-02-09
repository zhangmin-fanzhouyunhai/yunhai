package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidUnitTransmiDistriCost entity. @author MyEclipse Persistence Tools
 */
public class MidUnitTransmiDistriCost extends AbstractMidUnitTransmiDistriCost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidUnitTransmiDistriCost() {
	}

	/** minimal constructor */
	public MidUnitTransmiDistriCost(String midUnitTransmDistriCostId, String version, String orgName,
			Integer yearValue) {
		super(midUnitTransmDistriCostId, version, orgName, yearValue);
	}

	/** full constructor */
	public MidUnitTransmiDistriCost(String midUnitTransmDistriCostId, String version, Date calYear, String orgName,
			Integer yearValue, Date dvDateValue, Double transmiDistriCost, Double electricitySales,
			Double unitElectrTransmDistriCost) {
		super(midUnitTransmDistriCostId, version, calYear, orgName, yearValue, dvDateValue, transmiDistriCost,
				electricitySales, unitElectrTransmDistriCost);
	}

}
