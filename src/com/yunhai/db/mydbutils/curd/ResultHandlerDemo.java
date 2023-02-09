package com.yunhai.db.mydbutils.curd;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.yunhai.demo.Category;
import com.yunhai.util.DataSourceUtils2;

public class ResultHandlerDemo {
	@Test
	public void arrayHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		Object[] query = qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(query));

	}

	@Test
	public void arrayListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		Object object = qr.query(sql, new ArrayListHandler());
		List<Object[]> list = qr.query(sql, new ArrayListHandler());
		System.out.println(object);
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}

	@Test
	public void beanHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		Category categoryBean = qr.query(sql, new BeanHandler<>(Category.class));
		System.out.println(categoryBean);
	}

	@Test
	public void beanListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		List<Category> beanList = qr.query(sql, new BeanListHandler<>(Category.class));
		for (Category bean : beanList) {
			System.out.println(bean);
		}
	}

	@Test
	public void mapHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		Map<String, Object> map = qr.query(sql, new MapHandler());

		System.out.println(map);

	}

	@Test
	public void mapListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select * from category";

		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : mapList) {
			System.out.println(map);
		}
	}

	@Test
	public void scalarHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils2.getDataSource());

		String sql = "select count(*) from category";

		Object obj = qr.query(sql, new ScalarHandler());
		System.out.println(obj);
	}

}
