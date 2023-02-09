package com.yunhai.excel.orm;

/**
 * ErpPropertyRecord entity. @author MyEclipse Persistence Tools
 */
public class ErpPropertyRecord extends AbstractErpPropertyRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ErpPropertyRecord() {
	}

	/** full constructor */
	public ErpPropertyRecord(String equipmentId, String propertyCode, String propertyName) {
		super(equipmentId, propertyCode, propertyName);
	}

}
