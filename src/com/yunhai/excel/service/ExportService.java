package com.yunhai.excel.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.yunhai.db.util.DbUtil;

public class ExportService {
	public static List<Object> getExportTableValue(String tableName) {
		List<Object> list = new ArrayList<Object>();

		Connection conn = null;
		conn = DbUtil.getConnection();

		return list;

	}

	public static void getClassPropertyType(String tableName) {
		System.out.println("I'm Here!");
		try {
			Class clazz = Class.forName("com.yunhai.excel.orm.AbstractMidErpItem");
			Field[] fields = clazz.getDeclaredFields();
			System.out.println("I'm Here!");
			System.out.println("Size=" + fields.length);
			for (Field f : fields) {
				System.out.println("f.getType().getName()" + f.getType().getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
