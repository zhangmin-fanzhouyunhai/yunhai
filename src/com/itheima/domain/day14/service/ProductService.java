package com.itheima.domain.day14.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.day14.Product;
import com.itheima.domain.day14.dao.ProductDao;
import com.yunhai.bean.PageBean;

public class ProductService {

	/**
	 * 查询所有商品
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
	 * 通过productId查找商品
	 * 
	 * @param productId 商品productId
	 * @return 商品
	 * @throws SQLException
	 */
	public Product getProductById(String productId) throws SQLException {

		return new ProductDao().getProductById(productId);
	}

	/**
	 * 添加商品
	 * 
	 * @param p 商品
	 * @throws SQLException
	 */
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().addProduct(p);
	}

	/**
	 * 修改商品
	 * 
	 * @param product 商品信息
	 * @throws SQLException
	 */
	public void updateProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().updateProductById(product);
	}

	/**
	 * 删除由变量productId传递过来的商品ID编号的商品
	 * 
	 * @param productId
	 * @throws SQLException
	 */
	public void deleteProductById(String productId) throws SQLException {
		// TODO Auto-generated method stub
		new ProductDao().deleteProductById(productId);
	}

	/**
	 * 删除被选取的多个商品信息，被选中商品的ID编号由变量productIds传递提供
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
			System.out.println("无记录！");
		}
	}

	public List<Product> findProductByCondition(String name, String keyword, int methodType) throws SQLException {
		// TODO Auto-generated method stub
		List<Product> productList = new ProductDao().findProductByCondition(name, keyword, methodType);
		return productList;
	}

	/**
	 * 分页查询商品
	 * 
	 * @param currentPage 第几页
	 * @param pageSize    每页显示的条数
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Product> showProductsByPage(int currentPage, int pageSize ,int oldPageSize) throws SQLException {
		// TODO Auto-generated method stub
		// 查询当前面数据 limit m,n 即 limit (当前页－1）*每页显示条数，每页显示条数
		ProductDao dao = new ProductDao();
		// 查询总条数
		int totalCount = dao.getProductCount();
		List<Product> list = dao.findproductByPage(currentPage, pageSize);
		return new PageBean<>(list, currentPage, pageSize, totalCount);
	}

	public PageBean<Product> ChangePageSize(int currentPage, int pageSize, int sessionPageSize) throws SQLException {
		// TODO Auto-generated method stub 
		// 查询当前面数据 limit m,n 即 limit (当前页－1）*每页显示条数，每页显示条数
		ProductDao dao = new ProductDao();
		// 查询总条数
		int totalCount = dao.getProductCount(); 
		/**
		 * 对于从20条，至5条，如13条，切换时会出现问题。当currentPage=1，时表示当前页面只能是1
		 */ 
		if(totalCount<currentPage*sessionPageSize) {
			currentPage=(int) Math.ceil(totalCount/pageSize);
		}
		
		List<Product> list = dao.findproductByPage(currentPage, pageSize);
		return new PageBean<>(list, currentPage, pageSize, totalCount); 
	}
 

}
