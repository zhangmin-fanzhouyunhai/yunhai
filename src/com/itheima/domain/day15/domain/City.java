package com.itheima.domain.day15.domain;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
public class City extends AbstractCity implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Integer cityId) {
		super(cityId);
	}

	/** full constructor */
	public City(Integer cityId, Integer provinceId, String name) {
		super(cityId, provinceId, name);
	}

}
