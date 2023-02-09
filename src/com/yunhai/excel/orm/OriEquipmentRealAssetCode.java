package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriEquipmentRealAssetCode entity. @author MyEclipse Persistence Tools
 */
public class OriEquipmentRealAssetCode extends AbstractOriEquipmentRealAssetCode implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriEquipmentRealAssetCode() {
	}

	/** minimal constructor */
	public OriEquipmentRealAssetCode(String oriEquipmentRealAssetId, String class_) {
		super(oriEquipmentRealAssetId, class_);
	}

	/** full constructor */
	public OriEquipmentRealAssetCode(String oriEquipmentRealAssetId, Date calYear, String dataVersion,
			String class_, String equipmentId, String realAssetId, String dataSourceFile) {
		super(oriEquipmentRealAssetId, calYear, dataVersion, class_, equipmentId, realAssetId, dataSourceFile);
	}

}
