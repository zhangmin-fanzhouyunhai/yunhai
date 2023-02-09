package com.yunhai.file.orm;

import java.util.Date;

/**
 * AbstractStoragePath entity provides the base persistence definition of the
 * StoragePath entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStoragePath implements java.io.Serializable {

	// Fields

	private String storagePathId;
	private String storagePathName;
	private String storagePathValue;
	private String creatorName;
	private Date createDate;
	private Double sortIndex;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractStoragePath() {
	}

	/** minimal constructor */
	public AbstractStoragePath(String storagePathId) {
		this.storagePathId = storagePathId;
	}

	/** full constructor */
	public AbstractStoragePath(String storagePathId, String storagePathName, String storagePathValue,
			String creatorName, Date createDate, Double sortIndex, String description) {
		this.storagePathId = storagePathId;
		this.storagePathName = storagePathName;
		this.storagePathValue = storagePathValue;
		this.creatorName = creatorName;
		this.createDate = createDate;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	// Property accessors

	public String getStoragePathId() {
		return this.storagePathId;
	}

	public void setStoragePathId(String storagePathId) {
		this.storagePathId = storagePathId;
	}

	public String getStoragePathName() {
		return this.storagePathName;
	}

	public void setStoragePathName(String storagePathName) {
		this.storagePathName = storagePathName;
	}

	public String getStoragePathValue() {
		return this.storagePathValue;
	}

	public void setStoragePathValue(String storagePathValue) {
		this.storagePathValue = storagePathValue;
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}