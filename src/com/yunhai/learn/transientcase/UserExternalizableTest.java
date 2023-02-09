package com.yunhai.learn.transientcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserExternalizableTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		SerializeUser();
		DeSerializeUser();
	}

	// ���л�
	private static void SerializeUser() throws FileNotFoundException, IOException {
		UserExternalizable user = new UserExternalizable();
		user.setName("Java�ļܹ�ʦ���� ��"); 
		String savePath = "D:/ѧϰ/file/template2.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		System.out.println("ʹ��Externalize�ӿڣ������transient�ؼ������л�֮ǰ��" + user.toString());
	}

	// �����л�
	private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		String savePath = "D:/ѧϰ/file/template2.txt";
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		UserExternalizable newUser = (UserExternalizable) ois.readObject();
		ois.close();
		System.out.println("ʹ��Externalize�ӿڣ������transient�ؼ��ַ����л�֮��" + newUser.toString());
	}

}
