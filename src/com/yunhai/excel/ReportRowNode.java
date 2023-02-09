package com.yunhai.excel;
 
import java.util.List;
import java.util.Map;

public class ReportRowNode {

	private List<Dimension> dimensionList;
	private List<IndicateNode> indicateLsit;
	private Map<String, Dimension> dimensionMap;
	private String treeStructureCode;
	private boolean isLeaf;

	public ReportRowNode() {
		super();
	}

	public ReportRowNode(List<Dimension> dimensionList, List<IndicateNode> indicateLsit, String treeStructureCode,
			boolean isLeaf) {
		super();
		this.dimensionList = dimensionList;
		this.indicateLsit = indicateLsit;
		this.treeStructureCode = treeStructureCode;
		this.isLeaf = isLeaf;
	}

	

	public ReportRowNode(List<Dimension> dimensionList, List<IndicateNode> indicateLsit, String treeStructureCode,
			boolean isLeaf,Map<String, Dimension> dimensionMap) {
		super();
		this.dimensionList = dimensionList;
		this.indicateLsit = indicateLsit;
		this.treeStructureCode = treeStructureCode;
		this.isLeaf = isLeaf;
		this.dimensionMap=dimensionMap;
	}

	
	
	
	public Map<String, Dimension> getDimensionMap() {
		return dimensionMap;
	}

	public void setDimensionMap(Map<String, Dimension> dimensionMap) {
		this.dimensionMap = dimensionMap;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<Dimension> getDimensionList() {
		return dimensionList;
	}

	public void setDimensionList(List<Dimension> dimensionList) {
		this.dimensionList = dimensionList;
	}

	public List<IndicateNode> getIndicateLsit() {
		return indicateLsit;
	}

	public void setIndicateLsit(List<IndicateNode> indicateLsit) {
		this.indicateLsit = indicateLsit;
	}

	public String getTreeStructureCode() {
		return treeStructureCode;
	}

	public void setTreeStructureCode(String treeStructureCode) {
		this.treeStructureCode = treeStructureCode;
	}

}
