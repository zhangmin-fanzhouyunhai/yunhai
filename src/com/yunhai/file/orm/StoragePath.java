package com.yunhai.file.orm;

import java.util.Date;

/**
 * StoragePath entity. @author MyEclipse Persistence Tools
 */
public class StoragePath extends AbstractStoragePath implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public StoragePath() {
	}

	/** minimal constructor */
	public StoragePath(String storagePathId) {
		super(storagePathId);
	}

	/** full constructor */
	public StoragePath(String storagePathId, String storagePathName, String storagePathValue, String creatorName,
			Date createDate, Double sortIndex, String description) {
		super(storagePathId, storagePathName, storagePathValue, creatorName, createDate, sortIndex, description);
	}

}
