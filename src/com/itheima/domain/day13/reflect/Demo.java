package com.itheima.domain.day13.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.day13.Person;
import com.yunhai.db.orm.TableColumnProperty;
import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.ExportDao;

public class Demo {
	@Test
	public void f1() throws Exception {
		// 1.获取class对象
		Class clazz = Class.forName("com.itheima.domain.day13.Person");

		// 2.获取构造器（了解）
		Constructor con = clazz.getConstructor();
		Person p = (Person) con.newInstance();

		// 2.获取带参的构造器（了解
		Constructor con2 = clazz.getConstructor(String.class, String.class);
		Person p2 = (Person) con2.newInstance("tom", "123");
		System.out.println(p2.getPassword());
	}

	@Test
	public void ff1() throws ClassNotFoundException, SQLException {
		String tableName = "MID_ERP_ITEM";
		int recordQuantity = 50000;
		// int recordQuantity = 65534;
		// int recordQuantity = 50000;
		int columnNameOrComment = 1;
		//List<MidErpItem> list = new ArrayList<MidErpItem>();
		Connection conn = null;
		conn = DbUtil.getConnection();
		ExportDao exportDao = new ExportDao();
		List<TableColumnProperty> headList = exportDao.getHeadList(conn, tableName, columnNameOrComment);

		for (int i = 0; i < headList.size(); i++) {
			System.out.println("headList(" + i + ")=" + headList.get(i).getColumnName());
		}
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;

		String sql = "select * from " + tableName;// + " where rownum<1000";
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
		// json对象
		JSONObject jsonObj = new JSONObject();
		// 获取列数
		ResultSetMetaData rsd = result.getMetaData();
		int columnCount = rsd.getColumnCount();
		System.out.println("Ready in loop!");
		int i = 1;
		Runtime run = Runtime.getRuntime();
		Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
		Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
		Double totalMem = new Double(run.totalMemory() / 1024 / 1024);
		int outj = 1;
		// long usedMem = maxMem - freeMem;
		// 遍历ResultSet中的每条数据
		// long usedMem = maxMem - freeMem;
		// 遍历ResultSet中的每条数据

		List objList = new ArrayList<>();
		while (result.next()) {
			run = Runtime.getRuntime();
			maxMem = new Double(run.maxMemory() / 1024 / 1024);
			freeMem = new Double(run.freeMemory() / 1024 / 1024);
			totalMem = new Double(run.totalMemory() / 1024 / 1024);
			// 遍历每一列
			for (int colI = 1; colI <= columnCount; colI++) {
				String columnName = rsd.getColumnLabel(colI);

				String value = result.getString(columnName);

				if (rsd.getColumnType(colI) == 93) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, value);
					}
				} else if (rsd.getColumnType(colI) == 12) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == -9) {
					if (value == null) {
						jsonObj.put(columnName, "");
					} else {
						jsonObj.put(columnName, result.getString(columnName));
					}
				} else if (rsd.getColumnType(colI) == 2) {
					if (value == null) {
						jsonObj.put(columnName, 0);
					} else {
						jsonObj.put(columnName, result.getDouble(columnName));
					}
				}
			}
			String classString = "com.yicheng.excel.orm.MidErpItem";
			Class clazz = Class.forName(classString);
			JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz);
			objList.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(jsonObj, "yyyy-MM-dd HH:mm:ss.s"), clazz));
			System.out.println(objList.size());
			jsonObj = new JSONObject();

		}

	}

	
	@Test void ff2() {

		String classString = "com.yicheng.excel.orm.MidErpItem";

		try {
			System.out.println("1");
			Class clazz = Class.forName(classString);
			clazz.getDeclaredFields();
			System.out.println(clazz);
			Field[] fieldArray = clazz.getDeclaredFields();
			for (int fieldI = 0; fieldI < fieldArray.length; fieldI++) {
				System.out.println(fieldArray[fieldI].getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error!");
		}
	}
	
	
	@Test
	public void f2() throws Exception {
		// 1.获取class对象
		Class clazz = Class.forName("com.itheima.domain.day13.Person");

		// 2.获取构造器（了解）
		Person p = (Person) clazz.newInstance();
	}

	@Test
	public void f3() throws Exception {
		// 1.获取class对象
		Class clazz = Class.forName("com.itheima.domain.day13.Person");
		Person p = (Person) clazz.newInstance();
		// 2.获取私有的方法
		// Mthod m=clazz.getMethod("sleep");//获取公共的方法
		Method m = clazz.getDeclaredMethod("sleep");// 获取任意的方法

		// 2.1若是私有的方法，必须让该方法可以访问
		m.setAccessible(true);

		// 执行方法
		m.invoke(p);
	}

	@Test
	public void f4() throws Exception {
		// 1.获取class对象
		Class clazz = Class.forName("com.itheima.domain.day13.Person");
		Person p = (Person) clazz.newInstance();
		// 2.获取私有的方法
		// Mthod m=clazz.getMethod("sleep");//获取公共的方法
		Method m = clazz.getDeclaredMethod("sleep");// 获取任意的方法
System.out.println("%"+22688 % 60000);
		// 2.1若是私有的方法，必须让该方法可以访问
		m.setAccessible(true);

		// 执行方法
		m.invoke(p);
	}

	@Test
	public void f5() throws Exception {
		// 1.获取class对象
		Class clazz = Class.forName("com.itheima.domain.day13.Person");
		// Person p=(Person) clazz.newInstance();
		// 2.获取私有的方法
		// Mthod m=clazz.getMethod("sleep");//获取公共的方法
		Method m = clazz.getDeclaredMethod("sleep", String.class);// 获取任意的方法

		// 2.1若是私有的方法，必须让该方法可以访问
		m.setAccessible(true);

		// 执行方法
		String result = (String) m.invoke(clazz.newInstance(), "孙悟空");
		System.out.println(result);
	}

}
