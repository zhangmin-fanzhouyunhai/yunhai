package com.itheima.user.orm;

import java.util.Date;

/**
 * YunhaiUser entity. @author MyEclipse Persistence Tools
 */
public class YunhaiUser extends AbstractYunhaiUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public YunhaiUser() {
	}

	/** minimal constructor */
	public YunhaiUser(String yunhaiUserId) {
		super(yunhaiUserId);
	}

	/** full constructor */
	public YunhaiUser(String yunhaiUserId, String userName, String password, String email, String name, String sex,
			Date birthday, String hobby) {
		super(yunhaiUserId, userName, password, email, name, sex, birthday, hobby);
	}

}
