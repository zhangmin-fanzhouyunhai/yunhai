package com.yunhai.learn;

import java.util.Date;
 

public class Person implements java.io.Serializable {

	private static final long serialVersionUID = 6368373322525620237L;
	private String persionID;
	private String dataVersion;
	public String username;
	private String password;
	private Date birthday;
	private Double age;
	private Double height;
	private Double weight;
	public String getPersionID() {
		return persionID;
	}
	public void setPersionID(String persionID) {
		this.persionID = persionID;
	}
	public String getDataVersion() {
		return dataVersion;
	}
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Person() { 
	}
	public Person(String username, String password, Double age) {

		this.username = username;
		this.password = password; 
		this.age = age;
	}
	public Person(String username,  Double age) {
		this.username = username; 
		this.age = age;
	}
	public Person(String persionID, String dataVersion, String username, String password, Date birthday, Double age,
			Double height, Double weight) {
	 
		this.persionID = persionID;
		this.dataVersion = dataVersion;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
}
