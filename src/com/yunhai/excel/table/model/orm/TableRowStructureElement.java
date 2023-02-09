package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * 表头结构元素，一个结构中对应一个或多个列。有多个行，也可以一行的复杂结构。
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
