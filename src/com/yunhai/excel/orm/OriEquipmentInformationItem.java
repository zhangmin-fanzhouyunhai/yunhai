package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriEquipmentInformationItem entity. @author MyEclipse Persistence Tools
 */
public class OriEquipmentInformationItem extends AbstractOriEquipmentInformationItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriEquipmentInformationItem() {
	}

	/** minimal constructor */
	public OriEquipmentInformationItem(String oriEquipmentInformatItemId) {
		super(oriEquipmentInformatItemId);
	}

	/** full constructor */
	public OriEquipmentInformationItem(String oriEquipmentInformatItemId, String dataVersion, Date calYear,
			String equipmentNumber, String lengthUnit, String capacityUnit, Double lineLength,
			Double transformerCapacity, String realAssetId, String dataSourceFile) {
		super(oriEquipmentInformatItemId, dataVersion, calYear, equipmentNumber, lengthUnit, capacityUnit, lineLength,
				transformerCapacity, realAssetId, dataSourceFile);
	}

}
