package com.itheima.domain.day14.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.day14.Product;
import com.yunhai.util.DataSourceUtils;

public class ProductDao {
	/**
	 * 查询所有的商品
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Product> findAll() throws SQLException, ClassNotFoundException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		String productClassString = "com.itheima.domain.day14.Product.class";
		// System.out.println("Class.forName(productClassString).getClass():"+Class.forName(productClassString).getClass());
		List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));

		return productList;
		// return qr.query(sql,new
		// BeanListHandler<>(Class.forName(productClassString).getClass()));
	}

	/**
	 * 
	 * @param p
	 * @return
	 * @throws SQLException
	 */
	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "INSERT INTO PRODUCT"
				+ "(productId,productName,marketPrice,shopPrice,productDate,productDescription)"
				+ "VALUES(?,?,?,?,?,?)";
		qr.update(sql, p.getProductId(), p.getProductName(), p.getMarketPrice(), p.getShopPrice(), p.getProductDate(),
				p.getProductDescription());
	}

	/**
	 * 通过商品productId获取商品信息
	 * 
	 * @param 商品productId
	 * @return 商品
	 * @throws SQLException
	 */
	public Product getProductById(String productId) throws SQLException {
		// TODO Auto-generated method stub

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "select * from product where productId= ? ";
		// System.out.println("productId:"+productId);
		// System.out.println("sqlStr:"+sqlStr);
		return qr.query(sqlStr, new BeanHandler<>(Product.class), productId);
	}

	/**
	 * 
	 * 修改商品
	 * 
	 * @param product 商品信息
	 * @throws SQLException
	 */
	public void updateProductById(Product product) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "update product set productName=?,marketPrice=?,shopPrice=?,productDate=? where productId=?";
		queryRunner.update(sqlStr, product.getProductName(), product.getMarketPrice(), product.getShopPrice(),
				product.getProductDate(), product.getProductId());
	}

	/**
	 * 通过商品ID productId删除商品信息
	 * 
	 * @param productId
	 * @throws SQLException
	 */
	public void deleteProductById(String productId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "delete from product where productId = ?";
		queryRunner.update(sqlStr, productId);

	}

	/**
	 * 基于商品名称 name 与 关键词 keyword 查找
	 * 
	 * @param name
	 * @param keyword
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findProductByCondition(String name, String keyword, int methodType) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "select * from product where 1=1 ";
		// int method=1;
		if (methodType == 1) {

			/**
			 * 1.对于产品名称name与关键词keyword进行是否为空（包括“”与null两种情况）进行判断；
			 * 2.当产品名称name与关键词keyword同时为空时，查询所有的记录； 3.当产品名称name为空时，依据关键词keyword进行模糊查询；
			 * 4.当关键词keyword为空时，依据产品名称name进行模糊查询；
			 * 
			 */
			if ((name == null || name.trim().equals("")) && (keyword == null || keyword.trim().equals(""))) {
				return (List<Product>) queryRunner.query(sqlStr, new BeanListHandler<>(Product.class));
			} else if (keyword == null || keyword.equals("")) {
				sqlStr = sqlStr + " and productName like ?";
				return queryRunner.query(sqlStr, new BeanListHandler<>(Product.class), '%' + name + '%');
			} else if (name == null || name.equals("")) {
				sqlStr = sqlStr + " and productDescription like ?";
				return queryRunner.query(sqlStr, new BeanListHandler<>(Product.class), '%' + keyword + '%');
			} else {
				sqlStr = sqlStr + " and (productName like ? or productDescription like ?)";
				return queryRunner.query(sqlStr, new BeanListHandler<>(Product.class), '%' + name + '%',
						'%' + keyword + '%');
			}
		} else {
			ArrayList<String> params = new ArrayList<>();

			// 判断参数是否为空拼接sql
			if (name != null && name.trim().length() > 0) {
				sqlStr += (" and productName like ?");// productName like "%sss%"
				params.add("%" + name + "%");
			}
			if (keyword != null && keyword.trim().length() > 0) {
				sqlStr += (" and productDescription like ?");// productName like "%sss%"
				params.add("%" + keyword + "%");
			}
			return queryRunner.query(sqlStr, new BeanListHandler<>(Product.class), params.toArray());
		}

	}

	/**
	 * 查询第几页数据
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findproductByPage(int currentPage, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "select * from product limit ? , ? ";
		if(currentPage==0) {
			currentPage=1;
		}
		return queryRunner.query(sqlStr, new BeanListHandler<>(Product.class), (currentPage-1)*pageSize,pageSize);
	}

	/**
	 * 查询总条数
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public int getProductCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sqlStr = "select count(*) quantity from product  ";
		return  ((Long)queryRunner.query(sqlStr, new ScalarHandler())).intValue();
	}

}
