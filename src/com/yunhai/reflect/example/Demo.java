package com.yunhai.reflect.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.yunhai.demo.HelloMyServlet;

public class Demo {
	@Test
	public void f1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// ��һ��һ��map
		Map<String, String> map = new HashMap();

		// ��map�з���һ��ֵ key:/hello value:com.yunhai.demo.HelloMyServlet
		map.put("/hello","com.yunhai.demo.HelloMyServlet" );
		// ͨ��key ��ȡvalue
		String value=map.get("/hello");
		//ͨ��ȫ�޶�������һ��ʵ��
		Class clazz=Class.forName(value); 
		HelloMyServlet a=(HelloMyServlet)clazz.newInstance();
		// ���ÿղε�add����
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
	
	@Test
	public void f2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, DocumentException {
		//����xml
		//����document����
		org.dom4j.Document doc=new SAXReader().read("F:\\Workspace\\workspace\\Day29\\WebRoot\\xml\\web2.xml");
		//ͨ��xpath������ȡservlet-class��url-pattern�ı�ǩ
		Element servletClass=(Element) doc.selectSingleNode("//servlet-class");
		Element urlPattern=(Element)doc.selectSingleNode("//url-pattern");
		
		String classText=servletClass.getText();
		String urlText=urlPattern.getText();
		
		// ��һ��һ��map
		Map<String, String> map = new HashMap(); 
		//������ֵ���뵽map��
		map.put(urlText,classText);


		// ͨ��key ��ȡvalue
		String value=map.get("/SaveServlet");
		//ͨ��ȫ�޶�������һ��ʵ��
		Class clazz=Class.forName(value); 
		HelloMyServlet a=(HelloMyServlet)clazz.newInstance();
		// ���ÿղε�add����
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
}
