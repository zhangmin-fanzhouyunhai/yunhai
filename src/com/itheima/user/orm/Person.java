package com.itheima.user.orm;

import java.util.Date;

public class Person {

	private String tPersonId;
	private String personId;
	private String personName;
	private Date personBirthday;
	private String personPhone;
	private String personMobile;
	private String personInfo;

	public Person() {
	}

	public Person(String tPersonId, String personId, String personName, Date personBirthday, String personPhone,
			String personMobile, String personInfo) {
		super();
		this.tPersonId = tPersonId;
		this.personId = personId;
		this.personName = personName;
		this.personBirthday = personBirthday;
		this.personPhone = personPhone;
		this.personMobile = personMobile;
		this.personInfo = personInfo;
	}

	public String gettPersonId() {
		return tPersonId;
	}

	public void settPersonId(String tPersonId) {
		this.tPersonId = tPersonId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getPersonBirthday() {
		return personBirthday;
	}

	public void setPersonBirthday(Date personBirthday) {
		this.personBirthday = personBirthday;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public String getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(String personInfo) {
		this.personInfo = personInfo;
	}

}
