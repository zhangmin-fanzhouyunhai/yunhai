package com.yunhai.learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

public class ReflectTest {
	@Test
	public void getConstructors() {
		
		try {
			Class<?> class1=Class.forName("com.yunhai.learn.Person");
			//获取类名
			System.out.println(class1.getName());
			System.out.println("---------------所有公用的构造方法---------------------");
			
			//获取所有的构造方法（包括私有的）
			Constructor<?>[] constructors=class1.getDeclaredConstructors();
			for(Constructor<?> c:constructors) {
				System.out.println(c);
			}
			System.out.println("---------------所有的有参构造（包括私有的）---------------------");
			//获取所有的构造方法（包括私有的）
			Constructor<?> []declaredConstructors=class1.getDeclaredConstructors();
			for(Constructor<?> c:declaredConstructors) {
				System.out.println(c);
			}
			System.out.println("---------------公有的有参构造---------------------");
			//获取公有的有参构造方法
			Constructor<?> declaredCons1=class1.getConstructor(new Class[] {String.class,String.class,Double.class});
			System.out.println(declaredCons1);
			System.out.println("---------------私有的有参构造---------------------");
			//获取私有的有参构造方法
			Constructor<?> declaredCons2=class1.getDeclaredConstructor(new Class[] {String.class,Double.class});
			System.out.println(declaredCons2);
			class1.newInstance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void getFields() {
		try {
			Class<?> class1=Class.forName("com.yunhai.learn.Person");
			System.out.println("----------------------------所有公有字段----------------------------");
			//获取所有公有字段
			Field[] fildFields =class1.getFields();
			for( Field field:fildFields) {
				System.out.println(field);
			}
			System.out.println("----------------------------所有字段(包括私有)----------------------------");
			//获取所有字段(包括私有)
			Class<?> class2=Class.forName("com.yunhai.learn.Person");
			Field[] fields =class2.getDeclaredFields(); 
			System.out.println("fields size="+fields.length); 
			for( Field field2:fields) {
				field2.setAccessible(true);
				System.out.println(field2);
			}
			//获取指定的字段
			Field field=class1.getDeclaredField("username");
			//获取一个公有的无参构造，然后实例化，并给字段赋值
			Object object=class1.getConstructor().newInstance();
			//field.setAccessible(true);
			field.set(object,"孙悟空");
			System.out.println("----------------------------------测试字段设置是否成功---------------------------");
			//测试是否设置成功
			Person person =(Person) object;
			System.out.println(person.getUsername());
			System.out.println("----------------------------------获取私有字段并使用---------------------------");
			Field field2=class1.getDeclaredField("age");
			field2.setAccessible(true);//暴力反射 获取私有字段必须添加此行
			field2.set(object,25.00);
			System.out.println(person.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
