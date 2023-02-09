package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriWorkTaskInvoice entity. @author MyEclipse Persistence Tools
 */
public class OriWorkTaskInvoice extends AbstractOriWorkTaskInvoice implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriWorkTaskInvoice() {
	}

	/** minimal constructor */
	public OriWorkTaskInvoice(String oriWorkTaskInvoiceId, String dataVersion, String dataFile) {
		super(oriWorkTaskInvoiceId, dataVersion, dataFile);
	}

	/** full constructor */
	public OriWorkTaskInvoice(String oriWorkTaskInvoiceId, String dataVersion, Date calYear, String dataFile,
			String objId, String taskInvoiceName, Date preparationDate, String taskContent, String powerStationLine,
			Date plannedStartTime, Date plannedEndTime, String isPowerFailure, String approvedOutageStartTime,
			String approvedOutageEndTime, String powerCutScope, String taskArrangerName, String completionPhase,
			String major, String belongedCityName, String preparationDepartmentName, String stationLineType,
			String whetherAllocateOtherOrg, String responsibleOrg) {
		super(oriWorkTaskInvoiceId, dataVersion, calYear, dataFile, objId, taskInvoiceName, preparationDate, taskContent,
				powerStationLine, plannedStartTime, plannedEndTime, isPowerFailure, approvedOutageStartTime,
				approvedOutageEndTime, powerCutScope, taskArrangerName, completionPhase, major, belongedCityName,
				preparationDepartmentName, stationLineType, whetherAllocateOtherOrg, responsibleOrg);
		// TODO Auto-generated constructor stub
	}

	


}
