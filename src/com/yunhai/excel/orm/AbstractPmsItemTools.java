package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractPmsItemTools entity provides the base persistence definition of the
 * PmsItemTools entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPmsItemTools implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3870437958098129894L;
	private String pmsItemToolsId;
	private Short calYear;
	private String version;
	private String sbbm;
	private String dwmx;
	private String ywdw;
	private String zckbm;
	private String sblx;
	private Double zcyz;
	private String zcdl;
	private String zclxbm;
	private String cwbm;
	private String dydj;
	private String yxzt;
	private String jkzt;
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
	private Short tynf;
	private String nnd;
	private Date tyrq;
	private Short nn;
	private String qfzd;
	private Date ccrq;
	private String equipmentName;
	private String assetId;
	private String equipmentIncreaseMode;
	private String lineProperty;
	private String dataSourceFile;

	// Constructors

	public String getLineProperty() {
		return lineProperty;
	}

	public void setLineProperty(String lineProperty) {
		this.lineProperty = lineProperty;
	}


	// Constructors

	/** default constructor */
	public AbstractPmsItemTools() {
	}

	/** minimal constructor */
	public AbstractPmsItemTools(Short calYear, String version) {
		this.calYear = calYear;
		this.version = version;
	}
	/** full constructor */
	public AbstractPmsItemTools(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq,
			 String equipmentName, String assetId, String equipmentIncreaseMode,String lineProperty, String dataSourceFile) {
		this.calYear = calYear;
		this.version = version;
		this.sbbm = sbbm;
		this.dwmx = dwmx;
		this.ywdw = ywdw;
		this.zckbm = zckbm;
		this.sblx = sblx;
		this.zcyz = zcyz;
		this.zcdl = zcdl;
		this.zclxbm = zclxbm;
		this.cwbm = cwbm;
		this.dydj = dydj;
		this.yxzt = yxzt;
		this.jkzt = jkzt;
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
		this.qfzd = qfzd;
		this.ccrq = ccrq;
		this.equipmentName = equipmentName;
		this.assetId = assetId;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.lineProperty=lineProperty;
		this.dataSourceFile = dataSourceFile;
	}
	/** full constructor */
	public AbstractPmsItemTools(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq,
			 String equipmentName, String assetId, String equipmentIncreaseMode, String dataSourceFile) {
		this.calYear = calYear;
		this.version = version;
		this.sbbm = sbbm;
		this.dwmx = dwmx;
		this.ywdw = ywdw;
		this.zckbm = zckbm;
		this.sblx = sblx;
		this.zcyz = zcyz;
		this.zcdl = zcdl;
		this.zclxbm = zclxbm;
		this.cwbm = cwbm;
		this.dydj = dydj;
		this.yxzt = yxzt;
		this.jkzt = jkzt;
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
		this.qfzd = qfzd;
		this.ccrq = ccrq;
		this.equipmentName = equipmentName;
		this.assetId = assetId;
		this.equipmentIncreaseMode = equipmentIncreaseMode;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getPmsItemToolsId() {
		return this.pmsItemToolsId;
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

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setPmsItemToolsId(String pmsItemToolsId) {
		this.pmsItemToolsId = pmsItemToolsId;
	}

	public Short getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Short calYear) {
		this.calYear = calYear;
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

	public String getDwmx() {
		return this.dwmx;
	}

	public void setDwmx(String dwmx) {
		this.dwmx = dwmx;
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

	public String getSblx() {
		return this.sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public Double getZcyz() {
		return this.zcyz;
	}

	public void setZcyz(Double zcyz) {
		this.zcyz = zcyz;
	}

	public String getZcdl() {
		return this.zcdl;
	}

	public void setZcdl(String zcdl) {
		this.zcdl = zcdl;
	}

	public String getZclxbm() {
		return this.zclxbm;
	}

	public void setZclxbm(String zclxbm) {
		this.zclxbm = zclxbm;
	}

	public String getCwbm() {
		return this.cwbm;
	}

	public void setCwbm(String cwbm) {
		this.cwbm = cwbm;
	}

	public String getDydj() {
		return this.dydj;
	}

	public void setDydj(String dydj) {
		this.dydj = dydj;
	}

	public String getYxzt() {
		return this.yxzt;
	}

	public void setYxzt(String yxzt) {
		this.yxzt = yxzt;
	}

	public String getJkzt() {
		return this.jkzt;
	}

	public void setJkzt(String jkzt) {
		this.jkzt = jkzt;
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

	public Short getTynf() {
		return this.tynf;
	}

	public void setTynf(Short tynf) {
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

	public Short getNn() {
		return this.nn;
	}

	public void setNn(Short nn) {
		this.nn = nn;
	}

	public String getQfzd() {
		return this.qfzd;
	}

	public void setQfzd(String qfzd) {
		this.qfzd = qfzd;
	}

	public Date getCcrq() {
		return this.ccrq;
	}

	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	} 

}