package com.yunhai.orm;

import java.util.Date;

/**
 * AbstractUserAccount entity provides the base persistence definition of the
 * UserAccount entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserAccount implements java.io.Serializable {

	// Fields

	private String userAccountId;
	private String accountName;
	private String accountPassword;
	private String email;
	private String name;
	private String sex;
	private Date birthday;
	private String hobby;

	// Constructors

	/** default constructor */
	public AbstractUserAccount() {
	}

	/** minimal constructor */
	public AbstractUserAccount(String userAccountId, String accountName, String accountPassword) {
		this.userAccountId = userAccountId;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
	}

	/** full constructor */
	public AbstractUserAccount(String userAccountId, String accountName, String accountPassword, String email,
			String name, String sex, Date birthday, String hobby) {
		this.userAccountId = userAccountId;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.hobby = hobby;
	}

	// Property accessors

	public String getUserAccountId() {
		return this.userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return this.accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
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