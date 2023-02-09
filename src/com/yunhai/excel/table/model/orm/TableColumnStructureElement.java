package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * �нṹԪ�أ�һ���ṹ�ж�Ӧһ�������С��ж���У�Ҳ����һ�еĸ��ӽṹ��
 */
public class TableColumnStructureElement {

	private int indexValue;
	private List<Map<Integer,String>> columnMapList;
	
	

	public TableColumnStructureElement() {
		super(); 
	}
	public TableColumnStructureElement(int indexValue) {
		super();
		this.indexValue = indexValue; 
	}
	
	public TableColumnStructureElement(int indexValue, List<Map<Integer, String>> columnMapList) {
		super();
		this.indexValue = indexValue;
		this.columnMapList = columnMapList;
	}
	
	
	public int getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
	}
	public List<Map<Integer, String>> getColumnMapList() {
		return columnMapList;
	}
	public void setColumnMapList(List<Map<Integer, String>> columnMapList) {
		this.columnMapList = columnMapList;
	}
	
	
	
}
