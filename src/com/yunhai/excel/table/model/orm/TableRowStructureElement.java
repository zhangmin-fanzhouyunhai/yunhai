package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * ��ͷ�ṹԪ�أ�һ���ṹ�ж�Ӧһ�������С��ж���У�Ҳ����һ�еĸ��ӽṹ��
 *
 */
public class TableRowStructureElement {
	private int indexValue;
	private List<Map<Integer,String>> rowMapList;
	
	public TableRowStructureElement() {
		
	}
	
	public TableRowStructureElement(int indexValue) {
		super();
		this.indexValue = indexValue; 
	}
	
	public TableRowStructureElement(int indexValue, List<Map<Integer, String>> rowMapList) {
		super();
		this.indexValue = indexValue;
		this.rowMapList = rowMapList;
	}
	public int getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
	}
	public List<Map<Integer, String>> getRowMapList() {
		return rowMapList;
	}
	public void setRowMapList(List<Map<Integer, String>> rowMapList) {
		this.rowMapList = rowMapList;
	}
	
	
}
