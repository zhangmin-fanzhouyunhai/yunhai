package com.yunhai.bean;

public class AbstractDimension {
	
	private Long serialNumber; //维度序号
	private String dimensionID;//维度值记录ID
	private String parentDimensionID;//维度值记录对应父级ID
	private String dimensionType;//维度类型
	private String dimensionName;//维度名称
	private String dimensionValue;//维度值
	private Integer dimensionIndexof;//维度排序
	private String dimensionCode;//维度编号
	private String dimensionDescription;//维度说明
	

	public AbstractDimension() {
		// TODO Auto-generated constructor stub
	}


	public AbstractDimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionName,
			String dimensionValue, String dimensionCode) {
		super();
		this.serialNumber = serialNumber;
		this.dimensionID = dimensionID;
		this.parentDimensionID = parentDimensionID;
		this.dimensionName = dimensionName;
		this.dimensionValue = dimensionValue;
		this.dimensionCode = dimensionCode;
	}


	public AbstractDimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionName,
			String dimensionValue, String dimensionCode, String dimensionDescription) {
		super();
		this.serialNumber = serialNumber;
		this.dimensionID = dimensionID;
		this.parentDimensionID = parentDimensionID;
		this.dimensionName = dimensionName;
		this.dimensionValue = dimensionValue;
		this.dimensionCode = dimensionCode;
		this.dimensionDescription = dimensionDescription;
	}


	
	
	public AbstractDimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionType,
			String dimensionName, String dimensionValue, Integer dimensionIndexof, String dimensionCode,
			String dimensionDescription) {
		super();
		this.serialNumber = serialNumber;
		this.dimensionID = dimensionID;
		this.parentDimensionID = parentDimensionID;
		this.dimensionType = dimensionType;
		this.dimensionName = dimensionName;
		this.dimensionValue = dimensionValue;
		this.dimensionIndexof = dimensionIndexof;
		this.dimensionCode = dimensionCode;
		this.dimensionDescription = dimensionDescription;
	}


	public String getDimensionType() {
		return dimensionType;
	}


	public void setDimensionType(String dimensionType) {
		this.dimensionType = dimensionType;
	}


	public Integer getDimensionIndexof() {
		return dimensionIndexof;
	}


	public void setDimensionIndexof(Integer dimensionIndexof) {
		this.dimensionIndexof = dimensionIndexof;
	}


	public String getDimensionDescription() {
		return dimensionDescription;
	}


	public void setDimensionDescription(String dimensionDescription) {
		this.dimensionDescription = dimensionDescription;
	}


	public Long getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getDimensionID() {
		return dimensionID;
	}


	public void setDimensionID(String dimensionID) {
		this.dimensionID = dimensionID;
	}


	public String getParentDimensionID() {
		return parentDimensionID;
	}


	public void setParentDimensionID(String parentDimensionID) {
		this.parentDimensionID = parentDimensionID;
	}


	public String getDimensionName() {
		return dimensionName;
	}


	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}


	public String getDimensionValue() {
		return dimensionValue;
	}


	public void setDimensionValue(String dimensionValue) {
		this.dimensionValue = dimensionValue;
	}


	public String getDimensionCode() {
		return dimensionCode;
	}


	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}


	@Override
	public String toString() {
		return "AbstractDimension [serialNumber=" + serialNumber + ", dimensionID=" + dimensionID
				+ ", parentDimensionID=" + parentDimensionID + ", dimensionName=" + dimensionName + ", dimensionValue="
				+ dimensionValue + ", dimensionCode=" + dimensionCode + "]";
	}

}
