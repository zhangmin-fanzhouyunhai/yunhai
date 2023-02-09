package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidAssetUseStateQuant entity. @author MyEclipse Persistence Tools
 */
public class MidAssetUseStateQuant extends AbstractMidAssetUseStateQuant implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidAssetUseStateQuant() {
	}

	/** minimal constructor */
	public MidAssetUseStateQuant(String midAssetUseStateQuantId) {
		super(midAssetUseStateQuantId);
	}

	/** full constructor */
	public MidAssetUseStateQuant(String midAssetUseStateQuantId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double year1WorkingState,
			Double year1BackupState, Double year1DiscardState, Double year2WorkingState, Double year2BackupState,
			Double year2DiscardState, Double year3WorkingState, Double year3BackupState, Double year3DiscardState,
			Double year4WorkingState, Double year4BackupState, Double year4DiscardState, Double year5WorkingState,
			Double year5BackupState, Double year5DiscardState, Double year6WorkingState, Double year6BackupState,
			Double year6DiscardState, Date dvDateValue, String category) {
		super(midAssetUseStateQuantId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				year1WorkingState, year1BackupState, year1DiscardState, year2WorkingState, year2BackupState,
				year2DiscardState, year3WorkingState, year3BackupState, year3DiscardState, year4WorkingState,
				year4BackupState, year4DiscardState, year5WorkingState, year5BackupState, year5DiscardState,
				year6WorkingState, year6BackupState, year6DiscardState, dvDateValue, category);
	}

}
