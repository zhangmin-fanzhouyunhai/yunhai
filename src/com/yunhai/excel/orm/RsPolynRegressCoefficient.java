package com.yunhai.excel.orm;

import java.util.Date;

/**
 * RsPolynRegressCoefficient entity. @author MyEclipse Persistence Tools
 */
public class RsPolynRegressCoefficient extends AbstractRsPolynRegressCoefficient implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public RsPolynRegressCoefficient() {
	}

	/** minimal constructor */
	public RsPolynRegressCoefficient(String rsPolynRegressCoeffId) {
		super(rsPolynRegressCoeffId);
	}

	/** full constructor */
	public RsPolynRegressCoefficient(String rsPolynRegressCoeffId, String variableRelationId, String versionValue,
			Date calYear, String actionType, Integer indexof, String variableName, String coefficientName,
			Double coefficientValue, String bintLeftValue, String bintRightValue, String RValue, String rintLeftValue,
			String rintRightValue, String statsValue) {
		super(rsPolynRegressCoeffId, variableRelationId, versionValue, calYear, actionType, indexof, variableName,
				coefficientName, coefficientValue, bintLeftValue, bintRightValue, RValue, rintLeftValue, rintRightValue,
				statsValue);
	}

}
