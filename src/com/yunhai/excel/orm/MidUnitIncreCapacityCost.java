package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidUnitIncreCapacityCost entity. @author MyEclipse Persistence Tools
 */
public class MidUnitIncreCapacityCost extends AbstractMidUnitIncreCapacityCost implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidUnitIncreCapacityCost() {
	}

	/** minimal constructor */
	public MidUnitIncreCapacityCost(String midUnitIncreCapaciCostId, String version, String orgName,
			String largeClass) {
		super(midUnitIncreCapaciCostId, version, orgName, largeClass);
	}

	/** full constructor */
	public MidUnitIncreCapacityCost(String midUnitIncreCapaciCostId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Date dvDateValue,
			String category, Double year1Cost, Double year2Cost, Double year3Cost, Double year4Cost, Double year5Cost) {
		super(midUnitIncreCapaciCostId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				dvDateValue, category, year1Cost, year2Cost, year3Cost, year4Cost, year5Cost);
	}

}
