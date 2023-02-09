package com.itheima.day12.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.user.orm.Product;
import com.yunhai.util.DataSourceUtils2;
import com.yunhai.util.HibernateUtils;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		//创建queryRunner
				QueryRunner qr=new QueryRunner(DataSourceUtils2.getDataSource());

				//编写sql
				String sql="SELECT * FROM PRODUCT";
				//执行sql
				
				List<Product> productList= qr.query(sql,new BeanListHandler<>(Product.class));
				
				for (int i=0;i<productList.size();i++) {
					System.out.println(productList.get(i).getId());
				}
				
		// 先獲取session
		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		//编写sql
		//String sql="SELECT ID,PNAME,PRICE,PDESC FROM PRODUCT";
		// 查询
		// 
		Criteria criteria=session.createCriteria(Product.class);
		// 
		List<Product> list=criteria.list();
		// 查询
		//List<Product> list = (List<Product>) session.createQuery(sql);
		tr.commit(); 
		return productList;
		/*
		//创建queryRunner
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());

		//编写sql
		String sql="SELECT * FROM PRODUCT";
		//执行sql
		
		return qr.query(sql,new BeanListHandler<>(Product.class));
		*/
	}

}
