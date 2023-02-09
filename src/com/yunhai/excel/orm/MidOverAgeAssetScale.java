package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MidOverAgeAssetScale entity. @author MyEclipse Persistence Tools
 */
public class MidOverAgeAssetScale extends AbstractMidOverAgeAssetScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidOverAgeAssetScale() {
	}

	/** minimal constructor */
	public MidOverAgeAssetScale(String midOverAgeAssetScaleId) {
		super(midOverAgeAssetScaleId);
	}

	/** full constructor */
	public MidOverAgeAssetScale(String midOverAgeAssetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double totalOriginalValue,
			Double totalNetValue, Double totalQuantity, Double totalTechnologyScale, Double overAgeOriginalValue,
			Double overAgeNetValue, Double overAgeQuantity, Double overAgeTechnologyScale, Date dvDateValue,
			String category, String areaName) {
		super(midOverAgeAssetScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				totalOriginalValue, totalNetValue, totalQuantity, totalTechnologyScale, overAgeOriginalValue,
				overAgeNetValue, overAgeQuantity, overAgeTechnologyScale, dvDateValue, category, areaName);
	}

}
