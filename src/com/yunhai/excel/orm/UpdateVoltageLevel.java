package com.yunhai.excel.orm;

/**
 * UpdateVoltageLevel entity. @author MyEclipse Persistence Tools
 */
public class UpdateVoltageLevel extends AbstractUpdateVoltageLevel implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UpdateVoltageLevel() {
	}

	/** full constructor */
	public UpdateVoltageLevel(String assetMainNumber, String voltageLevel) {
		super(assetMainNumber, voltageLevel);
	}

}
