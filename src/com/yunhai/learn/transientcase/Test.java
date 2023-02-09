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
	
	//序列化
	private static void ServializeUer() throws FileNotFoundException, IOException, ClassNotFoundException {
		UserTransientStatic user=new UserTransientStatic();
		user.setName("Java的架构师技术栈");
		//序列化之前静态变量age年龄是24.
		user.setAge(24);
		String savePath = "D:/学习/file/template4.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		//再读取，通过modifyUser.getAge()打印新的值
		System.out.println("static.transient关键字修饰age之前："+user.getAge());
		//现在把年龄改成18
		user.setAge(18);
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		UserTransientStatic newUser = (UserTransientStatic) ois.readObject();
		ois.close();
		//再读取，通过newUser.getAge()打印新的值
		System.out.println("改变age之后："+newUser.getAge());
	}

	// 序列化
	private static void SerializeUser() throws FileNotFoundException, IOException {
		User user = new User();
		user.setName("Java的架构师技术 线");
		user.setAge(42);
		String savePath = "D:/学习/file/template.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(user);
		oos.close();
		System.out.println("添加了transient关键字序列化：age= " + user.getAge());
		/*
		 * 下面部分，UserNoSerialize类创建的对象userNoSerialize，
		 * 没有引用Serializable。故无法使用ObjectOutputStream将
		 * 对象写入到本地文件中 
		 */
		/*
		savePath = "D:/学习/file/template1.txt";
		oos = new ObjectOutputStream(new FileOutputStream(savePath));
		oos.writeObject(userNoSerialize);
		oos.close();
		System.out.println("未添加transient关键字序列化：age= " + userNoSerialize.getAge());
		*/
	}

	// 反序列化
	private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		String savePath = "D:/学习/file/template.txt";
		File file = new File(savePath);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		User newUser = (User) ois.readObject();
		ois.close();
		System.out.println("添加了transient关键字反序列化：age= " + newUser.getAge());
		/*
		 * 下面部分，UserNoSerialize类创建的对象userNoSerialize，
		 * 没有引用Serializable。故无法使用ObjectOutputStream将
		 * 对象写入到本地文件中 
		 */
		/*
		savePath = "D:/学习/file/template1.txt";
		file = new File(savePath);
		ois = new ObjectInputStream(new FileInputStream(file));
		UserNoSerialize userNoSerialize = (UserNoSerialize) ois.readObject();
		System.out.println("未添加transient关键字反序列化：age= " + userNoSerialize.getAge());
		
		 */
	}

}
