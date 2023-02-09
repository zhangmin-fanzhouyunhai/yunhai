package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidDiscardReasonDistribute entity. @author MyEclipse Persistence Tools
 */
public class MidDiscardReasonDistribute extends AbstractMidDiscardReasonDistribute implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidDiscardReasonDistribute() {
	}

	/** minimal constructor */
	public MidDiscardReasonDistribute(String midDiscardReasonDistrId) {
		super(midDiscardReasonDistrId);
	}

	/** full constructor */
	public MidDiscardReasonDistribute(String midDiscardReasonDistrId, String version, Date calYear, String orgName,
			String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double origValueDiscardReason1, Double origValueDiscardReason2, Double origValueDiscardReason3,
			Double origValueDiscardReason4, Double origValueDiscardReason5, Double origValueDiscardReason6,
			Double origValueDiscardReason7, Double origValueDiscardReason8, Double netValueDiscardReason1,
			Double netValueDiscardReason2, Double netValueDiscardReason3, Double netValueDiscardReason4,
			Double netValueDiscardReason5, Double netValueDiscardReason6, Double netValueDiscardReason7,
			Double netValueDiscardReason8, Double quantityDiscardReason1, Double quantityDiscardReason2,
			Double quantityDiscardReason3, Double quantityDiscardReason4, Double quantityDiscardReason5,
			Double quantityDiscardReason6, Double quantityDiscardReason7, Double quantityDiscardReason8,
			Date dvDateValue, String category, String areaName) {
		super(midDiscardReasonDistrId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				origValueDiscardReason1, origValueDiscardReason2, origValueDiscardReason3, origValueDiscardReason4,
				origValueDiscardReason5, origValueDiscardReason6, origValueDiscardReason7, origValueDiscardReason8,
				netValueDiscardReason1, netValueDiscardReason2, netValueDiscardReason3, netValueDiscardReason4,
				netValueDiscardReason5, netValueDiscardReason6, netValueDiscardReason7, netValueDiscardReason8,
				quantityDiscardReason1, quantityDiscardReason2, quantityDiscardReason3, quantityDiscardReason4,
				quantityDiscardReason5, quantityDiscardReason6, quantityDiscardReason7, quantityDiscardReason8,
				dvDateValue, category, areaName);
	}

}
