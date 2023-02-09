package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriFinanceScrapPostEquip entity. @author MyEclipse Persistence Tools
 */
public class OriFinanceScrapPostEquip extends AbstractOriFinanceScrapPostEquip implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriFinanceScrapPostEquip() {
	}

	/** minimal constructor */
	public OriFinanceScrapPostEquip(String oriFinancScrapPostEquipId, String dataVersion, java.util.Date calYear) {
		super(oriFinancScrapPostEquipId, dataVersion, calYear);
	}

	/** full constructor */
	public OriFinanceScrapPostEquip(String oriFinancScrapPostEquipId, String dataVersion, java.util.Date calYear,
			String equipmentNo, String technicalObjectType, String voltageLevel, String equipmentIncreaseMode,
			String assetManufacturer, String model, String userStatus, String assetPropertyCode,
			String assetPropertyTxt, String equipmentDescription, java.util.Date commissioningDate, String lengthUnit,
			String capacitanceUnit, Double lineLength, Double substationCapacity, String equipmentPhysicalId,
			String dataSourceFileName) {
		super(oriFinancScrapPostEquipId, dataVersion, calYear, equipmentNo, technicalObjectType, voltageLevel,
				equipmentIncreaseMode, assetManufacturer, model, userStatus, assetPropertyCode, assetPropertyTxt,
				equipmentDescription, commissioningDate, lengthUnit, capacitanceUnit, lineLength, substationCapacity,
				equipmentPhysicalId, dataSourceFileName);
	}

}
