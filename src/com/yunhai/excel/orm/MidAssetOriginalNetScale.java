package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetOriginalNetScale entity. @author MyEclipse Persistence Tools
 */
public class MidAssetOriginalNetScale extends AbstractMidAssetOriginalNetScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetOriginalNetScale() {
	}

	/** minimal constructor */
	public MidAssetOriginalNetScale(String midAssetOrigNetScaleId) {
		super(midAssetOrigNetScaleId);
	}

	/** full constructor */
	public MidAssetOriginalNetScale(String midAssetOrigNetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double originalValue,
			Double netValue, Date dvDateValue, String category, String areaName) {
		super(midAssetOrigNetScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				originalValue, netValue, dvDateValue, category, areaName);
	}

}
