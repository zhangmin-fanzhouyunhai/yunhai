package com.yunhai.excel.orm;
 
import java.util.Date;

/**
 * PmsSpareEquipment entity. @author MyEclipse Persistence Tools
 */
public class PmsSpareEquipment extends AbstractPmsSpareEquipment implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PmsSpareEquipment() {
	}

	/** minimal constructor */
	public PmsSpareEquipment(String pmsSpareEquipmentId) {
		super(pmsSpareEquipmentId);
	}

	/** full constructor */ 

	public PmsSpareEquipment(String pmsSpareEquipmentId, Date calYear, String dataVersion,
			String spareEquipmentSource, String sblx, String zclxbm, String cwbm, String dydj, String zzsmc,
			String sbxh, String kcdd, String equipmentManager, String equipmentAccessResult, String assetQuality,
			String assetOrg, String assetNo, String sbbm, Date warehousingDate, Double nn, String equipmentStatus,
			String programeName, Double assetOriginalValue, Double assetNetValue, String valueUnit,
			String dataSourceFile) {
		super(pmsSpareEquipmentId, calYear, dataVersion, spareEquipmentSource, sblx, zclxbm, cwbm, dydj, zzsmc, sbxh, kcdd,
				equipmentManager, equipmentAccessResult, assetQuality, assetOrg, assetNo, sbbm, warehousingDate, nn,
				equipmentStatus, programeName, assetOriginalValue, assetNetValue, valueUnit, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
