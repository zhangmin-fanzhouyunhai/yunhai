package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidIncreaseAssetValueScale entity. @author MyEclipse Persistence Tools
 */
public class MidIncreaseAssetValueScale extends AbstractMidIncreaseAssetValueScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidIncreaseAssetValueScale() {
	}

	/** minimal constructor */
	public MidIncreaseAssetValueScale(String midIncreAssetValueScaleId) {
		super(midIncreAssetValueScaleId);
	}

	/** full constructor */
	public MidIncreaseAssetValueScale(String midIncreAssetValueScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double inverstThisYearOriginValue, Double userHandoverOriginValue, Double smallPurchaseOriginValue,
			Double allocationOriginValue, Double otherOriginValue, Date dvDateValue, String category, String areaName) {
		super(midIncreAssetValueScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				inverstThisYearOriginValue, userHandoverOriginValue, smallPurchaseOriginValue, allocationOriginValue,
				otherOriginValue, dvDateValue, category, areaName);
	}

}
