package com.yunhai.learn.transientcase;

import java.io.Serializable;

public class UserTransientStatic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -783688222045774360L;
	private transient static int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

}
