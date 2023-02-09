package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriLowVolStationLineEquip entity. @author MyEclipse Persistence Tools
 */
public class OriLowVolStationLineEquip extends AbstractOriLowVolStationLineEquip implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriLowVolStationLineEquip() {
	}

	/** minimal constructor */
	public OriLowVolStationLineEquip(String oriLowVolStatLineEquipId) {
		super(oriLowVolStatLineEquipId);
	}

	/** full constructor */
	public OriLowVolStationLineEquip(String oriLowVolStatLineEquipId, String dataVersion, Date calYear,
			String subordinateOrgCode, String orgName, String assetClassName, String assetIncreasedMode,
			Double workingAge, Double quantity, Double lengthCapacity) {
		super(oriLowVolStatLineEquipId, dataVersion, calYear, subordinateOrgCode, orgName, assetClassName,
				assetIncreasedMode, workingAge, quantity, lengthCapacity);
	}
	/** full constructor */
	public OriLowVolStationLineEquip(String oriLowVolStatLineEquipId, String dataVersion, Date calYear,
			String subordinateOrgCode, String orgName, String assetClassName, String assetIncreasedMode,
			Double workingAge, Double quantity, Double lengthCapacity,String dataSourceFile) {
		super(oriLowVolStatLineEquipId, dataVersion, calYear, subordinateOrgCode, orgName, assetClassName,
				assetIncreasedMode, workingAge, quantity, lengthCapacity,dataSourceFile);
	}

}
