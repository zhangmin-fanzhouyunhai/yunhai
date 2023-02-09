package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidIncreaseAssetQuantScale entity. @author MyEclipse Persistence Tools
 */
public class MidIncreaseAssetQuantScale extends AbstractMidIncreaseAssetQuantScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidIncreaseAssetQuantScale() {
	}

	/** minimal constructor */
	public MidIncreaseAssetQuantScale(String midIncreAssetQuantScaleId) {
		super(midIncreAssetQuantScaleId);
	}

	/** full constructor */
	public MidIncreaseAssetQuantScale(String midIncreAssetQuantScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double inverstThisYearQuantity, Double inverstThisYearTechScale, Double userHandoverQuantity,
			Double userHandoverTechScale, Double smallPurchaseQuantity, Double smallPurchaseTechScale,
			Double allocationQuantity, Double allocationTechScale, Double otherQuantity, Double otherTechScale,
			Date dvDateValue, String category, String areaName) {
		super(midIncreAssetQuantScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				inverstThisYearQuantity, inverstThisYearTechScale, userHandoverQuantity, userHandoverTechScale,
				smallPurchaseQuantity, smallPurchaseTechScale, allocationQuantity, allocationTechScale, otherQuantity,
				otherTechScale, dvDateValue, category, areaName);
	}

}
