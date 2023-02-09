package com.yunhai.excel;

import java.math.BigDecimal;
import java.util.Map;
/**
 * 
 * @author 张敏
 * 创建时间：2019.11.15
 *
 */
public class StructureNode {
	
	/**
	 * 结构结点在结构体中的序号
	 */
	private int structureNodeNumber;

	/**
	 * 结构结点在结构体中的上级结点的序号
	 */
	private int parentNodeNumber;

	/**
	 * 结构结点的名称
	 */
	private String nodeName;

	/**
	 * 是否为叶子结点
	 */
	private boolean isLeaf;
	
	/**
	 * 本节点对应存放的值
	 */
	//private Map<String,BigDecimal> valueMap;
	private Map<Integer,BigDecimal> valueMap;
	
	public StructureNode() { 
		
	}
	
	public StructureNode(int structureNodeNumber, int parentNodeNumber, String nodeName, boolean isLeaf,
			Map<Integer, BigDecimal> valueMap) {
		super();
		this.structureNodeNumber = structureNodeNumber;
		this.parentNodeNumber = parentNodeNumber;
		this.nodeName = nodeName;
		this.isLeaf = isLeaf;
		this.valueMap = valueMap;
	}
	
	
	
	/*
	 * public Map<String, BigDecimal> getValueMap() { return valueMap; }
	 * 
	 * public void setValueMap(Map<String, BigDecimal> valueMap) { this.valueMap =
	 * valueMap; }
	 */

	public Map<Integer, BigDecimal> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<Integer, BigDecimal> valueMap) {
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
}
