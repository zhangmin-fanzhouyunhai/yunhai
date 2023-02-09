package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ZfiSwzc16classValue entity. @author MyEclipse Persistence Tools
 */
public class ZfiSwzc16classValue extends AbstractZfiSwzc16classValue implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ZfiSwzc16classValue() {
	}

	/** minimal constructor */
	public ZfiSwzc16classValue(String zfiSwzc16classValueId) {
		super(zfiSwzc16classValueId);
	}

	/** full constructor */
	public ZfiSwzc16classValue(String zfiSwzc16classValueId, String dataVersion, Date calYear, String assetMain,
			String equnr, Double zpmzcyz, Double zpmzcjz, String dataSourceFile) {
		super(zfiSwzc16classValueId, dataVersion, calYear, assetMain, equnr, zpmzcyz, zpmzcjz, dataSourceFile);
	}

}
