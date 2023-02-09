package com.yunhai.bibliography.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAuthorGroup entity provides the base persistence definition of the
 * AuthorGroup entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAuthorGroup implements java.io.Serializable {

	// Fields

	private String authorGroupId;
	private String authorGroupName;
	private Date createdTime;
	private Double sortIndex;
	private String description;
	private Set authorLists = new HashSet(0);
	private Set bibliographies = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractAuthorGroup() {
	}

	/** minimal constructor */
	public AbstractAuthorGroup(String authorGroupId) {
		this.authorGroupId = authorGroupId;
	}

	/** full constructor */
	public AbstractAuthorGroup(String authorGroupId, String authorGroupName, Date createdTime, Double sortIndex,
			String description, Set authorLists, Set bibliographies) {
		this.authorGroupId = authorGroupId;
		this.authorGroupName = authorGroupName;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
		this.authorLists = authorLists;
		this.bibliographies = bibliographies;
	}

	// Property accessors

	public String getAuthorGroupId() {
		return this.authorGroupId;
	}

	public void setAuthorGroupId(String authorGroupId) {
		this.authorGroupId = authorGroupId;
	}

	public String getAuthorGroupName() {
		return this.authorGroupName;
	}

	public void setAuthorGroupName(String authorGroupName) {
		this.authorGroupName = authorGroupName;
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

	public Set getAuthorLists() {
		return this.authorLists;
	}

	public void setAuthorLists(Set authorLists) {
		this.authorLists = authorLists;
	}

	public Set getBibliographies() {
		return this.bibliographies;
	}

	public void setBibliographies(Set bibliographies) {
		this.bibliographies = bibliographies;
	}

}