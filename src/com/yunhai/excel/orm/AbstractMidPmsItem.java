package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidPmsItem entity provides the base persistence definition of the
 * MidPmsItem entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidPmsItem implements java.io.Serializable {

	// Fields

	private String midPmsItemId;
	private String version;
	private String sbbm;
	private String orgName;
	private String dvPmsAssetClassId;
	private String zcDl;
	private String zcZl;
	private String zcXl;
	private String voltageLevel;
	private Date calYear;
	private String qfzd;
	private String jkzt;
	private String yxzt;
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
	private String isMatched;
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
	
	
	
	// Constructors

	/** default constructor */
	public AbstractMidPmsItem() {
	}

	/** minimal constructor */
	public AbstractMidPmsItem(String midPmsItemId, String version, String sbbm, String orgName, String zcDl) {
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.sbbm = sbbm;
		this.orgName = orgName;
		this.zcDl = zcDl;
	}

	/** full constructor */
	
	
	
	
	public AbstractMidPmsItem(String midPmsItemId, String version, String sbbm, String orgName,
			String dvPmsAssetClassId, String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear,
			String qfzd, String jkzt, String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz,
			Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh,
			Integer tynf, String nnd, Date tyrq, Integer nn, Date ccrq, String isMatched
			) {
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.sbbm = sbbm;
		this.orgName = orgName;
		this.dvPmsAssetClassId = dvPmsAssetClassId;
		this.zcDl = zcDl;
		this.zcZl = zcZl;
		this.zcXl = zcXl;
		this.voltageLevel = voltageLevel;
		this.calYear = calYear;
		this.qfzd = qfzd;
		this.jkzt = jkzt;
		this.yxzt = yxzt;
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
		this.isMatched = isMatched;
	}
	/**
	 * 2020-07-21
	 * @param midPmsItemId
	 * @param version
	 * @param sbbm
	 * @param orgName
	 * @param dvPmsAssetClassId
	 * @param zcDl
	 * @param zcZl
	 * @param zcXl
	 * @param voltageLevel
	 * @param calYear
	 * @param qfzd
	 * @param jkzt
	 * @param yxzt
	 * @param ywdw
	 * @param zckbm
	 * @param zcyz
	 * @param zjtyrq
	 * @param zcxz
	 * @param sl
	 * @param sl1
	 * @param sl2
	 * @param sl3
	 * @param jldw
	 * @param zzsmc
	 * @param ssxlbdz
	 * @param sbxh
	 * @param tynf
	 * @param nnd
	 * @param tyrq
	 * @param nn
	 * @param ccrq
	 * @param isMatched
	 * @param equipmentName
	 * @param assetId
	 * @param equipmentIncreaseMode
	 * @param lineProperty
	 * @param zcdl2
	 * @param sblx
	 * @param dvDateValue
	 * @param slOld
	 * @param oldVoltageLevel2
	 * @param oldZcxz
	 * @param discription
	 * @param oldYxzt
	 * @param oldTyrq
	 * @param oldCcrq
	 */
	public AbstractMidPmsItem(String midPmsItemId, String version, String sbbm, String orgName,
			String dvPmsAssetClassId, String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear,
			String qfzd, String jkzt, String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz,
			Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh,
			Integer tynf, String nnd, Date tyrq, Integer nn, Date ccrq, String isMatched, String equipmentName,
			String assetId, String equipmentIncreaseMode, String lineProperty, String zcdl2, String sblx,
			Date dvDateValue, Double slOld, String oldVoltageLevel2, String oldZcxz, String discription, String oldYxzt,
			Date oldTyrq, Date oldCcrq) {
		super();
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.sbbm = sbbm;
		this.orgName = orgName;
		this.dvPmsAssetClassId = dvPmsAssetClassId;
		this.zcDl = zcDl;
		this.zcZl = zcZl;
		this.zcXl = zcXl;
		this.voltageLevel = voltageLevel;
		this.calYear = calYear;
		this.qfzd = qfzd;
		this.jkzt = jkzt;
		this.yxzt = yxzt;
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
		this.isMatched = isMatched;
		this.equipmentName = equipmentName;
		this.assetId = assetId;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.lineProperty = lineProperty;
		zcdl = zcdl2;
		this.sblx = sblx;
		this.dvDateValue = dvDateValue;
		this.slOld = slOld;
		this.oldVoltageLevel2 = oldVoltageLevel2;
		this.oldZcxz = oldZcxz;
		this.discription = discription;
		this.oldYxzt = oldYxzt;
		this.oldTyrq = oldTyrq;
		this.oldCcrq = oldCcrq;
	}

	/** full constructor 20200527*/
	public AbstractMidPmsItem(String midPmsItemId, String version, String sbbm, String orgName,
			String dvPmsAssetClassId, String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear,
			String qfzd, String jkzt, String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz,
			Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh,
			Integer tynf, String nnd, Date tyrq, Integer nn, Date ccrq, String isMatched, String equipmentName, String assetId, String equipmentIncreaseMode, 
			String lineProperty, String zcdl, String sblx
			, Date dvDateValue) {
		this.midPmsItemId = midPmsItemId;
		this.version = version;
		this.sbbm = sbbm;
		this.orgName = orgName;
		this.dvPmsAssetClassId = dvPmsAssetClassId;
		this.zcDl = zcDl;
		this.zcZl = zcZl;
		this.zcXl = zcXl;
		this.voltageLevel = voltageLevel;
		this.calYear = calYear;
		this.qfzd = qfzd;
		this.jkzt = jkzt;
		this.yxzt = yxzt;
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
		this.isMatched = isMatched;
		this.equipmentName = equipmentName;
		this.assetId = assetId;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.lineProperty = lineProperty;
		this.zcdl = zcdl;
		this.sblx = sblx;
		this.dvDateValue = dvDateValue; 
		
	}
	// Property accessors

	public String getMidPmsItemId() {
		return this.midPmsItemId;
	}

	public Double getSlOld() {
		return slOld;
	}

	public void setSlOld(Double slOld) {
		this.slOld = slOld;
	}

	public String getOldVoltageLevel2() {
		return oldVoltageLevel2;
	}

	public void setOldVoltageLevel2(String oldVoltageLevel2) {
		this.oldVoltageLevel2 = oldVoltageLevel2;
	}

	public String getOldZcxz() {
		return oldZcxz;
	}

	public void setOldZcxz(String oldZcxz) {
		this.oldZcxz = oldZcxz;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getOldYxzt() {
		return oldYxzt;
	}

	public void setOldYxzt(String oldYxzt) {
		this.oldYxzt = oldYxzt;
	}

	public Date getOldTyrq() {
		return oldTyrq;
	}

	public void setOldTyrq(Date oldTyrq) {
		this.oldTyrq = oldTyrq;
	}

	public Date getOldCcrq() {
		return oldCcrq;
	}

	public void setOldCcrq(Date oldCcrq) {
		this.oldCcrq = oldCcrq;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getEquipmentIncreaseMode() {
		return equipmentIncreaseMode;
	}

	public void setEquipmentIncreaseMode(String equipmentIncreaseMode) {
		this.equipmentIncreaseMode = equipmentIncreaseMode;
	}

	public String getLineProperty() {
		return lineProperty;
	}

	public void setLineProperty(String lineProperty) {
		this.lineProperty = lineProperty;
	}

	public String getZcdl() {
		return zcdl;
	}

	public void setZcdl(String zcdl) {
		this.zcdl = zcdl;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public Date getDvDateValue() {
		return dvDateValue;
	}

	public void setDvDateValue(Date dvDateValue) {
		this.dvDateValue = dvDateValue;
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

	public String getDvPmsAssetClassId() {
		return this.dvPmsAssetClassId;
	}

	public void setDvPmsAssetClassId(String dvPmsAssetClassId) {
		this.dvPmsAssetClassId = dvPmsAssetClassId;
	}

	public String getZcDl() {
		return this.zcDl;
	}

	public void setZcDl(String zcDl) {
		this.zcDl = zcDl;
	}

	public String getZcZl() {
		return this.zcZl;
	}

	public void setZcZl(String zcZl) {
		this.zcZl = zcZl;
	}

	public String getZcXl() {
		return this.zcXl;
	}

	public void setZcXl(String zcXl) {
		this.zcXl = zcXl;
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

	public String getYxzt() {
		return this.yxzt;
	}

	public void setYxzt(String yxzt) {
		this.yxzt = yxzt;
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

	public String getIsMatched() {
		return this.isMatched;
	}

	public void setIsMatched(String isMatched) {
		this.isMatched = isMatched;
	}

}