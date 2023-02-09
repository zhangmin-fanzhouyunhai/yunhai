package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractPmsQuexian entity provides the base persistence definition of the
 * PmsQuexian entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPmsQuexian implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5324469210850228030L;
	private String pmsQuexianId;
	private Short calYear;
	private String version;
	private String sbbm;
	private String dwmx;
	private String qxbh;
	private String zclxbm;
	private String sblx;
	private Short tynf;
	private String dydj;
	private String zzsmc;
	private String sbxlmc;
	private String qxms;
	private String qxbw;
	private String qxzryy;
	private String sfxq;
	private String sfjs;
	private String zryybm;
	private String qxjsyy;
	private String jsyybm;
	private String qxdj;
	private Date fsrq;
	private Date xqrq;
	private String bz;
	private Double xqsj;
	private String jsyy;
	private String zryy;
	private String cwbm;
	private String qfzd;
	private Date ccrq;
	private String zcxlms;
	private String qxnr;
	private String zclxbm2;
	private String equipementName;
	private String lineStationName;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractPmsQuexian() {
	}

	/** minimal constructor */
	public AbstractPmsQuexian(String pmsQuexianId, Short calYear, String version) {
		this.pmsQuexianId = pmsQuexianId;
		this.calYear = calYear;
		this.version = version;
	}

	/** full constructor */
	public AbstractPmsQuexian(String pmsQuexianId, Short calYear, String version, String sbbm, String dwmx, String qxbh,
			String zclxbm, String sblx, Short tynf, String dydj, String zzsmc, String sbxlmc, String qxms, String qxbw,
			String qxzryy, String sfxq, String sfjs, String zryybm, String qxjsyy, String jsyybm, String qxdj,
			Date fsrq, Date xqrq, String bz, Double xqsj, String jsyy, String zryy, String cwbm, String qfzd, Date ccrq,
			String zcxlms, String qxnr, String zclxbm2, String equipementName, String lineStationName, String dataSourceFile) {
		this.pmsQuexianId = pmsQuexianId;
		this.calYear = calYear;
		this.version = version;
		this.sbbm = sbbm;
		this.dwmx = dwmx;
		this.qxbh = qxbh;
		this.zclxbm = zclxbm;
		this.sblx = sblx;
		this.tynf = tynf;
		this.dydj = dydj;
		this.zzsmc = zzsmc;
		this.sbxlmc = sbxlmc;
		this.qxms = qxms;
		this.qxbw = qxbw;
		this.qxzryy = qxzryy;
		this.sfxq = sfxq;
		this.sfjs = sfjs;
		this.zryybm = zryybm;
		this.qxjsyy = qxjsyy;
		this.jsyybm = jsyybm;
		this.qxdj = qxdj;
		this.fsrq = fsrq;
		this.xqrq = xqrq;
		this.bz = bz;
		this.xqsj = xqsj;
		this.jsyy = jsyy;
		this.zryy = zryy;
		this.cwbm = cwbm;
		this.qfzd = qfzd;
		this.ccrq = ccrq;
		this.zcxlms = zcxlms;
		this.qxnr = qxnr;
		this.zclxbm2 = zclxbm2;
		this.equipementName = equipementName;
		this.lineStationName = lineStationName;
		this.dataSourceFile =  dataSourceFile;
	}

	// Property accessors

	public String getPmsQuexianId() {
		return this.pmsQuexianId;
	}
 

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setPmsQuexianId(String pmsQuexianId) {
		this.pmsQuexianId = pmsQuexianId;
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

	public String getQxbh() {
		return this.qxbh;
	}

	public void setQxbh(String qxbh) {
		this.qxbh = qxbh;
	}

	public String getZclxbm() {
		return this.zclxbm;
	}

	public void setZclxbm(String zclxbm) {
		this.zclxbm = zclxbm;
	}

	public String getSblx() {
		return this.sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public Short getTynf() {
		return this.tynf;
	}

	public void setTynf(Short tynf) {
		this.tynf = tynf;
	}

	public String getDydj() {
		return this.dydj;
	}

	public void setDydj(String dydj) {
		this.dydj = dydj;
	}

	public String getZzsmc() {
		return this.zzsmc;
	}

	public void setZzsmc(String zzsmc) {
		this.zzsmc = zzsmc;
	}

	public String getSbxlmc() {
		return this.sbxlmc;
	}

	public void setSbxlmc(String sbxlmc) {
		this.sbxlmc = sbxlmc;
	}

	public String getQxms() {
		return this.qxms;
	}

	public void setQxms(String qxms) {
		this.qxms = qxms;
	}

	public String getQxbw() {
		return this.qxbw;
	}

	public void setQxbw(String qxbw) {
		this.qxbw = qxbw;
	}

	public String getQxzryy() {
		return this.qxzryy;
	}

	public void setQxzryy(String qxzryy) {
		this.qxzryy = qxzryy;
	}

	public String getSfxq() {
		return this.sfxq;
	}

	public void setSfxq(String sfxq) {
		this.sfxq = sfxq;
	}

	public String getSfjs() {
		return this.sfjs;
	}

	public void setSfjs(String sfjs) {
		this.sfjs = sfjs;
	}

	public String getZryybm() {
		return this.zryybm;
	}

	public void setZryybm(String zryybm) {
		this.zryybm = zryybm;
	}

	public String getQxjsyy() {
		return this.qxjsyy;
	}

	public void setQxjsyy(String qxjsyy) {
		this.qxjsyy = qxjsyy;
	}

	public String getJsyybm() {
		return this.jsyybm;
	}

	public void setJsyybm(String jsyybm) {
		this.jsyybm = jsyybm;
	}

	public String getQxdj() {
		return this.qxdj;
	}

	public void setQxdj(String qxdj) {
		this.qxdj = qxdj;
	}

	public Date getFsrq() {
		return this.fsrq;
	}

	public void setFsrq(Date fsrq) {
		this.fsrq = fsrq;
	}

	public Date getXqrq() {
		return this.xqrq;
	}

	public void setXqrq(Date xqrq) {
		this.xqrq = xqrq;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Double getXqsj() {
		return this.xqsj;
	}

	public void setXqsj(Double xqsj) {
		this.xqsj = xqsj;
	}

	public String getJsyy() {
		return this.jsyy;
	}

	public void setJsyy(String jsyy) {
		this.jsyy = jsyy;
	}

	public String getZryy() {
		return this.zryy;
	}

	public void setZryy(String zryy) {
		this.zryy = zryy;
	}

	public String getCwbm() {
		return this.cwbm;
	}

	public void setCwbm(String cwbm) {
		this.cwbm = cwbm;
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

	public String getZcxlms() {
		return this.zcxlms;
	}

	public void setZcxlms(String zcxlms) {
		this.zcxlms = zcxlms;
	}

	public String getQxnr() {
		return this.qxnr;
	}

	public void setQxnr(String qxnr) {
		this.qxnr = qxnr;
	}

	public String getZclxbm2() {
		return this.zclxbm2;
	}

	public void setZclxbm2(String zclxbm2) {
		this.zclxbm2 = zclxbm2;
	}

	public String getEquipementName() {
		return this.equipementName;
	}

	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}

	public String getLineStationName() {
		return this.lineStationName;
	}

	public void setLineStationName(String lineStationName) {
		this.lineStationName = lineStationName;
	}

}