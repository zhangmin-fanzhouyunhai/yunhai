package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidBackupAssetScale entity. @author MyEclipse Persistence Tools
 */
public class MidBackupAssetScale extends AbstractMidBackupAssetScale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidBackupAssetScale() {
	}

	/** minimal constructor */
	public MidBackupAssetScale(String midBackupAssetScaleId) {
		super(midBackupAssetScaleId);
	}

	/** full constructor */
	public MidBackupAssetScale(String midBackupAssetScaleId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Double within3YearQuantity,
			Double within3YearTechnScale, Double moreThan3YearQuantity, Double moreThan3YearTechnScale,
			Date dvDateValue, String category, String areaName) {
		super(midBackupAssetScaleId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				within3YearQuantity, within3YearTechnScale, moreThan3YearQuantity, moreThan3YearTechnScale, dvDateValue,
				category, areaName);
	}

}
