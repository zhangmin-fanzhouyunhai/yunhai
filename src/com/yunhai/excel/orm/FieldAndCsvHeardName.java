package com.yunhai.excel.orm;

public class FieldAndCsvHeardName {

	private String fieldRecordID;
	private String field;
	private String fieldName;
	private String dataType;
	private String csvHeaderName;
	
	
	public FieldAndCsvHeardName() {
		super();
	}


	public FieldAndCsvHeardName(String fieldRecordID, String field, String fieldName, String dataType,
			String csvHeaderName) {
		super();
		this.fieldRecordID = fieldRecordID;
		this.field = field;
		this.fieldName = fieldName;
		this.dataType = dataType;
		this.csvHeaderName = csvHeaderName;
	}


	public String getFieldRecordID() {
		return fieldRecordID;
	}


	public void setFieldRecordID(String fieldRecordID) {
		this.fieldRecordID = fieldRecordID;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getDataType() {
		return dataType;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	public String getCsvHeaderName() {
		return csvHeaderName;
	}


	public void setCsvHeaderName(String csvHeaderName) {
		this.csvHeaderName = csvHeaderName;
	} 
	
	

}
