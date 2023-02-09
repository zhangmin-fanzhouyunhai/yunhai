package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpAnluRecord entity. @author MyEclipse Persistence Tools
 */
public class ErpAnluRecord extends AbstractErpAnluRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpAnluRecord() {
	}

	/** minimal constructor */
	public ErpAnluRecord(Date calYear) {
		super(calYear);
	}

	/** full constructor */
	public ErpAnluRecord(String version,Date calYear, String companyCode, String mainAssetId, String secondaryCode,
			String assetOwnOrgId, String usingCustodianOrgId) {
		super(version,calYear, companyCode, mainAssetId, secondaryCode, assetOwnOrgId, usingCustodianOrgId);
	}

}
