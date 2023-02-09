package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriWorkTaskInvoice entity provides the base persistence definition of
 * the OriWorkTaskInvoice entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriWorkTaskInvoice implements java.io.Serializable {

	// Fields

	private String oriWorkTaskInvoiceId;
	private String dataVersion;
	private Date calYear;
	private String dataFile;
	private String objId;
	private String taskInvoiceName;
	private Date preparationDate;
	private String taskContent;
	private String powerStationLine;
	private Date plannedStartTime;
	private Date plannedEndTime;
	private String isPowerFailure;
	private String approvedOutageStartTime;
	private String approvedOutageEndTime;
	private String powerCutScope;
	private String taskArrangerName;
	private String completionPhase;
	private String major;
	private String belongedCityName;
	private String preparationDepartmentName;
	private String stationLineType;
	private String whetherAllocateOtherOrg;
	private String responsibleOrg;

	// Constructors

	/** default constructor */
	public AbstractOriWorkTaskInvoice() {
	}

	/** minimal constructor */
	public AbstractOriWorkTaskInvoice(String oriWorkTaskInvoiceId, String dataVersion, String dataFile) {
		this.oriWorkTaskInvoiceId = oriWorkTaskInvoiceId;
		this.dataVersion = dataVersion;
		this.dataFile = dataFile;
	}

	/** full constructor */
	public AbstractOriWorkTaskInvoice(String oriWorkTaskInvoiceId, String dataVersion, Date calYear,
			String dataFile, String objId, String taskInvoiceName, Date preparationDate, String taskContent,
			String powerStationLine, Date plannedStartTime, Date plannedEndTime, String isPowerFailure,
			String approvedOutageStartTime, String approvedOutageEndTime, String powerCutScope, String taskArrangerName,
			String completionPhase, String major, String belongedCityName, String preparationDepartmentName,
			String stationLineType, String whetherAllocateOtherOrg, String responsibleOrg) {
		this.oriWorkTaskInvoiceId = oriWorkTaskInvoiceId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataFile = dataFile;
		this.objId = objId;
		this.taskInvoiceName = taskInvoiceName;
		this.preparationDate = preparationDate;
		this.taskContent = taskContent;
		this.powerStationLine = powerStationLine;
		this.plannedStartTime = plannedStartTime;
		this.plannedEndTime = plannedEndTime;
		this.isPowerFailure = isPowerFailure;
		this.approvedOutageStartTime = approvedOutageStartTime;
		this.approvedOutageEndTime = approvedOutageEndTime;
		this.powerCutScope = powerCutScope;
		this.taskArrangerName = taskArrangerName;
		this.completionPhase = completionPhase;
		this.major = major;
		this.belongedCityName = belongedCityName;
		this.preparationDepartmentName = preparationDepartmentName;
		this.stationLineType = stationLineType;
		this.whetherAllocateOtherOrg = whetherAllocateOtherOrg;
		this.responsibleOrg = responsibleOrg;
	}

	// Property accessors

	public String getOriWorkTaskInvoiceId() {
		return this.oriWorkTaskInvoiceId;
	}

	public void setOriWorkTaskInvoiceId(String oriWorkTaskInvoiceId) {
		this.oriWorkTaskInvoiceId = oriWorkTaskInvoiceId;
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

	public String getDataFile() {
		return this.dataFile;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getTaskInvoiceName() {
		return this.taskInvoiceName;
	}

	public void setTaskInvoiceName(String taskInvoiceName) {
		this.taskInvoiceName = taskInvoiceName;
	}

	public Date getPreparationDate() {
		return this.preparationDate;
	}

	public void setPreparationDate(Date preparationDate) {
		this.preparationDate = preparationDate;
	}

	public String getTaskContent() {
		return this.taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getPowerStationLine() {
		return this.powerStationLine;
	}

	public void setPowerStationLine(String powerStationLine) {
		this.powerStationLine = powerStationLine;
	}

	public Date getPlannedStartTime() {
		return this.plannedStartTime;
	}

	public void setPlannedStartTime(Date plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	public Date getPlannedEndTime() {
		return this.plannedEndTime;
	}

	public void setPlannedEndTime(Date plannedEndTime) {
		this.plannedEndTime = plannedEndTime;
	}

	public String getIsPowerFailure() {
		return this.isPowerFailure;
	}

	public void setIsPowerFailure(String isPowerFailure) {
		this.isPowerFailure = isPowerFailure;
	}

	public String getApprovedOutageStartTime() {
		return this.approvedOutageStartTime;
	}

	public void setApprovedOutageStartTime(String approvedOutageStartTime) {
		this.approvedOutageStartTime = approvedOutageStartTime;
	}

	public String getApprovedOutageEndTime() {
		return this.approvedOutageEndTime;
	}

	public void setApprovedOutageEndTime(String approvedOutageEndTime) {
		this.approvedOutageEndTime = approvedOutageEndTime;
	}

	public String getPowerCutScope() {
		return this.powerCutScope;
	}

	public void setPowerCutScope(String powerCutScope) {
		this.powerCutScope = powerCutScope;
	}

	public String getTaskArrangerName() {
		return this.taskArrangerName;
	}

	public void setTaskArrangerName(String taskArrangerName) {
		this.taskArrangerName = taskArrangerName;
	}

	public String getCompletionPhase() {
		return this.completionPhase;
	}

	public void setCompletionPhase(String completionPhase) {
		this.completionPhase = completionPhase;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getBelongedCityName() {
		return this.belongedCityName;
	}

	public void setBelongedCityName(String belongedCityName) {
		this.belongedCityName = belongedCityName;
	}

	public String getPreparationDepartmentName() {
		return this.preparationDepartmentName;
	}

	public void setPreparationDepartmentName(String preparationDepartmentName) {
		this.preparationDepartmentName = preparationDepartmentName;
	}

	public String getStationLineType() {
		return this.stationLineType;
	}

	public void setStationLineType(String stationLineType) {
		this.stationLineType = stationLineType;
	}

	public String getWhetherAllocateOtherOrg() {
		return this.whetherAllocateOtherOrg;
	}

	public void setWhetherAllocateOtherOrg(String whetherAllocateOtherOrg) {
		this.whetherAllocateOtherOrg = whetherAllocateOtherOrg;
	}

	public String getResponsibleOrg() {
		return this.responsibleOrg;
	}

	public void setResponsibleOrg(String responsibleOrg) {
		this.responsibleOrg = responsibleOrg;
	}

}