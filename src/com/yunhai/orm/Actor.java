package com.yunhai.orm;

import java.util.Date;

/**
 * Actor entity. @author MyEclipse Persistence Tools
 */
public class Actor extends AbstractActor implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 3656786466119869223L;

	/** default constructor */
	public Actor() {
	}

	/** minimal constructor */
	public Actor(String actorId) {
		super(actorId);
	}

	/** full constructor */
	public Actor(String actorId, String actorName, String foreignName, String motherLand, Date createdTime,
			Double sortIndex, String description) {
		super(actorId, actorName, foreignName, motherLand, createdTime, sortIndex, description);
	}

}
