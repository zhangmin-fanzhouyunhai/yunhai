package com.yunhai.orm;

import java.util.Date;

public class User {
	// 以后使用包装类，默认值是null
	private Long tUserId;
	private String userId;
	private String userName;
	private Date userBirthday;
	private String userPhone;
	private String userMobile;
	private String userInfo;

	//在JavaBean中添加属性
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public User(Long tUserId, String userId, String userName, Date userBirthday, 
			String userPhone, String userMobile,
			String userInfo) {
		super();
		this.tUserId = tUserId;
		this.userId = userId;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userPhone = userPhone;
		this.userMobile = userMobile;
		this.userInfo = userInfo;
	}

	public User(String userId, String userName, Date userBirthday, 
			String userPhone, String userMobile,
			String userInfo) {
		super(); 
		this.userId = userId;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userPhone = userPhone;
		this.userMobile = userMobile;
		this.userInfo = userInfo;
	}
	public User() {
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Long gettUserId() {
		return tUserId;
	}

	public void settUserId(Long tUserId) {
		this.tUserId = tUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

}
