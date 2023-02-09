package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractPmsSpareEquipment entity provides the base persistence definition of
 * the PmsSpareEquipment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPmsSpareEquipment implements java.io.Serializable {

	// Fields

	private String pmsSpareEquipmentId;
	private Date calYear;
	private String dataVersion;
	private String spareEquipmentSource;
	private String sblx;
	private String zclxbm;
	private String cwbm;
	private String dydj;
	private String zzsmc;
	private String sbxh;
	private String kcdd;
	private String equipmentManager;
	private String equipmentAccessResult;
	private String assetQuality;
	private String assetOrg;
	private String assetNo;
	private String sbbm;
	private Date warehousingDate;
	private Double nn;
	private String equipmentStatus;
	private String programeName;
	private Double assetOriginalValue;
	private Double assetNetValue;
	private String valueUnit;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractPmsSpareEquipment() {
	}

	/** minimal constructor */
	public AbstractPmsSpareEquipment(String pmsSpareEquipmentId) {
		this.pmsSpareEquipmentId = pmsSpareEquipmentId;
	}

	/** full constructor */
	public AbstractPmsSpareEquipment(String pmsSpareEquipmentId, Date calYear, String dataVersion,
			String spareEquipmentSource, String sblx, String zclxbm, String cwbm, String dydj, String zzsmc,
			String sbxh, String kcdd, String equipmentManager, String equipmentAccessResult, String assetQuality,
			String assetOrg, String assetNo, String sbbm, Date warehousingDate, Double nn, String equipmentStatus,
			String programeName, Double assetOriginalValue, Double assetNetValue, String valueUnit,
			String dataSourceFile) {
		this.pmsSpareEquipmentId = pmsSpareEquipmentId;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.spareEquipmentSource = spareEquipmentSource;
		this.sblx = sblx;
		this.zclxbm = zclxbm;
		this.cwbm = cwbm;
		this.dydj = dydj;
		this.zzsmc = zzsmc;
		this.sbxh = sbxh;
		this.kcdd = kcdd;
		this.equipmentManager = equipmentManager;
		this.equipmentAccessResult = equipmentAccessResult;
		this.assetQuality = assetQuality;
		this.assetOrg = assetOrg;
		this.assetNo = assetNo;
		this.sbbm = sbbm;
		this.warehousingDate = warehousingDate;
		this.nn = nn;
		this.equipmentStatus = equipmentStatus;
		this.programeName = programeName;
		this.assetOriginalValue = assetOriginalValue;
		this.assetNetValue = assetNetValue;
		this.valueUnit = valueUnit;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getPmsSpareEquipmentId() {
		return this.pmsSpareEquipmentId;
	}

	public void setPmsSpareEquipmentId(String pmsSpareEquipmentId) {
		this.pmsSpareEquipmentId = pmsSpareEquipmentId;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getSpareEquipmentSource() {
		return this.spareEquipmentSource;
	}

	public void setSpareEquipmentSource(String spareEquipmentSource) {
		this.spareEquipmentSource = spareEquipmentSource;
	}

	public String getSblx() {
		return this.sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public String getZclxbm() {
		return this.zclxbm;
	}

	public void setZclxbm(String zclxbm) {
		this.zclxbm = zclxbm;
	}

	public String getCwbm() {
		return this.cwbm;
	}

	public void setCwbm(String cwbm) {
		this.cwbm = cwbm;
	}

	public String getDydj() {
		return this.dydj;
	}

	public void setDydj(String dydj) {
		this.dydj = dydj;
	}

	public String getZzsmc() {
		return this.zzsmc;
	}

	public void setZzsmc(String zzsmc) {
		this.zzsmc = zzsmc;
	}

	public String getSbxh() {
		return this.sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	public String getKcdd() {
		return this.kcdd;
	}

	public void setKcdd(String kcdd) {
		this.kcdd = kcdd;
	}

	public String getEquipmentManager() {
		return this.equipmentManager;
	}

	public void setEquipmentManager(String equipmentManager) {
		this.equipmentManager = equipmentManager;
	}

	public String getEquipmentAccessResult() {
		return this.equipmentAccessResult;
	}

	public void setEquipmentAccessResult(String equipmentAccessResult) {
		this.equipmentAccessResult = equipmentAccessResult;
	}

	public String getAssetQuality() {
		return this.assetQuality;
	}

	public void setAssetQuality(String assetQuality) {
		this.assetQuality = assetQuality;
	}

	public String getAssetOrg() {
		return this.assetOrg;
	}

	public void setAssetOrg(String assetOrg) {
		this.assetOrg = assetOrg;
	}

	public String getAssetNo() {
		return this.assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

	public String getSbbm() {
		return this.sbbm;
	}

	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public Date getWarehousingDate() {
		return this.warehousingDate;
	}

	public void setWarehousingDate(Date warehousingDate) {
		this.warehousingDate = warehousingDate;
	}

	public Double getNn() {
		return this.nn;
	}

	public void setNn(Double nn) {
		this.nn = nn;
	}

	public String getEquipmentStatus() {
		return this.equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getProgrameName() {
		return this.programeName;
	}

	public void setProgrameName(String programeName) {
		this.programeName = programeName;
	}

	public Double getAssetOriginalValue() {
		return this.assetOriginalValue;
	}

	public void setAssetOriginalValue(Double assetOriginalValue) {
		this.assetOriginalValue = assetOriginalValue;
	}

	public Double getAssetNetValue() {
		return this.assetNetValue;
	}

	public void setAssetNetValue(Double assetNetValue) {
		this.assetNetValue = assetNetValue;
	}

	public String getValueUnit() {
		return this.valueUnit;
	}

	public void setValueUnit(String valueUnit) {
		this.valueUnit = valueUnit;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}