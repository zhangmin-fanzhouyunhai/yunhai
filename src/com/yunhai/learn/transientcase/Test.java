package com.yunhai.learn.transientcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		SerializeUser();
		DeSerializeUser();
		ServializeUer();
	
	}
	
	//���л�
	private static void ServializeUer() throws FileNotFoundException, IOException, ClassNotFoundException {
		UserTransientStatic user=new UserTransientStatic();
		user.setName("Java�ļܹ�ʦ����ջ");
		//���л�֮ǰ��̬����age������24.
		user.setAge(24);
		String savePath = "D:/ѧϰ/file/template4.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		//�ٶ�ȡ��ͨ��modifyUser.getAge()��ӡ�µ�ֵ
		System.out.println("static.transient�ؼ�������age֮ǰ��"+user.getAge());
		//���ڰ�����ĳ�18
		user.setAge(18);
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		UserTransientStatic newUser = (UserTransientStatic) ois.readObject();
		ois.close();
		//�ٶ�ȡ��ͨ��newUser.getAge()��ӡ�µ�ֵ
		System.out.println("�ı�age֮��"+newUser.getAge());
	}

	// ���л�
	private static void SerializeUser() throws FileNotFoundException, IOException {
		User user = new User();
		user.setName("Java�ļܹ�ʦ���� ��");
		user.setAge(42);
		String savePath = "D:/ѧϰ/file/template.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		System.out.println("�����transient�ؼ������л���age= " + user.getAge());
		/*
		 * ���沿�֣�UserNoSerialize�ഴ���Ķ���userNoSerialize��
		 * û������Serializable�����޷�ʹ��ObjectOutputStream��
		 * ����д�뵽�����ļ��� 
		 */
		/*
		savePath = "D:/ѧϰ/file/template1.txt";
		oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(userNoSerialize);
		oos.close();
		System.out.println("δ���transient�ؼ������л���age= " + userNoSerialize.getAge());
		*/
	}

	// �����л�
	private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		String savePath = "D:/ѧϰ/file/template.txt";
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		User newUser = (User) ois.readObject();
		ois.close();
		System.out.println("�����transient�ؼ��ַ����л���age= " + newUser.getAge());
		/*
		 * ���沿�֣�UserNoSerialize�ഴ���Ķ���userNoSerialize��
		 * û������Serializable�����޷�ʹ��ObjectOutputStream��
		 * ����д�뵽�����ļ��� 
		 */
		/*
		savePath = "D:/ѧϰ/file/template1.txt";
		file = new File(savePath);
		ois = new ObjectInputStream(new FileInputStream(file));
		UserNoSerialize userNoSerialize = (UserNoSerialize) ois.readObject();
		System.out.println("δ���transient�ؼ��ַ����л���age= " + userNoSerialize.getAge());
		
		 */
	}

}
