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

	// 序列化
	private static void SerializeUser() throws FileNotFoundException, IOException {
		UserExternalizable user = new UserExternalizable();
		user.setName("Java的架构师技术 线"); 
		String savePath = "D:/学习/file/template2.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		System.out.println("使用Externalize接口，添加了transient关键字序列化之前：" + user.toString());
	}

	// 反序列化
	private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		String savePath = "D:/学习/file/template2.txt";
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		UserExternalizable newUser = (UserExternalizable) ois.readObject();
		ois.close();
		System.out.println("使用Externalize接口，添加了transient关键字反序列化之后" + newUser.toString());
	}

}
