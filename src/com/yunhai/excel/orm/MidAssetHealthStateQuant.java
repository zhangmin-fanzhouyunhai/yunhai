package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetHealthStateQuant entity. @author MyEclipse Persistence Tools
 */
public class MidAssetHealthStateQuant extends AbstractMidAssetHealthStateQuant implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetHealthStateQuant() {
	}

	/** minimal constructor */
	public MidAssetHealthStateQuant(String midAssetHealStateQuantId) {
		super(midAssetHealStateQuantId);
	}

	/** full constructor */
	public MidAssetHealthStateQuant(String midAssetHealStateQuantId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double year1TotalAssetQuantity, Double year1NormalStateQuant, Double year1AttentionStateQuant,
			Double year1UnnormalStateQuant, Double year1SeriousStateQuant, Double year2TotalAssetQuantity,
			Double year2NormalStateQuant, Double year2AttentionStateQuant, Double year2UnnormalStateQuant,
			Double year2SeriousStateQuant, Double year3TotalAssetQuantity, Double year3NormalStateQuant,
			Double year3AttentionStateQuant, Double year3UnnormalStateQuant, Double year3SeriousStateQuant,
			Double year4TotalAssetQuantity, Double year4NormalStateQuant, Double year4AttentionStateQuant,
			Double year4UnnormalStateQuant, Double year4SeriousStateQuant, Double year5TotalAssetQuantity,
			Double year5NormalStateQuant, Double year5AttentionStateQuant, Double year5UnnormalStateQuant,
			Double year5SeriousStateQuant, Double year6TotalAssetQuantity, Double year6NormalStateQuant,
			Double year6AttentionStateQuant, Double year6UnnormalStateQuant, Double year6SeriousStateQuant,
			Date dvDateValue, String category) {
		super(midAssetHealStateQuantId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				year1TotalAssetQuantity, year1NormalStateQuant, year1AttentionStateQuant, year1UnnormalStateQuant,
				year1SeriousStateQuant, year2TotalAssetQuantity, year2NormalStateQuant, year2AttentionStateQuant,
				year2UnnormalStateQuant, year2SeriousStateQuant, year3TotalAssetQuantity, year3NormalStateQuant,
				year3AttentionStateQuant, year3UnnormalStateQuant, year3SeriousStateQuant, year4TotalAssetQuantity,
				year4NormalStateQuant, year4AttentionStateQuant, year4UnnormalStateQuant, year4SeriousStateQuant,
				year5TotalAssetQuantity, year5NormalStateQuant, year5AttentionStateQuant, year5UnnormalStateQuant,
				year5SeriousStateQuant, year6TotalAssetQuantity, year6NormalStateQuant, year6AttentionStateQuant,
				year6UnnormalStateQuant, year6SeriousStateQuant, dvDateValue, category);
	}

}
