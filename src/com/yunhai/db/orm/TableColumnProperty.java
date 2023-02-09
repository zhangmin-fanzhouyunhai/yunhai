package com.yunhai.db.orm;

public class TableColumnProperty {
	/**
	 * columnId 字段的序�?
	 */
	private Integer columnId;
	/**
	 * columnName 字段的名�?
	 */
	private String columnName;
	/**
	 * dataType 字段的数据类�?
	 */
	private String dataType;
	/**
	 * dataLength 字段可以存储的数据的长度
	 */
	private Integer dataLength;
	/**
	 * dataPrecision 数据类字段的整数位数
	 */
	private Integer dataPrecision;
	/**
	 * dataScale 数据类字段的小数位数
	 */
	private Integer dataScale;
	
	/**
	 * columnComment 字段的备�?
	 */
	private String columnComment;
/**
 * 
 * @param columnId
 * @param columnName
 * @param dataType
 * @param dataLength
 * @param dataPrecision
 * @param dataScale
 * @param columnComment
 */
	public TableColumnProperty(Integer columnId, String columnName, String dataType, Integer dataLength,
			Integer dataPrecision, Integer dataScale,String columnComment) {
		super();
		this.columnId = columnId;
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataLength = dataLength;
		this.dataPrecision = dataPrecision;
		this.dataScale = dataScale;
		this.columnComment=columnComment;
	}

	 

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	public Integer getDataPrecision() {
		return dataPrecision;
	}

	public void setDataPrecision(Integer dataPrecision) {
		this.dataPrecision = dataPrecision;
	}

	public Integer getDataScale() {
		return dataScale;
	}

	public void setDataScale(Integer dataScale) {
		this.dataScale = dataScale;
	}

}
