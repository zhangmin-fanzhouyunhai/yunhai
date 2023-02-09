package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriEquipmentBreakdown entity. @author MyEclipse Persistence Tools
 */
public class OriEquipmentBreakdown extends AbstractOriEquipmentBreakdown implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriEquipmentBreakdown() {
	}

	/** minimal constructor */
	public OriEquipmentBreakdown(String oriEquipmentBreakdownId, String dataVersion) {
		super(oriEquipmentBreakdownId, dataVersion);
	}

	/** full constructor */
	public OriEquipmentBreakdown(String oriEquipmentBreakdownId, String dataVersion, Date calYear, String orgName,
			String maintainanceOrgName, String transformerSubstation, String voltageLevel, String faultyLine,
			String faultEquipment, Date timeOfFailure, String treatmentProcess, String technicalReasons,
			String dutyReason, Double recordingRangeFinding, Double faultCurrentKa, String isFaultOverstepped,
			String failureOutageScope, String failureSatuiation, String isInStationFault, String faultType,
			String weatherInFailurePeriod, String faultClassification, String isLocked, String extremelyBlockedAction,
			String reclosureOperation, String faultPhase, String isOutage, String isTripping, String simpleFault,
			Long particularYear, String dutyReasonLargeClass, String dutyReasonMediumClass, String major,
			String dataSourceFile) {
		super(oriEquipmentBreakdownId, dataVersion, calYear, orgName, maintainanceOrgName, transformerSubstation,
				voltageLevel, faultyLine, faultEquipment, timeOfFailure, treatmentProcess, technicalReasons, dutyReason,
				recordingRangeFinding, faultCurrentKa, isFaultOverstepped, failureOutageScope, failureSatuiation,
				isInStationFault, faultType, weatherInFailurePeriod, faultClassification, isLocked,
				extremelyBlockedAction, reclosureOperation, faultPhase, isOutage, isTripping, simpleFault,
				particularYear, dutyReasonLargeClass, dutyReasonMediumClass, major, dataSourceFile);
	}

}
