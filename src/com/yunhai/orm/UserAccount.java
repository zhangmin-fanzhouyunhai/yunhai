package com.yunhai.orm;

import java.util.Date;

/**
 * UserAccount entity. @author MyEclipse Persistence Tools
 */
public class UserAccount extends AbstractUserAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserAccount() {
	}

	/** minimal constructor */
	public UserAccount(String userAccountId, String accountName, String accountPassword) {
		super(userAccountId, accountName, accountPassword);
	}

	/** full constructor */
	public UserAccount(String userAccountId, String accountName, String accountPassword, String email, String name,
			String sex, Date birthday, String hobby) {
		super(userAccountId, accountName, accountPassword, email, name, sex, birthday, hobby);
	}

}
