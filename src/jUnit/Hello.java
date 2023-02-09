package jUnit;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.day13.orm.Person;
import com.mysql.jdbc.Driver;
import com.yunhai.util.DbUtil;
import com.yunhai.util.DbUtil2;

public class Hello {
	@Test
	public void f1() {
		System.out.println("hello!");
	}
	@Test
	public void f112() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 1.��ȡclass����
		Class clazz = Class.forName("com.itheima.day13.orm.Person");
		// 2.��ȡ���������˽⣩
		Constructor con = clazz.getConstructor();
		Person p = (Person) con.newInstance();
		// 2.��ȡ���εĹ��������˽⣩
		Constructor con2 = clazz.getConstructor(String.class, String.class);
		Person p2 = (Person) con2.newInstance("tom", "123");

		System.out.println(p2.getPassword());

	}
	@Test
	public void f2() throws Exception {
		// ע������
		//Class.forName("com.mysql.jdbc.Driver");
		DriverManager.deregisterDriver(new Driver());
		// ��ȡ����
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF8", "day06", "day06");

		// ��дsql
		String sql = "select * from category";

		// �������ִ����
		PreparedStatement st = conn.prepareStatement(sql);

		// ���ò���

		// ִ��sql
		ResultSet rs = st.executeQuery();
		// ������
		while (rs.next()) {
			System.out.println(rs.getString("cid") + "::" + rs.getString("cname"));
		}
		// �ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}

	// ����һ������
	/**
	 * @throws Exception
	 */
	@Test
	public void f3() throws Exception {
		// ��ȡ����
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			// ��ȡ����
			conn = DbUtil.getConnection();
			
			// ��дsql
			String sql = "insert into category values(?,?)";

			// �������ִ����
			st = conn.prepareStatement(sql);

			// ���ò���
			st.setString(1, "c009");
			st.setString(2, "����1");
			// ִ��sql
			int i = st.executeUpdate();
			// ������
			if (i==1) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeResource(conn, st, rs);
		}
	}
	
	//����
	@Test
	public void f11() throws Exception  {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DbUtil2.getConnection();
			String sql="update category set cname= ? where cid= ?";
			st=conn.prepareStatement(sql);
			st.setString(1, "ƽ��");
			st.setString(2, "c007");
			int i=st.executeUpdate();
			
			if(i==1) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			DbUtil2.closeResource(conn, st, rs);
		}
		
	}
	
	//ɾ��
	@Test
	public void f12() {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=DbUtil2.getConnection();

			String sql="delete from category where cid= ?";
			st=conn.prepareStatement(sql);
			
			st.setString(1, "c009");
			
			int resultFlag=st.executeUpdate();
			if(resultFlag==1) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
