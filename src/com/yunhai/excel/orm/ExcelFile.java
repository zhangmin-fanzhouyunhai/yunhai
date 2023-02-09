package com.yunhai.excel.orm;

import java.util.Date;
import java.util.Set;

/**
 * ExcelFile entity. @author MyEclipse Persistence Tools
 */
public class ExcelFile extends AbstractExcelFile implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ExcelFile() {
	}

	/** minimal constructor */
	public ExcelFile(String excelFileId) {
		super(excelFileId);
	}

	/** full constructor */
	public ExcelFile(String excelFileId, String excelFileName, String uploadPersonName, Date uploadDate,
			Double sortIndex, String storyPath, String description, Set excelSheets) {
		super(excelFileId, excelFileName, uploadPersonName, uploadDate, sortIndex, storyPath, description, excelSheets);
	}

}
