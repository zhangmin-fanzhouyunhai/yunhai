package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriFinancePostRecordAnep entity. @author MyEclipse Persistence Tools
 */
public class OriFinancePostRecordAnep extends AbstractOriFinancePostRecordAnep implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFinancePostRecordAnep() {
	}

	/** minimal constructor */
	public OriFinancePostRecordAnep(String oriFinancePostRecordId, String dataVersion, Date calYear) {
		super(oriFinancePostRecordId, dataVersion, calYear);
	}

	/** full constructor */
	public OriFinancePostRecordAnep(String oriFinancePostRecordId, String dataVersion, Date calYear,
			String companyCode, String assetNumber, String subnumber, String fiscalYear, String transactionType,
			Double accountAmount, Date assetValueDate, String dataSourceFile) {
		super(oriFinancePostRecordId, dataVersion, calYear, companyCode, assetNumber, subnumber, fiscalYear,
				transactionType, accountAmount, assetValueDate, dataSourceFile);
	}

}
