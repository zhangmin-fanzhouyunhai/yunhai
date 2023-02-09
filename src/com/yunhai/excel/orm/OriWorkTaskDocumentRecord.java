package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriWorkTaskDocumentRecord entity. @author MyEclipse Persistence Tools
 */
public class OriWorkTaskDocumentRecord extends AbstractOriWorkTaskDocumentRecord implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriWorkTaskDocumentRecord() {
	}

	/** minimal constructor */
	public OriWorkTaskDocumentRecord(String oriWorkTaskDocuRecordId) {
		super(oriWorkTaskDocuRecordId);
	}

	/** full constructor */
	public OriWorkTaskDocumentRecord(String oriWorkTaskDocuRecordId, String dataVersion, Date calYear,
			String taskDocumentNumber, String taskDocumentName, String compileTime, String taskContent,
			String workingPlace, String plannedStartTime, String plannedEndTime, String whetherPowerCut,
			String approvedPowerCutStartTime, String approvedPowerCutEndTime, String blackoutRange,
			String taskArrangerName, String completionPhase, String cityName, String dataSource) {
		super(oriWorkTaskDocuRecordId, dataVersion, calYear, taskDocumentNumber, taskDocumentName, compileTime,
				taskContent, workingPlace, plannedStartTime, plannedEndTime, whetherPowerCut, approvedPowerCutStartTime,
				approvedPowerCutEndTime, blackoutRange, taskArrangerName, completionPhase, cityName, dataSource);
	}

}
