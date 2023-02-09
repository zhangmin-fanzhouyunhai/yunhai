package com.itheima.test;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.user.orm.Person;
import com.yunhai.orm.User;
import com.yunhai.util.HibernateUtils;

public class Demo1 {
	/**
	 * 测试保存客户
	 */
	@Test
	public void testSave() {
		/**
		 * 1.先加載配置文件 2.創建SessionFaction對象，生成Session對象 3.創建session對象 4.開啟事務 5.編寫保存的代碼
		 * 6.提交事務 7.釋放資源
		 */
		// 1.先加載配置文件
		Configuration config = new Configuration();
		// 默認加載src目錄下hibernate.cfg.xml的配置文件
		config.configure();
		// 手动加载xml文件。
		// config.addResource("com/itheima/domain/Customer.hbm.xml");
		// 简写的方法,链式加载
		// Configuration config=new Configuration().configure();
		// 2. 創建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 3.創建session對象
		Session session = factory.openSession();
		// 4.开启事务
		Transaction tr = session.beginTransaction();
		// 5.编写保存的代码
		Customer cus = new Customer();
		// cus.setCust_id(cust_id);主鍵是自動遞增了
		cus.setCustName("202002222018");
		cus.setCustLevel("20200222");
		cus.setCustPhone("1101");

		cus.setCustInfo("1101");
		// 保存数据，操作对象就相当于操作数据库的表结构
		session.save(cus);

		// 6.提交事务
		tr.commit();
		// 7.释放资源
		session.close();
		factory.close();

	}

	/**
	 * 测试保存
	 */
	@Test
	public void testSave3() {
		Session session=null;
		Transaction tr=null;
		try {
			//获取session
			session=HibernateUtils.getSession();
			//开启事务
			tr=session.beginTransaction();
			//执行代码
			Customer c=new Customer();
			c.setCustName("星云2");
			//保存
			session.save(c);
			//提交事务
			tr.commit();
		}catch (Exception e) {
			// TODO: handle exception
			//回滚事务
			tr.rollback();
			e.printStackTrace();
		}finally {
			//释放资源
			session.close();
		}
	}
	
	
	/**
	 * 测试工具类
	 */
	@Test
	public void test2() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer c = new Customer();
		c.setCustName("小凤");
		session.save(c);
		// 提交事务
		tr.commit();
		// 翻译资源
		session.close();

	}

	/**
	 * 测试查询的方法
	 */
	@Test
	public void testSel() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// 创建查询的接口
		Query query = session.createQuery("from Customer");// HQL

		// 查询所有的数据select * from 表
		List<Customer> list = query.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}

		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
	}

	/**
	 * 测试添加或者修改
	 */
	@Test
	public void testSaveOrUpdate() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		/*
		 * //演示错误 Customer c=new Customer(); //c.setCustId(10L); 千万不能自己设置
		 * c.setCustName("测试202002222102");
		 * 
		 * //保存或者修改 session.saveOrUpdate(c);
		 */
		// 先查询再改
		Customer c = session.get(Customer.class, 6L);
		c.setCustName("天际");

		session.saveOrUpdate(c);

		System.out.println(c);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
	}

	/**
	 * 测试修改
	 */
	@Test
	public void testUpdate() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// 测试查询的方法2个参数：arg0查询JavaBean的class对象arg1主键的值
		Customer c = session.get(Customer.class, 6L);

		// 设置客户的信息
		c.setCustName("苍山");
		c.setCustLevel("5");

		// 修改客户
		session.update(c);
		System.out.println(c);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
	}

	/**
	 * 测试删除的方法 注意：删除或者修改，先查询再删除或者修改，为标准方法
	 */

	@Test
	public void testDel() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// 测试查询的方法2个参数：arg0查询JavaBean的class对象arg1主键的值
		Customer c = session.get(Customer.class, 7L);

		// 删除客户
		session.delete(c);
		System.out.println(c);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
	}

	/**
	 * 测试get()方法，获取查询，通过主键来查询一条记录
	 */
	@Test
	public void testGet() {
		// 原来：加载配置文件，获取Factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// 测试查询的方法2个参数：arg0查询JavaBean的class对象arg1主键的值
		Customer c = session.get(Customer.class, 7L);
		System.out.println(c);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
	}

	@Test
	public void run3() {
		// 获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 保存用户
		// 持久Person的对象
		// 瞬时太：没有OID的值，没有被session管理，此时person对象是瞬时太对象
		Person person = new Person();
		// person.settPersonId("12513564");
		person.setPersonName("202002221杨");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			person.setPersonBirthday(sdf.parse("2006-03-11 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		person.setPersonId("8130800820060311");
		person.setPersonPhone("8832648");
		person.setPersonMobile("1331653856");
		// 使用session保存用户，已经生成了ID值了，使用了数据库的自动生成的ID
		// person对象中已经存在id的值，默认的情况下，把person对象也保存到session的缓存中
		Serializable id = session.save(person);
		System.out.println("主键的值：" + id);
		// person是持久态对象

		tr.commit();
		// session销毁，缓存没有了
		session.close();
		// 打印
		// person对象存在id值，session销毁了，缓存不存在，session管理person对象？不管理
		// person是托管态的对象
		System.out.println(person.gettPersonId());
		System.out.println(person.getPersonName());
	}

	/**
	 * 测试uuid主键的生成策略
	 */
	@Test
	public void run2() {
		// 获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 保存用户
		Person person = new Person();
		person.settPersonId("12513564");
		person.setPersonName("12343小杨");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			person.setPersonBirthday(sdf.parse("2006-03-11 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		person.setPersonId("8130800820060311");
		person.setPersonPhone("8832648");
		person.setPersonMobile("1331653856");
		session.save(person);

		tr.commit();
		session.close();
	}

	@Test
	public void run1() {
		// 获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 保存用户
		User user = new User();
		user.setUserName("12343小杨");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			user.setUserBirthday(sdf.parse("2006-03-11 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setUserId("1328130800820060311");
		user.setUserPhone("8832648");
		user.setUserMobile("1331653856");
		session.save(user);

		tr.commit();
		session.close();
	}
}
