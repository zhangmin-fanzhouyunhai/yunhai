package com.itheima.domain.day15.domain;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String email, String name, String sex, Date birthday, String hobby) {
		super(username, password, email, name, sex, birthday, hobby);
	}

}
