package com.yunhai.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yunhai.demo.HelloMyServlet;


public class Demo {
	@Test
	public void f1() {
		//����helloMyServlet�еķ���
		HelloMyServlet a =new HelloMyServlet();
		a.add();
		a.add(1);
		a.add(1,7);
		
		
	}
	

	@Test
	public void f2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz=Class.forName("com.yunhai.demo.HelloMyServlet");
		//ͨ���ֽ�����󴴽�һ��ʵ�������൱�ڵ��ÿղεĹ�������
		//����ͨ������ѯ�������ݣ�����ʵ���Ķ�̬������
		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		a.add();
		a.add(1);
		a.add(1,7); 
	}
	
	@Test
	//���ÿղε�Add����
	public void f3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz=Class.forName("com.yunhai.demo.HelloMyServlet");
		//ͨ���ֽ�����󴴽�һ��ʵ�������൱�ڵ��ÿղεĹ�������
		//����ͨ������ѯ�������ݣ�����ʵ���Ķ�̬������

		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		
		//��ȡһ������
		Method method=clazz.getMethod("add");
		
		//�÷�������ִ�У�obj���� ���������ʵ���� �����a(a.add()),args�Ǹ÷���ִ��ʱ����Ҫ�Ĳ�����
		method.invoke(a);//�൱��a.add()����
	}
	
	@Test
	//�����������ε�Add����
	public void f4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//��ȡclass����
		Class clazz=HelloMyServlet.class;
		//ͨ���ֽ�����󴴽�һ��ʵ�������൱�ڵ��ÿղεĹ�������
		//����ͨ������ѯ�������ݣ�����ʵ���Ķ�̬������
		//ͨ��clazz���󴴽�һ��ʵ��
		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		
		//��ȡ������������add����
		Method method=clazz.getMethod("add",int.class,int.class);
		
		//�÷�������ִ�У�obj���� ���������ʵ���� �����a(a.add()),args�Ǹ÷���ִ��ʱ����Ҫ�Ĳ�����
		method.invoke(a,8,7);//�൱��a.add(8,7)����
	}
	
	
	
	
	
	
	
	
}
