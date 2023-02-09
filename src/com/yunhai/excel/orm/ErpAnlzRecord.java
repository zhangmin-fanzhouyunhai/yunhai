package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpAnlzRecord entity. @author MyEclipse Persistence Tools
 */
public class ErpAnlzRecord extends AbstractErpAnlzRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpAnlzRecord() {
	}

	/** minimal constructor */
	public ErpAnlzRecord(Date calYear) {
		super(calYear);
	}

	/** full constructor */
	public ErpAnlzRecord(String version, Date calYear, String companyCode, String mainAssetId, String secondaryCode, Date validEndDate,
			String profitCenterCode, String pssElement) {
		super(version, calYear, companyCode, mainAssetId, secondaryCode, validEndDate, profitCenterCode, pssElement);
	}

}
