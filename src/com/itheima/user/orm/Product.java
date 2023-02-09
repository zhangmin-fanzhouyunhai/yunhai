package com.itheima.user.orm;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
public class Product extends AbstractProduct implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String id) {
		super(id);
	}

	/** full constructor */
	public Product(String id, String pname, Double price, String pdesc) {
		super(id, pname, price, pdesc);
	}

}
