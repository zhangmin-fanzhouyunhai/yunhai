package com.yunhai.otherWebSite.orm;

import java.util.Date;

/**
 * WebContent entity. @author MyEclipse Persistence Tools
 */
public class WebContent extends AbstractWebContent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public WebContent() {
	}

	/** minimal constructor */
	public WebContent(String webContentId) {
		super(webContentId);
	}

	/** full constructor */
	public WebContent(String webContentId, String webSite, String webContentHtml, String webContent, String storagePath,
			Double sortIndex, Date createDate, String description) {
		super(webContentId, webSite, webContentHtml, webContent, storagePath, sortIndex, createDate, description);
	}

	public WebContent(String webContentId, String webSite, String webContentHtml, String webContent, String storagePath,
			Double sortIndex, Date createDate, String description, String webSiteName) {
		super(webContentId, webSite, webContentHtml, webContent, storagePath, sortIndex, createDate, description, webSiteName);
		// TODO Auto-generated constructor stub
	}

}
