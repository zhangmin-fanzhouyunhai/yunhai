package com.yunhai.excel.orm;

import java.util.Date;


/**
 * MidResuingAssetScale entity. @author MyEclipse Persistence Tools
 */
public class MidResuingAssetScale extends AbstractMidResuingAssetScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidResuingAssetScale() {
	}

	/** minimal constructor */
	public MidResuingAssetScale(String midResuingAssetScaleId) {
		super(midResuingAssetScaleId);
	}

	/** full constructor */
	public MidResuingAssetScale(String midResuingAssetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double inYearProvQuantity,
			Double inYearProvTechnScale, Double accumInProvQuantity, Double accumInProvTechnScale,
			Double inYearBetProvQuantity, Double inYearBetProvTechnScale, Double accumBetProvQuantity,
			Double accumBetProvTechnScale, Date dvDateValue, String category, String areaName) {
		super(midResuingAssetScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				inYearProvQuantity, inYearProvTechnScale, accumInProvQuantity, accumInProvTechnScale,
				inYearBetProvQuantity, inYearBetProvTechnScale, accumBetProvQuantity, accumBetProvTechnScale,
				dvDateValue, category, areaName);
	}

}
