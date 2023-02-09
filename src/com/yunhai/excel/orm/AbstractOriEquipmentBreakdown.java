package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOriEquipmentBreakdown entity provides the base persistence definition
 * of the OriEquipmentBreakdown entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriEquipmentBreakdown implements java.io.Serializable {

	// Fields

	private String oriEquipmentBreakdownId;
	private String dataVersion;
	private Date calYear;
	private String orgName;
	private String maintainanceOrgName;
	private String transformerSubstation;
	private String voltageLevel;
	private String faultyLine;
	private String faultEquipment;
	private Date timeOfFailure;
	private String treatmentProcess;
	private String technicalReasons;
	private String dutyReason;
	private Double recordingRangeFinding;
	private Double faultCurrentKa;
	private String isFaultOverstepped;
	private String failureOutageScope;
	private String failureSatuiation;
	private String isInStationFault;
	private String faultType;
	private String weatherInFailurePeriod;
	private String faultClassification;
	private String isLocked;
	private String extremelyBlockedAction;
	private String reclosureOperation;
	private String faultPhase;
	private String isOutage;
	private String isTripping;
	private String simpleFault;
	private Long particularYear;
	private String dutyReasonLargeClass;
	private String dutyReasonMediumClass;
	private String major;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriEquipmentBreakdown() {
	}

	/** minimal constructor */
	public AbstractOriEquipmentBreakdown(String oriEquipmentBreakdownId, String dataVersion) {
		this.oriEquipmentBreakdownId = oriEquipmentBreakdownId;
		this.dataVersion = dataVersion;
	}

	/** full constructor */
	public AbstractOriEquipmentBreakdown(String oriEquipmentBreakdownId, String dataVersion, Date calYear,
			String orgName, String maintainanceOrgName, String transformerSubstation, String voltageLevel,
			String faultyLine, String faultEquipment, Date timeOfFailure, String treatmentProcess,
			String technicalReasons, String dutyReason, Double recordingRangeFinding, Double faultCurrentKa,
			String isFaultOverstepped, String failureOutageScope, String failureSatuiation, String isInStationFault,
			String faultType, String weatherInFailurePeriod, String faultClassification, String isLocked,
			String extremelyBlockedAction, String reclosureOperation, String faultPhase, String isOutage,
			String isTripping, String simpleFault, Long particularYear, String dutyReasonLargeClass,
			String dutyReasonMediumClass, String major, String dataSourceFile) {
		this.oriEquipmentBreakdownId = oriEquipmentBreakdownId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.orgName = orgName;
		this.maintainanceOrgName = maintainanceOrgName;
		this.transformerSubstation = transformerSubstation;
		this.voltageLevel = voltageLevel;
		this.faultyLine = faultyLine;
		this.faultEquipment = faultEquipment;
		this.timeOfFailure = timeOfFailure;
		this.treatmentProcess = treatmentProcess;
		this.technicalReasons = technicalReasons;
		this.dutyReason = dutyReason;
		this.recordingRangeFinding = recordingRangeFinding;
		this.faultCurrentKa = faultCurrentKa;
		this.isFaultOverstepped = isFaultOverstepped;
		this.failureOutageScope = failureOutageScope;
		this.failureSatuiation = failureSatuiation;
		this.isInStationFault = isInStationFault;
		this.faultType = faultType;
		this.weatherInFailurePeriod = weatherInFailurePeriod;
		this.faultClassification = faultClassification;
		this.isLocked = isLocked;
		this.extremelyBlockedAction = extremelyBlockedAction;
		this.reclosureOperation = reclosureOperation;
		this.faultPhase = faultPhase;
		this.isOutage = isOutage;
		this.isTripping = isTripping;
		this.simpleFault = simpleFault;
		this.particularYear = particularYear;
		this.dutyReasonLargeClass = dutyReasonLargeClass;
		this.dutyReasonMediumClass = dutyReasonMediumClass;
		this.major = major;
		this.dataSourceFile = dataSourceFile;
	}

	// Property accessors

	public String getOriEquipmentBreakdownId() {
		return this.oriEquipmentBreakdownId;
	}

	public void setOriEquipmentBreakdownId(String oriEquipmentBreakdownId) {
		this.oriEquipmentBreakdownId = oriEquipmentBreakdownId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMaintainanceOrgName() {
		return this.maintainanceOrgName;
	}

	public void setMaintainanceOrgName(String maintainanceOrgName) {
		this.maintainanceOrgName = maintainanceOrgName;
	}

	public String getTransformerSubstation() {
		return this.transformerSubstation;
	}

	public void setTransformerSubstation(String transformerSubstation) {
		this.transformerSubstation = transformerSubstation;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getFaultyLine() {
		return this.faultyLine;
	}

	public void setFaultyLine(String faultyLine) {
		this.faultyLine = faultyLine;
	}

	public String getFaultEquipment() {
		return this.faultEquipment;
	}

	public void setFaultEquipment(String faultEquipment) {
		this.faultEquipment = faultEquipment;
	}

	public Date getTimeOfFailure() {
		return this.timeOfFailure;
	}

	public void setTimeOfFailure(Date timeOfFailure) {
		this.timeOfFailure = timeOfFailure;
	}

	public String getTreatmentProcess() {
		return this.treatmentProcess;
	}

	public void setTreatmentProcess(String treatmentProcess) {
		this.treatmentProcess = treatmentProcess;
	}

	public String getTechnicalReasons() {
		return this.technicalReasons;
	}

	public void setTechnicalReasons(String technicalReasons) {
		this.technicalReasons = technicalReasons;
	}

	public String getDutyReason() {
		return this.dutyReason;
	}

	public void setDutyReason(String dutyReason) {
		this.dutyReason = dutyReason;
	}

	public Double getRecordingRangeFinding() {
		return this.recordingRangeFinding;
	}

	public void setRecordingRangeFinding(Double recordingRangeFinding) {
		this.recordingRangeFinding = recordingRangeFinding;
	}

	public Double getFaultCurrentKa() {
		return this.faultCurrentKa;
	}

	public void setFaultCurrentKa(Double faultCurrentKa) {
		this.faultCurrentKa = faultCurrentKa;
	}

	public String getIsFaultOverstepped() {
		return this.isFaultOverstepped;
	}

	public void setIsFaultOverstepped(String isFaultOverstepped) {
		this.isFaultOverstepped = isFaultOverstepped;
	}

	public String getFailureOutageScope() {
		return this.failureOutageScope;
	}

	public void setFailureOutageScope(String failureOutageScope) {
		this.failureOutageScope = failureOutageScope;
	}

	public String getFailureSatuiation() {
		return this.failureSatuiation;
	}

	public void setFailureSatuiation(String failureSatuiation) {
		this.failureSatuiation = failureSatuiation;
	}

	public String getIsInStationFault() {
		return this.isInStationFault;
	}

	public void setIsInStationFault(String isInStationFault) {
		this.isInStationFault = isInStationFault;
	}

	public String getFaultType() {
		return this.faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public String getWeatherInFailurePeriod() {
		return this.weatherInFailurePeriod;
	}

	public void setWeatherInFailurePeriod(String weatherInFailurePeriod) {
		this.weatherInFailurePeriod = weatherInFailurePeriod;
	}

	public String getFaultClassification() {
		return this.faultClassification;
	}

	public void setFaultClassification(String faultClassification) {
		this.faultClassification = faultClassification;
	}

	public String getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}

	public String getExtremelyBlockedAction() {
		return this.extremelyBlockedAction;
	}

	public void setExtremelyBlockedAction(String extremelyBlockedAction) {
		this.extremelyBlockedAction = extremelyBlockedAction;
	}

	public String getReclosureOperation() {
		return this.reclosureOperation;
	}

	public void setReclosureOperation(String reclosureOperation) {
		this.reclosureOperation = reclosureOperation;
	}

	public String getFaultPhase() {
		return this.faultPhase;
	}

	public void setFaultPhase(String faultPhase) {
		this.faultPhase = faultPhase;
	}

	public String getIsOutage() {
		return this.isOutage;
	}

	public void setIsOutage(String isOutage) {
		this.isOutage = isOutage;
	}

	public String getIsTripping() {
		return this.isTripping;
	}

	public void setIsTripping(String isTripping) {
		this.isTripping = isTripping;
	}

	public String getSimpleFault() {
		return this.simpleFault;
	}

	public void setSimpleFault(String simpleFault) {
		this.simpleFault = simpleFault;
	}

	public Long getParticularYear() {
		return this.particularYear;
	}

	public void setParticularYear(Long particularYear) {
		this.particularYear = particularYear;
	}

	public String getDutyReasonLargeClass() {
		return this.dutyReasonLargeClass;
	}

	public void setDutyReasonLargeClass(String dutyReasonLargeClass) {
		this.dutyReasonLargeClass = dutyReasonLargeClass;
	}

	public String getDutyReasonMediumClass() {
		return this.dutyReasonMediumClass;
	}

	public void setDutyReasonMediumClass(String dutyReasonMediumClass) {
		this.dutyReasonMediumClass = dutyReasonMediumClass;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDataSourceFile() {
		return this.dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

}