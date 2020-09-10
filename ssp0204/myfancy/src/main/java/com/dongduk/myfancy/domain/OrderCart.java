package com.dongduk.myfancy.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderCart  implements Serializable {
	
	private String productName;
	private int productId;
	private String supplierName;
	private int supplierId;
	private int orderPrice;
	private int quantity;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public OrderCart() {
		super();
	}
	
	public OrderCart(String productName, int productId, int supplierId, int orderPrice, int quantity) {
		this.productName = productName;
		this.productId = productId;
		//this.supplierName = supplierName;
		this.supplierId = supplierId;
		this.orderPrice = orderPrice;
		this.quantity = quantity;
	}
	
	
	public String toString() {
		return "OrderCart [productName=" + productName + "productId=" + productId + "supplierName="+supplierName+ " supplierId=" + supplierId +", orderPrice=" + orderPrice + ", quantity=" + quantity + "]";
	}
	
}
