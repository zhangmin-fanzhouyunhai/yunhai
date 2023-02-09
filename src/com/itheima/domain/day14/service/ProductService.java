package com.itheima.domain.day14.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.dao.ProductDao;
import com.yunhai.bean.PageBean;

public class ProductService {

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return list
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Product> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return new ProductDao().findAll();
	}

	/**
	 * ͨ��productId������Ʒ
	 * 
	 * @param productId ��ƷproductId
	 * @return ��Ʒ
	 * @throws SQLException
	 */
	public Product getProductById(String productId) throws SQLException {

		return new ProductDao().getProductById(productId);
	}

	/**
	 * �����Ʒ
	 * 
	 * @param p ��Ʒ
	 * @throws SQLException
	 */
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().addProduct(p);
	}

	/**
	 * �޸���Ʒ
	 * 
	 * @param product ��Ʒ��Ϣ
	 * @throws SQLException
	 */
	public void updateProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().updateProductById(product);
	}

	/**
	 * ɾ���ɱ���productId���ݹ�������ƷID��ŵ���Ʒ
	 * 
	 * @param productId
	 * @throws SQLException
	 */
	public void deleteProductById(String productId) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().deleteProductById(productId);
	}

	/**
	 * ɾ����ѡȡ�Ķ����Ʒ��Ϣ����ѡ����Ʒ��ID����ɱ���productIds�����ṩ
	 * 
	 * @param productIds
	 * @throws SQLException
	 */
	public void deleteCheckedProduct(String[] productIds) throws SQLException {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDao();
		if (productIds.length != 0 || productIds != null) {
			for (int i = 0; i < productIds.length; i++) {
				productDao.deleteProductById(productIds[i]);
			}
		} else {
			System.out.println("�޼�¼��");
		}
	}

	public List<Product> findProductByCondition(String name, String keyword, int methodType) throws SQLException {
		// TODO Auto-generated method stub
		List<Product> productList = new ProductDao().findProductByCondition(name, keyword, methodType);
		return productList;
	}

	/**
	 * ��ҳ��ѯ��Ʒ
	 * 
	 * @param currentPage �ڼ�ҳ
	 * @param pageSize    ÿҳ��ʾ������
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Product> showProductsByPage(int currentPage, int pageSize ,int oldPageSize) throws SQLException {
		// TODO Auto-generated method stub
		// ��ѯ��ǰ������ limit m,n �� limit (��ǰҳ��1��*ÿҳ��ʾ������ÿҳ��ʾ����
		ProductDao dao = new ProductDao();
		// ��ѯ������
		int totalCount = dao.getProductCount();
		List<Product> list = dao.findproductByPage(currentPage, pageSize);
		return new PageBean<>(list, currentPage, pageSize, totalCount);
	}

	public PageBean<Product> ChangePageSize(int currentPage, int pageSize, int sessionPageSize) throws SQLException {
		// TODO Auto-generated method stub 
		// ��ѯ��ǰ������ limit m,n �� limit (��ǰҳ��1��*ÿҳ��ʾ������ÿҳ��ʾ����
		ProductDao dao = new ProductDao();
		// ��ѯ������
		int totalCount = dao.getProductCount(); 
		/**
		 * ���ڴ�20������5������13�����л�ʱ��������⡣��currentPage=1��ʱ��ʾ��ǰҳ��ֻ����1
		 */ 
		if(totalCount<currentPage*sessionPageSize) {
			currentPage=(int) Math.ceil(totalCount/pageSize);
		}
		
		List<Product> list = dao.findproductByPage(currentPage, pageSize);
		return new PageBean<>(list, currentPage, pageSize, totalCount); 
	}
 

}
