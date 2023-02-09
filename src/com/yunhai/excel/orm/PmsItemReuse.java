package com.yunhai.excel.orm;

import java.math.BigDecimal;
import java.util.Date;

public class PmsItemReuse extends AbstractPmsItemReuse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2237742243176061521L;

	public PmsItemReuse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PmsItemReuse(String pmsItemReuseId, String version, Date calYear, String oldEquipmentName,
			String equipmentType, String voltageLevel, String oldTransformSubstationLine, String repositoryAddress,
			String equipmentCustodian, String equipmentEvaluationResult, String assetProperty,
			String oldMaintenanceOrgName, String assetNumber, String equipmentNumber, String pmEquipmentNumber,
			Double originalValue, Double netValue, Date deliveryDate, Date storageDate, String isOccupied,
			String occupiedOrgName, String occupiedProjectName, String unit, String disposialStatus) {
		super(pmsItemReuseId, version, calYear, oldEquipmentName, equipmentType, voltageLevel,
				oldTransformSubstationLine, repositoryAddress, equipmentCustodian, equipmentEvaluationResult,
				assetProperty, oldMaintenanceOrgName, assetNumber, equipmentNumber, pmEquipmentNumber, originalValue,
				netValue, deliveryDate, storageDate, isOccupied, occupiedOrgName, occupiedProjectName, unit,
				disposialStatus);
		// TODO Auto-generated constructor stub
	}

	public PmsItemReuse(String pmsItemReuseId, String version, Date calYear, String oldEquipmentName,
			String equipmentType, String voltageLevel, String oldTransformSubstationLine, String repositoryAddress,
			String equipmentCustodian, String equipmentEvaluationResult, String assetProperty,
			String oldMaintenanceOrgName, String assetNumber, String equipmentNumber, String pmEquipmentNumber,
			Double originalValue, Double netValue, Date deliveryDate, Date storageDate, String isOccupied,
			String occupiedOrgName, String occupiedProjectName, String unit, String disposialStatus,
			String maintenanceOrgId, String subordinateMunicipality, String subordinateMaintenanceOrg,
			String modifierName,  Double whetherBeenUsed, String dataSourceFile) {
		super(pmsItemReuseId, version, calYear, oldEquipmentName, equipmentType, voltageLevel,
				oldTransformSubstationLine, repositoryAddress, equipmentCustodian, equipmentEvaluationResult,
				assetProperty, oldMaintenanceOrgName, assetNumber, equipmentNumber, pmEquipmentNumber, originalValue,
				netValue, deliveryDate, storageDate, isOccupied, occupiedOrgName, occupiedProjectName, unit,
				disposialStatus, maintenanceOrgId, subordinateMunicipality, subordinateMaintenanceOrg, modifierName,
				 whetherBeenUsed, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
