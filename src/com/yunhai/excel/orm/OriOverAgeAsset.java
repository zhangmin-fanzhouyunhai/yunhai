package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriOverAgeAsset entity. @author MyEclipse Persistence Tools
 */
public class OriOverAgeAsset extends AbstractOriOverAgeAsset implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriOverAgeAsset() {
	}

	/** minimal constructor */
	public OriOverAgeAsset(String oriOverAgeAssetId, String dataVersion, Date calYear) {
		super(oriOverAgeAssetId, dataVersion, calYear);
	}

	/** full constructor */
	public OriOverAgeAsset(String oriOverAgeAssetId, String dataVersion, Date calYear, String companyCode,
			String assetNumber, String profitCenter, String assetClassificationCode, String fixeAssetClassificationCode,
			String profitCenterDescription, String assetName, String assetClassAlias, String costCenter,
			String costCenterName, String largeAssetClassCode, String mediumAssetClassCode, String smallAssetClassCode,
			Double accumulatedPurchaseValue, Double accumulUnplannedDepreciation, Double accumulOrdinaryDepreciation,
			Double assetNetValue, Double assetResidualValue, Date capitalizationDate, String expectedServiceLife,
			Date overAgeDate, String depreciationCode, String dataSourceFile) {
		super(oriOverAgeAssetId, dataVersion, calYear, companyCode, assetNumber, profitCenter, assetClassificationCode,
				fixeAssetClassificationCode, profitCenterDescription, assetName, assetClassAlias, costCenter,
				costCenterName, largeAssetClassCode, mediumAssetClassCode, smallAssetClassCode,
				accumulatedPurchaseValue, accumulUnplannedDepreciation, accumulOrdinaryDepreciation, assetNetValue,
				assetResidualValue, capitalizationDate, expectedServiceLife, overAgeDate, depreciationCode,
				dataSourceFile);
	}

}
