package com.itheima.domain.day14;

import java.util.Date;

public class Product extends ProductAbstract implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428775225019139331L;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, Double marketPrice, Double shopPrice, String productImage,
			Date productDate, String productDescription) {
		super(productId, productName, marketPrice, shopPrice, productImage, productDate, productDescription);
		// TODO Auto-generated constructor stub
	}
	
	
}
