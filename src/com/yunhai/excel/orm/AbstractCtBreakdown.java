package com.yunhai.excel.orm;

/**
 * AbstractCtBreakdown entity provides the base persistence definition of the
 * CtBreakdown entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCtBreakdown implements java.io.Serializable {

	// Fields

	private String ctBreakdownId;
	private Short calYear;
	private String version;
	private String areaName;
	private Short year;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String erpCode;
	private String voltageLevel;
	private Double y2004;
	private Double y2005;
	private Double y2006;
	private Double y2007;
	private Double y2008;
	private Double y2009;
	private Double y2010;
	private Double y2011;
	private Double y2012;
	private Double y2013;
	private Double y2014;
	private Double y2015;
	private Double quantity;
	private Double nonPlanQuantity;
	private Double breakdownRate;

	// Constructors

	/** default constructor */
	public AbstractCtBreakdown() {
	}

	/** minimal constructor */
	public AbstractCtBreakdown(String ctBreakdownId, Short calYear, String version, String areaName, Short year,
			String largeClass) {
		this.ctBreakdownId = ctBreakdownId;
		this.calYear = calYear;
		this.version = version;
		this.areaName = areaName;
		this.year = year;
		this.largeClass = largeClass;
	}

	/** full constructor */
	public AbstractCtBreakdown(String ctBreakdownId, Short calYear, String version, String areaName, Short year,
			String largeClass, String mediumClass, String smallClass, String erpCode, String voltageLevel, Double y2004,
			Double y2005, Double y2006, Double y2007, Double y2008, Double y2009, Double y2010, Double y2011,
			Double y2012, Double y2013, Double y2014, Double y2015, Double quantity, Double nonPlanQuantity,
			Double breakdownRate) {
		this.ctBreakdownId = ctBreakdownId;
		this.calYear = calYear;
		this.version = version;
		this.areaName = areaName;
		this.year = year;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.erpCode = erpCode;
		this.voltageLevel = voltageLevel;
		this.y2004 = y2004;
		this.y2005 = y2005;
		this.y2006 = y2006;
		this.y2007 = y2007;
		this.y2008 = y2008;
		this.y2009 = y2009;
		this.y2010 = y2010;
		this.y2011 = y2011;
		this.y2012 = y2012;
		this.y2013 = y2013;
		this.y2014 = y2014;
		this.y2015 = y2015;
		this.quantity = quantity;
		this.nonPlanQuantity = nonPlanQuantity;
		this.breakdownRate = breakdownRate;
	}

	// Property accessors

	public String getCtBreakdownId() {
		return this.ctBreakdownId;
	}

	public void setCtBreakdownId(String ctBreakdownId) {
		this.ctBreakdownId = ctBreakdownId;
	}

	public Short getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Short calYear) {
		this.calYear = calYear;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Short getYear() {
		return this.year;
	}

	public void setYear(Short year) {
		this.year = year;
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

	public String getErpCode() {
		return this.erpCode;
	}

	public void setErpCode(String erpCode) {
		this.erpCode = erpCode;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Double getY2004() {
		return this.y2004;
	}

	public void setY2004(Double y2004) {
		this.y2004 = y2004;
	}

	public Double getY2005() {
		return this.y2005;
	}

	public void setY2005(Double y2005) {
		this.y2005 = y2005;
	}

	public Double getY2006() {
		return this.y2006;
	}

	public void setY2006(Double y2006) {
		this.y2006 = y2006;
	}

	public Double getY2007() {
		return this.y2007;
	}

	public void setY2007(Double y2007) {
		this.y2007 = y2007;
	}

	public Double getY2008() {
		return this.y2008;
	}

	public void setY2008(Double y2008) {
		this.y2008 = y2008;
	}

	public Double getY2009() {
		return this.y2009;
	}

	public void setY2009(Double y2009) {
		this.y2009 = y2009;
	}

	public Double getY2010() {
		return this.y2010;
	}

	public void setY2010(Double y2010) {
		this.y2010 = y2010;
	}

	public Double getY2011() {
		return this.y2011;
	}

	public void setY2011(Double y2011) {
		this.y2011 = y2011;
	}

	public Double getY2012() {
		return this.y2012;
	}

	public void setY2012(Double y2012) {
		this.y2012 = y2012;
	}

	public Double getY2013() {
		return this.y2013;
	}

	public void setY2013(Double y2013) {
		this.y2013 = y2013;
	}

	public Double getY2014() {
		return this.y2014;
	}

	public void setY2014(Double y2014) {
		this.y2014 = y2014;
	}

	public Double getY2015() {
		return this.y2015;
	}

	public void setY2015(Double y2015) {
		this.y2015 = y2015;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getNonPlanQuantity() {
		return this.nonPlanQuantity;
	}

	public void setNonPlanQuantity(Double nonPlanQuantity) {
		this.nonPlanQuantity = nonPlanQuantity;
	}

	public Double getBreakdownRate() {
		return this.breakdownRate;
	}

	public void setBreakdownRate(Double breakdownRate) {
		this.breakdownRate = breakdownRate;
	}

}