package com.itheima.domain.day16.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{
	private int id ;
	private String name;
	
	
	
	public Person() {
	}
	public Person(int id, String name) {
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
	//绑定到了session中
	public void valueBound(HttpSessionBindingEvent arg0) { 
		System.out.println("person对象绑定到了session中");
	}
	@Override
	//从session中移除
	public void valueUnbound(HttpSessionBindingEvent arg0) { 
		System.out.println("person对象从session中移除了~~~~");
		
	}
	
	
}
