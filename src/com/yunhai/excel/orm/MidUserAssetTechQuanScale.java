package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidUserAssetTechQuanScale entity. @author MyEclipse Persistence Tools
 */
public class MidUserAssetTechQuanScale extends AbstractMidUserAssetTechQuanScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidUserAssetTechQuanScale() {
	}

	/** minimal constructor */
	public MidUserAssetTechQuanScale(String midUserAssetTecQuaScalId) {
		super(midUserAssetTecQuaScalId);
	}

	/** full constructor */
	public MidUserAssetTechQuanScale(String midUserAssetTecQuaScalId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double originalValue,
			Double netValue, Double quantity, Double technologyScale, Date dvDateValue, String category,
			String areaName) {
		super(midUserAssetTecQuaScalId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				originalValue, netValue, quantity, technologyScale, dvDateValue, category, areaName);
	}

}
