package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpDiscardDepreciationValue entity. @author MyEclipse Persistence Tools
 */
public class ErpDiscardDepreciationValue extends AbstractErpDiscardDepreciationValue implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpDiscardDepreciationValue() {
	}

	/** full constructor */
	public ErpDiscardDepreciationValue(String version, Date calYear, String assetId, Double originalValue,
			Double discardDepreciation) {
		super(version, calYear, assetId, originalValue, discardDepreciation);
	}

}
