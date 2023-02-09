package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractZfiSwzc16classValue entity provides the base persistence definition
 * of the ZfiSwzc16classValue entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractZfiSwzc16classValue implements java.io.Serializable {

	// Fields

	private String zfiSwzc16classValueId;
	private String dataVersion;
	private Date calYear;
	private String assetMain;
	private String equnr;
	private Double zpmzcyz;
	private Double zpmzcjz;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractZfiSwzc16classValue() {
	}

	/** minimal constructor */
	public AbstractZfiSwzc16classValue(String zfiSwzc16classValueId) {
		this.zfiSwzc16classValueId = zfiSwzc16classValueId;
	}

	/** full constructor */
	public AbstractZfiSwzc16classValue(String zfiSwzc16classValueId, String dataVersion, java.util.Date calYear,
			String assetMain, String equnr, Double zpmzcyz, Double zpmzcjz, String dataSourceFile) {
		this.zfiSwzc16classValueId = zfiSwzc16classValueId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.assetMain = assetMain;
		this.equnr = equnr;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getZfiSwzc16classValueId() {
		return this.zfiSwzc16classValueId;
	}

	public void setZfiSwzc16classValueId(String zfiSwzc16classValueId) {
		this.zfiSwzc16classValueId = zfiSwzc16classValueId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public java.util.Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(java.util.Date calYear) {
		this.calYear = calYear;
	}

	public String getAssetMain() {
		return this.assetMain;
	}

	public void setAssetMain(String assetMain) {
		this.assetMain = assetMain;
	}

	public String getEqunr() {
		return this.equnr;
	}

	public void setEqunr(String equnr) {
		this.equnr = equnr;
	}

	public Double getZpmzcyz() {
		return this.zpmzcyz;
	}

	public void setZpmzcyz(Double zpmzcyz) {
		this.zpmzcyz = zpmzcyz;
	}

	public Double getZpmzcjz() {
		return this.zpmzcjz;
	}

	public void setZpmzcjz(Double zpmzcjz) {
		this.zpmzcjz = zpmzcjz;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}