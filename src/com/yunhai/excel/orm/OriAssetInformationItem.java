package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * OriAssetInformationItem entity. @author MyEclipse Persistence Tools
 */
public class OriAssetInformationItem extends AbstractOriAssetInformationItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriAssetInformationItem() {
	}

	/** minimal constructor */
	public OriAssetInformationItem(String oriAssetInformationItemId) {
		super(oriAssetInformationItemId);
	}

	/** full constructor */
	public OriAssetInformationItem(String oriAssetInformationItemId, String dataVersion, Date calYear,
			String orgCode, String assetNumber, String sno, Date validDate, String categoryCode,
			Date capitalizationDate, String voltageLevelCode, String voltageLevelDescription, Double quantity,
			String typeNameCode, String assetStatusCode, String assetStatusDescription, String assetDescription,
			String belongLineStationName, String costCenter, String profitCenter, String profitCenterDescription,
			String dataSourceFile) {
		super(oriAssetInformationItemId, dataVersion, calYear, orgCode, assetNumber, sno, validDate, categoryCode,
				capitalizationDate, voltageLevelCode, voltageLevelDescription, quantity, typeNameCode, assetStatusCode,
				assetStatusDescription, assetDescription, belongLineStationName, costCenter, profitCenter,
				profitCenterDescription, dataSourceFile);
	}

}
