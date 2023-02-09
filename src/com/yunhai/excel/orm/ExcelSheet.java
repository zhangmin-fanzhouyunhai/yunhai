package com.yunhai.excel.orm;

import java.util.Date;
import java.util.Set;

/**
 * ExcelSheet entity. @author MyEclipse Persistence Tools
 */
public class ExcelSheet extends AbstractExcelSheet implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -1767607820220619163L;

	/** default constructor */
	public ExcelSheet() {
	}

	/** minimal constructor */
	public ExcelSheet(String excelSheetId, ExcelFile excelFile) {
		super(excelSheetId, excelFile);
	}

	/** full constructor */
	public ExcelSheet(String excelSheetId, ExcelFile excelFile, String excelSheetName, Double sortIndex,
			String description, Set excelSheetColumns) {
		super(excelSheetId, excelFile, excelSheetName, sortIndex, description, excelSheetColumns);
	}

	public ExcelSheet(String excelSheetId, String excelFileId, String excelSheetName, Double sortIndex,
			String description, Set excelSheetColumns) {
		super(excelSheetId, excelFileId, excelSheetName, sortIndex, description, excelSheetColumns);
		// TODO Auto-generated constructor stub
	}

	public ExcelSheet(String excelSheetId, ExcelFile excelFile, String excelFileId, String excelSheetName,
			Double sortIndex, Date createDate, String description, Set excelSheetColumns) {
		super(excelSheetId, excelFile, excelFileId, excelSheetName, sortIndex, createDate, description, excelSheetColumns);
		// TODO Auto-generated constructor stub
	}

	public ExcelSheet(String excelSheetId, ExcelFile excelFile, String excelFileId, String excelSheetName,
			Double sortIndex, Date createDate, String description, Integer columnInserted) {
		super(excelSheetId, excelFile, excelFileId, excelSheetName, sortIndex, createDate, description, columnInserted);
		// TODO Auto-generated constructor stub
	}
   
	
	
}
