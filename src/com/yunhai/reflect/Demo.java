package com.yunhai.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.yunhai.demo.HelloMyServlet;


public class Demo {
	@Test
	public void f1() {
		//调用helloMyServlet中的方法
		HelloMyServlet a =new HelloMyServlet();
		a.add();
		a.add(1);
		a.add(1,7);
		
		
	}
	

	@Test
	public void f2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz=Class.forName("com.yunhai.demo.HelloMyServlet");
		//通过字节码对象创建一个实例对象（相当于调用空参的构造器）
		//可以通过检测查询到的内容，进行实例的动态创建。
		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		a.add();
		a.add(1);
		a.add(1,7); 
	}
	
	@Test
	//调用空参的Add方法
	public void f3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz=Class.forName("com.yunhai.demo.HelloMyServlet");
		//通过字节码对象创建一个实例对象（相当于调用空参的构造器）
		//可以通过检测查询到的内容，进行实例的动态创建。

		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		
		//获取一个方法
		Method method=clazz.getMethod("add");
		
		//让方法对象执行，obj调用 这个方法的实例， 相关于a(a.add()),args是该方法执行时所需要的参数。
		method.invoke(a);//相当于a.add()方法
	}
	
	@Test
	//调用有两个参的Add方法
	public void f4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//获取class对象
		Class clazz=HelloMyServlet.class;
		//通过字节码对象创建一个实例对象（相当于调用空参的构造器）
		//可以通过检测查询到的内容，进行实例的动态创建。
		//通过clazz对象创建一个实例
		HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
		
		//获取有两个参数的add方法
		Method method=clazz.getMethod("add",int.class,int.class);
		
		//让方法对象执行，obj调用 这个方法的实例， 相关于a(a.add()),args是该方法执行时所需要的参数。
		method.invoke(a,8,7);//相当于a.add(8,7)方法
	}
	
	
	
	
	
	
	
	
}
