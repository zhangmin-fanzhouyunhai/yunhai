package com.yunhai.demo;

public class HelloMyServlet {

	public void add() {
		System.out.println("�ղ�add����");
	}
	public void add(int i,int j) {
		System.out.println("������������ ��add����");
		System.out.println("i="+i+"j="+j);
	}
	public int add(int i) {
		return i+10;
	}
}
