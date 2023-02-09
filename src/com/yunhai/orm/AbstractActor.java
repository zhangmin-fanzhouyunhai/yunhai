package com.yunhai.orm;

import java.util.Date;

/**
 * AbstractActor entity provides the base persistence definition of the Actor
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractActor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 903705080493969638L;
	private String actorId;
	private String actorName;
	private String foreignName;
	private String motherLand;
	private Date createdTime;
	private Double sortIndex;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractActor() {
	}

	/** minimal constructor */
	public AbstractActor(String actorId) {
		this.actorId = actorId;
	}

	/** full constructor */
	public AbstractActor(String actorId, String actorName, String foreignName, String motherLand, Date createdTime,
			Double sortIndex, String description) {
		this.actorId = actorId;
		this.actorName = actorName;
		this.foreignName = foreignName;
		this.motherLand = motherLand;
		this.createdTime = createdTime;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	// Property accessors

	public String getActorId() {
		return this.actorId;
	}

	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return this.actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
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