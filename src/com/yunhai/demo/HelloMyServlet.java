package com.yunhai.demo;

public class HelloMyServlet {

	public void add() {
		System.out.println("空参add方法");
	}
	public void add(int i,int j) {
		System.out.println("带有两个参数 的add方法");
		System.out.println("i="+i+"j="+j);
	}
	public int add(int i) {
		return i+10;
	}
}
