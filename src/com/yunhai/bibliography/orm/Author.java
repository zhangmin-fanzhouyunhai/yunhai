package com.yunhai.bibliography.orm;

import java.util.Date;
import java.util.Set;

/**
 * Author entity. @author MyEclipse Persistence Tools
 */
public class Author extends AbstractAuthor implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Author() {
	}

	/** minimal constructor */
	public Author(String authorId) {
		super(authorId);
	}

	/** full constructor */
	public Author(String authorId, String authorName, String foreignName, String motherLand, Date createdDate,
			Double sortIndex, String description, Set authorLists) {
		super(authorId, authorName, foreignName, motherLand, createdDate, sortIndex, description, authorLists);
	}

}
