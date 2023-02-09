package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetTechQuantityScale entity. @author MyEclipse Persistence Tools
 */
public class MidAssetTechQuantityScale extends AbstractMidAssetTechQuantityScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetTechQuantityScale() {
	}

	/** minimal constructor */
	public MidAssetTechQuantityScale(String midAssetTechQuantScaleId) {
		super(midAssetTechQuantScaleId);
	}

	/** full constructor */
	public MidAssetTechQuantityScale(String midAssetTechQuantScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double quantity,
			Double technologyScale, Date dvDateValue, String category, String areaName) {
		super(midAssetTechQuantScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				quantity, technologyScale, dvDateValue, category, areaName);
	}

}
