package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidPmsItemOldAge1992 entity provides the base persistence definition
 * of the MidPmsItemOldAge1992 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidPmsItemOldAge1992 implements java.io.Serializable {

	// Fields

	private String midPmsItemId;
	private String version;
	private String sbbm;
	private String orgName;
	private String orgCode;
	private String largeClass;
	private String mediumClass;
	private String smallClass;
	private String voltageLevel;
	private Date calYear;
	private Double assetCapacity;
	private Double assetAmount;
	private String yxzt;
	private String qfzd;
	private String jkzt;
	private String ywdw;
	private String zckbm;
	private Double zcyz;
	private Date zjtyrq;
	private String zcxz;
	private Double sl;
	private Double sl1;
	private Double sl2;
	private Double sl3;
	private String jldw;
	private String zzsmc;
	private String ssxlbdz;
	private String sbxh;
	private Integer tynf;
	private String nnd;
	private Date tyrq;
	private Integer nn;
	private Date ccrq;
	private String equipmentName;
	private String assetId;
	private String equipmentIncreaseMode;
	private String lineProperty;
	private String zcdl;
	private String sblx;
	private Date dvDateValue;
	private Double slOld;
	private String oldVoltageLevel2;
	private String oldZcxz;
	private String discription;
	private String oldYxzt;
	private Date oldTyrq;
	private Date oldCcrq;
	private String usingStatusCode;
	private Integer groupStatus;
	private Date dvDataValue;
	private String category;

	// Constructors

	/** default constructor */
	public AbstractMidPmsItemOldAge1992() {
	}

	/** minimal constructor */
	public AbstractMidPmsItemOldAge1992(String midPmsItemId, String version, String largeClass, String yxzt) {
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.largeClass = largeClass;
		this.yxzt = yxzt;
	}

	/** full constructor */
	public AbstractMidPmsItemOldAge1992(String midPmsItemId, String version, String sbbm, String orgName,
			String orgCode, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Date calYear, Double assetCapacity, Double assetAmount, String yxzt, String qfzd, String jkzt,
			String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2,
			Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh, Integer tynf, String nnd,
			Date tyrq, Integer nn, Date ccrq, String equipmentName, String assetId,
			String equipmentIncreaseMode, String lineProperty, String zcdl, String sblx, Date dvDateValue,
			Double slOld, String oldVoltageLevel2, String oldZcxz, String discription, String oldYxzt,
			Date oldTyrq, Date oldCcrq, String usingStatusCode, Integer groupStatus, Date dvDataValue,
			String category) {
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.sbbm = sbbm;
		this.orgName = orgName;
		this.orgCode = orgCode;
		this.largeClass = largeClass;
		this.mediumClass = mediumClass;
		this.smallClass = smallClass;
		this.voltageLevel = voltageLevel;
		this.calYear = calYear;
		this.assetCapacity = assetCapacity;
		this.assetAmount = assetAmount;
		this.yxzt = yxzt;
		this.qfzd = qfzd;
		this.jkzt = jkzt;
		this.ywdw = ywdw;
		this.zckbm = zckbm;
		this.zcyz = zcyz;
		this.zjtyrq = zjtyrq;
		this.zcxz = zcxz;
		this.sl = sl;
		this.sl1 = sl1;
		this.sl2 = sl2;
		this.sl3 = sl3;
		this.jldw = jldw;
		this.zzsmc = zzsmc;
		this.ssxlbdz = ssxlbdz;
		this.sbxh = sbxh;
		this.tynf = tynf;
		this.nnd = nnd;
		this.tyrq = tyrq;
		this.nn = nn;
		this.ccrq = ccrq;
		this.equipmentName = equipmentName;
		this.assetId = assetId;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.lineProperty = lineProperty;
		this.zcdl = zcdl;
		this.sblx = sblx;
		this.dvDateValue = dvDateValue;
		this.slOld = slOld;
		this.oldVoltageLevel2 = oldVoltageLevel2;
		this.oldZcxz = oldZcxz;
		this.discription = discription;
		this.oldYxzt = oldYxzt;
		this.oldTyrq = oldTyrq;
		this.oldCcrq = oldCcrq;
		this.usingStatusCode = usingStatusCode;
		this.groupStatus = groupStatus;
		this.dvDataValue = dvDataValue;
		this.category = category;
	}

	// Property accessors

	public String getMidPmsItemId() {
		return this.midPmsItemId;
	}

	public void setMidPmsItemId(String midPmsItemId) {
		this.midPmsItemId = midPmsItemId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSbbm() {
		return this.sbbm;
	}

	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getLargeClass() {
		return this.largeClass;
	}

	public void setLargeClass(String largeClass) {
		this.largeClass = largeClass;
	}

	public String getMediumClass() {
		return this.mediumClass;
	}

	public void setMediumClass(String mediumClass) {
		this.mediumClass = mediumClass;
	}

	public String getSmallClass() {
		return this.smallClass;
	}

	public void setSmallClass(String smallClass) {
		this.smallClass = smallClass;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public Double getAssetCapacity() {
		return this.assetCapacity;
	}

	public void setAssetCapacity(Double assetCapacity) {
		this.assetCapacity = assetCapacity;
	}

	public Double getAssetAmount() {
		return this.assetAmount;
	}

	public void setAssetAmount(Double assetAmount) {
		this.assetAmount = assetAmount;
	}

	public String getYxzt() {
		return this.yxzt;
	}

	public void setYxzt(String yxzt) {
		this.yxzt = yxzt;
	}

	public String getQfzd() {
		return this.qfzd;
	}

	public void setQfzd(String qfzd) {
		this.qfzd = qfzd;
	}

	public String getJkzt() {
		return this.jkzt;
	}

	public void setJkzt(String jkzt) {
		this.jkzt = jkzt;
	}

	public String getYwdw() {
		return this.ywdw;
	}

	public void setYwdw(String ywdw) {
		this.ywdw = ywdw;
	}

	public String getZckbm() {
		return this.zckbm;
	}

	public void setZckbm(String zckbm) {
		this.zckbm = zckbm;
	}

	public Double getZcyz() {
		return this.zcyz;
	}

	public void setZcyz(Double zcyz) {
		this.zcyz = zcyz;
	}

	public Date getZjtyrq() {
		return this.zjtyrq;
	}

	public void setZjtyrq(Date zjtyrq) {
		this.zjtyrq = zjtyrq;
	}

	public String getZcxz() {
		return this.zcxz;
	}

	public void setZcxz(String zcxz) {
		this.zcxz = zcxz;
	}

	public Double getSl() {
		return this.sl;
	}

	public void setSl(Double sl) {
		this.sl = sl;
	}

	public Double getSl1() {
		return this.sl1;
	}

	public void setSl1(Double sl1) {
		this.sl1 = sl1;
	}

	public Double getSl2() {
		return this.sl2;
	}

	public void setSl2(Double sl2) {
		this.sl2 = sl2;
	}

	public Double getSl3() {
		return this.sl3;
	}

	public void setSl3(Double sl3) {
		this.sl3 = sl3;
	}

	public String getJldw() {
		return this.jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public String getZzsmc() {
		return this.zzsmc;
	}

	public void setZzsmc(String zzsmc) {
		this.zzsmc = zzsmc;
	}

	public String getSsxlbdz() {
		return this.ssxlbdz;
	}

	public void setSsxlbdz(String ssxlbdz) {
		this.ssxlbdz = ssxlbdz;
	}

	public String getSbxh() {
		return this.sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	public Integer getTynf() {
		return this.tynf;
	}

	public void setTynf(Integer tynf) {
		this.tynf = tynf;
	}

	public String getNnd() {
		return this.nnd;
	}

	public void setNnd(String nnd) {
		this.nnd = nnd;
	}

	public Date getTyrq() {
		return this.tyrq;
	}

	public void setTyrq(Date tyrq) {
		this.tyrq = tyrq;
	}

	public Integer getNn() {
		return this.nn;
	}

	public void setNn(Integer nn) {
		this.nn = nn;
	}

	public Date getCcrq() {
		return this.ccrq;
	}

	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getEquipmentIncreaseMode() {
		return this.equipmentIncreaseMode;
	}

	public void setEquipmentIncreaseMode(String equipmentIncreaseMode) {
		this.equipmentIncreaseMode = equipmentIncreaseMode;
	}

	public String getLineProperty() {
		return this.lineProperty;
	}

	public void setLineProperty(String lineProperty) {
		this.lineProperty = lineProperty;
	}

	public String getZcdl() {
		return this.zcdl;
	}

	public void setZcdl(String zcdl) {
		this.zcdl = zcdl;
	}

	public String getSblx() {
		return this.sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public Date getDvDateValue() {
		return this.dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
	}

	public Double getSlOld() {
		return this.slOld;
	}

	public void setSlOld(Double slOld) {
		this.slOld = slOld;
	}

	public String getOldVoltageLevel2() {
		return this.oldVoltageLevel2;
	}

	public void setOldVoltageLevel2(String oldVoltageLevel2) {
		this.oldVoltageLevel2 = oldVoltageLevel2;
	}

	public String getOldZcxz() {
		return this.oldZcxz;
	}

	public void setOldZcxz(String oldZcxz) {
		this.oldZcxz = oldZcxz;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getOldYxzt() {
		return this.oldYxzt;
	}

	public void setOldYxzt(String oldYxzt) {
		this.oldYxzt = oldYxzt;
	}

	public Date getOldTyrq() {
		return this.oldTyrq;
	}

	public void setOldTyrq(Date oldTyrq) {
		this.oldTyrq = oldTyrq;
	}

	public Date getOldCcrq() {
		return this.oldCcrq;
	}

	public void setOldCcrq(Date oldCcrq) {
		this.oldCcrq = oldCcrq;
	}

	public String getUsingStatusCode() {
		return this.usingStatusCode;
	}

	public void setUsingStatusCode(String usingStatusCode) {
		this.usingStatusCode = usingStatusCode;
	}

	public Integer getGroupStatus() {
		return this.groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}

	public Date getDvDataValue() {
		return this.dvDataValue;
	}

	public void setDvDataValue(Date dvDataValue) {
		this.dvDataValue = dvDataValue;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}