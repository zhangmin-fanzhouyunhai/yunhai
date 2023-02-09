package com.yunhai.learn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

public class ReflectTest {
	@Test
	public void getConstructors() {
		
		try {
			Class<?> class1=Class.forName("com.yunhai.learn.Person");
			//��ȡ����
			System.out.println(class1.getName());
			System.out.println("---------------���й��õĹ��췽��---------------------");
			
			//��ȡ���еĹ��췽��������˽�еģ�
			Constructor<?>[] constructors=class1.getDeclaredConstructors();
			for(Constructor<?> c:constructors) {
				System.out.println(c);
			}
			System.out.println("---------------���е��вι��죨����˽�еģ�---------------------");
			//��ȡ���еĹ��췽��������˽�еģ�
			Constructor<?> []declaredConstructors=class1.getDeclaredConstructors();
			for(Constructor<?> c:declaredConstructors) {
				System.out.println(c);
			}
			System.out.println("---------------���е��вι���---------------------");
			//��ȡ���е��вι��췽��
			Constructor<?> declaredCons1=class1.getConstructor(new Class[] {String.class,String.class,Double.class});
			System.out.println(declaredCons1);
			System.out.println("---------------˽�е��вι���---------------------");
			//��ȡ˽�е��вι��췽��
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
			System.out.println("----------------------------���й����ֶ�----------------------------");
			//��ȡ���й����ֶ�
			Field[] fildFields =class1.getFields();
			for( Field field:fildFields) {
				System.out.println(field);
			}
			System.out.println("----------------------------�����ֶ�(����˽��)----------------------------");
			//��ȡ�����ֶ�(����˽��)
			Class<?> class2=Class.forName("com.yunhai.learn.Person");
			Field[] fields =class2.getDeclaredFields(); 
			System.out.println("fields size="+fields.length); 
			for( Field field2:fields) {
				field2.setAccessible(true);
				System.out.println(field2);
			}
			//��ȡָ�����ֶ�
			Field field=class1.getDeclaredField("username");
			//��ȡһ�����е��޲ι��죬Ȼ��ʵ�����������ֶθ�ֵ
			Object object=class1.getConstructor().newInstance();
			//field.setAccessible(true);
			field.set(object,"�����");
			System.out.println("----------------------------------�����ֶ������Ƿ�ɹ�---------------------------");
			//�����Ƿ����óɹ�
			Person person =(Person) object;
			System.out.println(person.getUsername());
			System.out.println("----------------------------------��ȡ˽���ֶβ�ʹ��---------------------------");
			Field field2=class1.getDeclaredField("age");
			field2.setAccessible(true);//�������� ��ȡ˽���ֶα�����Ӵ���
			field2.set(object,25.00);
			System.out.println(person.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
