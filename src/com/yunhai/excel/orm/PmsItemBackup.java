package com.yunhai.excel.orm;

import java.io.Serializable;
import java.util.Date;

public class PmsItemBackup extends AbstractPmsItemBackup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8939925970642582774L;

	public PmsItemBackup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PmsItemBackup(String pmsItemBackupId, Date calYear, String version, String backupItemSource,
			String equipmentType, String voltageLevel, String manufacturer, String equipmentModel,
			String reporsitoryAddress, String equipmentCustodian, String equipmentEvaluationResult,
			String assetProperty, String orgName, String assetNumber, String equipmentNumber, Date storageDate,
			String backupEquipmentStatus, String projectName, Double originalValue, Double netValue, String unit) {
		super(pmsItemBackupId, calYear, version, backupItemSource, equipmentType, voltageLevel, manufacturer,
				equipmentModel, reporsitoryAddress, equipmentCustodian, equipmentEvaluationResult, assetProperty,
				orgName, assetNumber, equipmentNumber, storageDate, backupEquipmentStatus, projectName, originalValue,
				netValue, unit);
		// TODO Auto-generated constructor stub
	}

	public PmsItemBackup(String pmsItemBackupId, Date calYear, String version, String backupItemSource,
			String equipmentType, String voltageLevel, String manufacturer, String equipmentModel,
			String reporsitoryAddress, String equipmentCustodian, String equipmentEvaluationResult,
			String assetProperty, String orgName, String assetNumber, String equipmentNumber, Date storageDate,
			String backupEquipmentStatus, String projectName, Double originalValue, Double netValue, String unit,
			String maintenanceOrgId, String subordinateMunicipality, String subordinateMaintenanceOrg,
			String modifierName, String projectId, String dataSourceFile) {
		super(pmsItemBackupId, calYear, version, backupItemSource, equipmentType, voltageLevel, manufacturer,
				equipmentModel, reporsitoryAddress, equipmentCustodian, equipmentEvaluationResult, assetProperty,
				orgName, assetNumber, equipmentNumber, storageDate, backupEquipmentStatus, projectName, originalValue,
				netValue, unit, maintenanceOrgId, subordinateMunicipality, subordinateMaintenanceOrg, modifierName,
				projectId, dataSourceFile);
		// TODO Auto-generated constructor stub
	}
}
