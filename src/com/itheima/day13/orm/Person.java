package com.itheima.day13.orm;

public class Person {
	private String userName;
	private String password;
	
	private String sleep(String name) {
		return name+"在睡觉";
	}
	private void sleep() {
		System.out.println("会睡觉");
	}
	public void eat(String name) {
		System.out.println(name+"在吃");
	}
	public void eat() {
		System.out.println("会吃！");
	}

	public Person(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		System.out.println("带参构造器");
	}
	public Person() {
		System.out.println("空参构造器");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
