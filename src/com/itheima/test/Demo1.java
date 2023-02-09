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
	 * ���Ա���ͻ�
	 */
	@Test
	public void testSave() {
		/**
		 * 1.�ȼ��d�����ļ� 2.����SessionFaction��������Session���� 3.����session���� 4.�_���� 5.��������Ĵ��a
		 * 6.�ύ�� 7.ጷ��YԴ
		 */
		// 1.�ȼ��d�����ļ�
		Configuration config = new Configuration();
		// Ĭ�J���dsrcĿ���hibernate.cfg.xml�������ļ�
		config.configure();
		// �ֶ�����xml�ļ���
		// config.addResource("com/itheima/domain/Customer.hbm.xml");
		// ��д�ķ���,��ʽ����
		// Configuration config=new Configuration().configure();
		// 2. ����sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 3.����session����
		Session session = factory.openSession();
		// 4.��������
		Transaction tr = session.beginTransaction();
		// 5.��д����Ĵ���
		Customer cus = new Customer();
		// cus.setCust_id(cust_id);���I���Ԅ��f����
		cus.setCustName("202002222018");
		cus.setCustLevel("20200222");
		cus.setCustPhone("1101");

		cus.setCustInfo("1101");
		// �������ݣ�����������൱�ڲ������ݿ�ı�ṹ
		session.save(cus);

		// 6.�ύ����
		tr.commit();
		// 7.�ͷ���Դ
		session.close();
		factory.close();

	}

	/**
	 * ���Ա���
	 */
	@Test
	public void testSave3() {
		Session session=null;
		Transaction tr=null;
		try {
			//��ȡsession
			session=HibernateUtils.getSession();
			//��������
			tr=session.beginTransaction();
			//ִ�д���
			Customer c=new Customer();
			c.setCustName("����2");
			//����
			session.save(c);
			//�ύ����
			tr.commit();
		}catch (Exception e) {
			// TODO: handle exception
			//�ع�����
			tr.rollback();
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			session.close();
		}
	}
	
	
	/**
	 * ���Թ�����
	 */
	@Test
	public void test2() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer c = new Customer();
		c.setCustName("С��");
		session.save(c);
		// �ύ����
		tr.commit();
		// ������Դ
		session.close();

	}

	/**
	 * ���Բ�ѯ�ķ���
	 */
	@Test
	public void testSel() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// ������ѯ�Ľӿ�
		Query query = session.createQuery("from Customer");// HQL

		// ��ѯ���е�����select * from ��
		List<Customer> list = query.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}

		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
	}

	/**
	 * ������ӻ����޸�
	 */
	@Test
	public void testSaveOrUpdate() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		/*
		 * //��ʾ���� Customer c=new Customer(); //c.setCustId(10L); ǧ�����Լ�����
		 * c.setCustName("����202002222102");
		 * 
		 * //��������޸� session.saveOrUpdate(c);
		 */
		// �Ȳ�ѯ�ٸ�
		Customer c = session.get(Customer.class, 6L);
		c.setCustName("���");

		session.saveOrUpdate(c);

		System.out.println(c);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
	}

	/**
	 * �����޸�
	 */
	@Test
	public void testUpdate() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// ���Բ�ѯ�ķ���2��������arg0��ѯJavaBean��class����arg1������ֵ
		Customer c = session.get(Customer.class, 6L);

		// ���ÿͻ�����Ϣ
		c.setCustName("��ɽ");
		c.setCustLevel("5");

		// �޸Ŀͻ�
		session.update(c);
		System.out.println(c);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
	}

	/**
	 * ����ɾ���ķ��� ע�⣺ɾ�������޸ģ��Ȳ�ѯ��ɾ�������޸ģ�Ϊ��׼����
	 */

	@Test
	public void testDel() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// ���Բ�ѯ�ķ���2��������arg0��ѯJavaBean��class����arg1������ֵ
		Customer c = session.get(Customer.class, 7L);

		// ɾ���ͻ�
		session.delete(c);
		System.out.println(c);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
	}

	/**
	 * ����get()��������ȡ��ѯ��ͨ����������ѯһ����¼
	 */
	@Test
	public void testGet() {
		// ԭ�������������ļ�����ȡFactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// ���Բ�ѯ�ķ���2��������arg0��ѯJavaBean��class����arg1������ֵ
		Customer c = session.get(Customer.class, 7L);
		System.out.println(c);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
	}

	@Test
	public void run3() {
		// ��ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// �����û�
		// �־�Person�Ķ���
		// ˲ʱ̫��û��OID��ֵ��û�б�session������ʱperson������˲ʱ̫����
		Person person = new Person();
		// person.settPersonId("12513564");
		person.setPersonName("202002221��");
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
		// ʹ��session�����û����Ѿ�������IDֵ�ˣ�ʹ�������ݿ���Զ����ɵ�ID
		// person�������Ѿ�����id��ֵ��Ĭ�ϵ�����£���person����Ҳ���浽session�Ļ�����
		Serializable id = session.save(person);
		System.out.println("������ֵ��" + id);
		// person�ǳ־�̬����

		tr.commit();
		// session���٣�����û����
		session.close();
		// ��ӡ
		// person�������idֵ��session�����ˣ����治���ڣ�session����person���󣿲�����
		// person���й�̬�Ķ���
		System.out.println(person.gettPersonId());
		System.out.println(person.getPersonName());
	}

	/**
	 * ����uuid���������ɲ���
	 */
	@Test
	public void run2() {
		// ��ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// �����û�
		Person person = new Person();
		person.settPersonId("12513564");
		person.setPersonName("12343С��");
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
		// ��ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// �����û�
		User user = new User();
		user.setUserName("12343С��");
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
