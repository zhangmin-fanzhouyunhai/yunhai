package com.yunhai.excel.orm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * AbstractMidErpItemAssetWall entity provides the base persistence definition
 * of the MidErpItemAssetWall entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidErpItemAssetWall implements java.io.Serializable {

	// Fields

	private String midErpItemId;
	private String sbbm;
	private String gsdm;
	private String ssds;
	private String xgsdm;
	private String ssxj;
	private String sbmc;
	private String zyflbm;
	private String zyfl;
	private String typbz;
	private String typbzCode;
	private String sccj;
	private String sbxh;
	private String dydj;
	private Double yz;
	private Double jz;
	private String xlcd;
	private String byqrl;
	private Date tysj;
	private String sbzt;
	private Double sfylzc;
	private String swid;
	private Double zylzc;
	private Double cxl;
	private Double xzzc;
	private Double zlybz;
	private String eqart;

	// Constructors

	/** default constructor */
	public AbstractMidErpItemAssetWall() {
	}

	/** minimal constructor */
	public AbstractMidErpItemAssetWall(String midErpItemId) {
		this.midErpItemId = midErpItemId;
	}

	/** full constructor */
	public AbstractMidErpItemAssetWall(String midErpItemId, String sbbm, String gsdm, String ssds, String xgsdm,
			String ssxj, String sbmc, String zyflbm, String zyfl, String typbz, String typbzCode, String sccj,
			String sbxh, String dydj, Double yz, Double jz, String xlcd, String byqrl, Date tysj, String sbzt,
			Double sfylzc, String swid, Double zylzc, Double cxl, Double xzzc, Double zlybz, String eqart) {
		this.midErpItemId = midErpItemId;
		this.sbbm = sbbm;
		this.gsdm = gsdm;
		this.ssds = ssds;
		this.xgsdm = xgsdm;
		this.ssxj = ssxj;
		this.sbmc = sbmc;
		this.zyflbm = zyflbm;
		this.zyfl = zyfl;
		this.typbz = typbz;
		this.typbzCode = typbzCode;
		this.sccj = sccj;
		this.sbxh = sbxh;
		this.dydj = dydj;
		this.yz = yz;
		this.jz = jz;
		this.xlcd = xlcd;
		this.byqrl = byqrl;
		this.tysj = tysj;
		this.sbzt = sbzt;
		this.sfylzc = sfylzc;
		this.swid = swid;
		this.zylzc = zylzc;
		this.cxl = cxl;
		this.xzzc = xzzc;
		this.zlybz = zlybz;
		this.eqart = eqart;
	}

	// Property accessors

	public String getMidErpItemId() {
		return this.midErpItemId;
	}

	@JSONField(name="MID_ERP_ITEM_ID")
	public void setMidErpItemId(String midErpItemId) {
		this.midErpItemId = midErpItemId;
	}

	public String getSbbm() {
		return this.sbbm;
	}

	@JSONField(name="SBBM")
	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public String getGsdm() {
		return this.gsdm;
	}

	@JSONField(name="GSDM")
	public void setGsdm(String gsdm) {
		this.gsdm = gsdm;
	}

	public String getSsds() {
		return this.ssds;
	}

	@JSONField(name="SSDS")
	public void setSsds(String ssds) {
		this.ssds = ssds;
	}

	public String getXgsdm() {
		return this.xgsdm;
	}

	@JSONField(name="XGSDM")
	public void setXgsdm(String xgsdm) {
		this.xgsdm = xgsdm;
	}

	public String getSsxj() {
		return this.ssxj;
	}

	@JSONField(name="SSXJ")
	public void setSsxj(String ssxj) {
		this.ssxj = ssxj;
	}

	public String getSbmc() {
		return this.sbmc;
	}

	@JSONField(name="SBMC")
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getZyflbm() {
		return this.zyflbm;
	}

	@JSONField(name="ZYFLBM")
	public void setZyflbm(String zyflbm) {
		this.zyflbm = zyflbm;
	}

	public String getZyfl() {
		return this.zyfl;
	}

	@JSONField(name="ZYFL")
	public void setZyfl(String zyfl) {
		this.zyfl = zyfl;
	}

	public String getTypbz() {
		return this.typbz;
	}

	@JSONField(name="TYPBZ")
	public void setTypbz(String typbz) {
		this.typbz = typbz;
	}

	public String getTypbzCode() {
		return this.typbzCode;
	}

	@JSONField(name="TYPBZ_CODE")
	public void setTypbzCode(String typbzCode) {
		this.typbzCode = typbzCode;
	}

	public String getSccj() {
		return this.sccj;
	}

	@JSONField(name="SCCJ")
	public void setSccj(String sccj) {
		this.sccj = sccj;
	}

	public String getSbxh() {
		return this.sbxh;
	}

	@JSONField(name="SBXH")
	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	public String getDydj() {
		return this.dydj;
	}

	@JSONField(name="DYDJ")
	public void setDydj(String dydj) {
		this.dydj = dydj;
	}

	public Double getYz() {
		return this.yz;
	}

	@JSONField(name="YZ")
	public void setYz(Double yz) {
		this.yz = yz;
	}

	public Double getJz() {
		return this.jz;
	}

	@JSONField(name="JZ")
	public void setJz(Double jz) {
		this.jz = jz;
	}

	public String getXlcd() {
		return this.xlcd;
	}

	@JSONField(name="XLCD")
	public void setXlcd(String xlcd) {
		this.xlcd = xlcd;
	}

	public String getByqrl() {
		return this.byqrl;
	}

	@JSONField(name="BYQRL")
	public void setByqrl(String byqrl) {
		this.byqrl = byqrl;
	}

	public Date getTysj() {
		return this.tysj;
	}

	@JSONField(name="TYSJ")
	public void setTysj(Date tysj) {
		this.tysj = tysj;
	}

	public String getSbzt() {
		return this.sbzt;
	}

	@JSONField(name="SBZT")
	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}

	public Double getSfylzc() {
		return this.sfylzc;
	}

	@JSONField(name="SFYLZC")
	public void setSfylzc(Double sfylzc) {
		this.sfylzc = sfylzc;
	}

	public String getSwid() {
		return this.swid;
	}

	@JSONField(name="SWID")
	public void setSwid(String swid) {
		this.swid = swid;
	}

	public Double getZylzc() {
		return this.zylzc;
	}

	@JSONField(name="ZYLZC")
	public void setZylzc(Double zylzc) {
		this.zylzc = zylzc;
	}

	public Double getCxl() {
		return this.cxl;
	}

	@JSONField(name="CXL")
	public void setCxl(Double cxl) {
		this.cxl = cxl;
	}

	public Double getXzzc() {
		return this.xzzc;
	}

	@JSONField(name="XZZC")
	public void setXzzc(Double xzzc) {
		this.xzzc = xzzc;
	}

	public Double getZlybz() {
		return this.zlybz;
	}

	@JSONField(name="ZLYBZ")
	public void setZlybz(Double zlybz) {
		this.zlybz = zlybz;
	}

	public String getEqart() {
		return this.eqart;
	}

	@JSONField(name="EQART")
	public void setEqart(String eqart) {
		this.eqart = eqart;
	}

}