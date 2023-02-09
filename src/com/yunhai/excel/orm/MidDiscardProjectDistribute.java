package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidDiscardProjectDistribute entity. @author MyEclipse Persistence Tools
 */
public class MidDiscardProjectDistribute extends AbstractMidDiscardProjectDistribute implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidDiscardProjectDistribute() {
	}

	/** minimal constructor */
	public MidDiscardProjectDistribute(String midDiscardProjDistribId) {
		super(midDiscardProjDistribId);
	}

	/** full constructor */
	public MidDiscardProjectDistribute(String midDiscardProjDistribId, String version, Date calYear,
			String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel,
			Double origValueProject1, Double origValueProject2, Double origValueProject3, Double origValueProject4,
			Double netValueProject1, Double netValueProject2, Double netValueProject3, Double netValueProject4,
			Double quantityProject1, Double quantityProject2, Double quantityProject3, Double quantityProject4,
			Date dvDateValue, String category, String areaName) {
		super(midDiscardProjDistribId, version, calYear, orgName, largeClass, mediumClass, smallClass, voltageLevel,
				origValueProject1, origValueProject2, origValueProject3, origValueProject4, netValueProject1,
				netValueProject2, netValueProject3, netValueProject4, quantityProject1, quantityProject2,
				quantityProject3, quantityProject4, dvDateValue, category, areaName);
	}

}
