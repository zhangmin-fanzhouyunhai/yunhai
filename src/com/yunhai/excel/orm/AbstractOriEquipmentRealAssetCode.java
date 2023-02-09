package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriEquipmentRealAssetCode entity provides the base persistence
 * definition of the OriEquipmentRealAssetCode entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriEquipmentRealAssetCode implements java.io.Serializable {

	// Fields

	private String oriEquipmentRealAssetId;
	private Date calYear;
	private String dataVersion;
	private String class_;
	private String equipmentId;
	private String realAssetId;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriEquipmentRealAssetCode() {
	}

	/** minimal constructor */
	public AbstractOriEquipmentRealAssetCode(String oriEquipmentRealAssetId, String class_) {
		this.oriEquipmentRealAssetId = oriEquipmentRealAssetId;
		this.class_ = class_;
	}

	/** full constructor */
	public AbstractOriEquipmentRealAssetCode(String oriEquipmentRealAssetId, Date calYear, String dataVersion,
			String class_, String equipmentId, String realAssetId, String dataSourceFile) {
		this.oriEquipmentRealAssetId = oriEquipmentRealAssetId;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.class_ = class_;
		this.equipmentId = equipmentId;
		this.realAssetId = realAssetId;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriEquipmentRealAssetId() {
		return this.oriEquipmentRealAssetId;
	}

	public void setOriEquipmentRealAssetId(String oriEquipmentRealAssetId) {
		this.oriEquipmentRealAssetId = oriEquipmentRealAssetId;
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

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getRealAssetId() {
		return this.realAssetId;
	}

	public void setRealAssetId(String realAssetId) {
		this.realAssetId = realAssetId;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}