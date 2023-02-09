package com.yunhai.excel.orm;

import java.util.Date;

/**
 * PmsItemPeiSet entity. @author MyEclipse Persistence Tools
 */
public class PmsItemPeiSet extends AbstractPmsItemPeiSet implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -7028548569356407458L;

	/** default constructor */
	public PmsItemPeiSet() {
	}

	/** minimal constructor */
	public PmsItemPeiSet(Short calYear, String version) {
		super(calYear, version);
	}

	/** full constructor */
	public PmsItemPeiSet(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq,
			String equipmentName, String assetId, String equipmentIncreaseMode,String lineProperty,  String dataSourceFile) {
		super(calYear, version, sbbm, dwmx, ywdw, zckbm, sblx, zcyz, zcdl, zclxbm, cwbm, dydj, yxzt, jkzt, zjtyrq, zcxz,
				sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, qfzd, ccrq, equipmentName, assetId,
				equipmentIncreaseMode, lineProperty, dataSourceFile);
	}
	/** full constructor */
	public PmsItemPeiSet(Short calYear, String version, String sbbm, String dwmx, String ywdw, String zckbm,
			String sblx, Double zcyz, String zcdl, String zclxbm, String cwbm, String dydj, String yxzt, String jkzt,
			Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw, String zzsmc,
			String ssxlbdz, String sbxh, Short tynf, String nnd, Date tyrq, Short nn, String qfzd, Date ccrq,
			String equipmentName, String assetId, String equipmentIncreaseMode, String dataSourceFile) {
		super(calYear, version, sbbm, dwmx, ywdw, zckbm, sblx, zcyz, zcdl, zclxbm, cwbm, dydj, yxzt, jkzt, zjtyrq, zcxz,
				sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, qfzd, ccrq, equipmentName, assetId,
				equipmentIncreaseMode, dataSourceFile);
	}

}
