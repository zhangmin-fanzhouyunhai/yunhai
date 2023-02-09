package com.yunhai.excel.orm;

/**
 * DvArea entity. @author MyEclipse Persistence Tools
 */
public class DvArea extends AbstractDvArea implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public DvArea() {
	}

	/** minimal constructor */
	public DvArea(String dvAreaId, String areaName, String areaCode, Short indexof) {
		super(dvAreaId, areaName, areaCode, indexof);
	}

	/** full constructor */
	public DvArea(String dvAreaId, String areaName, String areaCode, Short indexof, String description,
			Integer whetherEvaluation, Integer isLeaf, Integer treeCodeLength) {
		super(dvAreaId, areaName, areaCode, indexof, description, whetherEvaluation, isLeaf, treeCodeLength);
	}

}
