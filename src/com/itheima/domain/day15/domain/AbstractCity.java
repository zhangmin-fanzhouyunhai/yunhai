package com.itheima.domain.day15.domain;

/**
 * AbstractCity entity provides the base persistence definition of the City
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private Integer provinceId;
	private String name;

	// Constructors

	/** default constructor */
	public AbstractCity() {
	}

	/** minimal constructor */
	public AbstractCity(Integer cityId) {
		this.cityId = cityId;
	}

	/** full constructor */
	public AbstractCity(Integer cityId, Integer provinceId, String name) {
		this.cityId = cityId;
		this.provinceId = provinceId;
		this.name = name;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}