package com.yunhai.excel.orm;

/**
 * AbstractUpdateVoltageLevel entity provides the base persistence definition of
 * the UpdateVoltageLevel entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUpdateVoltageLevel implements java.io.Serializable {

	// Fields

	private String updateVoltageLevelId;
	private String assetMainNumber;
	private String voltageLevel;

	// Constructors

	/** default constructor */
	public AbstractUpdateVoltageLevel() {
	}

	/** full constructor */
	public AbstractUpdateVoltageLevel(String assetMainNumber, String voltageLevel) {
		this.assetMainNumber = assetMainNumber;
		this.voltageLevel = voltageLevel;
	}

	// Property accessors

	public String getUpdateVoltageLevelId() {
		return this.updateVoltageLevelId;
	}

	public void setUpdateVoltageLevelId(String updateVoltageLevelId) {
		this.updateVoltageLevelId = updateVoltageLevelId;
	}

	public String getAssetMainNumber() {
		return this.assetMainNumber;
	}

	public void setAssetMainNumber(String assetMainNumber) {
		this.assetMainNumber = assetMainNumber;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

}