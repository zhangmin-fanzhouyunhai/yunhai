package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidPmsItem entity. @author MyEclipse Persistence Tools
 */
public class MidPmsItem extends AbstractMidPmsItem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidPmsItem() {
	}

	/** minimal constructor */
	public MidPmsItem(String midPmsItemId, String version, String sbbm, String orgName, String zcDl) {
		super(midPmsItemId, version, sbbm, orgName, zcDl);
	}

	/** full constructor */

	public MidPmsItem(String midPmsItemId, String version, String sbbm, String orgName, String dvPmsAssetClassId,
			String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear, String qfzd, String jkzt,
			String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz, Double sl, Double sl1,
			Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh, Integer tynf, String nnd,
			Date tyrq, Integer nn, Date ccrq, String isMatched) {
		super(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl, voltageLevel, calYear, qfzd,
				jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd,
				tyrq, nn, ccrq, isMatched);
	}

	/**
	 * 2020-07-21
	 * 
	 * @param midPmsItemId
	 * @param version
	 * @param sbbm
	 * @param orgName
	 * @param dvPmsAssetClassId
	 * @param zcDl
	 * @param zcZl
	 * @param zcXl
	 * @param voltageLevel
	 * @param calYear
	 * @param qfzd
	 * @param jkzt
	 * @param yxzt
	 * @param ywdw
	 * @param zckbm
	 * @param zcyz
	 * @param zjtyrq
	 * @param zcxz
	 * @param sl
	 * @param sl1
	 * @param sl2
	 * @param sl3
	 * @param jldw
	 * @param zzsmc
	 * @param ssxlbdz
	 * @param sbxh
	 * @param tynf
	 * @param nnd
	 * @param tyrq
	 * @param nn
	 * @param ccrq
	 * @param isMatched
	 * @param equipmentName
	 * @param assetId
	 * @param equipmentIncreaseMode
	 * @param lineProperty
	 * @param zcdl2
	 * @param sblx
	 * @param dvDateValue
	 * @param slOld
	 * @param oldVoltageLevel2
	 * @param oldZcxz
	 * @param discription
	 * @param oldYxzt
	 * @param oldTyrq
	 * @param oldCcrq
	 */
	public MidPmsItem(String midPmsItemId, String version, String sbbm, String orgName, String dvPmsAssetClassId,
			String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear, String qfzd, String jkzt,
			String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz, Double sl, Double sl1,
			Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh, Integer tynf, String nnd,
			Date tyrq, Integer nn, Date ccrq, String isMatched, String equipmentName, String assetId,
			String equipmentIncreaseMode, String lineProperty, String zcdl2, String sblx, Date dvDateValue,
			Double slOld, String oldVoltageLevel2, String oldZcxz, String discription, String oldYxzt, Date oldTyrq,
			Date oldCcrq) {
		super(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl, voltageLevel, calYear, qfzd,
				jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd,
				tyrq, nn, ccrq, isMatched, equipmentName, assetId, equipmentIncreaseMode, lineProperty, zcdl2, sblx,
				dvDateValue, slOld, oldVoltageLevel2, oldZcxz, discription, oldYxzt, oldTyrq, oldCcrq);
		// TODO Auto-generated constructor stub
	}

	/** full constructor 20200527 */
	public MidPmsItem(String midPmsItemId, String version, String sbbm, String orgName, String dvPmsAssetClassId,
			String zcDl, String zcZl, String zcXl, String voltageLevel, Date calYear, String qfzd, String jkzt,
			String yxzt, String ywdw, String zckbm, Double zcyz, Date zjtyrq, String zcxz, Double sl, Double sl1,
			Double sl2, Double sl3, String jldw, String zzsmc, String ssxlbdz, String sbxh, Integer tynf, String nnd,
			Date tyrq, Integer nn, Date ccrq, String isMatched, String equipmentName, String assetId,
			String equipmentIncreaseMode, String lineProperty, String zcdl, String sblx, Date dvDateValue) {
		super(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl, voltageLevel, calYear, qfzd,
				jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd,
				tyrq, nn, ccrq, isMatched, equipmentName, assetId, equipmentIncreaseMode, lineProperty, zcdl, sblx,
				dvDateValue);
	}

}
