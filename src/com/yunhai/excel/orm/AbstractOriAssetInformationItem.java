package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOriAssetInformationItem entity provides the base persistence
 * definition of the OriAssetInformationItem entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriAssetInformationItem implements java.io.Serializable {

	// Fields

	private String oriAssetInformationItemId;
	private String dataVersion;
	private Date calYear;
	private String orgCode;
	private String assetNumber;
	private String sno;
	private Date validDate;
	private String categoryCode;
	private Date capitalizationDate;
	private String voltageLevelCode;
	private String voltageLevelDescription;
	private Double quantity;
	private String typeNameCode;
	private String assetStatusCode;
	private String assetStatusDescription;
	private String assetDescription;
	private String belongLineStationName;
	private String costCenter;
	private String profitCenter;
	private String profitCenterDescription;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriAssetInformationItem() {
	}

	/** minimal constructor */
	public AbstractOriAssetInformationItem(String oriAssetInformationItemId) {
		this.oriAssetInformationItemId = oriAssetInformationItemId;
	}

	/** full constructor */
	public AbstractOriAssetInformationItem(String oriAssetInformationItemId, String dataVersion, Date calYear,
			String orgCode, String assetNumber, String sno, Date validDate, String categoryCode,
			Date capitalizationDate, String voltageLevelCode, String voltageLevelDescription, Double quantity,
			String typeNameCode, String assetStatusCode, String assetStatusDescription, String assetDescription,
			String belongLineStationName, String costCenter, String profitCenter, String profitCenterDescription,
			String dataSourceFile) {
		this.oriAssetInformationItemId = oriAssetInformationItemId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.orgCode = orgCode;
		this.assetNumber = assetNumber;
		this.sno = sno;
		this.validDate = validDate;
		this.categoryCode = categoryCode;
		this.capitalizationDate = capitalizationDate;
		this.voltageLevelCode = voltageLevelCode;
		this.voltageLevelDescription = voltageLevelDescription;
		this.quantity = quantity;
		this.typeNameCode = typeNameCode;
		this.assetStatusCode = assetStatusCode;
		this.assetStatusDescription = assetStatusDescription;
		this.assetDescription = assetDescription;
		this.belongLineStationName = belongLineStationName;
		this.costCenter = costCenter;
		this.profitCenter = profitCenter;
		this.profitCenterDescription = profitCenterDescription;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriAssetInformationItemId() {
		return this.oriAssetInformationItemId;
	}

	public void setOriAssetInformationItemId(String oriAssetInformationItemId) {
		this.oriAssetInformationItemId = oriAssetInformationItemId;
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

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public String getVoltageLevelCode() {
		return this.voltageLevelCode;
	}

	public void setVoltageLevelCode(String voltageLevelCode) {
		this.voltageLevelCode = voltageLevelCode;
	}

	public String getVoltageLevelDescription() {
		return this.voltageLevelDescription;
	}

	public void setVoltageLevelDescription(String voltageLevelDescription) {
		this.voltageLevelDescription = voltageLevelDescription;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getTypeNameCode() {
		return this.typeNameCode;
	}

	public void setTypeNameCode(String typeNameCode) {
		this.typeNameCode = typeNameCode;
	}

	public String getAssetStatusCode() {
		return this.assetStatusCode;
	}

	public void setAssetStatusCode(String assetStatusCode) {
		this.assetStatusCode = assetStatusCode;
	}

	public String getAssetStatusDescription() {
		return this.assetStatusDescription;
	}

	public void setAssetStatusDescription(String assetStatusDescription) {
		this.assetStatusDescription = assetStatusDescription;
	}

	public String getAssetDescription() {
		return this.assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getBelongLineStationName() {
		return this.belongLineStationName;
	}

	public void setBelongLineStationName(String belongLineStationName) {
		this.belongLineStationName = belongLineStationName;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getProfitCenter() {
		return this.profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getProfitCenterDescription() {
		return this.profitCenterDescription;
	}

	public void setProfitCenterDescription(String profitCenterDescription) {
		this.profitCenterDescription = profitCenterDescription;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}