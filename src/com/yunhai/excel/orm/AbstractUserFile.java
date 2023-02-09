package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractUserFile entity provides the base persistence definition of the
 * UserFile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserFile implements java.io.Serializable {

	// Fields

	private String userFileId;
	private String userAccountId;
	private String fileName;
	private String pathName;
	private Date uploadDate;
	private Date importDate;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractUserFile() {
	}

	/** minimal constructor */
	public AbstractUserFile(String userFileId) {
		this.userFileId = userFileId;
	}

	/** full constructor */
	public AbstractUserFile(String userFileId, String userAccountId, String fileName, String pathName,
			Date uploadDate, Date importDate, String description) {
		this.userFileId = userFileId;
		this.userAccountId = userAccountId;
		this.fileName = fileName;
		this.pathName = pathName;
		this.uploadDate = uploadDate;
		this.importDate = importDate;
		this.description = description;
	}

	// Property accessors

	public String getUserFileId() {
		return this.userFileId;
	}

	public void setUserFileId(String userFileId) {
		this.userFileId = userFileId;
	}

	public String getUserAccountId() {
		return this.userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPathName() {
		return this.pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getImportDate() {
		return this.importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}