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
		System.out.println("�ղι�������");

	}

	public AbstractPerson(String username, String password) {
		this.username = username;
		this.password = password;
		System.out.println("���ι�������");
	}

	public AbstractPerson(String username, String password,Double age) {
		this.username = username;
		this.password = password;
		this.age = age;
		System.out.println("�����Ĵ��ι�������");
	}
	private AbstractPerson(String username, Double age) {
		this.username = username;
		this.age = age;
		System.out.println("˽�еĴ��ι�������");
	}
	public void eat() {
		System.out.println("��ʳ��");
	}

	public void eat(String name) {
		System.out.println(name + "��ʳ��");
	}

	private void sleep() {
		System.out.println("˯����");
	}

	private String sleep(String name) {
		return name + "��˯����";
	}
}
