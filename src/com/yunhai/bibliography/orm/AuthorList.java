package com.yunhai.bibliography.orm;

import java.util.Date;

/**
 * AuthorList entity. @author MyEclipse Persistence Tools
 */
public class AuthorList extends AbstractAuthorList implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4059728563373887004L;

	/** default constructor */
	public AuthorList() {
	}

	/** minimal constructor */
	public AuthorList(String authorListId) {
		super(authorListId);
	}

	/** full constructor */
	public AuthorList(String authorListId, AuthorGroup authorGroup, Author author, String authorListName,
			Date createdTime, Double sortIndex, String description) {
		super(authorListId, authorGroup, author, authorListName, createdTime, sortIndex, description);
	}

	public AuthorList(String authorListId, AuthorGroup authorGroup, Author author, String authorGroupId,
			String authorId, String authorListName, Date createdTime, Double sortIndex, String description) {
		super(authorListId, authorGroup, author, authorGroupId, authorId, authorListName, createdTime, sortIndex, description);
		// TODO Auto-generated constructor stub
	}

	public AuthorList(String authorListId, String authorGroupId, String authorId, String authorListName,
			Date createdTime, Double sortIndex, String description) {
		super(authorListId, authorGroupId, authorId, authorListName, createdTime, sortIndex, description);
		// TODO Auto-generated constructor stub
	}

}
