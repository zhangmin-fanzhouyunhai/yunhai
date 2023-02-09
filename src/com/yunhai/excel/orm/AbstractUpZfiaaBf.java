package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractUpZfiaaBf entity provides the base persistence definition of the
 * UpZfiaaBf entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUpZfiaaBf implements java.io.Serializable {

	// Fields

	private String upZfiaaBfId;
	private Integer calYear;
	private String version;
	private String compCode;
	private String assetMain;
	private String asset;
	private String zzcms;
	private String calyear;
	private String profitCtr;
	private String zlrzx;
	private String ztypbz1;
	private String ztypbz2;
	private String ztypbz3;
	private String zioZxmlx;
	private String zioZusye;
	private String zvolLev;
	private String coArea;
	private String unit;
	private String zbfyy;
	private String currency;
	private String recordmode;
	private Double zpmzcjz;
	private Double zpmzcyz;
	private Double zquantity;
	private String fixedAssetClassificateCode;
	private String fixedAssetClassifDescript;
	private String increasedProjectType;
	private Date discardBookDate;
	private Date capitalizationDate;
	private String discardType;
	private String dataSourceFile;
	private String areaName;
	private String resume;
	private String textDescription;
	private Date inactiveDate;
	
	// Constructors

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	/** default constructor */
	public AbstractUpZfiaaBf() {
	}

	/** minimal constructor */
	public AbstractUpZfiaaBf(String upZfiaaBfId, Integer calYear, String version, String assetMain) {
		this.upZfiaaBfId = upZfiaaBfId;
		this.calYear = calYear;
		this.version = version;
		this.assetMain = assetMain;
	}

	/** full constructor */
	public AbstractUpZfiaaBf(String upZfiaaBfId, Integer calYear, String version, String compCode, String assetMain,
			String asset, String zzcms, String calyear, String profitCtr, String zlrzx, String ztypbz1, String ztypbz2,
			String ztypbz3, String zioZxmlx, String zioZusye, String zvolLev, String coArea, String unit, String zbfyy,
			String currency, String recordmode, Double zpmzcjz, Double zpmzcyz, Double zquantity,
			String fixedAssetClassificateCode, String fixedAssetClassifDescript, String increasedProjectType,
			Date discardBookDate, Date capitalizationDate, String discardType, String dataSourceFile) {
		this.upZfiaaBfId = upZfiaaBfId;
		this.calYear = calYear;
		this.version = version;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.zzcms = zzcms;
		this.calyear = calyear;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zioZxmlx = zioZxmlx;
		this.zioZusye = zioZusye;
		this.zvolLev = zvolLev;
		this.coArea = coArea;
		this.unit = unit;
		this.zbfyy = zbfyy;
		this.currency = currency;
		this.recordmode = recordmode;
		this.zpmzcjz = zpmzcjz;
		this.zpmzcyz = zpmzcyz;
		this.zquantity = zquantity;
		this.fixedAssetClassificateCode = fixedAssetClassificateCode;
		this.fixedAssetClassifDescript = fixedAssetClassifDescript;
		this.increasedProjectType = increasedProjectType;
		this.discardBookDate = discardBookDate;
		this.capitalizationDate = capitalizationDate;
		this.discardType = discardType;
		this.dataSourceFile = dataSourceFile;
	}
	/** full constructor */
	public AbstractUpZfiaaBf(String upZfiaaBfId, Integer calYear, String version, String compCode, String assetMain,
			String asset, String zzcms, String calyear, String profitCtr, String zlrzx, String ztypbz1, String ztypbz2,
			String ztypbz3, String zioZxmlx, String zioZusye, String zvolLev, String coArea, String unit, String zbfyy,
			String currency, String recordmode, Double zpmzcjz, Double zpmzcyz, Double zquantity,
			String fixedAssetClassificateCode, String fixedAssetClassifDescript, String increasedProjectType,
			Date discardBookDate, Date capitalizationDate, String discardType, String dataSourceFile, String areaName,
			String resume, String textDescription,Date inactiveDate) {
		this.upZfiaaBfId = upZfiaaBfId;
		this.areaName = areaName;
		this.resume = resume;
		this.textDescription = textDescription;

		this.calYear = calYear;
		this.version = version;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.zzcms = zzcms;
		this.calyear = calyear;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zioZxmlx = zioZxmlx;
		this.zioZusye = zioZusye;
		this.zvolLev = zvolLev;
		this.coArea = coArea;
		this.unit = unit;
		this.zbfyy = zbfyy;
		this.currency = currency;
		this.recordmode = recordmode;
		this.zpmzcjz = zpmzcjz;
		this.zpmzcyz = zpmzcyz;
		this.zquantity = zquantity;
		this.fixedAssetClassificateCode = fixedAssetClassificateCode;
		this.fixedAssetClassifDescript = fixedAssetClassifDescript;
		this.increasedProjectType = increasedProjectType;
		this.discardBookDate = discardBookDate;
		this.capitalizationDate = capitalizationDate;
		this.discardType = discardType;
		this.inactiveDate=inactiveDate;
		this.dataSourceFile = dataSourceFile;
	}


	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	// Property accessors

	public String getUpZfiaaBfId() {
		return this.upZfiaaBfId;
	}

	public void setUpZfiaaBfId(String upZfiaaBfId) {
		this.upZfiaaBfId = upZfiaaBfId;
	}

	public Integer getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getAssetMain() {
		return this.assetMain;
	}

	public void setAssetMain(String assetMain) {
		this.assetMain = assetMain;
	}

	public String getAsset() {
		return this.asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getZzcms() {
		return this.zzcms;
	}

	public void setZzcms(String zzcms) {
		this.zzcms = zzcms;
	}

	public String getCalyear() {
		return this.calyear;
	}

	public void setCalyear(String calyear) {
		this.calyear = calyear;
	}

	public String getProfitCtr() {
		return this.profitCtr;
	}

	public void setProfitCtr(String profitCtr) {
		this.profitCtr = profitCtr;
	}

	public String getZlrzx() {
		return this.zlrzx;
	}

	public void setZlrzx(String zlrzx) {
		this.zlrzx = zlrzx;
	}

	public String getZtypbz1() {
		return this.ztypbz1;
	}

	public void setZtypbz1(String ztypbz1) {
		this.ztypbz1 = ztypbz1;
	}

	public String getZtypbz2() {
		return this.ztypbz2;
	}

	public void setZtypbz2(String ztypbz2) {
		this.ztypbz2 = ztypbz2;
	}

	public String getZtypbz3() {
		return this.ztypbz3;
	}

	public void setZtypbz3(String ztypbz3) {
		this.ztypbz3 = ztypbz3;
	}

	public String getZioZxmlx() {
		return this.zioZxmlx;
	}

	public void setZioZxmlx(String zioZxmlx) {
		this.zioZxmlx = zioZxmlx;
	}

	public String getZioZusye() {
		return this.zioZusye;
	}

	public void setZioZusye(String zioZusye) {
		this.zioZusye = zioZusye;
	}

	public String getZvolLev() {
		return this.zvolLev;
	}

	public void setZvolLev(String zvolLev) {
		this.zvolLev = zvolLev;
	}

	public String getCoArea() {
		return this.coArea;
	}

	public void setCoArea(String coArea) {
		this.coArea = coArea;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getZbfyy() {
		return this.zbfyy;
	}

	public void setZbfyy(String zbfyy) {
		this.zbfyy = zbfyy;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRecordmode() {
		return this.recordmode;
	}

	public void setRecordmode(String recordmode) {
		this.recordmode = recordmode;
	}

	public Double getZpmzcjz() {
		return this.zpmzcjz;
	}

	public void setZpmzcjz(Double zpmzcjz) {
		this.zpmzcjz = zpmzcjz;
	}

	public Double getZpmzcyz() {
		return this.zpmzcyz;
	}

	public void setZpmzcyz(Double zpmzcyz) {
		this.zpmzcyz = zpmzcyz;
	}

	public Double getZquantity() {
		return this.zquantity;
	}

	public void setZquantity(Double zquantity) {
		this.zquantity = zquantity;
	}

	public String getFixedAssetClassificateCode() {
		return this.fixedAssetClassificateCode;
	}

	public void setFixedAssetClassificateCode(String fixedAssetClassificateCode) {
		this.fixedAssetClassificateCode = fixedAssetClassificateCode;
	}

	public String getFixedAssetClassifDescript() {
		return this.fixedAssetClassifDescript;
	}

	public void setFixedAssetClassifDescript(String fixedAssetClassifDescript) {
		this.fixedAssetClassifDescript = fixedAssetClassifDescript;
	}

	public String getIncreasedProjectType() {
		return this.increasedProjectType;
	}

	public void setIncreasedProjectType(String increasedProjectType) {
		this.increasedProjectType = increasedProjectType;
	}

	public Date getDiscardBookDate() {
		return this.discardBookDate;
	}

	public void setDiscardBookDate(Date discardBookDate) {
		this.discardBookDate = discardBookDate;
	}

	public Date getCapitalizationDate() {
		return this.capitalizationDate;
	}

	public void setCapitalizationDate(Date capitalizationDate) {
		this.capitalizationDate = capitalizationDate;
	}

	public String getDiscardType() {
		return this.discardType;
	}

	public void setDiscardType(String discardType) {
		this.discardType = discardType;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}