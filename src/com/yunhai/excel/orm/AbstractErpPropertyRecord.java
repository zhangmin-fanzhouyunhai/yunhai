package com.yunhai.excel.orm;

/**
 * AbstractErpPropertyRecord entity provides the base persistence definition of
 * the ErpPropertyRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpPropertyRecord implements java.io.Serializable {

	// Fields

	private String indexId;
	private String equipmentId;
	private String propertyCode;
	private String propertyName;

	// Constructors

	/** default constructor */
	public AbstractErpPropertyRecord() {
	}

	/** full constructor */
	public AbstractErpPropertyRecord(String equipmentId, String propertyCode, String propertyName) {
		this.equipmentId = equipmentId;
		this.propertyCode = propertyCode;
		this.propertyName = propertyName;
	}

	// Property accessors

	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}