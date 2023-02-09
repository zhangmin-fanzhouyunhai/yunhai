package com.yunhai.excel.orm;

import java.sql.Timestamp;

/**
 * OriFinanceScrapPostRecord entity. @author MyEclipse Persistence Tools
 */
public class OriFinanceScrapPostRecord extends AbstractOriFinanceScrapPostRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFinanceScrapPostRecord() {
	}

	/** minimal constructor */
	public OriFinanceScrapPostRecord(String oriFinanScrapPostRecordId, String dataVersion, java.util.Date calYear) {
		super(oriFinanScrapPostRecordId, dataVersion, calYear);
	}

	/** full constructor */
	public OriFinanceScrapPostRecord(String oriFinanScrapPostRecordId, String dataVersion, java.util.Date calYear,
			String applicationNo, String mainEquipmentNumber, String mainEquipmentStatus, String classification,
			String assetClassAlias, String assetsNumber, String assetDescription, String assetRetirement,
			String changingState, java.util.Date assetValueDate, java.util.Date bookkeepingDate,
			Double originalBookValue, Double accumulatedDepreciation, Double provisionForImpairment,
			Double netBookValue, Double scrapRatio, Double scrapOriginalValue, Double scrapDepreciation,
			String costCenter, Double quantity, String meterUnit, String unitOfMeasureText, String assetManufacturer,
			Timestamp capitalizationDate, String profitCenter, String scrapReasonCode, String scrapReasonDescription,
			String objectType, String dataSourceFileName) {
		super(oriFinanScrapPostRecordId, dataVersion, calYear, applicationNo, mainEquipmentNumber, mainEquipmentStatus,
				classification, assetClassAlias, assetsNumber, assetDescription, assetRetirement, changingState,
				assetValueDate, bookkeepingDate, originalBookValue, accumulatedDepreciation, provisionForImpairment,
				netBookValue, scrapRatio, scrapOriginalValue, scrapDepreciation, costCenter, quantity, meterUnit,
				unitOfMeasureText, assetManufacturer, capitalizationDate, profitCenter, scrapReasonCode,
				scrapReasonDescription, objectType, dataSourceFileName);
	}

}
