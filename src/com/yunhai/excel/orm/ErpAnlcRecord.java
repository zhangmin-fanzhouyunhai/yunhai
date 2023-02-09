package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpAnlcRecord entity. @author MyEclipse Persistence Tools
 */
public class ErpAnlcRecord extends AbstractErpAnlcRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpAnlcRecord() {
	}

	/** minimal constructor */
	public ErpAnlcRecord(Date calYear) {
		super(calYear);
	}

	/** full constructor */
	public ErpAnlcRecord(String version,Date calYear, String companyCode, String mainAssetId, String secondaryCode, Long calyear,
			String arCode, Double originalValue, Double accumulatGeneralDepreciation, Double unplannedDepreciation,
			Double netValue) {
		super(version,calYear, companyCode, mainAssetId, secondaryCode, calyear, arCode, originalValue,
				accumulatGeneralDepreciation, unplannedDepreciation, netValue);
	}

}
