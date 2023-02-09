package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidEquipBreakdownSatistics entity. @author MyEclipse Persistence Tools
 */
public class MidEquipBreakdownSatistics extends AbstractMidEquipBreakdownSatistics implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidEquipBreakdownSatistics() {
	}

	/** minimal constructor */
	public MidEquipBreakdownSatistics(String midEquipBreakdownSatisId) {
		super(midEquipBreakdownSatisId);
	}

	/** full constructor */
	public MidEquipBreakdownSatistics(String midEquipBreakdownSatisId, String version, Date calYear,
			String orgName, String largeDutyReason, String mediumDutyReason, String smallDutyReason,
			Double transmissionBreakdownTimes1, Double transformerBreakdownTimes1, Double distributionBreakdownTimes1,
			Double transmissionBreakdownTimes2, Double transformerBreakdownTimes2, Double distributionBreakdownTimes2,
			Double transmissionBreakdownTimes3, Double transformerBreakdownTimes3, Double distributionBreakdownTimes3,
			Double transmissionBreakdownTimes4, Double transformerBreakdownTimes4, Double distributionBreakdownTimes4,
			Double transmissionBreakdownTimes5, Double transformerBreakdownTimes5, Double distributionBreakdownTimes5,
			Date dvDateValue, String dutyReasonCategory, String areaName) {
		super(midEquipBreakdownSatisId, version, calYear, orgName, largeDutyReason, mediumDutyReason, smallDutyReason,
				transmissionBreakdownTimes1, transformerBreakdownTimes1, distributionBreakdownTimes1,
				transmissionBreakdownTimes2, transformerBreakdownTimes2, distributionBreakdownTimes2,
				transmissionBreakdownTimes3, transformerBreakdownTimes3, distributionBreakdownTimes3,
				transmissionBreakdownTimes4, transformerBreakdownTimes4, distributionBreakdownTimes4,
				transmissionBreakdownTimes5, transformerBreakdownTimes5, distributionBreakdownTimes5, dvDateValue,
				dutyReasonCategory, areaName);
	}

}
