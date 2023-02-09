package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriWorkTicketRecord entity. @author MyEclipse Persistence Tools
 */
public class OriWorkTicketRecord extends AbstractOriWorkTicketRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriWorkTicketRecord() {
	}

	/** minimal constructor */
	public OriWorkTicketRecord(String oriWorkTicketRecordId) {
		super(oriWorkTicketRecordId);
	}

	/** full constructor */
	public OriWorkTicketRecord(String oriWorkTicketRecordId, String dataVersion, Date calYear, String ticketNumber,
			String ticketType, String workTicketType, String workTicketStatus, String workPlaceName,
			String jobDescription, String ticketMakingDepartment, String operationMaintenanceOrgName,
			String ticketMakingTime, String plannedStartTime, String plannedEndTime,
			String permittedWorkingHours, String licensorName, String endTime, Double teamMembersQuantity,
			String ticketPreparerName, String dataSource) {
		super(oriWorkTicketRecordId, dataVersion, calYear, ticketNumber, ticketType, workTicketType, workTicketStatus,
				workPlaceName, jobDescription, ticketMakingDepartment, operationMaintenanceOrgName, ticketMakingTime,
				plannedStartTime, plannedEndTime, permittedWorkingHours, licensorName, endTime, teamMembersQuantity,
				ticketPreparerName, dataSource);
	}

}
