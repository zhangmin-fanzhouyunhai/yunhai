package com.yunhai.excel.orm;
 
import java.util.Date;

/**
 * AbstractOriWorkTicket entity provides the base persistence definition of the
 * OriWorkTicket entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriWorkTicket implements java.io.Serializable {

	// Fields

	private String oriWorkTicketId;
	private String dataVersion;
	private Date calYear;
	private String dataFile;
	private String objId;
	private String ticketName;
	private String ticketType;
	private String ticketNumber;
	private String ticketStatus;
	private String outsourcingOrNot;
	private String stationLineType;
	private String workPlaceName;
	private String workplaceDescription;
	private String jobContent;
	private Date ticketMakingTime;
	private String ticketingDepartmentName;
	private String ticketMakerName;
	private String operationOrgName;
	private String filingDepartmentName;
	private String archivistName;
	private String chargePersonName;
	private String approverName;
	private String deqfrmc;
	private String teamMembers;
	private Date plannedStartTime;
	private Date plannedEndTime;
	private String permitWorkChargePersonName;
	private String licenserName;
	private Date permittedWorkingHours;
	private Date delayTime;
	private Date endTime;
	private String terminationPermitterName;
	private String terminationChargePersonName;
	private String terminationNonExecutReason;
	private String invalidNonExecutPersonName;
	private Date invalidOrUnexecutedTime;
	private String teamName;
	private String workOrgName;
	private Double teamMemberQuantity;
	private Date issuanceTime;
	private Date licenseEndTime;
	private String nameOfReceiver;
	private Date pickUpTime;
	private String equipmentName;
	private String drawerName;
	private Date billingTime;
	private String returnedPersonName;
	private String returnReason;
	private Date returnTime;
	private Double printingTimes;
	private String printerName;
	private String printReason;
	private Date printingTime;
	private String belongedCityName;
	private Date secondIssueTime;
	private String majorClassification;
	private Date archiveTime;
	private String majorType;
	private String nameOfMaintenanceTeam;
	private Date changeTime;

	// Constructors

	/** default constructor */
	public AbstractOriWorkTicket() {
	}

	/** minimal constructor */
	public AbstractOriWorkTicket(String oriWorkTicketId, String dataVersion, String dataFile) {
		this.oriWorkTicketId = oriWorkTicketId;
		this.dataVersion = dataVersion;
		this.dataFile = dataFile;
	}

	/** full constructor */
	public AbstractOriWorkTicket(String oriWorkTicketId, String dataVersion, Date calYear, String dataFile,
			String objId, String ticketName, String ticketType, String ticketNumber, String ticketStatus,
			String outsourcingOrNot, String stationLineType, String workPlaceName, String workplaceDescription,
			String jobContent, Date ticketMakingTime, String ticketingDepartmentName, String ticketMakerName,
			String operationOrgName, String filingDepartmentName, String archivistName, String chargePersonName,
			String approverName, String deqfrmc, String teamMembers, Date plannedStartTime,
			Date plannedEndTime, String permitWorkChargePersonName, String licenserName,
			Date permittedWorkingHours, Date delayTime, Date endTime, String terminationPermitterName,
			String terminationChargePersonName, String terminationNonExecutReason, String invalidNonExecutPersonName,
			Date invalidOrUnexecutedTime, String teamName, String workOrgName, Double teamMemberQuantity,
			Date issuanceTime, Date licenseEndTime, String nameOfReceiver, Date pickUpTime,
			String equipmentName, String drawerName, Date billingTime, String returnedPersonName,
			String returnReason, Date returnTime, Double printingTimes, String printerName, String printReason,
			Date printingTime, String belongedCityName, Date secondIssueTime, String majorClassification,
			Date archiveTime, String majorType, String nameOfMaintenanceTeam, Date changeTime) {
		this.oriWorkTicketId = oriWorkTicketId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataFile = dataFile;
		this.objId = objId;
		this.ticketName = ticketName;
		this.ticketType = ticketType;
		this.ticketNumber = ticketNumber;
		this.ticketStatus = ticketStatus;
		this.outsourcingOrNot = outsourcingOrNot;
		this.stationLineType = stationLineType;
		this.workPlaceName = workPlaceName;
		this.workplaceDescription = workplaceDescription;
		this.jobContent = jobContent;
		this.ticketMakingTime = ticketMakingTime;
		this.ticketingDepartmentName = ticketingDepartmentName;
		this.ticketMakerName = ticketMakerName;
		this.operationOrgName = operationOrgName;
		this.filingDepartmentName = filingDepartmentName;
		this.archivistName = archivistName;
		this.chargePersonName = chargePersonName;
		this.approverName = approverName;
		this.deqfrmc = deqfrmc;
		this.teamMembers = teamMembers;
		this.plannedStartTime = plannedStartTime;
		this.plannedEndTime = plannedEndTime;
		this.permitWorkChargePersonName = permitWorkChargePersonName;
		this.licenserName = licenserName;
		this.permittedWorkingHours = permittedWorkingHours;
		this.delayTime = delayTime;
		this.endTime = endTime;
		this.terminationPermitterName = terminationPermitterName;
		this.terminationChargePersonName = terminationChargePersonName;
		this.terminationNonExecutReason = terminationNonExecutReason;
		this.invalidNonExecutPersonName = invalidNonExecutPersonName;
		this.invalidOrUnexecutedTime = invalidOrUnexecutedTime;
		this.teamName = teamName;
		this.workOrgName = workOrgName;
		this.teamMemberQuantity = teamMemberQuantity;
		this.issuanceTime = issuanceTime;
		this.licenseEndTime = licenseEndTime;
		this.nameOfReceiver = nameOfReceiver;
		this.pickUpTime = pickUpTime;
		this.equipmentName = equipmentName;
		this.drawerName = drawerName;
		this.billingTime = billingTime;
		this.returnedPersonName = returnedPersonName;
		this.returnReason = returnReason;
		this.returnTime = returnTime;
		this.printingTimes = printingTimes;
		this.printerName = printerName;
		this.printReason = printReason;
		this.printingTime = printingTime;
		this.belongedCityName = belongedCityName;
		this.secondIssueTime = secondIssueTime;
		this.majorClassification = majorClassification;
		this.archiveTime = archiveTime;
		this.majorType = majorType;
		this.nameOfMaintenanceTeam = nameOfMaintenanceTeam;
		this.changeTime = changeTime;
	}

	// Property accessors

	public String getOriWorkTicketId() {
		return this.oriWorkTicketId;
	}

	public void setOriWorkTicketId(String oriWorkTicketId) {
		this.oriWorkTicketId = oriWorkTicketId;
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

	public String getTicketName() {
		return this.ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketNumber() {
		return this.ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketStatus() {
		return this.ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getOutsourcingOrNot() {
		return this.outsourcingOrNot;
	}

	public void setOutsourcingOrNot(String outsourcingOrNot) {
		this.outsourcingOrNot = outsourcingOrNot;
	}

	public String getStationLineType() {
		return this.stationLineType;
	}

	public void setStationLineType(String stationLineType) {
		this.stationLineType = stationLineType;
	}

	public String getWorkPlaceName() {
		return this.workPlaceName;
	}

	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}

	public String getWorkplaceDescription() {
		return this.workplaceDescription;
	}

	public void setWorkplaceDescription(String workplaceDescription) {
		this.workplaceDescription = workplaceDescription;
	}

	public String getJobContent() {
		return this.jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public Date getTicketMakingTime() {
		return this.ticketMakingTime;
	}

	public void setTicketMakingTime(Date ticketMakingTime) {
		this.ticketMakingTime = ticketMakingTime;
	}

	public String getTicketingDepartmentName() {
		return this.ticketingDepartmentName;
	}

	public void setTicketingDepartmentName(String ticketingDepartmentName) {
		this.ticketingDepartmentName = ticketingDepartmentName;
	}

	public String getTicketMakerName() {
		return this.ticketMakerName;
	}

	public void setTicketMakerName(String ticketMakerName) {
		this.ticketMakerName = ticketMakerName;
	}

	public String getOperationOrgName() {
		return this.operationOrgName;
	}

	public void setOperationOrgName(String operationOrgName) {
		this.operationOrgName = operationOrgName;
	}

	public String getFilingDepartmentName() {
		return this.filingDepartmentName;
	}

	public void setFilingDepartmentName(String filingDepartmentName) {
		this.filingDepartmentName = filingDepartmentName;
	}

	public String getArchivistName() {
		return this.archivistName;
	}

	public void setArchivistName(String archivistName) {
		this.archivistName = archivistName;
	}

	public String getChargePersonName() {
		return this.chargePersonName;
	}

	public void setChargePersonName(String chargePersonName) {
		this.chargePersonName = chargePersonName;
	}

	public String getApproverName() {
		return this.approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getDeqfrmc() {
		return this.deqfrmc;
	}

	public void setDeqfrmc(String deqfrmc) {
		this.deqfrmc = deqfrmc;
	}

	public String getTeamMembers() {
		return this.teamMembers;
	}

	public void setTeamMembers(String teamMembers) {
		this.teamMembers = teamMembers;
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

	public String getPermitWorkChargePersonName() {
		return this.permitWorkChargePersonName;
	}

	public void setPermitWorkChargePersonName(String permitWorkChargePersonName) {
		this.permitWorkChargePersonName = permitWorkChargePersonName;
	}

	public String getLicenserName() {
		return this.licenserName;
	}

	public void setLicenserName(String licenserName) {
		this.licenserName = licenserName;
	}

	public Date getPermittedWorkingHours() {
		return this.permittedWorkingHours;
	}

	public void setPermittedWorkingHours(Date permittedWorkingHours) {
		this.permittedWorkingHours = permittedWorkingHours;
	}

	public Date getDelayTime() {
		return this.delayTime;
	}

	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTerminationPermitterName() {
		return this.terminationPermitterName;
	}

	public void setTerminationPermitterName(String terminationPermitterName) {
		this.terminationPermitterName = terminationPermitterName;
	}

	public String getTerminationChargePersonName() {
		return this.terminationChargePersonName;
	}

	public void setTerminationChargePersonName(String terminationChargePersonName) {
		this.terminationChargePersonName = terminationChargePersonName;
	}

	public String getTerminationNonExecutReason() {
		return this.terminationNonExecutReason;
	}

	public void setTerminationNonExecutReason(String terminationNonExecutReason) {
		this.terminationNonExecutReason = terminationNonExecutReason;
	}

	public String getInvalidNonExecutPersonName() {
		return this.invalidNonExecutPersonName;
	}

	public void setInvalidNonExecutPersonName(String invalidNonExecutPersonName) {
		this.invalidNonExecutPersonName = invalidNonExecutPersonName;
	}

	public Date getInvalidOrUnexecutedTime() {
		return this.invalidOrUnexecutedTime;
	}

	public void setInvalidOrUnexecutedTime(Date invalidOrUnexecutedTime) {
		this.invalidOrUnexecutedTime = invalidOrUnexecutedTime;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getWorkOrgName() {
		return this.workOrgName;
	}

	public void setWorkOrgName(String workOrgName) {
		this.workOrgName = workOrgName;
	}

	public Double getTeamMemberQuantity() {
		return this.teamMemberQuantity;
	}

	public void setTeamMemberQuantity(Double teamMemberQuantity) {
		this.teamMemberQuantity = teamMemberQuantity;
	}

	public Date getIssuanceTime() {
		return this.issuanceTime;
	}

	public void setIssuanceTime(Date issuanceTime) {
		this.issuanceTime = issuanceTime;
	}

	public Date getLicenseEndTime() {
		return this.licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	public String getNameOfReceiver() {
		return this.nameOfReceiver;
	}

	public void setNameOfReceiver(String nameOfReceiver) {
		this.nameOfReceiver = nameOfReceiver;
	}

	public Date getPickUpTime() {
		return this.pickUpTime;
	}

	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getDrawerName() {
		return this.drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public Date getBillingTime() {
		return this.billingTime;
	}

	public void setBillingTime(Date billingTime) {
		this.billingTime = billingTime;
	}

	public String getReturnedPersonName() {
		return this.returnedPersonName;
	}

	public void setReturnedPersonName(String returnedPersonName) {
		this.returnedPersonName = returnedPersonName;
	}

	public String getReturnReason() {
		return this.returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public Date getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Double getPrintingTimes() {
		return this.printingTimes;
	}

	public void setPrintingTimes(Double printingTimes) {
		this.printingTimes = printingTimes;
	}

	public String getPrinterName() {
		return this.printerName;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public String getPrintReason() {
		return this.printReason;
	}

	public void setPrintReason(String printReason) {
		this.printReason = printReason;
	}

	public Date getPrintingTime() {
		return this.printingTime;
	}

	public void setPrintingTime(Date printingTime) {
		this.printingTime = printingTime;
	}

	public String getBelongedCityName() {
		return this.belongedCityName;
	}

	public void setBelongedCityName(String belongedCityName) {
		this.belongedCityName = belongedCityName;
	}

	public Date getSecondIssueTime() {
		return this.secondIssueTime;
	}

	public void setSecondIssueTime(Date secondIssueTime) {
		this.secondIssueTime = secondIssueTime;
	}

	public String getMajorClassification() {
		return this.majorClassification;
	}

	public void setMajorClassification(String majorClassification) {
		this.majorClassification = majorClassification;
	}

	public Date getArchiveTime() {
		return this.archiveTime;
	}

	public void setArchiveTime(Date archiveTime) {
		this.archiveTime = archiveTime;
	}

	public String getMajorType() {
		return this.majorType;
	}

	public void setMajorType(String majorType) {
		this.majorType = majorType;
	}

	public String getNameOfMaintenanceTeam() {
		return this.nameOfMaintenanceTeam;
	}

	public void setNameOfMaintenanceTeam(String nameOfMaintenanceTeam) {
		this.nameOfMaintenanceTeam = nameOfMaintenanceTeam;
	}

	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

}