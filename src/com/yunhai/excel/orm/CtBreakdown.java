package com.yunhai.excel.orm;

/**
 * CtBreakdown entity. @author MyEclipse Persistence Tools
 */
public class CtBreakdown extends AbstractCtBreakdown implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CtBreakdown() {
	}

	/** minimal constructor */
	public CtBreakdown(String ctBreakdownId, Short calYear, String version, String areaName, Short year,
			String largeClass) {
		super(ctBreakdownId, calYear, version, areaName, year, largeClass);
	}

	/** full constructor */
	public CtBreakdown(String ctBreakdownId, Short calYear, String version, String areaName, Short year,
			String largeClass, String mediumClass, String smallClass, String erpCode, String voltageLevel, Double y2004,
			Double y2005, Double y2006, Double y2007, Double y2008, Double y2009, Double y2010, Double y2011,
			Double y2012, Double y2013, Double y2014, Double y2015, Double quantity, Double nonPlanQuantity,
			Double breakdownRate) {
		super(ctBreakdownId, calYear, version, areaName, year, largeClass, mediumClass, smallClass, erpCode,
				voltageLevel, y2004, y2005, y2006, y2007, y2008, y2009, y2010, y2011, y2012, y2013, y2014, y2015,
				quantity, nonPlanQuantity, breakdownRate);
	}

}
