package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidErpItemAssetWall entity. @author MyEclipse Persistence Tools
 */
public class MidErpItemAssetWall extends AbstractMidErpItemAssetWall implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidErpItemAssetWall() {
	}

	/** minimal constructor */
	public MidErpItemAssetWall(String midErpItemId) {
		super(midErpItemId);
	}

	/** full constructor */
	public MidErpItemAssetWall(String midErpItemId, String sbbm, String gsdm, String ssds, String xgsdm, String ssxj,
			String sbmc, String zyflbm, String zyfl, String typbz, String typbzCode, String sccj, String sbxh,
			String dydj, Double yz, Double jz, String xlcd, String byqrl, Date tysj, String sbzt, Double sfylzc,
			String swid, Double zylzc, Double cxl, Double xzzc, Double zlybz, String eqart) {
		super(midErpItemId, sbbm, gsdm, ssds, xgsdm, ssxj, sbmc, zyflbm, zyfl, typbz, typbzCode, sccj, sbxh, dydj, yz,
				jz, xlcd, byqrl, tysj, sbzt, sfylzc, swid, zylzc, cxl, xzzc, zlybz, eqart);
	}

	

}
