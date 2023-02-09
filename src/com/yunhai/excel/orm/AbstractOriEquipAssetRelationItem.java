package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriEquipAssetRelationItem entity provides the base persistence
 * definition of the OriEquipAssetRelationItem entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriEquipAssetRelationItem implements java.io.Serializable {

	// Fields

	private String oriEquipAssetRelatItemId;
	private String dataVersion;
	private Date calYear;
	private String equipmentNumber;
	private String techObjectDescription;
	private String techObjectType;
	private String assetNumber;
	private String assetProperty;
	private Date commissioningDate;
	private String assetPropertyDescription;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriEquipAssetRelationItem() {
	}

	/** minimal constructor */
	public AbstractOriEquipAssetRelationItem(String oriEquipAssetRelatItemId) {
		this.oriEquipAssetRelatItemId = oriEquipAssetRelatItemId;
	}

	/** full constructor */
	public AbstractOriEquipAssetRelationItem(String oriEquipAssetRelatItemId, String dataVersion, Date calYear,
			String equipmentNumber, String techObjectDescription, String techObjectType, String assetNumber,
			String assetProperty, Date commissioningDate, String assetPropertyDescription, String dataSourceFile) {
		this.oriEquipAssetRelatItemId = oriEquipAssetRelatItemId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentNumber = equipmentNumber;
		this.techObjectDescription = techObjectDescription;
		this.techObjectType = techObjectType;
		this.assetNumber = assetNumber;
		this.assetProperty = assetProperty;
		this.commissioningDate = commissioningDate;
		this.assetPropertyDescription = assetPropertyDescription;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriEquipAssetRelatItemId() {
		return this.oriEquipAssetRelatItemId;
	}

	public void setOriEquipAssetRelatItemId(String oriEquipAssetRelatItemId) {
		this.oriEquipAssetRelatItemId = oriEquipAssetRelatItemId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getEquipmentNumber() {
		return this.equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getTechObjectDescription() {
		return this.techObjectDescription;
	}

	public void setTechObjectDescription(String techObjectDescription) {
		this.techObjectDescription = techObjectDescription;
	}

	public String getTechObjectType() {
		return this.techObjectType;
	}

	public void setTechObjectType(String techObjectType) {
		this.techObjectType = techObjectType;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetProperty() {
		return this.assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getAssetPropertyDescription() {
		return this.assetPropertyDescription;
	}

	public void setAssetPropertyDescription(String assetPropertyDescription) {
		this.assetPropertyDescription = assetPropertyDescription;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}