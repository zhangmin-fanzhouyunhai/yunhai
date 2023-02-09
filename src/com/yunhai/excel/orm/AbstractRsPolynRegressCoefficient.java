package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractRsPolynRegressCoefficient entity provides the base persistence
 * definition of the RsPolynRegressCoefficient entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractRsPolynRegressCoefficient implements java.io.Serializable {

	// Fields

	private String rsPolynRegressCoeffId;
	private String variableRelationId;
	private String versionValue;
	private Date calYear;
	private String actionType;
	private Integer indexof;
	private String variableName;
	private String coefficientName;
	private Double coefficientValue;
	private String bintLeftValue;
	private String bintRightValue;
	private String RValue;
	private String rintLeftValue;
	private String rintRightValue;
	private String statsValue;

	// Constructors

	/** default constructor */
	public AbstractRsPolynRegressCoefficient() {
	}

	/** minimal constructor */
	public AbstractRsPolynRegressCoefficient(String rsPolynRegressCoeffId) {
		this.rsPolynRegressCoeffId = rsPolynRegressCoeffId;
	}

	/** full constructor */
	public AbstractRsPolynRegressCoefficient(String rsPolynRegressCoeffId, String variableRelationId,
			String versionValue, Date calYear, String actionType, Integer indexof, String variableName,
			String coefficientName, Double coefficientValue, String bintLeftValue, String bintRightValue, String RValue,
			String rintLeftValue, String rintRightValue, String statsValue) {
		this.rsPolynRegressCoeffId = rsPolynRegressCoeffId;
		this.variableRelationId = variableRelationId;
		this.versionValue = versionValue;
		this.calYear = calYear;
		this.actionType = actionType;
		this.indexof = indexof;
		this.variableName = variableName;
		this.coefficientName = coefficientName;
		this.coefficientValue = coefficientValue;
		this.bintLeftValue = bintLeftValue;
		this.bintRightValue = bintRightValue;
		this.RValue = RValue;
		this.rintLeftValue = rintLeftValue;
		this.rintRightValue = rintRightValue;
		this.statsValue = statsValue;
	}

	// Property accessors

	public String getRsPolynRegressCoeffId() {
		return this.rsPolynRegressCoeffId;
	}

	public void setRsPolynRegressCoeffId(String rsPolynRegressCoeffId) {
		this.rsPolynRegressCoeffId = rsPolynRegressCoeffId;
	}

	public String getVariableRelationId() {
		return this.variableRelationId;
	}

	public void setVariableRelationId(String variableRelationId) {
		this.variableRelationId = variableRelationId;
	}

	public String getVersionValue() {
		return this.versionValue;
	}

	public void setVersionValue(String versionValue) {
		this.versionValue = versionValue;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Integer getIndexof() {
		return this.indexof;
	}

	public void setIndexof(Integer indexof) {
		this.indexof = indexof;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getCoefficientName() {
		return this.coefficientName;
	}

	public void setCoefficientName(String coefficientName) {
		this.coefficientName = coefficientName;
	}

	public Double getCoefficientValue() {
		return this.coefficientValue;
	}

	public void setCoefficientValue(Double coefficientValue) {
		this.coefficientValue = coefficientValue;
	}

	public String getBintLeftValue() {
		return this.bintLeftValue;
	}

	public void setBintLeftValue(String bintLeftValue) {
		this.bintLeftValue = bintLeftValue;
	}

	public String getBintRightValue() {
		return this.bintRightValue;
	}

	public void setBintRightValue(String bintRightValue) {
		this.bintRightValue = bintRightValue;
	}

	public String getRValue() {
		return this.RValue;
	}

	public void setRValue(String RValue) {
		this.RValue = RValue;
	}

	public String getRintLeftValue() {
		return this.rintLeftValue;
	}

	public void setRintLeftValue(String rintLeftValue) {
		this.rintLeftValue = rintLeftValue;
	}

	public String getRintRightValue() {
		return this.rintRightValue;
	}

	public void setRintRightValue(String rintRightValue) {
		this.rintRightValue = rintRightValue;
	}

	public String getStatsValue() {
		return this.statsValue;
	}

	public void setStatsValue(String statsValue) {
		this.statsValue = statsValue;
	}

}