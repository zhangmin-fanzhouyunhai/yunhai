package com.itheima.user.orm;

import java.util.Date;

/**
 * AbstractYunhaiUser entity provides the base persistence definition of the
 * YunhaiUser entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYunhaiUser implements java.io.Serializable {

	// Fields

	private String yunhaiUserId;
	private String userName;
	private String password;
	private String email;
	private String name;
	private String sex;
	private Date birthday;
	private String hobby;

	// Constructors

	/** default constructor */
	public AbstractYunhaiUser() {
	}

	/** minimal constructor */
	public AbstractYunhaiUser(String yunhaiUserId) {
		this.yunhaiUserId = yunhaiUserId;
	}

	/** full constructor */
	public AbstractYunhaiUser(String yunhaiUserId, String userName, String password, String email, String name,
			String sex, Date birthday, String hobby) {
		this.yunhaiUserId = yunhaiUserId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.hobby = hobby;
	}

	// Property accessors

	public String getYunhaiUserId() {
		return this.yunhaiUserId;
	}

	public void setYunhaiUserId(String yunhaiUserId) {
		this.yunhaiUserId = yunhaiUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}