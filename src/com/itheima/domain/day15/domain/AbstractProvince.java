package com.itheima.domain.day15.domain;

public class AbstractProvince {
	private int provinceID;
	private String name;
	public AbstractProvince() {
		super();
	}
	public AbstractProvince(int provinceID, String name) {
		super();
		this.provinceID = provinceID;
		this.name = name;
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
