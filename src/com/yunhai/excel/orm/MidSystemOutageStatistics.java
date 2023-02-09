package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidSystemOutageStatistics entity. @author MyEclipse Persistence Tools
 */
public class MidSystemOutageStatistics extends AbstractMidSystemOutageStatistics implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MidSystemOutageStatistics() {
	}

	/** minimal constructor */
	public MidSystemOutageStatistics(String midSystemOutageStatisId) {
		super(midSystemOutageStatisId);
	}

	/** full constructor */
	public MidSystemOutageStatistics(String midSystemOutageStatisId, String version, Date calYear, String orgName,
			String largeDutyReason, String mediumDutyReason, String smallDutyReason, Double powerOutageCustomerTimes1,
			Double powerOutageTimeCustomerQt1, Double powerOutageCustomerTimes2, Double powerOutageTimeCustomerQt2,
			Double powerOutageCustomerTimes3, Double powerOutageTimeCustomerQt3, Double powerOutageCustomerTimes4,
			Double powerOutageTimeCustomerQt4, Double powerOutageCustomerTimes5, Double powerOutageTimeCustomerQt5,
			Date dvDateValue, String dutyReasonCategory, String areaName) {
		super(midSystemOutageStatisId, version, calYear, orgName, largeDutyReason, mediumDutyReason, smallDutyReason,
				powerOutageCustomerTimes1, powerOutageTimeCustomerQt1, powerOutageCustomerTimes2,
				powerOutageTimeCustomerQt2, powerOutageCustomerTimes3, powerOutageTimeCustomerQt3,
				powerOutageCustomerTimes4, powerOutageTimeCustomerQt4, powerOutageCustomerTimes5,
				powerOutageTimeCustomerQt5, dvDateValue, dutyReasonCategory, areaName);
	}

}
