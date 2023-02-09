package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriWorkTicketRecord entity provides the base persistence definition
 * of the OriWorkTicketRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriWorkTicketRecord implements java.io.Serializable {

	// Fields

	private String oriWorkTicketRecordId;
	private String dataVersion;
	private Date calYear;
	private String ticketNumber;
	private String ticketType;
	private String workTicketType;
	private String workTicketStatus;
	private String workPlaceName;
	private String jobDescription;
	private String ticketMakingDepartment;
	private String operationMaintenanceOrgName;
	private String ticketMakingTime;
	private String plannedStartTime;
	private String plannedEndTime;
	private String permittedWorkingHours;
	private String licensorName;
	private String endTime;
	private Double teamMembersQuantity;
	private String ticketPreparerName;
	private String dataSource;

	// Constructors

	/** default constructor */
	public AbstractOriWorkTicketRecord() {
	}

	/** minimal constructor */
	public AbstractOriWorkTicketRecord(String oriWorkTicketRecordId) {
		this.oriWorkTicketRecordId = oriWorkTicketRecordId;
	}

	/** full constructor */
	public AbstractOriWorkTicketRecord(String oriWorkTicketRecordId, String dataVersion, Date calYear,
			String ticketNumber, String ticketType, String workTicketType, String workTicketStatus,
			String workPlaceName, String jobDescription, String ticketMakingDepartment,
			String operationMaintenanceOrgName, String ticketMakingTime, String plannedStartTime,
			String plannedEndTime, String permittedWorkingHours, String licensorName, String endTime,
			Double teamMembersQuantity, String ticketPreparerName, String dataSource) {
		this.oriWorkTicketRecordId = oriWorkTicketRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.ticketNumber = ticketNumber;
		this.ticketType = ticketType;
		this.workTicketType = workTicketType;
		this.workTicketStatus = workTicketStatus;
		this.workPlaceName = workPlaceName;
		this.jobDescription = jobDescription;
		this.ticketMakingDepartment = ticketMakingDepartment;
		this.operationMaintenanceOrgName = operationMaintenanceOrgName;
		this.ticketMakingTime = ticketMakingTime;
		this.plannedStartTime = plannedStartTime;
		this.plannedEndTime = plannedEndTime;
		this.permittedWorkingHours = permittedWorkingHours;
		this.licensorName = licensorName;
		this.endTime = endTime;
		this.teamMembersQuantity = teamMembersQuantity;
		this.ticketPreparerName = ticketPreparerName;
		this.dataSource = dataSource;
	}

	// Property accessors

	public String getOriWorkTicketRecordId() {
		return this.oriWorkTicketRecordId;
	}

	public void setOriWorkTicketRecordId(String oriWorkTicketRecordId) {
		this.oriWorkTicketRecordId = oriWorkTicketRecordId;
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

	public String getTicketNumber() {
		return this.ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getWorkTicketType() {
		return this.workTicketType;
	}

	public void setWorkTicketType(String workTicketType) {
		this.workTicketType = workTicketType;
	}

	public String getWorkTicketStatus() {
		return this.workTicketStatus;
	}

	public void setWorkTicketStatus(String workTicketStatus) {
		this.workTicketStatus = workTicketStatus;
	}

	public String getWorkPlaceName() {
		return this.workPlaceName;
	}

	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getTicketMakingDepartment() {
		return this.ticketMakingDepartment;
	}

	public void setTicketMakingDepartment(String ticketMakingDepartment) {
		this.ticketMakingDepartment = ticketMakingDepartment;
	}

	public String getOperationMaintenanceOrgName() {
		return this.operationMaintenanceOrgName;
	}

	public void setOperationMaintenanceOrgName(String operationMaintenanceOrgName) {
		this.operationMaintenanceOrgName = operationMaintenanceOrgName;
	}

	public String getTicketMakingTime() {
		return this.ticketMakingTime;
	}

	public void setTicketMakingTime(String ticketMakingTime) {
		this.ticketMakingTime = ticketMakingTime;
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

	public String getPermittedWorkingHours() {
		return this.permittedWorkingHours;
	}

	public void setPermittedWorkingHours(String permittedWorkingHours) {
		this.permittedWorkingHours = permittedWorkingHours;
	}

	public String getLicensorName() {
		return this.licensorName;
	}

	public void setLicensorName(String licensorName) {
		this.licensorName = licensorName;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Double getTeamMembersQuantity() {
		return this.teamMembersQuantity;
	}

	public void setTeamMembersQuantity(Double teamMembersQuantity) {
		this.teamMembersQuantity = teamMembersQuantity;
	}

	public String getTicketPreparerName() {
		return this.ticketPreparerName;
	}

	public void setTicketPreparerName(String ticketPreparerName) {
		this.ticketPreparerName = ticketPreparerName;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}