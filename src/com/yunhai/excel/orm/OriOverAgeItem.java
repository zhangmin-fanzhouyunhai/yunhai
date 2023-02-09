package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriOverAgeItem entity. @author MyEclipse Persistence Tools
 */
public class OriOverAgeItem extends AbstractOriOverAgeItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriOverAgeItem() {
	}

	/** minimal constructor */
	public OriOverAgeItem(String oriOverAgeItemId) {
		super(oriOverAgeItemId);
	}

	/** full constructor */
	public OriOverAgeItem(String oriOverAgeItemId, String dataVersion, Date calYear, String assetNumber, String sno,
			String extractYear, String largeClassCode, Double originalValue, Double accumulatedDepreciation,
			Double netValue, Double depreciationRatio, String dataSourceFile) {
		super(oriOverAgeItemId, dataVersion, calYear, assetNumber, sno, extractYear, largeClassCode, originalValue,
				accumulatedDepreciation, netValue, depreciationRatio, dataSourceFile);
	}

}
