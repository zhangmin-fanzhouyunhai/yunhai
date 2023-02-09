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
		// 定一个一个map
		Map<String, String> map = new HashMap();

		// 往map中放入一个值 key:/hello value:com.yunhai.demo.HelloMyServlet
		map.put("/hello","com.yunhai.demo.HelloMyServlet" );
		// 通过key 获取value
		String value=map.get("/hello");
		//通过全限定名创建一个实例
		Class clazz=Class.forName(value); 
		HelloMyServlet a=(HelloMyServlet)clazz.newInstance();
		// 调用空参的add方法
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
	
	@Test
	public void f2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, DocumentException {
		//解析xml
		//创建document对象
		org.dom4j.Document doc=new SAXReader().read("F:\\Workspace\\workspace\\Day29\\WebRoot\\xml\\web2.xml");
		//通过xpath解析获取servlet-class和url-pattern的标签
		Element servletClass=(Element) doc.selectSingleNode("//servlet-class");
		Element urlPattern=(Element)doc.selectSingleNode("//url-pattern");
		
		String classText=servletClass.getText();
		String urlText=urlPattern.getText();
		
		// 定一个一个map
		Map<String, String> map = new HashMap(); 
		//将两个值放入到map中
		map.put(urlText,classText);


		// 通过key 获取value
		String value=map.get("/SaveServlet");
		//通过全限定名创建一个实例
		Class clazz=Class.forName(value); 
		HelloMyServlet a=(HelloMyServlet)clazz.newInstance();
		// 调用空参的add方法
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
}
