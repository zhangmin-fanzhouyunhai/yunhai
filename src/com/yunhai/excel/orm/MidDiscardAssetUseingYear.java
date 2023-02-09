package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidDiscardAssetUseingYear entity. @author MyEclipse Persistence Tools
 */
public class MidDiscardAssetUseingYear extends AbstractMidDiscardAssetUseingYear implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidDiscardAssetUseingYear() {
	}

	/** minimal constructor */
	public MidDiscardAssetUseingYear(String midDiscardAssetUseYearId) {
		super(midDiscardAssetUseYearId);
	}

	/** full constructor */
	public MidDiscardAssetUseingYear(String midDiscardAssetUseYearId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double realUsingYear6,
			Double discardAssetQuantityYear6, Double totalUsingYear6, Double realUsingYear5,
			Double discardAssetQuantityYear5, Double totalUsingYear5, Double realUsingYear4,
			Double discardAssetQuantityYear4, Double totalUsingYear4, Double realUsingYear3,
			Double discardAssetQuantityYear3, Double totalUsingYear3, Double realUsingYear2,
			Double discardAssetQuantityYear2, Double totalUsingYear2, Double realUsingYear1,
			Double discardAssetQuantityYear1, Double totalUsingYear1, Date dvDateValue, String category,
			String areaName) {
		super(midDiscardAssetUseYearId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				realUsingYear5, discardAssetQuantityYear5, totalUsingYear5, realUsingYear4, discardAssetQuantityYear4,
				totalUsingYear4, realUsingYear3, discardAssetQuantityYear3, totalUsingYear3, realUsingYear2,
				discardAssetQuantityYear2, totalUsingYear2, realUsingYear1, discardAssetQuantityYear1, totalUsingYear1,
				dvDateValue, category, areaName, realUsingYear6, discardAssetQuantityYear6, totalUsingYear6);
	}

}
