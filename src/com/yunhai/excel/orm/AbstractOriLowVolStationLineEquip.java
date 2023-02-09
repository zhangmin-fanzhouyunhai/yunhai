package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriLowVolStationLineEquip entity provides the base persistence
 * definition of the OriLowVolStationLineEquip entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriLowVolStationLineEquip implements java.io.Serializable {

	// Fields

	private String oriLowVolStatLineEquipId;
	private String dataVersion;
	private Date calYear;
	private String subordinateOrgCode;
	private String orgName;
	private String assetClassName;
	private String assetIncreasedMode;
	private Double workingAge;
	private Double quantity;
	private Double lengthCapacity;
	private String dataSourceFile;

	// Constructors
	/** default constructor */
	public AbstractOriLowVolStationLineEquip() {
	}

	/** minimal constructor */
	public AbstractOriLowVolStationLineEquip(String oriLowVolStatLineEquipId) {
		this.oriLowVolStatLineEquipId = oriLowVolStatLineEquipId;
	}

	/** full constructor */
	public AbstractOriLowVolStationLineEquip(String oriLowVolStatLineEquipId, String dataVersion, Date calYear,
			String subordinateOrgCode, String orgName, String assetClassName, String assetIncreasedMode,
			Double workingAge, Double quantity, Double lengthCapacity,String dataSourceFile) {
		this.oriLowVolStatLineEquipId = oriLowVolStatLineEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.subordinateOrgCode = subordinateOrgCode;
		this.orgName = orgName;
		this.assetClassName = assetClassName;
		this.assetIncreasedMode = assetIncreasedMode;
		this.workingAge = workingAge;
		this.quantity = quantity;
		this.lengthCapacity = lengthCapacity;
		this.dataSourceFile=dataSourceFile;
	}

	/** full constructor */
	public AbstractOriLowVolStationLineEquip(String oriLowVolStatLineEquipId, String dataVersion, Date calYear,
			String subordinateOrgCode, String orgName, String assetClassName, String assetIncreasedMode,
			Double workingAge, Double quantity, Double lengthCapacity) {
		this.oriLowVolStatLineEquipId = oriLowVolStatLineEquipId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.subordinateOrgCode = subordinateOrgCode;
		this.orgName = orgName;
		this.assetClassName = assetClassName;
		this.assetIncreasedMode = assetIncreasedMode;
		this.workingAge = workingAge;
		this.quantity = quantity;
		this.lengthCapacity = lengthCapacity;
	}

	// Property accessors

	public String getOriLowVolStatLineEquipId() {
		return this.oriLowVolStatLineEquipId;
	}

	public void setOriLowVolStatLineEquipId(String oriLowVolStatLineEquipId) {
		this.oriLowVolStatLineEquipId = oriLowVolStatLineEquipId;
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



	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}
	public String getSubordinateOrgCode() {
		return this.subordinateOrgCode;
	}

	public void setSubordinateOrgCode(String subordinateOrgCode) {
		this.subordinateOrgCode = subordinateOrgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAssetClassName() {
		return this.assetClassName;
	}

	public void setAssetClassName(String assetClassName) {
		this.assetClassName = assetClassName;
	}

	public String getAssetIncreasedMode() {
		return this.assetIncreasedMode;
	}

	public void setAssetIncreasedMode(String assetIncreasedMode) {
		this.assetIncreasedMode = assetIncreasedMode;
	}

	public Double getWorkingAge() {
		return this.workingAge;
	}

	public void setWorkingAge(Double workingAge) {
		this.workingAge = workingAge;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getLengthCapacity() {
		return this.lengthCapacity;
	}

	public void setLengthCapacity(Double lengthCapacity) {
		this.lengthCapacity = lengthCapacity;
	}

}