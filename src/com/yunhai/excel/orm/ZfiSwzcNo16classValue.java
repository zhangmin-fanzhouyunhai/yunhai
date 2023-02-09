package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ZfiSwzcNo16classValue entity. @author MyEclipse Persistence Tools
 */
public class ZfiSwzcNo16classValue extends AbstractZfiSwzcNo16classValue implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ZfiSwzcNo16classValue() {
	}

	/** minimal constructor */
	public ZfiSwzcNo16classValue(String zfiSwzc16classValueId) {
		super(zfiSwzc16classValueId);
	}

	/** full constructor */
	public ZfiSwzcNo16classValue(String zfiSwzc16classValueId, String dataVersion, Date calYear,
			String assetMain, String equnr, Double zpmzcyz, Double zpmzcjz, String dataSourceFile) {
		super( zfiSwzc16classValueId,  dataVersion,  calYear,
				 assetMain,  equnr,  zpmzcyz,  zpmzcjz,  dataSourceFile);
	}

}
