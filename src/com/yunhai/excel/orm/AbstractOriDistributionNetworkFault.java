package com.yunhai.excel.orm;

import java.io.Serializable;
import java.util.Date;

public class AbstractOriDistributionNetworkFault implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2278986862834656580L;
	private String oriDistributNetworkFaultId;
	private Date calYear;
	private String dataVersion;
	private String auditType;
	private String orgCode;
	private String orgName;
	private String incidentId;
	private String responsibleDepartCode;
	private String responsibleDepartment;
	private String provinceName;
	private Date startTime;
	private Date endTime;
	private Double lastTime;
	private Double circuitLineTimes;
	private Double userTimes;
	private Double timeMultipUserQuantity;
	private Double lackPowerSupplyQuantity;
	private String powerCutProperty;
	private String ignoreReason;
	private String powerCutEquipmentId;
	private String powerCutEquipmentName;
	private String techniqueReasonCode;
	private String techniqueReasonName;
	private String dutyReasonCode;
	private String dutyReasonName;
	private String specialAnalysis;
	private String powerCutPropertyCode;
	private String resume;
	private Date increaseRegisteDate;
	private Date userModifiedDate;
	private Date systemManipulateDate;
	private Date conformIgnoreApplyDate;
	private Date powerOutageRevisionTime;
	private Date nationalGridAuditTime;
	private String nationalGridAuditor;
	private Date natiGridProvinceAuditTime;
	private String natiGridProvinceAuditor;
	private Date natiGridMunicipalAuditTime;
	private String natiGridMunicipalAuditor;
	private String operator;
	private String recordObjId;
	private String managementProperty;
	private String abnormalState;
	private Date abnormalUpdateTime;
	private String abnormalDataReasonCode;
	private String abnormalDataMarkerOrgCode;
	private String markAuditOrgCode;
	private Date markAuditTime;
	private String isMajorEventDay;
	private String objId;
	private String objDispidx;
	private String dataSourceFile;
	/** default constructor */
	public AbstractOriDistributionNetworkFault() {

	}

	/** full constructor */
	public AbstractOriDistributionNetworkFault(String oriDistributNetworkFaultId, Date calYear, String dataVersion,
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
			String markAuditOrgCode, Date markAuditTime, String isMajorEventDay, String objId, String objDispidx,String dataSourceFile) {
		super();
		this.oriDistributNetworkFaultId = oriDistributNetworkFaultId;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.auditType = auditType;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.incidentId = incidentId;
		this.responsibleDepartCode = responsibleDepartCode;
		this.responsibleDepartment = responsibleDepartment;
		this.provinceName = provinceName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.lastTime = lastTime;
		this.circuitLineTimes = circuitLineTimes;
		this.userTimes = userTimes;
		this.timeMultipUserQuantity = timeMultipUserQuantity;
		this.lackPowerSupplyQuantity = lackPowerSupplyQuantity;
		this.powerCutProperty = powerCutProperty;
		this.ignoreReason = ignoreReason;
		this.powerCutEquipmentId = powerCutEquipmentId;
		this.powerCutEquipmentName = powerCutEquipmentName;
		this.techniqueReasonCode = techniqueReasonCode;
		this.techniqueReasonName = techniqueReasonName;
		this.dutyReasonCode = dutyReasonCode;
		this.dutyReasonName = dutyReasonName;
		this.specialAnalysis = specialAnalysis;
		this.powerCutPropertyCode = powerCutPropertyCode;
		this.resume = resume;
		this.increaseRegisteDate = increaseRegisteDate;
		this.userModifiedDate = userModifiedDate;
		this.systemManipulateDate = systemManipulateDate;
		this.conformIgnoreApplyDate = conformIgnoreApplyDate;
		this.powerOutageRevisionTime = powerOutageRevisionTime;
		this.nationalGridAuditTime = nationalGridAuditTime;
		this.nationalGridAuditor = nationalGridAuditor;
		this.natiGridProvinceAuditTime = natiGridProvinceAuditTime;
		this.natiGridProvinceAuditor = natiGridProvinceAuditor;
		this.natiGridMunicipalAuditTime = natiGridMunicipalAuditTime;
		this.natiGridMunicipalAuditor = natiGridMunicipalAuditor;
		this.operator = operator;
		this.recordObjId = recordObjId;
		this.managementProperty = managementProperty;
		this.abnormalState = abnormalState;
		this.abnormalUpdateTime = abnormalUpdateTime;
		this.abnormalDataReasonCode = abnormalDataReasonCode;
		this.abnormalDataMarkerOrgCode = abnormalDataMarkerOrgCode;
		this.markAuditOrgCode = markAuditOrgCode;
		this.markAuditTime = markAuditTime;
		this.isMajorEventDay = isMajorEventDay;
		this.objId = objId;
		this.objDispidx = objDispidx;
		this.dataSourceFile = dataSourceFile;
	}

	  
	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getOriDistributNetworkFaultId() {
		return oriDistributNetworkFaultId;
	}

	public void setOriDistributNetworkFaultId(String oriDistributNetworkFaultId) {
		this.oriDistributNetworkFaultId = oriDistributNetworkFaultId;
	}

	public Date getCalYear() {
		return calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getResponsibleDepartCode() {
		return responsibleDepartCode;
	}

	public void setResponsibleDepartCode(String responsibleDepartCode) {
		this.responsibleDepartCode = responsibleDepartCode;
	}

	public String getResponsibleDepartment() {
		return responsibleDepartment;
	}

	public void setResponsibleDepartment(String responsibleDepartment) {
		this.responsibleDepartment = responsibleDepartment;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getLastTime() {
		return lastTime;
	}

	public void setLastTime(Double lastTime) {
		this.lastTime = lastTime;
	}

	public Double getCircuitLineTimes() {
		return circuitLineTimes;
	}

	public void setCircuitLineTimes(Double circuitLineTimes) {
		this.circuitLineTimes = circuitLineTimes;
	}

	public Double getUserTimes() {
		return userTimes;
	}

	public void setUserTimes(Double userTimes) {
		this.userTimes = userTimes;
	}

	public Double getTimeMultipUserQuantity() {
		return timeMultipUserQuantity;
	}

	public void setTimeMultipUserQuantity(Double timeMultipUserQuantity) {
		this.timeMultipUserQuantity = timeMultipUserQuantity;
	}

	public Double getLackPowerSupplyQuantity() {
		return lackPowerSupplyQuantity;
	}

	public void setLackPowerSupplyQuantity(Double lackPowerSupplyQuantity) {
		this.lackPowerSupplyQuantity = lackPowerSupplyQuantity;
	}

	public String getPowerCutProperty() {
		return powerCutProperty;
	}

	public void setPowerCutProperty(String powerCutProperty) {
		this.powerCutProperty = powerCutProperty;
	}

	public String getIgnoreReason() {
		return ignoreReason;
	}

	public void setIgnoreReason(String ignoreReason) {
		this.ignoreReason = ignoreReason;
	}

	public String getPowerCutEquipmentId() {
		return powerCutEquipmentId;
	}

	public void setPowerCutEquipmentId(String powerCutEquipmentId) {
		this.powerCutEquipmentId = powerCutEquipmentId;
	}

	public String getPowerCutEquipmentName() {
		return powerCutEquipmentName;
	}

	public void setPowerCutEquipmentName(String powerCutEquipmentName) {
		this.powerCutEquipmentName = powerCutEquipmentName;
	}

	public String getTechniqueReasonCode() {
		return techniqueReasonCode;
	}

	public void setTechniqueReasonCode(String techniqueReasonCode) {
		this.techniqueReasonCode = techniqueReasonCode;
	}

	public String getTechniqueReasonName() {
		return techniqueReasonName;
	}

	public void setTechniqueReasonName(String techniqueReasonName) {
		this.techniqueReasonName = techniqueReasonName;
	}

	public String getDutyReasonCode() {
		return dutyReasonCode;
	}

	public void setDutyReasonCode(String dutyReasonCode) {
		this.dutyReasonCode = dutyReasonCode;
	}

	public String getDutyReasonName() {
		return dutyReasonName;
	}

	public void setDutyReasonName(String dutyReasonName) {
		this.dutyReasonName = dutyReasonName;
	}

	public String getSpecialAnalysis() {
		return specialAnalysis;
	}

	public void setSpecialAnalysis(String specialAnalysis) {
		this.specialAnalysis = specialAnalysis;
	}

	public String getPowerCutPropertyCode() {
		return powerCutPropertyCode;
	}

	public void setPowerCutPropertyCode(String powerCutPropertyCode) {
		this.powerCutPropertyCode = powerCutPropertyCode;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Date getIncreaseRegisteDate() {
		return increaseRegisteDate;
	}

	public void setIncreaseRegisteDate(Date increaseRegisteDate) {
		this.increaseRegisteDate = increaseRegisteDate;
	}

	public Date getUserModifiedDate() {
		return userModifiedDate;
	}

	public void setUserModifiedDate(Date userModifiedDate) {
		this.userModifiedDate = userModifiedDate;
	}

	public Date getSystemManipulateDate() {
		return systemManipulateDate;
	}

	public void setSystemManipulateDate(Date systemManipulateDate) {
		this.systemManipulateDate = systemManipulateDate;
	}

	public Date getConformIgnoreApplyDate() {
		return conformIgnoreApplyDate;
	}

	public void setConformIgnoreApplyDate(Date conformIgnoreApplyDate) {
		this.conformIgnoreApplyDate = conformIgnoreApplyDate;
	}

	public Date getPowerOutageRevisionTime() {
		return powerOutageRevisionTime;
	}

	public void setPowerOutageRevisionTime(Date powerOutageRevisionTime) {
		this.powerOutageRevisionTime = powerOutageRevisionTime;
	}

	public Date getNationalGridAuditTime() {
		return nationalGridAuditTime;
	}

	public void setNationalGridAuditTime(Date nationalGridAuditTime) {
		this.nationalGridAuditTime = nationalGridAuditTime;
	}

	public String getNationalGridAuditor() {
		return nationalGridAuditor;
	}

	public void setNationalGridAuditor(String nationalGridAuditor) {
		this.nationalGridAuditor = nationalGridAuditor;
	}

	public Date getNatiGridProvinceAuditTime() {
		return natiGridProvinceAuditTime;
	}

	public void setNatiGridProvinceAuditTime(Date natiGridProvinceAuditTime) {
		this.natiGridProvinceAuditTime = natiGridProvinceAuditTime;
	}

	public String getNatiGridProvinceAuditor() {
		return natiGridProvinceAuditor;
	}

	public void setNatiGridProvinceAuditor(String natiGridProvinceAuditor) {
		this.natiGridProvinceAuditor = natiGridProvinceAuditor;
	}

	public Date getNatiGridMunicipalAuditTime() {
		return natiGridMunicipalAuditTime;
	}

	public void setNatiGridMunicipalAuditTime(Date natiGridMunicipalAuditTime) {
		this.natiGridMunicipalAuditTime = natiGridMunicipalAuditTime;
	}

	public String getNatiGridMunicipalAuditor() {
		return natiGridMunicipalAuditor;
	}

	public void setNatiGridMunicipalAuditor(String natiGridMunicipalAuditor) {
		this.natiGridMunicipalAuditor = natiGridMunicipalAuditor;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRecordObjId() {
		return recordObjId;
	}

	public void setRecordObjId(String recordObjId) {
		this.recordObjId = recordObjId;
	}

	public String getManagementProperty() {
		return managementProperty;
	}

	public void setManagementProperty(String managementProperty) {
		this.managementProperty = managementProperty;
	}

	public String getAbnormalState() {
		return abnormalState;
	}

	public void setAbnormalState(String abnormalState) {
		this.abnormalState = abnormalState;
	}

	public Date getAbnormalUpdateTime() {
		return abnormalUpdateTime;
	}

	public void setAbnormalUpdateTime(Date abnormalUpdateTime) {
		this.abnormalUpdateTime = abnormalUpdateTime;
	}

	public String getAbnormalDataReasonCode() {
		return abnormalDataReasonCode;
	}

	public void setAbnormalDataReasonCode(String abnormalDataReasonCode) {
		this.abnormalDataReasonCode = abnormalDataReasonCode;
	}

	public String getAbnormalDataMarkerOrgCode() {
		return abnormalDataMarkerOrgCode;
	}

	public void setAbnormalDataMarkerOrgCode(String abnormalDataMarkerOrgCode) {
		this.abnormalDataMarkerOrgCode = abnormalDataMarkerOrgCode;
	}

	public String getMarkAuditOrgCode() {
		return markAuditOrgCode;
	}

	public void setMarkAuditOrgCode(String markAuditOrgCode) {
		this.markAuditOrgCode = markAuditOrgCode;
	}

	public Date getMarkAuditTime() {
		return markAuditTime;
	}

	public void setMarkAuditTime(Date markAuditTime) {
		this.markAuditTime = markAuditTime;
	}

	public String getIsMajorEventDay() {
		return isMajorEventDay;
	}

	public void setIsMajorEventDay(String isMajorEventDay) {
		this.isMajorEventDay = isMajorEventDay;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getObjDispidx() {
		return objDispidx;
	}

	public void setObjDispidx(String objDispidx) {
		this.objDispidx = objDispidx;
	}

}
