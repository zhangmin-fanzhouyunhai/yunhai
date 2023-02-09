package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriWorkTicket entity. @author MyEclipse Persistence Tools
 */
public class OriWorkTicket extends AbstractOriWorkTicket implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriWorkTicket() {
	}

	/** minimal constructor */
	public OriWorkTicket(String oriWorkTicketId, String dataVersion, String dataFile) {
		super(oriWorkTicketId, dataVersion, dataFile);
	}

	/** full constructor */
	public OriWorkTicket(String oriWorkTicketId, String dataVersion, Date calYear, String dataFile, String objId,
			String ticketName, String ticketType, String ticketNumber, String ticketStatus, String outsourcingOrNot,
			String stationLineType, String workPlaceName, String workplaceDescription, String jobContent,
			Date ticketMakingTime, String ticketingDepartmentName, String ticketMakerName, String operationOrgName,
			String filingDepartmentName, String archivistName, String chargePersonName, String approverName,
			String deqfrmc, String teamMembers, Date plannedStartTime, Date plannedEndTime,
			String permitWorkChargePersonName, String licenserName, Date permittedWorkingHours, Date delayTime,
			Date endTime, String terminationPermitterName, String terminationChargePersonName,
			String terminationNonExecutReason, String invalidNonExecutPersonName, Date invalidOrUnexecutedTime,
			String teamName, String workOrgName, Double teamMemberQuantity, Date issuanceTime, Date licenseEndTime,
			String nameOfReceiver, Date pickUpTime, String equipmentName, String drawerName, Date billingTime,
			String returnedPersonName, String returnReason, Date returnTime, Double printingTimes, String printerName,
			String printReason, Date printingTime, String belongedCityName, Date secondIssueTime,
			String majorClassification, Date archiveTime, String majorType, String nameOfMaintenanceTeam,
			Date changeTime) {
		super(oriWorkTicketId, dataVersion, calYear, dataFile, objId, ticketName, ticketType, ticketNumber, ticketStatus,
				outsourcingOrNot, stationLineType, workPlaceName, workplaceDescription, jobContent, ticketMakingTime,
				ticketingDepartmentName, ticketMakerName, operationOrgName, filingDepartmentName, archivistName,
				chargePersonName, approverName, deqfrmc, teamMembers, plannedStartTime, plannedEndTime,
				permitWorkChargePersonName, licenserName, permittedWorkingHours, delayTime, endTime, terminationPermitterName,
				terminationChargePersonName, terminationNonExecutReason, invalidNonExecutPersonName, invalidOrUnexecutedTime,
				teamName, workOrgName, teamMemberQuantity, issuanceTime, licenseEndTime, nameOfReceiver, pickUpTime,
				equipmentName, drawerName, billingTime, returnedPersonName, returnReason, returnTime, printingTimes,
				printerName, printReason, printingTime, belongedCityName, secondIssueTime, majorClassification, archiveTime,
				majorType, nameOfMaintenanceTeam, changeTime);
		// TODO Auto-generated constructor stub
	}

	

}
