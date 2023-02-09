package com.yunhai.excel.orm;

import java.sql.Timestamp;

/**
 * OriFinanceScrapPostAsset entity. @author MyEclipse Persistence Tools
 */
public class OriFinanceScrapPostAsset extends AbstractOriFinanceScrapPostAsset implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFinanceScrapPostAsset() {
	}

	/** minimal constructor */
	public OriFinanceScrapPostAsset(String oriFinancScrapPostAssetId, String dataVersion, java.util.Date calYear) {
		super(oriFinancScrapPostAssetId, dataVersion, calYear);
	}

	/** full constructor */
	public OriFinanceScrapPostAsset(String oriFinancScrapPostAssetId, String dataVersion, java.util.Date calYear,
			String companyCode, String assetsNo, String sno, String classification, String typeName,
			String voltageLevel, Double quantity, String meterUnit, String assetStatus, String costCenter,
			String assetDescription, java.util.Date capitalizationDate, java.util.Date inactiveDate, String locationAddress,
			String assetPhysicalId, String dataSourceFileName) {
		super(oriFinancScrapPostAssetId, dataVersion, calYear, companyCode, assetsNo, sno, classification, typeName,
				voltageLevel, quantity, meterUnit, assetStatus, costCenter, assetDescription, capitalizationDate,
				inactiveDate, locationAddress, assetPhysicalId, dataSourceFileName);
	}

}
