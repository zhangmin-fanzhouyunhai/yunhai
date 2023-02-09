package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidDiscardAssetYearScale entity. @author MyEclipse Persistence Tools
 */
public class MidDiscardAssetYearScale extends AbstractMidDiscardAssetYearScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidDiscardAssetYearScale() {
	}

	/** minimal constructor */
	public MidDiscardAssetYearScale(String midDiscAssetYearScaleId) {
		super(midDiscAssetYearScaleId);
	}

	/** full constructor */
	public MidDiscardAssetYearScale(String midDiscAssetYearScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double origValue6Years,
			Double origValue5Years, Double origValue4Years, Double origValue3Years, Double origValue2Years,
			Double origValue1Years, Double quantity6Years, Double quantity5Years, Double quantity4Years,
			Double quantity3Years, Double quantity2Years, Double quantity1Years, Date dvDateValue, String category) {
		super(midDiscAssetYearScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				origValue6Years, origValue5Years, origValue4Years, origValue3Years, origValue2Years, origValue1Years,
				quantity6Years, quantity5Years, quantity4Years, quantity3Years, quantity2Years, quantity1Years,
				dvDateValue, category);
	}

}
