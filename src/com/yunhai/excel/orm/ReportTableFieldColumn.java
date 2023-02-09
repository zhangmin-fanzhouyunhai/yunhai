package com.yunhai.excel.orm;

/**
 * ReportTableFieldColumn entity. @author MyEclipse Persistence Tools
 */
public class ReportTableFieldColumn extends AbstractReportTableFieldColumn implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ReportTableFieldColumn() {
	}

	/** minimal constructor */
	public ReportTableFieldColumn(String reportTableFieldColumnId, Double indexof) {
		super(reportTableFieldColumnId, indexof);
	}

	/** full constructor */
	public ReportTableFieldColumn(String reportTableFieldColumnId, String reportId, String reportName, String tableName,
			String fieldName, Double indexof, String fieldTitle, String dimensionOrIndicate,
			String dimensionOrIndicateType, String discription) {
		super(reportTableFieldColumnId, reportId, reportName, tableName, fieldName, indexof, fieldTitle,
				dimensionOrIndicate, dimensionOrIndicateType, discription);
	}

}
