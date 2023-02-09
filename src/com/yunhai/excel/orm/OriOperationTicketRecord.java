package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriOperationTicketRecord entity. @author MyEclipse Persistence Tools
 */
public class OriOperationTicketRecord extends AbstractOriOperationTicketRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriOperationTicketRecord() {
	}

	/** minimal constructor */
	public OriOperationTicketRecord(String oriOperationTicketRecordId) {
		super(oriOperationTicketRecordId);
	}

	/** full constructor */
	public OriOperationTicketRecord(String oriOperationTicketRecordId, String dataVersion, Date calYear,
			String ticketNumber, String ticketType, String operationTicketType, String operationTicketStatus,
			String workPlaceName, String operationTask, String ticketMakingTime, String ticketMakingOrgName,
			String ticketPreparerName, String orderIssuePersonName, String orderRecipientName, String guardianName,
			String operationStartTime, String operationEndTime, String dataSource) {
		super(oriOperationTicketRecordId, dataVersion, calYear, ticketNumber, ticketType, operationTicketType,
				operationTicketStatus, workPlaceName, operationTask, ticketMakingTime, ticketMakingOrgName,
				ticketPreparerName, orderIssuePersonName, orderRecipientName, guardianName, operationStartTime,
				operationEndTime, dataSource);
	}

}
