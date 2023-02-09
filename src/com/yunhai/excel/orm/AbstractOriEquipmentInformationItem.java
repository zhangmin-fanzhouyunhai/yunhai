package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOriEquipmentInformationItem entity provides the base persistence
 * definition of the OriEquipmentInformationItem entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriEquipmentInformationItem implements java.io.Serializable {

	// Fields

	private String oriEquipmentInformatItemId;
	private String dataVersion;
	private Date calYear;
	private String equipmentNumber;
	private String lengthUnit;
	private String capacityUnit;
	private Double lineLength;
	private Double transformerCapacity;
	private String realAssetId;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriEquipmentInformationItem() {
	}

	/** minimal constructor */
	public AbstractOriEquipmentInformationItem(String oriEquipmentInformatItemId) {
		this.oriEquipmentInformatItemId = oriEquipmentInformatItemId;
	}

	/** full constructor */
	public AbstractOriEquipmentInformationItem(String oriEquipmentInformatItemId, String dataVersion, Date calYear,
			String equipmentNumber, String lengthUnit, String capacityUnit, Double lineLength,
			Double transformerCapacity, String realAssetId, String dataSourceFile) {
		this.oriEquipmentInformatItemId = oriEquipmentInformatItemId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.equipmentNumber = equipmentNumber;
		this.lengthUnit = lengthUnit;
		this.capacityUnit = capacityUnit;
		this.lineLength = lineLength;
		this.transformerCapacity = transformerCapacity;
		this.realAssetId = realAssetId;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriEquipmentInformatItemId() {
		return this.oriEquipmentInformatItemId;
	}

	public void setOriEquipmentInformatItemId(String oriEquipmentInformatItemId) {
		this.oriEquipmentInformatItemId = oriEquipmentInformatItemId;
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

	public String getLengthUnit() {
		return this.lengthUnit;
	}

	public void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public String getCapacityUnit() {
		return this.capacityUnit;
	}

	public void setCapacityUnit(String capacityUnit) {
		this.capacityUnit = capacityUnit;
	}

	public Double getLineLength() {
		return this.lineLength;
	}

	public void setLineLength(Double lineLength) {
		this.lineLength = lineLength;
	}

	public Double getTransformerCapacity() {
		return this.transformerCapacity;
	}

	public void setTransformerCapacity(Double transformerCapacity) {
		this.transformerCapacity = transformerCapacity;
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