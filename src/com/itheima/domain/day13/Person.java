package com.itheima.domain.day13;

public class Person {
	private String username;
	private String password;

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

	public Person() {
		System.out.println("�ղι�������");

	}

	public Person(String username, String password) {
		this.username = username;
		this.password = password;
		System.out.println("���ι�������");
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
