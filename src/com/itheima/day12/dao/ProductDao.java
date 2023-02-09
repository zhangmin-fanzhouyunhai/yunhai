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
		//����queryRunner
				QueryRunner qr=new QueryRunner(DataSourceUtils2.getDataSource());

				//��дsql
				String sql="SELECT * FROM PRODUCT";
				//ִ��sql
				
				List<Product> productList= qr.query(sql,new BeanListHandler<>(Product.class));
				
				for (int i=0;i<productList.size();i++) {
					System.out.println(productList.get(i).getId());
				}
				
		// �ȫ@ȡsession
		Session session = HibernateUtils.getSession();
		// ��������
		Transaction tr = session.beginTransaction();
		//��дsql
		//String sql="SELECT ID,PNAME,PRICE,PDESC FROM PRODUCT";
		// ��ѯ
		// 
		Criteria criteria=session.createCriteria(Product.class);
		// 
		List<Product> list=criteria.list();
		// ��ѯ
		//List<Product> list = (List<Product>) session.createQuery(sql);
		tr.commit(); 
		return productList;
		/*
		//����queryRunner
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());

		//��дsql
		String sql="SELECT * FROM PRODUCT";
		//ִ��sql
		
		return qr.query(sql,new BeanListHandler<>(Product.class));
		*/
	}

}
