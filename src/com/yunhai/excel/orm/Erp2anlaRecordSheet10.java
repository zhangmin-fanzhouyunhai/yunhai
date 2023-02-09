package com.yunhai.excel.orm;

import java.util.Date;

/**
 * Erp2anlaRecordSheet10 entity. @author MyEclipse Persistence Tools
 */
public class Erp2anlaRecordSheet10 extends AbstractErp2anlaRecordSheet10 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Erp2anlaRecordSheet10() {
	}

	/** minimal constructor */
	public Erp2anlaRecordSheet10(Date calYear) {
		super(calYear);
	}

	/** full constructor */
	public Erp2anlaRecordSheet10(Date calYear, String companyCode, String assetId, String equipmentId,
			String secondaryCode, String classifiedCode, Date capitalizationDate, Date unactivedDate,
			String voltageLevelCode, String assetState, String isEscrow, String manufacturer, Double quantity,
			String fixedAssetClass, String dataSource, String assetName, String description2, String wbsElement) {
		super(calYear, companyCode, assetId, equipmentId, secondaryCode, classifiedCode, capitalizationDate,
				unactivedDate, voltageLevelCode, assetState, isEscrow, manufacturer, quantity, fixedAssetClass,
				dataSource, assetName, description2, wbsElement);
	}

}
