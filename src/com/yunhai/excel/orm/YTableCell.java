package com.yunhai.excel.orm;

public class YTableCell {

	/**
	 * columnId 字段的序�?
	 */
	private Integer columnId;
	/**
	 * columnName 字段的名�?
	 */
	private String columnName;
	
	private Double cellValue;

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

	public Double getCellValue() {
		return cellValue;
	}

	public void setCellValue(Double cellValue) {
		this.cellValue = cellValue;
	}

	public YTableCell(Integer columnId, String columnName, Double cellValue) {
		super();
		this.columnId = columnId;
		this.columnName = columnName;
		this.cellValue = cellValue;
	}
	
	
}
