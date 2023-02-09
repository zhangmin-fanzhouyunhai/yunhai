package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriEquipAssetRelationItem entity. @author MyEclipse Persistence Tools
 */
public class OriEquipAssetRelationItem extends AbstractOriEquipAssetRelationItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriEquipAssetRelationItem() {
	}

	/** minimal constructor */
	public OriEquipAssetRelationItem(String oriEquipAssetRelatItemId) {
		super(oriEquipAssetRelatItemId);
	}

	/** full constructor */
	public OriEquipAssetRelationItem(String oriEquipAssetRelatItemId, String dataVersion, Date calYear,
			String equipmentNumber, String techObjectDescription, String techObjectType, String assetNumber,
			String assetProperty, Date commissioningDate, String assetPropertyDescription, String dataSourceFile) {
		super(oriEquipAssetRelatItemId, dataVersion, calYear, equipmentNumber, techObjectDescription, techObjectType,
				assetNumber, assetProperty, commissioningDate, assetPropertyDescription, dataSourceFile);
	}

}
