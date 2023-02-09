package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * 列结构元素，一个结构中对应一个或多个行。有多个列，也可以一列的复杂结构。
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
