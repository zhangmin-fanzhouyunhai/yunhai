package com.yunhai.excel.table.model.orm;

import java.util.List;
import java.util.Map;

public class TableRowElement {
	private String structureCode;
	private int structurePaceLength;
	private TableColumnStructureElement tableColumnStructureElement;
	private int columnIndexValue;
	private List<TableRowStructureElement> tableRowStructure;
	private List<List<Map<Integer, Double>>> columnList;

	
	public TableRowElement(String structureCode, int structurePaceLength,
			TableColumnStructureElement tableColumnStructureElement, int columnIndexValue,
			List<TableRowStructureElement> tableRowStructure, List<List<Map<Integer, Double>>> columnList) {
		super();
		this.structureCode = structureCode;
		this.structurePaceLength = structurePaceLength;
		this.tableColumnStructureElement = tableColumnStructureElement;
		this.columnIndexValue = columnIndexValue;
		this.tableRowStructure = tableRowStructure;
		this.columnList = columnList;
	}

	public List<TableRowStructureElement> getTableRowStructure() {
		return tableRowStructure;
	}

	public void setTableRowStructure(List<TableRowStructureElement> tableRowStructure) {
		this.tableRowStructure = tableRowStructure;
	}

	public List<List<Map<Integer, Double>>> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<List<Map<Integer, Double>>> columnList) {
		this.columnList = columnList;
	}

	public int getColumnIndexValue() {
		return columnIndexValue;
	}

	public void setColumnIndexValue(int columnIndexValue) {
		this.columnIndexValue = columnIndexValue;
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

	public TableColumnStructureElement getTableColumnStructureElement() {
		return tableColumnStructureElement;
	}

	public void setTableColumnStructureElement(TableColumnStructureElement tableColumnStructureElement) {
		this.tableColumnStructureElement = tableColumnStructureElement;
	} 

}
