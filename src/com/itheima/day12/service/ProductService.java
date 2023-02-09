package com.itheima.day12.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.day12.dao.ProductDao;
import com.itheima.user.orm.Product;

public class ProductService {

	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return new ProductDao().findAll();
		 
	}

}
