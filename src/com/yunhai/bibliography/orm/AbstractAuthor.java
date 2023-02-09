package com.yunhai.bibliography.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAuthor entity provides the base persistence definition of the Author
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAuthor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1496235610521884347L;
	private String authorId;
	private String authorName;
	private String foreignName;
	private String motherLand;
	private Date createdDate;
	private Double sortIndex;
	private String description;
	private Set authorLists = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractAuthor() {
	}

	/** minimal constructor */
	public AbstractAuthor(String authorId) {
		this.authorId = authorId;
	}

	/** full constructor */
	public AbstractAuthor(String authorId, String authorName, String foreignName, String motherLand,
			Date createdDate, Double sortIndex, String description, Set authorLists) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.foreignName = foreignName;
		this.motherLand = motherLand;
		this.createdDate = createdDate;
		this.sortIndex = sortIndex;
		this.description = description;
		this.authorLists = authorLists;
	}

	// Property accessors

	public String getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getForeignName() {
		return this.foreignName;
	}

	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}

	public String getMotherLand() {
		return this.motherLand;
	}

	public void setMotherLand(String motherLand) {
		this.motherLand = motherLand;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Set getAuthorLists() {
		return this.authorLists;
	}

	public void setAuthorLists(Set authorLists) {
		this.authorLists = authorLists;
	}

}