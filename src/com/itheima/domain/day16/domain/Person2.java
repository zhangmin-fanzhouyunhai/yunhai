package com.itheima.domain.day16.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent; 

public class Person2 implements HttpSessionActivationListener{
	private int id ;
	private String name;
	
	public Person2() {
	}
	public Person2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	//�
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Person������~~~~~~");
	}
	@Override
	//�ۻ�
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Person����д����� �ۻ�");
	} 
	
	
}
