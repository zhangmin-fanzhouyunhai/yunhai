package com.itheima.day12.domain;

public class Product {
private int id;
private String pname;
private double price;
private String pdesc;




public Product() {
	super();
}
public Product(int id, String pname, double price, String pdesc) {
	super();
	this.id = id;
	this.pname = pname;
	this.price = price;
	this.pdesc = pdesc;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getPdesc() {
	return pdesc;
}
public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}



}
