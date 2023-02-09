package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

public class TableRow {
 private String structureCode;
 private int structurePaceLength;
 private TableColumnStructureElement tableColumnStructureElement;
 private int indexValue;
 private List<Map<Integer,Double>> columnList;
 
 
 
 
public TableColumnStructureElement getTableColumnStructureElement() {
	return tableColumnStructureElement;
}
public void setTableColumnStructureElement(TableColumnStructureElement tableColumnStructureElement) {
	this.tableColumnStructureElement = tableColumnStructureElement;
}
public int getIndexValue() {
	return indexValue;
}
public void setIndexValue(int indexValue) {
	this.indexValue = indexValue;
}
public List<Map<Integer, Double>> getColumnList() {
	return columnList;
}
public void setColumnList(List<Map<Integer, Double>> columnList) {
	this.columnList = columnList;
}
public String getStructureCode() {
	return structureCode;
}
public void setStructureCode(String structureCode) {
	this.structureCode = structureCode;
}
public int getStructurePaceLength() {
	return structurePaceLength;
}
public void setStructurePaceLength(int structurePaceLength) {
	this.structurePaceLength = structurePaceLength;
} 
 
 
 
 
}
