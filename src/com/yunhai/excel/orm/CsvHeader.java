package com.yunhai.excel.orm;

public class CsvHeader {
	private String csvHeaderName;
	private String csvHeaderValue;
	private Integer indexof ;
	 
	public CsvHeader() {
		super();
	}
	public CsvHeader(String csvHeaderName, String csvHeaderValue, Integer indexof) {
		super();
		this.csvHeaderName = csvHeaderName;
		this.csvHeaderValue = csvHeaderValue;
		this.indexof = indexof;
	}
	public String getCsvHeaderName() {
		return csvHeaderName;
	}
	public void setCsvHeaderName(String csvHeaderName) {
		this.csvHeaderName = csvHeaderName;
	}
	public String getCsvHeaderValue() {
		return csvHeaderValue;
	}
	public void setCsvHeaderValue(String csvHeaderValue) {
		this.csvHeaderValue = csvHeaderValue;
	}
	public Integer getIndexof() {
		return indexof;
	}
	public void setIndexof(Integer indexof) {
		this.indexof = indexof;
	}
	
	
	
}
