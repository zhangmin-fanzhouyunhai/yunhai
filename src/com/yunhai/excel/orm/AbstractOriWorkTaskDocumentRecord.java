package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriWorkTaskDocumentRecord entity provides the base persistence
 * definition of the OriWorkTaskDocumentRecord entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriWorkTaskDocumentRecord implements java.io.Serializable {

	// Fields

	private String oriWorkTaskDocuRecordId;
	private String dataVersion;
	private Date calYear;
	private String taskDocumentNumber;
	private String taskDocumentName;
	private String compileTime;
	private String taskContent;
	private String workingPlace;
	private String plannedStartTime;
	private String plannedEndTime;
	private String whetherPowerCut;
	private String approvedPowerCutStartTime;
	private String approvedPowerCutEndTime;
	private String blackoutRange;
	private String taskArrangerName;
	private String completionPhase;
	private String cityName;
	private String dataSource;

	// Constructors

	/** default constructor */
	public AbstractOriWorkTaskDocumentRecord() {
	}

	/** minimal constructor */
	public AbstractOriWorkTaskDocumentRecord(String oriWorkTaskDocuRecordId) {
		this.oriWorkTaskDocuRecordId = oriWorkTaskDocuRecordId;
	}

	/** full constructor */
	public AbstractOriWorkTaskDocumentRecord(String oriWorkTaskDocuRecordId, String dataVersion, Date calYear,
			String taskDocumentNumber, String taskDocumentName, String compileTime, String taskContent,
			String workingPlace, String plannedStartTime, String plannedEndTime, String whetherPowerCut,
			String approvedPowerCutStartTime, String approvedPowerCutEndTime, String blackoutRange,
			String taskArrangerName, String completionPhase, String cityName, String dataSource) {
		this.oriWorkTaskDocuRecordId = oriWorkTaskDocuRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.taskDocumentNumber = taskDocumentNumber;
		this.taskDocumentName = taskDocumentName;
		this.compileTime = compileTime;
		this.taskContent = taskContent;
		this.workingPlace = workingPlace;
		this.plannedStartTime = plannedStartTime;
		this.plannedEndTime = plannedEndTime;
		this.whetherPowerCut = whetherPowerCut;
		this.approvedPowerCutStartTime = approvedPowerCutStartTime;
		this.approvedPowerCutEndTime = approvedPowerCutEndTime;
		this.blackoutRange = blackoutRange;
		this.taskArrangerName = taskArrangerName;
		this.completionPhase = completionPhase;
		this.cityName = cityName;
		this.dataSource = dataSource;
	}

	// Property accessors

	public String getOriWorkTaskDocuRecordId() {
		return this.oriWorkTaskDocuRecordId;
	}

	public void setOriWorkTaskDocuRecordId(String oriWorkTaskDocuRecordId) {
		this.oriWorkTaskDocuRecordId = oriWorkTaskDocuRecordId;
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

	public String getTaskDocumentNumber() {
		return this.taskDocumentNumber;
	}

	public void setTaskDocumentNumber(String taskDocumentNumber) {
		this.taskDocumentNumber = taskDocumentNumber;
	}

	public String getTaskDocumentName() {
		return this.taskDocumentName;
	}

	public void setTaskDocumentName(String taskDocumentName) {
		this.taskDocumentName = taskDocumentName;
	}

	public String getCompileTime() {
		return this.compileTime;
	}

	public void setCompileTime(String compileTime) {
		this.compileTime = compileTime;
	}

	public String getTaskContent() {
		return this.taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getWorkingPlace() {
		return this.workingPlace;
	}

	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}

	public String getPlannedStartTime() {
		return this.plannedStartTime;
	}

	public void setPlannedStartTime(String plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	public String getPlannedEndTime() {
		return this.plannedEndTime;
	}

	public void setPlannedEndTime(String plannedEndTime) {
		this.plannedEndTime = plannedEndTime;
	}

	public String getWhetherPowerCut() {
		return this.whetherPowerCut;
	}

	public void setWhetherPowerCut(String whetherPowerCut) {
		this.whetherPowerCut = whetherPowerCut;
	}

	public String getApprovedPowerCutStartTime() {
		return this.approvedPowerCutStartTime;
	}

	public void setApprovedPowerCutStartTime(String approvedPowerCutStartTime) {
		this.approvedPowerCutStartTime = approvedPowerCutStartTime;
	}

	public String getApprovedPowerCutEndTime() {
		return this.approvedPowerCutEndTime;
	}

	public void setApprovedPowerCutEndTime(String approvedPowerCutEndTime) {
		this.approvedPowerCutEndTime = approvedPowerCutEndTime;
	}

	public String getBlackoutRange() {
		return this.blackoutRange;
	}

	public void setBlackoutRange(String blackoutRange) {
		this.blackoutRange = blackoutRange;
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

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}