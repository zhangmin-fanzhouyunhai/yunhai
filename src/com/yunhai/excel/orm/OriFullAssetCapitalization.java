package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriFullAssetCapitalization entity. @author MyEclipse Persistence Tools
 */
public class OriFullAssetCapitalization extends AbstractOriFullAssetCapitalization implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFullAssetCapitalization() {
	}

	/** minimal constructor */
	public OriFullAssetCapitalization(String oriFullAssetCapitalizId) {
		super(oriFullAssetCapitalizId);
	}

	/** full constructor */
	public OriFullAssetCapitalization(String oriFullAssetCapitalizId, String dataVersion, Date calYaer,
			String orgNameCode, String orgName, String assetNumber, String secondaryNumber, Long calyear, String arDot,
			String largeClassCode, Double originalValue, Double accumulatedPurchaseValue, Double assetValueBusiness,String dataSourceFile) {
		super(oriFullAssetCapitalizId, dataVersion, calYaer, orgNameCode, orgName, assetNumber, secondaryNumber,
				calyear, arDot, largeClassCode, originalValue, accumulatedPurchaseValue, assetValueBusiness, dataSourceFile);
	}

}
