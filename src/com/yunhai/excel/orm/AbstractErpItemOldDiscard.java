package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErpItemOldDiscard entity provides the base persistence definition of
 * the ErpItemOldDiscard entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpItemOldDiscard implements java.io.Serializable {

	// Fields

	private String erpItemOldDiscardId;
	private String version;
	private Date calYear;
	private String profitCenterId;
	private String neng;
	private String orgName;
	private String areaName;
	private String substation;
	private String equipmentType;
	private String equipmentClass;
	private String pmsEquipmentId;
	private String equipmentId;
	private String assetId;
	private String voltageLevel;
	private String equipmentMode;
	private Date deliveryDate;
	private Date manufactureDate;
	private Date capitalizationDate;
	private Date discardDate;
	private Long discardYear;
	private String discardReason;
	private String discardProject;
	private Double discardOriginalValue;
	private Double discardNetValue;
	private String manufacturer;
	private Double useAge;
	private String minimumDate;
	private String remark;
	private String projectId;
	private Double entityRatio;
	private String equipmentName;
	private String equipmentModeCode;
	private String equipmentVoltageLevel;

	// Constructors

	/** default constructor */
	public AbstractErpItemOldDiscard() {
	}

	/** full constructor */
	public AbstractErpItemOldDiscard(String version,Date calYear, String profitCenterId, String neng, String orgName,
			String areaName, String substation, String equipmentType, String equipmentClass, String pmsEquipmentId,
			String equipmentId, String assetId, String voltageLevel, String equipmentMode, Date deliveryDate,
			Date manufactureDate, Date capitalizationDate, Date discardDate, Long discardYear, String discardReason,
			String discardProject, Double discardOriginalValue, Double discardNetValue, String manufacturer,
			Double useAge, String minimumDate, String remark, String projectId, Double entityRatio,
			String equipmentName, String equipmentModeCode, String equipmentVoltageLevel) {
		this.version = version;
		this.calYear = calYear;
		this.profitCenterId = profitCenterId;
		this.neng = neng;
		this.orgName = orgName;
		this.areaName = areaName;
		this.substation = substation;
		this.equipmentType = equipmentType;
		this.equipmentClass = equipmentClass;
		this.pmsEquipmentId = pmsEquipmentId;
		this.equipmentId = equipmentId;
		this.assetId = assetId;
		this.voltageLevel = voltageLevel;
		this.equipmentMode = equipmentMode;
		this.deliveryDate = deliveryDate;
		this.manufactureDate = manufactureDate;
		this.capitalizationDate = capitalizationDate;
		this.discardDate = discardDate;
		this.discardYear = discardYear;
		this.discardReason = discardReason;
		this.discardProject = discardProject;
		this.discardOriginalValue = discardOriginalValue;
		this.discardNetValue = discardNetValue;
		this.manufacturer = manufacturer;
		this.useAge = useAge;
		this.minimumDate = minimumDate;
		this.remark = remark;
		this.projectId = projectId;
		this.entityRatio = entityRatio;
		this.equipmentName = equipmentName;
		this.equipmentModeCode = equipmentModeCode;
		this.equipmentVoltageLevel = equipmentVoltageLevel;
	}

	// Property accessors

	public String getErpItemOldDiscardId() {
		return this.erpItemOldDiscardId;
	}

	public void setErpItemOldDiscardId(String erpItemOldDiscardId) {
		this.erpItemOldDiscardId = erpItemOldDiscardId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getProfitCenterId() {
		return this.profitCenterId;
	}

	public void setProfitCenterId(String profitCenterId) {
		this.profitCenterId = profitCenterId;
	}

	public String getNeng() {
		return this.neng;
	}

	public void setNeng(String neng) {
		this.neng = neng;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getSubstation() {
		return this.substation;
	}

	public void setSubstation(String substation) {
		this.substation = substation;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentClass() {
		return this.equipmentClass;
	}

	public void setEquipmentClass(String equipmentClass) {
		this.equipmentClass = equipmentClass;
	}

	public String getPmsEquipmentId() {
		return this.pmsEquipmentId;
	}

	public void setPmsEquipmentId(String pmsEquipmentId) {
		this.pmsEquipmentId = pmsEquipmentId;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getEquipmentMode() {
		return this.equipmentMode;
	}

	public void setEquipmentMode(String equipmentMode) {
		this.equipmentMode = equipmentMode;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public Date getDiscardDate() {
		return this.discardDate;
	}

	public void setDiscardDate(Date discardDate) {
		this.discardDate = discardDate;
	}

	public Long getDiscardYear() {
		return this.discardYear;
	}

	public void setDiscardYear(Long discardYear) {
		this.discardYear = discardYear;
	}

	public String getDiscardReason() {
		return this.discardReason;
	}

	public void setDiscardReason(String discardReason) {
		this.discardReason = discardReason;
	}

	public String getDiscardProject() {
		return this.discardProject;
	}

	public void setDiscardProject(String discardProject) {
		this.discardProject = discardProject;
	}

	public Double getDiscardOriginalValue() {
		return this.discardOriginalValue;
	}

	public void setDiscardOriginalValue(Double discardOriginalValue) {
		this.discardOriginalValue = discardOriginalValue;
	}

	public Double getDiscardNetValue() {
		return this.discardNetValue;
	}

	public void setDiscardNetValue(Double discardNetValue) {
		this.discardNetValue = discardNetValue;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getUseAge() {
		return this.useAge;
	}

	public void setUseAge(Double useAge) {
		this.useAge = useAge;
	}

	public String getMinimumDate() {
		return this.minimumDate;
	}

	public void setMinimumDate(String minimumDate) {
		this.minimumDate = minimumDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Double getEntityRatio() {
		return this.entityRatio;
	}

	public void setEntityRatio(Double entityRatio) {
		this.entityRatio = entityRatio;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentModeCode() {
		return this.equipmentModeCode;
	}

	public void setEquipmentModeCode(String equipmentModeCode) {
		this.equipmentModeCode = equipmentModeCode;
	}

	public String getEquipmentVoltageLevel() {
		return this.equipmentVoltageLevel;
	}

	public void setEquipmentVoltageLevel(String equipmentVoltageLevel) {
		this.equipmentVoltageLevel = equipmentVoltageLevel;
	}

}