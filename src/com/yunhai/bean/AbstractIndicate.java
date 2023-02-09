package com.yunhai.bean;

import java.util.List;
import java.util.Map;

public class AbstractIndicate {

	private Map indicateMap; //指标值列表 ，当
	private String indicateName;//指标名称
	private List<AbstractDimension> dimensionList;//维度列表
	private int columnNumber=0;//指标在报表中的列脚本
	private int rowNumber=0;//指标在报表中的行脚本 
	/**
	 * indicateMap.size()>1时。
	 * 报表方向，
	 * 0为横向，即indicateMap中的key值做为横向维度输出;
	 * 1为纵向，即indicateMap中的key值做为纵向维度输出
	 */
	private int direction=0;
	
	public AbstractIndicate() {
		// TODO Auto-generated constructor stub 
	}

	public AbstractIndicate(Map indicateMap, String indicateName, List<AbstractDimension> dimensionList) {
		super();
		this.indicateMap = indicateMap;
		this.indicateName = indicateName;
		this.dimensionList = dimensionList;
	}

	public AbstractIndicate(Map indicateMap, String indicateName,
			List<AbstractDimension> dimensionList,int columnNumber, int rowNumber ) {
		super();
		this.columnNumber = columnNumber;
		this.rowNumber = rowNumber;
		this.indicateMap = indicateMap;
		this.indicateName = indicateName;
		this.dimensionList = dimensionList;
	}

	public AbstractIndicate(Map indicateMap, String indicateName, List<AbstractDimension> dimensionList,
			int columnNumber, int rowNumber, int direction) {
		super();
		this.indicateMap = indicateMap;
		this.indicateName = indicateName;
		this.dimensionList = dimensionList;
		this.columnNumber = columnNumber;
		this.rowNumber = rowNumber;
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Map getIndicateMap() {
		return indicateMap;
	}

	public void setIndicateMap(Map indicateMap) {
		this.indicateMap = indicateMap;
	}

	public String getIndicateName() {
		return indicateName;
	}

	public void setIndicateName(String indicateName) {
		this.indicateName = indicateName;
	}

	public List<AbstractDimension> getDimensionList() {
		return dimensionList;
	}

	public void setDimensionList(List<AbstractDimension> dimensionList) {
		this.dimensionList = dimensionList;
	}

}
