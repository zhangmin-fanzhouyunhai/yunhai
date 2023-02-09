package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriOperationTicketRecord entity provides the base persistence
 * definition of the OriOperationTicketRecord entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriOperationTicketRecord implements java.io.Serializable {

	// Fields

	private String oriOperationTicketRecordId;
	private String dataVersion;
	private Date calYear;
	private String ticketNumber;
	private String ticketType;
	private String operationTicketType;
	private String operationTicketStatus;
	private String workPlaceName;
	private String operationTask;
	private String ticketMakingTime;
	private String ticketMakingOrgName;
	private String ticketPreparerName;
	private String orderIssuePersonName;
	private String orderRecipientName;
	private String guardianName;
	private String operationStartTime;
	private String operationEndTime;
	private String dataSource;

	// Constructors

	/** default constructor */
	public AbstractOriOperationTicketRecord() {
	}

	/** minimal constructor */
	public AbstractOriOperationTicketRecord(String oriOperationTicketRecordId) {
		this.oriOperationTicketRecordId = oriOperationTicketRecordId;
	}

	/** full constructor */
	public AbstractOriOperationTicketRecord(String oriOperationTicketRecordId, String dataVersion, Date calYear,
			String ticketNumber, String ticketType, String operationTicketType, String operationTicketStatus,
			String workPlaceName, String operationTask, String ticketMakingTime, String ticketMakingOrgName,
			String ticketPreparerName, String orderIssuePersonName, String orderRecipientName, String guardianName,
			String operationStartTime, String operationEndTime, String dataSource) {
		this.oriOperationTicketRecordId = oriOperationTicketRecordId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.ticketNumber = ticketNumber;
		this.ticketType = ticketType;
		this.operationTicketType = operationTicketType;
		this.operationTicketStatus = operationTicketStatus;
		this.workPlaceName = workPlaceName;
		this.operationTask = operationTask;
		this.ticketMakingTime = ticketMakingTime;
		this.ticketMakingOrgName = ticketMakingOrgName;
		this.ticketPreparerName = ticketPreparerName;
		this.orderIssuePersonName = orderIssuePersonName;
		this.orderRecipientName = orderRecipientName;
		this.guardianName = guardianName;
		this.operationStartTime = operationStartTime;
		this.operationEndTime = operationEndTime;
		this.dataSource = dataSource;
	}

	// Property accessors

	public String getOriOperationTicketRecordId() {
		return this.oriOperationTicketRecordId;
	}

	public void setOriOperationTicketRecordId(String oriOperationTicketRecordId) {
		this.oriOperationTicketRecordId = oriOperationTicketRecordId;
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

	public String getOperationTicketType() {
		return this.operationTicketType;
	}

	public void setOperationTicketType(String operationTicketType) {
		this.operationTicketType = operationTicketType;
	}

	public String getOperationTicketStatus() {
		return this.operationTicketStatus;
	}

	public void setOperationTicketStatus(String operationTicketStatus) {
		this.operationTicketStatus = operationTicketStatus;
	}

	public String getWorkPlaceName() {
		return this.workPlaceName;
	}

	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}

	public String getOperationTask() {
		return this.operationTask;
	}

	public void setOperationTask(String operationTask) {
		this.operationTask = operationTask;
	}

	public String getTicketMakingTime() {
		return this.ticketMakingTime;
	}

	public void setTicketMakingTime(String ticketMakingTime) {
		this.ticketMakingTime = ticketMakingTime;
	}

	public String getTicketMakingOrgName() {
		return this.ticketMakingOrgName;
	}

	public void setTicketMakingOrgName(String ticketMakingOrgName) {
		this.ticketMakingOrgName = ticketMakingOrgName;
	}

	public String getTicketPreparerName() {
		return this.ticketPreparerName;
	}

	public void setTicketPreparerName(String ticketPreparerName) {
		this.ticketPreparerName = ticketPreparerName;
	}

	public String getOrderIssuePersonName() {
		return this.orderIssuePersonName;
	}

	public void setOrderIssuePersonName(String orderIssuePersonName) {
		this.orderIssuePersonName = orderIssuePersonName;
	}

	public String getOrderRecipientName() {
		return this.orderRecipientName;
	}

	public void setOrderRecipientName(String orderRecipientName) {
		this.orderRecipientName = orderRecipientName;
	}

	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getOperationStartTime() {
		return this.operationStartTime;
	}

	public void setOperationStartTime(String operationStartTime) {
		this.operationStartTime = operationStartTime;
	}

	public String getOperationEndTime() {
		return this.operationEndTime;
	}

	public void setOperationEndTime(String operationEndTime) {
		this.operationEndTime = operationEndTime;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}