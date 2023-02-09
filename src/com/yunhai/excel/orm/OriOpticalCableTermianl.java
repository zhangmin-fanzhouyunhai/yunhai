package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriOpticalCableTermianl entity. @author MyEclipse Persistence Tools
 */
public class OriOpticalCableTermianl extends AbstractOriOpticalCableTermianl implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriOpticalCableTermianl() {
	}

	/** minimal constructor */
	public OriOpticalCableTermianl(String oriOpticalCableTermianlId) {
		super(oriOpticalCableTermianlId);
	}

	/** full constructor */
	public OriOpticalCableTermianl(String oriOpticalCableTermianlId, String globalName, String name,
			String abbreviation, String subordinateComputerRoom, String erpAssetCoding,
			String erpEquipmentAccountCoding, String subordinateSite, String subordinateSystem, String manufacturer,
			String manufacturerEquipmentType, Date commissioningDate, String workingState,
			String jurisdictionRightOrg, String dataMaintenanceOrg, String propertyRightsOrg, String statisticalOrg,
			String defender, String warningSurveillanceOrg, String technicalSystem, String equipmentType,
			String maximumCapacity, String actualConfigurationMaxRate, String transportNetworkElementType, String dataVersion, String dataSourceFile) {
		super(oriOpticalCableTermianlId, globalName, name, abbreviation, subordinateComputerRoom, erpAssetCoding,
				erpEquipmentAccountCoding, subordinateSite, subordinateSystem, manufacturer, manufacturerEquipmentType,
				commissioningDate, workingState, jurisdictionRightOrg, dataMaintenanceOrg, propertyRightsOrg,
				statisticalOrg, defender, warningSurveillanceOrg, technicalSystem, equipmentType, maximumCapacity,
				actualConfigurationMaxRate, transportNetworkElementType,  dataVersion,  dataSourceFile);
	}

}
