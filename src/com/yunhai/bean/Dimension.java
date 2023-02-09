package com.yunhai.bean;

public class Dimension extends AbstractDimension{

	public Dimension() {
		// TODO Auto-generated constructor stub
	}

	public Dimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionName,
			String dimensionValue, String dimensionCode) {
		super(serialNumber, dimensionID, parentDimensionID, dimensionName, dimensionValue, dimensionCode);
		// TODO Auto-generated constructor stub
	}

	public Dimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionName,
			String dimensionValue, String dimensionCode, String dimensionDescription) {
		super(serialNumber, dimensionID, parentDimensionID, dimensionName, dimensionValue, dimensionCode, dimensionDescription);
		// TODO Auto-generated constructor stub
	}

	public Dimension(Long serialNumber, String dimensionID, String parentDimensionID, String dimensionType,
			String dimensionName, String dimensionValue, Integer dimensionIndexof, String dimensionCode,
			String dimensionDescription) {
		super(serialNumber, dimensionID, parentDimensionID, dimensionType, dimensionName, dimensionValue, dimensionIndexof,
				dimensionCode, dimensionDescription);
		// TODO Auto-generated constructor stub
	}

}
