package com.itheima.day13.orm;

public class Person {
	private String userName;
	private String password;
	
	private String sleep(String name) {
		return name+"��˯��";
	}
	private void sleep() {
		System.out.println("��˯��");
	}
	public void eat(String name) {
		System.out.println(name+"�ڳ�");
	}
	public void eat() {
		System.out.println("��ԣ�");
	}

	public Person(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		System.out.println("���ι�����");
	}
	public Person() {
		System.out.println("�ղι�����");
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
