package com.yunhai.otherWebSite.orm;

import java.util.Date;

/**
 * AbstractWebContent entity provides the base persistence definition of the
 * WebContent entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWebContent implements java.io.Serializable {

	// Fields

	private String webContentId;
	private String webSite;
	private String webContentHtml;
	private String webContent;
	private String storagePath;
	private Double sortIndex;
	private Date createDate;
	private String description;
	private String webSiteName;
	
	// Constructors

	/** default constructor */
	public AbstractWebContent() {
	}

	/** minimal constructor */
	public AbstractWebContent(String webContentId) {
		this.webContentId = webContentId;
	}

	/** full constructor */
	public AbstractWebContent(String webContentId, String webSite, String webContentHtml, String webContent,
			String storagePath, Double sortIndex, Date createDate, String description) {
		this.webContentId = webContentId;
		this.webSite = webSite;
		this.webContentHtml = webContentHtml;
		this.webContent = webContent;
		this.storagePath = storagePath;
		this.sortIndex = sortIndex;
		this.createDate = createDate;
		this.description = description;
	}

	
	
	public AbstractWebContent(String webContentId, String webSite, String webContentHtml, String webContent,
			String storagePath, Double sortIndex, Date createDate, String description, String webSiteName) {
		super();
		this.webContentId = webContentId;
		this.webSite = webSite;
		this.webContentHtml = webContentHtml;
		this.webContent = webContent;
		this.storagePath = storagePath;
		this.sortIndex = sortIndex;
		this.createDate = createDate;
		this.description = description;
		this.webSiteName = webSiteName;
	}
	// Property accessors

	

	public String getWebContentId() {
		return this.webContentId;
	}

	public String getWebSiteName() {
		return webSiteName;
	}

	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}

	public void setWebContentId(String webContentId) {
		this.webContentId = webContentId;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebContentHtml() {
		return this.webContentHtml;
	}

	public void setWebContentHtml(String webContentHtml) {
		this.webContentHtml = webContentHtml;
	}

	public String getWebContent() {
		return this.webContent;
	}

	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}

	public String getStoragePath() {
		return this.storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}

	public Double getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}