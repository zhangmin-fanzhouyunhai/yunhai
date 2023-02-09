package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidEquipForceOutageStatist entity. @author MyEclipse Persistence Tools
 */
public class MidEquipForceOutageStatist extends AbstractMidEquipForceOutageStatist implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidEquipForceOutageStatist() {
	}

	/** minimal constructor */
	public MidEquipForceOutageStatist(String midEquipForceOutageStaId) {
		super(midEquipForceOutageStaId);
	}

	/** full constructor */
	public MidEquipForceOutageStatist(String midEquipForceOutageStaId, String version, Date calYear,
			String orgName, String assetClass, String dutyReason, String smallDutyReason,
			Double equipForceOutageTimesYear1, Double equipForceOutageTimesYear2, Double equipForceOutageTimesYear3,
			Double equipForceOutageTimesYear4, Double equipForceOutageTimesYear5, Date dvDateValue,
			String dutyReasonCategory, String areaName) {
		super(midEquipForceOutageStaId, version, calYear, orgName, assetClass, dutyReason, smallDutyReason,
				equipForceOutageTimesYear1, equipForceOutageTimesYear2, equipForceOutageTimesYear3,
				equipForceOutageTimesYear4, equipForceOutageTimesYear5, dvDateValue, dutyReasonCategory, areaName);
	}

}
