package com.yunhai.excel.orm;

import java.util.Date;

public class OriDistributionNetworkFault extends AbstractOriDistributionNetworkFault implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798074133753263715L;

	/** default constructor */
	public OriDistributionNetworkFault() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	public OriDistributionNetworkFault(String oriDistributNetworkFaultId, Date calYear, String dataVersion,
			String auditType, String orgCode, String orgName, String incidentId, String responsibleDepartCode,
			String responsibleDepartment, String provinceName, Date startTime, Date endTime, Double lastTime,
			Double circuitLineTimes, Double userTimes, Double timeMultipUserQuantity, Double lackPowerSupplyQuantity,
			String powerCutProperty, String ignoreReason, String powerCutEquipmentId, String powerCutEquipmentName,
			String techniqueReasonCode, String techniqueReasonName, String dutyReasonCode, String dutyReasonName,
			String specialAnalysis, String powerCutPropertyCode, String resume, Date increaseRegisteDate,
			Date userModifiedDate, Date systemManipulateDate, Date conformIgnoreApplyDate, Date powerOutageRevisionTime,
			Date nationalGridAuditTime, String nationalGridAuditor, Date natiGridProvinceAuditTime,
			String natiGridProvinceAuditor, Date natiGridMunicipalAuditTime, String natiGridMunicipalAuditor,
			String operator, String recordObjId, String managementProperty, String abnormalState,
			Date abnormalUpdateTime, String abnormalDataReasonCode, String abnormalDataMarkerOrgCode,
			String markAuditOrgCode, Date markAuditTime, String isMajorEventDay, String objId, String objDispidx,
			String dataSourceFile) {
		super(oriDistributNetworkFaultId, calYear, dataVersion, auditType, orgCode, orgName, incidentId,
				responsibleDepartCode, responsibleDepartment, provinceName, startTime, endTime, lastTime,
				circuitLineTimes, userTimes, timeMultipUserQuantity, lackPowerSupplyQuantity, powerCutProperty,
				ignoreReason, powerCutEquipmentId, powerCutEquipmentName, techniqueReasonCode, techniqueReasonName,
				dutyReasonCode, dutyReasonName, specialAnalysis, powerCutPropertyCode, resume, increaseRegisteDate,
				userModifiedDate, systemManipulateDate, conformIgnoreApplyDate, powerOutageRevisionTime,
				nationalGridAuditTime, nationalGridAuditor, natiGridProvinceAuditTime, natiGridProvinceAuditor,
				natiGridMunicipalAuditTime, natiGridMunicipalAuditor, operator, recordObjId, managementProperty,
				abnormalState, abnormalUpdateTime, abnormalDataReasonCode, abnormalDataMarkerOrgCode, markAuditOrgCode,
				markAuditTime, isMajorEventDay, objId, objDispidx, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
