package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriErpDiscardItem entity. @author MyEclipse Persistence Tools
 */
public class OriErpDiscardItem extends AbstractOriErpDiscardItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriErpDiscardItem() {
	}

	/** minimal constructor */
	public OriErpDiscardItem(String version, Date calYear) {
		super(version, calYear);
	}

	/** full constructor */
	public OriErpDiscardItem(String version, Date calYear, String equnr, String techObj, String txt04, String ztypbz,
			String ztypbzTxt, String assetMain, String zzcms, String zbfyywb, String rvaluePro, String assetDiscard,
			String variableStatus, Date transDate, Date accountDate, String involve, Double discardRatio,
			Double discardOvalue, Double discardDepr, String text, String allocate, String allocateCode,
			String costCenter, String costcenterText, Double zquantity, String unit, String unitText, String herst,
			Date aktiv, String readyuseYear, String readyuseMonth, String checkMark, String zlrzxCode, String zlrzx,
			String profitCtr, String longText, String abstract_, String username, String techInformation,
			String rvalueproUpdaplan, String provAppr, String mark, String approvalNode, String carproWhether,
			String carBustype, String carType, String carLevel, String physicalid) {
		super(version, calYear, equnr, techObj, txt04, ztypbz, ztypbzTxt, assetMain, zzcms, zbfyywb, rvaluePro,
				assetDiscard, variableStatus, transDate, accountDate, involve, discardRatio, discardOvalue, discardDepr,
				text, allocate, allocateCode, costCenter, costcenterText, zquantity, unit, unitText, herst, aktiv,
				readyuseYear, readyuseMonth, checkMark, zlrzxCode, zlrzx, profitCtr, longText, abstract_, username,
				techInformation, rvalueproUpdaplan, provAppr, mark, approvalNode, carproWhether, carBustype, carType,
				carLevel, physicalid);
	}
 
}
