package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractErp2anlaRecordSheet7 entity provides the base persistence definition
 * of the Erp2anlaRecordSheet7 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErp2anlaRecordSheet7 implements java.io.Serializable {

	// Fields

	private String erp2anlaRecordSheet7Id;
	private String version;
	private Date calYear;
	private String companyCode;
	private String assetId;
	private String equipmentId;
	private String secondaryCode;
	private String classifiedCode;
	private Date capitalizationDate;
	private Date unactivedDate;
	private String voltageLevelCode;
	private String assetState;
	private String isEscrow;
	private String manufacturer;
	private Double quantity;
	private String fixedAssetClass;
	private String dataSource;
	private String assetName;
	private String description2;
	private String wbsElement;

	// Constructors

	/** default constructor */
	public AbstractErp2anlaRecordSheet7() {
	}

	/** minimal constructor */
	public AbstractErp2anlaRecordSheet7(Date calYear) {
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractErp2anlaRecordSheet7(String version,Date calYear, String companyCode, String assetId, String equipmentId,
			String secondaryCode, String classifiedCode, Date capitalizationDate, Date unactivedDate,
			String voltageLevelCode, String assetState, String isEscrow, String manufacturer, Double quantity,
			String fixedAssetClass, String dataSource, String assetName, String description2, String wbsElement) {
		this.version = version;
		this.calYear = calYear;
		this.companyCode = companyCode;
		this.assetId = assetId;
		this.equipmentId = equipmentId;
		this.secondaryCode = secondaryCode;
		this.classifiedCode = classifiedCode;
		this.capitalizationDate = capitalizationDate;
		this.unactivedDate = unactivedDate;
		this.voltageLevelCode = voltageLevelCode;
		this.assetState = assetState;
		this.isEscrow = isEscrow;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.fixedAssetClass = fixedAssetClass;
		this.dataSource = dataSource;
		this.assetName = assetName;
		this.description2 = description2;
		this.wbsElement = wbsElement;
	}

	// Property accessors

	public String getErp2anlaRecordSheet7Id() {
		return this.erp2anlaRecordSheet7Id;
	}

	public void setErp2anlaRecordSheet7Id(String erp2anlaRecordSheet7Id) {
		this.erp2anlaRecordSheet7Id = erp2anlaRecordSheet7Id;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getSecondaryCode() {
		return this.secondaryCode;
	}

	public void setSecondaryCode(String secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

	public String getClassifiedCode() {
		return this.classifiedCode;
	}

	public void setClassifiedCode(String classifiedCode) {
		this.classifiedCode = classifiedCode;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public Date getUnactivedDate() {
		return this.unactivedDate;
	}

	public void setUnactivedDate(Date unactivedDate) {
		this.unactivedDate = unactivedDate;
	}

	public String getVoltageLevelCode() {
		return this.voltageLevelCode;
	}

	public void setVoltageLevelCode(String voltageLevelCode) {
		this.voltageLevelCode = voltageLevelCode;
	}

	public String getAssetState() {
		return this.assetState;
	}

	public void setAssetState(String assetState) {
		this.assetState = assetState;
	}

	public String getIsEscrow() {
		return this.isEscrow;
	}

	public void setIsEscrow(String isEscrow) {
		this.isEscrow = isEscrow;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getFixedAssetClass() {
		return this.fixedAssetClass;
	}

	public void setFixedAssetClass(String fixedAssetClass) {
		this.fixedAssetClass = fixedAssetClass;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getWbsElement() {
		return this.wbsElement;
	}

	public void setWbsElement(String wbsElement) {
		this.wbsElement = wbsElement;
	}

}