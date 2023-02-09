package com.yunhai.excel.orm;

/**
 * AbstractDvArea entity provides the base persistence definition of the DvArea
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDvArea implements java.io.Serializable {

	// Fields

	private String dvAreaId;
	private String areaName;
	private String areaCode;
	private Short indexof;
	private String description;
	private Integer whetherEvaluation;
	private Integer isLeaf;
	private Integer treeCodeLength;

	// Constructors

	/** default constructor */
	public AbstractDvArea() {
	}

	/** minimal constructor */
	public AbstractDvArea(String dvAreaId, String areaName, String areaCode, Short indexof) {
		this.dvAreaId = dvAreaId;
		this.areaName = areaName;
		this.areaCode = areaCode;
		this.indexof = indexof;
	}

	/** full constructor */
	public AbstractDvArea(String dvAreaId, String areaName, String areaCode, Short indexof, String description,
			Integer whetherEvaluation, Integer isLeaf, Integer treeCodeLength) {
		this.dvAreaId = dvAreaId;
		this.areaName = areaName;
		this.areaCode = areaCode;
		this.indexof = indexof;
		this.description = description;
		this.whetherEvaluation = whetherEvaluation;
		this.isLeaf = isLeaf;
		this.treeCodeLength = treeCodeLength;
	}

	// Property accessors

	public String getDvAreaId() {
		return this.dvAreaId;
	}

	public void setDvAreaId(String dvAreaId) {
		this.dvAreaId = dvAreaId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Short getIndexof() {
		return this.indexof;
	}

	public void setIndexof(Short indexof) {
		this.indexof = indexof;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWhetherEvaluation() {
		return this.whetherEvaluation;
	}

	public void setWhetherEvaluation(Integer whetherEvaluation) {
		this.whetherEvaluation = whetherEvaluation;
	}

	public Integer getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getTreeCodeLength() {
		return this.treeCodeLength;
	}

	public void setTreeCodeLength(Integer treeCodeLength) {
		this.treeCodeLength = treeCodeLength;
	}

}