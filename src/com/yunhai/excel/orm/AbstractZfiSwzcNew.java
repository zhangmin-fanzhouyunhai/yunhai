package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractZfiSwzcNew entity provides the base persistence definition of the
 * ZfiSwzcNew entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractZfiSwzcNew implements java.io.Serializable {

	// Fields

	private String zfiSwzcNewId;
	private String version;
	private Date calYear;
	private Short calyear;
	private String compCode;
	private String assetMain;
	private String asset;
	private String equnr;
	private Double zpmzcyz;
	private Double zpmzcjz;
	private String fixedAssetClassCode;
	private String ztypbz1;
	private String ztypbz2;
	private String ztypbz3;
	private String zvolLev;
	private Double zquantity;
	private String zioZczt;
	private String profitCtr;
	private String zzcms;
	private String description2;
	private String wbs;
	private String zioZxmlx;
	private String aktiv;
	private String deakt;
	private String anlkl;
	private String zzc001;
	private String zzc002;
	private String kostl;
	private String izwek;
	private String anlue;
	private String herst;
	private String eqktx;
	private String txt04;
	private String inbdt;
	private String zccrq;
	private String zherst;
	private String zsb004;

	// Constructors

	/** default constructor */
	public AbstractZfiSwzcNew() {
	}

	/** full constructor */
	public AbstractZfiSwzcNew(String version,Date calYear, Short calyear, String compCode, String assetMain, String asset,
			String equnr, Double zpmzcyz, Double zpmzcjz, String fixedAssetClassCode, String ztypbz1, String ztypbz2,
			String ztypbz3, String zvolLev, Double zquantity, String zioZczt, String profitCtr, String zzcms,
			String description2, String wbs, String zioZxmlx, String aktiv, String deakt, String anlkl, String zzc001,
			String zzc002, String kostl, String izwek, String anlue, String herst, String eqktx, String txt04,
			String inbdt, String zccrq, String zherst, String zsb004) {
		this.version = version;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.fixedAssetClassCode = fixedAssetClassCode;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zzcms = zzcms;
		this.description2 = description2;
		this.wbs = wbs;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.izwek = izwek;
		this.anlue = anlue;
		this.herst = herst;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.zsb004 = zsb004;
	}

	// Property accessors

	public String getZfiSwzcNewId() {
		return this.zfiSwzcNewId;
	}

	public void setZfiSwzcNewId(String zfiSwzcNewId) {
		this.zfiSwzcNewId = zfiSwzcNewId;
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

	public Short getCalyear() {
		return this.calyear;
	}

	public void setCalyear(Short calyear) {
		this.calyear = calyear;
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

	public String getFixedAssetClassCode() {
		return this.fixedAssetClassCode;
	}

	public void setFixedAssetClassCode(String fixedAssetClassCode) {
		this.fixedAssetClassCode = fixedAssetClassCode;
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

	public String getZvolLev() {
		return this.zvolLev;
	}

	public void setZvolLev(String zvolLev) {
		this.zvolLev = zvolLev;
	}

	public Double getZquantity() {
		return this.zquantity;
	}

	public void setZquantity(Double zquantity) {
		this.zquantity = zquantity;
	}

	public String getZioZczt() {
		return this.zioZczt;
	}

	public void setZioZczt(String zioZczt) {
		this.zioZczt = zioZczt;
	}

	public String getProfitCtr() {
		return this.profitCtr;
	}

	public void setProfitCtr(String profitCtr) {
		this.profitCtr = profitCtr;
	}

	public String getZzcms() {
		return this.zzcms;
	}

	public void setZzcms(String zzcms) {
		this.zzcms = zzcms;
	}

	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getWbs() {
		return this.wbs;
	}

	public void setWbs(String wbs) {
		this.wbs = wbs;
	}

	public String getZioZxmlx() {
		return this.zioZxmlx;
	}

	public void setZioZxmlx(String zioZxmlx) {
		this.zioZxmlx = zioZxmlx;
	}

	public String getAktiv() {
		return this.aktiv;
	}

	public void setAktiv(String aktiv) {
		this.aktiv = aktiv;
	}

	public String getDeakt() {
		return this.deakt;
	}

	public void setDeakt(String deakt) {
		this.deakt = deakt;
	}

	public String getAnlkl() {
		return this.anlkl;
	}

	public void setAnlkl(String anlkl) {
		this.anlkl = anlkl;
	}

	public String getZzc001() {
		return this.zzc001;
	}

	public void setZzc001(String zzc001) {
		this.zzc001 = zzc001;
	}

	public String getZzc002() {
		return this.zzc002;
	}

	public void setZzc002(String zzc002) {
		this.zzc002 = zzc002;
	}

	public String getKostl() {
		return this.kostl;
	}

	public void setKostl(String kostl) {
		this.kostl = kostl;
	}

	public String getIzwek() {
		return this.izwek;
	}

	public void setIzwek(String izwek) {
		this.izwek = izwek;
	}

	public String getAnlue() {
		return this.anlue;
	}

	public void setAnlue(String anlue) {
		this.anlue = anlue;
	}

	public String getHerst() {
		return this.herst;
	}

	public void setHerst(String herst) {
		this.herst = herst;
	}

	public String getEqktx() {
		return this.eqktx;
	}

	public void setEqktx(String eqktx) {
		this.eqktx = eqktx;
	}

	public String getTxt04() {
		return this.txt04;
	}

	public void setTxt04(String txt04) {
		this.txt04 = txt04;
	}

	public String getInbdt() {
		return this.inbdt;
	}

	public void setInbdt(String inbdt) {
		this.inbdt = inbdt;
	}

	public String getZccrq() {
		return this.zccrq;
	}

	public void setZccrq(String zccrq) {
		this.zccrq = zccrq;
	}

	public String getZherst() {
		return this.zherst;
	}

	public void setZherst(String zherst) {
		this.zherst = zherst;
	}

	public String getZsb004() {
		return this.zsb004;
	}

	public void setZsb004(String zsb004) {
		this.zsb004 = zsb004;
	}

}