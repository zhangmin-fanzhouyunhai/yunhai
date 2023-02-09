package com.yunhai.excel.orm;

public abstract class AbstractOriginalNetReport implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8418126995624138908L;
	private String dimIndex;
	private String dimValue;
	private Double originValue;

	/** full constructor */
	public AbstractOriginalNetReport(String dimIndex, String dimValue, Double originValue, Double netValue) {
		this.dimIndex = dimIndex;
		this.dimValue = dimValue;
		this.originValue = originValue;
		this.netValue = netValue;
	}
	/** default constructor */
	public AbstractOriginalNetReport() {

	}

	public String getDimIndex() {
		return dimIndex;
	}

	public void setDimIndex(String dimIndex) {
		this.dimIndex = dimIndex;
	}

	public String getDimValue() {
		return dimValue;
	}

	public void setDimValue(String dimValue) {
		this.dimValue = dimValue;
	}

	public Double getOriginValue() {
		return originValue;
	}

	public void setOriginValue(Double originValue) {
		this.originValue = originValue;
	}

	public Double getNetValue() {
		return netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	private Double netValue;

}
