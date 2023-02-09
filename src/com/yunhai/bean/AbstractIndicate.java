package com.yunhai.bean;

import java.util.List;
import java.util.Map;

public class AbstractIndicate {

	private Map indicateMap; //ָ��ֵ�б� ����
	private String indicateName;//ָ������
	private List<AbstractDimension> dimensionList;//ά���б�
	private int columnNumber=0;//ָ���ڱ����е��нű�
	private int rowNumber=0;//ָ���ڱ����е��нű� 
	/**
	 * indicateMap.size()>1ʱ��
	 * ������
	 * 0Ϊ���򣬼�indicateMap�е�keyֵ��Ϊ����ά�����;
	 * 1Ϊ���򣬼�indicateMap�е�keyֵ��Ϊ����ά�����
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
