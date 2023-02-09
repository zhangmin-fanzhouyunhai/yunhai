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
	 * ��ѯ���е���Ʒ
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
	 * ͨ����ƷproductId��ȡ��Ʒ��Ϣ
	 * 
	 * @param ��ƷproductId
	 * @return ��Ʒ
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
	 * �޸���Ʒ
	 * 
	 * @param product ��Ʒ��Ϣ
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
	 * ͨ����ƷID productIdɾ����Ʒ��Ϣ
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
	 * ������Ʒ���� name �� �ؼ��� keyword ����
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
			 * 1.���ڲ�Ʒ����name��ؼ���keyword�����Ƿ�Ϊ�գ�����������null��������������жϣ�
			 * 2.����Ʒ����name��ؼ���keywordͬʱΪ��ʱ����ѯ���еļ�¼�� 3.����Ʒ����nameΪ��ʱ�����ݹؼ���keyword����ģ����ѯ��
			 * 4.���ؼ���keywordΪ��ʱ�����ݲ�Ʒ����name����ģ����ѯ��
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

			// �жϲ����Ƿ�Ϊ��ƴ��sql
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
	 * ��ѯ�ڼ�ҳ����
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
	 * ��ѯ������
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
