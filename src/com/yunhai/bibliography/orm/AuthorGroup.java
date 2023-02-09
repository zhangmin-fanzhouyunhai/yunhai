package com.yunhai.bibliography.orm;

import java.util.Date;
import java.util.Set;

/**
 * AuthorGroup entity. @author MyEclipse Persistence Tools
 */
public class AuthorGroup extends AbstractAuthorGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AuthorGroup() {
	}

	/** minimal constructor */
	public AuthorGroup(String authorGroupId) {
		super(authorGroupId);
	}

	/** full constructor */
	public AuthorGroup(String authorGroupId, String authorGroupName, Date createdTime, Double sortIndex,
			String description, Set authorLists, Set bibliographies) {
		super(authorGroupId, authorGroupName, createdTime, sortIndex, description, authorLists, bibliographies);
	}

}
