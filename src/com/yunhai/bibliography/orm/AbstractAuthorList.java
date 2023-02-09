package com.yunhai.bibliography.orm;

import java.util.Date;

/**
 * AbstractAuthorList entity provides the base persistence definition of the
 * AuthorList entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAuthorList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6913446322719881777L;
	private String authorListId;
	private AuthorGroup authorGroup;
	private Author author;
	private String authorGroupId;
	private String authorId; 
	private String authorListName;
	private Date createdTime;
	private Double sortIndex;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractAuthorList() {
	}

	/** minimal constructor */
	public AbstractAuthorList(String authorListId) {
		this.authorListId = authorListId;
	}

	/** full constructor */
	public AbstractAuthorList(String authorListId, AuthorGroup authorGroup, Author author, String authorListName,
			Date createdTime, Double sortIndex, String description) {
		this.authorListId = authorListId;
		this.authorGroup = authorGroup;
		this.author = author;
		this.authorListName = authorListName;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}


	public AbstractAuthorList(String authorListId, AuthorGroup authorGroup, Author author, String authorGroupId,
			String authorId, String authorListName, Date createdTime, Double sortIndex, String description) {
		super();
		this.authorListId = authorListId;
		this.authorGroup = authorGroup;
		this.author = author;
		this.authorGroupId = authorGroupId;
		this.authorId = authorId;
		this.authorListName = authorListName;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	public AbstractAuthorList(String authorListId, String authorGroupId, String authorId, String authorListName,
			Date createdTime, Double sortIndex, String description) {
		super();
		this.authorListId = authorListId;
		this.authorGroupId = authorGroupId;
		this.authorId = authorId;
		this.authorListName = authorListName;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	// Property accessors
	public String getAuthorListId() {
		return this.authorListId;
	}

	public String getAuthorGroupId() {
		return authorGroupId;
	}

	public void setAuthorGroupId(String authorGroupId) {
		this.authorGroupId = authorGroupId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public void setAuthorListId(String authorListId) {
		this.authorListId = authorListId;
	}

	public AuthorGroup getAuthorGroup() {
		return this.authorGroup;
	}

	public void setAuthorGroup(AuthorGroup authorGroup) {
		this.authorGroup = authorGroup;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getAuthorListName() {
		return this.authorListName;
	}

	public void setAuthorListName(String authorListName) {
		this.authorListName = authorListName;
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