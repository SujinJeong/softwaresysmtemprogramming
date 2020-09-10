package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Sale_product implements Serializable {
	
//	private List<Product> saleProductList;
	private int product_id;
	private int sale_id;
	private int quantity;
	
//	public List<Product> getSaleProductList() {
//		return saleProductList;
//	}
//	public void setSaleProductList(List<Product> saleProductList) {
//		this.saleProductList = saleProductList;
//	}
	public Sale_product(int product_id, int sale_id, int quantity) {
		super();
		this.product_id = product_id;
		this.sale_id = sale_id;
		this.quantity = quantity;
	}
	public Sale_product() {
		super();		
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
