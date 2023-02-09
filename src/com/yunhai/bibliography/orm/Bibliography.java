package com.yunhai.bibliography.orm;

import java.util.Date;

/**
 * Bibliography entity. @author MyEclipse Persistence Tools
 */
public class Bibliography extends AbstractBibliography implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -6827305644108805407L;

	/** default constructor */
	public Bibliography() {
	}

	/** minimal constructor */
	public Bibliography(String bibliographyId) {
		super(bibliographyId);
	}

	/** full constructor */
	public Bibliography(String bibliographyId, AuthorGroup authorGroup, String bibliographyName, String motherLand,
			Date createdTime, Double sortIndex, String description) {
		super(bibliographyId, authorGroup, bibliographyName, motherLand, createdTime, sortIndex, description);
	}

	public Bibliography(String bibliographyId, AuthorGroup authorGroup, String authorGroupId, String bibliographyName,
			String motherLand, Date createdTime, Double sortIndex, String description) {
		super(bibliographyId, authorGroup, authorGroupId, bibliographyName, motherLand, createdTime, sortIndex, description);
		// TODO Auto-generated constructor stub
	}

	public Bibliography(String bibliographyId, String authorGroupId, String bibliographyName, String motherLand,
			Date createdTime, Double sortIndex, String description) {
		super(bibliographyId, authorGroupId, bibliographyName, motherLand, createdTime, sortIndex, description);
		// TODO Auto-generated constructor stub
	}

}
