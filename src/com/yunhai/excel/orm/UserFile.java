package com.yunhai.excel.orm;

import java.util.Date;

/**
 * UserFile entity. @author MyEclipse Persistence Tools
 */
public class UserFile extends AbstractUserFile implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserFile() {
	}

	/** minimal constructor */
	public UserFile(String userFileId) {
		super(userFileId);
	}

	/** full constructor */
	public UserFile(String userFileId, String userAccountId, String fileName, String pathName, Date uploadDate,
			Date importDate, String description) {
		super(userFileId, userAccountId, fileName, pathName, uploadDate, importDate, description);
	}

}
