package com.yunhai.excel.orm;

import java.util.Date;
 

/**
 * PmsItemShuLine entity. @author MyEclipse Persistence Tools
 */
public class PmsItemShuLine extends AbstractPmsItemShuLine implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 8782444477834386603L;

	/** default constructor */
	public PmsItemShuLine() {
	}

	/** minimal constructor */
	public PmsItemShuLine(Short calYear, String version) {
		super(calYear, version);
	}

	/** full constructor */
	public PmsItemShuLine(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq, 
			String equipmentName, String assetId, String equipmentIncreaseMode, String dataSourceFile) {
		super(calYear, version, sbbm, dwmx, ywdw, zckbm, sblx, zcyz, zcdl, zclxbm, cwbm, dydj, yxzt, jkzt, zjtyrq, zcxz,
				sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, qfzd, ccrq, equipmentName, assetId,
				equipmentIncreaseMode, dataSourceFile);
	}

	/** full constructor */
	public PmsItemShuLine(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq, 
			String equipmentName, String assetId, String equipmentIncreaseMode, String lineProperty, String dataSourceFile) {
		super(calYear, version, sbbm, dwmx, ywdw, zckbm, sblx, zcyz, zcdl, zclxbm, cwbm, dydj, yxzt, jkzt, zjtyrq, zcxz,
				sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, qfzd, ccrq, equipmentName, assetId,
				equipmentIncreaseMode,lineProperty, dataSourceFile);
	}
	
	public String PropertyGet(String fieldName) {
		String fieldValue ="";
		switch(fieldName) {
		case "calYear" :
			fieldValue=getCalYear().toString();
		break;
		case "version":
			fieldValue=getCalYear().toString();
		break;
		case "sbbm" :
			fieldValue=getCalYear().toString();
		break;
		case "dwmx":
			fieldValue=getCalYear().toString();
		break;
		case "ywdw" :
			fieldValue=getCalYear().toString();
		break;
		case "zckbm":
			fieldValue=getCalYear().toString();
		break;
		case "sblx" :
			fieldValue=getCalYear().toString();
		break;
		case "zcyz":
			fieldValue=getCalYear().toString();
		break;
		case "zcdl" :
			fieldValue=getCalYear().toString();
		break;
		case "cwbm":
			fieldValue=getCalYear().toString();
		break;
		case "dydj":
			fieldValue=getCalYear().toString();
		break; 
		case "yxzt":
			fieldValue=getCalYear().toString();
		break; 
		case "jkzt":
			fieldValue=getCalYear().toString();
		break; 
		case "zjtyrq":
			fieldValue=getCalYear().toString();
		break; 
		case "zcxz":
			fieldValue=getCalYear().toString();
		break; 
		case "sl":
			fieldValue=getCalYear().toString();
		break; 
		case "sl1":
			fieldValue=getCalYear().toString();
		break;
		case "sl2":
			fieldValue=getCalYear().toString();
		break;
		case "sl3":
			fieldValue=getCalYear().toString();
		break;
		case "jldw":
			fieldValue=getCalYear().toString();
		break;
		case "zzsmc":
			fieldValue=getCalYear().toString();
		break;
		case "ssxlbdz":
			fieldValue=getCalYear().toString();
		break;
		case "sbxh":
			fieldValue=getCalYear().toString();
		break;
		case "tynf":
			fieldValue=getCalYear().toString();
		break;
		case "nnd":
			fieldValue=getCalYear().toString();
		break;
		case "tyrq":
			fieldValue=getCalYear().toString();
		break;
		case "nn":
			fieldValue=getCalYear().toString();
		break;
		case "qfzd":
			fieldValue=getCalYear().toString();
		break;
		case "ccrq":
			fieldValue=getCalYear().toString();
		break;
		case "equipmentName":
			fieldValue=getCalYear().toString();
		break;
		case "assetId":
			fieldValue=getCalYear().toString();
		break;
		case "equipmentIncreaseMode":
			fieldValue=getCalYear().toString();
		break;
		case "lineProperty":
			fieldValue=getCalYear().toString();
		break;
		case "dataSourceFile":
			fieldValue=getCalYear().toString();
		break;  
		default:
			System.out.println("属于不存在，请认真核实！");
		} 

		return fieldValue;
	}
	
	public void PropertySet(String fieldName, String fieldValue) {
		switch(fieldName) {
		case "calYear" :
		setCalYear(new Short(fieldValue));
		break;
		case "version":
		setVersion(fieldValue);
		break;
		case "sbbm" :
		setCalYear(new Short(fieldValue));
		break;
		case "dwmx":
		setVersion(fieldValue);
		break;
		case "ywdw" :
		setCalYear(new Short(fieldValue));
		break;
		case "zckbm":
		setVersion(fieldValue);
		break;
		case "sblx" :
		setCalYear(new Short(fieldValue));
		break;
		case "zcyz":
		setVersion(fieldValue);
		break;
		case "zcdl" :
		setCalYear(new Short(fieldValue));
		break;
		case "cwbm":
		setVersion(fieldValue);
		break;
		case "dydj":
		setVersion(fieldValue);
		break; 
		case "yxzt":
		setVersion(fieldValue);
		break; 
		case "jkzt":
		setVersion(fieldValue);
		break; 
		case "zjtyrq":
		setVersion(fieldValue);
		break; 
		case "zcxz":
		setVersion(fieldValue);
		break; 
		case "sl":
		setVersion(fieldValue);
		break; 
		case "sl1":
		setVersion(fieldValue);
		break;
		case "sl2":
		setVersion(fieldValue);
		break;
		case "sl3":
		setVersion(fieldValue);
		break;
		case "jldw":
		setVersion(fieldValue);
		break;
		case "zzsmc":
		setVersion(fieldValue);
		break;
		case "ssxlbdz":
		setVersion(fieldValue);
		break;
		case "sbxh":
		setVersion(fieldValue);
		break;
		case "tynf":
		setVersion(fieldValue);
		break;
		case "nnd":
		setVersion(fieldValue);
		break;
		case "tyrq":
		setVersion(fieldValue);
		break;
		case "nn":
		setVersion(fieldValue);
		break;
		case "qfzd":
		setVersion(fieldValue);
		break;
		case "ccrq":
		setVersion(fieldValue);
		break;
		case "equipmentName":
		setVersion(fieldValue);
		break;
		case "assetId":
		setAssetId(fieldValue);
		break;
		case "equipmentIncreaseMode":
		setVersion(fieldValue);
		break;
		case "lineProperty":
		setVersion(fieldValue);
		break;
		case "dataSourceFile":
		setVersion(fieldValue);
		break;  
		default:
			System.out.println("属于不存在，请认真核实！");
		} 
	}
}
