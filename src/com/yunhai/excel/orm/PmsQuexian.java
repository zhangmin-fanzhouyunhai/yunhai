package com.yunhai.excel.orm;

import java.util.Date;

/**
 * PmsQuexian entity. @author MyEclipse Persistence Tools
 */
public class PmsQuexian extends AbstractPmsQuexian implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -3533064444567062517L;

	/** default constructor */
	public PmsQuexian() {
	}

	/** minimal constructor */
	public PmsQuexian(String pmsQuexianId, Short calYear, String version) {
		super(pmsQuexianId, calYear, version);
	}

	/** full constructor */
	public PmsQuexian(String pmsQuexianId, Short calYear, String version, String sbbm, String dwmx, String qxbh,
			String zclxbm, String sblx, Short tynf, String dydj, String zzsmc, String sbxlmc, String qxms, String qxbw,
			String qxzryy, String sfxq, String sfjs, String zryybm, String qxjsyy, String jsyybm, String qxdj,
			Date fsrq, Date xqrq, String bz, Double xqsj, String jsyy, String zryy, String cwbm, String qfzd, Date ccrq,
			String zcxlms, String qxnr, String zclxbm2, String equipementName, String lineStationName,
			String dataSourceFile) {
		super(pmsQuexianId, calYear, version, sbbm, dwmx, qxbh, zclxbm, sblx, tynf, dydj, zzsmc, sbxlmc, qxms, qxbw,
				qxzryy, sfxq, sfjs, zryybm, qxjsyy, jsyybm, qxdj, fsrq, xqrq, bz, xqsj, jsyy, zryy, cwbm, qfzd, ccrq,
				zcxlms, qxnr, zclxbm2, equipementName, lineStationName, dataSourceFile);
	}

}
