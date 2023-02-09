package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractZfiSwzc2019 entity provides the base persistence definition of the
 * ZfiSwzc2019 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractZfiSwzc2019 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3346330682924036565L;
	private String areaName;
	private String zfiSwzc2019Id;
	private Date calYear;
	private Double calyear;
	private String compCode;
	private String assetMain;
	private String asset;
	private String equnr;
	private String currency;
	private Double zpmzcyz;
	private Double zpmzcjz;
	private String ztypbz1;
	private String ztypbz2;
	private String ztypbz3;
	private String zvolLev;
	private Double zquantity;
	private String unit;
	private String zioZczt;
	private String profitCtr;
	private String zlrzx;
	private String coArea;
	private String zzcms;
	private String zioZxmlx;
	private String aktiv;
	private String deakt;
	private String anlkl;
	private String sernr;
	private String invnr;
	private String zzc001;
	private String zzc002;
	private String kostl;
	private String kostlv;
	private String raumn;
	private String kfzkz;
	private String zzas1;
	private String zzc006;
	private String zzc007;
	private String ord41;
	private String ord44;
	private String gdlgrp;
	private String izwek;
	private String umwkz;
	private String anlue;
	private String herst;
	private String typbz;
	private String zkpwbs;
	private String zkpwbsms;
	private String fiamt;
	private String stadt;
	private String zfwcqzh;
	private String eqktx;
	private String txt04;
	private String eqart;
	private String begru;
	private String inbdt;
	private String zccrq;
	private String zherst;
	private String herld;
	private String mapar;
	private String ztypbz;
	private String serge;
	private String swerk;
	private String stort;
	private String beber;
	private String abckz;
	private String eqfnr;
	private String zkostl;
	private String zsbwbs;
	private String zsbwbsms;
	private String iwerk;
	private String ingrp;
	private String gewrk;
	private String tplnr;
	private String hequi;
	private String tidnr;
	private String zsb010;
	private String zsb001;
	private String zsb002;
	private String zsb004;
	private String zsb005;
	private String zsb006;
	private String zsb003;
	private String zsb007;
	private String zsb008;
	private String zlenunt;
	private String zsb009;
	private String zcapunt;
	private String zsb011;
	private String zeq003;
	private String zeq001;
	private String zeq002;
	private String zlyrkrq;
	private String zlyckrq;
	private String zbfjzrq;
	private String zbfxmbm;
	private String zbfxmms;
	private String zbfyydm;
	private String zbfyywb;
	private String cdate;
	private String ctime;
	private String cname;
	private String stext4;
	private String ztypbz1t;
	private String ztypbz2t;
	private String ztypbz3t;
	private String assetProperty;
	private String propertyCode;
	private String assetId;
	private String dataSourceFile;
	private String version;

	/**
	 * 2020-04-26 添加的字�?
	 */
	private String ltext;
	private String txk20;
	private String assetIdProperty;
	private String equipmentAssetIdProperty;
	private String fing;
	
	
	private String fixedAssetClass;
	private String orgGroupCode;
	private String assetDescription;
	private String fixAssetClassDescript;
	private String unkownCode;
	private String assetPropertyCVSName;
	private String equipmentName;
	private String realAssetIdEquip;
	private String discardCapacityScale;
	private String discardPaperNumber;
	private String metreUnit;
	private String discardSourceProject;
	private String operationMaintenanceTeam;
	// Constructors


	public String getOperationMaintenanceTeam() {
		return operationMaintenanceTeam;
	}

	public AbstractZfiSwzc2019(String areaName, String zfiSwzc2019Id, Date calYear, Double calyear2, String compCode,
			String assetMain, String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz,
			String ztypbz1, String ztypbz2, String ztypbz3, String zvolLev, Double zquantity, String unit,
			String zioZczt, String profitCtr, String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv,
			String deakt, String anlkl, String sernr, String invnr, String zzc001, String zzc002, String kostl,
			String kostlv, String raumn, String kfzkz, String zzas1, String zzc006, String zzc007, String ord41,
			String ord44, String gdlgrp, String izwek, String umwkz, String anlue, String herst, String typbz,
			String zkpwbs, String zkpwbsms, String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04,
			String eqart, String begru, String inbdt, String zccrq, String zherst, String herld, String mapar,
			String ztypbz, String serge, String swerk, String stort, String beber, String abckz, String eqfnr,
			String zkostl, String zsbwbs, String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr,
			String hequi, String tidnr, String zsb010, String zsb001, String zsb002, String zsb004, String zsb005,
			String zsb006, String zsb003, String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt,
			String zsb011, String zeq003, String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq,
			String zbfxmbm, String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname,
			String stext4, String ztypbz1t, String ztypbz2t, String ztypbz3t, String assetProperty, String propertyCode,
			String assetId, String dataSourceFile, String version, String ltext, String txk20, String assetIdProperty,
			String equipmentAssetIdProperty, String fing, String fixedAssetClass, String orgGroupCode,
			String assetDescription, String fixAssetClassDescript, String unkownCode, String assetPropertyCVSName,
			String equipmentName, String realAssetIdEquip, String discardCapacityScale, String discardPaperNumber,
			String metreUnit, String discardSourceProject, String operationMaintenanceTeam) {
		super();
		this.areaName = areaName;
		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		calyear = calyear2;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
		this.stext4 = stext4;
		this.ztypbz1t = ztypbz1t;
		this.ztypbz2t = ztypbz2t;
		this.ztypbz3t = ztypbz3t;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.assetId = assetId;
		this.dataSourceFile = dataSourceFile;
		this.version = version;
		this.ltext = ltext;
		this.txk20 = txk20;
		this.assetIdProperty = assetIdProperty;
		this.equipmentAssetIdProperty = equipmentAssetIdProperty;
		this.fing = fing;
		this.fixedAssetClass = fixedAssetClass;
		this.orgGroupCode = orgGroupCode;
		this.assetDescription = assetDescription;
		this.fixAssetClassDescript = fixAssetClassDescript;
		this.unkownCode = unkownCode;
		this.assetPropertyCVSName = assetPropertyCVSName;
		this.equipmentName = equipmentName;
		this.realAssetIdEquip = realAssetIdEquip;
		this.discardCapacityScale = discardCapacityScale;
		this.discardPaperNumber = discardPaperNumber;
		this.metreUnit = metreUnit;
		this.discardSourceProject = discardSourceProject;
		this.operationMaintenanceTeam = operationMaintenanceTeam;
	}

	public void setOperationMaintenanceTeam(String operationMaintenanceTeam) {
		this.operationMaintenanceTeam = operationMaintenanceTeam;
	}

	/** default constructor */
	public AbstractZfiSwzc2019() {
	}

	/** minimal constructor */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id) {
		this.zfiSwzc2019Id = zfiSwzc2019Id;
	}

	/** full constructor 2020-04-26 */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id, Date calYear, Double calyear, String compCode, String assetMain,
			String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz, String ztypbz1, String ztypbz2,
			String ztypbz3, String zvolLev, Double zquantity, String unit, String zioZczt, String profitCtr,
			String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv, String deakt, String anlkl,
			String sernr, String invnr, String zzc001, String zzc002, String kostl, String kostlv, String raumn,
			String kfzkz, String zzas1, String zzc006, String zzc007, String ord41, String ord44, String gdlgrp,
			String izwek, String umwkz, String anlue, String herst, String typbz, String zkpwbs, String zkpwbsms,
			String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04, String eqart, String begru,
			String inbdt, String zccrq, String zherst, String herld, String mapar, String ztypbz, String serge,
			String swerk, String stort, String beber, String abckz, String eqfnr, String zkostl, String zsbwbs,
			String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr, String hequi, String tidnr,
			String zsb010, String zsb001, String zsb002, String zsb004, String zsb005, String zsb006, String zsb003,
			String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt, String zsb011, String zeq003,
			String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq, String zbfxmbm,
			String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname, String stext4,
			String ztypbz1t, String ztypbz2t, String ztypbz3t, String assetProperty, String propertyCode,
			String assetId, String dataSourceFile,String version, String areaName, String ltext, String txk20, String assetIdProperty,
			String equipmentAssetIdProperty, String fing,String fixedAssetClass,String orgGroupCode,
			String assetDescription,String fixAssetClassDescript,String unkownCode,String assetPropertyCVSName,
			String equipmentName,String realAssetIdEquip,String discardCapacityScale,String discardPaperNumber,
			String metreUnit,String discardSourceProject) {		

		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
		this.stext4 = stext4;
		this.ztypbz1t = ztypbz1t;
		this.ztypbz2t = ztypbz2t;
		this.ztypbz3t = ztypbz3t;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.assetId = assetId;
		this.dataSourceFile = dataSourceFile;
		this.areaName = areaName;
		this.version = version;
		
		/**
		 * 2020-04-26
		 */
		this.ltext = ltext;
		this.txk20 = txk20;
		this.assetIdProperty = assetIdProperty;
		this.equipmentAssetIdProperty = equipmentAssetIdProperty;
		this.fing = fing;
		this.fixedAssetClass = fixedAssetClass;
		this.orgGroupCode = orgGroupCode;
		this.assetDescription = assetDescription;
		this.fixAssetClassDescript = fixAssetClassDescript;
		this.unkownCode = unkownCode;
		this.assetPropertyCVSName = assetPropertyCVSName;
		this.equipmentName = equipmentName;
		this.realAssetIdEquip = realAssetIdEquip;
		this.discardCapacityScale = discardCapacityScale;
		this.discardPaperNumber = discardPaperNumber;
		this.metreUnit = metreUnit;
		this.discardSourceProject = discardSourceProject; 
	}

	/** full constructor 20200415 */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id, Date calYear, Double calyear, String compCode, String assetMain,
			String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz, String ztypbz1, String ztypbz2,
			String ztypbz3, String zvolLev, Double zquantity, String unit, String zioZczt, String profitCtr,
			String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv, String deakt, String anlkl,
			String sernr, String invnr, String zzc001, String zzc002, String kostl, String kostlv, String raumn,
			String kfzkz, String zzas1, String zzc006, String zzc007, String ord41, String ord44, String gdlgrp,
			String izwek, String umwkz, String anlue, String herst, String typbz, String zkpwbs, String zkpwbsms,
			String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04, String eqart, String begru,
			String inbdt, String zccrq, String zherst, String herld, String mapar, String ztypbz, String serge,
			String swerk, String stort, String beber, String abckz, String eqfnr, String zkostl, String zsbwbs,
			String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr, String hequi, String tidnr,
			String zsb010, String zsb001, String zsb002, String zsb004, String zsb005, String zsb006, String zsb003,
			String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt, String zsb011, String zeq003,
			String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq, String zbfxmbm,
			String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname, String stext4,
			String ztypbz1t, String ztypbz2t, String ztypbz3t, String assetProperty, String propertyCode,
			String assetId, String dataSourceFile, String areaName) {
		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
		this.stext4 = stext4;
		this.ztypbz1t = ztypbz1t;
		this.ztypbz2t = ztypbz2t;
		this.ztypbz3t = ztypbz3t;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.assetId = assetId;
		this.dataSourceFile = dataSourceFile;
		this.areaName = areaName;
	}

	/** full constructor */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id, Date calYear, Double calyear, String compCode, String assetMain,
			String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz, String ztypbz1, String ztypbz2,
			String ztypbz3, String zvolLev, Double zquantity, String unit, String zioZczt, String profitCtr,
			String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv, String deakt, String anlkl,
			String sernr, String invnr, String zzc001, String zzc002, String kostl, String kostlv, String raumn,
			String kfzkz, String zzas1, String zzc006, String zzc007, String ord41, String ord44, String gdlgrp,
			String izwek, String umwkz, String anlue, String herst, String typbz, String zkpwbs, String zkpwbsms,
			String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04, String eqart, String begru,
			String inbdt, String zccrq, String zherst, String herld, String mapar, String ztypbz, String serge,
			String swerk, String stort, String beber, String abckz, String eqfnr, String zkostl, String zsbwbs,
			String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr, String hequi, String tidnr,
			String zsb010, String zsb001, String zsb002, String zsb004, String zsb005, String zsb006, String zsb003,
			String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt, String zsb011, String zeq003,
			String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq, String zbfxmbm,
			String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname, String stext4,
			String ztypbz1t, String ztypbz2t, String ztypbz3t, String assetProperty, String propertyCode,
			String assetId, String dataSourceFile) {
		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
		this.stext4 = stext4;
		this.ztypbz1t = ztypbz1t;
		this.ztypbz2t = ztypbz2t;
		this.ztypbz3t = ztypbz3t;
		this.assetProperty = assetProperty;
		this.propertyCode = propertyCode;
		this.assetId = assetId;
		this.dataSourceFile = dataSourceFile;
	}

	/** full constructor */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id, Date calYear, Double calyear, String compCode, String assetMain,
			String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz, String ztypbz1, String ztypbz2,
			String ztypbz3, String zvolLev, Double zquantity, String unit, String zioZczt, String profitCtr,
			String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv, String deakt, String anlkl,
			String sernr, String invnr, String zzc001, String zzc002, String kostl, String kostlv, String raumn,
			String kfzkz, String zzas1, String zzc006, String zzc007, String ord41, String ord44, String gdlgrp,
			String izwek, String umwkz, String anlue, String herst, String typbz, String zkpwbs, String zkpwbsms,
			String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04, String eqart, String begru,
			String inbdt, String zccrq, String zherst, String herld, String mapar, String ztypbz, String serge,
			String swerk, String stort, String beber, String abckz, String eqfnr, String zkostl, String zsbwbs,
			String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr, String hequi, String tidnr,
			String zsb010, String zsb001, String zsb002, String zsb004, String zsb005, String zsb006, String zsb003,
			String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt, String zsb011, String zeq003,
			String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq, String zbfxmbm,
			String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname) {
		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
	}

	/** full constructor */
	public AbstractZfiSwzc2019(String zfiSwzc2019Id, String version, Date calYear, Double calyear, String compCode,
			String assetMain, String asset, String equnr, String currency, Double zpmzcyz, Double zpmzcjz,
			String ztypbz1, String ztypbz2, String ztypbz3, String zvolLev, Double zquantity, String unit,
			String zioZczt, String profitCtr, String zlrzx, String coArea, String zzcms, String zioZxmlx, String aktiv,
			String deakt, String anlkl, String sernr, String invnr, String zzc001, String zzc002, String kostl,
			String kostlv, String raumn, String kfzkz, String zzas1, String zzc006, String zzc007, String ord41,
			String ord44, String gdlgrp, String izwek, String umwkz, String anlue, String herst, String typbz,
			String zkpwbs, String zkpwbsms, String fiamt, String stadt, String zfwcqzh, String eqktx, String txt04,
			String eqart, String begru, String inbdt, String zccrq, String zherst, String herld, String mapar,
			String ztypbz, String serge, String swerk, String stort, String beber, String abckz, String eqfnr,
			String zkostl, String zsbwbs, String zsbwbsms, String iwerk, String ingrp, String gewrk, String tplnr,
			String hequi, String tidnr, String zsb010, String zsb001, String zsb002, String zsb004, String zsb005,
			String zsb006, String zsb003, String zsb007, String zsb008, String zlenunt, String zsb009, String zcapunt,
			String zsb011, String zeq003, String zeq001, String zeq002, String zlyrkrq, String zlyckrq, String zbfjzrq,
			String zbfxmbm, String zbfxmms, String zbfyydm, String zbfyywb, String cdate, String ctime, String cname) {
		this.version = version;
		this.zfiSwzc2019Id = zfiSwzc2019Id;
		this.calYear = calYear;
		this.calyear = calyear;
		this.compCode = compCode;
		this.assetMain = assetMain;
		this.asset = asset;
		this.equnr = equnr;
		this.currency = currency;
		this.zpmzcyz = zpmzcyz;
		this.zpmzcjz = zpmzcjz;
		this.ztypbz1 = ztypbz1;
		this.ztypbz2 = ztypbz2;
		this.ztypbz3 = ztypbz3;
		this.zvolLev = zvolLev;
		this.zquantity = zquantity;
		this.unit = unit;
		this.zioZczt = zioZczt;
		this.profitCtr = profitCtr;
		this.zlrzx = zlrzx;
		this.coArea = coArea;
		this.zzcms = zzcms;
		this.zioZxmlx = zioZxmlx;
		this.aktiv = aktiv;
		this.deakt = deakt;
		this.anlkl = anlkl;
		this.sernr = sernr;
		this.invnr = invnr;
		this.zzc001 = zzc001;
		this.zzc002 = zzc002;
		this.kostl = kostl;
		this.kostlv = kostlv;
		this.raumn = raumn;
		this.kfzkz = kfzkz;
		this.zzas1 = zzas1;
		this.zzc006 = zzc006;
		this.zzc007 = zzc007;
		this.ord41 = ord41;
		this.ord44 = ord44;
		this.gdlgrp = gdlgrp;
		this.izwek = izwek;
		this.umwkz = umwkz;
		this.anlue = anlue;
		this.herst = herst;
		this.typbz = typbz;
		this.zkpwbs = zkpwbs;
		this.zkpwbsms = zkpwbsms;
		this.fiamt = fiamt;
		this.stadt = stadt;
		this.zfwcqzh = zfwcqzh;
		this.eqktx = eqktx;
		this.txt04 = txt04;
		this.eqart = eqart;
		this.begru = begru;
		this.inbdt = inbdt;
		this.zccrq = zccrq;
		this.zherst = zherst;
		this.herld = herld;
		this.mapar = mapar;
		this.ztypbz = ztypbz;
		this.serge = serge;
		this.swerk = swerk;
		this.stort = stort;
		this.beber = beber;
		this.abckz = abckz;
		this.eqfnr = eqfnr;
		this.zkostl = zkostl;
		this.zsbwbs = zsbwbs;
		this.zsbwbsms = zsbwbsms;
		this.iwerk = iwerk;
		this.ingrp = ingrp;
		this.gewrk = gewrk;
		this.tplnr = tplnr;
		this.hequi = hequi;
		this.tidnr = tidnr;
		this.zsb010 = zsb010;
		this.zsb001 = zsb001;
		this.zsb002 = zsb002;
		this.zsb004 = zsb004;
		this.zsb005 = zsb005;
		this.zsb006 = zsb006;
		this.zsb003 = zsb003;
		this.zsb007 = zsb007;
		this.zsb008 = zsb008;
		this.zlenunt = zlenunt;
		this.zsb009 = zsb009;
		this.zcapunt = zcapunt;
		this.zsb011 = zsb011;
		this.zeq003 = zeq003;
		this.zeq001 = zeq001;
		this.zeq002 = zeq002;
		this.zlyrkrq = zlyrkrq;
		this.zlyckrq = zlyckrq;
		this.zbfjzrq = zbfjzrq;
		this.zbfxmbm = zbfxmbm;
		this.zbfxmms = zbfxmms;
		this.zbfyydm = zbfyydm;
		this.zbfyywb = zbfyywb;
		this.cdate = cdate;
		this.ctime = ctime;
		this.cname = cname;
	}

	

	// Property accessors
	/**
	 * 2020-04-26 添加的字�?
	 */
	public String getLtext() {
		return ltext;
	}

	public void setLtext(String ltext) {
		this.ltext = ltext;
	}

	public String getTxk20() {
		return txk20;
	}

	public void setTxk20(String txk20) {
		this.txk20 = txk20;
	}

	public String getAssetIdProperty() {
		return assetIdProperty;
	}

	public void setAssetIdProperty(String assetIdProperty) {
		this.assetIdProperty = assetIdProperty;
	}

	public String getEquipmentAssetIdProperty() {
		return equipmentAssetIdProperty;
	}

	public void setEquipmentAssetIdProperty(String equipmentAssetIdProperty) {
		this.equipmentAssetIdProperty = equipmentAssetIdProperty;
	}

	public String getFing() {
		return fing;
	}

	public void setFing(String fing) {
		this.fing = fing;
	}

	public String getFixedAssetClass() {
		return fixedAssetClass;
	}

	public void setFixedAssetClass(String fixedAssetClass) {
		this.fixedAssetClass = fixedAssetClass;
	}

	public String getOrgGroupCode() {
		return orgGroupCode;
	}

	public void setOrgGroupCode(String orgGroupCode) {
		this.orgGroupCode = orgGroupCode;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getFixAssetClassDescript() {
		return fixAssetClassDescript;
	}

	public void setFixAssetClassDescript(String fixAssetClassDescript) {
		this.fixAssetClassDescript = fixAssetClassDescript;
	}

	public String getUnkownCode() {
		return unkownCode;
	}

	public void setUnkownCode(String unkownCode) {
		this.unkownCode = unkownCode;
	}

	public String getAssetPropertyCVSName() {
		return assetPropertyCVSName;
	}

	public void setAssetPropertyCVSName(String assetPropertyCVSName) {
		this.assetPropertyCVSName = assetPropertyCVSName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getRealAssetIdEquip() {
		return realAssetIdEquip;
	}

	public void setRealAssetIdEquip(String realAssetIdEquip) {
		this.realAssetIdEquip = realAssetIdEquip;
	}

	public String getDiscardCapacityScale() {
		return discardCapacityScale;
	}

	public void setDiscardCapacityScale(String discardCapacityScale) {
		this.discardCapacityScale = discardCapacityScale;
	}

	public String getDiscardPaperNumber() {
		return discardPaperNumber;
	}

	public void setDiscardPaperNumber(String discardPaperNumber) {
		this.discardPaperNumber = discardPaperNumber;
	}

	public String getMetreUnit() {
		return metreUnit;
	}

	public void setMetreUnit(String metreUnit) {
		this.metreUnit = metreUnit;
	}

	public String getDiscardSourceProject() {
		return discardSourceProject;
	}

	public void setDiscardSourceProject(String discardSourceProject) {
		this.discardSourceProject = discardSourceProject;
	}

	// Property accessors

	
	
	
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getZfiSwzc2019Id() {
		return this.zfiSwzc2019Id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public Date getCalYear() {
		return calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getStext4() {
		return stext4;
	}

	public void setStext4(String stext4) {
		this.stext4 = stext4;
	}

	public String getZtypbz1t() {
		return ztypbz1t;
	}

	public void setZtypbz1t(String ztypbz1t) {
		this.ztypbz1t = ztypbz1t;
	}

	public String getZtypbz2t() {
		return ztypbz2t;
	}

	public void setZtypbz2t(String ztypbz2t) {
		this.ztypbz2t = ztypbz2t;
	}

	public String getZtypbz3t() {
		return ztypbz3t;
	}

	public void setZtypbz3t(String ztypbz3t) {
		this.ztypbz3t = ztypbz3t;
	}

	public String getAssetProperty() {
		return assetProperty;
	}

	public void setAssetProperty(String assetProperty) {
		this.assetProperty = assetProperty;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public void setZfiSwzc2019Id(String zfiSwzc2019Id) {
		this.zfiSwzc2019Id = zfiSwzc2019Id;
	}

	public Double getCalyear() {
		return this.calyear;
	}

	public void setCalyear(Double calyear) {
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

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getZlrzx() {
		return this.zlrzx;
	}

	public void setZlrzx(String zlrzx) {
		this.zlrzx = zlrzx;
	}

	public String getCoArea() {
		return this.coArea;
	}

	public void setCoArea(String coArea) {
		this.coArea = coArea;
	}

	public String getZzcms() {
		return this.zzcms;
	}

	public void setZzcms(String zzcms) {
		this.zzcms = zzcms;
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

	public String getSernr() {
		return this.sernr;
	}

	public void setSernr(String sernr) {
		this.sernr = sernr;
	}

	public String getInvnr() {
		return this.invnr;
	}

	public void setInvnr(String invnr) {
		this.invnr = invnr;
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

	public String getKostlv() {
		return this.kostlv;
	}

	public void setKostlv(String kostlv) {
		this.kostlv = kostlv;
	}

	public String getRaumn() {
		return this.raumn;
	}

	public void setRaumn(String raumn) {
		this.raumn = raumn;
	}

	public String getKfzkz() {
		return this.kfzkz;
	}

	public void setKfzkz(String kfzkz) {
		this.kfzkz = kfzkz;
	}

	public String getZzas1() {
		return this.zzas1;
	}

	public void setZzas1(String zzas1) {
		this.zzas1 = zzas1;
	}

	public String getZzc006() {
		return this.zzc006;
	}

	public void setZzc006(String zzc006) {
		this.zzc006 = zzc006;
	}

	public String getZzc007() {
		return this.zzc007;
	}

	public void setZzc007(String zzc007) {
		this.zzc007 = zzc007;
	}

	public String getOrd41() {
		return this.ord41;
	}

	public void setOrd41(String ord41) {
		this.ord41 = ord41;
	}

	public String getOrd44() {
		return this.ord44;
	}

	public void setOrd44(String ord44) {
		this.ord44 = ord44;
	}

	public String getGdlgrp() {
		return this.gdlgrp;
	}

	public void setGdlgrp(String gdlgrp) {
		this.gdlgrp = gdlgrp;
	}

	public String getIzwek() {
		return this.izwek;
	}

	public void setIzwek(String izwek) {
		this.izwek = izwek;
	}

	public String getUmwkz() {
		return this.umwkz;
	}

	public void setUmwkz(String umwkz) {
		this.umwkz = umwkz;
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

	public String getTypbz() {
		return this.typbz;
	}

	public void setTypbz(String typbz) {
		this.typbz = typbz;
	}

	public String getZkpwbs() {
		return this.zkpwbs;
	}

	public void setZkpwbs(String zkpwbs) {
		this.zkpwbs = zkpwbs;
	}

	public String getZkpwbsms() {
		return this.zkpwbsms;
	}

	public void setZkpwbsms(String zkpwbsms) {
		this.zkpwbsms = zkpwbsms;
	}

	public String getFiamt() {
		return this.fiamt;
	}

	public void setFiamt(String fiamt) {
		this.fiamt = fiamt;
	}

	public String getStadt() {
		return this.stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getZfwcqzh() {
		return this.zfwcqzh;
	}

	public void setZfwcqzh(String zfwcqzh) {
		this.zfwcqzh = zfwcqzh;
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

	public String getEqart() {
		return this.eqart;
	}

	public void setEqart(String eqart) {
		this.eqart = eqart;
	}

	public String getBegru() {
		return this.begru;
	}

	public void setBegru(String begru) {
		this.begru = begru;
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

	public String getHerld() {
		return this.herld;
	}

	public void setHerld(String herld) {
		this.herld = herld;
	}

	public String getMapar() {
		return this.mapar;
	}

	public void setMapar(String mapar) {
		this.mapar = mapar;
	}

	public String getZtypbz() {
		return this.ztypbz;
	}

	public void setZtypbz(String ztypbz) {
		this.ztypbz = ztypbz;
	}

	public String getSerge() {
		return this.serge;
	}

	public void setSerge(String serge) {
		this.serge = serge;
	}

	public String getSwerk() {
		return this.swerk;
	}

	public void setSwerk(String swerk) {
		this.swerk = swerk;
	}

	public String getStort() {
		return this.stort;
	}

	public void setStort(String stort) {
		this.stort = stort;
	}

	public String getBeber() {
		return this.beber;
	}

	public void setBeber(String beber) {
		this.beber = beber;
	}

	public String getAbckz() {
		return this.abckz;
	}

	public void setAbckz(String abckz) {
		this.abckz = abckz;
	}

	public String getEqfnr() {
		return this.eqfnr;
	}

	public void setEqfnr(String eqfnr) {
		this.eqfnr = eqfnr;
	}

	public String getZkostl() {
		return this.zkostl;
	}

	public void setZkostl(String zkostl) {
		this.zkostl = zkostl;
	}

	public String getZsbwbs() {
		return this.zsbwbs;
	}

	public void setZsbwbs(String zsbwbs) {
		this.zsbwbs = zsbwbs;
	}

	public String getZsbwbsms() {
		return this.zsbwbsms;
	}

	public void setZsbwbsms(String zsbwbsms) {
		this.zsbwbsms = zsbwbsms;
	}

	public String getIwerk() {
		return this.iwerk;
	}

	public void setIwerk(String iwerk) {
		this.iwerk = iwerk;
	}

	public String getIngrp() {
		return this.ingrp;
	}

	public void setIngrp(String ingrp) {
		this.ingrp = ingrp;
	}

	public String getGewrk() {
		return this.gewrk;
	}

	public void setGewrk(String gewrk) {
		this.gewrk = gewrk;
	}

	public String getTplnr() {
		return this.tplnr;
	}

	public void setTplnr(String tplnr) {
		this.tplnr = tplnr;
	}

	public String getHequi() {
		return this.hequi;
	}

	public void setHequi(String hequi) {
		this.hequi = hequi;
	}

	public String getTidnr() {
		return this.tidnr;
	}

	public void setTidnr(String tidnr) {
		this.tidnr = tidnr;
	}

	public String getZsb010() {
		return this.zsb010;
	}

	public void setZsb010(String zsb010) {
		this.zsb010 = zsb010;
	}

	public String getZsb001() {
		return this.zsb001;
	}

	public void setZsb001(String zsb001) {
		this.zsb001 = zsb001;
	}

	public String getZsb002() {
		return this.zsb002;
	}

	public void setZsb002(String zsb002) {
		this.zsb002 = zsb002;
	}

	public String getZsb004() {
		return this.zsb004;
	}

	public void setZsb004(String zsb004) {
		this.zsb004 = zsb004;
	}

	public String getZsb005() {
		return this.zsb005;
	}

	public void setZsb005(String zsb005) {
		this.zsb005 = zsb005;
	}

	public String getZsb006() {
		return this.zsb006;
	}

	public void setZsb006(String zsb006) {
		this.zsb006 = zsb006;
	}

	public String getZsb003() {
		return this.zsb003;
	}

	public void setZsb003(String zsb003) {
		this.zsb003 = zsb003;
	}

	public String getZsb007() {
		return this.zsb007;
	}

	public void setZsb007(String zsb007) {
		this.zsb007 = zsb007;
	}

	public String getZsb008() {
		return this.zsb008;
	}

	public void setZsb008(String zsb008) {
		this.zsb008 = zsb008;
	}

	public String getZlenunt() {
		return this.zlenunt;
	}

	public void setZlenunt(String zlenunt) {
		this.zlenunt = zlenunt;
	}

	public String getZsb009() {
		return this.zsb009;
	}

	public void setZsb009(String zsb009) {
		this.zsb009 = zsb009;
	}

	public String getZcapunt() {
		return this.zcapunt;
	}

	public void setZcapunt(String zcapunt) {
		this.zcapunt = zcapunt;
	}

	public String getZsb011() {
		return this.zsb011;
	}

	public void setZsb011(String zsb011) {
		this.zsb011 = zsb011;
	}

	public String getZeq003() {
		return this.zeq003;
	}

	public void setZeq003(String zeq003) {
		this.zeq003 = zeq003;
	}

	public String getZeq001() {
		return this.zeq001;
	}

	public void setZeq001(String zeq001) {
		this.zeq001 = zeq001;
	}

	public String getZeq002() {
		return this.zeq002;
	}

	public void setZeq002(String zeq002) {
		this.zeq002 = zeq002;
	}

	public String getZlyrkrq() {
		return this.zlyrkrq;
	}

	public void setZlyrkrq(String zlyrkrq) {
		this.zlyrkrq = zlyrkrq;
	}

	public String getZlyckrq() {
		return this.zlyckrq;
	}

	public void setZlyckrq(String zlyckrq) {
		this.zlyckrq = zlyckrq;
	}

	public String getZbfjzrq() {
		return this.zbfjzrq;
	}

	public void setZbfjzrq(String zbfjzrq) {
		this.zbfjzrq = zbfjzrq;
	}

	public String getZbfxmbm() {
		return this.zbfxmbm;
	}

	public void setZbfxmbm(String zbfxmbm) {
		this.zbfxmbm = zbfxmbm;
	}

	public String getZbfxmms() {
		return this.zbfxmms;
	}

	public void setZbfxmms(String zbfxmms) {
		this.zbfxmms = zbfxmms;
	}

	public String getZbfyydm() {
		return this.zbfyydm;
	}

	public void setZbfyydm(String zbfyydm) {
		this.zbfyydm = zbfyydm;
	}

	public String getZbfyywb() {
		return this.zbfyywb;
	}

	public void setZbfyywb(String zbfyywb) {
		this.zbfyywb = zbfyywb;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}