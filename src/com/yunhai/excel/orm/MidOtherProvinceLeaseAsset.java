package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidOtherProvinceLeaseAsset entity. @author MyEclipse Persistence Tools
 */
public class MidOtherProvinceLeaseAsset extends AbstractMidOtherProvinceLeaseAsset implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidOtherProvinceLeaseAsset() {
	}

	/** minimal constructor */
	public MidOtherProvinceLeaseAsset(String midOtherProviLeaseAssetId) {
		super(midOtherProviLeaseAssetId);
	}

	/** full constructor */
	public MidOtherProvinceLeaseAsset(String midOtherProviLeaseAssetId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double otherProviOriginalValue, Double otherProviNetValue, Double otherProviQuantity,
			Double otherProviTechnologyScale, Double leaseOriginalValue, Double leaseNetValue, Double leaseQuantity,
			Double leaseTechnologyScale, Date dvDateValue, String category, String areaName) {
		super(midOtherProviLeaseAssetId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				otherProviOriginalValue, otherProviNetValue, otherProviQuantity, otherProviTechnologyScale,
				leaseOriginalValue, leaseNetValue, leaseQuantity, leaseTechnologyScale, dvDateValue, category,
				areaName);
	}

}
