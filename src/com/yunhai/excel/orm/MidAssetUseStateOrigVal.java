package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetUseStateOrigVal entity. @author MyEclipse Persistence Tools
 */
public class MidAssetUseStateOrigVal extends AbstractMidAssetUseStateOrigVal implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetUseStateOrigVal() {
	}

	/** minimal constructor */
	public MidAssetUseStateOrigVal(String midAssetUseStatOrigValId) {
		super(midAssetUseStatOrigValId);
	}

	/** full constructor */
	public MidAssetUseStateOrigVal(String midAssetUseStatOrigValId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double year1WorkingOrigVal,
			Double year1BackupOrigVal, Double year1DiscardOrigVal, Double year2WorkingOrigVal,
			Double year2BackupOrigVal, Double year2DiscardOrigVal, Double year3WorkingOrigVal,
			Double year3BackupOrigVal, Double year3DiscardOrigVal, Double year4WorkingOrigVal,
			Double year4BackupOrigVal, Double year4DiscardOrigVal, Double year5WorkingOrigVal,
			Double year5BackupOrigVal, Double year5DiscardOrigVal, Double year6WorkingOrigVal,
			Double year6BackupOrigVal, Double year6DiscardOrigVal, Date dvDateValue, String category) {
		super(midAssetUseStatOrigValId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				year1WorkingOrigVal, year1BackupOrigVal, year1DiscardOrigVal, year2WorkingOrigVal, year2BackupOrigVal,
				year2DiscardOrigVal, year3WorkingOrigVal, year3BackupOrigVal, year3DiscardOrigVal, year4WorkingOrigVal,
				year4BackupOrigVal, year4DiscardOrigVal, year5WorkingOrigVal, year5BackupOrigVal, year5DiscardOrigVal,
				year6WorkingOrigVal, year6BackupOrigVal, year6DiscardOrigVal, dvDateValue, category);
	}

}
