package com.yunhai.excel;

import java.math.BigDecimal;

public class IndicateNode {
	private String indicateType;
	private String indicateName;
	private Double indicateIndexof;
	private BigDecimal indicateValue;
	private String description;

	public IndicateNode() {
		super();
	}

	 
	public IndicateNode(String indicateType, String indicateName, Double indicateIndexof, BigDecimal indicateValue,
			String description) {
		super();
		this.indicateType = indicateType;
		this.indicateName = indicateName;
		this.indicateIndexof = indicateIndexof;
		this.indicateValue = indicateValue;
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIndicateType() {
		return indicateType;
	}

	public void setIndicateType(String indicateType) {
		this.indicateType = indicateType;
	}

	public String getIndicateName() {
		return indicateName;
	}

	public void setIndicateName(String indicateName) {
		this.indicateName = indicateName;
	}

	public Double getIndicateIndexof() {
		return indicateIndexof;
	}

	public void setIndicateIndexof(Double indicateIndexof) {
		this.indicateIndexof = indicateIndexof;
	}

	public BigDecimal getIndicateValue() {
		return indicateValue;
	}

	public void setIndicateValue(BigDecimal indicateValue) {
		this.indicateValue = indicateValue;
	}

}
