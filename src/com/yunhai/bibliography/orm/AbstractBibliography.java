package com.yunhai.bibliography.orm;

import java.util.Date;

/**
 * AbstractBibliography entity provides the base persistence definition of the
 * Bibliography entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBibliography implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9060313167976792202L;
	private String bibliographyId;
	private AuthorGroup authorGroup;
	private String authorGroupId;
	private String bibliographyName;
	private String motherLand;
	private Date createdTime;
	private Double sortIndex;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractBibliography() {
	}

	/** minimal constructor */
	public AbstractBibliography(String bibliographyId) {
		this.bibliographyId = bibliographyId;
	}

	/** full constructor */
	public AbstractBibliography(String bibliographyId, AuthorGroup authorGroup, String bibliographyName,
			String motherLand, Date createdTime, Double sortIndex, String description) {
		this.bibliographyId = bibliographyId;
		this.authorGroup = authorGroup;
		this.bibliographyName = bibliographyName;
		this.motherLand = motherLand;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}


	public AbstractBibliography(String bibliographyId, AuthorGroup authorGroup, String authorGroupId,
			String bibliographyName, String motherLand, Date createdTime, Double sortIndex, String description) {
		super();
		this.bibliographyId = bibliographyId;
		this.authorGroup = authorGroup;
		this.authorGroupId = authorGroupId;
		this.bibliographyName = bibliographyName;
		this.motherLand = motherLand;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	public AbstractBibliography(String bibliographyId, String authorGroupId, String bibliographyName, String motherLand,
			Date createdTime, Double sortIndex, String description) {
		super();
		this.bibliographyId = bibliographyId;
		this.authorGroupId = authorGroupId;
		this.bibliographyName = bibliographyName;
		this.motherLand = motherLand;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	// Property accessors
	public String getBibliographyId() {
		return this.bibliographyId;
	}

	public String getAuthorGroupId() {
		return authorGroupId;
	}

	public void setAuthorGroupId(String authorGroupId) {
		this.authorGroupId = authorGroupId;
	}

	public void setBibliographyId(String bibliographyId) {
		this.bibliographyId = bibliographyId;
	}

	public AuthorGroup getAuthorGroup() {
		return this.authorGroup;
	}

	public void setAuthorGroup(AuthorGroup authorGroup) {
		this.authorGroup = authorGroup;
	}

	public String getBibliographyName() {
		return this.bibliographyName;
	}

	public void setBibliographyName(String bibliographyName) {
		this.bibliographyName = bibliographyName;
	}

	public String getMotherLand() {
		return this.motherLand;
	}

	public void setMotherLand(String motherLand) {
		this.motherLand = motherLand;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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