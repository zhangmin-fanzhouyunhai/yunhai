package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ErpItemOldDiscard entity. @author MyEclipse Persistence Tools
 */
public class ErpItemOldDiscard extends AbstractErpItemOldDiscard implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpItemOldDiscard() {
	}

	/** full constructor */
	public ErpItemOldDiscard(String version,Date calYear, String profitCenterId, String neng, String orgName,
			String areaName, String substation, String equipmentType, String equipmentClass, String pmsEquipmentId,
			String equipmentId, String assetId, String voltageLevel, String equipmentMode, Date deliveryDate,
			Date manufactureDate, Date capitalizationDate, Date discardDate, Long discardYear, String discardReason,
			String discardProject, Double discardOriginalValue, Double discardNetValue, String manufacturer,
			Double useAge, String minimumDate, String remark, String projectId, Double entityRatio,
			String equipmentName, String equipmentModeCode, String equipmentVoltageLevel) {
		super(version,calYear, profitCenterId, neng, orgName, areaName, substation, equipmentType, equipmentClass,
				pmsEquipmentId, equipmentId, assetId, voltageLevel, equipmentMode, deliveryDate, manufactureDate,
				capitalizationDate, discardDate, discardYear, discardReason, discardProject, discardOriginalValue,
				discardNetValue, manufacturer, useAge, minimumDate, remark, projectId, entityRatio, equipmentName,
				equipmentModeCode, equipmentVoltageLevel);
	}

}
