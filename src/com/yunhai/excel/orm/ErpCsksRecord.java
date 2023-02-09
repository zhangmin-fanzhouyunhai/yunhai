package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpCsksRecord entity. @author MyEclipse Persistence Tools
 */
public class ErpCsksRecord extends AbstractErpCsksRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpCsksRecord() {
	}

	/** minimal constructor */
	public ErpCsksRecord(Date calYear) {
		super(calYear);
	}

	/** full constructor */
	public ErpCsksRecord(String version,Date calYear, String profitConentCode, String companyCode, String secondProfitCode,
			Date validEndDate, Date validStartDate) {
		super(version,calYear, profitConentCode, companyCode, secondProfitCode, validEndDate, validStartDate);
	}

}
