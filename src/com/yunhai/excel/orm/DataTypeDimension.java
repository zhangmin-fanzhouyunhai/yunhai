package com.yunhai.excel.orm;

public class DataTypeDimension {
	public String dimID  ;
	public String dimName ;
	public String dimValue;
	public String dimCode;
	public int  indexOf;
	public String description;
	 
	
	public DataTypeDimension() {
		super();
	}
	public DataTypeDimension(String dimID, String dimName, String dimValue, String dimCode, int indexOf,
			String description) {
		super();
		this.dimID = dimID;
		this.dimName = dimName;
		this.dimValue = dimValue;
		this.dimCode = dimCode;
		this.indexOf = indexOf;
		this.description = description;
	}
	public String getDimID() {
		return dimID;
	}
	public void setDimID(String dimID) {
		this.dimID = dimID;
	}
	public String getDimName() {
		return dimName;
	}
	public void setDimName(String dimName) {
		this.dimName = dimName;
	}
	public String getDimValue() {
		return dimValue;
	}
	public void setDimValue(String dimValue) {
		this.dimValue = dimValue;
	}
	public String getDimCode() {
		return dimCode;
	}
	public void setDimCode(String dimCode) {
		this.dimCode = dimCode;
	}
	public int getIndexOf() {
		return indexOf;
	}
	public void setIndexOf(int indexOf) {
		this.indexOf = indexOf;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
