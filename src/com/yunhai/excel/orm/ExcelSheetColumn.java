package com.yunhai.excel.orm;

import java.util.Date;

/**
 * ExcelSheetColumn entity. @author MyEclipse Persistence Tools
 */
public class ExcelSheetColumn extends AbstractExcelSheetColumn implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ExcelSheetColumn() {
	}

	/** minimal constructor */
	public ExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet) {
		super(excelSheetColumnId, excelSheet);
	}

	/** full constructor */
	public ExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet, String excelSheetColumnName,
			String dataType, String dataTypeCode, Double sortIndex, String description) {
		super(excelSheetColumnId, excelSheet, excelSheetColumnName, dataType, dataTypeCode, sortIndex, description);
	}

	public ExcelSheetColumn(String excelSheetColumnId, String excelSheetId, String excelSheetColumnName,
			String dataType, String dataTypeCode, Double sortIndex, String description) {
		super(excelSheetColumnId, excelSheetId, excelSheetColumnName, dataType, dataTypeCode, sortIndex, description);
		// TODO Auto-generated constructor stub
	}

	public ExcelSheetColumn(String excelSheetColumnId, ExcelSheet excelSheet, String excelSheetId,
			String excelSheetColumnName, String dataType, String dataTypeCode, Date createDate, Double sortIndex,
			String description) {
		super(excelSheetColumnId, excelSheet, excelSheetId, excelSheetColumnName, dataType, dataTypeCode, createDate, sortIndex,
				description);
		// TODO Auto-generated constructor stub
	}

}
