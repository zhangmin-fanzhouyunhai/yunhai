package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidPmsItemOldAge1992 entity. @author MyEclipse Persistence Tools
 */
public class MidPmsItemOldAge1992 extends AbstractMidPmsItemOldAge1992 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidPmsItemOldAge1992() {
	}

	/** minimal constructor */
	public MidPmsItemOldAge1992(String midPmsItemId, String version, String largeClass, String yxzt) {
		super(midPmsItemId, version, largeClass, yxzt);
	}

	/** full constructor */
	public MidPmsItemOldAge1992(String midPmsItemId, String version, String sbbm, String orgName, String orgCode,
			String largeClass, String mediumClass, String smallClass, String voltageLevel, Date calYear,
			Double assetCapacity, Double assetAmount, String yxzt, String qfzd, String jkzt, String ywdw, String zckbm,
			Double zcyz, Date zjtyrq, String zcxz, Double sl, Double sl1, Double sl2, Double sl3, String jldw,
			String zzsmc, String ssxlbdz, String sbxh, Integer tynf, String nnd, Date tyrq, Integer nn,
			Date ccrq, String equipmentName, String assetId, String equipmentIncreaseMode, String lineProperty,
			String zcdl, String sblx, Date dvDateValue, Double slOld, String oldVoltageLevel2, String oldZcxz,
			String discription, String oldYxzt, Date oldTyrq, Date oldCcrq, String usingStatusCode,
			Integer groupStatus, Date dvDataValue, String category) {
		super(midPmsItemId, version, sbbm, orgName, orgCode, largeClass, mediumClass, smallClass, voltageLevel, calYear,
				assetCapacity, assetAmount, yxzt, qfzd, jkzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw,
				zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq, nn, ccrq, equipmentName, assetId, equipmentIncreaseMode,
				lineProperty, zcdl, sblx, dvDateValue, slOld, oldVoltageLevel2, oldZcxz, discription, oldYxzt, oldTyrq,
				oldCcrq, usingStatusCode, groupStatus, dvDataValue, category);
	}

}
