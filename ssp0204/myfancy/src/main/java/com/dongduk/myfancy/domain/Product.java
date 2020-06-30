package com.dongduk.myfancy.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Product implements Serializable {

	private int product_id;
	private int category_id;
	private int supplier_id;
	private String product_name;
	private int list_price;
	private int order_price;
	private int quantity;
	private boolean in_stock;
	
	public Product(int product_id, int category_id, int supplier_id, String product_name, int list_price,
			int order_price, int quantity, boolean in_stock) {
		super();
		this.product_id = product_id;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
		this.product_name = product_name;
		this.list_price = list_price;
		this.order_price = order_price;
		this.quantity = quantity;
		this.in_stock = in_stock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getList_price() {
		return list_price;
	}
	public void setList_price(int list_price) {
		this.list_price = list_price;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isInStock() {
		if (quantity == 0) {
			in_stock = false;
		} else {
			in_stock = true;
		}
		return in_stock;
	}
		
}
