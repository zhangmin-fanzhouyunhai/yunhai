package com.itheima.domain.day14;

import java.util.Date;

public abstract class ProductAbstract implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9133154494433133357L;
	private String productId;
	private String productName;
	private Double marketPrice;
	private Double shopPrice;
	private String productImage;
	private Date productDate;
	private String productDescription;

	public ProductAbstract() {

	}

	public ProductAbstract(String productId, String productName, Double marketPrice, Double shopPrice,
			String productImage, Date productDate, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.productImage = productImage;
		this.productDate = productDate;
		this.productDescription = productDescription;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
