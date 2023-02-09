package com.yunhai.excel.orm;

public class YTableCellString {


	/**
	 * columnId 字段的序�?
	 */
	private Integer columnId;
	/**
	 * columnName 字段的名�?
	 */
	private String columnName;
	
	private String cellValue;

	
	
	
	public YTableCellString(Integer columnId, String columnName, String cellValue) {
		super();
		this.columnId = columnId;
		this.columnName = columnName;
		this.cellValue = cellValue;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getCellValue() {
		return cellValue;
	}

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	
	
}
