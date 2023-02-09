package com.itheima.user.orm;

/**
 * AbstractProduct entity provides the base persistence definition of the
 * Product entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProduct implements java.io.Serializable {

	// Fields

	private String id;
	private String pname;
	private Double price;
	private String pdesc;

	// Constructors

	/** default constructor */
	public AbstractProduct() {
	}

	/** minimal constructor */
	public AbstractProduct(String id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractProduct(String id, String pname, Double price, String pdesc) {
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.pdesc = pdesc;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPdesc() {
		return this.pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

}