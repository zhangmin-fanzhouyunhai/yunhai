package com.yunhai.excel;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 
 * @author 张敏
 * 创建时间�?2020.9.23
 *
 */
public class ExtendStructureNode {
/*
 * 结点Node类型要扩充属性，
 * 以行为主，开始列与结束列�?
 * 支持多重列结点，列树形结构；
 * �?�? 结点中支持多�?,默认�?1行，
 */
	
	/**
	 * 结构结点在结构体中的序号
	 */
	private int structureNodeNumber;

	/**
	 * 结构结点在结构体中的上级结点的序�?
	 */
	private int parentNodeNumber;

	/**
	 * 结构结点的名�?
	 */
	private String nodeName;

	/**
	 * 是否为叶子结点，默认为要结点
	 */
	private boolean isLeaf=false;
	/*
	 * 结点中数据行数，默认�?1�?
	 */
	private int rowNumber=1;
	/*
	 * 结点中数据对应列数，默认�?1�?
	 */
	private int colNumber=1;
	/**
	 * 本节点各行对应的行名�?
	 */ 
	private Map<Integer,String> rowNameMap;
	/**
	 * 本节点各行对应的列名�?
	 * 参�??2019年报表�?�F.3 利用效率-资产利用状�?��?�的结构
	 * 只支持叶子结点维度转�?
	 */ 
	private Map<Integer,String> colNameMap;
	/**
	 * 本节点各行，对应的各列的数据
	 */ 
	private Map<Integer,Map<Integer,BigDecimal>> valueMap;
	

	public ExtendStructureNode() { 
	}
	
	 
	public ExtendStructureNode(int structureNodeNumber, int parentNodeNumber, String nodeName, boolean isLeaf,
			int rowNumber, int colNumber, Map<Integer, String> rowNameMap, Map<Integer, String> colNameMap,
			Map<Integer, Map<Integer, BigDecimal>> valueMap) {
		super();
		this.structureNodeNumber = structureNodeNumber;
		this.parentNodeNumber = parentNodeNumber;
		this.nodeName = nodeName;
		this.isLeaf = isLeaf;
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.rowNameMap = rowNameMap;
		this.colNameMap = colNameMap;
		this.valueMap = valueMap;
	}
	public int getStructureNodeNumber() {
		return structureNodeNumber;
	}
	public void setStructureNodeNumber(int structureNodeNumber) {
		this.structureNodeNumber = structureNodeNumber;
	}
	public int getParentNodeNumber() {
		return parentNodeNumber;
	}
	public void setParentNodeNumber(int parentNodeNumber) {
		this.parentNodeNumber = parentNodeNumber;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public int getColNumber() {
		return colNumber;
	}
	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}
	public Map<Integer, String> getRowNameMap() {
		return rowNameMap;
	}
	public void setRowNameMap(Map<Integer, String> rowNameMap) {
		this.rowNameMap = rowNameMap;
	}
	public Map<Integer, String> getColNameMap() {
		return colNameMap;
	}
	public void setColNameMap(Map<Integer, String> colNameMap) {
		this.colNameMap = colNameMap;
	}
	public Map<Integer, Map<Integer, BigDecimal>> getValueMap() {
		return valueMap;
	}
	public void setValueMap(Map<Integer, Map<Integer, BigDecimal>> valueMap) {
		this.valueMap = valueMap;
	}
	
	
}
