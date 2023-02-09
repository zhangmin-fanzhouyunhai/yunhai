package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriFullAssetAccountPosting entity. @author MyEclipse Persistence Tools
 */
public class OriFullAssetAccountPosting extends AbstractOriFullAssetAccountPosting implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFullAssetAccountPosting() {
	}

	/** minimal constructor */
	public OriFullAssetAccountPosting(String oriFullAssetAccountPosId) {
		super(oriFullAssetAccountPosId);
	}

	/** full constructor */
	public OriFullAssetAccountPosting(String oriFullAssetAccountPosId, String dataVersion, Date calYaer,
			String systemIdentification, String orgNameCode, String orgName, String assetNumber, String secondaryNumber,
			Long calyear, String largeClassCode, String transactionCategory, String whethCapitalizationLastYear,
			Double bookKeepingAmount, Date assetValueDate, String businessAttribute, String dataSourceFile) {
		super(oriFullAssetAccountPosId, dataVersion, calYaer, systemIdentification, orgNameCode, orgName, assetNumber,
				secondaryNumber, calyear, largeClassCode, transactionCategory, whethCapitalizationLastYear,
				bookKeepingAmount, assetValueDate, businessAttribute, dataSourceFile);
	}

}
