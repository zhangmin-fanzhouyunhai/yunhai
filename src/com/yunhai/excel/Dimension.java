package com.yunhai.excel;

public class Dimension {
private String dimensionType;
private String dimensionName;
private String dimensionValue;
private Integer dimensionIndexof;
private String dimensionCode;
private String discription;



public Dimension() {
	super();
} 
 

public Dimension(String dimensionType, String dimensionName, String dimensionValue, Integer dimensionIndexof,
		String dimensionCode, String discription) {
	super();
	this.dimensionType = dimensionType;
	this.dimensionName = dimensionName;
	this.dimensionValue = dimensionValue;
	this.dimensionIndexof = dimensionIndexof;
	this.dimensionCode = dimensionCode;
	this.discription = discription;
}





public String getDimensionValue() {
	return dimensionValue;
}





public void setDimensionValue(String dimensionValue) {
	this.dimensionValue = dimensionValue;
}





public String getDimensionType() {
	return dimensionType;
}
public void setDimensionType(String dimensionType) {
	this.dimensionType = dimensionType;
}
public String getDimensionName() {
	return dimensionName;
}
public void setDimensionName(String dimensionName) {
	this.dimensionName = dimensionName;
}
public Integer getDimensionIndexof() {
	return dimensionIndexof;
}
public void setDimensionIndexof(Integer dimensionIndexof) {
	this.dimensionIndexof = dimensionIndexof;
}
public String getDimensionCode() {
	return dimensionCode;
}
public void setDimensionCode(String dimensionCode) {
	this.dimensionCode = dimensionCode;
}
public String getDiscription() {
	return discription;
}
public void setDiscription(String discription) {
	this.discription = discription;
}



}