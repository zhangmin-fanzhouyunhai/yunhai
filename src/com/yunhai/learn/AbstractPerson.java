package com.yunhai.learn;

import java.util.Date;

public class AbstractPerson  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6368373322525620237L;
	private String persionID;
	private String dataVersion;
	public String username;
	private String password;
	private Date birthday;
	private Double age;
	private Double height;
	private Double weight;


	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPersionID() {
		return persionID;
	}

	public void setPersionID(String persionID) {
		persionID = persionID;
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

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
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

	public AbstractPerson() {
		System.out.println("空参构建器！");

	}

	public AbstractPerson(String username, String password) {
		this.username = username;
		this.password = password;
		System.out.println("带参构建器！");
	}

	public AbstractPerson(String username, String password,Double age) {
		this.username = username;
		this.password = password;
		this.age = age;
		System.out.println("公共的带参构建器！");
	}
	private AbstractPerson(String username, Double age) {
		this.username = username;
		this.age = age;
		System.out.println("私有的带参构建器！");
	}
	public void eat() {
		System.out.println("饮食！");
	}

	public void eat(String name) {
		System.out.println(name + "饮食！");
	}

	private void sleep() {
		System.out.println("睡觉！");
	}

	private String sleep(String name) {
		return name + "在睡觉！";
	}
}
